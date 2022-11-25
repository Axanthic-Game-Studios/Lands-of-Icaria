package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasSkullModel extends SkullModel {
    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "catoblepas_skull"), "main");

    public ModelPart head;

    public CatoblepasSkullModel(ModelPart pModelPart) {
        super(pModelPart);
        this.head = pModelPart.getChild("head");
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.head.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    @Override
    public void setupAnim(float x, float y, float z) {
        this.head.xRot = z * ((float)Math.PI / 180F);
        this.head.yRot = y * ((float)Math.PI / 180F);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 31).addBox(-3.0F, -3.5F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.7F, 0.0F, -0.136659280431156F, 0.0F, 0.0F));
        PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(79, 37).addBox(-2.5F, -1.0F, -2.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -0.5F, -0.091106186954104F, 0.0F, 0.0F));
        PartDefinition horn_right = hair.addOrReplaceChild("horn_right", CubeListBuilder.create().texOffs(97, 30).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.1F, 0.0F, 0.0F, -0.27314402793711257F, -0.4553564018453205F));
        PartDefinition H0R0 = horn_right.addOrReplaceChild("H0R0", CubeListBuilder.create().texOffs(41, 8).addBox(-4.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.0F, 1.9F, 0.0F, -0.7285004297824331F, -0.136659280431156F));
        PartDefinition H0R1 = H0R0.addOrReplaceChild("H0R1", CubeListBuilder.create().texOffs(0, 7).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.6F, 0.0F, -0.5462880558742251F, -0.136659280431156F));
        H0R1.addOrReplaceChild("H0R2", CubeListBuilder.create().texOffs(49, 2).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.6F, 0.0F, -0.5462880558742251F, -0.136659280431156F));
        PartDefinition horn_left = hair.addOrReplaceChild("horn_left", CubeListBuilder.create().texOffs(30, 31).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.1F, 0.0F, 0.0F, -0.27314402793711257F, -2.6720990848033184F));
        PartDefinition H1L0 = horn_left.addOrReplaceChild("H1L0", CubeListBuilder.create().texOffs(113, 17).addBox(-4.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.0F, 1.9F, 0.0F, -0.7285004297824331F, 0.136659280431156F));
        PartDefinition H1L1 = H1L0.addOrReplaceChild("H1L1", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.6F, 0.0F, -0.5462880558742251F, 0.136659280431156F));
        H1L1.addOrReplaceChild("H1L2", CubeListBuilder.create().texOffs(44, 12).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.6F, 0.0F, -0.5462880558742251F, 0.136659280431156F));
        head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(80, 0).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, 0.5F, 1.0F, 0.18203784098300857F, 0.0F, -0.39269908169872414F));
        head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(119, 6).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, 0.5F, 1.0F, 0.18203784098300857F, 0.0F, 0.39269908169872414F));
        head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(112, 0).addBox(-1.5F, -5.5F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3F, 1.0F, 0.6373942428283291F, 0.0F, 0.0F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(101, 35).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, 0.19634954084936207F, 0.0F, 0.0F));
        snout.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(31, 8).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.5F, 0.19634954084936207F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 64);
    }
}
