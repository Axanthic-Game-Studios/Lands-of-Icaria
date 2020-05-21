package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArganHoundHead extends ModelBase {
	public ModelRenderer head;
	public ModelRenderer ear_right;
	public ModelRenderer ear_left;
	public ModelRenderer mouth;

	public ModelArganHoundHead() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.mouth = new ModelRenderer(this, 0, 10);
		this.mouth.setRotationPoint(-1.0F, -3.0F, 1.0F);
		this.mouth.addBox(-0.5F, 0.0F, -5.0F, 3, 3, 4, 0.0F);
		this.ear_left = new ModelRenderer(this, 16, 14);
		this.ear_left.setRotationPoint(-1.0F, -3.0F, 1.5F);
		this.ear_left.addBox(2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
		this.ear_right = new ModelRenderer(this, 16, 14);
		this.ear_right.setRotationPoint(-1.0F, -3.0F, 1.5F);
		this.ear_right.addBox(-2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-3.0F, -6.0F, 0.0F, 6, 6, 4, 0.0F);
		this.head.addChild(ear_right);
		this.head.addChild(ear_left);
		this.head.addChild(mouth);
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