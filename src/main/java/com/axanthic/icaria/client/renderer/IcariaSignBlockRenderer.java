package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.block.IcariaStandingSignBlock;
import com.axanthic.icaria.common.block.IcariaWallSignBlock;

import com.google.common.collect.ImmutableMap;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@OnlyIn(Dist.CLIENT)
public class IcariaSignBlockRenderer extends SignRenderer {
	public Font font;
	public Map<WoodType, SignModel> signModels;
	public static int OUTLINE_RENDER_DISTANCE = Mth.square(16);

	public IcariaSignBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		super(pContext);
		this.font = pContext.getFont();
		this.signModels = WoodType.values().collect(ImmutableMap.toImmutableMap((pWoodType) -> pWoodType, (pWoodType) -> new SignModel(pContext.bakeLayer(ModelLayers.createSignModelName(pWoodType)))));
	}

	public boolean isOutlineVisible(SignBlockEntity pBlockEntity, int pTextColor) {
		if (pTextColor == DyeColor.BLACK.getTextColor()) {
			return true;
		} else {
			Minecraft minecraft = Minecraft.getInstance();
			LocalPlayer player = minecraft.player;
			if (player != null && minecraft.options.getCameraType().isFirstPerson() && player.isScoping()) {
				return true;
			} else {
				Entity entity = minecraft.getCameraEntity();
				return entity != null && entity.distanceToSqr(Vec3.atCenterOf(pBlockEntity.getBlockPos())) < (double)OUTLINE_RENDER_DISTANCE;
			}
		}
	}

	public int getDarkColor(SignBlockEntity pBlockEntity) {
		int i = pBlockEntity.getColor().getTextColor();
		int j = (int)((double)NativeImage.getR(i) * 0.4D);
		int k = (int)((double)NativeImage.getG(i) * 0.4D);
		int l = (int)((double)NativeImage.getB(i) * 0.4D);
		return i == DyeColor.BLACK.getTextColor() && pBlockEntity.hasGlowingText() ? -988212 : NativeImage.combine(0, l, k, j);
	}

	@Override
	public void render(SignBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		BlockState state = pBlockEntity.getBlockState();
		pPoseStack.pushPose();
		WoodType type = getWoodType(state.getBlock());
		SignModel model = this.signModels.get(type);
		if (state.getBlock() instanceof StandingSignBlock) {
			pPoseStack.translate(0.5D, 0.5D, 0.5D);
			float f0 = -((float)(state.getValue(IcariaStandingSignBlock.ROTATION) * 360) / 16.0F);
			pPoseStack.mulPose(Vector3f.YP.rotationDegrees(f0));
			model.stick.visible = true;
		} else {
			if (state.getValue(IcariaWallSignBlock.FACE) == AttachFace.WALL) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				float f1 = -state.getValue(WallSignBlock.FACING).toYRot();
				pPoseStack.mulPose(Vector3f.YP.rotationDegrees(f1));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
				model.stick.visible = false;
			}
			if (state.getValue(IcariaWallSignBlock.FACE) == AttachFace.CEILING) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				float f2 = -state.getValue(WallSignBlock.FACING).getOpposite().toYRot();
				pPoseStack.mulPose(Vector3f.YP.rotationDegrees(f2));
				pPoseStack.mulPose(Vector3f.XP.rotationDegrees(90));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
				model.stick.visible = false;
			}
			if (state.getValue(IcariaWallSignBlock.FACE) == AttachFace.FLOOR) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				float f3 = -state.getValue(IcariaWallSignBlock.FACING).getOpposite().toYRot();
				pPoseStack.mulPose(Vector3f.YP.rotationDegrees(f3));
				pPoseStack.mulPose(Vector3f.XP.rotationDegrees(-90));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
				model.stick.visible = false;
			}
		}

		pPoseStack.pushPose();
		pPoseStack.scale(0.6666667F, -0.6666667F, -0.6666667F);
		Material material = Sheets.getSignMaterial(type);
		VertexConsumer consumer = material.buffer(pBufferSource, model::renderType);
		model.root.render(pPoseStack, consumer, pPackedLight, pPackedOverlay);
		pPoseStack.popPose();
		pPoseStack.translate(0.0D, 0.33333334F, 0.046666667F);
		pPoseStack.scale(0.010416667F, -0.010416667F, 0.010416667F);
		int i = getDarkColor(pBlockEntity);
		FormattedCharSequence[] sequences = pBlockEntity.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (pComponent) -> {
			List<FormattedCharSequence> list = this.font.split(pComponent, 90);
			return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
		});
		int k;
		boolean flag;
		int l;
		if (pBlockEntity.hasGlowingText()) {
			k = pBlockEntity.getColor().getTextColor();
			flag = isOutlineVisible(pBlockEntity, k);
			l = 15728880;
		} else {
			k = i;
			flag = false;
			l = pPackedLight;
		}

		for(int m = 0; m < 4; ++m) {
			FormattedCharSequence sequence = sequences[m];
			float f4 = (float)(-this.font.width(sequence) / 2);
			if (flag) {
				this.font.drawInBatch8xOutline(sequence, f4, (float)(m * 10 - 20), k, i, pPoseStack.last().pose(), pBufferSource, l);
			} else {
				this.font.drawInBatch(sequence, f4, (float)(m * 10 - 20), k, false, pPoseStack.last().pose(), pBufferSource, false, 0, l);
			}
		}

		pPoseStack.popPose();
	}
}
