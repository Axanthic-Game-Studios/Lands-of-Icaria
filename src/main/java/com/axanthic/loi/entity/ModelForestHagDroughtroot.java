package com.axanthic.loi.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelForestHagDroughtroot extends ModelBase {
	public ModelRenderer right_leg_top;
	public ModelRenderer left_leg_top;
	public ModelRenderer pelvis;
	public ModelRenderer right_leg_middle;
	public ModelRenderer right_leg_bottom;
	public ModelRenderer right_foot;
	public ModelRenderer left_leg_middle;
	public ModelRenderer left_leg_bottom;
	public ModelRenderer left_foot;
	public ModelRenderer belly;
	public ModelRenderer chest;
	public ModelRenderer breast;
	public ModelRenderer leaves_chest;
	public ModelRenderer right_shoulder;
	public ModelRenderer left_shoulder;
	public ModelRenderer neck;
	public ModelRenderer branch_base;
	public ModelRenderer right_arm;
	public ModelRenderer right_arm_lower;
	public ModelRenderer left_arm;
	public ModelRenderer vines_left;
	public ModelRenderer head;
	public ModelRenderer neck_comb;
	public ModelRenderer branch_middle;
	public ModelRenderer branch_top;
	public ModelRenderer sidebranch_thing;
	public ModelRenderer leaves_top_outer;
	public ModelRenderer leaves_top_center;
	public ModelRenderer leaves_top_outer_1;

	public ModelForestHagDroughtroot() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.vines_left = new ModelRenderer(this, 28, 29);
		this.vines_left.setRotationPoint(0.01F, 0.0F, 0.01F);
		this.vines_left.addBox(-5.5F, 0.0F, -3.0F, 9, 17, 10, 0.0F);
		this.leaves_top_center = new ModelRenderer(this, 0, 32);
		this.leaves_top_center.setRotationPoint(0.0F, -5.4F, -1.8F);
		this.leaves_top_center.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(leaves_top_center, 0.0F, 0.7853981633974483F, 0.0F);
		this.pelvis = new ModelRenderer(this, 24, 0);
		this.pelvis.setRotationPoint(-0.8F, 3.5F, 0.5F);
		this.pelvis.addBox(-5.5F, 0.0F, -2.5F, 11, 4, 5, 0.0F);
		this.setRotateAngle(pelvis, -0.17453292519943295F, 0.0F, -0.08726646259971647F);
		this.chest = new ModelRenderer(this, 86, 8);
		this.chest.setRotationPoint(0.5F, -3.5F, 0.2F);
		this.chest.addBox(-5.5F, 0.0F, -3.5F, 10, 4, 5, 0.0F);
		this.setRotateAngle(chest, 0.08726646259971647F, 0.08726646259971647F, 0.04363323129985824F);
		this.right_shoulder = new ModelRenderer(this, 46, 16);
		this.right_shoulder.setRotationPoint(-2.6F, -4.0F, -2.1F);
		this.right_shoulder.addBox(-5.5F, 0.0F, -3.0F, 8, 5, 8, 0.0F);
		this.setRotateAngle(right_shoulder, 0.17453292519943295F, -0.13962634015954636F, 0.04363323129985824F);
		this.left_shoulder = new ModelRenderer(this, 78, 17);
		this.left_shoulder.setRotationPoint(3.5F, -1.0F, -2.0F);
		this.left_shoulder.addBox(-5.5F, 0.0F, -3.0F, 9, 3, 10, 0.0F);
		this.setRotateAngle(left_shoulder, 0.17453292519943295F, 0.08203047484373349F, 0.04363323129985824F);
		this.branch_top = new ModelRenderer(this, 46, 9);
		this.branch_top.setRotationPoint(0.0F, -5.4F, 0.2F);
		this.branch_top.addBox(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(branch_top, 0.2617993877991494F, 0.0F, -0.08726646259971647F);
		this.right_arm_lower = new ModelRenderer(this, 118, 0);
		this.right_arm_lower.setRotationPoint(-0.5F, 8.0F, 0.0F);
		this.right_arm_lower.addBox(-2.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		this.setRotateAngle(right_arm_lower, -0.17453292519943295F, 0.17453292519943295F, -0.17453292519943295F);
		this.head = new ModelRenderer(this, 66, 30);
		this.head.setRotationPoint(0.0F, 1.0F, -5.0F);
		this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 8, 6, 0.0F);
		this.setRotateAngle(head, 0.4363323129985824F, -0.08726646259971647F, 0.0F);
		this.left_arm = new ModelRenderer(this, 122, 12);
		this.left_arm.setRotationPoint(3.0F, 1.0F, 1.5F);
		this.left_arm.addBox(0.0F, 0.0F, 1.5F, 1, 16, 1, 0.0F);
		this.setRotateAngle(left_arm, -0.2617993877991494F, -0.17453292519943295F, -0.3490658503988659F);
		this.branch_middle = new ModelRenderer(this, 16, 19);
		this.branch_middle.setRotationPoint(0.0F, -5.4F, 0.2F);
		this.branch_middle.addBox(-1.5F, -6.0F, -1.5F, 3, 6, 3, 0.0F);
		this.setRotateAngle(branch_middle, 0.2617993877991494F, 0.0F, -0.08726646259971647F);
		this.right_leg_top = new ModelRenderer(this, 0, 0);
		this.right_leg_top.setRotationPoint(-4.0F, 6.4F, 0.0F);
		this.right_leg_top.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
		this.setRotateAngle(right_leg_top, -0.17453292519943295F, 0.17453292519943295F, 0.0F);
		this.right_foot = new ModelRenderer(this, 76, 0);
		this.right_foot.setRotationPoint(0.0F, 3.1F, 0.0F);
		this.right_foot.addBox(-3.0F, 0.0F, -2.0F, 5, 4, 4, 0.0F);
		this.setRotateAngle(right_foot, 0.0F, -1.7453292519943295F, 0.0F);
		this.right_leg_middle = new ModelRenderer(this, 56, 0);
		this.right_leg_middle.setRotationPoint(0.0F, 4.4F, 0.0F);
		this.right_leg_middle.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(right_leg_middle, 0.08726646259971647F, -0.08726646259971647F, 0.0F);
		this.right_leg_bottom = new ModelRenderer(this, 64, 0);
		this.right_leg_bottom.setRotationPoint(0.0F, 6.2F, 0.0F);
		this.right_leg_bottom.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(right_leg_bottom, 0.08726646259971647F, 0.0F, 0.0F);
		this.left_leg_middle = new ModelRenderer(this, 94, 0);
		this.left_leg_middle.setRotationPoint(0.2F, 4.5F, 0.0F);
		this.left_leg_middle.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		this.setRotateAngle(left_leg_middle, 0.0F, -0.08726646259971647F, 0.04363323129985824F);
		this.right_arm = new ModelRenderer(this, 26, 27);
		this.right_arm.setRotationPoint(-1.5F, 4.0F, 1.5F);
		this.right_arm.addBox(-3.0F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.setRotateAngle(right_arm, -0.3490658503988659F, -0.13962634015954636F, 0.39269908169872414F);
		this.neck_comb = new ModelRenderer(this, 108, 27);
		this.neck_comb.setRotationPoint(0.0F, 0.0F, 0.3F);
		this.neck_comb.addBox(-0.5F, -1.0F, -7.0F, 1, 1, 8, 0.0F);
		this.left_foot = new ModelRenderer(this, 106, 0);
		this.left_foot.setRotationPoint(0.0F, 6.3F, 0.0F);
		this.left_foot.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(left_foot, 0.08726646259971647F, 0.08726646259971647F, 0.04363323129985824F);
		this.sidebranch_thing = new ModelRenderer(this, 111, 6);
		this.sidebranch_thing.setRotationPoint(0.0F, -1.0F, 1.0F);
		this.sidebranch_thing.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(sidebranch_thing, -0.9105382707654417F, -0.5462880558742251F, -0.18203784098300857F);
		this.leaves_top_outer_1 = new ModelRenderer(this, 56, 48);
		this.leaves_top_outer_1.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.leaves_top_outer_1.addBox(-5.0F, -6.0F, -5.0F, 10, 4, 10, 0.0F);
		this.left_leg_top = new ModelRenderer(this, 12, 0);
		this.left_leg_top.setRotationPoint(3.0F, 6.4F, 0.0F);
		this.left_leg_top.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.setRotateAngle(left_leg_top, -0.17453292519943295F, -0.08726646259971647F, -0.17453292519943295F);
		this.branch_base = new ModelRenderer(this, 106, 17);
		this.branch_base.setRotationPoint(0.0F, -0.7F, 0.9F);
		this.branch_base.addBox(-2.0F, -6.0F, -2.0F, 4, 6, 4, 0.0F);
		this.setRotateAngle(branch_base, 0.0F, -0.06981317007977318F, 0.17453292519943295F);
		this.left_leg_bottom = new ModelRenderer(this, 102, 0);
		this.left_leg_bottom.setRotationPoint(0.0F, 4.2F, 0.0F);
		this.left_leg_bottom.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
		this.setRotateAngle(left_leg_bottom, 0.08726646259971647F, 0.08726646259971647F, 0.08726646259971647F);
		this.leaves_top_outer = new ModelRenderer(this, 81, 35);
		this.leaves_top_outer.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.leaves_top_outer.addBox(-6.0F, -6.0F, -3.0F, 9, 4, 9, 0.0F);
		this.setRotateAngle(leaves_top_outer, 0.0F, 0.7853981633974483F, 0.0F);
		this.leaves_chest = new ModelRenderer(this, 34, 9);
		this.leaves_chest.setRotationPoint(-3.0F, 2.5F, -1.0F);
		this.leaves_chest.addBox(-1.0F, -7.0F, 0.0F, 2, 14, 4, 0.0F);
		this.setRotateAngle(leaves_chest, -0.091106186954104F, 0.08726646259971647F, 0.04363323129985824F);
		this.belly = new ModelRenderer(this, 60, 8);
		this.belly.setRotationPoint(0.5F, -3.7F, 0.2F);
		this.belly.addBox(-4.7F, 0.0F, -2.5F, 9, 4, 4, 0.0F);
		this.setRotateAngle(belly, 0.08726646259971647F, 0.08726646259971647F, 0.04363323129985824F);
		this.neck = new ModelRenderer(this, 0, 19);
		this.neck.setRotationPoint(0.0F, -2.7F, 0.3F);
		this.neck.addBox(-1.5F, 0.0F, -7.0F, 3, 3, 10, 0.0F);
		this.setRotateAngle(neck, -0.6981317007977318F, -0.06981317007977318F, 0.17453292519943295F);
		this.breast = new ModelRenderer(this, 0, 9);
		this.breast.setRotationPoint(-0.2F, -3.3F, -1.7F);
		this.breast.addBox(-5.5F, 0.0F, -3.0F, 11, 4, 6, 0.0F);
		this.setRotateAngle(breast, 0.17453292519943295F, 0.08203047484373349F, 0.04363323129985824F);
		this.left_shoulder.addChild(this.vines_left);
		this.branch_top.addChild(this.leaves_top_center);
		this.belly.addChild(this.chest);
		this.breast.addChild(this.right_shoulder);
		this.breast.addChild(this.left_shoulder);
		this.branch_middle.addChild(this.branch_top);
		this.right_arm.addChild(this.right_arm_lower);
		this.neck.addChild(this.head);
		this.left_shoulder.addChild(this.left_arm);
		this.branch_base.addChild(this.branch_middle);
		this.right_leg_bottom.addChild(this.right_foot);
		this.right_leg_top.addChild(this.right_leg_middle);
		this.right_leg_middle.addChild(this.right_leg_bottom);
		this.left_leg_top.addChild(this.left_leg_middle);
		this.right_shoulder.addChild(this.right_arm);
		this.neck.addChild(this.neck_comb);
		this.left_leg_bottom.addChild(this.left_foot);
		this.branch_middle.addChild(this.sidebranch_thing);
		this.leaves_top_center.addChild(this.leaves_top_outer_1);
		this.breast.addChild(this.branch_base);
		this.left_leg_middle.addChild(this.left_leg_bottom);
		this.branch_middle.addChild(this.leaves_top_outer);
		this.chest.addChild(this.leaves_chest);
		this.pelvis.addChild(this.belly);
		this.breast.addChild(this.neck);
		this.chest.addChild(this.breast);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		this.pelvis.render(f5);
		this.right_leg_top.render(f5);
		this.left_leg_top.render(f5);
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

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F + 0.4363323129985824F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F - 0.08726646259971647F;

		//limbSwing = ageInTicks / 10.0f;
		//limbSwingAmount = 0.5f;

		this.left_leg_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * legBend * limbSwingAmount - 0.17453292519943295F;
		this.right_leg_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * legBend * limbSwingAmount - 0.17453292519943295F;

		this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * armBend * limbSwingAmount - 0.3490658503988659F;
		this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * armBend * limbSwingAmount - 0.2617993877991494F;

		this.right_arm_lower.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * elbowBend * limbSwingAmount - elbowBend * limbSwingAmount - 0.17453292519943295F;

		this.right_leg_bottom.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;
		this.left_leg_bottom.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;

		if (this.swingProgress > 0.0F)  {
			float f2 = MathHelper.sin(this.swingProgress * (float)Math.PI) * 2.0F;
			this.left_arm.rotateAngleX -= f2;
			this.right_arm.rotateAngleX -= f2;
		}

		this.right_arm.rotateAngleZ = 0.39269908169872414F;
		this.left_arm.rotateAngleZ = -0.08726646259971647F;
		//this.left_arm.rotateAngleX = -0.39269908169872414F;
		this.right_arm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.left_arm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.right_arm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.left_arm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		this.wiggleRotateAngle(leaves_top_center, 0.0F, 0.7853981633974483F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(chest, 0.08726646259971647F, 0.08726646259971647F, 0.04363323129985824F, ageInTicks);
		this.wiggleRotateAngle(right_shoulder, 0.17453292519943295F, -0.13962634015954636F, 0.04363323129985824F, ageInTicks);
		this.wiggleRotateAngle(left_shoulder, 0.17453292519943295F, 0.08203047484373349F, 0.04363323129985824F, ageInTicks);
		this.wiggleRotateAngle(branch_top, 0.2617993877991494F, 0.0F, -0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(branch_middle, 0.2617993877991494F, 0.0F, -0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(sidebranch_thing, -0.9105382707654417F, -0.5462880558742251F, -0.18203784098300857F, ageInTicks);
		this.wiggleRotateAngle(branch_base, 0.0F, -0.06981317007977318F, 0.17453292519943295F, ageInTicks);
		this.wiggleRotateAngle(leaves_top_outer, 0.0F, 0.7853981633974483F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(leaves_chest, -0.091106186954104F, 0.08726646259971647F, 0.04363323129985824F, ageInTicks);
		this.wiggleRotateAngle(belly, 0.08726646259971647F, 0.08726646259971647F, 0.04363323129985824F, ageInTicks);
		this.wiggleRotateAngle(neck, -0.6981317007977318F, -0.06981317007977318F, 0.17453292519943295F, ageInTicks);
		this.wiggleRotateAngle(breast, 0.17453292519943295F, 0.08203047484373349F, 0.04363323129985824F, ageInTicks);
	}
}