package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icarian_fisshh - Shado47
 * Created using Tabula 7.0.0
 */
public class icarian_fisshh extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer rear_fin;
    public ModelRenderer right_arm;
    public ModelRenderer left_arm;

    public icarian_fisshh() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.right_arm = new ModelRenderer(this, 14, 6);
        this.right_arm.setRotationPoint(-0.25F, -2.0F, -3.0F);
        this.right_arm.addBox(0.0F, 0.0F, 0.0F, 0, 4, 7, 0.0F);
        this.setRotateAngle(right_arm, 0.0F, 0.7853981633974483F, 1.5707963267948966F);
        this.left_arm = new ModelRenderer(this, 0, 6);
        this.left_arm.setRotationPoint(0.25F, -2.0F, -3.0F);
        this.left_arm.addBox(0.0F, -4.0F, 0.0F, 0, 4, 7, 0.0F);
        this.setRotateAngle(left_arm, 0.0F, 0.7853981633974483F, 1.5707963267948966F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-0.5F, -5.0F, -5.0F, 1, 6, 6, 0.0F);
        this.setRotateAngle(body, 0.7853981633974483F, 0.0F, 0.0F);
        this.rear_fin = new ModelRenderer(this, 0, 20);
        this.rear_fin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rear_fin.addBox(0.0F, 0.0F, 0.0F, 0, 6, 6, 0.0F);
        this.body.addChild(this.right_arm);
        this.body.addChild(this.left_arm);
        this.body.addChild(this.rear_fin);
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
