package com.axanthic.icaria.client.events;

import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.world.entity.EquipmentSlot;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = IcariaIdents.ID, value = Dist.CLIENT)
public class ClientGameEvents {

	@SubscribeEvent
	public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> pEvent) {
		if (pEvent.getEntity().getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof IcariaSkullItem) {
			if (pEvent.getRenderer().getModel() instanceof PlayerModel<?> playerModel) {
				playerModel.hat.visible = false;
				playerModel.head.visible = false;
			}
		}
	}
}
