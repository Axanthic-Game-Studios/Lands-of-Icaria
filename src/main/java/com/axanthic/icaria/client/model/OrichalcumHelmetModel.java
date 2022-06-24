package com.axanthic.icaria.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OrichalcumHelmetModel<T extends LivingEntity> extends HumanoidModel<T> {
    public ModelPart helmet;

    public OrichalcumHelmetModel(ModelPart pModel) {
        super(pModel);
        this.helmet = pModel.getChild("helmet");
    }

    public static LayerDefinition createHelmetLayer(CubeDeformation pSize) {
        CubeListBuilder helmet = CubeListBuilder.create();
        helmet.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F));
        helmet.texOffs(25, 4).addBox(-1.0F, -12.0F, -2.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(57, 19).addBox(-1.0F, -12.0F, 4.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(0, 6).addBox(-1.5F, -9.5F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(2, 2).addBox(0.5F, -9.5F, 4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(2, 2).addBox(-1.5F, -9.5F, 4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(2, 6).addBox(-0.5F, -5.5F, 4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(2, 6).addBox(0.5F, -9.5F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(1, 5).addBox(-1.5F, -9.5F, 2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F));
        helmet.texOffs(2, 6).addBox(-1.5F, -9.5F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(1, 5).addBox(0.5F, -9.5F, 2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F));
        helmet.texOffs(1, 5).addBox(0.5F, -9.5F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F));
        helmet.texOffs(1, 5).addBox(0.5F, -9.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F));
        helmet.texOffs(1, 5).addBox(-1.5F, -9.5F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F));
        helmet.texOffs(1, 5).addBox(-1.5F, -9.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F));
        helmet.texOffs(57, 20).addBox(-1.0F, -12.0F, -1.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(57, 28).addBox(-1.0F, -12.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(25, 4).addBox(-1.0F, -12.0F, 0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(57, 20).addBox(-1.0F, -12.0F, 1.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(57, 28).addBox(-1.0F, -12.0F, 2.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(25, 4).addBox(-1.0F, -12.0F, 3.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(57, 26).addBox(-1.0F, -12.0F, 5.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(25, 1).addBox(-1.0F, -12.0F, 6.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(25, 6).addBox(-1.0F, -7.0F, 5.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F));
        helmet.texOffs(56, 21).addBox(-1.0F, -6.0F, 5.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F));
        MeshDefinition mesh = HumanoidModel.createMesh(pSize, 0.0F);
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("helmet", helmet, PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 32);
    }

    @Override
    public Iterable<ModelPart> headParts() {
        this.helmet.copyFrom(this.head);
        return ImmutableList.of(this.helmet);
    }
}
