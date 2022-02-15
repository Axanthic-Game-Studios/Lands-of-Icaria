package com.axanthic.icaria.client.render;

import com.axanthic.icaria.common.entities.ThrownBident;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThrownBidentRenderer extends EntityRenderer<ThrownBident> {

	private final ItemRenderer itemRenderer;

	public ThrownBidentRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.itemRenderer = context.getItemRenderer();
	}

	public void render(ThrownBident entity, float p_116112_, float p_116113_, PoseStack pose, MultiBufferSource p_116115_, int p_116116_) {
		pose.pushPose();
		pose.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(p_116113_, entity.yRotO, entity.getYRot()) - 90.0F));
		pose.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(p_116113_, entity.xRotO, entity.getXRot()) - 45.0F));
		pose.translate(-0.15, -0.15, 0);
		BakedModel bakedmodel = this.itemRenderer.getModel(entity.getContainedItem(), entity.level, null, entity.getId());
		this.itemRenderer.render(entity.getContainedItem(), ItemTransforms.TransformType.NONE, false, pose, p_116115_, p_116116_, OverlayTexture.NO_OVERLAY, bakedmodel);
		pose.popPose();
		super.render(entity, p_116112_, p_116113_, pose, p_116115_, p_116116_);
	}

	public ResourceLocation getTextureLocation(ThrownBident p_116109_) {
		return InventoryMenu.BLOCK_ATLAS;
	}
}