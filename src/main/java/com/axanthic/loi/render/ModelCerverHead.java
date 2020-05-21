package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCerverHead extends ModelBase {
	public ModelRenderer head;
	public ModelRenderer mouth;
	public ModelRenderer ear_right;
	public ModelRenderer ear_left;

	public ModelCerverHead() {
		this.textureWidth = 96;
		this.textureHeight = 64;
		this.ear_left = new ModelRenderer(this, 0, 60);
		this.ear_left.setRotationPoint(3.5F, -6.5F, 12.0F);
		this.ear_left.addBox(-2.0F, 0.0F, -10.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(ear_left, 0.0F, 0.0F, 0.7853981633974483F);
		this.ear_right = new ModelRenderer(this, 0, 60);
		this.ear_right.setRotationPoint(-0.5F, -6.5F, 12.0F);
		this.ear_right.addBox(-2.0F, 0.0F, -10.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(ear_right, 0.0F, 0.0F, 0.7853981633974483F);
		this.head = new ModelRenderer(this, 44, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-3.0F, -6.0F, -2.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(head, 0.21380283336930533F, 0.0F, 0.0F);
		this.mouth = new ModelRenderer(this, 80, 0);
		this.mouth.setRotationPoint(0.5F, -3.5F, 4.0F);
		this.mouth.addBox(-2.0F, 0.0F, -10.0F, 3, 3, 4, 0.0F);
		this.head.addChild(this.ear_left);
		this.head.addChild(this.ear_right);
		this.head.addChild(this.mouth);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.head.render(scale);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.head.rotateAngleX = headPitch * 0.017453292F;
	}
}