package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.state.NatureJellyfishRenderState;
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

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class NatureJellyfishModel extends EntityModel<NatureJellyfishRenderState> {
	public ModelPart body;
	public ModelPart bell;
	public ModelPart tentacleNorth;
	public ModelPart tentacleEast;
	public ModelPart tentacleSouth;
	public ModelPart tentacleWest;
	public ModelPart head;
	public ModelPart armNorthEast;
	public ModelPart armSouthEast;
	public ModelPart armSouth;
	public ModelPart armSouthWest;
	public ModelPart armNorthWest;

	public NatureJellyfishModel(ModelPart pModelPart) {
		super(pModelPart);
		this.body = this.root.getChild("body");
		this.bell = this.body.getChild("bell");
		this.tentacleNorth = this.bell.getChild("tentacleNorth");
		this.tentacleEast = this.bell.getChild("tentacleEast");
		this.tentacleSouth = this.bell.getChild("tentacleSouth");
		this.tentacleWest = this.bell.getChild("tentacleWest");
		this.head = this.body.getChild("head");
		this.armNorthEast = this.head.getChild("armNorthEast");
		this.armSouthEast = this.head.getChild("armSouthEast");
		this.armSouth = this.head.getChild("armSouth");
		this.armSouthWest = this.head.getChild("armSouthWest");
		this.armNorthWest = this.head.getChild("armNorthWest");
	}

	@Override
	public void setupAnim(NatureJellyfishRenderState pRenderState) {
		super.setupAnim(pRenderState);

		this.swimAnim(pRenderState.tentacleAngle);
	}

	public void swimAnim(float pTentacleAngle) {
		this.root.xScale = pTentacleAngle / 5.0F + 0.85F;
		this.root.yScale = -pTentacleAngle / 7.5F + 1.15F;
		this.root.zScale = pTentacleAngle / 5.0F + 0.85F;

		this.tentacleNorth.xRot = -pTentacleAngle * IcariaMath.rad(22.5F) - IcariaMath.rad(22.5F);
		this.tentacleEast.xRot = -pTentacleAngle * IcariaMath.rad(22.5F) - IcariaMath.rad(22.5F);
		this.tentacleSouth.xRot = pTentacleAngle * IcariaMath.rad(22.5F) + IcariaMath.rad(22.5F);
		this.tentacleWest.xRot = pTentacleAngle * IcariaMath.rad(22.5F) + IcariaMath.rad(22.5F);
		this.armNorthEast.xRot = -pTentacleAngle * IcariaMath.rad(22.5F) - IcariaMath.rad(22.5F);
		this.armSouthEast.xRot = -pTentacleAngle * IcariaMath.rad(22.5F) - IcariaMath.rad(22.5F);
		this.armSouth.xRot = -pTentacleAngle * IcariaMath.rad(22.5F) - IcariaMath.rad(22.5F);
		this.armSouthWest.xRot = -pTentacleAngle * IcariaMath.rad(22.5F) - IcariaMath.rad(22.5F);
		this.armNorthWest.xRot = -pTentacleAngle * IcariaMath.rad(22.5F) - IcariaMath.rad(22.5F);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();

		var partDefinition = meshDefinition.getRoot();

		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var bell = body.addOrReplaceChild("bell", CubeListBuilder.create().texOffs(0, 22).addBox(-6.5F, -24.0F, -6.5F, 13.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		bell.addOrReplaceChild("tentacleNorth", CubeListBuilder.create().texOffs(13, 47).addBox(-6.5F, 0.0F, 0.0F, 13.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, -6.5F, -0.3927F, 0.0F, 0.0F));
		bell.addOrReplaceChild("tentacleEast", CubeListBuilder.create().texOffs(13, 47).addBox(-6.5F, 0.0F, 0.0F, 13.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -22.0F, 0.0F, -0.3927F, 1.5708F, 0.0F));
		bell.addOrReplaceChild("tentacleSouth", CubeListBuilder.create().texOffs(0, 38).addBox(-6.5F, 0.0F, 0.0F, 13.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 6.5F, 0.3927F, 0.0F, 0.0F));
		bell.addOrReplaceChild("tentacleWest", CubeListBuilder.create().texOffs(0, 38).addBox(-6.5F, 0.0F, 0.0F, 13.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -22.0F, 0.0F, 0.3927F, 1.5708F, 0.0F));
		var head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(37, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));
		head.addOrReplaceChild("shoulderNorth", CubeListBuilder.create().texOffs(48, 50).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -3.0F, 0.7854F, 0.0F, 0.0F));
		head.addOrReplaceChild("shoulderEast", CubeListBuilder.create().texOffs(46, 56).addBox(-2.0F, -1.0F, -3.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		head.addOrReplaceChild("shoulderSouth", CubeListBuilder.create().texOffs(30, 50).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 3.0F, 0.7854F, 0.0F, 0.0F));
		head.addOrReplaceChild("shoulderWest", CubeListBuilder.create().texOffs(30, 55).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		head.addOrReplaceChild("armNorthEast", CubeListBuilder.create().texOffs(0, 50).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.3927F, 0.5236F, 0.0F));
		head.addOrReplaceChild("armSouthEast", CubeListBuilder.create().texOffs(6, 50).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.3927F, 1.7802F, 0.0F));
		head.addOrReplaceChild("armSouth", CubeListBuilder.create().texOffs(12, 50).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.3927F, 3.0369F, 0.0F));
		head.addOrReplaceChild("armSouthWest", CubeListBuilder.create().texOffs(24, 50).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.3927F, -1.9897F, 0.0F));
		head.addOrReplaceChild("armNorthWest", CubeListBuilder.create().texOffs(18, 50).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.3927F, -0.733F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 64);
	}
}
