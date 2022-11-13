package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.CerverEntity;
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

public class CerverModel extends EntityModel<CerverEntity> {
    public float kneebend = 0.75F;

    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "cerver"), "main");

    public ModelPart body;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart ear_right;
    public ModelPart ear_left;
    public ModelPart mouth;
    public ModelPart teeth;
    public ModelPart jaw;
    public ModelPart thigh_right_front;
    public ModelPart leg_right_front;
    public ModelPart paw_right_front;
    public ModelPart thigh_left_front;
    public ModelPart leg_left_front;
    public ModelPart paw_left_front;
    public ModelPart back;
    public ModelPart rump;
    public ModelPart tail_front;
    public ModelPart tail_rear;
    public ModelPart thigh_right_rear;
    public ModelPart leg_right_rear;
    public ModelPart paw_right_rear;
    public ModelPart thigh_left_rear;
    public ModelPart leg_left_rear;
    public ModelPart paw_left_rear;

    public CerverModel(ModelPart pModelPart) {
        this.body = pModelPart.getChild("body");
        this.neck = this.body.getChild("neck");
        this.head = this.neck.getChild("head");
        this.ear_right = this.head.getChild("ear_right");
        this.ear_left = this.head.getChild("ear_left");
        this.mouth = this.head.getChild("mouth");
        this.teeth = this.mouth.getChild("teeth");
        this.jaw = this.mouth.getChild("jaw");
        this.thigh_right_front = this.body.getChild("thigh_right_front");
        this.leg_right_front = this.thigh_right_front.getChild("leg_right_front");
        this.paw_right_front = this.leg_right_front.getChild("paw_right_front");
        this.thigh_left_front = this.body.getChild("thigh_left_front");
        this.leg_left_front = this.thigh_left_front.getChild("leg_left_front");
        this.paw_left_front = this.leg_left_front.getChild("paw_left_front");
        this.back = this.body.getChild("back");
        this.rump = this.back.getChild("rump");
        this.tail_front = this.rump.getChild("tail_front");
        this.tail_rear = this.tail_front.getChild("tail_rear");
        this.thigh_right_rear = this.rump.getChild("thigh_right_rear");
        this.leg_right_rear = this.thigh_right_rear.getChild("leg_right_rear");
        this.paw_right_rear = this.leg_right_rear.getChild("paw_right_rear");
        this.thigh_left_rear = this.rump.getChild("thigh_left_rear");
        this.leg_left_rear = this.thigh_left_rear.getChild("leg_left_rear");
        this.paw_left_rear = this.leg_left_rear.getChild("paw_left_rear");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -8.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, 2.0F, -0.136659280431156F, 0.0F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(72, 0).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, -5.5F, 0.136659280431156F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(66, 21).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -3.5F, 0.045553093477052F, 0.0F, 0.0F));
        head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, -3.8F, -2.0F, 0.0F, -0.5235987755982988F, 0.7853981633974483F));
        head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(30, 0).addBox(0.0F, 0.0F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, -3.8F, -2.0F, 0.5235987755982988F, 0.0F, 0.7853981633974483F));
        PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(12, 20).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -6.0F));
        mouth.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(12, 44).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.3F));
        mouth.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(24, 18).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -0.7F, 0.19634954084936207F, 0.0F, 0.0F));
        PartDefinition thigh_right_front = body.addOrReplaceChild("thigh_right_front", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.8F, -6.7F, 0.31869712141416456F, 0.0F, 0.0F));
        PartDefinition leg_right_front = thigh_right_front.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(69, 10).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.5F, -0.31869712141416456F, 0.0F, 0.0F));
        leg_right_front.addOrReplaceChild("paw_right_front", CubeListBuilder.create().texOffs(56, 17).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.3F, 0.136659280431156F, 0.0F, 0.0F));
        PartDefinition thigh_left_front = body.addOrReplaceChild("thigh_left_front", CubeListBuilder.create().texOffs(56, 0).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.8F, -6.7F, 0.31869712141416456F, 0.0F, 0.0F));
        PartDefinition leg_left_front = thigh_left_front.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(81, 10).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.5F, -0.31869712141416456F, 0.0F, 0.0F));
        leg_left_front.addOrReplaceChild("paw_left_front", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.3F, 0.136659280431156F, 0.0F, 0.0F));
        PartDefinition back = body.addOrReplaceChild("back", CubeListBuilder.create().texOffs(30, 13).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2F, 7.6F, 0.091106186954104F, 0.0F, 0.0F));
        PartDefinition rump = back.addOrReplaceChild("rump", CubeListBuilder.create().texOffs(0, 26).addBox(-4.5F, 0.2F, -2.1F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3F, 3.6F, -0.7853981633974483F, 0.0F, 0.0F));
        PartDefinition tail_front = rump.addOrReplaceChild("tail_front", CubeListBuilder.create().texOffs(30, 30).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.8F, 2.0032889154390916F, 0.0F, 0.0F));
        tail_front.addOrReplaceChild("tail_rear", CubeListBuilder.create().texOffs(62, 33).addBox(-1.02F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -1.5F, 0.5462880558742251F, 0.0F, 0.0F));
        PartDefinition thigh_right_rear = rump.addOrReplaceChild("thigh_right_rear", CubeListBuilder.create().texOffs(38, 30).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.2F, 0.8F, 0.39269908169872414F, 0.0F, 0.0F));
        PartDefinition leg_right_rear = thigh_right_rear.addOrReplaceChild("leg_right_rear", CubeListBuilder.create().texOffs(70, 33).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 5.15F, -0.25F, 0.5918411493512771F, 0.0F, 0.0F));
        leg_right_rear.addOrReplaceChild("paw_right_rear", CubeListBuilder.create().texOffs(0, 38).addBox(-2.0F, 0.0F, -2.2F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.3F, 0.0F, -0.136659280431156F, 0.0F, 0.0F));
        PartDefinition thigh_left_rear = rump.addOrReplaceChild("thigh_left_rear", CubeListBuilder.create().texOffs(50, 30).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.2F, 0.8F, 0.39269908169872414F, 0.0F, 0.0F));
        PartDefinition leg_left_rear = thigh_left_rear.addOrReplaceChild("leg_left_rear", CubeListBuilder.create().texOffs(82, 33).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 5.15F, -0.25F, 0.5918411493512771F, 0.0F, 0.0F));
        leg_left_rear.addOrReplaceChild("paw_left_rear", CubeListBuilder.create().texOffs(16, 38).addBox(-2.0F, 0.0F, -2.2F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.3F, 0.0F, -0.136659280431156F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 96, 64);
    }

    @Override
    public void setupAnim(CerverEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.body.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        pLimbSwing *= 1.2F;

        this.thigh_right_front.xRot = -Mth.cos(pLimbSwing * 0.5F) * 0.6F * pLimbSwingAmount + 0.31869712141416456F;
        this.leg_right_front.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing)) * 0.5F) * kneebend * pLimbSwingAmount - kneebend * pLimbSwingAmount - 0.31869712141416456F;
        this.paw_right_front.xRot = -Mth.sin((pLimbSwing + Mth.sin(pLimbSwing)) * 0.5F) * kneebend * 1.7F * pLimbSwingAmount + kneebend * 1.7F * pLimbSwingAmount + 0.136659280431156F;
        this.thigh_left_front.xRot = -Mth.cos(pLimbSwing * 0.5F + (float) Math.PI) * 0.6F * pLimbSwingAmount + 0.31869712141416456F;
        this.leg_left_front.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.5F)) * 0.5F + (float) Math.PI) * kneebend * pLimbSwingAmount - kneebend * pLimbSwingAmount - 0.31869712141416456F;
        this.paw_left_front.xRot = -Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.5F)) * 0.5F + (float) Math.PI) * kneebend * 1.7F * pLimbSwingAmount + kneebend * 1.7F * pLimbSwingAmount + 0.136659280431156F;
        this.thigh_right_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 1.5F) * 1.2F * pLimbSwingAmount + 0.39269908169872414F;
        this.leg_right_rear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.75F)) * 0.5F + (float) Math.PI * 1.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount + 0.5918411493512771F;
        this.paw_right_rear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.75F)) * 0.5F + (float) Math.PI * 1.5F) * kneebend * 1.7F * pLimbSwingAmount + kneebend * 1.0F * pLimbSwingAmount - 0.136659280431156F;
        this.thigh_left_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 0.5F) * 1.2F * pLimbSwingAmount + 0.39269908169872414F;
        this.leg_left_rear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.25F)) * 0.5F + (float) Math.PI * 0.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount + 0.5918411493512771F;
        this.paw_left_rear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.25F)) * 0.5F + (float) Math.PI * 0.5F) * kneebend * 1.7F * pLimbSwingAmount + kneebend * 1.0F * pLimbSwingAmount - 0.136659280431156F;
    }
}
