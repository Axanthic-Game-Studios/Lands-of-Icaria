// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class icaria_cetus<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "icaria_cetus"), "main");
	private final ModelPart bone;
	private final ModelPart bone12;
	private final ModelPart bone17;
	private final ModelPart bone18;
	private final ModelPart bone23;
	private final ModelPart bb_main;

	public icaria_cetus(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone12 = root.getChild("bone12");
		this.bone17 = root.getChild("bone17");
		this.bone18 = root.getChild("bone18");
		this.bone23 = root.getChild("bone23");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(51, 0).addBox(-3.0F, -7.0F, 0.0F, 6.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone24 = bone.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 1.6F));

		PartDefinition spike_r1 = bone24.addOrReplaceChild("spike_r1", CubeListBuilder.create().texOffs(90, 62).addBox(-1.0F, -0.7F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r2 = bone24.addOrReplaceChild("spike_r2", CubeListBuilder.create().texOffs(90, 59).addBox(-1.0F, -1.2F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r3 = bone24.addOrReplaceChild("spike_r3", CubeListBuilder.create().texOffs(90, 56).addBox(-1.0F, -1.7F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r4 = bone24.addOrReplaceChild("spike_r4", CubeListBuilder.create().texOffs(90, 52).addBox(-1.0F, -2.2F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r5 = bone24.addOrReplaceChild("spike_r5", CubeListBuilder.create().texOffs(90, 48).addBox(-1.0F, -2.7F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(56, 17).addBox(-2.5F, -6.0F, 0.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7F, 9.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(56, 29).addBox(-2.5F, -4.8F, 0.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.2F, 5.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(57, 40).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.45F, 5.9F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(58, 50).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -3.75F, 4.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(58, 59).addBox(-1.5F, -0.35F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 5.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(58, 68).addBox(-1.5F, -0.45F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(60, 77).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.85F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone9 = bone8.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(60, 84).addBox(-1.0F, -0.1F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.15F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(73, 88).addBox(-1.0F, -2.75F, -1.35F, 2.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition bone11 = bone10.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(74, 80).addBox(-1.0F, -5.05F, 0.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(0.0F, 1.05F, 2.45F, 0.7854F, 0.0F, 0.0F));

		PartDefinition top_fin_r1 = bone11.addOrReplaceChild("top_fin_r1", CubeListBuilder.create().texOffs(84, 77).addBox(-0.5F, -0.1F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition bottom_fin_r1 = bone11.addOrReplaceChild("bottom_fin_r1", CubeListBuilder.create().texOffs(85, 91).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition middle_fin_r1 = bone11.addOrReplaceChild("middle_fin_r1", CubeListBuilder.create().texOffs(82, 83).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone12 = partdefinition.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(15, 64).addBox(-3.0F, -7.8F, -5.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 14.8F, -9.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone25 = bone12.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offset(0.0F, -7.55F, -4.75F));

		PartDefinition spike_r6 = bone25.addOrReplaceChild("spike_r6", CubeListBuilder.create().texOffs(90, 13).addBox(-1.0F, -5.0F, -0.1F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r7 = bone25.addOrReplaceChild("spike_r7", CubeListBuilder.create().texOffs(90, 7).addBox(-1.0F, -4.0F, -0.1F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone13 = bone12.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(16, 51).addBox(-2.5F, -7.0F, -5.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, -4.8F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone26 = bone13.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, -5.0F));

		PartDefinition spike_r8 = bone26.addOrReplaceChild("spike_r8", CubeListBuilder.create().texOffs(90, 3).addBox(-1.0F, -3.0F, 0.1F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r9 = bone26.addOrReplaceChild("spike_r9", CubeListBuilder.create().texOffs(90, 0).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone14 = bone13.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(17, 39).addBox(-2.0F, -6.2F, -5.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -0.2F, -5.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone15 = bone14.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(17, 27).addBox(-2.0F, -6.0F, -5.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -5.2F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone16 = bone15.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, -5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition teeth_r1 = bone16.addOrReplaceChild("teeth_r1", CubeListBuilder.create().texOffs(34, 10).addBox(-2.0F, -2.9F, -6.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(34, 0).addBox(-2.0F, -1.5F, -6.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 2.3F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition teeth_r2 = bone16.addOrReplaceChild("teeth_r2", CubeListBuilder.create().texOffs(32, 19).addBox(-2.5F, 1.0F, -8.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(12, 13).addBox(-2.5F, -3.0F, -8.0F, 5.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition head_top_r1 = bone16.addOrReplaceChild("head_top_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.6F, -3.0F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition bone17 = partdefinition.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(0, 68).addBox(2.0F, -2.0F, -1.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 68).addBox(-5.0F, -2.0F, -1.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone19 = bone17.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(0, 78).addBox(2.5F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 78).addBox(-4.5F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone21 = bone19.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(0, 87).addBox(3.0F, 0.0F, 0.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(46, 87).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone18 = partdefinition.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(0, 43).addBox(1.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.2F))
		.texOffs(42, 43).addBox(-4.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 12.0F, -8.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone20 = bone18.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(0, 51).addBox(1.5F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 51).addBox(-3.5F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.2F, -1.2F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone22 = bone20.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(0, 60).addBox(2.0F, 0.0F, 0.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(46, 60).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone23 = partdefinition.addOrReplaceChild("bone23", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, -9.0F));

		PartDefinition spike_r10 = bone23.addOrReplaceChild("spike_r10", CubeListBuilder.create().texOffs(90, 43).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r11 = bone23.addOrReplaceChild("spike_r11", CubeListBuilder.create().texOffs(90, 38).addBox(-1.0F, -3.5F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r12 = bone23.addOrReplaceChild("spike_r12", CubeListBuilder.create().texOffs(90, 32).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r13 = bone23.addOrReplaceChild("spike_r13", CubeListBuilder.create().texOffs(90, 26).addBox(-1.0F, -4.5F, 0.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike_r14 = bone23.addOrReplaceChild("spike_r14", CubeListBuilder.create().texOffs(90, 19).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(10, 78).addBox(-3.5F, -17.0F, -9.0F, 7.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 96, 96);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}