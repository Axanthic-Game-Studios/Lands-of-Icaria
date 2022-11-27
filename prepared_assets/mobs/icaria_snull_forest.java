// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_snull_forest<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_snull_forest"), "main");
	private final ModelPart bone6;
	private final ModelPart bonex;
	private final ModelPart bone5;
	private final ModelPart bone;
	private final ModelPart bb_main;

	public icaria_snull_forest(ModelPart root) {
		this.bone6 = root.getChild("bone6");
		this.bonex = root.getChild("bonex");
		this.bone5 = root.getChild("bone5");
		this.bone = root.getChild("bone");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(22, 17).addBox(-2.99F, 1.0F, 0.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition feelers2 = bone6.addOrReplaceChild("feelers2", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5F, 0.0F));

		PartDefinition eye_left_r1 = feelers2.addOrReplaceChild("eye_left_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.5F, -5.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.5F, 0.0F, -0.2618F, -0.1745F, 0.0F));

		PartDefinition feeler_left_r1 = feelers2.addOrReplaceChild("feeler_left_r1", CubeListBuilder.create().texOffs(45, 0).addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.5F, 0.0F, -0.2618F, -0.1745F, 0.0F));

		PartDefinition eye_right_r1 = feelers2.addOrReplaceChild("eye_right_r1", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -1.5F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 45).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.5F, 0.0F, -0.2618F, 0.1745F, 0.0F));

		PartDefinition bonex = partdefinition.addOrReplaceChild("bonex", CubeListBuilder.create().texOffs(18, 29).addBox(0.0F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, -3.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition cube_r1 = bonex.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 43).addBox(-1.75F, -0.2F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 5.0F, 0.0F, 0.0F, -0.3927F, 0.1745F));

		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(26, 44).addBox(-0.5F, -0.2F, 0.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 6.0F, -0.2618F, 0.0F, 0.1745F));

		PartDefinition body_rear_shroom_hat_r1 = bone5.addOrReplaceChild("body_rear_shroom_hat_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 10.8F, 1.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(33, 38).addBox(-2.49F, 0.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(36, 31).addBox(-2.48F, 0.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 36).addBox(-2.47F, 0.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition neck_ring_bottom_r1 = bone3.addOrReplaceChild("neck_ring_bottom_r1", CubeListBuilder.create().texOffs(40, 17).addBox(-6.47F, -2.5F, -1.0F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 0.0F, 0.0F, 0.5236F, 0.1745F));

		PartDefinition neck_ring_mid_r1 = bone3.addOrReplaceChild("neck_ring_mid_r1", CubeListBuilder.create().texOffs(20, 10).addBox(-7.77F, -2.5F, -1.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, -1.0F, 0.0F, 0.3927F, 0.0873F));

		PartDefinition neck_ring_top_r1 = bone3.addOrReplaceChild("neck_ring_top_r1", CubeListBuilder.create().texOffs(42, 8).addBox(-6.97F, -2.5F, -1.0F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(27, 0).addBox(-2.46F, -4.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -3.0F, 0.1963F, 0.0F, 0.0F));

		PartDefinition feelers = bone4.addOrReplaceChild("feelers", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -4.0F));

		PartDefinition eye_left_r2 = feelers.addOrReplaceChild("eye_left_r2", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -0.7F, -5.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 46).addBox(-0.5F, -0.2F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.5F, 0.0F, 0.2618F, 0.0F, -0.7854F));

		PartDefinition eye_right_r2 = feelers.addOrReplaceChild("eye_right_r2", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -0.7F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, 0.2618F, 0.0F, 0.7854F));

		PartDefinition feeler_right_r1 = feelers.addOrReplaceChild("feeler_right_r1", CubeListBuilder.create().texOffs(46, 23).addBox(-0.5F, -0.2F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, 0.2618F, 0.0F, 0.7854F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(18, 31).addBox(-2.5F, 0.0F, 4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-1.5F, -0.01F, 8.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-2.5F, 0.0F, -8.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(18, 46).addBox(2.5F, 2.5F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 40).addBox(2.5F, 1.5F, -6.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 10).addBox(2.0F, 1.0F, 0.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(41, 0).addBox(4.5F, 1.5F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(40, 46).addBox(4.0F, 1.0F, 1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(2.0F, 2.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-3.01F, 0.0F, -1.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 39).addBox(-3.0F, 3.75F, -5.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 16).addBox(-2.0F, 3.75F, -6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail_r1 = bb_main.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(46, 46).addBox(-1.1F, 0.0F, -0.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 11.5F, 0.0F, -0.2618F, 0.0F));

		PartDefinition body_further_rear_r1 = bb_main.addOrReplaceChild("body_further_rear_r1", CubeListBuilder.create().texOffs(12, 39).addBox(-2.0F, 0.01F, -0.2F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.0F, 0.0873F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bonex.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}