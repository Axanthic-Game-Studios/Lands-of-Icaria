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

public class CrocottaSkullModel extends SkullModel {
	public ModelPart head;

	public CrocottaSkullModel(ModelPart pModelPart) {
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

		PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(40, 69).addBox(-4.25F, -1.1006F, 0.0021F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9994F, 0.9979F, -0.3491F, 0.0F, 0.1309F));
		head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(46, 69).addBox(2.25F, -1.1006F, 0.0021F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9994F, 0.9979F, -0.3491F, 0.0F, -0.1309F));
		PartDefinition noseRearUpper = head.addOrReplaceChild("noseRearUpper", CubeListBuilder.create().texOffs(0, 58).addBox(-2.0F, -1.9749F, -2.536F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.063F, -3.0023F, 0.1745F, 0.0F, 0.0F));
		noseRearUpper.addOrReplaceChild("noseFrontUpper", CubeListBuilder.create().texOffs(32, 69).addBox(-1.5F, 0.0005F, -0.9983F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.9754F, -2.5377F));
		PartDefinition noseRearLower = head.addOrReplaceChild("noseRearLower", CubeListBuilder.create().texOffs(22, 58).addBox(-2.0F, 0.0241F, -2.5366F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.063F, -3.0023F, 0.2618F, 0.0F, 0.0F));
		noseRearLower.addOrReplaceChild("noseFrontLower", CubeListBuilder.create().texOffs(32, 72).addBox(-1.5F, -1.0009F, -0.9971F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.025F, -2.5395F));

		return LayerDefinition.create(meshDefinition, 80, 80);
	}
}
