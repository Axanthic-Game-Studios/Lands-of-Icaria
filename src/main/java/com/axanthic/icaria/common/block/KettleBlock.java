package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.KettleBlockEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.properties.Kettle;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.shapes.KettleVoxelShapes;
import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;

import com.mojang.serialization.MapCodec;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KettleBlock extends BaseEntityBlock {
	public static final MapCodec<KettleBlock> CODEC = Block.simpleCodec(KettleBlock::new);

	public KettleBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.KETTLE, Kettle.EMPTY).setValue(BlockStateProperties.LIT, false));
	}

	@Override
	public boolean canDropFromExplosion(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	public double getX(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH, SOUTH -> 0.5D;
			case EAST -> 0.65625D;
			case WEST -> 0.34375D;
			default -> 1.0D;
		};
	}

	public double getZ(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> 0.34375D;
			case EAST, WEST -> 0.5D;
			case SOUTH -> 0.65625D;
			default -> 1.0D;
		};
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Direction pDirection) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? 15 : 0;
	}

	@Override
	public int getLightEmission(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? 15 : 0;
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER && pBlockState.getValue(IcariaBlockStateProperties.KETTLE) == Kettle.ACTIVE) {
			this.particlesActive(pBlockPos, pBlockState, pLevel, pRandomSource);
			this.soundsActive(pBlockPos, pLevel, pRandomSource);
		} else if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER && pBlockState.getValue(IcariaBlockStateProperties.KETTLE) == Kettle.BREWING) {
			this.particlesActive(pBlockPos, pBlockState, pLevel, pRandomSource);
			this.particlesConcocting(pBlockPos, pBlockState, pLevel, pRandomSource);
			this.soundsActive(pBlockPos, pLevel, pRandomSource);
			this.soundsConcocting(pBlockPos, pLevel, pRandomSource);
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.KETTLE, BlockStateProperties.LIT);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	@Override
	public void entityInside(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Entity pEntity, InsideBlockEffectApplier pInsideBlockEffectApplier) {
		if (pEntity instanceof ItemEntity itemEntity) {
			if (pLevel.getBlockEntity(pBlockPos) instanceof KettleBlockEntity blockEntity) {
				if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
					if (pBlockState.getValue(IcariaBlockStateProperties.KETTLE) != Kettle.EMPTY) {
						var itemStack = itemEntity.getItem();
						if (itemStack.is(IcariaItemTagsProvider.KETTLE_ITEMS)) {
							blockEntity.reset();
							blockEntity.set(itemStack);
							itemStack.shrink(1);
							pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_CONSUME, SoundSource.BLOCKS);
							pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.ACTIVE).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, true));
							pLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.ACTIVE).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, true));
						}
					}
				}
			}
		}
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(KettleBlock.getBlockEntityPosition(pBlockPos, pBlockState), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void particlesActive(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, RandomSource pRandomSource) {
		pLevel.addParticle(IcariaParticleTypes.STEAM.get(), this.getX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 0.875D, this.getZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
		pLevel.addParticle(ParticleTypes.SMALL_FLAME, this.getX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 0.125D, this.getZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
	}

	public void particlesConcocting(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, RandomSource pRandomSource) {
		pLevel.addParticle(IcariaParticleTypes.BUBBLE.get(), this.getX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 0.75D, this.getZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Level pLevel) {
		pLevel.setBlock(pBlockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.above(), Blocks.AIR.defaultBlockState(), 3);
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
		pLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER));
	}

	public void soundsActive(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		if (pRandomSource.nextDouble() < 0.1D) {
			pLevel.playLocalSound(pBlockPos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	public void soundsConcocting(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		if (pRandomSource.nextDouble() > 0.9D) {
			pLevel.playLocalSound(pBlockPos, IcariaSoundEvents.KETTLE_CONCOCT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new KettleBlockEntity(pBlockPos, pBlockState);
	}

	public static BlockPos getBlockEntityPosition(BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
			return pBlockPos;
		} else {
			return pBlockPos.below();
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		if (blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos.above()).canBeReplaced(pBlockPlaceContext)) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.drop(pBlockPos, pBlockState, pLevel);
		this.removeMultiBlock(KettleBlock.getBlockEntityPosition(pBlockPos, pBlockState), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (itemStack.is(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()) && pBlockState.getValue(IcariaBlockStateProperties.KETTLE) == Kettle.EMPTY) {
			return this.water(pBlockPos, pBlockState, pInteractionHand, pLevel, pPlayer);
		} else if (itemStack.is(IcariaItemTagsProvider.KETTLE_ITEMS) && pBlockState.getValue(IcariaBlockStateProperties.KETTLE) != Kettle.EMPTY) {
			return this.items(pBlockPos, pBlockState, pInteractionHand, pLevel, pPlayer);
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult items(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, Level pLevel, Player pPlayer) {
		var blockPos = KettleBlock.getBlockEntityPosition(pBlockPos, pBlockState);
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER && pLevel.getBlockEntity(blockPos) instanceof KettleBlockEntity blockEntity) {
			blockEntity.reset();
			blockEntity.set(itemStack);
			itemStack.consume(1, pPlayer);
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_CONSUME, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.ACTIVE).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, true));
			pLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.ACTIVE).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, true));
			pPlayer.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult water(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, Level pLevel, Player pPlayer) {
		if (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.FILLED).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
			pLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(IcariaBlockStateProperties.KETTLE, Kettle.FILLED).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER));
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return KettleBlock.CODEC;
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
			case LOWER -> this.getLower(pBlockState);
			case UPPER -> this.getUpper(pBlockState);
		};
	}

	public VoxelShape getLower(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> KettleVoxelShapes.LOWER_NORTH;
			case EAST -> KettleVoxelShapes.LOWER_EAST;
			case SOUTH -> KettleVoxelShapes.LOWER_SOUTH;
			default -> KettleVoxelShapes.LOWER_WEST;
		};
	}

	public VoxelShape getUpper(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> KettleVoxelShapes.UPPER_NORTH;
			case EAST -> KettleVoxelShapes.UPPER_EAST;
			case SOUTH -> KettleVoxelShapes.UPPER_SOUTH;
			default -> KettleVoxelShapes.UPPER_WEST;
		};
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pBlockState, BlockEntityType<T> pBlockEntityType) {
		return pLevel instanceof ServerLevel serverLevel ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.KETTLE.get(), (level, blockPos, blockState, blockEntity) -> KettleBlockEntity.tick(blockEntity, serverLevel)) : null;
	}
}
