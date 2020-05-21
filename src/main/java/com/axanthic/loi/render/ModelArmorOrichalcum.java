package com.axanthic.loi.render;

import net.minecraft.client.model.ModelRenderer;

public class ModelArmorOrichalcum extends ModelArmorBase {
	public ModelRenderer mohawk;
	public ModelRenderer holder;

	public ModelArmorOrichalcum() {
		super(1.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.mohawk = new ModelRenderer(this, 0, 32);
		this.mohawk.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.mohawk.addBox(-0.5F, -12.0F, -3.0F, 1, 7, 10, 0.25F);
		this.holder = new ModelRenderer(this, 22, 32);
		this.holder.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.holder.addBox(-1.0F, -9.0F, -3.5F, 2, 5, 8, 0.25F);
		this.bipedHead.addChild(this.mohawk);
		this.bipedHead.addChild(this.holder);
	}
}
