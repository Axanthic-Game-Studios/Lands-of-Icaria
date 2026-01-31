package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.container.data.KettleContainerData;
import com.axanthic.icaria.common.handler.stack.KettleInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.KettleOutputItemStackHandler;
import com.axanthic.icaria.common.properties.Kettle;
import com.axanthic.icaria.common.recipe.EntityConcoctingRecipe;
import com.axanthic.icaria.common.recipe.ExplosionConcoctingRecipe;
import com.axanthic.icaria.common.recipe.ItemConcoctingRecipe;
import com.axanthic.icaria.common.recipe.PotionConcoctingRecipe;
import com.axanthic.icaria.common.recipe.input.TripleRecipeInput;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KettleBlockEntity extends BlockEntity {
	public int color = 0;
	public int progress = 0;
	public int maxProgress = 0;

	public long prevTime;

	public Deque<ItemStack> deque = new ArrayDeque<>(3);

	public ItemStackHandler inputHandler = new KettleInputItemStackHandler(3, this);
	public ItemStackHandler outputHandler = new KettleOutputItemStackHandler(1, this);

	public SimpleContainer simpleContainer = new SimpleContainer(4);

	public KettleBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.KETTLE.get(), pBlockPos, pBlockState);
	}

	public boolean canAddCount(ServerLevel pServerLevel, int pSlot) {
		return this.getStack(pServerLevel).getCount() + this.simpleContainer.getItem(pSlot).getCount() <= 64;
	}

	public boolean canAddItems(ServerLevel pServerLevel, int pSlot) {
		return this.getStack(pServerLevel).getItem() == this.simpleContainer.getItem(pSlot).getItem() && this.simpleContainer.getItem(pSlot).isStackable() || this.simpleContainer.getItem(pSlot).isEmpty();
	}

	public boolean canAddStack(ServerLevel pServerLevel, int pSlot) {
		return this.canAddCount(pServerLevel, pSlot) && this.canAddItems(pServerLevel, pSlot);
	}

	public boolean hasSlot(ServerLevel pServerLevel) {
		return this.canAddStack(pServerLevel, 3);
	}

	public boolean hasRecipe(ServerLevel pServerLevel) {
		return this.getEntityConcoctingRecipe(pServerLevel).isPresent() || this.getExplosionConcoctingRecipe(pServerLevel).isPresent() || this.getItemConcoctingRecipe(pServerLevel).isPresent() || this.getPotionConcoctingRecipe(pServerLevel).isPresent();
	}

	public int getColor(ServerLevel pServerLevel) {
		if (this.getEntityConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getEntityConcoctingRecipe(pServerLevel).get().value().colour();
		} else if (this.getExplosionConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getExplosionConcoctingRecipe(pServerLevel).get().value().colour();
		} else if (this.getItemConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getItemConcoctingRecipe(pServerLevel).get().value().colour();
		} else if (this.getPotionConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getPotionConcoctingRecipe(pServerLevel).get().value().colour();
		} else {
			return 0;
		}
	}

	public int getRedstoneStrength() {
		var i = this.inputHandler.getStackInSlot(0).getCount() * 5;
		var j = this.inputHandler.getStackInSlot(1).getCount() * 5;
		var k = this.inputHandler.getStackInSlot(2).getCount() * 5;
		return i + j + k;
	}

	public int getTime(ServerLevel pServerLevel) {
		if (this.getEntityConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getEntityConcoctingRecipe(pServerLevel).get().value().time();
		} else if (this.getExplosionConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getExplosionConcoctingRecipe(pServerLevel).get().value().time();
		} else if (this.getItemConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getItemConcoctingRecipe(pServerLevel).get().value().time();
		} else if (this.getPotionConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getPotionConcoctingRecipe(pServerLevel).get().value().time();
		} else {
			return 0;
		}
	}

	public void dropItems(BlockPos pBlockPos, ServerLevel pServerLevel) {
		Containers.dropContents(pServerLevel, pBlockPos, this.simpleContainer);
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.inputHandler.deserialize(pValueInput.childOrEmpty("InputHandler"));
		this.outputHandler.deserialize(pValueInput.childOrEmpty("OutputHandler"));
		this.color = pValueInput.getIntOr("Color", 0);
		this.progress = pValueInput.getIntOr("ProgressTick", 0);
		this.maxProgress = pValueInput.getIntOr("MaxProgressTick", 0);
	}

	@Override
	public void onLoad() {
		super.onLoad();
		this.deque.offer(this.inputHandler.getStackInSlot(0));
		this.deque.offer(this.inputHandler.getStackInSlot(1));
		this.deque.offer(this.inputHandler.getStackInSlot(2));
	}

	public void outputRecipe(ServerLevel pServerLevel) {
		var blockEntity = pServerLevel.getBlockEntity(this.getBlockPos().below());
		if (blockEntity == null || (blockEntity.getLevel() != null && blockEntity.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, this.getBlockPos().below(), Direction.UP) == null)) {
			var itemEntity = EntityType.ITEM.create(pServerLevel, EntitySpawnReason.TRIGGERED);
			if (itemEntity != null) {
				itemEntity.setItem(this.outputHandler.getStackInSlot(0));
				if (this.getBlockState().getBlock() instanceof KettleBlock kettleBlock) {
					itemEntity.snapTo(this.getBlockPos().getX() + kettleBlock.getX(this.getBlockState()), this.getBlockPos().getY() + 0.75D, this.getBlockPos().getZ() + kettleBlock.getZ(this.getBlockState()));
					itemEntity.setDeltaMovement(0.0D, 0.25D, 0.0D);
					pServerLevel.addFreshEntity(itemEntity);
					this.outputHandler.setStackInSlot(0, ItemStack.EMPTY);
				}
			}
		}
	}

	public void performRecipe(BlockPos pBlockPos, ServerLevel pServerLevel) {
		if (this.getEntityConcoctingRecipe(pServerLevel).isPresent()) {
			this.getEntityConcoctingRecipe(pServerLevel).get().value().performRecipe(pBlockPos, pServerLevel);
		} else if (this.getExplosionConcoctingRecipe(pServerLevel).isPresent()) {
			this.getExplosionConcoctingRecipe(pServerLevel).get().value().performRecipe(pBlockPos, pServerLevel);
		} else if (this.getItemConcoctingRecipe(pServerLevel).isPresent()) {
			this.getItemConcoctingRecipe(pServerLevel).get().value().performRecipe(pBlockPos, pServerLevel);
		} else if (this.getPotionConcoctingRecipe(pServerLevel).isPresent()) {
			this.getPotionConcoctingRecipe(pServerLevel).get().value().performRecipe(pBlockPos, pServerLevel);
		}
	}

	@Override
	public void preRemoveSideEffects(BlockPos pBlockPos, BlockState pBlockState) {
		if (this.getLevel() instanceof ServerLevel serverLevel) {
			this.dropItems(pBlockPos, serverLevel);
		}
	}

	public void resetProgress() {
		this.progress = 0;
		this.maxProgress = 0;
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		this.inputHandler.serialize(pValueOutput.child("InputHandler"));
		this.outputHandler.serialize(pValueOutput.child("OutputHandler"));
		pValueOutput.putInt("Color", this.color);
		pValueOutput.putInt("ProgressTick", this.progress);
		pValueOutput.putInt("MaxProgressTick", this.maxProgress);
	}

	public void setContainer() {
		this.simpleContainer.setItem(0, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(1));
		this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(2));
		this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));
	}

	public void setStackInSlot(int pSlot) {
		if (this.deque.size() > pSlot) {
			this.inputHandler.setStackInSlot(pSlot, new ItemStack(this.deque.stream().toList().get(pSlot).getItem()));
		}
	}

	public static void tick(KettleBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		pBlockEntity.setContainer();
		pBlockEntity.tickPoll();
		pBlockEntity.tickSlot();
		pBlockEntity.tickProgress(pServerLevel);
		pBlockEntity.tickRecipe(pServerLevel);
		pBlockEntity.update(pBlockPos, pBlockState, pServerLevel);
		pBlockEntity.updateStates(pBlockPos, pBlockState, pServerLevel, pBlockEntity.hasRecipe(pServerLevel) && pBlockEntity.hasSlot(pServerLevel));
	}

	public void tickPoll() {
		if (this.deque.size() > 3) {
			this.deque.poll();
		}
	}

	public void tickProgress(ServerLevel pServerLevel) {
		if (this.progress < this.maxProgress && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.progress++;
		} else if (this.getTime(pServerLevel) > 0 && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.color = this.getColor(pServerLevel);
			this.progress = 1;
			this.maxProgress = this.getTime(pServerLevel);
		} else {
			this.progress = 0;
			this.maxProgress = 0;
		}
	}

	public void tickRecipe(ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.outputHandler.setStackInSlot(0, new ItemStack(this.getStack(pServerLevel).getItem(), this.getStack(pServerLevel).getCount() + this.outputHandler.getStackInSlot(0).getCount()));
			this.performRecipe(this.getBlockPos(), pServerLevel);
			this.outputRecipe(pServerLevel);
			this.updateStates(this.getBlockPos(), this.getBlockState(), pServerLevel);
			this.inputHandler.extractItem(0, 1, false);
			this.inputHandler.extractItem(1, 1, false);
			this.inputHandler.extractItem(2, 1, false);
			this.deque.clear();
		}
	}

	public void tickSlot() {
		this.setStackInSlot(0);
		this.setStackInSlot(1);
		this.setStackInSlot(2);
	}

	public void update(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		pServerLevel.blockEntityChanged(pBlockPos);
		pServerLevel.sendBlockUpdated(pBlockPos, pBlockState, pBlockState, 3);
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos, pBlockState.getBlock());
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos.above(), pBlockState.getBlock());
	}

	public void updateStates(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel, boolean pBrewing) {
		if (pBrewing) {
			pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.BREWING).setValue(BlockStateProperties.LIT, true));
			pServerLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.BREWING).setValue(BlockStateProperties.LIT, true));
		}
	}

	public void updateStates(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.EMPTY).setValue(BlockStateProperties.LIT, false));
		pServerLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(IcariaBlockStateProperties.KETTLE, Kettle.EMPTY).setValue(BlockStateProperties.LIT, false));
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		var compoundTag = this.getUpdateTagOutput(pProvider);
		compoundTag.putInt("Color", this.color);
		compoundTag.putInt("ProgressTick", this.progress);
		compoundTag.putInt("MaxProgressTick", this.maxProgress);
		return compoundTag;
	}

	public CompoundTag getUpdateTagOutput(HolderLookup.Provider pProvider) {
		var tagValueOutput = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, pProvider);
		this.inputHandler.serialize(tagValueOutput.child("InputHandler"));
		this.outputHandler.serialize(tagValueOutput.child("OutputHandler"));
		return tagValueOutput.buildResult();
	}

	public ContainerData getData() {
		return new KettleContainerData(this);
	}

	@Nullable
	public static IItemHandler getCapability(KettleBlockEntity pBlockEntity, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return pBlockEntity.outputHandler;
		}

		return null;
	}

	public ItemStack getInputA() {
		return this.inputHandler.getStackInSlot(0);
	}

	public ItemStack getInputB() {
		return this.inputHandler.getStackInSlot(1);
	}

	public ItemStack getInputC() {
		return this.inputHandler.getStackInSlot(2);
	}

	public ItemStack getStack(ServerLevel pServerLevel) {
		if (this.getEntityConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getEntityConcoctingRecipe(pServerLevel).get().value().result();
		} else if (this.getExplosionConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getExplosionConcoctingRecipe(pServerLevel).get().value().result();
		} else if (this.getItemConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getItemConcoctingRecipe(pServerLevel).get().value().result();
		} else if (this.getPotionConcoctingRecipe(pServerLevel).isPresent()) {
			return this.getPotionConcoctingRecipe(pServerLevel).get().value().result();
		} else {
			return ItemStack.EMPTY;
		}
	}

	public Optional<RecipeHolder<EntityConcoctingRecipe>> getEntityConcoctingRecipe(ServerLevel pServerLevel) {
		return pServerLevel.recipeAccess().getRecipeFor(IcariaRecipeTypes.ENTITY_CONCOCTING.get(), this.getRecipeInput(), pServerLevel);
	}

	public Optional<RecipeHolder<ExplosionConcoctingRecipe>> getExplosionConcoctingRecipe(ServerLevel pServerLevel) {
		return pServerLevel.recipeAccess().getRecipeFor(IcariaRecipeTypes.EXPLOSION_CONCOCTING.get(), this.getRecipeInput(), pServerLevel);
	}

	public Optional<RecipeHolder<ItemConcoctingRecipe>> getItemConcoctingRecipe(ServerLevel pServerLevel) {
		return pServerLevel.recipeAccess().getRecipeFor(IcariaRecipeTypes.ITEM_CONCOCTING.get(), this.getRecipeInput(), pServerLevel);
	}

	public Optional<RecipeHolder<PotionConcoctingRecipe>> getPotionConcoctingRecipe(ServerLevel pServerLevel) {
		return pServerLevel.recipeAccess().getRecipeFor(IcariaRecipeTypes.POTION_CONCOCTING.get(), this.getRecipeInput(), pServerLevel);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public RecipeInput getRecipeInput() {
		return new TripleRecipeInput(this.inputHandler.getStackInSlot(0), this.inputHandler.getStackInSlot(1), this.inputHandler.getStackInSlot(2));
	}
}
