package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FarmlandBlock extends FarmBlock {
	public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	public FarmlandBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.MOISTURE, 0));
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, IPlantable pPlantable) {
		return pPlantable.getPlantType(pLevel, pPos.relative(pDirection)) == PlantType.CROP;
	}

	public boolean isNearWater(LevelReader pLevel, BlockPos pPos) {
		for (var blockPos : BlockPos.betweenClosed(pPos.offset(-4, 0, -4), pPos.offset(4, 1, 4))) {
			if (pLevel.getFluidState(blockPos).is(FluidTags.WATER)) {
				return true;
			}
		}

		return FarmlandWaterManager.hasBlockWaterTicket(pLevel, pPos);
	}

	public boolean isUnderCrops(BlockGetter pLevel, BlockPos pPos) {
		var aboveState = pLevel.getBlockState(pPos.above());
		return aboveState.getBlock() instanceof IPlantable && pLevel.getBlockState(pPos).canSustainPlant(pLevel, pPos, Direction.UP, (IPlantable) aboveState.getBlock());
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.MOISTURE);
	}

	@Override
	public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
		super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
		if (!pLevel.isClientSide()) {
			if (ForgeHooks.onFarmlandTrample(pLevel, pPos, IcariaBlocks.MARL.get().defaultBlockState(), pFallDistance, pEntity)) {
				this.turnToMarl(pState, pLevel, pPos);
			}
		}
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		int i = pState.getValue(BlockStateProperties.MOISTURE);
		if (!this.isNearWater(pLevel, pPos) && !pLevel.isRainingAt(pPos.above())) {
			if (i > 0) {
				pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.MOISTURE, i - 1), 2);
			} else if (!this.isUnderCrops(pLevel, pPos)) {
				this.turnToMarl(pState, pLevel, pPos);
			}
		} else if (i < 7) {
			pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.MOISTURE, 7), 2);
		}
	}

	@Override
	public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (!pState.canSurvive(pLevel, pPos)) {
			this.turnToMarl(pState, pLevel, pPos);
		}
	}

	public void turnToMarl(BlockState pState, Level pLevel, BlockPos pPos) {
		pLevel.setBlockAndUpdate(pPos, Block.pushEntitiesUp(pState, IcariaBlocks.MARL.get().defaultBlockState(), pLevel, pPos));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return !this.defaultBlockState().canSurvive(pContext.getLevel(), pContext.getClickedPos()) ? IcariaBlocks.MARL.get().defaultBlockState() : super.getStateForPlacement(pContext);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		var itemStack = pPlayer.getItemInHand(pHand);
		if (itemStack.is(IcariaItems.CALCITE_DUST.get())) {
			if (pState.getValue(BlockStateProperties.MOISTURE) == 7) {
				pLevel.playSound(null, pPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS);
				if (!pLevel.isClientSide()) {
					pLevel.setBlock(pPos, IcariaBlocks.FERTILIZED_FARMLAND.get().defaultBlockState(), 0);
					pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CALCITE_DUST.get()));
					if (!pPlayer.isCreative()) {
						itemStack.shrink(1);
					}
				}
			}

			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return FarmlandBlock.SHAPE;
	}
}
