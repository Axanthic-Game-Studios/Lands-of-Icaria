package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.CaptainRevenantEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.HumanoidArm;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantModel extends HierarchicalModel<CaptainRevenantEntity> implements ArmedModel {
    public ModelPart root;
    public ModelPart bodyUpper;
    public ModelPart headMain;
    public ModelPart jawUpper;
    public ModelPart jawLower;
    public ModelPart shoulderMain;
    public ModelPart armRightUpper;
    public ModelPart armRightLower;
    public ModelPart armLeftUpper;
    public ModelPart armLeftLower;
    public ModelPart chestplateUpper;
    public ModelPart beltMain;
    public ModelPart bodyLower;
    public ModelPart pelvisMain;
    public ModelPart pelvisRight;
    public ModelPart pelvisLeft;
    public ModelPart thighRight;
    public ModelPart thighLeft;
    public ModelPart legRight;
    public ModelPart legLeft;

    public CaptainRevenantModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.bodyUpper = this.root.getChild("bodyUpper");
        this.headMain = this.bodyUpper.getChild("headMain");
        this.jawUpper = this.headMain.getChild("jawUpper");
        this.jawLower = this.jawUpper.getChild("jawLower");
        this.shoulderMain = this.bodyUpper.getChild("shoulderMain");
        this.armRightUpper = this.shoulderMain.getChild("armRightUpper");
        this.armRightLower = this.armRightUpper.getChild("armRightLower");
        this.armLeftUpper = this.shoulderMain.getChild("armLeftUpper");
        this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
        this.chestplateUpper = this.bodyUpper.getChild("chestplateUpper");
        this.beltMain = this.chestplateUpper.getChild("beltMain");
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
    public void setupAnim(CaptainRevenantEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        var randomSource = RandomSource.create(pEntity.getId());

        this.bodyUpper.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount - 4.0F;
        this.bodyLower.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount - 8.0F;

        this.setRotateAngles(this.headMain, 0.0F, 0.0F, randomSource.nextIntBetweenInclusive(-50, 50) * 0.005F);
        this.setRotateAngles(this.jawLower, 0.1047F, 0.0F, 0.0F);
        this.setRotateAngles(this.armRightUpper, 0.0F, 0.0F, 0.1239F);
        this.setRotateAngles(this.armRightLower, -0.1047F, 0.0F, -0.1047F);
        this.setRotateAngles(this.armLeftUpper, 0.0F, 0.0F, -0.1239F);
        this.setRotateAngles(this.armLeftLower, -0.1047F, 0.0F, 0.1047F);
        this.setRotateAngles(this.thighRight, -0.3142F, 0.3142F, -0.0436F);
        this.setRotateAngles(this.thighLeft, -0.3142F, -0.3142F, 0.0436F);
        this.setRotateAngles(this.legRight, 0.2094F, 0.0F, 0.0F);
        this.setRotateAngles(this.legLeft, 0.2094F, 0.0F, 0.0F);

        this.attackAnim();
        this.idleAnim(pAgeInTicks);
        this.lookAnim(pHeadPitch, pNetHeadYaw);
        this.rideAnim();
        this.walkAnim(pLimbSwing, pLimbSwingAmount);

        this.animate(pEntity.unequipsAnimationState, IcariaAnimations.CAPTAIN_REVENANT_EQUIPS, pAgeInTicks);
        this.animate(pEntity.rallyingAnimationState, IcariaAnimations.CAPTAIN_REVENANT_RALLYING, pAgeInTicks);
        this.animate(pEntity.reequipsAnimationState, IcariaAnimations.CAPTAIN_REVENANT_EQUIPS, pAgeInTicks);
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
        this.headMain.zRot += Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
        this.jawLower.xRot += Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
        this.armRightUpper.xRot += Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
        this.armRightUpper.zRot += Mth.cos(pAgeInTicks * 0.09F) * 0.05F + 0.05F;
        this.armLeftUpper.xRot -= Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
        this.armLeftUpper.zRot -= Mth.cos(pAgeInTicks * 0.09F) * 0.05F + 0.05F;
    }

    public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
        this.headMain.xRot += pHeadPitch * (Mth.PI / 180.0F);
        this.headMain.yRot += pNetHeadYaw * (Mth.PI / 180.0F);
    }

    public void rideAnim() {
        if (this.riding) {
            this.armRightUpper.xRot -= (Mth.PI / 5.0F);
            this.armLeftUpper.xRot -= (Mth.PI / 5.0F);
            this.thighRight.xRot -= 1.2F;
            this.thighRight.yRot += (Mth.PI / 10.0F);
            this.thighRight.zRot += 0.07F;
            this.thighLeft.xRot -= 1.2F;
            this.thighLeft.yRot -= (Mth.PI / 10.0F);
            this.thighLeft.zRot -= 0.07F;
            this.legRight.xRot += 0.7F;
            this.legLeft.xRot += 0.7F;
        }
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        this.armRightUpper.xRot += Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * 2.0F * pLimbSwingAmount * 0.5F;
        this.armRightLower.xRot -= Mth.cos(pLimbSwing * 0.6662F) * 2.0F * pLimbSwingAmount * 0.5F + 2.0F * pLimbSwingAmount * 0.5F;
        this.armLeftUpper.xRot += Mth.cos(pLimbSwing * 0.6662F) * 2.0F * pLimbSwingAmount * 0.5F;
        this.armLeftLower.xRot -= Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * 2.0F * pLimbSwingAmount * 0.5F + 2.0F * pLimbSwingAmount * 0.5F;
        this.thighRight.xRot += Mth.cos(pLimbSwing * 0.6662F) * 0.5F * pLimbSwingAmount;
        this.thighLeft.xRot += Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * 0.5F * pLimbSwingAmount;
        this.legRight.xRot += Mth.cos(pLimbSwing * 0.6662F) * 0.8F * pLimbSwingAmount + 0.8F * pLimbSwingAmount;
        this.legLeft.xRot += Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * 0.8F * pLimbSwingAmount + 0.8F * pLimbSwingAmount;
    }

    @Override
    public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
        this.bodyUpper.translateAndRotate(pPoseStack);
        this.shoulderMain.translateAndRotate(pPoseStack);
        this.armRightUpper.translateAndRotate(pPoseStack);
        this.armRightLower.translateAndRotate(pPoseStack);
    }

    public void translateToBelt(PoseStack pPoseStack) {
        this.bodyUpper.translateAndRotate(pPoseStack);
        this.chestplateUpper.translateAndRotate(pPoseStack);
        this.beltMain.translateAndRotate(pPoseStack);
    }

    public static LayerDefinition createLayer() {
        var meshDefinition = new MeshDefinition();
        var partDefinition = meshDefinition.getRoot();

        var bodyUpper = partDefinition.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(53, 62).addBox(-1.0F, -2.0F, 0.4F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));
        var headMain = bodyUpper.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(0, 29).addBox(-3.5F, -8.0F, -4.0F, 7.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        var jawUpper = headMain.addOrReplaceChild("jawUpper", CubeListBuilder.create().texOffs(53, 55).addBox(-2.5F, -2.0F, -3.5F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        jawUpper.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(55, 38).addBox(-2.5F, -0.8F, -3.3F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1047F, 0.0F, 0.0F));
        var helmetMain = headMain.addOrReplaceChild("helmetMain", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.5F, -4.7F, 8.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));
        var cristaBase = helmetMain.addOrReplaceChild("cristaBase", CubeListBuilder.create().texOffs(16, 43).addBox(-1.0F, -3.5F, -5.5F, 2.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));
        cristaBase.addOrReplaceChild("cristaMain", CubeListBuilder.create().texOffs(34, 0).addBox(-0.5F, -5.5F, -6.2F, 1.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));
        var shoulderMain = bodyUpper.addOrReplaceChild("shoulderMain", CubeListBuilder.create().texOffs(53, 29).addBox(-6.5F, 1.5F, 0.0F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        var armRightUpper = shoulderMain.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(0, 0).addBox(-1.8F, 0.0F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.1239F));
        var shoulderpieceRight = armRightUpper.addOrReplaceChild("shoulderpieceRight", CubeListBuilder.create().texOffs(38, 18).addBox(-2.5F, -2.0F, -3.5F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4905F, 0.5025F, 0.0F, 0.0F, 0.0F, -0.1239F));
        shoulderpieceRight.addOrReplaceChild("armpieceRight", CubeListBuilder.create().texOffs(47, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7697F, 0.9475F, 0.0F, 0.0F, 0.0F, -1.0472F));
        armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(42, 69).addBox(-0.992F, -0.0633F, -0.9884F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8125F, 7.0F, 0.5F, -0.1047F, 0.0F, -0.1047F));
        var armLeftUpper = shoulderMain.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(71, 31).addBox(-0.2F, 0.0F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.1239F));
        var shoulderpieceLeft = armLeftUpper.addOrReplaceChild("shoulderpieceLeft", CubeListBuilder.create().texOffs(38, 44).addBox(-2.5F, -2.0F, -3.5F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4984F, 0.5014F, 0.0F, 0.0F, 0.0F, 0.1239F));
        shoulderpieceLeft.addOrReplaceChild("armpieceLeft", CubeListBuilder.create().texOffs(55, 12).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7705F, 0.9489F, 0.0F, 0.0F, 0.0F, 1.0472F));
        armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(0, 29).addBox(-0.975F, 0.0125F, -1.025F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7625F, 6.9875F, 0.525F, -0.1047F, 0.0F, 0.1047F));
        var ribUpperRightRear = bodyUpper.addOrReplaceChild("ribUpperRightRear", CubeListBuilder.create().texOffs(24, 57).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribUpperRightSide = ribUpperRightRear.addOrReplaceChild("ribUpperRightSide", CubeListBuilder.create().texOffs(32, 18).addBox(-6.0F, 5.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribUpperRightSide.addOrReplaceChild("ribUpperRightFront", CubeListBuilder.create().texOffs(16, 57).addBox(-5.0F, 2.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));
        var ribUpperLeftRear = bodyUpper.addOrReplaceChild("ribUpperLeftRear", CubeListBuilder.create().texOffs(55, 22).addBox(1.0F, 3.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribUpperLeftSide = ribUpperLeftRear.addOrReplaceChild("ribUpperLeftSide", CubeListBuilder.create().texOffs(62, 22).addBox(5.0F, 1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        ribUpperLeftSide.addOrReplaceChild("ribUpperLeftFront", CubeListBuilder.create().texOffs(22, 34).addBox(2.0F, 4.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribUpperCenterRightRear = bodyUpper.addOrReplaceChild("ribUpperCenterRightRear", CubeListBuilder.create().texOffs(34, 9).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1047F));
        var ribUpperCenterRightSide = ribUpperCenterRightRear.addOrReplaceChild("ribUpperCenterRightSide", CubeListBuilder.create().texOffs(55, 45).addBox(-6.0F, 1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        ribUpperCenterRightSide.addOrReplaceChild("ribUpperCenterRightFront", CubeListBuilder.create().texOffs(75, 18).addBox(-5.3F, 3.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.3F, -2.0F, 0.0F));
        var ribUpperCenterLeftRear = bodyUpper.addOrReplaceChild("ribUpperCenterLeftRear", CubeListBuilder.create().texOffs(75, 8).addBox(1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1047F));
        var ribUpperCenterLeftSide = ribUpperCenterLeftRear.addOrReplaceChild("ribUpperCenterLeftSide", CubeListBuilder.create().texOffs(69, 55).addBox(5.0F, 1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        ribUpperCenterLeftSide.addOrReplaceChild("ribUpperCenterLeftFront", CubeListBuilder.create().texOffs(24, 60).addBox(2.0F, 3.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribCenterRightRear = bodyUpper.addOrReplaceChild("ribCenterRightRear", CubeListBuilder.create().texOffs(74, 26).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 1.0F, 0.0F, 0.0F, 0.0F, -0.2094F));
        var ribCenterRightSide = ribCenterRightRear.addOrReplaceChild("ribCenterRightSide", CubeListBuilder.create().texOffs(48, 55).addBox(-6.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribCenterRightSide.addOrReplaceChild("ribCenterRightFront", CubeListBuilder.create().texOffs(61, 0).addBox(-5.4F, 4.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4F, 1.0F, 0.0F));
        var ribCenterLeftRear = bodyUpper.addOrReplaceChild("ribCenterLeftRear", CubeListBuilder.create().texOffs(69, 16).addBox(1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 1.0F, 0.0F, 0.0F, 0.0F, 0.2094F));
        var ribCenterLeftSide = ribCenterLeftRear.addOrReplaceChild("ribCenterLeftSide", CubeListBuilder.create().texOffs(58, 33).addBox(5.0F, 1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        ribCenterLeftSide.addOrReplaceChild("ribCenterLeftFront", CubeListBuilder.create().texOffs(75, 10).addBox(2.0F, 3.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribLowerCenterRightRear = bodyUpper.addOrReplaceChild("ribLowerCenterRightRear", CubeListBuilder.create().texOffs(58, 10).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3142F));
        var ribLowerCenterRightSide = ribLowerCenterRightRear.addOrReplaceChild("ribLowerCenterRightSide", CubeListBuilder.create().texOffs(68, 24).addBox(-6.0F, 1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        ribLowerCenterRightSide.addOrReplaceChild("ribLowerCenterRightFront", CubeListBuilder.create().texOffs(75, 12).addBox(-5.0F, 3.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribLowerCenterLeftRear = bodyUpper.addOrReplaceChild("ribLowerCenterLeftRear", CubeListBuilder.create().texOffs(74, 24).addBox(1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3142F));
        var ribLowerCenterLeftSide = ribLowerCenterLeftRear.addOrReplaceChild("ribLowerCenterLeftSide", CubeListBuilder.create().texOffs(69, 11).addBox(5.0F, 1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        ribLowerCenterLeftSide.addOrReplaceChild("ribLowerCenterLeftFront", CubeListBuilder.create().texOffs(24, 62).addBox(2.0F, 3.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribLowerRightRear = bodyUpper.addOrReplaceChild("ribLowerRightRear", CubeListBuilder.create().texOffs(0, 64).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 3.0F, 0.0F, 0.0F, 0.0F, -0.4189F));
        var ribLowerRightSide = ribLowerRightRear.addOrReplaceChild("ribLowerRightSide", CubeListBuilder.create().texOffs(9, 45).addBox(-6.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribLowerRightSide.addOrReplaceChild("ribLowerRightFront", CubeListBuilder.create().texOffs(16, 50).addBox(-5.3F, 6.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.3F, -1.0F, 0.0F));
        var ribLowerLeftRear = bodyUpper.addOrReplaceChild("ribLowerLeftRear", CubeListBuilder.create().texOffs(68, 22).addBox(1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 3.0F, 0.0F, 0.0F, 0.0F, 0.4189F));
        var ribLowerLeftSide = ribLowerLeftRear.addOrReplaceChild("ribLowerLeftSide", CubeListBuilder.create().texOffs(22, 29).addBox(5.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribLowerLeftSide.addOrReplaceChild("ribLowerLeftFront", CubeListBuilder.create().texOffs(75, 20).addBox(2.3F, 6.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.3F, -1.0F, 0.0F));
        bodyUpper.addOrReplaceChild("breastboneMain", CubeListBuilder.create().texOffs(29, 44).addBox(-2.0F, 3.5F, -2.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -0.2F));
        var chestplateUpper = bodyUpper.addOrReplaceChild("chestplateUpper", CubeListBuilder.create().texOffs(0, 18).addBox(-6.5F, 0.8F, -3.0F, 13.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        var chestplateCenter = chestplateUpper.addOrReplaceChild("chestplateCenter", CubeListBuilder.create().texOffs(33, 55).addBox(-2.5F, 1.8F, -2.4F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));
        var chestplateLower = chestplateCenter.addOrReplaceChild("chestplateLower", CubeListBuilder.create().texOffs(30, 29).addBox(-4.5F, 2.8F, -2.3F, 9.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));
        chestplateLower.addOrReplaceChild("chestplateRight", CubeListBuilder.create().texOffs(62, 45).addBox(-6.5F, -1.2F, -2.2F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.3142F));
        chestplateLower.addOrReplaceChild("chestplateLeft", CubeListBuilder.create().texOffs(11, 59).addBox(3.9125F, 2.8F, -2.2F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.3142F));
        chestplateUpper.addOrReplaceChild("beltMain", CubeListBuilder.create().texOffs(0, 43).addBox(0.0F, 0.0F, -3.5F, 1.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6283F));
        var bodyLower = partDefinition.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(53, 31).addBox(-4.0F, 16.8F, 1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));
        var pelvisMain = bodyLower.addOrReplaceChild("pelvisMain", CubeListBuilder.create().texOffs(9, 43).addBox(-3.5F, 19.8F, -1.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var pelvisRight = pelvisMain.addOrReplaceChild("pelvisRight", CubeListBuilder.create().texOffs(15, 45).addBox(-3.8F, 0.5F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, 0.2094F, -0.1047F, 0.0F));
        var thighRight = pelvisRight.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(69, 70).addBox(-1.4F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.2F, 0.1F, -0.3142F, 0.3142F, -0.0436F));
        var legRight = thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(12, 69).addBox(-1.4F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.2094F, 0.0F, 0.0F));
        legRight.addOrReplaceChild("kneepadRight", CubeListBuilder.create().texOffs(61, 62).addBox(-1.8F, -2.0F, -1.8F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.8901F, 0.0F));
        var pelvisLeft = pelvisMain.addOrReplaceChild("pelvisLeft", CubeListBuilder.create().texOffs(71, 40).addBox(1.8F, 0.5F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, 0.2094F, 0.1047F, 0.0F));
        var thighLeft = pelvisLeft.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(34, 69).addBox(-0.6F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.2F, 0.1F, -0.3142F, -0.3142F, 0.0436F));
        var legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(61, 70).addBox(-0.6F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.2094F, 0.0F, 0.0F));
        legLeft.addOrReplaceChild("kneepadLeft", CubeListBuilder.create().texOffs(0, 66).addBox(-1.2F, -2.0F, -1.2F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6807F, 0.0F));
        bodyLower.addOrReplaceChild("skirtFront", CubeListBuilder.create().texOffs(20, 69).addBox(-1.0F, -16.0F, -2.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 31.6941F, -2.9108F, -0.2094F, 0.0F, 0.0F));
        bodyLower.addOrReplaceChild("skirtFrontCenterRight", CubeListBuilder.create().texOffs(75, 0).addBox(-2.9F, -2.0F, -1.9F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 18.5869F, -0.1247F, -0.2083F, 0.0217F, 0.1024F));
        bodyLower.addOrReplaceChild("skirtFrontCenterLeft", CubeListBuilder.create().texOffs(6, 74).addBox(0.7F, -2.0F, -1.9F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.5869F, -0.1247F, -0.2083F, -0.0217F, -0.1024F));
        bodyLower.addOrReplaceChild("skirtFrontRight", CubeListBuilder.create().texOffs(0, 74).addBox(-4.5F, -2.5F, -1.8F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.5869F, -0.1247F, -0.205F, 0.0432F, 0.205F));
        bodyLower.addOrReplaceChild("skirtFrontLeft", CubeListBuilder.create().texOffs(73, 62).addBox(2.5F, -2.5F, -1.8F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.5869F, -0.1247F, -0.205F, -0.0432F, -0.205F));
        bodyLower.addOrReplaceChild("skirtRight", CubeListBuilder.create().texOffs(26, 66).addBox(-4.0F, 0.0F, -1.7F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0656F, 0.6237F, 0.0044F, 0.0432F, 0.205F));
        bodyLower.addOrReplaceChild("skirtLeft", CubeListBuilder.create().texOffs(67, 0).addBox(3.0F, 0.0F, -1.7F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0656F, 0.6237F, 0.0044F, -0.0432F, -0.205F));
        bodyLower.addOrReplaceChild("skirtRear", CubeListBuilder.create().texOffs(25, 0).addBox(-1.0F, -3.0F, 1.6F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 18.0F, 0.0F, 0.1047F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
