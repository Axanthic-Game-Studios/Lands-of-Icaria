package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.ForestHagEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LaurelForestHagModel extends HierarchicalModel<ForestHagEntity> {
    public float armBend = 1.00F;
    public float ulnaBend = 1.00F;
    public float legBend = 1.50F;
    public float kneeBend = 1.25F;

    public ModelPart root;
    public ModelPart bodyMain;
    public ModelPart bodyMainLeavesMain;
    public ModelPart bodyLower;
    public ModelPart bodyCenter;
    public ModelPart bodyUpper;
    public ModelPart bodyUpperLeavesUpper;
    public ModelPart bodyUpperLeavesLower;
    public ModelPart shoulderRight;
    public ModelPart shoulderVine;
    public ModelPart armRightUpper;
    public ModelPart armRightLower;
    public ModelPart shoulderLeft;
    public ModelPart armLeftUpper;
    public ModelPart armLeftLower;
    public ModelPart neckMain;
    public ModelPart headMain;
    public ModelPart headMainLeavesLower;
    public ModelPart headMainLeavesUpper;
    public ModelPart thighRight;
    public ModelPart legRight;
    public ModelPart thighLeft;
    public ModelPart legLeft;

    public LaurelForestHagModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.bodyMain = this.root.getChild("bodyMain");
        this.bodyMainLeavesMain = this.bodyMain.getChild("bodyMainLeavesMain");
        this.bodyLower = this.bodyMain.getChild("bodyLower");
        this.bodyCenter = this.bodyLower.getChild("bodyCenter");
        this.bodyUpper = this.bodyCenter.getChild("bodyUpper");
        this.bodyUpperLeavesUpper = this.bodyUpper.getChild("bodyUpperLeavesUpper");
        this.bodyUpperLeavesLower = this.bodyUpperLeavesUpper.getChild("bodyUpperLeavesLower");
        this.shoulderRight = this.bodyUpper.getChild("shoulderRight");
        this.shoulderVine = this.shoulderRight.getChild("shoulderVine");
        this.armRightUpper = this.shoulderRight.getChild("armRightUpper");
        this.armRightLower = this.armRightUpper.getChild("armRightLower");
        this.shoulderLeft = this.bodyUpper.getChild("shoulderLeft");
        this.armLeftUpper = this.shoulderLeft.getChild("armLeftUpper");
        this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
        this.neckMain = this.bodyUpper.getChild("neckMain");
        this.headMain = this.neckMain.getChild("headMain");
        this.headMainLeavesLower = this.headMain.getChild("headMainLeavesLower");
        this.headMainLeavesUpper = this.headMainLeavesLower.getChild("headMainLeavesUpper");
        this.thighRight = this.bodyMain.getChild("thighRight");
        this.legRight = this.thighRight.getChild("legRight");
        this.thighLeft = this.bodyMain.getChild("thighLeft");
        this.legLeft = this.thighLeft.getChild("legLeft");
    }

    @Override
    public void setupAnim(ForestHagEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.bodyMain.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 4.0F;
        this.armRightUpper.xRot = -0.2731F;
        this.armRightUpper.zRot = 0.1867F;
        this.armLeftUpper.xRot = -0.1499F;
        this.armLeftUpper.zRot = -0.7481F;

        this.attackAnim();
        this.idleAnim(pAgeInTicks);
        this.lookAnim(pHeadPitch, pNetHeadYaw);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
    }

    public void attackAnim() {
        float f = Mth.sin(this.attackTime * Mth.PI);
        if (this.attackTime > 0.0F)  {
            this.armRightUpper.zRot -= f;
            this.armLeftUpper.zRot += f;
        }
    }

    public void idleAnim(float pAgeInTicks) {
        this.armRightUpper.xRot += Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
        this.armRightUpper.zRot += Mth.cos(pAgeInTicks * 0.09F) * 0.05F;
        this.armLeftUpper.xRot -= Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
        this.armLeftUpper.zRot -= Mth.cos(pAgeInTicks * 0.09F) * 0.05F;

        this.wiggleRotateAngles(this.bodyMainLeavesMain, 0.091106186954104F, 0.0F, 0.7740535232594852F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyLower, 0.0F, 0.06981317007977318F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyCenter, 0.08726646259971647F, 0.06981317007977318F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpper, 0.08726646259971647F, 0.06981317007977318F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpperLeavesUpper, 0.3490658503988659F, -0.03490658503988659F, 0.17453292519943295F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpperLeavesLower, 0.3490658503988659F, -0.03490658503988659F, 0.5462880558742251F, pAgeInTicks);
        this.wiggleRotateAngles(this.shoulderRight, 0.03490658503988659F, -0.045553093477052F, -0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.shoulderLeft, 0.03490658503988659F, 0.136659280431156F, 0.36425021489121656F, pAgeInTicks);
        this.wiggleRotateAngles(this.neckMain, 0.8651597102135892F, -0.17453292519943295F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.headMainLeavesUpper, 0.136659280431156F, 0.0F, -0.136659280431156F, pAgeInTicks);
        this.wiggleRotateAngles(this.headMainLeavesLower, 0.0F, 0.0F, 0.06981317007977318F, pAgeInTicks);
    }

    public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
        this.headMain.xRot = pHeadPitch * 0.017453292F - 0.9162978572970231F;
        this.headMain.yRot = pNetHeadYaw * 0.017453292F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        this.armRightUpper.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.armBend * pLimbSwingAmount - 0.2731F;
        this.armRightLower.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.1367F;
        this.thighRight.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.legBend * pLimbSwingAmount - 0.0873F;
        this.legRight.xRot = Mth.sin(pLimbSwing * 0.6662F + Mth.PI) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.0873F;
        this.armLeftUpper.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.armBend * pLimbSwingAmount - 0.1499F;
        this.armLeftLower.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.1820F;
        this.thighLeft.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.legBend * pLimbSwingAmount - 0.0873F;
        this.legLeft.xRot = Mth.sin(pLimbSwing * 0.6662F) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.0873F;
    }

    public void wiggleRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ, float pAgeInTicks) {
        pModelPart.xRot = Mth.cos(pAgeInTicks * 0.045F) * 0.015F + pX;
        pModelPart.yRot = Mth.sin(pAgeInTicks * 0.035F) * 0.015F + pY;
        pModelPart.zRot = -Mth.cos(pAgeInTicks * 0.04F) * 0.015F + pZ;
    }

    public static LayerDefinition createLayer() {
        var meshDefinition = new MeshDefinition();
        var partDefinition = meshDefinition.getRoot();

        var bodyMain = partDefinition.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(38, 0).addBox(-5.5F, 0.0F, -2.5F, 11.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, -0.0873F, 0.0F, 0.0F));
        bodyMain.addOrReplaceChild("bodyMainLeavesMain", CubeListBuilder.create().texOffs(24, 51).addBox(-5.0F, -4.0F, -3.75F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.8F, 0.7F, 0.1061F, 0.0F, 0.7591F));
        var bodyLower = bodyMain.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(52, 32).addBox(-5.0F, -4.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.015F, 0.0698F, 0.0286F));
        var bodyCenter = bodyLower.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(23, 42).addBox(-5.5F, -4.0F, -2.5F, 11.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.1023F, 0.0698F, 0.0286F));
        var bodyUpper = bodyCenter.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(24, 22).addBox(-6.0F, -4.0F, -3.0F, 12.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.1023F, 0.0698F, 0.0286F));
        var bodyUpperLeavesUpper = bodyUpper.addOrReplaceChild("bodyUpperLeavesUpper", CubeListBuilder.create().texOffs(0, 12).addBox(1.5F, -4.0F, -4.0F, 8.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0375F, -5.8125F, -0.8125F, 0.2768F, -0.0785F, 0.1159F));
        bodyUpperLeavesUpper.addOrReplaceChild("bodyUpperLeavesLower", CubeListBuilder.create().texOffs(0, 28).addBox(0.0F, -4.0F, -4.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2F, -1.0F, -1.5F, 0.3641F, -0.0349F, 0.5313F));
        var shoulderRight = bodyUpper.addOrReplaceChild("shoulderRight", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -4.0F, -3.5F, 12.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 0.2F, 0.0499F, -0.0456F, -0.0586F));
        var shoulderRightShroomBase = shoulderRight.addOrReplaceChild("shoulderRightShroomBase", CubeListBuilder.create(), PartPose.offsetAndRotation(-25.0F, 10.525F, -6.55F, 0.0F, 1.5708F, 0.0F));
        var shoulderRightShroomMain = shoulderRightShroomBase.addOrReplaceChild("shoulderRightShroomMain", CubeListBuilder.create().texOffs(59, 9).addBox(-9.5F, -14.0F, 12.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        shoulderRightShroomMain.addOrReplaceChild("shoulderRightShroomFront", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        shoulderRightShroomMain.addOrReplaceChild("shoulderRightShroomRear", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        var armRightUpper = shoulderRight.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(46, 59).addBox(-2.0219F, -0.0499F, -1.4592F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8625F, -2.6F, 0.0875F, -0.2731F, -0.1367F, 0.1867F));
        var armRightShroomBase = armRightUpper.addOrReplaceChild("armRightShroomBase", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0219F, 18.4876F, -6.7592F, 0.0F, 1.5708F, 0.0F));
        var armRightShroomMain = armRightShroomBase.addOrReplaceChild("armRightShroomMain", CubeListBuilder.create().texOffs(65, 0).addBox(-8.8F, -13.0F, 14.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        armRightShroomMain.addOrReplaceChild("armRightShroomFront", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        armRightShroomMain.addOrReplaceChild("armRightShroomRear", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(14, 75).addBox(-0.975F, -1.0F, -1.5625F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5219F, 13.2501F, 0.5408F, -0.1367F, -0.0456F, -0.182F));
        shoulderRight.addOrReplaceChild("shoulderVine", CubeListBuilder.create().texOffs(0, 51).addBox(-7.0F, 0.0F, 0.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.5F, 0.0873F, 0.0F, 0.0F));
        var shoulderLeft = bodyUpper.addOrReplaceChild("shoulderLeft", CubeListBuilder.create().texOffs(30, 12).addBox(-2.0F, -4.0F, -2.5F, 12.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4311F, -3.2741F, 0.237F, 0.0812F, 0.0767F, 0.2951F));
        var armLeftUpper = shoulderLeft.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(33, 72).addBox(-1.6843F, -1.5413F, -1.3765F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8561F, -1.8509F, -0.162F, -0.1499F, 0.0246F, -0.7481F));
        armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(22, 75).addBox(0.25F, 0.0F, -1.2375F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1843F, 6.4587F, 0.6235F, -0.182F, 0.0911F, 0.2731F));
        var neckMain = bodyUpper.addOrReplaceChild("neckMain", CubeListBuilder.create().texOffs(20, 65).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0739F, -6.4566F, -0.6978F, 0.9319F, -0.2191F, -0.0826F));
        var headMain = neckMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(49, 45).addBox(-3.0F, -3.5F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.9163F, 0.0F, 0.0F));
        var headMainLeavesLower = headMain.addOrReplaceChild("headMainLeavesLower", CubeListBuilder.create().texOffs(28, 32).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2F, -3.0F, 0.015F, 0.0F, 0.0548F));
        headMainLeavesLower.addOrReplaceChild("headMainLeavesUpper", CubeListBuilder.create().texOffs(58, 15).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1F, 0.0F, 0.1517F, 0.0F, -0.1517F));
        var thighRight = bodyMain.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(67, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 3.7F, 0.0F, -0.0873F, 0.0911F, 0.0F));
        var legRight = thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(73, 48).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9F, 0.0F, 0.0873F, 0.0F, 0.0F));
        var footRight = legRight.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(0, 67).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.6F, 0.0F, 0.0873F, -0.0911F, 0.0F));
        footRight.addOrReplaceChild("soleRight", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, 0.0F, 0.0F, 0.1367F, 0.0F));
        var thighLeft = bodyMain.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(58, 66).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.7F, 0.0F, -0.0873F, -0.0911F, -0.0873F));
        var legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(71, 73).addBox(-1.5F, 0.5F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
        var footLeft = legLeft.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(60, 23).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.6F, 0.0F, 0.0873F, -0.0911F, 0.0436F));
        footLeft.addOrReplaceChild("soleLeft", CubeListBuilder.create().texOffs(58, 59).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, 0.0F, 0.0F, 0.1367F, 0.0436F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
