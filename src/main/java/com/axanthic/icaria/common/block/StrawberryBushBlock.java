package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

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
				pServerLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.RIPE_BUSH, true), 2);
			}
		}
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		if (pBlockState.getValue(IcariaBlockStateProperties.RIPE_BUSH)) {
			Block.popResource(pLevel, pBlockPos, new ItemStack(IcariaItems.STRAWBERRIES.get()));
			pLevel.playSound(null, pBlockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);
			pLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.RIPE_BUSH, false), 2);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
	}
}
