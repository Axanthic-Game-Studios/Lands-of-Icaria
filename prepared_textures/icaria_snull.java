package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_snull - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_snull extends ModelBase {
    public ModelRenderer body_front;
    public ModelRenderer body_head_rear;
    public ModelRenderer head;
    public ModelRenderer head_rear;
    public ModelRenderer skull;
    public ModelRenderer body_rear;
    public ModelRenderer tail;
    public ModelRenderer eye_stalk_right;
    public ModelRenderer eye_stalk_left;
    public ModelRenderer jaw_upper;
    public ModelRenderer jaw_lower;
    public ModelRenderer eye_right;
    public ModelRenderer eye_left;

    public icaria_snull() {
        this.textureWidth = 48;
        this.textureHeight = 32;
        this.body_rear = new ModelRenderer(this, 2, 19);
        this.body_rear.setRotationPoint(0.0F, 22.0F, -8.7F);
        this.body_rear.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 6, 0.1F);
        this.head_rear = new ModelRenderer(this, 24, 0);
        this.head_rear.setRotationPoint(0.5F, 19.7F, 7.2F);
        this.head_rear.addBox(-3.0F, 0.0F, 0.0F, 5, 4, 4, 0.1F);
        this.setRotateAngle(head_rear, 0.7853981633974483F, 0.0F, 0.0F);
        this.eye_stalk_right = new ModelRenderer(this, 42, 0);
        this.eye_stalk_right.setRotationPoint(4.0F, 10.7F, 13.5F);
        this.eye_stalk_right.addBox(-1.0F, 0.0F, 0.0F, 1, 6, 1, -0.2F);
        this.setRotateAngle(eye_stalk_right, -0.39269908169872414F, 0.5811946409141118F, 0.13962634015954636F);
        this.eye_stalk_left = new ModelRenderer(this, 42, 0);
        this.eye_stalk_left.setRotationPoint(-4.0F, 10.7F, 13.5F);
        this.eye_stalk_left.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, -0.2F);
        this.setRotateAngle(eye_stalk_left, -0.39269908169872414F, -0.5811946409141118F, -0.13962634015954636F);
        this.head = new ModelRenderer(this, 24, 16);
        this.head.setRotationPoint(0.5F, 15.7F, 9.0F);
        this.head.addBox(-3.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F);
        this.tail = new ModelRenderer(this, 4, 21);
        this.tail.setRotationPoint(0.0F, 22.0F, -12.7F);
        this.tail.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 4, -0.1F);
        this.jaw_upper = new ModelRenderer(this, 0, 8);
        this.jaw_upper.setRotationPoint(0.0F, 0.0F, 1.7F);
        this.jaw_upper.addBox(-2.5F, 0.2F, 0.0F, 5, 1, 6, 0.0F);
        this.body_front = new ModelRenderer(this, 0, 16);
        this.body_front.setRotationPoint(0.0F, 20.0F, -2.4F);
        this.body_front.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 8, 0.2F);
        this.body_head_rear = new ModelRenderer(this, 24, 0);
        this.body_head_rear.setRotationPoint(0.5F, 19.9F, 4.8F);
        this.body_head_rear.addBox(-3.0F, 0.0F, 0.0F, 5, 4, 4, 0.2F);
        this.setRotateAngle(body_head_rear, 0.29757863746503316F, 0.0F, 0.0F);
        this.eye_left = new ModelRenderer(this, 0, 0);
        this.eye_left.setRotationPoint(-0.5F, -1.8F, -0.5F);
        this.eye_left.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.skull = new ModelRenderer(this, 0, 0);
        this.skull.setRotationPoint(0.0F, 22.0F, -3.0F);
        this.skull.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 8, 0.2F);
        this.setRotateAngle(skull, 0.5817182396897099F, 0.0F, 0.0F);
        this.jaw_lower = new ModelRenderer(this, 0, 9);
        this.jaw_lower.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.jaw_lower.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
        this.setRotateAngle(jaw_lower, -0.091106186954104F, 0.0F, 0.0F);
        this.eye_right = new ModelRenderer(this, 0, 0);
        this.eye_right.setRotationPoint(-1.5F, -1.8F, -0.5F);
        this.eye_right.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.skull.addChild(this.jaw_upper);
        this.eye_stalk_left.addChild(this.eye_left);
        this.jaw_upper.addChild(this.jaw_lower);
        this.eye_stalk_right.addChild(this.eye_right);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body_rear.render(f5);
        this.head_rear.render(f5);
        this.eye_stalk_right.render(f5);
        this.eye_stalk_left.render(f5);
        this.head.render(f5);
        this.tail.render(f5);
        this.body_front.render(f5);
        this.body_head_rear.render(f5);
        this.skull.render(f5);
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
