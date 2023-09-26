package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.util.Corner;
import com.axanthic.icaria.common.block.ForgeBlock;
import com.axanthic.icaria.common.container.data.ForgeContainerData;
import com.axanthic.icaria.common.handler.ForgeInputItemStackHandler;
import com.axanthic.icaria.common.handler.ForgeItemStackHandler;
import com.axanthic.icaria.common.handler.WrappedHandler;
import com.axanthic.icaria.common.recipe.ForgingRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

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
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeBlockEntity extends BlockEntity {
    public int maxFuel = 0;
    public int fuel = 0;
    public int maxProgress = 0;
    public int progress = 0;
    public int size = 6;

    public ItemStackHandler stackHandler = new ForgeItemStackHandler(3, this);
    public ItemStackHandler inputStackHandlerA = new ForgeInputItemStackHandler(1, this);
    public ItemStackHandler inputStackHandlerB = new ForgeInputItemStackHandler(1, this);
    public ItemStackHandler inputStackHandlerC = new ForgeInputItemStackHandler(1, this);

    public LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> stackHandler);
    public LazyOptional<IItemHandler> inputItemHandlerA = LazyOptional.of(() -> this.inputStackHandlerA);
    public LazyOptional<IItemHandler> inputItemHandlerB = LazyOptional.of(() -> this.inputStackHandlerB);
    public LazyOptional<IItemHandler> inputItemHandlerC = LazyOptional.of(() -> this.inputStackHandlerC);

    public Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

    public SimpleContainer simpleContainer = new SimpleContainer(this.size);

    public Map<Direction, LazyOptional<WrappedHandler>> directionWrappedFuelHandler = Map.of(
        Direction.UP, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> index == 1 || index == 2, (index, stack) -> false)),
        Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.EAST, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
        Direction.WEST, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> this.stackHandler.isItemValid(0, stack)))
    );

    public Map<Direction, LazyOptional<WrappedHandler>> frontLeftInputHandler = Map.of(
        Direction.UP, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerA, (index) -> false, (index, stack) -> this.inputStackHandlerA.isItemValid(0, stack))),
        Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerA, (index) -> false, (index, stack) -> false)),
        Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerA, (index) -> false, (index, stack) -> false)),
        Direction.EAST, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerA, (index) -> false, (index, stack) -> false)),
        Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerA, (index) -> false, (index, stack) -> false)),
        Direction.WEST, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerA, (index) -> false, (index, stack) -> false))
    );

    public Map<Direction, LazyOptional<WrappedHandler>> backLeftInputHandler = Map.of(
        Direction.UP, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerB, (index) -> false, (index, stack) -> this.inputStackHandlerB.isItemValid(0, stack))),
        Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerB, (index) -> false, (index, stack) -> false)),
        Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerB, (index) -> false, (index, stack) -> false)),
        Direction.EAST, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerB, (index) -> false, (index, stack) -> false)),
        Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerB, (index) -> false, (index, stack) -> false)),
        Direction.WEST, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerB, (index) -> false, (index, stack) -> false))
    );

    public Map<Direction, LazyOptional<WrappedHandler>> backRightInputHandler = Map.of(
        Direction.UP, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerC, (index) -> false, (index, stack) -> this.inputStackHandlerC.isItemValid(0, stack))),
        Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerC, (index) -> false, (index, stack) -> false)),
        Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerC, (index) -> false, (index, stack) -> false)),
        Direction.EAST, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerC, (index) -> false, (index, stack) -> false)),
        Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerC, (index) -> false, (index, stack) -> false)),
        Direction.WEST, LazyOptional.of(() -> new WrappedHandler(this.inputStackHandlerC, (index) -> false, (index, stack) -> false))
    );

    public ForgeBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.FORGE.get(), pPos, pState);
    }

    public boolean canInsertInSlot(SimpleContainer pContainer, ForgingRecipe pRecipe, int pSlot) {
        return (pContainer.getItem(pSlot).getItem() == pRecipe.getResultItem(null).getItem() || pContainer.getItem(pSlot).isEmpty()) && pContainer.getItem(pSlot).getMaxStackSize() >= pContainer.getItem(pSlot).getCount() + pRecipe.getResultItem(null).getCount();
    }

    public boolean hasFuel() {
        return this.fuel > 0;
    }

    public boolean hasRecipe() {
        this.simpleContainer.setItem(0, this.inputStackHandlerA.getStackInSlot(0));
        this.simpleContainer.setItem(1, this.inputStackHandlerB.getStackInSlot(0));
        this.simpleContainer.setItem(2, this.inputStackHandlerC.getStackInSlot(0));
        this.simpleContainer.setItem(3, this.stackHandler.getStackInSlot(0));
        this.simpleContainer.setItem(4, this.stackHandler.getStackInSlot(1));
        this.simpleContainer.setItem(5, this.stackHandler.getStackInSlot(2));

        Optional<ForgingRecipe> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.FORGING.get(), this.simpleContainer, this.level);
        }

        int burnTime = 0;
        if (recipe.isPresent()) {
            burnTime = recipe.get().getBurnTime();
        }

        if (this.maxProgress != burnTime) {
            this.maxProgress = burnTime;
        }

        return (recipe.isPresent() && this.canInsertInSlot(this.simpleContainer, recipe.get(), 4)) || (recipe.isPresent() && this.canInsertInSlot(this.simpleContainer, recipe.get(), 5));
    }

    public int getComparatorInput() {
        int i = (this.stackHandler.getStackInSlot(0).getCount() * 15) / this.stackHandler.getStackInSlot(0).getMaxStackSize();
        int j = (this.stackHandler.getStackInSlot(1).getCount() * 15) / this.stackHandler.getStackInSlot(1).getMaxStackSize();
        int k = (this.stackHandler.getStackInSlot(2).getCount() * 15) / this.stackHandler.getStackInSlot(2).getMaxStackSize();
        int l = (this.inputStackHandlerA.getStackInSlot(0).getCount() * 15) / this.inputStackHandlerA.getStackInSlot(0).getMaxStackSize();
        int m = (this.inputStackHandlerB.getStackInSlot(0).getCount() * 15) / this.inputStackHandlerB.getStackInSlot(0).getMaxStackSize();
        int n = (this.inputStackHandlerC.getStackInSlot(0).getCount() * 15) / this.inputStackHandlerC.getStackInSlot(0).getMaxStackSize();
        return (i + j + k + l + m + n) / this.size;
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
        pPlayer.awardRecipes(this.getRecipesToAwardAndPopExperience(pPlayer.serverLevel(), pPlayer.position()));
        this.recipesUsed.clear();
    }

    public void craftItem() {
        this.simpleContainer.setItem(0, this.inputStackHandlerA.getStackInSlot(0));
        this.simpleContainer.setItem(1, this.inputStackHandlerB.getStackInSlot(0));
        this.simpleContainer.setItem(2, this.inputStackHandlerC.getStackInSlot(0));
        this.simpleContainer.setItem(3, this.stackHandler.getStackInSlot(0));
        this.simpleContainer.setItem(4, this.stackHandler.getStackInSlot(1));
        this.simpleContainer.setItem(5, this.stackHandler.getStackInSlot(2));

        Optional<ForgingRecipe> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.FORGING.get(), this.simpleContainer, this.level);
        }

        if (this.hasRecipe() && recipe.isPresent()) {
            this.inputStackHandlerA.extractItem(0, 1, false);
            this.inputStackHandlerB.extractItem(0, 1, false);
            this.inputStackHandlerC.extractItem(0, 1, false);
            if (this.canInsertInSlot(this.simpleContainer, recipe.get(), 5)) {
                this.stackHandler.setStackInSlot(2, new ItemStack(recipe.get().getResultItem(null).getItem(), recipe.get().getResultItem(null).getCount() + this.stackHandler.getStackInSlot(2).getCount()));
            } else if (this.canInsertInSlot(this.simpleContainer, recipe.get(), 4)) {
                this.stackHandler.setStackInSlot(1, new ItemStack(recipe.get().getResultItem(null).getItem(), recipe.get().getResultItem(null).getCount() + this.stackHandler.getStackInSlot(1).getCount()));
            }

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
        this.simpleContainer.setItem(0, this.inputStackHandlerA.getStackInSlot(0));
        this.simpleContainer.setItem(1, this.inputStackHandlerB.getStackInSlot(0));
        this.simpleContainer.setItem(2, this.inputStackHandlerC.getStackInSlot(0));
        this.simpleContainer.setItem(3, this.stackHandler.getStackInSlot(0));
        this.simpleContainer.setItem(4, this.stackHandler.getStackInSlot(1));
        this.simpleContainer.setItem(5, this.stackHandler.getStackInSlot(2));

        Containers.dropContents(pLevel, this.worldPosition, this.simpleContainer);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.itemHandler.invalidate();
        this.inputItemHandlerA.invalidate();
        this.inputItemHandlerB.invalidate();
        this.inputItemHandlerC.invalidate();
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        if (pTag.contains("Inventory")) {
            this.stackHandler.deserializeNBT(pTag.getCompound("Inventory"));
            this.inputStackHandlerA.deserializeNBT(pTag.getCompound("InputInventoryA"));
            this.inputStackHandlerB.deserializeNBT(pTag.getCompound("InputInventoryB"));
            this.inputStackHandlerC.deserializeNBT(pTag.getCompound("InputInventoryC"));
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
        pTag.put("InputInventoryA", this.inputStackHandlerA.serializeNBT());
        pTag.put("InputInventoryB", this.inputStackHandlerB.serializeNBT());
        pTag.put("InputInventoryC", this.inputStackHandlerC.serializeNBT());
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
        this.inputItemHandlerA.invalidate();
        this.inputItemHandlerB.invalidate();
        this.inputItemHandlerC.invalidate();
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, ForgeBlockEntity pBlockEntity) {
        var stackHandler = pBlockEntity.stackHandler;
        var fuelSlot = stackHandler.getStackInSlot(0);
        var fuelTime = ForgeHooks.getBurnTime(fuelSlot, IcariaRecipeTypes.FORGING.get());
        if (!pLevel.isClientSide()) {
            if (!pBlockEntity.hasFuel() && pBlockEntity.hasRecipe() && fuelTime > 0) {
                stackHandler.extractItem(0, 1, false);
                pBlockEntity.fuel = fuelTime + 1;
                pBlockEntity.maxFuel = fuelTime;
                pBlockEntity.setChanged();
            }

            if (pBlockEntity.hasFuel()) {
                var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                pBlockEntity.fuel--;
                pBlockEntity.setChanged();
                pLevel.sendBlockUpdated(pPos, pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.LIT, true), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos.offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos.offset(facing.getOpposite().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_BACK_LEFT).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos.offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_BACK_RIGHT).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos.above(), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos.above().offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos.above().offset(facing.getOpposite().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_BACK_LEFT).setValue(BlockStateProperties.LIT, true), 3);
                pLevel.setBlock(pPos.above().offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_BACK_RIGHT).setValue(BlockStateProperties.LIT, true), 3);
            } else {
                var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                pBlockEntity.resetFuel();
                pBlockEntity.setChanged();
                pLevel.sendBlockUpdated(pPos, pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.LIT, false), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos.offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos.offset(facing.getOpposite().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_BACK_LEFT).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos.offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_BACK_RIGHT).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos.above(), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos.above().offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos.above().offset(facing.getOpposite().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_BACK_LEFT).setValue(BlockStateProperties.LIT, false), 3);
                pLevel.setBlock(pPos.above().offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_BACK_RIGHT).setValue(BlockStateProperties.LIT, false), 3);
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
        compoundTag.put("InputInventoryA", this.inputStackHandlerA.serializeNBT());
        compoundTag.put("InputInventoryB", this.inputStackHandlerB.serializeNBT());
        compoundTag.put("InputInventoryC", this.inputStackHandlerC.serializeNBT());
        compoundTag.putInt("TotalFuelTime", this.maxFuel);
        compoundTag.putInt("CurrentFuelTime", this.fuel);
        compoundTag.putInt("TotalProgressTime", this.maxProgress);
        compoundTag.putInt("CurrentProgressTime", this.progress);
        return compoundTag;
    }

    public ContainerData getData() {
        return new ForgeContainerData(this);
    }

    public ItemStack getFuel() {
        return this.stackHandler.getStackInSlot(0);
    }

    public ItemStack getOutputA() {
        return this.stackHandler.getStackInSlot(2);
    }

    public ItemStack getOutputB() {
        return this.stackHandler.getStackInSlot(1);
    }

    public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pPopVec) {
        List<Recipe<?>> list = Lists.newArrayList();
        for (var entry : this.recipesUsed.object2IntEntrySet()) {
            pLevel.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                if (recipe instanceof ForgingRecipe forgingRecipe) {
                    this.createExperience(pLevel, pPopVec, entry.getIntValue(), forgingRecipe.getExperience());
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
            } else if (this.directionWrappedFuelHandler.containsKey(pDirection) || this.frontLeftInputHandler.containsKey(pDirection) || this.backLeftInputHandler.containsKey(pDirection) || this.backRightInputHandler.containsKey(pDirection)) {
                var level = this.getLevel();
                var state = this.getBlockState();
                if (level != null) {
                    state = level.getBlockState(ForgeBlock.getBlockEntityPosition(this.getBlockState(), pPos));
                }

                var corner  = state.getValue(IcariaBlockStateProperties.CORNER);
                var facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                if (pDirection == Direction.DOWN) {
                    return this.directionWrappedFuelHandler.get(pDirection).cast();
                }

                if (pDirection == Direction.UP) {
                    if (corner == Corner.TOP_FRONT_LEFT) {
                        return this.frontLeftInputHandler.get(pDirection).cast();
                    } else if (corner == Corner.TOP_BACK_LEFT) {
                        return this.backLeftInputHandler.get(pDirection).cast();
                    } else if (corner == Corner.TOP_BACK_RIGHT) {
                        return this.backRightInputHandler.get(pDirection).cast();
                    }
                }

                if (corner == Corner.BOTTOM_FRONT_LEFT) {
                    if (facing == Direction.NORTH) {
                        return this.directionWrappedFuelHandler.get(pDirection.getOpposite()).cast();
                    } else if (facing == Direction.EAST) {
                        return this.directionWrappedFuelHandler.get(pDirection.getClockWise()).cast();
                    } else if (facing == Direction.SOUTH) {
                        return this.directionWrappedFuelHandler.get(pDirection).cast();
                    } else if (facing == Direction.WEST) {
                        return this.directionWrappedFuelHandler.get(pDirection.getCounterClockWise()).cast();
                    }
                }
            }
        }

        return super.getCapability(pCapability, pDirection);
    }
}
