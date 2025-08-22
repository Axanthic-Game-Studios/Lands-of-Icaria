package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.SignModel;

import com.google.common.collect.ImmutableMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSignBlockRenderer extends SignRenderer {
	public Font font;

	public Map<WoodType, SignModel> map;

	public IcariaSignBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		super(pContext);
		this.font = pContext.getFont();
		this.map = WoodType.values().collect(ImmutableMap.toImmutableMap(woodType -> woodType, woodType -> new SignModel(SignRenderer.createSignModel(pContext.getModelSet(), woodType, true), SignRenderer.createSignModel(pContext.getModelSet(), woodType, false))));
	}

	public void drawFont(FormattedCharSequence pFormattedCharSequence, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, SignText pSignText, float pX, float pY, int pPackedLight) {
		if (pSignText.hasGlowingText()) {
			this.font.drawInBatch8xOutline(pFormattedCharSequence, -pX, pY, pSignText.getColor().getTextColor(), SignRenderer.getDarkColor(pSignText), pPoseStack.last().pose(), pMultiBufferSource, LightTexture.FULL_BRIGHT);
		} else {
			this.font.drawInBatch(pFormattedCharSequence, -pX, pY, SignRenderer.getDarkColor(pSignText), false, pPoseStack.last().pose(), pMultiBufferSource, Font.DisplayMode.POLYGON_OFFSET, 0, pPackedLight);
		}
	}

	@Override
	public void render(SignBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var blockState = pBlockEntity.getBlockState();
		if (blockState.getBlock() instanceof SignBlock signBlock) {
			var woodType = this.getWoodType(signBlock);
			var signModel = this.map.get(woodType);
			var model = signBlock instanceof StandingSignBlock ? signModel.pModelStanding() : signModel.pModelWall();
			this.renderSignWithText(blockState, model, pMultiBufferSource, pPoseStack, signBlock, pBlockEntity, woodType, pPackedLight, pPackedOverlay);
		}
	}

	public void renderSign(Model pModel, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, WoodType pWoodType, int pPackedLight, int pPackedOverlay) {
		var scale = this.getSignModelRenderScale();
		var vertexConsumer = this.getSignMaterial(pWoodType).buffer(pMultiBufferSource, pModel::renderType);
		pPoseStack.pushPose();
		pPoseStack.scale(scale, -scale, -scale);
		pModel.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, pPackedOverlay);
		pPoseStack.popPose();
	}

	public void renderSignText(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, SignText pSignText, boolean pBack, int pLineHeight, int pLineWidth, int pPackedLight) {
		pPoseStack.pushPose();
		this.translateSignText(pPoseStack, pBack);
		this.renderText(pMultiBufferSource, pPoseStack, pSignText, pLineHeight, pLineWidth, pPackedLight);
		pPoseStack.popPose();
	}

	public void renderSignWithText(BlockState pBlockState, Model pModel, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, SignBlock pSignBlock, SignBlockEntity pBlockEntity, WoodType pWoodType, int pPackedLight, int pPackedOverlay) {
		pPoseStack.pushPose();
		this.translateSign(pBlockState, pPoseStack, pSignBlock.getYRotationDegrees(pBlockState));
		this.renderSign(pModel, pMultiBufferSource, pPoseStack, pWoodType, pPackedLight, pPackedOverlay);
		this.renderSignText(pMultiBufferSource, pPoseStack, pBlockEntity.getFrontText(), false, pBlockEntity.getTextLineHeight(), pBlockEntity.getMaxTextLineWidth(), pPackedLight);
		this.renderSignText(pMultiBufferSource, pPoseStack, pBlockEntity.getBackText(), true, pBlockEntity.getTextLineHeight(), pBlockEntity.getMaxTextLineWidth(), pPackedLight);
		pPoseStack.popPose();
	}

	public void renderText(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, SignText pSignText, int pLineHeight, int pLineWidth, int pPackedLight) {
		var formattedCharSequences = pSignText.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), component -> this.font.split(component, pLineWidth).stream().findFirst().orElse(FormattedCharSequence.EMPTY));
		for (var line = 0; line < 4; ++line) {
			var formattedCharSequence = formattedCharSequences[line];
			this.drawFont(formattedCharSequence, pMultiBufferSource, pPoseStack, pSignText, this.font.width(formattedCharSequence) * 0.5F, line * pLineHeight - pLineHeight * 2.0F, pPackedLight);
		}
	}

	public void translateSign(BlockState pBlockState, PoseStack pPoseStack, float pYRot) {
		if (pBlockState.getBlock() instanceof StandingSignBlock) {
			this.translateStandingSign(pPoseStack, pYRot);
		} else {
			this.translateWallSign(pBlockState, pPoseStack);
		}
	}

	public void translateSignText(PoseStack pPoseStack, boolean pBack) {
		var scale = this.getSignTextRenderScale() * 0.015625F;
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pBack ? 180.0F : 0.0F));
		pPoseStack.translate(0.0D, 0.33333334D, 0.046666667D);
		pPoseStack.scale(scale, -scale, -scale);
	}

	public void translateStandingSign(PoseStack pPoseStack, float pYRot) {
		pPoseStack.translate(0.5D, this.getSignModelRenderScale() * 0.75D, 0.5D);
		pPoseStack.mulPose(Axis.YN.rotationDegrees(pYRot));
	}

	public void translateWallSign(BlockState pBlockState, PoseStack pPoseStack) {
		if (pBlockState.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.CEILING) {
			pPoseStack.translate(0.5D, 0.5D, 0.5D);
			pPoseStack.mulPose(Axis.YN.rotationDegrees(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite().toYRot()));
			pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
		} else if (pBlockState.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.FLOOR) {
			pPoseStack.translate(0.5D, 0.5D, 0.5D);
			pPoseStack.mulPose(Axis.YN.rotationDegrees(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite().toYRot()));
			pPoseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
			pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
		} else if (pBlockState.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.WALL) {
			pPoseStack.translate(0.5D, 0.5D, 0.5D);
			pPoseStack.mulPose(Axis.YN.rotationDegrees(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
			pPoseStack.translate(0.0D, -0.3125D, -0.4375D);
		}
	}

	@Override
	public Material getSignMaterial(WoodType pWoodType) {
		return Sheets.getSignMaterial(pWoodType);
	}

	public WoodType getWoodType(SignBlock pSignBlock) {
		return SignBlock.getWoodType(pSignBlock);
	}
}
