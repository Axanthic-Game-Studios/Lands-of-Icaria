package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.HumanoidArm;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantModel extends HierarchicalModel<CrawlerRevenantEntity> implements ArmedModel {
    public float armBend = 1.25F;
    public float ulnaBend = 1.00F;

    public ModelPart root;
    public ModelPart bodyUpper;
    public ModelPart headMain;
    public ModelPart shoulderMain;
    public ModelPart armRightUpper;
    public ModelPart armRightLower;
    public ModelPart armLeftUpper;
    public ModelPart armLeftLower;

    public CrawlerRevenantModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.bodyUpper = this.root.getChild("bodyUpper");
        this.headMain = this.bodyUpper.getChild("headMain");
        this.shoulderMain = this.bodyUpper.getChild("shoulderMain");
        this.armRightUpper = this.shoulderMain.getChild("armRightUpper");
        this.armRightLower = this.armRightUpper.getChild("armRightLower");
        this.armLeftUpper = this.shoulderMain.getChild("armLeftUpper");
        this.armLeftLower = this.armLeftUpper.getChild("armLeftLower");
    }

    @Override
    public void setupAnim(CrawlerRevenantEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        var randomSource = RandomSource.create(pEntity.getId());

        this.setRotateAngles(this.headMain, -1.2625F, randomSource.nextIntBetweenInclusive(-50, 50) * 0.005F - 0.0242F, 0.0395F);
        this.setRotateAngles(this.armRightUpper, -1.8284F, 0.0873F, 0.0F);
        this.setRotateAngles(this.armRightLower, -0.9879F, -0.011F, -0.01F);
        this.setRotateAngles(this.armLeftUpper, -1.6408F, -0.6545F, -0.1745F);
        this.setRotateAngles(this.armLeftLower, -1.1985F, 0.1268F, 0.0036F);

        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.attackAnim();
        this.idleAnim(pAgeInTicks);
        this.lookAnim(pHeadPitch, pNetHeadYaw);
        this.walkAnim(pLimbSwing, pLimbSwingAmount);

        this.root.y -= pEntity.getTick() - pEntity.maxTick;
    }

    public void setRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ) {
        pModelPart.xRot = pX;
        pModelPart.yRot = pY;
        pModelPart.zRot = pZ;
    }

    public void attackAnim() {
        this.armRightUpper.xRot -= Mth.sin(this.attackTime * Mth.PI);
    }

    public void idleAnim(float pAgeInTicks) {
        this.headMain.xRot += Mth.sin(pAgeInTicks * 0.067F) * 0.05F;
    }

    public void lookAnim(float pHeadPitch, float pNetHeadYaw) {
        this.headMain.xRot += pHeadPitch * (Mth.PI / 180.0F);
        this.headMain.zRot -= pNetHeadYaw * (Mth.PI / 180.0F);
    }

    public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
        pLimbSwingAmount *= 1.7F;

        this.armRightUpper.xRot -= Mth.cos(pLimbSwing * 0.6662F + Mth.PI) * armBend * pLimbSwingAmount;
        this.armRightLower.xRot += Mth.cos(-0.6F + pLimbSwing * 0.6662F + Mth.PI) * ulnaBend * pLimbSwingAmount - 0.7F * pLimbSwingAmount;
        this.armLeftUpper.xRot -= Mth.cos(pLimbSwing * 0.6662F) * armBend * pLimbSwingAmount;
        this.armLeftLower.xRot += Mth.cos(-0.6F + pLimbSwing * 0.6662F) * ulnaBend * pLimbSwingAmount - 0.7F * pLimbSwingAmount;
    }

    @Override
    public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
        this.bodyUpper.translateAndRotate(pPoseStack);
        this.shoulderMain.translateAndRotate(pPoseStack);
        this.armRightUpper.translateAndRotate(pPoseStack);
        this.armRightLower.translateAndRotate(pPoseStack);
    }

    public static LayerDefinition createLayer() {
        var meshDefinition = new MeshDefinition();
        var partDefinition = meshDefinition.getRoot();

        var bodyUpper = partDefinition.addOrReplaceChild("bodyUpper", CubeListBuilder.create().texOffs(32, 9).addBox(-0.9999F, -14.9948F, -1.1447F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2125F, 19.4625F, 7.925F, 1.3659F, 0.0F, 0.0911F));
        var headMain = bodyUpper.addOrReplaceChild("headMain", CubeListBuilder.create().texOffs(24, 28).addBox(-3.427F, -5.0496F, -7.9019F, 7.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0344F, -14.071F, -0.1688F, -1.2625F, -0.0242F, 0.0395F));
        headMain.addOrReplaceChild("jawMain", CubeListBuilder.create().texOffs(32, 2).addBox(-2.5F, 0.0F, -5.9875F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.073F, 0.9504F, -1.4144F));
        var shoulderMain = bodyUpper.addOrReplaceChild("shoulderMain", CubeListBuilder.create().texOffs(28, 0).addBox(-6.5F, -0.5F, -0.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1366F, -11.9549F, -1.0262F, -0.0024F, -0.0853F, 0.0186F));
        var armRightUpper = shoulderMain.addOrReplaceChild("armRightUpper", CubeListBuilder.create().texOffs(16, 36).addBox(-2.1693F, -1.2826F, -1.3431F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9942F, 0.0103F, -0.0887F, -1.8284F, 0.0873F, 0.0F));
        armRightUpper.addOrReplaceChild("armRightLower", CubeListBuilder.create().texOffs(0, 40).addBox(-0.9975F, -0.0375F, -1.4519F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1818F, 5.7299F, -0.5681F, -0.9879F, -0.011F, -0.01F));
        var armLeftUpper = shoulderMain.addOrReplaceChild("armLeftUpper", CubeListBuilder.create().texOffs(24, 42).addBox(-0.6185F, -0.002F, -1.0082F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0058F, 0.0353F, 0.2614F, -1.6408F, -0.6545F, -0.1745F));
        armLeftUpper.addOrReplaceChild("armLeftLower", CubeListBuilder.create().texOffs(32, 42).addBox(-1.0043F, -1.0351F, -0.0007F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.394F, 5.8855F, -1.0207F, -1.1985F, 0.1268F, 0.0036F));
        var ribUpperRightRear = bodyUpper.addOrReplaceChild("ribUpperRightRear", CubeListBuilder.create().texOffs(50, 47).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9229F, -12.0555F, -0.4963F, -0.0024F, -0.0853F, 0.0186F));
        var ribUpperRightSide = ribUpperRightRear.addOrReplaceChild("ribUpperRightSide", CubeListBuilder.create().texOffs(46, 23).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribUpperRightSide.addOrReplaceChild("ribUpperRightFront", CubeListBuilder.create().texOffs(9, 53).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, -1.5F));
        var ribUpperLeftRear = bodyUpper.addOrReplaceChild("ribUpperLeftRear", CubeListBuilder.create().texOffs(50, 13).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0097F, -11.8544F, 0.427F, -0.0024F, -0.0853F, 0.0186F));
        var ribUpperLeftSide = ribUpperLeftRear.addOrReplaceChild("ribUpperLeftSide", CubeListBuilder.create().texOffs(40, 21).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribUpperLeftSide.addOrReplaceChild("ribUpperLeftFront", CubeListBuilder.create().texOffs(51, 52).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.5F, -1.5F));
        var ribUpperCenterRightRear = bodyUpper.addOrReplaceChild("ribUpperCenterRightRear", CubeListBuilder.create().texOffs(24, 51).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8436F, -10.0023F, -0.4908F, 0.0065F, -0.0851F, -0.0865F));
        var ribUpperCenterRightSide = ribUpperCenterRightRear.addOrReplaceChild("ribUpperCenterRightSide", CubeListBuilder.create().texOffs(48, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribUpperCenterRightSide.addOrReplaceChild("ribUpperCenterRightFront", CubeListBuilder.create().texOffs(43, 52).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
        var ribUpperCenterLeftRear = bodyUpper.addOrReplaceChild("ribUpperCenterLeftRear", CubeListBuilder.create().texOffs(34, 51).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.832F, -9.8293F, 0.4012F, -0.0113F, -0.0846F, 0.1237F));
        var ribUpperCenterLeftSide = ribUpperCenterLeftRear.addOrReplaceChild("ribUpperCenterLeftSide", CubeListBuilder.create().texOffs(48, 17).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribUpperCenterLeftSide.addOrReplaceChild("ribUpperCenterLeftFront", CubeListBuilder.create().texOffs(23, 53).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        var ribCenterRightRear = bodyUpper.addOrReplaceChild("ribCenterRightRear", CubeListBuilder.create().texOffs(52, 24).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.444F, -8.5505F, -0.434F, 0.0154F, -0.0839F, -0.1916F));
        var ribCenterRightSide = ribCenterRightRear.addOrReplaceChild("ribCenterRightSide", CubeListBuilder.create().texOffs(0, 49).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.5F));
        ribCenterRightSide.addOrReplaceChild("ribCenterRightFront", CubeListBuilder.create().texOffs(0, 54).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.5F));
        var ribCenterLeftRear = bodyUpper.addOrReplaceChild("ribCenterLeftRear", CubeListBuilder.create().texOffs(28, 2).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.387F, -8.4287F, 0.3358F, -0.0201F, -0.0829F, 0.2288F));
        var ribCenterLeftSide = ribCenterLeftRear.addOrReplaceChild("ribCenterLeftSide", CubeListBuilder.create().texOffs(46, 29).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribCenterLeftSide.addOrReplaceChild("ribCenterLeftFront", CubeListBuilder.create().texOffs(52, 29).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        var ribLowerCenterLeftRear = bodyUpper.addOrReplaceChild("ribLowerCenterLeftRear", CubeListBuilder.create().texOffs(46, 34).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9131F, -7.1718F, 0.2585F, -0.0287F, -0.0804F, 0.3338F));
        var ribLowerCenterLeftSide = ribLowerCenterLeftRear.addOrReplaceChild("ribLowerCenterLeftSide", CubeListBuilder.create().texOffs(44, 47).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribLowerCenterLeftSide.addOrReplaceChild("ribLowerCenterLeftFront", CubeListBuilder.create().texOffs(52, 31).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        var ribLowerLeftRear = bodyUpper.addOrReplaceChild("ribLowerLeftRear", CubeListBuilder.create().texOffs(52, 22).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2432F, -6.1471F, 0.1497F, -0.037F, -0.0769F, 0.4388F));
        var ribLowerLeftSide = ribLowerLeftRear.addOrReplaceChild("ribLowerLeftSide", CubeListBuilder.create().texOffs(48, 42).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.5F));
        ribLowerLeftSide.addOrReplaceChild("ribLowerLeftFront", CubeListBuilder.create().texOffs(31, 53).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.5F));
        bodyUpper.addOrReplaceChild("breastboneMain", CubeListBuilder.create().texOffs(40, 9).addBox(-2.0F, -3.0F, -0.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2782F, -9.4571F, -3.2242F, -0.0024F, -0.0853F, 0.0186F));
        bodyUpper.addOrReplaceChild("coatMain", CubeListBuilder.create().texOffs(0, 0).addBox(-6.05F, 0.0F, 0.5F, 12.0F, 32.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1987F, -13.9564F, -1.03F, -0.1085F, -0.0853F, 0.0186F));
        var bodyLower = partDefinition.addOrReplaceChild("bodyLower", CubeListBuilder.create().texOffs(0, 36).addBox(-3.9804F, -0.551F, -0.549F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2536F, 19.542F, 7.9619F, 1.3659F, 0.0F, 0.0911F));
        var pelvisMain = bodyLower.addOrReplaceChild("pelvisMain", CubeListBuilder.create().texOffs(0, 38).addBox(-3.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0538F, 0.6912F, -2.8355F));
        var pelvisRight = pelvisMain.addOrReplaceChild("pelvisRight", CubeListBuilder.create().texOffs(50, 9).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8575F, -0.4258F, 1.4005F, 0.2094F, -0.1047F, 0.0F));
        var thighRight = pelvisRight.addOrReplaceChild("thighRight", CubeListBuilder.create().texOffs(40, 42).addBox(-1.4F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3889F, 0.1658F, 0.037F, -0.2487F, -0.0911F, 0.0F));
        thighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(16, 45).addBox(-1.4F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0125F, 7.0F, 0.0F, 0.2094F, 0.0F, 0.0F));
        var pelvisLeft = pelvisMain.addOrReplaceChild("pelvisLeft", CubeListBuilder.create().texOffs(6, 49).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8575F, -0.4258F, 1.4005F, 0.2094F, 0.1047F, 0.0F));
        pelvisLeft.addOrReplaceChild("thighLeft", CubeListBuilder.create().texOffs(8, 40).addBox(-0.6F, 0.0625F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3736F, -0.0342F, 0.3995F, -0.2979F, 0.0911F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
