package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_sow - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_sow_head extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer hair;
    public ModelRenderer nose;
    public ModelRenderer jaw;
    public ModelRenderer ear_right;
    public ModelRenderer ear_left;
    public ModelRenderer tusk_l;
    public ModelRenderer tusk_r;

    public icaria_sow_head() {
        this.textureWidth = 64;
        this.textureHeight = 48;
        this.nose = new ModelRenderer(this, 47, 0);
        this.nose.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.nose.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(nose, 0.18203784098300857F, 0.0F, 0.0F);
        this.hair = new ModelRenderer(this, 42, 26);
        this.hair.setRotationPoint(0.0F, -2.5F, -4.1F);
        this.hair.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(hair, 0.00942477796076938F, 0.0F, 0.0F);
        this.ear_left = new ModelRenderer(this, 55, 6);
        this.ear_left.setRotationPoint(2.5F, -0.4F, -2.5F);
        this.ear_left.addBox(-2.0F, -1.0F, -0.5F, 3, 2, 1, 0.0F);
        this.setRotateAngle(ear_left, -0.36425021489121656F, 0.0F, 1.0471975511965976F);
        this.tusk_r = new ModelRenderer(this, 47, 0);
        this.tusk_r.setRotationPoint(-1.5F, 1.5F, -5.2F);
        this.tusk_r.addBox(-0.5F, -2.0F, 2.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tusk_r, 0.0F, 0.0F, -0.39269908169872414F);
        this.ear_right = new ModelRenderer(this, 47, 6);
        this.ear_right.setRotationPoint(-2.5F, -0.4F, -2.5F);
        this.ear_right.addBox(-2.0F, -1.0F, -0.5F, 3, 2, 1, 0.0F);
        this.setRotateAngle(ear_right, 0.36425021489121656F, 0.0F, 2.0943951023931953F);
        this.jaw = new ModelRenderer(this, 0, 3);
        this.jaw.setRotationPoint(0.0F, 2.0F, -5.0F);
        this.jaw.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 3, 0.0F);
        this.head = new ModelRenderer(this, 30, 11);
        this.head.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.head.addBox(-2.5F, -3.0F, -4.0F, 5, 6, 8, 0.0F);
        this.tusk_l = new ModelRenderer(this, 7, 0);
        this.tusk_l.setRotationPoint(1.5F, 1.5F, -1.2F);
        this.tusk_l.addBox(-0.5F, -2.0F, -2.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tusk_l, 0.0F, 0.0F, 0.39269908169872414F);
        this.head.addChild(this.nose);
        this.head.addChild(this.hair);
        this.head.addChild(this.ear_left);
        this.nose.addChild(this.tusk_r);
        this.head.addChild(this.ear_right);
        this.head.addChild(this.jaw);
        this.nose.addChild(this.tusk_l);
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
