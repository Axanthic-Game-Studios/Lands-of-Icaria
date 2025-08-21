package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.RugEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RugItem extends HangingEntityItem {
	public TagKey<PaintingVariant> tagKey;

	public RugItem(TagKey<PaintingVariant> pTagKey, Properties pProperties) {
		super(IcariaEntityTypes.RUG.get(), pProperties);
		this.setTagKey(pTagKey);
	}

	public void setTagKey(TagKey<PaintingVariant> pTagKey) {
		this.tagKey = pTagKey;
	}

	@Override
	public InteractionResult useOn(UseOnContext pUseOnContext) {
		var direction = pUseOnContext.getClickedFace();
		var horizontalDirection = pUseOnContext.getHorizontalDirection();
		var itemStack = pUseOnContext.getItemInHand();
		var level = pUseOnContext.getLevel();
		var player = pUseOnContext.getPlayer();
		var blockPos = pUseOnContext.getClickedPos().relative(direction);
		if (player != null && player.mayUseItemAt(blockPos, direction, itemStack)) {
			return this.handleAction(blockPos, direction, horizontalDirection, itemStack, level, player);
		} else {
			return InteractionResult.CONSUME;
		}
	}

	public InteractionResult handleAction(BlockPos pBlockPos, Direction pDirection, Direction pHorizontalDirection, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		var optional = RugEntity.create(pBlockPos, pDirection, pHorizontalDirection, new ItemStack(this), pLevel, this.getTagKey());
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

	public TagKey<PaintingVariant> getTagKey() {
		return this.tagKey;
	}
}
