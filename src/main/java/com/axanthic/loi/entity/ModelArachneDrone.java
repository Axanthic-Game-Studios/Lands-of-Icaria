package com.axanthic.loi.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelArachneDrone extends ModelBase {
	public ModelRenderer body_center;
	public ModelRenderer head;
	public ModelRenderer body_rear;
	public ModelRenderer leg_right_front;
	public ModelRenderer leg_left_front;
	public ModelRenderer leg_left_center_front;
	public ModelRenderer leg_left_center_back;
	public ModelRenderer leg_left_back;
	public ModelRenderer leg_right_center_front;
	public ModelRenderer leg_right_center_back;
	public ModelRenderer leg_right_back;
	public ModelRenderer lrf_c;
	public ModelRenderer llf_c;
	public ModelRenderer llcf_c;
	public ModelRenderer llcb_c;
	public ModelRenderer llb_c;
	public ModelRenderer lrcf_c;
	public ModelRenderer lrcb_c;
	public ModelRenderer lrb_c;

	public ModelArachneDrone() {
		this.textureWidth = 32;
		this.textureHeight = 16;
		this.lrcb_c = new ModelRenderer(this, 13, 2);
		this.lrcb_c.setRotationPoint(7.5F, 0.5F, -0.5F);
		this.lrcb_c.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(lrcb_c, 0.0F, 0.0F, 1.5707963267948966F);
		this.leg_right_front = new ModelRenderer(this, 13, 0);
		this.leg_right_front.setRotationPoint(-0.5F, 20.5F, -1.5F);
		this.leg_right_front.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
		this.setRotateAngle(leg_right_front, 0.03490658503988659F, 2.356194490192345F, 0.5811946409141118F);
		this.lrb_c = new ModelRenderer(this, 13, 2);
		this.lrb_c.setRotationPoint(7.5F, 0.5F, -0.5F);
		this.lrb_c.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(lrb_c, 0.0F, 0.0F, 1.5707963267948966F);
		this.llcf_c = new ModelRenderer(this, 13, 2);
		this.llcf_c.setRotationPoint(7.5F, 0.5F, -0.5F);
		this.llcf_c.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(llcf_c, 0.0F, 0.0F, 1.5707963267948966F);
		this.head = new ModelRenderer(this, 0, 8);
		this.head.setRotationPoint(0.0F, 20.0F, -3.0F);
		this.head.addBox(-2.0F, -2.3F, -3.0F, 4, 4, 4, -0.5F);
		this.setRotateAngle(head, -0.2617993877991494F, 0.0F, 0.0F);
		this.leg_left_back = new ModelRenderer(this, 13, 0);
		this.leg_left_back.setRotationPoint(0.5F, 20.5F, -1.5F);
		this.leg_left_back.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
		this.setRotateAngle(leg_left_back, 0.03490658503988659F, -0.7853981633974483F, -0.5811946409141118F);
		this.body_center = new ModelRenderer(this, 12, 8);
		this.body_center.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.body_center.addBox(-1.0F, -3.0F, -3.0F, 2, 2, 2, 0.0F);
		this.leg_right_back = new ModelRenderer(this, 13, 0);
		this.leg_right_back.setRotationPoint(-0.5F, 20.5F, -1.5F);
		this.leg_right_back.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
		this.setRotateAngle(leg_right_back, -0.03490658503988659F, -2.356194490192345F, 0.5811946409141118F);
		this.llf_c = new ModelRenderer(this, 13, 2);
		this.llf_c.setRotationPoint(7.5F, 0.5F, -0.5F);
		this.llf_c.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(llf_c, 0.0F, 0.0F, 1.5707963267948966F);
		this.body_rear = new ModelRenderer(this, 0, 0);
		this.body_rear.setRotationPoint(0.0F, 20.0F, 4.0F);
		this.body_rear.addBox(-2.0F, -2.5F, -5.5F, 4, 3, 5, 0.0F);
		this.setRotateAngle(body_rear, 0.17453292519943295F, 0.0F, 0.0F);
		this.llb_c = new ModelRenderer(this, 13, 2);
		this.llb_c.setRotationPoint(7.5F, 0.5F, -0.5F);
		this.llb_c.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(llb_c, 0.0F, 0.0F, 1.5707963267948966F);
		this.leg_right_center_front = new ModelRenderer(this, 13, 0);
		this.leg_right_center_front.setRotationPoint(-0.5F, 20.5F, -1.5F);
		this.leg_right_center_front.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
		this.setRotateAngle(leg_right_center_front, -0.05235987755982988F, 2.743657584135086F, 0.47123889803846897F);
		this.leg_left_front = new ModelRenderer(this, 13, 0);
		this.leg_left_front.setRotationPoint(0.5F, 20.5F, -1.5F);
		this.leg_left_front.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
		this.setRotateAngle(leg_left_front, -0.03490658503988659F, 0.7853981633974483F, -0.5811946409141118F);
		this.leg_right_center_back = new ModelRenderer(this, 13, 0);
		this.leg_right_center_back.setRotationPoint(-0.5F, 20.5F, -1.5F);
		this.leg_right_center_back.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
		this.setRotateAngle(leg_right_center_back, 0.05235987755982988F, -2.743657584135086F, 0.47123889803846897F);
		this.lrcf_c = new ModelRenderer(this, 13, 2);
		this.lrcf_c.setRotationPoint(7.5F, 0.5F, -0.5F);
		this.lrcf_c.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(lrcf_c, 0.0F, 0.0F, 1.5707963267948966F);
		this.leg_left_center_back = new ModelRenderer(this, 13, 0);
		this.leg_left_center_back.setRotationPoint(0.5F, 20.5F, -1.5F);
		this.leg_left_center_back.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
		this.setRotateAngle(leg_left_center_back, -0.05235987755982988F, -0.39269908169872414F, -0.47123889803846897F);
		this.leg_left_center_front = new ModelRenderer(this, 13, 0);
		this.leg_left_center_front.setRotationPoint(0.5F, 20.5F, -1.5F);
		this.leg_left_center_front.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
		this.setRotateAngle(leg_left_center_front, 0.05235987755982988F, 0.39269908169872414F, -0.47123889803846897F);
		this.lrf_c = new ModelRenderer(this, 13, 2);
		this.lrf_c.setRotationPoint(7.5F, 0.5F, -0.5F);
		this.lrf_c.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(lrf_c, 0.0F, 0.0F, 1.5707963267948966F);
		this.llcb_c = new ModelRenderer(this, 13, 2);
		this.llcb_c.setRotationPoint(7.5F, 0.5F, -0.5F);
		this.llcb_c.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(llcb_c, 0.0F, 0.0F, 1.5707963267948966F);
		this.leg_right_center_back.addChild(this.lrcb_c);
		this.leg_right_back.addChild(this.lrb_c);
		this.leg_left_center_front.addChild(this.llcf_c);
		this.leg_left_front.addChild(this.llf_c);
		this.leg_left_back.addChild(this.llb_c);
		this.leg_right_center_front.addChild(this.lrcf_c);
		this.leg_right_front.addChild(this.lrf_c);
		this.leg_left_center_back.addChild(this.llcb_c);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) { 
		GlStateManager.pushMatrix();
		this.leg_right_front.render(scale);
		this.head.render(scale);
		this.leg_left_back.render(scale);
		this.body_center.render(scale);
		this.leg_right_back.render(scale);
		this.body_rear.render(scale);
		this.leg_right_center_front.render(scale);
		this.leg_left_front.render(scale);
		this.leg_right_center_back.render(scale);
		this.leg_left_center_back.render(scale);
		this.leg_left_center_front.render(scale);
		GlStateManager.popMatrix();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.head.rotateAngleX = -0.2617993877991494F + headPitch * 0.017453292F;

		float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
		float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
		float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
		float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
		this.leg_right_back.rotateAngleY = -2.356194490192345F + f3;
		this.leg_left_back.rotateAngleY = -0.7853981633974483F - f3;
		this.leg_right_center_back.rotateAngleY = -2.743657584135086F + f4;
		this.leg_left_center_back.rotateAngleY = -0.39269908169872414F - f4;
		this.leg_right_center_front.rotateAngleY = 2.743657584135086F + f5;
		this.leg_left_center_front.rotateAngleY = 0.39269908169872414F - f5;
		this.leg_right_front.rotateAngleY = 2.356194490192345F + f6;
		this.leg_left_front.rotateAngleY = 0.7853981633974483F - f6;
		this.leg_right_back.rotateAngleZ = 0.5811946409141118F + f7;
		this.leg_left_back.rotateAngleZ = -0.5811946409141118F - f7;
		this.leg_right_center_back.rotateAngleZ = 0.47123889803846897F + f8;
		this.leg_left_center_back.rotateAngleZ = -0.47123889803846897F - f8;
		this.leg_right_center_front.rotateAngleZ = 0.47123889803846897F + f9;
		this.leg_left_center_front.rotateAngleZ = -0.47123889803846897F - f9;
		this.leg_right_front.rotateAngleZ = 0.5811946409141118F + f10;
		this.leg_left_front.rotateAngleZ = -0.5811946409141118F - f10;
	}
}
