package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.block.GrinderBlock;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class GrinderBlockRenderer implements BlockEntityRenderer<GrinderBlockEntity> {

//	ItemStack gearLarge = new ItemStack(Resources.renderAddon, 1, 0);
//	ItemStack gearLargeActive = new ItemStack(Resources.renderAddon, 1, 1);
//	ItemStack gearSmall = new ItemStack(Resources.renderAddon, 1, 2);
//	ItemStack gearSmallActive = new ItemStack(Resources.renderAddon, 1, 3);
	
	float rotation = 0;

	public GrinderBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		
	}

	@Override
	public void render(GrinderBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {

		if (Minecraft.getInstance().player != null
				&& !pBlockEntity.getBlockPos().closerThan(Minecraft.getInstance().player.getOnPos(), 16)) {
			return;
		}

		ItemStack stack = pBlockEntity.getGear();

		if (!stack.isEmpty()) {
			ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
			pPoseStack.pushPose();
			pPoseStack.translate(0.5f, 0.9f, 0.5f);
			pPoseStack.scale(0.85f, 0.85f, 0.85f);
	        pPoseStack.mulPose(Vector3f.XP.rotationDegrees(90));

			switch (pBlockEntity.getBlockState().getValue(GrinderBlock.FACING)) {
				case NORTH -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(180));
				case EAST -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(270));
				case SOUTH -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(0));
				case WEST -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(90));
			}
			
			if(pBlockEntity.isGrinding()) {
				rotation = rotation+ 0.05f;
				if (rotation == 1f) rotation = 0;
				pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(360*rotation));
			}

			itemRenderer.renderStatic(stack, ItemTransforms.TransformType.FIXED,
					getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack,
					pBufferSource, 1);
			
			pPoseStack.popPose();
			
			pPoseStack.pushPose();
			pPoseStack.translate(0.7f, 0.423f, 0.95f);
			pPoseStack.scale(0.5f, 0.5f, 0.5f);	

			
			if(pBlockEntity.isGrinding()) {
				rotation = rotation+ 0.05f;
				if (rotation == 1f) rotation = 0;
				pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(360*rotation));
			}
			
			itemRenderer.renderStatic(stack, ItemTransforms.TransformType.FIXED,
					getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack,
					pBufferSource, 1);
			
			pPoseStack.popPose();
			
			pPoseStack.pushPose();
			
			pPoseStack.translate(0.3f, 0.423f, 0.05f);
			pPoseStack.scale(0.5f, 0.5f, 0.5f);
			
			if(pBlockEntity.isGrinding()) {
				rotation = rotation+ 0.05f;
				if (rotation == 1f) rotation = 0;
				pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(360*rotation));
			}
			
			itemRenderer.renderStatic(stack, ItemTransforms.TransformType.FIXED,
					getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack,
					pBufferSource, 1);
			
			pPoseStack.popPose();

		}

	}

	private int getLightLevel(Level level, BlockPos pos) {
		int blockLight = level.getBrightness(LightLayer.BLOCK, pos);
		int skyLight = level.getBrightness(LightLayer.SKY, pos);
		return LightTexture.pack(blockLight, skyLight);
	}

}
