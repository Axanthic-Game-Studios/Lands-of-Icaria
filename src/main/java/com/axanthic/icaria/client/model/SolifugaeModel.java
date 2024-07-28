package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.entity.SolifugaeEntity;
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

public class SolifugaeModel extends HierarchicalModel<SolifugaeEntity> {
	public ModelPart root;
	public ModelPart bodyMain;
	public ModelPart headMain;
	public ModelPart legRightFrontUpper;
	public ModelPart legRightFrontLower;
	public ModelPart legLeftFrontUpper;
	public ModelPart legLeftFrontLower;
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

	public SolifugaeModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyMain = this.root.getChild("bodyMain");
		this.headMain = this.bodyMain.getChild("headMain");
		this.legRightFrontUpper = this.bodyMain.getChild("legRightFrontUpper");
		this.legRightFrontLower = this.legRightFrontUpper.getChild("legRightFrontLower");
		this.legLeftFrontUpper = this.bodyMain.getChild("legLeftFrontUpper");
		this.legLeftFrontLower = this.legLeftFrontUpper.getChild("legLeftFrontLower");
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
	public void setupAnim(SolifugaeEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.setupRotateAngles();
		this.setupAnim(pLimbSwing, pLimbSwingAmount, pNetHeadYaw, pHeadPitch);
	}

	public void setupRotateAngles() {
		IcariaClientHelper.setRotateAngles(this.headMain, -0.085F, 0.0F, 0.0F);
		IcariaClientHelper.setRotateAngles(this.legRightFrontUpper, -0.2233F, -0.7864F, 0.3079F);
		IcariaClientHelper.setRotateAngles(this.legLeftFrontUpper, -0.2445F, 0.7811F, -0.3441F);
		IcariaClientHelper.setRotateAngles(this.legRightCenterFrontUpper, -0.0945F, -0.2698F, 0.2376F);
		IcariaClientHelper.setRotateAngles(this.legLeftCenterFrontUpper, -0.0944F, 0.2654F, -0.2372F);
		IcariaClientHelper.setRotateAngles(this.legRightCenterRearUpper, 0.0946F, 0.2741F, 0.2381F);
		IcariaClientHelper.setRotateAngles(this.legLeftCenterRearUpper, 0.0946F, -0.2741F, -0.2381F);
		IcariaClientHelper.setRotateAngles(this.legRightRearUpper, 0.2227F, 0.781F, 0.304F);
		IcariaClientHelper.setRotateAngles(this.legLeftRearUpper, 0.2227F, -0.781F, -0.304F);
	}

	public void setupAnim(float pLimbSwing, float pLimbSwingAmount, float pNetHeadYaw, float pHeadPitch) {
		this.lookAnim(pHeadPitch, pNetHeadYaw);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
	}

	public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
		this.headMain.xRot += IcariaMath.rad(pHeadPitch);
		this.headMain.yRot += IcariaMath.rad(pNetHeadYaw);
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		float frontY = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 1.5F) * 0.4F * pLimbSwingAmount;
		float frontZ = Math.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 1.5F) * 0.4F) * pLimbSwingAmount;
		float centerFrontY = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 0.5F) * 0.4F * pLimbSwingAmount;
		float centerFrontZ = Math.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 0.5F) * 0.4F) * pLimbSwingAmount;
		float centerRearY = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 1.0F) * 0.4F * pLimbSwingAmount;
		float centerRearZ = Math.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 1.0F) * 0.4F) * pLimbSwingAmount;
		float rearY = -Mth.cos(pLimbSwing * 0.6F * 2.0F + Mth.PI * 0.0F) * 0.4F * pLimbSwingAmount;
		float rearZ = Math.abs(Mth.sin(pLimbSwing * 0.6F + Mth.PI * 0.0F) * 0.4F) * pLimbSwingAmount;

		this.legRightFrontUpper.yRot += frontY;
		this.legRightFrontUpper.zRot += frontZ;
		this.legLeftFrontUpper.yRot -= frontY;
		this.legLeftFrontUpper.zRot -= frontZ;
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

		var bodyMain = partDefinition.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(90, 27).addBox(-4.5F, -2.5F, -4.0F, 9.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.5F, 1.0F));
		var headMain = bodyMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(54, 27).addBox(-5.0F, -4.0832F, -7.981F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -3.9375F, -0.085F, 0.0F, 0.0F));
		headMain.addOrReplaceChild("eyeRight", CubeListBuilder.create().texOffs(56, 70).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.7F, -3.7832F, -7.681F));
		headMain.addOrReplaceChild("eyeLeft", CubeListBuilder.create().texOffs(56, 72).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7F, -3.7832F, -7.681F));
		headMain.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(62, 0).addBox(-24.0F, -1.0F, -1.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.5168F, -2.481F, 0.0F, -1.1345F, -0.2618F));
		headMain.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -1.0F, -1.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.5168F, -2.481F, 0.0F, 1.1345F, 0.2618F));
		var jawMain = headMain.addOrReplaceChild("jawMain", CubeListBuilder.create().texOffs(0, 43).addBox(-3.95F, -2.958F, -4.4308F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.05F, -0.1207F, -8.006F, 0.096F, 0.0F, 0.0F));
		var mouthMain = jawMain.addOrReplaceChild("mouthMain", CubeListBuilder.create().texOffs(28, 58).addBox(-2.9F, -2.6875F, -3.0F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.05F, 0.2295F, -4.4308F));
		mouthMain.addOrReplaceChild("toothRightUpper", CubeListBuilder.create().texOffs(14, 70).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -1.6875F, -3.0F, 0.1745F, 0.0F, 0.0F));
		mouthMain.addOrReplaceChild("toothRightLower", CubeListBuilder.create().texOffs(0, 70).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 1.3125F, -3.0F, -0.3F, 0.0F, 0.0F));
		mouthMain.addOrReplaceChild("toothLeftUpper", CubeListBuilder.create().texOffs(42, 70).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -1.6875F, -3.0F, 0.1745F, 0.0F, 0.0F));
		mouthMain.addOrReplaceChild("toothLeftLower", CubeListBuilder.create().texOffs(28, 70).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 1.3125F, -3.0F, -0.3F, 0.0F, 0.0F));
		bodyMain.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -4.0875F, 0.0F, 12.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5125F, 3.0F));
		var legRightFrontUpper = bodyMain.addOrReplaceChild("legRightFrontUpper", CubeListBuilder.create().texOffs(60, 66).addBox(-7.0053F, -1.0244F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.05F, -4.0F, -0.2233F, -0.7864F, 0.3079F));
		legRightFrontUpper.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(84, 54).addBox(-11.4824F, -1.0178F, -1.0126F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftFrontUpper = bodyMain.addOrReplaceChild("legLeftFrontUpper", CubeListBuilder.create().texOffs(0, 66).addBox(-0.994F, -1.0243F, -0.9999F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.075F, -4.0F, -0.2445F, 0.7811F, -0.3441F));
		legLeftFrontUpper.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(28, 54).addBox(-11.482F, -0.9827F, -1.0124F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.0944F));
		var legRightCenterFrontUpper = bodyMain.addOrReplaceChild("legRightCenterFrontUpper", CubeListBuilder.create().texOffs(66, 58).addBox(-7.0057F, -1.0243F, -1.0001F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.3F, -2.3F, -0.0945F, -0.2698F, 0.2376F));
		legRightCenterFrontUpper.addOrReplaceChild("legRightCenterFrontLower", CubeListBuilder.create().texOffs(54, 43).addBox(-11.4827F, -1.0181F, -1.0126F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftCenterFrontUpper = bodyMain.addOrReplaceChild("legLeftCenterFrontUpper", CubeListBuilder.create().texOffs(20, 66).addBox(-0.9943F, -1.0243F, -1.0001F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.3F, -2.3F, -0.0944F, 0.2654F, -0.2372F));
		legLeftCenterFrontUpper.addOrReplaceChild("legLeftCenterFrontLower", CubeListBuilder.create().texOffs(0, 54).addBox(-11.4827F, -0.982F, -1.0251F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));
		var legRightCenterRearUpper = bodyMain.addOrReplaceChild("legRightCenterRearUpper", CubeListBuilder.create().texOffs(46, 62).addBox(-7.0057F, -1.0243F, -0.9999F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.3F, -1.3F, 0.0946F, 0.2741F, 0.2381F));
		legRightCenterRearUpper.addOrReplaceChild("legRightCenterRearLower", CubeListBuilder.create().texOffs(26, 43).addBox(-11.4827F, -1.0181F, -0.9874F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftCenterRearUpper = bodyMain.addOrReplaceChild("legLeftCenterRearUpper", CubeListBuilder.create().texOffs(46, 58).addBox(-0.9943F, -1.0243F, -0.9999F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.3F, -1.3F, 0.0946F, -0.2741F, -0.2381F));
		legLeftCenterRearUpper.addOrReplaceChild("legLeftCenterRearLower", CubeListBuilder.create().texOffs(26, 47).addBox(-11.4827F, -0.982F, -0.9874F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));
		var legRightRearUpper = bodyMain.addOrReplaceChild("legRightRearUpper", CubeListBuilder.create().texOffs(40, 66).addBox(-7.0053F, -1.0244F, -0.9999F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.025F, 0.5F, 0.2227F, 0.781F, 0.304F));
		legRightRearUpper.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(56, 54).addBox(-11.4824F, -1.0178F, -0.9874F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftRearUpper = bodyMain.addOrReplaceChild("legLeftRearUpper", CubeListBuilder.create().texOffs(80, 66).addBox(-0.9947F, -1.0744F, -0.9999F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.1F, 0.3F, 0.2227F, -0.781F, -0.304F));
		legLeftRearUpper.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(0, 58).addBox(-11.4824F, -0.9822F, -0.9874F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
