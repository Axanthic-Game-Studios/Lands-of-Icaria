package com.axanthic.icaria.client.renderer;

import com.google.common.collect.ImmutableMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaSignBlockRenderer extends SignRenderer {
	public Font font;

	public Map<WoodType, SignModel> map;

	public IcariaSignBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		super(pContext);
		this.font = pContext.getFont();
		this.map = WoodType.values().collect(ImmutableMap.toImmutableMap((pWoodType) -> pWoodType, (pWoodType) -> new SignModel(pContext.bakeLayer(ModelLayers.createSignModelName(pWoodType)))));
	}

	public boolean isOutlineVisible(BlockPos pBlockPos, int pColor) {
		if (pColor == DyeColor.BLACK.getTextColor()) {
			return true;
		} else {
			var minecraft = Minecraft.getInstance();
			var localPlayer = minecraft.player;
			if (localPlayer != null && minecraft.options.getCameraType().isFirstPerson() && localPlayer.isScoping()) {
				return true;
			} else {
				var entity = minecraft.getCameraEntity();
				return entity != null && entity.distanceToSqr(Vec3.atCenterOf(pBlockPos)) < Mth.square(16);
			}
		}
	}

	public int getDarkColor(SignText pSignText) {
		int color = pSignText.getColor().getTextColor();
		if (color == DyeColor.BLACK.getTextColor() && pSignText.hasGlowingText()) {
			return -988212;
		} else {
			int red = (int) (FastColor.ARGB32.red(color) * 0.4D);
			int green = (int) (FastColor.ARGB32.green(color) * 0.4D);
			int blue = (int) (FastColor.ARGB32.blue(color) * 0.4D);
			return FastColor.ARGB32.color(0, red, green, blue);
		}
	}

	@Override
	public void render(SignBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		var blockState = pBlockEntity.getBlockState();
		var block = (SignBlock) blockState.getBlock();
		var woodType = SignBlock.getWoodType(block);
		var model = this.map.get(woodType);

		model.stick.visible = blockState.getBlock() instanceof StandingSignBlock;

		this.renderSignWithText(pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, blockState, woodType, model);
	}

	public void renderSign(PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, WoodType pWoodType, Model pModel) {
		float scale = this.getSignModelRenderScale();

		pPoseStack.pushPose();
		pPoseStack.scale(scale, -scale, -scale);

		this.renderSignModel(pPoseStack, pPackedLight, pPackedOverlay, pModel, this.getSignMaterial(pWoodType).buffer(pBufferSource, pModel::renderType));

		pPoseStack.popPose();
	}

	public void renderSignModel(PoseStack pPoseStack, int pPackedLight, int pPackedOverlay, Model pModel, VertexConsumer pVertexConsumer) {
		((SignModel) pModel).root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay);
	}

	public void renderSignText(BlockPos pBlockPos, SignText pSignText, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pLineHeight, int pLineWidth, boolean pBack) {
		boolean outline;

		int darkColor = this.getDarkColor(pSignText);
		int lineHeight = pLineHeight * 2;
		int packedLight;
		int textColor;

		var formattedCharSequences = pSignText.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (pComponent) -> {
			var list = this.font.split(pComponent, pLineWidth);
			return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
		});

		pPoseStack.pushPose();

		this.translateSignText(pPoseStack, pBack, this.getTextOffset());

		if (pSignText.hasGlowingText()) {
			textColor = pSignText.getColor().getTextColor();
			packedLight = 15728880;
			outline = this.isOutlineVisible(pBlockPos, textColor);
		} else {
			textColor = darkColor;
			packedLight = pPackedLight;
			outline = false;
		}

		for (int line = 0; line < 4; ++line) {
			var formattedCharSequence = formattedCharSequences[line];

			float width = (float) (this.font.width(formattedCharSequence) / -2);

			if (outline) {
				this.font.drawInBatch8xOutline(formattedCharSequence, width, (line * pLineHeight - lineHeight), textColor, darkColor, pPoseStack.last().pose(), pBufferSource, packedLight);
			} else {
				this.font.drawInBatch(formattedCharSequence, width, (line * pLineHeight - lineHeight), textColor, false, pPoseStack.last().pose(), pBufferSource, Font.DisplayMode.POLYGON_OFFSET, 0, packedLight);
			}
		}

		pPoseStack.popPose();
	}

	public void renderSignWithText(SignBlockEntity pBlockEntity, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, BlockState pBlockState, WoodType pWoodType, Model pModel) {
		pPoseStack.pushPose();
		this.translateSign(pPoseStack, pBlockState);
		this.renderSign(pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, pWoodType, pModel);
		this.renderSignText(pBlockEntity.getBlockPos(), pBlockEntity.getFrontText(), pPoseStack, pBufferSource, pPackedLight, pBlockEntity.getTextLineHeight(), pBlockEntity.getMaxTextLineWidth(), true);
		this.renderSignText(pBlockEntity.getBlockPos(), pBlockEntity.getBackText(), pPoseStack, pBufferSource, pPackedLight, pBlockEntity.getTextLineHeight(), pBlockEntity.getMaxTextLineWidth(), false);
		pPoseStack.popPose();
	}

	public void translateSign(PoseStack pPoseStack, BlockState pBlockState) {
		if (pBlockState.getBlock() instanceof StandingSignBlock) {
			pPoseStack.translate(0.5D, 0.75F * this.getSignModelRenderScale(), 0.5D);
			pPoseStack.mulPose(Axis.YP.rotationDegrees(((pBlockState.getValue(BlockStateProperties.ROTATION_16) * -360) / 16.0F)));
		} else {
			if (pBlockState.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.WALL) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() * -1));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
			}
			if (pBlockState.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.CEILING) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite().toYRot() * -1));
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
			}
			if (pBlockState.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.FLOOR) {
				pPoseStack.translate(0.5D, 0.5D, 0.5D);
				pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite().toYRot() * -1));
				pPoseStack.mulPose(Axis.XP.rotationDegrees(-90));
				pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
			}
		}
	}

	public void translateSignText(PoseStack pPoseStack, boolean pBack, Vec3 pVec3) {
		float scale = this.getSignTextRenderScale() * 0.015625F;

		if (!pBack) {
			pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
		}

		pPoseStack.translate(pVec3.x, pVec3.y, pVec3.z);
		pPoseStack.scale(scale, -scale, scale);
	}

	public Material getSignMaterial(WoodType pWoodType) {
		return Sheets.getSignMaterial(pWoodType);
	}

	public Vec3 getTextOffset() {
		return new Vec3(0.0D, 0.33333334D, 0.046666667D);
	}
}
