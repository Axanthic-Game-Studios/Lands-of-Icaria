package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_arganhound - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_arganhound extends ModelBase {
    public ModelRenderer body_front;
    public ModelRenderer body_rear;
    public ModelRenderer muscle_front_right;
    public ModelRenderer muscle_front_left;
    public ModelRenderer hair;
    public ModelRenderer neck;
    public ModelRenderer tail;
    public ModelRenderer muscle_rear_right;
    public ModelRenderer muscle_rear_left;
    public ModelRenderer muscle_rear_left_1;
    public ModelRenderer muscle_rear_right_1;
    public ModelRenderer leg_rear_right;
    public ModelRenderer leg_rear_left;
    public ModelRenderer leg_front_right;
    public ModelRenderer leg_front_left;
    public ModelRenderer hair_middle;
    public ModelRenderer hair_rear;
    public ModelRenderer head;
    public ModelRenderer nose;
    public ModelRenderer mouth;
    public ModelRenderer ear_right;
    public ModelRenderer ear_left;
    public ModelRenderer fang_right;
    public ModelRenderer fang_left;

    public icaria_arganhound() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.muscle_front_right = new ModelRenderer(this, 27, 0);
        this.muscle_front_right.setRotationPoint(-4.0F, 6.5F, -8.3F);
        this.muscle_front_right.addBox(-1.5F, -3.0F, -3.0F, 3, 5, 4, 0.0F);
        this.setRotateAngle(muscle_front_right, 0.091106186954104F, 0.0F, 0.0F);
        this.muscle_rear_right = new ModelRenderer(this, 0, 31);
        this.muscle_rear_right.setRotationPoint(-3.5F, 6.5F, 5.5F);
        this.muscle_rear_right.addBox(-1.5F, -3.0F, -3.0F, 3, 5, 4, 0.0F);
        this.setRotateAngle(muscle_rear_right, 0.091106186954104F, 0.0F, 0.0F);
        this.hair_middle = new ModelRenderer(this, 15, 20);
        this.hair_middle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair_middle.addBox(-1.49F, 0.0F, 0.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(hair_middle, -0.39269908169872414F, 0.0F, 0.0F);
        this.body_rear = new ModelRenderer(this, 31, 13);
        this.body_rear.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.body_rear.addBox(-3.5F, 0.0F, 0.0F, 7, 8, 7, 0.0F);
        this.setRotateAngle(body_rear, -0.27314402793711257F, 0.0F, 0.0F);
        this.muscle_front_left = new ModelRenderer(this, 41, 0);
        this.muscle_front_left.setRotationPoint(4.0F, 6.5F, -8.3F);
        this.muscle_front_left.addBox(-1.5F, -3.0F, -3.0F, 3, 5, 4, 0.0F);
        this.setRotateAngle(muscle_front_left, 0.091106186954104F, 0.0F, 0.0F);
        this.leg_rear_right = new ModelRenderer(this, 0, 0);
        this.leg_rear_right.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.leg_rear_right.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(leg_rear_right, 0.27314402793711257F, 0.0F, 0.0F);
        this.leg_rear_left = new ModelRenderer(this, 55, 0);
        this.leg_rear_left.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.leg_rear_left.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(leg_rear_left, 0.27314402793711257F, 0.0F, 0.0F);
        this.body_front = new ModelRenderer(this, 0, 0);
        this.body_front.setRotationPoint(0.0F, 8.0F, 5.0F);
        this.body_front.addBox(-4.0F, -0.5F, -12.0F, 8, 9, 11, 0.0F);
        this.setRotateAngle(body_front, 0.091106186954104F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 19, 28);
        this.neck.setRotationPoint(0.0F, 7.3F, -11.8F);
        this.neck.addBox(-2.0F, -6.0F, -4.0F, 4, 6, 5, 0.0F);
        this.setRotateAngle(neck, -0.39269908169872414F, 0.0F, 0.0F);
        this.muscle_rear_left = new ModelRenderer(this, 10, 39);
        this.muscle_rear_left.setRotationPoint(3.5F, 6.5F, 5.5F);
        this.muscle_rear_left.addBox(-1.5F, -3.0F, -3.0F, 3, 5, 4, 0.0F);
        this.setRotateAngle(muscle_rear_left, 0.091106186954104F, 0.0F, 0.0F);
        this.fang_left = new ModelRenderer(this, 38, 9);
        this.fang_left.setRotationPoint(1.1F, 0.5F, -3.0F);
        this.fang_left.addBox(-0.5F, 0.0F, -2.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(fang_left, 0.7853981633974483F, 0.0F, 0.0F);
        this.ear_left = new ModelRenderer(this, 0, 40);
        this.ear_left.setRotationPoint(0.5F, -0.5F, -2.0F);
        this.ear_left.addBox(-1.5F, -6.0F, 1.0F, 3, 5, 1, 0.0F);
        this.setRotateAngle(ear_left, 0.39269908169872414F, 0.0F, 0.7853981633974483F);
        this.head = new ModelRenderer(this, 0, 48);
        this.head.setRotationPoint(0.0F, -2.0F, -1.0F);
        this.head.addBox(-3.0F, -5.0F, -6.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(head, 0.39269908169872414F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 37, 28);
        this.tail.setRotationPoint(0.1F, 0.5F, 6.0F);
        this.tail.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
        this.setRotateAngle(tail, -0.27314402793711257F, 0.0F, 0.0F);
        this.muscle_rear_right_1 = new ModelRenderer(this, 36, 40);
        this.muscle_rear_right_1.setRotationPoint(-4.0F, 3.7F, 2.6F);
        this.muscle_rear_right_1.addBox(-0.5F, -3.0F, -3.0F, 1, 6, 5, 0.0F);
        this.setRotateAngle(muscle_rear_right_1, 1.0471975511965976F, 0.0F, 0.0F);
        this.fang_right = new ModelRenderer(this, 37, 0);
        this.fang_right.setRotationPoint(-1.1F, 0.5F, -3.0F);
        this.fang_right.addBox(-0.5F, 0.0F, -2.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(fang_right, 0.7853981633974483F, 0.0F, 0.0F);
        this.nose = new ModelRenderer(this, 43, 46);
        this.nose.setRotationPoint(0.0F, -2.0F, -5.0F);
        this.nose.addBox(-2.0F, 0.0F, -5.0F, 4, 2, 5, 0.0F);
        this.hair = new ModelRenderer(this, 0, 20);
        this.hair.setRotationPoint(0.0F, -1.7F, -4.0F);
        this.hair.addBox(-1.51F, 0.0F, -9.0F, 3, 2, 9, 0.0F);
        this.setRotateAngle(hair, 0.136659280431156F, 0.0F, 0.0F);
        this.muscle_rear_left_1 = new ModelRenderer(this, 24, 39);
        this.muscle_rear_left_1.setRotationPoint(4.0F, 3.7F, 2.6F);
        this.muscle_rear_left_1.addBox(-0.5F, -3.0F, -3.0F, 1, 6, 5, 0.0F);
        this.setRotateAngle(muscle_rear_left_1, 1.0471975511965976F, 0.0F, 0.0F);
        this.leg_front_right = new ModelRenderer(this, 52, 10);
        this.leg_front_right.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.leg_front_right.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(leg_front_right, -0.36425021489121656F, 0.0F, 0.0F);
        this.ear_right = new ModelRenderer(this, 0, 20);
        this.ear_right.setRotationPoint(-0.5F, -0.5F, -2.0F);
        this.ear_right.addBox(-1.5F, -6.0F, 1.0F, 3, 5, 1, 0.0F);
        this.setRotateAngle(ear_right, 0.39269908169872414F, 0.0F, -0.7853981633974483F);
        this.leg_front_left = new ModelRenderer(this, 37, 28);
        this.leg_front_left.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.leg_front_left.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(leg_front_left, -0.36425021489121656F, 0.0F, 0.0F);
        this.hair_rear = new ModelRenderer(this, 51, 28);
        this.hair_rear.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.hair_rear.addBox(-1.52F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(hair_rear, -0.39269908169872414F, 0.0F, 0.0F);
        this.mouth = new ModelRenderer(this, 24, 50);
        this.mouth.setRotationPoint(0.0F, 1.5F, -6.5F);
        this.mouth.addBox(-1.5F, -1.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(mouth, 0.136659280431156F, 0.0F, 0.0F);
        this.body_front.addChild(this.muscle_front_right);
        this.body_rear.addChild(this.muscle_rear_right);
        this.hair.addChild(this.hair_middle);
        this.body_front.addChild(this.body_rear);
        this.body_front.addChild(this.muscle_front_left);
        this.muscle_rear_right.addChild(this.leg_rear_right);
        this.muscle_rear_left.addChild(this.leg_rear_left);
        this.body_front.addChild(this.neck);
        this.body_rear.addChild(this.muscle_rear_left);
        this.nose.addChild(this.fang_left);
        this.head.addChild(this.ear_left);
        this.neck.addChild(this.head);
        this.body_rear.addChild(this.tail);
        this.body_rear.addChild(this.muscle_rear_right_1);
        this.nose.addChild(this.fang_right);
        this.head.addChild(this.nose);
        this.body_front.addChild(this.hair);
        this.body_rear.addChild(this.muscle_rear_left_1);
        this.muscle_front_right.addChild(this.leg_front_right);
        this.head.addChild(this.ear_right);
        this.muscle_front_left.addChild(this.leg_front_left);
        this.hair_middle.addChild(this.hair_rear);
        this.head.addChild(this.mouth);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body_front.render(f5);
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
