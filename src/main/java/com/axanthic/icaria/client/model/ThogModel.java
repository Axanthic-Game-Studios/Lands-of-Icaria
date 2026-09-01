package com.axanthic.icaria.client.model;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.registry.IcariaAnimationDefinitions;
import com.axanthic.icaria.client.state.ThogRenderState;
import com.axanthic.icaria.common.math.IcariaMath;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.util.Mth;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ThogModel extends EntityModel<ThogRenderState> {
	public ModelPart body;
	public ModelPart shoulder;
	public ModelPart head;
	public ModelPart forehead;
	public ModelPart earLeft;
	public ModelPart earRight;
	public ModelPart neck;
	public ModelPart nose;
	public ModelPart jaw;
	public ModelPart tuskLeftAdult;
	public ModelPart tuskRightAdult;
	public ModelPart tuskLeftTeen;
	public ModelPart tuskRightTeen;
	public ModelPart tuskLeftChild;
	public ModelPart tuskRightChild;
	public ModelPart thighLeftFront;
	public ModelPart legLeftFront;
	public ModelPart thighRightFront;
	public ModelPart legRightFront;
	public ModelPart hair;
	public ModelPart bodyMain;
	public ModelPart bodyCenter;
	public ModelPart bodyRear;
	public ModelPart tail;
	public ModelPart bushel;
	public ModelPart thighLeftRear;
	public ModelPart legLeftRear;
	public ModelPart thighRightRear;
	public ModelPart legRightRear;

	public ThogModel(ModelPart pModelPart) {
		super(pModelPart);
		this.body = this.root.getChild("body");
		this.shoulder = this.body.getChild("shoulder");
		this.head = this.body.getChild("head");
		this.forehead = this.head.getChild("forehead");
		this.earLeft = this.forehead.getChild("earLeft");
		this.earRight = this.forehead.getChild("earRight");
		this.neck = this.head.getChild("neck");
		this.nose = this.head.getChild("nose");
		this.jaw = this.head.getChild("jaw");
		this.tuskLeftAdult = this.jaw.getChild("tuskLeftAdult");
		this.tuskRightAdult = this.jaw.getChild("tuskRightAdult");
		this.tuskLeftTeen = this.jaw.getChild("tuskLeftTeen");
		this.tuskRightTeen = this.jaw.getChild("tuskRightTeen");
		this.tuskLeftChild = this.jaw.getChild("tuskLeftChild");
		this.tuskRightChild = this.jaw.getChild("tuskRightChild");
		this.thighLeftFront = this.body.getChild("thighLeftFront");
		this.legLeftFront = this.thighLeftFront.getChild("legLeftFront");
		this.thighRightFront = this.body.getChild("thighRightFront");
		this.legRightFront = this.thighRightFront.getChild("legRightFront");
		this.hair = this.body.getChild("hair");
		this.bodyMain = this.body.getChild("bodyMain");
		this.bodyCenter = this.bodyMain.getChild("bodyCenter");
		this.bodyRear = this.bodyCenter.getChild("bodyRear");
		this.tail = this.bodyRear.getChild("tail");
		this.bushel = this.tail.getChild("bushel");
		this.thighLeftRear = this.bodyCenter.getChild("thighLeftRear");
		this.legLeftRear = this.thighLeftRear.getChild("legLeftRear");
		this.thighRightRear = this.bodyCenter.getChild("thighRightRear");
		this.legRightRear = this.thighRightRear.getChild("legRightRear");
	}

	@Override
	public void setupAnim(ThogRenderState pRenderState) {
		super.setupAnim(pRenderState);

		this.lookAnim(pRenderState.xRot, pRenderState.yRot);
		this.walkAnim(pRenderState.size, pRenderState.walkAnimationPos, pRenderState.walkAnimationSpeed);

		IcariaClientHelper.anim(IcariaAnimationDefinitions.THOG_ATTACK, pRenderState.attackAnimationState, pRenderState.ageInTicks, this.root);
		IcariaClientHelper.anim(IcariaAnimationDefinitions.THOG_EATING, pRenderState.eatingAnimationState, pRenderState.ageInTicks, this.root);

		this.tuskRightChild.visible = pRenderState.size == 2;
		this.tuskLeftChild.visible = pRenderState.size == 2;
		this.tuskRightTeen.visible = pRenderState.size == 3;
		this.tuskLeftTeen.visible = pRenderState.size == 3;
		this.tuskRightAdult.visible = pRenderState.size == 4;
		this.tuskLeftAdult.visible = pRenderState.size == 4;
	}

	public void lookAnim(float pXRot, float pYRot) {
		this.head.xRot = IcariaMath.rad(pXRot);
		this.head.yRot = IcariaMath.rad(pYRot);
	}

	public void walkAnim(float pSize, float pWalkAnimationPos, float pWalkAnimationSpeed) {
		pWalkAnimationPos *= Mth.lerp(pSize, 0.5F, 1.0F);

		this.root.y = Mth.sin(pWalkAnimationPos) * pWalkAnimationSpeed * 0.5F;

		this.thighRightFront.xRot = Mth.cos(pWalkAnimationPos * 0.5F + Mth.PI * 0.0F) * pWalkAnimationSpeed - 0.0873F;
		this.legRightFront.xRot = Mth.sin((pWalkAnimationPos + Mth.sin(pWalkAnimationPos + Mth.PI * 0.0F)) * 0.5F + Mth.PI * 0.0F) * pWalkAnimationSpeed + pWalkAnimationSpeed + 0.0873F;
		this.thighLeftFront.xRot = Mth.cos(pWalkAnimationPos * 0.5F + Mth.PI * 1.0F) * pWalkAnimationSpeed - 0.0873F;
		this.legLeftFront.xRot = Mth.sin((pWalkAnimationPos + Mth.sin(pWalkAnimationPos + Mth.PI * 0.5F)) * 0.5F + Mth.PI * 1.0F) * pWalkAnimationSpeed + pWalkAnimationSpeed + 0.0873F;
		this.thighRightRear.xRot = Mth.cos(pWalkAnimationPos * 0.5F + Mth.PI * 1.5F) * pWalkAnimationSpeed + 0.0873F;
		this.legRightRear.xRot = Mth.sin((pWalkAnimationPos + Mth.sin(pWalkAnimationPos + Mth.PI * 0.75F)) * 0.5F + Mth.PI * 1.5F) * pWalkAnimationSpeed + pWalkAnimationSpeed - 0.0873F;
		this.thighLeftRear.xRot = Mth.cos(pWalkAnimationPos * 0.5F + Mth.PI * 0.5F) * pWalkAnimationSpeed + 0.0873F;
		this.legLeftRear.xRot = Mth.sin((pWalkAnimationPos + Mth.sin(pWalkAnimationPos + Mth.PI * 0.25F)) * 0.5F + Mth.PI * 0.5F) * pWalkAnimationSpeed + pWalkAnimationSpeed - 0.0873F;

		this.tail.xRot = Mth.sin(pWalkAnimationPos) * pWalkAnimationSpeed * 0.5F + 0.4363F;
	}

	public static LayerDefinition createLayer() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(20, 29).addBox(-5.0F, -5.5F, -5.0F, 10.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.5F, -4.0F));
		body.addOrReplaceChild("shoulder", CubeListBuilder.create().texOffs(46, 59).addBox(-6.0F, -3.0F, -2.5F, 12.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -1.5F));
		var head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 17).addBox(-4.5F, -2.5F, -5.0F, 9.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -5.0F));
		var forehead = head.addOrReplaceChild("forehead", CubeListBuilder.create().texOffs(28, 7).addBox(-3.5F, -1.65F, -3.6F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.6F, -1.55F, 0.0873F, 0.0F, 0.0F));
		forehead.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(16, 24).addBox(-1.775F, -2.3F, -0.325F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -1.65F, -0.95F, -0.2182F, 0.0F, 0.6545F));
		forehead.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(56, 24).addBox(-1.225F, -2.3F, -0.325F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -1.65F, -0.95F, -0.2182F, 0.0F, -0.6545F));
		head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(11, 1).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7F, -1.9F, -0.0873F, 0.0F, 0.0F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(31, 0).addBox(-2.5F, -1.5F, -4.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -5.0F));
		var jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(49, 0).addBox(-2.5F, -0.5F, -4.55F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.9F, -3.95F, 0.0873F, 0.0F, 0.0F));
		jaw.addOrReplaceChild("tuskLeftAdult", CubeListBuilder.create().texOffs(22, 12).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.0F, -2.5F, -3.35F, 0.3927F, 0.0F, 0.0873F));
		jaw.addOrReplaceChild("tuskRightAdult", CubeListBuilder.create().texOffs(56, 12).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.0F, -2.5F, -3.35F, 0.3927F, 0.0F, -0.0873F));
		jaw.addOrReplaceChild("tuskLeftTeen", CubeListBuilder.create().texOffs(22, 12).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.0F, -2.5F, -3.35F, 0.3927F, 0.0F, 0.0873F));
		jaw.addOrReplaceChild("tuskRightTeen", CubeListBuilder.create().texOffs(56, 12).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.0F, -2.5F, -3.35F, 0.3927F, 0.0F, -0.0873F));
		jaw.addOrReplaceChild("tuskLeftChild", CubeListBuilder.create().texOffs(22, 12).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.0F, -2.5F, -3.35F, 0.3927F, 0.0F, 0.0873F));
		jaw.addOrReplaceChild("tuskRightChild", CubeListBuilder.create().texOffs(56, 12).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.0F, -2.5F, -3.35F, 0.3927F, 0.0F, -0.0873F));
		var thighLeftFront = body.addOrReplaceChild("thighLeftFront", CubeListBuilder.create().texOffs(0, 21).addBox(-2.5F, -1.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.5F, -2.0F, -0.0873F, -0.0873F, 0.0F));
		thighLeftFront.addOrReplaceChild("legLeftFront", CubeListBuilder.create().texOffs(1, 29).addBox(-2.0F, -0.4F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0873F, 0.0F, 0.0F));
		var thighRightFront = body.addOrReplaceChild("thighRightFront", CubeListBuilder.create().texOffs(64, 21).addBox(-1.5F, -1.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 5.5F, -2.0F, -0.0873F, 0.0873F, 0.0F));
		thighRightFront.addOrReplaceChild("legRightFront", CubeListBuilder.create().texOffs(65, 29).addBox(-1.0F, -0.4F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0873F, 0.0F, 0.0F));
		body.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(0, -10).addBox(0.0F, -2.5F, -8.5F, 0.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.75F, 2.0F));
		var bodyMain = body.addOrReplaceChild("bodyMain", CubeListBuilder.create().texOffs(25, 50).addBox(-4.5F, -5.0F, -1.5F, 9.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, -0.0873F, 0.0F, 0.0F));
		var bodyCenter = bodyMain.addOrReplaceChild("bodyCenter", CubeListBuilder.create().texOffs(21, 63).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));
		var bodyRear = bodyCenter.addOrReplaceChild("bodyRear", CubeListBuilder.create().texOffs(3, 70).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, 0.0873F, 0.0F, 0.0F));
		var tail = bodyRear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(53, 73).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 1.0F, 0.4363F, 0.0F, 0.0F));
		tail.addOrReplaceChild("bushel", CubeListBuilder.create().texOffs(59, 72).addBox(-1.5F, -0.3F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var thighLeftRear = bodyCenter.addOrReplaceChild("thighLeftRear", CubeListBuilder.create().texOffs(10, 41).addBox(-1.1F, -1.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, 4.0F, 2.0F, 0.0873F, 0.0873F, 0.0F));
		thighLeftRear.addOrReplaceChild("legLeftRear", CubeListBuilder.create().texOffs(8, 50).addBox(-1.5F, -0.3F, -2.025F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.1F, 3.925F, 0.0F, -0.0873F, 0.0F, 0.0F));
		var thighRightRear = bodyCenter.addOrReplaceChild("thighRightRear", CubeListBuilder.create().texOffs(60, 41).addBox(-0.9F, -1.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6F, 4.0F, 2.0F, 0.0873F, -0.0873F, 0.0F));
		thighRightRear.addOrReplaceChild("legRightRear", CubeListBuilder.create().texOffs(58, 50).addBox(-1.5F, -0.3F, -2.025F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.1F, 3.925F, 0.0F, -0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 80, 80);
	}
}
