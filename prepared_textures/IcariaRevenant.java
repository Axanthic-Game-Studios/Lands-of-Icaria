package blab;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelZombie - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class IcariaRevenant extends ModelBase {
    public ModelRenderer pants_right;
    public ModelRenderer skull;
    public ModelRenderer pants_left;
    public ModelRenderer hood;
    public ModelRenderer sleeve_right;
    public ModelRenderer sleeve_left;
    public ModelRenderer cape;
    public ModelRenderer robe;
    public ModelRenderer body;
    public ModelRenderer leg_right;
    public ModelRenderer leg_left;
    public ModelRenderer arm_right;
    public ModelRenderer arm_left;

    public IcariaRevenant() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body = new ModelRenderer(this, 32, 0);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 13, 4, 0.0F);
        this.sleeve_right = new ModelRenderer(this, 16, 32);
        this.sleeve_right.setRotationPoint(-4.0F, 3.0F, -0.6F);
        this.sleeve_right.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(sleeve_right, -1.3962634015954636F, 0.10000736613927509F, 0.10000736613927509F);
        this.skull = new ModelRenderer(this, 0, 0);
        this.skull.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.skull.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(skull, 0.19634954084936207F, 0.0F, 0.0F);
        this.arm_right = new ModelRenderer(this, 8, 32);
        this.arm_right.setRotationPoint(1.5F, 0.5F, 0.5F);
        this.arm_right.addBox(-3.0F, -2.0F, -2.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(arm_right, 0.0F, 0.0F, 0.10000736613927509F);
        this.sleeve_left = new ModelRenderer(this, 0, 32);
        this.sleeve_left.mirror = true;
        this.sleeve_left.setRotationPoint(4.0F, 3.0F, -0.5F);
        this.sleeve_left.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(sleeve_left, -1.2217304763960306F, -0.10000736613927509F, -0.10000736613927509F);
        this.leg_left = new ModelRenderer(this, 0, 16);
        this.leg_left.mirror = true;
        this.leg_left.setRotationPoint(1.0F, 0.0F, 0.9F);
        this.leg_left.addBox(-2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(leg_left, -0.04363323129985824F, 0.0F, 0.0F);
        this.arm_left = new ModelRenderer(this, 0, 32);
        this.arm_left.mirror = true;
        this.arm_left.setRotationPoint(-1.5F, 0.5F, 0.5F);
        this.arm_left.addBox(0.5F, -2.0F, -2.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(arm_left, 0.0F, 0.0F, -0.10000736613927509F);
        this.pants_right = new ModelRenderer(this, 16, 16);
        this.pants_right.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.pants_right.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.hood = new ModelRenderer(this, 0, 0);
        this.hood.setRotationPoint(0.0F, 1.5F, -1.0F);
        this.hood.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.setRotateAngle(hood, 0.08726646259971647F, 0.0F, 0.0F);
        this.cape = new ModelRenderer(this, 32, 16);
        this.cape.setRotationPoint(-1.0F, 0.0F, 1.5F);
        this.cape.addBox(-4.0F, 0.0F, 0.0F, 10, 16, 1, 0.0F);
        this.setRotateAngle(cape, 0.08726646259971647F, 0.0F, 0.0F);
        this.pants_left = new ModelRenderer(this, 0, 16);
        this.pants_left.mirror = true;
        this.pants_left.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.pants_left.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(pants_left, 0.08726646259971647F, 0.0F, 0.0F);
        this.leg_right = new ModelRenderer(this, 8, 16);
        this.leg_right.setRotationPoint(1.0F, 0.0F, 1.0F);
        this.leg_right.addBox(-2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
        this.robe = new ModelRenderer(this, 32, 0);
        this.robe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.robe.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.sleeve_right.addChild(this.arm_right);
        this.pants_left.addChild(this.leg_left);
        this.sleeve_left.addChild(this.arm_left);
        this.pants_right.addChild(this.leg_right);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translate(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translate(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
        this.body.render(f5);
        GlStateManager.popMatrix();
        this.sleeve_right.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.skull.offsetX, this.skull.offsetY, this.skull.offsetZ);
        GlStateManager.translate(this.skull.rotationPointX * f5, this.skull.rotationPointY * f5, this.skull.rotationPointZ * f5);
        GlStateManager.scale(0.8D, 0.8D, 0.8D);
        GlStateManager.translate(-this.skull.offsetX, -this.skull.offsetY, -this.skull.offsetZ);
        GlStateManager.translate(-this.skull.rotationPointX * f5, -this.skull.rotationPointY * f5, -this.skull.rotationPointZ * f5);
        this.skull.render(f5);
        GlStateManager.popMatrix();
        this.sleeve_left.render(f5);
        this.pants_right.render(f5);
        this.hood.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.cape.offsetX, this.cape.offsetY, this.cape.offsetZ);
        GlStateManager.translate(this.cape.rotationPointX * f5, this.cape.rotationPointY * f5, this.cape.rotationPointZ * f5);
        GlStateManager.scale(1.2D, 1.2D, 1.2D);
        GlStateManager.translate(-this.cape.offsetX, -this.cape.offsetY, -this.cape.offsetZ);
        GlStateManager.translate(-this.cape.rotationPointX * f5, -this.cape.rotationPointY * f5, -this.cape.rotationPointZ * f5);
        this.cape.render(f5);
        GlStateManager.popMatrix();
        this.pants_left.render(f5);
        this.robe.render(f5);
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
