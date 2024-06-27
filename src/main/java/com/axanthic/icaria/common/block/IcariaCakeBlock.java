package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaMobEffects;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCakeBlock extends Block {
	public static final VoxelShape[] SHAPES = new VoxelShape[] {
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Shapes.or(Block.box(1.0D, 0.0D, 8.0D, 15.0D, 8.0D, 15.0D), Block.box(8.0D, 0.0D, 1.0D, 15.0D, 8.0D, 8.0D)), Block.box(1.0D, 0.0D, 8.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 8.0D, 8.0D, 8.0D, 15.0D)
	};

	public IcariaCakeBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.CAKE_BITE, 0));
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return pLevel.getBlockState(pPos.below()).isSolid();
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pState) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState pState, PathComputationType pType) {
		return false;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
		return (4 - pState.getValue(IcariaBlockStateProperties.CAKE_BITE)) * 3;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CAKE_BITE);
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pDirection == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pResult) {
		if (!pPlayer.canEat(false)) {
			return InteractionResult.PASS;
		} else {
			int bite = pState.getValue(IcariaBlockStateProperties.CAKE_BITE);
			if (bite < 3) {
				pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.CAKE_BITE, bite + 1), 3);
			} else {
				pLevel.removeBlock(pPos, false);
			}

			if (pState.is(IcariaBlocks.LAUREL_CHERRY_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(IcariaMobEffects.LIFESTEAL, 600));
			} else if (pState.is(IcariaBlocks.STRAWBERRY_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600));
			} else if (pState.is(IcariaBlocks.PHYSALIS_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600));
			} else if (pState.is(IcariaBlocks.VINE_BERRY_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
			} else if (pState.is(IcariaBlocks.VINE_SPROUT_CAKE.get())) {
				pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600));
			}

			if (pState.is(IcariaBlocks.LAUREL_CHERRY_CAKE.get())) {
				if (!pLevel.isClientSide()) {
					for (int i = 0; i < 16; ++i) {
						pPlayer.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT);
						pPlayer.randomTeleport(pPlayer.getX() + (pPlayer.getRandom().nextDouble() - 0.5D) * 16.0D, Mth.clamp(pPlayer.getY() + (pPlayer.getRandom().nextInt(16) - 8), pLevel.getMinBuildHeight(), pLevel.getMaxBuildHeight()), pPlayer.getZ() + (pPlayer.getRandom().nextDouble() - 0.5D) * 16.0D, true);
						if (pPlayer.isPassenger()) {
							pPlayer.stopRiding();
						}
					}
				}
			}

			pPlayer.awardStat(Stats.EAT_CAKE_SLICE);
			pPlayer.getFoodData().eat(2, 0.1F);

			return InteractionResult.SUCCESS;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return IcariaCakeBlock.SHAPES[pState.getValue(IcariaBlockStateProperties.CAKE_BITE)];
	}
}
