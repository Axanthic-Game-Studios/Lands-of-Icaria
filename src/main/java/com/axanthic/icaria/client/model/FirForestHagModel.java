package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.ForestHagEntity;

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

public class FirForestHagModel extends HierarchicalModel<ForestHagEntity> {
    public float armBend = 1.00F;
    public float ulnaBend = 1.00F;
    public float legBend = 1.50F;
    public float kneeBend = 1.25F;
    public float beardSpeed = 3.0F;

    public ModelPart root;
    public ModelPart bodyBase;
    public ModelPart bodyMain;
    public ModelPart bodyMainShroomLower;
    public ModelPart bodyLower;
    public ModelPart bodyMainShroomCenter;
    public ModelPart bodyCenter;
    public ModelPart bodyMainShroomUpper;
    public ModelPart bodyUpper;
    public ModelPart shoulderRight;
    public ModelPart armRightUpper;
    public ModelPart armRightLower;
    public ModelPart shoulderLeft;
    public ModelPart armLeftUpper;
    public ModelPart armLeftLower;
    public ModelPart neckMain;
    public ModelPart neckShroom;
    public ModelPart headMain;
    public ModelPart beardMain;
    public ModelPart beardUpper;
    public ModelPart beardCenter;
    public ModelPart beardLower;
    public ModelPart beardTip;
    public ModelPart shroomRightStem;
    public ModelPart shroomRightHead;
    public ModelPart shroomCenterStem;
    public ModelPart shroomCenterHead;
    public ModelPart shroomLeftStem;
    public ModelPart shroomLeftHead;
    public ModelPart thighRight;
    public ModelPart legRight;
    public ModelPart thighLeft;
    public ModelPart legLeft;
    public ModelPart kneeLeft;

    public FirForestHagModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.bodyBase = this.root.getChild("bodyBase");
        this.bodyMain = this.bodyBase.getChild("bodyMain");
        this.bodyMainShroomLower = this.bodyMain.getChild("bodyMainShroomLower");
        this.bodyLower = this.bodyMain.getChild("bodyLower");
        this.bodyMainShroomCenter = this.bodyLower.getChild("bodyMainShroomCenter");
        this.bodyCenter = this.bodyLower.getChild("bodyCenter");
        this.bodyMainShroomUpper = this.bodyCenter.getChild("bodyMainShroomUpper");
        this.bodyUpper = this.bodyCenter.getChild("bodyUpper");
        this.shoulderRight = this.bodyUpper.getChild("shoulderRight");
        this.armRightUpper = this.shoulderRight.getChild("armRightUpper");
        this.armRightLower = this.armRightUpper.getChild("armRightLower");
        this.shoulderLeft = this.bodyUpper.getChild("shoulderLeft");
        this.armLeftUpper = this.shoulderLeft.getChild("armLeftUpper");
        this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
        this.neckMain = this.bodyUpper.getChild("neckMain");
        this.neckShroom = this.neckMain.getChild("neckShroom");
        this.headMain = this.neckMain.getChild("headMain");
        this.beardMain = this.headMain.getChild("beardMain");
        this.beardUpper = this.beardMain.getChild("beardUpper");
        this.beardCenter = this.beardUpper.getChild("beardCenter");
        this.beardLower = this.beardCenter.getChild("beardLower");
        this.beardTip = this.beardLower.getChild("beardTip");
        this.shroomRightStem = this.bodyUpper.getChild("shroomRightStem");
        this.shroomRightHead = this.shroomRightStem.getChild("shroomRightHead");
        this.shroomCenterStem = this.bodyUpper.getChild("shroomCenterStem");
        this.shroomCenterHead = this.shroomCenterStem.getChild("shroomCenterHead");
        this.shroomLeftStem = this.bodyUpper.getChild("shroomLeftStem");
        this.shroomLeftHead = this.shroomLeftStem.getChild("shroomLeftHead");
        this.thighRight = this.bodyBase.getChild("thighRight");
        this.legRight = this.thighRight.getChild("legRight");
        this.thighLeft = this.bodyBase.getChild("thighLeft");
        this.legLeft = this.thighLeft.getChild("legLeft");
        this.kneeLeft = this.legLeft.getChild("kneeLeft");
    }

    @Override
    public void setupAnim(ForestHagEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.bodyBase.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 4.0F;
        this.armRightUpper.xRot = -0.5236F;
        this.armRightUpper.zRot = 0.4427F;
        this.armLeftUpper.xRot = -0.3491F;
        this.armLeftUpper.zRot = -0.1373F;

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

        this.wiggleRotateAngles(this.bodyMain, 0.08726646259971647F, 0.04363323129985824F, 0.08726646259971647F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyMainShroomLower, 0.0F, 0.7853981633974483F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyLower, 0.08726646259971647F, 0.04363323129985824F, 0.08726646259971647F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyMainShroomCenter, 0.0F, -0.39269908169872414F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyCenter, 0.2617993877991494F, 0.04363323129985824F, -0.08726646259971647F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyMainShroomUpper, 0.0F, 0.39269908169872414F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpper, 0.17453292519943295F, 0.04363323129985824F, -0.08726646259971647F, pAgeInTicks);
        this.wiggleRotateAngles(this.shoulderRight, 0.0F, -0.39269908169872414F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.shoulderLeft, 0.0F, 0.39269908169872414F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.neckMain, -0.7853981633974483F, 0.08726646259971647F, -0.17453292519943295F, pAgeInTicks);
        this.wiggleRotateAngles(this.neckShroom, 0.0F, 0.22759093446006054F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.beardUpper, 0.04363323129985824F, -0.17453292519943295F, -0.04363323129985824F, pAgeInTicks * this.beardSpeed);
        this.wiggleRotateAngles(this.beardCenter, 0.04363323129985824F, -0.08726646259971647F, -0.04363323129985824F, pAgeInTicks * this.beardSpeed);
        this.wiggleRotateAngles(this.beardLower, 0.04363323129985824F, -0.17453292519943295F, -0.04363323129985824F, pAgeInTicks * this.beardSpeed);
        this.wiggleRotateAngles(this.beardTip, -0.04363323129985824F, -0.17453292519943295F, 0.04363323129985824F, pAgeInTicks * this.beardSpeed);
        this.wiggleRotateAngles(this.shroomRightStem, -0.6108652381980153F, -0.39269908169872414F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.shroomRightHead, 0.0F, 0.2617993877991494F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.shroomCenterStem, 0.0F, 0.39269908169872414F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.shroomCenterHead, 0.0F, -0.17453292519943295F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.shroomLeftStem, -0.17453292519943295F, 0.17453292519943295F, 0.39269908169872414F, pAgeInTicks);
        this.wiggleRotateAngles(this.shroomLeftHead, 0.0F, 0.7853981633974483F, 0.0F, pAgeInTicks);
    }

    public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
        this.headMain.xRot = pHeadPitch * 0.017453292F + 0.3490658503988659F;
        this.headMain.yRot = pNetHeadYaw * 0.017453292F - 0.4363323129985824F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        this.armRightUpper.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.armBend * pLimbSwingAmount - 0.5235987755982988F;
        this.armRightLower.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.17453292519943295F;
        this.thighRight.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.legBend * pLimbSwingAmount - 0.1023F;
        this.legRight.xRot = Mth.sin(pLimbSwing * 0.6662F + Mth.PI) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.08726646259971647F;
        this.armLeftUpper.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.armBend * pLimbSwingAmount - 0.3490658503988659F;
        this.armLeftLower.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.17453292519943295F;
        this.thighLeft.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.legBend * pLimbSwingAmount - 0.1023F;
        this.kneeLeft.xRot = Mth.sin(pLimbSwing * 0.6662F) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.08726646259971647F;
    }

    public void wiggleRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ, float pAgeInTicks) {
        pModelPart.xRot = Mth.cos(pAgeInTicks * 0.045F) * 0.015F + pX;
        pModelPart.yRot = Mth.sin(pAgeInTicks * 0.035F) * 0.015F + pY;
        pModelPart.zRot = -Mth.cos(pAgeInTicks * 0.04F) * 0.015F + pZ;
    }

    public static LayerDefinition createLayer() {
        var meshDefinition = new MeshDefinition();
        var partDefinition = meshDefinition.getRoot();

        var bodyBase = partDefinition.addOrReplaceChild("bodyBase", CubeListBuilder.create().texOffs(42, 40).addBox(-6.5F, -1.0F, -2.5F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 4.0F, 1.7F, -0.1595F, 0.0436F, 0.0723F));
        var bodyMain = bodyBase.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(0, 66).addBox(-5.5F, -1.0F, -2.0F, 11.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -4.0F, -0.2F, 0.1023F, 0.0436F, 0.0723F));
        bodyMain.addOrReplaceChild("bodyMainShroomLower", CubeListBuilder.create().texOffs(73, 45).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 2.0F, 0.0F, 0.015F, 0.7854F, -0.015F));
        var bodyLower = bodyMain.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(48, 51).addBox(-6.0F, -1.0F, -2.5F, 12.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, -5.0F, -0.2F, 0.1023F, 0.0436F, 0.0723F));
        bodyLower.addOrReplaceChild("bodyMainShroomCenter", CubeListBuilder.create().texOffs(24, 57).addBox(-9.0F, -1.0F, -4.5F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.0F, 2.5F, 0.015F, -0.3927F, -0.015F));
        var bodyCenter = bodyLower.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(32, 28).addBox(-6.5F, -1.0F, -3.0F, 13.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, -2.2F, -1.5F, 0.2768F, 0.0436F, -0.1023F));
        bodyCenter.addOrReplaceChild("bodyMainShroomUpper", CubeListBuilder.create().texOffs(50, 0).addBox(-9.0F, -1.0F, -4.5F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, -1.0F, 0.015F, 0.3927F, -0.015F));
        bodyCenter.addOrReplaceChild("bodyMainVineMain", CubeListBuilder.create().texOffs(0, 14).addBox(-6.5F, -1.0F, -3.0F, 9.0F, 24.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.05F, 0.0F, 0.05F));
        var bodyUpper = bodyCenter.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -4.0F, 16.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, -4.0F, -0.5F, 0.1895F, 0.0436F, -0.1023F));
        var shoulderRight = bodyUpper.addOrReplaceChild("shoulderRight", CubeListBuilder.create().texOffs(32, 14).addBox(-9.0F, -3.0F, -6.0F, 13.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 3.5F, 2.0F, 0.015F, -0.3927F, -0.015F));
        var armRightUpper = shoulderRight.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(54, 72).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.0F, -2.0F, -0.5236F, 0.0873F, 0.4427F));
        armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(40, 80).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 11.0F, 0.0F, -0.1745F, -0.0873F, -0.1745F));
        var shoulderLeft = bodyUpper.addOrReplaceChild("shoulderLeft", CubeListBuilder.create().texOffs(0, 45).addBox(0.0F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 4.0F, 0.5F, 0.015F, 0.3927F, -0.015F));
        var armLeftUpper = shoulderLeft.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(12, 75).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.5F, 0.0F, -0.3491F, -0.5236F, -0.1373F));
        armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(32, 80).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 7.0F, 0.5F, -0.1745F, 0.0F, 0.1745F));
        var neckMain = bodyUpper.addOrReplaceChild("neckMain", CubeListBuilder.create().texOffs(21, 40).addBox(-2.5F, -5.0F, -9.5F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 5.0F, -2.0F, -0.7704F, 0.0873F, -0.1895F));
        neckMain.addOrReplaceChild("neckShroom", CubeListBuilder.create().texOffs(68, 62).addBox(0.0F, -1.0F, -9.5F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.9F, 0.0F, 0.015F, 0.2276F, -0.015F));
        var headMain = neckMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(30, 66).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, -6.5F, 0.3491F, -0.4363F, 0.1745F));
        var beardMain = headMain.addOrReplaceChild("beardMain", CubeListBuilder.create().texOffs(48, 62).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 4.05F, -3.0F, 0.0F, -0.0873F, 0.0F));
        var beardUpper = beardMain.addOrReplaceChild("beardUpper", CubeListBuilder.create().texOffs(72, 28).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 1.0F, 0.0F, 0.0586F, -0.1745F, -0.0586F));
        var beardCenter = beardUpper.addOrReplaceChild("beardCenter", CubeListBuilder.create().texOffs(79, 81).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 2.0F, 0.0F, 0.0586F, -0.0873F, -0.0586F));
        var beardLower = beardCenter.addOrReplaceChild("beardLower", CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 3.0F, 0.0F, 0.0586F, -0.1745F, -0.0586F));
        beardLower.addOrReplaceChild("beardTip", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 2.2F, 0.0F, -0.0286F, -0.1745F, 0.0286F));
        var shroomRightStem = bodyUpper.addOrReplaceChild("shroomRightStem", CubeListBuilder.create().texOffs(82, 51).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 1.0F, 4.0F, -0.5959F, -0.3927F, -0.015F));
        shroomRightStem.addOrReplaceChild("shroomRightHead", CubeListBuilder.create().texOffs(69, 10).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.015F, 0.2618F, -0.015F));
        var shroomCenterStem = bodyUpper.addOrReplaceChild("shroomCenterStem", CubeListBuilder.create().texOffs(24, 78).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, 0.015F, 0.3927F, -0.015F));
        shroomCenterStem.addOrReplaceChild("shroomCenterHead", CubeListBuilder.create().texOffs(0, 56).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.015F, -0.1745F, -0.015F));
        var shroomLeftStem = bodyUpper.addOrReplaceChild("shroomLeftStem", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 1.5F, -1.0F, -0.1595F, 0.1745F, 0.3777F));
        shroomLeftStem.addOrReplaceChild("shroomLeftHead", CubeListBuilder.create().texOffs(69, 18).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.015F, 0.7854F, -0.015F));
        var thighRight = bodyBase.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(0, 75).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0375F, 2.4125F, 0.025F, -0.1023F, 0.0436F, -0.0723F));
        var legRight = thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(0, 53).addBox(-3.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.0F, 0.0F, 0.0873F, -0.0873F, 0.0F));
        var footRight = legRight.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(15, 45).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.5F, -0.5F, 0.1745F, 0.1745F, 0.0F));
        footRight.addOrReplaceChild("soleRight", CubeListBuilder.create().texOffs(73, 37).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.5F, 0.0F, -0.2618F, 0.0F));
        var thighLeft = bodyBase.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(66, 74).addBox(0.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5125F, 2.9F, -0.125F, -0.1023F, -0.1309F, -0.0723F));
        var legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(77, 0).addBox(0.0F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, 0.0F, 0.0873F, 0.0873F, 0.0F));
        var kneeLeft = legLeft.addOrReplaceChild("kneeLeft", CubeListBuilder.create().texOffs(24, 56).addBox(0.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
        var footLeft = kneeLeft.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(41, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.4F, 0.0F, 0.0873F, 0.0873F, 0.0F));
        footLeft.addOrReplaceChild("soleLeft", CubeListBuilder.create().texOffs(25, 14).addBox(-2.0F, 0.0F, -1.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 3.0F, -2.0F, 0.0F, 0.1745F, 0.0175F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
