package com.axanthic.icaria.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CapellaSkullModel extends SkullModel {
	public ModelPart head;

	public CapellaSkullModel(ModelPart pModelPart) {
		super(pModelPart);
		this.head = pModelPart.getChild("head");
	}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, int pColor) {
		this.head.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 0).addBox(-2.5F, -4.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hornRightAdult = head.addOrReplaceChild("hornRightAdult", CubeListBuilder.create().texOffs(24, 39).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0027F, 0.8774F, -0.7854F, 0.0F, -0.7854F));
		PartDefinition hornRightInnerAdult = hornRightAdult.addOrReplaceChild("hornRightInnerAdult", CubeListBuilder.create().texOffs(8, 59).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, 0.5F, -0.576F, 0.0F, -0.7854F));
		PartDefinition hornRightCenterAdult = hornRightInnerAdult.addOrReplaceChild("hornRightCenterAdult", CubeListBuilder.create().texOffs(16, 59).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.7854F, 0.0F, -0.7854F));
		PartDefinition hornRightOuterAdult = hornRightCenterAdult.addOrReplaceChild("hornRightOuterAdult", CubeListBuilder.create().texOffs(40, 53).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.7854F, 0.7854F, -0.1963F));
		hornRightOuterAdult.addOrReplaceChild("hornRightTipAdult", CubeListBuilder.create().texOffs(0, 65).addBox(-0.5F, -4.5F, -0.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.7854F, 0.0F, 0.1963F));
		PartDefinition hornLeftAdult = head.addOrReplaceChild("hornLeftAdult", CubeListBuilder.create().texOffs(12, 39).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5039F, -3.0066F, 0.8735F, 0.7854F, 3.1416F, -2.3562F));
		PartDefinition hornLeftInnerAdult = hornLeftAdult.addOrReplaceChild("hornLeftInnerAdult", CubeListBuilder.create().texOffs(0, 39).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -1.0F, -0.576F, -0.7854F, 0.0F));
		PartDefinition hornLeftCenterAdult = hornLeftInnerAdult.addOrReplaceChild("hornLeftCenterAdult", CubeListBuilder.create().texOffs(24, 33).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.5F, 0.7854F, -0.7854F, 0.0F));
		PartDefinition hornLeftOuterAdult = hornLeftCenterAdult.addOrReplaceChild("hornLeftOuterAdult", CubeListBuilder.create().texOffs(48, 33).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.7854F, -0.1963F, -0.7854F));
		hornLeftOuterAdult.addOrReplaceChild("hornLeftTipAdult", CubeListBuilder.create().texOffs(36, 33).addBox(-0.5F, -0.75F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.7854F, 0.1963F, 0.0F));
		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(30, 24).addBox(-2.0F, -0.0036F, -0.0041F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -3.0F, -1.4399F, 0.0F, 0.0F));
		nose.addOrReplaceChild("noseFront", CubeListBuilder.create().texOffs(48, 39).addBox(-1.5F, -0.0522F, 0.0005F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.5872F, 0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 80, 80);
	}
}
