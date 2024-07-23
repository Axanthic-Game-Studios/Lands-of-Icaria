package com.axanthic.icaria.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CerverSkullModel extends SkullModel {
	public ModelPart head;

	public CerverSkullModel(ModelPart pModelPart) {
		super(pModelPart);
		this.head = pModelPart.getChild("head");
	}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, int pColor) {
		this.head.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
	}

	@Override
	public void setupAnim(float pX, float pY, float pZ) {
		this.head.xRot = pZ * (Mth.PI / 180.0F);
		this.head.yRot = pY * (Mth.PI / 180.0F);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(66, 21).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(12, 20).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.9944F, -3.038F));
		snout.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(12, 44).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.3F));
		snout.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(24, 18).addBox(-1.5F, -0.5166F, -3.611F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3875F, 0.0F, 0.1963F, 0.0F, 0.0F));
		head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, -5.7444F, 0.462F, 0.0F, -0.5236F, 0.7854F));
		head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -5.7444F, 0.462F, 0.5236F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshDefinition, 96, 64);
	}
}
