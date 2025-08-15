package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.shapes.AmphoraShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AmphoraBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public AmphoraBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.AMOUNT_LOCKED, false).setValue(IcariaBlockStateProperties.AMPHORA_AMOUNT, 1).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pBlockState.getValue(IcariaBlockStateProperties.AMPHORA_AMOUNT) * 5;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.AMOUNT_LOCKED, IcariaBlockStateProperties.AMPHORA_AMOUNT, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		var amount = pBlockState.getValue(IcariaBlockStateProperties.AMPHORA_AMOUNT);
		var item = pItemStack.getItem();
		if (item == IcariaItems.AMPHORA.get() && amount < 3) {
			pItemStack.consume(1, pPlayer);
			pLevel.playSound(pPlayer, pBlockPos, SoundEvents.DECORATED_POT_PLACE, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.AMPHORA_AMOUNT, amount + 1));
			pPlayer.awardStat(Stats.ITEM_USED.get(item));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return AmphoraShapes.AMPHORA;
	}
}
