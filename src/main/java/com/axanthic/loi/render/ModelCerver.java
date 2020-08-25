package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCerver extends ModelBase {
	public ModelRenderer body_main;
	public ModelRenderer leg_right_front;
	public ModelRenderer leg_left_front;
	public ModelRenderer neck;
	public ModelRenderer body_back;
	public ModelRenderer frontleg_right;
	public ModelRenderer paw_right_back;
	public ModelRenderer frontleg_left;
	public ModelRenderer paw_left_back;
	public ModelRenderer head;
	public ModelRenderer mouth;
	public ModelRenderer ear_right;
	public ModelRenderer ear_left;
	public ModelRenderer jaw;
	public ModelRenderer mouth_1;
	public ModelRenderer muscle_back;
	public ModelRenderer tail_front;
	public ModelRenderer leg_right_back_top;
	public ModelRenderer leg_left_back_top;
	public ModelRenderer tail_rear;
	public ModelRenderer leg_right_back_bottom;
	public ModelRenderer paw_right_back_1;
	public ModelRenderer leg_left_back_bottom;
	public ModelRenderer paw_left_back_1;

	public ModelCerver() {
		this.textureWidth = 96;
		this.textureHeight = 64;
		this.frontleg_left = new ModelRenderer(this, 81, 10);
		this.frontleg_left.setRotationPoint(0.0F, 5.0F, 0.5F);
		this.frontleg_left.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.setRotateAngle(frontleg_left, -0.31869712141416456F, 0.0F, 0.0F);
		this.paw_left_back_1 = new ModelRenderer(this, 16, 38);
		this.paw_left_back_1.setRotationPoint(0.0F, 5.3F, 0.0F);
		this.paw_left_back_1.addBox(-2.0F, 0.0F, -2.2F, 4, 2, 4, 0.0F);
		this.setRotateAngle(paw_left_back_1, -0.136659280431156F, 0.0F, 0.0F);
		this.neck = new ModelRenderer(this, 72, 0);
		this.neck.setRotationPoint(0.0F, 3.5F, -5.5F);
		this.neck.addBox(-2.0F, -3.0F, -5.0F, 4, 4, 6, 0.0F);
		this.setRotateAngle(neck, 0.136659280431156F, 0.0F, 0.0F);
		this.paw_right_back_1 = new ModelRenderer(this, 0, 38);
		this.paw_right_back_1.setRotationPoint(0.0F, 5.3F, 0.0F);
		this.paw_right_back_1.addBox(-2.0F, 0.0F, -2.2F, 4, 2, 4, 0.0F);
		this.setRotateAngle(paw_right_back_1, -0.136659280431156F, 0.0F, 0.0F);
		this.leg_left_back_bottom = new ModelRenderer(this, 82, 33);
		this.leg_left_back_bottom.setRotationPoint(0.1F, 5.15F, -0.25F);
		this.leg_left_back_bottom.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
		this.setRotateAngle(leg_left_back_bottom, 0.5918411493512771F, 0.0F, 0.0F);
		this.body_main = new ModelRenderer(this, 0, 0);
		this.body_main.setRotationPoint(0.0F, 9.5F, 2.0F);
		this.body_main.addBox(-5.0F, -1.0F, -8.0F, 10, 8, 10, 0.0F);
		this.setRotateAngle(body_main, -0.136659280431156F, 0.0F, 0.0F);
		this.jaw = new ModelRenderer(this, 24, 18);
		this.jaw.setRotationPoint(0.0F, 2.0F, -0.7F);
		this.jaw.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(jaw, 0.19634954084936207F, 0.0F, 0.0F);
		this.leg_right_back_bottom = new ModelRenderer(this, 70, 33);
		this.leg_right_back_bottom.setRotationPoint(-0.1F, 5.15F, -0.25F);
		this.leg_right_back_bottom.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
		this.setRotateAngle(leg_right_back_bottom, 0.5918411493512771F, 0.0F, 0.0F);
		this.tail_front = new ModelRenderer(this, 30, 30);
		this.tail_front.setRotationPoint(0.0F, 1.0F, -0.8F);
		this.tail_front.addBox(-1.0F, 0.0F, -1.5F, 2, 8, 2, 0.0F);
		this.setRotateAngle(tail_front, 2.0032889154390916F, 0.0F, 0.0F);
		this.leg_right_front = new ModelRenderer(this, 40, 0);
		this.leg_right_front.setRotationPoint(-4.0F, 1.8F, -6.7F);
		this.leg_right_front.addBox(-2.0F, -2.5F, -2.0F, 4, 9, 4, 0.0F);
		this.setRotateAngle(leg_right_front, 0.31869712141416456F, 0.0F, 0.0F);
		this.frontleg_right = new ModelRenderer(this, 69, 10);
		this.frontleg_right.setRotationPoint(0.0F, 5.0F, 0.5F);
		this.frontleg_right.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.setRotateAngle(frontleg_right, -0.31869712141416456F, 0.0F, 0.0F);
		this.leg_left_front = new ModelRenderer(this, 56, 0);
		this.leg_left_front.setRotationPoint(4.0F, 1.8F, -6.7F);
		this.leg_left_front.addBox(-2.0F, -2.5F, -2.0F, 4, 9, 4, 0.0F);
		this.setRotateAngle(leg_left_front, 0.31869712141416456F, 0.0F, 0.0F);
		this.body_back = new ModelRenderer(this, 30, 13);
		this.body_back.setRotationPoint(0.0F, -1.2F, 7.6F);
		this.body_back.addBox(-4.0F, 0.0F, -8.0F, 8, 7, 10, 0.0F);
		this.setRotateAngle(body_back, 0.091106186954104F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 66, 21);
		this.head.setRotationPoint(0.0F, -2.0F, -3.5F);
		this.head.addBox(-3.0F, -2.0F, -6.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(head, 0.045553093477052F, 0.0F, 0.0F);
		this.mouth = new ModelRenderer(this, 12, 20);
		this.mouth.setRotationPoint(0.0F, 1.0F, -6.0F);
		this.mouth.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 4, 0.0F);
		this.muscle_back = new ModelRenderer(this, 0, 26);
		this.muscle_back.setRotationPoint(0.0F, 1.3F, 3.6F);
		this.muscle_back.addBox(-4.5F, 0.2F, -2.1F, 9, 6, 6, 0.0F);
		this.setRotateAngle(muscle_back, -0.7853981633974483F, 0.0F, 0.0F);
		this.leg_right_back_top = new ModelRenderer(this, 38, 30);
		this.leg_right_back_top.setRotationPoint(-4.0F, 1.2F, 0.8F);
		this.leg_right_back_top.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.setRotateAngle(leg_right_back_top, 0.39269908169872414F, 0.0F, 0.0F);
		this.paw_right_back = new ModelRenderer(this, 56, 17);
		this.paw_right_back.setRotationPoint(0.0F, 7.0F, -0.3F);
		this.paw_right_back.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(paw_right_back, 0.136659280431156F, 0.0F, 0.0F);
		this.paw_left_back = new ModelRenderer(this, 0, 18);
		this.paw_left_back.setRotationPoint(0.0F, 7.0F, -0.3F);
		this.paw_left_back.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(paw_left_back, 0.136659280431156F, 0.0F, 0.0F);
		this.tail_rear = new ModelRenderer(this, 62, 33);
		this.tail_rear.setRotationPoint(0.0F, 8.0F, -1.5F);
		this.tail_rear.addBox(-1.02F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(tail_rear, 0.5462880558742251F, 0.0F, 0.0F);
		this.mouth_1 = new ModelRenderer(this, 12, 44);
		this.mouth_1.setRotationPoint(0.0F, 2.0F, 0.3F);
		this.mouth_1.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 4, 0.0F);
		this.ear_left = new ModelRenderer(this, 30, 0);
		this.ear_left.setRotationPoint(2.2F, -3.8F, -2.0F);
		this.ear_left.addBox(0.0F, 0.0F, -0.5F, 4, 3, 1, 0.0F);
		this.setRotateAngle(ear_left, 0.5235987755982988F, 0.0F, 0.7853981633974483F);
		this.ear_right = new ModelRenderer(this, 0, 0);
		this.ear_right.setRotationPoint(-2.2F, -3.8F, -2.0F);
		this.ear_right.addBox(0.0F, 0.0F, -0.5F, 3, 4, 1, 0.0F);
		this.setRotateAngle(ear_right, 0.0F, -0.5235987755982988F, 0.7853981633974483F);
		this.leg_left_back_top = new ModelRenderer(this, 50, 30);
		this.leg_left_back_top.setRotationPoint(4.0F, 1.2F, 0.8F);
		this.leg_left_back_top.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.setRotateAngle(leg_left_back_top, 0.39269908169872414F, 0.0F, 0.0F);
		this.leg_left_front.addChild(this.frontleg_left);
		this.leg_left_back_bottom.addChild(this.paw_left_back_1);
		this.body_main.addChild(this.neck);
		this.leg_right_back_bottom.addChild(this.paw_right_back_1);
		this.leg_left_back_top.addChild(this.leg_left_back_bottom);
		this.mouth.addChild(this.jaw);
		this.leg_right_back_top.addChild(this.leg_right_back_bottom);
		this.muscle_back.addChild(this.tail_front);
		this.body_main.addChild(this.leg_right_front);
		this.leg_right_front.addChild(this.frontleg_right);
		this.body_main.addChild(this.leg_left_front);
		this.body_main.addChild(this.body_back);
		this.neck.addChild(this.head);
		this.head.addChild(this.mouth);
		this.body_back.addChild(this.muscle_back);
		this.muscle_back.addChild(this.leg_right_back_top);
		this.frontleg_right.addChild(this.paw_right_back);
		this.frontleg_left.addChild(this.paw_left_back);
		this.tail_front.addChild(this.tail_rear);
		this.mouth.addChild(this.mouth_1);
		this.head.addChild(this.ear_left);
		this.head.addChild(this.ear_right);
		this.muscle_back.addChild(this.leg_left_back_top);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.body_main.render(scale);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	static float kneebend = 0.75F;

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F + 0.21380283336930533F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;

		limbSwing *= 1.2F;

		this.leg_right_front.rotateAngleX = -MathHelper.cos(limbSwing * 0.5F) * 0.6F * limbSwingAmount + 0.31869712141416456F;
		this.leg_left_front.rotateAngleX = -MathHelper.cos(limbSwing * 0.5F + (float) Math.PI) * 0.6F * limbSwingAmount + 0.31869712141416456F;
		this.leg_right_back_top.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI * 1.5F) * 1.2F * limbSwingAmount + 0.39269908169872414F;
		this.leg_left_back_top.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI * 0.5F) * 1.2F * limbSwingAmount + 0.39269908169872414F;

		this.frontleg_right.rotateAngleX = MathHelper.sin((limbSwing + MathHelper.sin(limbSwing)) * 0.5F) * kneebend * limbSwingAmount - kneebend * limbSwingAmount - 0.31869712141416456F;
		this.frontleg_left.rotateAngleX = MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.5F)) * 0.5F + (float) Math.PI) * kneebend * limbSwingAmount - kneebend * limbSwingAmount - 0.31869712141416456F;
		this.leg_right_back_bottom.rotateAngleX = MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.75F)) * 0.5F + (float) Math.PI * 1.5F) * kneebend * limbSwingAmount + kneebend * limbSwingAmount + 0.5918411493512771F;
		this.leg_left_back_bottom.rotateAngleX = MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.25F)) * 0.5F + (float) Math.PI * 0.5F) * kneebend * limbSwingAmount + kneebend * limbSwingAmount + 0.5918411493512771F;

		this.paw_right_back.rotateAngleX = -MathHelper.sin((limbSwing + MathHelper.sin(limbSwing)) * 0.5F) * kneebend * limbSwingAmount + kneebend * limbSwingAmount + 0.136659280431156F;
		this.paw_left_back.rotateAngleX = -MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.5F)) * 0.5F + (float) Math.PI) * kneebend * limbSwingAmount + kneebend * limbSwingAmount + 0.136659280431156F;
		this.paw_right_back_1.rotateAngleX = -MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.75F)) * 0.5F + (float) Math.PI * 1.5F) * kneebend * limbSwingAmount - kneebend * limbSwingAmount - 0.136659280431156F;
		this.paw_left_back_1.rotateAngleX = -MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.25F)) * 0.5F + (float) Math.PI * 0.5F) * kneebend * limbSwingAmount - kneebend * limbSwingAmount - 0.136659280431156F;
	}
}