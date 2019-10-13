package com.axanthic.loi.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSowHead extends ModelBase {
	public ModelRenderer head;
	public ModelRenderer snout;
	public ModelRenderer horn;
	public ModelRenderer horn_1;

	public ModelSowHead() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.snout = new ModelRenderer(this, 16, 16);
		this.snout.setRotationPoint(0.0F, -4.0F, 3.0F);
		this.snout.addBox(-2.0F, 0.0F, -9.0F, 4, 3, 2, 0.0F);
		this.horn = new ModelRenderer(this, 24, 0);
		this.horn.setRotationPoint(-1.0F, -4.5F, -8.0F);
		this.horn.addBox(-2.0F, 0.0F, -3.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(horn, 1.5707963267948966F, 0.0F, 0.0F);
		this.horn_1 = new ModelRenderer(this, 24, 0);
		this.horn_1.setRotationPoint(4.0F, -4.0F, -8.0F);
		this.horn_1.addBox(-2.0F, 0.0F, -3.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(horn_1, 1.5707963267948966F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.head.addChild(this.snout);
		this.head.addChild(this.horn);
		this.head.addChild(this.horn_1);
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