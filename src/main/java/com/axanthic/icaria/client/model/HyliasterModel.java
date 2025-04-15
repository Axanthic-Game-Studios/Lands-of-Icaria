package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.client.state.HyliasterRenderState;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliasterModel extends EntityModel<HyliasterRenderState> {
	public ModelPart head;
	public ModelPart body;

	public HyliasterModel(ModelPart pModelPart) {
		super(pModelPart);
		this.head = this.root.getChild("head");
		this.body = this.root.getChild("body");
	}

	@Override
	public void setupAnim(HyliasterRenderState pRenderState) {
		super.setupAnim(pRenderState);

		this.animate(pRenderState.moveAnimationState, IcariaAnimations.HYLIASTER_MOVE, pRenderState.ageInTicks);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();

		var partDefinition = meshDefinition.getRoot();

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));
		head.addOrReplaceChild("eyeRight", CubeListBuilder.create().texOffs(33, 0).addBox(-4.0F, -7.0F, -4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		head.addOrReplaceChild("eyeLeft", CubeListBuilder.create().texOffs(21, 0).addBox(1.0F, -7.0F, -4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 14).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 48);
	}
}
