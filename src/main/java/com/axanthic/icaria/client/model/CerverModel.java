package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.CerverEntity;
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

public class CerverModel extends HierarchicalModel<CerverEntity> {
	public ModelPart root;
	public ModelPart head;
	public ModelPart skull;
	public ModelPart body;
	public ModelPart legRightFront;
	public ModelPart legRightFrontLower;
	public ModelPart pawRightFront;
	public ModelPart legLeftFront;
	public ModelPart legLeftFrontLower;
	public ModelPart pawLeftFront;
	public ModelPart legRightRear;
	public ModelPart legRightRearLower;
	public ModelPart pawRightRear;
	public ModelPart legLeftRear;
	public ModelPart legLeftRearLower;
	public ModelPart pawLeftRear;

	public CerverModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.head = this.root.getChild("head");
		this.skull = this.head.getChild("skull");
		this.body = this.root.getChild("body");
		this.legRightFront = this.root.getChild("legRightFront");
		this.legRightFrontLower = this.legRightFront.getChild("legRightFrontLower");
		this.pawRightFront = this.legRightFrontLower.getChild("pawRightFront");
		this.legLeftFront = this.root.getChild("legLeftFront");
		this.legLeftFrontLower = this.legLeftFront.getChild("legLeftFrontLower");
		this.pawLeftFront = this.legLeftFrontLower.getChild("pawLeftFront");
		this.legRightRear = this.root.getChild("legRightRear");
		this.legRightRearLower = this.legRightRear.getChild("legRightRearLower");
		this.pawRightRear = this.legRightRearLower.getChild("pawRightRear");
		this.legLeftRear = this.root.getChild("legLeftRear");
		this.legLeftRearLower = this.legLeftRear.getChild("legLeftRearLower");
		this.pawLeftRear = this.legLeftRearLower.getChild("pawLeftRear");
	}

	@Override
	public void setupAnim(CerverEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.lookAnim(pNetHeadYaw, pHeadPitch);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.CERVER_ATTACK, pAgeInTicks);
	}

	public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
		this.skull.xRot = IcariaMath.rad(pHeadPitch) + 0.2138F;
		this.skull.yRot = IcariaMath.rad(pNetHeadYaw);
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount * 0.5F;

		this.legRightFront.xRot = -Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.0F) * 0.6F * pLimbSwingAmount + 0.182F;
		this.legRightFrontLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.0F)) * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount - pLimbSwingAmount - 0.3187F;
		this.pawRightFront.xRot = -Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.0F)) * 0.5F + Mth.PI * 0.0F) * 1.7F * pLimbSwingAmount + 1.7F * pLimbSwingAmount + 0.1367F;
		this.legLeftFront.xRot = -Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.0F) * 0.6F * pLimbSwingAmount + 0.182F;
		this.legLeftFrontLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.5F)) * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount - pLimbSwingAmount - 0.3187F;
		this.pawLeftFront.xRot = -Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.5F)) * 0.5F + Mth.PI * 1.0F) * 1.7F * pLimbSwingAmount + 1.7F * pLimbSwingAmount + 0.1367F;
		this.legRightRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.5F) * 1.2F * pLimbSwingAmount - 0.4383F;
		this.legRightRearLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount + pLimbSwingAmount + 0.5918F;
		this.pawRightRear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * 1.7F * pLimbSwingAmount + 1.0F * pLimbSwingAmount - 0.1367F;
		this.legLeftRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.5F) * 1.2F * pLimbSwingAmount - 0.4383F;
		this.legLeftRearLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount + pLimbSwingAmount + 0.5918F;
		this.pawLeftRear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * 1.7F * pLimbSwingAmount + 1.0F * pLimbSwingAmount - 0.1367F;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(72, 0).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.2181F, -3.9255F));
		var skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(66, 21).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -3.5F, 0.2138F, 0.0F, 0.0F));
		var snout = skull.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(12, 20).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -6.0F));
		snout.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(12, 44).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.3F));
		snout.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(24, 18).addBox(-1.5F, -0.5166F, -3.611F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3875F, 0.0F, 0.1963F, 0.0F, 0.0F));
		skull.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, -1.75F, -2.5F, 0.0F, -0.5236F, 0.7854F));
		skull.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.75F, -2.5F, 0.5236F, 0.0F, 0.7854F));
		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -8.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, 2.0F, -0.1367F, 0.0F, 0.0F));
		var front = body.addOrReplaceChild("front", CubeListBuilder.create().texOffs(30, 13).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1534F, 7.6926F, 0.0853F, 0.0F, 0.0F));
		var rear = front.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-4.5F, 0.2F, -2.1F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.3F, 3.6F, -0.7854F, 0.0F, 0.0F));
		var tailFront = rear.addOrReplaceChild("tailFront", CubeListBuilder.create().texOffs(30, 30).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.8F, 2.0033F, 0.0F, 0.0F));
		tailFront.addOrReplaceChild("tailRear", CubeListBuilder.create().texOffs(62, 33).addBox(-0.98F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -1.5F, 0.5463F, 0.0F, 0.0F));
		var legRightFront = partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(56, 0).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 10.3704F, -4.8828F, 0.182F, 0.0F, 0.0F));
		var legRightFrontLower = legRightFront.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(81, 10).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.5F, -0.3187F, 0.0F, 0.0F));
		legRightFrontLower.addOrReplaceChild("pawRightFront", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.3F, 0.1367F, 0.0F, 0.0F));
		var legLeftFront = partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 10.3704F, -4.8828F, 0.182F, 0.0F, 0.0F));
		var legLeftFrontLower = legLeftFront.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(69, 10).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.5F, -0.3187F, 0.0F, 0.0F));
		legLeftFrontLower.addOrReplaceChild("pawLeftFront", CubeListBuilder.create().texOffs(56, 17).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.3F, 0.1367F, 0.0F, 0.0F));
		var legRightRear = partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(50, 30).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 12.209F, 12.8827F, -0.4383F, 0.0F, 0.0F));
		var legRightRearLower = legRightRear.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(82, 33).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 5.15F, -0.25F, 0.5918F, 0.0F, 0.0F));
		legRightRearLower.addOrReplaceChild("pawRightRear", CubeListBuilder.create().texOffs(16, 38).addBox(-2.0F, 0.0F, -2.2F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.3F, 0.0F, -0.1367F, 0.0F, 0.0F));
		var legLeftRear = partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(38, 30).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 12.209F, 12.8827F, -0.4383F, 0.0F, 0.0F));
		var legLeftRearLower = legLeftRear.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(70, 33).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 5.15F, -0.25F, 0.5918F, 0.0F, 0.0F));
		legLeftRearLower.addOrReplaceChild("pawLeftRear", CubeListBuilder.create().texOffs(0, 38).addBox(-2.0F, 0.0F, -2.2F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.3F, 0.0F, -0.1367F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 96, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
