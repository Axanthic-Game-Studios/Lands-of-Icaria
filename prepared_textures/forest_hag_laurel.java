package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * forest_hag_laurel - Shado47
 * Created using Tabula 7.0.0
 */
public class forest_hag_laurel extends ModelBase {
    public ModelRenderer pelvis;
    public ModelRenderer right_leg_upper;
    public ModelRenderer left_leg_upper;
    public ModelRenderer hip;
    public ModelRenderer leaves_hip;
    public ModelRenderer right_leg_middle;
    public ModelRenderer right_leg_lower;
    public ModelRenderer right_foot;
    public ModelRenderer left_leg_middle;
    public ModelRenderer left_leg_lower;
    public ModelRenderer left_foot;
    public ModelRenderer belly;
    public ModelRenderer chest;
    public ModelRenderer leaves_bulge;
    public ModelRenderer shoulder_right;
    public ModelRenderer arm_right_upper;
    public ModelRenderer shoulder_left;
    public ModelRenderer neck;
    public ModelRenderer vines;
    public ModelRenderer arm_right_lower;
    public ModelRenderer head;
    public ModelRenderer leaves_hat;
    public ModelRenderer leaves_hat_1;
    public ModelRenderer leaves_bulge_2;
    public ModelRenderer arm_right_upper_1;
    public ModelRenderer arm_right_lower_1;

    public forest_hag_laurel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.right_leg_upper = new ModelRenderer(this, 32, 0);
        this.right_leg_upper.setRotationPoint(-3.0F, 3.7F, 0.0F);
        this.right_leg_upper.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(right_leg_upper, -0.08726646259971647F, 0.091106186954104F, 0.0F);
        this.leaves_bulge = new ModelRenderer(this, 96, 15);
        this.leaves_bulge.setRotationPoint(0.0F, -8.5F, -0.3F);
        this.leaves_bulge.addBox(1.5F, -4.0F, -4.0F, 8, 9, 7, 0.0F);
        this.setRotateAngle(leaves_bulge, 0.3490658503988659F, -0.03490658503988659F, 0.17453292519943295F);
        this.left_leg_lower = new ModelRenderer(this, 41, 10);
        this.left_leg_lower.setRotationPoint(0.0F, 6.6F, 0.0F);
        this.left_leg_lower.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(left_leg_lower, 0.08726646259971647F, -0.091106186954104F, 0.04363323129985824F);
        this.neck = new ModelRenderer(this, 102, 31);
        this.neck.setRotationPoint(0.0F, -2.0F, -0.8F);
        this.neck.addBox(-2.0F, -6.0F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(neck, 0.8651597102135892F, -0.17453292519943295F, 0.0F);
        this.arm_right_upper = new ModelRenderer(this, 0, 26);
        this.arm_right_upper.setRotationPoint(-8.0F, -2.5F, 0.0F);
        this.arm_right_upper.addBox(-4.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
        this.setRotateAngle(arm_right_upper, -0.27314402793711257F, -0.136659280431156F, 0.136659280431156F);
        this.leaves_hat_1 = new ModelRenderer(this, 32, 37);
        this.leaves_hat_1.setRotationPoint(0.0F, -1.1F, 0.0F);
        this.leaves_hat_1.addBox(-3.0F, -2.0F, -3.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(leaves_hat_1, 0.136659280431156F, 0.0F, -0.136659280431156F);
        this.right_leg_middle = new ModelRenderer(this, 29, 8);
        this.right_leg_middle.setRotationPoint(0.0F, 3.9F, 0.0F);
        this.right_leg_middle.addBox(-1.5F, -0.5F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(right_leg_middle, 0.08726646259971647F, 0.0F, 0.0F);
        this.arm_right_upper_1 = new ModelRenderer(this, 36, 45);
        this.arm_right_upper_1.setRotationPoint(3.3F, 0.4F, -0.5F);
        this.arm_right_upper_1.addBox(0.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotateAngle(arm_right_upper_1, -0.4553564018453205F, -0.4553564018453205F, -1.0471975511965976F);
        this.right_leg_lower = new ModelRenderer(this, 60, 8);
        this.right_leg_lower.setRotationPoint(0.0F, 6.6F, 0.0F);
        this.right_leg_lower.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(right_leg_lower, 0.08726646259971647F, -0.091106186954104F, 0.0F);
        this.right_foot = new ModelRenderer(this, 0, 9);
        this.right_foot.setRotationPoint(0.0F, 3.1F, 0.0F);
        this.right_foot.addBox(-2.5F, 0.0F, -2.5F, 5, 3, 5, 0.0F);
        this.setRotateAngle(right_foot, 0.0F, 0.136659280431156F, 0.0F);
        this.leaves_bulge_2 = new ModelRenderer(this, 86, 41);
        this.leaves_bulge_2.setRotationPoint(5.2F, -1.0F, -1.5F);
        this.leaves_bulge_2.addBox(0.0F, -4.0F, -4.0F, 7, 8, 7, 0.0F);
        this.setRotateAngle(leaves_bulge_2, 0.3490658503988659F, -0.03490658503988659F, 0.5462880558742251F);
        this.leaves_hip = new ModelRenderer(this, 92, 0);
        this.leaves_hip.setRotationPoint(0.0F, 2.8F, 0.7F);
        this.leaves_hip.addBox(-5.0F, -4.0F, -3.5F, 5, 8, 6, 0.0F);
        this.setRotateAngle(leaves_hip, 0.091106186954104F, 0.0F, 0.7740535232594852F);
        this.vines = new ModelRenderer(this, 0, 64);
        this.vines.setRotationPoint(0.0F, -4.0F, 3.5F);
        this.vines.addBox(-6.0F, 0.0F, 0.0F, 12, 16, 0, 0.0F);
        this.setRotateAngle(vines, 0.04363323129985824F, 0.0F, 0.0F);
        this.chest = new ModelRenderer(this, 35, 18);
        this.chest.setRotationPoint(0.0F, -3.5F, 0.0F);
        this.chest.addBox(-6.0F, -4.0F, -3.0F, 12, 4, 6, 0.0F);
        this.setRotateAngle(chest, 0.08726646259971647F, 0.06981317007977318F, 0.04363323129985824F);
        this.left_foot = new ModelRenderer(this, 83, 15);
        this.left_foot.setRotationPoint(0.0F, 3.1F, 0.0F);
        this.left_foot.addBox(-2.5F, 0.0F, -2.5F, 5, 2, 5, 0.0F);
        this.setRotateAngle(left_foot, 0.0F, 0.136659280431156F, 0.04363323129985824F);
        this.left_leg_upper = new ModelRenderer(this, 48, 0);
        this.left_leg_upper.setRotationPoint(3.0F, 3.7F, 0.0F);
        this.left_leg_upper.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(left_leg_upper, -0.08726646259971647F, -0.091106186954104F, -0.08726646259971647F);
        this.left_leg_middle = new ModelRenderer(this, 76, 8);
        this.left_leg_middle.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.left_leg_middle.addBox(-1.5F, 0.5F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(left_leg_middle, 0.08726646259971647F, 0.0F, 0.0F);
        this.hip = new ModelRenderer(this, 64, 0);
        this.hip.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.hip.addBox(-5.0F, -4.0F, -2.0F, 10, 4, 4, 0.0F);
        this.setRotateAngle(hip, 0.0F, 0.06981317007977318F, 0.04363323129985824F);
        this.arm_right_lower = new ModelRenderer(this, 50, 28);
        this.arm_right_lower.setRotationPoint(-1.5F, 13.3F, 0.0F);
        this.arm_right_lower.addBox(-2.0F, 0.0F, -1.5F, 3, 12, 3, 0.0F);
        this.setRotateAngle(arm_right_lower, -0.136659280431156F, -0.045553093477052F, -0.18203784098300857F);
        this.pelvis = new ModelRenderer(this, 0, 0);
        this.pelvis.setRotationPoint(0.0F, 3.8F, 0.0F);
        this.pelvis.addBox(-5.5F, 0.0F, -2.5F, 11, 4, 5, 0.0F);
        this.setRotateAngle(pelvis, -0.08726646259971647F, 0.0F, 0.0F);
        this.belly = new ModelRenderer(this, 0, 17);
        this.belly.setRotationPoint(0.0F, -3.5F, 0.0F);
        this.belly.addBox(-5.5F, -4.0F, -2.5F, 11, 4, 5, 0.0F);
        this.setRotateAngle(belly, 0.08726646259971647F, 0.06981317007977318F, 0.04363323129985824F);
        this.shoulder_right = new ModelRenderer(this, 64, 24);
        this.shoulder_right.setRotationPoint(0.0F, -4.5F, 0.2F);
        this.shoulder_right.addBox(-9.0F, -4.0F, -3.5F, 12, 5, 7, 0.0F);
        this.setRotateAngle(shoulder_right, 0.03490658503988659F, -0.045553093477052F, -0.04363323129985824F);
        this.shoulder_left = new ModelRenderer(this, 16, 28);
        this.shoulder_left.setRotationPoint(-0.5F, 1.2F, 0.0F);
        this.shoulder_left.addBox(-2.0F, -4.0F, -2.5F, 12, 4, 5, 0.0F);
        this.setRotateAngle(shoulder_left, 0.03490658503988659F, 0.136659280431156F, 0.36425021489121656F);
        this.arm_right_lower_1 = new ModelRenderer(this, 115, 38);
        this.arm_right_lower_1.setRotationPoint(1.5F, 8.0F, 0.0F);
        this.arm_right_lower_1.addBox(-1.0F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(arm_right_lower_1, -0.18203784098300857F, 0.091106186954104F, 0.27314402793711257F);
        this.leaves_hat = new ModelRenderer(this, 8, 37);
        this.leaves_hat.setRotationPoint(0.0F, -3.2F, -3.0F);
        this.leaves_hat.addBox(-4.0F, -2.0F, -4.0F, 8, 2, 8, 0.0F);
        this.setRotateAngle(leaves_hat, 0.0F, 0.0F, 0.06981317007977318F);
        this.head = new ModelRenderer(this, 62, 36);
        this.head.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.head.addBox(-3.0F, -3.5F, -6.0F, 6, 8, 6, 0.0F);
        this.setRotateAngle(head, -0.9162978572970231F, 0.0F, 0.0F);
        this.pelvis.addChild(this.right_leg_upper);
        this.belly.addChild(this.leaves_bulge);
        this.left_leg_middle.addChild(this.left_leg_lower);
        this.shoulder_right.addChild(this.neck);
        this.shoulder_right.addChild(this.arm_right_upper);
        this.leaves_hat.addChild(this.leaves_hat_1);
        this.right_leg_upper.addChild(this.right_leg_middle);
        this.leaves_bulge_2.addChild(this.arm_right_upper_1);
        this.right_leg_middle.addChild(this.right_leg_lower);
        this.right_leg_lower.addChild(this.right_foot);
        this.leaves_bulge.addChild(this.leaves_bulge_2);
        this.pelvis.addChild(this.leaves_hip);
        this.shoulder_right.addChild(this.vines);
        this.belly.addChild(this.chest);
        this.left_leg_lower.addChild(this.left_foot);
        this.pelvis.addChild(this.left_leg_upper);
        this.left_leg_upper.addChild(this.left_leg_middle);
        this.pelvis.addChild(this.hip);
        this.arm_right_upper.addChild(this.arm_right_lower);
        this.hip.addChild(this.belly);
        this.chest.addChild(this.shoulder_right);
        this.shoulder_right.addChild(this.shoulder_left);
        this.arm_right_upper_1.addChild(this.arm_right_lower_1);
        this.head.addChild(this.leaves_hat);
        this.neck.addChild(this.head);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.pelvis.render(f5);
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
