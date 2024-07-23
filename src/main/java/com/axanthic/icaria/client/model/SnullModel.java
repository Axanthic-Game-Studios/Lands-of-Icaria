package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.SnullEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HierarchicalModel;
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

public class SnullModel extends HierarchicalModel<SnullEntity> {
	public ModelPart root;
	public ModelPart bodyFront;
	public ModelPart chest;
	public ModelPart neck;
	public ModelPart head;
	public ModelPart headFeelerRight;
	public ModelPart headFeelerLeft;
	public ModelPart bodySkull;
	public ModelPart skullJawLower;
	public ModelPart skullJawUpper;
	public ModelPart skull;
	public ModelPart skullFeelerRight;
	public ModelPart skullFeelerLeft;

	public SnullModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.bodyFront = this.root.getChild("bodyFront");
		this.chest = this.bodyFront.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.head = this.neck.getChild("head");
		this.headFeelerRight = this.head.getChild("headFeelerRight");
		this.headFeelerLeft = this.head.getChild("headFeelerLeft");
		this.bodySkull = this.root.getChild("bodySkull");
		this.skullJawLower = this.bodySkull.getChild("skullJawLower");
		this.skullJawUpper = this.skullJawLower.getChild("skullJawUpper");
		this.skull = this.skullJawUpper.getChild("skull");
		this.skullFeelerRight = this.skull.getChild("skullFeelerRight");
		this.skullFeelerLeft = this.skull.getChild("skullFeelerLeft");
	}

	@Override
	public void setupAnim(SnullEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.idleAnim(pAgeInTicks);
		this.animate(pEntity.hideAnimationState, IcariaAnimations.SNULL_HIDE, pAgeInTicks);
		this.animate(pEntity.hurtAnimationState, IcariaAnimations.SNULL_HURT, pAgeInTicks);
		this.animate(pEntity.idleAnimationState, IcariaAnimations.SNULL_IDLE, pAgeInTicks);
		this.animate(pEntity.moveAnimationState, IcariaAnimations.SNULL_MOVE, pAgeInTicks);
		this.animate(pEntity.showAnimationState, IcariaAnimations.SNULL_SHOW, pAgeInTicks);
	}

	public void idleAnim(float pAgeInTicks) {
		this.headFeelerRight.xRot = Mth.sin(pAgeInTicks * 0.05F + 1.0F) * 0.075F + 0.2618F;
		this.headFeelerRight.zRot = Mth.cos(pAgeInTicks * 0.075F + 2.0F) * 0.075F + 0.7854F;
		this.headFeelerLeft.yRot = -Mth.sin(pAgeInTicks * 0.05F + 3.0F) * 0.075F - 0.2618F;
		this.headFeelerLeft.zRot = -Mth.cos(pAgeInTicks * 0.075F + 4.0F) * 0.075F + 0.7854F;
		this.skullFeelerRight.xRot = Mth.sin(pAgeInTicks * 0.05F + 1.0F) * 0.075F - 0.2618F;
		this.skullFeelerRight.yRot = Mth.cos(pAgeInTicks * 0.075F + 2.0F) * 0.075F + 0.1745F;
		this.skullFeelerLeft.xRot = -Mth.sin(pAgeInTicks * 0.05F + 3.0F) * 0.075F - 0.2618F;
		this.skullFeelerLeft.yRot = -Mth.cos(pAgeInTicks * 0.075F + 4.0F) * 0.075F - 0.1745F;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bodyFront = partDefinition.addOrReplaceChild("bodyFront", CubeListBuilder.create().texOffs(0, 29).addBox(-2.95F, -4.0F, -2.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, -3.0F, -0.2618F, 0.0F, 0.0F));
		var chest = bodyFront.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 21).addBox(-2.6F, -4.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.2618F, 0.0F, 0.0F));
		var neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 13).addBox(-2.55F, -4.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.5236F, 0.0F, 0.0F));
		neck.addOrReplaceChild("neckSack", CubeListBuilder.create().texOffs(18, 7).addBox(-1.8F, -1.75F, -0.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, -1.5F, 0.1309F, -0.0873F, 0.6109F));
		neck.addOrReplaceChild("neckWart", CubeListBuilder.create().texOffs(0, 42).addBox(-0.95F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.0F, -2.5F));
		var head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.2618F, 0.0F, 0.0F));
		head.addOrReplaceChild("headSack", CubeListBuilder.create().texOffs(0, 8).addBox(-3.15F, -2.25F, -0.5F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.3491F, 0.3054F, -0.0305F));
		head.addOrReplaceChild("headWart", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -4.0F, -2.0F));
		var headFeelerRight = head.addOrReplaceChild("headFeelerRight", CubeListBuilder.create().texOffs(18, 0).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, -4.0F, 0.2618F, 0.0F, 0.7854F));
		headFeelerRight.addOrReplaceChild("headEyeRight", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var headFeelerLeft = head.addOrReplaceChild("headFeelerLeft", CubeListBuilder.create().texOffs(19, 1).addBox(-0.5F, -0.5F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, -4.0F, 0.0F, -0.2618F, 0.7854F));
		headFeelerLeft.addOrReplaceChild("headEyeLeft", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.0F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var bodyCenter = partDefinition.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(0, 52).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 1.0F));
		bodyCenter.addOrReplaceChild("wartRight", CubeListBuilder.create().texOffs(0, 42).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 1.0F, -1.0F));
		bodyCenter.addOrReplaceChild("wartLeft", CubeListBuilder.create().texOffs(0, 42).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.0F, 2.0F));
		bodyCenter.addOrReplaceChild("wartTop", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.0F, -2.0F));
		var bodySkull = partDefinition.addOrReplaceChild("bodySkull", CubeListBuilder.create().texOffs(78, 15).addBox(-2.0F, -2.0F, -3.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, 5.0F, -0.4363F, 0.0F, 0.0F));
		var skullJawLower = bodySkull.addOrReplaceChild("skullJawLower", CubeListBuilder.create().texOffs(71, 1).addBox(-2.5F, -0.35F, -5.95F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.8F, 0.1745F, 0.0F, 0.0F));
		var skullJawUpper = skullJawLower.addOrReplaceChild("skullJawUpper", CubeListBuilder.create().texOffs(70, 7).addBox(-2.5F, -0.7F, -6.05F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0125F, -0.275F, 0.1375F, -0.1745F, 0.0F, 0.0F));
		var skull = skullJawUpper.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(68, 0).addBox(-3.5F, -6.0F, -6.8F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.6F, 0.0F));
		var skullFeelerRight = skull.addOrReplaceChild("skullFeelerRight", CubeListBuilder.create().texOffs(18, 0).addBox(-0.5F, -0.55F, -5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.4F, -6.8F, -0.2618F, 0.1745F, 0.0F));
		skullFeelerRight.addOrReplaceChild("skullEyeRight", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.05F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var skullFeelerLeft = skull.addOrReplaceChild("skullFeelerLeft", CubeListBuilder.create().texOffs(19, 1).addBox(-0.5F, -0.55F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.4F, -6.8F, -0.2618F, -0.1745F, 0.0F));
		skullFeelerLeft.addOrReplaceChild("skullEyeLeft", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.05F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		var bodyRear = partDefinition.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(0, 42).addBox(-2.6F, -3.0F, 0.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 5.0F));
		bodyRear.addOrReplaceChild("wartRear", CubeListBuilder.create().texOffs(26, 0).addBox(-1.1F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -3.0F, 5.0F));
		bodyRear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 35).addBox(-1.9F, -2.0F, 0.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		return LayerDefinition.create(meshDefinition, 96, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
