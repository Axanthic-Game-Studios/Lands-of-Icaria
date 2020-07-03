package com.axanthic.loi.render;

import com.axanthic.loi.entity.EntityVinegaroon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * ModelVinegaroon - Xenoform
 * Created using Tabula 7.0.0
 */
public class ModelVinegaroon extends ModelBase {
    public ModelRenderer Carapace;
    public ModelRenderer Rleg4;
    public ModelRenderer Lleg4;
    public ModelRenderer LmiddleLeg;
    public ModelRenderer LbackLeg;
    public ModelRenderer LfarthestLeg;
    public ModelRenderer RmiddleLeg;
    public ModelRenderer RbackLeg;
    public ModelRenderer RfarthestLeg;
    public ModelRenderer Abdomen;
    public ModelRenderer Head;
    public ModelRenderer Tailnub;
    public ModelRenderer Tail;
    public ModelRenderer Tail_1;
    public ModelRenderer Larm1;
    public ModelRenderer Rarm1;
    public ModelRenderer RFrontEye;
    public ModelRenderer LFrontEye;
    public ModelRenderer REye;
    public ModelRenderer LEye;
    public ModelRenderer Larm2;
    public ModelRenderer Larm3;
    public ModelRenderer Lclaw;
    public ModelRenderer Rarm2;
    public ModelRenderer Rarm3;
    public ModelRenderer Rclaw;
    public ModelRenderer Rleg4extend;
    public ModelRenderer Lleg4extend;
    public ModelRenderer LmiddleForeleg;
    public ModelRenderer LbackForeleg;
    public ModelRenderer LfarthestForeleg;
    public ModelRenderer RmiddleForeleg;
    public ModelRenderer RbackForeleg;
    public ModelRenderer RfarthestForeleg;

    public ModelVinegaroon() {
        this.textureWidth = 95;
        this.textureHeight = 58;
        this.RfarthestLeg = new ModelRenderer(this, 59, 43);
        this.RfarthestLeg.mirror = true;
        this.RfarthestLeg.setRotationPoint(-4.5F, 17.0F, 1.3F);
        this.RfarthestLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(RfarthestLeg, 0.22689280275926282F, 0.7853981633974483F, 0.3141592653589793F);
        this.Tail_1 = new ModelRenderer(this, 64, 10);
        this.Tail_1.setRotationPoint(0.0F, -0.1F, 8.8F);
        this.Tail_1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 9, 0.0F);
        this.setRotateAngle(Tail_1, 0.136659280431156F, 0.0F, 0.0F);
        this.Larm2 = new ModelRenderer(this, 0, 46);
        this.Larm2.setRotationPoint(5.0F, 0.0F, 1.5F);
        this.Larm2.addBox(0.5F, -2.0F, -2.0F, 7, 4, 3, 0.0F);
        this.setRotateAngle(Larm2, 0.0F, 1.0471975511965976F, 0.0F);
        this.Rarm2 = new ModelRenderer(this, 27, 46);
        this.Rarm2.setRotationPoint(-5.0F, 0.0F, 1.5F);
        this.Rarm2.addBox(-7.5F, -2.0F, -2.0F, 7, 4, 3, 0.0F);
        this.setRotateAngle(Rarm2, 0.0F, -1.0471975511965976F, 0.0F);
        this.RmiddleForeleg = new ModelRenderer(this, 59, 38);
        this.RmiddleForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
        this.RmiddleForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(RmiddleForeleg, 0.0F, 0.0F, 2.1467549799530254F);
        this.RbackLeg = new ModelRenderer(this, 59, 43);
        this.RbackLeg.mirror = true;
        this.RbackLeg.setRotationPoint(-4.5F, 17.0F, -0.3F);
        this.RbackLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(RbackLeg, 0.091106186954104F, 0.3839724354387525F, 0.22689280275926282F);
        this.Larm3 = new ModelRenderer(this, 52, 48);
        this.Larm3.setRotationPoint(6.5F, 0.0F, 0.8F);
        this.Larm3.addBox(0.5F, -2.0F, -1.0F, 5, 4, 2, 0.0F);
        this.setRotateAngle(Larm3, 0.0F, 1.0471975511965976F, 0.0F);
        this.RfarthestForeleg = new ModelRenderer(this, 59, 38);
        this.RfarthestForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
        this.RfarthestForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(RfarthestForeleg, 0.0F, 0.0F, 2.1467549799530254F);
        this.LfarthestLeg = new ModelRenderer(this, 59, 43);
        this.LfarthestLeg.setRotationPoint(4.5F, 17.0F, 1.5F);
        this.LfarthestLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(LfarthestLeg, 0.22689280275926282F, -0.7853981633974483F, -0.3141592653589793F);
        this.REye = new ModelRenderer(this, 0, 2);
        this.REye.setRotationPoint(-3.7F, -3.7F, -4.2F);
        this.REye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Rleg4extend = new ModelRenderer(this, 61, 30);
        this.Rleg4extend.setRotationPoint(-14.0F, 0.0F, 0.0F);
        this.Rleg4extend.addBox(-14.5F, -0.5F, -0.5F, 15, 1, 1, 0.0F);
        this.setRotateAngle(Rleg4extend, 0.5235987755982988F, -0.3490658503988659F, -0.08726646259971647F);
        this.Lleg4 = new ModelRenderer(this, 61, 33);
        this.Lleg4.setRotationPoint(4.5F, 17.0F, -3.0F);
        this.Lleg4.addBox(-1.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
        this.setRotateAngle(Lleg4, 0.0F, 0.9637708129512687F, 0.4886921905584123F);
        this.LbackForeleg = new ModelRenderer(this, 59, 38);
        this.LbackForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
        this.LbackForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(LbackForeleg, 0.0F, 0.0F, 0.9948376736367678F);
        this.LFrontEye = new ModelRenderer(this, 0, 0);
        this.LFrontEye.setRotationPoint(1.0F, -3.7F, -7.7F);
        this.LFrontEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.RbackForeleg = new ModelRenderer(this, 59, 38);
        this.RbackForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
        this.RbackForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(RbackForeleg, 0.0F, 0.0F, 2.1467549799530254F);
        this.Tail = new ModelRenderer(this, 64, 10);
        this.Tail.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Tail.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 9, 0.0F);
        this.setRotateAngle(Tail, 0.136659280431156F, 0.0F, 0.0F);
        this.RmiddleLeg = new ModelRenderer(this, 59, 43);
        this.RmiddleLeg.mirror = true;
        this.RmiddleLeg.setRotationPoint(-4.5F, 17.0F, -1.3F);
        this.RmiddleLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(RmiddleLeg, -0.091106186954104F, -0.3839724354387525F, 0.22689280275926282F);
        this.Rarm1 = new ModelRenderer(this, 26, 39);
        this.Rarm1.setRotationPoint(-3.0F, -1.0F, -7.0F);
        this.Rarm1.addBox(-6.0F, -1.5F, -1.5F, 6, 3, 3, 0.0F);
        this.setRotateAngle(Rarm1, 0.0F, -0.6981317007977318F, 0.0F);
        this.LbackLeg = new ModelRenderer(this, 59, 43);
        this.LbackLeg.setRotationPoint(4.5F, 17.0F, -0.3F);
        this.LbackLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(LbackLeg, 0.091106186954104F, -0.3839724354387525F, -0.22689280275926282F);
        this.Lclaw = new ModelRenderer(this, 8, 53);
        this.Lclaw.setRotationPoint(5.5F, 0.0F, 0.7F);
        this.Lclaw.addBox(0.0F, -2.0F, -1.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(Lclaw, 0.0F, 0.6108652381980153F, 0.0F);
        this.Rleg4 = new ModelRenderer(this, 61, 33);
        this.Rleg4.mirror = true;
        this.Rleg4.setRotationPoint(-4.5F, 17.0F, -3.0F);
        this.Rleg4.addBox(-14.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
        this.setRotateAngle(Rleg4, 0.0F, -0.9637708129512687F, -0.4886921905584123F);
        this.Larm1 = new ModelRenderer(this, 0, 39);
        this.Larm1.setRotationPoint(3.0F, -1.0F, -7.0F);
        this.Larm1.addBox(0.0F, -1.5F, -1.5F, 6, 3, 3, 0.0F);
        this.setRotateAngle(Larm1, 0.0F, 0.6981317007977318F, 0.0F);
        this.Abdomen = new ModelRenderer(this, 0, 14);
        this.Abdomen.setRotationPoint(0.0F, 0.4F, 3.5F);
        this.Abdomen.addBox(-5.0F, -4.0F, -0.3F, 10, 6, 18, 0.0F);
        this.setRotateAngle(Abdomen, 0.091106186954104F, 0.0F, 0.0F);
        this.Tailnub = new ModelRenderer(this, 79, 7);
        this.Tailnub.setRotationPoint(0.0F, -1.0F, 17.5F);
        this.Tailnub.addBox(-1.5F, -1.5F, -0.3F, 3, 3, 3, 0.0F);
        this.setRotateAngle(Tailnub, 0.091106186954104F, 0.0F, 0.0F);
        this.Carapace = new ModelRenderer(this, 31, 0);
        this.Carapace.setRotationPoint(0.0F, 15.7F, 0.0F);
        this.Carapace.addBox(-4.5F, -3.5F, -4.0F, 9, 6, 7, 0.0F);
        this.LmiddleForeleg = new ModelRenderer(this, 59, 38);
        this.LmiddleForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
        this.LmiddleForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(LmiddleForeleg, 0.0F, 0.0F, 0.9948376736367678F);
        this.RFrontEye = new ModelRenderer(this, 0, 2);
        this.RFrontEye.setRotationPoint(-1.0F, -3.7F, -7.7F);
        this.RFrontEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Rclaw = new ModelRenderer(this, 0, 53);
        this.Rclaw.setRotationPoint(-5.5F, 0.0F, 0.7F);
        this.Rclaw.addBox(-2.0F, -2.0F, -1.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(Rclaw, 0.0F, -0.6108652381980153F, 0.0F);
        this.Lleg4extend = new ModelRenderer(this, 61, 30);
        this.Lleg4extend.setRotationPoint(14.0F, 0.0F, 0.0F);
        this.Lleg4extend.addBox(-0.5F, -0.5F, -0.5F, 15, 1, 1, 0.0F);
        this.setRotateAngle(Lleg4extend, 0.5235987755982988F, 0.3490658503988659F, 0.08726646259971647F);
        this.Rarm3 = new ModelRenderer(this, 68, 48);
        this.Rarm3.setRotationPoint(-6.5F, 0.0F, 0.8F);
        this.Rarm3.addBox(-5.5F, -2.0F, -1.0F, 5, 4, 2, 0.0F);
        this.setRotateAngle(Rarm3, 0.0F, -1.0471975511965976F, 0.0F);
        this.LfarthestForeleg = new ModelRenderer(this, 59, 38);
        this.LfarthestForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
        this.LfarthestForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(LfarthestForeleg, 0.0F, 0.0F, 0.9948376736367678F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.5F, -3.0F);
        this.Head.addBox(-4.0F, -4.0F, -8.0F, 8, 6, 7, 0.0F);
        this.LmiddleLeg = new ModelRenderer(this, 59, 43);
        this.LmiddleLeg.setRotationPoint(4.5F, 17.0F, -1.3F);
        this.LmiddleLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(LmiddleLeg, -0.091106186954104F, 0.3839724354387525F, -0.22689280275926282F);
        this.LEye = new ModelRenderer(this, 0, 2);
        this.LEye.setRotationPoint(3.7F, -3.7F, -4.2F);
        this.LEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Tail.addChild(this.Tail_1);
        this.Larm1.addChild(this.Larm2);
        this.Rarm1.addChild(this.Rarm2);
        this.RmiddleLeg.addChild(this.RmiddleForeleg);
        this.Larm2.addChild(this.Larm3);
        this.RfarthestLeg.addChild(this.RfarthestForeleg);
        this.Head.addChild(this.REye);
        this.Rleg4.addChild(this.Rleg4extend);
        this.LbackLeg.addChild(this.LbackForeleg);
        this.Head.addChild(this.LFrontEye);
        this.RbackLeg.addChild(this.RbackForeleg);
        this.Tailnub.addChild(this.Tail);
        this.Head.addChild(this.Rarm1);
        this.Larm3.addChild(this.Lclaw);
        this.Head.addChild(this.Larm1);
        this.Carapace.addChild(this.Abdomen);
        this.Abdomen.addChild(this.Tailnub);
        this.LmiddleLeg.addChild(this.LmiddleForeleg);
        this.Head.addChild(this.RFrontEye);
        this.Rarm3.addChild(this.Rclaw);
        this.Lleg4.addChild(this.Lleg4extend);
        this.Rarm2.addChild(this.Rarm3);
        this.LfarthestLeg.addChild(this.LfarthestForeleg);
        this.Carapace.addChild(this.Head);
        this.Head.addChild(this.LEye);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        this.RfarthestLeg.render(f5);
        this.RbackLeg.render(f5);
        this.LfarthestLeg.render(f5);
        this.Lleg4.render(f5);
        this.RmiddleLeg.render(f5);
        this.LbackLeg.render(f5);
        this.Rleg4.render(f5);
        this.Carapace.render(f5);
        this.LmiddleLeg.render(f5);
        GlStateManager.popMatrix();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		EntityVinegaroon scorpion = (EntityVinegaroon) entityIn;
		if (scorpion.isBesideClimbableBlock() && scorpion.posY > scorpion.prevPosY) {
			final float armSwing = ageInTicks * 0.4f;
			final float legSpeed = 1.1f;
			final float varY = MathHelper.sin(armSwing * legSpeed) * 0.65f * limbSwingAmount;
			final float varZ = Math.abs(MathHelper.cos(armSwing * legSpeed)) * 0.8f * limbSwingAmount;
			
			this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
			this.Head.rotateAngleX = headPitch * 0.017453292F - 0.085f;

			this.LmiddleLeg.rotateAngleZ = -0.23F + varZ;
			this.LbackLeg.rotateAngleZ = -0.23F + varZ;
			this.LfarthestLeg.rotateAngleZ = -0.31F + varZ;
			this.RmiddleLeg.rotateAngleZ = 0.23F - varZ;
			this.RbackLeg.rotateAngleZ = 0.23F - varZ;
			this.RfarthestLeg.rotateAngleZ = 0.31F - varZ;

			this.LmiddleLeg.rotateAngleY = -0.38F - varY;
			this.LbackLeg.rotateAngleY = -0.38F + varY;
			this.LfarthestLeg.rotateAngleY = -0.78F - varY;
			this.RmiddleLeg.rotateAngleY = 0.38F - varY;
			this.RbackLeg.rotateAngleY = 0.38F + varY;
			this.RfarthestLeg.rotateAngleY = 0.78F - varY;

		} else {

			final float legSpeed = 1.1f;
			final float varY = MathHelper.sin(limbSwing * legSpeed) * 0.65f * limbSwingAmount;
			final float varZ = Math.abs(MathHelper.cos(limbSwing * legSpeed)) * 0.3f * limbSwingAmount;
			
			this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
			this.Head.rotateAngleX = headPitch * 0.017453292F - 0.085f;

			this.LmiddleLeg.rotateAngleZ = -0.23F + varZ;
			this.LbackLeg.rotateAngleZ = -0.23F + varZ;
			this.LfarthestLeg.rotateAngleZ = -0.31F + varZ;
			this.RmiddleLeg.rotateAngleZ = 0.23F + varZ;
			this.RbackLeg.rotateAngleZ = 0.23F - varZ;
			this.RfarthestLeg.rotateAngleZ = 0.31F - varZ;

			this.LmiddleLeg.rotateAngleY = 0.38F - varY;
			this.LbackLeg.rotateAngleY = -0.38F + varY;
			this.LfarthestLeg.rotateAngleY = -0.78F - varY;
			this.RmiddleLeg.rotateAngleY = -0.38F - varY;
			this.RbackLeg.rotateAngleY = 0.38F + varY;
			this.RfarthestLeg.rotateAngleY = 0.78F - varY;
		}
	}

	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTickTime) {
		EntityVinegaroon entity = (EntityVinegaroon) entitylivingbaseIn;

		if (!entity.getPassengers().isEmpty()) {
			this.Rarm1.rotateAngleY = -0.75F;
			this.Larm1.rotateAngleY = 0.75F;
		} else {
			this.Rarm1.rotateAngleY = -0.3F;
			this.Larm1.rotateAngleY = 0.3F;
		}
		
		int i2 = entity.getTailTimer();
		if (i2 > 40) {
			this.Abdomen.rotateAngleX = 0.25F;
			this.Tailnub.rotateAngleX = 1.25F;
			this.Tail.rotateAngleX = 0.45F;
			this.Tail_1.rotateAngleX = 0.35F;
		} else {
			this.Abdomen.rotateAngleX = 0.0F;
			this.Tailnub.rotateAngleX = 0.0F;
			this.Tail.rotateAngleX = 0.136659280431156F;
			this.Tail_1.rotateAngleX = 0.136659280431156F;
		}
	}
}
