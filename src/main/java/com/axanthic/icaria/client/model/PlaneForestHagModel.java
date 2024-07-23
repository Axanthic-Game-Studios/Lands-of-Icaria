package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.ForestHagEntity;

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

public class PlaneForestHagModel extends HierarchicalModel<ForestHagEntity> {
	public float armBend = 1.00F;
	public float ulnaBend = 1.00F;
	public float legBend = 1.50F;
	public float kneeBend = 1.25F;

	public ModelPart root;
	public ModelPart bodyBase;
	public ModelPart bodyMain;
	public ModelPart bodyLower;
	public ModelPart bodyCenterRight;
	public ModelPart bodyUpperRight;
	public ModelPart bodyCenterLeft;
	public ModelPart bodyUpperLeft;
	public ModelPart shoulderMain;
	public ModelPart shoulderRight;
	public ModelPart armRightUpper;
	public ModelPart armRightLower;
	public ModelPart shoulderLeft;
	public ModelPart armLeftUpper;
	public ModelPart armLeftLower;
	public ModelPart neckMain;
	public ModelPart neckLeavesUpper;
	public ModelPart neckLeavesLower;
	public ModelPart headMain;
	public ModelPart shoulderMainLeavesMain;
	public ModelPart bodyMainWoodMain;
	public ModelPart bodyMainLeavesMain;
	public ModelPart thighRight;
	public ModelPart legRight;
	public ModelPart kneeRight;
	public ModelPart thighLeft;
	public ModelPart legLeft;
	public ModelPart kneeLeftRight;
	public ModelPart kneeLeftLeft;
	public ModelPart kneeLeftRear;

	public PlaneForestHagModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyBase = this.root.getChild("bodyBase");
		this.bodyMain = this.bodyBase.getChild("bodyMain");
		this.bodyLower = this.bodyMain.getChild("bodyLower");
		this.bodyCenterRight = this.bodyLower.getChild("bodyCenterRight");
		this.bodyUpperRight = this.bodyCenterRight.getChild("bodyUpperRight");
		this.bodyCenterLeft = this.bodyLower.getChild("bodyCenterLeft");
		this.bodyUpperLeft = this.bodyCenterLeft.getChild("bodyUpperLeft");
		this.shoulderMain = this.bodyUpperLeft.getChild("shoulderMain");
		this.shoulderRight = this.shoulderMain.getChild("shoulderRight");
		this.armRightUpper = this.shoulderRight.getChild("armRightUpper");
		this.armRightLower = this.armRightUpper.getChild("armRightLower");
		this.shoulderLeft = this.shoulderMain.getChild("shoulderLeft");
		this.armLeftUpper = this.shoulderLeft.getChild("armLeftUpper");
		this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
		this.neckMain = this.shoulderMain.getChild("neckMain");
		this.neckLeavesUpper = this.neckMain.getChild("neckLeavesUpper");
		this.neckLeavesLower = this.neckLeavesUpper.getChild("neckLeavesLower");
		this.headMain = this.neckMain.getChild("headMain");
		this.shoulderMainLeavesMain = this.shoulderMain.getChild("shoulderMainLeavesMain");
		this.bodyMainWoodMain = this.bodyMain.getChild("bodyMainWoodMain");
		this.bodyMainLeavesMain = this.bodyMainWoodMain.getChild("bodyMainLeavesMain");
		this.thighRight = this.bodyBase.getChild("thighRight");
		this.legRight = this.thighRight.getChild("legRight");
		this.kneeRight = this.legRight.getChild("kneeRight");
		this.thighLeft = this.bodyBase.getChild("thighLeft");
		this.legLeft = this.thighLeft.getChild("legLeft");
		this.kneeLeftRight = this.legLeft.getChild("kneeLeftRight");
		this.kneeLeftLeft = this.legLeft.getChild("kneeLeftLeft");
		this.kneeLeftRear = this.legLeft.getChild("kneeLeftRear");
	}

	@Override
	public void setupAnim(ForestHagEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.bodyBase.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 4.0F;
		this.shoulderRight.xRot = -0.4554F;
		this.shoulderRight.zRot = -0.0411F;
		this.shoulderLeft.xRot = -0.5009F;
		this.shoulderLeft.zRot = -0.5054F;

		this.attackAnim();
		this.idleAnim(pAgeInTicks);
		this.lookAnim(pHeadPitch, pNetHeadYaw);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
	}

	public void attackAnim() {
		float f = Mth.sin(this.attackTime * Mth.PI);
		if (this.attackTime > 0.0F) {
			this.shoulderRight.zRot -= f;
			this.shoulderLeft.zRot += f;
		}
	}

	public void idleAnim(float pAgeInTicks) {
		this.shoulderRight.zRot += Mth.cos(pAgeInTicks * 0.09F) * 0.05F;
		this.shoulderLeft.zRot -= Mth.cos(pAgeInTicks * 0.09F) * 0.05F;
		this.shoulderRight.xRot += Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
		this.shoulderLeft.xRot -= Mth.sin(pAgeInTicks * 0.067F) * 0.05F;

		this.wiggleRotateAngles(this.bodyLower, 0.0F, 0.0F, 0.08726646259971647F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyMain, -0.08726646259971647F, 0.0F, 0.08726646259971647F, pAgeInTicks);
		this.wiggleRotateAngles(this.neckLeavesUpper, 0.0F, 0.0F, 0.045553093477052F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyMainLeavesMain, 0.0F, 0.0F, 0.0F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperRight, 0.08726646259971647F, 0.0F, 0.17453292519943295F, pAgeInTicks);
		this.wiggleRotateAngles(this.armLeftUpper, -0.08726646259971647F, 0.5811946409141118F, -0.13962634015954636F, pAgeInTicks);
		this.wiggleRotateAngles(this.shoulderMain, 0.08726646259971647F, 0.0F, 0.08726646259971647F, pAgeInTicks);
		this.wiggleRotateAngles(this.neckMain, 0.8726646259971648F, 0.08726646259971647F, 0.0F, pAgeInTicks);
		this.wiggleRotateAngles(this.shoulderMainLeavesMain, 0.06806784082777885F, 0.091106186954104F, 0.0F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyMainWoodMain, 0.04363323129985824F, 0.0F, -0.1308996938995747F, pAgeInTicks);
		this.wiggleRotateAngles(this.armRightUpper, 0.0F, 0.7853981633974483F, 0.0F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyCenterRight, 0.08726646259971647F, 0.0F, -0.27314402793711257F, pAgeInTicks);
		this.wiggleRotateAngles(this.neckLeavesLower, -0.9105382707654417F, 0.0F, -0.045553093477052F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyCenterLeft, 0.08726646259971647F, 0.0F, 0.08726646259971647F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperLeft, 0.08726646259971647F, 0.0F, -0.3490658503988659F, pAgeInTicks);
	}

	public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
		this.headMain.xRot = pHeadPitch * 0.017453292F - 0.8726646259971648F;
		this.headMain.yRot = pNetHeadYaw * 0.017453292F - 0.091106186954104F;
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		this.shoulderRight.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.armBend * pLimbSwingAmount - 0.4554F;
		this.armRightLower.zRot = Mth.cos(pLimbSwing * 0.6662F) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.1745F;
		this.thighRight.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.legBend * pLimbSwingAmount - 0.0873F;
		this.kneeRight.xRot = Mth.sin(pLimbSwing * 0.6662F + Mth.PI) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.0873F;
		this.shoulderLeft.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.armBend * pLimbSwingAmount - 0.5009F;
		this.armLeftLower.zRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.1745F;
		this.thighLeft.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.legBend * pLimbSwingAmount - 0.0873F;
		this.kneeLeftRight.xRot = Mth.sin(pLimbSwing * 0.6662F) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.0873F;
		this.kneeLeftLeft.xRot = Mth.sin(pLimbSwing * 0.6662F) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.0873F;
		this.kneeLeftRear.xRot = Mth.sin(pLimbSwing * 0.6662F) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.0873F;
	}

	public void wiggleRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ, float pAgeInTicks) {
		pModelPart.xRot = Mth.cos(pAgeInTicks * 0.045F) * 0.015F + pX;
		pModelPart.yRot = Mth.sin(pAgeInTicks * 0.035F) * 0.015F + pY;
		pModelPart.zRot = -Mth.cos(pAgeInTicks * 0.04F) * 0.015F + pZ;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bodyBase = partDefinition.addOrReplaceChild("bodyBase", CubeListBuilder.create().texOffs(21, 25).addBox(-5.5F, 0.0F, -2.5F, 11.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var bodyMain = bodyBase.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(48, 20).addBox(-4.6F, 0.0F, -1.7F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.4F, 0.0F, -0.0723F, 0.0F, 0.0723F));
		var bodyLower = bodyMain.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(11, 50).addBox(-3.9F, 0.0F, -1.2F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.4F, 0.0F, 0.015F, 0.0F, 0.0723F));
		var bodyCenterRight = bodyLower.addOrReplaceChild("bodyCenterRight", CubeListBuilder.create().texOffs(0, 56).addBox(-5.2F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.1023F, 0.0F, -0.2881F));
		bodyCenterRight.addOrReplaceChild("bodyUpperRight", CubeListBuilder.create().texOffs(50, 12).addBox(-5.3F, 0.0F, -2.8F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.1023F, 0.0F, 0.1595F));
		var bodyCenterLeft = bodyLower.addOrReplaceChild("bodyCenterLeft", CubeListBuilder.create().texOffs(31, 52).addBox(0.6F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.1023F, 0.0F, 0.0723F));
		var bodyUpperLeft = bodyCenterLeft.addOrReplaceChild("bodyUpperLeft", CubeListBuilder.create().texOffs(47, 47).addBox(0.5F, 0.0F, -2.8F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -1.3F, 0.0F, 0.1023F, 0.0F, -0.3641F));
		var shoulderMain = bodyUpperLeft.addOrReplaceChild("shoulderMain", CubeListBuilder.create().texOffs(0, 0).addBox(-5.7F, 0.0F, -3.0F, 13.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.6F, -0.7F, 0.1023F, 0.0F, 0.0723F));
		var shoulderRight = shoulderMain.addOrReplaceChild("shoulderRight", CubeListBuilder.create().texOffs(52, 29).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, 0.3F, 0.1F, -0.4554F, 0.7854F, -0.0411F));
		var armRightUpper = shoulderRight.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(16, 64).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 3.5F, -0.8F, 0.015F, 0.7854F, -0.015F));
		armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(0, 64).addBox(-0.9875F, 0.0F, -1.0125F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0125F, 7.65F, 0.525F, 0.1745F, 0.0F, -0.1745F));
		var shoulderLeft = shoulderMain.addOrReplaceChild("shoulderLeft", CubeListBuilder.create().texOffs(44, 0).addBox(-2.5F, 0.0F, -2.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -1.0F, 0.8F, -0.5009F, 0.7854F, -0.5054F));
		var armLeftUpper = shoulderLeft.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(24, 64).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 5.5F, 0.8F, -0.0723F, 0.5812F, -0.1546F));
		armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(8, 64).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, 0.0F, -0.1745F, 0.0F, -0.1745F));
		var neckMain = shoulderMain.addOrReplaceChild("neckMain", CubeListBuilder.create().texOffs(32, 60).addBox(-1.5F, -6.4F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 0.8F, -0.5F, 0.8877F, 0.0873F, -0.015F));
		var neckLeavesUpper = neckMain.addOrReplaceChild("neckLeavesUpper", CubeListBuilder.create().texOffs(14, 34).addBox(-3.5F, -6.4F, -1.5F, 7.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4F, 2.7F, 0.015F, 0.0F, 0.0306F));
		neckLeavesUpper.addOrReplaceChild("neckLeavesLower", CubeListBuilder.create().texOffs(34, 34).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2F, 1.2F, -0.8955F, 0.0F, -0.0606F));
		neckMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(26, 10).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.8727F, -0.0911F, 0.1367F));
		shoulderMain.addOrReplaceChild("shoulderMainLeavesMain", CubeListBuilder.create().texOffs(0, 10).addBox(-4.8F, 0.0F, 0.0F, 11.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, 2.5F, 0.0831F, 0.0911F, -0.015F));
		var bodyMainWoodMain = bodyMain.addOrReplaceChild("bodyMainWoodMain", CubeListBuilder.create().texOffs(44, 63).addBox(-5.3F, -7.2F, -1.5F, 1.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2F, 0.0F, 0.0586F, 0.0F, -0.1459F));
		bodyMainWoodMain.addOrReplaceChild("bodyMainLeavesMain", CubeListBuilder.create().texOffs(0, 30).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, 0.015F, 0.0F, -0.015F));
		var thighRight = bodyBase.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(57, 59).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 3.5F, 0.0F, -0.0873F, 0.0436F, 0.0436F));
		var legRight = thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.8F, 0.0F, 0.0F, 0.0436F, 0.0436F));
		var kneeRight = legRight.addOrReplaceChild("kneeRight", CubeListBuilder.create().texOffs(52, 66).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7F, 0.0F, 0.0873F, -0.0436F, 0.0F));
		var footRight = kneeRight.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(65, 9).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.8F, 0.0F, 0.0F, -0.0436F, -0.0436F));
		footRight.addOrReplaceChild("soleRight", CubeListBuilder.create().texOffs(16, 56).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.0873F, -0.0436F, -0.0436F));
		var thighLeft = bodyBase.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(52, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.5F, 0.0F, -0.0873F, -0.0436F, -0.0436F));
		var legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(62, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, 0.0F, 0.0436F, 0.0436F));
		var kneeLeftRight = legLeft.addOrReplaceChild("kneeLeftRight", CubeListBuilder.create().texOffs(64, 66).addBox(-1.3F, 0.0F, -1.2F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7F, 0.0F, 0.0873F, -0.0873F, 0.0F));
		legLeft.addOrReplaceChild("kneeLeftLeft", CubeListBuilder.create().texOffs(0, 52).addBox(0.3F, 0.0F, -0.9F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7F, 0.0F, 0.0873F, -0.0436F, 0.0F));
		legLeft.addOrReplaceChild("kneeLeftRear", CubeListBuilder.create().texOffs(60, 66).addBox(-0.7F, 0.0F, 0.3F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7F, 0.0F, 0.0873F, -0.0436F, 0.0F));
		var footLeft = kneeLeftRight.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(64, 46).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8F, 0.0F, 0.0F, 0.0436F, 0.0F));
		footLeft.addOrReplaceChild("soleLeft", CubeListBuilder.create().texOffs(45, 56).addBox(-2.0F, 0.0F, -2.2F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.0873F, 0.0436F, 0.0F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
