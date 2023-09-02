package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.KilnBlock;
import com.axanthic.icaria.common.handler.KilnItemStackHandler;
import com.axanthic.icaria.common.handler.WrappedHandler;
import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.container.data.KilnContainerData;

import com.google.common.collect.Lists;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnBlockEntity extends BlockEntity {
    public int maxFuel = 0;
    public int fuel = 0;
    public int maxProgress = 0;
    public int progress = 0;
    public int size = 3;

    public ItemStackHandler stackHandler = new KilnItemStackHandler(this.size, this);

    public LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> this.stackHandler);

    public Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

    public SimpleContainer simpleContainer = new SimpleContainer(this.size);

    public Map<Direction, LazyOptional<WrappedHandler>> directionWrappedFuelHandler = Map.of(
        Direction.UP, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> index == 2, (index, stack) -> false)),
        Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.EAST, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> this.stackHandler.isItemValid(1, stack))),
        Direction.WEST, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false))
    );

    public Map<Direction, LazyOptional<WrappedHandler>> directionWrappedInputHandler = Map.of(
        Direction.UP, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.EAST, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.WEST, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> this.stackHandler.isItemValid(0, stack)))
    );

    public KilnBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.KILN.get(), pPos, pState);
    }

    public boolean canInsertCountIntoOutputSlot(SimpleContainer pContainer) {
        return pContainer.getItem(2).getMaxStackSize() > pContainer.getItem(2).getCount();
    }

    public boolean canInsertStackIntoOutputSlot(SimpleContainer pContainer, ItemStack pStack) {
        return pContainer.getItem(2).getItem() == pStack.getItem() || pContainer.getItem(2).isEmpty();
    }

    public boolean hasFuel() {
        return this.fuel > 0;
    }

    public boolean hasRecipe() {
        for (int i = 0; i < this.size; i++) {
            this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
        }

        Optional<FiringRecipe> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.FIRING.get(), this.simpleContainer, this.level);
        }

        int burnTime = 0;
        if (recipe.isPresent()) {
            burnTime = recipe.get().getBurnTime();
        }

        if (this.maxProgress != burnTime) {
            this.maxProgress = burnTime;
        }

        return recipe.isPresent() && this.canInsertCountIntoOutputSlot(this.simpleContainer) && this.canInsertStackIntoOutputSlot(this.simpleContainer, recipe.get().getResultItem(null));
    }

    public int getComparatorInput() {
        return this.itemHandler.map(ItemHandlerHelper::calcRedstoneFromInventory).orElse(0);
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
        pPlayer.awardRecipes(this.getRecipesToAwardAndPopExperience(pPlayer.serverLevel(), pPlayer.position()));
        this.recipesUsed.clear();
    }

    public void craftItem() {
        for (int i = 0; i < this.size; i++) {
            this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
        }

        Optional<FiringRecipe> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.FIRING.get(), this.simpleContainer, this.level);
        }

        if (this.hasRecipe() && recipe.isPresent()) {
            this.stackHandler.extractItem(0, 1, false);
            this.stackHandler.setStackInSlot(2, new ItemStack(recipe.get().getResultItem(null).getItem(), this.stackHandler.getStackInSlot(2).getCount() + 1));
            this.resetProgress();
            this.setRecipeUsed(recipe.get());
        }
    }

    public void createExperience(ServerLevel pLevel, Vec3 pPopVec, int pRecipeIndex, float pExperience) {
        float f = Mth.frac(pRecipeIndex * pExperience);
        int i = Mth.floor(pRecipeIndex * pExperience);
        if (f != 0.0F && Math.random() < f) {
            ++i;
        }

        ExperienceOrb.award(pLevel, pPopVec, i);
    }

    public void drops(Level pLevel) {
        for (int i = 0; i < this.size; i++) {
            this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
        }

        Containers.dropContents(pLevel, this.worldPosition, this.simpleContainer);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.itemHandler.invalidate();
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        if (pTag.contains("Inventory")) {
            this.stackHandler.deserializeNBT(pTag.getCompound("Inventory"));
            this.maxFuel = pTag.getInt("TotalFuelTime");
            this.fuel = pTag.getInt("CurrentFuelTime");
            this.maxProgress = pTag.getInt("TotalProgressTime");
            this.progress = pTag.getInt("CurrentProgressTime");
            var compoundTag = pTag.getCompound("RecipesUsed");
            for (var string : compoundTag.getAllKeys()) {
                this.recipesUsed.put(new ResourceLocation(string), compoundTag.getInt(string));
            }
        }
    }

    public void resetFuel() {
        this.fuel = 0;
        this.maxFuel = 0;
    }

    public void resetProgress() {
        this.progress = 0;
        this.maxProgress = 0;
    }

    @Override
    public void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("Inventory", this.stackHandler.serializeNBT());
        pTag.putInt("TotalFuelTime", this.maxFuel);
        pTag.putInt("CurrentFuelTime", this.fuel);
        pTag.putInt("TotalProgressTime", this.maxProgress);
        pTag.putInt("CurrentProgressTime", this.progress);
        var compoundTag = new CompoundTag();
        this.recipesUsed.forEach((resourceLocation, index) -> compoundTag.putInt(resourceLocation.toString(), index));
        pTag.put("RecipesUsed", compoundTag);
    }

    public void setRecipeUsed(Recipe<?> pRecipe) {
        this.recipesUsed.addTo(pRecipe.getId(), 1);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        this.itemHandler.invalidate();
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, KilnBlockEntity pBlockEntity) {
        var stackHandler = pBlockEntity.stackHandler;
        var fuelSlot = stackHandler.getStackInSlot(1);
        var fuelTime = ForgeHooks.getBurnTime(fuelSlot, IcariaRecipeTypes.FIRING.get());
        if (!pLevel.isClientSide()) {
            if (!pBlockEntity.hasFuel() && pBlockEntity.hasRecipe() && fuelTime > 0) {
                stackHandler.extractItem(1, 1, false);
                pBlockEntity.fuel = fuelTime + 1;
                pBlockEntity.maxFuel = fuelTime;
                pBlockEntity.setChanged();
            }

            if (pBlockEntity.hasFuel()) {
                pBlockEntity.fuel--;
                pBlockEntity.setChanged();
                pLevel.sendBlockUpdated(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, true), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, true), 3);
            } else {
                pBlockEntity.resetFuel();
                pBlockEntity.setChanged();
                pLevel.sendBlockUpdated(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, false), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, false), 3);
            }

            if (pBlockEntity.hasRecipe() && pState.getValue(BlockStateProperties.LIT)) {
                if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
                    pBlockEntity.craftItem();
                    pBlockEntity.setChanged();
                }

                pBlockEntity.progress++;
                pBlockEntity.setChanged();
            } else {
                pBlockEntity.resetProgress();
                pBlockEntity.setChanged();
            }
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        var compoundTag = new CompoundTag();
        compoundTag.put("Inventory", this.stackHandler.serializeNBT());
        compoundTag.putInt("TotalFuelTime", this.maxFuel);
        compoundTag.putInt("CurrentFuelTime", this.fuel);
        compoundTag.putInt("TotalProgressTime", this.maxProgress);
        compoundTag.putInt("CurrentProgressTime", this.progress);
        return compoundTag;
    }

    public ContainerData getData() {
        return new KilnContainerData(this);
    }

    public ItemStack getFuel() {
        return this.stackHandler.getStackInSlot(1);
    }

    public ItemStack getInput() {
        return this.stackHandler.getStackInSlot(0);
    }

    public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pPopVec) {
        List<Recipe<?>> list = Lists.newArrayList();
        for (var entry : this.recipesUsed.object2IntEntrySet()) {
            pLevel.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                if (recipe instanceof FiringRecipe firingRecipe) {
                    this.createExperience(pLevel, pPopVec, entry.getIntValue(), firingRecipe.getExperience());
                }
            });
        }

        return list;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> pCapability, @Nullable Direction pDirection) {
        return this.getCapabilityForPos(pCapability, pDirection, this.getBlockPos());
    }

    public <T> LazyOptional<T> getCapabilityForPos(Capability<T> pCapability, @Nullable Direction pDirection, BlockPos pPos) {
        if (pCapability == ForgeCapabilities.ITEM_HANDLER) {
            if (pDirection == null) {
                return this.itemHandler.cast();
            } else if (this.directionWrappedFuelHandler.containsKey(pDirection) || this.directionWrappedInputHandler.containsKey(pDirection)) {
                var level = this.getLevel();
                var state = this.getBlockState();
                if (level != null) {
                    state = level.getBlockState(KilnBlock.getBlockEntityPosition(this.getBlockState(), pPos));
                }

                var half  = state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
                var facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                if (pDirection == Direction.DOWN) {
                    return this.directionWrappedFuelHandler.get(pDirection).cast();
                }

                if (half == DoubleBlockHalf.LOWER) {
                    if (facing == Direction.NORTH) {
                        return this.directionWrappedFuelHandler.get(pDirection).cast();
                    } else if (facing == Direction.EAST) {
                        return this.directionWrappedFuelHandler.get(pDirection.getCounterClockWise()).cast();
                    } else if (facing == Direction.SOUTH) {
                        return this.directionWrappedFuelHandler.get(pDirection.getOpposite()).cast();
                    } else if (facing == Direction.WEST) {
                        return this.directionWrappedFuelHandler.get(pDirection.getClockWise()).cast();
                    }
                } else if (half == DoubleBlockHalf.UPPER) {
                    if (facing == Direction.NORTH) {
                        return this.directionWrappedInputHandler.get(pDirection.getOpposite()).cast();
                    } else if (facing == Direction.EAST) {
                        return this.directionWrappedInputHandler.get(pDirection.getClockWise()).cast();
                    } else if (facing == Direction.SOUTH) {
                        return this.directionWrappedInputHandler.get(pDirection).cast();
                    } else if (facing == Direction.WEST) {
                        return this.directionWrappedInputHandler.get(pDirection.getCounterClockWise()).cast();
                    }
                }
            }
        }

        return super.getCapability(pCapability, pDirection);
    }
}
