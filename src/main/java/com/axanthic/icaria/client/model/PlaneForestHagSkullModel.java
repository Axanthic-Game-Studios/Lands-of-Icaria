package com.axanthic.icaria.client.model;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PlaneForestHagSkullModel extends SkullModel {
	public PlaneForestHagSkullModel(ModelPart pModelPart) {
		super(pModelPart);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();

		var partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 10).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}
}
