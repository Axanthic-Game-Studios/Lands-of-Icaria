package com.axanthic.blab.entity;

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
	public ModelRenderer tail;
	public ModelRenderer leg_front_left;
	public ModelRenderer leg_front_right;
	public ModelRenderer muscle_right;
	public ModelRenderer leg_rear_right;
	public ModelRenderer body;
	public ModelRenderer head;
	public ModelRenderer leg_rear_left;
	public ModelRenderer muscle_left;
	public ModelRenderer headChild;
	public ModelRenderer headChild_1;
	public ModelRenderer headChild_2;
	public ModelRenderer headChild_3;
	public ModelRenderer headChild_4;
	public ModelRenderer headChild_5;
	public ModelRenderer headChild_6;
	public ModelRenderer headChild_7;
	public ModelRenderer headChild_8;
	public ModelRenderer headChild_9;
	public ModelRenderer headChild_10;

	public ModelAeternae() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.headChild_9 = new ModelRenderer(this, 65, 8);
		this.headChild_9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_9.addBox(-3.009999990463257F, -13.5F, -20.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_9, -1.1780972480773926F, 0.0F, 0.0F);
		this.headChild_3 = new ModelRenderer(this, 65, 16);
		this.headChild_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_3.addBox(1.0099999904632568F, -13.5F, -20.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_3, -1.1780972480773926F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 32);
		this.head.setRotationPoint(0.0F, 10.0F, -4.8F);
		this.head.addBox(-3.5F, -17.0F, -7.0F, 7, 7, 7, 0.0F);
		this.leg_front_right = new ModelRenderer(this, 29, 46);
		this.leg_front_right.setRotationPoint(-3.0F, 10.0F, -5.0F);
		this.leg_front_right.addBox(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
		this.setRotateAngle(leg_front_right, -1.401298464324817E-45F, 0.0F, 0.0F);
		this.leg_front_left = new ModelRenderer(this, 29, 46);
		this.leg_front_left.setRotationPoint(3.0F, 10.0F, -5.0F);
		this.leg_front_left.addBox(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
		this.setRotateAngle(leg_front_left, 1.401298464324817E-45F, 0.0F, 0.0F);
		this.muscle_right = new ModelRenderer(this, 45, 49);
		this.muscle_right.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muscle_right.addBox(-6.0F, 5.0F, -8.0F, 2, 7, 8, 0.0F);
		this.headChild_1 = new ModelRenderer(this, 65, 0);
		this.headChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_1.addBox(-3.0F, -20.200000762939453F, -9.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_1, -0.39269909262657166F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 29, 0);
		this.body.setRotationPoint(2.0F, 5.0F, 1.0F);
		this.body.addBox(-6.0F, -10.0F, -7.0F, 8, 22, 8, 0.10000038146972656F);
		this.setRotateAngle(body, 1.5707963705062866F, 0.0F, 0.0F);
		this.headChild_7 = new ModelRenderer(this, 73, 0);
		this.headChild_7.setRotationPoint(1.0F, 0.0F, 0.0F);
		this.headChild_7.addBox(-2.0F, -14.5F, 3.0F, 2, 11, 3, 0.0F);
		this.setRotateAngle(headChild_7, 0.39269909262657166F, 0.0F, 0.0F);
		this.headChild_8 = new ModelRenderer(this, 65, 24);
		this.headChild_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_8.addBox(-3.0299999713897705F, -16.0F, 14.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_8, 0.39269909262657166F, 0.0F, 0.0F);
		this.headChild_2 = new ModelRenderer(this, 65, 24);
		this.headChild_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_2.addBox(1.0F, -20.200000762939453F, -9.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_2, -0.39269909262657166F, 0.0F, 0.0F);
		this.headChild = new ModelRenderer(this, 0, 0);
		this.headChild.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild.addBox(-1.5F, -14.0F, -12.0F, 3, 3, 8, 0.0F);
		this.headChild_4 = new ModelRenderer(this, 0, 46);
		this.headChild_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_4.addBox(-2.0F, -11.0F, 0.0F, 4, 9, 3, 0.0F);
		this.setRotateAngle(headChild_4, 0.39269909262657166F, 0.0F, 0.0F);
		this.headChild_6 = new ModelRenderer(this, 65, 8);
		this.headChild_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_6.addBox(1.0199999809265137F, -5.0F, 21.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_6, 1.1780972480773926F, 0.0F, 0.0F);
		this.tail = new ModelRenderer(this, 73, 0);
		this.tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail.addBox(-1.0F, 12.0F, 3.299999952316284F, 2, 11, 3, 0.0F);
		this.setRotateAngle(tail, 0.7853981852531433F, 0.0F, 0.0F);
		this.leg_rear_right = new ModelRenderer(this, 29, 46);
		this.leg_rear_right.setRotationPoint(-3.0F, 10.0F, 9.0F);
		this.leg_rear_right.addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		this.setRotateAngle(leg_rear_right, 1.401298464324817E-45F, 0.0F, 0.0F);
		this.headChild_5 = new ModelRenderer(this, 65, 16);
		this.headChild_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_5.addBox(-3.0199999809265137F, -5.0F, 21.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_5, 1.1780972480773926F, 0.0F, 0.0F);
		this.headChild_10 = new ModelRenderer(this, 65, 0);
		this.headChild_10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_10.addBox(1.0299999713897705F, -16.0F, 14.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_10, 0.39269909262657166F, 0.0F, 0.0F);
		this.leg_rear_left = new ModelRenderer(this, 29, 46);
		this.leg_rear_left.setRotationPoint(3.0F, 10.0F, 9.0F);
		this.leg_rear_left.addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		this.setRotateAngle(leg_rear_left, -1.401298464324817E-45F, 0.0F, 0.0F);
		this.muscle_left = new ModelRenderer(this, 45, 49);
		this.muscle_left.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muscle_left.addBox(4.0F, 5.0F, -8.0F, 2, 7, 8, 0.0F);
		this.head.addChild(this.headChild_9);
		this.head.addChild(this.headChild_3);
		this.head.addChild(this.headChild_1);
		this.head.addChild(this.headChild_7);
		this.head.addChild(this.headChild_8);
		this.head.addChild(this.headChild_2);
		this.head.addChild(this.headChild);
		this.head.addChild(this.headChild_4);
		this.head.addChild(this.headChild_6);
		this.head.addChild(this.headChild_5);
		this.head.addChild(this.headChild_10);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) { 
		if (((EntityAeternae) entity).isChild()) {
			GlStateManager.pushMatrix();
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
			this.head.render(scale);
			this.leg_front_right.render(scale);
			this.leg_front_left.render(scale);
			this.muscle_right.render(scale);
			this.body.render(scale);
			this.tail.render(scale);
			this.leg_rear_right.render(scale);
			this.leg_rear_left.render(scale);
			this.muscle_left.render(scale);
			GlStateManager.popMatrix();
		} else {
			this.head.render(scale);
			this.leg_front_right.render(scale);
			this.leg_front_left.render(scale);
			this.muscle_right.render(scale);
			this.body.render(scale);
			this.tail.render(scale);
			this.leg_rear_right.render(scale);
			this.leg_rear_left.render(scale);
			this.muscle_left.render(scale);
		}
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	private float headRotationAngleX;

	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
		this.headRotationAngleX = ((EntityAeternae) entitylivingbaseIn).getHeadRotationAngleX(partialTickTime);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.leg_rear_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg_front_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg_rear_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg_front_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.head.rotateAngleX = this.headRotationAngleX;
	}
}