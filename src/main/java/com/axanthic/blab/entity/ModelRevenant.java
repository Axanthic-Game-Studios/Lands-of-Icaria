package com.axanthic.blab.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

public class ModelRevenant extends ModelBiped {
	public ModelRenderer skull;
	public ModelRenderer hood;
	public ModelRenderer cape;
	public ModelRenderer robe;
	public ModelRenderer body;
	public ModelRenderer leg_right;
	public ModelRenderer leg_left;
	public ModelRenderer arm_right;
	public ModelRenderer arm_left;

	public ModelRevenant() {
		this.textureWidth = 64;
		this.textureHeight = 94;
		this.body = new ModelRenderer(this, 32, 0);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 13, 4, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 16, 32 + 46);
		this.bipedRightArm.setRotationPoint(-4.0F, 3.0F, -0.6F);
		this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(bipedRightArm, -1.3962634015954636F, 0.10000736613927509F, 0.10000736613927509F);
		this.skull = new ModelRenderer(this, 0, 0);
		this.skull.setRotationPoint(0.0F, 0.5F, 0.0F);
		this.skull.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.setRotateAngle(skull, 0.19634954084936207F, 0.0F, 0.0F);
		this.arm_right = new ModelRenderer(this, 8, 32);
		this.arm_right.setRotationPoint(1.5F, 0.5F, 0.5F);
		this.arm_right.addBox(-3.0F, -2.0F, -2.0F, 2, 12, 2, 0.0F);
		this.setRotateAngle(arm_right, 0.0F, 0.0F, 0.10000736613927509F);
		this.bipedLeftArm = new ModelRenderer(this, 0, 32 + 46);
		this.bipedLeftArm.mirror = true;
		this.bipedLeftArm.setRotationPoint(4.0F, 3.0F, -0.5F);
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(bipedLeftArm, -1.2217304763960306F, -0.10000736613927509F, -0.10000736613927509F);
		this.leg_left = new ModelRenderer(this, 0, 16);
		this.leg_left.mirror = true;
		this.leg_left.setRotationPoint(1.0F, 0.0F, 0.9F);
		this.leg_left.addBox(-2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
		this.setRotateAngle(leg_left, -0.04363323129985824F, 0.0F, 0.0F);
		this.arm_left = new ModelRenderer(this, 0, 32);
		this.arm_left.mirror = true;
		this.arm_left.setRotationPoint(-1.5F, 0.5F, 0.5F);
		this.arm_left.addBox(0.5F, -2.0F, -2.0F, 2, 12, 2, 0.0F);
		this.setRotateAngle(arm_left, 0.0F, 0.0F, -0.10000736613927509F);
		this.bipedRightLeg = new ModelRenderer(this, 16, 16 + 46);
		this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.hood = new ModelRenderer(this, 0, 0 + 46);
		this.hood.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hood.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
		this.cape = new ModelRenderer(this, 32, 16 + 46);
		this.cape.setRotationPoint(-1.0F, 0.0F, 1.5F);
		this.cape.addBox(-4.0F, 0.0F, 0.0F, 10, 16, 1, 0.0F);
		this.setRotateAngle(cape, 0.08726646259971647F, 0.0F, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 0, 16 + 46);
		this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(bipedLeftLeg, 0.08726646259971647F, 0.0F, 0.0F);
		this.leg_right = new ModelRenderer(this, 8, 16);
		this.leg_right.setRotationPoint(1.0F, 0.0F, 1.0F);
		this.leg_right.addBox(-2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
		this.robe = new ModelRenderer(this, 32, 0 + 46);
		this.robe.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.robe.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		this.bipedRightArm.addChild(this.arm_right);
		this.bipedLeftLeg.addChild(this.leg_left);
		this.bipedLeftArm.addChild(this.arm_left);
		this.bipedRightLeg.addChild(this.leg_right);
		this.skull.addChild(this.hood);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
		GlStateManager.translate(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
		GlStateManager.scale(0.9D, 0.9D, 0.9D);
		GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
		GlStateManager.translate(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
		this.body.render(f5);
		GlStateManager.popMatrix();
		this.bipedRightArm.render(f5);
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.skull.offsetX, this.skull.offsetY, this.skull.offsetZ);
		GlStateManager.translate(this.skull.rotationPointX * f5, this.skull.rotationPointY * f5, this.skull.rotationPointZ * f5);
		GlStateManager.translate(-this.skull.offsetX, -this.skull.offsetY, -this.skull.offsetZ);
		GlStateManager.translate(-this.skull.rotationPointX * f5, -this.skull.rotationPointY * f5, -this.skull.rotationPointZ * f5);
		this.skull.render(f5);
		GlStateManager.popMatrix();
		this.bipedLeftArm.render(f5);
		this.bipedRightLeg.render(f5);
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.cape.offsetX, this.cape.offsetY, this.cape.offsetZ);
		GlStateManager.translate(this.cape.rotationPointX * f5, this.cape.rotationPointY * f5, this.cape.rotationPointZ * f5);
		GlStateManager.scale(1.2D, 1.2D, 1.2D);
		GlStateManager.translate(-this.cape.offsetX, -this.cape.offsetY, -this.cape.offsetZ);
		GlStateManager.translate(-this.cape.rotationPointX * f5, -this.cape.rotationPointY * f5, -this.cape.rotationPointZ * f5);
		this.cape.render(f5);
		GlStateManager.popMatrix();
		this.bipedLeftLeg.render(f5);
		this.robe.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		this.cape.rotateAngleX = MathHelper.cos(limbSwing * 1.3324F) * limbSwingAmount / 3 + limbSwingAmount / 3 + 0.08726646259971647F;

		boolean flag = entityIn instanceof EntityRevenant && ((EntityRevenant)entityIn).isArmsRaised();
		float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
		this.bipedRightArm.rotateAngleZ = 0.10000736613927509F;
		this.bipedLeftArm.rotateAngleZ = 0.10000736613927509F;
		this.bipedRightArm.rotateAngleY = -(0.10000736613927509F - f * 0.6F);
		this.bipedLeftArm.rotateAngleY = 0.10000736613927509F - f * 0.6F;
		this.bipedRightArm.rotateAngleX = -(float)Math.PI / (flag ? 1.3962634015954636F : 2.2962634015954636F);
		this.bipedLeftArm.rotateAngleX = -(float)Math.PI / (flag ? 1.2217304763960306F : 2.1217304763960306F);
		this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.08726646259971647F;
	}
}
