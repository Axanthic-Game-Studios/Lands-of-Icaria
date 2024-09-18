package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaIdents;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mojang.math.MethodsReturnNonnullByDefault;

import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.AbstractChestBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ChestType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestBlockRenderer extends ChestRenderer<IcariaChestBlockEntity> {
	public Font font;

	public final ModelPart lid;
	public final ModelPart bottom;
	public final ModelPart lock;
	public final ModelPart doubleLeftLid;
	public final ModelPart doubleLeftBottom;
	public final ModelPart doubleLeftLock;
	public final ModelPart doubleRightLid;
	public final ModelPart doubleRightBottom;
	public final ModelPart doubleRightLock;

	public IcariaChestBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		super(pContext);
		this.font = pContext.getFont();
		var left = pContext.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT);
		this.doubleLeftBottom = left.getChild("bottom");
		this.doubleLeftLid = left.getChild("lid");
		this.doubleLeftLock = left.getChild("lock");
		var right = pContext.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT);
		this.doubleRightBottom = right.getChild("bottom");
		this.doubleRightLid = right.getChild("lid");
		this.doubleRightLock = right.getChild("lock");
		var single = pContext.bakeLayer(ModelLayers.CHEST);
		this.bottom = single.getChild("bottom");
		this.lid = single.getChild("lid");
		this.lock = single.getChild("lock");
	}

	public int getDarkColor(int pColor) {
		if (pColor == 0) {
			return -988212;
		} else {
			int r = (int) (FastColor.ARGB32.red(pColor) / 2.5F);
			int g = (int) (FastColor.ARGB32.green(pColor) / 2.5F);
			int b = (int) (FastColor.ARGB32.blue(pColor) / 2.5F);
			return FastColor.ARGB32.color(0, r, g, b);
		}
	}

	@Override
	public void render(IcariaChestBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
		boolean flag = pBlockEntity.getLevel() != null;

		var blockState = flag ? pBlockEntity.getBlockState() : Blocks.CHEST.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH);
		var chestType = blockState.hasProperty(BlockStateProperties.CHEST_TYPE) ? blockState.getValue(BlockStateProperties.CHEST_TYPE) : ChestType.SINGLE;
		var vertexConsumer = this.getMaterial(pBlockEntity, chestType).buffer(pBuffer, RenderType::entityCutout);

		DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity> neighborcombineresult;

		if (blockState.getBlock() instanceof AbstractChestBlock<?> chestBlock) {
			pPoseStack.pushPose();
			pPoseStack.translate(0.5F, 0.5F, 0.5F);
			pPoseStack.mulPose(Axis.YN.rotationDegrees(blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
			pPoseStack.translate(-0.5F, -0.5F, -0.5F);

			if (flag) {
				neighborcombineresult = chestBlock.combine(blockState, pBlockEntity.getLevel(), pBlockEntity.getBlockPos(), true);
			} else {
				neighborcombineresult = DoubleBlockCombiner.Combiner::acceptNone;
			}

			float angle = neighborcombineresult.apply(ChestBlock.opennessCombiner(pBlockEntity)).get(pPartialTick);

			angle = 1.0F - angle;
			angle = 1.0F - angle * angle * angle;

			if (chestType.equals(ChestType.SINGLE)) {
				this.render(angle, pPackedLight, pPackedOverlay, this.bottom, this.lid, this.lock, pPoseStack, vertexConsumer);
				this.renderSingle(pBlockEntity.hasLabelUp(), pBlockEntity.getStyleUp(), true, angle, 0.0F, pBlockEntity.getColorUp(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_lid", pBlockEntity.getLabelUp());
				if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.NORTH)) {
					this.renderSingle(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 180.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front", pBlockEntity.getLabelNorth());
					this.renderSingle(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 90.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_right", pBlockEntity.getLabelEast());
					this.renderSingle(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 0.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back", pBlockEntity.getLabelSouth());
					this.renderSingle(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 270.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_left", pBlockEntity.getLabelWest());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.EAST)) {
					this.renderSingle(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 270.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_left", pBlockEntity.getLabelNorth());
					this.renderSingle(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 180.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front", pBlockEntity.getLabelEast());
					this.renderSingle(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 90.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_right", pBlockEntity.getLabelSouth());
					this.renderSingle(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 0.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back", pBlockEntity.getLabelWest());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.SOUTH)) {
					this.renderSingle(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 0.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back", pBlockEntity.getLabelNorth());
					this.renderSingle(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 270.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_left", pBlockEntity.getLabelEast());
					this.renderSingle(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 180.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front", pBlockEntity.getLabelSouth());
					this.renderSingle(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 90.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_right", pBlockEntity.getLabelWest());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.WEST)) {
					this.renderSingle(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 90.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_right", pBlockEntity.getLabelNorth());
					this.renderSingle(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 0.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back", pBlockEntity.getLabelEast());
					this.renderSingle(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 270.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_left", pBlockEntity.getLabelSouth());
					this.renderSingle(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 180.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front", pBlockEntity.getLabelWest());
				}
			} else if (chestType.equals(ChestType.RIGHT)) {
				this.render(angle, pPackedLight, pPackedOverlay, this.doubleRightBottom, this.doubleRightLid, this.doubleRightLock, pPoseStack, vertexConsumer);
				this.renderRight(pBlockEntity.hasLabelUp(), pBlockEntity.getStyleUp(), true, angle, 0.0F, pBlockEntity.getColorUp(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_lid_right", pBlockEntity.getLabelUp());
				if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.NORTH)) {
					this.renderRight(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 180.0F, pBlockEntity.getColorNorth(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front_right", pBlockEntity.getLabelNorth());
					this.renderRight(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 90.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_right_right", pBlockEntity.getLabelEast());
					this.renderRight(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 0.0F, pBlockEntity.getColorSouth(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back_right", pBlockEntity.getLabelSouth());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.EAST)) {
					this.renderRight(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 180.0F, pBlockEntity.getColorEast(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front_right", pBlockEntity.getLabelEast());
					this.renderRight(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 90.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_right_right", pBlockEntity.getLabelSouth());
					this.renderRight(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 0.0F, pBlockEntity.getColorWest(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back_right", pBlockEntity.getLabelWest());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.SOUTH)) {
					this.renderRight(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 0.0F, pBlockEntity.getColorNorth(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back_right", pBlockEntity.getLabelNorth());
					this.renderRight(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 180.0F, pBlockEntity.getColorSouth(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front_right", pBlockEntity.getLabelSouth());
					this.renderRight(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 90.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_right_right", pBlockEntity.getLabelWest());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.WEST)) {
					this.renderRight(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 90.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_right_right", pBlockEntity.getLabelNorth());
					this.renderRight(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 0.0F, pBlockEntity.getColorEast(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back_right", pBlockEntity.getLabelEast());
					this.renderRight(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 180.0F, pBlockEntity.getColorWest(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front_right", pBlockEntity.getLabelWest());
				}
			} else if (chestType.equals(ChestType.LEFT)) {
				this.render(angle, pPackedLight, pPackedOverlay, this.doubleLeftBottom, this.doubleLeftLid, this.doubleLeftLock, pPoseStack, vertexConsumer);
				this.renderLeft(pBlockEntity.hasLabelUp(), pBlockEntity.getStyleUp(), true, angle, 0.0F, pBlockEntity.getColorUp(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_lid_left", pBlockEntity.getLabelUp());
				if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.NORTH)) {
					this.renderLeft(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 180.0F, pBlockEntity.getColorNorth(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front_left", pBlockEntity.getLabelNorth());
					this.renderLeft(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 270.0F, pBlockEntity.getColorWest(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_left_left", pBlockEntity.getLabelWest());
					this.renderLeft(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 0.0F, pBlockEntity.getColorSouth(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back_left", pBlockEntity.getLabelSouth());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.EAST)) {
					this.renderLeft(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 270.0F, pBlockEntity.getColorNorth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_left_left", pBlockEntity.getLabelNorth());
					this.renderLeft(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 180.0F, pBlockEntity.getColorEast(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front_left", pBlockEntity.getLabelEast());
					this.renderLeft(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 0.0F, pBlockEntity.getColorWest(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back_left", pBlockEntity.getLabelWest());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.SOUTH)) {
					this.renderLeft(pBlockEntity.hasLabelNorth(), pBlockEntity.getStyleNorth(), false, angle, 0.0F, pBlockEntity.getColorNorth(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back_left", pBlockEntity.getLabelNorth());
					this.renderLeft(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 270.0F, pBlockEntity.getColorEast(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_left_left", pBlockEntity.getLabelEast());
					this.renderLeft(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 180.0F, pBlockEntity.getColorSouth(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front_left", pBlockEntity.getLabelSouth());
				} else if (blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).equals(Direction.WEST)) {
					this.renderLeft(pBlockEntity.hasLabelEast(), pBlockEntity.getStyleEast(), false, angle, 0.0F, pBlockEntity.getColorEast(), 5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_back_left", pBlockEntity.getLabelEast());
					this.renderLeft(pBlockEntity.hasLabelSouth(), pBlockEntity.getStyleSouth(), false, angle, 270.0F, pBlockEntity.getColorSouth(), 0, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_left_left", pBlockEntity.getLabelSouth());
					this.renderLeft(pBlockEntity.hasLabelWest(), pBlockEntity.getStyleWest(), false, angle, 180.0F, pBlockEntity.getColorWest(), -5, pPackedLight, pPackedOverlay, pBuffer, pPoseStack, "label_bottom_front_left", pBlockEntity.getLabelWest());
				}
			}

			pPoseStack.popPose();
		}
	}

	public void render(float pLidAngle, int pPackedLight, int pPackedOverlay, ModelPart pBottom, ModelPart pLid, ModelPart pLock, PoseStack pPoseStack, VertexConsumer pConsumer) {
		pLid.xRot = Mth.PI * pLidAngle * -0.5F;
		pLock.xRot = pLid.xRot;
		pLid.render(pPoseStack, pConsumer, pPackedLight, pPackedOverlay);
		pLock.render(pPoseStack, pConsumer, pPackedLight, pPackedOverlay);
		pBottom.render(pPoseStack, pConsumer, pPackedLight, pPackedOverlay);
	}

	public void renderSingle(boolean pCheck, boolean pStyle, boolean pUp, float pAngle, float pRotation, int pColor, int pOffset, int pPackedLight, int pPackedOverlay, MultiBufferSource pBuffer, PoseStack pPoseStack, String pLabel, String pText) {
		if (pCheck) {
			this.renderSprite(pAngle, pPackedLight, pPackedOverlay, this.bottom, this.lid, this.lock, pBuffer, pPoseStack, pLabel);
			this.renderString(pStyle, pUp, pAngle, pRotation, pColor, pOffset, pPackedLight, pBuffer, pPoseStack, pText);
		}
	}

	public void renderRight(boolean pCheck, boolean pStyle, boolean pUp, float pAngle, float pRotation, int pColor, int pOffset, int pPackedLight, int pPackedOverlay, MultiBufferSource pBuffer, PoseStack pPoseStack, String pLabel, String pText) {
		if (pCheck) {
			this.renderSprite(pAngle, pPackedLight, pPackedOverlay, this.doubleRightBottom, this.doubleRightLid, this.doubleRightLock, pBuffer, pPoseStack, pLabel);
			this.renderString(pStyle, pUp, pAngle, pRotation, pColor, pOffset, pPackedLight, pBuffer, pPoseStack, pText);
		}
	}

	public void renderLeft(boolean pCheck, boolean pStyle, boolean pUp, float pAngle, float pRotation, int pColor, int pOffset, int pPackedLight, int pPackedOverlay, MultiBufferSource pBuffer, PoseStack pPoseStack, String pLabel, String pText) {
		if (pCheck) {
			this.renderSprite(pAngle, pPackedLight, pPackedOverlay, this.doubleLeftBottom, this.doubleLeftLid, this.doubleLeftLock, pBuffer, pPoseStack, pLabel);
			this.renderString(pStyle, pUp, pAngle, pRotation, pColor, pOffset, pPackedLight, pBuffer, pPoseStack, pText);
		}
	}

	public void renderSprite(float pAngle, int pPackedLight, int pPackedOverlay, ModelPart pBottom, ModelPart pLid, ModelPart pLock, MultiBufferSource pBuffer, PoseStack pPoseStack, String pString) {
		pPoseStack.pushPose();
		this.render(pAngle, pPackedLight, pPackedOverlay, pBottom, pLid, pLock, pPoseStack, new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity" + "/" + "chest" + "/" + pString)).buffer(pBuffer, RenderType::entityCutout));
		pPoseStack.popPose();
	}

	public void renderString(boolean pStyle, boolean pUp, float pAngle, float pRotation, int pColor, int pOffset, int pPackedLight, MultiBufferSource pBuffer, PoseStack pPoseStack, String pString) {
		var sequence = FormattedCharSequence.forward(pString, Style.EMPTY);

		pPoseStack.pushPose();
		if (pUp) {
			pPoseStack.translate(0.5F, 0.565F, 0.060F);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			pPoseStack.scale(1.0001F, 1.0001F, 1.0001F);
			pPoseStack.mulPose(Axis.XN.rotation(Mth.PI * pAngle * 0.5F));
			pPoseStack.translate(0.0F, 0.405F, -0.310F);
		} else {
			pPoseStack.translate(0.5F, 0.5F, 0.5F);
			pPoseStack.mulPose(Axis.YP.rotationDegrees(pRotation));
			pPoseStack.scale(1.0001F, 1.0001F, 1.0001F);
			pPoseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
			pPoseStack.translate(0.0F, 0.275F, -0.4375F);
		}

		pPoseStack.scale(0.01F, 0.01F, 0.01F);

		if (pStyle) {
			this.font.drawInBatch8xOutline(sequence, pOffset - this.font.width(pString) * 0.5F, 0.0F, pColor, this.getDarkColor(pColor), pPoseStack.last().pose(), pBuffer, 15728880);
		} else {
			this.font.drawInBatch(sequence, pOffset - this.font.width(pString) * 0.5F, 0.0F, pColor, false, pPoseStack.last().pose(), pBuffer, Font.DisplayMode.POLYGON_OFFSET, 0, pPackedLight);
		}

		pPoseStack.popPose();
	}

	@Override
	public Material getMaterial(IcariaChestBlockEntity pBlockEntity, ChestType pChestType) {
		if (pChestType.equals(ChestType.RIGHT)) {
			return new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity" + "/" + "chest" + "/" + this.getType(pBlockEntity) + "_" + "right"));
		} else if (pChestType.equals(ChestType.LEFT)) {
			return new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity" + "/" + "chest" + "/" + this.getType(pBlockEntity) + "_" + "left"));
		} else {
			return new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity" + "/" + "chest" + "/" + this.getType(pBlockEntity)));
		}
	}

	public String getType(IcariaChestBlockEntity pBlockEntity) {
		if (pBlockEntity.getBlockState().getBlock().equals(IcariaBlocks.TRAPPED_CHEST.get())) {
			return "trapped";
		} else {
			return "normal";
		}
	}
}
