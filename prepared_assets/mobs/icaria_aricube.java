package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * icaria_aricube - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_aricube extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer left_eye;
    public ModelRenderer right_eye;

    public icaria_aricube() {
        this.textureWidth = 64;
        this.textureHeight = 48;
        this.body = new ModelRenderer(this, 0, 14);
        this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.body.addBox(-6.0F, -6.0F, -6.0F, 12, 12, 12, 0.0F);
        this.right_eye = new ModelRenderer(this, 33, 0);
        this.right_eye.setRotationPoint(-1.0F, 3.0F, -1.0F);
        this.right_eye.addBox(-3.0F, -3.0F, -3.0F, 3, 3, 3, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.head.addBox(-3.5F, -3.5F, -3.5F, 7, 7, 7, 0.0F);
        this.setRotateAngle(head, -0.08726646259971647F, 0.0F, 0.0F);
        this.left_eye = new ModelRenderer(this, 21, 0);
        this.left_eye.setRotationPoint(4.0F, 3.0F, -1.0F);
        this.left_eye.addBox(-3.0F, -3.0F, -3.0F, 3, 3, 3, 0.0F);
        this.head.addChild(this.right_eye);
        this.head.addChild(this.left_eye);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
        this.body.render(f5);
        GlStateManager.disableBlend();
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
