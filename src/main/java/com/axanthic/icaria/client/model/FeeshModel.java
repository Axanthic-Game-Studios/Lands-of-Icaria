package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.state.FeeshRenderState;
import com.axanthic.icaria.common.math.IcariaMath;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FeeshModel extends EntityModel<FeeshRenderState> {
	public ModelPart body;
	public ModelPart bodyRear;
	public ModelPart finRear;
	public ModelPart finLeft;
	public ModelPart finRight;
	public ModelPart finTop;
	public ModelPart finBottom;

	public FeeshModel(ModelPart pModelPart) {
		super(pModelPart);
		this.body = this.root.getChild("body");
		this.bodyRear = this.body.getChild("bodyRear");
		this.finRear = this.bodyRear.getChild("finRear");
		this.finLeft = this.body.getChild("finLeft");
		this.finRight = this.body.getChild("finRight");
		this.finTop = this.body.getChild("finTop");
		this.finBottom = this.body.getChild("finBottom");
	}

	@Override
	public void setupAnim(FeeshRenderState pRenderState) {
		super.setupAnim(pRenderState);

		this.idleAnim(pRenderState);
	}

	public void idleAnim(FeeshRenderState pRenderState) {
		var offset = RandomSource.create(pRenderState.id).nextIntBetweenInclusive(-1, 1);

		this.body.yRot = Mth.sin(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(11.25F);
		this.bodyRear.yRot = Mth.sin(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(11.25F);
		this.bodyRear.zRot = Mth.cos(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(11.25F);
		this.finRear.yRot = Mth.sin(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(11.25F);
		this.finRear.zRot = Mth.cos(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(11.25F);
		this.finLeft.yRot = Mth.cos(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(22.5F) + IcariaMath.rad(22.5F) + IcariaMath.rad(1.0F);
		this.finRight.yRot = Mth.cos(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(22.5F) - IcariaMath.rad(22.5F) - IcariaMath.rad(1.0F);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();

		var partDefinition = meshDefinition.getRoot();

		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -4.0F));
		var bodyRear = body.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 6.0F));
		bodyRear.addOrReplaceChild("finRear", CubeListBuilder.create().texOffs(16, 1).addBox(0.0F, -4.5F, 0.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));
		body.addOrReplaceChild("finLeft", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.5F, 1.0F, 0.0F, 0.3927F, 0.0F));
		body.addOrReplaceChild("finRight", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.5F, 1.0F, 0.0F, -0.3927F, 0.0F));
		body.addOrReplaceChild("finTop", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 1.0F));
		body.addOrReplaceChild("finBottom", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		return LayerDefinition.create(meshDefinition, 32, 32);
	}
}
