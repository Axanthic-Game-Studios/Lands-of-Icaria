package com.axanthic.blab.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSow extends ModelBase {
	public ModelRenderer body_main;
	public ModelRenderer leg_left_back;
	public ModelRenderer muscle_front;
	public ModelRenderer leg_right_back;
	public ModelRenderer leg_right_front;
	public ModelRenderer leg_left_front;
	public ModelRenderer muscle_back;
	public ModelRenderer head;
	public ModelRenderer adder;
	public ModelRenderer snout;
	public ModelRenderer horn;
	public ModelRenderer horn_1;

	public ModelSow() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.muscle_back = new ModelRenderer(this, 28, 10);
		this.muscle_back.setRotationPoint(-4.0F, 12.0F, 6.0F);
		this.muscle_back.addBox(-2.0F, 0.0F, -2.0F, 12, 8, 6, 0.0F);
		this.muscle_front = new ModelRenderer(this, 28, 10);
		this.muscle_front.setRotationPoint(-4.0F, 10.0F, -5.0F);
		this.muscle_front.addBox(-2.0F, 0.0F, -2.0F, 12, 8, 6, 0.0F);
		this.leg_right_front = new ModelRenderer(this, 0, 16);
		this.leg_right_front.setRotationPoint(-3.0F, 16.0F, -4.0F);
		this.leg_right_front.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
		this.snout = new ModelRenderer(this, 16, 16);
		this.snout.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.snout.addBox(-2.0F, 0.0F, -9.0F, 4, 3, 2, 0.0F);
		this.horn = new ModelRenderer(this, 24, 0);
		this.horn.setRotationPoint(-1.0F, 0.0F, -12.0F);
		this.horn.addBox(-2.0F, 0.0F, -3.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(horn, 1.5707963267948966F, 0.0F, 0.0F);
		this.adder = new ModelRenderer(this, 36, 0);
		this.adder.setRotationPoint(1.0F, 11.4F, 4.5F);
		this.adder.addBox(-4.0F, -4.0F, -8.0F, 6, 6, 2, -0.4F);
		this.setRotateAngle(adder, 1.3569934934255912F, 0.0F, 0.0F);
		this.horn_1 = new ModelRenderer(this, 24, 0);
		this.horn_1.setRotationPoint(4.0F, 0.0F, -12.0F);
		this.horn_1.addBox(-2.0F, 0.0F, -3.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(horn_1, 1.5707963267948966F, 0.0F, 0.0F);
		this.leg_right_back = new ModelRenderer(this, 0, 18);
		this.leg_right_back.setRotationPoint(-3.0F, 18.0F, 7.0F);
		this.leg_right_back.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 11.5F, -5.5F);
		this.head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
		this.body_main = new ModelRenderer(this, 28, 8);
		this.body_main.setRotationPoint(0.0F, 11.0F, 5.4F);
		this.body_main.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F);
		this.setRotateAngle(body_main, 1.3569934934255912F, 0.0F, 0.0F);
		this.leg_left_back = new ModelRenderer(this, 0, 18);
		this.leg_left_back.setRotationPoint(3.0F, 18.0F, 7.0F);
		this.leg_left_back.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.leg_left_front = new ModelRenderer(this, 0, 16);
		this.leg_left_front.setRotationPoint(3.0F, 16.0F, -4.0F);
		this.leg_left_front.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
		this.head.addChild(this.snout);
		this.head.addChild(this.horn);
		this.head.addChild(this.horn_1);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (((EntitySow) entity).isChild()) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 6.0F * scale, 5.0F * scale);
			this.head.render(scale);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
			this.muscle_back.render(scale);
			this.muscle_front.render(scale);
			this.leg_right_front.render(scale);
			this.adder.render(scale);
			this.leg_right_back.render(scale);
			this.body_main.render(scale);
			this.leg_left_back.render(scale);
			this.leg_left_front.render(scale);
			GlStateManager.popMatrix();
		} else {
			this.muscle_back.render(scale);
			this.muscle_front.render(scale);
			this.leg_right_front.render(scale);
			this.adder.render(scale);
			this.leg_right_back.render(scale);
			this.head.render(scale);
			this.body_main.render(scale);
			this.leg_left_back.render(scale);
			this.leg_left_front.render(scale);
		}
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.leg_left_back.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg_left_front.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg_right_back.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg_right_front.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}