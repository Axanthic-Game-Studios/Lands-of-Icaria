package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.TroughBlockEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.shapes.TroughVoxelShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TroughBlock extends Block implements EntityBlock, MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public TroughBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Direction pDirection) {
		return pBlockState.getValue(IcariaBlockStateProperties.TROUGH_FILL);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.TROUGH, IcariaBlockStateProperties.TROUGH_FILL, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new TroughBlockEntity(pBlockPos, pBlockState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		var fill = pBlockState.getValue(IcariaBlockStateProperties.TROUGH_FILL);
		if (pBlockState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.NONE) {
			return this.fill(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer, fill);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.POWDER_SNOW) {
			return this.powderSnow(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.WATER) {
			return this.water(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer, fill);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.MEDITERRANEAN_WATER) {
			return this.mediterraneanWater(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.ONION) {
			return this.onion(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer, fill);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.SPELT) {
			return this.spelt(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer, fill);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.VINEBERRIES) {
			return this.vineberries(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer, fill);
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult fill(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer, int pFill) {
		if (pItemStack.is(Items.POWDER_SNOW_BUCKET)) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.POWDER_SNOW).setValue(IcariaBlockStateProperties.TROUGH_FILL, 9));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.POWDER_SNOW_BUCKET));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.WATER_BUCKET)) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, 9));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.WATER_BUCKET));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get())) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.MEDITERRANEAN_WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, 9));
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.POTION) && pItemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER)) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.GLASS_BOTTLE), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill + 3));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.POTION));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(IcariaItems.ONION.get())) {
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.ONION).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill + 1));
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.ONION.get()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(IcariaItems.SPELT.get())) {
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.SPELT).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill + 1));
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.SPELT.get()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(IcariaItems.VINEBERRIES.get())) {
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.VINEBERRIES).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill + 1));
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.VINEBERRIES.get()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult powderSnow(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pItemStack.is(Items.BUCKET)) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.POWDER_SNOW_BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL_POWDER_SNOW, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult water(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer, int pFill) {
		if (pItemStack.is(Items.BUCKET) && pFill == 9) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.WATER_BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.POTION) && pItemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER) && pFill <= 6) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.GLASS_BOTTLE), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill + 3));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.POTION));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.GLASS_BOTTLE) && pFill > 3) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, PotionContents.createItemStack(Items.POTION, Potions.WATER), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill - 3));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.GLASS_BOTTLE) && pFill > 2) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, PotionContents.createItemStack(Items.POTION, Potions.WATER), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult mediterraneanWater(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pItemStack.is(Items.BUCKET)) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0));
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult onion(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer, int pFill) {
		if (pItemStack.is(IcariaItems.ONION.get()) && pFill < 9) {
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.ONION).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill + 1));
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.ONION.get()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult spelt(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer, int pFill) {
		if (pItemStack.is(IcariaItems.SPELT.get()) && pFill < 9) {
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.SPELT).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill + 1));
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.SPELT.get()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult vineberries(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer, int pFill) {
		if (pItemStack.is(IcariaItems.VINEBERRIES.get()) && pFill < 9) {
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.TROUGH, Trough.VINEBERRIES).setValue(IcariaBlockStateProperties.TROUGH_FILL, pFill + 1));
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.VINEBERRIES.get()));
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TroughVoxelShapes.NORTH;
			case EAST -> TroughVoxelShapes.EAST;
			case SOUTH -> TroughVoxelShapes.SOUTH;
			default -> TroughVoxelShapes.WEST;
		};
	}
}
