package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Ladder;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RottenLadderBlock extends IcariaLadderBlock {
	public RottenLadderBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.LADDER, Ladder.NONE).setValue(IcariaBlockStateProperties.LADDER_TICK, 0).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean isLadder(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos, LivingEntity pLivingEntity) {
		return super.isLadder(pBlockState, pLevelReader, pBlockPos, pLivingEntity) && pBlockState.getValue(IcariaBlockStateProperties.LADDER) != Ladder.DAMAGED;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.LADDER, IcariaBlockStateProperties.LADDER_TICK, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void entityInside(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Entity pEntity, InsideBlockEffectApplier pInsideBlockEffectApplier, boolean pIntersects) {
		this.particle(pBlockPos, pBlockState, pLevel);
		pLevel.scheduleTick(pBlockPos, this, 0);
	}

	public void particle(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.LADDER_TICK) == 40) {
			var blockParticleOption = new BlockParticleOption(ParticleTypes.BLOCK, this.defaultBlockState());
			for (var i = 0; i < 25; i++) {
				var random = pLevel.getRandom().nextDouble();
				this.particle(blockParticleOption, pBlockPos, pBlockState, pLevel, random);
			}
		}
	}

	public void particle(BlockParticleOption pBlockParticleOption, BlockPos pBlockPos, BlockState pBlockState, Level pLevel, double pOffset) {
		if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
			pLevel.addParticle(pBlockParticleOption, pBlockPos.getX() + pOffset, pBlockPos.getY() + pOffset, pBlockPos.getZ() + 1.0D, 0.0D, 0.0D, 0.0D);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
			pLevel.addParticle(pBlockParticleOption, pBlockPos.getX(), pBlockPos.getY() + pOffset, pBlockPos.getZ() + pOffset, 0.0D, 0.0D, 0.0D);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
			pLevel.addParticle(pBlockParticleOption, pBlockPos.getX() + pOffset, pBlockPos.getY() + pOffset, pBlockPos.getZ(), 0.0D, 0.0D, 0.0D);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
			pLevel.addParticle(pBlockParticleOption, pBlockPos.getX() + 1.0D, pBlockPos.getY() + pOffset, pBlockPos.getZ() + pOffset, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (!pServerLevel.getEntitiesOfClass(Player.class, new AABB(pBlockPos)).isEmpty()) {
			this.updateLadder(pBlockPos, pBlockState, pServerLevel);
		} else {
			pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.LADDER_TICK, 0));
		}
	}

	public void updateLadder(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.LADDER) == Ladder.NONE) {
			this.updateLadder(pBlockPos, pBlockState, pServerLevel, Ladder.CRACKED);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.LADDER) == Ladder.CRACKED) {
			this.updateLadder(pBlockPos, pBlockState, pServerLevel, Ladder.DAMAGED);
		}
	}

	public void updateLadder(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel, Ladder pLadder) {
		if (pBlockState.getValue(IcariaBlockStateProperties.LADDER_TICK) < 40) {
			pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.LADDER_TICK, pBlockState.getValue(IcariaBlockStateProperties.LADDER_TICK) + 1));
		} else {
			pServerLevel.playSound(null, pBlockPos, IcariaSoundEvents.ROTTEN_BONE_LADDER_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
			pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.LADDER, pLadder).setValue(IcariaBlockStateProperties.LADDER_TICK, 0));
		}
	}
}
