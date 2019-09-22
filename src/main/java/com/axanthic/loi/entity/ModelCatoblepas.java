package com.axanthic.loi.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCatoblepas extends ModelBase {
	public ModelRenderer tail;
	public ModelRenderer leg_left_back;
	public ModelRenderer leg_left_front;
	public ModelRenderer leg_right_back;
	public ModelRenderer leg_right_front;
	public ModelRenderer head;
	public ModelRenderer leg_muscle_right_front;
	public ModelRenderer leg_muscle_left_front;
	public ModelRenderer leg_muscle_left_back;
	public ModelRenderer leg_muscle_right_back;
	public ModelRenderer body_main;
	public ModelRenderer neck;
	public ModelRenderer horn_right;
	public ModelRenderer horn_left;

	public ModelCatoblepas() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.body_main = new ModelRenderer(this, 0, 32);
		this.body_main.setRotationPoint(0.0F, 9.0F, 2.0F);
		this.body_main.addBox(-6.0F, -10.0F, -7.0F, 12, 19, 10, 0.0F);
		this.setRotateAngle(body_main, 1.3089969389957472F, 0.0F, 0.0F);
		this.horn_right = new ModelRenderer(this, 0, 0);
		this.horn_right.setRotationPoint(0.0F, 3.0F, -9.0F);
		this.horn_right.addBox(-6.0F, -10.0F, 4.0F, 1, 5, 1, 0.0F);
		this.setRotateAngle(horn_right, 0.4363323129985824F, 0.4363323129985824F, 0.0F);
		this.leg_muscle_right_front = new ModelRenderer(this, 32, 14);
		this.leg_muscle_right_front.setRotationPoint(-7.0F, 8.0F, -11.5F);
		this.leg_muscle_right_front.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F);
		this.setRotateAngle(leg_muscle_right_front, 0.17453292519943295F, 0.0F, 0.0F);
		this.leg_muscle_right_back = new ModelRenderer(this, 32, 14);
		this.leg_muscle_right_back.setRotationPoint(-7.0F, 10.0F, 2.5F);
		this.leg_muscle_right_back.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F);
		this.setRotateAngle(leg_muscle_right_back, 0.17453292519943295F, 0.0F, 0.0F);
		this.leg_muscle_left_back = new ModelRenderer(this, 32, 14);
		this.leg_muscle_left_back.setRotationPoint(1.0F, 10.0F, 2.5F);
		this.leg_muscle_left_back.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F);
		this.setRotateAngle(leg_muscle_left_back, 0.17453292519943295F, 0.0F, 0.0F);
		this.leg_left_back = new ModelRenderer(this, 48, 0);
		this.leg_left_back.setRotationPoint(4.1F, 16.0F, 6.5F);
		this.leg_left_back.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
		this.leg_right_back = new ModelRenderer(this, 48, 0);
		this.leg_right_back.setRotationPoint(-4.1F, 16.0F, 6.5F);
		this.leg_right_back.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
		this.horn_left = new ModelRenderer(this, 0, 0);
		this.horn_left.setRotationPoint(-1.0F, 3.0F, -9.0F);
		this.horn_left.addBox(6.0F, -10.0F, 4.0F, 1, 5, 1, 0.0F);
		this.setRotateAngle(horn_left, 0.4363323129985824F, -0.4363323129985824F, 0.0F);
		this.leg_left_front = new ModelRenderer(this, 32, 0);
		this.leg_left_front.setRotationPoint(4.0F, 14.0F, -7.0F);
		this.leg_left_front.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 9.0F, -13.0F);
		this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 8, 0.0F);
		this.setRotateAngle(head, 0.136659280431156F, 0.0F, 0.0F);
		this.tail = new ModelRenderer(this, 24, 16);
		this.tail.setRotationPoint(0.0F, 10.0F, 9.0F);
		this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 10, 2, 0.0F);
		this.setRotateAngle(tail, 0.27314402793711257F, 0.0F, 0.0F);
		this.leg_right_front = new ModelRenderer(this, 32, 0);
		this.leg_right_front.setRotationPoint(-4.0F, 14.0F, -7.0F);
		this.leg_right_front.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
		this.leg_muscle_left_front = new ModelRenderer(this, 32, 14);
		this.leg_muscle_left_front.setRotationPoint(1.0F, 8.0F, -11.5F);
		this.leg_muscle_left_front.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F);
		this.setRotateAngle(leg_muscle_left_front, 0.17453292519943295F, 0.0F, 0.0F);
		this.neck = new ModelRenderer(this, 0, 16);
		this.neck.setRotationPoint(1.0F, 16.0F, -6.0F);
		this.neck.addBox(-4.0F, -11.0F, -6.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(neck, 0.136659280431156F, 0.0F, 0.0F);
		this.head.addChild(this.horn_right);
		this.head.addChild(this.horn_left);
		//this.head.addChild(this.neck);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (((EntityCatoblepas) entity).isChild()) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 6.0F * scale, 5.0F * scale);
			this.head.render(scale);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
			this.body_main.render(scale);
			this.leg_muscle_right_front.render(scale);
			this.leg_muscle_right_back.render(scale);
			this.leg_muscle_left_back.render(scale);
			this.leg_left_back.render(scale);
			this.leg_right_back.render(scale);
			this.leg_left_front.render(scale);
			this.tail.render(scale);
			this.leg_right_front.render(scale);
			this.leg_muscle_left_front.render(scale);
			this.neck.render(scale);
			GlStateManager.popMatrix();
		} else {
			this.body_main.render(scale);
			this.leg_muscle_right_front.render(scale);
			this.leg_muscle_right_back.render(scale);
			this.leg_muscle_left_back.render(scale);
			this.leg_left_back.render(scale);
			this.leg_right_back.render(scale);
			this.leg_left_front.render(scale);
			this.head.render(scale);
			this.tail.render(scale);
			this.leg_right_front.render(scale);
			this.leg_muscle_left_front.render(scale);
			this.neck.render(scale);
		}
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F + 0.136659280431156F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.leg_left_back.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg_left_front.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg_right_back.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg_right_front.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}
