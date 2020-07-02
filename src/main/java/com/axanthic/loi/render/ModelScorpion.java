package com.axanthic.loi.render;

import com.axanthic.loi.entity.EntityScorpion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * ModelScorpion - Xenoform Created using Tabula 7.0.0
 */
public class ModelScorpion extends ModelBase {

	public ModelRenderer Carapace;
	public ModelRenderer LmiddleLeg;
	public ModelRenderer LfrontLeg;
	public ModelRenderer LbackLeg;
	public ModelRenderer LfarthestLeg;
	public ModelRenderer RfrontLeg;
	public ModelRenderer RmiddleLeg;
	public ModelRenderer RbackLeg;
	public ModelRenderer RfarthestLeg;
	public ModelRenderer Abdomen;
	public ModelRenderer Head;
	public ModelRenderer Rear;
	public ModelRenderer tailSeg1;
	public ModelRenderer tailSeg2;
	public ModelRenderer tailSeg2_1;
	public ModelRenderer Stinger;
	public ModelRenderer stingerEnd;
	public ModelRenderer LArm;
	public ModelRenderer RArm;
	public ModelRenderer REye;
	public ModelRenderer LEye;
	public ModelRenderer RfrontEye;
	public ModelRenderer LfrontEye;
	public ModelRenderer LForearm;
	public ModelRenderer LPincer;
	public ModelRenderer LclawTop;
	public ModelRenderer LclawBot;
	public ModelRenderer RForearm;
	public ModelRenderer RPincer;
	public ModelRenderer RclawTop;
	public ModelRenderer RclawBot;
	public ModelRenderer LmiddleForeleg;
	public ModelRenderer LfrontForeleg;
	public ModelRenderer LbackForeleg;
	public ModelRenderer LfarthestForeleg;
	public ModelRenderer RfrontForeleg;
	public ModelRenderer RmiddleForeleg;
	public ModelRenderer RbackForeleg;
	public ModelRenderer RfarthestForeleg;

	public ModelScorpion() {
		this.textureWidth = 95;
		this.textureHeight = 48;

		this.LArm = new ModelRenderer(this, 8, 21);
		this.LArm.setRotationPoint(2.3F, -1.0F, -9.0F);
		this.LArm.addBox(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
		this.setRotateAngle(LArm, 0.0F, -0.2792526803190927F, 0.0F);
		this.LmiddleLeg = new ModelRenderer(this, 59, 43);
		this.LmiddleLeg.setRotationPoint(4.5F, 17.0F, -1.3F);
		this.LmiddleLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(LmiddleLeg, -0.091106186954104F, 0.3839724354387525F, -0.22689280275926282F);
		this.RmiddleForeleg = new ModelRenderer(this, 59, 38);
		this.RmiddleForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
		this.RmiddleForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
		this.setRotateAngle(RmiddleForeleg, 0.0F, 0.0F, 2.1467549799530254F);
		this.LfarthestLeg = new ModelRenderer(this, 59, 43);
		this.LfarthestLeg.setRotationPoint(4.5F, 17.0F, 1.5F);
		this.LfarthestLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(LfarthestLeg, 0.22689280275926282F, -0.7853981633974483F, -0.3141592653589793F);
		this.LfrontEye = new ModelRenderer(this, 0, 0);
		this.LfrontEye.setRotationPoint(3.0F, -3.7F, -7.7F);
		this.LfrontEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.RfrontEye = new ModelRenderer(this, 0, 2);
		this.RfrontEye.setRotationPoint(-3.0F, -3.7F, -7.7F);
		this.RfrontEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.LclawTop = new ModelRenderer(this, 16, 28);
		this.LclawTop.setRotationPoint(5.8F, 0.0F, 0.5F);
		this.LclawTop.addBox(0.0F, -1.5F, -1.0F, 5, 1, 2, 0.0F);
		this.setRotateAngle(LclawTop, 0.0F, 0.0F, 0.18203784098300857F);
		this.LclawBot = new ModelRenderer(this, 16, 28);
		this.LclawBot.setRotationPoint(5.8F, 2.7F, 0.5F);
		this.LclawBot.addBox(0.0F, -1.5F, -1.0F, 5, 1, 2, 0.0F);
		this.setRotateAngle(LclawBot, 0.0F, 0.0F, -0.04363323129985824F);
		this.LfarthestForeleg = new ModelRenderer(this, 59, 38);
		this.LfarthestForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
		this.LfarthestForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
		this.setRotateAngle(LfarthestForeleg, 0.0F, 0.0F, 0.9948376736367678F);
		this.LbackLeg = new ModelRenderer(this, 59, 43);
		this.LbackLeg.setRotationPoint(4.5F, 17.0F, -0.3F);
		this.LbackLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(LbackLeg, 0.091106186954104F, -0.3839724354387525F, -0.22689280275926282F);
		this.tailSeg2 = new ModelRenderer(this, 21, 33);
		this.tailSeg2.setRotationPoint(0.0F, -5.6F, 0.1F);
		this.tailSeg2.addBox(-2.5F, -8.0F, -1.5F, 5, 9, 4, 0.0F);
		this.setRotateAngle(tailSeg2, 1.0173524209874947F, 0.0F, 0.0F);
		this.stingerEnd = new ModelRenderer(this, 57, 24);
		this.stingerEnd.setRotationPoint(-0.5F, -4.5F, -1.0F);
		this.stingerEnd.addBox(-0.5F, -5.7F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(stingerEnd, -0.40980330836826856F, 0.0F, 0.0F);
		this.RfarthestLeg = new ModelRenderer(this, 59, 43);
		this.RfarthestLeg.mirror = true;
		this.RfarthestLeg.setRotationPoint(-4.5F, 17.0F, 1.3F);
		this.RfarthestLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(RfarthestLeg, 0.22689280275926282F, 0.7853981633974483F, 0.3141592653589793F);
		this.RForearm = new ModelRenderer(this, 8, 21);
		this.RForearm.setRotationPoint(-5.5F, 0.0F, 0.0F);
		this.RForearm.addBox(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
		this.setRotateAngle(RForearm, 0.0F, -1.3089969389957472F, 0.0F);
		this.LEye = new ModelRenderer(this, 0, 0);
		this.LEye.setRotationPoint(0.9F, -3.7F, -4.7F);
		this.LEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.RfarthestForeleg = new ModelRenderer(this, 59, 38);
		this.RfarthestForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
		this.RfarthestForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
		this.setRotateAngle(RfarthestForeleg, 0.0F, 0.0F, 2.1467549799530254F);
		this.RmiddleLeg = new ModelRenderer(this, 59, 43);
		this.RmiddleLeg.mirror = true;
		this.RmiddleLeg.setRotationPoint(-4.5F, 17.0F, -1.3F);
		this.RmiddleLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(RmiddleLeg, -0.091106186954104F, -0.3839724354387525F, 0.22689280275926282F);
		this.Abdomen = new ModelRenderer(this, 64, 0);
		this.Abdomen.setRotationPoint(0.0F, 0.4F, 3.5F);
		this.Abdomen.addBox(-4.0F, -4.0F, -0.3F, 8, 6, 7, 0.0F);
		this.setRotateAngle(Abdomen, 0.36425021489121656F, 0.0F, 0.0F);
		this.LfrontForeleg = new ModelRenderer(this, 59, 38);
		this.LfrontForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
		this.LfrontForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
		this.setRotateAngle(LfrontForeleg, 0.0F, 0.0F, 0.9948376736367678F);
		this.Rear = new ModelRenderer(this, 66, 14);
		this.Rear.setRotationPoint(0.0F, -2.0F, 6.6F);
		this.Rear.addBox(-3.5F, -2.0F, -1.0F, 7, 5, 6, 0.0F);
		this.setRotateAngle(Rear, 0.27314402793711257F, 0.0F, 0.0F);
		this.REye = new ModelRenderer(this, 0, 2);
		this.REye.setRotationPoint(-0.9F, -3.7F, -4.7F);
		this.REye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.LfrontLeg = new ModelRenderer(this, 59, 43);
		this.LfrontLeg.setRotationPoint(4.5F, 17.0F, -3.0F);
		this.LfrontLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(LfrontLeg, -0.22689280275926282F, 0.7853981633974483F, -0.3141592653589793F);
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.setRotationPoint(0.0F, 0.5F, -3.0F);
		this.Head.addBox(-4.0F, -4.0F, -8.0F, 8, 6, 7, 0.0F);
		this.setRotateAngle(Head, -0.091106186954104F, 0.0F, 0.0F);
		this.Stinger = new ModelRenderer(this, 54, 14);
		this.Stinger.setRotationPoint(0.5F, -7.8F, -0.5F);
		this.Stinger.addBox(-1.5F, -5.5F, -1.6F, 2, 6, 3, 0.0F);
		this.setRotateAngle(Stinger, 1.9123572614101867F, 0.0F, 0.0F);
		this.RArm = new ModelRenderer(this, 8, 21);
		this.RArm.setRotationPoint(-2.3F, -1.0F, -9.0F);
		this.RArm.addBox(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
		this.setRotateAngle(RArm, 0.0F, 0.2792526803190927F, 0.0F);
		this.RfrontForeleg = new ModelRenderer(this, 59, 38);
		this.RfrontForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
		this.RfrontForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
		this.setRotateAngle(RfrontForeleg, 0.0F, 0.0F, 2.0943951023931953F);
		this.RbackLeg = new ModelRenderer(this, 59, 43);
		this.RbackLeg.mirror = true;
		this.RbackLeg.setRotationPoint(-4.5F, 17.0F, -0.3F);
		this.RbackLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(RbackLeg, 0.091106186954104F, 0.3839724354387525F, 0.22689280275926282F);
		this.tailSeg1 = new ModelRenderer(this, 0, 33);
		this.tailSeg1.setRotationPoint(0.0F, -0.7F, 5.1F);
		this.tailSeg1.addBox(-3.0F, -6.9F, -1.5F, 6, 9, 4, 0.0F);
		this.setRotateAngle(tailSeg1, -0.8651597102135892F, 0.0F, 0.0F);
		this.LbackForeleg = new ModelRenderer(this, 59, 38);
		this.LbackForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
		this.LbackForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
		this.setRotateAngle(LbackForeleg, 0.0F, 0.0F, 0.9948376736367678F);
		this.LPincer = new ModelRenderer(this, 33, 16);
		this.LPincer.setRotationPoint(4.5F, 0.0F, -0.5F);
		this.LPincer.addBox(0.0F, -1.5F, -1.5F, 6, 4, 4, 0.0F);
		this.setRotateAngle(LPincer, 0.0F, 0.7155849933176751F, 0.0F);
		this.RclawBot = new ModelRenderer(this, 1, 28);
		this.RclawBot.setRotationPoint(-5.8F, 2.7F, 0.5F);
		this.RclawBot.addBox(-5.0F, -1.5F, -1.0F, 5, 1, 2, 0.0F);
		this.setRotateAngle(RclawBot, 0.0F, 0.0F, 0.04363323129985824F);
		this.RPincer = new ModelRenderer(this, 33, 24);
		this.RPincer.setRotationPoint(-4.5F, 0.0F, -0.5F);
		this.RPincer.addBox(-6.0F, -1.5F, -1.5F, 6, 4, 4, 0.0F);
		this.setRotateAngle(RPincer, 0.0F, -0.7285004297824331F, 0.0F);
		this.RfrontLeg = new ModelRenderer(this, 59, 43);
		this.RfrontLeg.mirror = true;
		this.RfrontLeg.setRotationPoint(-4.5F, 17.0F, -3.0F);
		this.RfrontLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(RfrontLeg, -0.22689280275926282F, -0.7853981633974483F, 0.3490658503988659F);
		this.LForearm = new ModelRenderer(this, 8, 21);
		this.LForearm.setRotationPoint(5.5F, 0.0F, 0.0F);
		this.LForearm.addBox(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
		this.setRotateAngle(LForearm, 0.0F, 1.3089969389957472F, 0.0F);
		this.Carapace = new ModelRenderer(this, 31, 0);
		this.Carapace.setRotationPoint(0.0F, 15.7F, 0.0F);
		this.Carapace.addBox(-4.5F, -3.5F, -4.0F, 9, 6, 7, 0.0F);
		this.setRotateAngle(Carapace, 0.091106186954104F, 0.0F, 0.0F);
		this.LmiddleForeleg = new ModelRenderer(this, 59, 38);
		this.LmiddleForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
		this.LmiddleForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
		this.setRotateAngle(LmiddleForeleg, 0.0F, 0.0F, 0.9948376736367678F);
		this.RclawTop = new ModelRenderer(this, 1, 28);
		this.RclawTop.setRotationPoint(-5.8F, 0.0F, 0.5F);
		this.RclawTop.addBox(-5.0F, -1.5F, -1.0F, 5, 1, 2, 0.0F);
		this.setRotateAngle(RclawTop, 0.0F, 0.0F, -0.18203784098300857F);
		this.tailSeg2_1 = new ModelRenderer(this, 40, 34);
		this.tailSeg2_1.setRotationPoint(0.0F, -8.2F, 0.8F);
		this.tailSeg2_1.addBox(-2.0F, -8.1F, -2.0F, 4, 9, 3, 0.0F);
		this.setRotateAngle(tailSeg2_1, 0.5009094953223726F, 0.0F, 0.0F);
		this.RbackForeleg = new ModelRenderer(this, 59, 38);
		this.RbackForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
		this.RbackForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
		this.setRotateAngle(RbackForeleg, 0.0F, 0.0F, 2.1467549799530254F);
		this.RmiddleLeg.addChild(this.RmiddleForeleg);
		this.LfrontLeg.addChild(this.LfrontForeleg);
		this.LmiddleLeg.addChild(this.LmiddleForeleg);
		this.Carapace.addChild(this.Abdomen);
		this.tailSeg1.addChild(this.tailSeg2);
		this.Head.addChild(this.RArm);
		this.RArm.addChild(this.RForearm);
		this.tailSeg2_1.addChild(this.Stinger);
		this.LfarthestLeg.addChild(this.LfarthestForeleg);
		this.tailSeg2.addChild(this.tailSeg2_1);
		this.Head.addChild(this.LEye);
		this.Head.addChild(this.REye);
		this.RbackLeg.addChild(this.RbackForeleg);
		this.RfrontLeg.addChild(this.RfrontForeleg);
		this.RfarthestLeg.addChild(this.RfarthestForeleg);
		this.LPincer.addChild(this.LclawTop);
		this.RPincer.addChild(this.RclawBot);
		this.Stinger.addChild(this.stingerEnd);
		this.LPincer.addChild(this.LclawBot);
		this.Head.addChild(this.LfrontEye);
		this.RPincer.addChild(this.RclawTop);
		this.LArm.addChild(this.LForearm);
		this.LbackLeg.addChild(this.LbackForeleg);
		this.RForearm.addChild(this.RPincer);
		this.Head.addChild(this.RfrontEye);
		this.Head.addChild(this.LArm);
		this.Carapace.addChild(this.Head);
		this.Abdomen.addChild(this.Rear);
		this.Rear.addChild(this.tailSeg1);
		this.LForearm.addChild(this.LPincer);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.LfarthestLeg.render(f5);
		this.RmiddleLeg.render(f5);
		this.RfarthestLeg.render(f5);
		this.Carapace.render(f5);
		this.LfrontLeg.render(f5);
		this.RbackLeg.render(f5);
		this.LmiddleLeg.render(f5);
		this.RfrontLeg.render(f5);
		this.LbackLeg.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		EntityScorpion scorpion = (EntityScorpion) entityIn;
		if (scorpion.isBesideClimbableBlock() && scorpion.posY > scorpion.prevPosY) {
			final float armSwing = ageInTicks * 0.4f;
			final float legSpeed = 1.1f;
			final float varY = MathHelper.sin(armSwing * legSpeed) * 0.65f * limbSwingAmount;
			final float varZ = Math.abs(MathHelper.cos(armSwing * legSpeed)) * 0.8f * limbSwingAmount;
			
			this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
			this.Head.rotateAngleX = headPitch * 0.017453292F - 0.085f;

			this.LfrontLeg.rotateAngleZ = -0.35F + varZ;
			this.LmiddleLeg.rotateAngleZ = -0.23F + varZ;
			this.LbackLeg.rotateAngleZ = -0.23F + varZ;
			this.LfarthestLeg.rotateAngleZ = -0.31F + varZ;
			this.RfrontLeg.rotateAngleZ = 0.35F - varZ;
			this.RmiddleLeg.rotateAngleZ = 0.23F - varZ;
			this.RbackLeg.rotateAngleZ = 0.23F - varZ;
			this.RfarthestLeg.rotateAngleZ = 0.31F - varZ;

			this.LfrontLeg.rotateAngleY = 0.78F + varY;
			this.LmiddleLeg.rotateAngleY = -0.38F - varY;
			this.LbackLeg.rotateAngleY = -0.38F + varY;
			this.LfarthestLeg.rotateAngleY = -0.78F - varY;
			this.RfrontLeg.rotateAngleY = -0.78F + varY;
			this.RmiddleLeg.rotateAngleY = 0.38F - varY;
			this.RbackLeg.rotateAngleY = 0.38F + varY;
			this.RfarthestLeg.rotateAngleY = 0.78F - varY;

		} else {

			final float legSpeed = 1.1f;
			final float varY = MathHelper.sin(limbSwing * legSpeed) * 0.65f * limbSwingAmount;
			final float varZ = Math.abs(MathHelper.cos(limbSwing * legSpeed)) * 0.3f * limbSwingAmount;
			
			this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
			this.Head.rotateAngleX = headPitch * 0.017453292F - 0.085f;

			this.LfrontLeg.rotateAngleZ = -0.35F + varZ;
			this.LmiddleLeg.rotateAngleZ = -0.23F + varZ;
			this.LbackLeg.rotateAngleZ = -0.23F + varZ;
			this.LfarthestLeg.rotateAngleZ = -0.31F + varZ;
			this.RfrontLeg.rotateAngleZ = 0.35F - varZ;
			this.RmiddleLeg.rotateAngleZ = 0.23F + varZ;
			this.RbackLeg.rotateAngleZ = 0.23F - varZ;
			this.RfarthestLeg.rotateAngleZ = 0.31F - varZ;

			this.LfrontLeg.rotateAngleY = 0.78F + varY;
			this.LmiddleLeg.rotateAngleY = 0.38F - varY;
			this.LbackLeg.rotateAngleY = -0.38F + varY;
			this.LfarthestLeg.rotateAngleY = -0.78F - varY;
			this.RfrontLeg.rotateAngleY = -0.78F + varY;
			this.RmiddleLeg.rotateAngleY = -0.38F - varY;
			this.RbackLeg.rotateAngleY = 0.38F + varY;
			this.RfarthestLeg.rotateAngleY = 0.78F - varY;
		}
	}

	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTickTime) {
		EntityScorpion entity = (EntityScorpion) entitylivingbaseIn;
		int i = entity.getAttackTimer();

		if (i > 0) {
			this.RArm.rotateAngleY = 0.27F * -this.triangleWave((float) i - partialTickTime, 15.0F);
			this.LArm.rotateAngleY = -0.27F * -this.triangleWave((float) i - partialTickTime, 15.0F);
			this.Rear.rotateAngleX = 1.0F * -this.triangleWaveTail((float) i - partialTickTime, 10.0F);
			this.Stinger.rotateAngleX = 0.87F;
		} else {
			this.RArm.rotateAngleY = 0.2792526803190927F;
			this.LArm.rotateAngleY = -0.2792526803190927F;
			this.Rear.rotateAngleX = 0.27314402793711257F;
			this.Stinger.rotateAngleX = 1.9123572614101867F;
		}
	}

	private float triangleWave(float time, float speed) {
		return (Math.abs(time % speed - speed * 0.5F) - speed * 0.73F) / (speed * 0.73F);
	}

	private float triangleWaveTail(float time, float speed) {
		return (Math.abs(time % speed - speed * 0.5F) - speed * 0.25F) / (speed * 0.25F);
	}
}