package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.ArachneDroneEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneModel extends HierarchicalModel<ArachneDroneEntity> {
    public ModelPart root;
    public ModelPart head;
    public ModelPart body;
    public ModelPart legRightFront;
    public ModelPart legRightCenterFront;
    public ModelPart legRightCenterRear;
    public ModelPart legRightRear;
    public ModelPart legLeftFront;
    public ModelPart legLeftCenterFront;
    public ModelPart legLeftCenterRear;
    public ModelPart legLeftRear;

    public ArachneDroneModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.head = this.root.getChild("head");
        this.body = this.root.getChild("body");
        this.legRightFront = this.root.getChild("legRightFront");
        this.legRightCenterFront = this.root.getChild("legRightCenterFront");
        this.legRightCenterRear = this.root.getChild("legRightCenterRear");
        this.legRightRear = this.root.getChild("legRightRear");
        this.legLeftFront = this.root.getChild("legLeftFront");
        this.legLeftCenterFront = this.root.getChild("legLeftCenterFront");
        this.legLeftCenterRear = this.root.getChild("legLeftCenterRear");
        this.legLeftRear = this.root.getChild("legLeftRear");
    }

    @Override
    public void setupAnim(ArachneDroneEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pEntity, pLimbSwing, pLimbSwingAmount);
        this.animate(pEntity.attackAnimationState, IcariaAnimations.ARACHNE_DRONE_ATTACK, pAgeInTicks);
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.head.xRot = pHeadPitch * (Mth.PI / 360.0F) - 0.1745F;
        this.head.yRot = pNetHeadYaw * (Mth.PI / 360.0F);
    }

    public void walkAnim(ArachneDroneEntity pEntity, float pLimbSwing, float pLimbSwingAmount) {
        float animSpeed = 5.0F - pEntity.getSize();

        float f0 = -(Mth.cos((pLimbSwing * animSpeed)) * 0.5F) * pLimbSwingAmount * animSpeed * 0.5F;
        float f1 = -(Mth.cos((pLimbSwing * animSpeed) + (Mth.PI)) * 0.5F) * pLimbSwingAmount * animSpeed * 0.5F;
        float f2 = -(Mth.cos((pLimbSwing * animSpeed) + (Mth.PI * 0.5F)) * 0.5F) * pLimbSwingAmount * animSpeed * 0.5F;
        float f3 = -(Mth.cos((pLimbSwing * animSpeed) + (Mth.PI * 1.5F)) * 0.5F) * pLimbSwingAmount * animSpeed * 0.5F;
        float f4 = Mth.abs(Mth.sin((pLimbSwing * animSpeed)) * 0.5F) * pLimbSwingAmount * animSpeed * 0.5F;
        float f5 = Mth.abs(Mth.sin((pLimbSwing * animSpeed) + (Mth.PI)) * 0.5F) * pLimbSwingAmount * animSpeed * 0.5F;
        float f6 = Mth.abs(Mth.sin((pLimbSwing * animSpeed) + (Mth.PI * 0.5F)) * 0.5F) * pLimbSwingAmount * animSpeed * 0.5F;
        float f7 = Mth.abs(Mth.sin((pLimbSwing * animSpeed) + (Mth.PI * 1.5F)) * 0.5F) * pLimbSwingAmount * animSpeed * 0.5F;

        this.legRightFront.yRot = -0.3927F + f3;
        this.legRightCenterFront.yRot = f2;
        this.legRightCenterRear.yRot = 0.3927F + f1;
        this.legRightRear.yRot = 0.7854F + f0;
        this.legLeftFront.yRot = 0.3927F - f3;
        this.legLeftCenterFront.yRot = - f2;
        this.legLeftCenterRear.yRot = -0.3927F - f1;
        this.legLeftRear.yRot = -0.7854F - f0;
        this.legRightFront.zRot = 0.3927F + f7;
        this.legRightCenterFront.zRot = 0.3927F + f6;
        this.legRightCenterRear.zRot = 0.3927F + f5;
        this.legRightRear.zRot = 0.3927F + f4;
        this.legLeftFront.zRot = -0.3927F - f7;
        this.legLeftCenterFront.zRot = -0.3927F - f6;
        this.legLeftCenterRear.zRot = -0.3927F - f5;
        this.legLeftRear.zRot = -0.3927F - f4;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 0).addBox(-4.5F, -9.0F, -6.0F, 9.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(70, 0).addBox(-4.5F, -4.0F, -3.0F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 7).addBox(-5.0F, -7.25F, -3.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 3).addBox(-5.0F, -8.0F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(7, 0).addBox(-2.5F, -8.75F, -6.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 5).addBox(-3.5F, -9.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 7).addBox(4.0F, -7.5F, -3.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(35, 3).addBox(3.0F, -7.75F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(31, 0).addBox(0.5F, -8.5F, -6.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 5).addBox(2.75F, -9.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, -4.0F, -0.1745F, 0.0F, 0.0F));
        head.addOrReplaceChild("teethRight", CubeListBuilder.create().texOffs(12, 12).addBox(-3.5F, -1.0F, -0.25F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -6.0F, 0.3927F, 0.0F, -0.1309F));
        head.addOrReplaceChild("teethLeft", CubeListBuilder.create().texOffs(22, 12).addBox(0.5F, -1.5F, -0.25F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -6.0F, 0.3927F, 0.0F, 0.1309F));
        PartDefinition biterRight = head.addOrReplaceChild("biterRight", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, -2.5F, 0.7854F, 0.576F, 0.0F));
        biterRight.addOrReplaceChild("biterRightOuter", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -1.0F, -2.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.6981F));
        PartDefinition biterLeft = head.addOrReplaceChild("biterLeft", CubeListBuilder.create().texOffs(32, 12).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -2.5F, 0.7854F, -0.576F, 0.0F));
        biterLeft.addOrReplaceChild("biterLeftOuter", CubeListBuilder.create().texOffs(30, 19).addBox(-4.0F, -0.5F, -1.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -5.5F, 0.0F, 0.0F, -0.7854F));
        PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(34, 74).addBox(-3.0F, -8.1938F, -4.9784F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 2.0F));
        PartDefinition front = body.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 80).addBox(-5.0F, -6.0F, 0.0F, 10.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.175F, 2.475F, 0.1745F, 0.0F, 0.0F));
        front.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(52, 77).addBox(-6.0F, -7.0F, 8.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.275F, 0.0F, 0.1745F, 0.0F, 0.0F));
        PartDefinition legRightFront = partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(0, 50).addBox(-14.0F, -5.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 48).addBox(-14.0F, -2.0F, -0.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 16.0F, -2.0F, -0.0873F, -0.3927F, 0.3927F));
        legRightFront.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(86, 62).addBox(-2.0F, 2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.5F, 1.0F, 0.0F, 0.0F, -0.2618F));
        PartDefinition legRightCenterFront = partDefinition.addOrReplaceChild("legRightCenterFront", CubeListBuilder.create().texOffs(0, 56).addBox(-14.5F, -5.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 55).addBox(-14.5F, -2.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
        legRightCenterFront.addOrReplaceChild("legRightCenterFrontLower", CubeListBuilder.create().texOffs(77, 60).addBox(-2.5F, 0.2F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.5F, 1.0F, 0.0F, 0.0F, -0.2618F));
        PartDefinition legRightCenterRear = partDefinition.addOrReplaceChild("legRightCenterRear", CubeListBuilder.create().texOffs(0, 62).addBox(-14.5F, -5.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 62).addBox(-14.5F, -2.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 16.0F, 2.0F, 0.0873F, 0.3927F, 0.3927F));
        legRightCenterRear.addOrReplaceChild("legRightCenterRearLower", CubeListBuilder.create().texOffs(68, 60).addBox(-2.0F, -0.2F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.5F, 1.0F, 0.0436F, 0.0F, -0.2618F));
        PartDefinition legRightRear = partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(0, 68).addBox(-14.0F, -5.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 67).addBox(-14.0F, -2.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 16.0F, 4.0F, 0.1745F, 0.7854F, 0.3927F));
        legRightRear.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(59, 61).addBox(-2.0F, 0.0F, -1.25F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.5F, 1.0F, 0.0873F, 0.0F, -0.2618F));
        PartDefinition legLeftFront = partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -5.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 24).addBox(11.0F, -2.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 16.0F, -2.0F, -0.0873F, 0.3927F, -0.3927F));
        legLeftFront.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(86, 36).addBox(-1.5F, 1.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, 1.0F, -0.0436F, 0.0F, 0.2618F));
        PartDefinition legLeftCenterFront = partDefinition.addOrReplaceChild("legLeftCenterFront", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, -5.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 31).addBox(11.5F, -2.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 16.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
        legLeftCenterFront.addOrReplaceChild("legLeftCenterFrontLower", CubeListBuilder.create().texOffs(77, 35).addBox(-1.0F, 0.25F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, 1.0F, 0.0F, 0.0F, 0.2618F));
        PartDefinition legLeftCenterRear = partDefinition.addOrReplaceChild("legLeftCenterRear", CubeListBuilder.create().texOffs(0, 37).addBox(-1.5F, -5.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 36).addBox(11.5F, -2.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 16.0F, 2.0F, 0.0873F, -0.3927F, -0.3927F));
        legLeftCenterRear.addOrReplaceChild("legLeftCenterRearLower", CubeListBuilder.create().texOffs(68, 36).addBox(-0.75F, 0.9F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, 1.0F, 0.0436F, 0.0F, 0.2618F));
        PartDefinition legLeftRear = partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -5.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 41).addBox(11.0F, -2.0F, -0.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 16.0F, 4.0F, 0.1745F, -0.7854F, -0.3927F));
        legLeftRear.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(59, 38).addBox(-1.0F, 2.0F, -1.25F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, 1.0F, 0.0873F, 0.0F, 0.2618F));

        return LayerDefinition.create(meshDefinition, 96, 96);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
