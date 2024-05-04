package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.*;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaLogBlock extends RotatedPillarBlock {
	public IcariaLogBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y).setValue(IcariaBlockStateProperties.PLAYER_PLACED, false));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, boolean pWillHarvest, FluidState pFluid) {
		if (!pPlayer.isCreative()) {
			if (!pPlayer.getItemBySlot(EquipmentSlot.HEAD).is(IcariaItems.LAUREL_WREATH.get())) {
				if (!pState.getValue(IcariaBlockStateProperties.PLAYER_PLACED)) {
					if (pLevel.getRandom().nextInt(100) == 0) {
						var entityType = IcariaEntityTypes.CYPRESS_FOREST_HAG.get();
						if (pState.is(IcariaBlocks.DROUGHTROOT_LOG.get())) {
							entityType = IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get();
						} else if (pState.is(IcariaBlocks.FIR_LOG.get())) {
							entityType = IcariaEntityTypes.FIR_FOREST_HAG.get();
						} else if (pState.is(IcariaBlocks.LAUREL_LOG.get())) {
							entityType = IcariaEntityTypes.LAUREL_FOREST_HAG.get();
						} else if (pState.is(IcariaBlocks.OLIVE_LOG.get())) {
							entityType = IcariaEntityTypes.OLIVE_FOREST_HAG.get();
						} else if (pState.is(IcariaBlocks.PLANE_LOG.get())) {
							entityType = IcariaEntityTypes.PLANE_FOREST_HAG.get();
						} else if (pState.is(IcariaBlocks.POPULUS_LOG.get())) {
							entityType = IcariaEntityTypes.POPULUS_FOREST_HAG.get();
						}

						var entity = entityType.create(pLevel);
						if (entity != null) {
							var direction = pPlayer.getDirection();
							var blockPos = pPlayer.blockPosition();
							var soundPos = new BlockPos(blockPos.relative(direction.getOpposite(), 8).getX(), blockPos.getY(), blockPos.relative(direction.getOpposite(), 8).getZ());
							var spawnPos = new BlockPos(blockPos.relative(direction.getOpposite(), 16).getX(), blockPos.getY(), blockPos.relative(direction.getOpposite(), 16).getZ());
							if (!pLevel.getBiome(spawnPos).is(IcariaBiomes.VOID)) {
								entity.moveTo(spawnPos, 0.0F, 0.0F);
								entity.setTarget(pPlayer);
								entity.spawnAnim();
								pLevel.addFreshEntity(entity);
								pLevel.playSound(null, soundPos, SoundEvents.ENDERMAN_SCREAM, SoundSource.HOSTILE, 1.0F, 0.5F);
								pLevel.playSound(null, soundPos, SoundEvents.ENDERMAN_STARE, SoundSource.HOSTILE);
							}
						}
					}

					for (var entity : pLevel.getEntitiesOfClass(ForestHagEntity.class, new AABB(pPos).inflate(16))) {
						entity.setTarget(pPlayer);
					}
				}
			}
		}

		return super.onDestroyedByPlayer(pState, pLevel, pPos, pPlayer, pWillHarvest, pFluid);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.AXIS, IcariaBlockStateProperties.PLAYER_PLACED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(BlockStateProperties.AXIS, pContext.getClickedFace().getAxis()).setValue(IcariaBlockStateProperties.PLAYER_PLACED, true);
	}
}
