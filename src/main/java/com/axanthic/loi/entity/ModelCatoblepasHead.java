package com.axanthic.loi.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCatoblepasHead extends ModelBase {
	public ModelRenderer head;
	public ModelRenderer horn_right;
	public ModelRenderer horn_left;

	public ModelCatoblepasHead() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.horn_right = new ModelRenderer(this, 0, 0);
		this.horn_right.setRotationPoint(0.0F, 3.5F, -7.0F);
		this.horn_right.addBox(-6.0F, -14.0F, 6.0F, 1, 5, 1, 0.0F);
		this.setRotateAngle(horn_right, 0.4363323129985824F, 0.4363323129985824F, 0.0F);
		this.horn_left = new ModelRenderer(this, 0, 0);
		this.horn_left.setRotationPoint(-1.0F, -1.0F, -7.0F);
		this.horn_left.addBox(6.0F, -10.0F, 4.0F, 1, 5, 1, 0.0F);
		this.setRotateAngle(horn_left, 0.4363323129985824F, -0.4363323129985824F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.setRotateAngle(head, 0.136659280431156F, 0.0F, 0.0F);
		this.head.addChild(this.horn_right);
		this.head.addChild(this.horn_left);
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
