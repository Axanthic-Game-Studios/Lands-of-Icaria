package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.StoolEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.properties.Carpet;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.shapes.StoolVoxelShapes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StoolBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public StoolBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.CARPET, Carpet.ARACHNE_STRING_CARPET).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.STOOL_TAKEN, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Direction pDirection) {
		return pBlockState.getValue(IcariaBlockStateProperties.STOOL_TAKEN) ? 15 : 0;
	}

	public void bounceUp(Entity pEntity) {
		var vec3 = pEntity.getDeltaMovement();
		if (vec3.y < 0.0D) {
			var d = pEntity instanceof LivingEntity ? 1.0D : 0.8D;
			pEntity.setDeltaMovement(vec3.x, -vec3.y * d, vec3.z);
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CARPET, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.STOOL_TAKEN, BlockStateProperties.WATERLOGGED);
	}

	public void dropCarpet(BlockState pBlockState, BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CARPET) != Carpet.ARACHNE_STRING_CARPET) {
			var itemStack = new ItemStack(IcariaCommonHelper.getItemByCarpet(pBlockState.getValue(IcariaBlockStateProperties.CARPET)));
			Block.popResourceFromFace(pLevel, pBlockPos, pDirection, itemStack);
		}
	}

	@Override
	public void fallOn(Level pLevel, BlockState pBlockState, BlockPos pBlockPos, Entity pEntity, double pFallDistance) {
		pEntity.causeFallDamage(pFallDistance, 0.5F, pLevel.damageSources().fall());
	}

	@Override
	public void updateEntityMovementAfterFallOn(BlockGetter pBlockGetter, Entity pEntity) {
		if (pEntity.isSuppressingBounce()) {
			super.updateEntityMovementAfterFallOn(pBlockGetter, pEntity);
		} else {
			this.bounceUp(pEntity);
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof IcariaCarpetBlock carpetBlock && carpetBlock.getCarpet() != pBlockState.getValue(IcariaBlockStateProperties.CARPET)) {
			this.dropCarpet(pBlockState, pBlockPos, pBlockHitResult.getDirection(), pLevel);
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.CARPET_APPLY, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CARPET, carpetBlock.getCarpet()));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.getItem() == Items.SHEARS && pBlockState.getValue(IcariaBlockStateProperties.CARPET) != Carpet.ARACHNE_STRING_CARPET) {
			this.dropCarpet(pBlockState, pBlockPos, pBlockHitResult.getDirection(), pLevel);
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.CARPET_CLEAR, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CARPET, Carpet.ARACHNE_STRING_CARPET));
			return InteractionResult.SUCCESS;
		} else if (!pBlockState.getValue(IcariaBlockStateProperties.STOOL_TAKEN)) {
			var stool = new StoolEntity(IcariaEntityTypes.STOOL.get(), pLevel);
			stool.snapTo(pBlockPos.getX() + 0.5D, pBlockPos.getY(), pBlockPos.getZ() + 0.5D);
			pLevel.addFreshEntity(stool);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.STOOL_TAKEN, true));
			pPlayer.startRiding(stool);
			return InteractionResult.CONSUME;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return StoolVoxelShapes.STOOL;
	}
}
