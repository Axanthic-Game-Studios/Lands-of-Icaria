package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_wretch - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_wretch extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer lower_body;
    public ModelRenderer arm_right;
    public ModelRenderer arm_left;
    public ModelRenderer chestplate;
    public ModelRenderer neck;
    public ModelRenderer shoulderpad;
    public ModelRenderer bagstrap;
    public ModelRenderer hip;
    public ModelRenderer leg_right;
    public ModelRenderer leg_left;
    public ModelRenderer leg_right_1;
    public ModelRenderer leg_left_1;
    public ModelRenderer leg_protecc;
    public ModelRenderer arm_right_1;
    public ModelRenderer arm_protecc;
    public ModelRenderer arm_left_1;
    public ModelRenderer strap;
    public ModelRenderer chestplate_side;
    public ModelRenderer chestplate_1;
    public ModelRenderer spear;
    public ModelRenderer chestplate_tear;
    public ModelRenderer speartip;
    public ModelRenderer speartip_1;
    public ModelRenderer jaw;
    public ModelRenderer head;
    public ModelRenderer hat;
    public ModelRenderer shoulderpad_side;
    public ModelRenderer bag;

    public icaria_wretch() {
        this.textureWidth = 80;
        this.textureHeight = 80;
        this.arm_right_1 = new ModelRenderer(this, 42, 21);
        this.arm_right_1.setRotationPoint(0.0F, 14.5F, 0.0F);
        this.arm_right_1.addBox(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.setRotateAngle(arm_right_1, -0.091106186954104F, 0.0F, -0.17453292519943295F);
        this.hat = new ModelRenderer(this, 0, 55);
        this.hat.setRotationPoint(0.3F, -9.0F, 0.3F);
        this.hat.addBox(-4.5F, 0.0F, -4.5F, 9, 3, 9, 0.0F);
        this.setRotateAngle(hat, -0.08726646259971647F, 0.0F, 0.08726646259971647F);
        this.leg_right = new ModelRenderer(this, 55, 17);
        this.leg_right.setRotationPoint(-3.0F, 2.0F, 0.0F);
        this.leg_right.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(leg_right, -0.7853981633974483F, 0.0F, 0.05235987755982988F);
        this.lower_body = new ModelRenderer(this, 34, 0);
        this.lower_body.setRotationPoint(0.0F, 3.8F, -0.0F);
        this.lower_body.addBox(-3.0F, 0.0F, -2.0F, 6, 6, 4, 0.0F);
        this.setRotateAngle(lower_body, -0.08726646259971647F, 0.0F, 0.0F);
        this.arm_left_1 = new ModelRenderer(this, 30, 29);
        this.arm_left_1.mirror = true;
        this.arm_left_1.setRotationPoint(0.0F, 14.5F, 0.0F);
        this.arm_left_1.addBox(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.setRotateAngle(arm_left_1, -0.091106186954104F, 0.0F, 0.17453292519943295F);
        this.leg_left = new ModelRenderer(this, 14, 20);
        this.leg_left.mirror = true;
        this.leg_left.setRotationPoint(3.0F, 2.0F, 0.0F);
        this.leg_left.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(leg_left, -0.7853981633974483F, 0.0F, -0.05235987755982988F);
        this.shoulderpad_side = new ModelRenderer(this, 54, 56);
        this.shoulderpad_side.setRotationPoint(8.0F, 0.0F, -0.0F);
        this.shoulderpad_side.addBox(0.0F, 0.0F, -3.0F, 5, 4, 6, 0.0F);
        this.setRotateAngle(shoulderpad_side, 0.0F, 0.0F, 1.0471975511965976F);
        this.spear = new ModelRenderer(this, 35, 62);
        this.spear.setRotationPoint(-2.0F, 3.0F, -0.0F);
        this.spear.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 17, 0.0F);
        this.setRotateAngle(spear, 0.17453292519943295F, 0.31869712141416456F, 0.0F);
        this.bag = new ModelRenderer(this, 28, 62);
        this.bag.setRotationPoint(0.5F, 13.5F, -0.0F);
        this.bag.addBox(-0.5F, 0.0F, -4.0F, 3, 8, 8, 0.0F);
        this.setRotateAngle(bag, 0.0F, 0.0F, 0.5235987755982988F);
        this.speartip_1 = new ModelRenderer(this, 54, 73);
        this.speartip_1.setRotationPoint(0.0F, 0.0F, -7.0F);
        this.speartip_1.addBox(0.0F, -1.5F, -1.5F, 0, 3, 3, 0.0F);
        this.setRotateAngle(speartip_1, 0.7853981633974483F, 0.0F, 1.5707963267948966F);
        this.arm_left = new ModelRenderer(this, 62, 0);
        this.arm_left.mirror = true;
        this.arm_left.setRotationPoint(7.0F, 0.5F, 0.0F);
        this.arm_left.addBox(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.setRotateAngle(arm_left, 0.0F, 0.0F, -0.17453292519943295F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, -5.9F, -0.0F);
        this.body.addBox(-6.0F, 0.0F, -2.5F, 12, 4, 5, 0.0F);
        this.setRotateAngle(body, 0.08726646259971647F, 0.0F, 0.0F);
        this.hip = new ModelRenderer(this, 0, 20);
        this.hip.setRotationPoint(0.0F, 5.8F, -0.0F);
        this.hip.addBox(-2.0F, 0.0F, -1.5F, 4, 4, 3, 0.0F);
        this.setRotateAngle(hip, -0.08726646259971647F, 0.0F, 0.0F);
        this.speartip = new ModelRenderer(this, 54, 73);
        this.speartip.setRotationPoint(0.0F, 0.0F, -7.0F);
        this.speartip.addBox(0.0F, -1.5F, -1.5F, 0, 3, 3, 0.0F);
        this.setRotateAngle(speartip, 0.7853981633974483F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 28, 46);
        this.head.setRotationPoint(0.0F, -0.1F, 0.1F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(head, 0.03490658503988659F, 0.0F, 0.0F);
        this.chestplate_1 = new ModelRenderer(this, 38, 39);
        this.chestplate_1.setRotationPoint(0.0F, 4.8F, 0.5F);
        this.chestplate_1.addBox(-4.0F, 0.0F, -3.0F, 8, 2, 5, 0.0F);
        this.setRotateAngle(chestplate_1, -0.08726646259971647F, 0.0F, 0.0F);
        this.arm_right = new ModelRenderer(this, 54, 0);
        this.arm_right.setRotationPoint(-7.0F, 0.5F, 0.0F);
        this.arm_right.addBox(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.setRotateAngle(arm_right, 0.0F, 0.0F, 0.17453292519943295F);
        this.chestplate = new ModelRenderer(this, 0, 9);
        this.chestplate.setRotationPoint(0.0F, 1.5F, -0.0F);
        this.chestplate.addBox(-6.5F, 0.0F, -3.0F, 9, 5, 6, 0.0F);
        this.bagstrap = new ModelRenderer(this, 63, 10);
        this.bagstrap.setRotationPoint(-2.5F, -1.0F, -0.0F);
        this.bagstrap.addBox(-0.5F, 0.0F, -3.5F, 1, 15, 7, 0.0F);
        this.setRotateAngle(bagstrap, 0.0F, 0.0F, -0.5235987755982988F);
        this.chestplate_side = new ModelRenderer(this, 6, 32);
        this.chestplate_side.setRotationPoint(-0.5F, 3.0F, 0.0F);
        this.chestplate_side.addBox(3.0F, 0.0F, -3.0F, 3, 2, 6, 0.0F);
        this.shoulderpad = new ModelRenderer(this, 31, 10);
        this.shoulderpad.setRotationPoint(0.0F, -0.5F, -0.0F);
        this.shoulderpad.addBox(3.0F, 0.0F, -3.5F, 5, 4, 7, 0.0F);
        this.neck = new ModelRenderer(this, 24, 10);
        this.neck.setRotationPoint(0.0F, -2.0F, -0.0F);
        this.neck.addBox(-2.0F, 0.0F, -1.5F, 4, 2, 3, 0.0F);
        this.jaw = new ModelRenderer(this, 0, 40);
        this.jaw.setRotationPoint(0.0F, 0.5F, -0.0F);
        this.jaw.addBox(-3.5F, -8.0F, -3.5F, 7, 8, 7, 0.0F);
        this.setRotateAngle(jaw, 0.091106186954104F, 0.0F, 0.13962634015954636F);
        this.strap = new ModelRenderer(this, 50, 29);
        this.strap.setRotationPoint(0.0F, -2.0F, -0.0F);
        this.strap.addBox(-5.0F, 0.0F, -3.5F, 2, 3, 7, 0.0F);
        this.leg_protecc = new ModelRenderer(this, 30, 21);
        this.leg_protecc.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.leg_protecc.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(leg_protecc, 0.0F, 0.7853981633974483F, 0.0F);
        this.chestplate_tear = new ModelRenderer(this, 62, 33);
        this.chestplate_tear.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.chestplate_tear.addBox(3.0F, 0.0F, -3.0F, 1, 1, 6, 0.0F);
        this.leg_left_1 = new ModelRenderer(this, 22, 20);
        this.leg_left_1.setRotationPoint(0.0F, 9.5F, -0.2F);
        this.leg_left_1.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(leg_left_1, 0.5759586531581287F, 0.0F, 0.05235987755982988F);
        this.leg_right_1 = new ModelRenderer(this, 70, 0);
        this.leg_right_1.setRotationPoint(0.0F, 9.5F, -0.2F);
        this.leg_right_1.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(leg_right_1, 0.5759586531581287F, 0.0F, -0.05235987755982988F);
        this.arm_protecc = new ModelRenderer(this, 0, 27);
        this.arm_protecc.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.arm_protecc.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(arm_protecc, 0.0F, 0.7853981633974483F, 0.0F);
        this.arm_right.addChild(this.arm_right_1);
        this.head.addChild(this.hat);
        this.hip.addChild(this.leg_right);
        this.body.addChild(this.lower_body);
        this.arm_left.addChild(this.arm_left_1);
        this.hip.addChild(this.leg_left);
        this.shoulderpad.addChild(this.shoulderpad_side);
        this.chestplate.addChild(this.spear);
        this.bagstrap.addChild(this.bag);
        this.spear.addChild(this.speartip_1);
        this.body.addChild(this.arm_left);
        this.lower_body.addChild(this.hip);
        this.spear.addChild(this.speartip);
        this.jaw.addChild(this.head);
        this.chestplate.addChild(this.chestplate_1);
        this.body.addChild(this.arm_right);
        this.body.addChild(this.chestplate);
        this.body.addChild(this.bagstrap);
        this.chestplate.addChild(this.chestplate_side);
        this.body.addChild(this.shoulderpad);
        this.body.addChild(this.neck);
        this.neck.addChild(this.jaw);
        this.chestplate.addChild(this.strap);
        this.leg_left_1.addChild(this.leg_protecc);
        this.chestplate_side.addChild(this.chestplate_tear);
        this.leg_left.addChild(this.leg_left_1);
        this.leg_right.addChild(this.leg_right_1);
        this.arm_right_1.addChild(this.arm_protecc);
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
