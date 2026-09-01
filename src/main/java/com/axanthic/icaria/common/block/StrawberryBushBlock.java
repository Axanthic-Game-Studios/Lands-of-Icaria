package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StrawberryBushBlock extends IcariaBushBlock {
	public StrawberryBushBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.RIPE_BUSH, false));
	}

	@Override
	public boolean isRandomlyTicking(BlockState pBlockState) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.RIPE_BUSH);
	}

	@Override
	public void randomTick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pRandomSource.nextInt(100) == 0) {
			if (!pBlockState.getValue(IcariaBlockStateProperties.RIPE_BUSH)) {
				pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.RIPE_BUSH, true));
			}
		}
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		if (pLevel instanceof ServerLevel serverLevel && pBlockState.getValue(IcariaBlockStateProperties.RIPE_BUSH)) {
			return this.dropFromLootTable(pBlockPos, pBlockState, pBlockHitResult.getDirection(), serverLevel, IcariaLootTables.STRAWBERRY_BUSH);
		} else {
			return InteractionResult.PASS;
		}
	}

	public InteractionResult dropFromLootTable(BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ServerLevel pServerLevel, ResourceKey<LootTable> pResourceKey) {
		Block.dropFromLootTable(pServerLevel, pResourceKey, builder -> builder.withParameter(LootContextParams.BLOCK_STATE, pBlockState).create(LootContextParamSets.BLOCK_INTERACT), (serverLevel, itemStack) -> Block.popResourceFromFace(serverLevel, pBlockPos, pDirection, itemStack));
		pServerLevel.playSound(null, pBlockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);
		pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.RIPE_BUSH, false));
		return InteractionResult.SUCCESS;
	}
}
