package blab;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * IcariaAeternae - Shado47
 * Created using Tabula 7.0.0
 */
public class IcariaAeternae extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer leg_rear_left;
    public ModelRenderer leg_front_left;
    public ModelRenderer leg_rear_right;
    public ModelRenderer leg_front_right;
    public ModelRenderer head_jaw;
    public ModelRenderer horn_right_bottom;
    public ModelRenderer horn_left_bottom;
    public ModelRenderer head;
    public ModelRenderer horn_right_dmiddle;
    public ModelRenderer horn_left_dmiddle;
    public ModelRenderer horn_right_backmiddle;
    public ModelRenderer horn_left_backmiddle;
    public ModelRenderer horn_end_right;
    public ModelRenderer horn_end_left;
    public ModelRenderer neck;
    public ModelRenderer kamm;
    public ModelRenderer muscle_right;
    public ModelRenderer muscle_left;
    public ModelRenderer tail;

    public IcariaAeternae() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.horn_left_backmiddle = new ModelRenderer(this, 65, 8);
        this.horn_left_backmiddle.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.horn_left_backmiddle.addBox(1.02F, -5.0F, 21.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(horn_left_backmiddle, 1.1780972450961724F, 0.0F, 0.0F);
        this.horn_left_bottom = new ModelRenderer(this, 65, 24);
        this.horn_left_bottom.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.horn_left_bottom.addBox(1.0F, -20.2F, -9.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(horn_left_bottom, -0.39269908169872414F, 0.0F, 0.0F);
        this.leg_front_left = new ModelRenderer(this, 29, 46);
        this.leg_front_left.setRotationPoint(3.0F, 10.0F, -5.0F);
        this.leg_front_left.addBox(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
        this.leg_front_right = new ModelRenderer(this, 29, 46);
        this.leg_front_right.setRotationPoint(-3.0F, 10.0F, -5.0F);
        this.leg_front_right.addBox(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
        this.horn_right_bottom = new ModelRenderer(this, 65, 0);
        this.horn_right_bottom.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.horn_right_bottom.addBox(-3.0F, -20.2F, -9.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(horn_right_bottom, -0.39269908169872414F, 0.0F, 0.0F);
        this.horn_right_backmiddle = new ModelRenderer(this, 65, 16);
        this.horn_right_backmiddle.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.horn_right_backmiddle.addBox(-3.02F, -5.0F, 21.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(horn_right_backmiddle, 1.1780972450961724F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 29, 0);
        this.body.setRotationPoint(2.0F, 5.0F, 1.0F);
        this.body.addBox(-6.0F, -10.0F, -7.0F, 8, 22, 8, 0.1F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.horn_end_right = new ModelRenderer(this, 65, 24);
        this.horn_end_right.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.horn_end_right.addBox(-3.03F, -16.0F, 14.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(horn_end_right, 0.39269908169872414F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 73, 0);
        this.tail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail.addBox(-1.0F, 12.0F, 3.3F, 2, 11, 3, 0.0F);
        this.setRotateAngle(tail, 0.7853981633974483F, 0.0F, 0.0F);
        this.leg_rear_right = new ModelRenderer(this, 29, 46);
        this.leg_rear_right.setRotationPoint(-3.0F, 10.0F, 9.0F);
        this.leg_rear_right.addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
        this.horn_end_left = new ModelRenderer(this, 65, 0);
        this.horn_end_left.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.horn_end_left.addBox(1.03F, -16.0F, 14.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(horn_end_left, 0.39269908169872414F, 0.0F, 0.0F);
        this.kamm = new ModelRenderer(this, 73, 0);
        this.kamm.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.kamm.addBox(-2.0F, -14.5F, 3.0F, 2, 11, 3, 0.0F);
        this.setRotateAngle(kamm, 0.39269908169872414F, 0.0F, 0.0F);
        this.muscle_left = new ModelRenderer(this, 45, 49);
        this.muscle_left.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.muscle_left.addBox(4.0F, 5.0F, -8.0F, 2, 7, 8, 0.0F);
        this.horn_right_dmiddle = new ModelRenderer(this, 65, 8);
        this.horn_right_dmiddle.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.horn_right_dmiddle.addBox(-3.01F, -13.5F, -20.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(horn_right_dmiddle, -1.1780972450961724F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 46);
        this.neck.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.neck.addBox(-2.0F, -11.0F, 0.0F, 4, 9, 3, 0.0F);
        this.setRotateAngle(neck, 0.39269908169872414F, 0.0F, 0.0F);
        this.horn_left_dmiddle = new ModelRenderer(this, 65, 16);
        this.horn_left_dmiddle.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.horn_left_dmiddle.addBox(1.01F, -13.5F, -20.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(horn_left_dmiddle, -1.1780972450961724F, 0.0F, 0.0F);
        this.leg_rear_left = new ModelRenderer(this, 29, 46);
        this.leg_rear_left.setRotationPoint(3.0F, 10.0F, 9.0F);
        this.leg_rear_left.addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
        this.head_jaw = new ModelRenderer(this, 0, 0);
        this.head_jaw.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.head_jaw.addBox(-1.5F, -14.0F, -12.0F, 3, 3, 8, 0.0F);
        this.head = new ModelRenderer(this, 0, 32);
        this.head.setRotationPoint(0.0F, 10.0F, -6.8F);
        this.head.addBox(-3.5F, -17.0F, -7.0F, 7, 7, 7, 0.0F);
        this.muscle_right = new ModelRenderer(this, 45, 49);
        this.muscle_right.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.muscle_right.addBox(-6.0F, 5.0F, -8.0F, 2, 7, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.horn_left_backmiddle.render(f5);
        this.horn_left_bottom.render(f5);
        this.leg_front_left.render(f5);
        this.leg_front_right.render(f5);
        this.horn_right_bottom.render(f5);
        this.horn_right_backmiddle.render(f5);
        this.body.render(f5);
        this.horn_end_right.render(f5);
        this.tail.render(f5);
        this.leg_rear_right.render(f5);
        this.horn_end_left.render(f5);
        this.kamm.render(f5);
        this.muscle_left.render(f5);
        this.horn_right_dmiddle.render(f5);
        this.neck.render(f5);
        this.horn_left_dmiddle.render(f5);
        this.leg_rear_left.render(f5);
        this.head_jaw.render(f5);
        this.head.render(f5);
        this.muscle_right.render(f5);
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
