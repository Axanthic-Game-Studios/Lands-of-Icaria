package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.recipe.ItemConcoctingRecipe;
import com.axanthic.icaria.common.registry.IcariaIdents;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeMap;

import org.joml.Matrix4f;
import org.joml.Vector3f;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ScrollItemSpecialModelRenderer() implements SpecialModelRenderer<ItemStack> {

	public static RecipeMap recipeMap = RecipeMap.EMPTY;

	@Override
	public void getExtents(Set<Vector3f> pSet) {
		return;
	}

	public static void setRecipeMap(RecipeMap pRecipeMap) {
		ScrollItemSpecialModelRenderer.recipeMap = pRecipeMap;
	}

	@Override
	public void submit(@Nullable ItemStack pItemStack, ItemDisplayContext pItemDisplayContext, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, int pPackedOverlay, boolean pHasFoil, int pOutlineColor) {
		var minecraft = Minecraft.getInstance();

		var clientLevel = minecraft.level;
		var localPlayer = minecraft.player;

		var window = minecraft.getWindow();

		if (clientLevel != null && localPlayer != null && pItemStack != null) {
			var recipeHolder = ScrollItemSpecialModelRenderer.getRecipeMap().byKey(ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pItemStack.getItem()).getPath().replace("scroll", "spell" + "_" + "from" + "_" + "item_concocting"))));
			if (recipeHolder != null && recipeHolder.value() instanceof ItemConcoctingRecipe recipe) {
				var ingredient = recipe.ingredient();
				var result = recipe.result();

				this.translate(pItemStack, localPlayer, pPoseStack, window.getHeight(), window.getWidth());

				this.submit(pPoseStack, "textures" + "/" + "item" + "/" + BuiltInRegistries.ITEM.getKey(ingredient.getValues().get(0).value()).getPath() + "." + "png", pSubmitNodeCollector, pPackedLight, pPackedOverlay, 0.1240F, 1.6425F, 0.0005F, 2.5225F, 90.0F);
				this.submit(pPoseStack, "textures" + "/" + "item" + "/" + BuiltInRegistries.ITEM.getKey(ingredient.getValues().get(1).value()).getPath() + "." + "png", pSubmitNodeCollector, pPackedLight, pPackedOverlay, 0.1240F, 3.5225F, 0.0005F, 2.5225F, 90.0F);
				this.submit(pPoseStack, "textures" + "/" + "item" + "/" + BuiltInRegistries.ITEM.getKey(ingredient.getValues().get(2).value()).getPath() + "." + "png", pSubmitNodeCollector, pPackedLight, pPackedOverlay, 0.1240F, 5.4125F, 0.0005F, 2.5225F, 90.0F);

				this.submit(pPoseStack, "textures" + "/" + "item" + "/" + BuiltInRegistries.ITEM.getKey(result.getItem()).getPath() + "." + "png", pSubmitNodeCollector, pPackedLight, pPackedOverlay, 0.2480F, 1.5125F, 0.0005F, 2.0785F, 90.0F);

				this.submit(pPoseStack, "textures" + "/" + "gui" + "/" + "scroll" + "." + "png", pSubmitNodeCollector, pPackedLight, pPackedOverlay, 1.0F, 0.0F, 0.0F, 0.0F, 90.0F);

				this.renderHands(pItemStack, localPlayer, pPoseStack, pSubmitNodeCollector, pPackedLight);

				IcariaClientHelper.submitString(pSubmitNodeCollector, pPoseStack, result.getItemName(), pPackedLight, 0.005015F, 101.75F, 42.75F, 180.0F, 0.0F, 0.0F);
			}
		}
	}

	public void submit(PoseStack pPoseStack, String pPath, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, int pPackedOverlay, float pScale, float pX, float pY, float pZ, float pXRot) {
		pPoseStack.pushPose();
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
		pPoseStack.scale(pScale, pScale, pScale);
		pPoseStack.translate(pX, pY, pZ);
		pSubmitNodeCollector.submitCustomGeometry(pPoseStack, RenderType.text(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pPath)), (pose, vertexConsumer) -> this.submit(pose.pose(), vertexConsumer, pPackedLight, pPackedOverlay));
		pPoseStack.popPose();
	}

	public void submit(Matrix4f pMatrix4f, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay) {
		pVertexConsumer.addVertex(pMatrix4f, 0.0F, 0.0F, 1.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pPackedOverlay).setUv(0.0F, 1.0F);
		pVertexConsumer.addVertex(pMatrix4f, 1.0F, 0.0F, 1.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pPackedOverlay).setUv(1.0F, 1.0F);
		pVertexConsumer.addVertex(pMatrix4f, 1.0F, 0.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pPackedOverlay).setUv(1.0F, 0.0F);
		pVertexConsumer.addVertex(pMatrix4f, 0.0F, 0.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pPackedOverlay).setUv(0.0F, 0.0F);
	}

	public void translate(ItemStack pItemStack, LocalPlayer pLocalPlayer, PoseStack pPoseStack, int pHeight, int pWidth) {
		if (pLocalPlayer.getMainHandItem() == pItemStack) {
			pPoseStack.translate((float) pWidth / pHeight * 0.85F - 1.25F, 1.5F, 0.0F);
		} else if (pLocalPlayer.getOffhandItem() == pItemStack) {
			pPoseStack.translate((float) pWidth / pHeight * -0.85F + 1.25F, 1.5F, 0.0F);
		}
	}

	public void renderHands(ItemStack pItemStack, LocalPlayer pLocalPlayer, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight) {
		if (pLocalPlayer.getOffhandItem() == pItemStack) {
			IcariaClientHelper.renderLeftHand(pSubmitNodeCollector, pPoseStack, pLocalPlayer, pPackedLight, 1.0F, 0.0F, -0.2F, 0.7F, -105.0F, -90.0F, 0.0F);
		} else if (pLocalPlayer.getMainHandItem() == pItemStack) {
			IcariaClientHelper.renderRightHand(pSubmitNodeCollector, pPoseStack, pLocalPlayer, pPackedLight, 1.0F, 1.0F, -0.2F, 0.7F, 180.0F, 90.0F, 75.0F);
		}
	}

	@Override
	public ItemStack extractArgument(ItemStack pItemStack) {
		return pItemStack;
	}

	public static RecipeMap getRecipeMap() {
		return ScrollItemSpecialModelRenderer.recipeMap;
	}
}
