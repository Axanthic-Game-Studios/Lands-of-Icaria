package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_jellyfish_2 - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_jellyfish_2 extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer lower_body;
    public ModelRenderer northrim;
    public ModelRenderer westrim;
    public ModelRenderer southrim;
    public ModelRenderer eastrim;
    public ModelRenderer tentacle1;
    public ModelRenderer tentacle2;
    public ModelRenderer tentacle3;
    public ModelRenderer feeler;
    public ModelRenderer feeler_1;
    public ModelRenderer feeler_2;
    public ModelRenderer feeler_3;
    public ModelRenderer feeler_4;
    public ModelRenderer feeler_5;
    public ModelRenderer feeler_6;
    public ModelRenderer feeler_7;
    public ModelRenderer feeler_8;
    public ModelRenderer feeler_9;
    public ModelRenderer feeler_10;
    public ModelRenderer feeler_11;
    public ModelRenderer feeler_12;
    public ModelRenderer feeler_13;
    public ModelRenderer feeler_14;
    public ModelRenderer feeler_15;

    public icaria_jellyfish_2() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.feeler_3 = new ModelRenderer(this, 12, 53);
        this.feeler_3.setRotationPoint(-4.5F, 0.0F, 0.0F);
        this.feeler_3.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 0, 0.0F);
        this.eastrim = new ModelRenderer(this, 32, 24);
        this.eastrim.setRotationPoint(6.5F, 0.0F, 0.0F);
        this.eastrim.addBox(-6.0F, -2.0F, -0.5F, 12, 2, 1, 0.0F);
        this.setRotateAngle(eastrim, 0.0F, 1.5707963267948966F, 0.0F);
        this.feeler_13 = new ModelRenderer(this, 52, 52);
        this.feeler_13.setRotationPoint(1.5F, 0.0F, 0.0F);
        this.feeler_13.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 0, 0.0F);
        this.setRotateAngle(feeler_13, 0.08726646259971647F, 0.0F, 0.0F);
        this.feeler_6 = new ModelRenderer(this, 24, 52);
        this.feeler_6.setRotationPoint(1.5F, 0.0F, 0.0F);
        this.feeler_6.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 0, 0.0F);
        this.setRotateAngle(feeler_6, -0.08726646259971647F, 0.0F, 0.0F);
        this.feeler_1 = new ModelRenderer(this, 4, 52);
        this.feeler_1.setRotationPoint(1.5F, 0.0F, 0.0F);
        this.feeler_1.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 0, 0.0F);
        this.setRotateAngle(feeler_1, 0.08726646259971647F, 0.0F, 0.0F);
        this.westrim = new ModelRenderer(this, 0, 24);
        this.westrim.setRotationPoint(-6.5F, 0.0F, 0.0F);
        this.westrim.addBox(-6.0F, -2.0F, -0.5F, 12, 2, 1, 0.0F);
        this.setRotateAngle(westrim, 0.0F, 1.5707963267948966F, 0.0F);
        this.head = new ModelRenderer(this, 32, 35);
        this.head.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head.addBox(-4.0F, -2.0F, -4.0F, 8, 2, 8, 0.0F);
        this.northrim = new ModelRenderer(this, 16, 16);
        this.northrim.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.northrim.addBox(-6.0F, -2.0F, -0.5F, 12, 2, 1, 0.0F);
        this.feeler_15 = new ModelRenderer(this, 60, 53);
        this.feeler_15.setRotationPoint(-4.5F, 0.0F, 0.0F);
        this.feeler_15.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 0, 0.0F);
        this.feeler_12 = new ModelRenderer(this, 48, 53);
        this.feeler_12.setRotationPoint(4.5F, 0.0F, 0.0F);
        this.feeler_12.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 0, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.body.addBox(-6.0F, -2.0F, -6.0F, 12, 2, 12, 0.0F);
        this.feeler_14 = new ModelRenderer(this, 56, 52);
        this.feeler_14.setRotationPoint(-1.5F, 0.0F, 0.0F);
        this.feeler_14.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 0, 0.0F);
        this.setRotateAngle(feeler_14, 0.08726646259971647F, 0.0F, 0.0F);
        this.lower_body = new ModelRenderer(this, 24, 45);
        this.lower_body.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.lower_body.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5, 0.0F);
        this.tentacle2 = new ModelRenderer(this, 8, 37);
        this.tentacle2.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.tentacle2.addBox(-1.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(tentacle2, -0.08726646259971647F, 2.8797932657906435F, 0.0F);
        this.tentacle3 = new ModelRenderer(this, 16, 39);
        this.tentacle3.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.tentacle3.addBox(-1.0F, 0.0F, -2.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(tentacle3, -0.08726646259971647F, 4.974188368183839F, 0.0F);
        this.feeler_5 = new ModelRenderer(this, 20, 52);
        this.feeler_5.setRotationPoint(-1.5F, 0.0F, 0.0F);
        this.feeler_5.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 0, 0.0F);
        this.setRotateAngle(feeler_5, -0.08726646259971647F, 0.0F, 0.0F);
        this.feeler_4 = new ModelRenderer(this, 16, 53);
        this.feeler_4.setRotationPoint(-4.5F, 0.0F, 0.0F);
        this.feeler_4.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 0, 0.0F);
        this.feeler_10 = new ModelRenderer(this, 40, 52);
        this.feeler_10.setRotationPoint(1.5F, 0.0F, 0.0F);
        this.feeler_10.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 0, 0.0F);
        this.setRotateAngle(feeler_10, -0.08726646259971647F, 0.0F, 0.0F);
        this.feeler_7 = new ModelRenderer(this, 28, 53);
        this.feeler_7.setRotationPoint(4.5F, 0.0F, 0.0F);
        this.feeler_7.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 0, 0.0F);
        this.feeler = new ModelRenderer(this, 0, 53);
        this.feeler.setRotationPoint(4.5F, 0.0F, 0.0F);
        this.feeler.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 0, 0.0F);
        this.tentacle1 = new ModelRenderer(this, 0, 35);
        this.tentacle1.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.tentacle1.addBox(-1.0F, 0.0F, -2.0F, 2, 14, 2, 0.0F);
        this.setRotateAngle(tentacle1, -0.08726646259971647F, 0.7853981633974483F, 0.0F);
        this.southrim = new ModelRenderer(this, 16, 32);
        this.southrim.setRotationPoint(0.0F, 0.0F, -6.5F);
        this.southrim.addBox(-6.0F, -2.0F, -0.5F, 12, 2, 1, 0.0F);
        this.feeler_8 = new ModelRenderer(this, 32, 53);
        this.feeler_8.setRotationPoint(-4.5F, 0.0F, 0.0F);
        this.feeler_8.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 0, 0.0F);
        this.feeler_9 = new ModelRenderer(this, 36, 52);
        this.feeler_9.setRotationPoint(-1.5F, 0.0F, 0.0F);
        this.feeler_9.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 0, 0.0F);
        this.setRotateAngle(feeler_9, -0.08726646259971647F, 0.0F, 0.0F);
        this.feeler_2 = new ModelRenderer(this, 8, 52);
        this.feeler_2.setRotationPoint(-1.5F, 0.0F, 0.0F);
        this.feeler_2.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 0, 0.0F);
        this.setRotateAngle(feeler_2, 0.08726646259971647F, 0.0F, 0.0F);
        this.feeler_11 = new ModelRenderer(this, 44, 53);
        this.feeler_11.setRotationPoint(4.5F, 0.0F, 0.0F);
        this.feeler_11.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 0, 0.0F);
        this.northrim.addChild(this.feeler_3);
        this.body.addChild(this.eastrim);
        this.eastrim.addChild(this.feeler_13);
        this.westrim.addChild(this.feeler_6);
        this.northrim.addChild(this.feeler_1);
        this.body.addChild(this.westrim);
        this.body.addChild(this.head);
        this.body.addChild(this.northrim);
        this.eastrim.addChild(this.feeler_15);
        this.eastrim.addChild(this.feeler_12);
        this.eastrim.addChild(this.feeler_14);
        this.body.addChild(this.lower_body);
        this.lower_body.addChild(this.tentacle2);
        this.lower_body.addChild(this.tentacle3);
        this.westrim.addChild(this.feeler_5);
        this.westrim.addChild(this.feeler_4);
        this.southrim.addChild(this.feeler_10);
        this.westrim.addChild(this.feeler_7);
        this.northrim.addChild(this.feeler);
        this.lower_body.addChild(this.tentacle1);
        this.body.addChild(this.southrim);
        this.southrim.addChild(this.feeler_8);
        this.southrim.addChild(this.feeler_9);
        this.northrim.addChild(this.feeler_2);
        this.southrim.addChild(this.feeler_11);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
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
