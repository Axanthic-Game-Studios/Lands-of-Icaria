package com.axanthic.loi.tileentity;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.blocks.BlockIcariaChest;

import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntitySpecialRendererIcariaChest extends TileEntitySpecialRenderer<TileEntityIcariaChest>
{
    public static final ResourceLocation TEXTURE_NORMAL = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_chest_normal.png");
    public static final ResourceLocation TEXTURE_LABEL_TOP = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_chest_labels_normal_top.png");
    public static final ResourceLocation TEXTURE_LABEL_FRONT = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_chest_labels_normal_front.png");
    public static final ResourceLocation TEXTURE_TRAPPED = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_trapped_chest_normal.png");
    public static final ResourceLocation TEXTURE_NORMAL_DOUBLE = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_chest_double.png");
    public static final ResourceLocation DOUBLE_LABEL_TOP = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_chest_labels_double_top.png");
    public static final ResourceLocation DOUBLE_LABEL_FRONT = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_chest_labels_double_front.png");
    public static final ResourceLocation TEXTURE_TRAPPED_DOUBLE = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_trapped_chest_double.png");

    public final ModelChest simpleChest = new ModelChest();
    public final ModelChest largeChest = new ModelLargeChest();

    public void render(TileEntityIcariaChest te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);

        int i;

        if(te.hasWorld())
        {
            Block block = te.getBlockType();

            i = te.getBlockMetadata();

            if(block instanceof BlockIcariaChest && i == 0)
            {
                ((BlockIcariaChest)block).checkForSurroundingChests(te.getWorld(), te.getPos(), te.getWorld().getBlockState(te.getPos()));

                i = te.getBlockMetadata();
            }

            te.checkForAdjacentChests();
        }

        else
        {
            i = 0;
        }

        ModelChest modelchest = null;

        if(te.adjacentChestZNeg == null && te.adjacentChestXNeg == null && te.adjacentChestXPos == null && te.adjacentChestZPos == null)
        {
            modelchest = this.simpleChest;

            if(destroyStage >= 0)
            {
                this.bindTexture(DESTROY_STAGES[destroyStage]);

                GlStateManager.matrixMode(5890);
                GlStateManager.pushMatrix();
                GlStateManager.scale(4.0F, 4.0F, 1.0F);
                GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
                GlStateManager.matrixMode(5888);
            }

            else if(te.getChestType() == BlockIcariaChest.Type.TRAP)
            {
                this.bindTexture(TEXTURE_TRAPPED);
            }

            else
            {
                this.bindTexture(TEXTURE_NORMAL);
            }
        }

        if(te.adjacentChestZNeg != null || te.adjacentChestXNeg != null || te.adjacentChestXPos != null || te.adjacentChestZPos != null)
        {
            modelchest = this.largeChest;

            if(destroyStage >= 0)
            {
                this.bindTexture(DESTROY_STAGES[destroyStage]);

                GlStateManager.matrixMode(5890);
                GlStateManager.pushMatrix();
                GlStateManager.scale(8.0F, 4.0F, 1.0F);
                GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
                GlStateManager.matrixMode(5888);
            }

            else if(te.getChestType() == BlockIcariaChest.Type.TRAP)
            {
                this.bindTexture(TEXTURE_TRAPPED_DOUBLE);
            }

            else
            {
                this.bindTexture(TEXTURE_NORMAL_DOUBLE);
            }
        }

        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();

        if(destroyStage < 0)
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
        }

        GlStateManager.translate((float)x, (float)y + 1.0F, (float)z + 1.0F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        GlStateManager.translate(0.5F, 0.5F, 0.5F);

        int j = 0;

        if(i == 2)
        {
            j = 180;
        }

        if(i == 3)
        {
            j = 0;
        }

        if(i == 4)
        {
            j = 90;
        }

        if(i == 5)
        {
            j = -90;
        }

        if(i == 2 && te.adjacentChestXPos != null)
        {
            GlStateManager.translate(1.0F, 0.0F, 0.0F);
        }

        if(i == 3 && te.adjacentChestXNeg != null)
        {
            GlStateManager.translate(-1.0F, 0.0F, 0.0F);
        }

        if(i == 4 && te.adjacentChestZNeg != null)
        {
            GlStateManager.translate(0.0F, 0.0F, 1.0F);
        }

        if(i == 5 && te.adjacentChestZPos != null)
        {
            GlStateManager.translate(0.0F, 0.0F, -1.0F);
        }

        GlStateManager.rotate((float)j, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(-0.5F, -0.5F, -0.5F);

        float f = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;

        if(te.adjacentChestZNeg != null)
        {
            float f1 = te.adjacentChestZNeg.prevLidAngle + (te.adjacentChestZNeg.lidAngle - te.adjacentChestZNeg.prevLidAngle) * partialTicks;

            if(f1 > f)
            {
                f = f1;
            }
        }

        if(te.adjacentChestXNeg != null)
        {
            float f2 = te.adjacentChestXNeg.prevLidAngle + (te.adjacentChestXNeg.lidAngle - te.adjacentChestXNeg.prevLidAngle) * partialTicks;

            if(f2 > f)
            {
                f = f2;
            }
        }

        f = 1.0F - f;
        f = 1.0F - f * f * f;

        modelchest.chestLid.rotateAngleX = -(f * ((float)Math.PI / 2F));
        modelchest.renderAll();

        if(destroyStage < 0 && te.lidAngle == 0 || te.lidAngle == 1)
        {
            GlStateManager.translate(0.5F, (float)(0.12499 - (te.lidAngle * 0.071875)), (float)(0.53126 + (te.lidAngle * 0.71875)));
            GlStateManager.scale(0.010416667F, 0.010416667F, 0.010416667F);
            GlStateManager.rotate(90 + (te.lidAngle * 90), -1.0F, 0.0F, 0.0F);

            String text = "Test text";
            FontRenderer fontRenderer = this.getFontRenderer();

            if(te.adjacentChestZNeg == null && te.adjacentChestXNeg == null && te.adjacentChestXPos == null && te.adjacentChestZPos == null)
            {
                fontRenderer.drawString(text, fontRenderer.getStringWidth(text) / -2, 0, 0x000000);
            }

            if(te.adjacentChestZNeg != null || te.adjacentChestXNeg != null || te.adjacentChestXPos != null || te.adjacentChestZPos != null)
            {
                fontRenderer.drawString(text, fontRenderer.getStringWidth(text) / -2 + 48, 0, 0x000000);
            }
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        if(destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}