package blab;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelEnderman - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class IcariaForesthag extends ModelBase {
    public ModelRenderer arm_right;
    public ModelRenderer leg_right;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arm_left;
    public ModelRenderer leg_left;
    public ModelRenderer hunchback;
    public ModelRenderer back_lower;
    public ModelRenderer back_top;

    public IcariaForesthag() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -13.0F, -5.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(head, 0.19634954084936207F, 0.0F, 0.0F);
        this.arm_left = new ModelRenderer(this, 56, 0);
        this.arm_left.mirror = true;
        this.arm_left.setRotationPoint(4.5F, -12.0F, -2.0F);
        this.arm_left.addBox(-1.0F, -2.0F, -1.0F, 2, 30, 2, 0.0F);
        this.setRotateAngle(arm_left, -0.17453292519943295F, 0.0F, -0.03490658503988659F);
        this.arm_right = new ModelRenderer(this, 56, 0);
        this.arm_right.setRotationPoint(-3.5F, -12.0F, -2.0F);
        this.arm_right.addBox(-2.0F, -2.0F, -1.0F, 2, 30, 2, 0.0F);
        this.setRotateAngle(arm_right, -0.17453292519943295F, 0.0F, 0.03490658503988659F);
        this.leg_left = new ModelRenderer(this, 56, 0);
        this.leg_left.mirror = true;
        this.leg_left.setRotationPoint(2.0F, -5.0F, 1.0F);
        this.leg_left.addBox(-1.0F, 0.0F, -1.0F, 2, 30, 2, 0.0F);
        this.hunchback = new ModelRenderer(this, 0, 20);
        this.hunchback.setRotationPoint(0.0F, -16.0F, -4.0F);
        this.hunchback.addBox(-6.0F, 0.0F, 0.0F, 12, 8, 4, 0.0F);
        this.setRotateAngle(hunchback, 0.39269908169872414F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 32, 16);
        this.body.setRotationPoint(0.0F, -14.0F, -3.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.setRotateAngle(body, 0.39269908169872414F, 0.0F, 0.0F);
        this.back_lower = new ModelRenderer(this, 3, 16);
        this.back_lower.setRotationPoint(0.0F, -10.0F, -1.5F);
        this.back_lower.addBox(-5.0F, 0.0F, 0.7F, 10, 12, 3, 0.0F);
        this.setRotateAngle(back_lower, 0.19634954084936207F, 0.0F, 0.0F);
        this.leg_right = new ModelRenderer(this, 56, 0);
        this.leg_right.setRotationPoint(-2.0F, -5.0F, 1.0F);
        this.leg_right.addBox(-1.0F, 0.0F, -1.0F, 2, 30, 2, 0.0F);
        this.back_top = new ModelRenderer(this, 3, 16);
        this.back_top.setRotationPoint(0.0F, -20.5F, 0.0F);
        this.back_top.addBox(-5.0F, 0.0F, -4.0F, 10, 4, 3, 0.0F);
        this.setRotateAngle(back_top, 0.19634954084936207F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.head.render(f5);
        this.arm_left.render(f5);
        this.arm_right.render(f5);
        this.leg_left.render(f5);
        this.hunchback.render(f5);
        this.body.render(f5);
        this.back_lower.render(f5);
        this.leg_right.render(f5);
        this.back_top.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
