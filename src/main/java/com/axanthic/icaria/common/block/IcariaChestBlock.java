package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.block.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaChestBlockCombiner;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.CHEST_TYPE, ChestType.SINGLE).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.TEXT_UP, false).setValue(IcariaBlockStateProperties.TEXT_NORTH, false).setValue(IcariaBlockStateProperties.TEXT_EAST, false).setValue(IcariaBlockStateProperties.TEXT_SOUTH, false).setValue(IcariaBlockStateProperties.TEXT_WEST, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, boolean pWillHarvest, FluidState pFluid) {
		if (pLevel.getBlockEntity(pPos) instanceof IcariaChestBlockEntity blockEntity) {
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextUp(), IcariaBlockStateProperties.TEXT_UP);
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextNorth(), IcariaBlockStateProperties.TEXT_NORTH);
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextEast(), IcariaBlockStateProperties.TEXT_EAST);
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextSouth(), IcariaBlockStateProperties.TEXT_SOUTH);
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextWest(), IcariaBlockStateProperties.TEXT_WEST);
		}

		return super.onDestroyedByPlayer(pState, pLevel, pPos, pPlayer, pWillHarvest, pFluid);
	}

	@Override
	public void onBlockExploded(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion) {
		if (pLevel.getBlockEntity(pPos) instanceof IcariaChestBlockEntity blockEntity) {
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextUp(), IcariaBlockStateProperties.TEXT_UP);
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextNorth(), IcariaBlockStateProperties.TEXT_NORTH);
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextEast(), IcariaBlockStateProperties.TEXT_EAST);
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextSouth(), IcariaBlockStateProperties.TEXT_SOUTH);
			this.dropLabel(pLevel, pPos, pState, blockEntity.getTextWest(), IcariaBlockStateProperties.TEXT_WEST);
		}

		super.onBlockExploded(pState, pLevel, pPos, pExplosion);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.CHEST_TYPE, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.TEXT_UP, IcariaBlockStateProperties.TEXT_NORTH, IcariaBlockStateProperties.TEXT_EAST, IcariaBlockStateProperties.TEXT_SOUTH, IcariaBlockStateProperties.TEXT_WEST, BlockStateProperties.WATERLOGGED);
	}

	public void decrStack(boolean pCreative, ItemStack pStack) {
		if (!pCreative) {
			pStack.shrink(1);
		}
	}

	public void dropLabel(Direction pDirection, Level pLevel, BlockPos pPos, String pString) {
		var itemStack = new ItemStack(IcariaItems.CHEST_LABEL.get());
		if (pString.isEmpty()) {
			Block.popResourceFromFace(pLevel, pPos, pDirection, itemStack);
		} else {
			itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(pString));
			Block.popResourceFromFace(pLevel, pPos, pDirection, itemStack);
		}
	}

	public void dropLabel(Level pLevel, BlockPos pPos, BlockState pState, String pString, BooleanProperty pProperty) {
		var itemStack = new ItemStack(IcariaItems.CHEST_LABEL.get());
		if (pState.getValue(pProperty)) {
			if (pString.isEmpty()) {
				Block.popResource(pLevel, pPos, itemStack);
			} else {
				itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(pString));
				Block.popResource(pLevel, pPos, itemStack);
			}
		}
	}

	public void playSound(Level pLevel, BlockPos pPos) {
		pLevel.playSound(null, pPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS);
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
		var empty = Component.empty().getString();
		var direction = pResult.getDirection();
		var stack = pPlayer.getItemInHand(pHand);
		var creative = pPlayer.isCreative();
		var name = stack.getHoverName();
		var string = name.getString();
		if (pPlayer.isShiftKeyDown()) {
			if (pLevel.getBlockEntity(pPos) instanceof IcariaChestBlockEntity blockEntity) {
				if (stack.is(IcariaItems.CHEST_LABEL.get())) {
					if (stack.get(DataComponents.CUSTOM_NAME) != null) {
						if (string.length() <= 12) {
							if (direction.equals(Direction.UP)) {
								if (!pState.getValue(IcariaBlockStateProperties.TEXT_UP)) {
									this.playSound(pLevel, pPos);
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, true).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextUp(string);
									blockEntity.setChanged();
								} else if (!string.equals(blockEntity.getTextUp())) {
									this.playSound(pLevel, pPos);
									this.dropLabel(direction, pLevel, pPos, blockEntity.getTextUp());
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, true).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextUp(string);
									blockEntity.setChanged();
								}
							} else if (direction.equals(Direction.NORTH)) {
								if (!pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)) {
									this.playSound(pLevel, pPos);
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, true).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextNorth(string);
									blockEntity.setChanged();
								} else if (!string.equals(blockEntity.getTextNorth())) {
									this.playSound(pLevel, pPos);
									this.dropLabel(direction, pLevel, pPos, blockEntity.getTextNorth());
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, true).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextNorth(string);
									blockEntity.setChanged();
								}
							} else if (direction.equals(Direction.EAST)) {
								if (!pState.getValue(IcariaBlockStateProperties.TEXT_EAST)) {
									this.playSound(pLevel, pPos);
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, true).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextEast(string);
									blockEntity.setChanged();
								} else if (!string.equals(blockEntity.getTextEast())) {
									this.playSound(pLevel, pPos);
									this.dropLabel(direction, pLevel, pPos, blockEntity.getTextEast());
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, true).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextEast(string);
									blockEntity.setChanged();
								}
							} else if (direction.equals(Direction.SOUTH)) {
								if (!pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)) {
									this.playSound(pLevel, pPos);
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, true).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextSouth(string);
									blockEntity.setChanged();
								} else if (!string.equals(blockEntity.getTextSouth())) {
									this.playSound(pLevel, pPos);
									this.dropLabel(direction, pLevel, pPos, blockEntity.getTextSouth());
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, true).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextSouth(string);
									blockEntity.setChanged();
								}
							} else if (direction.equals(Direction.WEST)) {
								if (!pState.getValue(IcariaBlockStateProperties.TEXT_WEST)) {
									this.playSound(pLevel, pPos);
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, true).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextWest(string);
									blockEntity.setChanged();
								} else if (!string.equals(blockEntity.getTextWest())) {
									this.playSound(pLevel, pPos);
									this.dropLabel(direction, pLevel, pPos, blockEntity.getTextWest());
									this.decrStack(creative, stack);
									pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
									pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, true).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
									blockEntity.setTextWest(string);
									blockEntity.setChanged();
								}
							}
						} else {
							pPlayer.displayClientMessage(Component.translatable("message" + "." + IcariaIdents.ID + "." + "chest_label"), true);
						}
					} else {
						if (direction.equals(Direction.UP)) {
							if (!pState.getValue(IcariaBlockStateProperties.TEXT_UP)) {
								this.playSound(pLevel, pPos);
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, true).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextUp(empty);
								blockEntity.setChanged();
							} else if (!empty.equals(blockEntity.getTextUp())) {
								this.playSound(pLevel, pPos);
								this.dropLabel(direction, pLevel, pPos, blockEntity.getTextUp());
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, true).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextUp(empty);
								blockEntity.setChanged();
							}
						} else if (direction.equals(Direction.NORTH)) {
							if (!pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)) {
								this.playSound(pLevel, pPos);
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, true).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextNorth(empty);
								blockEntity.setChanged();
							} else if (!empty.equals(blockEntity.getTextNorth())) {
								this.playSound(pLevel, pPos);
								this.dropLabel(direction, pLevel, pPos, blockEntity.getTextNorth());
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, true).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextNorth(empty);
								blockEntity.setChanged();
							}
						} else if (direction.equals(Direction.EAST)) {
							if (!pState.getValue(IcariaBlockStateProperties.TEXT_EAST)) {
								this.playSound(pLevel, pPos);
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, true).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextEast(empty);
								blockEntity.setChanged();
							} else if (!empty.equals(blockEntity.getTextEast())) {
								this.playSound(pLevel, pPos);
								this.dropLabel(direction, pLevel, pPos, blockEntity.getTextEast());
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, true).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextEast(empty);
								blockEntity.setChanged();
							}
						} else if (direction.equals(Direction.SOUTH)) {
							if (!pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)) {
								this.playSound(pLevel, pPos);
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, true).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextSouth(empty);
								blockEntity.setChanged();
							} else if (!empty.equals(blockEntity.getTextSouth())) {
								this.playSound(pLevel, pPos);
								this.dropLabel(direction, pLevel, pPos, blockEntity.getTextSouth());
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, true).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextSouth(empty);
								blockEntity.setChanged();
							}
						} else if (direction.equals(Direction.WEST)) {
							if (!pState.getValue(IcariaBlockStateProperties.TEXT_WEST)) {
								this.playSound(pLevel, pPos);
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, true).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextWest(empty);
								blockEntity.setChanged();
							} else if (!empty.equals(blockEntity.getTextWest())) {
								this.playSound(pLevel, pPos);
								this.dropLabel(direction, pLevel, pPos, blockEntity.getTextWest());
								this.decrStack(creative, stack);
								pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.CHEST_LABEL.get()));
								pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, true).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
								blockEntity.setTextWest(empty);
								blockEntity.setChanged();
							}
						}
					}
				} else if (stack.isEmpty()) {
					if (direction.equals(Direction.UP)) {
						if (pState.getValue(IcariaBlockStateProperties.TEXT_UP)) {
							this.playSound(pLevel, pPos);
							this.dropLabel(direction, pLevel, pPos, blockEntity.getTextUp());
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, false).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setTextUp(null);
							blockEntity.setChanged();
						}
					} else if (direction.equals(Direction.NORTH)) {
						if (pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)) {
							this.playSound(pLevel, pPos);
							this.dropLabel(direction, pLevel, pPos, blockEntity.getTextNorth());
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, false).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setTextNorth(null);
							blockEntity.setChanged();
						}
					} else if (direction.equals(Direction.EAST)) {
						if (pState.getValue(IcariaBlockStateProperties.TEXT_EAST)) {
							this.playSound(pLevel, pPos);
							this.dropLabel(direction, pLevel, pPos, blockEntity.getTextEast());
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, false).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setTextEast(null);
							blockEntity.setChanged();
						}
					} else if (direction.equals(Direction.SOUTH)) {
						if (pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)) {
							this.playSound(pLevel, pPos);
							this.dropLabel(direction, pLevel, pPos, blockEntity.getTextSouth());
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, false).setValue(IcariaBlockStateProperties.TEXT_WEST, pState.getValue(IcariaBlockStateProperties.TEXT_WEST)).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setTextSouth(null);
							blockEntity.setChanged();
						}
					} else if (direction.equals(Direction.WEST)) {
						if (pState.getValue(IcariaBlockStateProperties.TEXT_WEST)) {
							this.playSound(pLevel, pPos);
							this.dropLabel(direction, pLevel, pPos, blockEntity.getTextWest());
							pLevel.setBlock(pPos, this.defaultBlockState().setValue(BlockStateProperties.CHEST_TYPE, pState.getValue(BlockStateProperties.CHEST_TYPE)).setValue(BlockStateProperties.HORIZONTAL_FACING, pState.getValue(BlockStateProperties.HORIZONTAL_FACING)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(IcariaBlockStateProperties.TEXT_UP, pState.getValue(IcariaBlockStateProperties.TEXT_UP)).setValue(IcariaBlockStateProperties.TEXT_NORTH, pState.getValue(IcariaBlockStateProperties.TEXT_NORTH)).setValue(IcariaBlockStateProperties.TEXT_EAST, pState.getValue(IcariaBlockStateProperties.TEXT_EAST)).setValue(IcariaBlockStateProperties.TEXT_SOUTH, pState.getValue(IcariaBlockStateProperties.TEXT_SOUTH)).setValue(IcariaBlockStateProperties.TEXT_WEST, false).setValue(BlockStateProperties.WATERLOGGED, pState.getValue(BlockStateProperties.WATERLOGGED)), 3);
							blockEntity.setTextWest(null);
							blockEntity.setChanged();
						}
					}
				}
			}
			return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
		} else {
			return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pResult);
		}
	}

	@Override
	public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
		return this.combine(pState, pLevel, pPos, false).apply(new IcariaChestBlockCombiner()).orElse(null);
	}
}
