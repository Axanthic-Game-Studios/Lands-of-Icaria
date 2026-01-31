package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.FireplaceBlock;
import com.axanthic.icaria.common.container.data.FireplaceContainerData;
import com.axanthic.icaria.common.handler.stack.FireplaceInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.FireplaceOutputItemStackHandler;
import com.axanthic.icaria.common.recipe.GrillingRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

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
import net.minecraft.util.Mth;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType, unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireplaceBlockEntity extends BlockEntity {
	public int progress = 0;
	public int maxProgress = 0;

	public ItemStackHandler inputHandler = new FireplaceInputItemStackHandler(1, this);
	public ItemStackHandler outputHandler = new FireplaceOutputItemStackHandler(1, this);

	public SimpleContainer simpleContainer = new SimpleContainer(2);

	public FireplaceBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.FIREPLACE.get(), pBlockPos, pBlockState);
	}

	public void dropItems(BlockPos pBlockPos, ServerLevel pServerLevel) {
		Containers.dropContents(pServerLevel, pBlockPos, this.simpleContainer);
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.inputHandler.deserialize(pValueInput.childOrEmpty("InputHandler"));
		this.outputHandler.deserialize(pValueInput.childOrEmpty("OutputHandler"));
		this.progress = pValueInput.getIntOr("ProgressTick", 0);
		this.maxProgress = pValueInput.getIntOr("MaxProgressTick", 0);
	}

	public void outputRecipe(ServerLevel pServerLevel) {
		var blockEntity = pServerLevel.getBlockEntity(this.getBlockPos().below());
		if (blockEntity == null || (blockEntity.getLevel() != null && blockEntity.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, this.getBlockPos().below(), Direction.UP) == null)) {
			var itemEntity = EntityType.ITEM.create(pServerLevel, EntitySpawnReason.TRIGGERED);
			if (itemEntity != null) {
				itemEntity.setItem(this.outputHandler.getStackInSlot(0));
				if (this.getBlockState().getBlock() instanceof FireplaceBlock fireplaceBlock) {
					itemEntity.snapTo(this.getBlockPos().getX() + fireplaceBlock.getX(this.getBlockState()), this.getBlockPos().getY() + fireplaceBlock.itemHeight + 0.1D, this.getBlockPos().getZ() + fireplaceBlock.getZ(this.getBlockState()));
					itemEntity.setDeltaMovement(0.0D, 0.25D, 0.0D);
					pServerLevel.addFreshEntity(itemEntity);
					this.outputHandler.setStackInSlot(0, ItemStack.EMPTY);
				}
			}
		}
	}

	@Override
	public void preRemoveSideEffects(BlockPos pBlockPos, BlockState pBlockState) {
		if (this.getLevel() instanceof ServerLevel serverLevel) {
			this.dropItems(pBlockPos, serverLevel);
		}
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		this.inputHandler.serialize(pValueOutput.child("InputHandler"));
		this.outputHandler.serialize(pValueOutput.child("OutputHandler"));
		pValueOutput.putInt("ProgressTick", this.progress);
		pValueOutput.putInt("MaxProgressTick", this.maxProgress);
	}

	public void setContainer() {
		this.simpleContainer.setItem(0, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.outputHandler.getStackInSlot(0));
	}

	public void setStackInSlot(ItemStack pItemStack) {
		this.inputHandler.setStackInSlot(0, pItemStack);
	}

	public static void tick(FireplaceBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		var recipe = pBlockEntity.getRecipe(pServerLevel);
		pBlockEntity.setContainer();
		pBlockEntity.tickProgress(pBlockState, pServerLevel, recipe);
		pBlockEntity.tickRecipe(pBlockState, pServerLevel, recipe);
		pBlockEntity.update(pBlockPos, pBlockState, pServerLevel);
	}

	public void tickProgress(BlockState pBlockState, ServerLevel pServerLevel, Optional<RecipeHolder<GrillingRecipe>> pRecipe) {
		if (this.progress < this.maxProgress && this.outputHandler.getStackInSlot(0).isEmpty() && pRecipe.isPresent() && pBlockState.getValue(BlockStateProperties.LIT)) {
			this.progress++;
			this.maxProgress = pRecipe.get().value().time();
		} else if (pRecipe.isPresent()) {
			this.progress = Mth.clamp(this.progress - 2, 0, pRecipe.get().value().time());
			this.maxProgress = pRecipe.get().value().time();
		} else {
			this.progress = 0;
			this.maxProgress = 0;
		}
	}

	public void tickRecipe(BlockState pBlockState, ServerLevel pServerLevel, Optional<RecipeHolder<GrillingRecipe>> pRecipe) {
		if (this.progress == this.maxProgress && this.outputHandler.getStackInSlot(0).isEmpty() && pRecipe.isPresent() && pBlockState.getValue(BlockStateProperties.LIT)) {
			this.inputHandler.extractItem(0, 1, false);
			this.outputHandler.setStackInSlot(0, new ItemStack(pRecipe.get().value().result().getItem(), pRecipe.get().value().result().getCount()));
			this.outputRecipe(pServerLevel);
		}
	}

	public void update(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		pServerLevel.blockEntityChanged(pBlockPos);
		pServerLevel.sendBlockUpdated(pBlockPos, pBlockState, pBlockState, 3);
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos, pBlockState.getBlock());
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos.above(), pBlockState.getBlock());
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		var compoundTag = this.getUpdateTagOutput(pProvider);
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
		return new FireplaceContainerData(this);
	}

	@Nullable
	public static IItemHandler getCapability(FireplaceBlockEntity pBlockEntity, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return pBlockEntity.outputHandler;
		}

		return null;
	}

	public ItemStack getInput() {
		return this.inputHandler.getStackInSlot(0);
	}

	public ItemStack getOutput() {
		return this.outputHandler.getStackInSlot(0);
	}

	public Optional<RecipeHolder<GrillingRecipe>> getRecipe(ServerLevel pServerLevel) {
		return pServerLevel.recipeAccess().getRecipeFor(IcariaRecipeTypes.GRILLING.get(), this.getRecipeInput(), pServerLevel);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public RecipeInput getRecipeInput() {
		return new SingleRecipeInput(this.inputHandler.getStackInSlot(0));
	}
}
