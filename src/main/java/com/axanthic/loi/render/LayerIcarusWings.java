package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.blocks.BlockWingsDispenser;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelElytra;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerIcarusWings extends LayerElytra {

	private static final ResourceLocation TEXTURE_WINGS = new ResourceLocation(ModInformation.ID, "textures/entity/icarus_wings.png");
	private static final ResourceLocation TEXTURE_WINGS_BURNING = new ResourceLocation(ModInformation.ID, "textures/entity/icarus_wings_burning.png");
	private final ModelElytra modelElytra = new ModelElytra();
	public LayerElytra wrappedLayer;
	public LayerIcarusWings(RenderLivingBase<?> p_i47185_1_, LayerElytra wrappedLayer) {
		super(p_i47185_1_);
		this.wrappedLayer = wrappedLayer;
	}

	public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST);

		if (itemstack.getItem() == Items.ELYTRA && itemstack.hasTagCompound() && itemstack.getTagCompound().getBoolean(BlockWingsDispenser.ICARUS_WINGS_TAG)) {
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

			if (ItemElytra.isUsable(itemstack))
				this.renderPlayer.bindTexture(TEXTURE_WINGS);
			else
				this.renderPlayer.bindTexture(TEXTURE_WINGS_BURNING);

			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 0.0F, 0.125F);
			this.modelElytra.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
			this.modelElytra.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

			//if (itemstack.isItemEnchanted()) {
			//LayerArmorBase.renderEnchantedGlint(this.renderPlayer, entitylivingbaseIn, this.modelElytra, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
			//}

			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		} else {
			wrappedLayer.doRenderLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}

	public boolean shouldCombineTextures() {
		return wrappedLayer.shouldCombineTextures();
	}
}