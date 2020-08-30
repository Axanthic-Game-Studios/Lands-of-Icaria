package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAeternaeHead extends ModelBase {
	public ModelRenderer head;
	public ModelRenderer nose;
	public ModelRenderer mouth;
	public ModelRenderer ear_right;
	public ModelRenderer ear_left;
	public ModelRenderer right_horn;
	public ModelRenderer left_horn;
	public ModelRenderer horn_2;
	public ModelRenderer horn_3;
	public ModelRenderer horn_4;
	public ModelRenderer horn_2_1;
	public ModelRenderer horn_3_1;
	public ModelRenderer horn_4_1;

	public ModelAeternaeHead() {
		this.textureWidth = 128;
		this.textureHeight = 48;
		this.horn_4 = new ModelRenderer(this, 30, 0);
		this.horn_4.setRotationPoint(-0.1F, -3.0F, 0.7F);
		this.horn_4.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(horn_4, -0.5462880558742251F, 0.0F, -0.045553093477052F);
		this.horn_2_1 = new ModelRenderer(this, 119, 18);
		this.horn_2_1.setRotationPoint(0.1F, -3.0F, 0.7F);
		this.horn_2_1.addBox(0.0F, -3.0F, 0.0F, 1, 3, 3, 0.0F);
		this.setRotateAngle(horn_2_1, -0.4553564018453205F, 0.0F, 0.045553093477052F);
		this.horn_3 = new ModelRenderer(this, 43, 0);
		this.horn_3.setRotationPoint(-0.1F, -3.0F, 0.7F);
		this.horn_3.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 2, 0.0F);
		this.setRotateAngle(horn_3, -0.4553564018453205F, 0.0F, -0.045553093477052F);
		this.nose = new ModelRenderer(this, 19, 22);
		this.nose.setRotationPoint(0.0F, 0.5F, -3.5F);
		this.nose.addBox(-2.0F, -2.5F, -4.0F, 4, 2, 4, 0.0F);
		this.right_horn = new ModelRenderer(this, 39, 23);
		this.right_horn.setRotationPoint(-1.5F, -2.0F, -1.0F);
		this.right_horn.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 4, 0.0F);
		this.setRotateAngle(right_horn, -0.18203784098300857F, 0.0F, -0.27314402793711257F);
		this.horn_2 = new ModelRenderer(this, 116, 10);
		this.horn_2.setRotationPoint(-0.1F, -3.0F, 0.7F);
		this.horn_2.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 3, 0.0F);
		this.setRotateAngle(horn_2, -0.4553564018453205F, 0.0F, -0.045553093477052F);
		this.horn_3_1 = new ModelRenderer(this, 61, 0);
		this.horn_3_1.setRotationPoint(0.1F, -3.0F, 0.7F);
		this.horn_3_1.addBox(0.0F, -3.0F, 0.0F, 1, 3, 2, 0.0F);
		this.setRotateAngle(horn_3_1, -0.4553564018453205F, 0.0F, 0.045553093477052F);
		this.head = new ModelRenderer(this, 0, 22);
		this.head.setRotationPoint(0.0F, -1.5F, 0.0F);
		this.head.addBox(-3.0F, -2.5F, -3.5F, 6, 4, 7, 0.0F);
		this.horn_4_1 = new ModelRenderer(this, 49, 0);
		this.horn_4_1.setRotationPoint(0.1F, -3.0F, 0.7F);
		this.horn_4_1.addBox(0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(horn_4_1, -0.5462880558742251F, 0.0F, 0.045553093477052F);
		this.left_horn = new ModelRenderer(this, 90, 25);
		this.left_horn.setRotationPoint(1.5F, -2.0F, -1.0F);
		this.left_horn.addBox(0.0F, -3.0F, 0.0F, 1, 3, 4, 0.0F);
		this.setRotateAngle(left_horn, -0.18203784098300857F, 0.0F, 0.27314402793711257F);
		this.mouth = new ModelRenderer(this, 0, 8);
		this.mouth.setRotationPoint(0.0F, -0.2F, -3.5F);
		this.mouth.addBox(-1.5F, -0.3F, -3.0F, 3, 2, 3, 0.0F);
		this.setRotateAngle(mouth, 0.045553093477052F, 0.0F, 0.0F);
		this.ear_right = new ModelRenderer(this, 56, 24);
		this.ear_right.setRotationPoint(-3.0F, -2.2F, 1.5F);
		this.ear_right.addBox(-1.0F, -0.3F, 0.0F, 1, 3, 5, 0.0F);
		this.setRotateAngle(ear_right, -0.7853981633974483F, 0.0F, 0.0F);
		this.ear_left = new ModelRenderer(this, 78, 25);
		this.ear_left.setRotationPoint(3.0F, -2.2F, 1.5F);
		this.ear_left.addBox(0.0F, -0.3F, 0.0F, 1, 3, 5, 0.0F);
		this.setRotateAngle(ear_left, -0.7853981633974483F, 0.0F, 0.0F);
		this.horn_3.addChild(this.horn_4);
		this.left_horn.addChild(this.horn_2_1);
		this.horn_2.addChild(this.horn_3);
		this.head.addChild(this.nose);
		this.head.addChild(this.right_horn);
		this.right_horn.addChild(this.horn_2);
		this.horn_2_1.addChild(this.horn_3_1);
		this.horn_3_1.addChild(this.horn_4_1);
		this.head.addChild(this.left_horn);
		this.head.addChild(this.mouth);
		this.head.addChild(this.ear_right);
		this.head.addChild(this.ear_left);
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