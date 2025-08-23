package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliastrumVialItem extends VialItem {
	public HyliastrumVialItem(Properties pProperties) {
		super(pProperties);
	}

	public void handleAction(UseOnContext pUseOnContext) {
		var player = pUseOnContext.getPlayer();
		var level = pUseOnContext.getLevel();
		var entity = IcariaEntityTypes.HYLIASTER.get().create(level, EntitySpawnReason.SPAWN_ITEM_USE);
		if (!level.isClientSide() && entity != null && player != null) {
			IcariaCommonHelper.setItemInHand(player.getUsedItemHand(), new ItemStack(IcariaItems.EMPTY_VIAL.get()), player);
			entity.snapTo(pUseOnContext.getClickedPos().above(), 0.0F, 0.0F);
			entity.setSize(1);
			level.addFreshEntity(entity);
			level.playSound(null, player.blockPosition(), IcariaSoundEvents.VIAL_EMPTY, SoundSource.PLAYERS);
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext pUseOnContext) {
		this.handleAction(pUseOnContext);
		return super.useOn(pUseOnContext);
	}
}
