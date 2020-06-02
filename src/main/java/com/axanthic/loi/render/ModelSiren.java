package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSiren extends ModelBase {
	public ModelRenderer leg_right_top;
	public ModelRenderer leg_left_top;
	public ModelRenderer pelvis;
	public ModelRenderer leg_right_bottom;
	public ModelRenderer leg_left_bottom;
	public ModelRenderer belly;
	public ModelRenderer lower_chest;
	public ModelRenderer chest;
	public ModelRenderer shoulders;
	public ModelRenderer head;
	public ModelRenderer arm_right;
	public ModelRenderer arm_left;
	public ModelRenderer right_breastplate;
	public ModelRenderer left_breastplate;
	public ModelRenderer arms_bound;
	public ModelRenderer arms_bound_1;
	public ModelRenderer hair;
	public ModelRenderer mouth;

	public ModelSiren() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.hair = new ModelRenderer(this, 12, 32);
		this.hair.setRotationPoint(0.0F, -1.8F, -2.5F);
		this.hair.addBox(-3.0F, -5.0F, -2.0F, 6, 12, 8, 0.0F);
		this.setRotateAngle(hair, -0.39269908169872414F, 0.0F, 0.0F);
		this.leg_right_top = new ModelRenderer(this, 0, 0);
		this.leg_right_top.setRotationPoint(-2.1F, 10.3F, 0.0F);
		this.leg_right_top.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(leg_right_top, -0.19198621771937624F, 0.19198621771937624F, 0.0F);
		this.arm_right = new ModelRenderer(this, 54, 0);
		this.arm_right.setRotationPoint(-5.0F, 0.5F, -0.5F);
		this.arm_right.addBox(-2.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(arm_right, 0.39269908169872414F, 0.0F, 0.0F);
		this.leg_right_bottom = new ModelRenderer(this, 38, 0);
		this.leg_right_bottom.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.leg_right_bottom.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(leg_right_bottom, 0.2792526803190927F, 0.0F, 0.0F);
		this.belly = new ModelRenderer(this, 13, 7);
		this.belly.setRotationPoint(0.0F, -2.5F, 1.0F);
		this.belly.addBox(-3.0F, 0.0F, -2.0F, 6, 3, 3, 0.0F);
		this.setRotateAngle(belly, -0.19198621771937624F, 0.0F, 0.0F);
		this.leg_left_bottom = new ModelRenderer(this, 46, 0);
		this.leg_left_bottom.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.leg_left_bottom.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(leg_left_bottom, 0.2792526803190927F, 0.0F, 0.0F);
		this.arms_bound_1 = new ModelRenderer(this, 34, 23);
		this.arms_bound_1.setRotationPoint(3.5F, -0.5F, -0.5F);
		this.arms_bound_1.addBox(-5.0F, 0.0F, -1.0F, 3, 3, 3, 0.0F);
		this.pelvis = new ModelRenderer(this, 0, 55);
		this.pelvis.setRotationPoint(0.0F, 7.8F, 0.5F);
		this.pelvis.addBox(-3.5F, 0.0F, -2.0F, 7, 5, 4, 0.0F);
		this.setRotateAngle(pelvis, -0.19198621771937624F, 0.0F, 0.0F);
		this.right_breastplate = new ModelRenderer(this, 47, 20);
		this.right_breastplate.setRotationPoint(5.5F, 1.2F, 1.0F);
		this.right_breastplate.addBox(-4.0F, 0.0F, -3.0F, 4, 6, 3, 0.0F);
		this.setRotateAngle(right_breastplate, -0.39269908169872414F, 0.0F, 0.39269908169872414F);
		this.lower_chest = new ModelRenderer(this, 28, 10);
		this.lower_chest.setRotationPoint(0.0F, -3.5F, -0.7F);
		this.lower_chest.addBox(-3.5F, 0.0F, -2.0F, 7, 4, 3, 0.0F);
		this.setRotateAngle(lower_chest, 0.19198621771937624F, 0.0F, 0.0F);
		this.mouth = new ModelRenderer(this, 0, 33);
		this.mouth.setRotationPoint(0.0F, 0.0F, -1.5F);
		this.mouth.addBox(-1.5F, 0.0F, -1.0F, 3, 3, 1, 0.0F);
		this.shoulders = new ModelRenderer(this, 24, 17);
		this.shoulders.setRotationPoint(0.0F, 0.5F, 0.0F);
		this.shoulders.addBox(-5.0F, 0.0F, -2.0F, 10, 3, 3, 0.0F);
		this.head = new ModelRenderer(this, 0, 22);
		this.head.setRotationPoint(0.0F, -1.5F, -2.5F);
		this.head.addBox(-2.5F, -5.0F, -2.5F, 5, 6, 5, 0.0F);
		this.setRotateAngle(head, 0.19198621771937624F, 0.0F, 0.0F);
		this.arm_left = new ModelRenderer(this, 48, 10);
		this.arm_left.setRotationPoint(5.0F, 0.5F, -0.5F);
		this.arm_left.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(arm_left, 0.39269908169872414F, 0.0F, 0.0F);
		this.leg_left_top = new ModelRenderer(this, 8, 0);
		this.leg_left_top.setRotationPoint(2.1F, 10.3F, 0.0F);
		this.leg_left_top.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(leg_left_top, -0.19198621771937624F, -0.19198621771937624F, 0.0F);
		this.arms_bound = new ModelRenderer(this, 34, 29);
		this.arms_bound.setRotationPoint(-5.0F, 6.0F, 0.0F);
		this.arms_bound.addBox(-5.0F, 0.0F, -1.0F, 10, 2, 2, 0.0F);
		this.chest = new ModelRenderer(this, 0, 13);
		this.chest.setRotationPoint(0.0F, -3.5F, -0.7F);
		this.chest.addBox(-4.0F, -0.5F, -2.6F, 8, 5, 4, 0.0F);
		this.setRotateAngle(chest, 0.2792526803190927F, 0.0F, 0.0F);
		this.left_breastplate = new ModelRenderer(this, 20, 23);
		this.left_breastplate.setRotationPoint(-5.5F, 1.2F, 1.0F);
		this.left_breastplate.addBox(0.0F, 0.0F, -3.0F, 4, 6, 3, 0.0F);
		this.setRotateAngle(left_breastplate, -0.39269908169872414F, 0.0F, -0.39269908169872414F);
		this.head.addChild(this.hair);
		this.shoulders.addChild(this.arm_right);
		this.leg_right_top.addChild(this.leg_right_bottom);
		this.pelvis.addChild(this.belly);
		this.leg_left_top.addChild(this.leg_left_bottom);
		this.arms_bound.addChild(this.arms_bound_1);
		this.shoulders.addChild(this.right_breastplate);
		this.belly.addChild(this.lower_chest);
		this.head.addChild(this.mouth);
		this.chest.addChild(this.shoulders);
		this.chest.addChild(this.head);
		this.shoulders.addChild(this.arm_left);
		this.arm_left.addChild(this.arms_bound);
		this.lower_chest.addChild(this.chest);
		this.shoulders.addChild(this.left_breastplate);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -MathHelper.cos(limbSwing * 0.6662F * 2.0f + 2.7f) * limbSwingAmount / 16.0f + limbSwingAmount / 31.05f, 0.0F);
		this.leg_right_top.render(scale);
		this.pelvis.render(scale);
		this.leg_left_top.render(scale);
		GlStateManager.popMatrix();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.setRotateAngle(leg_right_top, -0.19198621771937624F, 0.19198621771937624F, 0.0F);
		this.setRotateAngle(leg_left_top, -0.19198621771937624F, -0.19198621771937624F, 0.0F);
		this.setRotateAngle(leg_right_bottom, 0.2792526803190927F, 0.0F, 0.0F);
		this.setRotateAngle(leg_left_bottom, 0.2792526803190927F, 0.0F, 0.0F);
		
		this.setRotateAngle(head, 0.19198621771937624F + headPitch * 0.017453292F, netHeadYaw * 0.017453292F, 0.0F);

		this.leg_right_top.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.leg_left_top.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.leg_right_bottom.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount + 0.5F * limbSwingAmount;
		this.leg_left_bottom.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount + 0.5F * limbSwingAmount;

		if (this.isRiding) {
			this.leg_right_top.rotateAngleX += -1.2F;
			this.leg_right_top.rotateAngleY += ((float)Math.PI / 10F);
			this.leg_right_top.rotateAngleZ += 0.07F;
			this.leg_left_top.rotateAngleX += -1.2F;
			this.leg_left_top.rotateAngleY += -((float)Math.PI / 10F);
			this.leg_left_top.rotateAngleZ += -0.07F;
			this.leg_right_bottom.rotateAngleX += 0.7F;
			this.leg_left_bottom.rotateAngleX += 0.7F;
		}

		this.arm_right.rotateAngleX = 0.39269908169872414F + MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.arm_left.rotateAngleX = 0.39269908169872414F + MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
}