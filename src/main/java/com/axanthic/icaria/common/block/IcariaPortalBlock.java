package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaParticleTypes;
import com.axanthic.icaria.common.registry.IcariaPoiTypes;
import com.axanthic.icaria.common.shapes.PortalVoxelShapes;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;
import com.axanthic.icaria.data.registry.IcariaDimensions;

import java.util.Comparator;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.BlockUtil;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation, OptionalUsedAsFieldOrParameterType")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPortalBlock extends Block implements Portal {
	public IcariaPortalBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X));
	}

	public boolean canSet(Direction.Axis pAxis, BlockPos pBlockPos, ServerLevel pServerLevel) {
		var ground = new AABB(pBlockPos.below().relative(pAxis.getNegative(), 1).getX(), pBlockPos.below().getY(), pBlockPos.below().relative(pAxis.getNegative(), 1).getZ(), pBlockPos.below().relative(pAxis.getPositive(), 3).getX(), pBlockPos.below().getY(), pBlockPos.below().relative(pAxis.getPositive(), 3).getZ());
		var portal = new AABB(pBlockPos.relative(pAxis.getNegative(), 2).getX(), pBlockPos.getY(), pBlockPos.relative(pAxis.getNegative(), 2).getZ(), pBlockPos.relative(pAxis.getPositive(), 4).getX(), pBlockPos.above(4).getY(), pBlockPos.relative(pAxis.getPositive(), 4).getZ());
		return pServerLevel.getBlockStates(ground).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && pServerLevel.getBlockStates(portal).allMatch(BlockBehaviour.BlockStateBase::canBeReplaced);
	}

	@Override
	public boolean skipRendering(BlockState pBlockState, BlockState pBlockStateFaced, Direction pDirection) {
		return pBlockStateFaced.is(this);
	}

	public double getX(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource, int i) {
		if (pLevel.getBlockState(pBlockPos.east()).is(this) || pLevel.getBlockState(pBlockPos.west()).is(this)) {
			return pBlockPos.getX() + pRandomSource.nextDouble();
		} else {
			return pBlockPos.getX() + 0.5D + i * 0.25D;
		}
	}

	public double getXSpeed(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource, int i) {
		if (pLevel.getBlockState(pBlockPos.east()).is(this) || pLevel.getBlockState(pBlockPos.west()).is(this)) {
			return (pRandomSource.nextDouble() - 0.5D) * 0.5D;
		} else {
			return pRandomSource.nextDouble() * i * 2.0D;
		}
	}

	public double getZ(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource, int i) {
		if (pLevel.getBlockState(pBlockPos.east()).is(this) || pLevel.getBlockState(pBlockPos.west()).is(this)) {
			return pBlockPos.getZ() + 0.5D + i * 0.25D;
		} else {
			return pBlockPos.getZ() + pRandomSource.nextDouble();
		}
	}

	public double getZSpeed(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource, int i) {
		if (pLevel.getBlockState(pBlockPos.east()).is(this) || pLevel.getBlockState(pBlockPos.west()).is(this)) {
			return pRandomSource.nextDouble() * i * 2.0D;
		} else {
			return (pRandomSource.nextDouble() - 0.5D) * 0.5D;
		}
	}

	public int getY(BlockPos pBlockPos, ServerLevel pServerLevel) {
		return Mth.clamp(pServerLevel.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pBlockPos.getX(), pBlockPos.getZ()), pServerLevel.dimension() == IcariaDimensions.ICARIA ? 84 : 64, pServerLevel.getHeight() - 5);
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		this.particles(pBlockPos, pLevel, pRandomSource);
		this.sounds(pBlockPos, pLevel, pRandomSource);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_AXIS);
	}

	@Override
	public void entityInside(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Entity pEntity, InsideBlockEffectApplier pInsideBlockEffectApplier) {
		if (pEntity.canUsePortal(false)) {
			pEntity.setAsInsidePortal(this, pBlockPos);
		}
	}

	public void particles(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		for (var i = 0; i < 4; i++) {
			var j = pRandomSource.nextInt(2) * 2 - 1;
			var x = this.getX(pBlockPos, pLevel, pRandomSource, j);
			var z = this.getZ(pBlockPos, pLevel, pRandomSource, j);
			var xSpeed = this.getXSpeed(pBlockPos, pLevel, pRandomSource, j);
			var zSpeed = this.getZSpeed(pBlockPos, pLevel, pRandomSource, j);
			pLevel.addParticle(IcariaParticleTypes.PORTAL.get(), x, pBlockPos.getY() + pRandomSource.nextDouble(), z, xSpeed, (pRandomSource.nextDouble() - 0.5D) * 0.5D, zSpeed);
		}
	}

	@Override
	public void randomTick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		var blockPos = pBlockPos.below();
		var entityType = IcariaEntityTypes.CIVILIAN_REVENANT.get();
		if (pServerLevel.dimension() != IcariaDimensions.ICARIA) {
			if (pServerLevel.dimensionType().natural()) {
				if (pServerLevel.getBlockState(blockPos).isValidSpawn(pServerLevel, blockPos, entityType)) {
					if (pServerLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
						if (pRandomSource.nextInt(2000) == 0) {
							var entity = entityType.spawn(pServerLevel, pBlockPos, EntitySpawnReason.STRUCTURE);
							if (entity != null) {
								entity.setPortalCooldown();
								var vehicle = entity.getVehicle();
								if (vehicle != null) {
									vehicle.setPortalCooldown();
								}
							}
						}
					}
				}
			}
		}
	}

	public void setBlock(BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ServerLevel pServerLevel, int pMinH, int pMaxH, int pMinW, int pMaxW) {
		for (var i = pMinH; i < pMaxH; ++i) {
			for (var j = pMinW; j < pMaxW; ++j) {
				pServerLevel.setBlock(pBlockPos.offset(pDirection.getStepX() * j, i, pDirection.getStepZ() * j), pBlockState, 3);
			}
		}
	}

	public void sounds(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		if (pRandomSource.nextInt(100) == 0) {
			pLevel.playLocalSound(pBlockPos.getX() + 0.5D, pBlockPos.getY() + 0.5D, pBlockPos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, pRandomSource.nextFloat() * 0.4F + 0.8F, false);
		}
	}

	public BlockPos newPos(Direction.Axis pAxis, BlockPos pBlockPos, ServerLevel pServerLevel) {
		var blockPos = BlockPos.ZERO;
		var maxValue = Double.MAX_VALUE;
		for (var mutableBlockPos : BlockPos.spiralAround(pBlockPos, 64, Direction.NORTH, Direction.EAST)) {
			var y = this.getY(mutableBlockPos, pServerLevel);
			mutableBlockPos.setY(y);
			if (this.canSet(pAxis, mutableBlockPos, pServerLevel)) {
				var distance = pBlockPos.distSqr(mutableBlockPos);
				if (distance < maxValue) {
					blockPos = mutableBlockPos.immutable();
					maxValue = distance;
				}
			}
		}

		return blockPos;
	}

	public BlockState blockState(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_AXIS)) {
			case X -> pBlockState.setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.Z);
			case Z -> pBlockState.setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X);
			default -> pBlockState;
		};
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return switch (pRotation) {
			case CLOCKWISE_90, COUNTERCLOCKWISE_90 -> this.blockState(pBlockState);
			default -> pBlockState;
		};
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		var axis = pDirection.getAxis();
		var flag = axis.isHorizontal() && axis != pBlockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
		return flag || pBlockStateFaced.is(this) || pBlockStateFaced.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR) || pBlockStateFaced.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR_HEAD) || pBlockStateFaced.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_SLAB) ? pBlockState : Blocks.AIR.defaultBlockState();
	}

	public BlockUtil.FoundRectangle rectangle(Direction.Axis pAxis, BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		return BlockUtil.getLargestRectangleAround(pBlockPos, pAxis, 21, Direction.Axis.Y, 21, blockPos -> pServerLevel.getBlockState(blockPos) == pBlockState);
	}

	public BlockUtil.FoundRectangle portalRectangle(Optional<BlockPos> pOptional, BlockPos pEntrance, BlockPos pExit, Entity pEntity, ServerLevel pServerLevel) {
		if (pOptional.isPresent()) {
			var blockPos = pOptional.get();
			var blockState = pServerLevel.getBlockState(blockPos);
			return this.rectangle(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), blockPos, blockState, pServerLevel);
		} else {
			var axis = pEntity.level().getBlockState(pEntrance).getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
			var newPortal = this.createPortal(axis, pExit, pServerLevel);
			return newPortal.orElseThrow();
		}
	}

	public Optional<BlockPos> oldPos(BlockPos pBlockPos, ServerLevel pServerLevel, WorldBorder pWorldBorder) {
		var i = 128;
		var poiManager = pServerLevel.getPoiManager();
		poiManager.ensureLoadedAndValid(pServerLevel, pBlockPos, i);
		return poiManager.getInSquare(holder -> holder.is(IcariaPoiTypes.ICARIA_PORTAL), pBlockPos, i, PoiManager.Occupancy.ANY).map(PoiRecord::getPos).filter(pWorldBorder::isWithinBounds).filter(blockPos -> pServerLevel.getBlockState(blockPos).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).min(Comparator.<BlockPos>comparingDouble(blockPos -> blockPos.distSqr(pBlockPos)).thenComparingInt(Vec3i::getY));
	}

	public Optional<BlockUtil.FoundRectangle> createPortal(Direction.Axis pAxis, BlockPos pBlockPos, ServerLevel pServerLevel) {
		var blockPos = this.newPos(pAxis, pBlockPos, pServerLevel);

		var foundRectangle = new BlockUtil.FoundRectangle(blockPos, 3, 4);

		this.setBlock(blockPos, IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y), pAxis.getPositive(), pServerLevel, 0, 3, -1, 0);
		this.setBlock(blockPos, IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y), pAxis.getPositive(), pServerLevel, 0, 3, 3, 4);
		this.setBlock(blockPos, IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN), pAxis.getPositive(), pServerLevel, 3, 4, -1, 0);
		this.setBlock(blockPos, IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN), pAxis.getPositive(), pServerLevel, 3, 4, 3, 4);
		this.setBlock(blockPos, IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get().defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM), pAxis.getPositive(), pServerLevel, 4, 5, -1, 1);
		this.setBlock(blockPos, IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get().defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM), pAxis.getPositive(), pServerLevel, 4, 5, 2, 4);
		this.setBlock(blockPos, IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get().defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.TOP), pAxis.getPositive(), pServerLevel, 3, 4, -2, -1);
		this.setBlock(blockPos, IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get().defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.TOP), pAxis.getPositive(), pServerLevel, 3, 4, 4, 5);
		this.setBlock(blockPos, IcariaBlocks.ICARIA_PORTAL.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, pAxis), pAxis.getPositive(), pServerLevel, 0, 4, 0, 3);

		return Optional.of(foundRectangle);
	}

	public TeleportTransition createTeleportTransition(Direction.Axis pAxis, Entity pEntity, BlockUtil.FoundRectangle pFoundRectangle, TeleportTransition.PostTeleportTransition pPostTeleportTransition, ServerLevel pServerLevel, Vec3 pVe3) {
		var blockPos = pFoundRectangle.minCorner;
		var entityDimensions = pEntity.getDimensions(pEntity.getPose());
		var axis = pServerLevel.getBlockState(blockPos).getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);

		var flag = axis == Direction.Axis.X;

		var d = pVe3.x() * (pFoundRectangle.axis1Size - entityDimensions.width()) + entityDimensions.width() / 2.0D;
		var e = pVe3.y() * (pFoundRectangle.axis2Size - entityDimensions.height());
		var f = pVe3.z() + 0.5D;

		var i = pAxis == axis ? 0 : 90;

		var vec3 = new Vec3(blockPos.getX() + (flag ? d : f), blockPos.getY() + e, blockPos.getZ() + (flag ? f : d));

		return new TeleportTransition(pServerLevel, PortalShape.findCollisionFreePosition(vec3, pServerLevel, pEntity, entityDimensions), Vec3.ZERO, i, 0.0F, Relative.union(Relative.DELTA, Relative.ROTATION), pPostTeleportTransition);
	}

	public TeleportTransition teleportTransition(BlockPos pBlockPos, Entity pEntity, BlockUtil.FoundRectangle pFoundRectangle, TeleportTransition.PostTeleportTransition pPostTeleportTransition, ServerLevel pServerLevel) {
		var blockState = pEntity.level().getBlockState(pBlockPos);
		var axis = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
		var foundRectangle = this.rectangle(axis, pBlockPos, blockState, pServerLevel);
		var vec3 = pEntity.getRelativePortalPosition(axis, foundRectangle);
		return this.createTeleportTransition(axis, pEntity, pFoundRectangle, pPostTeleportTransition, pServerLevel, vec3);
	}

	public TeleportTransition teleportTransition(BlockPos pEntrance, BlockPos pExit, Entity pEntity, ServerLevel pServerLevel, WorldBorder pWorldBorder) {
		var optional = this.oldPos(pExit, pServerLevel, pWorldBorder);
		var foundRectangle = this.portalRectangle(optional, pEntrance, pExit, pEntity, pServerLevel);
		var postTeleportTransition = this.postTeleportTransition(optional);
		return this.teleportTransition(pEntrance, pEntity, foundRectangle, postTeleportTransition, pServerLevel);
	}

	public TeleportTransition.PostTeleportTransition postTeleportTransition(Optional<BlockPos> pOptional) {
		return pOptional.map(blockPos -> TeleportTransition.PLAY_PORTAL_SOUND.then(entity -> entity.placePortalTicket(blockPos))).orElseGet(() -> TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET));
	}

	@Nullable
	@Override
	public TeleportTransition getPortalDestination(ServerLevel pServerLevel, Entity pEntity, BlockPos pBlockPos) {
		var resourceKey = pServerLevel.dimension() != IcariaDimensions.ICARIA ? IcariaDimensions.ICARIA : Level.OVERWORLD;
		var serverLevel = pServerLevel.getServer().getLevel(resourceKey);
		if (serverLevel != null) {
			var worldBorder = serverLevel.getWorldBorder();
			var blockPos = worldBorder.clampToBounds(pEntity.getX(), pEntity.getY(), pEntity.getZ());
			return this.teleportTransition(pBlockPos, blockPos, pEntity, serverLevel, worldBorder);
		} else {
			return null;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return pBlockState.getValue(BlockStateProperties.HORIZONTAL_AXIS) == Direction.Axis.X ? PortalVoxelShapes.X : PortalVoxelShapes.Z;
	}
}
