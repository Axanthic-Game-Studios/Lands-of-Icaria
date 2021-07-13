package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_jellyfish_3 - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_jellyfish_3 extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer westflap;
    public ModelRenderer eastflap;
    public ModelRenderer southflap;
    public ModelRenderer northflap;
    public ModelRenderer lower_body;
    public ModelRenderer tentacle;
    public ModelRenderer tentacle_1;
    public ModelRenderer tentacle_2;
    public ModelRenderer tentacle_3;
    public ModelRenderer tentacle_4;
    public ModelRenderer tentacle_5;
    public ModelRenderer tentacle_6;
    public ModelRenderer tentacle_7;
    public ModelRenderer tentacle_8;
    public ModelRenderer tentacle_9;
    public ModelRenderer tentacle_10;
    public ModelRenderer tentacle_11;

    public icaria_jellyfish_3() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.northflap = new ModelRenderer(this, 16, 10);
        this.northflap.setRotationPoint(0.5F, 0.0F, 5.5F);
        this.northflap.addBox(-5.5F, 0.0F, -0.5F, 11, 4, 1, 0.0F);
        this.tentacle_7 = new ModelRenderer(this, 14, 48);
        this.tentacle_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_7.addBox(-0.5F, 0.0F, 1.0F, 1, 14, 0, 0.0F);
        this.setRotateAngle(tentacle_7, 0.17453292519943295F, 1.1780972450961724F, 0.0F);
        this.tentacle_5 = new ModelRenderer(this, 10, 48);
        this.tentacle_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_5.addBox(-0.5F, 0.0F, 0.75F, 1, 15, 0, 0.0F);
        this.setRotateAngle(tentacle_5, 0.1308996938995747F, -2.356194490192345F, 0.0F);
        this.westflap = new ModelRenderer(this, 0, 16);
        this.westflap.setRotationPoint(-5.5F, 0.0F, 0.5F);
        this.westflap.addBox(-5.5F, 0.0F, -0.5F, 11, 4, 1, 0.0F);
        this.setRotateAngle(westflap, 0.0F, 1.5707963267948966F, 0.0F);
        this.tentacle = new ModelRenderer(this, 0, 48);
        this.tentacle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle.addBox(-0.5F, 0.0F, 0.5F, 1, 16, 0, 0.0F);
        this.setRotateAngle(tentacle, 0.08726646259971647F, 0.7853981633974483F, 0.0F);
        this.body = new ModelRenderer(this, 0, 34);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-6.0F, -2.0F, -6.0F, 12, 2, 12, 0.0F);
        this.tentacle_10 = new ModelRenderer(this, 20, 48);
        this.tentacle_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_10.addBox(-0.5F, 0.0F, 1.0F, 1, 14, 0, 0.0F);
        this.setRotateAngle(tentacle_10, 0.17453292519943295F, -1.7016960206944711F, 0.0F);
        this.tentacle_11 = new ModelRenderer(this, 22, 48);
        this.tentacle_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_11.addBox(-0.5F, 0.0F, 1.0F, 1, 14, 0, 0.0F);
        this.setRotateAngle(tentacle_11, 0.17453292519943295F, -0.9162978572970231F, 0.0F);
        this.lower_body = new ModelRenderer(this, 48, 48);
        this.lower_body.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.lower_body.addBox(-2.0F, -2.0F, -2.0F, 4, 2, 4, 0.0F);
        this.southflap = new ModelRenderer(this, 16, 24);
        this.southflap.setRotationPoint(-0.5F, 0.0F, -5.5F);
        this.southflap.addBox(-5.5F, 0.0F, -0.5F, 11, 4, 1, 0.0F);
        this.tentacle_9 = new ModelRenderer(this, 18, 48);
        this.tentacle_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_9.addBox(-0.5F, 0.0F, 1.0F, 1, 14, 0, 0.0F);
        this.setRotateAngle(tentacle_9, 0.17453292519943295F, -3.0106929596902186F, 0.0F);
        this.tentacle_1 = new ModelRenderer(this, 2, 48);
        this.tentacle_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_1.addBox(-0.5F, 0.0F, 0.5F, 1, 16, 0, 0.0F);
        this.setRotateAngle(tentacle_1, 0.08726646259971647F, 2.8797932657906435F, 0.0F);
        this.tentacle_8 = new ModelRenderer(this, 16, 48);
        this.tentacle_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_8.addBox(-0.5F, 0.0F, 1.0F, 1, 14, 0, 0.0F);
        this.setRotateAngle(tentacle_8, 0.17453292519943295F, 2.4870941840919194F, 0.0F);
        this.tentacle_4 = new ModelRenderer(this, 8, 48);
        this.tentacle_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_4.addBox(-0.5F, 0.0F, 0.75F, 1, 15, 0, 0.0F);
        this.setRotateAngle(tentacle_4, 0.1308996938995747F, 1.8325957145940461F, 0.0F);
        this.tentacle_2 = new ModelRenderer(this, 4, 48);
        this.tentacle_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_2.addBox(-0.5F, 0.0F, 0.5F, 1, 16, 0, 0.0F);
        this.setRotateAngle(tentacle_2, 0.08726646259971647F, 4.974188368183839F, 0.0F);
        this.tentacle_3 = new ModelRenderer(this, 6, 48);
        this.tentacle_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_3.addBox(-0.5F, 0.0F, 0.75F, 1, 15, 0, 0.0F);
        this.setRotateAngle(tentacle_3, 0.1308996938995747F, -0.2617993877991494F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head.addBox(-3.0F, -2.0F, -3.0F, 6, 2, 6, 0.0F);
        this.eastflap = new ModelRenderer(this, 32, 16);
        this.eastflap.setRotationPoint(5.5F, 0.0F, -0.5F);
        this.eastflap.addBox(-5.5F, 0.0F, -0.5F, 11, 4, 1, 0.0F);
        this.setRotateAngle(eastflap, 0.0F, 1.5707963267948966F, 0.0F);
        this.tentacle_6 = new ModelRenderer(this, 12, 48);
        this.tentacle_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle_6.addBox(-0.5F, 0.0F, 1.0F, 1, 14, 0, 0.0F);
        this.setRotateAngle(tentacle_6, 0.17453292519943295F, 0.39269908169872414F, 0.0F);
        this.body.addChild(this.northflap);
        this.lower_body.addChild(this.tentacle_7);
        this.lower_body.addChild(this.tentacle_5);
        this.body.addChild(this.westflap);
        this.lower_body.addChild(this.tentacle);
        this.lower_body.addChild(this.tentacle_10);
        this.lower_body.addChild(this.tentacle_11);
        this.body.addChild(this.lower_body);
        this.body.addChild(this.southflap);
        this.lower_body.addChild(this.tentacle_9);
        this.lower_body.addChild(this.tentacle_1);
        this.lower_body.addChild(this.tentacle_8);
        this.lower_body.addChild(this.tentacle_4);
        this.lower_body.addChild(this.tentacle_2);
        this.lower_body.addChild(this.tentacle_3);
        this.body.addChild(this.head);
        this.body.addChild(this.eastflap);
        this.lower_body.addChild(this.tentacle_6);
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
