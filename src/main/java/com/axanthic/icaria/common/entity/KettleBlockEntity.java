package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.container.data.KettleContainerData;
import com.axanthic.icaria.common.handler.KettleItemStackHandler;
import com.axanthic.icaria.common.properties.Kettle;
import com.axanthic.icaria.common.recipe.ConcoctingEntityRecipe;
import com.axanthic.icaria.common.recipe.ConcoctingExplosionsRecipe;
import com.axanthic.icaria.common.recipe.ConcoctingItemRecipe;
import com.axanthic.icaria.common.recipe.ConcoctingPotionRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KettleBlockEntity extends BlockEntity {
    public Deque<ItemStack> deque = new ArrayDeque<>(3);

    public int color = 0;
    public int maxProgress = 0;
    public int progress = 0;
    public int size = 4;

    public ItemStackHandler stackHandler = new KettleItemStackHandler(this.size, this);

    public SimpleContainer simpleContainer = new SimpleContainer(this.size);

    //public Map<Direction, LazyOptional<WrappedHandler>> directionWrappedFuelHandler = Map.of(
    //    Direction.UP, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
    //    Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> index == 3, (index, stack) -> false)),
    //    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
    //    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
    //    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false)),
    //    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(this.stackHandler, (index) -> false, (index, stack) -> false))
    //);

    public KettleBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.KETTLE.get(), pPos, pState);
    }

    public int getComparatorInput() {
        int a = (this.stackHandler.getStackInSlot(0).getCount() * 5);
        int b = (this.stackHandler.getStackInSlot(1).getCount() * 5);
        int c = (this.stackHandler.getStackInSlot(2).getCount() * 5);
        return a + b + c;
    }

    public void limitSlots() {
        if (this.deque.size() > 3) {
            this.deque.poll();
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        if (pTag.contains("Inventory")) {
            this.stackHandler.deserializeNBT(pTag.getCompound("Inventory"));
            this.color = pTag.getInt("Color");
            this.maxProgress = pTag.getInt("TotalProgressTime");
            this.progress = pTag.getInt("CurrentProgressTime");
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        this.deque.offer(this.stackHandler.getStackInSlot(0));
        this.deque.offer(this.stackHandler.getStackInSlot(1));
        this.deque.offer(this.stackHandler.getStackInSlot(2));
    }

    public void resetProgress() {
        this.progress = 0;
        this.maxProgress = 0;
    }

    @Override
    public void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("Inventory", this.stackHandler.serializeNBT());
        pTag.putInt("Color", this.color);
        pTag.putInt("TotalProgressTime", this.maxProgress);
        pTag.putInt("CurrentProgressTime", this.progress);
    }

    public void setStackInSlot(int pSlot) {
        if (this.stackHandler.getStackInSlot(3).isEmpty()) {
            if (this.deque.size() > pSlot) {
                this.stackHandler.setStackInSlot(pSlot, new ItemStack(this.deque.stream().toList().get(pSlot).getItem()));
            }
        }
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, KettleBlockEntity pBlockEntity) {
        if (!pLevel.isClientSide()) {
            pBlockEntity.limitSlots();
            pBlockEntity.setStackInSlot(0);
            pBlockEntity.setStackInSlot(1);
            pBlockEntity.setStackInSlot(2);
            pBlockEntity.update(pPos, pState);

            if (pBlockEntity.getEntityRecipe().isEmpty() && pBlockEntity.getExplosionsRecipe().isEmpty() && pBlockEntity.getItemRecipe().isEmpty() && pBlockEntity.getPotionRecipe().isEmpty()) {
                pBlockEntity.resetProgress();
            } else {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.BREWING).setValue(BlockStateProperties.LIT, true));
                pLevel.setBlockAndUpdate(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.BREWING).setValue(BlockStateProperties.LIT, true));

                int count = 0;
                Item item = null;

                var optionalEntityRecipe = pBlockEntity.getEntityRecipe();
                var optionalExplosionsRecipe = pBlockEntity.getExplosionsRecipe();
                var optionalItemRecipe = pBlockEntity.getItemRecipe();
                var optionalPotionRecipe = pBlockEntity.getPotionRecipe();

                if (optionalEntityRecipe.isPresent()) {
                    var entityRecipe = optionalEntityRecipe.get();
                    count = entityRecipe.value().getResultItem(null).getCount();
                    item = entityRecipe.value().getResultItem(null).getItem();
                    pBlockEntity.color = entityRecipe.value().getColor();
                    pBlockEntity.maxProgress = entityRecipe.value().getBurnTime();
                    if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
                        entityRecipe.value().performRecipe(pLevel, pPos);
                    }
                } else if (optionalExplosionsRecipe.isPresent()) {
                    var explosionsRecipe = optionalExplosionsRecipe.get();
                    count = explosionsRecipe.value().getResultItem(null).getCount();
                    item = explosionsRecipe.value().getResultItem(null).getItem();
                    pBlockEntity.color = explosionsRecipe.value().getColor();
                    pBlockEntity.maxProgress = explosionsRecipe.value().getBurnTime();
                    if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
                        explosionsRecipe.value().performRecipe(pLevel, pPos);
                    }
                } else if  (optionalItemRecipe.isPresent()) {
                    var itemRecipe = optionalItemRecipe.get();
                    count = itemRecipe.value().getResultItem(null).getCount();
                    item = itemRecipe.value().getResultItem(null).getItem();
                    pBlockEntity.color = itemRecipe.value().getColor();
                    pBlockEntity.maxProgress = itemRecipe.value().getBurnTime();
                    if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
                        itemRecipe.value().performRecipe(pLevel, pPos);
                    }
                } else if (optionalPotionRecipe.isPresent()) {
                    var potionRecipe = optionalPotionRecipe.get();
                    count = potionRecipe.value().getResultItem(null).getCount();
                    item = potionRecipe.value().getResultItem(null).getItem();
                    pBlockEntity.color = potionRecipe.value().getColor();
                    pBlockEntity.maxProgress = potionRecipe.value().getBurnTime();
                    if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
                        potionRecipe.value().performRecipe(pLevel, pPos);
                    }
                }

                if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
                    pBlockEntity.deque.clear();

                    pBlockEntity.stackHandler.setStackInSlot(0, ItemStack.EMPTY);
                    pBlockEntity.stackHandler.setStackInSlot(1, ItemStack.EMPTY);
                    pBlockEntity.stackHandler.setStackInSlot(2, ItemStack.EMPTY);
                    pBlockEntity.stackHandler.setStackInSlot(3, new ItemStack(item, count));

                    pBlockEntity.resetProgress();

                    pLevel.setBlockAndUpdate(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.EMPTY).setValue(BlockStateProperties.LIT, false));
                    pLevel.setBlockAndUpdate(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.EMPTY).setValue(BlockStateProperties.LIT, false));

                    //var entityBelow = pLevel.getBlockEntity(pPos.below());
                    //if (entityBelow == null || !entityBelow.getCapability(Capabilities.ITEM_HANDLER).isPresent()) {
                        var entity = EntityType.ITEM.create(pLevel);
                        if (entity != null) {
                            entity.setItem(pBlockEntity.stackHandler.getStackInSlot(3));
                            if (pState.getBlock() instanceof KettleBlock kettleBlock) {
                                entity.moveTo(pPos.getX() + kettleBlock.getX(pState), pPos.getY() + 0.75D, pPos.getZ() + kettleBlock.getZ(pState));
                                entity.setDeltaMovement(0.0D, 0.25D, 0.0D);
                                pLevel.addFreshEntity(entity);
                                pBlockEntity.stackHandler.setStackInSlot(3, ItemStack.EMPTY);
                            }
                        }
                    //}
                } else {
                    pBlockEntity.progress++;
                }
            }
        }
    }

    public void update(BlockPos pPos, BlockState pState) {
        if (this.getLevel() != null) {
            this.getLevel().sendBlockUpdated(pPos, pState, pState, 3);
            this.getLevel().updateNeighbourForOutputSignal(pPos.above(), pState.getBlock());
            this.setChanged();
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        var compoundTag = new CompoundTag();
        compoundTag.put("Inventory", this.stackHandler.serializeNBT());
        compoundTag.putInt("Color", this.color);
        compoundTag.putInt("TotalProgressTime", this.maxProgress);
        compoundTag.putInt("CurrentProgressTime", this.progress);
        return compoundTag;
    }

    public ContainerData getData() {
        return new KettleContainerData(this);
    }

    public ItemStack getIngA() {
        return this.stackHandler.getStackInSlot(0);
    }

    public ItemStack getIngB() {
        return this.stackHandler.getStackInSlot(1);
    }

    public ItemStack getIngC() {
        return this.stackHandler.getStackInSlot(2);
    }

    public Optional<RecipeHolder<ConcoctingEntityRecipe>> getEntityRecipe() {
        for (int i = 0; i < this.size; i++) {
            this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<ConcoctingEntityRecipe>> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.CONCOCTING_ENTITY.get(), this.simpleContainer, this.level);
        }

        return recipe;
    }

    public Optional<RecipeHolder<ConcoctingExplosionsRecipe>> getExplosionsRecipe() {
        for (int i = 0; i < this.size; i++) {
            this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<ConcoctingExplosionsRecipe>> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.CONCOCTING_EXPLOSIONS.get(), this.simpleContainer, this.level);
        }

        return recipe;
    }

    public Optional<RecipeHolder<ConcoctingItemRecipe>> getItemRecipe() {
        for (int i = 0; i < this.size; i++) {
            this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<ConcoctingItemRecipe>> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.CONCOCTING_ITEM.get(), this.simpleContainer, this.level);
        }

        return recipe;
    }

    public Optional<RecipeHolder<ConcoctingPotionRecipe>> getPotionRecipe() {
        for (int i = 0; i < this.size; i++) {
            this.simpleContainer.setItem(i, this.stackHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<ConcoctingPotionRecipe>> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.CONCOCTING_POTION.get(), this.simpleContainer, this.level);
        }

        return recipe;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    //@Override
    //public <T> LazyOptional<T> getCapability(Capability<T> pCapability, @Nullable Direction pDirection) {
    //    if (pCapability == Capabilities.ITEM_HANDLER) {
    //        if (pDirection != null) {
    //            if (pDirection == Direction.DOWN) {
    //                if (this.directionWrappedFuelHandler.containsKey(pDirection)) {
    //                    return this.directionWrappedFuelHandler.get(pDirection).cast();
    //                }
    //            }
    //        }
    //    }
    //
    //    return super.getCapability(pCapability, pDirection);
    //}
}
