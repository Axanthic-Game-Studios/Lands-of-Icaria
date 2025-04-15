package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.IcariaPaintingEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.context.UseOnContext;
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
		var optional = IcariaPaintingEntity.create(blockPos, direction, level);
		if (player != null && this.mayPlace(player, direction, itemStack, blockPos) && optional.isPresent() && optional.get().survives() && !level.isClientSide()) {
			itemStack.consume(1, player);
			level.addFreshEntity(optional.get());
			level.gameEvent(player, GameEvent.ENTITY_PLACE, optional.get().position());
			optional.get().playPlacementSound();
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.CONSUME;
		}
	}
}
