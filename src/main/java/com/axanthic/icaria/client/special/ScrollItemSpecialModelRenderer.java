package com.axanthic.icaria.client.special;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.recipe.ItemConcoctingRecipe;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeMap;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ScrollItemSpecialModelRenderer() implements SpecialModelRenderer<ItemStack> {

	public static RecipeMap recipeMap = RecipeMap.EMPTY;

	@Override
	public ItemStack extractArgument(ItemStack pItemStack) {
		return pItemStack;
	}

	@Override
	public void render(@Nullable ItemStack pItemStack, ItemDisplayContext pItemDisplayContext, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, boolean pHasFoilType) {
		var minecraft = Minecraft.getInstance();

		var clientLevel = minecraft.level;
		var localPlayer = minecraft.player;

		var window = minecraft.getWindow();

		var textureAtlasSprite = minecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.SCROLL);

		var vertexConsumer = pMultiBufferSource.getBuffer(Sheets.translucentItemSheet());

		if (clientLevel != null && localPlayer != null && pItemStack != null) {
			var concoctingItemRecipe = ScrollItemSpecialModelRenderer.getRecipeMap().byKey(ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pItemStack.getItem()).getPath().replace("scroll", "spell" + "_" + "from" + "_" + "item_concocting"))));
			if (concoctingItemRecipe != null && concoctingItemRecipe.value() instanceof ItemConcoctingRecipe recipe) {
				var ingredient = recipe.ingredient();
				var result = recipe.result();

				this.translate(pItemStack, localPlayer, pPoseStack, window.getHeight(), window.getWidth());
				this.renderHands(pItemStack, localPlayer, pMultiBufferSource, pPoseStack, pPackedLight);

				pPoseStack.pushPose();

				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

				IcariaClientHelper.renderQuad(vertexConsumer, textureAtlasSprite, pPoseStack.last().pose(), pPackedLight, pPackedOverlay, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F);

				pPoseStack.popPose();

				IcariaClientHelper.renderString(pPoseStack, pMultiBufferSource, Component.translatable(result.getItem().getDescriptionId()), pPackedLight, 0.00675F, 74.55F, -111.0F, 180.0F, 0.0F, 0.0F);
				IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(ingredient.getValues().get(0)), clientLevel, pPackedLight, 0.3F, 0.5625F, 0.0F, 0.0F, 0.0F, 0.0F, 0.125F, 0.125F, 0.001F);
				IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(ingredient.getValues().get(1)), clientLevel, pPackedLight, 0.5F, 0.5625F, 0.0F, 0.0F, 0.0F, 0.0F, 0.125F, 0.125F, 0.001F);
				IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, new ItemStack(ingredient.getValues().get(2)), clientLevel, pPackedLight, 0.7F, 0.5625F, 0.0F, 0.0F, 0.0F, 0.0F, 0.125F, 0.125F, 0.001F);
				IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, result, clientLevel, pPackedLight, 0.5F, 0.3125F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2495F, 0.2495F, 0.001F);
			}
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

	public static void setRecipeMap(RecipeMap pRecipeMap) {
		ScrollItemSpecialModelRenderer.recipeMap = pRecipeMap;
	}

	public static RecipeMap getRecipeMap() {
		return ScrollItemSpecialModelRenderer.recipeMap;
	}
}
