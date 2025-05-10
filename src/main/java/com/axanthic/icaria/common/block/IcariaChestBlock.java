package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaChestBlockCombiner;

import java.util.function.Supplier;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestBlock extends ChestBlock implements MediterraneanWaterloggedBlock {
	public IcariaChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> pBlockEntityType, Properties pProperties) {
		super(pBlockEntityType, pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.CHEST_TYPE, ChestType.SINGLE).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.LABEL_UP, false).setValue(IcariaBlockStateProperties.LABEL_NORTH, false).setValue(IcariaBlockStateProperties.LABEL_EAST, false).setValue(IcariaBlockStateProperties.LABEL_SOUTH, false).setValue(IcariaBlockStateProperties.LABEL_WEST, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, boolean pWillHarvest, FluidState pFluidState) {
		this.dropLabels(pBlockPos, pBlockState, pLevel);
		return super.onDestroyedByPlayer(pBlockState, pLevel, pBlockPos, pPlayer, pWillHarvest, pFluidState);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.CHEST_TYPE, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.LABEL_UP, IcariaBlockStateProperties.LABEL_NORTH, IcariaBlockStateProperties.LABEL_EAST, IcariaBlockStateProperties.LABEL_SOUTH, IcariaBlockStateProperties.LABEL_WEST, BlockStateProperties.WATERLOGGED);
	}

	public void dropLabel(BlockPos pBlockPos, Direction pDirection, Level pLevel, @Nullable String pLabel, boolean pStyle, int pColor) {
		var itemStack = new ItemStack(IcariaItems.CHEST_LABEL.get());
		Block.popResourceFromFace(pLevel, pBlockPos, pDirection, itemStack);
		itemStack.set(IcariaDataComponents.COLOR, pColor);
		itemStack.set(IcariaDataComponents.LABEL, pLabel);
		itemStack.set(IcariaDataComponents.STYLE, pStyle);
	}

	public void dropLabel(BlockPos pBlockPos, BlockState pBlockState, BooleanProperty pBooleanProperty, Level pLevel, @Nullable String pLabel, boolean pStyle, int pColor) {
		var itemStack = new ItemStack(IcariaItems.CHEST_LABEL.get());
		if (pBlockState.getValue(pBooleanProperty)) {
			Block.popResource(pLevel, pBlockPos, itemStack);
			itemStack.set(IcariaDataComponents.COLOR, pColor);
			itemStack.set(IcariaDataComponents.LABEL, pLabel);
			itemStack.set(IcariaDataComponents.STYLE, pStyle);
		}
	}

	public void dropLabels(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (pLevel.getBlockEntity(pBlockPos) instanceof IcariaChestBlockEntity blockEntity) {
			this.dropLabel(pBlockPos, pBlockState, IcariaBlockStateProperties.LABEL_UP, pLevel, blockEntity.getLabelUp(), blockEntity.getStyleUp(), blockEntity.getColorUp());
			this.dropLabel(pBlockPos, pBlockState, IcariaBlockStateProperties.LABEL_NORTH, pLevel, blockEntity.getLabelNorth(), blockEntity.getStyleNorth(), blockEntity.getColorNorth());
			this.dropLabel(pBlockPos, pBlockState, IcariaBlockStateProperties.LABEL_EAST, pLevel, blockEntity.getLabelEast(), blockEntity.getStyleEast(), blockEntity.getColorEast());
			this.dropLabel(pBlockPos, pBlockState, IcariaBlockStateProperties.LABEL_SOUTH, pLevel, blockEntity.getLabelSouth(), blockEntity.getStyleSouth(), blockEntity.getColorSouth());
			this.dropLabel(pBlockPos, pBlockState, IcariaBlockStateProperties.LABEL_WEST, pLevel, blockEntity.getLabelWest(), blockEntity.getStyleWest(), blockEntity.getColorWest());
		}
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.dropLabels(pBlockPos, pBlockState, pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void playApplySound(BlockPos pBlockPos, Level pLevel) {
		pLevel.playSound(null, pBlockPos, IcariaSoundEvents.CHEST_LABEL_APPLY, SoundSource.BLOCKS);
	}

	public void playClearSound(BlockPos pBlockPos, Level pLevel) {
		pLevel.playSound(null, pBlockPos, IcariaSoundEvents.CHEST_LABEL_CLEAR, SoundSource.BLOCKS);
	}

	public void playDyeSound(BlockPos pBlockPos, Level pLevel) {
		pLevel.playSound(null, pBlockPos, SoundEvents.DYE_USE, SoundSource.BLOCKS);
	}

	public void playGlowInkSacSound(BlockPos pBlockPos, Level pLevel) {
		pLevel.playSound(null, pBlockPos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS);
	}

	public void playInkSacSound(BlockPos pBlockPos, Level pLevel) {
		pLevel.playSound(null, pBlockPos, SoundEvents.INK_SAC_USE, SoundSource.BLOCKS);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new IcariaChestBlockEntity(pBlockPos, pBlockState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return super.getStateForPlacement(pBlockPlaceContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType() == IcariaFluids.MEDITERRANEAN_WATER.get());
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);

		var color = itemStack.getOrDefault(IcariaDataComponents.COLOR, 0);
		var label = itemStack.getOrDefault(IcariaDataComponents.LABEL, "");
		var style = itemStack.getOrDefault(IcariaDataComponents.STYLE, false);

		if (pLevel.getBlockEntity(pBlockPos) instanceof IcariaChestBlockEntity blockEntity && !blockEntity.getWaxed()) {
			return this.getInteractionResult(blockEntity, pBlockPos, pBlockState, pBlockHitResult.getDirection(), itemStack, pLevel, pPlayer, label, style, color);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult getInteractionResult(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer, String pLabel, boolean pStyle, int pColor) {
		if (pItemStack.getItem() instanceof DyeItem dyeItem) {
			return this.setColor(pBlockEntity, pBlockPos, pBlockState, pDirection, dyeItem, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(IcariaItems.CHEST_LABEL.get())) {
			return this.setLabel(pBlockEntity, pBlockPos, pBlockState, pDirection, pItemStack, pLevel, pPlayer, pLabel, pStyle, pColor);
		} else if (pItemStack.is(Items.INK_SAC)) {
			return this.setStyle(pBlockEntity, pBlockPos, pBlockState, pDirection, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.GLOW_INK_SAC)) {
			return this.setStyleGlowing(pBlockEntity, pBlockPos, pBlockState, pDirection, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.is(Items.HONEYCOMB)) {
			return this.setWaxed(pBlockEntity, pBlockPos, pItemStack, pLevel, pPlayer);
		} else if (pItemStack.isEmpty() && pPlayer.isShiftKeyDown()) {
			return this.removeLabel(pBlockEntity, pBlockPos, pBlockState, pDirection, pLevel);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setColor(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, DyeItem pDyeItem, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pDirection == Direction.UP) {
			return this.setColorUp(pBlockEntity, pBlockPos, pBlockState, pDyeItem, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.NORTH) {
			return this.setColorNorth(pBlockEntity, pBlockPos, pBlockState, pDyeItem, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.EAST) {
			return this.setColorEast(pBlockEntity, pBlockPos, pBlockState, pDyeItem, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.SOUTH) {
			return this.setColorSouth(pBlockEntity, pBlockPos, pBlockState, pDyeItem, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.WEST) {
			return this.setColorWest(pBlockEntity, pBlockPos, pBlockState, pDyeItem, pItemStack, pLevel, pPlayer);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setLabel(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer, String pLabel, boolean pStyle, int pColor) {
		if (pDirection == Direction.UP) {
			return this.setLabelUp(pBlockEntity, pBlockPos, pBlockState, pDirection, pItemStack, pLevel, pPlayer, pLabel, pStyle, pColor);
		} else if (pDirection == Direction.NORTH) {
			return this.setLabelNorth(pBlockEntity, pBlockPos, pBlockState, pDirection, pItemStack, pLevel, pPlayer, pLabel, pStyle, pColor);
		} else if (pDirection == Direction.EAST) {
			return this.setLabelEast(pBlockEntity, pBlockPos, pBlockState, pDirection, pItemStack, pLevel, pPlayer, pLabel, pStyle, pColor);
		} else if (pDirection == Direction.SOUTH) {
			return this.setLabelSouth(pBlockEntity, pBlockPos, pBlockState, pDirection, pItemStack, pLevel, pPlayer, pLabel, pStyle, pColor);
		} else if (pDirection == Direction.WEST) {
			return this.setLabelWest(pBlockEntity, pBlockPos, pBlockState, pDirection, pItemStack, pLevel, pPlayer, pLabel, pStyle, pColor);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setStyle(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pDirection == Direction.UP) {
			return this.setStyleUp(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.NORTH) {
			return this.setStyleNorth(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.EAST) {
			return this.setStyleEast(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.SOUTH) {
			return this.setStyleSouth(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.WEST) {
			return this.setStyleWest(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setStyleGlowing(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pDirection == Direction.UP) {
			return this.setGlowStyleUp(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.NORTH) {
			return this.setGlowStyleNorth(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.EAST) {
			return this.setGlowStyleEast(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.SOUTH) {
			return this.setGlowStyleSouth(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else if (pDirection == Direction.WEST) {
			return this.setGlowStyleWest(pBlockEntity, pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setWaxed(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		pBlockEntity.setWaxed(true);
		pBlockEntity.setChanged();
		pItemStack.consume(1, pPlayer);
		pLevel.levelEvent(null, 3003, pBlockPos, 0);
		return InteractionResult.SUCCESS;
	}

	public InteractionResult removeLabel(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, Level pLevel) {
		if (pDirection == Direction.UP) {
			return this.removeLabelUp(pBlockEntity, pBlockPos, pBlockState, pDirection, pLevel);
		} else if (pDirection == Direction.NORTH) {
			return this.removeLabelNorth(pBlockEntity, pBlockPos, pBlockState, pDirection, pLevel);
		} else if (pDirection == Direction.EAST) {
			return this.removeLabelEast(pBlockEntity, pBlockPos, pBlockState, pDirection, pLevel);
		} else if (pDirection == Direction.SOUTH) {
			return this.removeLabelSouth(pBlockEntity, pBlockPos, pBlockState, pDirection, pLevel);
		} else if (pDirection == Direction.WEST) {
			return this.removeLabelWest(pBlockEntity, pBlockPos, pBlockState, pDirection, pLevel);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setColorUp(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, DyeItem pDyeItem, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP) && pDyeItem.getDyeColor().getTextColor() != pBlockEntity.getColorUp()) {
			this.playDyeSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(pDyeItem));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorUp(pDyeItem.getDyeColor().getTextColor());
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setColorNorth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, DyeItem pDyeItem, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH) && pDyeItem.getDyeColor().getTextColor() != pBlockEntity.getColorNorth()) {
			this.playDyeSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(pDyeItem));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorNorth(pDyeItem.getDyeColor().getTextColor());
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setColorEast(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, DyeItem pDyeItem, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST) && pDyeItem.getDyeColor().getTextColor() != pBlockEntity.getColorEast()) {
			this.playDyeSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(pDyeItem));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorEast(pDyeItem.getDyeColor().getTextColor());
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setColorSouth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, DyeItem pDyeItem, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH) && pDyeItem.getDyeColor().getTextColor() != pBlockEntity.getColorSouth()) {
			this.playDyeSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(pDyeItem));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorSouth(pDyeItem.getDyeColor().getTextColor());
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setColorWest(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, DyeItem pDyeItem, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST) && pDyeItem.getDyeColor().getTextColor() != pBlockEntity.getColorWest()) {
			this.playDyeSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(pDyeItem));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorWest(pDyeItem.getDyeColor().getTextColor());
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setLabelUp(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer, String pLabel, boolean pStyle, int pColor) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, true).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (!pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)) {
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.setBlock(pBlockPos, blockState, 3);
			pBlockEntity.setColorUp(pColor);
			pBlockEntity.setLabelUp(pLabel);
			pBlockEntity.setStyleUp(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (pColor != pBlockEntity.getColorUp() || !pLabel.equals(pBlockEntity.getLabelUp()) || pStyle != pBlockEntity.getStyleUp()) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelUp(), pBlockEntity.getStyleUp(), pBlockEntity.getColorUp());
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorUp(pColor);
			pBlockEntity.setLabelUp(pLabel);
			pBlockEntity.setStyleUp(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setLabelNorth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer, String pLabel, boolean pStyle, int pColor) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, true).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (!pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)) {
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.setBlock(pBlockPos, blockState, 3);
			pBlockEntity.setColorNorth(pColor);
			pBlockEntity.setLabelNorth(pLabel);
			pBlockEntity.setStyleNorth(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (pColor != pBlockEntity.getColorNorth() || !pLabel.equals(pBlockEntity.getLabelNorth()) || pStyle != pBlockEntity.getStyleNorth()) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelNorth(), pBlockEntity.getStyleNorth(), pBlockEntity.getColorNorth());
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorNorth(pColor);
			pBlockEntity.setLabelNorth(pLabel);
			pBlockEntity.setStyleNorth(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setLabelEast(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer, String pLabel, boolean pStyle, int pColor) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, true).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (!pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)) {
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.setBlock(pBlockPos, blockState, 3);
			pBlockEntity.setColorEast(pColor);
			pBlockEntity.setLabelEast(pLabel);
			pBlockEntity.setStyleEast(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (pColor != pBlockEntity.getColorEast() || !pLabel.equals(pBlockEntity.getLabelEast()) || pStyle != pBlockEntity.getStyleEast()) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelEast(), pBlockEntity.getStyleEast(), pBlockEntity.getColorEast());
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorEast(pColor);
			pBlockEntity.setLabelEast(pLabel);
			pBlockEntity.setStyleEast(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setLabelSouth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer, String pLabel, boolean pStyle, int pColor) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, true).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (!pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)) {
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.setBlock(pBlockPos, blockState, 3);
			pBlockEntity.setColorSouth(pColor);
			pBlockEntity.setLabelSouth(pLabel);
			pBlockEntity.setStyleSouth(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (pColor != pBlockEntity.getColorSouth() || !pLabel.equals(pBlockEntity.getLabelSouth()) || pStyle != pBlockEntity.getStyleSouth()) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelSouth(), pBlockEntity.getStyleSouth(), pBlockEntity.getColorSouth());
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorSouth(pColor);
			pBlockEntity.setLabelSouth(pLabel);
			pBlockEntity.setStyleSouth(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setLabelWest(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer, String pLabel, boolean pStyle, int pColor) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, true).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (!pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)) {
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.setBlock(pBlockPos, blockState, 3);
			pBlockEntity.setColorWest(pColor);
			pBlockEntity.setLabelWest(pLabel);
			pBlockEntity.setStyleWest(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else if (pColor != pBlockEntity.getColorWest() || !pLabel.equals(pBlockEntity.getLabelWest()) || pStyle != pBlockEntity.getStyleWest()) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelWest(), pBlockEntity.getStyleWest(), pBlockEntity.getColorWest());
			this.playApplySound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setColorWest(pColor);
			pBlockEntity.setLabelWest(pLabel);
			pBlockEntity.setStyleWest(pStyle);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setStyleUp(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP) && pBlockEntity.getStyleUp()) {
			this.playInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleUp(false);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setStyleNorth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH) && pBlockEntity.getStyleNorth()) {
			this.playInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleNorth(false);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setStyleEast(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST) && pBlockEntity.getStyleEast()) {
			this.playInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleEast(false);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setStyleSouth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH) && pBlockEntity.getStyleSouth()) {
			this.playInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleSouth(false);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setStyleWest(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST) && pBlockEntity.getStyleWest()) {
			this.playInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleWest(false);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setGlowStyleUp(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP) && !pBlockEntity.getStyleUp()) {
			this.playGlowInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleUp(true);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setGlowStyleNorth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH) && !pBlockEntity.getStyleNorth()) {
			this.playGlowInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleNorth(true);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setGlowStyleEast(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST) && !pBlockEntity.getStyleEast()) {
			this.playGlowInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleEast(true);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setGlowStyleSouth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH) && !pBlockEntity.getStyleSouth()) {
			this.playGlowInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleSouth(true);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult setGlowStyleWest(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var blockState = this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED));
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST) && !pBlockEntity.getStyleWest()) {
			this.playGlowInkSacSound(pBlockPos, pLevel);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
			pLevel.sendBlockUpdated(pBlockPos, blockState, blockState, 3);
			pBlockEntity.setStyleWest(true);
			pBlockEntity.setChanged();
			pItemStack.consume(1, pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult removeLabelUp(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelUp(), pBlockEntity.getStyleUp(), pBlockEntity.getColorUp());
			this.playClearSound(pBlockPos, pLevel);
			pLevel.setBlock(pBlockPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, false).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED)), 3);
			pBlockEntity.setColorUp(0);
			pBlockEntity.setLabelUp(null);
			pBlockEntity.setStyleUp(false);
			pBlockEntity.setChanged();
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult removeLabelNorth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelNorth(), pBlockEntity.getStyleNorth(), pBlockEntity.getColorNorth());
			this.playClearSound(pBlockPos, pLevel);
			pLevel.setBlock(pBlockPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, false).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED)), 3);
			pBlockEntity.setColorNorth(0);
			pBlockEntity.setLabelNorth(null);
			pBlockEntity.setStyleNorth(false);
			pBlockEntity.setChanged();
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult removeLabelEast(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelEast(), pBlockEntity.getStyleEast(), pBlockEntity.getColorEast());
			this.playClearSound(pBlockPos, pLevel);
			pLevel.setBlock(pBlockPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, false).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED)), 3);
			pBlockEntity.setColorEast(0);
			pBlockEntity.setLabelEast(null);
			pBlockEntity.setStyleEast(false);
			pBlockEntity.setChanged();
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult removeLabelSouth(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelSouth(), pBlockEntity.getStyleSouth(), pBlockEntity.getColorSouth());
			this.playClearSound(pBlockPos, pLevel);
			pLevel.setBlock(pBlockPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, false).setValue(IcariaBlockStateProperties.LABEL_WEST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED)), 3);
			pBlockEntity.setColorSouth(0);
			pBlockEntity.setLabelSouth(null);
			pBlockEntity.setStyleSouth(false);
			pBlockEntity.setChanged();
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult removeLabelWest(IcariaChestBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.LABEL_WEST)) {
			this.dropLabel(pBlockPos, pDirection, pLevel, pBlockEntity.getLabelWest(), pBlockEntity.getStyleWest(), pBlockEntity.getColorWest());
			this.playClearSound(pBlockPos, pLevel);
			pLevel.setBlock(pBlockPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pBlockState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pBlockState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pBlockState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pBlockState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, false).setValue(BlockStateProperties.WATERLOGGED, pBlockState.getValue(BlockStateProperties.WATERLOGGED)), 3);
			pBlockEntity.setColorWest(0);
			pBlockEntity.setLabelWest(null);
			pBlockEntity.setStyleWest(false);
			pBlockEntity.setChanged();
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Nullable
	@Override
	public MenuProvider getMenuProvider(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return this.combine(pBlockState, pLevel, pBlockPos, false).apply(new IcariaChestBlockCombiner()).orElse(null);
	}
}
