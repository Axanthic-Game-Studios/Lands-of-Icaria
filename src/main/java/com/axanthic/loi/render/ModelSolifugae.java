package com.axanthic.loi.render;

import com.axanthic.loi.entity.EntitySolifugae;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * ModelSolifugae - Xenoform
 * Created using Tabula 7.0.0
 */
public class ModelSolifugae extends ModelBase {

    public ModelRenderer Carapace;
    public ModelRenderer LmiddleLeg;
    public ModelRenderer LbackLeg;
    public ModelRenderer LfrontLeg;
    public ModelRenderer LfarthestLeg;
    public ModelRenderer RbackLeg;
    public ModelRenderer RmiddleLeg;
    public ModelRenderer RfarthestLeg;
    public ModelRenderer RfrontLeg;
    public ModelRenderer Abdomen;
    public ModelRenderer Head;
    public ModelRenderer LTusk;
    public ModelRenderer RTusk;
    public ModelRenderer LJaw;
    public ModelRenderer RJaw;
    public ModelRenderer LEye;
    public ModelRenderer REye;
    public ModelRenderer LJaw2;
    public ModelRenderer LTopFang;
    public ModelRenderer LBotFang;
    public ModelRenderer RJaw2;
    public ModelRenderer RTopFang;
    public ModelRenderer RBotFang;
    public ModelRenderer LmiddleForeleg;
    public ModelRenderer LbackForeleg;
    public ModelRenderer LfrontForeleg;
    public ModelRenderer LfarthestForeleg;
    public ModelRenderer RbackForeleg;
    public ModelRenderer RmiddleForeleg;
    public ModelRenderer RfarthestForeleg;
    public ModelRenderer RfrontForeleg;



    public ModelSolifugae() {
        this.textureWidth = 120;
        this.textureHeight = 60;
        this.RTopFang = new ModelRenderer(this, 41, 28);
        this.RTopFang.setRotationPoint(0.4F, -1.0F, -3.0F);
        this.RTopFang.addBox(-1.0F, -0.5F, -4.5F, 2, 1, 5, 0.0F);
        this.setRotateAngle(RTopFang, 0.17453292519943295F, 0.0F, 0.0F);
        this.RfrontForeleg = new ModelRenderer(this, 59, 41);
        this.RfrontForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
        this.RfrontForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(RfrontForeleg, 0.0F, 0.0F, 2.0943951023931953F);
        this.LTopFang = new ModelRenderer(this, 41, 43);
        this.LTopFang.setRotationPoint(-0.2F, -1.0F, -3.0F);
        this.LTopFang.addBox(-1.0F, -0.5F, -4.5F, 2, 1, 5, 0.0F);
        this.setRotateAngle(LTopFang, 0.17453292519943295F, 0.0F, 0.0F);
        this.RfrontLeg = new ModelRenderer(this, 59, 46);
        this.RfrontLeg.mirror = true;
        this.RfrontLeg.setRotationPoint(-4.5F, 17.0F, -3.0F);
        this.RfrontLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(RfrontLeg, -0.22689280275926282F, -0.7853981633974483F, 0.3490658503988659F);
        this.LmiddleForeleg = new ModelRenderer(this, 59, 41);
        this.LmiddleForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
        this.LmiddleForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(LmiddleForeleg, 0.0F, 0.0F, 0.9948376736367678F);
        this.RJaw = new ModelRenderer(this, 0, 31);
        this.RJaw.setRotationPoint(-2.0F, -1.5F, -9.0F);
        this.RJaw.addBox(-2.0F, -2.5F, -4.5F, 4, 6, 5, 0.0F);
        this.setRotateAngle(RJaw, 0.09599310885968812F, 0.0F, 0.0F);
        this.LBotFang = new ModelRenderer(this, 41, 50);
        this.LBotFang.setRotationPoint(-0.2F, 2.0F, -3.0F);
        this.LBotFang.addBox(-1.0F, -0.5F, -4.5F, 2, 1, 5, 0.0F);
        this.setRotateAngle(LBotFang, -0.17453292519943295F, 0.0F, 0.0F);
        this.RTusk = new ModelRenderer(this, 60, 29);
        this.RTusk.setRotationPoint(-3.5F, -0.4F, -3.5F);
        this.RTusk.addBox(-24.0F, -1.0F, -1.0F, 25, 2, 2, 0.0F);
        this.setRotateAngle(RTusk, 0.0F, -1.1344640137963142F, -0.2617993877991494F);
        this.LfrontLeg = new ModelRenderer(this, 59, 46);
        this.LfrontLeg.setRotationPoint(4.5F, 17.0F, -3.0F);
        this.LfrontLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(LfrontLeg, -0.22689280275926282F, 0.7853981633974483F, -0.3141592653589793F);
        this.LJaw2 = new ModelRenderer(this, 23, 43);
        this.LJaw2.setRotationPoint(-0.5F, 0.0F, -4.5F);
        this.LJaw2.addBox(-1.5F, -2.0F, -3.0F, 3, 5, 3, 0.0F);
        this.RBotFang = new ModelRenderer(this, 41, 35);
        this.RBotFang.setRotationPoint(0.4F, 2.0F, -3.0F);
        this.RBotFang.addBox(-1.0F, -0.5F, -4.5F, 2, 1, 5, 0.0F);
        this.setRotateAngle(RBotFang, -0.17453292519943295F, 0.0F, 0.0F);
        this.LfrontForeleg = new ModelRenderer(this, 59, 41);
        this.LfrontForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
        this.LfrontForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(LfrontForeleg, 0.0F, 0.0F, 0.9948376736367678F);
        this.RmiddleLeg = new ModelRenderer(this, 59, 46);
        this.RmiddleLeg.mirror = true;
        this.RmiddleLeg.setRotationPoint(-4.5F, 17.0F, -1.3F);
        this.RmiddleLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(RmiddleLeg, -0.091106186954104F, -0.3839724354387525F, 0.22689280275926282F);
        this.LbackLeg = new ModelRenderer(this, 59, 46);
        this.LbackLeg.setRotationPoint(4.5F, 17.0F, -0.3F);
        this.LbackLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(LbackLeg, 0.091106186954104F, -0.3839724354387525F, -0.22689280275926282F);
        this.REye = new ModelRenderer(this, 0, 2);
        this.REye.setRotationPoint(-0.7F, -4.7F, -8.7F);
        this.REye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.RbackLeg = new ModelRenderer(this, 59, 46);
        this.RbackLeg.mirror = true;
        this.RbackLeg.setRotationPoint(-4.5F, 17.0F, -0.3F);
        this.RbackLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(RbackLeg, 0.091106186954104F, 0.3839724354387525F, 0.22689280275926282F);
        this.LmiddleLeg = new ModelRenderer(this, 59, 46);
        this.LmiddleLeg.setRotationPoint(4.5F, 17.0F, -1.3F);
        this.LmiddleLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(LmiddleLeg, -0.091106186954104F, 0.3839724354387525F, -0.22689280275926282F);
        this.Abdomen = new ModelRenderer(this, 39, 0);
        this.Abdomen.setRotationPoint(0.0F, 0.4F, 3.5F);
        this.Abdomen.addBox(-6.0F, -5.0F, -0.3F, 12, 8, 19, 0.0F);
        this.setRotateAngle(Abdomen, 0.091106186954104F, 0.0F, 0.0F);
        this.RJaw2 = new ModelRenderer(this, 4, 43);
        this.RJaw2.setRotationPoint(0.5F, 0.0F, -4.5F);
        this.RJaw2.addBox(-1.5F, -2.0F, -3.0F, 3, 5, 3, 0.0F);
        this.LJaw = new ModelRenderer(this, 20, 31);
        this.LJaw.setRotationPoint(2.0F, -1.5F, -9.0F);
        this.LJaw.addBox(-2.0F, -2.5F, -4.5F, 4, 6, 5, 0.0F);
        this.setRotateAngle(LJaw, 0.09599310885968812F, 0.0F, 0.0F);
        this.Carapace = new ModelRenderer(this, 2, 0);
        this.Carapace.setRotationPoint(0.0F, 16.5F, 1.0F);
        this.Carapace.addBox(-4.5F, -2.5F, -4.0F, 9, 4, 7, 0.0F);
        this.LfarthestForeleg = new ModelRenderer(this, 59, 41);
        this.LfarthestForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
        this.LfarthestForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(LfarthestForeleg, 0.0F, 0.0F, 0.9948376736367678F);
        this.RbackForeleg = new ModelRenderer(this, 59, 41);
        this.RbackForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
        this.RbackForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(RbackForeleg, 0.0F, 0.0F, 2.1467549799530254F);
        this.RmiddleForeleg = new ModelRenderer(this, 59, 41);
        this.RmiddleForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
        this.RmiddleForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(RmiddleForeleg, 0.0F, 0.0F, 2.1467549799530254F);
        this.Head = new ModelRenderer(this, 0, 14);
        this.Head.setRotationPoint(0.0F, 0.5F, -3.0F);
        this.Head.addBox(-5.0F, -5.0F, -9.0F, 10, 8, 8, 0.0F);
        this.LbackForeleg = new ModelRenderer(this, 59, 41);
        this.LbackForeleg.setRotationPoint(6.8F, 0.1F, 0.0F);
        this.LbackForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(LbackForeleg, 0.0F, 0.0F, 0.9948376736367678F);
        this.LEye = new ModelRenderer(this, 0, 0);
        this.LEye.setRotationPoint(0.7F, -4.7F, -8.7F);
        this.LEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.LTusk = new ModelRenderer(this, 60, 34);
        this.LTusk.setRotationPoint(3.5F, -0.4F, -3.5F);
        this.LTusk.addBox(-1.0F, -1.0F, -1.0F, 25, 2, 2, 0.0F);
        this.setRotateAngle(LTusk, 0.0F, 1.1344640137963142F, 0.2617993877991494F);
        this.LfarthestLeg = new ModelRenderer(this, 59, 46);
        this.LfarthestLeg.setRotationPoint(4.5F, 17.0F, 1.5F);
        this.LfarthestLeg.addBox(-1.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(LfarthestLeg, 0.22689280275926282F, -0.7853981633974483F, -0.3141592653589793F);
        this.RfarthestLeg = new ModelRenderer(this, 58, 46);
        this.RfarthestLeg.mirror = true;
        this.RfarthestLeg.setRotationPoint(-4.5F, 17.0F, 1.3F);
        this.RfarthestLeg.addBox(-7.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(RfarthestLeg, 0.22689280275926282F, 0.7853981633974483F, 0.3141592653589793F);
        this.RfarthestForeleg = new ModelRenderer(this, 59, 41);
        this.RfarthestForeleg.setRotationPoint(-6.8F, 0.1F, 0.0F);
        this.RfarthestForeleg.addBox(-0.5F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(RfarthestForeleg, 0.0F, 0.0F, 2.1467549799530254F);
        this.RJaw2.addChild(this.RTopFang);
        this.RfrontLeg.addChild(this.RfrontForeleg);
        this.LJaw2.addChild(this.LTopFang);
        this.LmiddleLeg.addChild(this.LmiddleForeleg);
        this.Head.addChild(this.RJaw);
        this.LJaw2.addChild(this.LBotFang);
        this.Head.addChild(this.RTusk);
        this.LJaw.addChild(this.LJaw2);
        this.RJaw2.addChild(this.RBotFang);
        this.LfrontLeg.addChild(this.LfrontForeleg);
        this.Head.addChild(this.REye);
        this.Carapace.addChild(this.Abdomen);
        this.RJaw.addChild(this.RJaw2);
        this.Head.addChild(this.LJaw);
        this.LfarthestLeg.addChild(this.LfarthestForeleg);
        this.RbackLeg.addChild(this.RbackForeleg);
        this.RmiddleLeg.addChild(this.RmiddleForeleg);
        this.Carapace.addChild(this.Head);
        this.LbackLeg.addChild(this.LbackForeleg);
        this.Head.addChild(this.LEye);
        this.Head.addChild(this.LTusk);
        this.RfarthestLeg.addChild(this.RfarthestForeleg);
	}

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		GlStateManager.pushMatrix();
        this.RfrontLeg.render(f5);
        this.LfrontLeg.render(f5);
        this.RmiddleLeg.render(f5);
        this.LbackLeg.render(f5);
        this.RbackLeg.render(f5);
        this.LmiddleLeg.render(f5);
        this.Carapace.render(f5);
        this.LfarthestLeg.render(f5);
        this.RfarthestLeg.render(f5);
        GlStateManager.popMatrix();
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

		EntitySolifugae scorpion = (EntitySolifugae) entityIn;
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
		EntitySolifugae entity = (EntitySolifugae) entitylivingbaseIn;
		boolean charging = entity.isCharging();
		if (charging == true) {
			this.Abdomen.rotateAngleX = 0.25F;
			this.LBotFang.rotateAngleX = 0.65F;
			this.RBotFang.rotateAngleX = 0.65F;
		} else {
			this.Abdomen.rotateAngleX = 0.0F;
			this.LBotFang.rotateAngleX = -0.3F;
			this.RBotFang.rotateAngleX = -0.3F;
		}
	}
}
