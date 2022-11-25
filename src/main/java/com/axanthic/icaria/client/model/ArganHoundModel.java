package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.ArganHoundEntity;
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

public class ArganHoundModel extends EntityModel<ArganHoundEntity> {
    public float kneebend = 0.5F;

    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "argan_hound"), "main");

    public ModelPart body_front;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart ear_right;
    public ModelPart ear_left;
    public ModelPart mouth;
    public ModelPart nose;
    public ModelPart fang_right;
    public ModelPart fang_left;
    public ModelPart hair_front;
    public ModelPart hair_center;
    public ModelPart hair_rear;
    public ModelPart thigh_right_front;
    public ModelPart thigh_left_front;
    public ModelPart leg_right_front;
    public ModelPart leg_left_front;
    public ModelPart body_rear;
    public ModelPart tail;
    public ModelPart upper_thigh_right_rear;
    public ModelPart upper_thigh_left_rear;
    public ModelPart lower_thigh_right_rear;
    public ModelPart lower_thigh_left_rear;
    public ModelPart leg_right_rear;
    public ModelPart leg_left_rear;

    public ArganHoundModel(ModelPart pModelPart) {
        this.body_front = pModelPart.getChild("body_front");
        this.neck = this.body_front.getChild("neck");
        this.head = this.neck.getChild("head");
        this.ear_right = this.head.getChild("ear_right");
        this.ear_left = this.head.getChild("ear_left");
        this.mouth = this.head.getChild("mouth");
        this.nose = this.head.getChild("nose");
        this.fang_right = this.nose.getChild("fang_right");
        this.fang_left = this.nose.getChild("fang_left");
        this.hair_front = this.body_front.getChild("hair_front");
        this.hair_center = this.hair_front.getChild("hair_center");
        this.hair_rear = this.hair_center.getChild("hair_rear");
        this.thigh_right_front = this.body_front.getChild("thigh_right_front");
        this.thigh_left_front = this.body_front.getChild("thigh_left_front");
        this.leg_right_front = this.thigh_right_front.getChild("leg_right_front");
        this.leg_left_front = this.thigh_left_front.getChild("leg_left_front");
        this.body_rear = this.body_front.getChild("body_rear");
        this.tail = this.body_rear.getChild("tail");
        this.upper_thigh_right_rear = this.body_rear.getChild("upper_thigh_right_rear");
        this.upper_thigh_left_rear = this.body_rear.getChild("upper_thigh_left_rear");
        this.lower_thigh_right_rear = this.body_rear.getChild("lower_thigh_right_rear");
        this.lower_thigh_left_rear = this.body_rear.getChild("lower_thigh_left_rear");
        this.leg_right_rear = this.lower_thigh_right_rear.getChild("leg_right_rear");
        this.leg_left_rear = this.lower_thigh_left_rear.getChild("leg_left_rear");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body_front = partDefinition.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -0.5F, -12.0F, 8.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 5.0F, 0.091106186954104F, 0.0F, 0.0F));
        PartDefinition neck = body_front.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(19, 28).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.3F, -11.8F, -0.39269908169872414F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 48).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -1.0F, 0.39269908169872414F, 0.0F, 0.0F));
        head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(0, 20).addBox(-1.5F, -6.0F, 1.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -2.0F, 0.39269908169872414F, 0.0F, -0.7853981633974483F));
        head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(0, 40).addBox(-1.5F, -6.0F, 1.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, -2.0F, 0.39269908169872414F, 0.0F, 0.7853981633974483F));
        head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(24, 50).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -6.5F, 0.136659280431156F, 0.0F, 0.0F));
        PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(43, 46).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));
        nose.addOrReplaceChild("fang_right", CubeListBuilder.create().texOffs(37, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 0.5F, -3.0F, 0.7853981633974483F, 0.0F, 0.0F));
        nose.addOrReplaceChild("fang_left", CubeListBuilder.create().texOffs(38, 9).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 0.5F, -3.0F, 0.7853981633974483F, 0.0F, 0.0F));
        PartDefinition hair_front = body_front.addOrReplaceChild("hair_front", CubeListBuilder.create().texOffs(0, 20).addBox(-1.51F, 0.0F, -9.0F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, -4.0F, 0.136659280431156F, 0.0F, 0.0F));
        PartDefinition hair_center = hair_front.addOrReplaceChild("hair_center", CubeListBuilder.create().texOffs(15, 20).addBox(-1.49F, 0.0F, 0.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.39269908169872414F, 0.0F, 0.0F));
        hair_center.addOrReplaceChild("hair_rear", CubeListBuilder.create().texOffs(51, 28).addBox(-1.52F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.39269908169872414F, 0.0F, 0.0F));
        PartDefinition thigh_right_front = body_front.addOrReplaceChild("thigh_right_front", CubeListBuilder.create().texOffs(27, 0).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 6.5F, -8.3F, 0.091106186954104F, 0.0F, 0.0F));
        PartDefinition thigh_left_front = body_front.addOrReplaceChild("thigh_left_front", CubeListBuilder.create().texOffs(41, 0).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 6.5F, -8.3F, 0.091106186954104F, 0.0F, 0.0F));
        thigh_right_front.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(52, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.36425021489121656F, 0.0F, 0.0F));
        thigh_left_front.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(37, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.36425021489121656F, 0.0F, 0.0F));
        PartDefinition body_rear = body_front.addOrReplaceChild("body_rear", CubeListBuilder.create().texOffs(31, 13).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.27314402793711257F, 0.0F, 0.0F));
        body_rear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(37, 28).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.5F, 6.0F, -0.27314402793711257F, 0.0F, 0.0F));
        body_rear.addOrReplaceChild("upper_thigh_right_rear", CubeListBuilder.create().texOffs(36, 40).addBox(-0.5F, -3.0F, -3.0F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.7F, 2.6F, 1.0471975511965976F, 0.0F, 0.0F));
        body_rear.addOrReplaceChild("upper_thigh_left_rear", CubeListBuilder.create().texOffs(24, 39).addBox(-0.5F, -3.0F, -3.0F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.7F, 2.6F, 1.0471975511965976F, 0.0F, 0.0F));
        PartDefinition lower_thigh_right_rear = body_rear.addOrReplaceChild("lower_thigh_right_rear", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 6.5F, 5.5F, 0.091106186954104F, 0.0F, 0.0F));
        PartDefinition lower_thigh_left_rear = body_rear.addOrReplaceChild("lower_thigh_left_rear", CubeListBuilder.create().texOffs(10, 39).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 6.5F, 5.5F, 0.091106186954104F, 0.0F, 0.0F));
        lower_thigh_right_rear.addOrReplaceChild("leg_right_rear", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.27314402793711257F, 0.0F, 0.0F));
        lower_thigh_left_rear.addOrReplaceChild("leg_left_rear", CubeListBuilder.create().texOffs(55, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.27314402793711257F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.body_front.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    @Override
    public void setupAnim(ArganHoundEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.head.xRot = pHeadPitch * 0.017453292F + 0.39269908169872414F;
        this.head.yRot = pNetHeadYaw * 0.017453292F;
        this.head.zRot = pNetHeadYaw * 0.0045F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        pLimbSwing *= 1.2F;

        this.thigh_right_front.xRot = -Mth.cos(pLimbSwing * 0.5F) * 0.6F * pLimbSwingAmount + 0.091106186954104F;
        this.leg_right_front.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing)) * 0.5F) * kneebend * pLimbSwingAmount - kneebend * pLimbSwingAmount - 0.36425021489121656F;
        this.thigh_left_front.xRot = -Mth.cos(pLimbSwing * 0.5F + (float) Math.PI) * 0.6F * pLimbSwingAmount + 0.091106186954104F;
        this.leg_left_front.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.5F)) * 0.5F + (float) Math.PI) * kneebend * pLimbSwingAmount - kneebend * pLimbSwingAmount - 0.36425021489121656F;
        this.lower_thigh_right_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 1.5F) * 1.2F * pLimbSwingAmount - 0.091106186954104F;
        this.leg_right_rear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.75F)) * 0.5F + (float) Math.PI * 1.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount + 0.27314402793711257F;
        this.lower_thigh_left_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 0.5F) * 1.2F * pLimbSwingAmount - 0.091106186954104F;
        this.leg_left_rear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.25F)) * 0.5F + (float) Math.PI * 0.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount + 0.27314402793711257F;
    }
}
