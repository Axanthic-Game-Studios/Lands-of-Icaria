package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.FireplaceBlock;
import com.axanthic.icaria.common.handler.FireplaceHandler;
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
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.RangedResourceHandler;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireplaceBlockEntity extends BlockEntity {
	public int progress = 0;
	public int maxProgress = 0;

	public ItemStacksResourceHandler handler = new FireplaceHandler(this);

	public FireplaceBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.FIREPLACE.get(), pBlockPos, pBlockState);
	}

	public boolean canAddCount(ServerLevel pServerLevel, int pSlot) {
		return this.hasRecipe(pServerLevel) && this.getResult(pServerLevel).getCount() + this.handler.getAmountAsInt(pSlot) <= 64;
	}

	public boolean canAddItems(ServerLevel pServerLevel, int pSlot) {
		return this.hasRecipe(pServerLevel) && this.getResult(pServerLevel).getItem() == this.handler.getResource(pSlot).getItem() && this.handler.getResource(pSlot).toStack().isStackable() || this.handler.getResource(pSlot).toStack().isEmpty();
	}

	public boolean canAddStack(ServerLevel pServerLevel, int pSlot) {
		return this.canAddCount(pServerLevel, pSlot) && this.canAddItems(pServerLevel, pSlot);
	}

	public boolean hasRecipe(ServerLevel pServerLevel) {
		return this.getRecipe(pServerLevel).isPresent();
	}

	public boolean hasSlot(ServerLevel pServerLevel) {
		return this.canAddStack(pServerLevel, 1);
	}

	public int getSize() {
		return 2;
	}

	public int getTime(ServerLevel pServerLevel) {
		if (this.getRecipe(pServerLevel).isPresent()) {
			return this.getRecipe(pServerLevel).get().value().time();
		} else {
			return 0;
		}
	}

	public void dropContents(BlockPos pBlockPos, ServerLevel pServerLevel) {
		Containers.dropContents(pServerLevel, pBlockPos, this.handler.copyToList());
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.handler.deserialize(pValueInput.childOrEmpty("Handler"));
		this.progress = pValueInput.getIntOr("Progress", 0);
		this.maxProgress = pValueInput.getIntOr("MaxProgress", 0);
	}

	@Override
	public void preRemoveSideEffects(BlockPos pBlockPos, BlockState pBlockState) {
		if (this.getLevel() instanceof ServerLevel serverLevel) {
			this.dropContents(pBlockPos, serverLevel);
		}
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		this.handler.serialize(pValueOutput.child("Handler"));
		pValueOutput.putInt("Progress", this.progress);
		pValueOutput.putInt("MaxProgress", this.maxProgress);
	}

	public void set(ItemStack pItemStack) {
		this.handler.set(0, ItemResource.of(pItemStack), 1);
	}

	public static void tick(FireplaceBlockEntity pBlockEntity, ServerLevel pServerLevel) {
		pBlockEntity.tickProgress(pServerLevel);
		pBlockEntity.tickResult(pServerLevel);
		pBlockEntity.tickIntake(pServerLevel);
		pBlockEntity.tickUpdate(pServerLevel);
	}

	public void tickProgress(ServerLevel pServerLevel) {
		if (this.progress < this.maxProgress && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel) && this.getBlockState().getValue(BlockStateProperties.LIT)) {
			this.progress++;
		} else if (this.getTime(pServerLevel) > 0 && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.progress = 1;
			this.maxProgress = this.getTime(pServerLevel);
		} else {
			this.progress = 0;
			this.maxProgress = 0;
		}
	}

	public void tickResult(ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel) && this.getBlockState().getValue(BlockStateProperties.LIT)) {
			this.setResult(this.getBlockPos(), this.getBlockState(), pServerLevel);
		}
	}

	public void setResult(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		this.handler.set(1, ItemResource.of(this.getResult(pServerLevel).getItem()), this.getResult(pServerLevel).getCount() + this.handler.getAmountAsInt(1));
		if (pServerLevel.getCapability(Capabilities.Item.BLOCK, pBlockPos.below(), Direction.UP) == null) {
			var itemEntity = EntityType.ITEM.create(pServerLevel, EntitySpawnReason.TRIGGERED);
			if (itemEntity != null) {
				itemEntity.setItem(this.handler.getResource(1).toStack());
				if (pBlockState.getBlock() instanceof FireplaceBlock fireplaceBlock) {
					itemEntity.snapTo(pBlockPos.getX() + fireplaceBlock.getX(pBlockState), pBlockPos.getY() + fireplaceBlock.itemHeight + 0.1D, pBlockPos.getZ() + fireplaceBlock.getZ(pBlockState));
					itemEntity.setDeltaMovement(0.0D, 0.25D, 0.0D);
					pServerLevel.addFreshEntity(itemEntity);
					this.handler.set(1, ItemResource.EMPTY, 0);
				}
			}
		}
	}

	public void tickIntake(ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel) && this.getBlockState().getValue(BlockStateProperties.LIT)) {
			this.setIntake(0);
		}
	}

	public void setIntake(int pIndex) {
		if (this.handler.getAmountAsInt(pIndex) > 0) {
			this.handler.set(pIndex, this.handler.getResource(pIndex), this.handler.getAmountAsInt(pIndex) - 1);
		}
	}

	public void tickUpdate(ServerLevel pServerLevel) {
		if (this.getBlockState().getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
			this.setUpdate(this.getBlockPos(), this.getBlockState(), pServerLevel);
			this.setUpdate(this.getBlockPos().above(), this.getBlockState(), pServerLevel);
		}
	}

	public void setUpdate(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		pServerLevel.blockEntityChanged(pBlockPos);
		pServerLevel.sendBlockUpdated(pBlockPos, pBlockState, pBlockState, 3);
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos, pBlockState.getBlock());
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		var compoundTag = this.getUpdateTagOutput(pProvider);
		compoundTag.putInt("Progress", this.progress);
		compoundTag.putInt("MaxProgress", this.maxProgress);
		return compoundTag;
	}

	public CompoundTag getUpdateTagOutput(HolderLookup.Provider pProvider) {
		var tagValueOutput = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, pProvider);
		this.handler.serialize(tagValueOutput.child("Handler"));
		return tagValueOutput.buildResult();
	}

	@Nullable
	public ResourceHandler<ItemResource> getCap(BlockEntity pBlockEntity, @Nullable Direction pDirection) {
		if (pBlockEntity.getBlockState().getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER && pDirection == Direction.DOWN) {
			return this.getCap(pBlockEntity, pBlockEntity.getBlockPos(), 1, 2);
		} else {
			return null;
		}
	}

	@Nullable
	public ResourceHandler<ItemResource> getCap(BlockEntity pBlockEntity, BlockPos pBlockPos, int p0, int p1) {
		if (pBlockEntity.getLevel() != null && pBlockEntity.getLevel().getBlockEntity(pBlockPos) instanceof FireplaceBlockEntity blockEntity) {
			return RangedResourceHandler.of(blockEntity.handler, p0, p1);
		} else {
			return null;
		}
	}

	public ItemStack getIntake() {
		return this.handler.getResource(0).toStack();
	}

	public ItemStack getResult(ServerLevel pServerLevel) {
		if (this.getRecipe(pServerLevel).isPresent()) {
			return this.getRecipe(pServerLevel).get().value().result();
		} else {
			return ItemStack.EMPTY;
		}
	}

	public Optional<RecipeHolder<GrillingRecipe>> getRecipe(ServerLevel pServerLevel) {
		return pServerLevel.recipeAccess().getRecipeFor(IcariaRecipeTypes.GRILLING.get(), this.getRecipeInput(), pServerLevel);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public RecipeInput getRecipeInput() {
		return new SingleRecipeInput(this.handler.getResource(0).toStack());
	}
}
