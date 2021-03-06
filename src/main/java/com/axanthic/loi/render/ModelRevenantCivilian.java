package com.axanthic.loi.render;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class ModelRevenantCivilian extends ModelBase {
	public ModelRenderer skull;
	public ModelRenderer spine;
	public ModelRenderer leg_left;
	public ModelRenderer leg_right;
	public ModelRenderer arm_right;
	public ModelRenderer arm_left;
	public ModelRenderer upper_jaw;
	public ModelRenderer eyes;
	public ModelRenderer lower_jaw;
	public ModelRenderer front_chest_bone;
	public ModelRenderer rib_top_back_right;
	public ModelRenderer rib_top_back_left;
	public ModelRenderer rib_2nd_back_right;
	public ModelRenderer rib_2nd_back_left;
	public ModelRenderer rib_3rd_back_right;
	public ModelRenderer rib_3rd_back_left;
	public ModelRenderer rib_4th_back_left;
	public ModelRenderer rib_5th_back_left;
	public ModelRenderer spine_legplate_top;
	public ModelRenderer robe_shoulder_center;
	public ModelRenderer rib_top_backplate_right;
	public ModelRenderer rib_top_side_right;
	public ModelRenderer rib_top_front_right;
	public ModelRenderer rib_top_side_left;
	public ModelRenderer rib_top_front_left;
	public ModelRenderer rib_2nd_side_right;
	public ModelRenderer rib_2nd_front_right;
	public ModelRenderer rib_2nd_side_left;
	public ModelRenderer rib_2nd_front_left;
	public ModelRenderer rib_3rd_side_right;
	public ModelRenderer rib_3rd_front_right;
	public ModelRenderer rib_3rd_side_left;
	public ModelRenderer rib_3rd_front_left;
	public ModelRenderer rib_4th_side_left;
	public ModelRenderer rib_4th_front_left;
	public ModelRenderer rib_5th_side_left;
	public ModelRenderer rib_5th_front_left;
	public ModelRenderer spine_legplate_bottom;
	public ModelRenderer spine_legplate_right;
	public ModelRenderer spine_legplate_left;
	public ModelRenderer robe_shoulder_side;
	public ModelRenderer robe_thighs;
	public ModelRenderer robe_body;
	public ModelRenderer robe_legs;
	public ModelRenderer robe_body_bottom;
	public ModelRenderer leg_left_bottom;
	public ModelRenderer leg_right_bottom;
	public ModelRenderer arm_right_lower;
	public ModelRenderer arm_left_lower;

	public ModelRevenantCivilian() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.rib_top_front_left = new ModelRenderer(this, 68, 0);
		this.rib_top_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_front_left.addBox(2.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F);
		this.spine_legplate_bottom = new ModelRenderer(this, 6, 14);
		this.spine_legplate_bottom.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spine_legplate_bottom.addBox(-3.5F, 19.8F, -1.5F, 7, 1, 1, 0.0F);
		this.arm_left_lower = new ModelRenderer(this, 86, 27);
		this.arm_left_lower.mirror = true;
		this.arm_left_lower.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.arm_left_lower.addBox(-0.2F, -0.2F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_left_lower, -0.10471975511965977F, 0.0F, 0.10471975511965977F);
		this.rib_3rd_front_left = new ModelRenderer(this, 22, 4);
		this.rib_3rd_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_3rd_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_top_front_right = new ModelRenderer(this, 0, 0);
		this.rib_top_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_front_right.addBox(-5.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F);
		this.robe_body_bottom = new ModelRenderer(this, 50, 27);
		this.robe_body_bottom.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.robe_body_bottom.addBox(-3.9F, -1.1F, -3.4F, 8, 4, 6, 0.0F);
		this.setRotateAngle(robe_body_bottom, 0.0F, 0.0F, -0.39269908169872414F);
		this.spine_legplate_left = new ModelRenderer(this, 19, 14);
		this.spine_legplate_left.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.spine_legplate_left.addBox(1.8F, 0.5F, -1.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(spine_legplate_left, 0.20943951023931953F, 0.10471975511965977F, 0.0F);
		this.rib_5th_back_left = new ModelRenderer(this, 48, 9);
		this.rib_5th_back_left.setRotationPoint(0.3F, 3.0F, 0.0F);
		this.rib_5th_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_5th_back_left, 0.0F, 0.0F, 0.41887902047863906F);
		this.rib_2nd_side_right = new ModelRenderer(this, 38, 11);
		this.rib_2nd_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_2nd_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.rib_2nd_front_left = new ModelRenderer(this, 22, 2);
		this.rib_2nd_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_2nd_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.robe_shoulder_center = new ModelRenderer(this, 69, 9);
		this.robe_shoulder_center.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.robe_shoulder_center.addBox(1.0F, 0.5F, -4.0F, 3, 11, 7, 0.0F);
		this.rib_top_side_right = new ModelRenderer(this, 116, 7);
		this.rib_top_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F);
		this.rib_top_backplate_right = new ModelRenderer(this, 82, 9);
		this.rib_top_backplate_right.setRotationPoint(-1.5F, -2.0F, 0.0F);
		this.rib_top_backplate_right.addBox(-5.0F, 5.5F, 0.2F, 13, 1, 1, 0.0F);
		this.lower_jaw = new ModelRenderer(this, 92, 0);
		this.lower_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lower_jaw.addBox(-2.5F, -0.8F, -3.3F, 5, 1, 6, 0.0F);
		this.setRotateAngle(lower_jaw, 0.10471975511965977F, 0.0F, 0.0F);
		this.rib_3rd_back_left = new ModelRenderer(this, 90, 7);
		this.rib_3rd_back_left.setRotationPoint(0.4F, 1.0F, 0.0F);
		this.rib_3rd_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_3rd_back_left, 0.0F, 0.0F, 0.20943951023931953F);
		this.robe_body = new ModelRenderer(this, 89, 17);
		this.robe_body.setRotationPoint(-2.0F, 0.0F, 0.0F);
		this.robe_body.addBox(-4.0F, 4.5F, -3.3F, 7, 4, 6, 0.0F);
		this.rib_3rd_side_right = new ModelRenderer(this, 58, 11);
		this.rib_3rd_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_3rd_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.arm_right_lower = new ModelRenderer(this, 78, 27);
		this.arm_right_lower.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.arm_right_lower.addBox(-1.8F, -0.2F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_right_lower, -0.10471975511965977F, 0.0F, -0.10471975511965977F);
		this.leg_right = new ModelRenderer(this, 46, 0);
		this.leg_right.setRotationPoint(-2.5F, 10.2F, 0.1F);
		this.leg_right.addBox(-1.4F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_right, -0.10471975511965977F, 0.20943951023931953F, 0.0F);
		this.rib_3rd_front_right = new ModelRenderer(this, 0, 4);
		this.rib_3rd_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_3rd_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_2nd_front_right = new ModelRenderer(this, 0, 2);
		this.rib_2nd_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_2nd_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_3rd_side_left = new ModelRenderer(this, 82, 11);
		this.rib_3rd_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_3rd_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.arm_left = new ModelRenderer(this, 62, 0);
		this.arm_left.mirror = true;
		this.arm_left.setRotationPoint(6.0F, -2.0F, 0.0F);
		this.arm_left.addBox(-0.2F, 0.0F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_left, 0.0F, 0.0F, -0.10471975511965977F);
		this.rib_2nd_back_right = new ModelRenderer(this, 22, 0);
		this.rib_2nd_back_right.setRotationPoint(-0.3F, 0.0F, 0.0F);
		this.rib_2nd_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_2nd_back_right, 0.0F, 0.0F, -0.10471975511965977F);
		this.leg_right_bottom = new ModelRenderer(this, 115, 18);
		this.leg_right_bottom.mirror = true;
		this.leg_right_bottom.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.leg_right_bottom.addBox(-1.4F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_right_bottom, 0.20943951023931953F, 0.0F, 0.0F);
		this.rib_2nd_back_left = new ModelRenderer(this, 70, 7);
		this.rib_2nd_back_left.setRotationPoint(0.3F, 0.0F, 0.0F);
		this.rib_2nd_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_2nd_back_left, 0.0F, 0.0F, 0.10471975511965977F);
		this.robe_thighs = new ModelRenderer(this, 32, 16);
		this.robe_thighs.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.robe_thighs.addBox(-4.5F, 9.5F, -3.5F, 9, 5, 6, 0.0F);
		this.upper_jaw = new ModelRenderer(this, 70, 0);
		this.upper_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.upper_jaw.addBox(-2.5F, -2.0F, -3.5F, 5, 1, 6, 0.0F);
		this.eyes = new ModelRenderer(this, 0, 34);
		this.eyes.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.eyes.addBox(-3.0F, -4.0F, -3.8F, 6, 5, 0, 0.0F);
		this.rib_top_back_right = new ModelRenderer(this, 86, 0);
		this.rib_top_back_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 2, 1, 0.0F);
		this.skull = new ModelRenderer(this, 0, 0);
		this.skull.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.skull.addBox(-3.5F, -8.0F, -4.0F, 7, 6, 8, 0.0F);
		this.rib_3rd_back_right = new ModelRenderer(this, 80, 7);
		this.rib_3rd_back_right.setRotationPoint(-0.4F, 1.0F, 0.0F);
		this.rib_3rd_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_3rd_back_right, 0.0F, 0.0F, -0.20943951023931953F);
		this.rib_top_side_left = new ModelRenderer(this, 106, 9);
		this.rib_top_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F);
		this.rib_4th_back_left = new ModelRenderer(this, 110, 7);
		this.rib_4th_back_left.setRotationPoint(0.4F, 2.0F, 0.0F);
		this.rib_4th_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_4th_back_left, 0.0F, 0.0F, 0.3141592653589793F);
		this.spine_legplate_top = new ModelRenderer(this, 58, 9);
		this.spine_legplate_top.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.spine_legplate_top.addBox(-4.0F, 16.8F, 1.0F, 8, 1, 1, 0.0F);
		this.rib_5th_front_left = new ModelRenderer(this, 44, 11);
		this.rib_5th_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_5th_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_4th_front_left = new ModelRenderer(this, 22, 6);
		this.rib_4th_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_4th_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.robe_legs = new ModelRenderer(this, 22, 27);
		this.robe_legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.robe_legs.addBox(-4.5F, 14.5F, -3.0F, 9, 8, 5, 0.0F);
		this.arm_right = new ModelRenderer(this, 54, 0);
		this.arm_right.setRotationPoint(-6.0F, -2.0F, 0.0F);
		this.arm_right.addBox(-1.8F, 0.0F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_right, 0.0F, 0.0F, 0.10471975511965977F);
		this.front_chest_bone = new ModelRenderer(this, 114, 0);
		this.front_chest_bone.setRotationPoint(0.0F, -2.0F, -0.2F);
		this.front_chest_bone.addBox(-2.0F, 3.5F, -2.0F, 4, 6, 1, 0.0F);
		this.spine = new ModelRenderer(this, 30, 0);
		this.spine.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.spine.addBox(-1.0F, -2.0F, 0.4F, 2, 16, 2, 0.0F);
		this.rib_4th_side_left = new ModelRenderer(this, 98, 12);
		this.rib_4th_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_4th_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.rib_5th_side_left = new ModelRenderer(this, 0, 14);
		this.rib_5th_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_5th_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.rib_top_back_left = new ModelRenderer(this, 86, 3);
		this.rib_top_back_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 2, 1, 0.0F);
		this.leg_left_bottom = new ModelRenderer(this, 22, 18);
		this.leg_left_bottom.mirror = true;
		this.leg_left_bottom.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.leg_left_bottom.addBox(-0.6F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_left_bottom, 0.20943951023931953F, 0.0F, 0.0F);
		this.spine_legplate_right = new ModelRenderer(this, 64, 11);
		this.spine_legplate_right.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.spine_legplate_right.addBox(-3.8F, 0.5F, -1.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(spine_legplate_right, 0.20943951023931953F, -0.10471975511965977F, 0.0F);
		this.leg_left = new ModelRenderer(this, 38, 0);
		this.leg_left.mirror = true;
		this.leg_left.setRotationPoint(2.5F, 10.2F, 0.1F);
		this.leg_left.addBox(-0.6F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_left, -0.10471975511965977F, -0.20943951023931953F, 0.0F);
		this.rib_2nd_side_left = new ModelRenderer(this, 48, 11);
		this.rib_2nd_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_2nd_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.robe_shoulder_side = new ModelRenderer(this, 4, 16);
		this.robe_shoulder_side.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.robe_shoulder_side.addBox(4.0F, 0.1F, -3.4F, 3, 11, 6, 0.0F);
		this.setRotateAngle(robe_shoulder_side, 0.0F, 0.0F, 0.10471975511965977F);
		this.rib_top_side_left.addChild(this.rib_top_front_left);
		this.spine_legplate_top.addChild(this.spine_legplate_bottom);
		this.arm_left.addChild(this.arm_left_lower);
		this.rib_3rd_side_left.addChild(this.rib_3rd_front_left);
		this.rib_top_side_right.addChild(this.rib_top_front_right);
		this.robe_body.addChild(this.robe_body_bottom);
		this.spine_legplate_bottom.addChild(this.spine_legplate_left);
		this.spine.addChild(this.rib_5th_back_left);
		this.rib_2nd_back_right.addChild(this.rib_2nd_side_right);
		this.rib_2nd_side_left.addChild(this.rib_2nd_front_left);
		this.spine.addChild(this.robe_shoulder_center);
		this.rib_top_back_right.addChild(this.rib_top_side_right);
		this.front_chest_bone.addChild(this.rib_top_backplate_right);
		this.upper_jaw.addChild(this.lower_jaw);
		this.spine.addChild(this.rib_3rd_back_left);
		this.robe_shoulder_center.addChild(this.robe_body);
		this.rib_3rd_back_right.addChild(this.rib_3rd_side_right);
		this.arm_right.addChild(this.arm_right_lower);
		this.rib_3rd_side_right.addChild(this.rib_3rd_front_right);
		this.rib_2nd_side_right.addChild(this.rib_2nd_front_right);
		this.rib_3rd_back_left.addChild(this.rib_3rd_side_left);
		this.spine.addChild(this.rib_2nd_back_right);
		this.leg_right.addChild(this.leg_right_bottom);
		this.spine.addChild(this.rib_2nd_back_left);
		this.robe_shoulder_center.addChild(this.robe_thighs);
		this.skull.addChild(this.upper_jaw);
		this.skull.addChild(this.eyes);
		this.spine.addChild(this.rib_top_back_right);
		this.spine.addChild(this.rib_3rd_back_right);
		this.rib_top_back_left.addChild(this.rib_top_side_left);
		this.spine.addChild(this.rib_4th_back_left);
		this.spine.addChild(this.spine_legplate_top);
		this.rib_5th_side_left.addChild(this.rib_5th_front_left);
		this.rib_4th_side_left.addChild(this.rib_4th_front_left);
		this.robe_thighs.addChild(this.robe_legs);
		this.spine.addChild(this.front_chest_bone);
		this.rib_4th_back_left.addChild(this.rib_4th_side_left);
		this.rib_5th_back_left.addChild(this.rib_5th_side_left);
		this.spine.addChild(this.rib_top_back_left);
		this.leg_left.addChild(this.leg_left_bottom);
		this.spine_legplate_bottom.addChild(this.spine_legplate_right);
		this.rib_2nd_back_left.addChild(this.rib_2nd_side_left);
		this.robe_shoulder_center.addChild(this.robe_shoulder_side);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -MathHelper.cos(limbSwing * 0.6662F * 2.0f + 2.7f) * limbSwingAmount / 16.0f + limbSwingAmount / 31.05f, 0.0F);
		this.leg_right.render(scale);
		this.arm_left.render(scale);
		this.skull.render(scale);
		this.arm_right.render(scale);
		this.spine.render(scale);
		this.leg_left.render(scale);
		this.renderHeldItems(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.popMatrix();
	}
	
	public void renderWithoutEquipment(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -MathHelper.cos(limbSwing * 0.6662F * 2.0f + 2.7f) * limbSwingAmount / 16.0f + limbSwingAmount / 31.05f, 0.0F);
		this.leg_right.render(scale);
		this.arm_left.render(scale);
		this.skull.render(scale);
		this.arm_right.render(scale);
		this.spine.render(scale);
		this.leg_left.render(scale);
		GlStateManager.popMatrix();
	}

	public void renderHeldItems(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ItemStack heldItem = ((EntityLivingBase) entityIn).getHeldItemMainhand();
		if (heldItem.isEmpty())
			return;

		GlStateManager.translate(this.arm_right.rotationPointX/16.0D, this.arm_right.rotationPointY/16.0D, this.arm_right.rotationPointZ/16.0D);
		GlStateManager.rotate(this.arm_right.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(this.arm_right.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(this.arm_right.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
		GlStateManager.translate(this.arm_right.offsetX/16.0D, this.arm_right.offsetY/16.0D, this.arm_right.offsetZ/16.0D);

		GlStateManager.translate(this.arm_right_lower.rotationPointX/16.0D, this.arm_right_lower.rotationPointY/16.0D, this.arm_right_lower.rotationPointZ/16.0D);
		GlStateManager.rotate(this.arm_right_lower.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(this.arm_right_lower.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(this.arm_right_lower.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
		GlStateManager.translate(this.arm_right_lower.offsetX/16.0D, this.arm_right_lower.offsetY/16.0D, this.arm_right_lower.offsetZ/16.0D);

		GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(0.05F, 0.02F, -0.4F);

		Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase) entityIn, heldItem, TransformType.THIRD_PERSON_RIGHT_HAND);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		Random random = new Random(entityIn.getEntityId());
		this.setRotateAngle(arm_right, 0.0F, 0.0F, 0.10471975511965977F);
		this.setRotateAngle(arm_left, 0.0F, 0.0F, -0.10471975511965977F);
		this.setRotateAngle(arm_right_lower, -0.10471975511965977F, 0.0F, -0.10471975511965977F);
		this.setRotateAngle(arm_left_lower, -0.10471975511965977F, 0.0F, 0.10471975511965977F);
		this.setRotateAngle(leg_right, -0.10471975511965977F, 0.20943951023931953F, 0.0F);
		this.setRotateAngle(leg_left, -0.10471975511965977F, -0.20943951023931953F, 0.0F);
		this.setRotateAngle(leg_right_bottom, 0.20943951023931953F, 0.0F, 0.0F);
		this.setRotateAngle(leg_left_bottom, 0.20943951023931953F, 0.0F, 0.0F);
		this.setRotateAngle(lower_jaw, 0.10471975511965977F, 0.0F, 0.0F);
		this.setRotateAngle(skull, headPitch * 0.017453292F, netHeadYaw * 0.017453292F, (((float) random.nextInt(100)) / 100.0F - 0.5F) * 0.5F + MathHelper.sin(ageInTicks * 0.05F) * 0.05F);

		this.arm_right.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.arm_left.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leg_right.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.leg_left.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;

		this.arm_right_lower.rotateAngleX -= MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 2.0F * limbSwingAmount * 0.5F;
		this.arm_left_lower.rotateAngleX -= MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 2.0F * limbSwingAmount * 0.5F;
		this.leg_right_bottom.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount + 0.8F * limbSwingAmount;
		this.leg_left_bottom.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount + 0.8F * limbSwingAmount;

		if (this.isRiding) {
			this.arm_right.rotateAngleX += -((float)Math.PI / 5F);
			this.arm_left.rotateAngleX += -((float)Math.PI / 5F);
			this.leg_right.rotateAngleX += -1.2F;
			this.leg_right.rotateAngleY += ((float)Math.PI / 10F);
			this.leg_right.rotateAngleZ += 0.07F;
			this.leg_left.rotateAngleX += -1.2F;
			this.leg_left.rotateAngleY += -((float)Math.PI / 10F);
			this.leg_left.rotateAngleZ += -0.07F;
			this.leg_right_bottom.rotateAngleX += 0.7F;
			this.leg_left_bottom.rotateAngleX += 0.7F;
		}


		if (this.swingProgress > 0.0F) {
			//EnumHandSide enumhandside = this.getMainHand(entityIn);
			//ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
			float f1 = this.swingProgress;
			/*//this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float)Math.PI * 2F)) * 0.2F;

			//if (enumhandside == EnumHandSide.LEFT)
			//{
				//this.bipedBody.rotateAngleY *= -1.0F;
			//}

			this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;*/
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float)Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float)Math.PI) * 0.7F * 0.75F;
			this.arm_right.rotateAngleX += (float)((double)this.arm_right.rotateAngleX - ((double)f2 * 1.2D + (double)f3));
			//modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			this.arm_right.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
		}

		this.arm_right.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.arm_left.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.arm_right.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.arm_left.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.lower_jaw.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
}
