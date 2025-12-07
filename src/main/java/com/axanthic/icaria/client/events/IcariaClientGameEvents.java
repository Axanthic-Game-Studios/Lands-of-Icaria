package com.axanthic.icaria.client.events;

import com.axanthic.icaria.client.renderer.ScrollItemSpecialModelRenderer;
import com.axanthic.icaria.client.screen.ChestLabelScreen;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

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

	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem pEvent) {
		var itemStack = pEvent.getItemStack();
		if (pEvent.getHand() == InteractionHand.MAIN_HAND && itemStack.is(IcariaItems.CHEST_LABEL.get())) {
			pEvent.getEntity().awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
			Minecraft.getInstance().setScreen(new ChestLabelScreen(itemStack));
		}
	}
}
