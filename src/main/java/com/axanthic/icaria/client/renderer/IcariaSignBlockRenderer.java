package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.block.IcariaStandingSignBlock;
import com.axanthic.icaria.common.block.IcariaWallSignBlock;

import com.google.common.collect.ImmutableMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

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
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSignBlockRenderer extends SignRenderer {
	public static final int OUTLINE_RENDER_DISTANCE = Mth.square(16);

	public Font font;

	public Map<WoodType, SignModel> map;

	public IcariaSignBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		super(pContext);
		this.font = pContext.getFont();
		this.map = WoodType.values().collect(ImmutableMap.toImmutableMap((pWoodType) -> pWoodType, (pWoodType) -> new SignModel(pContext.bakeLayer(ModelLayers.createSignModelName(pWoodType)))));
	}

	public boolean isOutlineVisible(SignBlockEntity pBlockEntity, int pTextColor) {
		if (pTextColor == DyeColor.BLACK.getTextColor()) {
			return true;
		} else {
			Minecraft minecraft = Minecraft.getInstance();
			LocalPlayer localPlayer = minecraft.player;
			if (localPlayer != null && minecraft.options.getCameraType().isFirstPerson() && localPlayer.isScoping()) {
				return true;
			} else {
				Entity entity = minecraft.getCameraEntity();
				return entity != null && entity.distanceToSqr(Vec3.atCenterOf(pBlockEntity.getBlockPos())) < OUTLINE_RENDER_DISTANCE;
			}
		}
	}

	public int getDarkColor(SignBlockEntity pBlockEntity) {
		int i = pBlockEntity.getColor().getTextColor();
		int j = (int) (FastColor.ARGB32.red(i) * 0.4D);
		int k = (int) (FastColor.ARGB32.green(i) * 0.4D);
		int l = (int) (FastColor.ARGB32.blue(i) * 0.4D);
		return i == DyeColor.BLACK.getTextColor() && pBlockEntity.hasGlowingText() ? -988212 : FastColor.ARGB32.color(0, j, k, l);
	}

	@Override
	public void render(SignBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		BlockState blockState = pBlockEntity.getBlockState();
		WoodType woodType = SignBlock.getWoodType(blockState.getBlock());
		Material material = Sheets.getSignMaterial(woodType);
		SignModel signModel = this.map.get(woodType);
		VertexConsumer vertexConsumer = material.buffer(pBufferSource, signModel::renderType);
		FormattedCharSequence[] formattedCharSequences = pBlockEntity.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (pComponent) -> {
			List<FormattedCharSequence> list = this.font.split(pComponent, 90);
			return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
		});

		boolean flag;

		int i = this.getDarkColor(pBlockEntity);
		int j;
		int k;

		pPoseStack.pushPose();

		if (blockState.getBlock() instanceof StandingSignBlock) {
			pPoseStack.translate(0.5D, 0.5D, 0.5D);
			float f0 = -((blockState.getValue(IcariaStandingSignBlock.ROTATION) * 360) / 16.0F);
			pPoseStack.mulPose(Axis.YP.rotationDegrees(f0));
			signModel.stick.visible = true;
		} else {
			if (blockState.getValue(IcariaWallSignBlock.FACE) == AttachFace.WALL) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				float f1 = -blockState.getValue(WallSignBlock.FACING).toYRot();
				pPoseStack.mulPose(Axis.YP.rotationDegrees(f1));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
				signModel.stick.visible = false;
			}
			if (blockState.getValue(IcariaWallSignBlock.FACE) == AttachFace.CEILING) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				float f2 = -blockState.getValue(WallSignBlock.FACING).getOpposite().toYRot();
				pPoseStack.mulPose(Axis.YP.rotationDegrees(f2));
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
				signModel.stick.visible = false;
			}
			if (blockState.getValue(IcariaWallSignBlock.FACE) == AttachFace.FLOOR) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				float f3 = -blockState.getValue(IcariaWallSignBlock.FACING).getOpposite().toYRot();
				pPoseStack.mulPose(Axis.YP.rotationDegrees(f3));
				pPoseStack.mulPose(Axis.XP.rotationDegrees(-90));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
				signModel.stick.visible = false;
			}
		}

		pPoseStack.pushPose();
		pPoseStack.scale(0.6666667F, -0.6666667F, -0.6666667F);

		signModel.root.render(pPoseStack, vertexConsumer, pPackedLight, pPackedOverlay);

		pPoseStack.popPose();
		pPoseStack.translate(0.0D, 0.33333334F, 0.046666667F);
		pPoseStack.scale(0.010416667F, -0.010416667F, 0.010416667F);

		if (pBlockEntity.hasGlowingText()) {
			j = pBlockEntity.getColor().getTextColor();
			flag = isOutlineVisible(pBlockEntity, j);
			k = 15728880;
		} else {
			j = i;
			flag = false;
			k = pPackedLight;
		}

		for (int m = 0; m < 4; ++m) {
			FormattedCharSequence formattedCharSequence = formattedCharSequences[m];
			float f4 = (float) (-this.font.width(formattedCharSequence) / 2);
			if (flag) {
				this.font.drawInBatch8xOutline(formattedCharSequence, f4, (m * 10 - 20), j, i, pPoseStack.last().pose(), pBufferSource, k);
			} else {
				this.font.drawInBatch(formattedCharSequence, f4, (m * 10 - 20), j, false, pPoseStack.last().pose(), pBufferSource, Font.DisplayMode.NORMAL, 0, k);
			}
		}

		pPoseStack.popPose();
	}
}
