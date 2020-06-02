package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_forest_hag_olive - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_forest_hag_olive_head extends ModelBase {
    public ModelRenderer head;

    public icaria_forest_hag_olive_head() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.head = new ModelRenderer(this, 104, 0);
        this.head.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.head.addBox(-3.0F, -8.0F, -3.0F, 6, 8, 6, 0.0F);
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
