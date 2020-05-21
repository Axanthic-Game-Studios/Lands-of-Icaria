package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMyrmekeHead extends ModelBase {
	public ModelRenderer head;
	public ModelRenderer antler_left;
	public ModelRenderer antler_right;

	public ModelMyrmekeHead() {
		this.textureWidth = 32;
		this.textureHeight = 16;
		this.head = new ModelRenderer(this, 0, 8);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -3.0F, -2.0F, 4, 3, 4, 0.0F);
		this.setRotateAngle(head, 0.39269908169872414F, 0.0F, 0.0F);
		this.antler_right = new ModelRenderer(this, 13, 0);
		this.antler_right.setRotationPoint(-1.4F, -1.7F, -1.9F);
		this.antler_right.addBox(-0.5F, 0.2F, 0.5F, 6, 1, 1, -0.1F);
		this.setRotateAngle(antler_right, 0.0F, 0.75F, -2.1F);
		this.antler_left = new ModelRenderer(this, 13, 0);
		this.antler_left.setRotationPoint(1.4F, -1.7F, -1.9F);
		this.antler_left.addBox(-0.5F, -1.2F, 0.5F, 6, 1, 1, -0.1F);
		this.setRotateAngle(antler_left, -0.2F, 0.75F, -1.0F);
		this.head.addChild(this.antler_left);
		this.head.addChild(this.antler_right);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.head.render(scale * 2);
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