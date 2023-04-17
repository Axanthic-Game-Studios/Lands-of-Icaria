package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.CatoblepasEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasModel extends HierarchicalModel<CatoblepasEntity> {
    public float kneebend = 0.9F;

    public CatoblepasEntity entity;

    public ModelPart root;
    public ModelPart head;
    public ModelPart skull;
    public ModelPart hornRightBaby;
    public ModelPart hornLeftBaby;
    public ModelPart hornRightKid;
    public ModelPart hornLeftKid;
    public ModelPart hornRightTeen;
    public ModelPart hornLeftTeen;
    public ModelPart hornRightAdult;
    public ModelPart hornLeftAdult;
    public ModelPart body;
    public ModelPart legRightFront;
    public ModelPart legRightFrontLower;
    public ModelPart legLeftFront;
    public ModelPart legLeftFrontLower;
    public ModelPart legRightRear;
    public ModelPart legRightRearLower;
    public ModelPart legLeftRear;
    public ModelPart legLeftRearLower;

    public CatoblepasModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.head = this.root.getChild("head");
        this.skull = this.head.getChild("skull");
        this.hornRightBaby = this.skull.getChild("hornRightBaby");
        this.hornLeftBaby = this.skull.getChild("hornLeftBaby");
        this.hornRightKid = this.skull.getChild("hornRightKid");
        this.hornLeftKid = this.skull.getChild("hornLeftKid");
        this.hornRightTeen = this.skull.getChild("hornRightTeen");
        this.hornLeftTeen = this.skull.getChild("hornLeftTeen");
        this.hornRightAdult = this.skull.getChild("hornRightAdult");
        this.hornLeftAdult = this.skull.getChild("hornLeftAdult");
        this.body = this.root.getChild("body");
        this.legRightFront = this.root.getChild("legRightFront");
        this.legRightFrontLower = this.legRightFront.getChild("legRightFrontLower");
        this.legLeftFront = this.root.getChild("legLeftFront");
        this.legLeftFrontLower = this.legLeftFront.getChild("legLeftFrontLower");
        this.legRightRear = this.root.getChild("legRightRear");
        this.legRightRearLower = this.legRightRear.getChild("legRightRearLower");
        this.legLeftRear = this.root.getChild("legLeftRear");
        this.legLeftRearLower = this.legLeftRear.getChild("legLeftRearLower");
    }

    @Override
    public void prepareMobModel(CatoblepasEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
        super.prepareMobModel(pEntity, pLimbSwing, pLimbSwingAmount, pPartialTick);
        this.entity = pEntity;
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        if (this.entity.getSize() < 2) {
            pPoseStack.pushPose();
            this.hornRightBaby.visible = true;
            this.hornLeftBaby.visible = true;
            this.hornRightKid.visible = false;
            this.hornLeftKid.visible = false;
            this.hornRightTeen.visible = false;
            this.hornLeftTeen.visible = false;
            this.hornRightAdult.visible = false;
            this.hornLeftAdult.visible = false;
            this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        } else if (this.entity.getSize() < 3) {
            pPoseStack.pushPose();
            this.hornRightBaby.visible = false;
            this.hornLeftBaby.visible = false;
            this.hornRightKid.visible = true;
            this.hornLeftKid.visible = true;
            this.hornRightTeen.visible = false;
            this.hornLeftTeen.visible = false;
            this.hornRightAdult.visible = false;
            this.hornLeftAdult.visible = false;
            this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        } else if (this.entity.getSize() < 4) {
            pPoseStack.pushPose();
            this.hornRightBaby.visible = false;
            this.hornLeftBaby.visible = false;
            this.hornRightKid.visible = false;
            this.hornLeftKid.visible = false;
            this.hornRightTeen.visible = true;
            this.hornLeftTeen.visible = true;
            this.hornRightAdult.visible = false;
            this.hornLeftAdult.visible = false;
            this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        } else {
            pPoseStack.pushPose();
            this.hornRightBaby.visible = false;
            this.hornLeftBaby.visible = false;
            this.hornRightKid.visible = false;
            this.hornLeftKid.visible = false;
            this.hornRightTeen.visible = false;
            this.hornLeftTeen.visible = false;
            this.hornRightAdult.visible = true;
            this.hornLeftAdult.visible = true;
            this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        }
    }

    @Override
    public void setupAnim(CatoblepasEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.lookAnim(pNetHeadYaw, pHeadPitch);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);
        this.animate(pEntity.attackAnimationState, IcariaAnimations.CATOBLEPAS_ATTACK, pAgeInTicks);
    }

    public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
        this.skull.xRot = pHeadPitch * 0.017453292F + 0.39269908169872414F;
        this.skull.yRot = pNetHeadYaw * 0.017453292F;
        this.skull.zRot = pNetHeadYaw * 0.0045F;
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        pLimbSwing *= 1.8;

        this.legRightFront.xRot = Mth.cos(pLimbSwing * 0.5F) * 0.9F * pLimbSwingAmount + 0.091106186954104F;
        this.legRightFrontLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing)) * 0.5F) * this.kneebend * pLimbSwingAmount + this.kneebend * pLimbSwingAmount - 0.18203784098300857F;
        this.legLeftFront.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI) * 0.9F * pLimbSwingAmount + 0.091106186954104F;
        this.legLeftFrontLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.5F)) * 0.5F + Mth.PI) * this.kneebend * pLimbSwingAmount + this.kneebend * pLimbSwingAmount - 0.18203784098300857F;
        this.legRightRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.5F) * 0.9F * pLimbSwingAmount - 0.091106186954104F;
        this.legRightRearLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * this.kneebend * pLimbSwingAmount + this.kneebend * pLimbSwingAmount + 0.18203784098300857F;
        this.legLeftRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.5F) * 0.9F * pLimbSwingAmount - 0.091106186954104F;
        this.legLeftRearLower.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * this.kneebend * pLimbSwingAmount + this.kneebend * pLimbSwingAmount + 0.18203784098300857F;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(46, 27).addBox(-3.5F, -4.1F, -4.65F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.416F, -6.2573F, -0.3927F, 0.0F, 0.0F));
        PartDefinition skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(12, 31).addBox(-3.0F, -3.5F, -6.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.25F, -3.0F, 0.3927F, 0.0F, 0.0F));
        skull.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(79, 37).addBox(-2.5F, -1.15F, -3.05F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -2.5F, -0.0873F, 0.0F, 0.0F));
        skull.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(112, 0).addBox(-1.5F, -5.5F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3F, -2.0F, 0.6374F, 0.0F, 0.0F));
        skull.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(101, 35).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -5.0F, 0.1963F, 0.0F, 0.0F));
        skull.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(31, 8).addBox(-1.5F, -0.9048F, -4.0351F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1306F, -4.289F, 0.3927F, 0.0F, 0.0F));
        skull.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(119, 6).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, 0.5F, -2.0F, 0.182F, 0.0F, -0.3927F));
        skull.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(80, 0).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, 0.5F, -2.0F, 0.182F, 0.0F, 0.3927F));
        PartDefinition hornRightBaby = skull.addOrReplaceChild("hornRightBaby", CubeListBuilder.create().texOffs(0, 7).addBox(6.3F, -0.5F, 1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, -6.0F, -3.225F, 0.0F, 0.2731F, 2.6721F));
        hornRightBaby.addOrReplaceChild("hornRightBabyOuter", CubeListBuilder.create().texOffs(49, 2).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 0.0F, 3.1F, 0.0F, 0.5463F, -0.1367F));
        PartDefinition hornLeftBaby = skull.addOrReplaceChild("hornLeftBaby", CubeListBuilder.create().texOffs(0, 10).addBox(6.3F, -0.5F, 1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.85F, -5.925F, -3.25F, 0.0F, 0.2731F, 0.4554F));
        hornLeftBaby.addOrReplaceChild("hornLeftBabyOuter", CubeListBuilder.create().texOffs(44, 12).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 0.0F, 3.1F, 0.0F, 0.5463F, 0.1367F));
        PartDefinition hornRightKid = skull.addOrReplaceChild("hornRightKid", CubeListBuilder.create().texOffs(0, 7).addBox(6.3F, -0.5F, 1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, -6.0F, -3.225F, 0.0F, 0.2731F, 2.6721F));
        hornRightKid.addOrReplaceChild("hornRightKidOuter", CubeListBuilder.create().texOffs(49, 2).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 0.0F, 3.1F, 0.0F, 0.5463F, -0.1367F));
        PartDefinition hornLeftKid = skull.addOrReplaceChild("hornLeftKid", CubeListBuilder.create().texOffs(0, 10).addBox(6.3F, -0.5F, 1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.85F, -5.925F, -3.25F, 0.0F, 0.2731F, 0.4554F));
        hornLeftKid.addOrReplaceChild("hornLeftKidOuter", CubeListBuilder.create().texOffs(44, 12).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 0.0F, 3.1F, 0.0F, 0.5463F, 0.1367F));
        PartDefinition hornRightTeen = skull.addOrReplaceChild("hornRightTeen", CubeListBuilder.create().texOffs(41, 8).addBox(2.8F, -0.5F, 0.4F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.625F, -4.425F, -3.6F, 0.0F, 0.2731F, 2.6721F));
        PartDefinition hornRightTeenCenter = hornRightTeen.addOrReplaceChild("hornRightTeenCenter", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3F, 0.0F, 2.5F, 0.0F, 0.5463F, -0.1367F));
        hornRightTeenCenter.addOrReplaceChild("hornRightTeenOuter", CubeListBuilder.create().texOffs(49, 2).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.6F, 0.0F, 0.5463F, -0.1367F));
        PartDefinition hornLeftTeen = skull.addOrReplaceChild("hornLeftTeen", CubeListBuilder.create().texOffs(113, 17).addBox(2.8F, -0.5F, 0.4F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.675F, -4.375F, -3.625F, 0.0F, 0.2731F, 0.4554F));
        PartDefinition hornLeftTeenCenter = hornLeftTeen.addOrReplaceChild("hornLeftTeenCenter", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3F, 0.0F, 2.5F, 0.0F, 0.5463F, 0.1367F));
        hornLeftTeenCenter.addOrReplaceChild("hornLeftTeenOuter", CubeListBuilder.create().texOffs(44, 12).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.6F, 0.0F, 0.5463F, 0.1367F));
        PartDefinition hornRightAdult = skull.addOrReplaceChild("hornRightAdult", CubeListBuilder.create().texOffs(97, 30).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.1F, -3.5F, 0.0F, 0.2731F, 2.6721F));
        PartDefinition hornRightAdultInner = hornRightAdult.addOrReplaceChild("hornRightAdultInner", CubeListBuilder.create().texOffs(41, 8).addBox(0.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, 0.0F, 1.9F, 0.0F, 0.7285F, -0.1367F));
        PartDefinition hornRightAdultCenter = hornRightAdultInner.addOrReplaceChild("hornRightAdultCenter", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.6F, 0.0F, 0.5463F, -0.1367F));
        hornRightAdultCenter.addOrReplaceChild("hornRightAdultOuter", CubeListBuilder.create().texOffs(49, 2).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.6F, 0.0F, 0.5463F, -0.1367F));
        PartDefinition hornLeftAdult = skull.addOrReplaceChild("hornLeftAdult", CubeListBuilder.create().texOffs(30, 31).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.1F, -3.5F, 0.0F, 0.2731F, 0.4554F));
        PartDefinition hornLeftAdultInner = hornLeftAdult.addOrReplaceChild("hornLeftAdultInner", CubeListBuilder.create().texOffs(113, 17).addBox(0.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, 0.0F, 1.9F, 0.0F, 0.7285F, 0.1367F));
        PartDefinition hornLeftAdultCenter = hornLeftAdultInner.addOrReplaceChild("hornLeftAdultCenter", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.6F, 0.0F, 0.5463F, 0.1367F));
        hornLeftAdultCenter.addOrReplaceChild("hornLeftAdultOuter", CubeListBuilder.create().texOffs(44, 12).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.6F, 0.0F, 0.5463F, 0.1367F));
        PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -4.95F, -7.325F, 9.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.9018F, 4.1216F, -0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("back", CubeListBuilder.create().texOffs(18, 21).addBox(-4.0F, -1.1094F, -4.3712F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.3108F, -7.1788F, -0.2618F, 0.0F, 0.0F));
        body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(85, 28).addBox(-1.0F, -0.075F, 0.75F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6358F, -8.0288F, -0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("front", CubeListBuilder.create().texOffs(85, 0).addBox(-5.0F, -18.625F, -9.125F, 10.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.5392F, -3.5538F, 0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(55, 0).addBox(-5.0F, -18.325F, 6.325F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.3392F, -4.0596F, 0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.025F, -0.9F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9917F, 6.1731F, 0.2618F, 0.0F, 0.0F));
        PartDefinition udder = body.addOrReplaceChild("udder", CubeListBuilder.create().texOffs(31, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.6683F, -0.5686F));
        udder.addOrReplaceChild("teatRightFront", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.5F, -1.5F));
        udder.addOrReplaceChild("teatLeftFront", CubeListBuilder.create().texOffs(31, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.5F, -1.5F));
        udder.addOrReplaceChild("teatRightRear", CubeListBuilder.create().texOffs(53, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.5F, 0.5F));
        udder.addOrReplaceChild("teatLeftRear", CubeListBuilder.create().texOffs(49, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.5F, 0.5F));
        PartDefinition legRightFront = partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 8.666F, -6.7073F, 0.0911F, 0.0F, 0.0F));
        legRightFront.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(115, 27).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.7F, 1.2F, -0.182F, 0.0F, 0.0F));
        PartDefinition legLeftFront = partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(100, 17).addBox(0.0F, 0.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 8.666F, -6.7073F, 0.0911F, 0.0F, 0.0F));
        legLeftFront.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(73, 26).addBox(0.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.7F, 1.2F, -0.182F, 0.0F, 0.0F));
        PartDefinition legRightRear = partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(60, 15).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 9.541F, 7.9619F, -0.0911F, 0.0F, 0.0F));
        legRightRear.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(88, 17).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.7F, 0.2F, 0.182F, 0.0F, 0.0F));
        PartDefinition legLeftRear = partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(44, 15).addBox(0.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 9.541F, 7.9619F, -0.0911F, 0.0F, 0.0F));
        legLeftRear.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(76, 15).addBox(0.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.7F, 0.2F, 0.182F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
