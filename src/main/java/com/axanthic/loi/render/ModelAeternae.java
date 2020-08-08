package com.axanthic.loi.render;

import com.axanthic.loi.entity.EntityAeternae;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAeternae extends ModelBase {
	public ModelRenderer body_main;
	public ModelRenderer leg_front_muscle_right;
	public ModelRenderer leg_front_muscle_left;
	public ModelRenderer leg_front_muscle_right_1;
	public ModelRenderer leg_front_muscle_left_1;
	public ModelRenderer body_rear;
	public ModelRenderer neck_root;
	public ModelRenderer leg_front_upper_right;
	public ModelRenderer leg_front_lower_right;
	public ModelRenderer leg_front_upper_left;
	public ModelRenderer leg_front_lower_left;
	public ModelRenderer leg_front_upper_right_1;
	public ModelRenderer leg_front_lower_right_1;
	public ModelRenderer leg_front_upper_right_2;
	public ModelRenderer leg_front_lower_right_2;
	public ModelRenderer tail;
	public ModelRenderer neck;
	public ModelRenderer head;
	public ModelRenderer nose;
	public ModelRenderer mouth;
	public ModelRenderer beard;
	public ModelRenderer ear_right;
	public ModelRenderer ear_left;
	public ModelRenderer right_horn;
	public ModelRenderer left_horn;
	public ModelRenderer horn_2;
	public ModelRenderer horn_3;
	public ModelRenderer horn_4;
	public ModelRenderer horn_2_1;
	public ModelRenderer horn_3_1;
	public ModelRenderer horn_4_1;

	public ModelAeternae() {
		this.textureWidth = 128;
		this.textureHeight = 48;
		this.horn_2 = new ModelRenderer(this, 116, 10);
		this.horn_2.setRotationPoint(-0.1F, -3.0F, 0.7F);
		this.horn_2.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 3, 0.0F);
		this.setRotateAngle(horn_2, -0.4553564018453205F, 0.0F, -0.045553093477052F);
		this.leg_front_muscle_right_1 = new ModelRenderer(this, 66, 0);
		this.leg_front_muscle_right_1.setRotationPoint(-3.0F, 1.0F, 11.0F);
		this.leg_front_muscle_right_1.addBox(-2.0F, 0.0F, -2.5F, 4, 8, 5, 0.0F);
		this.setRotateAngle(leg_front_muscle_right_1, -0.39269908169872414F, 0.0F, 0.0F);
		this.leg_front_lower_right_1 = new ModelRenderer(this, 84, 13);
		this.leg_front_lower_right_1.setRotationPoint(0.0F, 4.2F, 0.2F);
		this.leg_front_lower_right_1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(leg_front_lower_right_1, -0.22759093446006054F, 0.0F, 0.0F);
		this.beard = new ModelRenderer(this, 27, 22);
		this.beard.setRotationPoint(0.0F, 1.5F, -5.9F);
		this.beard.addBox(-1.0F, 0.0F, -3.0F, 2, 6, 8, 0.0F);
		this.body_rear = new ModelRenderer(this, 102, 0);
		this.body_rear.setRotationPoint(0.0F, 0.0F, 9.0F);
		this.body_rear.addBox(-3.5F, 0.0F, 0.0F, 7, 6, 4, 0.0F);
		this.setRotateAngle(body_rear, -0.18203784098300857F, 0.0F, 0.0F);
		this.nose = new ModelRenderer(this, 19, 22);
		this.nose.setRotationPoint(0.0F, 0.5F, -7.0F);
		this.nose.addBox(-2.0F, -2.5F, -4.0F, 4, 2, 4, 0.0F);
		this.leg_front_muscle_left_1 = new ModelRenderer(this, 84, 0);
		this.leg_front_muscle_left_1.setRotationPoint(3.0F, 1.0F, 11.0F);
		this.leg_front_muscle_left_1.addBox(-2.0F, 0.0F, -2.5F, 4, 8, 5, 0.0F);
		this.setRotateAngle(leg_front_muscle_left_1, -0.39269908169872414F, 0.0F, 0.0F);
		this.leg_front_muscle_right = new ModelRenderer(this, 30, 0);
		this.leg_front_muscle_right.setRotationPoint(-3.0F, 1.4F, -4.0F);
		this.leg_front_muscle_right.addBox(-2.0F, 0.0F, -2.5F, 4, 8, 5, 0.0F);
		this.setRotateAngle(leg_front_muscle_right, 0.18203784098300857F, 0.0F, 0.0F);
		this.tail = new ModelRenderer(this, 84, 15);
		this.tail.setRotationPoint(0.0F, 1.5F, 3.5F);
		this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8, 0.0F);
		this.setRotateAngle(tail, -0.18203784098300857F, 0.0F, 0.0F);
		this.horn_2_1 = new ModelRenderer(this, 119, 18);
		this.horn_2_1.setRotationPoint(0.1F, -3.0F, 0.7F);
		this.horn_2_1.addBox(0.0F, -3.0F, 0.0F, 1, 3, 3, 0.0F);
		this.setRotateAngle(horn_2_1, -0.4553564018453205F, 0.0F, 0.045553093477052F);
		this.leg_front_upper_right = new ModelRenderer(this, 0, 0);
		this.leg_front_upper_right.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.leg_front_upper_right.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
		this.setRotateAngle(leg_front_upper_right, -0.091106186954104F, 0.0F, 0.0F);
		this.leg_front_lower_right_2 = new ModelRenderer(this, 70, 21);
		this.leg_front_lower_right_2.setRotationPoint(0.0F, 4.2F, 0.2F);
		this.leg_front_lower_right_2.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(leg_front_lower_right_2, -0.22759093446006054F, 0.0F, 0.0F);
		this.horn_4_1 = new ModelRenderer(this, 49, 0);
		this.horn_4_1.setRotationPoint(0.1F, -3.0F, 0.7F);
		this.horn_4_1.addBox(0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(horn_4_1, -0.5462880558742251F, 0.0F, 0.045553093477052F);
		this.neck_root = new ModelRenderer(this, 96, 10);
		this.neck_root.setRotationPoint(0.0F, 5.5F, -3.0F);
		this.neck_root.addBox(-3.5F, -6.0F, -5.5F, 7, 5, 6, 0.0F);
		this.setRotateAngle(neck_root, -0.4553564018453205F, 0.0F, 0.0F);
		this.leg_front_lower_left = new ModelRenderer(this, 64, 13);
		this.leg_front_lower_left.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.leg_front_lower_left.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(leg_front_lower_left, -0.091106186954104F, 0.0F, 0.0F);
		this.body_main = new ModelRenderer(this, 0, 0);
		this.body_main.setRotationPoint(0.0F, 4.1F, 0.0F);
		this.body_main.addBox(-4.0F, 0.0F, -5.0F, 8, 8, 14, 0.0F);
		this.setRotateAngle(body_main, -0.091106186954104F, 0.0F, 0.0F);
		this.leg_front_lower_right = new ModelRenderer(this, 44, 13);
		this.leg_front_lower_right.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.leg_front_lower_right.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(leg_front_lower_right, -0.091106186954104F, 0.0F, 0.0F);
		this.horn_3_1 = new ModelRenderer(this, 61, 0);
		this.horn_3_1.setRotationPoint(0.1F, -3.0F, 0.7F);
		this.horn_3_1.addBox(0.0F, -3.0F, 0.0F, 1, 3, 2, 0.0F);
		this.setRotateAngle(horn_3_1, -0.4553564018453205F, 0.0F, 0.045553093477052F);
		this.leg_front_upper_left = new ModelRenderer(this, 52, 13);
		this.leg_front_upper_left.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.leg_front_upper_left.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
		this.setRotateAngle(leg_front_upper_left, -0.091106186954104F, 0.0F, 0.0F);
		this.horn_3 = new ModelRenderer(this, 43, 0);
		this.horn_3.setRotationPoint(-0.1F, -3.0F, 0.7F);
		this.horn_3.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 2, 0.0F);
		this.setRotateAngle(horn_3, -0.4553564018453205F, 0.0F, -0.045553093477052F);
		this.head = new ModelRenderer(this, 0, 22);
		this.head.setRotationPoint(0.0F, -5.8F, -0.4F);
		this.head.addBox(-3.0F, -2.5F, -7.0F, 6, 4, 7, 0.0F);
		this.setRotateAngle(head, -0.27314402793711257F, 0.0F, 0.0F);
		this.ear_right = new ModelRenderer(this, 56, 24);
		this.ear_right.setRotationPoint(-3.0F, -2.2F, -2.0F);
		this.ear_right.addBox(-1.0F, -0.3F, 0.0F, 1, 3, 5, 0.0F);
		this.setRotateAngle(ear_right, -0.7853981633974483F, 0.0F, 0.0F);
		this.left_horn = new ModelRenderer(this, 90, 25);
		this.left_horn.setRotationPoint(1.5F, -2.0F, -4.5F);
		this.left_horn.addBox(0.0F, -3.0F, 0.0F, 1, 3, 4, 0.0F);
		this.setRotateAngle(left_horn, -0.18203784098300857F, 0.0F, 0.27314402793711257F);
		this.leg_front_upper_right_2 = new ModelRenderer(this, 49, 21);
		this.leg_front_upper_right_2.setRotationPoint(0.0F, 7.0F, -0.5F);
		this.leg_front_upper_right_2.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
		this.setRotateAngle(leg_front_upper_right_2, 0.7285004297824331F, 0.0F, 0.0F);
		this.mouth = new ModelRenderer(this, 0, 8);
		this.mouth.setRotationPoint(0.0F, -0.2F, -7.0F);
		this.mouth.addBox(-1.5F, -0.3F, -3.0F, 3, 2, 3, 0.0F);
		this.setRotateAngle(mouth, 0.045553093477052F, 0.0F, 0.0F);
		this.right_horn = new ModelRenderer(this, 39, 23);
		this.right_horn.setRotationPoint(-1.5F, -2.0F, -4.5F);
		this.right_horn.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 4, 0.0F);
		this.setRotateAngle(right_horn, -0.18203784098300857F, 0.0F, -0.27314402793711257F);
		this.neck = new ModelRenderer(this, 104, 21);
		this.neck.setRotationPoint(0.0F, -4.0F, -3.5F);
		this.neck.addBox(-2.5F, -8.0F, -3.0F, 5, 8, 3, 0.0F);
		this.setRotateAngle(neck, 0.9105382707654417F, 0.0F, 0.0F);
		this.ear_left = new ModelRenderer(this, 78, 25);
		this.ear_left.setRotationPoint(3.0F, -2.2F, -2.0F);
		this.ear_left.addBox(0.0F, -0.3F, 0.0F, 1, 3, 5, 0.0F);
		this.setRotateAngle(ear_left, -0.7853981633974483F, 0.0F, 0.0F);
		this.leg_front_upper_right_1 = new ModelRenderer(this, 72, 13);
		this.leg_front_upper_right_1.setRotationPoint(0.0F, 7.0F, -0.5F);
		this.leg_front_upper_right_1.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
		this.setRotateAngle(leg_front_upper_right_1, 0.7285004297824331F, 0.0F, 0.0F);
		this.leg_front_muscle_left = new ModelRenderer(this, 48, 0);
		this.leg_front_muscle_left.setRotationPoint(3.0F, 1.4F, -4.0F);
		this.leg_front_muscle_left.addBox(-2.0F, 0.0F, -2.5F, 4, 8, 5, 0.0F);
		this.setRotateAngle(leg_front_muscle_left, 0.18203784098300857F, 0.0F, 0.0F);
		this.horn_4 = new ModelRenderer(this, 30, 0);
		this.horn_4.setRotationPoint(-0.1F, -3.0F, 0.7F);
		this.horn_4.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(horn_4, -0.5462880558742251F, 0.0F, -0.045553093477052F);
		this.right_horn.addChild(this.horn_2);
		this.body_main.addChild(this.leg_front_muscle_right_1);
		this.leg_front_upper_right_1.addChild(this.leg_front_lower_right_1);
		this.head.addChild(this.beard);
		this.body_main.addChild(this.body_rear);
		this.head.addChild(this.nose);
		this.body_main.addChild(this.leg_front_muscle_left_1);
		this.body_main.addChild(this.leg_front_muscle_right);
		this.body_rear.addChild(this.tail);
		this.left_horn.addChild(this.horn_2_1);
		this.leg_front_muscle_right.addChild(this.leg_front_upper_right);
		this.leg_front_upper_right_2.addChild(this.leg_front_lower_right_2);
		this.horn_3_1.addChild(this.horn_4_1);
		this.body_main.addChild(this.neck_root);
		this.leg_front_upper_left.addChild(this.leg_front_lower_left);
		this.leg_front_upper_right.addChild(this.leg_front_lower_right);
		this.horn_2_1.addChild(this.horn_3_1);
		this.leg_front_muscle_left.addChild(this.leg_front_upper_left);
		this.horn_2.addChild(this.horn_3);
		this.neck.addChild(this.head);
		this.head.addChild(this.ear_right);
		this.head.addChild(this.left_horn);
		this.leg_front_muscle_left_1.addChild(this.leg_front_upper_right_2);
		this.head.addChild(this.mouth);
		this.head.addChild(this.right_horn);
		this.neck_root.addChild(this.neck);
		this.head.addChild(this.ear_left);
		this.leg_front_muscle_right_1.addChild(this.leg_front_upper_right_1);
		this.body_main.addChild(this.leg_front_muscle_left);
		this.horn_3.addChild(this.horn_4);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) { 
		if (((EntityAeternae) entity).isChild()) {
			GlStateManager.pushMatrix();
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
			this.body_main.render(scale);
			GlStateManager.popMatrix();
		} else {
			this.body_main.render(scale);
		}
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	private float neckRotationAngleX;
	private float mouthRotationAngleX;

	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
		this.neckRotationAngleX = -((EntityAeternae) entitylivingbaseIn).getNeckRotationAngleX(partialTickTime);
		this.mouthRotationAngleX = -((EntityAeternae) entitylivingbaseIn).getMouthRotationAngleX(partialTickTime);
	}

	static float kneebend = 1.0F;

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F;
		this.head.rotateAngleY = netHeadYaw * 0.005F;
		this.neck.rotateAngleY = netHeadYaw * 0.005F;
		this.neck_root.rotateAngleY = netHeadYaw * 0.003F;

		limbSwing *= 1.8;

		this.leg_front_muscle_right.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 0.7F * limbSwingAmount + 0.18203784098300857F;
		this.leg_front_muscle_left.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI) * 0.7F * limbSwingAmount + 0.18203784098300857F;
		this.leg_front_muscle_right_1.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI * 1.5F) * 0.7F * limbSwingAmount - 0.39269908169872414F;
		this.leg_front_muscle_left_1.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float) Math.PI * 0.5F) * 0.7F * limbSwingAmount - 0.39269908169872414F;

		float frontRight = MathHelper.sin((limbSwing + MathHelper.sin(limbSwing)) * 0.5F) * kneebend * limbSwingAmount + kneebend * limbSwingAmount;
		float frontLeft = MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.5F)) * 0.5F + (float) Math.PI) * kneebend * limbSwingAmount + kneebend * limbSwingAmount;
		float backRight = MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.75F)) * 0.5F + (float) Math.PI * 1.5F) * kneebend * limbSwingAmount + kneebend * limbSwingAmount;
		float backLeft = MathHelper.sin((limbSwing + MathHelper.sin(limbSwing + (float) Math.PI * 0.25F)) * 0.5F + (float) Math.PI * 0.5F) * kneebend * limbSwingAmount + kneebend * limbSwingAmount;

		this.leg_front_upper_right.rotateAngleX = -frontRight - 0.091106186954104F;
		this.leg_front_upper_left.rotateAngleX = -frontLeft - 0.091106186954104F;
		this.leg_front_upper_right_1.rotateAngleX = backRight + 0.7285004297824331F;
		this.leg_front_upper_right_2.rotateAngleX = backLeft + 0.7285004297824331F;

		this.leg_front_lower_right.rotateAngleX = frontRight * 1.5F - 0.091106186954104F;
		this.leg_front_lower_left.rotateAngleX = frontLeft * 1.5F - 0.091106186954104F;
		this.leg_front_lower_right_1.rotateAngleX = -backRight - 0.22759093446006054F;
		this.leg_front_lower_right_2.rotateAngleX = -backLeft - 0.22759093446006054F;

		this.head.rotateAngleX -= this.neckRotationAngleX * 0.3F;
		this.neck.rotateAngleX = this.neckRotationAngleX * 0.3F + 0.9105382707654417F;
		this.neck_root.rotateAngleX = this.neckRotationAngleX * 0.45F - 0.4553564018453205F;
		this.mouth.rotateAngleX = this.mouthRotationAngleX * 0.25F + 0.045553093477052F;
	}
}