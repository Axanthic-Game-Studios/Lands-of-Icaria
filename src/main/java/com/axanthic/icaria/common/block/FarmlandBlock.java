package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.shapes.LayerShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.FarmlandWaterManager;
import net.neoforged.neoforge.common.util.TriState;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FarmlandBlock extends Block {
	public FarmlandBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.MOISTURE, 0));
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		var blockState = pLevelReader.getBlockState(pBlockPos.above());
		var block = blockState.getBlock();
		return !blockState.isSolid() || block instanceof FenceGateBlock || block instanceof MovingPistonBlock;
	}

	public boolean isHydrated(BlockPos pBlockPos, LevelReader pLevelReader) {
		for (var blockPos : BlockPos.betweenClosed(pBlockPos.offset(-4, 0, -4), pBlockPos.offset(4, 1, 4))) {
			if (pLevelReader.getBlockState(pBlockPos).canBeHydrated(pLevelReader, pBlockPos, pLevelReader.getFluidState(blockPos), blockPos)) {
				return true;
			}
		}

		return FarmlandWaterManager.hasBlockWaterTicket(pLevelReader, pBlockPos);
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	public boolean shouldMaintainFarmland(BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return pBlockGetter.getBlockState(pBlockPos.above()).is(BlockTags.MAINTAINS_FARMLAND);
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pBlockState) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.MOISTURE);
	}

	@Override
	public void fallOn(Level pLevel, BlockState pBlockState, BlockPos pBlockPos, Entity pEntity, float pFallDistance) {
		super.fallOn(pLevel, pBlockState, pBlockPos, pEntity, pFallDistance);
		if (pLevel instanceof ServerLevel serverLevel) {
			if (CommonHooks.onFarmlandTrample(serverLevel, pBlockPos, IcariaBlocks.MARL.get().defaultBlockState(), pFallDistance, pEntity)) {
				this.turnToMarl(pBlockPos, pBlockState, pLevel);
			}
		}
	}

	@Override
	public void randomTick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		var i = pBlockState.getValue(BlockStateProperties.MOISTURE);
		if (!this.isHydrated(pBlockPos, pServerLevel) && !pServerLevel.isRainingAt(pBlockPos.above())) {
			if (i > 0) {
				pServerLevel.setBlock(pBlockPos, pBlockState.setValue(BlockStateProperties.MOISTURE, i - 1), 2);
			} else if (!this.shouldMaintainFarmland(pServerLevel, pBlockPos)) {
				this.turnToMarl(pBlockPos, pBlockState, pServerLevel);
			}
		} else if (i < 7) {
			pServerLevel.setBlock(pBlockPos, pBlockState.setValue(BlockStateProperties.MOISTURE, 7), 2);
		}
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (!pBlockState.canSurvive(pServerLevel, pBlockPos)) {
			this.turnToMarl(pBlockPos, pBlockState, pServerLevel);
		}
	}

	public void turnToMarl(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		pLevel.setBlockAndUpdate(pBlockPos, Block.pushEntitiesUp(pBlockState, IcariaBlocks.MARL.get().defaultBlockState(), pLevel, pBlockPos));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return this.defaultBlockState().canSurvive(pBlockPlaceContext.getLevel(), pBlockPlaceContext.getClickedPos()) ? this.defaultBlockState() : IcariaBlocks.MARL.get().defaultBlockState();
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		pScheduledTickAccess.scheduleTick(pBlockPos, this, 0);
		return super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.is(IcariaItems.CALCITE_DUST.get()) && pBlockState.getValue(BlockStateProperties.MOISTURE) == 7) {
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.CALCITE_FERTILIZE, SoundSource.BLOCKS);
			pLevel.setBlock(pBlockPos, IcariaBlocks.FERTILIZED_FARMLAND.get().defaultBlockState(), 2);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CALCITE_DUST.get()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	@Override
	public TriState canSustainPlant(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Direction pDirection, BlockState pBlockStatePlant) {
		return pBlockStatePlant.is(BlockTags.MAINTAINS_FARMLAND) ? TriState.TRUE : TriState.DEFAULT;
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return LayerShapes.Y_15;
	}
}
