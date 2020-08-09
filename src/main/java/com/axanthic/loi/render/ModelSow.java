package com.axanthic.loi.render;

import com.axanthic.loi.entity.EntitySow;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSow extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer body_rear;
	public ModelRenderer head;
	public ModelRenderer muscles_front;
	public ModelRenderer muscles_rear;
	public ModelRenderer tail;
	public ModelRenderer hair;
	public ModelRenderer nose;
	public ModelRenderer jaw;
	public ModelRenderer ear_right;
	public ModelRenderer ear_left;
	public ModelRenderer hair_rear;
	public ModelRenderer tusk_l;
	public ModelRenderer tusk_r;
	public ModelRenderer leg_front_left;
	public ModelRenderer leg_front_right;
	public ModelRenderer leg_rear_right;
	public ModelRenderer leg_rear_left;

	public ModelSow() {
		this.textureWidth = 64;
		this.textureHeight = 48;
		this.jaw = new ModelRenderer(this, 0, 3);
		this.jaw.setRotationPoint(0.0F, 2.0F, -8.0F);
		this.jaw.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 3, 0.0F);
		this.tail = new ModelRenderer(this, 0, 0);
		this.tail.setRotationPoint(0.0F, 2.5F, 2.0F);
		this.tail.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(tail, 0.5918411493512771F, 0.0F, 0.0F);
		this.hair_rear = new ModelRenderer(this, 0, 28);
		this.hair_rear.setRotationPoint(0.01F, -2.0F, 5.0F);
		this.hair_rear.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 9, 0.0F);
		this.setRotateAngle(hair_rear, -0.39269908169872414F, 0.0F, 0.0F);
		this.hair = new ModelRenderer(this, 42, 26);
		this.hair.setRotationPoint(0.0F, -2.5F, -4.1F);
		this.hair.addBox(-1.0F, -2.0F, -3.0F, 2, 2, 8, 0.0F);
		this.setRotateAngle(hair, 0.00942477796076938F, 0.0F, 0.0F);
		this.nose = new ModelRenderer(this, 47, 0);
		this.nose.setRotationPoint(0.0F, 0.0F, -6.5F);
		this.nose.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 4, 0.0F);
		this.setRotateAngle(nose, 0.18203784098300857F, 0.0F, 0.0F);
		this.muscles_rear = new ModelRenderer(this, 24, 25);
		this.muscles_rear.setRotationPoint(0.0F, 3.25F, 0.9F);
		this.muscles_rear.addBox(-4.5F, -4.5F, 1.0F, 9, 5, 4, 0.0F);
		this.setRotateAngle(muscles_rear, 0.091106186954104F, 0.0F, 0.0F);
		this.ear_right = new ModelRenderer(this, 47, 6);
		this.ear_right.setRotationPoint(-2.5F, -0.4F, -2.5F);
		this.ear_right.addBox(-2.0F, -1.0F, -0.5F, 3, 2, 1, 0.0F);
		this.setRotateAngle(ear_right, 0.36425021489121656F, 0.0F, 2.0943951023931953F);
		this.body_rear = new ModelRenderer(this, 27, 0);
		this.body_rear.setRotationPoint(0.0F, -4.5F, 4.0F);
		this.body_rear.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 3, 0.0F);
		this.setRotateAngle(body_rear, -0.15533430342749532F, 0.0F, 0.0F);
		this.leg_front_left = new ModelRenderer(this, 48, 9);
		this.leg_front_left.setRotationPoint(3.0F, -0.25F, -5.0F);
		this.leg_front_left.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.muscles_front = new ModelRenderer(this, 0, 19);
		this.muscles_front.setRotationPoint(0.0F, 3.25F, 0.5F);
		this.muscles_front.addBox(-5.0F, -4.5F, -7.0F, 10, 5, 4, 0.0F);
		this.setRotateAngle(muscles_front, 0.091106186954104F, 0.0F, 0.0F);
		this.leg_rear_right = new ModelRenderer(this, 34, 36);
		this.leg_rear_right.setRotationPoint(-2.5F, -0.25F, 3.0F);
		this.leg_rear_right.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.tusk_r = new ModelRenderer(this, 47, 0);
		this.tusk_r.setRotationPoint(-1.5F, 1.5F, -2.2F);
		this.tusk_r.addBox(-0.5F, -2.0F, -1.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(tusk_r, 0.0F, 0.0F, -0.39269908169872414F);
		this.leg_front_right = new ModelRenderer(this, 22, 34);
		this.leg_front_right.setRotationPoint(-3.0F, -0.25F, -5.0F);
		this.leg_front_right.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.head = new ModelRenderer(this, 30, 11);
		this.head.setRotationPoint(0.0F, -0.5F, -5.0F);
		this.head.addBox(-2.5F, -3.0F, -7.0F, 5, 6, 8, 0.0F);
		this.setRotateAngle(head, 0.17453292519943295F, 0.0F, 0.0F);
		this.leg_rear_left = new ModelRenderer(this, 46, 36);
		this.leg_rear_left.setRotationPoint(2.5F, -0.25F, 3.0F);
		this.leg_rear_left.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.tusk_l = new ModelRenderer(this, 7, 0);
		this.tusk_l.setRotationPoint(1.5F, 1.5F, -2.2F);
		this.tusk_l.addBox(-0.5F, -2.0F, -1.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(tusk_l, 0.0F, 0.0F, 0.39269908169872414F);
		this.ear_left = new ModelRenderer(this, 55, 6);
		this.ear_left.setRotationPoint(2.5F, -0.4F, -2.5F);
		this.ear_left.addBox(-2.0F, -1.0F, -0.5F, 3, 2, 1, 0.0F);
		this.setRotateAngle(ear_left, -0.36425021489121656F, 0.0F, 1.0471975511965976F);
		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.body.addBox(-4.0F, -4.5F, -7.0F, 8, 8, 11, 0.0F);
		this.setRotateAngle(body, -0.091106186954104F, 0.0F, 0.0F);
		this.head.addChild(this.jaw);
		this.body_rear.addChild(this.tail);
		this.hair.addChild(this.hair_rear);
		this.head.addChild(this.hair);
		this.head.addChild(this.nose);
		this.body.addChild(this.muscles_rear);
		this.head.addChild(this.ear_right);
		this.body.addChild(this.body_rear);
		this.muscles_front.addChild(this.leg_front_left);
		this.body.addChild(this.muscles_front);
		this.muscles_rear.addChild(this.leg_rear_right);
		this.nose.addChild(this.tusk_r);
		this.muscles_front.addChild(this.leg_front_right);
		this.body.addChild(this.head);
		this.muscles_rear.addChild(this.leg_rear_left);
		this.nose.addChild(this.tusk_l);
		this.head.addChild(this.ear_left);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (((EntitySow) entity).isChild()) {
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
			this.tusk_r.isHidden = true;
			this.tusk_l.isHidden = true;
		} else {
			this.tusk_r.isHidden = false;
			this.tusk_l.isHidden = false;
		}
		this.body.render(scale);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	static float kneebend = 0.9F;

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F + 0.17453292519943295F;
		this.head.rotateAngleY = netHeadYaw * 0.005F;

		limbSwing *= 1.8;

		this.leg_front_right.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 0.9F * limbSwingAmount;
		this.leg_front_left.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI) * 0.9F * limbSwingAmount;
		this.leg_rear_right.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI * 1.5F) * 0.9F * limbSwingAmount;
		this.leg_rear_left.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI * 0.5F) * 0.9F * limbSwingAmount;
	}
}