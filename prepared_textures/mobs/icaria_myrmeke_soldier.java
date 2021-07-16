// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class custom_model extends ModelBase {
	private final ModelRenderer BODY1;
	private final ModelRenderer BODY1S3;
	private final ModelRenderer BODY1S4;
	private final ModelRenderer HEAD;
	private final ModelRenderer HEAD4TEETH1;
	private final ModelRenderer HEAD5TEETH2;
	private final ModelRenderer HEAD2ANTHENNA2;
	private final ModelRenderer HEAD6ANTHENNA1;
	private final ModelRenderer head3;
	private final ModelRenderer BODY2;
	private final ModelRenderer BODY2S2N2_r1;
	private final ModelRenderer BODY2S2;
	private final ModelRenderer BODY2S3;
	private final ModelRenderer BODY2S4;
	private final ModelRenderer BODY2S6;
	private final ModelRenderer BODY2S7;
	private final ModelRenderer BODY2S8;
	private final ModelRenderer BODY3;
	private final ModelRenderer BODY3S2;
	private final ModelRenderer BODY3S3;
	private final ModelRenderer TAIL1;
	private final ModelRenderer TAIL2;
	private final ModelRenderer TAIL4;
	private final ModelRenderer TAIL3;
	private final ModelRenderer TAIL5;
	private final ModelRenderer LEG1;
	private final ModelRenderer L1;
	private final ModelRenderer L2;
	private final ModelRenderer L3;
	private final ModelRenderer L3_r1;
	private final ModelRenderer LEG2;
	private final ModelRenderer L4;
	private final ModelRenderer L5;
	private final ModelRenderer L6;
	private final ModelRenderer L4_r1;
	private final ModelRenderer LEG3;
	private final ModelRenderer L7;
	private final ModelRenderer L8;
	private final ModelRenderer L9;
	private final ModelRenderer L5_r1;
	private final ModelRenderer LEG4;
	private final ModelRenderer L10;
	private final ModelRenderer L11;
	private final ModelRenderer L12;
	private final ModelRenderer L6_r1;
	private final ModelRenderer LEG5;
	private final ModelRenderer L13;
	private final ModelRenderer L14;
	private final ModelRenderer L15;
	private final ModelRenderer L7_r1;
	private final ModelRenderer LEG6;
	private final ModelRenderer L16;
	private final ModelRenderer L17;
	private final ModelRenderer L18;
	private final ModelRenderer L4_r2;

	public custom_model() {
		textureWidth = 64;
		textureHeight = 64;

		BODY1 = new ModelRenderer(this);
		BODY1.setRotationPoint(0.0F, 19.2F, -4.0F);
		BODY1.cubeList.add(new ModelBox(BODY1, 37, 9, -1.5F, -0.7F, -2.0F, 3, 1, 1, 0.0F, false));
		BODY1.cubeList.add(new ModelBox(BODY1, 32, 32, -1.5F, -0.7F, -1.0F, 3, 2, 1, 0.0F, false));

		BODY1S3 = new ModelRenderer(this);
		BODY1S3.setRotationPoint(0.5F, -1.9539F, -0.6313F);
		BODY1.addChild(BODY1S3);
		setRotationAngle(BODY1S3, 0.2182F, 0.0F, 0.0F);
		BODY1S3.cubeList.add(new ModelBox(BODY1S3, 22, 32, -1.999F, 0.8727F, -1.5469F, 3, 1, 2, 0.0F, false));

		BODY1S4 = new ModelRenderer(this);
		BODY1S4.setRotationPoint(0.5F, -1.9539F, -0.6313F);
		BODY1.addChild(BODY1S4);
		setRotationAngle(BODY1S4, -0.7418F, 0.0F, 0.0F);
		BODY1S4.cubeList.add(new ModelBox(BODY1S4, 32, 16, -2.001F, 1.6481F, -0.0735F, 3, 1, 2, 0.0F, false));

		HEAD = new ModelRenderer(this);
		HEAD.setRotationPoint(0.0F, -0.2F, -2.0F);
		BODY1.addChild(HEAD);
		setRotationAngle(HEAD, 0.2618F, 0.0F, 0.0F);
		HEAD.cubeList.add(new ModelBox(HEAD, 12, 21, -2.0F, -1.0F, -2.0F, 4, 3, 2, 0.0F, false));
		HEAD.cubeList.add(new ModelBox(HEAD, 15, 12, -2.0F, 0.0F, -5.0F, 4, 2, 3, 0.0F, false));
		HEAD.cubeList.add(new ModelBox(HEAD, 18, 4, -2.5F, -0.5F, -3.0F, 5, 1, 2, 0.0F, false));

		HEAD4TEETH1 = new ModelRenderer(this);
		HEAD4TEETH1.setRotationPoint(2.0F, 1.3F, -4.0F);
		HEAD.addChild(HEAD4TEETH1);
		setRotationAngle(HEAD4TEETH1, 0.0F, 0.0436F, 0.0F);
		HEAD4TEETH1.cubeList.add(new ModelBox(HEAD4TEETH1, 51, 0, -0.5F, -0.5F, -4.0F, 1, 1, 4, 0.0F, false));
		HEAD4TEETH1.cubeList.add(new ModelBox(HEAD4TEETH1, 46, 5, -1.5F, -0.5F, -3.5F, 1, 1, 1, 0.0F, false));

		HEAD5TEETH2 = new ModelRenderer(this);
		HEAD5TEETH2.setRotationPoint(-2.0F, 1.3F, -4.0F);
		HEAD.addChild(HEAD5TEETH2);
		setRotationAngle(HEAD5TEETH2, 0.0F, -0.0436F, 0.0F);
		HEAD5TEETH2.cubeList.add(new ModelBox(HEAD5TEETH2, 41, 0, -0.5F, -0.5F, -4.0F, 1, 1, 4, 0.0F, false));
		HEAD5TEETH2.cubeList.add(new ModelBox(HEAD5TEETH2, 42, 5, 0.5F, -0.5F, -3.5F, 1, 1, 1, 0.0F, false));

		HEAD2ANTHENNA2 = new ModelRenderer(this);
		HEAD2ANTHENNA2.setRotationPoint(-1.0F, 0.3F, -4.0F);
		HEAD.addChild(HEAD2ANTHENNA2);
		setRotationAngle(HEAD2ANTHENNA2, 0.1745F, 0.0F, -0.4363F);
		HEAD2ANTHENNA2.cubeList.add(new ModelBox(HEAD2ANTHENNA2, 19, 37, -0.5F, -4.5F, -0.5F, 1, 5, 1, 0.0F, false));
		HEAD2ANTHENNA2.cubeList.add(new ModelBox(HEAD2ANTHENNA2, 26, 17, -0.5F, -4.5F, -4.5F, 1, 1, 4, 0.0F, false));

		HEAD6ANTHENNA1 = new ModelRenderer(this);
		HEAD6ANTHENNA1.setRotationPoint(1.0F, 0.3F, -4.0F);
		HEAD.addChild(HEAD6ANTHENNA1);
		setRotationAngle(HEAD6ANTHENNA1, 0.1745F, 0.0F, 0.4363F);
		HEAD6ANTHENNA1.cubeList.add(new ModelBox(HEAD6ANTHENNA1, 15, 37, -0.5F, -4.5F, -0.5F, 1, 5, 1, 0.0F, false));
		HEAD6ANTHENNA1.cubeList.add(new ModelBox(HEAD6ANTHENNA1, 8, 26, -0.5F, -4.5F, -4.5F, 1, 1, 4, 0.0F, false));

		head3 = new ModelRenderer(this);
		head3.setRotationPoint(0.0F, 0.3033F, -3.6881F);
		HEAD.addChild(head3);
		setRotationAngle(head3, -1.2217F, 0.0F, 0.0F);
		head3.cubeList.add(new ModelBox(head3, 12, 31, -2.0F, -2.032F, -0.6473F, 4, 3, 1, 0.01F, false));

		BODY2 = new ModelRenderer(this);
		BODY2.setRotationPoint(0.0F, 19.3571F, -2.0F);
		BODY2.cubeList.add(new ModelBox(BODY2, 0, 14, -2.0F, -1.3571F, -2.0F, 4, 3, 4, 0.0F, false));

		BODY2S2N2_r1 = new ModelRenderer(this);
		BODY2S2N2_r1.setRotationPoint(0.0F, -1.8571F, 0.0F);
		BODY2.addChild(BODY2S2N2_r1);
		setRotationAngle(BODY2S2N2_r1, 0.2182F, 0.0F, 0.0F);
		BODY2S2N2_r1.cubeList.add(new ModelBox(BODY2S2N2_r1, 47, 5, -1.5F, -0.5F, -2.0F, 3, 1, 3, 0.01F, false));
		BODY2S2N2_r1.cubeList.add(new ModelBox(BODY2S2N2_r1, 41, 13, -1.5F, 0.5F, 2.0F, 3, 1, 3, 0.01F, false));
		BODY2S2N2_r1.cubeList.add(new ModelBox(BODY2S2N2_r1, 42, 9, -1.5F, 0.0F, 0.0F, 3, 1, 3, 0.0F, false));

		BODY2S2 = new ModelRenderer(this);
		BODY2S2.setRotationPoint(4.0F, 5.6429F, 4.0F);
		BODY2.addChild(BODY2S2);
		BODY2S2.cubeList.add(new ModelBox(BODY2S2, 13, 8, -7.0F, -6.3F, -5.8F, 6, 2, 2, 0.0F, false));

		BODY2S3 = new ModelRenderer(this);
		BODY2S3.setRotationPoint(4.0F, 5.6429F, 6.0F);
		BODY2.addChild(BODY2S3);
		BODY2S3.cubeList.add(new ModelBox(BODY2S3, 13, 0, -7.0F, -6.3F, -5.5F, 6, 2, 2, 0.0F, false));

		BODY2S4 = new ModelRenderer(this);
		BODY2S4.setRotationPoint(3.999F, 0.5371F, -2.2048F);
		BODY2.addChild(BODY2S4);
		setRotationAngle(BODY2S4, 0.0F, 1.0908F, 0.0F);
		BODY2S4.cubeList.add(new ModelBox(BODY2S4, 0, 0, -2.9517F, -1.5942F, -5.2266F, 1, 2, 1, 0.0F, false));

		BODY2S6 = new ModelRenderer(this);
		BODY2S6.setRotationPoint(3.999F, 0.5371F, -2.2048F);
		BODY2.addChild(BODY2S6);
		setRotationAngle(BODY2S6, 0.0F, 1.0908F, 0.0F);
		BODY2S6.cubeList.add(new ModelBox(BODY2S6, 35, 37, -6.6527F, -1.5942F, -0.8316F, 2, 2, 1, 0.0F, false));

		BODY2S7 = new ModelRenderer(this);
		BODY2S7.setRotationPoint(3.999F, 0.5371F, -2.2048F);
		BODY2.addChild(BODY2S7);
		setRotationAngle(BODY2S7, 0.0F, -1.0908F, 0.0F);
		BODY2S7.cubeList.add(new ModelBox(BODY2S7, 29, 37, 0.9597F, -1.5942F, 6.2627F, 2, 2, 1, 0.0F, false));

		BODY2S8 = new ModelRenderer(this);
		BODY2S8.setRotationPoint(3.999F, 0.5371F, -2.2048F);
		BODY2.addChild(BODY2S8);
		setRotationAngle(BODY2S8, 0.0F, -1.0908F, 0.0F);
		BODY2S8.cubeList.add(new ModelBox(BODY2S8, 0, 8, -1.7414F, -1.5942F, 1.8677F, 1, 2, 1, 0.0F, false));

		BODY3 = new ModelRenderer(this);
		BODY3.setRotationPoint(0.0F, 19.5F, 0.0F);
		BODY3.cubeList.add(new ModelBox(BODY3, 0, 21, -1.5F, -1.0F, 0.0F, 3, 2, 3, 0.0F, false));

		BODY3S2 = new ModelRenderer(this);
		BODY3S2.setRotationPoint(0.0F, 4.5F, 6.0F);
		BODY3.addChild(BODY3S2);
		setRotationAngle(BODY3S2, -0.1745F, 0.0F, 0.0F);
		BODY3S2.cubeList.add(new ModelBox(BODY3S2, 21, 23, -1.499F, -4.8955F, -6.9095F, 3, 1, 3, 0.0F, false));

		BODY3S3 = new ModelRenderer(this);
		BODY3S3.setRotationPoint(4.0F, 5.5F, 7.0F);
		BODY3.addChild(BODY3S3);
		BODY3S3.cubeList.add(new ModelBox(BODY3S3, 16, 17, -6.5F, -6.501F, -6.2F, 5, 2, 2, 0.0F, false));

		TAIL1 = new ModelRenderer(this);
		TAIL1.setRotationPoint(0.0F, 19.5F, 3.0F);
		setRotationAngle(TAIL1, -0.2182F, 0.0F, 0.0F);
		TAIL1.cubeList.add(new ModelBox(TAIL1, 0, 33, -1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F, false));

		TAIL2 = new ModelRenderer(this);
		TAIL2.setRotationPoint(0.0F, -0.3F, 0.7F);
		TAIL1.addChild(TAIL2);
		TAIL2.cubeList.add(new ModelBox(TAIL2, 0, 0, -2.0F, -0.6142F, -0.1142F, 4, 3, 5, 0.0F, false));
		TAIL2.cubeList.add(new ModelBox(TAIL2, 0, 8, -2.001F, 2.0929F, 0.5929F, 4, 1, 5, 0.0F, false));

		TAIL4 = new ModelRenderer(this);
		TAIL4.setRotationPoint(0.0F, 2.3F, 1.8F);
		TAIL2.addChild(TAIL4);
		setRotationAngle(TAIL4, -0.7854F, 0.0F, 0.0F);
		TAIL4.cubeList.add(new ModelBox(TAIL4, 32, 19, -2.002F, 0.4142F, -1.2929F, 4, 1, 1, 0.0F, false));

		TAIL3 = new ModelRenderer(this);
		TAIL3.setRotationPoint(0.0F, 1.3F, 4.8F);
		TAIL2.addChild(TAIL3);
		setRotationAngle(TAIL3, -0.48F, 0.0F, 0.0F);
		TAIL3.cubeList.add(new ModelBox(TAIL3, 27, 10, -1.997F, -1.7375F, -0.8078F, 4, 2, 2, 0.0F, false));

		TAIL5 = new ModelRenderer(this);
		TAIL5.setRotationPoint(-0.02F, 1.4921F, 3.8831F);
		TAIL2.addChild(TAIL5);
		setRotationAngle(TAIL5, -0.3491F, 0.0F, 0.0F);
		TAIL5.cubeList.add(new ModelBox(TAIL5, 0, 26, -1.978F, -1.0698F, 0.0742F, 4, 2, 2, 0.0F, false));
		TAIL5.cubeList.add(new ModelBox(TAIL5, 49, 1, -0.48F, -1.0698F, 2.0742F, 1, 1, 2, 0.0F, false));

		LEG1 = new ModelRenderer(this);
		LEG1.setRotationPoint(3.0F, 19.7F, -2.8F);
		setRotationAngle(LEG1, 0.0F, 0.829F, 0.0F);
		

		L1 = new ModelRenderer(this);
		L1.setRotationPoint(0.0F, -0.2F, -0.2F);
		LEG1.addChild(L1);
		setRotationAngle(L1, 0.0F, 0.0F, -0.7854F);
		L1.cubeList.add(new ModelBox(L1, 0, 31, -0.5F, -0.3F, -0.3F, 5, 1, 1, 0.0F, false));

		L2 = new ModelRenderer(this);
		L2.setRotationPoint(4.0F, 0.0F, 0.0F);
		L1.addChild(L2);
		setRotationAngle(L2, 0.0F, 0.0F, 1.7453F);
		L2.cubeList.add(new ModelBox(L2, 29, 30, 0.6025F, -0.614F, -0.301F, 5, 1, 1, 0.0F, false));

		L3 = new ModelRenderer(this);
		L3.setRotationPoint(5.5F, 0.0F, 0.0F);
		L2.addChild(L3);
		setRotationAngle(L3, 0.0F, 0.0F, 0.3491F);
		

		L3_r1 = new ModelRenderer(this);
		L3_r1.setRotationPoint(0.0684F, 0.2189F, -0.002F);
		L3.addChild(L3_r1);
		setRotationAngle(L3_r1, 0.0F, 0.0F, 0.1309F);
		L3_r1.cubeList.add(new ModelBox(L3_r1, 7, 37, -0.2889F, -0.8F, -0.298F, 3, 1, 1, 0.0F, false));

		LEG2 = new ModelRenderer(this);
		LEG2.setRotationPoint(3.0F, 19.7F, -0.5F);
		

		L4 = new ModelRenderer(this);
		L4.setRotationPoint(0.0F, -0.2F, -0.5F);
		LEG2.addChild(L4);
		setRotationAngle(L4, 0.0F, 0.0F, -0.7854F);
		L4.cubeList.add(new ModelBox(L4, 30, 24, -0.5F, -0.3F, 0.0F, 5, 1, 1, 0.0F, false));

		L5 = new ModelRenderer(this);
		L5.setRotationPoint(4.0F, 0.0F, 0.0F);
		L4.addChild(L5);
		setRotationAngle(L5, 0.0F, 0.0F, 1.7453F);
		L5.cubeList.add(new ModelBox(L5, 30, 22, 0.6025F, -0.614F, -0.001F, 5, 1, 1, 0.0F, false));

		L6 = new ModelRenderer(this);
		L6.setRotationPoint(5.5F, 0.0F, 0.0F);
		L5.addChild(L6);
		setRotationAngle(L6, 0.0F, 0.0F, 0.3491F);
		

		L4_r1 = new ModelRenderer(this);
		L4_r1.setRotationPoint(0.0684F, 0.2189F, -0.002F);
		L6.addChild(L4_r1);
		setRotationAngle(L4_r1, 0.0F, 0.0F, 0.1309F);
		L4_r1.cubeList.add(new ModelBox(L4_r1, 0, 36, -0.2889F, -0.8F, 0.002F, 3, 1, 1, 0.0F, false));

		LEG3 = new ModelRenderer(this);
		LEG3.setRotationPoint(-3.0F, 19.7F, -0.5F);
		setRotationAngle(LEG3, 0.0F, 3.1416F, 0.0F);
		

		L7 = new ModelRenderer(this);
		L7.setRotationPoint(0.0F, -0.2F, -0.5F);
		LEG3.addChild(L7);
		setRotationAngle(L7, 0.0F, 0.0F, -0.7854F);
		L7.cubeList.add(new ModelBox(L7, 30, 4, -0.5F, -0.3F, 0.0F, 5, 1, 1, 0.0F, false));

		L8 = new ModelRenderer(this);
		L8.setRotationPoint(4.0F, 0.0F, 0.0F);
		L7.addChild(L8);
		setRotationAngle(L8, 0.0F, 0.0F, 1.7453F);
		L8.cubeList.add(new ModelBox(L8, 18, 29, 0.6025F, -0.614F, -0.001F, 5, 1, 1, 0.0F, false));

		L9 = new ModelRenderer(this);
		L9.setRotationPoint(5.5F, 0.0F, 0.0F);
		L8.addChild(L9);
		setRotationAngle(L9, 0.0F, 0.0F, 0.3491F);
		

		L5_r1 = new ModelRenderer(this);
		L5_r1.setRotationPoint(0.0684F, 0.2189F, -0.002F);
		L9.addChild(L5_r1);
		setRotationAngle(L5_r1, 0.0F, 0.0F, 0.1309F);
		L5_r1.cubeList.add(new ModelBox(L5_r1, 31, 35, -0.2889F, -0.8F, 0.002F, 3, 1, 1, 0.0F, false));

		LEG4 = new ModelRenderer(this);
		LEG4.setRotationPoint(2.0F, 19.7F, 1.7F);
		setRotationAngle(LEG4, 0.0F, -0.4363F, 0.0F);
		

		L10 = new ModelRenderer(this);
		L10.setRotationPoint(0.0F, -0.2F, -0.7F);
		LEG4.addChild(L10);
		setRotationAngle(L10, 0.0F, 0.0F, -0.7854F);
		L10.cubeList.add(new ModelBox(L10, 29, 14, -0.5F, -0.3F, 0.2F, 5, 1, 1, 0.0F, false));

		L11 = new ModelRenderer(this);
		L11.setRotationPoint(4.0F, 0.0F, 0.0F);
		L10.addChild(L11);
		setRotationAngle(L11, 0.0F, 0.0F, 1.7453F);
		L11.cubeList.add(new ModelBox(L11, 29, 2, 0.6025F, -0.614F, 0.21F, 5, 1, 1, 0.0F, false));

		L12 = new ModelRenderer(this);
		L12.setRotationPoint(5.5F, 0.0F, 0.0F);
		L11.addChild(L12);
		setRotationAngle(L12, 0.0F, 0.0F, 0.3491F);
		

		L6_r1 = new ModelRenderer(this);
		L6_r1.setRotationPoint(0.0684F, 0.2189F, -0.002F);
		L12.addChild(L6_r1);
		setRotationAngle(L6_r1, 0.0F, 0.0F, 0.1309F);
		L6_r1.cubeList.add(new ModelBox(L6_r1, 23, 35, -0.2889F, -0.8F, 0.202F, 3, 1, 1, 0.0F, false));

		LEG5 = new ModelRenderer(this);
		LEG5.setRotationPoint(-2.0F, 19.7F, 1.7F);
		setRotationAngle(LEG5, 0.0F, -2.618F, 0.0F);
		

		L13 = new ModelRenderer(this);
		L13.setRotationPoint(0.0F, -0.2F, -0.7F);
		LEG5.addChild(L13);
		setRotationAngle(L13, 0.0F, 0.0F, -0.7854F);
		L13.cubeList.add(new ModelBox(L13, 26, 27, -0.5F, -0.3F, 0.2F, 5, 1, 1, 0.0F, false));

		L14 = new ModelRenderer(this);
		L14.setRotationPoint(4.0F, 0.0F, 0.0F);
		L13.addChild(L14);
		setRotationAngle(L14, 0.0F, 0.0F, 1.7453F);
		L14.cubeList.add(new ModelBox(L14, 14, 27, 0.6025F, -0.614F, 0.21F, 5, 1, 1, 0.0F, false));

		L15 = new ModelRenderer(this);
		L15.setRotationPoint(5.5F, 0.0F, 0.0F);
		L14.addChild(L15);
		setRotationAngle(L15, 0.0F, 0.0F, 0.3491F);
		

		L7_r1 = new ModelRenderer(this);
		L7_r1.setRotationPoint(0.0684F, 0.2189F, -0.002F);
		L15.addChild(L7_r1);
		setRotationAngle(L7_r1, 0.0F, 0.0F, 0.1309F);
		L7_r1.cubeList.add(new ModelBox(L7_r1, 15, 35, -0.2889F, -0.8F, 0.202F, 3, 1, 1, 0.0F, false));

		LEG6 = new ModelRenderer(this);
		LEG6.setRotationPoint(-3.0F, 19.7F, -2.8F);
		setRotationAngle(LEG6, 0.0F, 2.2253F, 0.0F);
		

		L16 = new ModelRenderer(this);
		L16.setRotationPoint(0.0F, -0.2F, -0.2F);
		LEG6.addChild(L16);
		setRotationAngle(L16, 0.0F, 0.0F, -0.7854F);
		L16.cubeList.add(new ModelBox(L16, 27, 7, -0.5F, -0.3F, -0.3F, 5, 1, 1, 0.0F, false));

		L17 = new ModelRenderer(this);
		L17.setRotationPoint(4.0F, 0.0F, 0.0F);
		L16.addChild(L17);
		setRotationAngle(L17, 0.0F, 0.0F, 1.7453F);
		L17.cubeList.add(new ModelBox(L17, 27, 0, 0.6025F, -0.614F, -0.301F, 5, 1, 1, 0.0F, false));

		L18 = new ModelRenderer(this);
		L18.setRotationPoint(5.5F, 0.0F, 0.0F);
		L17.addChild(L18);
		setRotationAngle(L18, 0.0F, 0.0F, 0.3491F);
		

		L4_r2 = new ModelRenderer(this);
		L4_r2.setRotationPoint(0.0684F, 0.2189F, -0.002F);
		L18.addChild(L4_r2);
		setRotationAngle(L4_r2, 0.0F, 0.0F, 0.1309F);
		L4_r2.cubeList.add(new ModelBox(L4_r2, 7, 35, -0.2889F, -0.8F, -0.298F, 3, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		BODY1.render(f5);
		BODY2.render(f5);
		BODY3.render(f5);
		TAIL1.render(f5);
		LEG1.render(f5);
		LEG2.render(f5);
		LEG3.render(f5);
		LEG4.render(f5);
		LEG5.render(f5);
		LEG6.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}