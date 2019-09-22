package com.axanthic.blab.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelArachne extends ModelBase {
	public ModelRenderer body_center;
	public ModelRenderer head;
	public ModelRenderer body_tail;
	public ModelRenderer leg_left_back;
	public ModelRenderer leg_left_center_back;
	public ModelRenderer leg_left_center_front;
	public ModelRenderer leg_left_front;
	public ModelRenderer leg_right_back;
	public ModelRenderer leg_right_center_back;
	public ModelRenderer leg_right_center_front;
	public ModelRenderer leg_right_front;
	public ModelRenderer body;
	public ModelRenderer arm_left;
	public ModelRenderer arm_right;

	public ModelArachne() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 6.0F, -5.4F);
		this.head.addBox(-4.0F, -7.0F, -4.0F, 8, 8, 8, -1.0F);
		this.setRotateAngle(head, 0.2617993877991494F, 0.0F, 0.0F);
		this.leg_left_center_front = new ModelRenderer(this, 24, 0);
		this.leg_left_center_front.setRotationPoint(2.0F, 15.0F, 0.0F);
		this.leg_left_center_front.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
		this.setRotateAngle(leg_left_center_front, 0.0F, 0.39269908169872414F, 0.5811946409141118F);
		this.leg_left_back = new ModelRenderer(this, 24, 0);
		this.leg_left_back.setRotationPoint(2.0F, 15.0F, 4.0F);
		this.leg_left_back.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
		this.setRotateAngle(leg_left_back, 0.0F, -0.7853981633974483F, 0.7853981633974483F);
		this.leg_right_center_front = new ModelRenderer(this, 24, 0);
		this.leg_right_center_front.setRotationPoint(-2.0F, 15.0F, 0.0F);
		this.leg_right_center_front.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
		this.setRotateAngle(leg_right_center_front, 0.0F, -0.39269908169872414F, -0.5811946409141118F);
		this.body_center = new ModelRenderer(this, 0, 16);
		this.body_center.setRotationPoint(0.0F, 15.0F, -1.0F);
		this.body_center.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 8, -1.0F);
		this.body_tail = new ModelRenderer(this, 0, 45);
		this.body_tail.setRotationPoint(1.0F, 16.5F, 7.0F);
		this.body_tail.addBox(-5.0F, -4.0F, -6.0F, 8, 7, 12, -1.0F);
		this.setRotateAngle(body_tail, -0.2617993877991494F, 0.0F, 0.0F);
		this.leg_right_front = new ModelRenderer(this, 24, 0);
		this.leg_right_front.setRotationPoint(-2.0F, 15.0F, -2.0F);
		this.leg_right_front.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
		this.setRotateAngle(leg_right_front, 0.0F, -0.7853981633974483F, -0.7853981633974483F);
		this.leg_left_front = new ModelRenderer(this, 24, 0);
		this.leg_left_front.setRotationPoint(2.0F, 15.0F, -2.0F);
		this.leg_left_front.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
		this.setRotateAngle(leg_left_front, 0.0F, 0.7853981633974483F, 0.7853981633974483F);
		this.arm_left = new ModelRenderer(this, 32, 4);
		this.arm_left.setRotationPoint(6.0F, 13.0F, -0.5F);
		this.arm_left.addBox(-4.0F, -4.0F, -8.0F, 4, 12, 4, -0.8F);
		this.setRotateAngle(arm_left, -0.4363323129985824F, 0.0F, -0.08726646259971647F);
		this.arm_right = new ModelRenderer(this, 32, 4);
		this.arm_right.setRotationPoint(-2.0F, 13.0F, -0.5F);
		this.arm_right.addBox(-4.0F, -4.0F, -8.0F, 4, 12, 4, -0.8F);
		this.setRotateAngle(arm_right, -0.4363323129985824F, 0.0F, 0.08726646259971647F);
		this.body = new ModelRenderer(this, 28, 20);
		this.body.setRotationPoint(0.5F, 8.0F, 0.0F);
		this.body.addBox(-4.0F, -4.0F, -8.0F, 7, 14, 6, -1.0F);
		this.setRotateAngle(body, 0.13962634015954636F, 0.0F, 0.0F);
		this.leg_left_center_back = new ModelRenderer(this, 24, 0);
		this.leg_left_center_back.setRotationPoint(2.0F, 15.0F, 2.0F);
		this.leg_left_center_back.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
		this.setRotateAngle(leg_left_center_back, 0.0F, -0.39269908169872414F, 0.5811946409141118F);
		this.leg_right_back = new ModelRenderer(this, 24, 0);
		this.leg_right_back.setRotationPoint(-2.0F, 15.0F, 4.0F);
		this.leg_right_back.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
		this.setRotateAngle(leg_right_back, 0.0F, 0.7853981633974483F, -0.7853981633974483F);
		this.leg_right_center_back = new ModelRenderer(this, 24, 0);
		this.leg_right_center_back.setRotationPoint(-2.0F, 15.0F, 2.0F);
		this.leg_right_center_back.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
		this.setRotateAngle(leg_right_center_back, 0.0F, 0.39269908169872414F, -0.5811946409141118F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		GlStateManager.pushMatrix();
		this.head.render(f5);
		this.leg_left_center_front.render(f5);
		this.leg_left_back.render(f5);
		this.leg_right_center_front.render(f5);
		this.body_center.render(f5);
		this.body_tail.render(f5);
		this.leg_right_front.render(f5);
		this.leg_left_front.render(f5);
		this.arm_left.render(f5);
		this.arm_right.render(f5);
		this.body.render(f5);
		this.leg_left_center_back.render(f5);
		this.leg_right_back.render(f5);
		this.leg_right_center_back.render(f5);
		GlStateManager.popMatrix();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.head.rotateAngleX = 0.2617993877991494F + headPitch * 0.017453292F;

		//this.arm_left.rotateAngleX = -0.4363323129985824F + MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		//this.arm_right.rotateAngleX = -0.4363323129985824F + MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
		float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
		float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
		float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
		this.leg_right_back.rotateAngleY = 0.7853981633974483F + f3;
		this.leg_left_back.rotateAngleY = -0.7853981633974483F - f3;
		this.leg_right_center_back.rotateAngleY = 0.39269908169872414F + f4;
		this.leg_left_center_back.rotateAngleY = -0.39269908169872414F - f4;
		this.leg_right_center_front.rotateAngleY = -0.39269908169872414F + f5;
		this.leg_left_center_front.rotateAngleY = 0.39269908169872414F - f5;
		this.leg_right_front.rotateAngleY = -0.7853981633974483F + f6;
		this.leg_left_front.rotateAngleY = 0.7853981633974483F - f6;
		this.leg_right_back.rotateAngleZ = -0.7853981633974483F + f7;
		this.leg_left_back.rotateAngleZ = 0.7853981633974483F - f7;
		this.leg_right_center_back.rotateAngleZ = -0.5811946409141118F + f8;
		this.leg_left_center_back.rotateAngleZ = 0.5811946409141118F - f8;
		this.leg_right_center_front.rotateAngleZ = -0.5811946409141118F + f9;
		this.leg_left_center_front.rotateAngleZ = 0.5811946409141118F - f9;
		this.leg_right_front.rotateAngleZ = -0.7853981633974483F + f10;
		this.leg_left_front.rotateAngleZ = 0.7853981633974483F - f10;
	}
}
