package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.VinegaroonEntity;
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

public class VinegaroonModel extends HierarchicalModel<VinegaroonEntity> {
	public ModelPart root;
	public ModelPart bodyMain;
	public ModelPart headMain;
	public ModelPart armRightRear;
	public ModelPart armLeftRear;
	public ModelPart legRightCenterFrontUpper;
	public ModelPart legRightCenterFrontLower;
	public ModelPart legLeftCenterFrontUpper;
	public ModelPart legLeftCenterFrontLower;
	public ModelPart legRightCenterRearUpper;
	public ModelPart legRightCenterRearLower;
	public ModelPart legLeftCenterRearUpper;
	public ModelPart legLeftCenterRearLower;
	public ModelPart legRightRearUpper;
	public ModelPart legRightRearLower;
	public ModelPart legLeftRearUpper;
	public ModelPart legLeftRearLower;

	public VinegaroonModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyMain = this.root.getChild("bodyMain");
		this.headMain = this.bodyMain.getChild("headMain");
		this.armRightRear = this.headMain.getChild("armRightRear");
		this.armLeftRear = this.headMain.getChild("armLeftRear");
		this.legRightCenterFrontUpper = this.bodyMain.getChild("legRightCenterFrontUpper");
		this.legRightCenterFrontLower = this.legRightCenterFrontUpper.getChild("legRightCenterFrontLower");
		this.legLeftCenterFrontUpper = this.bodyMain.getChild("legLeftCenterFrontUpper");
		this.legLeftCenterFrontLower = this.legLeftCenterFrontUpper.getChild("legLeftCenterFrontLower");
		this.legRightCenterRearUpper = this.bodyMain.getChild("legRightCenterRearUpper");
		this.legRightCenterRearLower = this.legRightCenterRearUpper.getChild("legRightCenterRearLower");
		this.legLeftCenterRearUpper = this.bodyMain.getChild("legLeftCenterRearUpper");
		this.legLeftCenterRearLower = this.legLeftCenterRearUpper.getChild("legLeftCenterRearLower");
		this.legRightRearUpper = this.bodyMain.getChild("legRightRearUpper");
		this.legRightRearLower = this.legRightRearUpper.getChild("legRightRearLower");
		this.legLeftRearUpper = this.bodyMain.getChild("legLeftRearUpper");
		this.legLeftRearLower = this.legLeftRearUpper.getChild("legLeftRearLower");
	}

	@Override
	public void setupAnim(VinegaroonEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.setupRotateAngles();
		this.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pNetHeadYaw, pHeadPitch);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.VINEGAROON_ATTACK, pAgeInTicks);
	}

	public void setupRotateAngles() {
		IcariaClientHelper.setRotateAngles(this.headMain, 0.0F, 0.0F, 0.0F);
		IcariaClientHelper.setRotateAngles(this.armRightRear, 0.0F, -0.3F, 0.0F);
		IcariaClientHelper.setRotateAngles(this.armLeftRear, 0.0F, 0.3F, 0.0F);
		IcariaClientHelper.setRotateAngles(this.legRightCenterFrontUpper, -0.0964F, -0.3076F, 0.2555F);
		IcariaClientHelper.setRotateAngles(this.legLeftCenterFrontUpper, -0.0922F, 0.3075F, -0.2558F);
		IcariaClientHelper.setRotateAngles(this.legRightCenterRearUpper, 0.092F, 0.3032F, 0.2554F);
		IcariaClientHelper.setRotateAngles(this.legLeftCenterRearUpper, 0.092F, -0.3032F, -0.2554F);
		IcariaClientHelper.setRotateAngles(this.legRightRearUpper, 0.2664F, 0.9177F, 0.375F);
		IcariaClientHelper.setRotateAngles(this.legLeftRearUpper, 0.2664F, -0.9177F, -0.375F);
	}

	public void setupAnim(VinegaroonEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pNetHeadYaw, float pHeadPitch) {
		this.attackAnim(pEntity);
		this.lookAnim(pHeadPitch, pNetHeadYaw);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
	}

	public void attackAnim(VinegaroonEntity pEntity) {
		if (pEntity.hasExactlyOnePlayerPassenger()) {
			this.armRightRear.yRot -= 0.75F;
			this.armLeftRear.yRot += 0.75F;
		} else {
			this.armRightRear.yRot -= 0.0F;
			this.armLeftRear.yRot += 0.0F;
		}
	}

	public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
		this.headMain.xRot += IcariaMath.rad(pHeadPitch);
		this.headMain.yRot += IcariaMath.rad(pNetHeadYaw);
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		float centerFrontY = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 0.5F) * 0.4F * pLimbSwingAmount;
		float centerFrontZ = Math.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 0.5F) * 0.4F) * pLimbSwingAmount;
		float centerRearY = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 1.0F) * 0.4F * pLimbSwingAmount;
		float centerRearZ = Math.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 1.0F) * 0.4F) * pLimbSwingAmount;
		float rearY = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 0.0F) * 0.4F * pLimbSwingAmount;
		float rearZ = Math.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 0.0F) * 0.4F) * pLimbSwingAmount;

		this.legRightCenterFrontUpper.yRot += centerFrontY;
		this.legRightCenterFrontUpper.zRot += centerFrontZ;
		this.legLeftCenterFrontUpper.yRot -= centerFrontY;
		this.legLeftCenterFrontUpper.zRot -= centerFrontZ;
		this.legRightCenterRearUpper.yRot += centerRearY;
		this.legRightCenterRearUpper.zRot += centerRearZ;
		this.legLeftCenterRearUpper.yRot -= centerRearY;
		this.legLeftCenterRearUpper.zRot -= centerRearZ;
		this.legRightRearUpper.yRot += rearY;
		this.legRightRearUpper.zRot += rearZ;
		this.legLeftRearUpper.yRot -= rearY;
		this.legLeftRearUpper.zRot -= rearZ;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bodyMain = partDefinition.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(56, 0).addBox(-4.5F, -3.5F, -4.0F, 9.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.7F, 0.0F));
		var headMain = bodyMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, -2.95F, -7.0125F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5625F, -3.9875F));
		headMain.addOrReplaceChild("eyeRightFront", CubeListBuilder.create().texOffs(24, 67).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.65F, -6.7125F));
		headMain.addOrReplaceChild("eyeLeftFront", CubeListBuilder.create().texOffs(18, 71).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -2.65F, -6.7125F));
		headMain.addOrReplaceChild("eyeRightRear", CubeListBuilder.create().texOffs(18, 69).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.7F, -2.65F, -3.2125F));
		headMain.addOrReplaceChild("eyeLeftRear", CubeListBuilder.create().texOffs(24, 69).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.7F, -2.65F, -3.2125F));
		var armRightRear = headMain.addOrReplaceChild("armRightRear", CubeListBuilder.create().texOffs(0, 55).addBox(-6.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0375F, -6.0125F, 0.0F, -0.3F, 0.0F));
		var armRightCenter = armRightRear.addOrReplaceChild("armRightCenter", CubeListBuilder.create().texOffs(40, 45).addBox(-7.0383F, -2.0F, -1.5747F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8625F, 0.0F, 0.8875F, 0.0F, -1.0472F, 0.0F));
		var armRightFront = armRightCenter.addOrReplaceChild("armRightFront", CubeListBuilder.create().texOffs(74, 61).addBox(-3.9112F, -2.0F, -1.2519F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0508F, 0.0125F, -0.0247F, 0.0F, -1.0472F, 0.0F));
		armRightFront.addOrReplaceChild("fingerRightUpper", CubeListBuilder.create().texOffs(12, 71).addBox(-1.62F, -0.5125F, -0.4573F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9112F, -1.475F, -0.2144F, 0.0F, -0.6109F, 0.0F));
		armRightFront.addOrReplaceChild("fingerRightLower", CubeListBuilder.create().texOffs(12, 67).addBox(-1.6302F, -0.5125F, -0.4501F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8987F, 1.5F, -0.2144F, 0.0F, -0.6109F, 0.0F));
		var armLeftRear = headMain.addOrReplaceChild("armLeftRear", CubeListBuilder.create().texOffs(18, 55).addBox(0.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.05F, -6.0125F, 0.0F, 0.3F, 0.0F));
		var armLeftCenter = armLeftRear.addOrReplaceChild("armLeftCenter", CubeListBuilder.create().texOffs(60, 45).addBox(0.015F, -2.0F, -1.5901F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8875F, 0.0F, 0.875F, 0.0F, 1.0472F, 0.0F));
		var armLeftFront = armLeftCenter.addOrReplaceChild("armLeftFront", CubeListBuilder.create().texOffs(60, 61).addBox(-1.1025F, -2.0F, -1.2006F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.99F, 0.0125F, -0.0776F, 0.0F, 1.0472F, 0.0F));
		armLeftFront.addOrReplaceChild("fingerLeftUpper", CubeListBuilder.create().texOffs(18, 67).addBox(-0.4158F, -0.5125F, -0.4061F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8975F, -1.475F, -0.2256F, 0.0F, 0.6109F, 0.0F));
		armLeftFront.addOrReplaceChild("fingerLeftLower", CubeListBuilder.create().texOffs(12, 69).addBox(-0.4158F, -0.5125F, -0.4061F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8975F, 1.5F, -0.2256F, 0.0F, 0.6109F, 0.0F));
		var bodyRear = bodyMain.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.9625F, 0.0F, 10.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5375F, 3.0F));
		var tailMain = bodyRear.addOrReplaceChild("tailMain", CubeListBuilder.create().texOffs(0, 67).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0375F, 18.0F));
		var tailFront = tailMain.addOrReplaceChild("tailFront", CubeListBuilder.create().texOffs(20, 45).addBox(-0.5F, -0.4698F, -0.1887F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0125F, 2.4875F, 0.1367F, 0.0F, 0.0F));
		tailFront.addOrReplaceChild("tailRear", CubeListBuilder.create().texOffs(0, 45).addBox(-0.4875F, -0.5048F, -0.0519F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0302F, 8.7863F, 0.1367F, 0.0F, 0.0F));
		var legRightFrontUpper = bodyMain.addOrReplaceChild("legRightFrontUpper", CubeListBuilder.create().texOffs(30, 24).addBox(-14.0F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.3F, -3.0F, 0.0F, -0.9638F, -0.4887F));
		legRightFrontUpper.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(0, 37).addBox(-14.5F, -0.5F, -0.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 0.5236F, -0.3491F, -0.0873F));
		var legLeftFrontUpper = bodyMain.addOrReplaceChild("legLeftFrontUpper", CubeListBuilder.create().texOffs(30, 28).addBox(-1.0F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.3F, -3.0F, 0.0F, 0.9638F, 0.4887F));
		legLeftFrontUpper.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(0, 39).addBox(-0.5F, -0.5F, -0.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 0.0F, 0.0F, 0.5236F, 0.3491F, 0.0873F));
		var legRightCenterFrontUpper = bodyMain.addOrReplaceChild("legRightCenterFrontUpper", CubeListBuilder.create().texOffs(76, 55).addBox(-7.006F, -1.0243F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.3F, -1.3F, -0.0964F, -0.3076F, 0.2555F));
		legRightCenterFrontUpper.addOrReplaceChild("legRightCenterFrontLower", CubeListBuilder.create().texOffs(60, 37).addBox(-11.4829F, -1.0183F, -1.0125F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftCenterFrontUpper = bodyMain.addOrReplaceChild("legLeftCenterFrontUpper", CubeListBuilder.create().texOffs(0, 61).addBox(-0.994F, -1.0243F, -0.9999F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.3F, -1.3F, -0.0922F, 0.3075F, -0.2558F));
		legLeftCenterFrontUpper.addOrReplaceChild("legLeftCenterFrontLower", CubeListBuilder.create().texOffs(0, 41).addBox(-11.4829F, -0.9817F, -1.0124F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));
		var legRightCenterRearUpper = bodyMain.addOrReplaceChild("legRightCenterRearUpper", CubeListBuilder.create().texOffs(36, 55).addBox(-7.006F, -1.0243F, -1.0001F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.3F, -0.3F, 0.092F, 0.3032F, 0.2554F));
		legRightCenterRearUpper.addOrReplaceChild("legRightCenterRearLower", CubeListBuilder.create().texOffs(28, 41).addBox(-11.4829F, -1.0183F, -0.9876F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftCenterRearUpper = bodyMain.addOrReplaceChild("legLeftCenterRearUpper", CubeListBuilder.create().texOffs(56, 55).addBox(-0.994F, -1.0243F, -1.0001F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.3F, -0.3F, 0.092F, -0.3032F, -0.2554F));
		legLeftCenterRearUpper.addOrReplaceChild("legLeftCenterRearLower", CubeListBuilder.create().texOffs(32, 37).addBox(-11.4829F, -0.9817F, -0.9876F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));
		var legRightRearUpper = bodyMain.addOrReplaceChild("legRightRearUpper", CubeListBuilder.create().texOffs(20, 61).addBox(-7.0056F, -1.0244F, -1.0001F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.0375F, 1.5F, 0.2664F, 0.9177F, 0.375F));
		legRightRearUpper.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(84, 41).addBox(-11.4826F, -1.018F, -0.9876F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftRearUpper = bodyMain.addOrReplaceChild("legLeftRearUpper", CubeListBuilder.create().texOffs(40, 61).addBox(-0.9944F, -1.0244F, -1.0001F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.05F, 1.3F, 0.2664F, -0.9177F, -0.375F));
		legLeftRearUpper.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(56, 41).addBox(-11.4826F, -0.982F, -0.9876F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
