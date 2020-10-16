package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHagHeadLaurel extends ModelBase {

	public ModelRenderer head;
	public ModelRenderer leaves_hat;
	public ModelRenderer leaves_hat_1;

	public ModelHagHeadLaurel() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.leaves_hat = new ModelRenderer(this, 8, 37);
		this.leaves_hat.setRotationPoint(0.0F, -3.2F, -3.0F);
		this.leaves_hat.addBox(-4.0F, -2.0F, -1.0F, 8, 2, 8, 0.0F);
		this.setRotateAngle(leaves_hat, 0.0F, 0.0F, 0.06981317007977318F);
		this.leaves_hat_1 = new ModelRenderer(this, 32, 37);
		this.leaves_hat_1.setRotationPoint(0.0F, -0.6F, 0.0F);
		this.leaves_hat_1.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 6, 0.0F);
		this.setRotateAngle(leaves_hat_1, 0.136659280431156F, 0.0F, -0.136659280431156F);
		this.head = new ModelRenderer(this, 62, 36);
		this.head.setRotationPoint(0.0F, -4.5F, 0.0F);
		this.head.addBox(-3.0F, -3.5F, -3.0F, 6, 8, 6, 0.0F);
		this.head.addChild(this.leaves_hat);
		this.leaves_hat.addChild(this.leaves_hat_1);
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