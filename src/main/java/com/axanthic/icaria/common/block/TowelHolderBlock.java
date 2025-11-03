package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Carpet;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.shapes.TowelHolderVoxelShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TowelHolderBlock extends HolderBlock {
	public TowelHolderBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.CARPET, Carpet.ARACHNE_STRING_CARPET).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CARPET, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public void dropCarpet(BlockState pBlockState, BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CARPET) != Carpet.ARACHNE_STRING_CARPET) {
			var itemStack = new ItemStack(this.getItemByCarpet(pBlockState.getValue(IcariaBlockStateProperties.CARPET)));
			Block.popResourceFromFace(pLevel, pBlockPos, pDirection, itemStack);
		}
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof IcariaCarpetBlock carpetBlock && carpetBlock.getCarpet() != pBlockState.getValue(IcariaBlockStateProperties.CARPET)) {
			this.dropCarpet(pBlockState, pBlockPos, pBlockHitResult.getDirection(), pLevel);
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.CARPET_APPLY, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CARPET, carpetBlock.getCarpet()));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.getItem() == Items.SHEARS && pBlockState.getValue(IcariaBlockStateProperties.CARPET) != Carpet.ARACHNE_STRING_CARPET) {
			this.dropCarpet(pBlockState, pBlockPos, pBlockHitResult.getDirection(), pLevel);
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.CARPET_CLEAR, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CARPET, Carpet.ARACHNE_STRING_CARPET));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public Item getItemByCarpet(Carpet pCarpet) {
		return switch (pCarpet) {
			case Carpet.ARACHNE_STRING_CARPET -> IcariaItems.ARACHNE_STRING_CARPET.get();
			case Carpet.WHITE_ARACHNE_STRING_CARPET -> IcariaItems.WHITE_ARACHNE_STRING_CARPET.get();
			case Carpet.LIGHT_GRAY_ARACHNE_STRING_CARPET -> IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get();
			case Carpet.GRAY_ARACHNE_STRING_CARPET -> IcariaItems.GRAY_ARACHNE_STRING_CARPET.get();
			case Carpet.BLACK_ARACHNE_STRING_CARPET -> IcariaItems.BLACK_ARACHNE_STRING_CARPET.get();
			case Carpet.BROWN_ARACHNE_STRING_CARPET -> IcariaItems.BROWN_ARACHNE_STRING_CARPET.get();
			case Carpet.RED_ARACHNE_STRING_CARPET -> IcariaItems.RED_ARACHNE_STRING_CARPET.get();
			case Carpet.ORANGE_ARACHNE_STRING_CARPET -> IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get();
			case Carpet.YELLOW_ARACHNE_STRING_CARPET -> IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get();
			case Carpet.LIME_ARACHNE_STRING_CARPET -> IcariaItems.LIME_ARACHNE_STRING_CARPET.get();
			case Carpet.GREEN_ARACHNE_STRING_CARPET -> IcariaItems.GREEN_ARACHNE_STRING_CARPET.get();
			case Carpet.CYAN_ARACHNE_STRING_CARPET -> IcariaItems.CYAN_ARACHNE_STRING_CARPET.get();
			case Carpet.LIGHT_BLUE_ARACHNE_STRING_CARPET -> IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get();
			case Carpet.BLUE_ARACHNE_STRING_CARPET -> IcariaItems.BLUE_ARACHNE_STRING_CARPET.get();
			case Carpet.PURPLE_ARACHNE_STRING_CARPET -> IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get();
			case Carpet.MAGENTA_ARACHNE_STRING_CARPET -> IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get();
			case Carpet.PINK_ARACHNE_STRING_CARPET -> IcariaItems.PINK_ARACHNE_STRING_CARPET.get();
		};
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TowelHolderVoxelShapes.NORTH;
			case EAST -> TowelHolderVoxelShapes.EAST;
			case SOUTH -> TowelHolderVoxelShapes.SOUTH;
			default -> TowelHolderVoxelShapes.WEST;
		};
	}
}
