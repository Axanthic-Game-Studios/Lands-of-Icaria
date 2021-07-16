package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icarian_feesh - Shado47
 * Created using Tabula 7.0.0
 */
public class icarian_feesh extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer body_rear;
    public ModelRenderer top_fin;
    public ModelRenderer bottom_fin;
    public ModelRenderer rear_fin;
    public ModelRenderer left_fin;
    public ModelRenderer right_fin;

    public icarian_feesh() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.body.addBox(-1.0F, -2.0F, -4.0F, 2, 4, 6, 0.0F);
        this.left_fin = new ModelRenderer(this, 0, 14);
        this.left_fin.setRotationPoint(1.0F, 2.0F, -3.0F);
        this.left_fin.addBox(0.0F, -3.0F, 0.0F, 0, 3, 4, 0.0F);
        this.setRotateAngle(left_fin, 0.0F, 0.39269908169872414F, 0.0F);
        this.body_rear = new ModelRenderer(this, 0, 0);
        this.body_rear.setRotationPoint(0.0F, 1.0F, 2.0F);
        this.body_rear.addBox(-0.5F, -2.0F, 0.0F, 1, 3, 2, 0.0F);
        this.top_fin = new ModelRenderer(this, 0, 2);
        this.top_fin.setRotationPoint(0.0F, -2.0F, -4.0F);
        this.top_fin.addBox(0.0F, -4.0F, 0.0F, 0, 4, 8, 0.0F);
        this.right_fin = new ModelRenderer(this, 8, 14);
        this.right_fin.setRotationPoint(-1.0F, 2.0F, -3.0F);
        this.right_fin.addBox(0.0F, -3.0F, 0.0F, 0, 3, 4, 0.0F);
        this.setRotateAngle(right_fin, 0.0F, -0.39269908169872414F, 0.0F);
        this.bottom_fin = new ModelRenderer(this, 0, 6);
        this.bottom_fin.setRotationPoint(0.0F, 2.0F, -4.0F);
        this.bottom_fin.addBox(0.0F, 0.0F, 0.0F, 0, 4, 8, 0.0F);
        this.rear_fin = new ModelRenderer(this, 16, 1);
        this.rear_fin.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.rear_fin.addBox(0.0F, -4.0F, 0.0F, 0, 8, 5, 0.0F);
        this.body.addChild(this.left_fin);
        this.body.addChild(this.body_rear);
        this.body.addChild(this.top_fin);
        this.body.addChild(this.right_fin);
        this.body.addChild(this.bottom_fin);
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
