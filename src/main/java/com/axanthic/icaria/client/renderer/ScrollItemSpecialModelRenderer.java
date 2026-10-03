package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.recipe.ItemConcoctingRecipe;
import com.axanthic.icaria.common.registry.IcariaIds;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import java.util.Objects;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;

import org.joml.Matrix4f;
import org.joml.Vector3fc;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ScrollItemSpecialModelRenderer() implements SpecialModelRenderer<ItemStack> {

	public static RecipeMap recipeMap = RecipeMap.EMPTY;

	public boolean test(RecipeHolder<?> pRecipeHolder, ItemStack pItemStack) {
		return pRecipeHolder.value() instanceof ItemConcoctingRecipe recipe && Objects.equals(this.path(recipe.result().create().getItem()), this.path(pItemStack.getItem()).replace("scroll", "spell"));
	}

	@Override
	public void getExtents(Consumer<Vector3fc> pConsumer) {
		return;
	}

	public static void setRecipeMap(RecipeMap pRecipeMap) {
		ScrollItemSpecialModelRenderer.recipeMap = pRecipeMap;
	}

	@Override
	public void submit(@Nullable ItemStack pItemStack, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, int pOverlayCoords, boolean pHasFoil, int pOutlineColor) {
		var minecraft = Minecraft.getInstance();

		var clientLevel = minecraft.level;
		var localPlayer = minecraft.player;

		var window = minecraft.getWindow();

		if (clientLevel != null && localPlayer != null && pItemStack != null) {
			var stream = ScrollItemSpecialModelRenderer.getRecipeMap().values().stream().filter(recipeHolder -> this.test(recipeHolder, pItemStack));
			if (stream.findFirst().orElseThrow().value() instanceof ItemConcoctingRecipe recipe) {
				this.translate(pItemStack, localPlayer, pPoseStack, window.getHeight(), window.getWidth());

				this.submit(pPoseStack, "textures" + "/" + "item" + "/" + this.path(recipe.ingredient().getValues().get(0).value()) + "." + "png", pSubmitNodeCollector, pLightCoords, pOverlayCoords, 0.1240F, 1.6425F, 0.0005F, 2.5225F, 90.0F);
				this.submit(pPoseStack, "textures" + "/" + "item" + "/" + this.path(recipe.ingredient().getValues().get(1).value()) + "." + "png", pSubmitNodeCollector, pLightCoords, pOverlayCoords, 0.1240F, 3.5225F, 0.0005F, 2.5225F, 90.0F);
				this.submit(pPoseStack, "textures" + "/" + "item" + "/" + this.path(recipe.ingredient().getValues().get(2).value()) + "." + "png", pSubmitNodeCollector, pLightCoords, pOverlayCoords, 0.1240F, 5.4125F, 0.0005F, 2.5225F, 90.0F);

				this.submit(pPoseStack, "textures" + "/" + "item" + "/" + this.path(recipe.result().create().getItem()) + "." + "png", pSubmitNodeCollector, pLightCoords, pOverlayCoords, 0.2480F, 1.5125F, 0.0005F, 2.0785F, 90.0F);

				this.submit(pPoseStack, "textures" + "/" + "gui" + "/" + "scroll" + "." + "png", pSubmitNodeCollector, pLightCoords, pOverlayCoords, 1.0F, 0.0F, 0.0F, 0.0F, 90.0F);

				this.renderHands(pItemStack, localPlayer, pPoseStack, pSubmitNodeCollector, pLightCoords);

				IcariaClientHelper.submitString(pSubmitNodeCollector, pPoseStack, recipe.result().create().getItemName(), pLightCoords, 0.005015F, 101.75F, 42.75F, 180.0F, 0.0F, 0.0F);
			}
		}
	}

	public void submit(PoseStack pPoseStack, String pPath, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, int pOverlayCoords, float pScale, float pX, float pY, float pZ, float pXRot) {
		pPoseStack.pushPose();
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
		pPoseStack.scale(pScale, pScale, pScale);
		pPoseStack.translate(pX, pY, pZ);
		pSubmitNodeCollector.submitCustomGeometry(pPoseStack, RenderTypes.text(Identifier.fromNamespaceAndPath(IcariaIds.ID, pPath)), (pose, vertexConsumer) -> this.submit(pose.pose(), vertexConsumer, pLightCoords, pOverlayCoords));
		pPoseStack.popPose();
	}

	public void submit(Matrix4f pMatrix4f, VertexConsumer pVertexConsumer, int pLightCoords, int pOverlayCoords) {
		pVertexConsumer.addVertex(pMatrix4f, 0.0F, 0.0F, 1.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setLight(pLightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pOverlayCoords).setUv(0.0F, 1.0F);
		pVertexConsumer.addVertex(pMatrix4f, 1.0F, 0.0F, 1.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setLight(pLightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pOverlayCoords).setUv(1.0F, 1.0F);
		pVertexConsumer.addVertex(pMatrix4f, 1.0F, 0.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setLight(pLightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pOverlayCoords).setUv(1.0F, 0.0F);
		pVertexConsumer.addVertex(pMatrix4f, 0.0F, 0.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F).setLight(pLightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pOverlayCoords).setUv(0.0F, 0.0F);
	}

	public void translate(ItemStack pItemStack, LocalPlayer pLocalPlayer, PoseStack pPoseStack, int pHeight, int pWidth) {
		if (pLocalPlayer.getMainHandItem() == pItemStack) {
			pPoseStack.translate((float) pWidth / pHeight * 0.85F - 1.25F, 1.5F, 0.0F);
		} else if (pLocalPlayer.getOffhandItem() == pItemStack) {
			pPoseStack.translate((float) pWidth / pHeight * -0.85F + 1.25F, 1.5F, 0.0F);
		}
	}

	public void renderHands(ItemStack pItemStack, LocalPlayer pLocalPlayer, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords) {
		if (pLocalPlayer.getOffhandItem() == pItemStack) {
			IcariaClientHelper.renderLeftHand(pSubmitNodeCollector, pPoseStack, pLocalPlayer, pLightCoords, 1.0F, 0.0F, -0.2F, 0.7F, -105.0F, -90.0F, 0.0F);
		} else if (pLocalPlayer.getMainHandItem() == pItemStack) {
			IcariaClientHelper.renderRightHand(pSubmitNodeCollector, pPoseStack, pLocalPlayer, pLightCoords, 1.0F, 1.0F, -0.2F, 0.7F, 180.0F, 90.0F, 75.0F);
		}
	}

	@Override
	public ItemStack extractArgument(ItemStack pItemStack) {
		return pItemStack;
	}

	public static RecipeMap getRecipeMap() {
		return ScrollItemSpecialModelRenderer.recipeMap;
	}

	public String path(Item pItem) {
		return BuiltInRegistries.ITEM.getKey(pItem).getPath();
	}
}
