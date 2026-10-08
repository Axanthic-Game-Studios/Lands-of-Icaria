package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.properties.Mat;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TowelHolderBlock extends HolderBlock {
	public TowelHolderBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MAT, Mat.TERRY_MAT).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MAT, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public void dropMat(BlockState pBlockState, BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.MAT) != Mat.TERRY_MAT) {
			var itemStack = new ItemStack(IcariaCommonHelper.getItemFromMat(pBlockState.getValue(IcariaBlockStateProperties.MAT)));
			Block.popResourceFromFace(pLevel, pBlockPos, pDirection, itemStack);
		}
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof MatBlock matBlock && matBlock.getMat() != pBlockState.getValue(IcariaBlockStateProperties.MAT)) {
			this.dropMat(pBlockState, pBlockPos, pBlockHitResult.getDirection(), pLevel);
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.MAT_APPLY, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.MAT, matBlock.getMat()));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.getItem() == Items.SHEARS && pBlockState.getValue(IcariaBlockStateProperties.MAT) != Mat.TERRY_MAT) {
			this.dropMat(pBlockState, pBlockPos, pBlockHitResult.getDirection(), pLevel);
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.MAT_CLEAR, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.MAT, Mat.TERRY_MAT));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}
}
