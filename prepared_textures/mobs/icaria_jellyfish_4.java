package icaria;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * icaria_jellyfish_4 - Shado47
 * Created using Tabula 7.0.0
 */
public class icaria_jellyfish_4 extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer lower_body;
    public ModelRenderer feelers_south;
    public ModelRenderer feelers_east;
    public ModelRenderer feelers_north;
    public ModelRenderer feelers_west;
    public ModelRenderer tentacle;
    public ModelRenderer tentacle_1;
    public ModelRenderer tentacle_2;
    public ModelRenderer tentacle_3;
    public ModelRenderer tentacle_4;
    public ModelRenderer tentaclebase;
    public ModelRenderer tentaclebase_1;
    public ModelRenderer tentaclebase_2;
    public ModelRenderer tentaclebase_3;

    public icaria_jellyfish_4() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.feelers_north = new ModelRenderer(this, 0, 41);
        this.feelers_north.setRotationPoint(0.0F, 2.0F, 6.5F);
        this.feelers_north.addBox(-6.5F, 0.0F, 0.0F, 13, 3, 0, 0.0F);
        this.setRotateAngle(feelers_north, 0.39269908169872414F, 0.0F, 0.0F);
        this.tentacle_3 = new ModelRenderer(this, 18, 50);
        this.tentacle_3.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.tentacle_3.addBox(-0.5F, 0.0F, -2.0F, 1, 12, 2, 0.0F);
        this.setRotateAngle(tentacle_3, -0.39269908169872414F, -0.7330382858376184F, 0.0F);
        this.feelers_south = new ModelRenderer(this, 0, 47);
        this.feelers_south.setRotationPoint(0.0F, 2.0F, -6.5F);
        this.feelers_south.addBox(-6.5F, 0.0F, 0.0F, 13, 3, 0, 0.0F);
        this.setRotateAngle(feelers_south, -0.39269908169872414F, 0.0F, 0.0F);
        this.tentacle_2 = new ModelRenderer(this, 12, 50);
        this.tentacle_2.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.tentacle_2.addBox(-0.5F, 0.0F, -2.0F, 1, 12, 2, 0.0F);
        this.setRotateAngle(tentacle_2, -0.39269908169872414F, 3.036872898470133F, 0.0F);
        this.tentaclebase_2 = new ModelRenderer(this, 30, 50);
        this.tentaclebase_2.setRotationPoint(0.0F, 4.0F, 3.0F);
        this.tentaclebase_2.addBox(-3.0F, -1.0F, -1.0F, 6, 2, 3, 0.0F);
        this.setRotateAngle(tentaclebase_2, 0.7853981633974483F, 0.0F, 0.0F);
        this.feelers_west = new ModelRenderer(this, 0, 38);
        this.feelers_west.setRotationPoint(-6.5F, 2.0F, 0.0F);
        this.feelers_west.addBox(-6.5F, 0.0F, 0.0F, 13, 3, 0, 0.0F);
        this.setRotateAngle(feelers_west, -0.39269908169872414F, 1.5707963267948966F, 0.0F);
        this.tentaclebase_3 = new ModelRenderer(this, 48, 50);
        this.tentaclebase_3.setRotationPoint(0.0F, 4.0F, -3.0F);
        this.tentaclebase_3.addBox(-3.0F, -2.0F, -1.0F, 6, 3, 2, 0.0F);
        this.setRotateAngle(tentaclebase_3, 0.7853981633974483F, 0.0F, 0.0F);
        this.tentacle_4 = new ModelRenderer(this, 24, 50);
        this.tentacle_4.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.tentacle_4.addBox(-0.5F, 0.0F, -2.0F, 1, 12, 2, 0.0F);
        this.setRotateAngle(tentacle_4, -0.39269908169872414F, -1.9896753472735356F, 0.0F);
        this.tentaclebase = new ModelRenderer(this, 30, 55);
        this.tentaclebase.setRotationPoint(3.0F, 4.0F, 0.0F);
        this.tentaclebase.addBox(-1.0F, -2.0F, -3.0F, 2, 3, 6, 0.0F);
        this.setRotateAngle(tentaclebase, 0.0F, 0.0F, 0.7853981633974483F);
        this.body = new ModelRenderer(this, 0, 22);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-6.5F, 0.0F, -6.5F, 13, 3, 13, 0.0F);
        this.tentacle = new ModelRenderer(this, 0, 50);
        this.tentacle.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.tentacle.addBox(-0.5F, 0.0F, -2.0F, 1, 12, 2, 0.0F);
        this.setRotateAngle(tentacle, -0.39269908169872414F, 0.5235987755982988F, 0.0F);
        this.tentaclebase_1 = new ModelRenderer(this, 46, 56);
        this.tentaclebase_1.setRotationPoint(-3.0F, 4.0F, 0.0F);
        this.tentaclebase_1.addBox(-2.0F, -1.0F, -3.0F, 3, 2, 6, 0.0F);
        this.setRotateAngle(tentaclebase_1, 0.0F, 0.0F, 0.7853981633974483F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head.addBox(-3.5F, 0.0F, -3.5F, 7, 2, 7, 0.0F);
        this.lower_body = new ModelRenderer(this, 37, 38);
        this.lower_body.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.lower_body.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.tentacle_1 = new ModelRenderer(this, 6, 50);
        this.tentacle_1.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.tentacle_1.addBox(-0.5F, 0.0F, -2.0F, 1, 12, 2, 0.0F);
        this.setRotateAngle(tentacle_1, -0.39269908169872414F, 1.780235837034216F, 0.0F);
        this.feelers_east = new ModelRenderer(this, 0, 44);
        this.feelers_east.setRotationPoint(6.5F, 2.0F, 0.0F);
        this.feelers_east.addBox(-6.5F, 0.0F, 0.0F, 13, 3, 0, 0.0F);
        this.setRotateAngle(feelers_east, 0.39269908169872414F, 1.5707963267948966F, 0.0F);
        this.body.addChild(this.feelers_north);
        this.lower_body.addChild(this.tentacle_3);
        this.body.addChild(this.feelers_south);
        this.lower_body.addChild(this.tentacle_2);
        this.lower_body.addChild(this.tentaclebase_2);
        this.body.addChild(this.feelers_west);
        this.lower_body.addChild(this.tentaclebase_3);
        this.lower_body.addChild(this.tentacle_4);
        this.lower_body.addChild(this.tentaclebase);
        this.lower_body.addChild(this.tentacle);
        this.lower_body.addChild(this.tentaclebase_1);
        this.body.addChild(this.head);
        this.body.addChild(this.lower_body);
        this.lower_body.addChild(this.tentacle_1);
        this.body.addChild(this.feelers_east);
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
