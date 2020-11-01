package com.axanthic.loi.render;

import com.axanthic.loi.entity.EntityWhipSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelWhipSpider - xenoform55
 * Created using Tabula 7.1.0
 */
public class ModelWhipSpider extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer Abdomen;
    public ModelRenderer LmiddleLeg;
    public ModelRenderer LbackLeg;
    public ModelRenderer LhindLeg;
    public ModelRenderer RmiddleLeg;
    public ModelRenderer RbackLeg;
    public ModelRenderer RhindLeg;
    public ModelRenderer RfeelerLeg;
    public ModelRenderer LfeelerLeg;
    public ModelRenderer Rarm1;
    public ModelRenderer Larm1;
    public ModelRenderer RFrontEye;
    public ModelRenderer LFrontEye;
    public ModelRenderer RBackEyes;
    public ModelRenderer LBackEyes;
    public ModelRenderer Relbow;
    public ModelRenderer Rarm2;
    public ModelRenderer Rclaw;
    public ModelRenderer Rpoker;
    public ModelRenderer RpokerExt;
    public ModelRenderer Lelbow;
    public ModelRenderer Larm2;
    public ModelRenderer Lclaw;
    public ModelRenderer Lpoker;
    public ModelRenderer LpokerExt;
    public ModelRenderer Abdomen1;
    public ModelRenderer Abdomen3;
    public ModelRenderer Abdomen4;
    public ModelRenderer LmiddleForeleg;
    public ModelRenderer LbackForeleg;
    public ModelRenderer LhindForeleg;
    public ModelRenderer RmiddleForeleg;
    public ModelRenderer RbackForeleg;
    public ModelRenderer RhindForeleg;
    public ModelRenderer RmiddleForeleg_1;
    public ModelRenderer LmiddleForeleg_1;

    public ModelWhipSpider() {
        this.textureWidth = 100;
        this.textureHeight = 70;
        this.LFrontEye = new ModelRenderer(this, 50, 25);
        this.LFrontEye.setRotationPoint(0.7F, 0.3F, -9.0F);
        this.LFrontEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Lelbow = new ModelRenderer(this, 61, 38);
        this.Lelbow.setRotationPoint(23.5F, 0.0F, -0.5F);
        this.Lelbow.addBox(-1.5F, -1.5F, -3.5F, 3, 3, 5, 0.0F);
        this.Larm2 = new ModelRenderer(this, 0, 40);
        this.Larm2.mirror = true;
        this.Larm2.setRotationPoint(-0.5F, 0.0F, -2.5F);
        this.Larm2.addBox(-25.5F, -1.5F, -1.5F, 27, 3, 3, 0.0F);
        this.setRotateAngle(Larm2, 0.0F, -0.18203784098300857F, 0.0F);
        this.Lclaw = new ModelRenderer(this, 80, 42);
        this.Lclaw.setRotationPoint(-25.0F, 0.0F, -0.5F);
        this.Lclaw.addBox(-3.5F, -1.5F, -0.9F, 4, 3, 2, 0.0F);
        this.setRotateAngle(Lclaw, 0.0F, 0.9948376736367678F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Body.addBox(-8.5F, 0.0F, -5.5F, 17, 5, 11, 0.0F);
        this.LBackEyes = new ModelRenderer(this, 50, 20);
        this.LBackEyes.setRotationPoint(3.7F, 0.3F, -6.7F);
        this.LBackEyes.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.LpokerExt = new ModelRenderer(this, 82, 38);
        this.LpokerExt.setRotationPoint(-1.8F, 0.0F, 0.0F);
        this.LpokerExt.addBox(-2.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.LmiddleForeleg = new ModelRenderer(this, 0, 54);
        this.LmiddleForeleg.setRotationPoint(19.6F, 0.0F, 0.0F);
        this.LmiddleForeleg.addBox(-0.5F, -1.5F, -1.0F, 32, 2, 2, 0.0F);
        this.setRotateAngle(LmiddleForeleg, 0.0F, 0.0F, 0.6981317007977318F);
        this.Relbow = new ModelRenderer(this, 61, 38);
        this.Relbow.setRotationPoint(-23.5F, 0.0F, -0.5F);
        this.Relbow.addBox(-1.5F, -1.5F, -3.5F, 3, 3, 5, 0.0F);
        this.LmiddleLeg = new ModelRenderer(this, 0, 47);
        this.LmiddleLeg.setRotationPoint(8.0F, 2.5F, -3.0F);
        this.LmiddleLeg.addBox(-1.0F, -1.5F, -1.5F, 21, 3, 3, 0.0F);
        this.setRotateAngle(LmiddleLeg, -0.091106186954104F, 0.08726646259971647F, -0.22689280275926282F);
        this.RbackForeleg = new ModelRenderer(this, 0, 54);
        this.RbackForeleg.setRotationPoint(-19.2F, -0.7F, 0.0F);
        this.RbackForeleg.addBox(-0.5F, -1.5F, -1.0F, 32, 2, 2, 0.0F);
        this.setRotateAngle(RbackForeleg, 0.0F, 0.0F, 2.504198410761464F);
        this.Rclaw = new ModelRenderer(this, 80, 42);
        this.Rclaw.mirror = true;
        this.Rclaw.setRotationPoint(25.0F, 0.0F, -0.5F);
        this.Rclaw.addBox(-0.5F, -1.5F, -0.9F, 4, 3, 2, 0.0F);
        this.setRotateAngle(Rclaw, 0.0F, -0.9948376736367678F, 0.0F);
        this.RFrontEye = new ModelRenderer(this, 50, 25);
        this.RFrontEye.setRotationPoint(-0.7F, 0.3F, -9.0F);
        this.RFrontEye.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Rpoker = new ModelRenderer(this, 75, 38);
        this.Rpoker.setRotationPoint(3.5F, 0.0F, 0.1F);
        this.Rpoker.addBox(-0.5F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(Rpoker, 0.0F, -0.7285004297824331F, 0.0F);
        this.Abdomen4 = new ModelRenderer(this, 58, 30);
        this.Abdomen4.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Abdomen4.addBox(-5.0F, -2.0F, 0.0F, 10, 4, 2, 0.0F);
        this.RBackEyes = new ModelRenderer(this, 50, 20);
        this.RBackEyes.setRotationPoint(-3.7F, 0.3F, -6.7F);
        this.RBackEyes.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.RhindForeleg = new ModelRenderer(this, 0, 54);
        this.RhindForeleg.setRotationPoint(-19.2F, -0.7F, 0.0F);
        this.RhindForeleg.addBox(-0.5F, -1.5F, -1.0F, 32, 2, 2, 0.0F);
        this.setRotateAngle(RhindForeleg, 0.0F, 0.0F, 2.4586453172844123F);
        this.Rarm2 = new ModelRenderer(this, 0, 40);
        this.Rarm2.setRotationPoint(0.5F, 0.0F, -2.5F);
        this.Rarm2.addBox(-1.5F, -1.5F, -1.5F, 27, 3, 3, 0.0F);
        this.setRotateAngle(Rarm2, 0.0F, 0.18203784098300857F, 0.0F);
        this.Abdomen = new ModelRenderer(this, 59, 0);
        this.Abdomen.setRotationPoint(0.0F, 2.5F, 5.5F);
        this.Abdomen.addBox(-6.0F, -2.0F, -0.3F, 12, 4, 4, 0.0F);
        this.setRotateAngle(Abdomen, 0.136659280431156F, 0.0F, 0.0F);
        this.Rarm1 = new ModelRenderer(this, 0, 33);
        this.Rarm1.setRotationPoint(-4.5F, 2.5F, -10.0F);
        this.Rarm1.addBox(-24.5F, -1.5F, -1.5F, 26, 3, 3, 0.0F);
        this.setRotateAngle(Rarm1, 0.0F, 0.1308996938995747F, 0.0F);
        this.Larm1 = new ModelRenderer(this, 0, 33);
        this.Larm1.mirror = true;
        this.Larm1.setRotationPoint(4.5F, 2.5F, -10.0F);
        this.Larm1.addBox(-1.5F, -1.5F, -1.5F, 26, 3, 3, 0.0F);
        this.setRotateAngle(Larm1, 0.0F, -0.1308996938995747F, 0.0F);
        this.RmiddleForeleg_1 = new ModelRenderer(this, 0, 64);
        this.RmiddleForeleg_1.setRotationPoint(-27.0F, -0.3F, 0.0F);
        this.RmiddleForeleg_1.addBox(-0.5F, -1.5F, -1.0F, 45, 2, 2, 0.0F);
        this.setRotateAngle(RmiddleForeleg_1, 0.0F, 0.0F, 2.443460952792061F);
        this.LbackForeleg = new ModelRenderer(this, 0, 54);
        this.LbackForeleg.setRotationPoint(19.4F, 0.0F, 0.0F);
        this.LbackForeleg.addBox(-0.5F, -1.5F, -1.0F, 32, 2, 2, 0.0F);
        this.setRotateAngle(LbackForeleg, 0.0F, 0.0F, 0.6373942428283291F);
        this.LhindForeleg = new ModelRenderer(this, 0, 54);
        this.LhindForeleg.setRotationPoint(19.4F, 0.1F, 0.0F);
        this.LhindForeleg.addBox(-0.5F, -1.5F, -1.0F, 32, 2, 2, 0.0F);
        this.setRotateAngle(LhindForeleg, 0.0F, 0.0F, 0.6829473363053812F);
        this.LhindLeg = new ModelRenderer(this, 0, 47);
        this.LhindLeg.setRotationPoint(8.0F, 2.5F, 4.0F);
        this.LhindLeg.addBox(-1.0F, -1.5F, -1.5F, 21, 3, 3, 0.0F);
        this.setRotateAngle(LhindLeg, 0.6108652381980153F, -1.2217304763960306F, -0.6981317007977318F);
        this.Abdomen1 = new ModelRenderer(this, 58, 9);
        this.Abdomen1.setRotationPoint(0.0F, 0.0F, 3.7F);
        this.Abdomen1.addBox(-6.5F, -2.0F, 0.0F, 13, 4, 8, 0.0F);
        this.LfeelerLeg = new ModelRenderer(this, 0, 59);
        this.LfeelerLeg.setRotationPoint(8.0F, 2.0F, -4.6F);
        this.LfeelerLeg.addBox(-27.0F, -1.0F, -1.0F, 30, 2, 2, 0.0F);
        this.setRotateAngle(LfeelerLeg, 0.22584560520806624F, -2.373647782712288F, -0.4553564018453205F);
        this.LmiddleForeleg_1 = new ModelRenderer(this, 0, 64);
        this.LmiddleForeleg_1.setRotationPoint(-27.0F, -0.3F, 0.0F);
        this.LmiddleForeleg_1.addBox(-0.5F, -1.5F, -1.0F, 45, 2, 2, 0.0F);
        this.setRotateAngle(LmiddleForeleg_1, 0.0F, 0.0F, 2.443460952792061F);
        this.Abdomen3 = new ModelRenderer(this, 58, 22);
        this.Abdomen3.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.Abdomen3.addBox(-6.0F, -2.0F, 0.0F, 12, 4, 3, 0.0F);
        this.RmiddleLeg = new ModelRenderer(this, 0, 47);
        this.RmiddleLeg.mirror = true;
        this.RmiddleLeg.setRotationPoint(-8.0F, 2.5F, -3.0F);
        this.RmiddleLeg.addBox(-19.0F, -1.5F, -1.5F, 21, 3, 3, 0.0F);
        this.setRotateAngle(RmiddleLeg, -0.091106186954104F, -0.08726646259971647F, 0.22689280275926282F);
        this.RpokerExt = new ModelRenderer(this, 82, 38);
        this.RpokerExt.setRotationPoint(1.8F, 0.0F, 0.0F);
        this.RpokerExt.addBox(-0.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.RbackLeg = new ModelRenderer(this, 0, 47);
        this.RbackLeg.mirror = true;
        this.RbackLeg.setRotationPoint(-8.0F, 2.5F, 0.5F);
        this.RbackLeg.addBox(-19.0F, -1.5F, -1.5F, 21, 3, 3, 0.0F);
        this.setRotateAngle(RbackLeg, 0.091106186954104F, 0.4363323129985824F, 0.22689280275926282F);
        this.RfeelerLeg = new ModelRenderer(this, 0, 59);
        this.RfeelerLeg.mirror = true;
        this.RfeelerLeg.setRotationPoint(-8.0F, 2.0F, -4.6F);
        this.RfeelerLeg.addBox(-27.0F, -1.0F, -1.0F, 30, 2, 2, 0.0F);
        this.setRotateAngle(RfeelerLeg, -0.22759093446006054F, -0.767944870877505F, 0.4553564018453205F);
        this.RmiddleForeleg = new ModelRenderer(this, 0, 54);
        this.RmiddleForeleg.setRotationPoint(-19.2F, -0.7F, 0.0F);
        this.RmiddleForeleg.addBox(-0.5F, -1.5F, -1.0F, 32, 2, 2, 0.0F);
        this.setRotateAngle(RmiddleForeleg, 0.0F, 0.0F, 2.443460952792061F);
        this.Head = new ModelRenderer(this, 0, 18);
        this.Head.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Head.addBox(-7.0F, 0.0F, -10.0F, 14, 5, 8, 0.0F);
        this.LbackLeg = new ModelRenderer(this, 0, 47);
        this.LbackLeg.setRotationPoint(8.0F, 2.5F, 0.5F);
        this.LbackLeg.addBox(-1.0F, -1.5F, -1.5F, 21, 3, 3, 0.0F);
        this.setRotateAngle(LbackLeg, 0.091106186954104F, -0.4363323129985824F, -0.22689280275926282F);
        this.RhindLeg = new ModelRenderer(this, 0, 47);
        this.RhindLeg.mirror = true;
        this.RhindLeg.setRotationPoint(-8.0F, 2.5F, 4.6F);
        this.RhindLeg.addBox(-19.0F, -1.5F, -1.5F, 21, 3, 3, 0.0F);
        this.setRotateAngle(RhindLeg, 0.6108652381980153F, 1.2217304763960306F, 0.6981317007977318F);
        this.Lpoker = new ModelRenderer(this, 75, 38);
        this.Lpoker.setRotationPoint(-3.5F, 0.0F, 0.1F);
        this.Lpoker.addBox(-1.5F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(Lpoker, 0.0F, 0.7285004297824331F, 0.0F);
        this.Head.addChild(this.LFrontEye);
        this.Larm1.addChild(this.Lelbow);
        this.Lelbow.addChild(this.Larm2);
        this.Larm2.addChild(this.Lclaw);
        this.Head.addChild(this.LBackEyes);
        this.Lpoker.addChild(this.LpokerExt);
        this.LmiddleLeg.addChild(this.LmiddleForeleg);
        this.Rarm1.addChild(this.Relbow);
        this.Body.addChild(this.LmiddleLeg);
        this.RbackLeg.addChild(this.RbackForeleg);
        this.Rarm2.addChild(this.Rclaw);
        this.Head.addChild(this.RFrontEye);
        this.Rclaw.addChild(this.Rpoker);
        this.Abdomen3.addChild(this.Abdomen4);
        this.Head.addChild(this.RBackEyes);
        this.RhindLeg.addChild(this.RhindForeleg);
        this.Relbow.addChild(this.Rarm2);
        this.Body.addChild(this.Abdomen);
        this.Head.addChild(this.Rarm1);
        this.Head.addChild(this.Larm1);
        this.RfeelerLeg.addChild(this.RmiddleForeleg_1);
        this.LbackLeg.addChild(this.LbackForeleg);
        this.LhindLeg.addChild(this.LhindForeleg);
        this.Body.addChild(this.LhindLeg);
        this.Abdomen.addChild(this.Abdomen1);
        this.Body.addChild(this.LfeelerLeg);
        this.LfeelerLeg.addChild(this.LmiddleForeleg_1);
        this.Abdomen1.addChild(this.Abdomen3);
        this.Body.addChild(this.RmiddleLeg);
        this.Rpoker.addChild(this.RpokerExt);
        this.Body.addChild(this.RbackLeg);
        this.Body.addChild(this.RfeelerLeg);
        this.RmiddleLeg.addChild(this.RmiddleForeleg);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.LbackLeg);
        this.Body.addChild(this.RhindLeg);
        this.Lclaw.addChild(this.Lpoker);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        this.Body.render(f5);
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

        EntityWhipSpider whipSpider = (EntityWhipSpider) entityIn;
        if (whipSpider.isBesideClimbableBlock() && whipSpider.posY > whipSpider.prevPosY) {
            final float armSwing = ageInTicks * 0.4f;
            final float legSpeed = 1.1f;
            final float varY = MathHelper.sin(armSwing * legSpeed) * 0.65f * limbSwingAmount;
            final float varZ = Math.abs(MathHelper.cos(armSwing * legSpeed)) * 0.8f * limbSwingAmount;

            this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
            this.Head.rotateAngleX = headPitch * 0.017453292F - 0.085f;

            this.LmiddleLeg.rotateAngleZ = -0.23F + varZ;
            this.LbackLeg.rotateAngleZ = -0.23F + varZ;
            this.LhindLeg.rotateAngleZ = -0.31F + varZ;
            this.RmiddleLeg.rotateAngleZ = 0.23F - varZ;
            this.RbackLeg.rotateAngleZ = 0.23F - varZ;
            this.RhindLeg.rotateAngleZ = 0.31F - varZ;

            this.LmiddleLeg.rotateAngleY = -0.38F - varY;
            this.LbackLeg.rotateAngleY = -0.38F + varY;
            this.LhindLeg.rotateAngleY = -0.78F - varY;
            this.RmiddleLeg.rotateAngleY = 0.38F - varY;
            this.RbackLeg.rotateAngleY = 0.38F + varY;
            this.RhindLeg.rotateAngleY = 0.78F - varY;

        } else {

            final float legSpeed = 1.1f;
            final float varY = MathHelper.sin(limbSwing * legSpeed) * 0.65f * limbSwingAmount;
            final float varZ = Math.abs(MathHelper.cos(limbSwing * legSpeed)) * 0.3f * limbSwingAmount;

            this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
            this.Head.rotateAngleX = headPitch * 0.017453292F - 0.085f;

            this.LmiddleLeg.rotateAngleZ = -0.23F + varZ;
            this.LbackLeg.rotateAngleZ = -0.23F + varZ;
            this.LhindLeg.rotateAngleZ = -0.31F + varZ;
            this.RmiddleLeg.rotateAngleZ = 0.23F + varZ;
            this.RbackLeg.rotateAngleZ = 0.23F - varZ;
            this.RhindLeg.rotateAngleZ = 0.31F - varZ;

            this.LmiddleLeg.rotateAngleY = 0.38F - varY;
            this.LbackLeg.rotateAngleY = -0.38F + varY;
            this.LhindLeg.rotateAngleY = -0.78F - varY;
            this.RmiddleLeg.rotateAngleY = -0.38F - varY;
            this.RbackLeg.rotateAngleY = 0.38F + varY;
            this.RhindLeg.rotateAngleY = 0.78F - varY;
        }
    }
}
