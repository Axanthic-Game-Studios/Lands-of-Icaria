package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.state.FisshhRenderState;
import com.axanthic.icaria.common.math.IcariaMath;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
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

public class FisshhModel extends EntityModel<FisshhRenderState> {
	public ModelPart body;
	public ModelPart finRear;
	public ModelPart finLeft;
	public ModelPart finRight;

	public FisshhModel(ModelPart pModelPart) {
		super(pModelPart);
		this.body = this.root.getChild("body");
		this.finRear = this.body.getChild("finRear");
		this.finLeft = this.body.getChild("finLeft");
		this.finRight = this.body.getChild("finRight");
	}

	@Override
	public void setupAnim(FisshhRenderState pRenderState) {
		super.setupAnim(pRenderState);

		this.idleAnim(pRenderState);
	}

	public void idleAnim(FisshhRenderState pRenderState) {
		var offset = RandomSource.create(pRenderState.id).nextIntBetweenInclusive(-1, 1);

		this.body.yRot = Mth.sin(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(11.25F);
		this.finRear.yRot = Mth.sin(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(22.5F);
		this.finRear.zRot = Mth.cos(offset + pRenderState.ageInTicks * 0.25F) * IcariaMath.rad(22.5F);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();

		var partDefinition = meshDefinition.getRoot();

		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, -4.5F, 0.7854F, 0.0F, 0.0F));
		body.addOrReplaceChild("finRear", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -0.5F, -0.5F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.5F, 5.5F));
		body.addOrReplaceChild("finLeft", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.0F, 2.0F, 0.0F, 0.7854F, 1.5708F));
		body.addOrReplaceChild("finRight", CubeListBuilder.create().texOffs(14, 6).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.0F, 2.0F, 0.0F, 0.7854F, 1.5708F));

		return LayerDefinition.create(meshDefinition, 32, 32);
	}
}
