package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.entity.JellyfishEntity;
import com.axanthic.icaria.common.math.IcariaMath;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireJellyfishModel extends HierarchicalModel<JellyfishEntity> {
	public ModelPart root;
	public ModelPart body;
	public ModelPart head;
	public ModelPart tentacleInnerSouthEastUpper;
	public ModelPart tentacleInnerNorthUpper;
	public ModelPart tentacleInnerSouthWestUpper;
	public ModelPart tentacleCenterNorthEastUpper;
	public ModelPart tentacleCenterSouthUpper;
	public ModelPart tentacleCenterNorthWestUpper;
	public ModelPart tentacleOuterNorthUpper;
	public ModelPart tentacleOuterNorthEastUpper;
	public ModelPart tentacleOuterSouthEastUpper;
	public ModelPart tentacleOuterSouthUpper;
	public ModelPart tentacleOuterSouthWestUpper;
	public ModelPart tentacleOuterNorthWestUpper;

	public FireJellyfishModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.body = this.root.getChild("body");
		this.head = this.body.getChild("head");
		this.tentacleInnerSouthEastUpper = this.head.getChild("tentacleInnerSouthEastUpper");
		this.tentacleInnerNorthUpper = this.head.getChild("tentacleInnerNorthUpper");
		this.tentacleInnerSouthWestUpper = this.head.getChild("tentacleInnerSouthWestUpper");
		this.tentacleCenterNorthEastUpper = this.head.getChild("tentacleCenterNorthEastUpper");
		this.tentacleCenterSouthUpper = this.head.getChild("tentacleCenterSouthUpper");
		this.tentacleCenterNorthWestUpper = this.head.getChild("tentacleCenterNorthWestUpper");
		this.tentacleOuterNorthUpper = this.head.getChild("tentacleOuterNorthUpper");
		this.tentacleOuterNorthEastUpper = this.head.getChild("tentacleOuterNorthEastUpper");
		this.tentacleOuterSouthEastUpper = this.head.getChild("tentacleOuterSouthEastUpper");
		this.tentacleOuterSouthUpper = this.head.getChild("tentacleOuterSouthUpper");
		this.tentacleOuterSouthWestUpper = this.head.getChild("tentacleOuterSouthWestUpper");
		this.tentacleOuterNorthWestUpper = this.head.getChild("tentacleOuterNorthWestUpper");
	}

	@Override
	public void setupAnim(JellyfishEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.swimAnim(pAgeInTicks);
	}

	public void swimAnim(float pAgeInTicks) {
		this.root.xScale = (pAgeInTicks / 5.0F) + 0.85F;
		this.root.yScale = -(pAgeInTicks / 7.5F) + 1.15F;
		this.root.zScale = (pAgeInTicks / 5.0F) + 0.85F;
		this.tentacleInnerSouthEastUpper.xRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
		this.tentacleInnerNorthUpper.xRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
		this.tentacleInnerSouthWestUpper.xRot = (pAgeInTicks * IcariaMath.rad(10.0F)) + IcariaMath.rad(10.0F);
		this.tentacleCenterNorthEastUpper.xRot = (pAgeInTicks * IcariaMath.rad(15.0F)) + IcariaMath.rad(15.0F);
		this.tentacleCenterSouthUpper.xRot = (pAgeInTicks * IcariaMath.rad(15.0F)) + IcariaMath.rad(15.0F);
		this.tentacleCenterNorthWestUpper.xRot = (pAgeInTicks * IcariaMath.rad(15.0F)) + IcariaMath.rad(15.0F);
		this.tentacleOuterNorthUpper.xRot = (pAgeInTicks * IcariaMath.rad(20.0F)) + IcariaMath.rad(20.0F);
		this.tentacleOuterNorthEastUpper.xRot = (pAgeInTicks * IcariaMath.rad(20.0F)) + IcariaMath.rad(20.0F);
		this.tentacleOuterSouthEastUpper.xRot = (pAgeInTicks * IcariaMath.rad(20.0F)) + IcariaMath.rad(20.0F);
		this.tentacleOuterSouthUpper.xRot = (pAgeInTicks * IcariaMath.rad(20.0F)) + IcariaMath.rad(20.0F);
		this.tentacleOuterSouthWestUpper.xRot = (pAgeInTicks * IcariaMath.rad(20.0F)) + IcariaMath.rad(20.0F);
		this.tentacleOuterNorthWestUpper.xRot = (pAgeInTicks * IcariaMath.rad(20.0F)) + IcariaMath.rad(20.0F);
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var bell = body.addOrReplaceChild("bell", CubeListBuilder.create().texOffs(0, 34).addBox(-6.0F, -26.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		bell.addOrReplaceChild("bellNorth", CubeListBuilder.create().texOffs(16, 24).addBox(-5.5F, 0.0F, -0.5F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -24.0F, -5.5F));
		bell.addOrReplaceChild("bellEast", CubeListBuilder.create().texOffs(0, 16).addBox(-5.5F, 0.0F, -0.5F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -24.0F, 0.5F, 0.0F, 1.5708F, 0.0F));
		bell.addOrReplaceChild("bellSouth", CubeListBuilder.create().texOffs(16, 10).addBox(-5.5F, 0.0F, -0.5F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -24.0F, 5.5F));
		bell.addOrReplaceChild("bellWest", CubeListBuilder.create().texOffs(32, 16).addBox(-5.5F, 0.0F, -0.5F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -24.0F, -0.5F, 0.0F, 1.5708F, 0.0F));
		var head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 48).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
		var tentacleInnerSouthEastUpper = head.addOrReplaceChild("tentacleInnerSouthEastUpper", CubeListBuilder.create().texOffs(4, 48).addBox(-0.5F, 0.0F, 0.5F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 4.9742F, 0.0F));
		tentacleInnerSouthEastUpper.addOrReplaceChild("tentacleInnerSouthEastLower", CubeListBuilder.create().texOffs(4, 56).addBox(-0.5F, 0.0F, 0.5F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleInnerNorthUpper = head.addOrReplaceChild("tentacleInnerNorthUpper", CubeListBuilder.create().texOffs(2, 48).addBox(-0.5F, 0.0F, 0.5F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 2.8798F, 0.0F));
		tentacleInnerNorthUpper.addOrReplaceChild("tentacleInnerNorthLower", CubeListBuilder.create().texOffs(2, 56).addBox(-0.5F, 0.0F, 0.5F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleInnerSouthWestUpper = head.addOrReplaceChild("tentacleInnerSouthWestUpper", CubeListBuilder.create().texOffs(0, 48).addBox(-0.5F, 0.0F, 0.5F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.7854F, 0.0F));
		tentacleInnerSouthWestUpper.addOrReplaceChild("tentacleInnerSouthWestLower", CubeListBuilder.create().texOffs(0, 56).addBox(-0.5F, 0.0F, 0.5F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleCenterNorthEastUpper = head.addOrReplaceChild("tentacleCenterNorthEastUpper", CubeListBuilder.create().texOffs(10, 48).addBox(-0.5F, 0.0F, 0.75F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -2.3562F, 0.0F));
		tentacleCenterNorthEastUpper.addOrReplaceChild("tentacleCenterNorthEastLower", CubeListBuilder.create().texOffs(10, 55).addBox(-0.5F, 0.0F, 0.75F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleCenterSouthUpper = head.addOrReplaceChild("tentacleCenterSouthUpper", CubeListBuilder.create().texOffs(6, 48).addBox(-0.5F, 0.0F, 0.75F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.2618F, 0.0F));
		tentacleCenterSouthUpper.addOrReplaceChild("tentacleCenterSouthLower", CubeListBuilder.create().texOffs(6, 55).addBox(-0.5F, 0.0F, 0.75F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleCenterNorthWestUpper = head.addOrReplaceChild("tentacleCenterNorthWestUpper", CubeListBuilder.create().texOffs(8, 48).addBox(-0.5F, 0.0F, 0.75F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 1.8326F, 0.0F));
		tentacleCenterNorthWestUpper.addOrReplaceChild("tentacleCenterNorthWestLower", CubeListBuilder.create().texOffs(8, 55).addBox(-0.5F, 0.0F, 0.75F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleOuterNorthUpper = head.addOrReplaceChild("tentacleOuterNorthUpper", CubeListBuilder.create().texOffs(18, 48).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, -3.0107F, 0.0F));
		tentacleOuterNorthUpper.addOrReplaceChild("tentacleOuterNorthLower", CubeListBuilder.create().texOffs(18, 54).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleOuterNorthEastUpper = head.addOrReplaceChild("tentacleOuterNorthEastUpper", CubeListBuilder.create().texOffs(20, 48).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, -1.7017F, 0.0F));
		tentacleOuterNorthEastUpper.addOrReplaceChild("tentacleOuterNorthEastLower", CubeListBuilder.create().texOffs(20, 54).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleOuterSouthEastUpper = head.addOrReplaceChild("tentacleOuterSouthEastUpper", CubeListBuilder.create().texOffs(22, 48).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, -0.9163F, 0.0F));
		tentacleOuterSouthEastUpper.addOrReplaceChild("tentacleOuterSouthEastLower", CubeListBuilder.create().texOffs(22, 54).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleOuterSouthUpper = head.addOrReplaceChild("tentacleOuterSouthUpper", CubeListBuilder.create().texOffs(12, 48).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.3927F, 0.0F));
		tentacleOuterSouthUpper.addOrReplaceChild("tentacleOuterSouthLower", CubeListBuilder.create().texOffs(12, 54).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleOuterSouthWestUpper = head.addOrReplaceChild("tentacleOuterSouthWestUpper", CubeListBuilder.create().texOffs(14, 48).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 1.1781F, 0.0F));
		tentacleOuterSouthWestUpper.addOrReplaceChild("tentacleOuterSouthWestLower", CubeListBuilder.create().texOffs(14, 54).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var tentacleOuterNorthWestUpper = head.addOrReplaceChild("tentacleOuterNorthWestUpper", CubeListBuilder.create().texOffs(16, 48).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 2.4871F, 0.0F));
		tentacleOuterNorthWestUpper.addOrReplaceChild("tentacleOuterNorthWestLower", CubeListBuilder.create().texOffs(16, 54).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, -0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
