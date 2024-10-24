package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;
import com.axanthic.icaria.common.math.IcariaMath;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
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

public class MyrmekeQueenModel extends HierarchicalModel<MyrmekeQueenEntity> {
	public ModelPart root;
	public ModelPart head;
	public ModelPart body;
	public ModelPart legRightFront;
	public ModelPart legLeftFront;
	public ModelPart legRightCenter;
	public ModelPart legLeftCenter;
	public ModelPart legRightRear;
	public ModelPart legLeftRear;

	public MyrmekeQueenModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.head = this.root.getChild("head");
		this.body = this.root.getChild("body");
		this.legRightFront = this.root.getChild("legRightFront");
		this.legLeftFront = this.root.getChild("legLeftFront");
		this.legRightCenter = this.root.getChild("legRightCenter");
		this.legLeftCenter = this.root.getChild("legLeftCenter");
		this.legRightRear = this.root.getChild("legRightRear");
		this.legLeftRear = this.root.getChild("legLeftRear");
	}

	@Override
	public void setupAnim(MyrmekeQueenEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.lookAnim(pNetHeadYaw, pHeadPitch);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
	}

	public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
		this.head.xRot = IcariaMath.rad(pHeadPitch) + 0.2618F;
		this.head.yRot = IcariaMath.rad(pNetHeadYaw);
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		float f0 = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 0.0F) * 0.4F * pLimbSwingAmount;
		float f1 = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 1.0F) * 0.4F * pLimbSwingAmount;
		float f2 = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 0.5F) * 0.4F * pLimbSwingAmount;
		float f3 = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 1.5F) * 0.4F * pLimbSwingAmount;
		float f4 = Mth.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 0.0F) * 0.4F) * pLimbSwingAmount;
		float f5 = Mth.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 1.0F) * 0.4F) * pLimbSwingAmount;
		float f6 = Mth.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 0.5F) * 0.4F) * pLimbSwingAmount;
		float f7 = Mth.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 1.5F) * 0.4F) * pLimbSwingAmount;

		this.legRightFront.yRot = f3 + 2.2253F;
		this.legLeftFront.yRot = -f4 + 0.829F;
		this.legRightCenter.yRot = f1 + 3.1416F;
		this.legLeftCenter.yRot = -f2;
		this.legRightRear.yRot = f0 - 2.618F;
		this.legLeftRear.yRot = -f1 - 0.4363F;
		this.legRightFront.zRot = f7;
		this.legLeftFront.zRot = -f0;
		this.legRightCenter.zRot = f5;
		this.legLeftCenter.zRot = -f6;
		this.legRightRear.zRot = f4;
		this.legLeftRear.zRot = -f5;
	}

	public void translateToHead(PoseStack pPoseStack) {
		this.head.translateAndRotate(pPoseStack);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(42, 21).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(42, 15).addBox(-2.99F, 0.0F, -6.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 26).addBox(-3.5F, -0.5F, -4.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, -6.0F, 0.2618F, 0.0F, 0.0F));
		head.addOrReplaceChild("forehead", CubeListBuilder.create().texOffs(44, 10).addBox(-3.01F, -1.9201F, -0.897F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)).texOffs(50, 5).addBox(-1.0F, -1.9093F, -1.3681F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.3033F, -3.6881F, -1.3526F, 0.0F, 0.0F));
		head.addOrReplaceChild("toothRight", CubeListBuilder.create().texOffs(36, 27).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.3F, -6.0F, 0.0F, -0.1309F, 0.0F));
		head.addOrReplaceChild("toothLeft", CubeListBuilder.create().texOffs(23, 37).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.3F, -6.0F, 0.0F, 0.1309F, 0.0F));
		head.addOrReplaceChild("antennaRight", CubeListBuilder.create().texOffs(19, 37).addBox(-0.5F, -4.5F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(26, 17).addBox(-0.5F, -4.5F, -5.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.3F, -4.0F, 0.1745F, 0.0F, -0.4363F));
		head.addOrReplaceChild("antennaLeft", CubeListBuilder.create().texOffs(15, 37).addBox(-0.5F, -4.5F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 26).addBox(-0.5F, -4.5F, -5.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.3F, -4.0F, 0.1745F, 0.0F, 0.4363F));
		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(42, 5).addBox(-1.5F, -1.7F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(37, 36).addBox(-2.0F, -2.2F, 0.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(13, 8).addBox(-3.0F, -0.5F, 0.2F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(13, 0).addBox(-3.0F, -0.5F, 2.5F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 17).addBox(-2.5F, -0.701F, 4.8F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 29).addBox(-1.5F, -1.7F, 4.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.2F, -4.0F));
		body.addOrReplaceChild("neckUpper", CubeListBuilder.create().texOffs(22, 32).addBox(-1.999F, 0.8727F, -1.5469F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.9539F, -0.6313F, 0.2182F, 0.0F, 0.0F));
		body.addOrReplaceChild("neckLower", CubeListBuilder.create().texOffs(32, 16).addBox(-2.001F, 1.6481F, -0.0735F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.9539F, -0.6313F, -0.7418F, 0.0F, 0.0F));
		body.addOrReplaceChild("shoulderRightFront", CubeListBuilder.create().texOffs(57, 0).addBox(-2.9517F, -2.5942F, -5.2266F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.999F, 0.6942F, -0.2048F, 0.0F, 1.0908F, 0.0F));
		body.addOrReplaceChild("shoulderLeftFront", CubeListBuilder.create().texOffs(53, 0).addBox(-1.7414F, -2.5942F, 1.8677F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.999F, 0.6942F, -0.2048F, 0.0F, -1.0908F, 0.0F));
		body.addOrReplaceChild("shoulderRightRear", CubeListBuilder.create().texOffs(47, 0).addBox(0.9597F, -2.5942F, 6.2627F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.999F, 0.6942F, -0.2048F, 0.0F, -1.0908F, 0.0F));
		body.addOrReplaceChild("shoulderLeftRear", CubeListBuilder.create().texOffs(41, 0).addBox(-6.6527F, -2.5942F, -0.8316F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.999F, 0.6942F, -0.2048F, 0.0F, 1.0908F, 0.0F));
		body.addOrReplaceChild("back", CubeListBuilder.create().texOffs(21, 23).addBox(-1.499F, -5.8955F, -6.9095F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.8F, 10.0F, -0.1745F, 0.0F, 0.0F));
		var tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 33).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 46).addBox(-3.001F, 1.7929F, 1.2929F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 43).addBox(-3.0F, -1.9142F, 0.3F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, 7.0F, -0.0873F, 0.0F, 0.0F));
		tail.addOrReplaceChild("tailFront", CubeListBuilder.create().texOffs(23, 41).addBox(-3.002F, 0.4142F, -1.2929F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 2.5F, -0.7854F, 0.0F, 0.0F));
		tail.addOrReplaceChild("tailRearUpper", CubeListBuilder.create().texOffs(21, 47).addBox(-2.997F, -4.3F, 2.1922F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 5.5F, -0.48F, 0.0F, 0.0F));
		tail.addOrReplaceChild("tailRearLower", CubeListBuilder.create().texOffs(21, 43).addBox(-2.978F, -2.0698F, 3.0742F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.02F, 1.1921F, 4.5831F, -0.3491F, 0.0F, 0.0F));
		var legRightFront = partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 19.7F, -2.8F, 0.0F, 2.2253F, 0.0F));
		var legRightFrontUpper = legRightFront.addOrReplaceChild("legRightFrontUpper", CubeListBuilder.create().texOffs(27, 7).addBox(-0.5F, -0.3F, -0.3F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.2F, 0.0F, 0.0F, -0.7854F));
		var legRightFrontCenter = legRightFrontUpper.addOrReplaceChild("legRightFrontCenter", CubeListBuilder.create().texOffs(27, 0).addBox(0.6025F, -0.614F, -0.301F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
		legRightFrontCenter.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(7, 35).addBox(-0.2889F, -0.8F, -0.298F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4894F, 0.2291F, -0.002F, 0.0F, 0.0F, 0.48F));
		var legLeftFront = partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 19.7F, -2.8F, 0.0F, 0.829F, 0.0F));
		var legLeftFrontUpper = legLeftFront.addOrReplaceChild("legLeftFrontUpper", CubeListBuilder.create().texOffs(0, 31).addBox(-0.5F, -0.3F, -0.3F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.2F, 0.0F, 0.0F, -0.7854F));
		var legLeftFrontCenter = legLeftFrontUpper.addOrReplaceChild("legLeftFrontCenter", CubeListBuilder.create().texOffs(29, 30).addBox(0.6025F, -0.614F, -0.301F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
		legLeftFrontCenter.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(7, 37).addBox(-0.2889F, -0.8F, -0.298F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4894F, 0.2291F, -0.002F, 0.0F, 0.0F, 0.48F));
		var legRightCenter = partDefinition.addOrReplaceChild("legRightCenter", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 19.7F, -0.5F, 0.0F, 3.1416F, 0.0F));
		var legRightCenterUpper = legRightCenter.addOrReplaceChild("legRightCenterUpper", CubeListBuilder.create().texOffs(30, 4).addBox(-0.5F, -0.3F, 0.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.5F, 0.0F, 0.0F, -0.7854F));
		var legRightCenterCenter = legRightCenterUpper.addOrReplaceChild("legRightCenterCenter", CubeListBuilder.create().texOffs(18, 29).addBox(0.6025F, -0.614F, -0.001F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
		legRightCenterCenter.addOrReplaceChild("legRightCenterLower", CubeListBuilder.create().texOffs(31, 35).addBox(-0.2889F, -0.8F, 0.002F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4894F, 0.2291F, -0.002F, 0.0F, 0.0F, 0.48F));
		var legLeftCenter = partDefinition.addOrReplaceChild("legLeftCenter", CubeListBuilder.create(), PartPose.offset(3.0F, 19.7F, -0.5F));
		var legLeftCenterUpper = legLeftCenter.addOrReplaceChild("legLeftCenterUpper", CubeListBuilder.create().texOffs(30, 24).addBox(-0.5F, -0.3F, 0.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.5F, 0.0F, 0.0F, -0.7854F));
		var legLeftCenterCenter = legLeftCenterUpper.addOrReplaceChild("legLeftCenterCenter", CubeListBuilder.create().texOffs(30, 22).addBox(0.6025F, -0.614F, -0.001F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
		legLeftCenterCenter.addOrReplaceChild("legLeftCenterLower", CubeListBuilder.create().texOffs(0, 36).addBox(-0.2889F, -0.8F, 0.002F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4894F, 0.2291F, -0.002F, 0.0F, 0.0F, 0.48F));
		var legRightRear = partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 19.7F, 1.7F, 0.0F, -2.618F, 0.0F));
		var legRightRearUpper = legRightRear.addOrReplaceChild("legRightRearUpper", CubeListBuilder.create().texOffs(26, 27).addBox(-0.5F, -0.3F, 0.2F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.7F, 0.0F, 0.0F, -0.7854F));
		var legRightRearCenter = legRightRearUpper.addOrReplaceChild("legRightRearCenter", CubeListBuilder.create().texOffs(14, 27).addBox(0.6025F, -0.614F, 0.21F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
		legRightRearCenter.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(15, 35).addBox(-0.2889F, -0.8F, 0.202F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4894F, 0.2291F, -0.002F, 0.0F, 0.0F, 0.48F));
		var legLeftRear = partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 19.7F, 1.7F, 0.0F, -0.4363F, 0.0F));
		var legLeftRearUpper = legLeftRear.addOrReplaceChild("legLeftRearUpper", CubeListBuilder.create().texOffs(29, 14).addBox(-0.5F, -0.3F, 0.2F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.7F, 0.0F, 0.0F, -0.7854F));
		var legLeftRearCenter = legLeftRearUpper.addOrReplaceChild("legLeftRearCenter", CubeListBuilder.create().texOffs(29, 2).addBox(0.6025F, -0.614F, 0.21F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
		legLeftRearCenter.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(23, 35).addBox(-0.2889F, -0.8F, 0.202F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4894F, 0.2291F, -0.002F, 0.0F, 0.0F, 0.48F));

		return LayerDefinition.create(meshDefinition, 64, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
