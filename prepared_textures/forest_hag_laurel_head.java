package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * forest_hag_laurel_head - Shado47
 * Created using Tabula 7.0.0
 */
public class forest_hag_laurel_head extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer leaves_hat;
    public ModelRenderer leaves_hat_1;

    public forest_hag_laurel_head() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.leaves_hat = new ModelRenderer(this, 8, 37);
        this.leaves_hat.setRotationPoint(0.0F, -3.2F, -3.0F);
        this.leaves_hat.addBox(-4.0F, -2.0F, -1.0F, 8, 2, 8, 0.0F);
        this.setRotateAngle(leaves_hat, 0.0F, 0.0F, 0.06981317007977318F);
        this.leaves_hat_1 = new ModelRenderer(this, 32, 37);
        this.leaves_hat_1.setRotationPoint(0.0F, -0.6F, 0.0F);
        this.leaves_hat_1.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(leaves_hat_1, 0.136659280431156F, 0.0F, -0.136659280431156F);
        this.head = new ModelRenderer(this, 62, 36);
        this.head.setRotationPoint(0.0F, 19.5F, 0.0F);
        this.head.addBox(-3.0F, -3.5F, -3.0F, 6, 8, 6, 0.0F);
        this.head.addChild(this.leaves_hat);
        this.leaves_hat.addChild(this.leaves_hat_1);
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
