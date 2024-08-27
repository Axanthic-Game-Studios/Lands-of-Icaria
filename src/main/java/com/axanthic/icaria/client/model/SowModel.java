package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.SowEntity;
import com.axanthic.icaria.common.math.IcariaMath;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

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

public class SowModel extends HierarchicalModel<SowEntity> {
	public SowEntity entity;

	public ModelPart root;
	public ModelPart body;
	public ModelPart head;
	public ModelPart mouth;
	public ModelPart tuskRightAdult;
	public ModelPart tuskLeftAdult;
	public ModelPart tuskRightTeen;
	public ModelPart tuskLeftTeen;
	public ModelPart legRightFront;
	public ModelPart legLeftFront;
	public ModelPart legRightRear;
	public ModelPart legLeftRear;

	public SowModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.body = this.root.getChild("body");
		this.head = this.root.getChild("head");
		this.mouth = this.head.getChild("mouth");
		this.tuskRightAdult = this.mouth.getChild("tuskRightAdult");
		this.tuskLeftAdult = this.mouth.getChild("tuskLeftAdult");
		this.tuskRightTeen = this.mouth.getChild("tuskRightTeen");
		this.tuskLeftTeen = this.mouth.getChild("tuskLeftTeen");
		this.legRightFront = this.root.getChild("legRightFront");
		this.legLeftFront = this.root.getChild("legLeftFront");
		this.legRightRear = this.root.getChild("legRightRear");
		this.legLeftRear = this.root.getChild("legLeftRear");
	}

	@Override
	public void prepareMobModel(SowEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
		super.prepareMobModel(pEntity, pLimbSwing, pLimbSwingAmount, pPartialTick);
		this.entity = pEntity;
	}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
		if (this.entity.getSize() < 2) {
			pPoseStack.pushPose();
			this.tuskRightAdult.visible = false;
			this.tuskLeftAdult.visible = false;
			this.tuskRightTeen.visible = false;
			this.tuskLeftTeen.visible = false;
			this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		} else if (this.entity.getSize() < 3) {
			pPoseStack.pushPose();
			this.tuskRightAdult.visible = false;
			this.tuskLeftAdult.visible = false;
			this.tuskRightTeen.visible = false;
			this.tuskLeftTeen.visible = false;
			this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		} else if (this.entity.getSize() < 4) {
			pPoseStack.pushPose();
			this.tuskRightAdult.visible = false;
			this.tuskLeftAdult.visible = false;
			this.tuskRightTeen.visible = true;
			this.tuskLeftTeen.visible = true;
			this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		} else {
			pPoseStack.pushPose();
			this.tuskRightAdult.visible = true;
			this.tuskLeftAdult.visible = true;
			this.tuskRightTeen.visible = false;
			this.tuskLeftTeen.visible = false;
			this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		}
	}

	@Override
	public void setupAnim(SowEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.lookAnim(pNetHeadYaw, pHeadPitch);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.SOW_ATTACK, pAgeInTicks);
		this.animate(pEntity.eatingAnimationState, IcariaAnimations.SOW_EATING, pAgeInTicks);
	}

	public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
		this.head.xRot = IcariaMath.rad(pHeadPitch) + 0.0834F;
		this.head.yRot = IcariaMath.rad(pNetHeadYaw);
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		pLimbSwing *= Mth.lerp(this.entity.getSize(), 0.5F, 1.0F);

		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount * 0.5F;

		this.legRightFront.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount;
		this.legLeftFront.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount;
		this.legRightRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount;
		this.legLeftRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.5352F, -7.0F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, -0.0911F, 0.0F, 0.0F));
		var rump = body.addOrReplaceChild("rump", CubeListBuilder.create().texOffs(20, 28).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 4.0F, -0.1553F, 0.0F, 0.0F));
		rump.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 47).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, 0.5918F, 0.0F, 0.0F));
		body.addOrReplaceChild("thighsFront", CubeListBuilder.create().texOffs(0, 19).addBox(-5.0F, -4.5F, -7.0F, 10.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.25F, 0.5F, 0.0911F, 0.0F, 0.0F));
		body.addOrReplaceChild("thighsRear", CubeListBuilder.create().texOffs(28, 19).addBox(-4.5F, -4.5F, 1.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.25F, 0.9F, 0.0911F, 0.0F, 0.0F));
		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(38, 0).addBox(-2.5F, -2.9991F, -7.4391F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0097F, -4.4963F, 0.0834F, 0.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(36, 38).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0009F, -6.9391F, 0.182F, 0.0F, 0.0F));
		var mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(10, 47).addBox(-1.0F, -0.5375F, -3.0125F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5384F, -7.4266F));
		mouth.addOrReplaceChild("tuskRightAdult", CubeListBuilder.create().texOffs(0, 52).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5375F, -1.7125F, 0.0F, 0.0F, -0.3927F));
		mouth.addOrReplaceChild("tuskLeftAdult", CubeListBuilder.create().texOffs(42, 47).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5375F, -1.7125F, 0.0F, 0.0F, 0.3927F));
		mouth.addOrReplaceChild("tuskRightTeen", CubeListBuilder.create().texOffs(8, 52).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5375F, -1.7125F, 0.0F, 0.0F, -0.3927F));
		mouth.addOrReplaceChild("tuskLeftTeen", CubeListBuilder.create().texOffs(4, 52).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5375F, -1.7125F, 0.0F, 0.0F, 0.3927F));
		var hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -2.0156F, -2.9883F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.4991F, -4.5391F, 0.0094F, 0.0F, 0.0F));
		hair.addOrReplaceChild("hairRear", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, -0.0195F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.01F, -2.0F, 5.0F, -0.3927F, 0.0F, 0.0F));
		head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(28, 47).addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3125F, -0.7491F, -2.9391F, 0.3927F, 0.0F, 2.0944F));
		head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(20, 47).addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -0.7491F, -2.9391F, -0.3927F, 0.0F, 1.0472F));
		partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.032F, -4.7978F));
		partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(40, 28).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.032F, -4.7978F));
		partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(12, 38).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 18.0684F, 3.6006F));
		partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(24, 38).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 18.0684F, 3.6006F));

		return LayerDefinition.create(meshDefinition, 64, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
