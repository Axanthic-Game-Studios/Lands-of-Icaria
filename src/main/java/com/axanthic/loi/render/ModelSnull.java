package com.axanthic.loi.render;

import com.axanthic.loi.entity.EntitySnull;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSnull extends ModelBase {
	public ModelRenderer body_front;
	public ModelRenderer body_head_rear;
	public ModelRenderer head;
	public ModelRenderer head_rear;
	public ModelRenderer skull;
	public ModelRenderer body_rear;
	public ModelRenderer tail;
	public ModelRenderer eye_stalk_right;
	public ModelRenderer eye_stalk_left;
    public ModelRenderer jaw_upper;
    public ModelRenderer jaw_lower;
	public ModelRenderer eye_right;
	public ModelRenderer eye_left;

	public ModelSnull() {
		this.textureWidth = 48;
		this.textureHeight = 32;
		this.body_rear = new ModelRenderer(this, 2, 19);
		this.body_rear.setRotationPoint(0.0F, 22.0F, -8.7F);
		this.body_rear.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 6, 0.1F);
		this.body_front = new ModelRenderer(this, 0, 16);
		this.body_front.setRotationPoint(0.0F, 20.0F, -2.4F);
		this.body_front.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 8, 0.2F);
		this.body_head_rear = new ModelRenderer(this, 24, 0);
		this.body_head_rear.setRotationPoint(0.5F, 19.9F, 4.8F);
		this.body_head_rear.addBox(-3.0F, 0.0F, 0.0F, 5, 4, 4, 0.2F);
		this.setRotateAngle(body_head_rear, 0.29757863746503316F, 0.0F, 0.0F);
		this.tail = new ModelRenderer(this, 4, 21);
		this.tail.setRotationPoint(0.0F, 22.0F, -12.7F);
		this.tail.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 4, -0.1F);
		this.head_rear = new ModelRenderer(this, 24, 0);
		this.head_rear.setRotationPoint(0.5F, 19.7F, 7.2F);
		this.head_rear.addBox(-3.0F, 0.0F, 0.0F, 5, 4, 4, 0.1F);
		this.setRotateAngle(head_rear, 0.7853981633974483F, 0.0F, 0.0F);
		this.eye_right = new ModelRenderer(this, 0, 0);
		this.eye_right.setRotationPoint(-1.5F, -1.8F, -0.5F);
		this.eye_right.addBox(0.5F, -6.0F, -0.5F, 2, 2, 2, 0.0F);
        this.skull = new ModelRenderer(this, 0, 0);
        this.skull.setRotationPoint(0.0F, 22.0F, -3.0F);
        this.skull.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 8, 0.2F);
        this.setRotateAngle(skull, 0.5817182396897099F, 0.0F, 0.0F);
        this.jaw_upper = new ModelRenderer(this, 0, 8);
        this.jaw_upper.setRotationPoint(0.0F, 0.0F, 1.7F);
        this.jaw_upper.addBox(-2.5F, 0.2F, 0.0F, 5, 1, 6, 0.0F);
        this.jaw_lower = new ModelRenderer(this, 0, 9);
        this.jaw_lower.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.jaw_lower.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
        this.setRotateAngle(jaw_lower, -0.091106186954104F, 0.0F, 0.0F);
		this.eye_stalk_right = new ModelRenderer(this, 42, 0);
		this.eye_stalk_right.setRotationPoint(1.9F, 16.1F, 12.3F);
		this.eye_stalk_right.addBox(-0.5F, -6.0F, -0.5F, 1, 6, 1, -0.2F);
		this.setRotateAngle(eye_stalk_right, -0.39269908169872414F, 0.5811946409141118F, 0.13962634015954636F);
		this.eye_stalk_left = new ModelRenderer(this, 42, 0);
		this.eye_stalk_left.setRotationPoint(-1.9F, 16.1F, 12.3F);
		this.eye_stalk_left.addBox(-0.5F, -6.0F, -0.5F, 1, 6, 1, -0.2F);
		this.setRotateAngle(eye_stalk_left, -0.39269908169872414F, -0.5811946409141118F, -0.13962634015954636F);
		this.eye_left = new ModelRenderer(this, 0, 0);
		this.eye_left.setRotationPoint(-0.5F, -1.8F, -0.5F);
		this.eye_left.addBox(-0.4F, -6.0F, -0.5F, 2, 2, 2, 0.0F);
		this.head = new ModelRenderer(this, 24, 16);
		this.head.setRotationPoint(0.5F, 15.7F, 9.0F);
		this.head.addBox(-3.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F);
		this.eye_stalk_right.addChild(this.eye_right);
		this.eye_stalk_left.addChild(this.eye_left);
        this.skull.addChild(this.jaw_upper);
        this.jaw_upper.addChild(this.jaw_lower);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, 0.0F, 0.02F);

		EntitySnull snull = (EntitySnull) entity;
		Float partialTicks = ageInTicks - snull.ticksExisted;
		if (snull.isBesideClimbableBlock() && snull.posY > snull.prevPosY) {
			final float climbSwing = ageInTicks * 0.4f;
			GlStateManager.scale(1.0F, 1.0F, MathHelper.sin(climbSwing * 0.6662F) * -0.3F + 1.05F);
		} else {
			GlStateManager.scale(1.0F, 1.0F, MathHelper.sin(limbSwing * 0.6662F) * -0.3F + 1.05F);
		}

		this.body_rear.render(scale);
		this.body_front.render(scale);
		GlStateManager.popMatrix();
		this.body_head_rear.render(scale);
		this.tail.render(scale);
		this.head_rear.render(scale);
		this.skull.render(scale);
		Double eyescale = 1.0D - entity.hurtResistantTime / 25.0D;
		if (entity.hurtResistantTime > 0.0D) {
			eyescale += partialTicks / 25.0D;
		}
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.eye_stalk_right.offsetX, this.eye_stalk_right.offsetY, this.eye_stalk_right.offsetZ);
		GlStateManager.translate(this.eye_stalk_right.rotationPointX * scale, this.eye_stalk_right.rotationPointY * scale, this.eye_stalk_right.rotationPointZ * scale);
		GlStateManager.scale(eyescale, eyescale, eyescale);
		GlStateManager.translate(-this.eye_stalk_right.offsetX, -this.eye_stalk_right.offsetY, -this.eye_stalk_right.offsetZ);
		GlStateManager.translate(-this.eye_stalk_right.rotationPointX * scale, -this.eye_stalk_right.rotationPointY * scale, -this.eye_stalk_right.rotationPointZ * scale);
		this.eye_stalk_right.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.eye_stalk_left.offsetX, this.eye_stalk_left.offsetY, this.eye_stalk_left.offsetZ);
		GlStateManager.translate(this.eye_stalk_left.rotationPointX * scale, this.eye_stalk_left.rotationPointY * scale, this.eye_stalk_left.rotationPointZ * scale);
		GlStateManager.scale(eyescale, eyescale, eyescale);
		GlStateManager.translate(-this.eye_stalk_left.offsetX, -this.eye_stalk_left.offsetY, -this.eye_stalk_left.offsetZ);
		GlStateManager.translate(-this.eye_stalk_left.rotationPointX * scale, -this.eye_stalk_left.rotationPointY * scale, -this.eye_stalk_left.rotationPointZ * scale);
		this.eye_stalk_left.render(scale);
		GlStateManager.popMatrix();
		this.head.render(scale);
		GlStateManager.popMatrix();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		EntitySnull snull = (EntitySnull) entityIn;
		if (snull.isBesideClimbableBlock() && snull.posY > snull.prevPosY) {
			final float climbSwing = ageInTicks * 0.4f;
			this.tail.rotationPointZ = -12.7F + getStretch(climbSwing);
			this.body_head_rear.rotationPointZ = 4.8F - getStretch(climbSwing);
			this.head_rear.rotationPointZ = 7.2F - getStretch(climbSwing);
			this.head.rotationPointZ = 9.0F - getStretch(climbSwing);
			this.eye_stalk_left.rotationPointZ = 12.3F - getStretch(climbSwing);
			this.eye_stalk_right.rotationPointZ = 12.3F - getStretch(climbSwing);

		} else {
			this.tail.rotationPointZ = -12.7F + getStretch(limbSwing);
			this.body_head_rear.rotationPointZ = 4.8F - getStretch(limbSwing);
			this.head_rear.rotationPointZ = 7.2F - getStretch(limbSwing);
			this.head.rotationPointZ = 9.0F - getStretch(limbSwing);
			this.eye_stalk_left.rotationPointZ = 12.3F - getStretch(limbSwing);
			this.eye_stalk_right.rotationPointZ = 12.3F - getStretch(limbSwing);

		}
		this.eye_stalk_left.rotateAngleZ = MathHelper.cos(ageInTicks * 0.09F + 1.0F) * 0.08F - 0.13962634015954636F;
		this.eye_stalk_right.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.09F + 2.0F) * 0.08F + 0.13962634015954636F;
		this.eye_stalk_left.rotateAngleX = MathHelper.sin(ageInTicks * 0.067F + 3.0F) * 0.08F - 0.39269908169872414F;
		this.eye_stalk_right.rotateAngleX = -MathHelper.sin(ageInTicks * 0.067F + 4.0F) * 0.08F - 0.39269908169872414F;
	}

	public float getStretch(float ticks) {
		return MathHelper.sin(ticks * 0.6662F) * 2.5F;
	}
}
