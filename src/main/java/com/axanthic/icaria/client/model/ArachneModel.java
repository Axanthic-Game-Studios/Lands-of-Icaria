package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.ArachneEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
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

public class ArachneModel extends HierarchicalModel<ArachneEntity> {
    public static AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(0.5F).addAnimation("front", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16667F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("abdomen", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16667F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16667F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("shoulders", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16667F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16667F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("biterRight", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.20833F, KeyframeAnimations.degreeVec(7.5F, 2.5F, 22.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("biterLeft", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(10.0F, -10.0F, -22.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("armRight", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("armLeft", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.20833F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("forearmRight", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.20833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -22.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("forearmLeft", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "arachne"), "main");

    public ModelPart root;
    public ModelPart front;
    public ModelPart abdomen;
    public ModelPart chest;
    public ModelPart shoulders;
    public ModelPart head;
    public ModelPart rear;
    public ModelPart legRightFront;
    public ModelPart legRightCenter;
    public ModelPart legRightRear;
    public ModelPart legLeftFront;
    public ModelPart legLeftCenter;
    public ModelPart legLeftRear;

    public ArachneModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.front = this.root.getChild("front");
        this.abdomen = this.front.getChild("abdomen");
        this.chest = this.abdomen.getChild("chest");
        this.shoulders = this.chest.getChild("shoulders");
        this.head = this.shoulders.getChild("head");
        this.rear = this.root.getChild("rear");
        this.legRightFront = this.root.getChild("legRightFront");
        this.legRightCenter = this.root.getChild("legRightCenter");
        this.legRightRear = this.root.getChild("legRightRear");
        this.legLeftFront = this.root.getChild("legLeftFront");
        this.legLeftCenter = this.root.getChild("legLeftCenter");
        this.legLeftRear = this.root.getChild("legLeftRear");
    }

    @Override
    public void setupAnim(ArachneEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
        this.animate(pEntity.attackAnimationState, ATTACK, pAgeInTicks);
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.head.xRot = pHeadPitch * (Mth.PI / 360.0F) + 1.3963F;
        this.head.zRot = pNetHeadYaw * (Mth.PI / 360.0F);
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        float f0 = -(Mth.cos(pLimbSwing + (Mth.PI)) * 0.5F) * pLimbSwingAmount;
        float f1 = -(Mth.cos(pLimbSwing + (Mth.PI * 0.5F)) * 0.5F) * pLimbSwingAmount;
        float f2 = -(Mth.cos(pLimbSwing + (Mth.PI * 1.5F)) * 0.5F) * pLimbSwingAmount;
        float f3 = Math.abs(Mth.sin(pLimbSwing + (Mth.PI)) * 0.5F) * pLimbSwingAmount;
        float f4 = Math.abs(Mth.sin(pLimbSwing + (Mth.PI * 0.5F)) * 0.5F) * pLimbSwingAmount;
        float f5 = Math.abs(Mth.sin(pLimbSwing + (Mth.PI * 1.5F)) * 0.5F) * pLimbSwingAmount;

        this.legRightFront.yRot = -0.576F + f2;
        this.legRightCenter.yRot = f1;
        this.legRightRear.yRot = 0.576F + f0;
        this.legLeftFront.yRot = 0.576F - f2;
        this.legLeftCenter.yRot = - f1;
        this.legLeftRear.yRot = -0.576F - f0;
        this.legRightFront.zRot = 0.3927F + f5;
        this.legRightCenter.zRot = 0.3927F + f4;
        this.legRightRear.zRot = 0.3927F + f3;
        this.legLeftFront.zRot = -0.3927F - f5;
        this.legLeftCenter.zRot = -0.3927F - f4;
        this.legLeftRear.zRot = -0.3927F - f3;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition front = partDefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(114, 151).addBox(-3.5F, -4.0F, -3.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.5F, -2.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition abdomen = front.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(86, 150).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -3.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition chest = abdomen.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(54, 150).addBox(-5.0F, -4.25F, -6.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition shoulders = chest.addOrReplaceChild("shoulders", CubeListBuilder.create().texOffs(14, 148).addBox(-7.0F, -5.25F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, -6.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition head = shoulders.addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 0).addBox(-4.5F, -8.0F, -4.0F, 9.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(-4.5F, -3.0F, -1.0F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 7).addBox(-5.0F, -6.25F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 3).addBox(-5.0F, -7.0F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(7, 0).addBox(-2.5F, -7.75F, -4.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 5).addBox(-3.5F, -8.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 7).addBox(4.0F, -6.5F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(35, 3).addBox(3.0F, -6.75F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(31, 0).addBox(0.5F, -7.5F, -4.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 5).addBox(2.75F, -8.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.125F, -3.5625F, 1.3963F, 0.0F, 0.0F));
        head.addOrReplaceChild("B04C11", CubeListBuilder.create().texOffs(22, 12).addBox(-0.5F, -1.5F, -0.25F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, -4.0F, 0.3927F, 0.0F, 0.1309F));
        head.addOrReplaceChild("B04C10", CubeListBuilder.create().texOffs(12, 12).addBox(-2.5F, -1.0F, -0.25F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, -4.0F, 0.3927F, 0.0F, -0.1309F));
        PartDefinition biterRight = head.addOrReplaceChild("biterRight", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, 0.6F, -4.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, -1.0F, 0.7854F, 0.576F, 0.0F));
        biterRight.addOrReplaceChild("B05C01", CubeListBuilder.create().texOffs(0, 21).addBox(-2.25F, -2.5F, -8.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.5F, 1.5F, 0.0F, 0.0F, 0.6981F));
        PartDefinition biterLeft = head.addOrReplaceChild("biterLeft", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, 0.6F, -4.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -4.0F, -1.0F, 0.7854F, -0.576F, 0.0F));
        biterLeft.addOrReplaceChild("B06C01", CubeListBuilder.create().texOffs(30, 19).addBox(-2.75F, -2.5F, -8.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.5F, 1.5F, 0.0F, 0.0F, -0.7854F));
        PartDefinition armRight = shoulders.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(10, 99).addBox(-12.5F, -2.0F, -0.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 124).addBox(-12.5F, 1.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -0.75F, -4.0F, 0.3927F, 0.0F, 0.3927F));
        PartDefinition forearmRight = armRight.addOrReplaceChild("forearmRight", CubeListBuilder.create(), PartPose.offset(-12.0F, 4.0F, 0.0F));
        forearmRight.addOrReplaceChild("B08C00", CubeListBuilder.create().texOffs(84, 109).addBox(0.0F, -0.7F, 0.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, -0.2618F));
        PartDefinition armLeft = shoulders.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(10, 124).addBox(1.5F, -2.0F, -0.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 98).addBox(9.5F, 1.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -0.75F, -4.0F, 0.3927F, 0.0F, -0.3927F));
        PartDefinition forearmLeft = armLeft.addOrReplaceChild("forearmLeft", CubeListBuilder.create(), PartPose.offset(12.0F, 4.0F, 0.0F));
        forearmLeft.addOrReplaceChild("B10C00", CubeListBuilder.create().texOffs(84, 135).addBox(-1.75F, 0.4F, 0.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.2618F));
        PartDefinition rear = partDefinition.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(132, 136).addBox(-5.0F, -10.0F, 1.0F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 0.1745F, 0.0F, 0.0F));
        rear.addOrReplaceChild("B11C08", CubeListBuilder.create().texOffs(146, 48).addBox(-2.0F, -0.25F, -1.25F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 28.5F, -0.7854F, 0.0F, 0.0F));
        rear.addOrReplaceChild("B11C07", CubeListBuilder.create().texOffs(142, 55).addBox(-3.0F, -0.5F, 0.25F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 26.0F, -0.6109F, 0.0F, 0.0F));
        rear.addOrReplaceChild("B11C06", CubeListBuilder.create().texOffs(136, 63).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, 24.0F, -0.3927F, 0.0F, 0.0F));
        rear.addOrReplaceChild("B11C05", CubeListBuilder.create().texOffs(130, 73).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 20.5F, -0.2182F, 0.0F, 0.0F));
        rear.addOrReplaceChild("B11C04", CubeListBuilder.create().texOffs(124, 86).addBox(-6.0F, 0.0F, -1.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 15.75F, -0.1309F, 0.0F, 0.0F));
        rear.addOrReplaceChild("B11C03", CubeListBuilder.create().texOffs(120, 102).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 10.0F, -0.0873F, 0.0F, 0.0F));
        rear.addOrReplaceChild("B11C02", CubeListBuilder.create().texOffs(124, 120).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 5.0F, -0.0436F, 0.0F, 0.0F));
        rear.addOrReplaceChild("B11C00", CubeListBuilder.create().texOffs(136, 148).addBox(-3.0F, -3.5F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition stingerFront = rear.addOrReplaceChild("stingerFront", CubeListBuilder.create().texOffs(148, 0).addBox(-1.5F, 0.0F, -0.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.25F, 29.25F, -1.0036F, 0.0F, 0.0F));
        PartDefinition stingerCenter = stingerFront.addOrReplaceChild("stingerCenter", CubeListBuilder.create().texOffs(150, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 1.75F, -0.1745F, 0.0F, 0.0F));
        PartDefinition stingerRear = stingerCenter.addOrReplaceChild("stingerRear", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, 3.0F));
        stingerRear.addOrReplaceChild("B14C00", CubeListBuilder.create().texOffs(154, 11).addBox(-0.5F, 0.0F, -0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition legRightFront = partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(0, 105).addBox(-14.5F, -3.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 129).addBox(-14.5F, 0.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 15.0F, 0.0F, -0.2618F, -0.576F, 0.3927F));
        legRightFront.addOrReplaceChild("B15C02", CubeListBuilder.create().texOffs(76, 110).addBox(-2.5F, 0.95F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.5F, 1.0F, 0.0F, 0.0F, -0.2618F));
        PartDefinition legRightCenter = partDefinition.addOrReplaceChild("legRightCenter", CubeListBuilder.create().texOffs(0, 111).addBox(-14.5F, -4.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 136).addBox(-14.5F, -1.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 16.0F, 2.0F, 0.0F, 0.0F, 0.3927F));
        legRightCenter.addOrReplaceChild("B16C02", CubeListBuilder.create().texOffs(68, 109).addBox(-2.0F, 0.8F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.5F, 1.0F, 0.0F, 0.0F, -0.2618F));
        PartDefinition legRightRear = partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(0, 117).addBox(-14.0F, -2.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 141).addBox(-14.0F, 1.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 14.0F, 4.0F, 0.1745F, 0.576F, 0.3927F));
        legRightRear.addOrReplaceChild("B17C02", CubeListBuilder.create().texOffs(60, 110).addBox(-2.25F, 0.9F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 2.5F, 1.0F, 0.0F, 0.0F, -0.2618F));
        PartDefinition legLeftFront = partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(0, 130).addBox(-1.5F, -3.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 105).addBox(11.5F, 0.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 15.0F, 0.0F, -0.2618F, 0.576F, -0.3927F));
        legLeftFront.addOrReplaceChild("B18C02", CubeListBuilder.create().texOffs(76, 135).addBox(-1.0F, 1.25F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 1.5F, 1.0F, 0.0F, 0.0F, 0.2618F));
        PartDefinition legLeftCenter = partDefinition.addOrReplaceChild("legLeftCenter", CubeListBuilder.create().texOffs(0, 136).addBox(-1.5F, -4.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 110).addBox(11.5F, -1.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 16.0F, 2.0F, 0.0F, 0.0F, -0.3927F));
        legLeftCenter.addOrReplaceChild("B19C02", CubeListBuilder.create().texOffs(68, 135).addBox(-0.75F, 1.9F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, 1.0F, 0.0F, 0.0F, 0.2618F));
        PartDefinition legLeftRear = partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(0, 142).addBox(-2.0F, -2.0F, -0.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 115).addBox(11.0F, 1.0F, -0.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 14.0F, 4.0F, 0.1745F, -0.576F, -0.3927F));
        legLeftRear.addOrReplaceChild("B20C02", CubeListBuilder.create().texOffs(60, 137).addBox(-0.75F, 3.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 2.5F, 1.0F, 0.0F, 0.0F, 0.2618F));

        return LayerDefinition.create(meshDefinition, 160, 160);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
