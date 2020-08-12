package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_cerver - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_cerver_head extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer mouth;
    public ModelRenderer ear_right;
    public ModelRenderer ear_left;
    public ModelRenderer jaw;
    public ModelRenderer mouth_1;

    public icaria_cerver_head() {
        this.textureWidth = 96;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 66, 21);
        this.head.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.head.addBox(-3.0F, -2.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(head, 0.045553093477052F, 0.0F, 0.0F);
        this.jaw = new ModelRenderer(this, 24, 18);
        this.jaw.setRotationPoint(0.0F, 2.0F, -0.6F);
        this.jaw.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
        this.ear_right = new ModelRenderer(this, 0, 0);
        this.ear_right.setRotationPoint(-2.2F, -3.8F, 0.0F);
        this.ear_right.addBox(0.0F, 0.0F, -0.5F, 3, 4, 1, 0.0F);
        this.setRotateAngle(ear_right, 0.0F, -0.5235987755982988F, 0.7853981633974483F);
        this.ear_left = new ModelRenderer(this, 30, 0);
        this.ear_left.setRotationPoint(2.2F, -3.8F, 0.0F);
        this.ear_left.addBox(0.0F, 0.0F, -0.5F, 4, 3, 1, 0.0F);
        this.setRotateAngle(ear_left, 0.5235987755982988F, 0.0F, 0.7853981633974483F);
        this.mouth_1 = new ModelRenderer(this, 12, 44);
        this.mouth_1.setRotationPoint(0.0F, 2.0F, 0.3F);
        this.mouth_1.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 4, 0.0F);
        this.mouth = new ModelRenderer(this, 12, 20);
        this.mouth.setRotationPoint(0.0F, 1.0F, -3.0F);
        this.mouth.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 4, 0.0F);
        this.mouth.addChild(this.jaw);
        this.head.addChild(this.ear_right);
        this.head.addChild(this.ear_left);
        this.mouth.addChild(this.mouth_1);
        this.head.addChild(this.mouth);
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
