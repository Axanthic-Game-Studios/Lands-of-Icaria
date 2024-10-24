package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.SlugEntity;

import com.mojang.blaze3d.vertex.PoseStack;

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

public class CrystalSlugModel extends HierarchicalModel<SlugEntity> {
	public ModelPart root;
	public ModelPart bodyFront;
	public ModelPart neck;
	public ModelPart neckCrystalCenter;
	public ModelPart head;
	public ModelPart feelerRight;
	public ModelPart feelerLeft;
	public ModelPart bodyCenter;
	public ModelPart bodyCenterCrystal;
	public ModelPart bodyRear;
	public ModelPart bodyRearCrystal;

	public CrystalSlugModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyFront = this.root.getChild("bodyFront");
		this.neck = this.bodyFront.getChild("neck");
		this.neckCrystalCenter = this.neck.getChild("neckCrystalCenter");
		this.head = this.neck.getChild("head");
		this.feelerRight = this.head.getChild("feelerRight");
		this.feelerLeft = this.head.getChild("feelerLeft");
		this.bodyCenter = this.root.getChild("bodyCenter");
		this.bodyCenterCrystal = this.root.getChild("bodyCenterCrystal");
		this.bodyRear = this.root.getChild("bodyRear");
		this.bodyRearCrystal = this.root.getChild("bodyRearCrystal");
	}

	@Override
	public void setupAnim(SlugEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.idleAnim(pAgeInTicks);
		this.animate(pEntity.hideAnimationState, IcariaAnimations.CRYSTAL_SLUG_HIDE, pAgeInTicks);
		this.animate(pEntity.hurtAnimationState, IcariaAnimations.CRYSTAL_SLUG_HURT, pAgeInTicks);
		this.animate(pEntity.moveAnimationState, IcariaAnimations.CRYSTAL_SLUG_MOVE, pAgeInTicks);
		this.animate(pEntity.showAnimationState, IcariaAnimations.CRYSTAL_SLUG_SHOW, pAgeInTicks);
	}

	public void idleAnim(float pAgeInTicks) {
		this.feelerRight.xRot = Mth.sin(pAgeInTicks * 0.05F + 1.0F) * 0.075F + 0.2618F;
		this.feelerRight.zRot = Mth.cos(pAgeInTicks * 0.075F + 2.0F) * 0.075F + 0.7854F;
		this.feelerLeft.xRot = -Mth.sin(pAgeInTicks * 0.05F + 3.0F) * 0.075F + 0.2618F;
		this.feelerLeft.zRot = -Mth.cos(pAgeInTicks * 0.075F + 4.0F) * 0.075F - 0.7854F;
	}

	public void translateToNeck(PoseStack pPoseStack) {
		this.bodyFront.translateAndRotate(pPoseStack);
		this.neck.translateAndRotate(pPoseStack);
		this.neckCrystalCenter.translateAndRotate(pPoseStack);
	}

	public void translateToCenter(PoseStack pPoseStack) {
		this.bodyCenterCrystal.translateAndRotate(pPoseStack);
	}

	public void translateToRear(PoseStack pPoseStack) {
		this.bodyRearCrystal.translateAndRotate(pPoseStack);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bodyFront = partDefinition.addOrReplaceChild("bodyFront", CubeListBuilder.create().texOffs(0, 20).addBox(-3.5F, -5.0F, -6.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, -12.0F, -0.3927F, 0.0F, 0.0F));
		var neck = bodyFront.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3927F, 0.0F, 0.0F));
		var neckCrystalCenter = neck.addOrReplaceChild("neckCrystalCenter", CubeListBuilder.create().texOffs(0, 44).addBox(-0.5F, -1.0F, -4.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -5.0F, 0.0F, 0.0F, -0.0873F, -0.1963F));
		neckCrystalCenter.addOrReplaceChild("neckCrystalNorth", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, -3.5F, -5.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, -0.3054F, 0.1091F));
		neckCrystalCenter.addOrReplaceChild("neckCrystalEast", CubeListBuilder.create().texOffs(18, 52).addBox(-1.5F, 0.0F, -4.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, -0.1963F));
		neckCrystalCenter.addOrReplaceChild("neckCrystalSouth", CubeListBuilder.create().texOffs(0, 52).addBox(0.5F, -1.0F, -0.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.1745F, 0.1963F));
		neckCrystalCenter.addOrReplaceChild("neckCrystalWest", CubeListBuilder.create().texOffs(12, 37).addBox(3.5F, -1.0F, -2.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1963F, 0.1745F, 0.1963F));
		var head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -0.3927F, 0.0F, 0.0F));
		head.addOrReplaceChild("mandibleRight", CubeListBuilder.create().texOffs(20, 20).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, -0.5F, 0.1963F, 0.0F, 0.1963F));
		head.addOrReplaceChild("mandibleLeft", CubeListBuilder.create().texOffs(20, 20).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, -0.5F, 0.1963F, 0.0F, -0.1963F));
		var feelerRight = head.addOrReplaceChild("feelerRight", CubeListBuilder.create().texOffs(21, 1).addBox(-0.5F, -0.5F, -4.75F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, -5.0F, 0.2618F, 0.0F, 0.7854F));
		feelerRight.addOrReplaceChild("eyeRight", CubeListBuilder.create().texOffs(15, 0).addBox(-1.0F, -1.0F, -6.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var feelerLeft = head.addOrReplaceChild("feelerLeft", CubeListBuilder.create().texOffs(20, 0).addBox(-0.5F, -0.5F, -5.75F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, -5.0F, 0.2618F, 0.0F, -0.7854F));
		feelerLeft.addOrReplaceChild("eyeLeft", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -1.0F, -7.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(0, 59).addBox(-4.0F, -5.0F, -16.0F, 8.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 4.0F));
		var bodyCenterCrystal = partDefinition.addOrReplaceChild("bodyCenterCrystal", CubeListBuilder.create().texOffs(56, 7).addBox(-4.0F, -1.0F, -8.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 19.0F, 2.0F, 0.0F, 0.0F, 0.3927F));
		bodyCenterCrystal.addOrReplaceChild("bodyCenterCrystalNorth", CubeListBuilder.create().texOffs(64, 0).addBox(-2.5F, -2.25F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.3927F, 0.0F, 0.0F));
		bodyCenterCrystal.addOrReplaceChild("bodyCenterCrystalEast", CubeListBuilder.create().texOffs(48, 17).addBox(-5.0F, -2.35F, -2.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -0.7854F));
		bodyCenterCrystal.addOrReplaceChild("bodyCenterCrystalSouth", CubeListBuilder.create().texOffs(64, 17).addBox(-4.5F, -3.25F, 0.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -0.7854F, 0.0F, 0.0F));
		bodyCenterCrystal.addOrReplaceChild("bodyCenterCrystalWest", CubeListBuilder.create().texOffs(46, 0).addBox(0.0F, -0.5F, -1.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, -0.3927F, 0.0F));
		var bodyRear = partDefinition.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(32, 61).addBox(-3.5F, -4.0F, 0.0F, 7.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 4.0F));
		var tailFront = bodyRear.addOrReplaceChild("tailFront", CubeListBuilder.create().texOffs(56, 62).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));
		tailFront.addOrReplaceChild("tailRear", CubeListBuilder.create().texOffs(62, 74).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));
		var bodyRearCrystal = partDefinition.addOrReplaceChild("bodyRearCrystal", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, -1.0F, 0.1F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 20.0F, 10.0F, -0.1963F, 0.0F, -0.0873F));
		bodyRearCrystal.addOrReplaceChild("bodyRearCrystalNorth", CubeListBuilder.create().texOffs(72, 39).addBox(0.5F, -0.9F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, -0.7854F, 0.2618F));
		bodyRearCrystal.addOrReplaceChild("bodyRearCrystalEast", CubeListBuilder.create().texOffs(56, 51).addBox(-2.0F, 1.1F, 1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.1963F, 0.0F));
		bodyRearCrystal.addOrReplaceChild("bodyRearCrystalSouth", CubeListBuilder.create().texOffs(68, 51).addBox(0.5F, -0.9F, 4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.1963F, 0.2618F));
		bodyRearCrystal.addOrReplaceChild("bodyRearCrystalWest", CubeListBuilder.create().texOffs(62, 37).addBox(2.5F, -0.88F, 1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0654F, 0.3054F));

		return LayerDefinition.create(meshDefinition, 80, 80);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
