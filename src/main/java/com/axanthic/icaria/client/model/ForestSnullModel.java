package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.SnullEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForestSnullModel extends HierarchicalModel<SnullEntity> {
    public ModelPart root;
    public ModelPart bodyFront;
    public ModelPart bodyFrontLower;
    public ModelPart bodyFrontCenter;
    public ModelPart bodyFrontUpper;
    public ModelPart head;
    public ModelPart headFeelerRight;
    public ModelPart headFeelerLeft;
    public ModelPart bodySkull;
    public ModelPart skullFeelerRight;
    public ModelPart skullFeelerLeft;

    public ForestSnullModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.bodyFront = this.root.getChild("bodyFront");
        this.bodyFrontLower = this.bodyFront.getChild("bodyFrontLower");
        this.bodyFrontCenter = this.bodyFrontLower.getChild("bodyFrontCenter");
        this.bodyFrontUpper = this.bodyFrontCenter.getChild("bodyFrontUpper");
        this.head = this.bodyFrontUpper.getChild("head");
        this.headFeelerRight = this.head.getChild("headFeelerRight");
        this.headFeelerLeft = this.head.getChild("headFeelerLeft");
        this.bodySkull = this.root.getChild("bodySkull");
        this.skullFeelerRight = this.bodySkull.getChild("skullFeelerRight");
        this.skullFeelerLeft = this.bodySkull.getChild("skullFeelerLeft");
    }

    @Override
    public void setupAnim(SnullEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.idleAnim(pAgeInTicks);
        this.animate(pEntity.hideAnimationState, IcariaAnimations.FOREST_SNULL_HIDE, pAgeInTicks);
        this.animate(pEntity.hurtAnimationState, IcariaAnimations.FOREST_SNULL_HURT, pAgeInTicks);
        this.animate(pEntity.idleAnimationState, IcariaAnimations.FOREST_SNULL_IDLE, pAgeInTicks);
        this.animate(pEntity.moveAnimationState, IcariaAnimations.FOREST_SNULL_MOVE, pAgeInTicks);
        this.animate(pEntity.showAnimationState, IcariaAnimations.FOREST_SNULL_SHOW, pAgeInTicks);
    }

    public void idleAnim(float pAgeInTicks) {
        this.headFeelerRight.xRot = Mth.sin(pAgeInTicks * 0.05F + 1.0F) * 0.075F + 0.2618F;
        this.headFeelerRight.zRot = Mth.cos(pAgeInTicks * 0.075F + 2.0F) * 0.075F + 0.7854F;
        this.headFeelerLeft.xRot = -Mth.sin(pAgeInTicks * 0.05F + 3.0F) * 0.075F + 0.2618F;
        this.headFeelerLeft.zRot = -Mth.cos(pAgeInTicks * 0.075F + 4.0F) * 0.075F - 0.7854F;
        this.skullFeelerRight.xRot = Mth.sin(pAgeInTicks * 0.05F + 1.0F) * 0.075F - 0.2618F;
        this.skullFeelerRight.yRot = Mth.cos(pAgeInTicks * 0.075F + 2.0F) * 0.075F + 0.1745F;
        this.skullFeelerLeft.xRot = -Mth.sin(pAgeInTicks * 0.05F + 3.0F) * 0.075F - 0.2618F;
        this.skullFeelerLeft.yRot = -Mth.cos(pAgeInTicks * 0.075F + 4.0F) * 0.075F - 0.1745F;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition bodyFront = partDefinition.addOrReplaceChild("bodyFront", CubeListBuilder.create().texOffs(0, 28).addBox(-2.5F, -4.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -4.0F));
        PartDefinition bodyFrontLower = bodyFront.addOrReplaceChild("bodyFrontLower", CubeListBuilder.create().texOffs(33, 38).addBox(-2.49F, -4.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition bodyFrontCenter = bodyFrontLower.addOrReplaceChild("bodyFrontCenter", CubeListBuilder.create().texOffs(36, 31).addBox(-2.48F, -4.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition bodyFrontUpper = bodyFrontCenter.addOrReplaceChild("bodyFrontUpper", CubeListBuilder.create().texOffs(0, 36).addBox(-2.47F, -4.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -0.3927F, 0.0F, 0.0F));
        bodyFrontUpper.addOrReplaceChild("bodyFrontShroomLower", CubeListBuilder.create().texOffs(40, 17).addBox(-6.47F, -2.5F, -1.0F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, 0.0F, 0.5236F, 0.1745F));
        bodyFrontUpper.addOrReplaceChild("bodyFrontShroomCenter", CubeListBuilder.create().texOffs(20, 10).addBox(-7.77F, -2.5F, -1.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -1.0F, 0.0F, 0.3927F, 0.0873F));
        bodyFrontUpper.addOrReplaceChild("bodyFrontShroomUpper", CubeListBuilder.create().texOffs(42, 8).addBox(-6.97F, -2.5F, -1.0F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -2.0F, 0.0F, 0.2618F, 0.0F));
        PartDefinition head = bodyFrontUpper.addOrReplaceChild("head", CubeListBuilder.create().texOffs(27, 0).addBox(-2.46F, 0.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -3.0F, 0.1963F, 0.0F, 0.0F));
        PartDefinition headFeelerRight = head.addOrReplaceChild("headFeelerRight", CubeListBuilder.create().texOffs(46, 23).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 3.0F, -4.0F, 0.2618F, 0.0F, 0.7854F));
        headFeelerRight.addOrReplaceChild("headEyeRight", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition headFeelerLeft = head.addOrReplaceChild("headFeelerLeft", CubeListBuilder.create().texOffs(12, 46).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 3.0F, -4.0F, 0.2618F, 0.0F, -0.7854F));
        headFeelerLeft.addOrReplaceChild("headEyeLeft", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -5.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bodyCenter = partDefinition.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        bodyCenter.addOrReplaceChild("vine", CubeListBuilder.create().texOffs(0, 15).addBox(-3.01F, -5.0F, -1.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bodyCenterShroomFront = partDefinition.addOrReplaceChild("bodyCenterShroomFront", CubeListBuilder.create().texOffs(24, 39).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 19.25F, -4.0F));
        bodyCenterShroomFront.addOrReplaceChild("bodyCenterShroomFrontTip", CubeListBuilder.create().texOffs(20, 16).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));
        PartDefinition bodyCenterShroomRight = partDefinition.addOrReplaceChild("bodyCenterShroomRight", CubeListBuilder.create().texOffs(18, 29).addBox(0.0F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 22.0F, -3.0F, 0.0F, 0.0F, -0.6109F));
        bodyCenterShroomRight.addOrReplaceChild("bodyCenterShroomRightHat", CubeListBuilder.create().texOffs(0, 43).addBox(-2.25F, -5.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.1745F));
        PartDefinition bodyCenterShroomLeftFront = partDefinition.addOrReplaceChild("bodyCenterShroomLeftFront", CubeListBuilder.create().texOffs(44, 40).addBox(2.5F, -2.5F, -6.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        bodyCenterShroomLeftFront.addOrReplaceChild("bodyCenterShroomLeftFrontTip", CubeListBuilder.create().texOffs(41, 0).addBox(4.5F, -2.5F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        bodyCenterShroomLeftFront.addOrReplaceChild("bodyCenterShroomLeftFrontTop", CubeListBuilder.create().texOffs(18, 46).addBox(2.5F, -3.5F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bodyCenterShroomLeftRear = partDefinition.addOrReplaceChild("bodyCenterShroomLeftRear", CubeListBuilder.create().texOffs(32, 10).addBox(2.0F, -2.0F, 0.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        bodyCenterShroomLeftRear.addOrReplaceChild("bodyCenterShroomLeftRearTip", CubeListBuilder.create().texOffs(40, 46).addBox(4.0F, -2.0F, 1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        bodyCenterShroomLeftRear.addOrReplaceChild("bodyCenterShroomLeftRearTop", CubeListBuilder.create().texOffs(0, 59).addBox(2.0F, -3.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bodySkull = partDefinition.addOrReplaceChild("bodySkull", CubeListBuilder.create().texOffs(22, 17).addBox(-2.99F, -9.0F, 0.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
        PartDefinition skullFeelerRight = bodySkull.addOrReplaceChild("skullFeelerRight", CubeListBuilder.create().texOffs(34, 45).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -4.5F, 0.0F, -0.2618F, 0.1745F, 0.0F));
        skullFeelerRight.addOrReplaceChild("skullEyeRight", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition skullFeelerLeft = bodySkull.addOrReplaceChild("skullFeelerLeft", CubeListBuilder.create().texOffs(45, 0).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.5F, 0.0F, -0.2618F, -0.1745F, 0.0F));
        skullFeelerLeft.addOrReplaceChild("skullEyeLeft", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -5.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bodyRear = partDefinition.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(18, 31).addBox(-2.5F, -4.0F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 4.0F));
        PartDefinition bodyRearFront = bodyRear.addOrReplaceChild("bodyRearFront", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, -3.99F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 4.0F));
        PartDefinition bodyRearCenter = bodyRearFront.addOrReplaceChild("bodyRearCenter", CubeListBuilder.create().texOffs(12, 39).addBox(-2.0F, -3.01F, -0.2F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0087F, 0.0F));
        bodyRearCenter.addOrReplaceChild("bodyRearTail", CubeListBuilder.create().texOffs(46, 46).addBox(-1.6F, -2.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 3.0F, 0.0F, -0.2618F, 0.0F));
        PartDefinition bodyRearShroom = partDefinition.addOrReplaceChild("bodyRearShroom", CubeListBuilder.create().texOffs(26, 44).addBox(-0.5F, -10.8F, 0.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, 6.0F, -0.2618F, 0.0F, 0.1745F));
        bodyRearShroom.addOrReplaceChild("bodyRearShroomHat", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -1.0F, -4.5F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -10.8F, 1.0F, 0.0F, -0.2618F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
