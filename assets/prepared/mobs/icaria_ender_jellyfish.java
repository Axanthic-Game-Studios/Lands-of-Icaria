package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_ender_jellyfish - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_ender_jellyfish extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer front;
    public ModelRenderer rear;
    public ModelRenderer head;
    public ModelRenderer lower_body;
    public ModelRenderer east;
    public ModelRenderer west;
    public ModelRenderer front_1;
    public ModelRenderer front_2;
    public ModelRenderer upper_tentacle;
    public ModelRenderer upper_tentacle_1;
    public ModelRenderer upper_tentacle_2;
    public ModelRenderer upper_tentacle_3;
    public ModelRenderer lower_body_2;
    public ModelRenderer lower_tentacle;
    public ModelRenderer lower_tentacle_1;
    public ModelRenderer lower_tentacle_2;
    public ModelRenderer lower_tentacle_3;
    public ModelRenderer inner_stub;
    public ModelRenderer inner_stub_1;
    public ModelRenderer inner_stub_2;
    public ModelRenderer inner_stub_3;

    public icaria_ender_jellyfish() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.upper_tentacle = new ModelRenderer(this, 0, 51);
        this.upper_tentacle.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.upper_tentacle.addBox(-0.5F, 0.0F, -1.5F, 1, 10, 1, 0.0F);
        this.setRotateAngle(upper_tentacle, -0.19634954084936207F, 0.7853981633974483F, 0.0F);
        this.lower_tentacle_1 = new ModelRenderer(this, 4, 40);
        this.lower_tentacle_1.setRotationPoint(0.0F, 10.9F, -1.0F);
        this.lower_tentacle_1.addBox(-0.5F, 0.0F, -0.5F, 1, 10, 1, 0.0F);
        this.setRotateAngle(lower_tentacle_1, 0.19634954084936207F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 30);
        this.body.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.body.addBox(-5.0F, 0.0F, -4.0F, 10, 2, 8, 0.0F);
        this.inner_stub_2 = new ModelRenderer(this, 16, 20);
        this.inner_stub_2.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.inner_stub_2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(inner_stub_2, 0.20071286397934787F, 0.0F, 0.0F);
        this.lower_body = new ModelRenderer(this, 18, 9);
        this.lower_body.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.lower_body.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F);
        this.upper_tentacle_2 = new ModelRenderer(this, 8, 51);
        this.upper_tentacle_2.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.upper_tentacle_2.addBox(-0.5F, 0.0F, -1.5F, 1, 12, 1, 0.0F);
        this.setRotateAngle(upper_tentacle_2, -0.19634954084936207F, -2.356194490192345F, 0.0F);
        this.upper_tentacle_3 = new ModelRenderer(this, 12, 51);
        this.upper_tentacle_3.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.upper_tentacle_3.addBox(-0.5F, 0.0F, -1.5F, 1, 11, 1, 0.0F);
        this.setRotateAngle(upper_tentacle_3, -0.19634954084936207F, -0.7853981633974483F, 0.0F);
        this.lower_tentacle_2 = new ModelRenderer(this, 8, 40);
        this.lower_tentacle_2.setRotationPoint(0.0F, 11.9F, -1.0F);
        this.lower_tentacle_2.addBox(-0.5F, 0.0F, -0.5F, 1, 10, 1, 0.0F);
        this.setRotateAngle(lower_tentacle_2, 0.19634954084936207F, 0.0F, 0.0F);
        this.front_1 = new ModelRenderer(this, 32, 3);
        this.front_1.setRotationPoint(0.0F, 2.0F, -4.5F);
        this.front_1.addBox(-4.0F, 0.0F, 0.0F, 8, 6, 0, 0.0F);
        this.front = new ModelRenderer(this, 0, 0);
        this.front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.front.addBox(-4.0F, 0.0F, -5.0F, 8, 2, 1, 0.0F);
        this.inner_stub_3 = new ModelRenderer(this, 20, 20);
        this.inner_stub_3.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.inner_stub_3.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(inner_stub_3, -0.20071286397934787F, 0.0F, 0.0F);
        this.east = new ModelRenderer(this, 0, 3);
        this.east.setRotationPoint(4.5F, 2.0F, 0.0F);
        this.east.addBox(-4.0F, 0.0F, 0.0F, 8, 6, 0, 0.0F);
        this.setRotateAngle(east, 0.0F, 1.5707963267948966F, 0.0F);
        this.upper_tentacle_1 = new ModelRenderer(this, 4, 51);
        this.upper_tentacle_1.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.upper_tentacle_1.addBox(-0.5F, 0.0F, -1.5F, 1, 11, 1, 0.0F);
        this.setRotateAngle(upper_tentacle_1, -0.19634954084936207F, 2.356194490192345F, 0.0F);
        this.lower_body_2 = new ModelRenderer(this, 0, 17);
        this.lower_body_2.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.lower_body_2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.lower_tentacle = new ModelRenderer(this, 0, 40);
        this.lower_tentacle.setRotationPoint(0.0F, 9.9F, -1.0F);
        this.lower_tentacle.addBox(-0.5F, 0.0F, -0.5F, 1, 10, 1, 0.0F);
        this.setRotateAngle(lower_tentacle, 0.19634954084936207F, 0.0F, 0.0F);
        this.inner_stub_1 = new ModelRenderer(this, 12, 20);
        this.inner_stub_1.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.inner_stub_1.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(inner_stub_1, 0.0F, 0.017453292519943295F, -0.20071286397934787F);
        this.front_2 = new ModelRenderer(this, 48, 3);
        this.front_2.setRotationPoint(0.0F, 2.0F, 4.5F);
        this.front_2.addBox(-4.0F, 0.0F, 0.0F, 8, 6, 0, 0.0F);
        this.rear = new ModelRenderer(this, 18, 0);
        this.rear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rear.addBox(-4.0F, 0.0F, 4.0F, 8, 2, 1, 0.0F);
        this.lower_tentacle_3 = new ModelRenderer(this, 12, 40);
        this.lower_tentacle_3.setRotationPoint(0.0F, 10.9F, -1.0F);
        this.lower_tentacle_3.addBox(-0.5F, 0.0F, -0.5F, 1, 10, 1, 0.0F);
        this.setRotateAngle(lower_tentacle_3, 0.19634954084936207F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 9);
        this.head.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head.addBox(-3.0F, 0.0F, -3.0F, 6, 2, 6, 0.0F);
        this.inner_stub = new ModelRenderer(this, 8, 20);
        this.inner_stub.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.inner_stub.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(inner_stub, 0.0F, 0.0F, 0.20071286397934787F);
        this.west = new ModelRenderer(this, 16, 3);
        this.west.setRotationPoint(-4.5F, 2.0F, 0.0F);
        this.west.addBox(-4.0F, 0.0F, 0.0F, 8, 6, 0, 0.0F);
        this.setRotateAngle(west, 0.0F, 1.5707963267948966F, 0.0F);
        this.lower_body.addChild(this.upper_tentacle);
        this.upper_tentacle_1.addChild(this.lower_tentacle_1);
        this.lower_body_2.addChild(this.inner_stub_2);
        this.body.addChild(this.lower_body);
        this.lower_body.addChild(this.upper_tentacle_2);
        this.lower_body.addChild(this.upper_tentacle_3);
        this.upper_tentacle_2.addChild(this.lower_tentacle_2);
        this.front.addChild(this.front_1);
        this.body.addChild(this.front);
        this.lower_body_2.addChild(this.inner_stub_3);
        this.body.addChild(this.east);
        this.lower_body.addChild(this.upper_tentacle_1);
        this.lower_body.addChild(this.lower_body_2);
        this.upper_tentacle.addChild(this.lower_tentacle);
        this.lower_body_2.addChild(this.inner_stub_1);
        this.rear.addChild(this.front_2);
        this.body.addChild(this.rear);
        this.upper_tentacle_3.addChild(this.lower_tentacle_3);
        this.body.addChild(this.head);
        this.lower_body_2.addChild(this.inner_stub);
        this.body.addChild(this.west);
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
