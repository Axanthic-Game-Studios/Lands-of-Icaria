package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;
import com.axanthic.icaria.data.registry.IcariaBiomes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLogBlock extends RotatedPillarBlock {
	public IcariaLogBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y).setValue(IcariaBlockStateProperties.PLAYER_PLACED, false));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, ItemStack pItemStack, boolean pWillHarvest, FluidState pFluidState) {
		this.handleAction(pBlockPos, pBlockState, pLevel, pPlayer);
		return super.onDestroyedByPlayer(pBlockState, pLevel, pBlockPos, pPlayer, pItemStack, pWillHarvest, pFluidState);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.AXIS, IcariaBlockStateProperties.PLAYER_PLACED);
	}

	public void handleAction(BlockPos pBlockPos, BlockState pBlockState, Level pLevel, Player pPlayer) {
		if (!pPlayer.getItemBySlot(EquipmentSlot.HEAD).is(IcariaItems.LAUREL_WREATH.get())) {
			if (!pPlayer.isCreative()) {
				if (!pBlockState.getValue(IcariaBlockStateProperties.PLAYER_PLACED)) {
					this.summon(pBlockState, pLevel, pPlayer);
					this.target(pBlockPos, pLevel, pPlayer);
				}
			}
		}
	}

	public void summon(BlockState pBlockState, Level pLevel, Player pPlayer) {
		if (pLevel.getRandom().nextInt(50) == 0) {
			var blockPos = pPlayer.blockPosition();
			var direction = pPlayer.getDirection();
			var entity = this.entityType(pBlockState).create(pLevel, EntitySpawnReason.TRIGGERED);
			var spawnPos = new BlockPos(blockPos.relative(direction.getOpposite(), 12).getX(), blockPos.getY(), blockPos.relative(direction.getOpposite(), 12).getZ());
			if (entity != null) {
				if (!pLevel.getBiome(spawnPos).is(IcariaBiomes.VOID)) {
					if (pLevel.getBlockState(spawnPos).isAir()) {
						entity.snapTo(spawnPos, 0.0F, 0.0F);
						entity.setTarget(pPlayer);
						entity.spawnAnim();
						pLevel.addFreshEntity(entity);
					}
				}
			}
		}
	}

	public void target(BlockPos pBlockPos, Level pLevel, Player pPlayer) {
		for (var entity : pLevel.getEntitiesOfClass(ForestHagEntity.class, new AABB(pBlockPos).inflate(12))) {
			entity.setTarget(pPlayer);
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return this.defaultBlockState().setValue(BlockStateProperties.AXIS, pBlockPlaceContext.getClickedFace().getAxis()).setValue(IcariaBlockStateProperties.PLAYER_PLACED, true);
	}

	public EntityType<ForestHagEntity> entityType(BlockState pBlockState) {
		if (pBlockState.is(IcariaBlockTagsProvider.LOGS_CYPRESS)) {
			return IcariaEntityTypes.CYPRESS_FOREST_HAG.get();
		} else if (pBlockState.is(IcariaBlockTagsProvider.LOGS_DROUGHTROOT)) {
			return IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get();
		} else if (pBlockState.is(IcariaBlockTagsProvider.LOGS_FIR)) {
			return IcariaEntityTypes.FIR_FOREST_HAG.get();
		} else if (pBlockState.is(IcariaBlockTagsProvider.LOGS_LAUREL)) {
			return IcariaEntityTypes.LAUREL_FOREST_HAG.get();
		} else if (pBlockState.is(IcariaBlockTagsProvider.LOGS_OLIVE)) {
			return IcariaEntityTypes.OLIVE_FOREST_HAG.get();
		} else if (pBlockState.is(IcariaBlockTagsProvider.LOGS_PLANE)) {
			return IcariaEntityTypes.PLANE_FOREST_HAG.get();
		} else {
			return IcariaEntityTypes.POPULUS_FOREST_HAG.get();
		}
	}
}
