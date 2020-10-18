package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * forest_hag_plane_head - Shado47
 * Created using Tabula 7.0.0
 */
public class forest_hag_plane_head extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer leaf_hair;

    public forest_hag_plane_head() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 99, 25);
        this.head.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.head.addBox(-3.0F, -8.0F, -3.0F, 6, 8, 6, 0.0F);
        this.leaf_hair = new ModelRenderer(this, 26, 29);
        this.leaf_hair.setRotationPoint(0.0F, -1.7F, 4.7F);
        this.leaf_hair.addBox(-3.5F, -6.4F, -1.5F, 7, 6, 3, 0.0F);
        this.setRotateAngle(leaf_hair, 0.5009094953223726F, 0.0F, 0.0F);
        this.head.addChild(this.leaf_hair);
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
