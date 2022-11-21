package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.CatoblepasEntity;
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

public class CatoblepasModel extends EntityModel<CatoblepasEntity> {
    public float kneebend = 0.9F;

    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "catoblepas"), "main");

    public ModelPart body_center;
    public ModelPart tail;
    public ModelPart udder;
    public ModelPart teat_right_front;
    public ModelPart teat_left_front;
    public ModelPart teat_right_rear;
    public ModelPart teat_left_rear;
    public ModelPart body_front;
    public ModelPart back_front;
    public ModelPart back_rear;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart hair;
    public ModelPart horn_right;
    public ModelPart H0R0;
    public ModelPart H0R1;
    public ModelPart H0R2;
    public ModelPart horn_left;
    public ModelPart H1L0;
    public ModelPart H1L1;
    public ModelPart H1L2;
    public ModelPart ear_right;
    public ModelPart ear_left;
    public ModelPart nose;
    public ModelPart snout;
    public ModelPart mouth;
    public ModelPart thigh_right_front;
    public ModelPart leg_right_front;
    public ModelPart thigh_left_front;
    public ModelPart leg_left_front;
    public ModelPart body_rear;
    public ModelPart thigh_right_rear;
    public ModelPart leg_right_rear;
    public ModelPart thigh_left_rear;
    public ModelPart leg_left_rear;

    public CatoblepasModel(ModelPart pModelPart) {
        this.body_center = pModelPart.getChild("body_center");
        this.tail = this.body_center.getChild("tail");
        this.udder = this.body_center.getChild("udder");
        this.teat_right_front = this.udder.getChild("teat_right_front");
        this.teat_left_front = this.udder.getChild("teat_left_front");
        this.teat_right_rear = this.udder.getChild("teat_right_rear");
        this.teat_left_rear = this.udder.getChild("teat_left_rear");
        this.body_front = this.body_center.getChild("body_front");
        this.back_front = this.body_front.getChild("back_front");
        this.back_rear = this.back_front.getChild("back_rear");
        this.neck = this.body_front.getChild("neck");
        this.head = this.neck.getChild("head");
        this.hair = this.head.getChild("hair");
        this.horn_right = this.hair.getChild("horn_right");
        this.H0R0 = this.horn_right.getChild("H0R0");
        this.H0R1 = this.H0R0.getChild("H0R1");
        this.H0R2 = this.H0R1.getChild("H0R2");
        this.horn_left = this.hair.getChild("horn_left");
        this.H1L0 = this.horn_left.getChild("H1L0");
        this.H1L1 = this.H1L0.getChild("H1L1");
        this.H1L2 = this.H1L1.getChild("H1L2");
        this.ear_right = this.head.getChild("ear_right");
        this.ear_left = this.head.getChild("ear_left");
        this.nose = this.head.getChild("nose");
        this.snout = this.head.getChild("snout");
        this.mouth = this.snout.getChild("mouth");
        this.thigh_right_front = this.body_front.getChild("thigh_right_front");
        this.leg_right_front = this.thigh_right_front.getChild("leg_right_front");
        this.thigh_left_front = this.body_front.getChild("thigh_left_front");
        this.leg_left_front = this.thigh_left_front.getChild("leg_left_front");
        this.body_rear = this.body_center.getChild("body_rear");
        this.thigh_right_rear = this.body_rear.getChild("thigh_right_rear");
        this.leg_right_rear = this.thigh_right_rear.getChild("leg_right_rear");
        this.thigh_left_rear = this.body_rear.getChild("thigh_left_rear");
        this.leg_left_rear = this.thigh_left_rear.getChild("leg_left_rear");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body_center = partDefinition.addOrReplaceChild("body_center", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, 0.0F, -3.0F, 9.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 1.0F, -0.091106186954104F, 0.0F, 0.0F));
        body_center.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 9.5F, 0.19634954084936207F, 0.0F, 0.0F));
        PartDefinition udder = body_center.addOrReplaceChild("udder", CubeListBuilder.create().texOffs(31, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.7F, 3.0F, -0.091106186954104F, 0.0F, 0.0F));
        udder.addOrReplaceChild("teat_right_front", CubeListBuilder.create().texOffs(31, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.5F, -1.5F, 0.045553093477052F, 0.0F, 0.0F));
        udder.addOrReplaceChild("teat_left_front", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, -1.5F, 0.045553093477052F, 0.0F, 0.0F));
        udder.addOrReplaceChild("teat_right_rear", CubeListBuilder.create().texOffs(49, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.5F, 0.9F, 0.045553093477052F, 0.0F, 0.0F));
        udder.addOrReplaceChild("teat_left_rear", CubeListBuilder.create().texOffs(53, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 0.9F, 0.045553093477052F, 0.0F, 0.0F));
        PartDefinition body_front = body_center.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(85, 0).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7F, -7.0F, 0.091106186954104F, 0.0F, 0.0F));
        PartDefinition back_front = body_front.addOrReplaceChild("back_front", CubeListBuilder.create().texOffs(18, 21).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.27314402793711257F, 0.0F, 0.0F));
        back_front.addOrReplaceChild("back_rear", CubeListBuilder.create().texOffs(85, 28).addBox(-1.0F, 0.0F, -3.2F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7F, 5.0F, 0.091106186954104F, 0.0F, 0.0F));
        PartDefinition neck = body_front.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(46, 27).addBox(-3.5F, -3.5F, -4.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, -1.0F, -0.39269908169872414F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 31).addBox(-3.0F, -3.5F, -6.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -2.5F, 0.39269908169872414F, 0.0F, 0.0F));
        PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(79, 37).addBox(-2.5F, -1.0F, -2.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -3.5F, -0.091106186954104F, 0.0F, 0.0F));
        PartDefinition horn_right = hair.addOrReplaceChild("horn_right", CubeListBuilder.create().texOffs(97, 30).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.1F, 0.0F, 0.0F, -0.27314402793711257F, -0.4553564018453205F));
        PartDefinition H0R0 = horn_right.addOrReplaceChild("H0R0", CubeListBuilder.create().texOffs(41, 8).addBox(-4.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.0F, 1.9F, 0.0F, -0.7285004297824331F, -0.136659280431156F));
        PartDefinition H0R1 = H0R0.addOrReplaceChild("H0R1", CubeListBuilder.create().texOffs(0, 7).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.6F, 0.0F, -0.5462880558742251F, -0.136659280431156F));
        H0R1.addOrReplaceChild("H0R2", CubeListBuilder.create().texOffs(49, 2).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.6F, 0.0F, -0.5462880558742251F, -0.136659280431156F));
        PartDefinition horn_left = hair.addOrReplaceChild("horn_left", CubeListBuilder.create().texOffs(30, 31).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.1F, 0.0F, 0.0F, -0.27314402793711257F, -2.6720990848033184F));
        PartDefinition H1L0 = horn_left.addOrReplaceChild("H1L0", CubeListBuilder.create().texOffs(113, 17).addBox(-4.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.0F, 1.9F, 0.0F, -0.7285004297824331F, 0.136659280431156F));
        PartDefinition H1L1 = H1L0.addOrReplaceChild("H1L1", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.6F, 0.0F, -0.5462880558742251F, 0.136659280431156F));
        H1L1.addOrReplaceChild("H1L2", CubeListBuilder.create().texOffs(44, 12).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.6F, 0.0F, -0.5462880558742251F, 0.136659280431156F));
        head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(80, 0).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, 0.5F, -2.0F, 0.18203784098300857F, 0.0F, -0.39269908169872414F));
        head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(119, 6).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, 0.5F, -2.0F, 0.18203784098300857F, 0.0F, 0.39269908169872414F));
        head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(112, 0).addBox(-1.5F, -5.5F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3F, -2.0F, 0.6373942428283291F, 0.0F, 0.0F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(101, 35).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -5.0F, 0.19634954084936207F, 0.0F, 0.0F));
        snout.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(31, 8).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.5F, 0.19634954084936207F, 0.0F, 0.0F));
        PartDefinition thigh_right_front = body_front.addOrReplaceChild("thigh_right_front", CubeListBuilder.create().texOffs(100, 17).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 3.0F, -0.8F, 0.091106186954104F, 0.0F, 0.0F));
        thigh_right_front.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(73, 26).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.7F, 1.2F, -0.18203784098300857F, 0.0F, 0.0F));
        PartDefinition thigh_left_front = body_front.addOrReplaceChild("thigh_left_front", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, 0.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, -0.8F, 0.091106186954104F, 0.0F, 0.0F));
        thigh_left_front.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(115, 27).addBox(0.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.7F, 1.2F, -0.18203784098300857F, 0.0F, 0.0F));
        PartDefinition body_rear = body_center.addOrReplaceChild("body_rear", CubeListBuilder.create().texOffs(55, 0).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 7.0F, 0.091106186954104F, 0.0F, 0.0F));
        PartDefinition thigh_right_rear = body_rear.addOrReplaceChild("thigh_right_rear", CubeListBuilder.create().texOffs(44, 15).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.9F, -0.1F, -0.091106186954104F, 0.0F, 0.0F));
        thigh_right_rear.addOrReplaceChild("leg_right_rear", CubeListBuilder.create().texOffs(76, 15).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.7F, 0.2F, 0.18203784098300857F, 0.0F, 0.0F));
        PartDefinition thigh_left_rear = body_rear.addOrReplaceChild("thigh_left_rear", CubeListBuilder.create().texOffs(60, 15).addBox(0.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.9F, -0.1F, -0.091106186954104F, 0.0F, 0.0F));
        thigh_left_rear.addOrReplaceChild("leg_left_rear", CubeListBuilder.create().texOffs(88, 17).addBox(0.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.7F, 0.2F, 0.18203784098300857F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 64);
    }

    @Override
    public void setupAnim(CatoblepasEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        if (this.young) {
            pPoseStack.pushPose();
            pPoseStack.scale(0.5F, 0.5F, 0.5F);
            pPoseStack.translate(0.0F, 1.5F, 0.0F);
            this.horn_right.visible = false;
            this.horn_left.visible = false;
            this.body_center.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        } else {
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, 1.0F, 1.0F);
            pPoseStack.translate(0.0F, 0.0F, 0.0F);
            this.horn_right.visible = true;
            this.horn_left.visible = true;
            this.body_center.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        }
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.head.xRot = pHeadPitch * 0.017453292F + 0.39269908169872414F;
        this.head.yRot = pNetHeadYaw * 0.017453292F;
        this.head.zRot = pNetHeadYaw * 0.0045F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        pLimbSwing *= 1.8;

        this.thigh_right_front.xRot = Mth.cos(pLimbSwing * 0.5F) * 0.9F * pLimbSwingAmount + 0.091106186954104F;
        this.leg_right_front.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing)) * 0.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount - 0.18203784098300857F;
        this.thigh_left_front.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI) * 0.9F * pLimbSwingAmount + 0.091106186954104F;
        this.leg_left_front.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.5F)) * 0.5F + (float) Math.PI) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount - 0.18203784098300857F;
        this.thigh_right_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 1.5F) * 0.9F * pLimbSwingAmount - 0.091106186954104F;
        this.leg_right_rear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.75F)) * 0.5F + (float) Math.PI * 1.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount + 0.18203784098300857F;
        this.thigh_left_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 0.5F) * 0.9F * pLimbSwingAmount - 0.091106186954104F;
        this.leg_left_rear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + (float) Math.PI * 0.25F)) * 0.5F + (float) Math.PI * 0.5F) * kneebend * pLimbSwingAmount + kneebend * pLimbSwingAmount + 0.18203784098300857F;
    }
}
