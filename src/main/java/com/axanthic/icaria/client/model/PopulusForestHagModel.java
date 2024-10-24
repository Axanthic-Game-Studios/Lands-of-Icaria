package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.math.IcariaMath;

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

public class PopulusForestHagModel extends HierarchicalModel<ForestHagEntity> {
	public ModelPart root;
	public ModelPart bodyMainRight;
	public ModelPart bodyLowerRight;
	public ModelPart bodyLowerLeft;
	public ModelPart bodyCenterRight;
	public ModelPart bodyCenterLeft;
	public ModelPart bodyUpperRight;
	public ModelPart bodyUpperLeft;
	public ModelPart shoulderRight;
	public ModelPart neckMain;
	public ModelPart headMain;
	public ModelPart shoulderLeft;
	public ModelPart armLeftUpper;
	public ModelPart armLeftLower;
	public ModelPart shroomStem;
	public ModelPart shroomRing;
	public ModelPart shroomHead;
	public ModelPart armRightUpper;
	public ModelPart armRightLower;
	public ModelPart shoulderRightLeavesUpper;
	public ModelPart shoulderRightLeavesCenter;
	public ModelPart shoulderRightLeavesLower;
	public ModelPart bodyLowerTwigUpper;
	public ModelPart bodyLowerTwigLower;
	public ModelPart thighRight;
	public ModelPart legRight;
	public ModelPart thighLeft;
	public ModelPart legLeft;
	public ModelPart kneeLeft;

	public PopulusForestHagModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyMainRight = this.root.getChild("bodyMainRight");
		this.bodyLowerRight = this.bodyMainRight.getChild("bodyLowerRight");
		this.bodyLowerLeft = this.bodyLowerRight.getChild("bodyLowerLeft");
		this.bodyCenterRight = this.bodyLowerRight.getChild("bodyCenterRight");
		this.bodyCenterLeft = this.bodyCenterRight.getChild("bodyCenterLeft");
		this.bodyUpperRight = this.bodyCenterRight.getChild("bodyUpperRight");
		this.bodyUpperLeft = this.bodyUpperRight.getChild("bodyUpperLeft");
		this.shoulderRight = this.bodyUpperRight.getChild("shoulderRight");
		this.neckMain = this.shoulderRight.getChild("neckMain");
		this.headMain = this.neckMain.getChild("headMain");
		this.shoulderLeft = this.shoulderRight.getChild("shoulderLeft");
		this.armLeftUpper = this.shoulderLeft.getChild("armLeftUpper");
		this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
		this.shroomStem = this.shoulderLeft.getChild("shroomStem");
		this.shroomRing = this.shroomStem.getChild("shroomRing");
		this.shroomHead = this.shroomStem.getChild("shroomHead");
		this.armRightUpper = this.shoulderRight.getChild("armRightUpper");
		this.armRightLower = this.armRightUpper.getChild("armRightLower");
		this.shoulderRightLeavesUpper = this.shoulderRight.getChild("shoulderRightLeavesUpper");
		this.shoulderRightLeavesCenter = this.shoulderRightLeavesUpper.getChild("shoulderRightLeavesCenter");
		this.shoulderRightLeavesLower = this.shoulderRightLeavesCenter.getChild("shoulderRightLeavesLower");
		this.bodyLowerTwigUpper = this.bodyLowerRight.getChild("bodyLowerTwigUpper");
		this.bodyLowerTwigLower = this.bodyLowerRight.getChild("bodyLowerTwigLower");
		this.thighRight = this.bodyMainRight.getChild("thighRight");
		this.legRight = this.thighRight.getChild("legRight");
		this.thighLeft = this.bodyMainRight.getChild("thighLeft");
		this.legLeft = this.thighLeft.getChild("legLeft");
		this.kneeLeft = this.legLeft.getChild("kneeLeft");
	}

	@Override
	public void setupAnim(ForestHagEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.armRightUpper.xRot = -0.3927F;
		this.armRightUpper.zRot = 0.1373F;
		this.armLeftUpper.xRot = -0.3927F;
		this.armLeftUpper.zRot = -0.1896F;

		this.attackAnim();
		this.idleAnim(pAgeInTicks);
		this.lookAnim(pHeadPitch, pNetHeadYaw);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
	}

	public void attackAnim() {
		float f = Mth.sin(this.attackTime * Mth.PI);
		if (this.attackTime > 0.0F) {
			this.armRightUpper.zRot -= f;
			this.armLeftUpper.zRot += f;
		}
	}

	public void idleAnim(float pAgeInTicks) {
		this.armRightUpper.xRot += Mth.sin(pAgeInTicks * 0.06F) * 0.05F;
		this.armRightUpper.zRot += Mth.cos(pAgeInTicks * 0.09F) * 0.05F;
		this.armLeftUpper.xRot -= Mth.sin(pAgeInTicks * 0.06F) * 0.05F;
		this.armLeftUpper.zRot -= Mth.cos(pAgeInTicks * 0.09F) * 0.05F;

		this.wiggleRotateAngles(this.bodyLowerRight, 0.1023F, 0.0F, 0.0199F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyLowerLeft, 0.015F, 0.0F, 0.0897F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyCenterRight, 0.1023F, 0.0F, 0.0199F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyCenterLeft, 0.015F, 0.0F, 0.0374F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperRight, 0.1023F, 0.0F, 0.0199F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperLeft, 0.015F, 0.0F, 0.0723F, pAgeInTicks);
		this.wiggleRotateAngles(this.shoulderRight, 0.1023F, 0.0F, 0.0199F, pAgeInTicks);
		this.wiggleRotateAngles(this.neckMain, 0.8004F, 0.0873F, 0.0199F, pAgeInTicks);
		this.wiggleRotateAngles(this.shoulderLeft, 0.015F, 0.0F, 0.0723F, pAgeInTicks);
		this.wiggleRotateAngles(this.shroomStem, 0.015F, 0.0F, -0.1895F, pAgeInTicks);
		this.wiggleRotateAngles(this.shroomRing, 0.015F, 0.182F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.shroomHead, 0.015F, -0.0456F, 0.0723F, pAgeInTicks);
		this.wiggleRotateAngles(this.shoulderRightLeavesUpper, 0.1023F, 0.0F, 0.0199F, pAgeInTicks);
		this.wiggleRotateAngles(this.shoulderRightLeavesCenter, -0.1246F, 0.0F, -0.0237F, pAgeInTicks);
		this.wiggleRotateAngles(this.shoulderRightLeavesLower, -0.1246F, 0.0F, -0.0237F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyLowerTwigUpper, 0.1023F, -0.4098F, -0.6068F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyLowerTwigLower, 0.1023F, -0.1047F, 0.9866F, pAgeInTicks);
	}

	public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
		this.headMain.xRot = IcariaMath.rad(pHeadPitch) - 0.9599F;
		this.headMain.yRot = IcariaMath.rad(pNetHeadYaw) + 0.0873F;
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount;

		this.armRightUpper.xRot = Mth.cos(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount - 0.3927F;
		this.armRightLower.xRot = Mth.cos(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount - pLimbSwingAmount - 0.3927F;
		this.thighRight.xRot = Mth.cos(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount - 0.0873F;
		this.legRight.xRot = Mth.sin(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount + pLimbSwingAmount + 0.0873F;
		this.armLeftUpper.xRot = Mth.cos(pLimbSwing * 0.6F) * pLimbSwingAmount - 0.3927F;
		this.armLeftLower.xRot = Mth.cos(pLimbSwing * 0.6F) * pLimbSwingAmount - pLimbSwingAmount - 0.3927F;
		this.thighLeft.xRot = Mth.cos(pLimbSwing * 0.6F) * pLimbSwingAmount - 0.0873F;
		this.kneeLeft.xRot = Mth.sin(pLimbSwing * 0.6F) * pLimbSwingAmount + pLimbSwingAmount + 0.0873F;
	}

	public void wiggleRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ, float pAgeInTicks) {
		pModelPart.xRot = Mth.cos(pAgeInTicks * 0.045F) * 0.015F + pX;
		pModelPart.yRot = Mth.sin(pAgeInTicks * 0.035F) * 0.015F + pY;
		pModelPart.zRot = -Mth.cos(pAgeInTicks * 0.04F) * 0.015F + pZ;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bodyMainRight = partDefinition.addOrReplaceChild("bodyMainRight", CubeListBuilder.create().texOffs(66, 35).addBox(-6.5F, 0.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, -0.0873F, 0.0F, -0.1745F));
		bodyMainRight.addOrReplaceChild("bodyMainLeft", CubeListBuilder.create().texOffs(0, 58).addBox(0.0F, 0.5F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, -0.9F, 0.0F, 0.0F, 0.0F, 0.1745F));
		var bodyLowerRight = bodyMainRight.addOrReplaceChild("bodyLowerRight", CubeListBuilder.create().texOffs(44, 69).addBox(-6.0F, 0.0F, -1.5F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, -3.2F, -0.2F, 0.1023F, 0.0F, 0.0199F));
		bodyLowerRight.addOrReplaceChild("bodyLowerLeft", CubeListBuilder.create().texOffs(73, 43).addBox(0.0F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, -0.4F, -0.3F, 0.015F, 0.0F, 0.0897F));
		var bodyCenterRight = bodyLowerRight.addOrReplaceChild("bodyCenterRight", CubeListBuilder.create().texOffs(24, 78).addBox(-5.9F, 0.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, -3.2F, -0.3F, 0.1023F, 0.0F, 0.0199F));
		bodyCenterRight.addOrReplaceChild("bodyCenterLeft", CubeListBuilder.create().texOffs(40, 76).addBox(0.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, -0.4F, -0.2F, 0.015F, 0.0F, 0.0374F));
		var bodyUpperRight = bodyCenterRight.addOrReplaceChild("bodyUpperRight", CubeListBuilder.create().texOffs(64, 52).addBox(-7.5F, 0.0F, -1.5F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, -3.5F, -0.3F, 0.1023F, 0.0F, 0.0199F));
		bodyUpperRight.addOrReplaceChild("bodyUpperLeft", CubeListBuilder.create().texOffs(73, 9).addBox(0.0F, -0.1F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, -0.4F, -0.2F, 0.015F, 0.0F, 0.0723F));
		var shoulderRight = bodyUpperRight.addOrReplaceChild("shoulderRight", CubeListBuilder.create().texOffs(20, 39).addBox(-10.0F, 0.0F, -2.0F, 12.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, -3.3F, -0.3F, 0.1023F, 0.0F, 0.0199F));
		var neckMain = shoulderRight.addOrReplaceChild("neckMain", CubeListBuilder.create().texOffs(0, 36).addBox(-1.5F, -7.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, 1.8F, -0.4F, 0.8004F, 0.0873F, 0.0199F));
		neckMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(56, 20).addBox(-3.0F, -5.0F, -1.5F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -8.0F, -3.4F, -0.9599F, 0.0873F, 0.0349F));
		var shoulderLeft = shoulderRight.addOrReplaceChild("shoulderLeft", CubeListBuilder.create().texOffs(45, 40).addBox(0.0F, 0.2F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, -1.5F, -0.2F, 0.015F, 0.0F, 0.0723F));
		var armLeftUpper = shoulderLeft.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(78, 75).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6F, 1.8F, -0.3F, -0.3927F, 0.0F, -0.1896F));
		armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(54, 82).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.4F, 0.1F, -0.3927F, 0.0F, 0.0873F));
		var shroomStem = shoulderLeft.addOrReplaceChild("shroomStem", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.0F, -0.2F, 0.015F, 0.0F, -0.1895F));
		shroomStem.addOrReplaceChild("shroomRing", CubeListBuilder.create().texOffs(0, 69).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.015F, 0.182F, -0.015F));
		var shroomHead = shroomStem.addOrReplaceChild("shroomHead", CubeListBuilder.create().texOffs(0, 20).addBox(-6.0F, -13.0F, -6.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.5F, 0.0F, 0.015F, -0.0456F, 0.0723F));
		shroomHead.addOrReplaceChild("shroomHeadMain", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -13.0F, -9.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.98F, 0.0F));
		shroomHead.addOrReplaceChild("shroomHeadNorth", CubeListBuilder.create().texOffs(0, 51).addBox(-6.0F, -10.0F, -10.0F, 12.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
		shroomHead.addOrReplaceChild("shroomHeadEast", CubeListBuilder.create().texOffs(36, 24).addBox(-10.0F, -10.0F, -6.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
		shroomHead.addOrReplaceChild("shroomHeadSouth", CubeListBuilder.create().texOffs(32, 52).addBox(-6.0F, -10.0F, 6.0F, 12.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
		shroomHead.addOrReplaceChild("shroomHeadWest", CubeListBuilder.create().texOffs(0, 36).addBox(6.0F, -10.0F, -6.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
		var armRightUpper = shoulderRight.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(82, 59).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8F, 0.7F, -0.3F, -0.3927F, 0.0F, 0.1373F));
		armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(16, 76).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.4F, 0.1F, -0.3927F, 0.0F, -0.0873F));
		var shoulderRightLeavesUpper = shoulderRight.addOrReplaceChild("shoulderRightLeavesUpper", CubeListBuilder.create().texOffs(24, 59).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.5F, 3.8F, 0.1023F, 0.0F, 0.0199F));
		var shoulderRightLeavesCenter = shoulderRightLeavesUpper.addOrReplaceChild("shoulderRightLeavesCenter", CubeListBuilder.create().texOffs(48, 59).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.1246F, 0.0F, -0.0237F));
		shoulderRightLeavesCenter.addOrReplaceChild("shoulderRightLeavesLower", CubeListBuilder.create().texOffs(54, 0).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.1246F, 0.0F, -0.0237F));
		bodyLowerRight.addOrReplaceChild("bodyLowerTwigUpper", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6F, 1.2F, -0.2F, 0.1023F, -0.4098F, -0.6068F));
		bodyLowerRight.addOrReplaceChild("bodyLowerTwigLower", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.8F, 0.4F, 0.1023F, -0.1047F, 0.9866F));
		var thighRight = bodyMainRight.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(36, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, 3.3F, 0.0F, -0.0873F, 0.0F, 0.2443F));
		var legRight = thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(62, 75).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0873F, 0.0F, -0.0349F));
		legRight.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(67, 64).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.3F, 0.0F, 0.0873F, 0.0873F, -0.0349F));
		var thighLeft = bodyMainRight.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(24, 69).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9077F, 3.8556F, 0.0F, -0.0873F, 0.0F, 0.0698F));
		var legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(0, 76).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.0F, 0.0F, 0.0349F));
		var kneeLeft = legLeft.addOrReplaceChild("kneeLeft", CubeListBuilder.create().texOffs(0, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3F, 0.0F, 0.0873F, 0.0F, 0.0349F));
		var footLeft = kneeLeft.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(78, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, 0.0873F, 0.0F, 0.0349F));
		footLeft.addOrReplaceChild("soleLeft", CubeListBuilder.create().texOffs(74, 18).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
