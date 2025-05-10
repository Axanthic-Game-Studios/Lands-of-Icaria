package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.IcariaPaintingEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingItem extends HangingEntityItem {
	public IcariaPaintingItem(Properties pProperties) {
		super(IcariaEntityTypes.PAINTING.get(), pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pUseOnContext) {
		var direction = pUseOnContext.getClickedFace();
		var itemStack = pUseOnContext.getItemInHand();
		var level = pUseOnContext.getLevel();
		var player = pUseOnContext.getPlayer();
		var blockPos = pUseOnContext.getClickedPos().relative(direction);
		if (player != null && this.mayPlace(player, direction, itemStack, blockPos)) {
			return this.handleAction(blockPos, direction, itemStack, level, player);
		} else {
			return InteractionResult.CONSUME;
		}
	}

	public InteractionResult handleAction(BlockPos pBlockPos, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var optional = IcariaPaintingEntity.create(pBlockPos, pDirection, pLevel);
		if (optional.isPresent() && optional.get().survives() && !pLevel.isClientSide()) {
			pItemStack.consume(1, pPlayer);
			pLevel.addFreshEntity(optional.get());
			pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, optional.get().position());
			optional.get().playPlacementSound();
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.CONSUME;
		}
	}
}
