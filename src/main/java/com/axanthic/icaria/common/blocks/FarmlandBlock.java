package com.axanthic.icaria.common.blocks;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.IcariaItemTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FarmlandBlock extends Block {
	public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
	public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	public FarmlandBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockState state = pLevel.getBlockState(pPos.above());
		return !state.getMaterial().isSolid() || state.getBlock() instanceof FenceGateBlock || state.getBlock() instanceof MovingPistonBlock;
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pFacing, IPlantable pPlantable) {
		PlantType type = pPlantable.getPlantType(pLevel, pPos.relative(pFacing));
		return type == PlantType.CROP;
	}

	public boolean isNearWater(LevelReader pLevel, BlockPos pPos) {
		for (BlockPos pos : BlockPos.betweenClosed(pPos.offset(-4, 0, -4), pPos.offset(4, 1, 4))) {
			if (pLevel.getFluidState(pos).is(FluidTags.WATER)) {
				return true;
			}
		}

		return FarmlandWaterManager.hasBlockWaterTicket(pLevel, pPos);
	}

	public boolean isUnderCrops(BlockGetter pLevel, BlockPos pPos) {
		BlockState state = pLevel.getBlockState(pPos.above());
		return state.getBlock() instanceof IPlantable && pLevel.getBlockState(pPos).canSustainPlant(pLevel, pPos, Direction.UP, (IPlantable) state.getBlock());
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(MOISTURE);
	}

	@Override
	public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
		if (!pLevel.isClientSide && ForgeHooks.onFarmlandTrample(pLevel, pPos, IcariaBlocks.MARL.get().defaultBlockState(), pFallDistance, pEntity)) {
			turnToMarl(pState, pLevel, pPos);
		}

		super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		int i = pState.getValue(MOISTURE);
		if (!isNearWater(pLevel, pPos) && !pLevel.isRainingAt(pPos.above())) {
			if (i > 0) {
				pLevel.setBlock(pPos, pState.setValue(MOISTURE, i - 1), 2);
			} else if (!isUnderCrops(pLevel, pPos)) {
				turnToMarl(pState, pLevel, pPos);
			}
		} else if (i < 7) {
			pLevel.setBlock(pPos, pState.setValue(MOISTURE, 7), 2);
		}
	}

	@Override
	public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (!pState.canSurvive(pLevel, pPos)) {
			turnToMarl(pState, pLevel, pPos);
		}
	}

	public void turnToMarl(BlockState pState, Level pLevel, BlockPos pPos) {
		pLevel.setBlockAndUpdate(pPos, pushEntitiesUp(pState, IcariaBlocks.MARL.get().defaultBlockState(), pLevel, pPos));
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		if (pFacing == Direction.UP && !pState.canSurvive(pLevel, pCurrentPos)) {
			pLevel.scheduleTick(pCurrentPos, this, 1);
		}

		return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		ItemStack stack = pPlayer.getItemInHand(pHand);

		if (stack.is(IcariaItemTags.SMALL_DUST_CALCITE)) {
			if (pState.getValue(MOISTURE) == 7) {
				pLevel.playSound(pPlayer, pPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				if (!pLevel.isClientSide) {
					pLevel.setBlock(pPos, IcariaBlocks.FARMLAND_FERTILIZED.get().defaultBlockState(), 0);
					if (!pPlayer.isCreative()) {
						stack.shrink(1);
					}
				}
			}

			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}
}
