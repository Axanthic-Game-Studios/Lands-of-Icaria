package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.AeternaeEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeModel extends EntityModel<AeternaeEntity> {
    public float kneebend = 1.0F;
    public float xRotMouth;
    public float xRotNeck;

    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "aeternae"), "main");

    public ModelPart body_center;
    public ModelPart thigh_right_front;
    public ModelPart leg_right_front_upper;
    public ModelPart leg_right_front_lower;
    public ModelPart thigh_left_front;
    public ModelPart leg_left_front_upper;
    public ModelPart leg_left_front_lower;
    public ModelPart thigh_right_rear;
    public ModelPart leg_right_rear_upper;
    public ModelPart leg_right_rear_lower;
    public ModelPart thigh_left_rear;
    public ModelPart leg_left_rear_upper;
    public ModelPart leg_left_rear_lower;
    public ModelPart body_front;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart nose;
    public ModelPart mouth;
    public ModelPart beard;
    public ModelPart ear_right;
    public ModelPart ear_left;
    public ModelPart horn_right_big;
    public ModelPart H0R0;
    public ModelPart H0R1;
    public ModelPart H0R2;
    public ModelPart horn_left_big;
    public ModelPart H1L0;
    public ModelPart H1L1;
    public ModelPart H1L2;
    public ModelPart horn_right_small;
    public ModelPart H2R0;
    public ModelPart horn_left_small;
    public ModelPart H3L0;
    public ModelPart body_rear;
    public ModelPart tail;

    public AeternaeModel(ModelPart pModelPart) {
        this.body_center = pModelPart.getChild("body_center");
        this.thigh_right_front = this.body_center.getChild("thigh_right_front");
        this.leg_right_front_upper = this.thigh_right_front.getChild("leg_right_front_upper");
        this.leg_right_front_lower = this.leg_right_front_upper.getChild("leg_right_front_lower");
        this.thigh_left_front = this.body_center.getChild("thigh_left_front");
        this.leg_left_front_upper = this.thigh_left_front.getChild("leg_left_front_upper");
        this.leg_left_front_lower = this.leg_left_front_upper.getChild("leg_left_front_lower");
        this.thigh_right_rear = this.body_center.getChild("thigh_right_rear");
        this.leg_right_rear_upper = this.thigh_right_rear.getChild("leg_right_rear_upper");
        this.leg_right_rear_lower = this.leg_right_rear_upper.getChild("leg_right_rear_lower");
        this.thigh_left_rear = this.body_center.getChild("thigh_left_rear");
        this.leg_left_rear_upper = this.thigh_left_rear.getChild("leg_left_rear_upper");
        this.leg_left_rear_lower = this.leg_left_rear_upper.getChild("leg_left_rear_lower");
        this.body_front = this.body_center.getChild("body_front");
        this.neck = this.body_front.getChild("neck");
        this.head = this.neck.getChild("head");
        this.nose = this.head.getChild("nose");
        this.mouth = this.head.getChild("mouth");
        this.beard = this.head.getChild("beard");
        this.ear_right = this.head.getChild("ear_right");
        this.ear_left = this.head.getChild("ear_left");
        this.horn_right_big = this.head.getChild("horn_right_big");
        this.H0R0 = this.horn_right_big.getChild("H0R0");
        this.H0R1 = this.H0R0.getChild("H0R1");
        this.H0R2 = this.H0R1.getChild("H0R2");
        this.horn_left_big = this.head.getChild("horn_left_big");
        this.H1L0 = this.horn_left_big.getChild("H1L0");
        this.H1L1 = this.H1L0.getChild("H1L1");
        this.H1L2 = this.H1L1.getChild("H1L2");
        this.horn_right_small = this.head.getChild("horn_right_small");
        this.H2R0 = this.horn_right_small.getChild("H2R0");
        this.horn_left_small = this.head.getChild("horn_left_small");
        this.H3L0 = this.horn_left_small.getChild("H3L0");
        this.body_rear = this.body_center.getChild("body_rear");
        this.tail = this.body_rear.getChild("tail");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body_center = partDefinition.addOrReplaceChild("body_center", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, -0.091106186954104F, 0.0F, 0.0F));
        PartDefinition thigh_right_front = body_center.addOrReplaceChild("thigh_right_front", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.4F, -4.0F, 0.18203784098300857F, 0.0F, 0.0F));
        PartDefinition leg_right_front_upper = thigh_right_front.addOrReplaceChild("leg_right_front_upper", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.091106186954104F, 0.0F, 0.0F));
        leg_right_front_upper.addOrReplaceChild("leg_right_front_lower", CubeListBuilder.create().texOffs(44, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.091106186954104F, 0.0F, 0.0F));
        PartDefinition thigh_left_front = body_center.addOrReplaceChild("thigh_left_front", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.4F, -4.0F, 0.18203784098300857F, 0.0F, 0.0F));
        PartDefinition leg_left_front_upper = thigh_left_front.addOrReplaceChild("leg_left_front_upper", CubeListBuilder.create().texOffs(52, 13).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.091106186954104F, 0.0F, 0.0F));
        leg_left_front_upper.addOrReplaceChild("leg_left_front_lower", CubeListBuilder.create().texOffs(64, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.091106186954104F, 0.0F, 0.0F));
        PartDefinition thigh_right_rear = body_center.addOrReplaceChild("thigh_right_rear", CubeListBuilder.create().texOffs(66, 0).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 11.0F, -0.39269908169872414F, 0.0F, 0.0F));
        PartDefinition leg_right_rear_upper = thigh_right_rear.addOrReplaceChild("leg_right_rear_upper", CubeListBuilder.create().texOffs(72, 13).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.5F, 0.7285004297824331F, 0.0F, 0.0F));
        leg_right_rear_upper.addOrReplaceChild("leg_right_rear_lower", CubeListBuilder.create().texOffs(84, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.2F, 0.2F, -0.22759093446006054F, 0.0F, 0.0F));
        PartDefinition thigh_left_rear = body_center.addOrReplaceChild("thigh_left_rear", CubeListBuilder.create().texOffs(84, 0).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, 11.0F, -0.39269908169872414F, 0.0F, 0.0F));
        PartDefinition leg_left_rear_upper = thigh_left_rear.addOrReplaceChild("leg_left_rear_upper", CubeListBuilder.create().texOffs(49, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.5F, 0.7285004297824331F, 0.0F, 0.0F));
        leg_left_rear_upper.addOrReplaceChild("leg_left_rear_lower", CubeListBuilder.create().texOffs(70, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.2F, 0.2F, -0.22759093446006054F, 0.0F, 0.0F));
        PartDefinition body_front = body_center.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(96, 10).addBox(-3.5F, -6.0F, -5.5F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, -3.0F, -0.4553564018453205F, 0.0F, 0.0F));
        PartDefinition neck = body_front.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(104, 21).addBox(-2.5F, -8.0F, -3.0F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -3.5F, 0.9105382707654417F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, -2.5F, -7.0F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.8F, -0.4F, -0.27314402793711257F, 0.0F, 0.0F));
        head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(19, 22).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -7.0F));
        head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -0.3F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -7.0F, 0.045553093477052F, 0.0F, 0.0F));
        head.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(27, 22).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -5.9F));
        head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(56, 24).addBox(-1.0F, -0.3F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.2F, -2.0F, -0.7853981633974483F, 0.0F, 0.0F));
        head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(78, 25).addBox(0.0F, -0.3F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.2F, -2.0F, -0.7853981633974483F, 0.0F, 0.0F));
        PartDefinition horn_right_big = head.addOrReplaceChild("horn_right_big", CubeListBuilder.create().texOffs(39, 23).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0F, -4.5F, -0.18203784098300857F, 0.0F, -0.27314402793711257F));
        PartDefinition H0R0 = horn_right_big.addOrReplaceChild("H0R0", CubeListBuilder.create().texOffs(116, 10).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.4553564018453205F, 0.0F, -0.045553093477052F));
        PartDefinition H0R1 = H0R0.addOrReplaceChild("H0R1", CubeListBuilder.create().texOffs(43, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.4553564018453205F, 0.0F, -0.045553093477052F));
        H0R1.addOrReplaceChild("H0R2", CubeListBuilder.create().texOffs(30, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.5462880558742251F, 0.0F, -0.045553093477052F));
        PartDefinition horn_left_big = head.addOrReplaceChild("horn_left_big", CubeListBuilder.create().texOffs(90, 25).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.0F, -4.5F, -0.18203784098300857F, 0.0F, 0.27314402793711257F));
        PartDefinition H1L0 = horn_left_big.addOrReplaceChild("H1L0", CubeListBuilder.create().texOffs(119, 18).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.4553564018453205F, 0.0F, 0.045553093477052F));
        PartDefinition H1L1 = H1L0.addOrReplaceChild("H1L1", CubeListBuilder.create().texOffs(61, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.4553564018453205F, 0.0F, 0.045553093477052F));
        H1L1.addOrReplaceChild("H1L2", CubeListBuilder.create().texOffs(49, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.5462880558742251F, 0.0F, 0.045553093477052F));
        PartDefinition horn_right_small = head.addOrReplaceChild("horn_right_small", CubeListBuilder.create().texOffs(43, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -2.5F, -2.6F, -0.4553564018453205F, 0.0F, -0.045553093477052F));
        horn_right_small.addOrReplaceChild("H2R0", CubeListBuilder.create().texOffs(30, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.5462880558742251F, 0.0F, -0.045553093477052F));
        PartDefinition horn_left_small = head.addOrReplaceChild("horn_left_small", CubeListBuilder.create().texOffs(61, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, -2.5F, -2.6F, -0.4553564018453205F, 0.0F, 0.045553093477052F));
        horn_left_small.addOrReplaceChild("H3L0", CubeListBuilder.create().texOffs(49, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.5462880558742251F, 0.0F, 0.045553093477052F));
        PartDefinition body_rear = body_center.addOrReplaceChild("body_rear", CubeListBuilder.create().texOffs(102, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.18203784098300857F, 0.0F, 0.0F));
        body_rear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(84, 15).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 3.5F, -0.18203784098300857F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 48);
    }

    @Override
    public void prepareMobModel(AeternaeEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks) {
        super.prepareMobModel(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks);
        this.xRotMouth = -pEntity.xRotMouth(pAgeInTicks);
        this.xRotNeck = -pEntity.xRotNeck(pAgeInTicks);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        if (this.young) {
            pPoseStack.pushPose();
            pPoseStack.scale(0.5F, 0.5F, 0.5F);
            pPoseStack.translate(0.0F, 1.5F, 0.0F);
            this.horn_right_big.visible = false;
            this.horn_left_big.visible = false;
            this.horn_right_small.visible = true;
            this.horn_left_small.visible = true;
            this.body_center.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        } else {
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, 1.0F, 1.0F);
            pPoseStack.translate(0.0F, 0.0F, 0.0F);
            this.horn_right_big.visible = true;
            this.horn_left_big.visible = true;
            this.horn_right_small.visible = false;
            this.horn_left_small.visible = false;
            this.body_center.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        }
    }

    @Override
    public void setupAnim(AeternaeEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.eatAnim();
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
    }

    public void eatAnim() {
        this.body_front.xRot = this.xRotNeck * 0.45F - 0.4553564018453205F;
        this.neck.xRot = this.xRotNeck * 0.3F + 0.9105382707654417F;
        this.head.xRot -= this.xRotNeck * 0.3F;
        this.mouth.xRot = this.xRotMouth * 0.25F + 0.045553093477052F;
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.body_front.yRot = pNetHeadYaw * 0.003F;
        this.head.xRot = pHeadPitch * 0.017453292F;
        this.head.yRot = pNetHeadYaw * 0.005F;
        this.neck.yRot = pNetHeadYaw * 0.005F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        pLimbSwing *= 1.8;

        float rightFront = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing)) * 0.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount;
        float leftFront = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.5F)) * 0.5F + (float) Math.PI) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount;
        float rightRear = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.75F)) * 0.5F + (float) Math.PI * 1.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount;
        float leftRear = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.25F)) * 0.5F + (float) Math.PI * 0.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount;

        this.thigh_right_front.xRot = Mth.cos(pLimbSwing * 0.5F) * 0.7F * pLimbSwingAmount + 0.18203784098300857F;
        this.leg_right_front_upper.xRot = -rightFront - 0.091106186954104F;
        this.leg_right_front_lower.xRot = rightFront * 1.5F - 0.091106186954104F;
        this.thigh_left_front.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI) * 0.7F * pLimbSwingAmount + 0.18203784098300857F;
        this.leg_left_front_upper.xRot = -leftFront - 0.091106186954104F;
        this.leg_left_front_lower.xRot = leftFront * 1.5F - 0.091106186954104F;
        this.thigh_right_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 1.5F) * 0.7F * pLimbSwingAmount - 0.39269908169872414F;
        this.leg_right_rear_upper.xRot = rightRear + 0.7285004297824331F;
        this.leg_right_rear_lower.xRot = -rightRear - 0.22759093446006054F;
        this.thigh_left_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 0.5F) * 0.7F * pLimbSwingAmount - 0.39269908169872414F;
        this.leg_left_rear_upper.xRot = leftRear + 0.7285004297824331F;
        this.leg_left_rear_lower.xRot = -leftRear - 0.22759093446006054F;
    }
}
