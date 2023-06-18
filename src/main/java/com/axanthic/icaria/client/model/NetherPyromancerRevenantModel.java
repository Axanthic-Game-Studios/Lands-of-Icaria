package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.NetherPyromancerRevenantEntity;

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

public class NetherPyromancerRevenantModel extends HierarchicalModel<NetherPyromancerRevenantEntity> implements ArmedModel {
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

    public NetherPyromancerRevenantModel(ModelPart pModelPart) {
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
    public void setupAnim(NetherPyromancerRevenantEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        var randomSource = RandomSource.create(pEntity.getId());

        this.bodyUpper.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 10.0F;
        this.bodyLower.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 10.0F;

        this.setRotateAngles(this.headMain, 0.0F, 0.0F, randomSource.nextIntBetweenInclusive(-50, 50) * 0.005F);
        this.setRotateAngles(this.jawLower, 0.1047F, 0.0F, 0.0F);
        this.setRotateAngles(this.armRightUpper, 0.0F, 0.0F, 0.3927F);
        this.setRotateAngles(this.armRightLower, -0.1047F, 0.0F, -0.3927F);
        this.setRotateAngles(this.armLeftUpper, 0.0F, 0.0F, -0.1047F);
        this.setRotateAngles(this.armLeftLower, -0.1047F, 0.0F, 0.1047F);
        this.setRotateAngles(this.thighRight, -0.3142F, 0.3142F, -0.0436F);
        this.setRotateAngles(this.thighLeft, -0.3142F, -0.3142F, 0.0436F);
        this.setRotateAngles(this.legRight, 0.2094F, 0.0F, 0.0F);
        this.setRotateAngles(this.legLeft, 0.2094F, 0.0F, 0.0F);

        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.idleAnim(pAgeInTicks);
        this.lookAnim(pHeadPitch, pNetHeadYaw);
        this.rideAnim();
        this.walkAnim(pLimbSwing, pLimbSwingAmount);

        this.animate(pEntity.reloadAnimationState, IcariaAnimations.PYROMANCER_REVENANT_RELOAD, pAgeInTicks);
        this.animate(pEntity.thrownAnimationState, IcariaAnimations.PYROMANCER_REVENANT_THROWN, pAgeInTicks);
    }

    public void setRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ) {
        pModelPart.xRot = pX;
        pModelPart.yRot = pY;
        pModelPart.zRot = pZ;
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

        var bodyUpper = partDefinition.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -15.5F, -0.975F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.5F, 1.375F));
        var headMain = bodyUpper.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(0, 12).addBox(-3.5F, -8.0F, -5.4125F, 7.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.5F, 0.0375F));
        headMain.addOrReplaceChild("headWear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.5F, -4.5F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0561F, -8.4279F, -1.2536F, -0.0785F, 0.0F, 0.0785F));
        var jawUpper = headMain.addOrReplaceChild("jawUpper", CubeListBuilder.create().texOffs(30, 14).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 1.0875F));
        jawUpper.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(36, 33).addBox(-2.5F, 0.0068F, -6.0171F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9875F, 0.0125F, 0.1047F, 0.0F, 0.0F));
        var shoulderMain = bodyUpper.addOrReplaceChild("shoulderMain", CubeListBuilder.create().texOffs(22, 12).addBox(-6.5F, -0.5F, -0.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.5F, -0.875F));
        var armRightUpper = shoulderMain.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(36, 50).addBox(-1.0609F, -0.3061F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
        armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(8, 44).addBox(-1.0655F, -0.0389F, -0.8434F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0109F, 6.3438F, -0.1625F, -0.1047F, 0.0F, -0.3927F));
        var armLeftUpper = shoulderMain.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(25, 0).addBox(-0.6973F, -0.0523F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1047F));
        armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(52, 0).addBox(-0.9832F, -0.0672F, -0.9762F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2902F, 6.9477F, -0.0125F, -0.1047F, 0.0F, 0.1047F));
        var ribUpperRightRear = bodyUpper.addOrReplaceChild("ribUpperRightRear", CubeListBuilder.create().texOffs(53, 25).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -11.5F, 0.125F));
        var ribUpperRightSide = ribUpperRightRear.addOrReplaceChild("ribUpperRightSide", CubeListBuilder.create().texOffs(22, 14).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribUpperRightSide.addOrReplaceChild("ribUpperRightFront", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, -1.5F));
        var ribUpperLeftRear = bodyUpper.addOrReplaceChild("ribUpperLeftRear", CubeListBuilder.create().texOffs(52, 51).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -11.5F, 0.125F));
        var ribUpperLeftSide = ribUpperLeftRear.addOrReplaceChild("ribUpperLeftSide", CubeListBuilder.create().texOffs(30, 33).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribUpperLeftSide.addOrReplaceChild("ribUpperLeftFront", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.5F, -1.5F));
        var ribUpperCenterRightRear = bodyUpper.addOrReplaceChild("ribUpperCenterRightRear", CubeListBuilder.create().texOffs(55, 42).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9177F, -9.7056F, 0.125F, 0.0F, 0.0F, -0.1047F));
        var ribUpperCenterRightSide = ribUpperCenterRightRear.addOrReplaceChild("ribUpperCenterRightSide", CubeListBuilder.create().texOffs(50, 46).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribUpperCenterRightSide.addOrReplaceChild("ribUpperCenterRightFront", CubeListBuilder.create().texOffs(0, 28).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
        var ribUpperCenterLeftRear = bodyUpper.addOrReplaceChild("ribUpperCenterLeftRear", CubeListBuilder.create().texOffs(22, 55).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9177F, -9.7056F, 0.125F, 0.0F, 0.0F, 0.1047F));
        var ribUpperCenterLeftSide = ribUpperCenterLeftRear.addOrReplaceChild("ribUpperCenterLeftSide", CubeListBuilder.create().texOffs(49, 40).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribUpperCenterLeftSide.addOrReplaceChild("ribUpperCenterLeftFront", CubeListBuilder.create().texOffs(28, 14).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        var ribCenterRightRear = bodyUpper.addOrReplaceChild("ribCenterRightRear", CubeListBuilder.create().texOffs(53, 28).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6067F, -8.4528F, 0.125F, 0.0F, 0.0F, -0.2094F));
        var ribCenterRightSide = ribCenterRightRear.addOrReplaceChild("ribCenterRightSide", CubeListBuilder.create().texOffs(50, 9).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribCenterRightSide.addOrReplaceChild("ribCenterRightFront", CubeListBuilder.create().texOffs(28, 16).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
        var ribCenterLeftRear = bodyUpper.addOrReplaceChild("ribCenterLeftRear", CubeListBuilder.create().texOffs(52, 54).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6067F, -8.4528F, 0.125F, 0.0F, 0.0F, 0.2094F));
        var ribCenterLeftSide = ribCenterLeftRear.addOrReplaceChild("ribCenterLeftSide", CubeListBuilder.create().texOffs(33, 0).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -0.5F));
        ribCenterLeftSide.addOrReplaceChild("ribCenterLeftFront", CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -2.5F));
        var ribLowerCenterLeftRear = bodyUpper.addOrReplaceChild("ribLowerCenterLeftRear", CubeListBuilder.create().texOffs(56, 9).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1716F, -7.2443F, 0.125F, 0.0F, 0.0F, 0.3142F));
        var ribLowerCenterLeftSide = ribLowerCenterLeftRear.addOrReplaceChild("ribLowerCenterLeftSide", CubeListBuilder.create().texOffs(0, 30).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -0.5F));
        ribLowerCenterLeftSide.addOrReplaceChild("ribLowerCenterLeftFront", CubeListBuilder.create().texOffs(33, 3).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -2.5F));
        var ribLowerLeftRear = bodyUpper.addOrReplaceChild("ribLowerLeftRear", CubeListBuilder.create().texOffs(55, 40).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6171F, -6.0824F, 0.125F, 0.0F, 0.0F, 0.4189F));
        var ribLowerLeftSide = ribLowerLeftRear.addOrReplaceChild("ribLowerLeftSide", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.0F));
        ribLowerLeftSide.addOrReplaceChild("ribLowerLeftFront", CubeListBuilder.create().texOffs(22, 33).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -2.0F));
        bodyUpper.addOrReplaceChild("breastboneMain", CubeListBuilder.create().texOffs(14, 26).addBox(-2.0F, -3.0F, -0.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -3.075F));
        var bandUpper = bodyUpper.addOrReplaceChild("bandUpper", CubeListBuilder.create().texOffs(22, 33).addBox(-0.5F, -8.0F, -3.0F, 1.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.451F, -6.2278F, -1.375F, 0.0F, 0.0F, 0.589F));
        bandUpper.addOrReplaceChild("bandLower", CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, -4.0F, -4.0F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4695F, 8.9925F, 0.0F, 0.0F, 0.0F, -0.589F));
        var robeUpper = bodyUpper.addOrReplaceChild("robeUpper", CubeListBuilder.create().texOffs(34, 0).addBox(-2.0F, -3.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.9F, -10.0F, -1.175F));
        var robeCenter = robeUpper.addOrReplaceChild("robeCenter", CubeListBuilder.create().texOffs(36, 40).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7992F, 4.5318F, 0.03F, 0.0F, 0.0F, -0.3927F));
        robeCenter.addOrReplaceChild("robeLower", CubeListBuilder.create().texOffs(25, 21).addBox(-4.5F, -3.5F, -2.5F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3038F, 4.9901F, -0.066F, -0.0785F, 0.0F, 0.3927F));
        var bodyLower = partDefinition.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(46, 14).addBox(-4.0F, -0.5F, -0.4F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.3F, 1.4F));
        var pelvisMain = bodyLower.addOrReplaceChild("pelvisMain", CubeListBuilder.create().texOffs(6, 42).addBox(-3.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -2.4F));
        var pelvisRight = pelvisMain.addOrReplaceChild("pelvisRight", CubeListBuilder.create().texOffs(52, 30).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8575F, -0.4258F, 1.4005F, 0.2094F, -0.1047F, 0.0F));
        var thighRight = pelvisRight.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(52, 16).addBox(-1.1664F, 0.6062F, -0.5989F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0125F, -0.4875F, -0.5125F, -0.3142F, 0.3142F, -0.0436F));
        thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(44, 50).addBox(-0.975F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1789F, 7.6062F, 0.4012F, 0.2094F, 0.0F, 0.0F));
        var pelvisLeft = pelvisMain.addOrReplaceChild("pelvisLeft", CubeListBuilder.create().texOffs(52, 34).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.858F, -0.401F, 1.4049F, 0.2094F, 0.1047F, 0.0F));
        var thighLeft = pelvisLeft.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(14, 51).addBox(-0.8025F, 0.4022F, -0.579F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -0.5125F, -0.3142F, -0.3142F, 0.0436F));
        thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0125F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1975F, 7.4022F, 0.421F, 0.2094F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
