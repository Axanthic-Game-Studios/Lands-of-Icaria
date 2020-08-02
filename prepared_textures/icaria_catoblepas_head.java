package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_catoblepas - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_catoblepas_head extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer snout;
    public ModelRenderer nose;
    public ModelRenderer head_1;
    public ModelRenderer ear_right;
    public ModelRenderer ear_left;
    public ModelRenderer mouth;
    public ModelRenderer horn_right;
    public ModelRenderer horn_left;
    public ModelRenderer horn_2;
    public ModelRenderer horn_3;
    public ModelRenderer horn_4;
    public ModelRenderer horn_2_1;
    public ModelRenderer horn_3_1;
    public ModelRenderer horn_4_1;

    public icaria_catoblepas_head() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.horn_left = new ModelRenderer(this, 30, 31);
        this.horn_left.setRotationPoint(2.0F, -0.1F, 0.0F);
        this.horn_left.addBox(-4.0F, -0.5F, -1.0F, 4, 1, 4, 0.0F);
        this.setRotateAngle(horn_left, 0.0F, -0.27314402793711257F, -2.6720990848033184F);
        this.horn_2 = new ModelRenderer(this, 41, 8);
        this.horn_2.setRotationPoint(-2.8F, 0.0F, 1.9F);
        this.horn_2.addBox(-4.0F, -0.5F, -1.5F, 4, 1, 3, 0.0F);
        this.setRotateAngle(horn_2, 0.0F, -0.7285004297824331F, -0.136659280431156F);
        this.horn_3_1 = new ModelRenderer(this, 0, 10);
        this.horn_3_1.setRotationPoint(-3.5F, 0.0F, 0.6F);
        this.horn_3_1.addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(horn_3_1, 0.0F, -0.5462880558742251F, 0.136659280431156F);
        this.snout = new ModelRenderer(this, 101, 35);
        this.snout.setRotationPoint(0.0F, 3.0F, -2.0F);
        this.snout.addBox(-2.0F, -3.5F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(snout, 0.19634954084936207F, 0.0F, 0.0F);
        this.ear_right = new ModelRenderer(this, 80, 0);
        this.ear_right.setRotationPoint(-3.7F, 0.5F, 1.0F);
        this.ear_right.addBox(-1.5F, -1.5F, -1.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(ear_right, 0.18203784098300857F, 0.0F, -0.39269908169872414F);
        this.horn_3 = new ModelRenderer(this, 0, 7);
        this.horn_3.setRotationPoint(-3.5F, 0.0F, 0.6F);
        this.horn_3.addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(horn_3, 0.0F, -0.5462880558742251F, -0.136659280431156F);
        this.head_1 = new ModelRenderer(this, 79, 37);
        this.head_1.setRotationPoint(0.0F, -3.0F, -0.5F);
        this.head_1.addBox(-2.5F, -1.0F, -2.0F, 5, 2, 6, 0.0F);
        this.setRotateAngle(head_1, -0.091106186954104F, 0.0F, 0.0F);
        this.mouth = new ModelRenderer(this, 31, 8);
        this.mouth.setRotationPoint(0.0F, -0.5F, 0.5F);
        this.mouth.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(mouth, 0.19634954084936207F, 0.0F, 0.0F);
        this.horn_2_1 = new ModelRenderer(this, 113, 17);
        this.horn_2_1.setRotationPoint(-2.8F, 0.0F, 1.9F);
        this.horn_2_1.addBox(-4.0F, -0.5F, -1.5F, 4, 1, 3, 0.0F);
        this.setRotateAngle(horn_2_1, 0.0F, -0.7285004297824331F, 0.136659280431156F);
        this.horn_4_1 = new ModelRenderer(this, 44, 12);
        this.horn_4_1.setRotationPoint(-3.0F, 0.0F, 0.6F);
        this.horn_4_1.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(horn_4_1, 0.0F, -0.5462880558742251F, 0.136659280431156F);
        this.ear_left = new ModelRenderer(this, 119, 6);
        this.ear_left.setRotationPoint(3.7F, 0.5F, 1.0F);
        this.ear_left.addBox(-1.5F, -1.5F, -1.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(ear_left, 0.18203784098300857F, 0.0F, 0.39269908169872414F);
        this.horn_right = new ModelRenderer(this, 97, 30);
        this.horn_right.setRotationPoint(-2.0F, -0.1F, 0.0F);
        this.horn_right.addBox(-4.0F, -0.5F, -1.0F, 4, 1, 4, 0.0F);
        this.setRotateAngle(horn_right, 0.0F, -0.27314402793711257F, -0.4553564018453205F);
        this.nose = new ModelRenderer(this, 112, 0);
        this.nose.setRotationPoint(0.0F, 2.3F, 1.0F);
        this.nose.addBox(-1.5F, -5.5F, -4.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(nose, 0.6373942428283291F, 0.0F, 0.0F);
        this.horn_4 = new ModelRenderer(this, 49, 2);
        this.horn_4.setRotationPoint(-3.0F, 0.0F, 0.6F);
        this.horn_4.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(horn_4, 0.0F, -0.5462880558742251F, -0.136659280431156F);
        this.head = new ModelRenderer(this, 12, 31);
        this.head.setRotationPoint(0.0F, 20.7F, 0.0F);
        this.head.addBox(-3.0F, -3.5F, -3.0F, 6, 7, 6, 0.0F);
        this.setRotateAngle(head, -0.136659280431156F, 0.0F, 0.0F);
        this.head_1.addChild(this.horn_left);
        this.horn_right.addChild(this.horn_2);
        this.horn_2_1.addChild(this.horn_3_1);
        this.head.addChild(this.snout);
        this.head.addChild(this.ear_right);
        this.horn_2.addChild(this.horn_3);
        this.head.addChild(this.head_1);
        this.snout.addChild(this.mouth);
        this.horn_left.addChild(this.horn_2_1);
        this.horn_3_1.addChild(this.horn_4_1);
        this.head.addChild(this.ear_left);
        this.head_1.addChild(this.horn_right);
        this.head.addChild(this.nose);
        this.horn_3.addChild(this.horn_4);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.head.render(f5);
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
