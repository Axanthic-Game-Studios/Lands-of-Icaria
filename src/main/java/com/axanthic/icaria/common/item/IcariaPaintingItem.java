package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.IcariaPaintingEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingItem extends HangingEntityItem {
	public IcariaPaintingItem(Properties pProperties) {
		super(IcariaEntityTypes.PAINTING.get(), pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		var direction = pContext.getClickedFace();
		var itemStack = pContext.getItemInHand();
		var level = pContext.getLevel();
		var player = pContext.getPlayer();
		var blockPos = pContext.getClickedPos().relative(direction);
		if (player != null && !this.mayPlace(player, direction, itemStack, blockPos)) {
			return InteractionResult.FAIL;
		}

		var optional = IcariaPaintingEntity.create(level, blockPos, direction);
		if (optional.isEmpty()) {
			return InteractionResult.CONSUME;
		}

		var painting = optional.get();
		if (painting.survives() && !level.isClientSide()) {
			itemStack.shrink(1);
			level.addFreshEntity(painting);
			level.gameEvent(player, GameEvent.ENTITY_PLACE, painting.position());
			painting.playPlacementSound();
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.CONSUME;
		}
	}
}
