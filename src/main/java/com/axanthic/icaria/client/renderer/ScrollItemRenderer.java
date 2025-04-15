package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.item.ScrollItem;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScrollItemRenderer extends BlockEntityWithoutLevelRenderer {
	public ScrollItemRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
		super(pBlockEntityRenderDispatcher, pEntityModelSet);
	}

	@Override
	public void renderByItem(ItemStack pItemStack, ItemDisplayContext pItemDisplayContext, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay) {
		var minecraft = Minecraft.getInstance();

		var window = minecraft.getWindow();

		var vertexConsumer = pMultiBufferSource.getBuffer(Sheets.translucentItemSheet());

		var clientLevel = minecraft.level;
		var localPlayer = minecraft.player;

		var textureAtlasSprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.SCROLL);

		if (clientLevel != null && localPlayer != null && pItemStack.getItem() instanceof ScrollItem scrollItem) {
			pPoseStack.pushPose();

			var concoctingItemRecipe = scrollItem.getRecipe();

			var ingredient = concoctingItemRecipe.ingredient();
			var result = concoctingItemRecipe.result();

			this.translate(pItemStack, localPlayer, pPoseStack, window.getHeight(), window.getWidth());

			this.renderHands(pItemStack, localPlayer, pMultiBufferSource, pPoseStack, pPackedLight);

			pPoseStack.pushPose();

			pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

			IcariaClientHelper.renderQuad(vertexConsumer, textureAtlasSprite, pPoseStack.last().pose(), pPackedLight, pPackedOverlay, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F);

			pPoseStack.popPose();

			IcariaClientHelper.renderString(pPoseStack, pMultiBufferSource, Component.translatable(result.getItem().getDescriptionId()), pPackedLight, 0.00675F, 74.55F, -111.0F, 180.0F, 0.0F, 0.0F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(ingredient.items().get(0)), clientLevel, pPackedLight, 0.3F, 0.5625F, 0.0F, 0.0F, 0.0F, 0.0F, 0.125F, 0.125F, 0.001F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(ingredient.items().get(1)), clientLevel, pPackedLight, 0.5F, 0.5625F, 0.0F, 0.0F, 0.0F, 0.0F, 0.125F, 0.125F, 0.001F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(ingredient.items().get(2)), clientLevel, pPackedLight, 0.7F, 0.5625F, 0.0F, 0.0F, 0.0F, 0.0F, 0.125F, 0.125F, 0.001F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, result, clientLevel, pPackedLight, 0.5F, 0.3125F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2495F, 0.2495F, 0.001F);

			pPoseStack.popPose();
		}
	}

	public void renderHands(ItemStack pItemStack, LocalPlayer pLocalPlayer, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, int pPackedLight) {
		if (pLocalPlayer.getOffhandItem() == pItemStack) {
			IcariaClientHelper.renderLeftHand(pPoseStack, pMultiBufferSource, pLocalPlayer, pPackedLight, 1.0F, 0.0F, 0.8F, 0.7F, -105.0F, -90.0F, 0.0F);
		} else if (pLocalPlayer.getMainHandItem() == pItemStack) {
			IcariaClientHelper.renderMainHand(pPoseStack, pMultiBufferSource, pLocalPlayer, pPackedLight, 1.0F, 1.0F, 0.8F, 0.7F, 180.0F, 90.0F, 75.0F);
			if (pLocalPlayer.getOffhandItem().isEmpty()) {
				IcariaClientHelper.renderLeftHand(pPoseStack, pMultiBufferSource, pLocalPlayer, pPackedLight, 1.0F, 0.0F, 0.1F, 0.7F, 180.0F, 90.0F, 115.0F);
			}
		}
	}

	public void translate(ItemStack pItemStack, LocalPlayer pLocalPlayer, PoseStack pPoseStack, int pHeight, int pWidth) {
		if (pLocalPlayer.getMainHandItem() == pItemStack) {
			pPoseStack.translate((float) pWidth / pHeight * 0.85F - 1.25F, 0.5F, 0.0F);
		} else if (pLocalPlayer.getOffhandItem() == pItemStack) {
			pPoseStack.translate((float) pWidth / pHeight * -0.85F + 1.25F, 0.5F, 0.0F);
		}
	}
}
