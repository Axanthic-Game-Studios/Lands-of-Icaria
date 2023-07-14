package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.CivilianRevenantEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.HumanoidArm;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CivilianRevenantModel extends HierarchicalModel<CivilianRevenantEntity> implements ArmedModel {
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
    public ModelPart bodyLower;
    public ModelPart pelvisMain;
    public ModelPart pelvisRight;
    public ModelPart pelvisLeft;
    public ModelPart thighRight;
    public ModelPart thighLeft;
    public ModelPart legRight;
    public ModelPart legLeft;

    public CivilianRevenantModel(ModelPart pModelPart) {
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
    public void setupAnim(CivilianRevenantEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        var randomSource = RandomSource.create(pEntity.getId());

        this.bodyUpper.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 10.0F;
        this.bodyLower.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 24.0F;

        this.setRotateAngles(this.headMain, 0.0F, 0.0F, randomSource.nextIntBetweenInclusive(-50, 50) * 0.005F);
        this.setRotateAngles(this.jawLower, 0.1047F, 0.0F, 0.0F);
        this.setRotateAngles(this.armRightUpper, 0.0F, 0.0F, 0.2047F);
        this.setRotateAngles(this.armRightLower, -0.1047F, 0.0F, -0.1047F);
        this.setRotateAngles(this.armLeftUpper, 0.0F, 0.0F, -0.2094F);
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

    public static LayerDefinition createLayer() {
        var meshDefinition = new MeshDefinition();
        var partDefinition = meshDefinition.getRoot();

        var bodyUpper = partDefinition.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(18, 46).addBox(-3.5F, -16.2F, 0.3F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 10.2F, 0.1F));
        var headMain = bodyUpper.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -8.0F, -4.0F, 7.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -14.2F, -0.1F));
        var jawUpper = headMain.addOrReplaceChild("jawUpper", CubeListBuilder.create().texOffs(41, 18).addBox(-2.5F, -2.0F, -3.5F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        jawUpper.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(42, 30).addBox(-2.5F, -0.8F, -3.3F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1047F, 0.0F, 0.0F));
        var shoulderMain = bodyUpper.addOrReplaceChild("shoulderMain", CubeListBuilder.create().texOffs(22, 0).addBox(-5.0F, 5.5F, 0.2F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -18.2F, -0.3F));
        var armRightUpper = shoulderMain.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(50, 51).addBox(-1.8F, 0.0F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 6.0F, 0.2F, 0.0F, 0.0F, 0.2047F));
        armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(52, 9).addBox(-1.8F, -0.2F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.1047F, 0.0F, -0.1047F));
        var armLeftUpper = shoulderMain.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(26, 46).addBox(-0.2F, 0.0F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 6.0F, 0.2F, 0.0F, 0.0F, -0.2047F));
        armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(34, 46).addBox(-0.2F, -0.2F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.1047F, 0.0F, 0.1047F));
        var ribUpperRightRear = bodyUpper.addOrReplaceChild("ribUpperRightRear", CubeListBuilder.create().texOffs(57, 18).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -16.2F, -0.1F));
        var ribUpperRightSide = ribUpperRightRear.addOrReplaceChild("ribUpperRightSide", CubeListBuilder.create().texOffs(12, 38).addBox(-6.0F, 5.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribUpperRightSide.addOrReplaceChild("ribUpperRightFront", CubeListBuilder.create().texOffs(0, 6).addBox(-5.0F, 8.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribUpperLeftRear = bodyUpper.addOrReplaceChild("ribUpperLeftRear", CubeListBuilder.create().texOffs(56, 5).addBox(1.0F, 3.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -16.2F, -0.1F));
        var ribUpperLeftSide = ribUpperLeftRear.addOrReplaceChild("ribUpperLeftSide", CubeListBuilder.create().texOffs(36, 2).addBox(5.0F, 5.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribUpperLeftSide.addOrReplaceChild("ribUpperLeftFront", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, 8.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribUpperCenterRightRear = bodyUpper.addOrReplaceChild("ribUpperCenterRightRear", CubeListBuilder.create().texOffs(56, 42).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -14.2F, -0.1F, 0.0F, 0.0F, -0.1047F));
        var ribUpperCenterRightSide = ribUpperCenterRightRear.addOrReplaceChild("ribUpperCenterRightSide", CubeListBuilder.create().texOffs(36, 55).addBox(-6.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribUpperCenterRightSide.addOrReplaceChild("ribUpperCenterRightFront", CubeListBuilder.create().texOffs(32, 55).addBox(-5.0F, 7.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribUpperCenterLeftRear = bodyUpper.addOrReplaceChild("ribUpperCenterLeftRear", CubeListBuilder.create().texOffs(50, 0).addBox(1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, -14.2F, -0.1F, 0.0F, 0.0F, 0.1047F));
        var ribUpperCenterLeftSide = ribUpperCenterLeftRear.addOrReplaceChild("ribUpperCenterLeftSide", CubeListBuilder.create().texOffs(26, 55).addBox(5.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribUpperCenterLeftSide.addOrReplaceChild("ribUpperCenterLeftFront", CubeListBuilder.create().texOffs(46, 9).addBox(2.0F, 7.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribCenterRightRear = bodyUpper.addOrReplaceChild("ribCenterRightRear", CubeListBuilder.create().texOffs(24, 18).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9F, -13.2F, -0.1F, 0.0F, 0.0F, -0.2094F));
        var ribCenterRightSide = ribCenterRightRear.addOrReplaceChild("ribCenterRightSide", CubeListBuilder.create().texOffs(54, 37).addBox(-6.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribCenterRightSide.addOrReplaceChild("ribCenterRightFront", CubeListBuilder.create().texOffs(0, 4).addBox(-5.0F, 7.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribCenterLeftRear = bodyUpper.addOrReplaceChild("ribCenterLeftRear", CubeListBuilder.create().texOffs(56, 51).addBox(1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -13.2F, -0.1F, 0.0F, 0.0F, 0.2094F));
        var ribCenterLeftSide = ribCenterLeftRear.addOrReplaceChild("ribCenterLeftSide", CubeListBuilder.create().texOffs(56, 0).addBox(5.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribCenterLeftSide.addOrReplaceChild("ribCenterLeftFront", CubeListBuilder.create().texOffs(32, 57).addBox(2.0F, 7.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribLowerCenterLeftRear = bodyUpper.addOrReplaceChild("ribLowerCenterLeftRear", CubeListBuilder.create().texOffs(22, 6).addBox(1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -12.2F, -0.1F, 0.0F, 0.0F, 0.3142F));
        var ribLowerCenterLeftSide = ribLowerCenterLeftRear.addOrReplaceChild("ribLowerCenterLeftSide", CubeListBuilder.create().texOffs(48, 25).addBox(5.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribLowerCenterLeftSide.addOrReplaceChild("ribLowerCenterLeftFront", CubeListBuilder.create().texOffs(0, 2).addBox(2.0F, 7.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        var ribLowerLeftRear = bodyUpper.addOrReplaceChild("ribLowerLeftRear", CubeListBuilder.create().texOffs(57, 21).addBox(1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, -11.2F, -0.1F, 0.0F, 0.0F, 0.4189F));
        var ribLowerLeftSide = ribLowerLeftRear.addOrReplaceChild("ribLowerLeftSide", CubeListBuilder.create().texOffs(42, 56).addBox(5.0F, 5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        ribLowerLeftSide.addOrReplaceChild("ribLowerLeftFront", CubeListBuilder.create().texOffs(58, 8).addBox(2.0F, 7.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        bodyUpper.addOrReplaceChild("breastboneMain", CubeListBuilder.create().texOffs(46, 2).addBox(-2.0F, 3.5F, -2.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -16.2F, -0.3F));
        var robeUpper = bodyUpper.addOrReplaceChild("robeUpper", CubeListBuilder.create().texOffs(28, 18).addBox(1.0F, 0.5F, -4.0F, 3.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -14.2F, -0.1F));
        robeUpper.addOrReplaceChild("robeLeft", CubeListBuilder.create().texOffs(0, 38).addBox(4.0F, 0.1F, -3.4F, 3.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1047F));
        var robeRightUpper = robeUpper.addOrReplaceChild("robeRightUpper", CubeListBuilder.create().texOffs(22, 36).addBox(-4.0F, 4.5F, -3.3F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));
        robeRightUpper.addOrReplaceChild("robeRightLower", CubeListBuilder.create().texOffs(24, 8).addBox(-3.9F, -1.1F, -3.4F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
        var robeCenter = robeUpper.addOrReplaceChild("robeCenter", CubeListBuilder.create().texOffs(0, 14).addBox(-4.5F, 9.5F, -3.5F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        robeCenter.addOrReplaceChild("robeLower", CubeListBuilder.create().texOffs(0, 25).addBox(-4.5F, 14.5F, -3.0F, 9.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        var bodyLower = partDefinition.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(22, 2).addBox(-4.0F, -15.2F, 1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        var pelvisMain = bodyLower.addOrReplaceChild("pelvisMain", CubeListBuilder.create().texOffs(22, 4).addBox(-3.5F, 19.8F, -1.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -34.0F, 0.0F));
        var pelvisRight = pelvisMain.addOrReplaceChild("pelvisRight", CubeListBuilder.create().texOffs(18, 38).addBox(-3.8F, 0.5F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, 0.2094F, -0.1047F, 0.0F));
        var thighRight = pelvisRight.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(42, 46).addBox(-1.4F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.2F, 0.1F, -0.3142F, 0.3142F, -0.0436F));
        thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(50, 42).addBox(-1.4F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.2094F, 0.0F, 0.0F));
        var pelvisLeft = pelvisMain.addOrReplaceChild("pelvisLeft", CubeListBuilder.create().texOffs(54, 25).addBox(1.8F, 0.5F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, 0.2094F, 0.1047F, 0.0F));
        var thighLeft = pelvisLeft.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(0, 55).addBox(-0.6F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.2F, 0.1F, -0.3142F, -0.3142F, 0.0436F));
        thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(8, 55).addBox(-0.6F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.2094F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
