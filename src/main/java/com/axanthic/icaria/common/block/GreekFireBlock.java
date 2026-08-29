package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.LayerVoxelShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public GreekFireBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		return IcariaCommonHelper.hasRigidBlockBelow(pBlockPos, pLevelReader);
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		var flag = pBlockState.getFluidState().is(FluidTags.WATER);
		var chance = flag ? 2 : 24;
		var particleType = flag ? ParticleTypes.BUBBLE_COLUMN_UP : ParticleTypes.LARGE_SMOKE;
		var soundEvent = flag ? SoundEvents.BUBBLE_COLUMN_BUBBLE_POP : SoundEvents.FIRE_AMBIENT;
		this.particles(pBlockPos, pLevel, pRandomSource, particleType);
		this.sounds(pBlockPos, pLevel, pRandomSource, soundEvent, chance);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void entityInside(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Entity pEntity, InsideBlockEffectApplier pInsideBlockEffectApplier, boolean pIntersects) {
		this.igniteEntity(pEntity);
		IcariaCommonHelper.hurt(pLevel.damageSources().inFire(), pEntity, 1.5F);
	}

	public void extinguish(BlockPos pBlockPos, Level pLevel) {
		if (!pLevel.isClientSide()) {
			pLevel.levelEvent(null, 1009, pBlockPos, 0);
		}
	}

	public void igniteEntity(Entity pEntity) {
		var i = pEntity.getRemainingFireTicks();
		if (!pEntity.fireImmune()) {
			if (i < 0) {
				pEntity.setRemainingFireTicks(i + 1);
			} else {
				pEntity.igniteForSeconds(8.0F);
			}
		}
	}

	@Override
	public void onPlace(BlockState pBlockStateNew, Level pLevel, BlockPos pBlockPos, BlockState pBlockStateOld, boolean pMovedByPiston) {
		pLevel.scheduleTick(pBlockPos, this, pLevel.getRandom().nextInt(300) + 300);
	}

	public void particles(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource, SimpleParticleType pSimpleParticleType) {
		for (var i = 0; i < 3; ++i) {
			pLevel.addParticle(pSimpleParticleType, pBlockPos.getX() + pRandomSource.nextDouble(), pBlockPos.getY() + pRandomSource.nextDouble() * 0.5D + 0.5D, pBlockPos.getZ() + pRandomSource.nextDouble(), 0.0D, 0.0D, 0.0D);
		}
	}

	public void sounds(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource, SoundEvent pSoundEvent, int pChance) {
		if (pRandomSource.nextInt(pChance) == 0) {
			pLevel.playLocalSound(pBlockPos.getX() + 0.5D, pBlockPos.getY() + 0.5D, pBlockPos.getZ() + 0.5D, pSoundEvent, SoundSource.BLOCKS, pRandomSource.nextFloat() + 1.0F, pRandomSource.nextFloat() * 0.7F + 0.3F, false);
		}
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pServerLevel.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
			pServerLevel.removeBlock(pBlockPos, false);
		}
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.extinguish(pBlockPos, pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pBlockState.canSurvive(pLevelReader, pBlockPos) ? super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource) : Blocks.AIR.defaultBlockState();
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return LayerVoxelShapes.Y_01;
	}
}
