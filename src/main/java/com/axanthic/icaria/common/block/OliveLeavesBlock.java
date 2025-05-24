package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Olives;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OliveLeavesBlock extends IcariaLeavesBlock {
	public OliveLeavesBlock(int pColor, Properties pProperties) {
		super(pColor, pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.DISTANCE, 7).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE).setValue(BlockStateProperties.PERSISTENT, false).setValue(BlockStateProperties.WATERLOGGED, false));
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
		if (pBlockState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.GREEN) {
			Block.popResource(pLevel, pBlockPos, new ItemStack(IcariaItems.GREEN_OLIVES.get()));
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.OLIVES_POP, SoundSource.BLOCKS);
			pLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE), 2);
			return InteractionResult.SUCCESS;
		} else if (pBlockState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.BLACK) {
			Block.popResource(pLevel, pBlockPos, new ItemStack(IcariaItems.BLACK_OLIVES.get()));
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.OLIVES_POP, SoundSource.BLOCKS);
			pLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE), 2);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
	}
}
