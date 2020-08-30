package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArganHoundHead extends ModelBase {
	public ModelRenderer head;
    public ModelRenderer nose;
    public ModelRenderer mouth;
    public ModelRenderer ear_right;
    public ModelRenderer ear_left;
    public ModelRenderer fang_right;
    public ModelRenderer fang_left;

    public ModelArganHoundHead() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ear_right = new ModelRenderer(this, 0, 20);
        this.ear_right.setRotationPoint(0.0F, -0.5F, 1.0F);
        this.ear_right.addBox(-1.5F, -6.0F, 1.0F, 3, 5, 1, 0.0F);
        this.setRotateAngle(ear_right, 0.39269908169872414F, 0.0F, -0.7853981633974483F);
        this.mouth = new ModelRenderer(this, 24, 50);
        this.mouth.setRotationPoint(0.0F, 0.5F, -3.5F);
        this.mouth.addBox(-1.5F, -1.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(mouth, 0.136659280431156F, 0.0F, 0.0F);
        this.ear_left = new ModelRenderer(this, 0, 40);
        this.ear_left.setRotationPoint(0.0F, -0.5F, 1.0F);
        this.ear_left.addBox(-1.5F, -6.0F, 1.0F, 3, 5, 1, 0.0F);
        this.setRotateAngle(ear_left, 0.39269908169872414F, 0.0F, 0.7853981633974483F);
        this.head = new ModelRenderer(this, 0, 48);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
        this.nose = new ModelRenderer(this, 43, 46);
        this.nose.setRotationPoint(0.0F, -3.0F, -2.0F);
        this.nose.addBox(-2.0F, 0.0F, -5.0F, 4, 2, 5, 0.0F);
        this.fang_right = new ModelRenderer(this, 37, 0);
        this.fang_right.setRotationPoint(-1.1F, 0.5F, -3.0F);
        this.fang_right.addBox(-0.5F, 0.0F, -2.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(fang_right, 0.7853981633974483F, 0.0F, 0.0F);
        this.fang_left = new ModelRenderer(this, 38, 9);
        this.fang_left.setRotationPoint(1.1F, 0.5F, -3.0F);
        this.fang_left.addBox(-0.5F, 0.0F, -2.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(fang_left, 0.7853981633974483F, 0.0F, 0.0F);
        this.head.addChild(this.ear_right);
        this.head.addChild(this.mouth);
        this.head.addChild(this.ear_left);
        this.head.addChild(this.nose);
        this.nose.addChild(this.fang_right);
        this.nose.addChild(this.fang_left);
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