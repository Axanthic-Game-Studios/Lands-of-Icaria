package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SuspiciousSubstanceBlock extends TableDecorationBlock {
	public SuspiciousSubstanceBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.SUSPICIOUS_SUBSTANCE, 3).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.SUSPICIOUS_SUBSTANCE, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		if (pBlockState.getValue(IcariaBlockStateProperties.SUSPICIOUS_SUBSTANCE) > 0) {
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.PLAYER_SNIFF, SoundSource.PLAYERS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.SUSPICIOUS_SUBSTANCE, pBlockState.getValue(IcariaBlockStateProperties.SUSPICIOUS_SUBSTANCE) - 1));
			pPlayer.addEffect(new MobEffectInstance(MobEffects.HASTE, 200));
			pPlayer.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 200));
			pPlayer.addEffect(new MobEffectInstance(MobEffects.SPEED, 200));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}
}
