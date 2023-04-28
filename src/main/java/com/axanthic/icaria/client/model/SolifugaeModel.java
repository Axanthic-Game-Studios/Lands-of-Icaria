package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.entity.SolifugaeEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SolifugaeModel extends HierarchicalModel<SolifugaeEntity> {
    public ModelPart root;
    public ModelPart bodyMain;
    public ModelPart headMain;
    public ModelPart legRightFrontUpper;
    public ModelPart legRightFrontLower;
    public ModelPart legLeftFrontUpper;
    public ModelPart legLeftFrontLower;
    public ModelPart legRightCenterFrontUpper;
    public ModelPart legRightCenterFrontLower;
    public ModelPart legLeftCenterFrontUpper;
    public ModelPart legLeftCenterFrontLower;
    public ModelPart legRightCenterRearUpper;
    public ModelPart legRightCenterRearLower;
    public ModelPart legLeftCenterRearUpper;
    public ModelPart legLeftCenterRearLower;
    public ModelPart legRightRearUpper;
    public ModelPart legRightRearLower;
    public ModelPart legLeftRearUpper;
    public ModelPart legLeftRearLower;

    public SolifugaeModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.bodyMain = this.root.getChild("bodyMain");
        this.headMain = this.bodyMain.getChild("headMain");
        this.legRightFrontUpper = this.bodyMain.getChild("legRightFrontUpper");
        this.legRightFrontLower = this.legRightFrontUpper.getChild("legRightFrontLower");
        this.legLeftFrontUpper = this.bodyMain.getChild("legLeftFrontUpper");
        this.legLeftFrontLower = this.legLeftFrontUpper.getChild("legLeftFrontLower");
        this.legRightCenterFrontUpper = this.bodyMain.getChild("legRightCenterFrontUpper");
        this.legRightCenterFrontLower = this.legRightCenterFrontUpper.getChild("legRightCenterFrontLower");
        this.legLeftCenterFrontUpper = this.bodyMain.getChild("legLeftCenterFrontUpper");
        this.legLeftCenterFrontLower = this.legLeftCenterFrontUpper.getChild("legLeftCenterFrontLower");
        this.legRightCenterRearUpper = this.bodyMain.getChild("legRightCenterRearUpper");
        this.legRightCenterRearLower = this.legRightCenterRearUpper.getChild("legRightCenterRearLower");
        this.legLeftCenterRearUpper = this.bodyMain.getChild("legLeftCenterRearUpper");
        this.legLeftCenterRearLower = this.legLeftCenterRearUpper.getChild("legLeftCenterRearLower");
        this.legRightRearUpper = this.bodyMain.getChild("legRightRearUpper");
        this.legRightRearLower = this.legRightRearUpper.getChild("legRightRearLower");
        this.legLeftRearUpper = this.bodyMain.getChild("legLeftRearUpper");
        this.legLeftRearLower = this.legLeftRearUpper.getChild("legLeftRearLower");
    }

    @Override
    public void setupAnim(SolifugaeEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.setupRotateAngles();
        this.setupAnim(pLimbSwing, pLimbSwingAmount, pNetHeadYaw, pHeadPitch);
    }

    public void setupRotateAngles() {
        IcariaClientHelper.setRotateAngles(this.headMain, -0.085F, 0.0F, 0.0F);
        IcariaClientHelper.setRotateAngles(this.legRightFrontUpper, -0.3581F, -0.7655F, 0.4075F);
        IcariaClientHelper.setRotateAngles(this.legLeftFrontUpper, -0.3814F, 0.7561F, -0.4412F);
        IcariaClientHelper.setRotateAngles(this.legRightCenterFrontUpper, -0.1872F, -0.2516F, 0.2755F);
        IcariaClientHelper.setRotateAngles(this.legLeftCenterFrontUpper, -0.1818F, 0.2609F, -0.2733F);
        IcariaClientHelper.setRotateAngles(this.legRightCenterRearUpper, -0.0017F, 0.2622F, 0.2255F);
        IcariaClientHelper.setRotateAngles(this.legLeftCenterRearUpper, -0.0017F, -0.2709F, -0.2255F);
        IcariaClientHelper.setRotateAngles(this.legRightRearUpper, 0.0927F, 0.7865F, 0.2243F);
        IcariaClientHelper.setRotateAngles(this.legLeftRearUpper, 0.0971F, -0.7866F, -0.2243F);
    }

    public void setupAnim(float pLimbSwing, float pLimbSwingAmount, float pNetHeadYaw, float pHeadPitch) {
        this.lookAnim(pHeadPitch, pNetHeadYaw);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
    }

    public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
        this.headMain.xRot += pHeadPitch * (Mth.PI / 180.0F);
        this.headMain.yRot += pNetHeadYaw * (Mth.PI / 180.0F);
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        float frontY = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + (Mth.PI * 1.5F)) * 0.4F) * pLimbSwingAmount;
        float frontZ = Math.abs(Mth.sin(pLimbSwing * 0.6662F + (Mth.PI * 1.5F)) * 0.4F) * pLimbSwingAmount;
        float centerFrontY = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + (Mth.PI * 0.5F)) * 0.4F) * pLimbSwingAmount;
        float centerFrontZ = Math.abs(Mth.sin(pLimbSwing * 0.6662F + (Mth.PI * 0.5F)) * 0.4F) * pLimbSwingAmount;
        float centerRearY = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + (Mth.PI * 1.0F)) * 0.4F) * pLimbSwingAmount;
        float centerRearZ = Math.abs(Mth.sin(pLimbSwing * 0.6662F + (Mth.PI * 1.0F)) * 0.4F) * pLimbSwingAmount;
        float rearY = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + (Mth.PI * 0.0F)) * 0.4F) * pLimbSwingAmount;
        float rearZ = Math.abs(Mth.sin(pLimbSwing * 0.6662F + (Mth.PI * 0.0F)) * 0.4F) * pLimbSwingAmount;

        this.legRightFrontUpper.yRot += frontY;
        this.legRightFrontUpper.zRot += frontZ;
        this.legLeftFrontUpper.yRot -= frontY;
        this.legLeftFrontUpper.zRot -= frontZ;
        this.legRightCenterFrontUpper.yRot += centerFrontY;
        this.legRightCenterFrontUpper.zRot += centerFrontZ;
        this.legLeftCenterFrontUpper.yRot -= centerFrontY;
        this.legLeftCenterFrontUpper.zRot -= centerFrontZ;
        this.legRightCenterRearUpper.yRot += centerRearY;
        this.legRightCenterRearUpper.zRot += centerRearZ;
        this.legLeftCenterRearUpper.yRot -= centerRearY;
        this.legLeftCenterRearUpper.zRot -= centerRearZ;
        this.legRightRearUpper.yRot += rearY;
        this.legRightRearUpper.zRot += rearZ;
        this.legLeftRearUpper.yRot -= rearY;
        this.legLeftRearUpper.zRot -= rearZ;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition bodyMain = partDefinition.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(90, 27).addBox(-4.5F, -2.5F, -4.0F, 9.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.5F, 1.0F));
        PartDefinition headMain = bodyMain.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(54, 27).addBox(-5.0F, -5.0F, -9.0F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -3.0F, -0.085F, 0.0F, 0.0F));
        headMain.addOrReplaceChild("eyeRight", CubeListBuilder.create().texOffs(56, 70).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.7F, -4.7F, -8.7F));
        headMain.addOrReplaceChild("eyeLeft", CubeListBuilder.create().texOffs(56, 72).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7F, -4.7F, -8.7F));
        headMain.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(62, 0).addBox(-24.0F, -1.0F, -1.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -0.4F, -3.5F, 0.0F, -1.1345F, -0.2618F));
        headMain.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -1.0F, -1.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -0.4F, -3.5F, 0.0F, 1.1345F, 0.2618F));
        PartDefinition jawMain = headMain.addOrReplaceChild("jawMain", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -2.5F, -4.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.5F, -9.0F, 0.096F, 0.0F, 0.0F));
        PartDefinition mouthMain = jawMain.addOrReplaceChild("mouthMain", CubeListBuilder.create().texOffs(28, 58).addBox(-1.5F, -2.0F, -3.0F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -4.5F));
        mouthMain.addOrReplaceChild("toothRightUpper", CubeListBuilder.create().texOffs(14, 70).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -1.0F, -3.0F, 0.1745F, 0.0F, 0.0F));
        mouthMain.addOrReplaceChild("toothRightLower", CubeListBuilder.create().texOffs(0, 70).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 2.0F, -3.0F, -0.3F, 0.0F, 0.0F));
        mouthMain.addOrReplaceChild("toothLeftUpper", CubeListBuilder.create().texOffs(42, 70).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, -1.0F, -3.0F, 0.1745F, 0.0F, 0.0F));
        mouthMain.addOrReplaceChild("toothLeftLower", CubeListBuilder.create().texOffs(28, 70).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, 2.0F, -3.0F, -0.3F, 0.0F, 0.0F));
        bodyMain.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -5.0F, -0.3F, 12.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.4F, 3.5F));
        PartDefinition legRightFrontUpper = bodyMain.addOrReplaceChild("legRightFrontUpper", CubeListBuilder.create().texOffs(60, 66).addBox(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.05F, -4.0F, -0.2233F, -0.7864F, 0.3079F));
        legRightFrontUpper.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(84, 54).addBox(-11.5F, -1.0F, -1.0125F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
        PartDefinition legLeftFrontUpper = bodyMain.addOrReplaceChild("legLeftFrontUpper", CubeListBuilder.create().texOffs(0, 66).addBox(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.075F, -4.0F, -0.2445F, 0.7811F, -0.3441F));
        legLeftFrontUpper.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(28, 54).addBox(-11.5F, -1.0F, -1.0125F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.0944F));
        PartDefinition legRightCenterFrontUpper = bodyMain.addOrReplaceChild("legRightCenterFrontUpper", CubeListBuilder.create().texOffs(66, 58).addBox(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.3F, -2.3F, -0.098F, -0.3784F, 0.2487F));
        legRightCenterFrontUpper.addOrReplaceChild("legRightCenterFrontLower", CubeListBuilder.create().texOffs(54, 43).addBox(-11.5F, -1.0F, -1.0125F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
        PartDefinition legLeftCenterFrontUpper = bodyMain.addOrReplaceChild("legLeftCenterFrontUpper", CubeListBuilder.create().texOffs(20, 66).addBox(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.3F, -2.3F, -0.098F, 0.3784F, -0.2487F));
        legLeftCenterFrontUpper.addOrReplaceChild("legLeftCenterFrontLower", CubeListBuilder.create().texOffs(0, 54).addBox(-11.5F, -1.0F, -1.025F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));
        PartDefinition legRightCenterRearUpper = bodyMain.addOrReplaceChild("legRightCenterRearUpper", CubeListBuilder.create().texOffs(46, 62).addBox(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.3F, -1.3F, 0.098F, 0.3784F, 0.2487F));
        legRightCenterRearUpper.addOrReplaceChild("legRightCenterRearLower", CubeListBuilder.create().texOffs(26, 43).addBox(-11.5F, -1.0F, -0.9875F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
        PartDefinition legLeftCenterRearUpper = bodyMain.addOrReplaceChild("legLeftCenterRearUpper", CubeListBuilder.create().texOffs(46, 58).addBox(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.3F, -1.3F, 0.098F, -0.3784F, -0.2487F));
        legLeftCenterRearUpper.addOrReplaceChild("legLeftCenterRearLower", CubeListBuilder.create().texOffs(26, 47).addBox(-11.5F, -1.0F, -0.9875F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));
        PartDefinition legRightRearUpper = bodyMain.addOrReplaceChild("legRightRearUpper", CubeListBuilder.create().texOffs(40, 66).addBox(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.025F, 0.5F, 0.2227F, 0.781F, 0.304F));
        legRightRearUpper.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(56, 54).addBox(-11.5F, -1.0F, -0.9875F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -0.9948F));
        PartDefinition legLeftRearUpper = bodyMain.addOrReplaceChild("legLeftRearUpper", CubeListBuilder.create().texOffs(80, 66).addBox(-1.0F, -1.05F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.1F, 0.3F, 0.2227F, -0.781F, -0.304F));
        legLeftRearUpper.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(0, 58).addBox(-11.5F, -1.0F, -0.9875F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.1F, 0.0F, 0.0F, 0.0F, -2.1468F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
