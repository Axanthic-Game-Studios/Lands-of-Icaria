package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.registry.IcariaAnimations;
import com.axanthic.icaria.common.entity.AeternaeEntity;
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

public class AeternaeModel extends HierarchicalModel<AeternaeEntity> {
	public AeternaeEntity entity;

	public ModelPart root;
	public ModelPart head;
	public ModelPart neck;
	public ModelPart skull;
	public ModelPart mouth;
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
	public ModelPart legRightFrontUpper;
	public ModelPart legRightFrontLower;
	public ModelPart legLeftFront;
	public ModelPart legLeftFrontUpper;
	public ModelPart legLeftFrontLower;
	public ModelPart legRightRear;
	public ModelPart legRightRearUpper;
	public ModelPart legRightRearLower;
	public ModelPart legLeftRear;
	public ModelPart legLeftRearUpper;
	public ModelPart legLeftRearLower;

	public AeternaeModel(ModelPart pModelPart) {
		this.root = pModelPart;
		this.head = this.root.getChild("head");
		this.neck = this.head.getChild("neck");
		this.skull = this.neck.getChild("skull");
		this.mouth = this.skull.getChild("mouth");
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
		this.legRightFrontUpper = this.legRightFront.getChild("legRightFrontUpper");
		this.legRightFrontLower = this.legRightFrontUpper.getChild("legRightFrontLower");
		this.legLeftFront = this.root.getChild("legLeftFront");
		this.legLeftFrontUpper = this.legLeftFront.getChild("legLeftFrontUpper");
		this.legLeftFrontLower = this.legLeftFrontUpper.getChild("legLeftFrontLower");
		this.legRightRear = this.root.getChild("legRightRear");
		this.legRightRearUpper = this.legRightRear.getChild("legRightRearUpper");
		this.legRightRearLower = this.legRightRearUpper.getChild("legRightRearLower");
		this.legLeftRear = this.root.getChild("legLeftRear");
		this.legLeftRearUpper = this.legLeftRear.getChild("legLeftRearUpper");
		this.legLeftRearLower = this.legLeftRearUpper.getChild("legLeftRearLower");
	}

	@Override
	public void prepareMobModel(AeternaeEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
		super.prepareMobModel(pEntity, pLimbSwing, pLimbSwingAmount, pPartialTick);
		this.entity = pEntity;
	}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, int pColor) {
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
			this.root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
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
			this.root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
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
			this.root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
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
			this.root.render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pColor);
			pPoseStack.popPose();
		}
	}

	@Override
	public void setupAnim(AeternaeEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.lookAnim(pNetHeadYaw, pHeadPitch);
		this.walkAnim(pLimbSwing, pLimbSwingAmount);
		this.animate(pEntity.attackAnimationState, IcariaAnimations.AETERNAE_ATTACK, pAgeInTicks);
		this.animate(pEntity.eatingAnimationState, IcariaAnimations.AETERNAE_EATING, pAgeInTicks);
	}

	public void lookAnim(float pNetHeadYaw, float pHeadPitch) {
		float xRot = IcariaMath.rad(pHeadPitch) / 3.0F;
		float yRot = IcariaMath.rad(pNetHeadYaw) / 3.0F;
		this.head.xRot = xRot - 0.5465F;
		this.head.yRot = yRot;
		this.neck.xRot = xRot + 0.9105F;
		this.neck.yRot = yRot;
		this.skull.xRot = xRot;
		this.skull.yRot = yRot;
	}

	public void walkAnim(float pLimbSwing, float pLimbSwingAmount) {
		pLimbSwing *= Mth.lerp(this.entity.getSize(), 0.5F, 1.0F);

		float rightFront = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.0F)) * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount + pLimbSwingAmount;
		float leftFront = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.5F)) * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount + pLimbSwingAmount;
		float rightRear = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount + pLimbSwingAmount;
		float leftRear = Mth.sin((pLimbSwing + Mth.sin(pLimbSwing + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount + pLimbSwingAmount;

		this.root.y = Mth.sin(pLimbSwing) * pLimbSwingAmount * 0.5F;

		this.legRightFront.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.0F) * pLimbSwingAmount + 0.0909F;
		this.legRightFrontUpper.xRot = -rightFront - 0.0911F;
		this.legRightFrontLower.xRot = rightFront - 0.0911F;
		this.legLeftFront.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.0F) * pLimbSwingAmount + 0.0909F;
		this.legLeftFrontUpper.xRot = -leftFront - 0.0911F;
		this.legLeftFrontLower.xRot = leftFront - 0.0911F;
		this.legRightRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 1.5F) * pLimbSwingAmount - 0.4838F;
		this.legRightRearUpper.xRot = rightRear + 0.7285F;
		this.legRightRearLower.xRot = -rightRear - 0.2276F;
		this.legLeftRear.xRot = Mth.cos(pLimbSwing * 0.5F + Mth.PI * 0.5F) * pLimbSwingAmount - 0.4838F;
		this.legLeftRearUpper.xRot = leftRear + 0.7285F;
		this.legLeftRearLower.xRot = -leftRear - 0.2276F;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(96, 10).addBox(-3.5F, -2.8155F, -6.021F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8543F, -1.388F, -0.5465F, 0.0F, 0.0F));
		var neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(104, 21).addBox(-2.5F, -8.0098F, -1.52F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3595F, -4.921F, 0.9105F, 0.0F, 0.0F));
		var skull = neck.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, -3.95F, -5.85F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.3598F, -0.07F));
		skull.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(19, 22).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.95F, -5.85F));
		skull.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -0.3F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.65F, -5.85F, 0.0456F, 0.0F, 0.0F));
		skull.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(27, 22).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.05F, -4.75F));
		skull.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(78, 25).addBox(-1.0F, -0.3F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.65F, -0.85F, -0.7854F, 0.0F, 0.0F));
		skull.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(56, 24).addBox(0.0F, -0.3F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.65F, -0.85F, -0.7854F, 0.0F, 0.0F));
		var hornRightBaby = skull.addOrReplaceChild("hornRightBaby", CubeListBuilder.create().texOffs(61, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.475F, -3.25F, -2.325F, -0.182F, 0.0F, -0.2731F));
		hornRightBaby.addOrReplaceChild("hornRightBabyUpper", CubeListBuilder.create().texOffs(49, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, 0.0456F));
		var hornLeftBaby = skull.addOrReplaceChild("hornLeftBaby", CubeListBuilder.create().texOffs(43, 0).addBox(0.125F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.35F, -3.275F, -2.325F, -0.182F, 0.0F, 0.2731F));
		hornLeftBaby.addOrReplaceChild("hornLeftBabyUpper", CubeListBuilder.create().texOffs(30, 0).addBox(0.125F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, -0.0456F));
		var hornRightKid = skull.addOrReplaceChild("hornRightKid", CubeListBuilder.create().texOffs(61, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.475F, -3.25F, -2.325F, -0.182F, 0.0F, -0.2731F));
		hornRightKid.addOrReplaceChild("hornRightKidUpper", CubeListBuilder.create().texOffs(49, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, 0.0456F));
		var hornLeftKid = skull.addOrReplaceChild("hornLeftKid", CubeListBuilder.create().texOffs(43, 0).addBox(0.125F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.35F, -3.275F, -2.325F, -0.182F, 0.0F, 0.2731F));
		hornLeftKid.addOrReplaceChild("hornLeftKidUpper", CubeListBuilder.create().texOffs(30, 0).addBox(0.125F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, -0.0456F));
		var hornRightTeen = skull.addOrReplaceChild("hornRightTeen", CubeListBuilder.create().texOffs(119, 18).addBox(-1.1F, -6.0F, 0.7F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.65F, -0.625F, -4.075F, -0.182F, 0.0F, -0.2731F));
		var hornRightTeenCenter = hornRightTeen.addOrReplaceChild("hornRightTeenCenter", CubeListBuilder.create().texOffs(61, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -6.0F, 1.4F, -0.4554F, 0.0F, 0.0456F));
		hornRightTeenCenter.addOrReplaceChild("hornRightTeenUpper", CubeListBuilder.create().texOffs(49, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, 0.0456F));
		var hornLeftTeen = skull.addOrReplaceChild("hornLeftTeen", CubeListBuilder.create().texOffs(116, 10).addBox(0.1F, -6.0F, 0.7F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.65F, -0.625F, -4.075F, -0.182F, 0.0F, 0.2731F));
		var hornLeftTeenCenter = hornLeftTeen.addOrReplaceChild("hornLeftTeenCenter", CubeListBuilder.create().texOffs(43, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -6.0F, 1.4F, -0.4554F, 0.0F, -0.0456F));
		hornLeftTeenCenter.addOrReplaceChild("hornLeftTeenUpper", CubeListBuilder.create().texOffs(30, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, -0.0456F));
		var hornRightAdult = skull.addOrReplaceChild("hornRightAdult", CubeListBuilder.create().texOffs(90, 25).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.525F, -3.4F, -3.35F, -0.182F, 0.0F, -0.2731F));
		var hornRightAdultLower = hornRightAdult.addOrReplaceChild("hornRightAdultLower", CubeListBuilder.create().texOffs(119, 18).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.4554F, 0.0F, 0.0456F));
		var hornRightAdultCenter = hornRightAdultLower.addOrReplaceChild("hornRightAdultCenter", CubeListBuilder.create().texOffs(61, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.4554F, 0.0F, 0.0456F));
		hornRightAdultCenter.addOrReplaceChild("hornRightAdultUpper", CubeListBuilder.create().texOffs(49, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, 0.0456F));
		var hornLeftAdult = skull.addOrReplaceChild("hornLeftAdult", CubeListBuilder.create().texOffs(39, 23).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.525F, -3.4F, -3.35F, -0.182F, 0.0F, 0.2731F));
		var hornLeftAdultLower = hornLeftAdult.addOrReplaceChild("hornLeftAdultLower", CubeListBuilder.create().texOffs(116, 10).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.4554F, 0.0F, -0.0456F));
		var hornLeftAdultCenter = hornLeftAdultLower.addOrReplaceChild("hornLeftAdultCenter", CubeListBuilder.create().texOffs(43, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.4554F, 0.0F, -0.0456F));
		hornLeftAdultCenter.addOrReplaceChild("hornLeftAdultUpper", CubeListBuilder.create().texOffs(30, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 0.7F, -0.5463F, 0.0F, -0.0456F));
		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -0.15F, -14.275F, 8.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.9188F, 8.9627F, -0.0873F, 0.0F, 0.0F));
		var rump = body.addOrReplaceChild("rump", CubeListBuilder.create().texOffs(102, 0).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.15F, 1.175F, -0.1745F, 0.0F, 0.0F));
		rump.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(84, 15).addBox(-1.0F, -0.7F, -0.425F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8F, 2.3F, -0.1745F, 0.0F, 0.0F));
		var legRightFront = partDefinition.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 5.1303F, -4.1108F, 0.0909F, 0.0F, 0.0F));
		var legRightFrontUpper = legRightFront.addOrReplaceChild("legRightFrontUpper", CubeListBuilder.create().texOffs(52, 13).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.0911F, 0.0F, 0.0F));
		legRightFrontUpper.addOrReplaceChild("legRightFrontLower", CubeListBuilder.create().texOffs(64, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0911F, 0.0F, 0.0F));
		var legLeftFront = partDefinition.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.1303F, -4.1108F, 0.0909F, 0.0F, 0.0F));
		var legLeftFrontUpper = legLeftFront.addOrReplaceChild("legLeftFrontUpper", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.0911F, 0.0F, 0.0F));
		legLeftFrontUpper.addOrReplaceChild("legLeftFrontLower", CubeListBuilder.create().texOffs(44, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0911F, 0.0F, 0.0F));
		var legRightRear = partDefinition.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(84, 0).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 6.0966F, 10.8634F, -0.4838F, 0.0F, 0.0F));
		var legRightRearUpper = legRightRear.addOrReplaceChild("legRightRearUpper", CubeListBuilder.create().texOffs(49, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.5F, 0.7285F, 0.0F, 0.0F));
		legRightRearUpper.addOrReplaceChild("legRightRearLower", CubeListBuilder.create().texOffs(70, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.2F, 0.2F, -0.2276F, 0.0F, 0.0F));
		var legLeftRear = partDefinition.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(66, 0).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0966F, 10.8634F, -0.4838F, 0.0F, 0.0F));
		var legLeftRearUpper = legLeftRear.addOrReplaceChild("legLeftRearUpper", CubeListBuilder.create().texOffs(72, 13).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.5F, 0.7285F, 0.0F, 0.0F));
		legLeftRearUpper.addOrReplaceChild("legLeftRearLower", CubeListBuilder.create().texOffs(84, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.2F, 0.2F, -0.2276F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 128, 48);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
