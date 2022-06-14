package com.axanthic.icaria.common.blocks;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StrawberryCandleCakeBlock extends Block {
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final Iterable<Vec3> PARTICLE_OFFSETS = ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));
	public static final Map<Block, StrawberryCandleCakeBlock> BY_CANDLE = Maps.newHashMap();
	public static final VoxelShape CAKE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
	public static final VoxelShape CANDLE_SHAPE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
	public static final VoxelShape SHAPE = Shapes.or(CAKE_SHAPE, CANDLE_SHAPE);

	public StrawberryCandleCakeBlock(Block pCandleBlock, Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.FALSE));
		BY_CANDLE.put(pCandleBlock, this);
	}

	public static boolean candleHit(BlockHitResult pHit) {
		return pHit.getLocation().y - (double)pHit.getBlockPos().getY() > 0.5D;
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return pLevel.getBlockState(pPos.below()).getMaterial().isSolid();
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pState) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
		return false;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
		return 14;
	}

	public static void addParticlesAndSound(Level pLevel, Vec3 pVec3, RandomSource pRandom) {
		float f = pRandom.nextFloat();
		if (f < 0.3F) {
			pLevel.addParticle(ParticleTypes.SMOKE, pVec3.x, pVec3.y, pVec3.z, 0.0D, 0.0D, 0.0D);
			if (f < 0.17F) {
				pLevel.playLocalSound(pVec3.x + 0.5D, pVec3.y + 0.5D, pVec3.z + 0.5D, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.3F, false);
			}
		}

		pLevel.addParticle(ParticleTypes.SMALL_FLAME, pVec3.x, pVec3.y, pVec3.z, 0.0D, 0.0D, 0.0D);
	}

	@Override
	public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pState.getValue(LIT)) {
			this.getParticleOffsets().forEach((pVec3) -> addParticlesAndSound(pLevel, pVec3.add(pPos.getX(), pPos.getY(), pPos.getZ()), pRandom));
		}
	}

	public boolean canBeLit(BlockState pState) {
		return !pState.getValue(LIT);
	}

	@Override
	public void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(LIT);
	}

	public static void extinguish(Player pPlayer, BlockState pState, LevelAccessor pLevel, BlockPos pPos) {
		setLit(pLevel, pState, pPos, false);
		if (pState.getBlock() instanceof StrawberryCandleCakeBlock) {
			((StrawberryCandleCakeBlock)pState.getBlock()).getParticleOffsets().forEach((pVec3) -> pLevel.addParticle(ParticleTypes.SMOKE, (double)pPos.getX() + pVec3.x(), (double)pPos.getY() + pVec3.y(), (double)pPos.getZ() + pVec3.z(), 0.0D, 0.1F, 0.0D));
		}

		pLevel.playSound(null, pPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
		pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
	}

	public static void setLit(LevelAccessor pLevel, BlockState pState, BlockPos pPos, boolean pLit) {
		pLevel.setBlock(pPos, pState.setValue(LIT, pLit), 11);
	}

	public Iterable<Vec3> getParticleOffsets() {
		return PARTICLE_OFFSETS;
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
		if (!pLevel.isClientSide && pProjectile.isOnFire() && this.canBeLit(pState)) {
			setLit(pLevel, pState, pHit.getBlockPos(), true);
		}
	}

	public static BlockState byCandle(Block pCandleBlock) {
		return BY_CANDLE.get(pCandleBlock).defaultBlockState();
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		ItemStack stack = pPlayer.getItemInHand(pHand);
		if (!stack.is(Items.FLINT_AND_STEEL) && !stack.is(Items.FIRE_CHARGE)) {
			if (candleHit(pHit) && stack.isEmpty() && pState.getValue(LIT)) {
				extinguish(pPlayer, pState, pLevel, pPos);
				return InteractionResult.sidedSuccess(pLevel.isClientSide);
			} else {
				InteractionResult result = StrawberryCakeBlock.eat(pLevel, pPos, IcariaBlocks.STRAWBERRY_CAKE.get().defaultBlockState(), pPlayer);
				if (result.consumesAction()) {
					dropResources(pState, pLevel, pPos);
				}

				return result;
			}
		} else {
			if (stack.is(Items.FLINT_AND_STEEL)) {
				if (!pState.getValue(LIT)) {
					pLevel.playSound(null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
				} else {
					return InteractionResult.PASS;
				}
				if (!pLevel.isClientSide) {
					if (!pPlayer.isCreative()) {
						stack.hurtAndBreak(1, pPlayer, (playerUsing) -> playerUsing.broadcastBreakEvent(pHand));
					}
				}
			}

			if (stack.is(Items.FIRE_CHARGE)) {
				if (!pState.getValue(LIT)) {
					pLevel.playSound(null, pPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
				} else {
					return InteractionResult.PASS;
				}
				if (!pLevel.isClientSide) {
					pLevel.setBlock(pPos, IcariaBlocks.FARMLAND_FERTILIZED.get().defaultBlockState(), 0);
					if (!pPlayer.isCreative()) {
						stack.shrink(1);
					}
				}
			}

			pLevel.setBlockAndUpdate(pPos, this.defaultBlockState().setValue(LIT, Boolean.TRUE));
			return InteractionResult.CONSUME;
		}
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
		return new ItemStack(IcariaBlocks.STRAWBERRY_CAKE.get());
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}
}
