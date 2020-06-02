package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_forest_hag_olive - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_forest_hag_olive extends ModelBase {
    public ModelRenderer leg_right_top;
    public ModelRenderer leg_left_top;
    public ModelRenderer pelvis;
    public ModelRenderer leg_right_middle;
    public ModelRenderer leg_right_bottom;
    public ModelRenderer leg_left_middle;
    public ModelRenderer leg_left_bottom;
    public ModelRenderer leg_left_foot;
    public ModelRenderer hip;
    public ModelRenderer belly;
    public ModelRenderer chest;
    public ModelRenderer shoulders;
    public ModelRenderer arm_left;
    public ModelRenderer shoulder_right;
    public ModelRenderer neck;
    public ModelRenderer leaves_coat;
    public ModelRenderer leaves_left_sleeve;
    public ModelRenderer fern;
    public ModelRenderer fern_1;
    public ModelRenderer arm_left_bottom;
    public ModelRenderer arm_right;
    public ModelRenderer arm_right_bottom;
    public ModelRenderer head;
    public ModelRenderer leaves_sidecut;

    public icaria_forest_hag_olive() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.leg_right_middle = new ModelRenderer(this, 64, 64);
        this.leg_right_middle.setRotationPoint(0.0F, 5.5F, 0.0F);
        this.leg_right_middle.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(leg_right_middle, 0.091106186954104F, -0.091106186954104F, 0.0F);
        this.shoulder_right = new ModelRenderer(this, 0, 94);
        this.shoulder_right.setRotationPoint(-6.0F, -2.0F, -0.5F);
        this.shoulder_right.addBox(-7.0F, 0.0F, -3.5F, 12, 5, 3, 0.0F);
        this.setRotateAngle(shoulder_right, 0.39269908169872414F, 0.0F, -0.39269908169872414F);
        this.leaves_left_sleeve = new ModelRenderer(this, 0, 0);
        this.leaves_left_sleeve.setRotationPoint(9.5F, 1.0F, -1.0F);
        this.leaves_left_sleeve.addBox(0.0F, 0.0F, -2.0F, 2, 12, 4, 0.0F);
        this.setRotateAngle(leaves_left_sleeve, -0.091106186954104F, 0.0F, -0.31869712141416456F);
        this.leg_left_top = new ModelRenderer(this, 0, 15);
        this.leg_left_top.setRotationPoint(4.0F, 7.0F, 0.0F);
        this.leg_left_top.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(leg_left_top, -0.091106186954104F, -0.18203784098300857F, 0.0F);
        this.leg_left_middle = new ModelRenderer(this, 0, 32);
        this.leg_left_middle.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.leg_left_middle.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(leg_left_middle, -0.091106186954104F, -0.091106186954104F, 0.0F);
        this.pelvis = new ModelRenderer(this, 0, 57);
        this.pelvis.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.pelvis.addBox(-6.2F, 0.0F, -1.8F, 13, 4, 5, 0.0F);
        this.setRotateAngle(pelvis, -0.18203784098300857F, 0.0F, -0.091106186954104F);
        this.fern = new ModelRenderer(this, 24, 100);
        this.fern.setRotationPoint(6.0F, 0.0F, 0.2F);
        this.fern.addBox(0.0F, -16.0F, -6.0F, 0, 16, 12, 0.0F);
        this.setRotateAngle(fern, 0.0F, -0.39269908169872414F, 0.0F);
        this.leg_left_bottom = new ModelRenderer(this, 0, 46);
        this.leg_left_bottom.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.leg_left_bottom.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(leg_left_bottom, 0.091106186954104F, 0.091106186954104F, 0.0F);
        this.arm_left = new ModelRenderer(this, 12, 0);
        this.arm_left.setRotationPoint(8.0F, 2.0F, -1.0F);
        this.arm_left.addBox(0.0F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.setRotateAngle(arm_left, -0.091106186954104F, 0.0F, -0.18203784098300857F);
        this.neck = new ModelRenderer(this, 88, 0);
        this.neck.setRotationPoint(0.5F, 1.5F, -1.0F);
        this.neck.addBox(-2.0F, -6.0F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(neck, 0.7853981633974483F, 0.0F, 0.0F);
        this.hip = new ModelRenderer(this, 0, 67);
        this.hip.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.hip.addBox(-6.2F, 0.0F, -0.8F, 12, 4, 4, 0.0F);
        this.setRotateAngle(hip, -0.18203784098300857F, 0.0F, -0.091106186954104F);
        this.shoulders = new ModelRenderer(this, 0, 102);
        this.shoulders.setRotationPoint(1.0F, -4.0F, 0.0F);
        this.shoulders.addBox(-7.0F, 0.0F, -3.5F, 18, 5, 5, 0.0F);
        this.setRotateAngle(shoulders, 0.18203784098300857F, 0.0F, 0.091106186954104F);
        this.chest = new ModelRenderer(this, 0, 85);
        this.chest.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.chest.addBox(-5.5F, 0.0F, -2.0F, 12, 4, 4, 0.0F);
        this.setRotateAngle(chest, 0.18203784098300857F, 0.0F, 0.091106186954104F);
        this.arm_right = new ModelRenderer(this, 36, 0);
        this.arm_right.setRotationPoint(-6.0F, 2.0F, -2.0F);
        this.arm_right.addBox(0.0F, 0.0F, -1.5F, 2, 10, 2, 0.0F);
        this.setRotateAngle(arm_right, -0.5918411493512771F, 0.0F, 0.39269908169872414F);
        this.fern_1 = new ModelRenderer(this, 0, 100);
        this.fern_1.setRotationPoint(6.0F, 0.0F, 0.2F);
        this.fern_1.addBox(0.0F, -16.0F, -6.0F, 0, 16, 12, 0.0F);
        this.setRotateAngle(fern_1, 0.0F, 1.1780972450961724F, 0.0F);
        this.belly = new ModelRenderer(this, 0, 76);
        this.belly.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.belly.addBox(-5.5F, 0.0F, -0.8F, 11, 5, 3, 0.0F);
        this.setRotateAngle(belly, 0.091106186954104F, 0.0F, 0.091106186954104F);
        this.leg_right_bottom = new ModelRenderer(this, 96, 80);
        this.leg_right_bottom.setRotationPoint(0.0F, 6.5F, 0.0F);
        this.leg_right_bottom.addBox(-2.5F, 0.0F, -2.5F, 4, 5, 4, 0.0F);
        this.setRotateAngle(leg_right_bottom, 0.0F, -0.091106186954104F, 0.0F);
        this.leg_left_foot = new ModelRenderer(this, 32, 32);
        this.leg_left_foot.setRotationPoint(0.0F, 7.2F, 0.0F);
        this.leg_left_foot.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(leg_left_foot, 0.091106186954104F, 0.091106186954104F, 0.045553093477052F);
        this.leaves_coat = new ModelRenderer(this, 96, 106);
        this.leaves_coat.setRotationPoint(2.0F, 0.0F, 1.5F);
        this.leaves_coat.addBox(-8.0F, 0.0F, 0.0F, 14, 20, 2, 0.0F);
        this.arm_right_bottom = new ModelRenderer(this, 44, 0);
        this.arm_right_bottom.setRotationPoint(1.0F, 9.5F, -0.5F);
        this.arm_right_bottom.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.setRotateAngle(arm_right_bottom, -0.18203784098300857F, 0.0F, -0.091106186954104F);
        this.leg_right_top = new ModelRenderer(this, 44, 44);
        this.leg_right_top.setRotationPoint(-4.0F, 7.0F, 0.0F);
        this.leg_right_top.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(leg_right_top, -0.091106186954104F, 0.18203784098300857F, 0.0F);
        this.arm_left_bottom = new ModelRenderer(this, 24, 0);
        this.arm_left_bottom.setRotationPoint(0.0F, 9.5F, 0.0F);
        this.arm_left_bottom.addBox(0.0F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.setRotateAngle(arm_left_bottom, -0.18203784098300857F, 0.0F, 0.091106186954104F);
        this.head = new ModelRenderer(this, 104, 0);
        this.head.setRotationPoint(0.0F, -4.5F, 0.2F);
        this.head.addBox(-3.0F, -5.0F, -6.0F, 6, 8, 6, 0.0F);
        this.setRotateAngle(head, -0.8726646259971648F, 0.0F, 0.0F);
        this.leaves_sidecut = new ModelRenderer(this, 112, 14);
        this.leaves_sidecut.setRotationPoint(-1.5F, -5.0F, -2.5F);
        this.leaves_sidecut.addBox(-2.0F, 0.0F, -3.0F, 2, 12, 6, 0.0F);
        this.setRotateAngle(leaves_sidecut, 0.0F, 0.0F, 0.18203784098300857F);
        this.leg_right_top.addChild(this.leg_right_middle);
        this.shoulders.addChild(this.shoulder_right);
        this.shoulders.addChild(this.leaves_left_sleeve);
        this.leg_left_top.addChild(this.leg_left_middle);
        this.shoulders.addChild(this.fern);
        this.leg_left_middle.addChild(this.leg_left_bottom);
        this.shoulders.addChild(this.arm_left);
        this.shoulders.addChild(this.neck);
        this.pelvis.addChild(this.hip);
        this.chest.addChild(this.shoulders);
        this.belly.addChild(this.chest);
        this.shoulder_right.addChild(this.arm_right);
        this.shoulders.addChild(this.fern_1);
        this.hip.addChild(this.belly);
        this.leg_right_middle.addChild(this.leg_right_bottom);
        this.leg_left_bottom.addChild(this.leg_left_foot);
        this.shoulders.addChild(this.leaves_coat);
        this.arm_right.addChild(this.arm_right_bottom);
        this.arm_left.addChild(this.arm_left_bottom);
        this.neck.addChild(this.head);
        this.head.addChild(this.leaves_sidecut);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.leg_left_top.render(f5);
        this.pelvis.render(f5);
        this.leg_right_top.render(f5);
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
