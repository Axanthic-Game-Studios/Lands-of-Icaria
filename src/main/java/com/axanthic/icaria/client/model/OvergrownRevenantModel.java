package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.OvergrownRevenantEntity;
import com.axanthic.icaria.common.math.IcariaMath;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.HumanoidArm;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OvergrownRevenantModel extends HierarchicalModel<OvergrownRevenantEntity> implements ArmedModel {
	public ModelPart root;
	public ModelPart bodyUpper;
	public ModelPart spineMain;
	public ModelPart headMain;
	public ModelPart jawUpper;
	public ModelPart jawLower;
	public ModelPart shoulderMain;
	public ModelPart armRightUpper;
	public ModelPart armRightLower;
	public ModelPart armLeftUpper;
	public ModelPart armLeftLower;
	public ModelPart bodyLower;
	public ModelPart pelvisMain;
	public ModelPart pelvisRight;
	public ModelPart pelvisLeft;
	public ModelPart thighRight;
	public ModelPart thighLeft;
	public ModelPart legRight;
	public ModelPart legLeft;

	public OvergrownRevenantModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyUpper = this.root.getChild("bodyUpper");
		this.spineMain = this.bodyUpper.getChild("spineMain");
		this.headMain = this.spineMain.getChild("headMain");
		this.jawUpper = this.headMain.getChild("jawUpper");
		this.jawLower = this.jawUpper.getChild("jawLower");
		this.shoulderMain = this.spineMain.getChild("shoulderMain");
		this.armRightUpper = this.shoulderMain.getChild("armRightUpper");
		this.armRightLower = this.armRightUpper.getChild("armRightLower");
		this.armLeftUpper = this.shoulderMain.getChild("armLeftUpper");
		this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
		this.bodyLower = this.root.getChild("bodyLower");
		this.pelvisMain = this.bodyLower.getChild("pelvisMain");
		this.pelvisRight = this.pelvisMain.getChild("pelvisRight");
		this.pelvisLeft = this.pelvisMain.getChild("pelvisLeft");
		this.thighRight = this.pelvisRight.getChild("thighRight");
		this.thighLeft = this.pelvisLeft.getChild("thighLeft");
		this.legRight = this.thighRight.getChild("legRight");
		this.legLeft = this.thighLeft.getChild("legLeft");
	}

	@Override
	public void setupAnim(OvergrownRevenantEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		var randomSource = RandomSource.create(pEntity.getId());

		this.setRotateAngles(this.headMain, -0.2721F, 0.0F, randomSource.nextIntBetweenInclusive(-50, 50) * 0.005F);
		this.setRotateAngles(this.jawLower, 0.1047F, 0.0F, 0.0F);
		this.setRotateAngles(this.armRightUpper, -0.2731F, 0.0F, 0.2047F);
		this.setRotateAngles(this.armRightLower, -0.1047F, 0.0F, -0.1047F);
		this.setRotateAngles(this.armLeftUpper, -0.2731F, 0.0F, -0.2047F);
		this.setRotateAngles(this.armLeftLower, -0.1047F, 0.0F, 0.1047F);
		this.setRotateAngles(this.thighRight, -0.3142F, 0.3142F, -0.0436F);
		this.setRotateAngles(this.thighLeft, -0.3142F, -0.3142F, 0.0436F);
		this.setRotateAngles(this.legRight, 0.2094F, 0.0F, 0.0F);
		this.setRotateAngles(this.legLeft, 0.2094F, 0.0F, 0.0F);

		this.attackAnim();
		this.idleAnim(pAgeInTicks);
		this.lookAnim(pHeadPitch, pNetHeadYaw);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
	}

	public void setRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ) {
		pModelPart.xRot = pX;
		pModelPart.yRot = pY;
		pModelPart.zRot = pZ;
	}

	public void attackAnim() {
		this.armRightUpper.xRot -= Mth.sin(this.attackTime * Mth.PI);
	}

	public void idleAnim(float pAgeInTicks) {
		this.headMain.zRot += Mth.sin(pAgeInTicks * 0.06F) * 0.05F;
		this.jawLower.xRot += Mth.sin(pAgeInTicks * 0.06F) * 0.05F;
		this.armRightUpper.xRot += Mth.sin(pAgeInTicks * 0.06F) * 0.05F;
		this.armRightUpper.zRot += Mth.cos(pAgeInTicks * 0.09F) * 0.05F + 0.05F;
		this.armLeftUpper.xRot -= Mth.sin(pAgeInTicks * 0.06F) * 0.05F;
		this.armLeftUpper.zRot -= Mth.cos(pAgeInTicks * 0.09F) * 0.05F + 0.05F;
	}

	public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
		this.headMain.xRot += IcariaMath.rad(pHeadPitch);
		this.headMain.yRot += IcariaMath.rad(pNetHeadYaw);
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount;

		this.armRightUpper.xRot += Mth.cos(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount;
		this.armLeftUpper.xRot += Mth.cos(pLimbSwing * 0.6F) * pLimbSwingAmount;
		this.armRightLower.xRot -= Mth.cos(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount + pLimbSwingAmount;
		this.armLeftLower.xRot -= Mth.cos(pLimbSwing * 0.6F) * pLimbSwingAmount + pLimbSwingAmount;
		this.thighRight.xRot += Mth.cos(pLimbSwing * 0.6F + Mth.PI) * 0.5F * pLimbSwingAmount;
		this.thighLeft.xRot += Mth.cos(pLimbSwing * 0.6F) * 0.5F * pLimbSwingAmount;
		this.legRight.xRot += Mth.cos(pLimbSwing * 0.6F + Mth.PI) * 0.8F * pLimbSwingAmount + 0.8F * pLimbSwingAmount;
		this.legLeft.xRot += Mth.cos(pLimbSwing * 0.6F) * 0.8F * pLimbSwingAmount + 0.8F * pLimbSwingAmount;
	}

	public void translateToBiceps(PoseStack pPoseStack) {
		this.bodyUpper.translateAndRotate(pPoseStack);
		this.spineMain.translateAndRotate(pPoseStack);
		this.shoulderMain.translateAndRotate(pPoseStack);
		this.armLeftUpper.translateAndRotate(pPoseStack);
	}

	@Override
	public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
		this.bodyUpper.translateAndRotate(pPoseStack);
		this.spineMain.translateAndRotate(pPoseStack);
		this.shoulderMain.translateAndRotate(pPoseStack);
		this.armRightUpper.translateAndRotate(pPoseStack);
		this.armRightLower.translateAndRotate(pPoseStack);
	}

	public void translateToHead(PoseStack pPoseStack) {
		this.bodyUpper.translateAndRotate(pPoseStack);
		this.spineMain.translateAndRotate(pPoseStack);
		this.headMain.translateAndRotate(pPoseStack);
	}

	public void translateToFoot(PoseStack pPoseStack) {
		this.bodyLower.translateAndRotate(pPoseStack);
		this.pelvisMain.translateAndRotate(pPoseStack);
		this.pelvisLeft.translateAndRotate(pPoseStack);
		this.thighLeft.translateAndRotate(pPoseStack);
		this.legLeft.translateAndRotate(pPoseStack);
	}

	public void translateToPelvis(PoseStack pPoseStack) {
		this.bodyLower.translateAndRotate(pPoseStack);
		this.pelvisMain.translateAndRotate(pPoseStack);
	}

	public void translateToShoulder(PoseStack pPoseStack) {
		this.bodyUpper.translateAndRotate(pPoseStack);
		this.spineMain.translateAndRotate(pPoseStack);
		this.shoulderMain.translateAndRotate(pPoseStack);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bodyUpper = partDefinition.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(8, 35).addBox(-1.0F, -7.05F, -1.0375F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.02F, 9.9641F, 0.4459F));
		var spineMain = bodyUpper.addOrReplaceChild("spineMain", CubeListBuilder.create().texOffs(34, 7).addBox(-1.0F, -9.7498F, -1.0076F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.02F, -7.0813F, 0.0002F, 0.2731F, 0.0F, 0.0F));
		var headMain = spineMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(0, 21).addBox(-3.6196F, -5.9487F, -5.5416F, 7.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.025F, -8.6576F, -0.0411F, -0.2721F, 0.0F, 0.0F));
		headMain.addOrReplaceChild("crystalsHead", CubeListBuilder.create().texOffs(46, 43).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3997F, -8.9487F, -3.583F, 0.0F, -0.3927F, 0.0F));
		headMain.addOrReplaceChild("crystalHeadNorthEast", CubeListBuilder.create().texOffs(30, 45).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3856F, -7.7017F, -5.5961F, 2.3662F, 0.7746F, 3.087F));
		headMain.addOrReplaceChild("crystalHeadSouthEast", CubeListBuilder.create().texOffs(56, 31).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.239F, -7.0377F, -1.988F, -0.8166F, 0.4979F, -0.119F));
		headMain.addOrReplaceChild("crystalHeadSouthWest", CubeListBuilder.create().texOffs(0, 35).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0075F, -8.534F, -0.8102F, -0.7917F, -0.6517F, -0.0365F));
		headMain.addOrReplaceChild("crystalHeadNorthWest", CubeListBuilder.create().texOffs(52, 7).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3055F, -7.1138F, -5.3879F, 2.326F, -0.7815F, 3.1204F));
		var jawUpper = headMain.addOrReplaceChild("jawUpper", CubeListBuilder.create().texOffs(34, 0).addBox(-2.575F, -0.0375F, -6.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0446F, 0.0888F, 0.9584F));
		jawUpper.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(24, 29).addBox(-2.5875F, -0.0275F, -5.9955F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0125F, 0.9875F, 0.0F, 0.1047F, 0.0F, 0.0F));
		spineMain.addOrReplaceChild("crystalsShoulder", CubeListBuilder.create().texOffs(56, 24).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -6.6655F, 0.2993F, 2.679F, -0.0065F, -0.0771F));
		spineMain.addOrReplaceChild("crystalsShoulderSouthEast", CubeListBuilder.create().texOffs(54, 41).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7981F, -5.6865F, 1.6598F, 1.998F, -0.2142F, 0.6763F));
		spineMain.addOrReplaceChild("crystalsShoulderSouthWest", CubeListBuilder.create().texOffs(44, 51).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5144F, -5.5917F, 1.5682F, 1.3855F, -0.5424F, 0.9187F));
		spineMain.addOrReplaceChild("crystalsShoulderNorthWest", CubeListBuilder.create().texOffs(8, 51).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5929F, -6.6957F, -2.5497F, -2.3419F, 0.6238F, -0.0054F));
		var shoulderMain = spineMain.addOrReplaceChild("shoulderMain", CubeListBuilder.create().texOffs(22, 21).addBox(-6.5F, -0.5F, -0.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.7553F, -0.9128F));
		var armRightUpper = shoulderMain.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(32, 36).addBox(-0.9968F, 0.0078F, -1.0041F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8125F, 0.0228F, 0.0466F, -0.2731F, 0.0F, 0.2047F));
		armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(40, 23).addBox(-1.0044F, -0.0619F, -1.0134F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0032F, 7.0078F, 0.0209F, -0.1047F, 0.0F, -0.1047F));
		var armLeftUpper = shoulderMain.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(24, 36).addBox(-1.0154F, 0.002F, -0.9927F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.825F, 0.2103F, -0.0784F, -0.2731F, 0.0F, -0.2047F));
		armLeftUpper.addOrReplaceChild("crystalArm", CubeListBuilder.create().texOffs(22, 45).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3073F, 3.0215F, -1.3569F, -2.2852F, -0.7854F, 0.0F));
		armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(16, 35).addBox(-1.0054F, -0.0399F, -0.9733F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0029F, 6.977F, -0.0052F, -0.1047F, 0.0F, 0.1047F));
		var ribUpperRightRear = spineMain.addOrReplaceChild("ribUpperRightRear", CubeListBuilder.create().texOffs(56, 47).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -5.7498F, 0.0924F));
		var ribUpperRightSide = ribUpperRightRear.addOrReplaceChild("ribUpperRightSide", CubeListBuilder.create().texOffs(44, 28).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
		ribUpperRightSide.addOrReplaceChild("ribUpperRightFront", CubeListBuilder.create().texOffs(18, 58).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, -1.5F));
		var ribUpperLeftRear = spineMain.addOrReplaceChild("ribUpperLeftRear", CubeListBuilder.create().texOffs(34, 57).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -5.7498F, 0.0924F));
		var ribUpperLeftSide = ribUpperLeftRear.addOrReplaceChild("ribUpperLeftSide", CubeListBuilder.create().texOffs(46, 12).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
		ribUpperLeftSide.addOrReplaceChild("ribUpperLeftFront", CubeListBuilder.create().texOffs(58, 36).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.5F, -1.5F));
		var ribUpperCenterRightRear = spineMain.addOrReplaceChild("ribUpperCenterRightRear", CubeListBuilder.create().texOffs(58, 20).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9177F, -3.9554F, 0.0924F, 0.0F, 0.0F, -0.1047F));
		var ribUpperCenterRightSide = ribUpperCenterRightRear.addOrReplaceChild("ribUpperCenterRightSide", CubeListBuilder.create().texOffs(52, 52).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
		ribUpperCenterRightSide.addOrReplaceChild("ribUpperCenterRightFront", CubeListBuilder.create().texOffs(58, 59).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
		var ribUpperCenterLeftRear = spineMain.addOrReplaceChild("ribUpperCenterLeftRear", CubeListBuilder.create().texOffs(22, 27).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9177F, -3.9554F, 0.0924F, 0.0F, 0.0F, 0.1047F));
		var ribUpperCenterLeftSide = ribUpperCenterLeftRear.addOrReplaceChild("ribUpperCenterLeftSide", CubeListBuilder.create().texOffs(29, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
		ribUpperCenterLeftSide.addOrReplaceChild("ribUpperCenterLeftFront", CubeListBuilder.create().texOffs(32, 27).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
		var ribCenterRightRear = spineMain.addOrReplaceChild("ribCenterRightRear", CubeListBuilder.create().texOffs(8, 58).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6067F, -2.7025F, 0.0924F, 0.0F, 0.0F, -0.2094F));
		var ribCenterRightSide = ribCenterRightRear.addOrReplaceChild("ribCenterRightSide", CubeListBuilder.create().texOffs(34, 52).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
		ribCenterRightSide.addOrReplaceChild("ribCenterRightFront", CubeListBuilder.create().texOffs(58, 54).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
		var ribCenterLeftRear = spineMain.addOrReplaceChild("ribCenterLeftRear", CubeListBuilder.create().texOffs(56, 5).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6067F, -2.7025F, 0.0924F, 0.0F, 0.0F, 0.2094F));
		var ribCenterLeftSide = ribCenterLeftRear.addOrReplaceChild("ribCenterLeftSide", CubeListBuilder.create().texOffs(38, 16).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
		ribCenterLeftSide.addOrReplaceChild("ribCenterLeftFront", CubeListBuilder.create().texOffs(44, 18).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
		var ribLowerCenterRightRear = spineMain.addOrReplaceChild("ribLowerCenterRightRear", CubeListBuilder.create().texOffs(58, 7).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1716F, -1.4941F, 0.0924F, 0.0F, 0.0F, -0.3142F));
		var ribLowerCenterRightSide = ribLowerCenterRightRear.addOrReplaceChild("ribLowerCenterRightSide", CubeListBuilder.create().texOffs(50, 47).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
		ribLowerCenterRightSide.addOrReplaceChild("ribLowerCenterRightFront", CubeListBuilder.create().texOffs(58, 52).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
		var ribLowerCenterLeftRear = spineMain.addOrReplaceChild("ribLowerCenterLeftRear", CubeListBuilder.create().texOffs(56, 57).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1716F, -1.4941F, 0.0924F, 0.0F, 0.0F, 0.3142F));
		var ribLowerCenterLeftSide = ribLowerCenterLeftRear.addOrReplaceChild("ribLowerCenterLeftSide", CubeListBuilder.create().texOffs(50, 26).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
		ribLowerCenterLeftSide.addOrReplaceChild("ribLowerCenterLeftFront", CubeListBuilder.create().texOffs(58, 38).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
		var ribLowerRightRear = spineMain.addOrReplaceChild("ribLowerRightRear", CubeListBuilder.create().texOffs(58, 22).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6171F, -0.3322F, 0.0924F, 0.0F, 0.0F, -0.4189F));
		var ribLowerRightSide = ribLowerRightRear.addOrReplaceChild("ribLowerRightSide", CubeListBuilder.create().texOffs(16, 53).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
		ribLowerRightSide.addOrReplaceChild("ribLowerRightFront", CubeListBuilder.create().texOffs(0, 60).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
		var ribLowerLeftRear = spineMain.addOrReplaceChild("ribLowerLeftRear", CubeListBuilder.create().texOffs(56, 18).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6171F, -0.3322F, 0.0924F, 0.0F, 0.0F, 0.4189F));
		var ribLowerLeftSide = ribLowerLeftRear.addOrReplaceChild("ribLowerLeftSide", CubeListBuilder.create().texOffs(50, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
		ribLowerLeftSide.addOrReplaceChild("ribLowerLeftFront", CubeListBuilder.create().texOffs(6, 45).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
		spineMain.addOrReplaceChild("breastboneMain", CubeListBuilder.create().texOffs(40, 36).addBox(-2.0F, -3.0F, -0.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.267F, -3.1357F));
		spineMain.addOrReplaceChild("vineMain", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -8.0F, -2.5F, 12.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.03F, 0.8747F, -1.2077F));
		var bodyLower = partDefinition.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(22, 23).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.9248F, 0.4112F));
		var pelvisMain = bodyLower.addOrReplaceChild("pelvisMain", CubeListBuilder.create().texOffs(22, 25).addBox(-3.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.75F, -2.4625F));
		var pelvisRight = pelvisMain.addOrReplaceChild("pelvisRight", CubeListBuilder.create().texOffs(56, 14).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8575F, -0.4258F, 1.4005F, 0.2094F, -0.1047F, 0.0F));
		pelvisRight.addOrReplaceChild("crystalPelvisNorthEast", CubeListBuilder.create().texOffs(0, 54).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3501F, -1.2906F, -0.109F, 2.7819F, 1.3183F, -1.1125F));
		pelvisRight.addOrReplaceChild("crystalPelvisSouthWest", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6616F, -1.3742F, 2.2081F, 1.0802F, -0.3143F, 3.0875F));
		pelvisRight.addOrReplaceChild("crystalPelvisNorthWest", CubeListBuilder.create().texOffs(50, 34).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8095F, -1.6998F, -1.2475F, -2.552F, -0.5066F, 0.1371F));
		var thighRight = pelvisRight.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(42, 7).addBox(-0.9657F, 0.1285F, -1.1001F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0012F, 0.0765F, 0.5268F, -0.3142F, 0.3142F, -0.0436F));
		thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(38, 43).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0218F, 7.1285F, -0.1001F, 0.2094F, 0.0F, 0.0F));
		var pelvisLeft = pelvisMain.addOrReplaceChild("pelvisLeft", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8575F, -0.4258F, 1.4005F, 0.2094F, 0.1047F, 0.0F));
		var thighLeft = pelvisLeft.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(14, 44).addBox(-1.0165F, 0.1732F, -1.0778F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0091F, 0.0425F, 0.5056F, -0.3142F, -0.3142F, 0.0436F));
		var legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.004F, 7.1732F, -0.0778F, 0.2094F, 0.0F, 0.0F));
		legLeft.addOrReplaceChild("crystalLegNorthWest", CubeListBuilder.create().texOffs(50, 18).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3868F, 2.9524F, -1.3821F, -2.2808F, -0.8073F, -0.0218F));
		legLeft.addOrReplaceChild("crystalLegSouthWest", CubeListBuilder.create().texOffs(26, 53).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.659F, 3.4421F, 1.2911F, 0.8669F, -0.4904F, 3.1221F));
		legLeft.addOrReplaceChild("crystalLegNorthEast", CubeListBuilder.create().texOffs(50, 57).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9325F, 3.9966F, -0.9238F, -2.0048F, 0.8001F, 0.0125F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
