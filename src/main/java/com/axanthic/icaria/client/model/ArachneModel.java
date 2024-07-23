package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.ArachneEntity;

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

public class ArachneModel extends HierarchicalModel<ArachneEntity> {
	public ModelPart root;
	public ModelPart head;
	public ModelPart abdomen;
	public ModelPart chest;
	public ModelPart shoulders;
	public ModelPart skull;
	public ModelPart body;
	public ModelPart legRightFront;
	public ModelPart legRightCenter;
	public ModelPart legRightRear;
	public ModelPart legLeftFront;
	public ModelPart legLeftCenter;
	public ModelPart legLeftRear;

	public ArachneModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.head = this.root.getChild("head");
		this.abdomen = this.head.getChild("abdomen");
		this.chest = this.abdomen.getChild("chest");
		this.shoulders = this.chest.getChild("shoulders");
		this.skull = this.shoulders.getChild("skull");
		this.body = this.root.getChild("body");
		this.legRightFront = this.root.getChild("legRightFront");
		this.legRightCenter = this.root.getChild("legRightCenter");
		this.legRightRear = this.root.getChild("legRightRear");
		this.legLeftFront = this.root.getChild("legLeftFront");
		this.legLeftCenter = this.root.getChild("legLeftCenter");
		this.legLeftRear = this.root.getChild("legLeftRear");
	}

	@Override
	public void setupAnim(ArachneEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.lookAnim(pNetHeadYaw, pHeadPitch);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.ARACHNE_ATTACK, pAgeInTicks);
	}

	public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
		this.skull.xRot = pHeadPitch * (Mth.PI / 360.0F) + 1.3963F;
		this.skull.zRot = pNetHeadYaw * (Mth.PI / 360.0F);
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		float f0 = -(Mth.cos(pLimbSwing + (Mth.PI)) * 0.5F) * pLimbSwingAmount;
		float f1 = -(Mth.cos(pLimbSwing + (Mth.PI * 0.5F)) * 0.5F) * pLimbSwingAmount;
		float f2 = -(Mth.cos(pLimbSwing + (Mth.PI * 1.5F)) * 0.5F) * pLimbSwingAmount;
		float f3 = Mth.abs(Mth.sin(pLimbSwing + (Mth.PI)) * 0.5F) * pLimbSwingAmount;
		float f4 = Mth.abs(Mth.sin(pLimbSwing + (Mth.PI * 0.5F)) * 0.5F) * pLimbSwingAmount;
		float f5 = Mth.abs(Mth.sin(pLimbSwing + (Mth.PI * 1.5F)) * 0.5F) * pLimbSwingAmount;

		this.legRightFront.yRot = -0.576F + f2;
		this.legRightCenter.yRot = f1;
		this.legRightRear.yRot = 0.576F + f0;
		this.legLeftFront.yRot = 0.576F - f2;
		this.legLeftCenter.yRot = -f1;
		this.legLeftRear.yRot = -0.576F - f0;
		this.legRightFront.zRot = 0.3927F + f5;
		this.legRightCenter.zRot = 0.3927F + f4;
		this.legRightRear.zRot = 0.3927F + f3;
		this.legLeftFront.zRot = -0.3927F - f5;
		this.legLeftCenter.zRot = -0.3927F - f4;
		this.legLeftRear.zRot = -0.3927F - f3;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(114, 151).addBox(-3.5F, -4.0F, -3.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.5F, -2.0F, -0.3927F, 0.0F, 0.0F));
		var abdomen = head.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(86, 150).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -3.0F, -0.3927F, 0.0F, 0.0F));
		var chest = abdomen.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(54, 150).addBox(-5.0F, -4.25F, -6.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3927F, 0.0F, 0.0F));
		var shoulders = chest.addOrReplaceChild("shoulders", CubeListBuilder.create().texOffs(14, 148).addBox(-7.0F, -5.25F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, -6.0F, -0.3927F, 0.0F, 0.0F));
		var skull = shoulders.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(6, 0).addBox(-4.5F, -8.0F, -4.0F, 9.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(-4.5F, -3.0F, -1.0F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 7).addBox(-5.0F, -6.25F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 3).addBox(-5.0F, -7.0F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(7, 0).addBox(-2.5F, -7.75F, -4.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 5).addBox(-3.5F, -8.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 7).addBox(4.0F, -6.5F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(35, 3).addBox(3.0F, -6.75F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(31, 0).addBox(0.5F, -7.5F, -4.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 5).addBox(2.75F, -8.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.125F, -3.5625F, 1.3963F, 0.0F, 0.0F));
		skull.addOrReplaceChild("teethRight", CubeListBuilder.create().texOffs(12, 12).addBox(-2.5F, -1.0F, -0.25F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, -4.0F, 0.3927F, 0.0F, -0.1309F));
		skull.addOrReplaceChild("teethLeft", CubeListBuilder.create().texOffs(22, 12).addBox(-0.5F, -1.5F, -0.25F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, -4.0F, 0.3927F, 0.0F, 0.1309F));
		var biterRight = skull.addOrReplaceChild("biterRight", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, 0.6F, -4.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, -1.0F, 0.7854F, 0.576F, 0.0F));
		biterRight.addOrReplaceChild("biterRightOuter", CubeListBuilder.create().texOffs(0, 21).addBox(-2.25F, -2.5F, -8.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.5F, 1.5F, 0.0F, 0.0F, 0.6981F));
		var biterLeft = skull.addOrReplaceChild("biterLeft", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, 0.6F, -4.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -4.0F, -1.0F, 0.7854F, -0.576F, 0.0F));
		biterLeft.addOrReplaceChild("biterLeftOuter", CubeListBuilder.create().texOffs(30, 19).addBox(-5.75F, -0.625F, -6.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		var armRight = shoulders.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(10, 99).addBox(-12.5F, -2.0F, -0.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 124).addBox(-12.5F, 1.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -0.75F, -4.0F, 0.3927F, 0.0F, 0.3927F));
		armRight.addOrReplaceChild("forearmRight", CubeListBuilder.create().texOffs(84, 109).addBox(0.0F, -0.7F, 0.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 4.0F, 0.0F, 0.0436F, 0.0F, -0.2618F));
		var armLeft = shoulders.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(10, 124).addBox(1.5F, -2.0F, -0.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 98).addBox(9.5F, 1.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -0.75F, -4.0F, 0.3927F, 0.0F, -0.3927F));
		armLeft.addOrReplaceChild("forearmLeft", CubeListBuilder.create().texOffs(84, 135).addBox(-1.75F, 0.4F, 0.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 4.0F, 0.0F, 0.0436F, 0.0F, 0.2618F));
		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(136, 148).addBox(-3.0F, -9.3188F, -2.9284F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.3F, 1.1F));
		var bodyFront = body.addOrReplaceChild("bodyFront", CubeListBuilder.create().texOffs(132, 136).addBox(-5.0F, -7.0F, 0.0F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 3.1F, 0.1745F, 0.0F, 0.0F));
		var bodyFrontCenter = bodyFront.addOrReplaceChild("bodyFrontCenter", CubeListBuilder.create().texOffs(124, 120).addBox(-6.0F, -8.0F, 4.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.15F, -0.275F, -0.0436F, 0.0F, 0.0F));
		var bodyFrontRear = bodyFrontCenter.addOrReplaceChild("bodyFrontRear", CubeListBuilder.create().texOffs(120, 102).addBox(-7.0F, -1.0F, 5.0F, 14.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.2F, 4.0F, -0.0436F, 0.0F, 0.0F));
		var bodyCenterFront = bodyFrontRear.addOrReplaceChild("bodyCenterFront", CubeListBuilder.create().texOffs(124, 86).addBox(-6.0F, 1.5F, 4.75F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.775F, 5.25F, -0.0436F, 0.0F, 0.0F));
		var bodyCenter = bodyCenterFront.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(130, 73).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.475F, 10.775F, -0.0436F, 0.0F, 0.0F));
		var bodyCenterRear = bodyCenter.addOrReplaceChild("bodyCenterRear", CubeListBuilder.create().texOffs(136, 63).addBox(-4.0F, 1.5F, 2.5F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.675F, 0.575F, -0.0436F, 0.0F, 0.0F));
		var bodyRearFront = bodyCenterRear.addOrReplaceChild("bodyRearFront", CubeListBuilder.create().texOffs(142, 55).addBox(-3.0F, 1.5F, 2.25F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.45F, 4.3F, -0.0873F, 0.0F, 0.0F));
		var bodyRearCenter = bodyRearFront.addOrReplaceChild("bodyRearCenter", CubeListBuilder.create().texOffs(146, 48).addBox(-2.0F, 1.75F, 1.25F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, 4.3F, -0.1745F, 0.0F, 0.0F));
		var bodyRear = bodyRearCenter.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(148, 0).addBox(-1.5F, 0.0F, -0.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1F, 4.025F, -0.3491F, 0.0F, 0.0F));
		var stingerFront = bodyRear.addOrReplaceChild("stingerFront", CubeListBuilder.create().texOffs(150, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.175F, 1.325F, -0.3491F, 0.0F, 0.0F));
		stingerFront.addOrReplaceChild("stingerRear", CubeListBuilder.create().texOffs(154, 11).addBox(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.525F, 3.225F, -0.3491F, 0.0F, 0.0F));
		var legRightFront = partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(0, 105).addBox(-14.5F, -3.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 129).addBox(-14.5F, 0.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 15.0F, 0.0F, -0.2618F, -0.576F, 0.3927F));
		legRightFront.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(76, 110).addBox(-2.5F, 0.95F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.5F, 1.0F, 0.0F, 0.0F, -0.2618F));
		var legRightCenter = partDefinition.addOrReplaceChild("legRightCenter", CubeListBuilder.create().texOffs(0, 111).addBox(-14.5F, -4.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 136).addBox(-14.5F, -1.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 16.0F, 2.0F, 0.0F, 0.0F, 0.3927F));
		legRightCenter.addOrReplaceChild("legRightCenterLower", CubeListBuilder.create().texOffs(68, 109).addBox(-2.0F, 0.8F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.5F, 1.0F, 0.0F, 0.0F, -0.2618F));
		var legRightRear = partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(0, 117).addBox(-14.0F, -2.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 141).addBox(-14.0F, 1.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 14.0F, 4.0F, 0.1745F, 0.576F, 0.3927F));
		legRightRear.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(60, 110).addBox(-2.25F, 0.9F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 2.5F, 1.0F, 0.0F, 0.0F, -0.2618F));
		var legLeftFront = partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(0, 130).addBox(-1.5F, -3.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 105).addBox(11.5F, 0.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 15.0F, 0.0F, -0.2618F, 0.576F, -0.3927F));
		legLeftFront.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(76, 135).addBox(-1.0F, 1.25F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 1.5F, 1.0F, 0.0F, 0.0F, 0.2618F));
		var legLeftCenter = partDefinition.addOrReplaceChild("legLeftCenter", CubeListBuilder.create().texOffs(0, 136).addBox(-1.5F, -4.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 110).addBox(11.5F, -1.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 16.0F, 2.0F, 0.0F, 0.0F, -0.3927F));
		legLeftCenter.addOrReplaceChild("legLeftCenterLower", CubeListBuilder.create().texOffs(68, 135).addBox(-0.75F, 1.9F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, 1.0F, 0.0F, 0.0F, 0.2618F));
		var legLeftRear = partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(0, 142).addBox(-2.0F, -2.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 115).addBox(11.0F, 1.0F, -0.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 14.0F, 4.0F, 0.1745F, -0.576F, -0.3927F));
		legLeftRear.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(60, 137).addBox(-0.75F, 3.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 2.5F, 1.0F, 0.0F, 0.0F, 0.2618F));

		return LayerDefinition.create(meshDefinition, 160, 160);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
