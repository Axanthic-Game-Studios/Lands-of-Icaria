package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.util.IcariaMath;
import com.axanthic.icaria.common.entity.JellyfishEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class WaterJellyfishModel extends HierarchicalModel<JellyfishEntity> {
    public ModelPart root;
    public ModelPart body;
    public ModelPart bell;
    public ModelPart bellNorth;
    public ModelPart tentacleNorthLeftOuter;
    public ModelPart tentacleNorthLeftCenter;
    public ModelPart tentacleNorthLeftInner;
    public ModelPart tentacleNorthCenter;
    public ModelPart tentacleNorthRightInner;
    public ModelPart tentacleNorthRightCenter;
    public ModelPart tentacleNorthRightOuter;
    public ModelPart bellEast;
    public ModelPart tentacleEastLeftOuter;
    public ModelPart tentacleEastLeftCenter;
    public ModelPart tentacleEastLeftInner;
    public ModelPart tentacleEastCenter;
    public ModelPart tentacleEastRightInner;
    public ModelPart tentacleEastRightCenter;
    public ModelPart tentacleEastRightOuter;
    public ModelPart bellSouth;
    public ModelPart tentacleSouthLeftOuter;
    public ModelPart tentacleSouthLeftCenter;
    public ModelPart tentacleSouthLeftInner;
    public ModelPart tentacleSouthCenter;
    public ModelPart tentacleSouthRightInner;
    public ModelPart tentacleSouthRightCenter;
    public ModelPart tentacleSouthRightOuter;
    public ModelPart bellWest;
    public ModelPart tentacleWestLeftOuter;
    public ModelPart tentacleWestLeftCenter;
    public ModelPart tentacleWestLeftInner;
    public ModelPart tentacleWestCenter;
    public ModelPart tentacleWestRightInner;
    public ModelPart tentacleWestRightCenter;
    public ModelPart tentacleWestRightOuter;
    public ModelPart head;
    public ModelPart armNorth;
    public ModelPart armNorthEast;
    public ModelPart armEast;
    public ModelPart armSouthEast;
    public ModelPart armSouth;
    public ModelPart armSouthWest;
    public ModelPart armWest;
    public ModelPart armNorthWest;

    public WaterJellyfishModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.body = this.root.getChild("body");
        this.bell = this.body.getChild("bell");
        this.bellNorth = this.bell.getChild("bellNorth");
        this.tentacleNorthLeftOuter = this.bellNorth.getChild("tentacleNorthLeftOuter");
        this.tentacleNorthLeftCenter = this.bellNorth.getChild("tentacleNorthLeftCenter");
        this.tentacleNorthLeftInner = this.bellNorth.getChild("tentacleNorthLeftInner");
        this.tentacleNorthCenter = this.bellNorth.getChild("tentacleNorthCenter");
        this.tentacleNorthRightInner = this.bellNorth.getChild("tentacleNorthRightInner");
        this.tentacleNorthRightCenter = this.bellNorth.getChild("tentacleNorthRightCenter");
        this.tentacleNorthRightOuter = this.bellNorth.getChild("tentacleNorthRightOuter");
        this.bellEast = this.bell.getChild("bellEast");
        this.tentacleEastLeftOuter = this.bellEast.getChild("tentacleEastLeftOuter");
        this.tentacleEastLeftCenter = this.bellEast.getChild("tentacleEastLeftCenter");
        this.tentacleEastLeftInner = this.bellEast.getChild("tentacleEastLeftInner");
        this.tentacleEastCenter = this.bellEast.getChild("tentacleEastCenter");
        this.tentacleEastRightInner = this.bellEast.getChild("tentacleEastRightInner");
        this.tentacleEastRightCenter = this.bellEast.getChild("tentacleEastRightCenter");
        this.tentacleEastRightOuter = this.bellEast.getChild("tentacleEastRightOuter");
        this.bellSouth = this.bell.getChild("bellSouth");
        this.tentacleSouthLeftOuter = this.bellSouth.getChild("tentacleSouthLeftOuter");
        this.tentacleSouthLeftCenter = this.bellSouth.getChild("tentacleSouthLeftCenter");
        this.tentacleSouthLeftInner = this.bellSouth.getChild("tentacleSouthLeftInner");
        this.tentacleSouthCenter = this.bellSouth.getChild("tentacleSouthCenter");
        this.tentacleSouthRightInner = this.bellSouth.getChild("tentacleSouthRightInner");
        this.tentacleSouthRightCenter = this.bellSouth.getChild("tentacleSouthRightCenter");
        this.tentacleSouthRightOuter = this.bellSouth.getChild("tentacleSouthRightOuter");
        this.bellWest = this.bell.getChild("bellWest");
        this.tentacleWestLeftOuter = this.bellWest.getChild("tentacleWestLeftOuter");
        this.tentacleWestLeftCenter = this.bellWest.getChild("tentacleWestLeftCenter");
        this.tentacleWestLeftInner = this.bellWest.getChild("tentacleWestLeftInner");
        this.tentacleWestCenter = this.bellWest.getChild("tentacleWestCenter");
        this.tentacleWestRightInner = this.bellWest.getChild("tentacleWestRightInner");
        this.tentacleWestRightCenter = this.bellWest.getChild("tentacleWestRightCenter");
        this.tentacleWestRightOuter = this.bellWest.getChild("tentacleWestRightOuter");
        this.head = this.body.getChild("head");
        this.armNorth = this.head.getChild("armNorth");
        this.armNorthEast = this.head.getChild("armNorthEast");
        this.armEast = this.head.getChild("armEast");
        this.armSouthEast = this.head.getChild("armSouthEast");
        this.armSouth = this.head.getChild("armSouth");
        this.armSouthWest = this.head.getChild("armSouthWest");
        this.armWest = this.head.getChild("armWest");
        this.armNorthWest = this.head.getChild("armNorthWest");
    }

    @Override
    public void setupAnim(JellyfishEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.swimAnim(pAgeInTicks);
    }

    public void swimAnim(float pAgeInTicks) {
        this.root.xScale = (pAgeInTicks / 5.0F) + 0.85F;
        this.root.yScale = -(pAgeInTicks / 7.5F) + 1.15F;
        this.root.zScale = (pAgeInTicks / 5.0F) + 0.85F;
        this.tentacleNorthLeftOuter.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.tentacleNorthLeftCenter.xRot = -(pAgeInTicks * IcariaMath.rad(10.0F)) - IcariaMath.rad(10.0F);
        this.tentacleNorthLeftInner.xRot = -(pAgeInTicks * IcariaMath.rad(15.0F)) - IcariaMath.rad(15.0F);
        this.tentacleNorthCenter.xRot = -(pAgeInTicks * IcariaMath.rad(10.0F)) - IcariaMath.rad(10.0F);
        this.tentacleNorthRightInner.xRot = -(pAgeInTicks * IcariaMath.rad(15.0F)) - IcariaMath.rad(15.0F);
        this.tentacleNorthRightCenter.xRot = -(pAgeInTicks * IcariaMath.rad(10.0F)) - IcariaMath.rad(10.0F);
        this.tentacleNorthRightOuter.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.tentacleEastLeftOuter.zRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.tentacleEastLeftCenter.zRot = -(pAgeInTicks * IcariaMath.rad(10.0F)) - IcariaMath.rad(10.0F);
        this.tentacleEastLeftInner.zRot = -(pAgeInTicks * IcariaMath.rad(15.0F)) - IcariaMath.rad(15.0F);
        this.tentacleEastCenter.zRot = -(pAgeInTicks * IcariaMath.rad(10.0F)) - IcariaMath.rad(10.0F);
        this.tentacleEastRightInner.zRot = -(pAgeInTicks * IcariaMath.rad(15.0F)) - IcariaMath.rad(15.0F);
        this.tentacleEastRightCenter.zRot = -(pAgeInTicks * IcariaMath.rad(10.0F)) - IcariaMath.rad(10.0F);
        this.tentacleEastRightOuter.zRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.tentacleSouthLeftOuter.xRot = (pAgeInTicks * IcariaMath.rad(5.0F)) + IcariaMath.rad(5.0F);
        this.tentacleSouthLeftCenter.xRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
        this.tentacleSouthLeftInner.xRot = (pAgeInTicks * IcariaMath.rad(15.0F)) + IcariaMath.rad(15.0F);
        this.tentacleSouthCenter.xRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
        this.tentacleSouthRightInner.xRot = (pAgeInTicks * IcariaMath.rad(15.0F)) + IcariaMath.rad(15.0F);
        this.tentacleSouthRightCenter.xRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
        this.tentacleSouthRightOuter.xRot = (pAgeInTicks * IcariaMath.rad(5.0F)) + IcariaMath.rad(5.0F);
        this.tentacleWestLeftOuter.zRot = (pAgeInTicks * IcariaMath.rad(5.0F)) + IcariaMath.rad(5.0F);
        this.tentacleWestLeftCenter.zRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
        this.tentacleWestLeftInner.zRot = (pAgeInTicks * IcariaMath.rad(15.0F)) + IcariaMath.rad(15.0F);
        this.tentacleWestCenter.zRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
        this.tentacleWestRightInner.zRot = (pAgeInTicks * IcariaMath.rad(15.0F)) + IcariaMath.rad(15.0F);
        this.tentacleWestRightCenter.zRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
        this.tentacleWestRightOuter.zRot = (pAgeInTicks * IcariaMath.rad(5.0F)) + IcariaMath.rad(5.0F);
        this.armNorth.xRot = -(pAgeInTicks * IcariaMath.rad(22.5F)) - IcariaMath.rad(22.5F);
        this.armNorthEast.xRot = -(pAgeInTicks * IcariaMath.rad(22.5F)) - IcariaMath.rad(22.5F);
        this.armEast.xRot = -(pAgeInTicks * IcariaMath.rad(22.5F)) - IcariaMath.rad(22.5F);
        this.armSouthEast.xRot = -(pAgeInTicks * IcariaMath.rad(22.5F)) - IcariaMath.rad(22.5F);
        this.armSouth.xRot = -(pAgeInTicks * IcariaMath.rad(22.5F)) - IcariaMath.rad(22.5F);
        this.armSouthWest.xRot = -(pAgeInTicks * IcariaMath.rad(22.5F)) - IcariaMath.rad(22.5F);
        this.armWest.xRot = -(pAgeInTicks * IcariaMath.rad(22.5F)) - IcariaMath.rad(22.5F);
        this.armNorthWest.xRot = -(pAgeInTicks * IcariaMath.rad(22.5F)) - IcariaMath.rad(22.5F);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -25.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition bell = body.addOrReplaceChild("bell", CubeListBuilder.create().texOffs(0, 36).addBox(-7.0F, -24.0F, -7.0F, 14.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bellNorth = bell.addOrReplaceChild("bellNorth", CubeListBuilder.create().texOffs(32, 30).addBox(-7.0F, -2.0F, -9.0F, 14.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthLeftOuter", CubeListBuilder.create().texOffs(14, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 2.0F, -8.0F, -0.0873F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthLeftCenter", CubeListBuilder.create().texOffs(16, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, -8.0F, -0.1745F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthLeftInner", CubeListBuilder.create().texOffs(18, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, -8.0F, -0.2618F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthCenter", CubeListBuilder.create().texOffs(20, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -8.0F, -0.1745F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthRightInner", CubeListBuilder.create().texOffs(22, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, -8.0F, -0.2618F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthRightCenter", CubeListBuilder.create().texOffs(24, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0F, -8.0F, -0.1745F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthRightOuter", CubeListBuilder.create().texOffs(26, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 2.0F, -8.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition bellEast = bell.addOrReplaceChild("bellEast", CubeListBuilder.create().texOffs(0, 18).addBox(7.0F, -2.0F, -7.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, 0.0F));
        bellEast.addOrReplaceChild("tentacleEastLeftOuter", CubeListBuilder.create().texOffs(28, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 2.0F, -6.0F, 0.0F, 0.0F, -0.0873F));
        bellEast.addOrReplaceChild("tentacleEastLeftCenter", CubeListBuilder.create().texOffs(30, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 2.0F, -4.0F, 0.0F, 0.0F, -0.1745F));
        bellEast.addOrReplaceChild("tentacleEastLeftInner", CubeListBuilder.create().texOffs(32, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 2.0F, -2.0F, 0.0F, 0.0F, -0.2618F));
        bellEast.addOrReplaceChild("tentacleEastCenter", CubeListBuilder.create().texOffs(34, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
        bellEast.addOrReplaceChild("tentacleEastRightInner", CubeListBuilder.create().texOffs(36, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 2.0F, 2.0F, 0.0F, 0.0F, -0.2618F));
        bellEast.addOrReplaceChild("tentacleEastRightCenter", CubeListBuilder.create().texOffs(38, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 2.0F, 4.0F, 0.0F, 0.0F, -0.1745F));
        bellEast.addOrReplaceChild("tentacleEastRightOuter", CubeListBuilder.create().texOffs(40, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 2.0F, 6.0F, 0.0F, 0.0F, -0.0873F));
        PartDefinition bellSouth = bell.addOrReplaceChild("bellSouth", CubeListBuilder.create().texOffs(32, 30).addBox(-7.0F, -2.0F, 7.0F, 14.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthLeftOuter", CubeListBuilder.create().texOffs(42, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 2.0F, 8.0F, 0.0873F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthLeftCenter", CubeListBuilder.create().texOffs(44, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0F, 8.0F, 0.1745F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthLeftInner", CubeListBuilder.create().texOffs(46, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 8.0F, 0.2618F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthCenter", CubeListBuilder.create().texOffs(48, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 8.0F, 0.1745F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthRightInner", CubeListBuilder.create().texOffs(50, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 8.0F, 0.2618F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthRightCenter", CubeListBuilder.create().texOffs(52, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, 8.0F, 0.1745F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthRightOuter", CubeListBuilder.create().texOffs(54, 54).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 2.0F, 8.0F, 0.0873F, 0.0F, 0.0F));
        PartDefinition bellWest = bell.addOrReplaceChild("bellWest", CubeListBuilder.create().texOffs(0, 18).addBox(-9.0F, -2.0F, -7.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, 0.0F));
        bellWest.addOrReplaceChild("tentacleWestLeftOuter", CubeListBuilder.create().texOffs(0, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0873F));
        bellWest.addOrReplaceChild("tentacleWestLeftCenter", CubeListBuilder.create().texOffs(2, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.1745F));
        bellWest.addOrReplaceChild("tentacleWestLeftInner", CubeListBuilder.create().texOffs(4, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.2618F));
        bellWest.addOrReplaceChild("tentacleWestCenter", CubeListBuilder.create().texOffs(6, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
        bellWest.addOrReplaceChild("tentacleWestRightInner", CubeListBuilder.create().texOffs(8, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 2.0F, -2.0F, 0.0F, 0.0F, 0.2618F));
        bellWest.addOrReplaceChild("tentacleWestRightCenter", CubeListBuilder.create().texOffs(10, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 2.0F, -4.0F, 0.0F, 0.0F, 0.1745F));
        bellWest.addOrReplaceChild("tentacleWestRightOuter", CubeListBuilder.create().texOffs(12, 53).addBox(0.0F, 0.0F, -0.5F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 2.0F, -6.0F, 0.0F, 0.0F, 0.0873F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 10).addBox(-4.0F, -20.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        head.addOrReplaceChild("armNorth", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
        head.addOrReplaceChild("armNorthEast", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.3927F, -0.7854F, 0.0F));
        head.addOrReplaceChild("armEast", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.3927F, -1.5708F, 0.0F));
        head.addOrReplaceChild("armSouthEast", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.3927F, -2.3562F, 0.0F));
        head.addOrReplaceChild("armSouth", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.3927F, 3.1416F, 0.0F));
        head.addOrReplaceChild("armSouthWest", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.3927F, 2.3562F, 0.0F));
        head.addOrReplaceChild("armWest", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.3927F, 1.5708F, 0.0F));
        head.addOrReplaceChild("armNorthWest", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.3927F, 0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
