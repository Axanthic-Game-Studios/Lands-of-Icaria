package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.SowEntity;
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

public class SowModel extends EntityModel<SowEntity> {
    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "sow"), "main");

    public ModelPart body_front;
    public ModelPart muscle_front;
    public ModelPart leg_right_front;
    public ModelPart leg_left_front;
    public ModelPart muscle_rear;
    public ModelPart leg_right_rear;
    public ModelPart leg_left_rear;
    public ModelPart body_rear;
    public ModelPart tail;
    public ModelPart head;
    public ModelPart ear_right;
    public ModelPart ear_left;
    public ModelPart hair_front;
    public ModelPart hair_rear;
    public ModelPart jaw;
    public ModelPart nose;
    public ModelPart tusk_right;
    public ModelPart tusk_left;

    public SowModel(ModelPart pModelPart) {
        this.body_front = pModelPart.getChild("body_front");
        this.muscle_front = this.body_front.getChild("muscle_front");
        this.leg_right_front = this.muscle_front.getChild("leg_right_front");
        this.leg_left_front = this.muscle_front.getChild("leg_left_front");
        this.muscle_rear = this.body_front.getChild("muscle_rear");
        this.leg_right_rear = this.muscle_rear.getChild("leg_right_rear");
        this.leg_left_rear = this.muscle_rear.getChild("leg_left_rear");
        this.body_rear = this.body_front.getChild("body_rear");
        this.tail = this.body_rear.getChild("tail");
        this.head = this.body_front.getChild("head");
        this.ear_right = this.head.getChild("ear_right");
        this.ear_left = this.head.getChild("ear_left");
        this.hair_front = this.head.getChild("hair_front");
        this.hair_rear = this.hair_front.getChild("hair_rear");
        this.jaw = this.head.getChild("jaw");
        this.nose = this.head.getChild("nose");
        this.tusk_right = this.nose.getChild("tusk_right");
        this.tusk_left = this.nose.getChild("tusk_left");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body_front = partDefinition.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.5F, -7.0F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, -0.091106186954104F, 0.0F, 0.0F));
        PartDefinition muscle_front = body_front.addOrReplaceChild("muscle_front", CubeListBuilder.create().texOffs(0, 19).addBox(-5.0F, -4.5F, -7.0F, 10.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.25F, 0.5F, 0.091106186954104F, 0.0F, 0.0F));
        muscle_front.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(22, 34).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -0.25F, -5.0F));
        muscle_front.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(48, 9).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -0.25F, -5.0F));
        PartDefinition muscle_rear = body_front.addOrReplaceChild("muscle_rear", CubeListBuilder.create().texOffs(24, 25).addBox(-4.5F, -4.5F, 1.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.25F, 0.9F, 0.091106186954104F, 0.0F, 0.0F));
        muscle_rear.addOrReplaceChild("leg_right_rear", CubeListBuilder.create().texOffs(34, 36).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -0.25F, 3.0F));
        muscle_rear.addOrReplaceChild("leg_left_rear", CubeListBuilder.create().texOffs(46, 36).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -0.25F, 3.0F));
        PartDefinition body_rear = body_front.addOrReplaceChild("body_rear", CubeListBuilder.create().texOffs(27, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 4.0F, -0.15533430342749532F, 0.0F, 0.0F));
        body_rear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, 0.5918411493512771F, 0.0F, 0.0F));
        PartDefinition head = body_front.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 11).addBox(-2.5F, -3.0F, -7.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -5.0F, 0.17453292519943295F, 0.0F, 0.0F));
        head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(47, 6).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -0.4F, -2.5F, 0.36425021489121656F, 0.0F, 2.0943951023931953F));
        head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(55, 6).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -0.4F, -2.5F, -0.36425021489121656F, 0.0F, 1.0471975511965976F));
        PartDefinition hair_front = head.addOrReplaceChild("hair_front", CubeListBuilder.create().texOffs(42, 26).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -4.1F, 0.00942477796076938F, 0.0F, 0.0F));
        hair_front.addOrReplaceChild("hair_rear", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.01F, -2.0F, 5.0F, -0.39269908169872414F, 0.0F, 0.0F));
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -8.0F));
        PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(47, 0).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, 0.18203784098300857F, 0.0F, 0.0F));
        nose.addOrReplaceChild("tusk_right", CubeListBuilder.create().texOffs(47, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.5F, -2.2F, 0.0F, 0.0F, -0.39269908169872414F));
        nose.addOrReplaceChild("tusk_left", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, -2.2F, 0.0F, 0.0F, 0.39269908169872414F));

        return LayerDefinition.create(meshDefinition, 64, 48);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        if (this.young) {
            pPoseStack.pushPose();
            pPoseStack.scale(0.5F, 0.5F, 0.5F);
            pPoseStack.translate(0.0F, 1.5F, 0.0F);
            this.tusk_right.visible = false;
            this.tusk_left.visible = false;
            this.body_front.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        } else {
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, 1.0F, 1.0F);
            pPoseStack.translate(0.0F, 0.0F, 0.0F);
            this.tusk_right.visible = true;
            this.tusk_left.visible = true;
            this.body_front.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        }
    }

    @Override
    public void setupAnim(SowEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.head.xRot = pHeadPitch * 0.017453292F + 0.17453292519943295F;
        this.head.yRot = pNetHeadYaw * 0.005F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        pLimbSwing *= 1.8;

        this.leg_right_front.xRot = Mth.cos(pLimbSwing * 0.5F) * 0.9F * pLimbSwingAmount;
        this.leg_left_front.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI) * 0.9F * pLimbSwingAmount;
        this.leg_right_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 1.5F) * 0.9F * pLimbSwingAmount;
        this.leg_left_rear.xRot = Mth.cos(pLimbSwing * 0.5F + (float) Math.PI * 0.5F) * 0.9F * pLimbSwingAmount;
    }
}
