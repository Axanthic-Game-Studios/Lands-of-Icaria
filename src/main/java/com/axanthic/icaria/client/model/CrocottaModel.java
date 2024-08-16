package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.CrocottaEntity;
import com.axanthic.icaria.common.math.IcariaMath;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrocottaModel extends HierarchicalModel<CrocottaEntity> {
	public ModelPart root;
	public ModelPart body;
	public ModelPart bodyFront;
	public ModelPart neckRear;
	public ModelPart neckCenter;
	public ModelPart neckFront;
	public ModelPart head;
	public ModelPart maneRear;
	public ModelPart maneCenter;
	public ModelPart maneFront;
	public ModelPart thighRightFront;
	public ModelPart legRightFront;
	public ModelPart pawRightFront;
	public ModelPart thighLeftFront;
	public ModelPart legLeftFront;
	public ModelPart pawLeftFront;
	public ModelPart bodyRear;
	public ModelPart thighRightRear;
	public ModelPart legRightRear;
	public ModelPart pawRightRear;
	public ModelPart thighLeftRear;
	public ModelPart legLeftRear;
	public ModelPart pawLeftRear;

	public CrocottaModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.body = this.root.getChild("body");
		this.bodyFront = this.body.getChild("bodyFront");
		this.neckRear = this.bodyFront.getChild("neckRear");
		this.neckCenter = this.neckRear.getChild("neckCenter");
		this.neckFront = this.neckCenter.getChild("neckFront");
		this.head = this.neckFront.getChild("head");
		this.maneRear = this.body.getChild("maneRear");
		this.maneCenter = this.maneRear.getChild("maneCenter");
		this.maneFront = this.maneCenter.getChild("maneFront");
		this.thighRightFront = this.bodyFront.getChild("thighRightFront");
		this.legRightFront = this.thighRightFront.getChild("legRightFront");
		this.pawRightFront = this.legRightFront.getChild("pawRightFront");
		this.thighLeftFront = this.bodyFront.getChild("thighLeftFront");
		this.legLeftFront = this.thighLeftFront.getChild("legLeftFront");
		this.pawLeftFront = this.legLeftFront.getChild("pawLeftFront");
		this.bodyRear = this.body.getChild("bodyRear");
		this.thighRightRear = this.bodyRear.getChild("thighRightRear");
		this.legRightRear = this.thighRightRear.getChild("legRightRear");
		this.pawRightRear = this.legRightRear.getChild("pawRightRear");
		this.thighLeftRear = this.bodyRear.getChild("thighLeftRear");
		this.legLeftRear = this.thighLeftRear.getChild("legLeftRear");
		this.pawLeftRear = this.legLeftRear.getChild("pawLeftRear");
	}

	@Override
	public void setupAnim(CrocottaEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.lookAnim(pNetHeadYaw, pHeadPitch);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.CROCOTTA_ATTACK, pAgeInTicks);
	}

	public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
		float xRot = IcariaMath.rad(pHeadPitch) / 1.5F;
		float yRot = IcariaMath.rad(pNetHeadYaw) / 3.0F;
		this.maneFront.xRot = xRot + 0.2182F;
		this.maneFront.yRot = yRot;
		this.neckCenter.xRot = xRot + 0.0873F;
		this.neckCenter.yRot = yRot;
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		pLimbSwing *= 1.375F;
		pLimbSwingAmount *= 0.875F;

		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount * 0.5F;

		this.thighRightFront.xRot = -Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.0F) * 0.6F * pLimbSwingAmount + 0.3054F;
		this.legRightFront.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.0F)) * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount - pLimbSwingAmount - 0.1745F;
		this.pawRightFront.xRot = -Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.0F)) * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount + pLimbSwingAmount + 0.0436F;
		this.thighLeftFront.xRot = -Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.0F) * 0.6F * pLimbSwingAmount + 0.3054F;
		this.legLeftFront.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.5F)) * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount - pLimbSwingAmount - 0.1745F;
		this.pawLeftFront.xRot = -Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.5F)) * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount + pLimbSwingAmount + 0.0436F;
		this.thighRightRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.5F) * 1.2F * pLimbSwingAmount + 0.0436F;
		this.legRightRear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount + pLimbSwingAmount + 0.2182F;
		this.pawRightRear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount + pLimbSwingAmount - 0.1309F;
		this.thighLeftRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.5F) * 1.2F * pLimbSwingAmount + 0.0436F;
		this.legLeftRear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount + pLimbSwingAmount + 0.2182F;
		this.pawLeftRear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount + pLimbSwingAmount - 0.1309F;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -18.0F, 0.0F, 7.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition maneRear = body.addOrReplaceChild("maneRear", CubeListBuilder.create().texOffs(8, 47).addBox(-0.5F, 0.0031F, -3.6945F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, 3.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition maneCenter = maneRear.addOrReplaceChild("maneCenter", CubeListBuilder.create().texOffs(14, 38).addBox(-0.5F, 0.0069F, -5.9922F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.7F, 0.2182F, 0.0F, 0.0F));
		maneCenter.addOrReplaceChild("maneFront", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, -2.6051F, -6.004F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.546F, -5.415F, 0.2182F, 0.0F, 0.0F));
		PartDefinition bodyFront = body.addOrReplaceChild("bodyFront", CubeListBuilder.create().texOffs(50, 0).addBox(-3.0F, -8.0114F, -4.8698F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.75F, 0.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition neckRear = bodyFront.addOrReplaceChild("neckRear", CubeListBuilder.create().texOffs(20, 15).addBox(-2.5F, -6.0F, -3.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2614F, -4.8698F, -0.0873F, 0.0F, 0.0F));
		PartDefinition neckCenter = neckRear.addOrReplaceChild("neckCenter", CubeListBuilder.create().texOffs(28, 27).addBox(-2.0F, -0.0192F, -2.9998F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.9886F, -3.0002F, 0.0873F, 0.0F, 0.0F));
		PartDefinition neckFront = neckCenter.addOrReplaceChild("neckFront", CubeListBuilder.create().texOffs(42, 38).addBox(-2.5F, -0.5F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0114F, -1.9998F, 0.0873F, 0.0F, 0.0F));
		PartDefinition head = neckFront.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 0).addBox(-3.0F, -0.9F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.1745F, 0.0F, 0.0F));
		head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(40, 69).addBox(-4.25F, -1.1F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, -2.0F, -0.3491F, 0.0F, 0.1309F));
		head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(46, 69).addBox(2.25F, -1.1F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, -2.0F, -0.3491F, 0.0F, -0.1309F));
		PartDefinition noseRearUpper = head.addOrReplaceChild("noseRearUpper", CubeListBuilder.create().texOffs(0, 58).addBox(-2.0F, -1.9743F, -2.5381F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0364F, -6.0002F, 0.1745F, 0.0F, 0.0F));
		noseRearUpper.addOrReplaceChild("noseFrontUpper", CubeListBuilder.create().texOffs(32, 69).addBox(-1.5F, 0.0011F, -1.0004F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.9754F, -2.5377F));
		PartDefinition noseRearLower = head.addOrReplaceChild("noseRearLower", CubeListBuilder.create().texOffs(22, 58).addBox(-2.0F, 0.0247F, -2.5387F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0364F, -6.0002F, 0.2618F, 0.0F, 0.0F));
		noseRearLower.addOrReplaceChild("noseFrontLower", CubeListBuilder.create().texOffs(32, 72).addBox(-1.5F, -1.0003F, -0.9992F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.025F, -2.5395F));
		PartDefinition thighRightFront = bodyFront.addOrReplaceChild("thighRightFront", CubeListBuilder.create().texOffs(38, 15).addBox(-1.5F, -0.0186F, -2.0319F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -4.9525F, -3.7875F, 0.3054F, 0.0F, 0.0F));
		PartDefinition legRightFront = thighRightFront.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(20, 47).addBox(-1.0F, -1.1696F, -0.9602F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.966F, -0.071F, -0.1745F, 0.0F, 0.0F));
		legRightFront.addOrReplaceChild("pawRightFront", CubeListBuilder.create().texOffs(36, 58).addBox(-1.5F, -0.0087F, -1.7609F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.393F, 0.0535F, 0.0436F, 0.0F, 0.0F));
		PartDefinition thighLeftFront = bodyFront.addOrReplaceChild("thighLeftFront", CubeListBuilder.create().texOffs(0, 27).addBox(-1.5F, -0.0173F, -2.0237F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -4.9525F, -3.7875F, 0.3054F, 0.0F, 0.0F));
		PartDefinition legLeftFront = thighLeftFront.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(14, 58).addBox(-1.0F, -1.1651F, -0.952F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.966F, -0.071F, -0.1745F, 0.0F, 0.0F));
		legLeftFront.addOrReplaceChild("pawLeftFront", CubeListBuilder.create().texOffs(12, 69).addBox(-1.5F, -0.0076F, -1.7528F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.393F, 0.0535F, 0.0436F, 0.0F, 0.0F));
		PartDefinition bodyRear = body.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(0, 15).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 6.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition tail = bodyRear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(28, 38).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 4.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition tailFront = tail.addOrReplaceChild("tailFront", CubeListBuilder.create().texOffs(36, 47).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 2.0F, -0.3927F, 0.0F, 0.0F));
		tailFront.addOrReplaceChild("tailRear", CubeListBuilder.create().texOffs(24, 69).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.1963F, 0.0F, 0.0F));
		PartDefinition thighRightRear = bodyRear.addOrReplaceChild("thighRightRear", CubeListBuilder.create().texOffs(44, 27).addBox(-1.5F, -0.0129F, -1.9996F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.7305F, 2.7385F, 0.0436F, 0.0F, 0.0F));
		PartDefinition legRightRear = thighRightRear.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(28, 47).addBox(-1.0F, -1.3816F, -0.9823F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.979F, -0.023F, 0.2182F, 0.0F, 0.0F));
		legRightRear.addOrReplaceChild("pawRightRear", CubeListBuilder.create().texOffs(0, 69).addBox(-1.5F, -0.0059F, -1.6865F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.04F, 0.0295F, -0.1309F, 0.0F, 0.0F));
		PartDefinition thighLeftRear = bodyRear.addOrReplaceChild("thighLeftRear", CubeListBuilder.create().texOffs(14, 27).addBox(-1.5F, -0.0129F, -1.9996F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.7305F, 2.7385F, 0.0436F, 0.0F, 0.0F));
		PartDefinition legLeftRear = thighLeftRear.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, -1.3816F, -0.9823F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.979F, -0.023F, 0.2182F, 0.0F, 0.0F));
		legLeftRear.addOrReplaceChild("pawLeftRear", CubeListBuilder.create().texOffs(22, 62).addBox(-1.5F, -0.0059F, -1.6865F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.04F, 0.0295F, -0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 80, 80);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
