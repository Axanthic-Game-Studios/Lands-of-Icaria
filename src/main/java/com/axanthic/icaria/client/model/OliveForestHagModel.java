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

public class OliveForestHagModel extends HierarchicalModel<ForestHagEntity> {
	public float armBend = 1.00F;
	public float ulnaBend = 1.00F;
	public float legBend = 1.50F;
	public float kneeBend = 1.25F;

	public ModelPart root;
	public ModelPart bodyBase;
	public ModelPart bodyMain;
	public ModelPart bodyLower;
	public ModelPart bodyCenter;
	public ModelPart bodyUpper;
	public ModelPart shoulderRight;
	public ModelPart armRightUpper;
	public ModelPart armRightLower;
	public ModelPart armLeftUpper;
	public ModelPart armLeftLower;
	public ModelPart neckMain;
	public ModelPart headMain;
	public ModelPart thighRight;
	public ModelPart legRight;
	public ModelPart thighLeft;
	public ModelPart legLeft;
	public ModelPart footLeft;

	public OliveForestHagModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyBase = this.root.getChild("bodyBase");
		this.bodyMain = this.bodyBase.getChild("bodyMain");
		this.bodyLower = this.bodyMain.getChild("bodyLower");
		this.bodyCenter = this.bodyLower.getChild("bodyCenter");
		this.bodyUpper = this.bodyCenter.getChild("bodyUpper");
		this.shoulderRight = this.bodyUpper.getChild("shoulderRight");
		this.armRightUpper = this.shoulderRight.getChild("armRightUpper");
		this.armRightLower = this.armRightUpper.getChild("armRightLower");
		this.armLeftUpper = this.bodyUpper.getChild("armLeftUpper");
		this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
		this.neckMain = this.bodyUpper.getChild("neckMain");
		this.headMain = this.neckMain.getChild("headMain");
		this.thighRight = this.bodyBase.getChild("thighRight");
		this.legRight = this.thighRight.getChild("legRight");
		this.thighLeft = this.bodyBase.getChild("thighLeft");
		this.legLeft = this.thighLeft.getChild("legLeft");
		this.footLeft = this.legLeft.getChild("footLeft");
	}

	@Override
	public void setupAnim(ForestHagEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.bodyBase.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 8.5F;
		this.armRightUpper.xRot = -0.5918F;
		this.armRightUpper.zRot = 0.4427F;
		this.armLeftUpper.xRot = -0.1784F;
		this.armLeftUpper.zRot = -0.3193F;

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
		this.armRightUpper.xRot += Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
		this.armRightUpper.zRot += Mth.cos(pAgeInTicks * 0.09F) * 0.05F;
		this.armLeftUpper.xRot -= Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
		this.armLeftUpper.zRot -= Mth.cos(pAgeInTicks * 0.09F) * 0.05F;

		this.wiggleRotateAngles(this.bodyBase, -0.18203784098300857F, 0.0F, -0.091106186954104F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyMain, -0.18203784098300857F, 0.0F, -0.091106186954104F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyLower, 0.091106186954104F, 0.0F, 0.091106186954104F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyCenter, 0.18203784098300857F, 0.0F, 0.091106186954104F, pAgeInTicks);
		this.wiggleRotateAngles(this.bodyUpper, 0.18203784098300857F, 0.0F, 0.091106186954104F, pAgeInTicks);
		this.wiggleRotateAngles(this.shoulderRight, 0.39269908169872414F, 0.0F, -0.39269908169872414F, pAgeInTicks);
		this.wiggleRotateAngles(this.neckMain, 0.7853981633974483F, 0.0F, 0.0F, pAgeInTicks);
	}

	public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
		this.headMain.xRot = pHeadPitch * 0.017453292F - 0.8726646259971648F;
		this.headMain.yRot = pNetHeadYaw * 0.017453292F;
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		this.armRightUpper.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.armBend * pLimbSwingAmount - 0.5918F;
		this.armRightLower.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.1820F;
		this.thighRight.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.legBend * pLimbSwingAmount + 0.0759F;
		this.legRight.xRot = Mth.sin(pLimbSwing * 0.6662F + Mth.PI) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.0911F;
		this.armLeftUpper.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.armBend * pLimbSwingAmount - 0.1784F;
		this.armLeftLower.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.1820F;
		this.thighLeft.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.legBend * pLimbSwingAmount + 0.0759F;
		this.footLeft.xRot = Mth.sin(pLimbSwing * 0.6662F) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.0911F;
	}

	public void wiggleRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ, float pAgeInTicks) {
		pModelPart.xRot = Mth.cos(pAgeInTicks * 0.045F) * 0.015F + pX;
		pModelPart.yRot = Mth.sin(pAgeInTicks * 0.035F) * 0.015F + pY;
		pModelPart.zRot = -Mth.cos(pAgeInTicks * 0.04F) * 0.015F + pZ;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bodyBase = partDefinition.addOrReplaceChild("bodyBase", CubeListBuilder.create().texOffs(32, 10).addBox(-5.9599F, -4.2017F, -2.5084F, 13.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2125F, 8.2625F, 0.0F, -0.167F, 0.0F, -0.1061F));
		var bodyMain = bodyBase.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(32, 19).addBox(-5.8246F, -2.8478F, -2.2689F, 12.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1901F, -4.1267F, 0.2666F, -0.167F, 0.0F, -0.1061F));
		var bodyLower = bodyMain.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(48, 27).addBox(-5.9577F, -3.8032F, -1.564F, 11.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5504F, -3.1228F, -0.3064F, 0.1061F, 0.0F, 0.0761F));
		var bodyCenter = bodyLower.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(44, 44).addBox(-5.9924F, -3.5181F, -1.7566F, 12.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2327F, -3.2782F, -0.314F, 0.197F, 0.0F, 0.0761F));
		var bodyUpper = bodyCenter.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(0, 0).addBox(-7.3716F, -4.7791F, -2.546F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5076F, -2.6306F, 0.2434F, 0.197F, 0.0F, 0.0761F));
		bodyUpper.addOrReplaceChild("bodyUpperLeavesLeft", CubeListBuilder.create().texOffs(40, 52).addBox(-1.0298F, 0.0087F, -1.9945F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.6284F, -4.7791F, -0.046F, 0.0112F, 0.0F, -0.3337F));
		bodyUpper.addOrReplaceChild("bodyUpperLeavesRear", CubeListBuilder.create().texOffs(0, 10).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6284F, -4.7791F, 2.454F, 0.0436F, 0.0F, 0.0F));
		bodyUpper.addOrReplaceChild("bodyUpperSaplingX", CubeListBuilder.create().texOffs(0, 20).addBox(0.0137F, -16.0191F, -5.9837F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6284F, -4.7791F, 0.454F, 0.015F, 1.1781F, -0.015F));
		bodyUpper.addOrReplaceChild("bodyUpperSaplingZ", CubeListBuilder.create().texOffs(24, 20).addBox(0.016F, -16.0196F, -6.0134F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6284F, -4.7791F, 0.454F, 0.015F, -0.3927F, -0.015F));
		var shoulderRight = bodyUpper.addOrReplaceChild("shoulderRight", CubeListBuilder.create().texOffs(46, 0).addBox(-11.8005F, -4.2922F, -1.2377F, 12.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0466F, -4.2416F, 0.079F, 0.4077F, 0.0F, -0.4077F));
		var armRightUpper = shoulderRight.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(64, 62).addBox(-0.8689F, 0.3634F, -1.3015F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.913F, -2.2922F, 0.2623F, -0.5918F, 0.0436F, 0.4427F));
		armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(52, 62).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1311F, 9.8634F, -0.3015F, -0.182F, 0.0F, -0.0911F));
		var armLeftUpper = bodyUpper.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(0, 62).addBox(-1.1868F, -0.4039F, -1.4712F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6409F, -2.7791F, -0.071F, -0.1784F, 0.0F, -0.3193F));
		armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(12, 62).addBox(-1.4564F, 0.1309F, -1.4759F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2757F, 9.0961F, 0.0288F, -0.182F, 0.0F, 0.0911F));
		var neckMain = bodyUpper.addOrReplaceChild("neckMain", CubeListBuilder.create().texOffs(52, 52).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1284F, -3.2791F, -0.046F, 0.8004F, 0.0F, -0.015F));
		var headMain = neckMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(0, 48).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 0.2F, -0.8727F, 0.0F, 0.0F));
		headMain.addOrReplaceChild("headLeaves", CubeListBuilder.create().texOffs(24, 48).addBox(-1.0386F, -0.1621F, -2.9875F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9875F, -4.825F, -3.0F, 0.0F, 0.0F, 0.167F));
		var thighRight = bodyBase.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(64, 35).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5849F, -1.5517F, -0.3834F, 0.0759F, 0.182F, 0.1309F));
		var legRight = thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(44, 68).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.0911F, -0.0911F, 0.0F));
		legRight.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(48, 35).addBox(-2.5F, 0.0F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 0.0F, 0.0F, -0.0911F, 0.0F));
		var thighLeft = bodyBase.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(63, 8).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5526F, -0.9142F, -0.0709F, 0.0759F, -0.0948F, 0.048F));
		var legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(24, 66).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.0911F, -0.0911F, 0.0F));
		var footLeft = legLeft.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(36, 68).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.0911F, 0.0911F, 0.0F));
		footLeft.addOrReplaceChild("soleLeft", CubeListBuilder.create().texOffs(64, 15).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.2F, 0.0F, 0.0911F, 0.0911F, 0.0456F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
