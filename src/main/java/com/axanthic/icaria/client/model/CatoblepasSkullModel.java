package com.axanthic.icaria.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasSkullModel extends SkullModel {
    public ModelPart head;

    public CatoblepasSkullModel(ModelPart pModelPart) {
        super(pModelPart);
        this.head = pModelPart.getChild("head");
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, int pColor) {
        this.head.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
    }

    @Override
    public void setupAnim(float pX, float pY, float pZ) {
        this.head.xRot = pZ * (Mth.PI / 180.0F);
        this.head.yRot = pY * (Mth.PI / 180.0F);
    }

    public static LayerDefinition createLayer() {
        var meshDefinition = new MeshDefinition();
        var partDefinition = meshDefinition.getRoot();

        var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 31).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(79, 37).addBox(-2.5F, -1.15F, -3.05F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.4984F, 0.5836F, -0.0873F, 0.0F, 0.0F));
        head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(112, 0).addBox(-1.5F, -5.5F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1984F, 1.0836F, 0.6374F, 0.0F, 0.0F));
        head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(101, 35).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4984F, -1.9164F, 0.1963F, 0.0F, 0.0F));
        head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(31, 8).addBox(-1.5F, -0.9048F, -4.0351F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3678F, -1.2054F, 0.3927F, 0.0F, 0.0F));
        head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(119, 6).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, -2.9984F, 1.0836F, 0.182F, 0.0F, -0.3927F));
        head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(80, 0).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, -2.9984F, 1.0836F, 0.182F, 0.0F, 0.3927F));
        var hornRightAdult = head.addOrReplaceChild("hornRightAdult", CubeListBuilder.create().texOffs(97, 30).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -6.5984F, -0.4164F, 0.0F, 0.2731F, 2.6721F));
        var hornRightAdultInner = hornRightAdult.addOrReplaceChild("hornRightAdultInner", CubeListBuilder.create().texOffs(41, 8).addBox(0.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, 0.0F, 1.9F, 0.0F, 0.7285F, -0.1367F));
        var hornRightAdultCenter = hornRightAdultInner.addOrReplaceChild("hornRightAdultCenter", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.6F, 0.0F, 0.5463F, -0.1367F));
        hornRightAdultCenter.addOrReplaceChild("hornRightAdultOuter", CubeListBuilder.create().texOffs(49, 2).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.6F, 0.0F, 0.5463F, -0.1367F));
        var hornLeftAdult = head.addOrReplaceChild("hornLeftAdult", CubeListBuilder.create().texOffs(30, 31).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -6.5984F, -0.4164F, 0.0F, 0.2731F, 0.4554F));
        var hornLeftAdultInner = hornLeftAdult.addOrReplaceChild("hornLeftAdultInner", CubeListBuilder.create().texOffs(113, 17).addBox(0.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, 0.0F, 1.9F, 0.0F, 0.7285F, 0.1367F));
        var hornLeftAdultCenter = hornLeftAdultInner.addOrReplaceChild("hornLeftAdultCenter", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.6F, 0.0F, 0.5463F, 0.1367F));
        hornLeftAdultCenter.addOrReplaceChild("hornLeftAdultOuter", CubeListBuilder.create().texOffs(44, 12).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.6F, 0.0F, 0.5463F, 0.1367F));

        return LayerDefinition.create(meshDefinition, 128, 64);
    }
}
