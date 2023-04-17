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

public class EnderJellyfishModel extends HierarchicalModel<JellyfishEntity> {
    public ModelPart root;
    public ModelPart body;
    public ModelPart bell;
    public ModelPart bellNorth;
    public ModelPart tentacleNorth;
    public ModelPart tentacleEast;
    public ModelPart bellSouth;
    public ModelPart tentacleSouth;
    public ModelPart tentacleWest;
    public ModelPart head;
    public ModelPart armOuterNorthEastUpper;
    public ModelPart armOuterNorthEastLower;
    public ModelPart armOuterSouthEastUpper;
    public ModelPart armOuterSouthEastLower;
    public ModelPart armOuterSouthWestUpper;
    public ModelPart armOuterSouthWestLower;
    public ModelPart armOuterNorthWestUpper;
    public ModelPart armOuterNorthWestLower;

    public EnderJellyfishModel(ModelPart pModelPart) {
        this.root = pModelPart;
        this.body = this.root.getChild("body");
        this.bell = this.body.getChild("bell");
        this.bellNorth = this.bell.getChild("bellNorth");
        this.tentacleNorth = this.bellNorth.getChild("tentacleNorth");
        this.tentacleEast = this.bell.getChild("tentacleEast");
        this.bellSouth = this.bell.getChild("bellSouth");
        this.tentacleSouth = this.bellSouth.getChild("tentacleSouth");
        this.tentacleWest = this.bell.getChild("tentacleWest");
        this.head = this.body.getChild("head");
        this.armOuterNorthEastUpper = this.head.getChild("armOuterNorthEastUpper");
        this.armOuterNorthEastLower = this.armOuterNorthEastUpper.getChild("armOuterNorthEastLower");
        this.armOuterSouthEastUpper = this.head.getChild("armOuterSouthEastUpper");
        this.armOuterSouthEastLower = this.armOuterSouthEastUpper.getChild("armOuterSouthEastLower");
        this.armOuterSouthWestUpper = this.head.getChild("armOuterSouthWestUpper");
        this.armOuterSouthWestLower = this.armOuterSouthWestUpper.getChild("armOuterSouthWestLower");
        this.armOuterNorthWestUpper = this.head.getChild("armOuterNorthWestUpper");
        this.armOuterNorthWestLower = this.armOuterNorthWestUpper.getChild("armOuterNorthWestLower");
    }

    @Override
    public void setupAnim(JellyfishEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.swimAnim(pAgeInTicks);
    }

    public void swimAnim(float pAgeInTicks) {
        this.root.xScale = (pAgeInTicks / 5.0F) + 0.85F;
        this.root.yScale = -(pAgeInTicks / 7.5F) + 1.15F;
        this.root.zScale = (pAgeInTicks / 5.0F) + 0.85F;
        this.tentacleNorth.xRot = -(pAgeInTicks * IcariaMath.rad(11.25F));
        this.tentacleEast.xRot = (pAgeInTicks * IcariaMath.rad(11.25F));
        this.tentacleSouth.xRot = (pAgeInTicks * IcariaMath.rad(11.25F));
        this.tentacleWest.xRot = -(pAgeInTicks * IcariaMath.rad(11.25F));
        this.armOuterNorthEastUpper.xRot = -(pAgeInTicks * IcariaMath.rad(11.25F)) - IcariaMath.rad(11.25F);
        this.armOuterNorthEastLower.xRot = (pAgeInTicks * IcariaMath.rad(11.25F)) + IcariaMath.rad(11.25F);
        this.armOuterSouthEastUpper.xRot = -(pAgeInTicks * IcariaMath.rad(11.25F)) - IcariaMath.rad(11.25F);
        this.armOuterSouthEastLower.xRot = (pAgeInTicks * IcariaMath.rad(11.25F)) + IcariaMath.rad(11.25F);
        this.armOuterSouthWestUpper.xRot = -(pAgeInTicks * IcariaMath.rad(11.25F)) - IcariaMath.rad(11.25F);
        this.armOuterSouthWestLower.xRot = (pAgeInTicks * IcariaMath.rad(11.25F)) + IcariaMath.rad(11.25F);
        this.armOuterNorthWestUpper.xRot = -(pAgeInTicks * IcariaMath.rad(11.25F)) - IcariaMath.rad(11.25F);
        this.armOuterNorthWestLower.xRot = (pAgeInTicks * IcariaMath.rad(11.25F)) + IcariaMath.rad(11.25F);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        PartDefinition bell = body.addOrReplaceChild("bell", CubeListBuilder.create().texOffs(0, 30).addBox(-5.0F, -26.0F, -4.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 26.0F, 0.0F));
        PartDefinition bellNorth = bell.addOrReplaceChild("bellNorth", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.0F, 0.0F));
        bellNorth.addOrReplaceChild("tentacleNorth", CubeListBuilder.create().texOffs(32, 3).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -4.5F));
        bell.addOrReplaceChild("tentacleEast", CubeListBuilder.create().texOffs(0, 3).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        PartDefinition bellSouth = bell.addOrReplaceChild("bellSouth", CubeListBuilder.create().texOffs(18, 0).addBox(-4.0F, 0.0F, 4.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.0F, 0.0F));
        bellSouth.addOrReplaceChild("tentacleSouth", CubeListBuilder.create().texOffs(48, 3).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 4.5F));
        bell.addOrReplaceChild("tentacleWest", CubeListBuilder.create().texOffs(16, 3).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 9).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition torso = head.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        torso.addOrReplaceChild("armInnerNorth", CubeListBuilder.create().texOffs(20, 20).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.2007F, 0.0F, 0.0F));
        torso.addOrReplaceChild("armInnerEast", CubeListBuilder.create().texOffs(8, 20).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.2007F));
        torso.addOrReplaceChild("armInnerSouth", CubeListBuilder.create().texOffs(16, 20).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.2007F, 0.0F, 0.0F));
        torso.addOrReplaceChild("armInnerWest", CubeListBuilder.create().texOffs(12, 20).addBox(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0175F, -0.2007F));
        PartDefinition armOuterNorthEastUpper = head.addOrReplaceChild("armOuterNorthEastUpper", CubeListBuilder.create().texOffs(0, 51).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, -0.1963F, 0.7854F, 0.0F));
        armOuterNorthEastUpper.addOrReplaceChild("armOuterNorthEastLower", CubeListBuilder.create().texOffs(0, 40).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.9F, -1.0F, 0.1963F, 0.0F, 0.0F));
        PartDefinition armOuterSouthEastUpper = head.addOrReplaceChild("armOuterSouthEastUpper", CubeListBuilder.create().texOffs(4, 51).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, -0.1963F, 2.3562F, 0.0F));
        armOuterSouthEastUpper.addOrReplaceChild("armOuterSouthEastLower", CubeListBuilder.create().texOffs(4, 40).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.9F, -1.0F, 0.1963F, 0.0F, 0.0F));
        PartDefinition armOuterSouthWestUpper = head.addOrReplaceChild("armOuterSouthWestUpper", CubeListBuilder.create().texOffs(8, 51).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, -0.1963F, -2.3562F, 0.0F));
        armOuterSouthWestUpper.addOrReplaceChild("armOuterSouthWestLower", CubeListBuilder.create().texOffs(8, 40).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.9F, -1.0F, 0.1963F, 0.0F, 0.0F));
        PartDefinition armOuterNorthWestUpper = head.addOrReplaceChild("armOuterNorthWestUpper", CubeListBuilder.create().texOffs(12, 51).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, -0.1963F, -0.7854F, 0.0F));
        armOuterNorthWestUpper.addOrReplaceChild("armOuterNorthWestLower", CubeListBuilder.create().texOffs(12, 40).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.9F, -1.0F, 0.1963F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
