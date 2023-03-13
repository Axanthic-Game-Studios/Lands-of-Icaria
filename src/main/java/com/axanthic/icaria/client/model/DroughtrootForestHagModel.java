package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DroughtrootForestHagModel extends HierarchicalModel<ForestHagEntity> {
    public float armBend = 1.00F;
    public float ulnaBend = 1.00F;
    public float legBend = 1.50F;
    public float kneeBend = 1.25F;

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "droughtroot_forest_hag"), "main");

    public ModelPart root;
    public ModelPart bodyBase;
    public ModelPart bodyLower;
    public ModelPart bodyCenter;
    public ModelPart bodyCenterLeavesMain;
    public ModelPart bodyUpper;
    public ModelPart neckMain;
    public ModelPart headMain;
    public ModelPart shoulderRight;
    public ModelPart armRightUpper;
    public ModelPart armRightLower;
    public ModelPart shoulderLeft;
    public ModelPart armLeftUpper;
    public ModelPart armLeftLower;
    public ModelPart bodyUpperBranchLower;
    public ModelPart bodyUpperBranchCenter;
    public ModelPart bodyUpperLeavesLower;
    public ModelPart bodyUpperTwigMain;
    public ModelPart bodyUpperBranchUpper;
    public ModelPart bodyUpperLeavesCenter;
    public ModelPart thighRight;
    public ModelPart legRight;
    public ModelPart thighLeft;
    public ModelPart legLeft;

    public DroughtrootForestHagModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.bodyBase = this.root.getChild("bodyBase");
        this.bodyLower = this.bodyBase.getChild("bodyLower");
        this.bodyCenter = this.bodyLower.getChild("bodyCenter");
        this.bodyCenterLeavesMain = this.bodyCenter.getChild("bodyCenterLeavesMain");
        this.bodyUpper = this.bodyCenter.getChild("bodyUpper");
        this.neckMain = this.bodyUpper.getChild("neckMain");
        this.headMain = this.neckMain.getChild("headMain");
        this.shoulderRight = this.bodyUpper.getChild("shoulderRight");
        this.armRightUpper = this.shoulderRight.getChild("armRightUpper");
        this.armRightLower = this.armRightUpper.getChild("armRightLower");
        this.shoulderLeft = this.bodyUpper.getChild("shoulderLeft");
        this.armLeftUpper = this.shoulderLeft.getChild("armLeftUpper");
        this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
        this.bodyUpperBranchLower = this.bodyUpper.getChild("bodyUpperBranchLower");
        this.bodyUpperBranchCenter = this.bodyUpperBranchLower.getChild("bodyUpperBranchCenter");
        this.bodyUpperLeavesLower = this.bodyUpperBranchCenter.getChild("bodyUpperLeavesLower");
        this.bodyUpperTwigMain = this.bodyUpperBranchCenter.getChild("bodyUpperTwigMain");
        this.bodyUpperBranchUpper = this.bodyUpperBranchCenter.getChild("bodyUpperBranchUpper");
        this.bodyUpperLeavesCenter = this.bodyUpperBranchUpper.getChild("bodyUpperLeavesCenter");
        this.thighRight = this.bodyBase.getChild("thighRight");
        this.legRight = this.thighRight.getChild("legRight");
        this.thighLeft = this.bodyBase.getChild("thighLeft");
        this.legLeft = this.thighLeft.getChild("legLeft");
    }

    @Override
    public void setupAnim(ForestHagEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.bodyBase.y = -Mth.cos(pLimbSwing * 1.25F + 2.75F) * pLimbSwingAmount + 4.0F;
        this.armRightUpper.xRot = -0.3491F;
        this.armRightUpper.zRot = 0.4427F;
        this.armLeftUpper.xRot = -0.1745F;
        this.armLeftUpper.zRot = -0.1745F;

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
        this.armRightUpper.zRot += Mth.cos(pAgeInTicks * 0.09F) * 0.05F;
        this.armLeftUpper.zRot -= Mth.cos(pAgeInTicks * 0.09F) * 0.05F;
        this.armRightUpper.xRot += Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
        this.armLeftUpper.xRot -= Mth.sin(pAgeInTicks * 0.067F) * 0.05F;

        this.wiggleRotateAngles(this.bodyLower, 0.08726646259971647F, 0.08726646259971647F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyCenter, 0.08726646259971647F, 0.08726646259971647F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyCenterLeavesMain, -0.091106186954104F, 0.08726646259971647F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpper, 0.17453292519943295F, 0.08203047484373349F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.neckMain, -0.6981317007977318F, -0.06981317007977318F, 0.17453292519943295F, pAgeInTicks);
        this.wiggleRotateAngles(this.shoulderRight, 0.17453292519943295F, -0.13962634015954636F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.shoulderLeft, 0.17453292519943295F, 0.08203047484373349F, 0.04363323129985824F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpperBranchLower, 0.0F, -0.06981317007977318F, 0.17453292519943295F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpperBranchCenter, 0.2617993877991494F, 0.0F, -0.08726646259971647F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpperLeavesLower, 0.0F, 0.7853981633974483F, 0.0F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpperTwigMain, -0.9105382707654417F, -0.5462880558742251F, -0.18203784098300857F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpperBranchUpper, 0.2617993877991494F, 0.0F, -0.08726646259971647F, pAgeInTicks);
        this.wiggleRotateAngles(this.bodyUpperLeavesCenter, 0.0F, 0.7853981633974483F, 0.0F, pAgeInTicks);
    }

    public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
        this.headMain.xRot = pHeadPitch * 0.017453292F + 0.4363323129985824F;
        this.headMain.yRot = pNetHeadYaw * 0.017453292F - 0.08726646259971647F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        this.armRightUpper.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.armBend * pLimbSwingAmount - 0.3490658503988659F;
        this.armRightLower.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.17453292519943295F;
        this.thighRight.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.legBend * pLimbSwingAmount;
        this.legRight.xRot = Mth.sin(pLimbSwing * 0.6662F + Mth.PI) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.08726646259971647F;
        this.armLeftUpper.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.armBend * pLimbSwingAmount - 0.17453292519943295F;
        this.armLeftLower.xRot = Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * this.ulnaBend * pLimbSwingAmount - this.ulnaBend * pLimbSwingAmount - 0.3490658503988659F;
        this.thighLeft.xRot = Mth.cos(pLimbSwing * 0.6662F) * this.legBend * pLimbSwingAmount;
        this.legLeft.xRot = Mth.sin(pLimbSwing * 0.6662F) * this.kneeBend * pLimbSwingAmount + this.kneeBend * pLimbSwingAmount + 0.08726646259971647F;
    }

    public void wiggleRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ, float pAgeInTicks) {
        pModelPart.xRot = Mth.cos(pAgeInTicks * 0.045F) * 0.015F + pX;
        pModelPart.yRot = Mth.sin(pAgeInTicks * 0.035F) * 0.015F + pY;
        pModelPart.zRot = -Mth.cos(pAgeInTicks * 0.04F) * 0.015F + pZ;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition bodyBase = partDefinition.addOrReplaceChild("bodyBase", CubeListBuilder.create().texOffs(34, 46).addBox(-5.5F, 0.0F, -2.5F, 11.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 3.5F, 0.5F, -0.1745F, 0.0F, -0.0873F));
        PartDefinition bodyLower = bodyBase.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(56, 32).addBox(-4.7F, 0.0F, -2.5F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.7F, 0.2F, 0.1023F, 0.0873F, 0.0286F));
        PartDefinition bodyCenter = bodyLower.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(0, 52).addBox(-5.5F, 0.0F, -3.5F, 10.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.5F, 0.2F, 0.1023F, 0.0873F, 0.0286F));
        bodyCenter.addOrReplaceChild("bodyCenterLeavesMain", CubeListBuilder.create().texOffs(0, 61).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.5F, -1.0F, -0.0761F, 0.0873F, 0.0286F));
        PartDefinition bodyUpper = bodyCenter.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(0, 42).addBox(-5.5F, 0.0F, -3.0F, 11.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -3.3F, -1.7F, 0.1895F, 0.082F, 0.0286F));
        PartDefinition neckMain = bodyUpper.addOrReplaceChild("neckMain", CubeListBuilder.create().texOffs(54, 19).addBox(-1.5F, 0.0F, -7.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7F, 0.3F, -0.6831F, -0.0698F, 0.1595F));
        neckMain.addOrReplaceChild("neckLeaves", CubeListBuilder.create().texOffs(58, 5).addBox(-0.5F, -1.0F, -7.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.3F));
        neckMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(24, 55).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, 0.4363F, -0.0873F, 0.0F));
        PartDefinition shoulderRight = bodyUpper.addOrReplaceChild("shoulderRight", CubeListBuilder.create().texOffs(34, 0).addBox(-5.5F, 0.0F, -3.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6F, -4.0F, -2.1F, 0.1895F, -0.1396F, 0.0286F));
        PartDefinition armRightUpper = shoulderRight.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(45, 67).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 4.0F, 1.5F, -0.3491F, -0.1396F, 0.4427F));
        armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 8.0F, 0.0F, -0.1745F, 0.1745F, -0.1745F));
        PartDefinition shoulderLeft = bodyUpper.addOrReplaceChild("shoulderLeft", CubeListBuilder.create().texOffs(0, 29).addBox(-5.5F, 0.0F, -3.0F, 9.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -1.0F, -2.0F, 0.1895F, 0.082F, 0.0286F));
        shoulderLeft.addOrReplaceChild("shoulderVine", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, 3.0F, -3.0F, 8.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.01F, 0.0F, 0.01F));
        PartDefinition armLeftUpper = shoulderLeft.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(28, 69).addBox(0.0F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.45F, 2.225F, 2.0F, -0.1745F, -0.1745F, -0.1745F));
        armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(28, 69).addBox(-0.4875F, -0.0875F, -0.825F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 8.0F, 0.3F, -0.3491F, 0.0F, 0.0F));
        PartDefinition bodyUpperBranchLower = bodyUpper.addOrReplaceChild("bodyUpperBranchLower", CubeListBuilder.create().texOffs(12, 65).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7F, 0.9F, 0.015F, -0.0698F, 0.1595F));
        PartDefinition bodyUpperBranchCenter = bodyUpperBranchLower.addOrReplaceChild("bodyUpperBranchCenter", CubeListBuilder.create().texOffs(57, 67).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4F, 0.2F, 0.2768F, 0.0F, -0.1023F));
        bodyUpperBranchCenter.addOrReplaceChild("bodyUpperTwigMain", CubeListBuilder.create().texOffs(0, 42).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, -0.8955F, -0.5463F, -0.197F));
        bodyUpperBranchCenter.addOrReplaceChild("bodyUpperLeavesLower", CubeListBuilder.create().texOffs(29, 33).addBox(-6.0F, -6.0F, -3.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.015F, 0.7854F, -0.015F));
        PartDefinition bodyUpperBranchUpper = bodyUpperBranchCenter.addOrReplaceChild("bodyUpperBranchUpper", CubeListBuilder.create().texOffs(54, 14).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4F, 0.2F, 0.2768F, 0.0F, -0.1023F));
        PartDefinition bodyUpperLeavesCenter = bodyUpperBranchUpper.addOrReplaceChild("bodyUpperLeavesCenter", CubeListBuilder.create().texOffs(48, 55).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4F, -1.8F, 0.015F, 0.7854F, -0.015F));
        bodyUpperLeavesCenter.addOrReplaceChild("bodyUpperLeavesUpper", CubeListBuilder.create().texOffs(24, 15).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));
        PartDefinition thighRight = bodyBase.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(25, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, 2.7875F, -0.5F, 0.0F, 0.1745F, 0.0873F));
        PartDefinition legRight = thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(28, 29).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.4F, 0.0F, 0.0873F, -0.0873F, 0.0F));
        PartDefinition footRight = legRight.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(68, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, 0.0873F, 0.0F, 0.0F));
        footRight.addOrReplaceChild("soleRight", CubeListBuilder.create().texOffs(61, 42).addBox(-3.0F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, 0.0F, 0.0F, -1.7453F, 0.0F));
        PartDefinition thighLeft = bodyBase.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(66, 50).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, 3.4F, -0.5F, 0.0F, -0.0873F, -0.0873F));
        PartDefinition legLeft = thighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 4.5F, 0.0F, 0.0F, -0.0873F, 0.0436F));
        PartDefinition footLeft = legLeft.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(37, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.2F, 0.0F, 0.0873F, 0.0873F, 0.0873F));
        footLeft.addOrReplaceChild("soleLeft", CubeListBuilder.create().texOffs(42, 55).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.3F, 0.0F, 0.0873F, 0.0873F, 0.0436F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
