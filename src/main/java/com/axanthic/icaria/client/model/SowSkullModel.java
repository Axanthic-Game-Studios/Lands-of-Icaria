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

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SowSkullModel extends SkullModel {
	public ModelPart head;

	public SowSkullModel(ModelPart pModelPart) {
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

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 11).addBox(-2.5F, -6.0F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(47, 0).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0019F, -3.4354F, 0.182F, 0.0F, 0.0F));
		var mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -0.5375F, -3.0125F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4644F, -3.9229F));
		mouth.addOrReplaceChild("tuskRight", CubeListBuilder.create().texOffs(47, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5375F, -1.7125F, 0.0F, 0.0F, -0.3927F));
		mouth.addOrReplaceChild("tuskLeft", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5375F, -1.7125F, 0.0F, 0.0F, 0.3927F));
		head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(42, 26).addBox(-1.0F, -2.0106F, -3.0646F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5019F, -0.9354F, 0.0094F, 0.0F, 0.0F));
		head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(47, 6).addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3125F, -3.7519F, 0.5646F, 0.3927F, 0.0F, 2.0944F));
		head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(55, 6).addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -3.7519F, 0.5646F, -0.3927F, 0.0F, 1.0472F));

		return LayerDefinition.create(meshDefinition, 64, 48);
	}
}
