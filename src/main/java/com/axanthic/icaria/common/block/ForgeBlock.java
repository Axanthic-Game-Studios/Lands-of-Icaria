package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.ForgeBlockEntity;
import com.axanthic.icaria.common.entity.ForgeRedirectorBlockEntity;
import com.axanthic.icaria.common.menu.provider.ForgeMenuProvider;
import com.axanthic.icaria.common.properties.Corner;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.ForgeVoxelShapes;

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

public class ForgeBlock extends BaseEntityBlock {
	public static final MapCodec<ForgeBlock> CODEC = Block.simpleCodec(ForgeBlock::new);

	public ForgeBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.LIT, false));
	}

	@Override
	public boolean canDropFromExplosion(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	public double getFlameX(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> 0.0D;
			case EAST, WEST -> 0.5D;
			default -> 1.0D;
		};
	}

	public double getFlameZ(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH, SOUTH -> 0.5D;
			case EAST -> 0.0D;
			default -> 1.0D;
		};
	}

	public double getLavaX(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> -0.5625D;
			case EAST -> 0.3125D;
			case SOUTH -> 1.5625D;
			default -> 0.6875D;
		};
	}

	public double getLavaZ(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> 0.6875D;
			case EAST -> -0.5625D;
			case SOUTH -> 0.3125D;
			default -> 1.5625D;
		};
	}

	public double getSmokeX(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH, EAST -> 0.0D;
			default -> 1.0D;
		};
	}

	public double getSmokeZ(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case EAST, SOUTH -> 0.0D;
			default -> 1.0D;
		};
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pLevel.getBlockEntity(ForgeBlock.getBlockEntityPosition(pBlockPos, pBlockState)) instanceof ForgeBlockEntity blockEntity ? blockEntity.getRedstoneStrength() : 0;
	}

	@Override
	public int getLightEmission(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return pBlockState.getValue(BlockStateProperties.LIT) ? 13 : 0;
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_LEFT && pBlockState.getValue(BlockStateProperties.LIT)) {
			this.particlesEmber(pBlockPos, pBlockState, pLevel, pRandomSource);
			this.particlesItems(pBlockPos, pBlockState, pLevel, pRandomSource);
			this.particlesSmoke(pBlockPos, pBlockState, pLevel, pRandomSource);
			this.sounds(pBlockPos, pLevel, pRandomSource);
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CORNER, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.LIT);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.removeMultiBlock(ForgeBlock.getBlockEntityPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void particlesEmber(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, RandomSource pRandomSource) {
		if (pRandomSource.nextDouble() < 0.1D) {
			pLevel.addParticle(ParticleTypes.LAVA, this.getLavaX(pBlockState) + pBlockPos.getX(), pBlockPos.getY() + 0.8125D, this.getLavaZ(pBlockState) + pBlockPos.getZ(), 0.0D, 0.0D, 0.0D);
		}
	}

	public void particlesItems(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, RandomSource pRandomSource) {
		if (IcariaConfig.RENDER_FORGE_ITEMS.get()) {
			pLevel.addParticle(ParticleTypes.FLAME, this.getFlameX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 0.25D, this.getFlameZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
			pLevel.addParticle(ParticleTypes.SMALL_FLAME, this.getFlameX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 0.25D, this.getFlameZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 4.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
		}
	}

	public void particlesSmoke(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, RandomSource pRandomSource) {
		pLevel.addParticle(ParticleTypes.LARGE_SMOKE, this.getSmokeX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 2.0D, this.getSmokeZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
		pLevel.addParticle(ParticleTypes.SMOKE, this.getSmokeX(pBlockState) + pBlockPos.getX() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), pBlockPos.getY() + 2.0D, this.getSmokeZ(pBlockState) + pBlockPos.getZ() + pRandomSource.nextDouble() / 8.0D * (pRandomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		pLevel.setBlock(pBlockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.offset(pDirection.getOpposite().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.offset(pDirection.getOpposite().getUnitVec3i()).offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.above(), Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.above().offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.above().offset(pDirection.getOpposite().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.above().offset(pDirection.getOpposite().getUnitVec3i()).offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		pLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT), 3);
		pLevel.setBlock(pBlockPos.offset(direction.getCounterClockWise().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT), 3);
		pLevel.setBlock(pBlockPos.offset(direction.getOpposite().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_BACK_LEFT), 3);
		pLevel.setBlock(pBlockPos.offset(direction.getOpposite().getUnitVec3i()).offset(direction.getCounterClockWise().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_BACK_RIGHT), 3);
		pLevel.setBlock(pBlockPos.above(), pBlockState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT), 3);
		pLevel.setBlock(pBlockPos.above().offset(direction.getCounterClockWise().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT), 3);
		pLevel.setBlock(pBlockPos.above().offset(direction.getOpposite().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_BACK_LEFT), 3);
		pLevel.setBlock(pBlockPos.above().offset(direction.getOpposite().getUnitVec3i()).offset(direction.getCounterClockWise().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_BACK_RIGHT), 3);
	}

	public void sounds(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		if (IcariaConfig.FORGE_SOUNDS.get() && pRandomSource.nextDouble() < 0.1D) {
			pLevel.playLocalSound(pBlockPos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_LEFT) {
			return new ForgeBlockEntity(pBlockPos, pBlockState);
		} else {
			return new ForgeRedirectorBlockEntity(pBlockPos, pBlockState);
		}
	}

	public static BlockPos getBlockEntityPosition(BlockPos pBlockPos, BlockState pBlockState) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_BACK_RIGHT) {
			return pBlockPos.below().offset(direction.getUnitVec3i()).offset(direction.getClockWise().getUnitVec3i());
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_BACK_LEFT) {
			return pBlockPos.below().offset(direction.getUnitVec3i());
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_FRONT_RIGHT) {
			return pBlockPos.below().offset(direction.getClockWise().getUnitVec3i());
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_FRONT_LEFT) {
			return pBlockPos.below();
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_BACK_RIGHT) {
			return pBlockPos.offset(direction.getUnitVec3i()).offset(direction.getClockWise().getUnitVec3i());
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_BACK_LEFT) {
			return pBlockPos.offset(direction.getUnitVec3i());
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_RIGHT) {
			return pBlockPos.offset(direction.getClockWise().getUnitVec3i());
		} else {
			return pBlockPos;
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var direction = pBlockPlaceContext.getHorizontalDirection().getOpposite();
		var level = pBlockPlaceContext.getLevel();
		if (blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos.offset(direction.getCounterClockWise().getUnitVec3i())).canBeReplaced(pBlockPlaceContext) && level.getBlockState(blockPos.offset(direction.getOpposite().getUnitVec3i())).canBeReplaced(pBlockPlaceContext) && level.getBlockState(blockPos.offset(direction.getOpposite().getUnitVec3i()).offset(direction.getCounterClockWise().getUnitVec3i())).canBeReplaced(pBlockPlaceContext) && level.getBlockState(blockPos.above()).canBeReplaced(pBlockPlaceContext) && level.getBlockState(blockPos.above().offset(direction.getCounterClockWise().getUnitVec3i())).canBeReplaced(pBlockPlaceContext) && level.getBlockState(blockPos.above().offset(direction.getOpposite().getUnitVec3i())).canBeReplaced(pBlockPlaceContext) && level.getBlockState(blockPos.above().offset(direction.getOpposite().getUnitVec3i()).offset(direction.getCounterClockWise().getUnitVec3i())).canBeReplaced(pBlockPlaceContext)) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		var blockState = pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
		return pMirror == Mirror.NONE ? blockState : blockState.setValue(IcariaBlockStateProperties.CORNER, blockState.getValue(IcariaBlockStateProperties.CORNER).getOpposite());
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.removeMultiBlock(ForgeBlock.getBlockEntityPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		var blockPos = ForgeBlock.getBlockEntityPosition(pBlockPos, pBlockState);
		if (pLevel instanceof ServerLevel serverLevel && serverLevel.getBlockEntity(blockPos) instanceof ForgeBlockEntity blockEntity) {
			pPlayer.openMenu(new ForgeMenuProvider(blockEntity));
			return InteractionResult.SUCCESS_SERVER;
		} else {
			return InteractionResult.SUCCESS;
		}
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return ForgeBlock.CODEC;
	}

	@Override
	public RenderShape getRenderShape(BlockState pBlockState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.CORNER)) {
			case BOTTOM_FRONT_LEFT -> this.getBottomFrontLeft(pBlockState);
			case BOTTOM_FRONT_RIGHT -> this.getBottomFrontRight(pBlockState);
			case BOTTOM_BACK_LEFT -> this.getBottomBackLeft(pBlockState);
			case BOTTOM_BACK_RIGHT -> this.getBottomBackRight(pBlockState);
			case TOP_FRONT_LEFT -> this.getTopFrontLeft(pBlockState);
			case TOP_FRONT_RIGHT -> this.getTopFrontRight(pBlockState);
			case TOP_BACK_LEFT -> this.getTopBackLeft(pBlockState);
			case TOP_BACK_RIGHT -> this.getTopBackRight(pBlockState);
		};
	}

	public VoxelShape getBottomFrontLeft(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ForgeVoxelShapes.BOTTOM_FRONT_LEFT_NORTH;
			case EAST -> ForgeVoxelShapes.BOTTOM_FRONT_LEFT_EAST;
			case SOUTH -> ForgeVoxelShapes.BOTTOM_FRONT_LEFT_SOUTH;
			default -> ForgeVoxelShapes.BOTTOM_FRONT_LEFT_WEST;
		};
	}

	public VoxelShape getBottomFrontRight(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ForgeVoxelShapes.BOTTOM_FRONT_RIGHT_NORTH;
			case EAST -> ForgeVoxelShapes.BOTTOM_FRONT_RIGHT_EAST;
			case SOUTH -> ForgeVoxelShapes.BOTTOM_FRONT_RIGHT_SOUTH;
			default -> ForgeVoxelShapes.BOTTOM_FRONT_RIGHT_WEST;
		};
	}

	public VoxelShape getBottomBackLeft(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ForgeVoxelShapes.BOTTOM_BACK_LEFT_NORTH;
			case EAST -> ForgeVoxelShapes.BOTTOM_BACK_LEFT_EAST;
			case SOUTH -> ForgeVoxelShapes.BOTTOM_BACK_LEFT_SOUTH;
			default -> ForgeVoxelShapes.BOTTOM_BACK_LEFT_WEST;
		};
	}

	public VoxelShape getBottomBackRight(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ForgeVoxelShapes.BOTTOM_BACK_RIGHT_NORTH;
			case EAST -> ForgeVoxelShapes.BOTTOM_BACK_RIGHT_EAST;
			case SOUTH -> ForgeVoxelShapes.BOTTOM_BACK_RIGHT_SOUTH;
			default -> ForgeVoxelShapes.BOTTOM_BACK_RIGHT_WEST;
		};
	}

	public VoxelShape getTopFrontLeft(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ForgeVoxelShapes.TOP_FRONT_LEFT_NORTH;
			case EAST -> ForgeVoxelShapes.TOP_FRONT_LEFT_EAST;
			case SOUTH -> ForgeVoxelShapes.TOP_FRONT_LEFT_SOUTH;
			default -> ForgeVoxelShapes.TOP_FRONT_LEFT_WEST;
		};
	}

	public VoxelShape getTopFrontRight(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ForgeVoxelShapes.TOP_FRONT_RIGHT_NORTH;
			case EAST -> ForgeVoxelShapes.TOP_FRONT_RIGHT_EAST;
			case SOUTH -> ForgeVoxelShapes.TOP_FRONT_RIGHT_SOUTH;
			default -> ForgeVoxelShapes.TOP_FRONT_RIGHT_WEST;
		};
	}

	public VoxelShape getTopBackLeft(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ForgeVoxelShapes.TOP_BACK_LEFT_NORTH;
			case EAST -> ForgeVoxelShapes.TOP_BACK_LEFT_EAST;
			case SOUTH -> ForgeVoxelShapes.TOP_BACK_LEFT_SOUTH;
			default -> ForgeVoxelShapes.TOP_BACK_LEFT_WEST;
		};
	}

	public VoxelShape getTopBackRight(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ForgeVoxelShapes.TOP_BACK_RIGHT_NORTH;
			case EAST -> ForgeVoxelShapes.TOP_BACK_RIGHT_EAST;
			case SOUTH -> ForgeVoxelShapes.TOP_BACK_RIGHT_SOUTH;
			default -> ForgeVoxelShapes.TOP_BACK_RIGHT_WEST;
		};
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pBlockState, BlockEntityType<T> pBlockEntityType) {
		return pLevel instanceof ServerLevel serverlevel ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.FORGE.get(), (level, blockPos, blockState, blockEntity) -> ForgeBlockEntity.tick(blockEntity, blockPos, blockState, serverlevel)) : null;
	}
}
