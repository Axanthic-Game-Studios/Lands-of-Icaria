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

public class VoidJellyfishModel extends HierarchicalModel<JellyfishEntity> {
    public ModelPart root;
    public ModelPart body;
    public ModelPart bell;
    public ModelPart bellNorth;
    public ModelPart tentacleNorthLeftOuter;
    public ModelPart tentacleNorthLeftInner;
    public ModelPart tentacleNorthRightInner;
    public ModelPart tentacleNorthRightOuter;
    public ModelPart bellEast;
    public ModelPart tentacleEastLeftOuter;
    public ModelPart tentacleEastLeftInner;
    public ModelPart tentacleEastRightInner;
    public ModelPart tentacleEastRightOuter;
    public ModelPart bellSouth;
    public ModelPart tentacleSouthLeftOuter;
    public ModelPart tentacleSouthLeftInner;
    public ModelPart tentacleSouthRightInner;
    public ModelPart tentacleSouthRightOuter;
    public ModelPart bellWest;
    public ModelPart tentacleWestLeftOuter;
    public ModelPart tentacleWestLeftInner;
    public ModelPart tentacleWestRightInner;
    public ModelPart tentacleWestRightOuter;
    public ModelPart head;
    public ModelPart armNorthEast;
    public ModelPart armSouth;
    public ModelPart armNorthWest;

    public VoidJellyfishModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.body = this.root.getChild("body");
        this.bell = this.body.getChild("bell");
        this.bellNorth = this.bell.getChild("bellNorth");
        this.tentacleNorthLeftOuter = this.bellNorth.getChild("tentacleNorthLeftOuter");
        this.tentacleNorthLeftInner = this.bellNorth.getChild("tentacleNorthLeftInner");
        this.tentacleNorthRightInner = this.bellNorth.getChild("tentacleNorthRightInner");
        this.tentacleNorthRightOuter = this.bellNorth.getChild("tentacleNorthRightOuter");
        this.bellEast = this.bell.getChild("bellEast");
        this.tentacleEastLeftOuter = this.bellEast.getChild("tentacleEastLeftOuter");
        this.tentacleEastLeftInner = this.bellEast.getChild("tentacleEastLeftInner");
        this.tentacleEastRightInner = this.bellEast.getChild("tentacleEastRightInner");
        this.tentacleEastRightOuter = this.bellEast.getChild("tentacleEastRightOuter");
        this.bellSouth = this.bell.getChild("bellSouth");
        this.tentacleSouthLeftOuter = this.bellSouth.getChild("tentacleSouthLeftOuter");
        this.tentacleSouthLeftInner = this.bellSouth.getChild("tentacleSouthLeftInner");
        this.tentacleSouthRightInner = this.bellSouth.getChild("tentacleSouthRightInner");
        this.tentacleSouthRightOuter = this.bellSouth.getChild("tentacleSouthRightOuter");
        this.bellWest = this.bell.getChild("bellWest");
        this.tentacleWestLeftOuter = this.bellWest.getChild("tentacleWestLeftOuter");
        this.tentacleWestLeftInner = this.bellWest.getChild("tentacleWestLeftInner");
        this.tentacleWestRightInner = this.bellWest.getChild("tentacleWestRightInner");
        this.tentacleWestRightOuter = this.bellWest.getChild("tentacleWestRightOuter");
        this.head = this.body.getChild("head");
        this.armNorthEast = this.head.getChild("armNorthEast");
        this.armSouth = this.head.getChild("armSouth");
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
        this.tentacleNorthLeftOuter.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F));
        this.tentacleNorthLeftInner.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.tentacleNorthRightInner.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.tentacleNorthRightOuter.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F));
        this.tentacleEastLeftOuter.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F));
        this.tentacleEastLeftInner.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.tentacleEastRightInner.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.tentacleEastRightOuter.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F));
        this.tentacleSouthLeftOuter.xRot = (pAgeInTicks * IcariaMath.rad(5.0F));
        this.tentacleSouthLeftInner.xRot = (pAgeInTicks * IcariaMath.rad(5.0F)) + IcariaMath.rad(5.0F);
        this.tentacleSouthRightInner.xRot = (pAgeInTicks * IcariaMath.rad(5.0F)) + IcariaMath.rad(5.0F);
        this.tentacleSouthRightOuter.xRot = (pAgeInTicks * IcariaMath.rad(5.0F));
        this.tentacleWestLeftOuter.xRot = (pAgeInTicks * IcariaMath.rad(5.0F));
        this.tentacleWestLeftInner.xRot = (pAgeInTicks * IcariaMath.rad(5.0F)) + IcariaMath.rad(5.0F);
        this.tentacleWestRightInner.xRot = (pAgeInTicks * IcariaMath.rad(5.0F)) + IcariaMath.rad(5.0F);
        this.tentacleWestRightOuter.xRot = (pAgeInTicks * IcariaMath.rad(5.0F));
        this.armNorthEast.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.armSouth.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
        this.armNorthWest.xRot = -(pAgeInTicks * IcariaMath.rad(5.0F)) - IcariaMath.rad(5.0F);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 35).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition bell = body.addOrReplaceChild("bell", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));
        PartDefinition bellNorth = bell.addOrReplaceChild("bellNorth", CubeListBuilder.create().texOffs(16, 32).addBox(-6.0F, -2.0F, -0.5F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, -6.5F));
        bellNorth.addOrReplaceChild("tentacleNorthLeftOuter", CubeListBuilder.create().texOffs(32, 53).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthLeftInner", CubeListBuilder.create().texOffs(36, 52).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthRightInner", CubeListBuilder.create().texOffs(40, 52).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorthRightOuter", CubeListBuilder.create().texOffs(44, 53).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 0.0F, 0.0F));
        PartDefinition bellEast = bell.addOrReplaceChild("bellEast", CubeListBuilder.create().texOffs(0, 24).addBox(-6.0F, -2.0F, -0.5F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -22.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        bellEast.addOrReplaceChild("tentacleEastLeftOuter", CubeListBuilder.create().texOffs(16, 53).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 0.0F, 0.0F));
        bellEast.addOrReplaceChild("tentacleEastLeftInner", CubeListBuilder.create().texOffs(20, 52).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
        bellEast.addOrReplaceChild("tentacleEastRightInner", CubeListBuilder.create().texOffs(24, 52).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
        bellEast.addOrReplaceChild("tentacleEastRightOuter", CubeListBuilder.create().texOffs(28, 53).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 0.0F, 0.0F));
        PartDefinition bellSouth = bell.addOrReplaceChild("bellSouth", CubeListBuilder.create().texOffs(16, 16).addBox(-6.0F, -2.0F, -0.5F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, 6.5F));
        bellSouth.addOrReplaceChild("tentacleSouthLeftOuter", CubeListBuilder.create().texOffs(0, 53).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthLeftInner", CubeListBuilder.create().texOffs(4, 52).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthRightInner", CubeListBuilder.create().texOffs(8, 52).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouthRightOuter", CubeListBuilder.create().texOffs(12, 53).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 0.0F, 0.0F));
        PartDefinition bellWest = bell.addOrReplaceChild("bellWest", CubeListBuilder.create().texOffs(32, 24).addBox(-6.0F, -2.0F, -0.5F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -22.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        bellWest.addOrReplaceChild("tentacleWestLeftOuter", CubeListBuilder.create().texOffs(48, 53).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 0.0F, 0.0F));
        bellWest.addOrReplaceChild("tentacleWestLeftInner", CubeListBuilder.create().texOffs(52, 52).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
        bellWest.addOrReplaceChild("tentacleWestRightInner", CubeListBuilder.create().texOffs(56, 52).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
        bellWest.addOrReplaceChild("tentacleWestRightOuter", CubeListBuilder.create().texOffs(60, 53).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 45).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        head.addOrReplaceChild("armNorthEast", CubeListBuilder.create().texOffs(0, 35).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0873F, 0.7854F, 0.0F));
        head.addOrReplaceChild("armSouth", CubeListBuilder.create().texOffs(8, 37).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0873F, 2.8798F, 0.0F));
        head.addOrReplaceChild("armNorthWest", CubeListBuilder.create().texOffs(16, 39).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0873F, 4.9742F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
