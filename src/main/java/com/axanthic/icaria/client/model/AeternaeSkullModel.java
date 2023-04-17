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

public class AeternaeSkullModel extends SkullModel {
    public ModelPart head;

    public AeternaeSkullModel(ModelPart pModelPart) {
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

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, -4.0F, -3.5F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(19, 22).addBox(-2.0F, 18.5F, 4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.096F, -11.4914F));
        head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, 21.0425F, 4.0354F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.7961F, -11.4914F, 0.0456F, 0.0F, 0.0F));
        head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(78, 25).addBox(-1.0F, 8.8924F, 20.5061F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -24.7961F, -6.4914F, -0.7854F, 0.0F, 0.0F));
        head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(56, 24).addBox(0.0F, 8.8924F, 20.5061F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -24.7961F, -6.4914F, -0.7854F, 0.0F, 0.0F));
        PartDefinition hornRightAdult = head.addOrReplaceChild("hornRightAdult", CubeListBuilder.create().texOffs(90, 25).addBox(-6.665F, 15.4391F, 11.5286F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.525F, -24.5461F, -8.9914F, -0.182F, 0.0F, -0.2731F));
        PartDefinition hornRightAdultLower = hornRightAdult.addOrReplaceChild("hornRightAdultLower", CubeListBuilder.create().texOffs(119, 18).addBox(-5.8194F, 8.7047F, 18.5681F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.4554F, 0.0F, 0.0456F));
        PartDefinition hornRightAdultCenter = hornRightAdultLower.addOrReplaceChild("hornRightAdultCenter", CubeListBuilder.create().texOffs(61, 0).addBox(-5.2814F, -0.4677F, 21.9148F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.4554F, 0.0F, 0.0456F));
        hornRightAdultCenter.addOrReplaceChild("hornRightAdultUpper", CubeListBuilder.create().texOffs(49, 0).addBox(-5.1617F, -12.0571F, 20.1408F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, 0.0456F));
        PartDefinition hornLeftAdult = head.addOrReplaceChild("hornLeftAdult", CubeListBuilder.create().texOffs(39, 23).addBox(5.665F, 15.4391F, 11.5286F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.525F, -24.5461F, -8.9914F, -0.182F, 0.0F, 0.2731F));
        PartDefinition hornLeftAdultLower = hornLeftAdult.addOrReplaceChild("hornLeftAdultLower", CubeListBuilder.create().texOffs(116, 10).addBox(4.8194F, 8.7047F, 18.5681F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.4554F, 0.0F, -0.0456F));
        PartDefinition hornLeftAdultCenter = hornLeftAdultLower.addOrReplaceChild("hornLeftAdultCenter", CubeListBuilder.create().texOffs(43, 0).addBox(4.2814F, -0.4677F, 21.9148F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.4554F, 0.0F, -0.0456F));
        hornLeftAdultCenter.addOrReplaceChild("hornLeftAdultUpper", CubeListBuilder.create().texOffs(30, 0).addBox(4.1617F, -12.0571F, 20.1408F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, -0.0456F));

        return LayerDefinition.create(meshDefinition, 128, 48);
    }
}
