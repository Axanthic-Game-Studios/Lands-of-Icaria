package com.axanthic.loi.utils;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockGrinder;
import com.axanthic.loi.blocks.BlockMobHead;
import com.axanthic.loi.items.ItemBlockMobHead;
import com.axanthic.loi.items.ItemSaltedFood;
import com.axanthic.loi.items.ItemScroll;
import com.axanthic.loi.render.BakedModelScroll;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererGrinder;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererMobHead;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LOIItemStackRenderer extends TileEntityItemStackRenderer {

	public static LOIItemStackRenderer LOIInstance;
	private static final ResourceLocation RES_SCROLL_BACKGROUND = new ResourceLocation(ModInformation.ID, "textures/gui/scroll_background.png");
	public static ItemStack saltOverlay = new ItemStack(Resources.renderAddon, 1, 5);

	public void renderByItem(ItemStack stack, float partialTicks) {
		Item item = stack.getItem();

		if (item instanceof ItemBlockMobHead) {
			if (TileEntitySpecialRendererMobHead.instance != null) {
				GlStateManager.pushMatrix();
				GlStateManager.disableCull();
				TileEntitySpecialRendererMobHead.instance.renderSkull(0.0F, 0.1F, 0.0F, EnumFacing.DOWN, 0.0F, ((BlockMobHead) ((ItemBlock) item).getBlock()).name, -1, 1.6F);
				GlStateManager.enableCull();
				GlStateManager.popMatrix();
			}
		}

		if (item instanceof ItemSaltedFood) {
			GlStateManager.pushMatrix();
            GlStateManager.translate(0.5F, 0.5F, 0.5F);
			if (stack.hasTagCompound()) {
				ItemStack foodStack = ItemSaltedFood.getContainedItem(stack.getTagCompound());
				if (!foodStack.isEmpty())
					Minecraft.getMinecraft().getRenderItem().renderItem(foodStack, ItemCameraTransforms.TransformType.NONE);
			}
			Minecraft.getMinecraft().getRenderItem().renderItem(saltOverlay, ItemCameraTransforms.TransformType.NONE);
			GlStateManager.popMatrix();
		}

		if (item instanceof ItemBlock && ((ItemBlock) item).getBlock() instanceof BlockGrinder) {
			if (TileEntitySpecialRendererGrinder.instance != null) {
				GlStateManager.pushMatrix();
				GlStateManager.disableCull();
				TileEntitySpecialRendererGrinder.instance.renderInventory();
				GlStateManager.enableCull();
				GlStateManager.popMatrix();
			}
		}

		if (item instanceof ItemScroll) {
			ItemScroll scroll = ((ItemScroll) item);
			if (!Minecraft.getMinecraft().player.isInvisible()) {
				EnumHand rightHand = EnumHand.MAIN_HAND;
				EnumHand leftHand = EnumHand.OFF_HAND;
				if (Minecraft.getMinecraft().player.getPrimaryHand() == EnumHandSide.LEFT) {
					rightHand = EnumHand.OFF_HAND;
					leftHand = EnumHand.MAIN_HAND;
				}
				//render player arms
				if (BakedModelScroll.transform == TransformType.FIRST_PERSON_RIGHT_HAND) {
					GlStateManager.translate(((float) Minecraft.getMinecraft().displayWidth) / ((float) Minecraft.getMinecraft().displayHeight) * 0.5F, 0.9F, 0.4F);
					GlStateManager.disableCull();
					GlStateManager.pushMatrix();
					GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
					if (Minecraft.getMinecraft().player.getHeldItem(leftHand).isEmpty() && rightHand != EnumHand.OFF_HAND)
						renderArm(EnumHandSide.LEFT);
					GlStateManager.translate(0.0F, 0.3F, -0.7F);
					GlStateManager.rotate(-60.0F, 1.0F, 0.0F, 0.0F);
					renderArm(EnumHandSide.RIGHT);
					GlStateManager.popMatrix();
					GlStateManager.enableCull();
				}
				if (BakedModelScroll.transform == TransformType.FIRST_PERSON_LEFT_HAND) {
					GlStateManager.translate(((float) Minecraft.getMinecraft().displayWidth) / ((float) Minecraft.getMinecraft().displayHeight) * -0.5F + 1.68F, 0.9F, 0.4F);
					GlStateManager.disableCull();
					GlStateManager.pushMatrix();
					GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
					GlStateManager.translate(-0.1F, 0.03F, -0.7F);
					if (Minecraft.getMinecraft().player.getHeldItem(rightHand).isEmpty() && leftHand != EnumHand.OFF_HAND)
						renderArm(EnumHandSide.RIGHT);
					GlStateManager.translate(0.1F, 0.27F, 0.7F);
					GlStateManager.rotate(60.0F, 1.0F, 0.0F, 0.0F);
					renderArm(EnumHandSide.LEFT);
					GlStateManager.popMatrix();
					GlStateManager.enableCull();
				}
			}
			//render scroll background
			GlStateManager.scale(0.76F, 0.76F, 0.76F);
			GlStateManager.disableLighting();
			Minecraft.getMinecraft().getTextureManager().bindTexture(RES_SCROLL_BACKGROUND);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferbuilder = tessellator.getBuffer();
			GlStateManager.translate(-1.0F, -0.6F, -0.2F);
			GlStateManager.scale(0.0078125F, 0.0078125F, 0.0078125F);
			bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
			bufferbuilder.pos(0.0D, 0.0D, 0.0D).tex(0.0D, 1.0D).endVertex();
			bufferbuilder.pos(142.0D, 0.0D, 0.0D).tex(1.0D, 1.0D).endVertex();
			bufferbuilder.pos(142.0D, 142.0D, 0.0D).tex(1.0D, 0.0D).endVertex();
			bufferbuilder.pos(0.0D, 142.0D, 0.0D).tex(0.0D, 0.0D).endVertex();
			tessellator.draw();
			GlStateManager.translate(71.0F, 44.5F, 0.01F);
			//render scroll title
			GlStateManager.pushMatrix();
			GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
			FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
			String title = I18n.translateToLocal("spell." + scroll.getName() + ".name");
			fontRenderer.drawString(title, -fontRenderer.getStringWidth(title) / 2, -60, 0x82735A);
			GlStateManager.popMatrix();
			GlStateManager.scale(25.0F, 25.0F, 0.001F);
			//render ingredients
			Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			GlStateManager.pushMatrix();
			GlStateManager.scale(0.6F, 0.6F, 1.0F);
			GlStateManager.translate(0.55F - scroll.getRecipe().order.size() * 0.55F, 2.5F, 0.0F);
			for (int i = 0; i < scroll.getRecipe().order.size(); ++i) {
				Minecraft.getMinecraft().getRenderItem().renderItem(scroll.getRecipe().getInputs().get(scroll.getRecipe().order.get(i)).getMatchingStacks()[0], ItemCameraTransforms.TransformType.GUI);
				GlStateManager.translate(1.1F, 0.0F, 0.0F);
			}
			GlStateManager.popMatrix();
			//render result
			Minecraft.getMinecraft().getRenderItem().renderItem(scroll.getRecipe().recipeOutput, ItemCameraTransforms.TransformType.GUI);
			GlStateManager.enableLighting();
		}
	}

	public static void renderArm(EnumHandSide side) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(Minecraft.getMinecraft().player.getLocationSkin());
		Render<AbstractClientPlayer> render = Minecraft.getMinecraft().getRenderManager().<AbstractClientPlayer>getEntityRenderObject(Minecraft.getMinecraft().player);
		RenderPlayer renderplayer = (RenderPlayer)render;
		GlStateManager.pushMatrix();
		float f = side == EnumHandSide.RIGHT ? 1.0F : -1.0F;
		GlStateManager.rotate(92.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(f * -41.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.translate(f * 0.3F, -1.1F, 0.45F);

		if (side == EnumHandSide.RIGHT) {
			renderplayer.renderRightArm(Minecraft.getMinecraft().player);
		} else {
			renderplayer.renderLeftArm(Minecraft.getMinecraft().player);
		}
		GlStateManager.popMatrix();
	}
}
