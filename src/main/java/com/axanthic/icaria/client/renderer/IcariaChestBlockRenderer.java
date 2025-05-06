package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaIdents;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mojang.math.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ChestType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestBlockRenderer extends ChestRenderer<IcariaChestBlockEntity> {
	public Font font;

	public ModelPart leftBottom;
	public ModelPart leftLid;
	public ModelPart leftLock;
	public ModelPart rightBottom;
	public ModelPart rightLid;
	public ModelPart rightLock;
	public ModelPart singleBottom;
	public ModelPart singleLid;
	public ModelPart singleLock;

	public IcariaChestBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		super(pContext);
		var left = pContext.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT);
		var right = pContext.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT);
		var single = pContext.bakeLayer(ModelLayers.CHEST);
		this.font = pContext.getFont();
		this.leftBottom = left.getChild("bottom");
		this.leftLid = left.getChild("lid");
		this.leftLock = left.getChild("lock");
		this.rightBottom = right.getChild("bottom");
		this.rightLid = right.getChild("lid");
		this.rightLock = right.getChild("lock");
		this.singleBottom = single.getChild("bottom");
		this.singleLid = single.getChild("lid");
		this.singleLock = single.getChild("lock");
	}

	public int getDarkColor(int pColor) {
		if (pColor == 0) {
			return -988212;
		} else {
			var red = (int) (ARGB.red(pColor) / 2.5F);
			var green = (int) (ARGB.green(pColor) / 2.5F);
			var blue = (int) (ARGB.blue(pColor) / 2.5F);
			return ARGB.color(0, red, green, blue);
		}
	}

	public void drawFont(FormattedCharSequence pFormattedCharSequence, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, String pString, boolean pStyle, int pColor, int pOffset, int pPackedLight) {
		if (pStyle) {
			this.font.drawInBatch8xOutline(pFormattedCharSequence, pOffset - this.font.width(pString) * 0.5F, 0.0F, pColor, this.getDarkColor(pColor), pPoseStack.last().pose(), pMultiBufferSource, LightTexture.FULL_BRIGHT);
		} else {
			this.font.drawInBatch(pFormattedCharSequence, pOffset - this.font.width(pString) * 0.5F, 0.0F, pColor, false, pPoseStack.last().pose(), pMultiBufferSource, Font.DisplayMode.POLYGON_OFFSET, 0, pPackedLight);
		}
	}

	@Override
	public void render(IcariaChestBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay) {
		var blockState = pBlockEntity.getLevel() != null ? pBlockEntity.getBlockState() : pBlockEntity.getBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH);
		if (blockState.getBlock() instanceof ChestBlock chestBlock) {
			var chestType = blockState.getValue(BlockStateProperties.CHEST_TYPE);
			var neighborCombineResult = this.getCombiner(pBlockEntity, blockState, chestBlock);
			var material = this.getMaterial(pBlockEntity, chestType);
			var vertexConsumer = material.buffer(pMultiBufferSource, RenderType::entityCutout);

			var combiner = ChestBlock.opennessCombiner(pBlockEntity);
			var function = neighborCombineResult.apply(combiner);

			var angle = function.get(pPartialTick);

			angle = 1.0F - angle;
			angle = 1.0F - angle * angle * angle;

			pPoseStack.pushPose();

			this.translateChest(blockState, pPoseStack);
			this.renderChest(pBlockEntity, blockState, chestType, pMultiBufferSource, pPoseStack, vertexConsumer, angle, pPackedLight, pPackedOverlay);

			pPoseStack.popPose();
		}
	}

	public void render(ModelPart pBottom, ModelPart pLid, ModelPart pLock, PoseStack pPoseStack, VertexConsumer pVertexConsumer, float pAngle, int pPackedLight, int pPackedOverlay) {
		pLid.xRot = Mth.PI * pAngle * -0.5F;
		pLock.xRot = Mth.PI * pAngle * -0.5F;
		pLid.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay);
		pLock.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay);
		pBottom.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay);
	}

	public void renderChest(IcariaChestBlockEntity pBlockEntity, BlockState pBlockState, ChestType pChestType, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, VertexConsumer pVertexConsumer, float pAngle, int pPackedLight, int pPackedOverlay) {
		if (pChestType == ChestType.SINGLE) {
			this.render(this.singleBottom, this.singleLid, this.singleLock, pPoseStack, pVertexConsumer, pAngle, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_lid", pBlockEntity.getLabelUp(), pBlockEntity.hasLabelUp(), pBlockEntity.getStyleUp(), true, pAngle, 0.0F, pBlockEntity.getColorUp(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pBlockEntity, pBlockState, pMultiBufferSource, pPoseStack, pAngle, pPackedLight, pPackedOverlay);
		} else if (pChestType == ChestType.RIGHT) {
			this.render(this.rightBottom, this.rightLid, this.rightLock, pPoseStack, pVertexConsumer, pAngle, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_lid_right", pBlockEntity.getLabelUp(), pBlockEntity.hasLabelUp(), pBlockEntity.getStyleUp(), true, pAngle, 0.0F, pBlockEntity.getColorUp(), 5, pPackedLight, pPackedOverlay);
			this.renderRight(pBlockEntity, pBlockState, pMultiBufferSource, pPoseStack, pAngle, pPackedLight, pPackedOverlay);
		} else if (pChestType == ChestType.LEFT) {
			this.render(this.leftBottom, this.leftLid, this.leftLock, pPoseStack, pVertexConsumer, pAngle, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_lid_left", pBlockEntity.getLabelUp(), pBlockEntity.hasLabelUp(), pBlockEntity.getStyleUp(), true, pAngle, 0.0F, pBlockEntity.getColorUp(), -5, pPackedLight, pPackedOverlay);
			this.renderLeft(pBlockEntity, pBlockState, pMultiBufferSource, pPoseStack, pAngle, pPackedLight, pPackedOverlay);
		}
	}

	public void renderLeft(IcariaChestBlockEntity pBlockEntity, BlockState pBlockState, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, float pAngle, int pPackedLight, int pPackedOverlay) {
		if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_front_left", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 180.0F, pBlockEntity.getColorNorth(), -5, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_left_left", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 270.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_back_left", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 0.0F, pBlockEntity.getColorSouth(), 5, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_left_left", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 270.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_front_left", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 180.0F, pBlockEntity.getColorEast(), -5, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_back_left", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 0.0F, pBlockEntity.getColorWest(), 5, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_back_left", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 0.0F, pBlockEntity.getColorNorth(), 5, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_left_left", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 270.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_front_left", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 180.0F, pBlockEntity.getColorSouth(), -5, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_back_left", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 0.0F, pBlockEntity.getColorEast(), 5, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_left_left", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 270.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay);
			this.renderLeft(pMultiBufferSource, pPoseStack, "label_bottom_front_left", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 180.0F, pBlockEntity.getColorWest(), -5, pPackedLight, pPackedOverlay);
		}
	}

	public void renderRight(IcariaChestBlockEntity pBlockEntity, BlockState pBlockState, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, float pAngle, int pPackedLight, int pPackedOverlay) {
		if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_front_right", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 180.0F, pBlockEntity.getColorNorth(), 5, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_right_right", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 90.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_back_right", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 0.0F, pBlockEntity.getColorSouth(), -5, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_front_right", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 180.0F, pBlockEntity.getColorEast(), 5, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_right_right", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 90.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_back_right", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 0.0F, pBlockEntity.getColorWest(), -5, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_back_right", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 0.0F, pBlockEntity.getColorNorth(), -5, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_front_right", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 180.0F, pBlockEntity.getColorSouth(), 5, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_right_right", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 90.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_right_right", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 90.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_back_right", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 0.0F, pBlockEntity.getColorEast(), -5, pPackedLight, pPackedOverlay);
			this.renderRight(pMultiBufferSource, pPoseStack, "label_bottom_front_right", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 180.0F, pBlockEntity.getColorWest(), 5, pPackedLight, pPackedOverlay);
		}
	}

	public void renderSingle(IcariaChestBlockEntity pBlockEntity, BlockState pBlockState, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, float pAngle, int pPackedLight, int pPackedOverlay) {
		if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH) {
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_front", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 180.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_right", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 90.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_back", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 0.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_left", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 270.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST) {
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_left", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 270.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_front", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 180.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_right", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 90.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_back", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 0.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH) {
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_back", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 0.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_left", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 270.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_front", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 180.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_right", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 90.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay);
		} else if (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST) {
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_right", pBlockEntity.getLabelNorth(), pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, pAngle, 90.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_back", pBlockEntity.getLabelEast(), pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, pAngle, 0.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_left", pBlockEntity.getLabelSouth(), pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, pAngle, 270.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay);
			this.renderSingle(pMultiBufferSource, pPoseStack, "label_bottom_front", pBlockEntity.getLabelWest(), pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, pAngle, 180.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay);
		}
	}

	public void renderLeft(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, String pLabel, @Nullable String pText, boolean pCheck, boolean pStyle, boolean pUp, float pAngle, float pRotation, int pColor, int pOffset, int pPackedLight, int pPackedOverlay) {
		if (pCheck) {
			pPoseStack.pushPose();
			this.renderSprite(this.leftBottom, this.leftLid, this.leftLock, pMultiBufferSource, pPoseStack, pLabel, pAngle, pPackedLight, pPackedOverlay);
			this.renderString(pMultiBufferSource, pPoseStack, pText, pStyle, pUp, pAngle, pRotation, pColor, pOffset, pPackedLight);
			pPoseStack.popPose();
		}
	}

	public void renderRight(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, String pLabel, @Nullable String pText, boolean pCheck, boolean pStyle, boolean pUp, float pAngle, float pRotation, int pColor, int pOffset, int pPackedLight, int pPackedOverlay) {
		if (pCheck) {
			pPoseStack.pushPose();
			this.renderSprite(this.rightBottom, this.rightLid, this.rightLock, pMultiBufferSource, pPoseStack, pLabel, pAngle, pPackedLight, pPackedOverlay);
			this.renderString(pMultiBufferSource, pPoseStack, pText, pStyle, pUp, pAngle, pRotation, pColor, pOffset, pPackedLight);
			pPoseStack.popPose();
		}
	}

	public void renderSingle(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, String pLabel, @Nullable String pText, boolean pCheck, boolean pStyle, boolean pUp, float pAngle, float pRotation, int pColor, int pOffset, int pPackedLight, int pPackedOverlay) {
		if (pCheck) {
			pPoseStack.pushPose();
			this.renderSprite(this.singleBottom, this.singleLid, this.singleLock, pMultiBufferSource, pPoseStack, pLabel, pAngle, pPackedLight, pPackedOverlay);
			this.renderString(pMultiBufferSource, pPoseStack, pText, pStyle, pUp, pAngle, pRotation, pColor, pOffset, pPackedLight);
			pPoseStack.popPose();
		}
	}

	public void renderSprite(ModelPart pBottom, ModelPart pLid, ModelPart pLock, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, String pString, float pAngle, int pPackedLight, int pPackedOverlay) {
		this.render(pBottom, pLid, pLock, pPoseStack, new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity" + "/" + "chest" + "/" + pString)).buffer(pMultiBufferSource, RenderType::entityCutout), pAngle, pPackedLight, pPackedOverlay);
	}

	public void renderString(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, @Nullable String pString, boolean pStyle, boolean pUp, float pAngle, float pRotation, int pColor, int pOffset, int pPackedLight) {
		if (pString != null) {
			this.translateString(pPoseStack, pUp, Mth.PI * pAngle * 0.5F, pRotation);
			this.drawFont(FormattedCharSequence.forward(pString, Style.EMPTY), pMultiBufferSource, pPoseStack, pString, pStyle, pColor, pOffset, pPackedLight);
		}
	}

	public void translateChest(BlockState pBlockState, PoseStack pPoseStack) {
		pPoseStack.translate(0.5F, 0.5F, 0.5F);
		pPoseStack.mulPose(Axis.YN.rotationDegrees(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
		pPoseStack.translate(-0.5F, -0.5F, -0.5F);
	}

	public void translateString(PoseStack pPoseStack, boolean pUp, float pAngle, float pRotation) {
		if (pUp) {
			pPoseStack.scale(1.0001F, 1.0001F, 1.0001F);
			pPoseStack.translate(0.5F, 0.565F, 0.060F);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			pPoseStack.mulPose(Axis.XN.rotation(pAngle));
			pPoseStack.translate(0.0F, 0.405F, -0.310F);
			pPoseStack.scale(0.01F, 0.01F, 0.01F);
		} else {
			pPoseStack.scale(1.0001F, 1.0001F, 1.0001F);
			pPoseStack.translate(0.5F, 0.5F, 0.5F);
			pPoseStack.mulPose(Axis.YP.rotationDegrees(pRotation));
			pPoseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
			pPoseStack.translate(0.0F, 0.275F, -0.4375F);
			pPoseStack.scale(0.01F, 0.01F, 0.01F);
		}
	}

	public DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity> getCombiner(IcariaChestBlockEntity pBlockEntity, BlockState pBlockState, ChestBlock pChestBlock) {
		if (pBlockEntity.getLevel() != null) {
			return pChestBlock.combine(pBlockState, pBlockEntity.getLevel(), pBlockEntity.getBlockPos(), true);
		} else {
			return DoubleBlockCombiner.Combiner::acceptNone;
		}
	}

	@Override
	public Material getMaterial(IcariaChestBlockEntity pBlockEntity, ChestType pChestType) {
		if (pChestType == ChestType.RIGHT) {
			return new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity" + "/" + "chest" + "/" + this.getType(pBlockEntity) + "_" + "right"));
		} else if (pChestType == ChestType.LEFT) {
			return new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity" + "/" + "chest" + "/" + this.getType(pBlockEntity) + "_" + "left"));
		} else {
			return new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity" + "/" + "chest" + "/" + this.getType(pBlockEntity)));
		}
	}

	public String getType(IcariaChestBlockEntity pBlockEntity) {
		if (pBlockEntity.getBlockState().getBlock() == IcariaBlocks.TRAPPED_CHEST.get()) {
			return "trapped_chest";
		} else {
			return "chest";
		}
	}
}
