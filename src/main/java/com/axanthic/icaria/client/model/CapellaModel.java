package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.CapellaEntity;
import com.axanthic.icaria.common.math.IcariaMath;

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

public class CapellaModel extends HierarchicalModel<CapellaEntity> {
	public CapellaEntity entity;

	public ModelPart root;
	public ModelPart body;
	public ModelPart bodyFront;
	public ModelPart neck;
	public ModelPart neckFront;
	public ModelPart head;
	public ModelPart hornRightAdult;
	public ModelPart hornLeftAdult;
	public ModelPart hornRightTeen;
	public ModelPart hornLeftTeen;
	public ModelPart hornRightChild;
	public ModelPart hornLeftChild;
	public ModelPart hornRightBaby;
	public ModelPart hornLeftBaby;
	public ModelPart thighRightFront;
	public ModelPart legRightFront;
	public ModelPart thighLeftFront;
	public ModelPart legLeftFront;
	public ModelPart bodyRear;
	public ModelPart thighRightRear;
	public ModelPart legRightRear;
	public ModelPart thighLeftRear;
	public ModelPart legLeftRear;

	public CapellaModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.body = this.root.getChild("body");
		this.bodyFront = this.body.getChild("bodyFront");
		this.neck = this.bodyFront.getChild("neck");
		this.neckFront = this.neck.getChild("neckFront");
		this.head = this.neckFront.getChild("head");
		this.hornRightBaby = this.head.getChild("hornRightBaby");
		this.hornLeftBaby = this.head.getChild("hornLeftBaby");
		this.hornRightChild = this.head.getChild("hornRightChild");
		this.hornLeftChild = this.head.getChild("hornLeftChild");
		this.hornRightTeen = this.head.getChild("hornRightTeen");
		this.hornLeftTeen = this.head.getChild("hornLeftTeen");
		this.hornRightAdult = this.head.getChild("hornRightAdult");
		this.hornLeftAdult = this.head.getChild("hornLeftAdult");
		this.thighRightFront = this.bodyFront.getChild("thighRightFront");
		this.legRightFront = this.thighRightFront.getChild("legRightFront");
		this.thighLeftFront = this.bodyFront.getChild("thighLeftFront");
		this.legLeftFront = this.thighLeftFront.getChild("legLeftFront");
		this.bodyRear = this.body.getChild("bodyRear");
		this.thighRightRear = this.bodyRear.getChild("thighRightRear");
		this.legRightRear = this.thighRightRear.getChild("legRightRear");
		this.thighLeftRear = this.bodyRear.getChild("thighLeftRear");
		this.legLeftRear = this.thighLeftRear.getChild("legLeftRear");
	}

	@Override
	public void prepareMobModel(CapellaEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
		super.prepareMobModel(pEntity, pLimbSwing, pLimbSwingAmount, pPartialTick);
		this.entity = pEntity;
	}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, int pColor) {
		if (this.entity.getSize() < 2) {
			pPoseStack.pushPose();
			this.hornRightBaby.visible = true;
			this.hornLeftBaby.visible = true;
			this.hornRightChild.visible = false;
			this.hornLeftChild.visible = false;
			this.hornRightTeen.visible = false;
			this.hornLeftTeen.visible = false;
			this.hornRightAdult.visible = false;
			this.hornLeftAdult.visible = false;
			this.root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		} else if (this.entity.getSize() < 3) {
			pPoseStack.pushPose();
			this.hornRightBaby.visible = false;
			this.hornLeftBaby.visible = false;
			this.hornRightChild.visible = true;
			this.hornLeftChild.visible = true;
			this.hornRightTeen.visible = false;
			this.hornLeftTeen.visible = false;
			this.hornRightAdult.visible = false;
			this.hornLeftAdult.visible = false;
			this.root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		} else if (this.entity.getSize() < 4) {
			pPoseStack.pushPose();
			this.hornRightBaby.visible = false;
			this.hornLeftBaby.visible = false;
			this.hornRightChild.visible = false;
			this.hornLeftChild.visible = false;
			this.hornRightTeen.visible = true;
			this.hornLeftTeen.visible = true;
			this.hornRightAdult.visible = false;
			this.hornLeftAdult.visible = false;
			this.root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		} else {
			pPoseStack.pushPose();
			this.hornRightBaby.visible = false;
			this.hornLeftBaby.visible = false;
			this.hornRightChild.visible = false;
			this.hornLeftChild.visible = false;
			this.hornRightTeen.visible = false;
			this.hornLeftTeen.visible = false;
			this.hornRightAdult.visible = true;
			this.hornLeftAdult.visible = true;
			this.root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		}
	}

	@Override
	public void setupAnim(CapellaEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.lookAnim(pNetHeadYaw, pHeadPitch);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.CAPELLA_ATTACK, pAgeInTicks);
	}

	public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
		float xRot = IcariaMath.rad(pHeadPitch) / 3.0F;
		float yRot = IcariaMath.rad(pNetHeadYaw) / 6.0F;
		this.neckFront.xRot = xRot - 0.1745F;
		this.neckFront.yRot = yRot;
		this.head.xRot = xRot + 1.3265F;
		this.head.yRot = yRot;
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		pLimbSwing *= Mth.lerp(this.entity.getSize(), 0.5F, 1.0F);

		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount * 0.5F;

		this.thighRightFront.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount + 0.3927F;
		this.legRightFront.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.0F)) * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount + pLimbSwingAmount - 0.2618F;
		this.thighLeftFront.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount + 0.3927F;
		this.legLeftFront.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.5F)) * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount + pLimbSwingAmount - 0.2618F;
		this.thighRightRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount;
		this.legRightRear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount + pLimbSwingAmount + 0.2182F;
		this.thighLeftRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount;
		this.legLeftRear.xRot = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount + pLimbSwingAmount + 0.2182F;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -12.0F, -2.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition bodyFront = body.addOrReplaceChild("bodyFront", CubeListBuilder.create().texOffs(28, 0).addBox(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -2.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition neck = bodyFront.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(14, 24).addBox(-3.5F, -6.0F, -1.0F, 7.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -6.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition neckFront = neck.addOrReplaceChild("neckFront", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -2.0309F, -4.1309F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -1.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition head = neckFront.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 0).addBox(-2.5F, -4.0111F, -3.1119F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0117F, -2.0859F, 1.3265F, 0.0F, 0.0F));
		PartDefinition hornRightAdult = head.addOrReplaceChild("hornRightAdult", CubeListBuilder.create().texOffs(24, 39).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0138F, 0.7655F, -0.7854F, 0.0F, -0.7854F));
		PartDefinition hornRightInnerAdult = hornRightAdult.addOrReplaceChild("hornRightInnerAdult", CubeListBuilder.create().texOffs(24, 59).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, 0.5F, -0.576F, 0.0F, -0.7854F));
		PartDefinition hornRightCenterAdult = hornRightInnerAdult.addOrReplaceChild("hornRightCenterAdult", CubeListBuilder.create().texOffs(16, 59).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.7854F, 0.0F, -0.7854F));
		PartDefinition hornRightOuterAdult = hornRightCenterAdult.addOrReplaceChild("hornRightOuterAdult", CubeListBuilder.create().texOffs(40, 53).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.7854F, 0.7854F, -0.1963F));
		hornRightOuterAdult.addOrReplaceChild("hornRightTipAdult", CubeListBuilder.create().texOffs(0, 65).addBox(-0.5F, -4.5F, -0.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.7854F, 0.0F, 0.1963F));
		PartDefinition hornLeftAdult = head.addOrReplaceChild("hornLeftAdult", CubeListBuilder.create().texOffs(12, 39).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5039F, -3.0177F, 0.7616F, 0.7854F, 3.1416F, -2.3562F));
		PartDefinition hornLeftInnerAdult = hornLeftAdult.addOrReplaceChild("hornLeftInnerAdult", CubeListBuilder.create().texOffs(0, 39).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -1.0F, -0.576F, -0.7854F, 0.0F));
		PartDefinition hornLeftCenterAdult = hornLeftInnerAdult.addOrReplaceChild("hornLeftCenterAdult", CubeListBuilder.create().texOffs(36, 39).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.5F, 0.7854F, -0.7854F, 0.0F));
		PartDefinition hornLeftOuterAdult = hornLeftCenterAdult.addOrReplaceChild("hornLeftOuterAdult", CubeListBuilder.create().texOffs(48, 33).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.7854F, -0.1963F, -0.7854F));
		hornLeftOuterAdult.addOrReplaceChild("hornLeftTipAdult", CubeListBuilder.create().texOffs(36, 33).addBox(-0.5F, -0.75F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.7854F, 0.1963F, 0.0F));
		PartDefinition hornRightTeen = head.addOrReplaceChild("hornRightTeen", CubeListBuilder.create().texOffs(48, 59).addBox(-0.5F, -1.0F, -0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0216F, 0.7616F, -0.7854F, 0.0F, -0.7854F));
		PartDefinition hornRightInnerTeen = hornRightTeen.addOrReplaceChild("hornRightInnerTeen", CubeListBuilder.create().texOffs(8, 59).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, 0.5F, -0.576F, 0.0F, -0.7854F));
		PartDefinition hornRightOuterTeen = hornRightInnerTeen.addOrReplaceChild("hornRightOuterTeen", CubeListBuilder.create().texOffs(0, 59).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.7854F, 0.0F, -0.7854F));
		hornRightOuterTeen.addOrReplaceChild("hornRightTipTeen", CubeListBuilder.create().texOffs(12, 65).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.7854F, 0.7854F, -0.1963F));
		PartDefinition hornLeftTeen = head.addOrReplaceChild("hornLeftTeen", CubeListBuilder.create().texOffs(30, 53).addBox(-1.5F, -1.5F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.0177F, 0.7577F, 0.7854F, 3.1416F, -2.3562F));
		PartDefinition hornLeftInnerTeen = hornLeftTeen.addOrReplaceChild("hornLeftInnerTeen", CubeListBuilder.create().texOffs(12, 33).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -1.0F, -0.576F, -0.7854F, 0.0F));
		PartDefinition hornLeftOuterTeen = hornLeftInnerTeen.addOrReplaceChild("hornLeftOuterTeen", CubeListBuilder.create().texOffs(24, 33).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.5F, 0.7854F, -0.7854F, 0.0F));
		hornLeftOuterTeen.addOrReplaceChild("hornLeftTipTeen", CubeListBuilder.create().texOffs(20, 53).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.7854F, -0.1963F, -0.7854F));
		PartDefinition hornRightChild = head.addOrReplaceChild("hornRightChild", CubeListBuilder.create().texOffs(40, 59).addBox(-0.5F, -1.0F, -0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0177F, 0.7616F, -0.7854F, 0.0F, -0.7854F));
		PartDefinition hornRightCenterChild = hornRightChild.addOrReplaceChild("hornRightCenterChild", CubeListBuilder.create().texOffs(48, 53).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, 0.5F, -0.576F, 0.0F, -0.7854F));
		hornRightCenterChild.addOrReplaceChild("hornRightTipChild", CubeListBuilder.create().texOffs(8, 65).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.7854F, 0.0F, -0.7854F));
		PartDefinition hornLeftChild = head.addOrReplaceChild("hornLeftChild", CubeListBuilder.create().texOffs(10, 53).addBox(-1.5F, -1.5F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.0177F, 0.7577F, 0.7854F, 3.1416F, -2.3562F));
		PartDefinition hornLeftCenterChild = hornLeftChild.addOrReplaceChild("hornLeftCenterChild", CubeListBuilder.create().texOffs(0, 33).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -1.0F, -0.576F, -0.7854F, 0.0F));
		hornLeftCenterChild.addOrReplaceChild("hornLeftTipChild", CubeListBuilder.create().texOffs(0, 53).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.5F, 0.7854F, -0.7854F, 0.0F));
		PartDefinition hornRightBaby = head.addOrReplaceChild("hornRightBaby", CubeListBuilder.create().texOffs(32, 59).addBox(-0.5F, -1.0F, -0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0216F, 0.7577F, -0.7854F, 0.0F, -0.7854F));
		hornRightBaby.addOrReplaceChild("hornRightTipBaby", CubeListBuilder.create().texOffs(4, 65).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, 0.5F, -0.576F, 0.0F, -0.7854F));
		PartDefinition hornLeftBaby = head.addOrReplaceChild("hornLeftBaby", CubeListBuilder.create().texOffs(42, 45).addBox(-1.5F, -1.5F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.0177F, 0.7577F, 0.7854F, 3.1416F, -2.3562F));
		hornLeftBaby.addOrReplaceChild("hornLeftTipBaby", CubeListBuilder.create().texOffs(32, 45).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -1.0F, -0.576F, -0.7854F, 0.0F));
		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(30, 24).addBox(-2.0F, 0.0007F, 0.0032F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.015F, -3.1119F, -1.4399F, 0.0F, 0.0F));
		nose.addOrReplaceChild("noseFront", CubeListBuilder.create().texOffs(48, 39).addBox(-1.5F, -0.0473F, 0.0005F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9995F, 0.5945F, 0.0873F, 0.0F, 0.0F));
		PartDefinition thighRightFront = bodyFront.addOrReplaceChild("thighRightFront", CubeListBuilder.create().texOffs(20, 14).addBox(-5.0F, -0.1131F, -2.0688F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -2.5F, 0.3927F, 0.0F, 0.0F));
		thighRightFront.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(8, 45).addBox(-4.5F, -0.447F, -1.1029F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition thighLeftFront = bodyFront.addOrReplaceChild("thighLeftFront", CubeListBuilder.create().texOffs(0, 24).addBox(2.0F, -0.1131F, -2.0688F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -2.5F, 0.3927F, 0.0F, 0.0F));
		thighLeftFront.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(16, 45).addBox(2.5F, -0.447F, -1.1029F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition bodyRear = body.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(46, 24).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.5F, 6.0F, -0.1309F, 0.0F, 0.0F));
		bodyRear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(16, 65).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.576F, 0.0F, 0.0F));
		PartDefinition thighRightRear = bodyRear.addOrReplaceChild("thighRightRear", CubeListBuilder.create().texOffs(48, 14).addBox(-4.0F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -0.5F));
		thighRightRear.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(24, 45).addBox(-3.5F, -0.3414F, -0.9763F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition thighLeftRear = bodyRear.addOrReplaceChild("thighLeftRear", CubeListBuilder.create().texOffs(34, 14).addBox(1.0F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -0.5F));
		thighLeftRear.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(0, 45).addBox(1.5F, -0.3414F, -0.9763F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 80, 80);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
