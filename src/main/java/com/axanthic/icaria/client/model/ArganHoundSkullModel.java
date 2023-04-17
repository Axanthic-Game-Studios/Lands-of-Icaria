package com.axanthic.icaria.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArganHoundSkullModel extends SkullModel {
    public ModelPart head;

    public ArganHoundSkullModel(ModelPart pModelPart) {
        super(pModelPart);
        this.head = pModelPart.getChild("head");
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.head.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    @Override
    public void setupAnim(float pX, float pY, float pZ) {
        this.head.xRot = pZ * (Mth.PI / 180.0F);
        this.head.yRot = pY * (Mth.PI / 180.0F);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 48).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(43, 46).addBox(-2.0F, -1.025F, -4.925F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.9567F, -2.0744F));
        nose.addOrReplaceChild("teethRight", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0125F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.4625F, -2.925F, 0.7854F, 0.0F, 0.0F));
        nose.addOrReplaceChild("teethLeft", CubeListBuilder.create().texOffs(38, 9).addBox(-0.5125F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.025F, -0.4375F, -2.925F, 0.7854F, 0.0F, 0.0F));
        head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(24, 50).addBox(-1.5F, -0.5666F, -4.0116F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5442F, -2.6244F, 0.1367F, 0.0F, 0.0F));
        head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(0, 20).addBox(-1.5F, -6.0F, 1.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.425F, -1.2942F, 1.0006F, 0.3927F, 0.0F, -0.7854F));
        head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(0, 40).addBox(-1.5F, -6.0F, 1.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.55F, -1.3817F, 1.0006F, 0.3927F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
