package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliastrumVialItem extends Item {
	public HyliastrumVialItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		var stack = new ItemStack(IcariaItems.EMPTY_VIAL.get());
		var player = pContext.getPlayer();
		var level = pContext.getLevel();
		var entity = IcariaEntityTypes.HYLIASTER.get().create(level);
		if (player != null) {
			player.playSound(IcariaSoundEvents.VIAL_EMPTY);
			if (!level.isClientSide() && entity != null) {
				entity.moveTo(pContext.getClickedPos().relative(pContext.getClickedFace()), 0.0F, 0.0F);
				entity.setSize(1);
				level.addFreshEntity(entity);
				if (!player.isCreative()) {
					player.setItemInHand(player.getUsedItemHand(), stack);
				}
			}
		}

		return InteractionResult.SUCCESS;
	}
}
