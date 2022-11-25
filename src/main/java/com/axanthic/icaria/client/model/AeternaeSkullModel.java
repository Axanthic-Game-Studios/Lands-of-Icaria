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

public class AeternaeSkullModel extends SkullModel {
    public static ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID, "aeternae_skull"), "main");

    public ModelPart head;

    public AeternaeSkullModel(ModelPart pModelPart) {
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

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, -2.5F, -3.5F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));
        head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(19, 22).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -3.5F));
        head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -0.3F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -3.5F, 0.045553093477052F, 0.0F, 0.0F));
        head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(56, 24).addBox(-1.0F, -0.3F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.2F, 1.5F, -0.7853981633974483F, 0.0F, 0.0F));
        head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(78, 25).addBox(0.0F, -0.3F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.2F, 1.5F, -0.7853981633974483F, 0.0F, 0.0F));
        PartDefinition horn_right_big = head.addOrReplaceChild("horn_right_big", CubeListBuilder.create().texOffs(39, 23).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0F, -1.0F, -0.18203784098300857F, 0.0F, -0.27314402793711257F));
        PartDefinition H0R0 = horn_right_big.addOrReplaceChild("H0R0", CubeListBuilder.create().texOffs(116, 10).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.4553564018453205F, 0.0F, -0.045553093477052F));
        PartDefinition H0R1 = H0R0.addOrReplaceChild("H0R1", CubeListBuilder.create().texOffs(43, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.4553564018453205F, 0.0F, -0.045553093477052F));
        H0R1.addOrReplaceChild("H0R2", CubeListBuilder.create().texOffs(30, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.5462880558742251F, 0.0F, -0.045553093477052F));
        PartDefinition horn_left_big = head.addOrReplaceChild("horn_left_big", CubeListBuilder.create().texOffs(90, 25).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.0F, -1.0F, -0.18203784098300857F, 0.0F, 0.27314402793711257F));
        PartDefinition H1L0 = horn_left_big.addOrReplaceChild("H1L0", CubeListBuilder.create().texOffs(119, 18).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.4553564018453205F, 0.0F, 0.045553093477052F));
        PartDefinition H1L1 = H1L0.addOrReplaceChild("H1L1", CubeListBuilder.create().texOffs(61, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.4553564018453205F, 0.0F, 0.045553093477052F));
        H1L1.addOrReplaceChild("H1L2", CubeListBuilder.create().texOffs(49, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.5462880558742251F, 0.0F, 0.045553093477052F));

        return LayerDefinition.create(meshDefinition, 128, 48);
    }
}
