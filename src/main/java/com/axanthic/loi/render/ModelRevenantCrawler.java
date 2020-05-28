package com.axanthic.loi.render;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class ModelRevenantCrawler extends ModelBase {
	public ModelRenderer leg_left;
	public ModelRenderer arm_right;
	public ModelRenderer leg_right;
	public ModelRenderer arm_left;
	public ModelRenderer skull;
	public ModelRenderer spine;
	public ModelRenderer arm_rightChild;
	public ModelRenderer leg_rightChild;
	public ModelRenderer arm_leftChild;
	public ModelRenderer skullChild;
	public ModelRenderer skullChild_1;
	public ModelRenderer spineChild;
	public ModelRenderer spineChild_1;
	public ModelRenderer spineChild_2;
	public ModelRenderer spineChild_3;
	public ModelRenderer spineChild_4;
	public ModelRenderer spineChild_5;
	public ModelRenderer spineChild_6;
	public ModelRenderer spineChild_7;
	public ModelRenderer spineChild_8;
	public ModelRenderer spineChild_9;
	public ModelRenderer coat;
	public ModelRenderer spineChildChild;
	public ModelRenderer spineChildChildChild;
	public ModelRenderer spineChildChild_1;
	public ModelRenderer spineChildChildChild_1;
	public ModelRenderer spineChildChild_2;
	public ModelRenderer spineChildChildChild_2;
	public ModelRenderer spineChildChild_3;
	public ModelRenderer spineChildChildChild_3;
	public ModelRenderer spineChildChild_4;
	public ModelRenderer spineChildChildChild_4;
	public ModelRenderer spineChildChild_5;
	public ModelRenderer spineChildChildChild_5;
	public ModelRenderer spineChildChild_6;
	public ModelRenderer spineChildChildChild_6;
	public ModelRenderer spineChildChild_7;
	public ModelRenderer spineChildChildChild_7;
	public ModelRenderer spineChildChildChild_8;
	public ModelRenderer spineChildChild_8;
	public ModelRenderer spineChildChild_9;
	public ModelRenderer spineChildChildChild_9;

	public ModelRevenantCrawler() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.leg_right = new ModelRenderer(this, 46, 0);
		this.leg_right.setRotationPoint(-2.5F, 20.4F, 11.1F);
		this.leg_right.addBox(-1.4F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_right, 1.2915436464758039F, -0.091106186954104F, 0.0F);
		this.spineChild_5 = new ModelRenderer(this, 80, 7);
		this.spineChild_5.setRotationPoint(-0.4000000059604645F, 1.0F, 0.0F);
		this.spineChild_5.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(spineChild_5, 0.0F, 0.0F, -0.2094395160675049F);
		this.spineChildChildChild_8 = new ModelRenderer(this, 64, 11);
		this.spineChildChildChild_8.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.spineChildChildChild_8.addBox(-3.799999952316284F, 0.5F, -1.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(spineChildChildChild_8, 0.2094395160675049F, -0.10471975803375246F, 0.0F);
		this.spineChildChildChild_2 = new ModelRenderer(this, 0, 2);
		this.spineChildChildChild_2.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChildChild_2.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.arm_right = new ModelRenderer(this, 54, 0);
		this.arm_right.setRotationPoint(-6.0F, 16.0F, -1.0F);
		this.arm_right.addBox(-1.8F, 0.0F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_right, -0.39269908169872414F, 0.0F, 0.20472712125893486F);
		this.spineChild = new ModelRenderer(this, 48, 9);
		this.spineChild.setRotationPoint(0.30000001192092896F, 3.0F, 0.0F);
		this.spineChild.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(spineChild, 0.0F, 0.0F, 0.4188790321350098F);
		this.spineChild_3 = new ModelRenderer(this, 70, 7);
		this.spineChild_3.setRotationPoint(0.30000001192092896F, 0.0F, 0.0F);
		this.spineChild_3.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(spineChild_3, 0.0F, 0.0F, 0.10471975803375246F);
		this.spineChild_7 = new ModelRenderer(this, 58, 9);
		this.spineChild_7.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.spineChild_7.addBox(-4.0F, 16.799999237060547F, 1.0F, 8, 1, 1, 0.0F);
		this.spineChildChildChild_5 = new ModelRenderer(this, 0, 4);
		this.spineChildChildChild_5.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChildChild_5.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.spineChildChild_9 = new ModelRenderer(this, 106, 9);
		this.spineChildChild_9.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild_9.addBox(5.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F);
		this.arm_leftChild = new ModelRenderer(this, 86, 27);
		this.arm_leftChild.mirror = true;
		this.arm_leftChild.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.arm_leftChild.addBox(-0.4F, -1.0F, -1.1F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_leftChild, -1.1838568316277536F, 0.0F, 0.27314402793711257F);
		this.skullChild = new ModelRenderer(this, 70, 0);
		this.skullChild.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skullChild.addBox(-2.5F, -2.0F, -3.5F, 5, 1, 6, 0.0F);
		this.spineChild_8 = new ModelRenderer(this, 114, 0);
		this.spineChild_8.setRotationPoint(0.0F, -2.0F, -0.20000000298023224F);
		this.spineChild_8.addBox(-2.0F, 3.5F, -2.0F, 4, 6, 1, 0.0F);
		this.spineChildChildChild = new ModelRenderer(this, 44, 11);
		this.spineChildChildChild.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChildChild.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.spineChildChild_4 = new ModelRenderer(this, 116, 7);
		this.spineChildChild_4.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild_4.addBox(-6.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F);
		this.skullChild_1 = new ModelRenderer(this, 0, 34);
		this.skullChild_1.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.skullChild_1.addBox(-3.0F, -4.0F, -3.799999952316284F, 6, 5, 0, 0.0F);
		this.spineChildChild = new ModelRenderer(this, 0, 14);
		this.spineChildChild.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.spineChildChild_1 = new ModelRenderer(this, 82, 11);
		this.spineChildChild_1.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild_1.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.spineChild_4 = new ModelRenderer(this, 86, 0);
		this.spineChild_4.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChild_4.addBox(-5.0F, 3.0F, 1.0F, 4, 2, 1, 0.0F);
		this.spineChild_9 = new ModelRenderer(this, 86, 3);
		this.spineChild_9.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChild_9.addBox(1.0F, 3.0F, 1.0F, 4, 2, 1, 0.0F);
		this.spine = new ModelRenderer(this, 30, 0);
		this.spine.setRotationPoint(0.0F, 17.5F, -3.0F);
		this.spine.addBox(-1.0F, -2.0F, 0.4F, 2, 16, 2, 0.0F);
		this.setRotateAngle(spine, 1.3658946726107624F, 0.0F, 0.091106186954104F);
		this.spineChild_2 = new ModelRenderer(this, 22, 0);
		this.spineChild_2.setRotationPoint(-0.30000001192092896F, 0.0F, 0.0F);
		this.spineChild_2.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(spineChild_2, 0.0F, 0.0F, -0.10471975803375246F);
		this.arm_left = new ModelRenderer(this, 62, 0);
		this.arm_left.mirror = true;
		this.arm_left.setRotationPoint(6.0F, 18.0F, -1.5F);
		this.arm_left.addBox(-0.2F, 0.0F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_left, -0.39269908169872414F, 0.0F, -0.5759586531581287F);
		this.spineChildChild_3 = new ModelRenderer(this, 48, 11);
		this.spineChildChild_3.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild_3.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.spineChildChild_5 = new ModelRenderer(this, 58, 11);
		this.spineChildChild_5.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild_5.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.spineChildChild_8 = new ModelRenderer(this, 82, 9);
		this.spineChildChild_8.setRotationPoint(-1.5F, -2.0F, 0.0F);
		this.spineChildChild_8.addBox(-5.0F, 5.5F, 0.20000000298023224F, 13, 1, 1, 0.0F);
		this.spineChildChildChild_4 = new ModelRenderer(this, 0, 0);
		this.spineChildChildChild_4.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChildChild_4.addBox(-5.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F);
		this.spineChildChildChild_7 = new ModelRenderer(this, 19, 14);
		this.spineChildChildChild_7.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.spineChildChildChild_7.addBox(1.7999999523162842F, 0.5F, -1.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(spineChildChildChild_7, 0.2094395160675049F, 0.10471975803375246F, 0.0F);
		this.leg_rightChild = new ModelRenderer(this, 115, 18);
		this.leg_rightChild.mirror = true;
		this.leg_rightChild.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.leg_rightChild.addBox(-1.4F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_rightChild, 0.20943951023931953F, 0.0F, 0.0F);
		this.coat = new ModelRenderer(this, 96, 28);
		this.coat.setRotationPoint(-0.1F, 0.0F, 0.5F);
		this.coat.addBox(-6.0F, 0.0F, 0.0F, 12, 32, 4, 0.0F);
		this.setRotateAngle(coat, -0.136659280431156F, 0.0F, 0.0F);
		this.spineChildChildChild_1 = new ModelRenderer(this, 22, 4);
		this.spineChildChildChild_1.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChildChild_1.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.spineChildChildChild_6 = new ModelRenderer(this, 22, 6);
		this.spineChildChildChild_6.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChildChild_6.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.spineChild_6 = new ModelRenderer(this, 110, 7);
		this.spineChild_6.setRotationPoint(0.4000000059604645F, 2.0F, 0.0F);
		this.spineChild_6.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(spineChild_6, 0.0F, 0.0F, 0.3141592741012573F);
		this.spineChildChild_7 = new ModelRenderer(this, 6, 14);
		this.spineChildChild_7.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild_7.addBox(-3.5F, 19.799999237060547F, -1.5F, 7, 1, 1, 0.0F);
		this.spineChildChildChild_9 = new ModelRenderer(this, 68, 0);
		this.spineChildChildChild_9.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChildChild_9.addBox(2.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F);
		this.skull = new ModelRenderer(this, 0, 0);
		this.skull.setRotationPoint(0.0F, 20.0F, -6.0F);
		this.skull.addBox(-3.5F, -8.0F, -4.0F, 7, 6, 8, 0.0F);
		this.setRotateAngle(skull, 0.15707963267948966F, 0.0F, 0.15707963267948966F);
		this.spineChildChildChild_3 = new ModelRenderer(this, 22, 2);
		this.spineChildChildChild_3.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChildChild_3.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.leg_left = new ModelRenderer(this, 38, 0);
		this.leg_left.mirror = true;
		this.leg_left.setRotationPoint(2.5F, 20.7F, 11.1F);
		this.leg_left.addBox(-0.6F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_left, 1.1768755146197767F, 0.091106186954104F, 0.0F);
		this.spineChildChild_2 = new ModelRenderer(this, 38, 11);
		this.spineChildChild_2.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild_2.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.spineChild_1 = new ModelRenderer(this, 90, 7);
		this.spineChild_1.setRotationPoint(0.4000000059604645F, 1.0F, 0.0F);
		this.spineChild_1.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(spineChild_1, 0.0F, 0.0F, 0.2094395160675049F);
		this.arm_rightChild = new ModelRenderer(this, 78, 27);
		this.arm_rightChild.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.arm_rightChild.addBox(-1.8F, -1.0F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_rightChild, -1.1344640137963142F, 0.0F, -0.2617993877991494F);
		this.spineChildChild_6 = new ModelRenderer(this, 98, 12);
		this.spineChildChild_6.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spineChildChild_6.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.spine.addChild(this.spineChild_5);
		this.spineChildChild_7.addChild(this.spineChildChildChild_8);
		this.spineChildChild_2.addChild(this.spineChildChildChild_2);
		this.spine.addChild(this.spineChild);
		this.spine.addChild(this.spineChild_3);
		this.spine.addChild(this.spineChild_7);
		this.spineChildChild_5.addChild(this.spineChildChildChild_5);
		this.spineChild_9.addChild(this.spineChildChild_9);
		this.arm_left.addChild(this.arm_leftChild);
		this.skull.addChild(this.skullChild);
		this.spine.addChild(this.spineChild_8);
		this.spineChildChild.addChild(this.spineChildChildChild);
		this.spineChild_4.addChild(this.spineChildChild_4);
		this.skull.addChild(this.skullChild_1);
		this.spineChild.addChild(this.spineChildChild);
		this.spineChild_1.addChild(this.spineChildChild_1);
		this.spine.addChild(this.spineChild_4);
		this.spine.addChild(this.spineChild_9);
		this.spine.addChild(this.spineChild_2);
		this.spineChild_3.addChild(this.spineChildChild_3);
		this.spineChild_5.addChild(this.spineChildChild_5);
		this.spineChild_8.addChild(this.spineChildChild_8);
		this.spineChildChild_4.addChild(this.spineChildChildChild_4);
		this.spineChildChild_7.addChild(this.spineChildChildChild_7);
		this.leg_right.addChild(this.leg_rightChild);
		this.spine.addChild(this.coat);
		this.spineChildChild_1.addChild(this.spineChildChildChild_1);
		this.spineChildChild_6.addChild(this.spineChildChildChild_6);
		this.spine.addChild(this.spineChild_6);
		this.spineChild_7.addChild(this.spineChildChild_7);
		this.spineChildChild_9.addChild(this.spineChildChildChild_9);
		this.spineChildChild_3.addChild(this.spineChildChildChild_3);
		this.spineChild_2.addChild(this.spineChildChild_2);
		this.spine.addChild(this.spineChild_1);
		this.arm_right.addChild(this.arm_rightChild);
		this.spineChild_6.addChild(this.spineChildChild_6);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.leg_right.render(scale);
		this.arm_right.render(scale);
		this.spine.render(scale);
		this.arm_left.render(scale);
		this.skull.render(scale);
		this.leg_left.render(scale);
		this.renderHeldItems(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}

	public void renderHeldItems(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ItemStack heldItem = ((EntityLivingBase) entityIn).getHeldItemMainhand();
		if (heldItem.isEmpty())
			return;

		GlStateManager.pushMatrix();
		GlStateManager.translate(this.arm_right.rotationPointX/16.0D, this.arm_right.rotationPointY/16.0D, this.arm_right.rotationPointZ/16.0D);
		GlStateManager.rotate(this.arm_right.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(this.arm_right.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(this.arm_right.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
		GlStateManager.translate(this.arm_right.offsetX/16.0D, this.arm_right.offsetY/16.0D, this.arm_right.offsetZ/16.0D);

		GlStateManager.translate(this.arm_rightChild.rotationPointX/16.0D, this.arm_rightChild.rotationPointY/16.0D, this.arm_rightChild.rotationPointZ/16.0D);
		GlStateManager.rotate(this.arm_rightChild.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(this.arm_rightChild.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(this.arm_rightChild.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
		GlStateManager.translate(this.arm_rightChild.offsetX/16.0D, this.arm_rightChild.offsetY/16.0D, this.arm_rightChild.offsetZ/16.0D);

		GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(0.05F, 0.02F, -0.4F);

		Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase) entityIn, heldItem, TransformType.THIRD_PERSON_RIGHT_HAND);
		GlStateManager.popMatrix();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	float legBend = 1.2f;
	float kneeBend = 1.0f;

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		Random random = new Random(entityIn.getEntityId());
		this.setRotateAngle(skull, headPitch * 0.017453292F + 0.15707963267948966F, netHeadYaw * 0.017453292F, (((float) random.nextInt(100)) / 100.0F - 0.5F) * 0.5F + MathHelper.sin(ageInTicks * 0.05F) * 0.05F);

		limbSwingAmount *= 1.7F;
		
		this.arm_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * legBend * limbSwingAmount - 0.39269908169872414F;
		this.arm_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * legBend * limbSwingAmount - 0.39269908169872414F;

		this.arm_rightChild.rotateAngleX = -MathHelper.cos(-0.6F + limbSwing * 0.6662F + (float)Math.PI) * kneeBend * limbSwingAmount - 0.7F * limbSwingAmount - 1.1344640137963142F;
		this.arm_leftChild.rotateAngleX = -MathHelper.cos(-0.6F + limbSwing * 0.6662F) * kneeBend * limbSwingAmount - 0.7F * limbSwingAmount - 1.1838568316277536F;

		if (this.swingProgress > 0.0F) {
			//EnumHandSide enumhandside = this.getMainHand(entityIn);
			//ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
			float f1 = this.swingProgress;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float)Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float)Math.PI) * 0.7F * 0.75F;
			this.arm_right.rotateAngleX += (float)((double)this.arm_right.rotateAngleX - ((double)f2 * 1.2D + (double)f3));
			//modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			this.arm_right.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
		}

		//this.arm_right.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		//this.arm_left.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		//this.arm_right.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		//this.arm_left.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		//this.lower_jaw.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
}