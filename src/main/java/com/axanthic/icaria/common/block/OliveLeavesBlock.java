package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Olives;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
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

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OliveLeavesBlock extends IcariaLeavesBlock {
	public OliveLeavesBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.DISTANCE, 7).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE).setValue(BlockStateProperties.PERSISTENT, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.DISTANCE, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.OLIVES, BlockStateProperties.PERSISTENT, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		super.randomTick(pState, pLevel, pPos, pRandom);
		if (pRandom.nextInt(100) == 0) {
			if (!pState.getValue(BlockStateProperties.PERSISTENT)) {
				if (pState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.NONE) {
					pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.OLIVES, Olives.GREEN), 2);
				} else if (pState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.GREEN) {
					pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.OLIVES, Olives.BLACK), 2);
				}
			}
		}
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pResult) {
		if (pState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.GREEN) {
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);
			pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE), 2);
			Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.GREEN_OLIVES.get()));
			return InteractionResult.sidedSuccess(pLevel.isClientSide());
		} else if (pState.getValue(IcariaBlockStateProperties.OLIVES) == Olives.BLACK) {
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);
			pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE), 2);
			Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.BLACK_OLIVES.get()));
			return InteractionResult.sidedSuccess(pLevel.isClientSide());
		} else {
			return InteractionResult.PASS;
		}
	}
}
