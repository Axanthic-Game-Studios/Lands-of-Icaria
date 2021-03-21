package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRevenantSkull extends ModelBase {
	public ModelRenderer skull;
	public ModelRenderer skullChild;
	public ModelRenderer skullChildChild;

	public ModelRevenantSkull() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.skullChild = new ModelRenderer(this, 70, 0);
		this.skullChild.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skullChild.addBox(-2.5F, -2.0F, -3.5F, 5, 1, 6, 0.0F);
		this.skullChildChild = new ModelRenderer(this, 92, 0);
		this.skullChildChild.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skullChildChild.addBox(-2.5F, -0.800000011920929F, -3.299999952316284F, 5, 1, 6, 0.0F);
		this.setRotateAngle(skullChildChild, 0.10471975803375246F, 0.0F, 0.0F);
		this.skull = new ModelRenderer(this, 0, 0);
		this.skull.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skull.addBox(-3.5F, -8.0F, -4.0F, 7, 6, 8, 0.0F);
		this.setRotateAngle(skull, -0.10471975511965977F, 0.0F, 0.0F);
		this.skull.addChild(this.skullChild);
		this.skullChild.addChild(this.skullChildChild);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.skull.render(scale);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		this.skull.rotateAngleY = netHeadYaw * 0.017453292F;
		this.skull.rotateAngleX = headPitch * 0.017453292F;
	}
}