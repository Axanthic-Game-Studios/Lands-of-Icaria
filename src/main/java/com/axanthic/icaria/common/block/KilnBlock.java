package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.KilnBlockEntity;
import com.axanthic.icaria.common.enums.HeightPair;
import com.axanthic.icaria.common.menu.provider.KilnMenuProvider;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.KilnVoxelShapes;

import com.mojang.serialization.MapCodec;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnBlock extends BaseEntityBlock {
	public static final MapCodec<KilnBlock> CODEC = Block.simpleCodec(KilnBlock::new);

	public KilnBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.HEIGHT_PAIR, HeightPair.BOTTOM).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.LIT, false));
	}

	@Override
	public boolean canDropFromExplosion(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Direction pDirection) {
		return pLevel.getBlockEntity(KilnBlock.getMultiBlockPos(pBlockPos, pBlockState)) instanceof KilnBlockEntity blockEntity ? blockEntity.getRedstoneStrength() : 0;
	}

	@Override
	public int getLightEmission(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? 13 : 0;
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_PAIR) == HeightPair.BOTTOM && pBlockState.getValue(BlockStateProperties.LIT)) {
			this.particlesBlock(pBlockPos, pLevel, pRandomSource);
			this.particlesItems(pBlockPos, pLevel, pRandomSource);
			this.sounds(pBlockPos, pLevel, pRandomSource);
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.HEIGHT_PAIR, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.LIT);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(KilnBlock.getMultiBlockPos(pBlockPos, pBlockState), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void particlesBlock(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		pLevel.addParticle(ParticleTypes.SMALL_FLAME, pBlockPos.getX() + 0.5D + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 0.25D, pBlockPos.getZ() + 0.5D + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
		pLevel.addParticle(ParticleTypes.SMOKE, pBlockPos.getX() + 0.5D + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 2.0D, pBlockPos.getZ() + 0.5D + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
	}

	public void particlesItems(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		if (pLevel.getBlockEntity(pBlockPos) instanceof KilnBlockEntity blockEntity && !blockEntity.getIntake().isEmpty()) {
			pLevel.addParticle(ParticleTypes.WHITE_SMOKE, pBlockPos.getX() + 0.5D + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + 0.5D + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
		}
	}

	public void removeMultiBlock(BlockPos pBlockPos, Level pLevel) {
		pLevel.setBlockAndUpdate(pBlockPos, Blocks.AIR.defaultBlockState());
		pLevel.setBlockAndUpdate(pBlockPos.above(), Blocks.AIR.defaultBlockState());
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.HEIGHT_PAIR, HeightPair.BOTTOM));
		pLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(IcariaBlockStateProperties.HEIGHT_PAIR, HeightPair.TOP));
	}

	public void sounds(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		if (pRandomSource.nextDouble() < 0.1D) {
			pLevel.playLocalSound(pBlockPos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new KilnBlockEntity(pBlockPos, pBlockState);
	}

	public static BlockPos getMultiBlockPos(BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_PAIR) == HeightPair.BOTTOM) {
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
		if (blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos).canBeReplaced() && level.getBlockState(blockPos.above()).canBeReplaced()) {
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
		this.removeMultiBlock(KilnBlock.getMultiBlockPos(pBlockPos, pBlockState), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		var blockPos = KilnBlock.getMultiBlockPos(pBlockPos, pBlockState);
		if (pLevel instanceof ServerLevel serverLevel && serverLevel.getBlockEntity(blockPos) instanceof KilnBlockEntity blockEntity) {
			pPlayer.openMenu(new KilnMenuProvider(blockEntity));
			return InteractionResult.SUCCESS_SERVER;
		} else {
			return InteractionResult.SUCCESS;
		}
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return KilnBlock.CODEC;
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_PAIR)) {
			case BOTTOM -> this.getBottom(pBlockState);
			case TOP -> this.getTop(pBlockState);
		};
	}

	public VoxelShape getBottom(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> KilnVoxelShapes.BOTTOM_NORTH;
			case EAST -> KilnVoxelShapes.BOTTOM_EAST;
			case SOUTH -> KilnVoxelShapes.BOTTOM_SOUTH;
			default -> KilnVoxelShapes.BOTTOM_WEST;
		};
	}

	public VoxelShape getTop(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> KilnVoxelShapes.TOP_NORTH;
			case EAST -> KilnVoxelShapes.TOP_EAST;
			case SOUTH -> KilnVoxelShapes.TOP_SOUTH;
			default -> KilnVoxelShapes.TOP_WEST;
		};
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pBlockState, BlockEntityType<T> pBlockEntityType) {
		return pLevel instanceof ServerLevel serverLevel ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.KILN.get(), (level, blockPos, blockState, blockEntity) -> KilnBlockEntity.tick(blockEntity, serverLevel)) : null;
	}
}
