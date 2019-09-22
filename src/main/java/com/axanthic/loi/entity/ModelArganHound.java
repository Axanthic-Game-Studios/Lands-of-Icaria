package com.axanthic.loi.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelArganHound extends ModelBase {
	public ModelRenderer body_front;
	public ModelRenderer body_back;
	public ModelRenderer tail;
	public ModelRenderer head;
	public ModelRenderer ear_right;
	public ModelRenderer ear_left;
	public ModelRenderer mouth;
	public ModelRenderer leg_front_left;
	public ModelRenderer leg_back_left;
	public ModelRenderer leg_front_right;
	public ModelRenderer leg_back_right;
	public ModelRenderer leg_front_right_c;
	public ModelRenderer leg_front_left_c;
	public ModelRenderer leg_back_right_c;
	public ModelRenderer leg_back_left_c;
	public ModelRenderer foot_front_right;
	public ModelRenderer foot_back_right;
	public ModelRenderer foot_front_left;
	public ModelRenderer foot_back_left;

	public ModelArganHound() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.mouth = new ModelRenderer(this, 0, 10);
		this.mouth.setRotationPoint(-1.0F, 13.5F, -8.5F);
		this.mouth.addBox(-0.5F, 0.0F, -5.0F, 3, 3, 4, 0.0F);
		this.leg_back_left_c = new ModelRenderer(this, 0, 22);
		this.leg_back_left_c.setRotationPoint(1.5F, 19.7F, 7.8F);
		this.leg_back_left_c.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.2F);
		this.setRotateAngle(leg_back_left_c, -0.39269908169872414F, 0.0F, 0.0F);
		this.leg_back_left = new ModelRenderer(this, 0, 18);
		this.leg_back_left.setRotationPoint(0.5F, 16.0F, 7.0F);
		this.leg_back_left.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(leg_back_left, 0.19634954084936207F, 0.0F, 0.0F);
		this.leg_front_right_c = new ModelRenderer(this, 0, 22);
		this.leg_front_right_c.setRotationPoint(-2.5F, 19.7F, -3.2F);
		this.leg_front_right_c.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.2F);
		this.setRotateAngle(leg_front_right_c, -0.39269908169872414F, 0.0F, 0.0F);
		this.foot_back_right = new ModelRenderer(this, 0, 18);
		this.foot_back_right.setRotationPoint(-2.5F, 23.0F, 6.2F);
		this.foot_back_right.addBox(0.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
		this.tail = new ModelRenderer(this, 9, 18);
		this.tail.setRotationPoint(-1.0F, 13.0F, 8.5F);
		this.tail.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.foot_front_right = new ModelRenderer(this, 0, 18);
		this.foot_front_right.setRotationPoint(-3.5F, 23.0F, -4.8F);
		this.foot_front_right.addBox(0.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
		this.leg_front_left_c = new ModelRenderer(this, 0, 22);
		this.leg_front_left_c.setRotationPoint(2.5F, 19.7F, -3.2F);
		this.leg_front_left_c.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.2F);
		this.setRotateAngle(leg_front_left_c, -0.39269908169872414F, 0.0F, 0.0F);
		this.foot_back_left = new ModelRenderer(this, 0, 18);
		this.foot_back_left.setRotationPoint(0.5F, 23.0F, 6.2F);
		this.foot_back_left.addBox(0.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
		this.body_front = new ModelRenderer(this, 21, 0);
		this.body_front.setRotationPoint(-1.0F, 14.0F, -2.8F);
		this.body_front.addBox(-3.0F, -3.0F, -3.0F, 8, 6, 7, 0.2F);
		this.setRotateAngle(body_front, 1.5707963267948966F, 0.0F, 0.0F);
		this.body_back = new ModelRenderer(this, 18, 14);
		this.body_back.setRotationPoint(0.0F, 14.0F, 2.0F);
		this.body_back.addBox(-3.0F, -2.0F, -3.0F, 6, 9, 6, 0.2F);
		this.setRotateAngle(body_back, 1.3962634015954636F, 0.0F, -0.01377094091514014F);
		this.leg_back_right_c = new ModelRenderer(this, 0, 22);
		this.leg_back_right_c.setRotationPoint(-1.5F, 19.7F, 7.8F);
		this.leg_back_right_c.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.2F);
		this.setRotateAngle(leg_back_right_c, -0.39269908169872414F, 0.0F, 0.0F);
		this.leg_front_left = new ModelRenderer(this, 0, 18);
		this.leg_front_left.setRotationPoint(1.5F, 16.0F, -4.0F);
		this.leg_front_left.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(leg_front_left, 0.19634954084936207F, 0.0F, 0.0F);
		this.leg_front_right = new ModelRenderer(this, 0, 18);
		this.leg_front_right.setRotationPoint(-3.5F, 16.0F, -4.0F);
		this.leg_front_right.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(leg_front_right, 0.19634954084936207F, 0.0F, 0.0F);
		this.ear_left = new ModelRenderer(this, 16, 14);
		this.ear_left.setRotationPoint(-1.0F, 13.5F, -8.0F);
		this.ear_left.addBox(2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
		this.ear_right = new ModelRenderer(this, 16, 14);
		this.ear_right.setRotationPoint(-1.0F, 13.5F, -8.0F);
		this.ear_right.addBox(-2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
		this.leg_back_right = new ModelRenderer(this, 0, 18);
		this.leg_back_right.setRotationPoint(-2.5F, 16.0F, 7.0F);
		this.leg_back_right.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(leg_back_right, 0.19634954084936207F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(-1.0F, 13.5F, -7.5F);
		this.head.addBox(-2.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
		this.foot_front_left = new ModelRenderer(this, 0, 18);
		this.foot_front_left.setRotationPoint(1.5F, 23.0F, -4.8F);
		this.foot_front_left.addBox(0.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.scale(1.5F, 1.5F, 1.5F);
		GlStateManager.translate(0.0F, -8.0F * scale, 0.0F);
		this.mouth.render(scale);
		this.leg_back_left_c.render(scale);
		this.leg_back_left.render(scale);
		this.leg_front_right_c.render(scale);
		this.foot_back_right.render(scale);
		this.tail.render(scale);
		this.foot_front_right.render(scale);
		this.leg_front_left_c.render(scale);
		this.foot_back_left.render(scale);
		this.body_front.render(scale);
		this.body_back.render(scale);
		this.leg_back_right_c.render(scale);
		this.leg_front_left.render(scale);
		this.leg_front_right.render(scale);
		this.ear_left.render(scale);
		this.ear_right.render(scale);
		this.leg_back_right.render(scale);
		this.head.render(scale);
		this.foot_front_left.render(scale);
		GlStateManager.popMatrix();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}