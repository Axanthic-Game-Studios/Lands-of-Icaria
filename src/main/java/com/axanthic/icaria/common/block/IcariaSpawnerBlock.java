package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaSpawnerBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import com.mojang.serialization.MapCodec;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSpawnerBlock extends BaseEntityBlock {
	public static final MapCodec<IcariaSpawnerBlock> CODEC = Block.simpleCodec(IcariaSpawnerBlock::new);

	public IcariaSpawnerBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public int getExpDrop(BlockState pBlockState, LevelAccessor pLevelAccessor, BlockPos pBlockPos, @Nullable BlockEntity pBlockEntity, @Nullable Entity pEntity, ItemStack pItemStack) {
		return pLevelAccessor.getRandom().nextInt(15) + pLevelAccessor.getRandom().nextInt(15) + 15;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new IcariaSpawnerBlockEntity(pBlockPos, pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (pLevel instanceof ServerLevel serverLevel && itemStack.getItem() instanceof SpawnEggItem spawnEggItem && pLevel.getBlockEntity(pBlockPos) instanceof IcariaSpawnerBlockEntity blockEntity) {
			var entityType = spawnEggItem.getType(serverLevel.registryAccess(), itemStack);
			blockEntity.setChanged();
			blockEntity.setEntityId(entityType, pLevel.getRandom());
			itemStack.consume(1, pPlayer);
			pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pBlockPos);
			pLevel.sendBlockUpdated(pBlockPos, pBlockState, pBlockState, 3);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return IcariaSpawnerBlock.CODEC;
	}

	@Override
	public RenderShape getRenderShape(BlockState pBlockState) {
		return RenderShape.MODEL;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pBlockState, BlockEntityType<T> pBlockEntityType) {
		return BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.SPAWNER.get(), pLevel.isClientSide() ? IcariaSpawnerBlockEntity::clientTick : IcariaSpawnerBlockEntity::serverTick);
	}
}
