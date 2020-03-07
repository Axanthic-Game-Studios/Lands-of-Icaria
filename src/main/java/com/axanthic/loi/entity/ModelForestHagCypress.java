package com.axanthic.loi.entity;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelForestHagCypress extends ModelBase {
	public ModelRenderer right_leg_top;
	public ModelRenderer left_leg_top_extension;
	public ModelRenderer body_bottom_main;
	public ModelRenderer right_leg_top_middle;
	public ModelRenderer right_leg_bottom_middle;
	public ModelRenderer right_leg_bottom;
	public ModelRenderer left_leg_top;
	public ModelRenderer left_leg_bottom;
	public ModelRenderer body_center_bottom;
	public ModelRenderer body_bottom_right;
	public ModelRenderer body_center;
	public ModelRenderer shroom_body_center_bottom;
	public ModelRenderer body_center_top;
	public ModelRenderer shroom_body_center;
	public ModelRenderer body_top;
	public ModelRenderer shroom_body_center_top;
	public ModelRenderer neck;
	public ModelRenderer body_top_extension;
	public ModelRenderer arm_right;
	public ModelRenderer arm_left;
	public ModelRenderer branch_back_bottom;
	public ModelRenderer head;
	public ModelRenderer head_branch_front_bottom;
	public ModelRenderer head_branch_back_bottom;
	public ModelRenderer leaves_back_sidebranch;
	public ModelRenderer head_branch_front_bottom_1;
	public ModelRenderer head_branch_front_bottom_2;
	public ModelRenderer leaves_back_sidebranch_1;
	public ModelRenderer vines_back;
	public ModelRenderer arm_right_tip;
	public ModelRenderer arm_left_bottom;
	public ModelRenderer branch_back_center;
	public ModelRenderer branch_back_center_1;
	public ModelRenderer branch_back_center_2;
	public ModelRenderer branch_back_center_3;
	public ModelRenderer branch_back_center_4;
	public ModelRenderer branch_back_center_5;
	public ModelRenderer leaves_backbranch;
	public ModelRenderer leaves_backbranch_tip;
	public ModelRenderer branch_back_center_6;
	public ModelRenderer leaves_back_sidebranch_2;
	public ModelRenderer leaves_back_sidebranch_tip;

	public ModelForestHagCypress() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.body_center_bottom = new ModelRenderer(this, 48, 6);
		this.body_center_bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body_center_bottom.addBox(-4.5F, -3.5F, -2.0F, 9, 4, 4, 0.0F);
		this.setRotateAngle(body_center_bottom, 0.0F, -0.08726646259971647F, 0.0F);
		this.branch_back_center_2 = new ModelRenderer(this, 25, 38);
		this.branch_back_center_2.setRotationPoint(0.0F, 0.8F, 4.0F);
		this.branch_back_center_2.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 5, 0.0F);
		this.setRotateAngle(branch_back_center_2, 0.39269908169872414F, 0.2617993877991494F, 0.0F);
		this.body_center = new ModelRenderer(this, 69, 9);
		this.body_center.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.body_center.addBox(-5.0F, -3.5F, -2.5F, 10, 4, 5, 0.0F);
		this.setRotateAngle(body_center, 0.08726646259971647F, -0.08726646259971647F, 0.0F);
		this.right_leg_top = new ModelRenderer(this, 0, 0);
		this.right_leg_top.setRotationPoint(-3.0F, 7.0F, 0.0F);
		this.right_leg_top.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
		this.setRotateAngle(right_leg_top, -0.08726646259971647F, /*0.39269908169872414F*/0.0f, 0.0F);
		this.right_leg_bottom_middle = new ModelRenderer(this, 64, 0);
		this.right_leg_bottom_middle.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.right_leg_bottom_middle.addBox(-2.0F, -0.4F, -2.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(right_leg_bottom_middle, 0.0F, -0.08726646259971647F, 0.08726646259971647F);
		this.head_branch_front_bottom = new ModelRenderer(this, 37, 9);
		this.head_branch_front_bottom.setRotationPoint(-1.5F, -6.4F, -2.5F);
		this.head_branch_front_bottom.addBox(-1.0F, -3.5F, -1.0F, 2, 3, 2, 0.0F);
		this.setRotateAngle(head_branch_front_bottom, 0.0F, -0.40980330836826856F, -0.5462880558742251F);
		this.left_leg_top = new ModelRenderer(this, 100, 0);
		this.left_leg_top.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.left_leg_top.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(left_leg_top, 0.0F, -0.39269908169872414F, 0.0F);
		this.shroom_body_center_bottom = new ModelRenderer(this, 117, 0);
		this.shroom_body_center_bottom.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.shroom_body_center_bottom.addBox(0.0F, -1.8F, -3.0F, 4, 2, 1, 0.0F);
		this.body_top = new ModelRenderer(this, 48, 18);
		this.body_top.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.body_top.addBox(-6.5F, -3.5F, -3.5F, 13, 4, 7, 0.0F);
		this.setRotateAngle(body_top, 0.08726646259971647F, -0.08726646259971647F, 0.0F);
		this.neck = new ModelRenderer(this, 99, 10);
		this.neck.setRotationPoint(0.0F, -1.5F, -0.5F);
		this.neck.addBox(-2.0F, -8.0F, -1.0F, 4, 8, 4, 0.0F);
		this.setRotateAngle(neck, 0.6108652381980153F, 0.17453292519943295F, 0.0F);
		this.body_bottom_main = new ModelRenderer(this, 20, 0);
		this.body_bottom_main.setRotationPoint(0.0F, 3.8F, 0.5F);
		this.body_bottom_main.addBox(-5.5F, 0.0F, -2.5F, 11, 4, 5, 0.0F);
		this.setRotateAngle(body_bottom_main, -0.08726646259971647F, 0.0F, 0.0F);
		this.arm_left_bottom = new ModelRenderer(this, 96, 32);
		this.arm_left_bottom.setRotationPoint(0.0F, 3.5F, -2.5F);
		this.arm_left_bottom.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
		this.setRotateAngle(arm_left_bottom, 0.0F, -0.39269908169872414F, 0.08726646259971647F);
		this.body_center_top = new ModelRenderer(this, 19, 14);
		this.body_center_top.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.body_center_top.addBox(-6.0F, -3.5F, -3.0F, 12, 4, 6, 0.0F);
		this.setRotateAngle(body_center_top, 0.08726646259971647F, -0.08726646259971647F, 0.0F);
		this.arm_left = new ModelRenderer(this, 0, 16);
		this.arm_left.setRotationPoint(3.5F, -3.0F, -1.0F);
		this.arm_left.addBox(-2.0F, 0.0F, -4.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(arm_left, -0.39269908169872414F, -0.7853981633974483F, -0.08726646259971647F);
		this.leaves_backbranch_tip = new ModelRenderer(this, 104, 43);
		this.leaves_backbranch_tip.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leaves_backbranch_tip.addBox(-3.0F, -3.0F, 8.0F, 6, 6, 3, 0.0F);
		this.vines_back = new ModelRenderer(this, 78, 32);
		this.vines_back.setRotationPoint(-3.5F, 0.0F, 4.55F);
		this.vines_back.addBox(-6.0F, 0.0F, 0.0F, 8, 16, 1, 0.0F);
		this.setRotateAngle(vines_back, -0.136659280431156F, 0.0F, 0.0F);
		this.left_leg_bottom = new ModelRenderer(this, 108, 0);
		this.left_leg_bottom.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.left_leg_bottom.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
		this.setRotateAngle(left_leg_bottom, 0.08726646259971647F, 0.17453292519943295F, 0.0F);
		this.branch_back_center_4 = new ModelRenderer(this, 40, 24);
		this.branch_back_center_4.setRotationPoint(-0.1F, 1.1F, 4.5F);
		this.branch_back_center_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(branch_back_center_4, 0.091106186954104F, 0.8651597102135892F, 3.096039560112741F);
		this.left_leg_top_extension = new ModelRenderer(this, 8, 0);
		this.left_leg_top_extension.setRotationPoint(3.4F, 7.5F, 0.0F);
		this.left_leg_top_extension.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(left_leg_top_extension, -0.08726646259971647F, -0.27314402793711257F, 0.0F);
		this.leaves_back_sidebranch_1 = new ModelRenderer(this, 106, 22);
		this.leaves_back_sidebranch_1.setRotationPoint(0.0F, -4.0F, 0.1F);
		this.leaves_back_sidebranch_1.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5, 0.0F);
		this.shroom_body_center = new ModelRenderer(this, 25, 9);
		this.shroom_body_center.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.shroom_body_center.addBox(1.5F, -1.5F, -3.0F, 4, 2, 2, 0.0F);
		this.body_top_extension = new ModelRenderer(this, 80, 22);
		this.body_top_extension.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.body_top_extension.addBox(-9.5F, -2.0F, -3.5F, 9, 2, 8, 0.0F);
		this.setRotateAngle(body_top_extension, 0.08726646259971647F, -0.08726646259971647F, 0.17453292519943295F);
		this.branch_back_bottom = new ModelRenderer(this, 0, 24);
		this.branch_back_bottom.setRotationPoint(-1.4F, -2.5F, 0.5F);
		this.branch_back_bottom.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 7, 0.0F);
		this.setRotateAngle(branch_back_bottom, 0.40980330836826856F, 0.7853981633974483F, 0.0F);
		this.right_leg_top_middle = new ModelRenderer(this, 52, 0);
		this.right_leg_top_middle.setRotationPoint(0.0F, 9.0F, 0.0F);
		this.right_leg_top_middle.addBox(-1.5F, -0.2F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(right_leg_top_middle, 0.08726646259971647F, -0.08726646259971647F, 0.0F);
		this.leaves_back_sidebranch_tip = new ModelRenderer(this, 32, 45);
		this.leaves_back_sidebranch_tip.setRotationPoint(0.0F, 0.0F, -3.0F);
		this.leaves_back_sidebranch_tip.addBox(-2.5F, -2.5F, -2.0F, 5, 5, 2, 0.0F);
		this.head = new ModelRenderer(this, 22, 24);
		this.head.setRotationPoint(-0.5F, -5.0F, 0.0F);
		this.head.addBox(-3.0F, -8.0F, -4.0F, 6, 8, 6, 0.0F);
		this.setRotateAngle(head, -0.6108652381980153F, 0.17453292519943295F, 0.08726646259971647F);
		this.leaves_back_sidebranch = new ModelRenderer(this, 46, 29);
		this.leaves_back_sidebranch.setRotationPoint(-0.65F, -10.0F, -0.5F);
		this.leaves_back_sidebranch.addBox(-4.0F, -4.0F, -4.0F, 8, 4, 8, 0.0F);
		this.leaves_backbranch = new ModelRenderer(this, 47, 41);
		this.leaves_backbranch.setRotationPoint(-0.5F, 0.0F, 0.0F);
		this.leaves_backbranch.addBox(-4.5F, -4.5F, 4.0F, 9, 9, 4, 0.0F);
		this.shroom_body_center_top = new ModelRenderer(this, 8, 6);
		this.shroom_body_center_top.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.shroom_body_center_top.addBox(1.5F, -1.5F, -4.0F, 4, 2, 1, 0.0F);
		this.head_branch_front_bottom_1 = new ModelRenderer(this, 20, 0);
		this.head_branch_front_bottom_1.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.head_branch_front_bottom_1.addBox(-0.5F, -3.5F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(head_branch_front_bottom_1, 0.27314402793711257F, 0.22759093446006054F, 0.31869712141416456F);
		this.arm_right = new ModelRenderer(this, 115, 10);
		this.arm_right.setRotationPoint(-6.4F, -4.3F, -0.5F);
		this.arm_right.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.setRotateAngle(arm_right, -0.17453292519943295F, 0.17453292519943295F, 0.39269908169872414F);
		this.body_bottom_right = new ModelRenderer(this, 5, 9);
		this.body_bottom_right.setRotationPoint(-3.5F, 3.0F, 0.0F);
		this.body_bottom_right.addBox(-1.5F, 0.0F, -1.6F, 7, 4, 3, 0.0F);
		this.setRotateAngle(body_bottom_right, 0.0F, -0.08726646259971647F, -0.39269908169872414F);
		this.branch_back_center_6 = new ModelRenderer(this, 0, 43);
		this.branch_back_center_6.setRotationPoint(-0.5F, 0.1F, -4.5F);
		this.branch_back_center_6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(branch_back_center_6, -0.4553564018453205F, 3.141592653589793F, 1.1383037381507017F);
		this.right_leg_bottom = new ModelRenderer(this, 80, 0);
		this.right_leg_bottom.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.right_leg_bottom.addBox(-2.5F, 0.0F, -2.5F, 5, 4, 5, 0.0F);
		this.setRotateAngle(right_leg_bottom, 0.0F, -0.08726646259971647F, -0.08726646259971647F);
		this.branch_back_center_3 = new ModelRenderer(this, 15, 24);
		this.branch_back_center_3.setRotationPoint(-0.1F, 1.1F, 4.5F);
		this.branch_back_center_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.setRotateAngle(branch_back_center_3, -0.9560913642424937F, 0.045553093477052F, -0.5009094953223726F);
		this.arm_right_tip = new ModelRenderer(this, 114, 29);
		this.arm_right_tip.setRotationPoint(0.0F, 7.0F, 0.1F);
		this.arm_right_tip.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
		this.setRotateAngle(arm_right_tip, -0.08726646259971647F, -0.39269908169872414F, -0.17453292519943295F);
		this.leaves_back_sidebranch_2 = new ModelRenderer(this, 12, 45);
		this.leaves_back_sidebranch_2.setRotationPoint(-2.0F, 0.0F, -4.0F);
		this.leaves_back_sidebranch_2.addBox(-3.5F, -3.5F, -3.0F, 7, 7, 3, 0.0F);
		this.branch_back_center_1 = new ModelRenderer(this, 11, 38);
		this.branch_back_center_1.setRotationPoint(-1.0F, 2.0F, 2.0F);
		this.branch_back_center_1.addBox(-2.0F, -1.0F, -5.0F, 2, 2, 5, 0.0F);
		this.setRotateAngle(branch_back_center_1, -0.40980330836826856F, 1.730144887501979F, -0.045553093477052F);
		this.branch_back_center_5 = new ModelRenderer(this, 39, 38);
		this.branch_back_center_5.setRotationPoint(0.9F, 0.1F, 2.5F);
		this.branch_back_center_5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(branch_back_center_5, 0.36425021489121656F, -0.9105382707654417F, 1.4570008595648662F);
		this.head_branch_front_bottom_2 = new ModelRenderer(this, 47, 0);
		this.head_branch_front_bottom_2.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.head_branch_front_bottom_2.addBox(-0.5F, -3.5F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(head_branch_front_bottom_2, 0.27314402793711257F, 0.22759093446006054F, -0.27314402793711257F);
		this.head_branch_back_bottom = new ModelRenderer(this, 94, 9);
		this.head_branch_back_bottom.setRotationPoint(0.5F, -6.4F, 0.5F);
		this.head_branch_back_bottom.addBox(-1.0F, -3.5F, -1.0F, 2, 3, 2, 0.0F);
		this.setRotateAngle(head_branch_back_bottom, 0.0F, 0.39269908169872414F, 0.5235987755982988F);
		this.branch_back_center = new ModelRenderer(this, 0, 35);
		this.branch_back_center.setRotationPoint(0.0F, 1.0F, 5.5F);
		this.branch_back_center.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
		this.setRotateAngle(branch_back_center, 0.39269908169872414F, -0.17453292519943295F, 0.0F);
		this.body_bottom_main.addChild(this.body_center_bottom);
		this.branch_back_center.addChild(this.branch_back_center_2);
		this.body_center_bottom.addChild(this.body_center);
		this.right_leg_top_middle.addChild(this.right_leg_bottom_middle);
		this.head.addChild(this.head_branch_front_bottom);
		this.left_leg_top_extension.addChild(this.left_leg_top);
		this.body_center_bottom.addChild(this.shroom_body_center_bottom);
		this.body_center_top.addChild(this.body_top);
		this.body_top.addChild(this.neck);
		this.arm_left.addChild(this.arm_left_bottom);
		this.body_center.addChild(this.body_center_top);
		this.body_top.addChild(this.arm_left);
		this.leaves_backbranch.addChild(this.leaves_backbranch_tip);
		this.body_top_extension.addChild(this.vines_back);
		this.left_leg_top.addChild(this.left_leg_bottom);
		this.branch_back_center_2.addChild(this.branch_back_center_4);
		this.leaves_back_sidebranch.addChild(this.leaves_back_sidebranch_1);
		this.body_center.addChild(this.shroom_body_center);
		this.body_top.addChild(this.body_top_extension);
		this.body_top.addChild(this.branch_back_bottom);
		this.right_leg_top.addChild(this.right_leg_top_middle);
		this.leaves_back_sidebranch_2.addChild(this.leaves_back_sidebranch_tip);
		this.neck.addChild(this.head);
		this.head.addChild(this.leaves_back_sidebranch);
		this.branch_back_center_2.addChild(this.leaves_backbranch);
		this.body_center_top.addChild(this.shroom_body_center_top);
		this.head_branch_front_bottom.addChild(this.head_branch_front_bottom_1);
		this.body_top.addChild(this.arm_right);
		this.body_bottom_main.addChild(this.body_bottom_right);
		this.branch_back_center_1.addChild(this.branch_back_center_6);
		this.right_leg_bottom_middle.addChild(this.right_leg_bottom);
		this.branch_back_center_2.addChild(this.branch_back_center_3);
		this.arm_right.addChild(this.arm_right_tip);
		this.branch_back_center_1.addChild(this.leaves_back_sidebranch_2);
		this.branch_back_bottom.addChild(this.branch_back_center_1);
		this.branch_back_center_2.addChild(this.branch_back_center_5);
		this.head_branch_back_bottom.addChild(this.head_branch_front_bottom_2);
		this.head.addChild(this.head_branch_back_bottom);
		this.branch_back_bottom.addChild(this.branch_back_center);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -MathHelper.cos(limbSwing * 0.6662F * 2.0f + 2.7f) * limbSwingAmount / 8.0f + limbSwingAmount / 15.05f, 0.0F);
		this.right_leg_top.render(scale);
		this.body_bottom_main.render(scale);
		this.left_leg_top_extension.render(scale);
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

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		Random random = new Random(entityIn.getEntityId());
		this.head.rotateAngleX = headPitch * 0.017453292F - 0.6108652381980153F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F + 0.17453292519943295F;

		//limbSwing = ageInTicks / 10.0f;
		//limbSwingAmount = 0.5f;
		//limbSwing *= 1.1f;

		this.left_leg_top_extension.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * legBend * limbSwingAmount - 0.08726646259971647F;
		this.right_leg_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * legBend * limbSwingAmount - 0.08726646259971647F;

		this.arm_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * armBend * limbSwingAmount - 0.17453292519943295F;
		this.arm_left.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * armBend * limbSwingAmount - 0.7853981633974483F;

		this.arm_right_tip.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * elbowBend * limbSwingAmount - elbowBend * limbSwingAmount - 0.08726646259971647F;
		this.arm_left_bottom.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * elbowBend * limbSwingAmount + elbowBend * limbSwingAmount + 0.08726646259971647F;

		this.right_leg_top_middle.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;
		this.left_leg_bottom.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;

		this.arm_right.rotateAngleZ = 0.39269908169872414F;
		this.arm_left.rotateAngleZ = -0.08726646259971647F;
		this.arm_left.rotateAngleX = -0.39269908169872414F;

		if (this.swingProgress > 0.0F)  {
			float f2 = MathHelper.sin(this.swingProgress * (float)Math.PI) * 2.0F;
			this.arm_left.rotateAngleZ += f2;
			this.arm_right.rotateAngleX -= f2;
		}

		this.arm_right.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.arm_left.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.arm_right.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.arm_left.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		this.wiggleRotateAngle(body_center_bottom, 0.0F, -0.08726646259971647F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(branch_back_center_2, 0.39269908169872414F, 0.2617993877991494F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(body_center, 0.08726646259971647F, -0.08726646259971647F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(head_branch_front_bottom, 0.0F, -0.40980330836826856F, -0.5462880558742251F, ageInTicks);
		this.wiggleRotateAngle(body_top, 0.08726646259971647F, -0.08726646259971647F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(neck, 0.6108652381980153F, 0.17453292519943295F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(body_center_top, 0.08726646259971647F, -0.08726646259971647F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(branch_back_center_4, 0.091106186954104F, 0.8651597102135892F, 3.096039560112741F, ageInTicks);
		this.wiggleRotateAngle(body_top_extension, 0.08726646259971647F, -0.08726646259971647F, 0.17453292519943295F, ageInTicks);
		this.wiggleRotateAngle(branch_back_bottom, 0.40980330836826856F, 0.7853981633974483F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(head_branch_front_bottom_1, 0.27314402793711257F, 0.22759093446006054F, 0.31869712141416456F, ageInTicks);
		this.wiggleRotateAngle(body_bottom_right, 0.0F, -0.08726646259971647F, -0.39269908169872414F, ageInTicks);
		this.wiggleRotateAngle(branch_back_center_6, -0.4553564018453205F, 3.141592653589793F, 1.1383037381507017F, ageInTicks);
		this.wiggleRotateAngle(branch_back_center_3, -0.9560913642424937F, 0.045553093477052F, -0.5009094953223726F, ageInTicks);
		this.wiggleRotateAngle(branch_back_center_1, -0.40980330836826856F, 1.730144887501979F, -0.045553093477052F, ageInTicks);
		this.wiggleRotateAngle(branch_back_center_5, 0.36425021489121656F, -0.9105382707654417F, 1.4570008595648662F, ageInTicks);
		this.wiggleRotateAngle(head_branch_front_bottom_2, 0.27314402793711257F, 0.22759093446006054F, -0.27314402793711257F, ageInTicks);
		this.wiggleRotateAngle(head_branch_back_bottom, 0.0F, 0.39269908169872414F, 0.5235987755982988F, ageInTicks);
		this.wiggleRotateAngle(branch_back_center, 0.39269908169872414F, -0.17453292519943295F, 0.0F, ageInTicks);
	}
}