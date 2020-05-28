package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_revenant_overgrown - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_revenant_overgrown extends ModelBase {
    public ModelRenderer leg_right;
    public ModelRenderer arm_right;
    public ModelRenderer arm_left;
    public ModelRenderer skull;
    public ModelRenderer spine;
    public ModelRenderer leg_left;
    public ModelRenderer leg_right_bottom;
    public ModelRenderer arm_right_lower;
    public ModelRenderer arm_left_lower;
    public ModelRenderer arm_crystal;
    public ModelRenderer upper_jaw;
    public ModelRenderer crystal_head_1;
    public ModelRenderer crystal_head_2;
    public ModelRenderer crystal_head_3;
    public ModelRenderer crystal_head_4;
    public ModelRenderer crystal_head_5;
    public ModelRenderer lower_jaw;
    public ModelRenderer front_chest_bone;
    public ModelRenderer rib_top_back_right;
    public ModelRenderer rib_top_back_left;
    public ModelRenderer rib_2nd_back_left;
    public ModelRenderer rib_3rd_back_right;
    public ModelRenderer rib_3rd_back_left;
    public ModelRenderer rib_4th_back_left;
    public ModelRenderer rib_5th_back_left;
    public ModelRenderer spine_legplate_top;
    public ModelRenderer rib_4th_back_right;
    public ModelRenderer rib_5th_back_right;
    public ModelRenderer spine_lower;
    public ModelRenderer shoulder_crystal_1;
    public ModelRenderer shoulder_crystal_2;
    public ModelRenderer rib_2nd_back_right;
    public ModelRenderer shoulder_crystal_3;
    public ModelRenderer shoulder_crystal_4;
    public ModelRenderer vines_coat;
    public ModelRenderer rib_top_backplate_right;
    public ModelRenderer rib_top_side_right;
    public ModelRenderer rib_top_front_right;
    public ModelRenderer rib_top_side_left;
    public ModelRenderer rib_top_front_left;
    public ModelRenderer rib_2nd_side_left;
    public ModelRenderer rib_2nd_front_left;
    public ModelRenderer rib_3rd_side_right;
    public ModelRenderer rib_3rd_front_right;
    public ModelRenderer rib_3rd_side_left;
    public ModelRenderer rib_3rd_front_left;
    public ModelRenderer rib_4th_side_left;
    public ModelRenderer rib_4th_front_left;
    public ModelRenderer rib_5th_side_left;
    public ModelRenderer rib_5th_front_left;
    public ModelRenderer spine_legplate_bottom;
    public ModelRenderer pelvis_crystal_1;
    public ModelRenderer pelvis_crystal_2;
    public ModelRenderer pelvis_crystal_3;
    public ModelRenderer spine_legplate_right;
    public ModelRenderer spine_legplate_left;
    public ModelRenderer rib_4th_side_right;
    public ModelRenderer rib_4th_front_right;
    public ModelRenderer rib_5th_side_right;
    public ModelRenderer rib_5th_front_right;
    public ModelRenderer rib_2nd_side_right;
    public ModelRenderer rib_2nd_front_right;
    public ModelRenderer leg_left_bottom;
    public ModelRenderer leg_crystal_1;
    public ModelRenderer leg_crystal_2;
    public ModelRenderer leg_crystal_3;

    public icaria_revenant_overgrown() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.arm_left = new ModelRenderer(this, 62, 0);
        this.arm_left.mirror = true;
        this.arm_left.setRotationPoint(6.0F, -2.0F, -2.5F);
        this.arm_left.addBox(-0.2F, 0.0F, -0.5F, 2, 7, 2, 0.0F);
        this.setRotateAngle(arm_left, -0.08726646259971647F, 0.0F, -0.12391837689159739F);
        this.crystal_head_1 = new ModelRenderer(this, 0, 56);
        this.crystal_head_1.setRotationPoint(-1.5F, -8.0F, -2.0F);
        this.crystal_head_1.addBox(-1.0F, -6.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(crystal_head_1, 0.0F, -0.39269908169872414F, 0.0F);
        this.rib_3rd_side_right = new ModelRenderer(this, 58, 11);
        this.rib_3rd_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_3rd_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
        this.lower_jaw = new ModelRenderer(this, 92, 0);
        this.lower_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lower_jaw.addBox(-2.5F, -0.8F, -3.3F, 5, 1, 6, 0.0F);
        this.setRotateAngle(lower_jaw, 0.10471975511965977F, 0.0F, 0.0F);
        this.pelvis_crystal_3 = new ModelRenderer(this, 40, 56);
        this.pelvis_crystal_3.setRotationPoint(-2.5F, 1.6F, 0.6F);
        this.pelvis_crystal_3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(pelvis_crystal_3, -2.231054382824351F, 1.9123572614101867F, 0.31869712141416456F);
        this.spine_legplate_left = new ModelRenderer(this, 19, 14);
        this.spine_legplate_left.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.spine_legplate_left.addBox(1.8F, 0.5F, -1.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(spine_legplate_left, 0.20943951023931953F, 0.10471975511965977F, 0.0F);
        this.leg_left = new ModelRenderer(this, 38, 0);
        this.leg_left.mirror = true;
        this.leg_left.setRotationPoint(2.5F, 10.2F, 0.1F);
        this.leg_left.addBox(-0.6F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(leg_left, -0.10471975511965977F, -0.20943951023931953F, 0.0F);
        this.rib_top_side_left = new ModelRenderer(this, 106, 9);
        this.rib_top_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_top_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F);
        this.rib_3rd_side_left = new ModelRenderer(this, 82, 11);
        this.rib_3rd_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_3rd_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
        this.arm_left_lower = new ModelRenderer(this, 86, 27);
        this.arm_left_lower.mirror = true;
        this.arm_left_lower.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.arm_left_lower.addBox(-0.2F, -0.2F, -0.5F, 2, 7, 2, 0.0F);
        this.setRotateAngle(arm_left_lower, -0.10471975511965977F, 0.0F, 0.10471975511965977F);
        this.rib_5th_back_left = new ModelRenderer(this, 48, 9);
        this.rib_5th_back_left.setRotationPoint(0.3F, 3.0F, 0.0F);
        this.rib_5th_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rib_5th_back_left, 0.0F, 0.0F, 0.41887902047863906F);
        this.rib_5th_side_right = new ModelRenderer(this, 58, 11);
        this.rib_5th_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_5th_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
        this.rib_2nd_back_left = new ModelRenderer(this, 70, 7);
        this.rib_2nd_back_left.setRotationPoint(0.3F, 0.0F, 0.0F);
        this.rib_2nd_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rib_2nd_back_left, 0.0F, 0.0F, 0.10471975511965977F);
        this.arm_right_lower = new ModelRenderer(this, 78, 27);
        this.arm_right_lower.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.arm_right_lower.addBox(-1.8F, -0.2F, -0.5F, 2, 7, 2, 0.0F);
        this.setRotateAngle(arm_right_lower, -0.10471975511965977F, 0.0F, -0.10471975511965977F);
        this.leg_crystal_1 = new ModelRenderer(this, 48, 44);
        this.leg_crystal_1.setRotationPoint(0.2F, 5.0F, 0.3F);
        this.leg_crystal_1.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(leg_crystal_1, -2.41309222380736F, -0.5918411493512771F, 0.18203784098300857F);
        this.rib_4th_side_left = new ModelRenderer(this, 98, 12);
        this.rib_4th_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_4th_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
        this.leg_crystal_2 = new ModelRenderer(this, 48, 56);
        this.leg_crystal_2.setRotationPoint(0.4F, 5.0F, 0.0F);
        this.leg_crystal_2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(leg_crystal_2, -2.41309222380736F, -3.050486466635689F, 0.18203784098300857F);
        this.shoulder_crystal_2 = new ModelRenderer(this, 8, 44);
        this.shoulder_crystal_2.setRotationPoint(-0.5F, 2.0F, 1.7F);
        this.shoulder_crystal_2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(shoulder_crystal_2, 1.8212510744560826F, 0.0F, 0.7853981633974483F);
        this.pelvis_crystal_2 = new ModelRenderer(this, 40, 44);
        this.pelvis_crystal_2.setRotationPoint(-1.5F, 1.6F, 0.6F);
        this.pelvis_crystal_2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(pelvis_crystal_2, -2.231054382824351F, -2.7317893452215247F, 0.31869712141416456F);
        this.spine_lower = new ModelRenderer(this, 30, 0);
        this.spine_lower.mirror = true;
        this.spine_lower.setRotationPoint(0.02F, 7.5F, 0.4F);
        this.spine_lower.addBox(-1.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(spine_lower, -0.27314402793711257F, 0.0F, 0.0F);
        this.rib_3rd_back_left = new ModelRenderer(this, 90, 7);
        this.rib_3rd_back_left.setRotationPoint(0.4F, 1.0F, 0.0F);
        this.rib_3rd_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rib_3rd_back_left, 0.0F, 0.0F, 0.20943951023931953F);
        this.rib_4th_back_left = new ModelRenderer(this, 110, 7);
        this.rib_4th_back_left.setRotationPoint(0.4F, 2.0F, 0.0F);
        this.rib_4th_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rib_4th_back_left, 0.0F, 0.0F, 0.3141592653589793F);
        this.rib_2nd_front_right = new ModelRenderer(this, 0, 2);
        this.rib_2nd_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_2nd_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
        this.vines_coat = new ModelRenderer(this, 64, 43);
        this.vines_coat.setRotationPoint(0.03F, 0.8F, -2.5F);
        this.vines_coat.addBox(-6.0F, 0.0F, 0.0F, 12, 16, 5, 0.0F);
        this.leg_right_bottom = new ModelRenderer(this, 115, 18);
        this.leg_right_bottom.mirror = true;
        this.leg_right_bottom.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.leg_right_bottom.addBox(-1.4F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(leg_right_bottom, 0.20943951023931953F, 0.0F, 0.0F);
        this.rib_5th_front_left = new ModelRenderer(this, 44, 11);
        this.rib_5th_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_5th_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
        this.rib_3rd_front_left = new ModelRenderer(this, 22, 4);
        this.rib_3rd_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_3rd_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
        this.rib_top_backplate_right = new ModelRenderer(this, 82, 9);
        this.rib_top_backplate_right.setRotationPoint(-1.5F, -2.0F, 0.0F);
        this.rib_top_backplate_right.addBox(-5.0F, 5.5F, 0.2F, 13, 1, 1, 0.0F);
        this.rib_top_side_right = new ModelRenderer(this, 116, 7);
        this.rib_top_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_top_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F);
        this.rib_4th_back_right = new ModelRenderer(this, 80, 7);
        this.rib_4th_back_right.setRotationPoint(-0.4F, 2.0F, 0.0F);
        this.rib_4th_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rib_4th_back_right, 0.0F, 0.0F, -0.3141592653589793F);
        this.rib_5th_side_left = new ModelRenderer(this, 0, 14);
        this.rib_5th_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_5th_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
        this.spine_legplate_bottom = new ModelRenderer(this, 6, 14);
        this.spine_legplate_bottom.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.spine_legplate_bottom.addBox(-3.5F, 3.8F, -1.5F, 7, 1, 1, 0.0F);
        this.rib_2nd_front_left = new ModelRenderer(this, 22, 2);
        this.rib_2nd_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_2nd_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
        this.rib_2nd_side_left = new ModelRenderer(this, 48, 11);
        this.rib_2nd_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_2nd_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
        this.rib_4th_front_right = new ModelRenderer(this, 0, 6);
        this.rib_4th_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_4th_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
        this.spine_legplate_top = new ModelRenderer(this, 58, 9);
        this.spine_legplate_top.setRotationPoint(0.0F, 13.0F, -0.5F);
        this.spine_legplate_top.addBox(-3.5F, 0.8F, 0.5F, 7, 1, 1, 0.0F);
        this.setRotateAngle(spine_legplate_top, -0.40980330836826856F, 0.0F, 0.0F);
        this.skull = new ModelRenderer(this, 0, 0);
        this.skull.setRotationPoint(0.0F, -3.4F, -3.5F);
        this.skull.addBox(-3.5F, -8.0F, -4.0F, 7, 6, 8, 0.0F);
        this.setRotateAngle(skull, 0.19634954084936207F, 0.0F, 0.0F);
        this.leg_right = new ModelRenderer(this, 46, 0);
        this.leg_right.setRotationPoint(-2.5F, 10.2F, 0.1F);
        this.leg_right.addBox(-1.4F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(leg_right, -0.10471975511965977F, 0.20943951023931953F, 0.0F);
        this.rib_top_back_right = new ModelRenderer(this, 86, 0);
        this.rib_top_back_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_top_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 2, 1, 0.0F);
        this.arm_right = new ModelRenderer(this, 54, 0);
        this.arm_right.setRotationPoint(-6.0F, -2.0F, -2.5F);
        this.arm_right.addBox(-1.8F, 0.0F, -0.5F, 2, 7, 2, 0.0F);
        this.setRotateAngle(arm_right, -0.08726646259971647F, 0.0F, 0.12391837689159739F);
        this.spine = new ModelRenderer(this, 30, 0);
        this.spine.setRotationPoint(0.0F, -4.2F, -3.0F);
        this.spine.addBox(-1.0F, -2.0F, 0.4F, 2, 10, 2, 0.0F);
        this.setRotateAngle(spine, 0.27314402793711257F, 0.0F, 0.0F);
        this.crystal_head_4 = new ModelRenderer(this, 24, 54);
        this.crystal_head_4.setRotationPoint(-2.0F, -8.2F, -1.1F);
        this.crystal_head_4.addBox(-1.0F, -6.0F, -0.2F, 2, 8, 2, 0.0F);
        this.setRotateAngle(crystal_head_4, -1.0471975511965976F, -0.4553564018453205F, 0.0F);
        this.shoulder_crystal_4 = new ModelRenderer(this, 24, 44);
        this.shoulder_crystal_4.setRotationPoint(-3.0F, 2.3F, 0.6F);
        this.shoulder_crystal_4.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(shoulder_crystal_4, -2.5953045977155678F, 0.7740535232594852F, -0.36425021489121656F);
        this.pelvis_crystal_1 = new ModelRenderer(this, 32, 44);
        this.pelvis_crystal_1.setRotationPoint(-1.5F, 2.0F, 0.6F);
        this.pelvis_crystal_1.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(pelvis_crystal_1, -2.231054382824351F, 0.136659280431156F, -0.045553093477052F);
        this.rib_4th_side_right = new ModelRenderer(this, 58, 11);
        this.rib_4th_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_4th_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
        this.crystal_head_5 = new ModelRenderer(this, 32, 56);
        this.crystal_head_5.setRotationPoint(-2.0F, -6.5F, -1.5F);
        this.crystal_head_5.addBox(-1.0F, -4.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(crystal_head_5, -0.7285004297824331F, 0.8196066167365371F, 0.0F);
        this.shoulder_crystal_1 = new ModelRenderer(this, 0, 44);
        this.shoulder_crystal_1.setRotationPoint(-4.5F, 2.3F, 1.6F);
        this.shoulder_crystal_1.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(shoulder_crystal_1, 1.6390387005478748F, -0.5009094953223726F, 0.27314402793711257F);
        this.leg_crystal_3 = new ModelRenderer(this, 56, 56);
        this.leg_crystal_3.setRotationPoint(0.4F, 5.0F, 0.2F);
        this.leg_crystal_3.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(leg_crystal_3, -1.9577358219620393F, 1.0927506446736497F, 0.18203784098300857F);
        this.spine_legplate_right = new ModelRenderer(this, 64, 11);
        this.spine_legplate_right.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.spine_legplate_right.addBox(-3.8F, 0.5F, -1.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(spine_legplate_right, 0.20943951023931953F, -0.10471975511965977F, 0.0F);
        this.leg_left_bottom = new ModelRenderer(this, 22, 18);
        this.leg_left_bottom.mirror = true;
        this.leg_left_bottom.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.leg_left_bottom.addBox(-0.6F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(leg_left_bottom, 0.20943951023931953F, 0.0F, 0.0F);
        this.upper_jaw = new ModelRenderer(this, 70, 0);
        this.upper_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upper_jaw.addBox(-2.5F, -2.0F, -3.5F, 5, 1, 6, 0.0F);
        this.rib_top_back_left = new ModelRenderer(this, 86, 3);
        this.rib_top_back_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_top_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 2, 1, 0.0F);
        this.arm_crystal = new ModelRenderer(this, 56, 44);
        this.arm_crystal.setRotationPoint(0.6F, 5.0F, 0.8F);
        this.arm_crystal.addBox(-1.1F, 0.0F, -1.02F, 2, 6, 2, 0.0F);
        this.setRotateAngle(arm_crystal, -2.285159589636176F, -0.7853981633974483F, 0.0F);
        this.front_chest_bone = new ModelRenderer(this, 114, 0);
        this.front_chest_bone.setRotationPoint(0.0F, -2.0F, -0.2F);
        this.front_chest_bone.addBox(-2.0F, 3.5F, -2.0F, 4, 6, 1, 0.0F);
        this.rib_5th_back_right = new ModelRenderer(this, 80, 7);
        this.rib_5th_back_right.setRotationPoint(-0.3F, 3.0F, 0.0F);
        this.rib_5th_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rib_5th_back_right, 0.0F, 0.0F, -0.41887902047863906F);
        this.rib_3rd_back_right = new ModelRenderer(this, 80, 7);
        this.rib_3rd_back_right.setRotationPoint(-0.4F, 1.0F, 0.0F);
        this.rib_3rd_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rib_3rd_back_right, 0.0F, 0.0F, -0.20943951023931953F);
        this.rib_3rd_front_right = new ModelRenderer(this, 0, 4);
        this.rib_3rd_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_3rd_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
        this.rib_4th_front_left = new ModelRenderer(this, 22, 6);
        this.rib_4th_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_4th_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
        this.crystal_head_3 = new ModelRenderer(this, 16, 56);
        this.crystal_head_3.setRotationPoint(-1.5F, -7.2F, -2.0F);
        this.crystal_head_3.addBox(-1.0F, -6.0F, -0.2F, 2, 6, 2, 0.0F);
        this.setRotateAngle(crystal_head_3, -0.7285004297824331F, 1.8212510744560826F, 0.0F);
        this.rib_2nd_side_right = new ModelRenderer(this, 38, 11);
        this.rib_2nd_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_2nd_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
        this.rib_top_front_left = new ModelRenderer(this, 68, 0);
        this.rib_top_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_top_front_left.addBox(2.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F);
        this.crystal_head_2 = new ModelRenderer(this, 8, 56);
        this.crystal_head_2.setRotationPoint(-1.5F, -6.5F, -2.0F);
        this.crystal_head_2.addBox(-1.0F, -6.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(crystal_head_2, -0.7285004297824331F, -2.41309222380736F, 0.0F);
        this.shoulder_crystal_3 = new ModelRenderer(this, 16, 44);
        this.shoulder_crystal_3.setRotationPoint(-2.0F, 2.0F, 1.2F);
        this.shoulder_crystal_3.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(shoulder_crystal_3, 0.8651597102135892F, 0.0F, 0.22759093446006054F);
        this.rib_top_front_right = new ModelRenderer(this, 0, 0);
        this.rib_top_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_top_front_right.addBox(-5.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F);
        this.rib_2nd_back_right = new ModelRenderer(this, 22, 0);
        this.rib_2nd_back_right.setRotationPoint(-0.3F, 0.0F, 0.0F);
        this.rib_2nd_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rib_2nd_back_right, 0.0F, 0.0F, -0.10471975511965977F);
        this.rib_5th_front_right = new ModelRenderer(this, 0, 2);
        this.rib_5th_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.rib_5th_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
        this.skull.addChild(this.crystal_head_1);
        this.rib_3rd_back_right.addChild(this.rib_3rd_side_right);
        this.upper_jaw.addChild(this.lower_jaw);
        this.spine_legplate_top.addChild(this.pelvis_crystal_3);
        this.spine_legplate_bottom.addChild(this.spine_legplate_left);
        this.rib_top_back_left.addChild(this.rib_top_side_left);
        this.rib_3rd_back_left.addChild(this.rib_3rd_side_left);
        this.arm_left.addChild(this.arm_left_lower);
        this.spine.addChild(this.rib_5th_back_left);
        this.rib_5th_back_right.addChild(this.rib_5th_side_right);
        this.spine.addChild(this.rib_2nd_back_left);
        this.arm_right.addChild(this.arm_right_lower);
        this.leg_left_bottom.addChild(this.leg_crystal_1);
        this.rib_4th_back_left.addChild(this.rib_4th_side_left);
        this.leg_left_bottom.addChild(this.leg_crystal_2);
        this.spine.addChild(this.shoulder_crystal_2);
        this.spine_legplate_top.addChild(this.pelvis_crystal_2);
        this.spine.addChild(this.spine_lower);
        this.spine.addChild(this.rib_3rd_back_left);
        this.spine.addChild(this.rib_4th_back_left);
        this.rib_2nd_side_right.addChild(this.rib_2nd_front_right);
        this.spine.addChild(this.vines_coat);
        this.leg_right.addChild(this.leg_right_bottom);
        this.rib_5th_side_left.addChild(this.rib_5th_front_left);
        this.rib_3rd_side_left.addChild(this.rib_3rd_front_left);
        this.front_chest_bone.addChild(this.rib_top_backplate_right);
        this.rib_top_back_right.addChild(this.rib_top_side_right);
        this.spine.addChild(this.rib_4th_back_right);
        this.rib_5th_back_left.addChild(this.rib_5th_side_left);
        this.spine_legplate_top.addChild(this.spine_legplate_bottom);
        this.rib_2nd_side_left.addChild(this.rib_2nd_front_left);
        this.rib_2nd_back_left.addChild(this.rib_2nd_side_left);
        this.rib_4th_side_right.addChild(this.rib_4th_front_right);
        this.spine.addChild(this.spine_legplate_top);
        this.spine.addChild(this.rib_top_back_right);
        this.skull.addChild(this.crystal_head_4);
        this.spine.addChild(this.shoulder_crystal_4);
        this.spine_legplate_top.addChild(this.pelvis_crystal_1);
        this.rib_4th_back_right.addChild(this.rib_4th_side_right);
        this.skull.addChild(this.crystal_head_5);
        this.spine.addChild(this.shoulder_crystal_1);
        this.leg_left_bottom.addChild(this.leg_crystal_3);
        this.spine_legplate_bottom.addChild(this.spine_legplate_right);
        this.leg_left.addChild(this.leg_left_bottom);
        this.skull.addChild(this.upper_jaw);
        this.spine.addChild(this.rib_top_back_left);
        this.arm_left.addChild(this.arm_crystal);
        this.spine.addChild(this.front_chest_bone);
        this.spine.addChild(this.rib_5th_back_right);
        this.spine.addChild(this.rib_3rd_back_right);
        this.rib_3rd_side_right.addChild(this.rib_3rd_front_right);
        this.rib_4th_side_left.addChild(this.rib_4th_front_left);
        this.skull.addChild(this.crystal_head_3);
        this.rib_2nd_back_right.addChild(this.rib_2nd_side_right);
        this.rib_top_side_left.addChild(this.rib_top_front_left);
        this.skull.addChild(this.crystal_head_2);
        this.spine.addChild(this.shoulder_crystal_3);
        this.rib_top_side_right.addChild(this.rib_top_front_right);
        this.spine.addChild(this.rib_2nd_back_right);
        this.rib_5th_side_right.addChild(this.rib_5th_front_right);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.arm_left.render(f5);
        this.leg_left.render(f5);
        this.skull.render(f5);
        this.leg_right.render(f5);
        this.arm_right.render(f5);
        this.spine.render(f5);
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
