package com.axanthic.loi.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCerver extends ModelBase {
	public ModelRenderer body_front;
	public ModelRenderer leg_right_front;
	public ModelRenderer leg_left_front;
	public ModelRenderer neck;
	public ModelRenderer body_back;
	public ModelRenderer head;
	public ModelRenderer muscle_back;
	public ModelRenderer leg_left_back_top;
	public ModelRenderer leg_right_back_bottom;
	public ModelRenderer leg_left_back_bottom;
	public ModelRenderer paw_left_back;
	public ModelRenderer paw_right_back;
	public ModelRenderer paw_left_front;
	public ModelRenderer paw_right_front;
	public ModelRenderer leg_right_back_top;
	public ModelRenderer tail_front;
	public ModelRenderer frontleg_right;
	public ModelRenderer frontleg_left;
	public ModelRenderer mouth;
	public ModelRenderer ear_right;
	public ModelRenderer ear_left;
	public ModelRenderer tail_rear;

	public ModelCerver() {
		this.textureWidth = 96;
		this.textureHeight = 64;
		this.neck = new ModelRenderer(this, 76, 8);
		this.neck.setRotationPoint(0.0F, 12.0F, -6.0F);
		this.neck.addBox(-2.0F, -3.0F, -5.0F, 4, 4, 6, 0.0F);
		this.setRotateAngle(neck, -0.3909537524467298F, 0.0F, 0.0F);
		this.paw_right_back = new ModelRenderer(this, 16, 33);
		this.paw_right_back.setRotationPoint(-3.0F, 22.0F, 11.8F);
		this.paw_right_back.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(paw_right_back, 0.0F, 0.7853981633974483F, 0.0F);
		this.frontleg_right = new ModelRenderer(this, 0, 16);
		this.frontleg_right.setRotationPoint(0.0F, 5.0F, 0.5F);
		this.frontleg_right.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.setRotateAngle(frontleg_right, 0.21380283336930533F, 0.0F, 0.0F);
		this.frontleg_left = new ModelRenderer(this, 0, 16);
		this.frontleg_left.setRotationPoint(0.0F, 5.0F, 0.5F);
		this.frontleg_left.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.setRotateAngle(frontleg_left, 0.21380283336930533F, 0.0F, 0.0F);
		this.paw_right_front = new ModelRenderer(this, 16, 33);
		this.paw_right_front.setRotationPoint(-4.0F, 22.0F, -7.5F);
		this.paw_right_front.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.1F);
		this.setRotateAngle(paw_right_front, 0.0F, 0.7853981633974483F, 0.0F);
		this.muscle_back = new ModelRenderer(this, 16, 0);
		this.muscle_back.setRotationPoint(-2.5F, 11.0F, 13.4F);
		this.muscle_back.addBox(-1.5F, 0.0F, -2.5F, 8, 6, 6, 0.1F);
		this.setRotateAngle(muscle_back, -0.7853981633974483F, 0.0F, 0.0F);
		this.ear_left = new ModelRenderer(this, 0, 60);
		this.ear_left.setRotationPoint(3.5F, -1.5F, 8.0F);
		this.ear_left.addBox(-2.0F, 0.0F, -10.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(ear_left, 0.0F, 0.0F, 0.7853981633974483F);
		this.tail_front = new ModelRenderer(this, 0, 27);
		this.tail_front.setRotationPoint(0.0F, 12.5F, 14.0F);
		this.tail_front.addBox(-1.0F, 0.0F, -1.5F, 2, 8, 2, 0.0F);
		this.setRotateAngle(tail_front, 0.9992009967667536F, 0.0F, 0.0F);
		this.ear_right = new ModelRenderer(this, 0, 60);
		this.ear_right.setRotationPoint(-0.5F, -1.5F, 8.0F);
		this.ear_right.addBox(-2.0F, 0.0F, -10.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(ear_right, 0.0F, 0.0F, 0.7853981633974483F);
		this.leg_left_back_bottom = new ModelRenderer(this, 16, 23);
		this.leg_left_back_bottom.setRotationPoint(-3.0F, 17.0F, 14.8F);
		this.leg_left_back_bottom.addBox(-1.5F, 0.0F, -2.5F, 3, 7, 3, -0.1F);
		this.setRotateAngle(leg_left_back_bottom, -0.296705972839036F, 0.0F, 0.0F);
		this.leg_right_back_bottom = new ModelRenderer(this, 16, 23);
		this.leg_right_back_bottom.setRotationPoint(3.0F, 17.0F, 14.8F);
		this.leg_right_back_bottom.addBox(-1.5F, 0.0F, -2.5F, 3, 7, 3, -0.1F);
		this.setRotateAngle(leg_right_back_bottom, -0.296705972839036F, 0.0F, 0.0F);
		this.leg_right_back_top = new ModelRenderer(this, 16, 12);
		this.leg_right_back_top.setRotationPoint(-3.0F, 12.5F, 8.5F);
		this.leg_right_back_top.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.setRotateAngle(leg_right_back_top, 0.7853981633974483F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 44, 0);
		this.head.setRotationPoint(0.0F, 7.5F, -9.0F);
		this.head.addBox(-3.0F, -1.0F, -6.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(head, 0.21380283336930533F, 0.0F, 0.0F);
		this.leg_right_front = new ModelRenderer(this, 0, 0);
		this.leg_right_front.setRotationPoint(-4.0F, 10.0F, -4.7F);
		this.leg_right_front.addBox(-2.0F, -4.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(leg_right_front, -0.39269908169872414F, 0.0F, 0.0F);
		this.leg_left_front = new ModelRenderer(this, 0, 0);
		this.leg_left_front.setRotationPoint(4.0F, 10.0F, -4.7F);
		this.leg_left_front.addBox(-2.0F, -4.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(leg_left_front, -0.39269908169872414F, 0.0F, 0.0F);
		this.body_back = new ModelRenderer(this, 40, 47);
		this.body_back.setRotationPoint(-1.0F, 8.5F, 9.8F);
		this.body_back.addBox(-3.0F, 0.2F, -8.0F, 8, 7, 10, 0.0F);
		this.setRotateAngle(body_back, -0.21380283336930533F, 0.0F, 0.0F);
		this.tail_rear = new ModelRenderer(this, 0, 27);
		this.tail_rear.setRotationPoint(0.0F, 6.9F, -0.4F);
		this.tail_rear.addBox(-1.0F, 0.0F, -1.5F, 2, 8, 2, 0.0F);
		this.setRotateAngle(tail_rear, 0.7740535232594852F, 0.0F, 0.0F);
		this.leg_left_back_top = new ModelRenderer(this, 16, 12);
		this.leg_left_back_top.setRotationPoint(3.0F, 12.5F, 8.5F);
		this.leg_left_back_top.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.setRotateAngle(leg_left_back_top, 0.7853981633974483F, 0.0F, 0.0F);
		this.paw_left_back = new ModelRenderer(this, 16, 33);
		this.paw_left_back.setRotationPoint(3.0F, 22.0F, 11.8F);
		this.paw_left_back.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(paw_left_back, 0.0F, 0.7853981633974483F, 0.0F);
		this.mouth = new ModelRenderer(this, 80, 0);
		this.mouth.setRotationPoint(0.5F, 1.5F, 0.0F);
		this.mouth.addBox(-2.0F, 0.0F, -10.0F, 3, 3, 4, 0.0F);
		this.body_front = new ModelRenderer(this, 0, 46);
		this.body_front.setRotationPoint(-2.0F, 8.4F, 0.2F);
		this.body_front.addBox(-3.0F, -1.0F, -8.0F, 10, 8, 10, 0.0F);
		this.setRotateAngle(body_front, 0.21380283336930533F, 0.0F, 0.0F);
		this.paw_left_front = new ModelRenderer(this, 16, 33);
		this.paw_left_front.setRotationPoint(4.0F, 22.0F, -7.5F);
		this.paw_left_front.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.1F);
		this.setRotateAngle(paw_left_front, 0.0F, 0.7853981633974483F, 0.0F);
		this.leg_right_front.addChild(this.frontleg_right);
		this.leg_left_front.addChild(this.frontleg_left);
		this.head.addChild(this.ear_left);
		this.head.addChild(this.ear_right);
		this.tail_front.addChild(this.tail_rear);
		this.head.addChild(this.mouth);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		this.neck.render(f5);
		this.paw_right_back.render(f5);
		this.paw_right_front.render(f5);
		this.muscle_back.render(f5);
		this.tail_front.render(f5);
		this.leg_left_back_bottom.render(f5);
		this.leg_right_back_bottom.render(f5);
		this.leg_right_back_top.render(f5);
		this.head.render(f5);
		this.leg_right_front.render(f5);
		this.leg_left_front.render(f5);
		this.body_back.render(f5);
		this.leg_left_back_top.render(f5);
		this.paw_left_back.render(f5);
		this.body_front.render(f5);
		this.paw_left_front.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F + 0.21380283336930533F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		//this.leg_left_back_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		//this.leg_left_front.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		//this.leg_right_back_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		//this.leg_right_front.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}