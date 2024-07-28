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

public class CypressForestHagModel extends HierarchicalModel<ForestHagEntity> {
	public ModelPart root;
	public ModelPart bodyBase;
	public ModelPart bodyMain;
	public ModelPart bodyLower;
	public ModelPart bodyCenter;
	public ModelPart bodyUpper;
	public ModelPart neckMain;
	public ModelPart headMain;
	public ModelPart headBranchRightLower;
	public ModelPart headBranchRightUpper;
	public ModelPart headBranchLeftLower;
	public ModelPart headBranchLeftUpper;
	public ModelPart neckShroom;
	public ModelPart shoulderRight;
	public ModelPart armRight;
	public ModelPart shoulderLeft;
	public ModelPart armLeft;
	public ModelPart bodyUpperBranchLower;
	public ModelPart bodyUpperTwigLower;
	public ModelPart bodyUpperTwigUpper;
	public ModelPart bodyUpperBranchCenter;
	public ModelPart bodyUpperBranchUpper;
	public ModelPart bodyUpperTwigFront;
	public ModelPart bodyUpperTwigRight;
	public ModelPart bodyUpperTwigLeft;
	public ModelPart bodyRump;
	public ModelPart thighRight;
	public ModelPart legRight;
	public ModelPart thighLeft;
	public ModelPart legLeft;
	public ModelPart footLeft;

	public CypressForestHagModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyBase = this.root.getChild("bodyBase");
		this.bodyMain = this.bodyBase.getChild("bodyMain");
		this.bodyLower = this.bodyMain.getChild("bodyLower");
		this.bodyCenter = this.bodyLower.getChild("bodyCenter");
		this.bodyUpper = this.bodyCenter.getChild("bodyUpper");
		this.neckMain = this.bodyUpper.getChild("neckMain");
		this.headMain = this.neckMain.getChild("headMain");
		this.headBranchRightLower = this.headMain.getChild("headBranchRightLower");
		this.headBranchRightUpper = this.headBranchRightLower.getChild("headBranchRightUpper");
		this.headBranchLeftLower = this.headMain.getChild("headBranchLeftLower");
		this.headBranchLeftUpper = this.headBranchLeftLower.getChild("headBranchLeftUpper");
		this.neckShroom = this.bodyUpper.getChild("neckShroom");
		this.shoulderRight = this.bodyUpper.getChild("shoulderRight");
		this.armRight = this.shoulderRight.getChild("armRight");
		this.shoulderLeft = this.bodyUpper.getChild("shoulderLeft");
		this.armLeft = this.shoulderLeft.getChild("armLeft");
		this.bodyUpperBranchLower = this.bodyUpper.getChild("bodyUpperBranchLower");
		this.bodyUpperTwigLower = this.bodyUpperBranchLower.getChild("bodyUpperTwigLower");
		this.bodyUpperTwigUpper = this.bodyUpperTwigLower.getChild("bodyUpperTwigUpper");
		this.bodyUpperBranchCenter = this.bodyUpperBranchLower.getChild("bodyUpperBranchCenter");
		this.bodyUpperBranchUpper = this.bodyUpperBranchCenter.getChild("bodyUpperBranchUpper");
		this.bodyUpperTwigFront = this.bodyUpperBranchUpper.getChild("bodyUpperTwigFront");
		this.bodyUpperTwigRight = this.bodyUpperBranchUpper.getChild("bodyUpperTwigRight");
		this.bodyUpperTwigLeft = this.bodyUpperBranchUpper.getChild("bodyUpperTwigLeft");
		this.bodyRump = this.bodyBase.getChild("bodyRump");
		this.thighRight = this.bodyBase.getChild("thighRight");
		this.legRight = this.thighRight.getChild("legRight");
		this.thighLeft = this.bodyBase.getChild("thighLeft");
		this.legLeft = this.thighLeft.getChild("legLeft");
		this.footLeft = this.legLeft.getChild("footLeft");
	}

	@Override
	public void setupAnim(ForestHagEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.shoulderRight.xRot = -0.1745F;
		this.shoulderRight.zRot = 0.4427F;
		this.shoulderLeft.xRot = -0.3927F;
		this.shoulderLeft.zRot = -0.1373F;

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
		this.shoulderRight.xRot += Mth.sin(pAgeInTicks * 0.06F) * 0.05F;
		this.shoulderRight.zRot += Mth.cos(pAgeInTicks * 0.09F) * 0.05F;
		this.shoulderLeft.xRot -= Mth.sin(pAgeInTicks * 0.06F) * 0.05F;
		this.shoulderLeft.zRot -= Mth.cos(pAgeInTicks * 0.09F) * 0.05F;

		this.wiggleRotateAngles(this.bodyMain, 0.015F, -0.0873F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyLower, 0.1023F, -0.0873F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyCenter, 0.1023F, -0.0873F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpper, 0.1023F, -0.0873F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.neckMain, 0.6259F, 0.1745F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.headBranchRightLower, 0.015F, -0.4098F, -0.5613F, pAgeInTicks);
		this.wiggleRotateAngles(this.headBranchRightUpper, 0.2881F, 0.2276F, 0.3037F, pAgeInTicks);
		this.wiggleRotateAngles(this.headBranchLeftLower, 0.015F, 0.3927F, 0.5086F, pAgeInTicks);
		this.wiggleRotateAngles(this.headBranchLeftUpper, 0.2881F, 0.2276F, -0.2881F, pAgeInTicks);
		this.wiggleRotateAngles(this.neckShroom, 0.1023F, -0.0873F, 0.1595F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperBranchLower, 0.4248F, 0.7854F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperTwigLower, -0.3948F, 1.7301F, -0.0606F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperTwigUpper, -0.4404F, 3.1416F, 1.1233F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperBranchCenter, 0.4077F, -0.1745F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperBranchUpper, 0.4077F, 0.2618F, -0.015F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperTwigFront, 0.3793F, -0.9105F, 1.442F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperTwigRight, 0.1061F, 0.8652F, 3.081F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpperTwigLeft, -0.9411F, 0.0456F, -0.5159F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyRump, 0.015F, -0.0873F, -0.4077F, pAgeInTicks);
	}

	public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
		this.headMain.xRot = IcariaMath.rad(pHeadPitch) - 0.6109F;
		this.headMain.yRot = IcariaMath.rad(pNetHeadYaw) + 0.1745F;
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount;

		this.shoulderRight.xRot = Mth.cos(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount - 0.1745F;
		this.armRight.xRot = Mth.cos(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount - pLimbSwingAmount - 0.0873F;
		this.thighRight.xRot = Mth.cos(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount;
		this.legRight.xRot = Mth.sin(pLimbSwing * 0.6F + Mth.PI) * pLimbSwingAmount + pLimbSwingAmount + 0.0873F;
		this.shoulderLeft.xRot = Mth.cos(pLimbSwing * 0.6F) * pLimbSwingAmount - 0.3927F;
		this.armLeft.zRot = Mth.cos(pLimbSwing * 0.6F) * pLimbSwingAmount + pLimbSwingAmount + 0.0873F;
		this.thighLeft.xRot = Mth.cos(pLimbSwing * 0.6F) * pLimbSwingAmount;
		this.footLeft.xRot = Mth.sin(pLimbSwing * 0.6F) * pLimbSwingAmount + pLimbSwingAmount + 0.0873F;
	}

	public void wiggleRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ, float pAgeInTicks) {
		pModelPart.xRot = Mth.cos(pAgeInTicks * 0.045F) * 0.015F + pX;
		pModelPart.yRot = Mth.sin(pAgeInTicks * 0.035F) * 0.015F + pY;
		pModelPart.zRot = -Mth.cos(pAgeInTicks * 0.04F) * 0.015F + pZ;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bodyBase = partDefinition.addOrReplaceChild("bodyBase", CubeListBuilder.create().texOffs(0, 35).addBox(-5.5F, 0.0F, -2.5F, 11.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.5F, -0.0873F, 0.0F, 0.0F));
		var bodyMain = bodyBase.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(36, 15).addBox(-4.5F, -3.5F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.015F, -0.0873F, -0.015F));
		bodyMain.addOrReplaceChild("bodyMainShroomLower", CubeListBuilder.create().texOffs(12, 31).addBox(0.0F, -1.8F, -3.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));
		var bodyLower = bodyMain.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(35, 6).addBox(-5.0F, -3.5F, -2.5F, 10.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.1023F, -0.0873F, -0.015F));
		bodyLower.addOrReplaceChild("bodyMainShroomCenter", CubeListBuilder.create().texOffs(0, 31).addBox(1.5F, -1.5F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));
		var bodyCenter = bodyLower.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(0, 11).addBox(-6.0F, -3.5F, -3.0F, 12.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.1023F, -0.0873F, -0.015F));
		bodyCenter.addOrReplaceChild("bodyMainShroomUpper", CubeListBuilder.create().texOffs(55, 0).addBox(1.5F, -1.5F, -4.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));
		var bodyUpper = bodyCenter.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -3.5F, -3.5F, 13.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.1023F, -0.0873F, -0.015F));
		var neckMain = bodyUpper.addOrReplaceChild("neckMain", CubeListBuilder.create().texOffs(20, 59).addBox(-2.0F, -8.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -0.5F, 0.6259F, 0.1745F, -0.015F));
		var headMain = neckMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(0, 44).addBox(-3.0F, -8.0F, -4.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, 0.0F, -0.6109F, 0.1745F, 0.0873F));
		var headBranchLeavesLower = headMain.addOrReplaceChild("headBranchLeavesLower", CubeListBuilder.create().texOffs(26, 23).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.65F, -10.0F, -0.5F));
		headBranchLeavesLower.addOrReplaceChild("headBranchLeavesUpper", CubeListBuilder.create().texOffs(57, 59).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.1F));
		var headBranchRightLower = headMain.addOrReplaceChild("headBranchRightLower", CubeListBuilder.create().texOffs(26, 21).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -6.4F, -2.5F, 0.015F, -0.4098F, -0.5613F));
		headBranchRightLower.addOrReplaceChild("headBranchRightUpper", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.2881F, 0.2276F, 0.3037F));
		var headBranchLeftLower = headMain.addOrReplaceChild("headBranchLeftLower", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -6.4F, 0.5F, 0.015F, 0.3927F, 0.5086F));
		headBranchLeftLower.addOrReplaceChild("headBranchLeftUpper", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.2881F, 0.2276F, -0.2881F));
		var neckShroom = bodyUpper.addOrReplaceChild("neckShroom", CubeListBuilder.create().texOffs(0, 21).addBox(-9.5F, -2.0F, -3.5F, 9.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.1023F, -0.0873F, 0.1595F));
		neckShroom.addOrReplaceChild("neckVine", CubeListBuilder.create().texOffs(46, 48).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 0.0F, 4.55F, 0.0F, 3.1416F, 0.0F));
		var shoulderRight = bodyUpper.addOrReplaceChild("shoulderRight", CubeListBuilder.create().texOffs(62, 48).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4F, -4.3F, -0.5F, -0.1745F, 0.1745F, 0.4427F));
		shoulderRight.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(56, 66).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.1F, -0.0873F, -0.3927F, -0.1745F));
		var shoulderLeft = bodyUpper.addOrReplaceChild("shoulderLeft", CubeListBuilder.create().texOffs(61, 11).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.0F, -1.0F, -0.3927F, -0.7854F, -0.1373F));
		shoulderLeft.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(36, 59).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, -2.5F, 0.0F, -0.3927F, 0.0873F));
		var bodyUpperBranchLower = bodyUpper.addOrReplaceChild("bodyUpperBranchLower", CubeListBuilder.create().texOffs(24, 48).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, -2.5F, 0.5F, 0.4248F, 0.7854F, -0.015F));
		var bodyUpperTwigLower = bodyUpperBranchLower.addOrReplaceChild("bodyUpperTwigLower", CubeListBuilder.create().texOffs(67, 19).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 2.0F, -0.3948F, 1.7301F, -0.0606F));
		bodyUpperTwigLower.addOrReplaceChild("bodyUpperTwigUpper", CubeListBuilder.create().texOffs(72, 54).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.1F, -4.5F, -0.4404F, 3.1416F, 1.1233F));
		var bodyUpperLeavesLeft = bodyUpperTwigLower.addOrReplaceChild("bodyUpperLeavesLeft", CubeListBuilder.create().texOffs(0, 58).addBox(-3.5F, -3.5F, -3.0F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -4.0F));
		bodyUpperLeavesLeft.addOrReplaceChild("bodyUpperLeavesRight", CubeListBuilder.create().texOffs(0, 68).addBox(-2.5F, -2.5F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));
		var bodyUpperBranchCenter = bodyUpperBranchLower.addOrReplaceChild("bodyUpperBranchCenter", CubeListBuilder.create().texOffs(60, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 5.5F, 0.4077F, -0.1745F, -0.015F));
		var bodyUpperBranchUpper = bodyUpperBranchCenter.addOrReplaceChild("bodyUpperBranchUpper", CubeListBuilder.create().texOffs(64, 66).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.8F, 4.0F, 0.4077F, 0.2618F, -0.015F));
		bodyUpperBranchUpper.addOrReplaceChild("bodyUpperTwigFront", CubeListBuilder.create().texOffs(71, 3).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 0.1F, 2.5F, 0.3793F, -0.9105F, 1.442F));
		bodyUpperBranchUpper.addOrReplaceChild("bodyUpperTwigRight", CubeListBuilder.create().texOffs(71, 43).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 1.1F, 4.5F, 0.1061F, 0.8652F, 3.081F));
		bodyUpperBranchUpper.addOrReplaceChild("bodyUpperTwigLeft", CubeListBuilder.create().texOffs(49, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 1.1F, 4.5F, -0.9411F, 0.0456F, -0.5159F));
		var bodyUpperLeavesLower = bodyUpperBranchUpper.addOrReplaceChild("bodyUpperLeavesLower", CubeListBuilder.create().texOffs(32, 35).addBox(-4.5F, -4.5F, 4.0F, 9.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 0.0F));
		bodyUpperLeavesLower.addOrReplaceChild("bodyUpperLeavesUpper", CubeListBuilder.create().texOffs(58, 39).addBox(-3.0F, -3.0F, 8.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		bodyBase.addOrReplaceChild("bodyRump", CubeListBuilder.create().texOffs(50, 23).addBox(-1.5F, 0.0F, -1.6F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 3.0F, 0.0F, 0.015F, -0.0873F, -0.4077F));
		var thighRight = bodyBase.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(14, 69).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 3.2F, -0.5F));
		var legRight = thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(69, 27).addBox(-1.5F, -0.2F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0873F, -0.0873F, 0.0F));
		var footRight = legRight.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(33, 0).addBox(-2.0F, -0.4F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.0873F, 0.0873F));
		footRight.addOrReplaceChild("soleRight", CubeListBuilder.create().texOffs(54, 30).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -0.0873F, -0.0873F));
		var thighLeft = bodyBase.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(18, 44).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 3.7F, -0.5F, 0.0F, -0.2731F, 0.0F));
		var legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(22, 71).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0F, -0.3927F, 0.0F));
		legLeft.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(44, 64).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0873F, 0.1745F, 0.0F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
