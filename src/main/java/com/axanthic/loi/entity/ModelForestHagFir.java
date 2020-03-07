package com.axanthic.loi.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelForestHagFir extends ModelBase {
	public ModelRenderer leg_left_top;
	public ModelRenderer leg_right_top;
	public ModelRenderer body_bottom;
	public ModelRenderer leg_left_middle;
	public ModelRenderer leg_left_bottom;
	public ModelRenderer leg_left_foot;
	public ModelRenderer leg_left_sole;
	public ModelRenderer leg_right_middle;
	public ModelRenderer leg_right_foot;
	public ModelRenderer leg_right_sole;
	public ModelRenderer body_belly;
	public ModelRenderer body_chest;
	public ModelRenderer belly_shroom;
	public ModelRenderer body_breast;
	public ModelRenderer chest_shroom;
	public ModelRenderer body_shoulders;
	public ModelRenderer breast_shroom;
	public ModelRenderer body_breast_1;
	public ModelRenderer neck;
	public ModelRenderer shoulder_right;
	public ModelRenderer shoulder_left;
	public ModelRenderer backstem_right;
	public ModelRenderer backstem_center;
	public ModelRenderer backstem_left;
	public ModelRenderer head;
	public ModelRenderer neck_side;
	public ModelRenderer leafbeard_top;
	public ModelRenderer leafbeard_middle;
	public ModelRenderer leafbeard_bottom;
	public ModelRenderer leafbeard_thinbottom;
	public ModelRenderer leafbeard_tip;
	public ModelRenderer arm_right_top;
	public ModelRenderer arm_right_bottom;
	public ModelRenderer arm_left_top;
	public ModelRenderer arm_left_bottom;
	public ModelRenderer backshroom_head_right;
	public ModelRenderer backshroom_head_center;
	public ModelRenderer backshroom_head_center_1;

	public ModelForestHagFir() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.body_chest = new ModelRenderer(this, 74, 10);
		this.body_chest.setRotationPoint(0.3F, -5.0F, -0.2F);
		this.body_chest.addBox(-6.0F, -1.0F, -2.5F, 12, 6, 5, 0.0F);
		this.setRotateAngle(body_chest, 0.08726646259971647F, 0.04363323129985824F, 0.08726646259971647F);
		this.shoulder_right = new ModelRenderer(this, 64, 35);
		this.shoulder_right.setRotationPoint(-5.0F, 3.5F, 2.0F);
		this.shoulder_right.addBox(-9.0F, -3.0F, -6.0F, 13, 3, 11, 0.0F);
		this.setRotateAngle(shoulder_right, 0.0F, -0.39269908169872414F, 0.0F);
		this.leafbeard_bottom = new ModelRenderer(this, 112, 44);
		this.leafbeard_bottom.setRotationPoint(0.1F, 2.0F, 0.0F);
		this.leafbeard_bottom.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(leafbeard_bottom, 0.04363323129985824F, -0.08726646259971647F, -0.04363323129985824F);
		this.leg_left_middle = new ModelRenderer(this, 64, 0);
		this.leg_left_middle.setRotationPoint(0.5F, 5.0F, 0.0F);
		this.leg_left_middle.addBox(0.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(leg_left_middle, 0.08726646259971647F, 0.08726646259971647F, 0.0F);
		this.leg_right_middle = new ModelRenderer(this, 118, 0);
		this.leg_right_middle.setRotationPoint(0.5F, 7.0F, 0.0F);
		this.leg_right_middle.addBox(-3.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
		this.setRotateAngle(leg_right_middle, 0.08726646259971647F, -0.08726646259971647F, 0.0F);
		this.leg_right_foot = new ModelRenderer(this, 97, 6);
		this.leg_right_foot.setRotationPoint(-2.0F, 7.5F, -0.5F);
		this.leg_right_foot.addBox(-1.5F, 0.0F, -1.0F, 3, 1, 3, 0.0F);
		this.setRotateAngle(leg_right_foot, 0.17453292519943295F, 0.17453292519943295F, 0.0F);
		this.leafbeard_thinbottom = new ModelRenderer(this, 108, 16);
		this.leafbeard_thinbottom.setRotationPoint(0.2F, 3.0F, 0.0F);
		this.leafbeard_thinbottom.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
		this.setRotateAngle(leafbeard_thinbottom, 0.04363323129985824F, -0.17453292519943295F, -0.04363323129985824F);
		this.chest_shroom = new ModelRenderer(this, 46, 15);
		this.chest_shroom.setRotationPoint(1.0F, 4.0F, 2.5F);
		this.chest_shroom.addBox(-9.0F, -1.0F, -4.5F, 8, 1, 8, 0.0F);
		this.setRotateAngle(chest_shroom, 0.0F, -0.39269908169872414F, 0.0F);
		this.arm_left_top = new ModelRenderer(this, 32, 34);
		this.arm_left_top.setRotationPoint(1.0F, -1.5F, 0.0F);
		this.arm_left_top.addBox(0.0F, 0.0F, -1.5F, 2, 8, 3, 0.0F);
		this.setRotateAngle(arm_left_top, -0.3490658503988659F, -0.5235987755982988F, -0.2617993877991494F);
		this.backstem_right = new ModelRenderer(this, 109, 6);
		this.backstem_right.setRotationPoint(-6.0F, 1.0F, 4.0F);
		this.backstem_right.addBox(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(backstem_right, -0.6108652381980153F, -0.39269908169872414F, 0.0F);
		this.leg_left_sole = new ModelRenderer(this, 100, 0);
		this.leg_left_sole.setRotationPoint(-0.7F, 3.0F, -2.0F);
		this.leg_left_sole.addBox(-2.0F, 0.0F, -1.0F, 5, 2, 4, 0.0F);
		this.setRotateAngle(leg_left_sole, 0.0F, 0.17453292519943295F, 0.017453292519943295F);
		this.body_breast = new ModelRenderer(this, 0, 19);
		this.body_breast.setRotationPoint(-0.4F, -2.2F, -1.5F);
		this.body_breast.addBox(-6.5F, -1.0F, -3.0F, 13, 5, 7, 0.0F);
		this.setRotateAngle(body_breast, 0.2617993877991494F, 0.04363323129985824F, -0.08726646259971647F);
		this.body_shoulders = new ModelRenderer(this, 69, 21);
		this.body_shoulders.setRotationPoint(-0.4F, -4.0F, -0.5F);
		this.body_shoulders.addBox(-8.0F, 0.0F, -4.0F, 16, 5, 9, 0.0F);
		this.setRotateAngle(body_shoulders, 0.17453292519943295F, 0.04363323129985824F, -0.08726646259971647F);
		this.neck_side = new ModelRenderer(this, 82, 49);
		this.neck_side.setRotationPoint(2.5F, -2.9F, 0.0F);
		this.neck_side.addBox(0.0F, -1.0F, -9.5F, 3, 2, 10, 0.0F);
		this.setRotateAngle(neck_side, 0.0F, 0.22759093446006054F, 0.0F);
		this.leafbeard_top = new ModelRenderer(this, 24, 54);
		this.leafbeard_top.setRotationPoint(0.3F, 4.05F, -3.0F);
		this.leafbeard_top.addBox(-4.0F, 0.0F, -4.0F, 7, 2, 8, 0.0F);
		this.setRotateAngle(leafbeard_top, 0.0F, -0.08726646259971647F, 0.0F);
		this.backstem_left = new ModelRenderer(this, 58, 24);
		this.backstem_left.setRotationPoint(8.0F, 1.5F, -1.0F);
		this.backstem_left.addBox(-1.0F, -7.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(backstem_left, -0.17453292519943295F, 0.17453292519943295F, 0.39269908169872414F);
		this.leg_left_bottom = new ModelRenderer(this, 76, 0);
		this.leg_left_bottom.setRotationPoint(0.5F, 3.0F, 0.0F);
		this.leg_left_bottom.addBox(0.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(leg_left_bottom, 0.08726646259971647F, 0.0F, 0.0F);
		this.neck = new ModelRenderer(this, 32, 34);
		this.neck.setRotationPoint(1.0F, 5.0F, -2.0F);
		this.neck.addBox(-2.5F, -5.0F, -9.5F, 5, 5, 11, 0.0F);
		this.setRotateAngle(neck, -0.7853981633974483F, 0.08726646259971647F, -0.17453292519943295F);
		this.arm_right_bottom = new ModelRenderer(this, 119, 25);
		this.arm_right_bottom.setRotationPoint(-0.5F, 11.0F, 0.0F);
		this.arm_right_bottom.addBox(-2.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		this.setRotateAngle(arm_right_bottom, -0.17453292519943295F, -0.08726646259971647F, -0.17453292519943295F);
		this.backshroom_head_right = new ModelRenderer(this, 75, 61);
		this.backshroom_head_right.setRotationPoint(0.0F, -8.0F, 0.0F);
		this.backshroom_head_right.addBox(-3.5F, -1.0F, -3.5F, 7, 1, 7, 0.0F);
		this.setRotateAngle(backshroom_head_right, 0.0F, 0.2617993877991494F, 0.0F);
		this.leg_right_sole = new ModelRenderer(this, 59, 7);
		this.leg_right_sole.setRotationPoint(0.0F, 1.0F, 0.5F);
		this.leg_right_sole.addBox(-2.5F, 0.0F, -2.5F, 5, 3, 5, 0.0F);
		this.setRotateAngle(leg_right_sole, 0.0F, -0.2617993877991494F, 0.0F);
		this.arm_left_bottom = new ModelRenderer(this, 120, 51);
		this.arm_left_bottom.setRotationPoint(0.6F, 7.0F, 0.5F);
		this.arm_left_bottom.addBox(0.0F, 0.0F, -1.5F, 1, 12, 2, 0.0F);
		this.setRotateAngle(arm_left_bottom, -0.17453292519943295F, 0.0F, 0.17453292519943295F);
		this.leg_left_foot = new ModelRenderer(this, 84, 0);
		this.leg_left_foot.setRotationPoint(1.0F, 4.4F, 0.0F);
		this.leg_left_foot.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
		this.setRotateAngle(leg_left_foot, 0.08726646259971647F, 0.08726646259971647F, 0.0F);
		this.body_bottom = new ModelRenderer(this, 28, 0);
		this.body_bottom.setRotationPoint(0.5F, 4.0F, 1.7F);
		this.body_bottom.addBox(-6.5F, -1.0F, -2.5F, 13, 5, 5, 0.0F);
		this.setRotateAngle(body_bottom, -0.17453292519943295F, 0.04363323129985824F, 0.08726646259971647F);
		this.backshroom_head_center_1 = new ModelRenderer(this, 48, 63);
		this.backshroom_head_center_1.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.backshroom_head_center_1.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6, 0.0F);
		this.setRotateAngle(backshroom_head_center_1, 0.0F, 0.7853981633974483F, 0.0F);
		this.leafbeard_tip = new ModelRenderer(this, 0, 0);
		this.leafbeard_tip.setRotationPoint(0.2F, 2.2F, 0.0F);
		this.leafbeard_tip.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(leafbeard_tip, -0.04363323129985824F, -0.17453292519943295F, 0.04363323129985824F);
		this.leg_right_top = new ModelRenderer(this, 16, 0);
		this.leg_right_top.setRotationPoint(-2.5F, 6.0F, 1.0F);
		this.leg_right_top.addBox(-3.0F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.setRotateAngle(leg_right_top, -0.2617993877991494F, 0.08726646259971647F, 0.0F);
		this.shoulder_left = new ModelRenderer(this, 53, 34);
		this.shoulder_left.setRotationPoint(7.0F, 4.0F, 0.5F);
		this.shoulder_left.addBox(0.0F, -3.0F, -2.5F, 5, 3, 5, 0.0F);
		this.setRotateAngle(shoulder_left, 0.0F, 0.39269908169872414F, 0.0F);
		this.backshroom_head_center = new ModelRenderer(this, 0, 62);
		this.backshroom_head_center.setRotationPoint(0.0F, -8.0F, 0.0F);
		this.backshroom_head_center.addBox(-4.0F, -1.0F, -4.0F, 8, 1, 8, 0.0F);
		this.setRotateAngle(backshroom_head_center, 0.0F, -0.17453292519943295F, 0.0F);
		this.leafbeard_middle = new ModelRenderer(this, 101, 35);
		this.leafbeard_middle.setRotationPoint(0.3F, 1.0F, 0.0F);
		this.leafbeard_middle.addBox(-3.0F, 0.0F, -3.0F, 5, 3, 6, 0.0F);
		this.setRotateAngle(leafbeard_middle, 0.04363323129985824F, -0.17453292519943295F, -0.04363323129985824F);
		this.leg_left_top = new ModelRenderer(this, 0, 0);
		this.leg_left_top.setRotationPoint(2.0F, 7.0F, 1.0F);
		this.leg_left_top.addBox(0.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.setRotateAngle(leg_left_top, -0.2617993877991494F, -0.08726646259971647F, 0.0F);
		this.backstem_center = new ModelRenderer(this, 117, 11);
		this.backstem_center.setRotationPoint(0.0F, -4.0F, -1.0F);
		this.backstem_center.addBox(-1.0F, -8.0F, -1.0F, 2, 12, 2, 0.0F);
		this.setRotateAngle(backstem_center, 0.0F, 0.39269908169872414F, 0.0F);
		this.body_breast_1 = new ModelRenderer(this, 0, 31);
		this.body_breast_1.setRotationPoint(4.05F, 0.0F, 0.05F);
		this.body_breast_1.addBox(-6.5F, -1.0F, -3.0F, 9, 24, 7, 0.0F);
		this.head = new ModelRenderer(this, 58, 49);
		this.head.setRotationPoint(-1.0F, -3.0F, -6.5F);
		this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 8, 6, 0.0F);
		this.setRotateAngle(head, 0.3490658503988659F, -0.4363323129985824F, 0.17453292519943295F);
		this.body_belly = new ModelRenderer(this, 24, 10);
		this.body_belly.setRotationPoint(0.1F, -4.0F, -0.2F);
		this.body_belly.addBox(-5.5F, -1.0F, -2.0F, 11, 5, 4, 0.0F);
		this.setRotateAngle(body_belly, 0.08726646259971647F, 0.04363323129985824F, 0.08726646259971647F);
		this.breast_shroom = new ModelRenderer(this, 31, 24);
		this.breast_shroom.setRotationPoint(0.0F, 3.5F, -1.0F);
		this.breast_shroom.addBox(-9.0F, -1.0F, -4.5F, 9, 1, 9, 0.0F);
		this.setRotateAngle(breast_shroom, 0.0F, 0.39269908169872414F, 0.0F);
		this.belly_shroom = new ModelRenderer(this, 0, 10);
		this.belly_shroom.setRotationPoint(-4.5F, 2.0F, 0.0F);
		this.belly_shroom.addBox(-2.5F, -1.0F, -2.5F, 5, 1, 5, 0.0F);
		this.setRotateAngle(belly_shroom, 0.0F, 0.7853981633974483F, 0.0F);
		this.arm_right_top = new ModelRenderer(this, 108, 51);
		this.arm_right_top.setRotationPoint(-5.0F, -1.0F, -2.0F);
		this.arm_right_top.addBox(-3.0F, 0.0F, -1.5F, 3, 12, 3, 0.0F);
		this.setRotateAngle(arm_right_top, -0.5235987755982988F, 0.08726646259971647F, 0.17453292519943295F);
		this.body_belly.addChild(this.body_chest);
		this.body_shoulders.addChild(this.shoulder_right);
		this.leafbeard_middle.addChild(this.leafbeard_bottom);
		this.leg_left_top.addChild(this.leg_left_middle);
		this.leg_right_top.addChild(this.leg_right_middle);
		this.leg_right_middle.addChild(this.leg_right_foot);
		this.leafbeard_bottom.addChild(this.leafbeard_thinbottom);
		this.body_chest.addChild(this.chest_shroom);
		this.shoulder_left.addChild(this.arm_left_top);
		this.body_shoulders.addChild(this.backstem_right);
		this.leg_left_foot.addChild(this.leg_left_sole);
		this.body_chest.addChild(this.body_breast);
		this.body_breast.addChild(this.body_shoulders);
		this.neck.addChild(this.neck_side);
		this.head.addChild(this.leafbeard_top);
		this.body_shoulders.addChild(this.backstem_left);
		this.leg_left_middle.addChild(this.leg_left_bottom);
		this.body_shoulders.addChild(this.neck);
		this.arm_right_top.addChild(this.arm_right_bottom);
		this.backstem_right.addChild(this.backshroom_head_right);
		this.leg_right_foot.addChild(this.leg_right_sole);
		this.arm_left_top.addChild(this.arm_left_bottom);
		this.leg_left_bottom.addChild(this.leg_left_foot);
		this.backstem_left.addChild(this.backshroom_head_center_1);
		this.leafbeard_thinbottom.addChild(this.leafbeard_tip);
		this.body_shoulders.addChild(this.shoulder_left);
		this.backstem_center.addChild(this.backshroom_head_center);
		this.leafbeard_top.addChild(this.leafbeard_middle);
		this.body_shoulders.addChild(this.backstem_center);
		this.body_breast.addChild(this.body_breast_1);
		this.neck.addChild(this.head);
		this.body_bottom.addChild(this.body_belly);
		this.body_breast.addChild(this.breast_shroom);
		this.body_belly.addChild(this.belly_shroom);
		this.shoulder_right.addChild(this.arm_right_top);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -MathHelper.cos(limbSwing * 0.6662F * 2.0f + 2.7f) * limbSwingAmount / 8.0f + limbSwingAmount / 15.05f, 0.0F);
		this.body_bottom.render(scale);
		this.leg_right_top.render(scale);
		this.leg_left_top.render(scale);
		GlStateManager.popMatrix();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void wiggleRotateAngle(ModelRenderer modelRenderer, float x, float y, float z, float ageInTicks) {
		modelRenderer.rotateAngleX = MathHelper.cos(ageInTicks * 0.045F) * 0.015F + x;
		modelRenderer.rotateAngleY = MathHelper.sin(ageInTicks * 0.034F) * 0.015F + y;
		modelRenderer.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.04F) * 0.015F + z;
	}

	float armBend = 1.0f;
	float elbowBend = 1.0f;
	float legBend = 1.5f;
	float kneeBend = 1.3f;
	float beardSpeed = 3.0f;

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F + 0.3490658503988659F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F - 0.4363323129985824F;

		//limbSwing = ageInTicks / 10.0f;
		//limbSwingAmount = 0.5f;

		this.leg_left_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * legBend * limbSwingAmount - 0.2617993877991494F;
		this.leg_right_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * legBend * limbSwingAmount - 0.2617993877991494F;

		this.arm_right_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * armBend * limbSwingAmount - 0.5235987755982988F;
		this.arm_left_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * armBend * limbSwingAmount - 0.3490658503988659F;

		this.arm_right_bottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * elbowBend * limbSwingAmount - elbowBend * limbSwingAmount - 0.17453292519943295F;
		this.arm_left_bottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * elbowBend * limbSwingAmount - elbowBend * limbSwingAmount - 0.17453292519943295F;

		this.leg_right_middle.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;
		this.leg_left_bottom.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;

		if (this.swingProgress > 0.0F)  {
			float f2 = MathHelper.sin(this.swingProgress * (float)Math.PI) * 2.0F;
			this.arm_left_top.rotateAngleX -= f2;
			this.arm_right_top.rotateAngleX -= f2;
		}

		this.arm_right_top.rotateAngleZ = 0.39269908169872414F;
		this.arm_left_top.rotateAngleZ = -0.08726646259971647F;
		this.arm_right_top.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.arm_left_top.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.arm_right_top.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.arm_left_top.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		this.wiggleRotateAngle(body_chest, 0.08726646259971647F, 0.04363323129985824F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(shoulder_right, 0.0F, -0.39269908169872414F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(leafbeard_bottom, 0.04363323129985824F, -0.08726646259971647F, -0.04363323129985824F, ageInTicks * beardSpeed);
		this.wiggleRotateAngle(leafbeard_thinbottom, 0.04363323129985824F, -0.17453292519943295F, -0.04363323129985824F, ageInTicks * beardSpeed);
		this.wiggleRotateAngle(chest_shroom, 0.0F, -0.39269908169872414F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(backstem_right, -0.6108652381980153F, -0.39269908169872414F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(body_breast, 0.2617993877991494F, 0.04363323129985824F, -0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(body_shoulders, 0.17453292519943295F, 0.04363323129985824F, -0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(neck_side, 0.0F, 0.22759093446006054F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(backstem_left, -0.17453292519943295F, 0.17453292519943295F, 0.39269908169872414F, ageInTicks);
		this.wiggleRotateAngle(neck, -0.7853981633974483F, 0.08726646259971647F, -0.17453292519943295F, ageInTicks);
		this.wiggleRotateAngle(backshroom_head_right, 0.0F, 0.2617993877991494F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(body_bottom, -0.17453292519943295F, 0.04363323129985824F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(backshroom_head_center_1, 0.0F, 0.7853981633974483F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(leafbeard_tip, -0.04363323129985824F, -0.17453292519943295F, 0.04363323129985824F, ageInTicks * beardSpeed);
		this.wiggleRotateAngle(shoulder_left, 0.0F, 0.39269908169872414F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(backshroom_head_center, 0.0F, -0.17453292519943295F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(leafbeard_middle, 0.04363323129985824F, -0.17453292519943295F, -0.04363323129985824F, ageInTicks * beardSpeed);
		this.wiggleRotateAngle(backstem_center, 0.0F, 0.39269908169872414F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(body_belly, 0.08726646259971647F, 0.04363323129985824F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(breast_shroom, 0.0F, 0.39269908169872414F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(belly_shroom, 0.0F, 0.7853981633974483F, 0.0F, ageInTicks);
	}
}