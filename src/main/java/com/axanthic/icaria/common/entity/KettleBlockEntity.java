package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.container.data.KettleContainerData;
import com.axanthic.icaria.common.handler.stack.KettleInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.KettleOutputItemStackHandler;
import com.axanthic.icaria.common.properties.Kettle;
import com.axanthic.icaria.common.recipe.ConcoctingEntityRecipe;
import com.axanthic.icaria.common.recipe.ConcoctingExplosionsRecipe;
import com.axanthic.icaria.common.recipe.ConcoctingItemRecipe;
import com.axanthic.icaria.common.recipe.ConcoctingPotionRecipe;
import com.axanthic.icaria.common.recipe.input.TripleRecipeInput;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KettleBlockEntity extends BlockEntity {
    public int color = 0;
    public int maxProgress = 0;
    public int progress = 0;

    public Deque<ItemStack> deque = new ArrayDeque<>(3);

    public ItemStackHandler inputHandler = new KettleInputItemStackHandler(3, this);
    public ItemStackHandler outputHandler = new KettleOutputItemStackHandler(1, this);

    public SimpleContainer simpleContainer = new SimpleContainer(4);

    public KettleBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.KETTLE.get(), pPos, pState);
    }

    public int getComparatorInput() {
        int i = (this.inputHandler.getStackInSlot(0).getCount() * 5);
        int j = (this.inputHandler.getStackInSlot(1).getCount() * 5);
        int k = (this.inputHandler.getStackInSlot(2).getCount() * 5);
        return i + j + k;
    }

    public void drops(Level pLevel) {
        this.simpleContainer.setItem(0, this.inputHandler.getStackInSlot(0));
        this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(1));
        this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(2));
        this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));
        Containers.dropContents(pLevel, this.worldPosition, this.simpleContainer);
    }

    public void limitSlots() {
        if (this.deque.size() > 3) {
            this.deque.poll();
        }
    }

    @Override
    public void loadAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
        super.loadAdditional(pTag, pProvider);
        this.inputHandler.deserializeNBT(pProvider, pTag.getCompound("Inventory"));
        this.outputHandler.deserializeNBT(pProvider, pTag.getCompound("OutputInventory"));
        this.color = pTag.getInt("Color");
        this.maxProgress = pTag.getInt("TotalProgressTime");
        this.progress = pTag.getInt("CurrentProgressTime");
    }

    @Override
    public void onLoad() {
        super.onLoad();
        this.deque.offer(this.inputHandler.getStackInSlot(0));
        this.deque.offer(this.inputHandler.getStackInSlot(1));
        this.deque.offer(this.inputHandler.getStackInSlot(2));
    }

    public void resetProgress() {
        this.progress = 0;
        this.maxProgress = 0;
    }

    @Override
    public void saveAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
        super.saveAdditional(pTag, pProvider);
        pTag.put("Inventory", this.inputHandler.serializeNBT(pProvider));
        pTag.put("OutputInventory", this.outputHandler.serializeNBT(pProvider));
        pTag.putInt("Color", this.color);
        pTag.putInt("TotalProgressTime", this.maxProgress);
        pTag.putInt("CurrentProgressTime", this.progress);
    }

    public void setStackInSlot(int pSlot) {
        if (this.outputHandler.getStackInSlot(0).isEmpty()) {
            if (this.deque.size() > pSlot) {
                this.inputHandler.setStackInSlot(pSlot, new ItemStack(this.deque.stream().toList().get(pSlot).getItem()));
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

                    pBlockEntity.inputHandler.setStackInSlot(0, ItemStack.EMPTY);
                    pBlockEntity.inputHandler.setStackInSlot(1, ItemStack.EMPTY);
                    pBlockEntity.inputHandler.setStackInSlot(2, ItemStack.EMPTY);
                    pBlockEntity.outputHandler.setStackInSlot(0, new ItemStack(item, count));

                    pBlockEntity.resetProgress();

                    pLevel.setBlockAndUpdate(pPos, pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.EMPTY).setValue(BlockStateProperties.LIT, false));
                    pLevel.setBlockAndUpdate(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.EMPTY).setValue(BlockStateProperties.LIT, false));

                    var entityBelow = pLevel.getBlockEntity(pPos.below());
                    if (entityBelow == null || (entityBelow.getLevel() != null && entityBelow.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, pPos.below(), Direction.UP) == null)) {
                        var entity = EntityType.ITEM.create(pLevel);
                        if (entity != null) {
                            entity.setItem(pBlockEntity.outputHandler.getStackInSlot(0));
                            if (pState.getBlock() instanceof KettleBlock kettleBlock) {
                                entity.moveTo(pPos.getX() + kettleBlock.getX(pState), pPos.getY() + 0.75D, pPos.getZ() + kettleBlock.getZ(pState));
                                entity.setDeltaMovement(0.0D, 0.25D, 0.0D);
                                pLevel.addFreshEntity(entity);
                                pBlockEntity.outputHandler.setStackInSlot(0, ItemStack.EMPTY);
                            }
                        }
                    }
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
    public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
        var compoundTag = new CompoundTag();
        compoundTag.put("Inventory", this.inputHandler.serializeNBT(pProvider));
        compoundTag.put("OutputInventory", this.outputHandler.serializeNBT(pProvider));
        compoundTag.putInt("Color", this.color);
        compoundTag.putInt("TotalProgressTime", this.maxProgress);
        compoundTag.putInt("CurrentProgressTime", this.progress);
        return compoundTag;
    }

    public ContainerData getData() {
        return new KettleContainerData(this);
    }

    public static @Nullable IItemHandler getCapability(KettleBlockEntity pBlockEntity, Direction pDirection) {
        if (pDirection == Direction.DOWN) {
            return pBlockEntity.outputHandler;
        }

        return null;
    }

    public ItemStack getIngA() {
        return this.inputHandler.getStackInSlot(0);
    }

    public ItemStack getIngB() {
        return this.inputHandler.getStackInSlot(1);
    }

    public ItemStack getIngC() {
        return this.inputHandler.getStackInSlot(2);
    }

    public Optional<RecipeHolder<ConcoctingEntityRecipe>> getEntityRecipe() {
        this.simpleContainer.setItem(0, this.inputHandler.getStackInSlot(0));
        this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(1));
        this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(2));
        this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));

        Optional<RecipeHolder<ConcoctingEntityRecipe>> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.CONCOCTING_ENTITY.get(), this.getRecipeInput(), this.level);
        }

        return recipe;
    }

    public Optional<RecipeHolder<ConcoctingExplosionsRecipe>> getExplosionsRecipe() {
        this.simpleContainer.setItem(0, this.inputHandler.getStackInSlot(0));
        this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(1));
        this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(2));
        this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));

        Optional<RecipeHolder<ConcoctingExplosionsRecipe>> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.CONCOCTING_EXPLOSIONS.get(), this.getRecipeInput(), this.level);
        }

        return recipe;
    }

    public Optional<RecipeHolder<ConcoctingItemRecipe>> getItemRecipe() {
        this.simpleContainer.setItem(0, this.inputHandler.getStackInSlot(0));
        this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(1));
        this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(2));
        this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));

        Optional<RecipeHolder<ConcoctingItemRecipe>> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.CONCOCTING_ITEM.get(), this.getRecipeInput(), this.level);
        }

        return recipe;
    }

    public Optional<RecipeHolder<ConcoctingPotionRecipe>> getPotionRecipe() {
        this.simpleContainer.setItem(0, this.inputHandler.getStackInSlot(0));
        this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(1));
        this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(2));
        this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));

        Optional<RecipeHolder<ConcoctingPotionRecipe>> recipe = Optional.empty();
        if (this.level != null) {
            recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.CONCOCTING_POTION.get(), this.getRecipeInput(), this.level);
        }

        return recipe;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public RecipeInput getRecipeInput() {
        return new TripleRecipeInput(this.inputHandler.getStackInSlot(0), this.inputHandler.getStackInSlot(1), this.inputHandler.getStackInSlot(2));
    }
}
