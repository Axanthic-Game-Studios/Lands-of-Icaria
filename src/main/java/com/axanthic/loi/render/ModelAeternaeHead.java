package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAeternaeHead extends ModelBase {
	public ModelRenderer head;
	public ModelRenderer headChild;
	public ModelRenderer headChild_1;
	public ModelRenderer headChild_2;
	public ModelRenderer headChild_3;
	public ModelRenderer headChild_5;
	public ModelRenderer headChild_6;
	public ModelRenderer headChild_8;
	public ModelRenderer headChild_9;
	public ModelRenderer headChild_10;

	public ModelAeternaeHead() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.headChild_9 = new ModelRenderer(this, 65, 8);
		this.headChild_9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_9.addBox(-3.009999990463257F, -13.5F, -20.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_9, -1.1780972480773926F, 0.0F, 0.0F);
		this.headChild_3 = new ModelRenderer(this, 65, 16);
		this.headChild_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_3.addBox(1.0099999904632568F, -13.5F, -20.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_3, -1.1780972480773926F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 32);
		this.head.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.head.addBox(-3.5F, -17.0F, -3.5F, 7, 7, 7, 0.0F);
		this.headChild_1 = new ModelRenderer(this, 65, 0);
		this.headChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_1.addBox(-3.0F, -20.200000762939453F, -9.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_1, -0.39269909262657166F, 0.0F, 0.0F);
		this.headChild_8 = new ModelRenderer(this, 65, 24);
		this.headChild_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_8.addBox(-3.0299999713897705F, -16.0F, 14.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_8, 0.39269909262657166F, 0.0F, 0.0F);
		this.headChild_2 = new ModelRenderer(this, 65, 24);
		this.headChild_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_2.addBox(1.0F, -20.200000762939453F, -9.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_2, -0.39269909262657166F, 0.0F, 0.0F);
		this.headChild = new ModelRenderer(this, 0, 0);
		this.headChild.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild.addBox(-1.5F, -14.0F, -8.5F, 3, 3, 8, 0.0F);
		this.headChild_6 = new ModelRenderer(this, 65, 8);
		this.headChild_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_6.addBox(1.0199999809265137F, -5.0F, 21.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_6, 1.1780972480773926F, 0.0F, 0.0F);
		this.headChild_5 = new ModelRenderer(this, 65, 16);
		this.headChild_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_5.addBox(-3.0199999809265137F, -5.0F, 21.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_5, 1.1780972480773926F, 0.0F, 0.0F);
		this.headChild_10 = new ModelRenderer(this, 65, 0);
		this.headChild_10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headChild_10.addBox(1.0299999713897705F, -16.0F, 14.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(headChild_10, 0.39269909262657166F, 0.0F, 0.0F);
		this.head.addChild(this.headChild_9);
		this.head.addChild(this.headChild_3);
		this.head.addChild(this.headChild_1);
		this.head.addChild(this.headChild_8);
		this.head.addChild(this.headChild_2);
		this.head.addChild(this.headChild);
		this.head.addChild(this.headChild_6);
		this.head.addChild(this.headChild_5);
		this.head.addChild(this.headChild_10);
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