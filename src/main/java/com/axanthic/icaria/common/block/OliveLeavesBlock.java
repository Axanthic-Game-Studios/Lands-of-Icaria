package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Olives;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OliveLeavesBlock extends IcariaLeavesBlock {
	public OliveLeavesBlock(int pColor, Properties pProperties) {
		super(pColor, pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.DISTANCE, 7).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE).setValue(BlockStateProperties.PERSISTENT, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean isRandomlyTicking(BlockState pBlockState) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.DISTANCE, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.OLIVES, BlockStateProperties.PERSISTENT, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void randomTick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		super.randomTick(pBlockState, pServerLevel, pBlockPos, pRandomSource);
		if (pRandomSource.nextInt(100) == 0) {
			if (!pBlockState.getValue(BlockStateProperties.PERSISTENT)) {
				if (pBlockState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.NONE) {
					pServerLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.GREEN), 2);
				} else if (pBlockState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.GREEN) {
					pServerLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.BLACK), 2);
				}
			}
		}
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		if (pLevel instanceof ServerLevel serverLevel && pBlockState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.BLACK) {
			return this.dropFromLootTable(pBlockPos, pBlockState, pBlockHitResult.getDirection(), serverLevel, IcariaLootTables.OLIVE_LEAVES);
		} else if (pLevel instanceof ServerLevel serverLevel && pBlockState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.GREEN) {
			return this.dropFromLootTable(pBlockPos, pBlockState, pBlockHitResult.getDirection(), serverLevel, IcariaLootTables.OLIVE_LEAVES);
		} else {
			return InteractionResult.PASS;
		}
	}

	public InteractionResult dropFromLootTable(BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ServerLevel pServerLevel, ResourceKey<LootTable> pResourceKey) {
		Block.dropFromLootTable(pServerLevel, pResourceKey, builder -> builder.withParameter(LootContextParams.BLOCK_STATE, pBlockState).create(LootContextParamSets.BLOCK_INTERACT), (serverLevel, itemStack) -> Block.popResourceFromFace(serverLevel, pBlockPos, pDirection, itemStack));
		pServerLevel.playSound(null, pBlockPos, IcariaSoundEvents.OLIVES_POP, SoundSource.BLOCKS);
		pServerLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE), 2);
		return InteractionResult.SUCCESS;
	}
}
