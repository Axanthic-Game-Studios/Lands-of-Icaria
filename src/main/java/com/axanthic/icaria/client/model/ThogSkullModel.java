package com.axanthic.icaria.client.model;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.object.skull.SkullModel;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ThogSkullModel extends SkullModel {
	public ThogSkullModel(ModelPart pModelPart) {
		super(pModelPart);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 17).addBox(-4.5F, -5.0F, -3.5F, 9.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var forehead = head.addOrReplaceChild("forehead", CubeListBuilder.create().texOffs(28, 7).addBox(-3.5F, -1.575F, -3.575F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.1F, -0.05F, 0.0873F, 0.0F, 0.0F));
		forehead.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(16, 24).addBox(-1.775F, -2.3F, -0.325F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -1.65F, -0.95F, -0.2182F, 0.0F, 0.6545F));
		forehead.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(56, 24).addBox(-1.225F, -2.3F, -0.325F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -1.65F, -0.95F, -0.2182F, 0.0F, -0.6545F));
		head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(11, 1).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, -0.4F, -0.0873F, 0.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(31, 0).addBox(-2.5F, -1.5F, -4.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -3.5F));
		var jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(49, 0).addBox(-2.5F, -0.5F, -4.55F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, -2.45F, 0.0873F, 0.0F, 0.0F));
		jaw.addOrReplaceChild("tuskLeftAdult", CubeListBuilder.create().texOffs(22, 12).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.0F, -2.5F, -3.35F, 0.3927F, 0.0F, 0.0873F));
		jaw.addOrReplaceChild("tuskRightAdult", CubeListBuilder.create().texOffs(56, 12).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.0F, -2.5F, -3.35F, 0.3927F, 0.0F, -0.0873F));

		return LayerDefinition.create(meshDefinition, 80, 80);
	}
}
