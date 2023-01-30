package com.axanthic.icaria.common.block;

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
import net.minecraft.world.level.block.state.StateDefinition;
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

	public static final VoxelShape SHAPE_CAKE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
	public static final VoxelShape SHAPE_CANDLE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
	public static final VoxelShape SHAPE = Shapes.or(SHAPE_CAKE, SHAPE_CANDLE);

	public StrawberryCandleCakeBlock(Block pCandleBlock, Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
		BY_CANDLE.put(pCandleBlock, this);
	}

	public boolean candleHit(BlockHitResult pHit) {
		return pHit.getLocation().y - pHit.getBlockPos().getY() > 0.5D;
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

	public void addParticlesAndSound(Level pLevel, Vec3 pVec3, RandomSource pRandom) {
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
			this.getParticleOffsets().forEach((pVec3) -> this.addParticlesAndSound(pLevel, pVec3.add(pPos.getX(), pPos.getY(), pPos.getZ()), pRandom));
		}
	}

	public boolean canBeLit(BlockState pState) {
		return !pState.getValue(LIT);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(LIT);
	}

	public void extinguish(Player pPlayer, BlockState pState, LevelAccessor pLevel, BlockPos pPos) {
		this.setLit(pLevel, pState, pPos, false);
		if (pState.getBlock() instanceof StrawberryCandleCakeBlock) {
			((StrawberryCandleCakeBlock) pState.getBlock()).getParticleOffsets().forEach((pVec3) -> pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + pVec3.x(), pPos.getY() + pVec3.y(), pPos.getZ() + pVec3.z(), 0.0D, 0.1F, 0.0D));
		}

		pLevel.playSound(null, pPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
		pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
		if (!pLevel.isClientSide && pProjectile.isOnFire() && this.canBeLit(pState)) {
			this.setLit(pLevel, pState, pHit.getBlockPos(), true);
		}
	}

	public void setLit(LevelAccessor pLevel, BlockState pState, BlockPos pPos, boolean pLit) {
		pLevel.setBlock(pPos, pState.setValue(LIT, pLit), 11);
	}

	public static BlockState byCandle(Block pCandleBlock) {
		return BY_CANDLE.get(pCandleBlock).defaultBlockState();
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pDirection == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		ItemStack itemStack = pPlayer.getItemInHand(pHand);
		if (!itemStack.is(Items.FLINT_AND_STEEL) && !itemStack.is(Items.FIRE_CHARGE)) {
			if (this.candleHit(pHit) && itemStack.isEmpty() && pState.getValue(LIT)) {
				this.extinguish(pPlayer, pState, pLevel, pPos);
				return InteractionResult.sidedSuccess(pLevel.isClientSide);
			} else {
				InteractionResult interactionResult = StrawberryCakeBlock.eat(pLevel, pPos, IcariaBlocks.STRAWBERRY_CAKE.get().defaultBlockState(), pPlayer);
				if (interactionResult.consumesAction()) {
					dropResources(pState, pLevel, pPos);
				}

				return interactionResult;
			}
		} else {
			if (itemStack.is(Items.FLINT_AND_STEEL)) {
				if (!pState.getValue(LIT)) {
					pLevel.playSound(null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
				} else {
					return InteractionResult.PASS;
				}

				if (!pLevel.isClientSide) {
					if (!pPlayer.isCreative()) {
						itemStack.hurtAndBreak(1, pPlayer, (player) -> player.broadcastBreakEvent(pHand));
					}
				}
			}

			if (itemStack.is(Items.FIRE_CHARGE)) {
				if (!pState.getValue(LIT)) {
					pLevel.playSound(null, pPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
				} else {
					return InteractionResult.PASS;
				}

				if (!pLevel.isClientSide) {
					pLevel.setBlock(pPos, IcariaBlocks.FARMLAND_FERTILIZED.get().defaultBlockState(), 0);
					if (!pPlayer.isCreative()) {
						itemStack.shrink(1);
					}
				}
			}

			pLevel.setBlockAndUpdate(pPos, this.defaultBlockState().setValue(LIT, true));
			return InteractionResult.CONSUME;
		}
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
		return new ItemStack(IcariaBlocks.STRAWBERRY_CAKE.get());
	}

	public Iterable<Vec3> getParticleOffsets() {
		return PARTICLE_OFFSETS;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}
}
