package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.BathtubBlockEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.properties.Bathtub;
import com.axanthic.icaria.common.properties.Part;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.shapes.BathtubShapes;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BathtubBlock extends Block implements EntityBlock {
	public BathtubBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.BATHTUB, Bathtub.NONE).setValue(IcariaBlockStateProperties.BATHTUB_FILL, 0).setValue(IcariaBlockStateProperties.BATHTUB_REMAINS, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pBlockState.getValue(IcariaBlockStateProperties.BATHTUB_FILL);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.BATHTUB, IcariaBlockStateProperties.BATHTUB_FILL, IcariaBlockStateProperties.BATHTUB_REMAINS, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.PART);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(BathtubBlock.getPlacedBlockPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		pLevel.setBlock(pBlockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.relative(pDirection.getOpposite()), Blocks.AIR.defaultBlockState(), 3);
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		pLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.PART, Part.FOOT), 3);
		pLevel.setBlock(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()), pBlockState.setValue(IcariaBlockStateProperties.PART, Part.HEAD), 3);
	}

	public void update(Bathtub pBathtub, BlockPos pBlockPos, BlockState pBlockState, Level pLevel, int i) {
		if (pBlockState.getValue(IcariaBlockStateProperties.PART) == Part.HEAD) {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.BATHTUB, pBathtub).setValue(IcariaBlockStateProperties.BATHTUB_FILL, i).setValue(IcariaBlockStateProperties.PART, Part.HEAD));
			pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)), pBlockState.setValue(IcariaBlockStateProperties.BATHTUB, pBathtub).setValue(IcariaBlockStateProperties.BATHTUB_FILL, i).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
		} else {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.BATHTUB, pBathtub).setValue(IcariaBlockStateProperties.BATHTUB_FILL, i).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
			pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()), pBlockState.setValue(IcariaBlockStateProperties.BATHTUB, pBathtub).setValue(IcariaBlockStateProperties.BATHTUB_FILL, i).setValue(IcariaBlockStateProperties.PART, Part.HEAD));
		}
	}

	public void update(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.PART) == Part.HEAD) {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.BATHTUB_REMAINS, true).setValue(IcariaBlockStateProperties.PART, Part.HEAD));
			pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)), pBlockState.setValue(IcariaBlockStateProperties.BATHTUB_REMAINS, true).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
		} else {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.BATHTUB_REMAINS, true).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
			pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()), pBlockState.setValue(IcariaBlockStateProperties.BATHTUB_REMAINS, true).setValue(IcariaBlockStateProperties.PART, Part.HEAD));
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new BathtubBlockEntity(pBlockPos, pBlockState);
	}

	public static BlockPos getPlacedBlockPosition(BlockPos pBlockPos, BlockState pBlockState) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (pBlockState.getValue(IcariaBlockStateProperties.PART) == Part.HEAD) {
			return pBlockPos.relative(direction);
		} else {
			return pBlockPos;
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		if (blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos.relative(pBlockPlaceContext.getHorizontalDirection())).canBeReplaced()) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.drop(pBlockPos, pBlockState, pLevel);
		this.removeMultiBlock(BathtubBlock.getPlacedBlockPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.is(IcariaItems.SURFACE_BONES.get()) || pItemStack.is(IcariaItems.REVENANT_SKULL.get())) {
			return this.useItemOn(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else {
			return this.useItemOn(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer);
		}
	}

	public InteractionResult useItemOn(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (!pBlockState.getValue(IcariaBlockStateProperties.BATHTUB_REMAINS)) {
			return this.skeleton(pBlockPos, pBlockState, pItemStack, pLevel, pPlayer);
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult useItemOn(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var fill = pBlockState.getValue(IcariaBlockStateProperties.BATHTUB_FILL);
		if (pBlockState.getValue(IcariaBlockStateProperties.BATHTUB) == Bathtub.NONE) {
			return this.fill(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.BATHTUB) == Bathtub.POWDER_SNOW) {
			return this.powderSnow(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer, fill);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.BATHTUB) == Bathtub.WATER) {
			return this.water(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer, fill);
		} else if (pBlockState.getValue(IcariaBlockStateProperties.BATHTUB) == Bathtub.MEDITERRANEAN_WATER) {
			return this.mediterraneanWater(pBlockPos, pBlockState, pInteractionHand, pItemStack, pLevel, pPlayer, fill);
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult skeleton(BlockPos pBlockPos, BlockState pBlockState, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pItemStack.is(IcariaItems.SURFACE_BONES.get())) {
			pItemStack.consume(1, pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BONE_BLOCK_PLACE, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.SURFACE_BONES.get()));
			this.update(pBlockPos, pBlockState, pLevel);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(IcariaItems.REVENANT_SKULL.get())) {
			pItemStack.consume(1, pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.REVENANT_SKULL.get()));
			this.update(pBlockPos, pBlockState, pLevel);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult fill(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pItemStack.is(Items.POWDER_SNOW_BUCKET)) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.POWDER_SNOW_BUCKET));
			this.update(Bathtub.POWDER_SNOW, pBlockPos, pBlockState, pLevel, 6);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.WATER_BUCKET)) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.WATER_BUCKET));
			this.update(Bathtub.WATER, pBlockPos, pBlockState, pLevel, 6);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get())) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()));
			this.update(Bathtub.MEDITERRANEAN_WATER, pBlockPos, pBlockState, pLevel, 6);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.POTION) && pItemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER)) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.GLASS_BOTTLE), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.POTION));
			this.update(Bathtub.WATER, pBlockPos, pBlockState, pLevel, 3);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult powderSnow(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer, int pFill) {
		if (pItemStack.is(Items.POWDER_SNOW_BUCKET) && pFill == 6) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.POWDER_SNOW_BUCKET));
			this.update(Bathtub.POWDER_SNOW, pBlockPos, pBlockState, pLevel, 12);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.BUCKET) && pFill == 12) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.POWDER_SNOW_BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL_POWDER_SNOW, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			this.update(Bathtub.POWDER_SNOW, pBlockPos, pBlockState, pLevel, 6);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.BUCKET) && pFill == 6) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.POWDER_SNOW_BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL_POWDER_SNOW, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			this.update(Bathtub.NONE, pBlockPos, pBlockState, pLevel, 0);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult water(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer, int pFill) {
		if (pItemStack.is(Items.WATER_BUCKET) && pFill <= 6) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.WATER_BUCKET));
			this.update(Bathtub.WATER, pBlockPos, pBlockState, pLevel, pFill + 6);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.BUCKET) && pFill >= 9) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.WATER_BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			this.update(Bathtub.WATER, pBlockPos, pBlockState, pLevel, pFill - 6);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.BUCKET) && pFill == 6) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.WATER_BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			this.update(Bathtub.NONE, pBlockPos, pBlockState, pLevel, 0);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.POTION) && pItemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER) && pFill <= 9) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.GLASS_BOTTLE), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.POTION));
			this.update(Bathtub.WATER, pBlockPos, pBlockState, pLevel, pFill + 3);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.GLASS_BOTTLE) && pFill >= 6) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, PotionContents.createItemStack(Items.POTION, Potions.WATER), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
			this.update(Bathtub.WATER, pBlockPos, pBlockState, pLevel, pFill - 3);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.GLASS_BOTTLE) && pFill == 3) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, PotionContents.createItemStack(Items.POTION, Potions.WATER), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
			this.update(Bathtub.NONE, pBlockPos, pBlockState, pLevel, 0);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult mediterraneanWater(BlockPos pBlockPos, BlockState pBlockState, InteractionHand pInteractionHand, ItemStack pItemStack, Level pLevel, Player pPlayer, int pFill) {
		if (pItemStack.is(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()) && pFill == 6) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(Items.BUCKET), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()));
			this.update(Bathtub.MEDITERRANEAN_WATER, pBlockPos, pBlockState, pLevel, 12);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.BUCKET) && pFill == 12) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			this.update(Bathtub.MEDITERRANEAN_WATER, pBlockPos, pBlockState, pLevel, 6);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.is(Items.BUCKET) && pFill == 6) {
			IcariaCommonHelper.setItemInHand(pInteractionHand, new ItemStack(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get()), pPlayer);
			pLevel.playSound(null, pBlockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
			pPlayer.awardStat(Stats.ITEM_USED.get(Items.BUCKET));
			this.update(Bathtub.NONE, pBlockPos, pBlockState, pLevel, 0);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pLevel, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.PART)) {
			case HEAD -> this.getHead(pBlockState);
			case FOOT -> this.getFoot(pBlockState);
		};
	}

	public VoxelShape getHead(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> BathtubShapes.HEAD_NORTH;
			case EAST -> BathtubShapes.HEAD_EAST;
			case SOUTH -> BathtubShapes.HEAD_SOUTH;
			default -> BathtubShapes.HEAD_WEST;
		};
	}

	public VoxelShape getFoot(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> BathtubShapes.FOOT_NORTH;
			case EAST -> BathtubShapes.FOOT_EAST;
			case SOUTH -> BathtubShapes.FOOT_SOUTH;
			default -> BathtubShapes.FOOT_WEST;
		};
	}
}
