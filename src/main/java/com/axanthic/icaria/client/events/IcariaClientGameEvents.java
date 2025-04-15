package com.axanthic.icaria.client.events;

import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.PlayerModel;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = IcariaIdents.ID, value = Dist.CLIENT)
public class IcariaClientGameEvents {

	@SubscribeEvent
	public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?, ?> pEvent) {
		var flag = pEvent.getRenderState().headItem.getItem() instanceof IcariaSkullItem;
		if (pEvent.getRenderer().getModel() instanceof PlayerModel playerModel) {
			playerModel.hat.visible = !flag;
			playerModel.head.visible = !flag;
		}
	}
}
