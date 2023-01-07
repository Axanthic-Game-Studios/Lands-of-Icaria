package com.axanthic.icaria.client.model;

import com.axanthic.icaria.common.util.IcariaInfo;

import com.google.common.collect.ImmutableList;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OrichalcumHelmetModel<T extends LivingEntity> extends HumanoidModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID + "orichalcum_helmet"), "main");

    public ModelPart helmet;

    public OrichalcumHelmetModel(ModelPart pModelPart) {
        super(pModelPart);
        this.helmet = pModelPart.getChild("helmet");
    }

    @Override
    public Iterable<ModelPart> headParts() {
        this.helmet.copyFrom(this.head);
        return ImmutableList.of(this.helmet);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition helmet = partDefinition.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.ZERO);
        helmet.addOrReplaceChild("00", CubeListBuilder.create().texOffs(25, 4).addBox(-1.0F, -12.0F, -2.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("01", CubeListBuilder.create().texOffs(57, 19).addBox(-1.0F, -12.0F, 4.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("02", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, -9.5F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("03", CubeListBuilder.create().texOffs(2, 2).addBox(0.5F, -9.5F, 4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("04", CubeListBuilder.create().texOffs(2, 2).addBox(-1.5F, -9.5F, 4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("05", CubeListBuilder.create().texOffs(2, 6).addBox(-0.5F, -5.5F, 4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("06", CubeListBuilder.create().texOffs(2, 6).addBox(0.5F, -9.5F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("07", CubeListBuilder.create().texOffs(1, 5).addBox(-1.5F, -9.5F, 2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("08", CubeListBuilder.create().texOffs(2, 6).addBox(-1.5F, -9.5F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("09", CubeListBuilder.create().texOffs(1, 5).addBox(0.5F, -9.5F, 2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("10", CubeListBuilder.create().texOffs(1, 5).addBox(0.5F, -9.5F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("11", CubeListBuilder.create().texOffs(1, 5).addBox(0.5F, -9.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("12", CubeListBuilder.create().texOffs(1, 5).addBox(-1.5F, -9.5F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("13", CubeListBuilder.create().texOffs(1, 5).addBox(-1.5F, -9.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("14", CubeListBuilder.create().texOffs(57, 20).addBox(-1.0F, -12.0F, -1.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("15", CubeListBuilder.create().texOffs(57, 28).addBox(-1.0F, -12.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("16", CubeListBuilder.create().texOffs(25, 4).addBox(-1.0F, -12.0F, 0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("17", CubeListBuilder.create().texOffs(57, 20).addBox(-1.0F, -12.0F, 1.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("18", CubeListBuilder.create().texOffs(57, 28).addBox(-1.0F, -12.0F, 2.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("19", CubeListBuilder.create().texOffs(25, 4).addBox(-1.0F, -12.0F, 3.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("20", CubeListBuilder.create().texOffs(57, 26).addBox(-1.0F, -12.0F, 5.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("21", CubeListBuilder.create().texOffs(25, 1).addBox(-1.0F, -12.0F, 6.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("22", CubeListBuilder.create().texOffs(25, 6).addBox(-1.0F, -7.0F, 5.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        helmet.addOrReplaceChild("23", CubeListBuilder.create().texOffs(56, 21).addBox(-1.0F, -6.0F, 5.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
