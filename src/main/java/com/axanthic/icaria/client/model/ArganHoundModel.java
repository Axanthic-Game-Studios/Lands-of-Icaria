package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.ArganHoundEntity;
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

public class ArganHoundModel extends HierarchicalModel<ArganHoundEntity> {
	public ModelPart root;
	public ModelPart head;
	public ModelPart skull;
	public ModelPart body;
	public ModelPart legRightFront;
	public ModelPart legRightFrontLower;
	public ModelPart legLeftFront;
	public ModelPart legLeftFrontLower;
	public ModelPart legRightRear;
	public ModelPart legRightRearLower;
	public ModelPart legLeftRear;
	public ModelPart legLeftRearLower;

	public ArganHoundModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.head = this.root.getChild("head");
		this.skull = this.head.getChild("skull");
		this.body = this.root.getChild("body");
		this.legRightFront = this.root.getChild("legRightFront");
		this.legRightFrontLower = this.legRightFront.getChild("legRightFrontLower");
		this.legLeftFront = this.root.getChild("legLeftFront");
		this.legLeftFrontLower = this.legLeftFront.getChild("legLeftFrontLower");
		this.legRightRear = this.root.getChild("legRightRear");
		this.legRightRearLower = this.legRightRear.getChild("legRightRearLower");
		this.legLeftRear = this.root.getChild("legLeftRear");
		this.legLeftRearLower = this.legLeftRear.getChild("legLeftRearLower");
	}

	@Override
	public void setupAnim(ArganHoundEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.lookAnim(pNetHeadYaw, pHeadPitch);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.ARGAN_HOUND_ATTACK, pAgeInTicks);
	}

	public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
		this.skull.xRot = IcariaMath.rad(pHeadPitch) + 0.3927F;
		this.skull.yRot = IcariaMath.rad(pNetHeadYaw);
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount * 0.5F;

		this.legRightFront.xRot = -Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.0F) * 0.6F * pLimbSwingAmount + 0.1822F;
		this.legRightFrontLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.0F)) * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount - pLimbSwingAmount - 0.3643F;
		this.legLeftFront.xRot = -Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.0F) * 0.6F * pLimbSwingAmount + 0.1822F;
		this.legLeftFrontLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.5F)) * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount - pLimbSwingAmount - 0.3643F;
		this.legRightRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.5F) * 1.2F * pLimbSwingAmount - 0.2731F;
		this.legRightRearLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount + pLimbSwingAmount + 0.2731F;
		this.legLeftRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.5F) * 1.2F * pLimbSwingAmount - 0.2731F;
		this.legLeftRearLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount + pLimbSwingAmount + 0.2731F;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(19, 28).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.3433F, -6.0869F, -0.3016F, 0.0F, 0.0F));
		var skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 48).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -1.0F, 0.3927F, 0.0F, 0.0F));
		var nose = skull.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(43, 46).addBox(-2.0F, -1.025F, -4.925F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.975F, -5.075F));
		nose.addOrReplaceChild("teethRight", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0125F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.4625F, -2.925F, 0.7854F, 0.0F, 0.0F));
		nose.addOrReplaceChild("teethLeft", CubeListBuilder.create().texOffs(38, 9).addBox(-0.5125F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.025F, -0.4375F, -2.925F, 0.7854F, 0.0F, 0.0F));
		skull.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(24, 50).addBox(-1.5F, -0.5666F, -4.0116F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4375F, -5.625F, 0.1367F, 0.0F, 0.0F));
		skull.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(0, 20).addBox(-1.5F, -6.0F, 1.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.425F, -0.3125F, -2.0F, 0.3927F, 0.0F, -0.7854F));
		skull.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(0, 40).addBox(-1.5F, -6.0F, 1.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.55F, -0.4F, -2.0F, 0.3927F, 0.0F, 0.7854F));
		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -16.1115F, -5.5236F, 8.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.7F, 0.0F, 0.0873F, 0.0F, 0.0F));
		body.addOrReplaceChild("rump", CubeListBuilder.create().texOffs(31, 13).addBox(-3.5F, -16.0F, 5.4875F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8975F, -2.8263F, -0.182F, 0.0F, 0.0F));
		var spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 20).addBox(-1.5F, 0.0F, -9.0F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.329F, 2.1619F, 0.1571F, 0.0F, 0.0F));
		var spineFront = spine.addOrReplaceChild("spineFront", CubeListBuilder.create().texOffs(15, 20).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		spineFront.addOrReplaceChild("spineRear", CubeListBuilder.create().texOffs(51, 28).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.3927F, 0.0F, 0.0F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(37, 28).addBox(-1.0F, -0.2375F, 1.5125F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -14.3311F, 9.8145F, -0.4552F, 0.0F, 0.0F));
		body.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(24, 39).addBox(-0.5F, -1.725F, -2.9125F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -11.7995F, 5.8914F, 0.7418F, 0.0F, 0.0F));
		body.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(36, 40).addBox(-0.5F, -1.6125F, -3.2625F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -12.112F, 6.0164F, 0.7418F, 0.0F, 0.0F));
		var legRightFront = partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(41, 0).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 15.2282F, -2.6742F, 0.1822F, 0.0F, 0.0F));
		legRightFront.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(37, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.3643F, 0.0F, 0.0F));
		var legLeftFront = partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(27, 0).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 15.2282F, -2.6742F, 0.1822F, 0.0F, 0.0F));
		legLeftFront.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(52, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.3643F, 0.0F, 0.0F));
		var legRightRear = partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(10, 39).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 15.4793F, 8.2365F, -0.2731F, 0.0F, 0.0F));
		legRightRear.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(55, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.2731F, 0.0F, 0.0F));
		var legLeftRear = partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 15.4793F, 8.2365F, -0.2731F, 0.0F, 0.0F));
		legLeftRear.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.2731F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
