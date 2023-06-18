package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.SoldierRevenantEntity;

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

public class SoldierRevenantModel extends HierarchicalModel<SoldierRevenantEntity> implements ArmedModel {
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

    public SoldierRevenantModel(ModelPart pModelPart) {
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
    public void setupAnim(SoldierRevenantEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        var randomSource = RandomSource.create(pEntity.getId());

        this.bodyUpper.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 9.5F;
        this.bodyLower.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 9.5F;

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

        var bodyUpper = partDefinition.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(16, 50).addBox(-1.0F, -15.025F, -0.9875F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.775F, 1.3875F));
        var headMain = bodyUpper.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(28, 21).addBox(-3.4625F, -6.0F, -5.5125F, 7.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0375F, -15.025F, 0.125F));
        var jawUpper = headMain.addOrReplaceChild("jawUpper", CubeListBuilder.create().texOffs(32, 35).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0375F, 0.0F, 0.9875F));
        jawUpper.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(46, 0).addBox(-2.5F, -0.0043F, -6.0033F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.1047F, 0.0F, 0.0F));
        var helmetMain = headMain.addOrReplaceChild("helmetMain", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.5F, -4.5F, 8.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0375F, -2.0F, -1.5125F));
        var cristaBase = helmetMain.addOrReplaceChild("cristaBase", CubeListBuilder.create().texOffs(19, 35).addBox(-1.0F, -3.0F, -4.5F, 2.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.6F));
        cristaBase.addOrReplaceChild("cristaMain", CubeListBuilder.create().texOffs(34, 0).addBox(-0.5F, -3.5F, -5.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));
        var shoulderMain = bodyUpper.addOrReplaceChild("shoulderMain", CubeListBuilder.create().texOffs(30, 18).addBox(-6.5F, -0.5F, -0.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.025F, -0.8875F));
        var armRightUpper = shoulderMain.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(24, 59).addBox(-1.3038F, -0.0618F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1239F));
        var armRightLower = armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(60, 59).addBox(-2.0028F, -0.236F, -0.001F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6962F, 6.9007F, -1.0F, -0.1047F, 0.0F, -0.1047F));
        armRightLower.addOrReplaceChild("bracerRight", CubeListBuilder.create().texOffs(38, 53).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0099F, 2.464F, 1.099F, 0.0F, 0.7854F, 0.0F));
        var armLeftUpper = shoulderMain.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(58, 29).addBox(-0.6962F, -0.0618F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1239F));
        var armLeftLower = armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(0, 0).addBox(0.0028F, -0.236F, -0.001F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6962F, 6.9007F, -1.0F, -0.1047F, 0.0F, 0.1047F));
        armLeftLower.addOrReplaceChild("bracerLeft", CubeListBuilder.create().texOffs(50, 53).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0027F, 2.464F, 0.9045F, 0.0F, -0.7854F, 0.0F));
        var ribUpperRightRear = bodyUpper.addOrReplaceChild("ribUpperRightRear", CubeListBuilder.create().texOffs(48, 35).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -11.025F, 0.1125F));
        var ribUpperRightSide = ribUpperRightRear.addOrReplaceChild("ribUpperRightSide", CubeListBuilder.create().texOffs(48, 61).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribUpperRightSide.addOrReplaceChild("ribUpperRightFront", CubeListBuilder.create().texOffs(33, 50).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, -1.5F));
        var ribUpperLeftRear = bodyUpper.addOrReplaceChild("ribUpperLeftRear", CubeListBuilder.create().texOffs(46, 7).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -11.025F, 0.1125F));
        var ribUpperLeftSide = ribUpperLeftRear.addOrReplaceChild("ribUpperLeftSide", CubeListBuilder.create().texOffs(62, 0).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribUpperLeftSide.addOrReplaceChild("ribUpperLeftFront", CubeListBuilder.create().texOffs(48, 38).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.5F, -1.5F));
        var ribUpperCenterRightRear = bodyUpper.addOrReplaceChild("ribUpperCenterRightRear", CubeListBuilder.create().texOffs(64, 29).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9177F, -9.2306F, 0.1125F, 0.0F, 0.0F, -0.1047F));
        var ribUpperCenterRightSide = ribUpperCenterRightRear.addOrReplaceChild("ribUpperCenterRightSide", CubeListBuilder.create().texOffs(64, 64).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribUpperCenterRightSide.addOrReplaceChild("ribUpperCenterRightFront", CubeListBuilder.create().texOffs(11, 44).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
        var ribUpperCenterLeftRear = bodyUpper.addOrReplaceChild("ribUpperCenterLeftRear", CubeListBuilder.create().texOffs(66, 31).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9177F, -9.2306F, 0.1125F, 0.0F, 0.0F, 0.1047F));
        var ribUpperCenterLeftSide = ribUpperCenterLeftRear.addOrReplaceChild("ribUpperCenterLeftSide", CubeListBuilder.create().texOffs(63, 19).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribUpperCenterLeftSide.addOrReplaceChild("ribUpperCenterLeftFront", CubeListBuilder.create().texOffs(66, 59).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        var ribCenterRightRear = bodyUpper.addOrReplaceChild("ribCenterRightRear", CubeListBuilder.create().texOffs(32, 42).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6068F, -7.9777F, 0.1125F, 0.0F, 0.0F, -0.2094F));
        var ribCenterRightSide = ribCenterRightRear.addOrReplaceChild("ribCenterRightSide", CubeListBuilder.create().texOffs(64, 24).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribCenterRightSide.addOrReplaceChild("ribCenterRightFront", CubeListBuilder.create().texOffs(67, 15).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
        var ribCenterLeftRear = bodyUpper.addOrReplaceChild("ribCenterLeftRear", CubeListBuilder.create().texOffs(34, 8).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6068F, -7.9777F, 0.1125F, 0.0F, 0.0F, 0.2094F));
        var ribCenterLeftSide = ribCenterLeftRear.addOrReplaceChild("ribCenterLeftSide", CubeListBuilder.create().texOffs(54, 64).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribCenterLeftSide.addOrReplaceChild("ribCenterLeftFront", CubeListBuilder.create().texOffs(66, 46).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        var ribLowerCenterRightRear = bodyUpper.addOrReplaceChild("ribLowerCenterRightRear", CubeListBuilder.create().texOffs(32, 42).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1716F, -6.7693F, 0.1125F, 0.0F, 0.0F, -0.3142F));
        var ribLowerCenterRightSide = ribLowerCenterRightRear.addOrReplaceChild("ribLowerCenterRightSide", CubeListBuilder.create().texOffs(64, 24).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribLowerCenterRightSide.addOrReplaceChild("ribLowerCenterRightFront", CubeListBuilder.create().texOffs(67, 17).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
        var ribLowerCenterLeftRear = bodyUpper.addOrReplaceChild("ribLowerCenterLeftRear", CubeListBuilder.create().texOffs(66, 33).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1716F, -6.7693F, 0.1125F, 0.0F, 0.0F, 0.3142F));
        var ribLowerCenterLeftSide = ribLowerCenterLeftRear.addOrReplaceChild("ribLowerCenterLeftSide", CubeListBuilder.create().texOffs(65, 10).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribLowerCenterLeftSide.addOrReplaceChild("ribLowerCenterLeftFront", CubeListBuilder.create().texOffs(66, 35).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        var ribLowerRightRear = bodyUpper.addOrReplaceChild("ribLowerRightRear", CubeListBuilder.create().texOffs(32, 42).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6171F, -5.6074F, 0.1125F, 0.0F, 0.0F, -0.4189F));
        var ribLowerRightSide = ribLowerRightRear.addOrReplaceChild("ribLowerRightSide", CubeListBuilder.create().texOffs(64, 24).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribLowerRightSide.addOrReplaceChild("ribLowerRightFront", CubeListBuilder.create().texOffs(11, 44).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
        var ribLowerLeftRear = bodyUpper.addOrReplaceChild("ribLowerLeftRear", CubeListBuilder.create().texOffs(62, 57).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6171F, -5.6074F, 0.1125F, 0.0F, 0.0F, 0.4189F));
        var ribLowerLeftSide = ribLowerLeftRear.addOrReplaceChild("ribLowerLeftSide", CubeListBuilder.create().texOffs(64, 52).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribLowerLeftSide.addOrReplaceChild("ribLowerLeftFront", CubeListBuilder.create().texOffs(33, 52).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        bodyUpper.addOrReplaceChild("breastboneMain", CubeListBuilder.create().texOffs(56, 7).addBox(-2.0F, -3.0F, -0.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.525F, -3.0875F));
        bodyUpper.addOrReplaceChild("strapRight", CubeListBuilder.create().texOffs(41, 42).addBox(-1.0F, -2.0F, -3.5F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -11.025F, -1.0875F));
        bodyUpper.addOrReplaceChild("strapLeft", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -2.0F, -3.5F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -11.025F, -1.0875F));
        var chestplateUpper = bodyUpper.addOrReplaceChild("chestplateUpper", CubeListBuilder.create().texOffs(0, 18).addBox(-6.0F, -2.5F, -3.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.525F, -1.1875F));
        chestplateUpper.addOrReplaceChild("chestplateLower", CubeListBuilder.create().texOffs(0, 29).addBox(-4.0F, -2.5F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -0.2F));
        chestplateUpper.addOrReplaceChild("chestplateRight", CubeListBuilder.create().texOffs(24, 50).addBox(-1.0F, -2.0F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8076F, 3.9301F, -0.1F, 0.0F, 0.0F, -0.4189F));
        chestplateUpper.addOrReplaceChild("chestplateLeft", CubeListBuilder.create().texOffs(50, 20).addBox(-1.0F, -2.0F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8076F, 3.9301F, -0.1F, 0.0F, 0.0F, 0.4189F));
        var bodyLower = partDefinition.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(11, 42).addBox(-3.4875F, -0.5375F, -0.5125F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0125F, 9.775F, 1.4F));
        var pelvisMain = bodyLower.addOrReplaceChild("pelvisMain", CubeListBuilder.create().texOffs(11, 40).addBox(-3.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0125F, 0.6F, -2.4875F));
        var pelvisRight = pelvisMain.addOrReplaceChild("pelvisRight", CubeListBuilder.create().texOffs(66, 6).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6881F, -0.3168F, 1.1669F, 0.2094F, -0.1047F, 0.0F));
        var thighRight = pelvisRight.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0119F, 0.7531F, -1.0511F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0125F, -0.4875F, -0.0125F, -0.3142F, 0.3142F, -0.0436F));
        thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(32, 59).addBox(-0.9875F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0119F, 7.7531F, -0.0511F, 0.2094F, 0.0F, 0.0F));
        var pelvisLeft = pelvisMain.addOrReplaceChild("pelvisLeft", CubeListBuilder.create().texOffs(6, 51).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6756F, -0.3168F, 1.1669F, 0.2094F, 0.1047F, 0.0F));
        var thighLeft = pelvisLeft.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(8, 60).addBox(-0.9724F, 0.7501F, -1.0436F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4875F, -0.025F, -0.3142F, -0.3142F, 0.0436F));
        thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(59, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0151F, 7.7501F, -0.0436F, 0.2094F, 0.0F, 0.0F));
        bodyLower.addOrReplaceChild("skirtFront", CubeListBuilder.create().texOffs(0, 62).addBox(-1.5F, -3.5F, -0.5F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0125F, 2.6282F, -4.0993F, -0.2094F, 0.0F, 0.0F));
        bodyLower.addOrReplaceChild("skirtFrontRight", CubeListBuilder.create().texOffs(62, 38).addBox(-1.5F, -3.5F, -0.5F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.62F, 2.0757F, -3.664F, -0.1658F, 0.0F, 0.3142F));
        bodyLower.addOrReplaceChild("skirtFrontLeft", CubeListBuilder.create().texOffs(40, 61).addBox(-1.5F, -3.5F, -0.5F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.645F, 2.0757F, -3.664F, -0.1658F, 0.0F, -0.3142F));
        bodyLower.addOrReplaceChild("skirtRight", CubeListBuilder.create().texOffs(52, 38).addBox(-0.5F, -3.5F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9579F, 1.8651F, -1.1625F, 0.0F, 0.0F, 0.3142F));
        bodyLower.addOrReplaceChild("skirtLeft", CubeListBuilder.create().texOffs(0, 51).addBox(-0.5F, -3.5F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.971F, 1.8689F, -1.2F, 0.0F, 0.0F, -0.3142F));
        bodyLower.addOrReplaceChild("skirtRear", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0125F, 2.953F, 1.4667F, 0.1745F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
