package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;

public class ModelArmorBase extends ModelBiped {

	public ModelArmorBase() {
		super();
	}

	public ModelArmorBase(float modelSize) {
		super(modelSize);
	}

	public ModelArmorBase(float modelSize, float p_i1149_2_, int textureWidthIn, int textureHeightIn) {
		super(modelSize, p_i1149_2_, textureWidthIn, textureHeightIn);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		if (entityIn instanceof EntityArmorStand) {
			EntityArmorStand entityarmorstand = (EntityArmorStand)entityIn;
			float x = 0.017453292F;
			this.setRotateAngle(this.bipedHead, x * entityarmorstand.getHeadRotation().getX(), x * entityarmorstand.getHeadRotation().getY(), x * entityarmorstand.getHeadRotation().getZ());
			this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
			this.setRotateAngle(this.bipedBody, x * entityarmorstand.getBodyRotation().getX(), x * entityarmorstand.getBodyRotation().getY(), x * entityarmorstand.getBodyRotation().getZ());
			this.setRotateAngle(this.bipedLeftArm, x * entityarmorstand.getLeftArmRotation().getX(), x * entityarmorstand.getLeftArmRotation().getY(), x * entityarmorstand.getLeftArmRotation().getZ());
			this.setRotateAngle(this.bipedRightArm, x * entityarmorstand.getRightArmRotation().getX(), x * entityarmorstand.getRightArmRotation().getY(), x * entityarmorstand.getRightArmRotation().getZ());
			this.setRotateAngle(this.bipedLeftLeg, x * entityarmorstand.getLeftLegRotation().getX(), x * entityarmorstand.getLeftLegRotation().getY(), x * entityarmorstand.getLeftLegRotation().getZ());
			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
			this.setRotateAngle(this.bipedRightLeg, x * entityarmorstand.getRightLegRotation().getX(), x * entityarmorstand.getRightLegRotation().getY(), x * entityarmorstand.getRightLegRotation().getZ());
			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
			copyModelAngles(this.bipedHead, this.bipedHeadwear);
		} else
			super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
