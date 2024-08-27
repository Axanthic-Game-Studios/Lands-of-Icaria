package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.block.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaChestBlockCombiner;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
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

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestBlock extends ChestBlock implements MediterraneanWaterloggedBlock {
	public IcariaChestBlock(Properties pProperties, Supplier<BlockEntityType<? extends ChestBlockEntity>> pBlockEntityType) {
		super(pProperties, pBlockEntityType);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.CHEST_TYPE, ChestType.SINGLE).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.LABEL_UP, false).setValue(IcariaBlockStateProperties.LABEL_NORTH, false).setValue(IcariaBlockStateProperties.LABEL_EAST, false).setValue(IcariaBlockStateProperties.LABEL_SOUTH, false).setValue(IcariaBlockStateProperties.LABEL_WEST, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, boolean pWillHarvest, FluidState pFluid) {
		if (pLevel.getBlockEntity(pPos) instanceof IcariaChestBlockEntity blockEntity) {
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelUp(), blockEntity.getColorUp(), blockEntity.getStyleUp(), IcariaBlockStateProperties.LABEL_UP);
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelNorth(), blockEntity.getColorNorth(), blockEntity.getStyleNorth(), IcariaBlockStateProperties.LABEL_NORTH);
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelEast(), blockEntity.getColorEast(), blockEntity.getStyleEast(), IcariaBlockStateProperties.LABEL_EAST);
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelSouth(), blockEntity.getColorSouth(), blockEntity.getStyleSouth(), IcariaBlockStateProperties.LABEL_SOUTH);
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelWest(), blockEntity.getColorWest(), blockEntity.getStyleWest(), IcariaBlockStateProperties.LABEL_WEST);
		}

		return super.onDestroyedByPlayer(pState, pLevel, pPos, pPlayer, pWillHarvest, pFluid);
	}

	@Override
	public void onBlockExploded(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion) {
		if (pLevel.getBlockEntity(pPos) instanceof IcariaChestBlockEntity blockEntity) {
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelUp(), blockEntity.getColorUp(), blockEntity.getStyleUp(), IcariaBlockStateProperties.LABEL_UP);
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelNorth(), blockEntity.getColorNorth(), blockEntity.getStyleNorth(), IcariaBlockStateProperties.LABEL_NORTH);
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelEast(), blockEntity.getColorEast(), blockEntity.getStyleEast(), IcariaBlockStateProperties.LABEL_EAST);
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelSouth(), blockEntity.getColorSouth(), blockEntity.getStyleSouth(), IcariaBlockStateProperties.LABEL_SOUTH);
			this.dropLabel(pPos, pState, pLevel, blockEntity.getLabelWest(), blockEntity.getColorWest(), blockEntity.getStyleWest(), IcariaBlockStateProperties.LABEL_WEST);
		}

		super.onBlockExploded(pState, pLevel, pPos, pExplosion);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.CHEST_TYPE, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.LABEL_UP, IcariaBlockStateProperties.LABEL_NORTH, IcariaBlockStateProperties.LABEL_EAST, IcariaBlockStateProperties.LABEL_SOUTH, IcariaBlockStateProperties.LABEL_WEST, BlockStateProperties.WATERLOGGED);
	}

	public void shrinkStack(boolean pCreative, ItemStack pStack) {
		if (!pCreative) {
			pStack.shrink(1);
		}
	}

	public void dropLabel(BlockPos pPos, Direction pDirection, Level pLevel, String pLabel, int pColor, boolean pStyle) {
		var itemStack = new ItemStack(IcariaItems.CHEST_LABEL.get());
		itemStack.set(IcariaDataComponents.COLOR, pColor);
		itemStack.set(IcariaDataComponents.LABEL, pLabel);
		itemStack.set(IcariaDataComponents.STYLE, pStyle);
		Block.popResourceFromFace(pLevel, pPos, pDirection, itemStack);
	}

	public void dropLabel(BlockPos pPos, BlockState pState, Level pLevel, String pLabel, int pColor, boolean pStyle, BooleanProperty pProperty) {
		var itemStack = new ItemStack(IcariaItems.CHEST_LABEL.get());
		if (pState.getValue(pProperty)) {
			itemStack.set(IcariaDataComponents.COLOR, pColor);
			itemStack.set(IcariaDataComponents.LABEL, pLabel);
			itemStack.set(IcariaDataComponents.STYLE, pStyle);
			Block.popResource(pLevel, pPos, itemStack);
		}
	}

	public void playApplySound(Level pLevel, BlockPos pPos) {
		pLevel.playSound(null, pPos, IcariaSoundEvents.CHEST_LABEL_APPLY, SoundSource.BLOCKS);
	}

	public void playClearSound(Level pLevel, BlockPos pPos) {
		pLevel.playSound(null, pPos, IcariaSoundEvents.CHEST_LABEL_CLEAR, SoundSource.BLOCKS);
	}

	public void playDyeSound(Level pLevel, BlockPos pPos) {
		pLevel.playSound(null, pPos, SoundEvents.DYE_USE, SoundSource.BLOCKS);
	}

	public void playInkSacSound(Level pLevel, BlockPos pPos) {
		pLevel.playSound(null, pPos, SoundEvents.INK_SAC_USE, SoundSource.BLOCKS);
	}

	public void playGlowInkSacSound(Level pLevel, BlockPos pPos) {
		pLevel.playSound(null, pPos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new IcariaChestBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return super.getStateForPlacement(pContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == IcariaFluids.MEDITERRANEAN_WATER.get());
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pState);
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pResult) {
		var creative = pPlayer.isCreative();
		var direction = pResult.getDirection();
		var stack = pPlayer.getItemInHand(pHand);

		var color = stack.getOrDefault(IcariaDataComponents.COLOR, 0);
		var label = stack.getOrDefault(IcariaDataComponents.LABEL, "");
		var style = stack.getOrDefault(IcariaDataComponents.STYLE, false);

		if (pLevel.getBlockEntity(pPos) instanceof IcariaChestBlockEntity blockEntity) {
			if (!blockEntity.getWaxed()) {
				if (stack.is(IcariaItems.CHEST_LABEL.get())) {
					if (direction.equals(Direction.UP)) {
						if (!pState.getValue(IcariaBlockStateProperties.LABEL_UP)) {
							this.playApplySound(pLevel, pPos);
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, true).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorUp(color);
							blockEntity.setLabelUp(label);
							blockEntity.setStyleUp(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						} else if (!color.equals(blockEntity.getColorUp()) || !label.equals(blockEntity.getLabelUp()) || !style.equals(blockEntity.getStyleUp())) {
							this.playApplySound(pLevel, pPos);
							this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelUp(), blockEntity.getColorUp(), blockEntity.getStyleUp());
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, true).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorUp(color);
							blockEntity.setLabelUp(label);
							blockEntity.setStyleUp(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						}
					} else if (direction.equals(Direction.NORTH)) {
						if (!pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)) {
							this.playApplySound(pLevel, pPos);
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, true).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorNorth(color);
							blockEntity.setLabelNorth(label);
							blockEntity.setStyleNorth(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						} else if (!color.equals(blockEntity.getColorNorth()) || !label.equals(blockEntity.getLabelNorth()) || !style.equals(blockEntity.getStyleNorth())) {
							this.playApplySound(pLevel, pPos);
							this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelNorth(), blockEntity.getColorNorth(), blockEntity.getStyleNorth());
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, true).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorNorth(color);
							blockEntity.setLabelNorth(label);
							blockEntity.setStyleNorth(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						}
					} else if (direction.equals(Direction.EAST)) {
						if (!pState.getValue(IcariaBlockStateProperties.LABEL_EAST)) {
							this.playApplySound(pLevel, pPos);
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, true).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorEast(color);
							blockEntity.setLabelEast(label);
							blockEntity.setStyleEast(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						} else if (!color.equals(blockEntity.getColorEast()) || !label.equals(blockEntity.getLabelEast()) || !style.equals(blockEntity.getStyleEast())) {
							this.playApplySound(pLevel, pPos);
							this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelEast(), blockEntity.getColorEast(), blockEntity.getStyleEast());
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, true).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorEast(color);
							blockEntity.setLabelEast(label);
							blockEntity.setStyleEast(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						}
					} else if (direction.equals(Direction.SOUTH)) {
						if (!pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)) {
							this.playApplySound(pLevel, pPos);
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, true).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorSouth(color);
							blockEntity.setLabelSouth(label);
							blockEntity.setStyleSouth(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						} else if (!color.equals(blockEntity.getColorSouth()) || !label.equals(blockEntity.getLabelSouth()) || !style.equals(blockEntity.getStyleSouth())) {
							this.playApplySound(pLevel, pPos);
							this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelSouth(), blockEntity.getColorSouth(), blockEntity.getStyleSouth());
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, true).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorSouth(color);
							blockEntity.setLabelSouth(label);
							blockEntity.setStyleSouth(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						}
					} else if (direction.equals(Direction.WEST)) {
						if (!pState.getValue(IcariaBlockStateProperties.LABEL_WEST)) {
							this.playApplySound(pLevel, pPos);
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, true).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorWest(color);
							blockEntity.setLabelWest(label);
							blockEntity.setStyleWest(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						} else if (!color.equals(blockEntity.getColorWest()) || !label.equals(blockEntity.getLabelWest()) || !style.equals(blockEntity.getStyleWest())) {
							this.playApplySound(pLevel, pPos);
							this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelWest(), blockEntity.getColorWest(), blockEntity.getStyleWest());
							this.shrinkStack(creative, stack);
							pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, true).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setColorWest(color);
							blockEntity.setLabelWest(label);
							blockEntity.setStyleWest(style);
							blockEntity.setChanged();
							return ItemInteractionResult.CONSUME;
						}
					}
				} else if (stack.getItem() instanceof DyeItem dyeItem) {
					if (direction.equals(Direction.UP)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_UP)) {
							if (dyeItem.getDyeColor().getTextColor() != blockEntity.getColorUp()) {
								this.shrinkStack(creative, stack);
								this.playDyeSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(dyeItem));
								blockEntity.setColorUp(dyeItem.getDyeColor().getTextColor());
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.NORTH)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)) {
							if (dyeItem.getDyeColor().getTextColor() != blockEntity.getColorNorth()) {
								this.shrinkStack(creative, stack);
								this.playDyeSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(dyeItem));
								blockEntity.setColorNorth(dyeItem.getDyeColor().getTextColor());
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.EAST)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_EAST)) {
							if (dyeItem.getDyeColor().getTextColor() != blockEntity.getColorEast()) {
								this.shrinkStack(creative, stack);
								this.playDyeSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(dyeItem));
								blockEntity.setColorEast(dyeItem.getDyeColor().getTextColor());
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.SOUTH)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)) {
							if (dyeItem.getDyeColor().getTextColor() != blockEntity.getColorSouth()) {
								this.shrinkStack(creative, stack);
								this.playDyeSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(dyeItem));
								blockEntity.setColorSouth(dyeItem.getDyeColor().getTextColor());
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.WEST)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_WEST)) {
							if (dyeItem.getDyeColor().getTextColor() != blockEntity.getColorWest()) {
								this.shrinkStack(creative, stack);
								this.playDyeSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(dyeItem));
								blockEntity.setColorWest(dyeItem.getDyeColor().getTextColor());
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					}
				} else if (stack.is(Items.INK_SAC)) {
					if (direction.equals(Direction.UP)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_UP)) {
							if (blockEntity.getStyleUp()) {
								this.shrinkStack(creative, stack);
								this.playInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleUp(false);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.NORTH)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)) {
							if (blockEntity.getStyleNorth()) {
								this.shrinkStack(creative, stack);
								this.playInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleNorth(false);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.EAST)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_EAST)) {
							if (blockEntity.getStyleEast()) {
								this.shrinkStack(creative, stack);
								this.playInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleEast(false);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.SOUTH)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)) {
							if (blockEntity.getStyleSouth()) {
								this.shrinkStack(creative, stack);
								this.playInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleSouth(false);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.WEST)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_WEST)) {
							if (blockEntity.getStyleWest()) {
								this.shrinkStack(creative, stack);
								this.playInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleWest(false);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					}
				} else if (stack.is(Items.GLOW_INK_SAC)) {
					if (direction.equals(Direction.UP)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_UP)) {
							if (!blockEntity.getStyleUp()) {
								this.shrinkStack(creative, stack);
								this.playGlowInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleUp(true);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.NORTH)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)) {
							if (!blockEntity.getStyleNorth()) {
								this.shrinkStack(creative, stack);
								this.playGlowInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleNorth(true);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.EAST)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_EAST)) {
							if (!blockEntity.getStyleEast()) {
								this.shrinkStack(creative, stack);
								this.playGlowInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleEast(true);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.SOUTH)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)) {
							if (!blockEntity.getStyleSouth()) {
								this.shrinkStack(creative, stack);
								this.playGlowInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleSouth(true);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					} else if (direction.equals(Direction.WEST)) {
						if (pState.getValue(IcariaBlockStateProperties.LABEL_WEST)) {
							if (!blockEntity.getStyleWest()) {
								this.shrinkStack(creative, stack);
								this.playGlowInkSacSound(pLevel, pPos);
								pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLOW_INK_SAC));
								blockEntity.setStyleWest(true);
								blockEntity.setChanged();
								return ItemInteractionResult.CONSUME;
							}
						}
					}
				} else if (stack.is(Items.HONEYCOMB)) {
					pLevel.levelEvent(null, 3003, pPos, 0);
					blockEntity.setWaxed(true);
					blockEntity.setChanged();
					return ItemInteractionResult.CONSUME;
				} else if (stack.isEmpty()) {
					if (pPlayer.isShiftKeyDown()) {
						if (direction.equals(Direction.UP)) {
							if (pState.getValue(IcariaBlockStateProperties.LABEL_UP)) {
								this.playClearSound(pLevel, pPos);
								this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelUp(), blockEntity.getColorUp(), blockEntity.getStyleUp());
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, false).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setColorUp(0);
								blockEntity.setLabelUp(null);
								blockEntity.setStyleUp(false);
								blockEntity.setChanged();
							}
						} else if (direction.equals(Direction.NORTH)) {
							if (pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)) {
								this.playClearSound(pLevel, pPos);
								this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelNorth(), blockEntity.getColorNorth(), blockEntity.getStyleNorth());
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, false).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setColorNorth(0);
								blockEntity.setLabelNorth(null);
								blockEntity.setStyleNorth(false);
								blockEntity.setChanged();
							}
						} else if (direction.equals(Direction.EAST)) {
							if (pState.getValue(IcariaBlockStateProperties.LABEL_EAST)) {
								this.playClearSound(pLevel, pPos);
								this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelEast(), blockEntity.getColorEast(), blockEntity.getStyleEast());
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, false).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setColorEast(0);
								blockEntity.setLabelEast(null);
								blockEntity.setStyleEast(false);
								blockEntity.setChanged();
							}
						} else if (direction.equals(Direction.SOUTH)) {
							if (pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)) {
								this.playClearSound(pLevel, pPos);
								this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelSouth(), blockEntity.getColorSouth(), blockEntity.getStyleSouth());
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, false).setValue(IcariaBlockStateProperties.LABEL_WEST, pState.getValue(IcariaBlockStateProperties.LABEL_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setColorSouth(0);
								blockEntity.setLabelSouth(null);
								blockEntity.setStyleSouth(false);
								blockEntity.setChanged();
							}
						} else if (direction.equals(Direction.WEST)) {
							if (pState.getValue(IcariaBlockStateProperties.LABEL_WEST)) {
								this.playClearSound(pLevel, pPos);
								this.dropLabel(pPos, direction, pLevel, blockEntity.getLabelWest(), blockEntity.getColorWest(), blockEntity.getStyleWest());
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.LABEL_UP, pState.getValue(IcariaBlockStateProperties.LABEL_UP)).setValue(IcariaBlockStateProperties.LABEL_NORTH, pState.getValue(IcariaBlockStateProperties.LABEL_NORTH)).setValue(IcariaBlockStateProperties.LABEL_EAST, pState.getValue(IcariaBlockStateProperties.LABEL_EAST)).setValue(IcariaBlockStateProperties.LABEL_SOUTH, pState.getValue(IcariaBlockStateProperties.LABEL_SOUTH)).setValue(IcariaBlockStateProperties.LABEL_WEST, false).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setColorWest(0);
								blockEntity.setLabelWest(null);
								blockEntity.setStyleWest(false);
								blockEntity.setChanged();
							}
						}

						return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
					}
				}
			}
		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
		return this.combine(pState, pLevel, pPos, false).apply(new IcariaChestBlockCombiner()).orElse(null);
	}
}
