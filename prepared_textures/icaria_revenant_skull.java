package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_revenant_skull - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_revenant_skull extends ModelBase {
    public ModelRenderer skull;
    public ModelRenderer skullChild;
    public ModelRenderer skullChildChild;

    public icaria_revenant_skull() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.skullChild = new ModelRenderer(this, 70, 0);
        this.skullChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.skullChild.addBox(-2.5F, -2.0F, -3.5F, 5, 1, 6, 0.0F);
        this.skullChildChild = new ModelRenderer(this, 92, 0);
        this.skullChildChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.skullChildChild.addBox(-2.5F, -0.800000011920929F, -3.299999952316284F, 5, 1, 6, 0.0F);
        this.setRotateAngle(skullChildChild, 0.10471975803375246F, 0.0F, 0.0F);
        this.skull = new ModelRenderer(this, 0, 0);
        this.skull.setRotationPoint(0.0F, 23.8F, 0.0F);
        this.skull.addBox(-3.5F, -8.0F, -4.0F, 7, 6, 8, 0.0F);
        this.setRotateAngle(skull, -0.10471975511965977F, 0.0F, 0.0F);
        this.skull.addChild(this.skullChild);
        this.skullChild.addChild(this.skullChildChild);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.skull.render(f5);
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
