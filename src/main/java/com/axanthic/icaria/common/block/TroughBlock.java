package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.block.entity.TroughBlockEntity;
import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaShapes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TroughBlock extends Block implements EntityBlock {
	public TroughBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pState) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
		return pState.getValue(IcariaBlockStateProperties.TROUGH_FILL);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.TROUGH, IcariaBlockStateProperties.TROUGH_FILL);
	}

	public void setStack(InteractionHand pHand, Item pItem, Player pPlayer) {
		if (!pPlayer.isCreative()) {
			pPlayer.setItemInHand(pHand, new ItemStack(pItem));
		}
	}

	public void shrinkStack(ItemStack pStack, Player pPlayer) {
		if (!pPlayer.isCreative()) {
			pStack.shrink(1);
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new TroughBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pResult) {
		var fill = pState.getValue(IcariaBlockStateProperties.TROUGH_FILL);
		var item = pPlayer.getItemInHand(pHand);

		if (fill < 9) {
			if (pStack.is(Items.WATER_BUCKET)) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.NONE) {
					pLevel.playSound(null, pPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, 9));
					pPlayer.awardStat(Stats.ITEM_USED.get(Items.WATER_BUCKET));
					this.setStack(pHand, Items.BUCKET, pPlayer);
					return ItemInteractionResult.CONSUME;
				}
			} else if (pStack.is(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get())) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.NONE) {
					pLevel.playSound(null, pPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.MEDITERRANEAN_WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, 9));
					pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()));
					this.setStack(pHand, Items.BUCKET, pPlayer);
					return ItemInteractionResult.CONSUME;
				}
			} else if (pStack.is(IcariaItems.ONION.get())) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.NONE || pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.ONION) {
					pLevel.playSound(null, pPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.ONION).setValue(IcariaBlockStateProperties.TROUGH_FILL, fill + 1));
					pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.ONION.get()));
					this.shrinkStack(item, pPlayer);
					return ItemInteractionResult.CONSUME;
				}
			} else if (pStack.is(IcariaItems.SPELT.get())) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.NONE || pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.SPELT) {
					pLevel.playSound(null, pPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.SPELT).setValue(IcariaBlockStateProperties.TROUGH_FILL, fill + 1));
					pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.SPELT.get()));
					this.shrinkStack(item, pPlayer);
					return ItemInteractionResult.CONSUME;
				}
			} else if (pStack.is(IcariaItems.VINEBERRIES.get())) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.NONE || pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.VINEBERRIES) {
					pLevel.playSound(null, pPos, IcariaSoundEvents.TROUGH_FILL, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.VINEBERRIES).setValue(IcariaBlockStateProperties.TROUGH_FILL, fill + 1));
					pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.VINEBERRIES.get()));
					this.shrinkStack(item, pPlayer);
					return ItemInteractionResult.CONSUME;
				}
			}
		} else {
			if (pStack.is(Items.BUCKET)) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.WATER) {
					pLevel.playSound(null, pPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0));
					pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
					this.setStack(pHand, Items.WATER_BUCKET, pPlayer);
					return ItemInteractionResult.CONSUME;
				} else if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.MEDITERRANEAN_WATER) {
					pLevel.playSound(null, pPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0));
					pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
					this.setStack(pHand, IcariaItems.MEDITERRANEAN_WATER_BUCKET.get(), pPlayer);
					return ItemInteractionResult.CONSUME;
				}
			}
		}

		if (fill > 3) {
			if (pStack.is(Items.GLASS_BOTTLE)) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.WATER) {
					pLevel.playSound(null, pPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, fill - 3));
					pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
					if (!pPlayer.isCreative()) {
						pPlayer.setItemInHand(pHand, PotionContents.createItemStack(Items.POTION, Potions.WATER));
					}
					return ItemInteractionResult.CONSUME;
				}
			}
		} else if (fill > 2) {
			if (pStack.is(Items.GLASS_BOTTLE)) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.WATER) {
					pLevel.playSound(null, pPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, 0));
					pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
					if (!pPlayer.isCreative()) {
						pPlayer.setItemInHand(pHand, PotionContents.createItemStack(Items.POTION, Potions.WATER));
					}
					return ItemInteractionResult.CONSUME;
				}
			}
		}

		if (fill < 7) {
			if (pStack.is(Items.POTION) && pStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER)) {
				if (pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.NONE || pState.getValue(IcariaBlockStateProperties.TROUGH) == Trough.WATER) {
					pLevel.playSound(null, pPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS);
					pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.TROUGH, Trough.WATER).setValue(IcariaBlockStateProperties.TROUGH_FILL, fill + 3));
					pPlayer.awardStat(Stats.ITEM_USED.get(Items.POTION));
					this.setStack(pHand, Items.GLASS_BOTTLE, pPlayer);
					return ItemInteractionResult.CONSUME;
				}
			}
		}

		return ItemInteractionResult.FAIL;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> IcariaShapes.TroughShapes.NORTH;
			case EAST -> IcariaShapes.TroughShapes.EAST;
			case SOUTH -> IcariaShapes.TroughShapes.SOUTH;
			default -> IcariaShapes.TroughShapes.WEST;
		};
	}
}
