package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.MyrmekeDroneEntity;
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

public class MyrmekeDroneModel extends EntityModel<MyrmekeDroneEntity> {
    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "myrmeke_drone"), "main");

    public ModelPart body_head;
    public ModelPart head;
    public ModelPart body_thorax;
    public ModelPart thorax;
    public ModelPart body_abdomen;
    public ModelPart abdomen;
    public ModelPart leg_right_front;
    public ModelPart leg_right_center;
    public ModelPart leg_right_rear;
    public ModelPart leg_left_front;
    public ModelPart leg_left_center;
    public ModelPart leg_left_rear;

    public MyrmekeDroneModel(ModelPart pModelPart) {
        this.body_head = pModelPart.getChild("body_head");
        this.head = this.body_head.getChild("head");
        this.body_thorax = pModelPart.getChild("body_thorax");
        this.thorax = pModelPart.getChild("thorax");
        this.body_abdomen = pModelPart.getChild("body_abdomen");
        this.abdomen = this.thorax.getChild("abdomen");
        this.leg_right_front = pModelPart.getChild("leg_right_front");
        this.leg_right_center = pModelPart.getChild("leg_right_center");
        this.leg_right_rear = pModelPart.getChild("leg_right_rear");
        this.leg_left_front = pModelPart.getChild("leg_left_front");
        this.leg_left_center = pModelPart.getChild("leg_left_center");
        this.leg_left_rear = pModelPart.getChild("leg_left_rear");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body_head = partDefinition.addOrReplaceChild("body_head", CubeListBuilder.create().texOffs(37, 9).addBox(-1.5F, -0.7F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 32).addBox(-1.5F, -0.7F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.2F, -4.0F));
        body_head.addOrReplaceChild("B0H0", CubeListBuilder.create().texOffs(22, 32).addBox(-1.999F, 0.8727F, -1.5469F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.9539F, -0.6313F, 0.2182F, 0.0F, 0.0F));
        body_head.addOrReplaceChild("B1H1", CubeListBuilder.create().texOffs(32, 16).addBox(-2.001F, 1.6481F, -0.0735F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.9539F, -0.6313F, -0.7418F, 0.0F, 0.0F));
        PartDefinition head = body_head.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 21).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 12).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(18, 4).addBox(-2.5F, -0.5F, -3.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -2.0F, 0.2618F, 0.0F, 0.0F));
        head.addOrReplaceChild("mandible_left", CubeListBuilder.create().texOffs(23, 37).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.3F, -5.0F, 0.0F, 0.1309F, 0.0F));
        head.addOrReplaceChild("mandible_right", CubeListBuilder.create().texOffs(36, 27).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.3F, -5.0F, 0.0F, -0.1309F, 0.0F));
        head.addOrReplaceChild("antenna_left", CubeListBuilder.create().texOffs(15, 37).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 26).addBox(-0.5F, -4.5F, -4.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.3F, -4.0F, 0.1745F, 0.0F, 0.4363F));
        head.addOrReplaceChild("antenna_right", CubeListBuilder.create().texOffs(19, 37).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(26, 17).addBox(-0.5F, -4.5F, -4.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.3F, -4.0F, 0.1745F, 0.0F, -0.4363F));
        head.addOrReplaceChild("H0", CubeListBuilder.create().texOffs(12, 31).addBox(-2.0F, -2.032F, -0.6473F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.3033F, -3.6881F, -1.2217F, 0.0F, 0.0F));
        PartDefinition body_thorax = partDefinition.addOrReplaceChild("body_thorax", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -1.3571F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.3571F, -2.0F));
        body_thorax.addOrReplaceChild("B1T0", CubeListBuilder.create().texOffs(13, 8).addBox(-7.0F, -6.3F, -5.8F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 5.6429F, 4.0F));
        body_thorax.addOrReplaceChild("B1T1", CubeListBuilder.create().texOffs(13, 0).addBox(-7.0F, -6.3F, -5.5F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 5.6429F, 6.0F));
        body_thorax.addOrReplaceChild("B1T2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.9517F, -1.5942F, -5.2266F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.999F, 0.5371F, -2.2048F, 0.0F, 1.0908F, 0.0F));
        body_thorax.addOrReplaceChild("B1T3", CubeListBuilder.create().texOffs(35, 37).addBox(-6.6527F, -1.5942F, -0.8316F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.999F, 0.5371F, -2.2048F, 0.0F, 1.0908F, 0.0F));
        body_thorax.addOrReplaceChild("B1T4", CubeListBuilder.create().texOffs(29, 37).addBox(0.9597F, -1.5942F, 6.2627F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.999F, 0.5371F, -2.2048F, 0.0F, -1.0908F, 0.0F));
        body_thorax.addOrReplaceChild("B1T5", CubeListBuilder.create().texOffs(0, 8).addBox(-1.7414F, -1.5942F, 1.8677F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.999F, 0.5371F, -2.2048F, 0.0F, -1.0908F, 0.0F));
        PartDefinition thorax = partDefinition.addOrReplaceChild("thorax", CubeListBuilder.create().texOffs(0, 33).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.5F, 3.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition body_abdomen = partDefinition.addOrReplaceChild("body_abdomen", CubeListBuilder.create().texOffs(0, 21).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.5F, 0.0F));
        body_abdomen.addOrReplaceChild("B2A0", CubeListBuilder.create().texOffs(21, 23).addBox(-1.499F, -4.8955F, -6.9095F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5F, 6.0F, -0.1745F, 0.0F, 0.0F));
        body_abdomen.addOrReplaceChild("B2A1", CubeListBuilder.create().texOffs(16, 17).addBox(-6.5F, -6.501F, -6.2F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 5.5F, 7.0F));
        PartDefinition abdomen = thorax.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.6142F, -0.1142F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 8).addBox(-2.001F, 2.0929F, 0.5929F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.3F, 0.7F));
        abdomen.addOrReplaceChild("A0", CubeListBuilder.create().texOffs(32, 19).addBox(-2.002F, 0.4142F, -1.2929F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3F, 1.8F, -0.7854F, 0.0F, 0.0F));
        abdomen.addOrReplaceChild("A1", CubeListBuilder.create().texOffs(27, 10).addBox(-1.997F, -1.7375F, -0.8078F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3F, 4.8F, -0.48F, 0.0F, 0.0F));
        abdomen.addOrReplaceChild("A2", CubeListBuilder.create().texOffs(0, 26).addBox(-1.978F, -1.0698F, 0.0742F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.02F, 1.4921F, 3.8831F, -0.3491F, 0.0F, 0.0F));
        PartDefinition leg_right_front = partDefinition.addOrReplaceChild("leg_right_front", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 19.7F, -2.8F, 0.0F, 2.2253F, 0.0F));
        PartDefinition L0 = leg_right_front.addOrReplaceChild("L0", CubeListBuilder.create().texOffs(27, 7).addBox(-0.5F, -0.3F, -0.3F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.2F, 0.0F, 0.0F, -0.7854F));
        PartDefinition L1 = L0.addOrReplaceChild("L1", CubeListBuilder.create().texOffs(27, 0).addBox(0.6025F, -0.614F, -0.301F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
        PartDefinition L2 = L1.addOrReplaceChild("L2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
        L2.addOrReplaceChild("L2R0", CubeListBuilder.create().texOffs(7, 35).addBox(-0.2889F, -0.8F, -0.298F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0684F, 0.2189F, -0.002F, 0.0F, 0.0F, 0.1309F));
        PartDefinition leg_right_center = partDefinition.addOrReplaceChild("leg_right_center", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 19.7F, -0.5F, 0.0F, 3.1416F, 0.0F));
        PartDefinition L3 = leg_right_center.addOrReplaceChild("L3", CubeListBuilder.create().texOffs(30, 4).addBox(-0.5F, -0.3F, 0.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.5F, 0.0F, 0.0F, -0.7854F));
        PartDefinition L4 = L3.addOrReplaceChild("L4", CubeListBuilder.create().texOffs(18, 29).addBox(0.6025F, -0.614F, -0.001F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
        PartDefinition L5 = L4.addOrReplaceChild("L5", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
        L5.addOrReplaceChild("L5R0", CubeListBuilder.create().texOffs(31, 35).addBox(-0.2889F, -0.8F, 0.002F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0684F, 0.2189F, -0.002F, 0.0F, 0.0F, 0.1309F));
        PartDefinition leg_right_rear = partDefinition.addOrReplaceChild("leg_right_rear", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 19.7F, 1.7F, 0.0F, -2.618F, 0.0F));
        PartDefinition L6 = leg_right_rear.addOrReplaceChild("L6", CubeListBuilder.create().texOffs(26, 27).addBox(-0.5F, -0.3F, 0.2F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.7F, 0.0F, 0.0F, -0.7854F));
        PartDefinition L7 = L6.addOrReplaceChild("L7", CubeListBuilder.create().texOffs(14, 27).addBox(0.6025F, -0.614F, 0.21F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
        PartDefinition L8 = L7.addOrReplaceChild("L8", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
        L8.addOrReplaceChild("L8R0", CubeListBuilder.create().texOffs(15, 35).addBox(-0.2889F, -0.8F, 0.202F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0684F, 0.2189F, -0.002F, 0.0F, 0.0F, 0.1309F));
        PartDefinition leg_left_front = partDefinition.addOrReplaceChild("leg_left_front", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 19.7F, -2.8F, 0.0F, 0.829F, 0.0F));
        PartDefinition L9 = leg_left_front.addOrReplaceChild("L9", CubeListBuilder.create().texOffs(0, 31).addBox(-0.5F, -0.3F, -0.3F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.2F, 0.0F, 0.0F, -0.7854F));
        PartDefinition L10 = L9.addOrReplaceChild("L10", CubeListBuilder.create().texOffs(29, 30).addBox(0.6025F, -0.614F, -0.301F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
        PartDefinition L11 = L10.addOrReplaceChild("L11", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
        L11.addOrReplaceChild("L11R0", CubeListBuilder.create().texOffs(7, 37).addBox(-0.2889F, -0.8F, -0.298F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0684F, 0.2189F, -0.002F, 0.0F, 0.0F, 0.1309F));
        PartDefinition leg_left_center = partDefinition.addOrReplaceChild("leg_left_center", CubeListBuilder.create(), PartPose.offset(3.0F, 19.7F, -0.5F));
        PartDefinition L12 = leg_left_center.addOrReplaceChild("L12", CubeListBuilder.create().texOffs(30, 24).addBox(-0.5F, -0.3F, 0.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.5F, 0.0F, 0.0F, -0.7854F));
        PartDefinition L13 = L12.addOrReplaceChild("L13", CubeListBuilder.create().texOffs(30, 22).addBox(0.6025F, -0.614F, -0.001F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
        PartDefinition L14 = L13.addOrReplaceChild("L14", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
        L14.addOrReplaceChild("L14R0", CubeListBuilder.create().texOffs(0, 36).addBox(-0.2889F, -0.8F, 0.002F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0684F, 0.2189F, -0.002F, 0.0F, 0.0F, 0.1309F));
        PartDefinition leg_left_rear = partDefinition.addOrReplaceChild("leg_left_rear", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 19.7F, 1.7F, 0.0F, -0.4363F, 0.0F));
        PartDefinition L15 = leg_left_rear.addOrReplaceChild("L15", CubeListBuilder.create().texOffs(29, 14).addBox(-0.5F, -0.3F, 0.2F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -0.7F, 0.0F, 0.0F, -0.7854F));
        PartDefinition L16 = L15.addOrReplaceChild("L16", CubeListBuilder.create().texOffs(29, 2).addBox(0.6025F, -0.614F, 0.21F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7453F));
        PartDefinition L17 = L16.addOrReplaceChild("L17", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
        L17.addOrReplaceChild("L17R0", CubeListBuilder.create().texOffs(23, 35).addBox(-0.2889F, -0.8F, 0.202F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0684F, 0.2189F, -0.002F, 0.0F, 0.0F, 0.1309F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(MyrmekeDroneEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.body_head.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.body_thorax.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.body_abdomen.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.thorax.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.leg_right_front.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.leg_right_center.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.leg_right_rear.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.leg_left_front.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.leg_left_center.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        this.leg_left_rear.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.head.xRot = 0.39269908169872414F + pHeadPitch * 0.017453292F;
        this.head.yRot = pNetHeadYaw * 0.017453292F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        float f0 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * pLimbSwingAmount;
        float f1 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * pLimbSwingAmount;
        float f2 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * pLimbSwingAmount;
        float f3 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * pLimbSwingAmount;
        float f4 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + 0.0F) * 0.4F) * pLimbSwingAmount;
        float f5 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + (float)Math.PI) * 0.4F) * pLimbSwingAmount;
        float f6 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * pLimbSwingAmount;
        float f7 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * pLimbSwingAmount;

        this.leg_right_front.yRot = 2.1205750411731104F + f3 * 2;
        this.leg_right_center.yRot = 3.141592653589793F + f1 * 2;
        this.leg_right_rear.yRot = -2.356194490192345F + f0 * 2;
        this.leg_left_front.yRot = 1.0210176124166828F - f4 * 2;
        this.leg_left_center.yRot = -0.0F - f2 * 2;
        this.leg_left_rear.yRot = -0.7853981633974483F - f1 * 2;
        this.leg_right_front.zRot = 0F + f7 * 2;
        this.leg_right_center.zRot = 0F + f5 * 2;
        this.leg_right_rear.zRot = 0F + f4 * 2;
        this.leg_left_front.zRot = -0F - f0 * 2;
        this.leg_left_center.zRot = -0F - f6 * 2;
        this.leg_left_rear.zRot = -0F - f5 * 2;
    }
}
