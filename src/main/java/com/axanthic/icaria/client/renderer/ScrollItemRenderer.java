package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.item.ScrollItem;
import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import org.joml.Matrix4f;

import java.util.Arrays;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScrollItemRenderer extends BlockEntityWithoutLevelRenderer {
	public ScrollItemRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
		super(pBlockEntityRenderDispatcher, pEntityModelSet);
	}

	@Override
	public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
		pPoseStack.pushPose();

		var minecraft = Minecraft.getInstance();
		var window = minecraft.getWindow();

		int height = window.getHeight();
		int width = window.getWidth();

		var consumer = pBuffer.getBuffer(Sheets.translucentCullBlockSheet());
		var matrix4f = pPoseStack.last().pose();

		var itemRenderer = minecraft.getItemRenderer();
		var level = minecraft.level;
		var player = minecraft.player;
		var sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.SCROLL);

		if (player != null) {
			var mainHandItem = player.getMainHandItem();
			var offHandItem = player.getOffhandItem();

			pPoseStack.scale(1.0F, 1.0F, 1.0F);

			if (mainHandItem == pStack) {
				pPoseStack.translate((float) width / height * 0.85F - 1.25F, 0.5F, 0.0F);
			} else if (offHandItem == pStack) {
				pPoseStack.translate((float) width / height * -0.85F + 1.25F, 0.5F, 0.0F);
			}

			consumer.addVertex(matrix4f, 0.0F, 0.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setUv(sprite.getU0(), sprite.getV1()).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(0.0F, 0.0F, 1.0F);
			consumer.addVertex(matrix4f, 1.0F, 0.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setUv(sprite.getU1(), sprite.getV1()).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(0.0F, 0.0F, 1.0F);
			consumer.addVertex(matrix4f, 1.0F, 1.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setUv(sprite.getU1(), sprite.getV0()).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(0.0F, 0.0F, 1.0F);
			consumer.addVertex(matrix4f, 0.0F, 1.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setUv(sprite.getU0(), sprite.getV0()).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(0.0F, 0.0F, 1.0F);

			if (pStack.getItem() instanceof ScrollItem scrollItem) {
				var recipe = scrollItem.getRecipe();
				var ingredients = recipe.getIngredients();
				var ingC = Arrays.stream(ingredients.get(2).getItems()).findFirst().get();
				var ingB = Arrays.stream(ingredients.get(1).getItems()).findFirst().get();
				var ingA = Arrays.stream(ingredients.get(0).getItems()).findFirst().get();
				var output = recipe.getResultItem(null);

				pPoseStack.scale(1.0F, 1.0F, 1.0F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
				pPoseStack.translate(0.5F, -0.75F, 0.0F);
				pPoseStack.scale(0.007F, 0.007F, 0.007F);
				this.renderString(0, pPackedLight, Component.translatable(output.getItem().getDescriptionId()), matrix4f, pBuffer);

				pPoseStack.scale(13.5F, 13.5F, 0.1F);
				pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
				pPoseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
				pPoseStack.translate(1.5F, -2.0F, 0.0F);
				itemRenderer.renderStatic(ingC, ItemDisplayContext.GUI, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, level, 0);

				pPoseStack.translate(-1.5F, 0.0F, 0.0F);
				itemRenderer.renderStatic(ingB, ItemDisplayContext.GUI, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, level, 0);

				pPoseStack.translate(-1.5F, 0.0F, 0.0F);
				itemRenderer.renderStatic(ingA, ItemDisplayContext.GUI, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, level, 0);

				pPoseStack.translate(1.5F, -2.6375F, 0.0F);
				pPoseStack.scale(2.625F, 2.625F, 1.0F);
				itemRenderer.renderStatic(output, ItemDisplayContext.GUI, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, level, 0);
			}

			RenderSystem.setShaderTexture(0, player.getSkin().texture());

			pPoseStack.scale(5.0F, 5.0F, 5.0F);

			if (minecraft.getEntityRenderDispatcher().getRenderer(player) instanceof PlayerRenderer playerRenderer) {
				if (offHandItem == pStack) {
					pPoseStack.mulPose(Axis.XP.rotationDegrees(150.0F));
					pPoseStack.mulPose(Axis.ZN.rotationDegrees(75.0F));
					pPoseStack.translate(0.0F, -1.01F, -0.25F);
					playerRenderer.renderLeftHand(pPoseStack, pBuffer, pPackedLight, player);
				} else if (mainHandItem == pStack) {
					pPoseStack.mulPose(Axis.XP.rotationDegrees(150.0F));
					pPoseStack.mulPose(Axis.ZP.rotationDegrees(75.0F));
					pPoseStack.translate(0.0F, -1.01F, -0.25F);
					playerRenderer.renderRightHand(pPoseStack, pBuffer, pPackedLight, player);
					if (offHandItem.isEmpty()) {
						pPoseStack.mulPose(Axis.XP.rotationDegrees(25.0F));
						pPoseStack.mulPose(Axis.ZP.rotationDegrees(122.5F));
						pPoseStack.translate(0.625F, -1.5F, -0.2F);
						playerRenderer.renderLeftHand(pPoseStack, pBuffer, pPackedLight, player);
					}
				}
			}
		}

		pPoseStack.popPose();
	}

	public void renderString(int pOffset, int pPackedLight, Component pComponent, Matrix4f pMatrix4f, MultiBufferSource pBuffer) {
		Minecraft.getInstance().font.drawInBatch(pComponent, pOffset - Minecraft.getInstance().font.width(pComponent) * 0.5F, 0.0F, IcariaColors.TEXT, false, pMatrix4f, pBuffer, Font.DisplayMode.POLYGON_OFFSET, 0, pPackedLight);
	}
}
