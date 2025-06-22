package com.axanthic.icaria.client.events;

import com.axanthic.icaria.client.special.ScrollItemSpecialModelRenderer;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(modid = IcariaIdents.ID, value = Dist.CLIENT)
public class IcariaClientGameEvents {

	@SubscribeEvent
	public static void onRecipesReceived(RecipesReceivedEvent pEvent) {
		ScrollItemSpecialModelRenderer.setRecipeMap(pEvent.getRecipeMap());
	}

	@SubscribeEvent
	public static void onRenderPlayer(RenderPlayerEvent.Pre pEvent) {
		var flag = pEvent.getRenderState().wornHeadType instanceof IcariaSkullBlockTypes;
		var playerModel = pEvent.getRenderer().getModel();
		playerModel.hat.visible = !flag;
		playerModel.head.visible = !flag;
	}
}
