package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.ScorpionEntity;
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

public class ScorpionModel extends HierarchicalModel<ScorpionEntity> {
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

	public ScorpionModel(ModelPart pModelPart) {
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
	public void setupAnim(ScorpionEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.setupRotateAngles();
		this.setupAnim(pLimbSwing, pLimbSwingAmount, pNetHeadYaw, pHeadPitch);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.SCORPION_ATTACK, pAgeInTicks);
	}

	public void setupRotateAngles() {
		IcariaClientHelper.setRotateAngles(this.headMain, -0.085F, 0.0F, 0.0F);
		IcariaClientHelper.setRotateAngles(this.legRightFrontUpper, -0.3581F, -0.7655F, 0.4075F);
		IcariaClientHelper.setRotateAngles(this.legLeftFrontUpper, -0.3814F, 0.7561F, -0.4412F);
		IcariaClientHelper.setRotateAngles(this.legRightCenterFrontUpper, -0.188F, -0.2688F, 0.2789F);
		IcariaClientHelper.setRotateAngles(this.legLeftCenterFrontUpper, -0.1826F, 0.2781F, -0.2766F);
		IcariaClientHelper.setRotateAngles(this.legRightCenterRearUpper, -0.0017F, 0.2709F, 0.2255F);
		IcariaClientHelper.setRotateAngles(this.legLeftCenterRearUpper, -0.0017F, -0.2622F, -0.2255F);
		IcariaClientHelper.setRotateAngles(this.legRightRearUpper, 0.0927F, 0.7865F, 0.2243F);
		IcariaClientHelper.setRotateAngles(this.legLeftRearUpper, 0.0971F, -0.7866F, -0.2243F);
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

		var bodyMain = partDefinition.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -3.5F, -4.0F, 9.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.7F, 0.0F, 0.0911F, 0.0F, 0.0F));
		var headMain = bodyMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -3.0657F, -6.8917F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.525F, -4.025F, -0.085F, 0.0F, 0.0F));
		var armRightRear = headMain.addOrReplaceChild("armRightRear", CubeListBuilder.create().texOffs(0, 59).addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, -0.0657F, -7.8917F, 0.0F, 0.2793F, 0.0F));
		var armRightCenter = armRightRear.addOrReplaceChild("armRightCenter", CubeListBuilder.create().texOffs(0, 63).addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 0.0125F, 0.0F, 0.0F, -1.309F, 0.0F));
		var armRightFront = armRightCenter.addOrReplaceChild("armRightFront", CubeListBuilder.create().texOffs(46, 30).addBox(-6.006F, -1.5F, -2.1738F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9375F, 0.0F, 0.0125F, 0.0F, -0.7156F, 0.0F));
		armRightFront.addOrReplaceChild("fingerRightUpper", CubeListBuilder.create().texOffs(0, 68).addBox(-5.0067F, -0.4971F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.981F, -0.9875F, -0.1738F, 0.0F, 0.0F, -0.182F));
		armRightFront.addOrReplaceChild("fingerRightLower", CubeListBuilder.create().texOffs(42, 59).addBox(-4.768F, -0.4841F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9935F, 1.675F, -0.1738F, 0.0F, 0.0F, 0.0436F));
		var armLeftRear = headMain.addOrReplaceChild("armLeftRear", CubeListBuilder.create().texOffs(16, 59).addBox(0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, -0.0657F, -7.8917F, 0.0F, -0.2793F, 0.0F));
		var armLeftCenter = armLeftRear.addOrReplaceChild("armLeftCenter", CubeListBuilder.create().texOffs(16, 63).addBox(0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.025F, 0.0F, 0.0F, 1.309F, 0.0F));
		var armLeftFront = armLeftCenter.addOrReplaceChild("armLeftFront", CubeListBuilder.create().texOffs(0, 43).addBox(0.0011F, -1.5F, -2.1021F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9F, 0.0F, -0.05F, 0.0F, 0.7285F, 0.0F));
		armLeftFront.addOrReplaceChild("fingerLeftUpper", CubeListBuilder.create().texOffs(0, 71).addBox(-0.0056F, -0.4949F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9886F, -0.9875F, -0.1021F, 0.0F, 0.0F, 0.182F));
		armLeftFront.addOrReplaceChild("fingerLeftLower", CubeListBuilder.create().texOffs(14, 68).addBox(-0.2304F, -0.5216F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9886F, 1.7125F, -0.1021F, 0.0F, 0.0F, -0.0436F));
		headMain.addOrReplaceChild("eyeRightFront", CubeListBuilder.create().texOffs(32, 70).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -2.7657F, -6.5917F));
		headMain.addOrReplaceChild("eyeLeftFront", CubeListBuilder.create().texOffs(32, 68).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -2.7657F, -6.5917F));
		headMain.addOrReplaceChild("eyeRightRear", CubeListBuilder.create().texOffs(36, 68).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, -2.7657F, -3.5917F));
		headMain.addOrReplaceChild("eyeLeftRear", CubeListBuilder.create().texOffs(32, 72).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, -2.7657F, -3.5917F));
		var bodyFront = bodyMain.addOrReplaceChild("bodyFront", CubeListBuilder.create().texOffs(62, 0).addBox(-4.0F, -2.9837F, -0.1256F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4875F, 2.975F, 0.3643F, 0.0F, 0.0F));
		var bodyCenter = bodyFront.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(0, 13).addBox(-3.5F, -2.9986F, -0.8111F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0288F, 6.8619F, 0.2731F, 0.0F, 0.0F));
		var bodyRear = bodyCenter.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(26, 13).addBox(-3.0F, -7.6652F, -2.2439F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6361F, 5.1889F, -0.8652F, 0.0F, 0.0F));
		var tailFront = bodyRear.addOrReplaceChild("tailFront", CubeListBuilder.create().texOffs(28, 30).addBox(-2.5F, -7.657F, -2.8162F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.6652F, -0.2439F, 1.0174F, 0.0F, 0.0F));
		var tailCenter = tailFront.addOrReplaceChild("tailCenter", CubeListBuilder.create().texOffs(20, 43).addBox(-2.0F, -8.0713F, -1.5312F, 4.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.657F, -0.9412F, 0.5009F, 0.0F, 0.0F));
		var tailRear = tailCenter.addOrReplaceChild("tailRear", CubeListBuilder.create().texOffs(32, 59).addBox(-0.5F, -5.6199F, -1.8625F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -8.0588F, -0.0062F, 1.9124F, 0.0F, 0.0F));
		tailRear.addOrReplaceChild("stingerMain", CubeListBuilder.create().texOffs(28, 68).addBox(-0.5F, -4.61F, -0.5308F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.6074F, -0.8F, -0.4098F, 0.0F, 0.0F));
		var legRightFrontUpper = bodyMain.addOrReplaceChild("legRightFrontUpper", CubeListBuilder.create().texOffs(80, 55).addBox(-6.848F, -1.0357F, -0.8559F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.7F, -3.0F, -0.3581F, -0.7655F, 0.4075F));
		legRightFrontUpper.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(0, 30).addBox(-11.3873F, -0.8919F, -0.8683F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftFrontUpper = bodyMain.addOrReplaceChild("legLeftFrontUpper", CubeListBuilder.create().texOffs(40, 55).addBox(-1.2579F, -1.0665F, -0.7541F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.6875F, -3.0F, -0.3814F, 0.7561F, -0.4412F));
		legLeftFrontUpper.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(56, 26).addBox(-11.3135F, -1.1901F, -0.7666F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.0944F));
		var legRightCenterFrontUpper = bodyMain.addOrReplaceChild("legRightCenterFrontUpper", CubeListBuilder.create().texOffs(0, 55).addBox(-6.9187F, -1.0196F, -0.8046F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.125F, -1.3F, -0.188F, -0.2688F, 0.2789F));
		legRightCenterFrontUpper.addOrReplaceChild("legRightCenterFrontLower", CubeListBuilder.create().texOffs(46, 13).addBox(-11.4393F, -0.9425F, -0.8172F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftCenterFrontUpper = bodyMain.addOrReplaceChild("legLeftCenterFrontUpper", CubeListBuilder.create().texOffs(60, 55).addBox(-1.1387F, -1.0378F, -0.6672F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.1F, -1.3F, -0.1826F, 0.2781F, -0.2766F));
		legLeftCenterFrontUpper.addOrReplaceChild("legLeftCenterFrontLower", CubeListBuilder.create().texOffs(84, 26).addBox(-11.3927F, -1.0957F, -0.6797F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));
		var legRightCenterRearUpper = bodyMain.addOrReplaceChild("legRightCenterRearUpper", CubeListBuilder.create().texOffs(34, 43).addBox(-7.0745F, -0.9815F, -0.8018F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.2125F, -0.3F, -0.0017F, 0.2709F, 0.2255F));
		legRightCenterRearUpper.addOrReplaceChild("legRightCenterRearLower", CubeListBuilder.create().texOffs(0, 34).addBox(-11.5561F, -1.0524F, -0.7893F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftCenterRearUpper = bodyMain.addOrReplaceChild("legLeftCenterRearUpper", CubeListBuilder.create().texOffs(34, 47).addBox(-0.8729F, -0.9684F, -0.662F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.2125F, -0.3F, -0.0017F, -0.2622F, -0.2255F));
		legLeftCenterRearUpper.addOrReplaceChild("legLeftCenterRearLower", CubeListBuilder.create().texOffs(46, 17).addBox(-11.5957F, -0.9106F, -0.6495F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));
		var legRightRearUpper = bodyMain.addOrReplaceChild("legRightRearUpper", CubeListBuilder.create().texOffs(34, 51).addBox(-7.1468F, -0.9671F, -0.8499F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.1125F, 1.5F, 0.0927F, 0.7865F, 0.2243F));
		legRightRearUpper.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(0, 26).addBox(-11.6075F, -1.1052F, -0.8374F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
		var legLeftRearUpper = bodyMain.addOrReplaceChild("legLeftRearUpper", CubeListBuilder.create().texOffs(20, 55).addBox(-0.7499F, -0.9417F, -0.7442F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.1125F, 1.3F, 0.0971F, -0.7866F, -0.2243F));
		legLeftRearUpper.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(28, 26).addBox(-11.6852F, -0.822F, -0.7317F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
