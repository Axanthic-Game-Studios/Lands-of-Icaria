package com.axanthic.loi.tileentity;

import com.axanthic.loi.LOISigns;
import com.axanthic.loi.ModInformation;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TESRSignPopulus extends TileEntitySpecialRenderer<TESignPopulus>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/blocks/wood_populus_sign.png");

    public static final ModelSign model = new ModelSign();

    @Override
    public void render(TESignPopulus tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        int i1 = tileEntity.getBlockMetadata();
        int i2 = (i1 & 6) >> 1;

        float f1 = tileEntity.getBlockMetadata() * 22.5F;
        float f2 = 0.0F;

        boolean wallSign = ((i1 & 8) >> 3) == 1;
        boolean flatSign = (i1 & 1) == 1;

        Block block = tileEntity.getBlockType();

        GlStateManager.pushMatrix();

        if (block == LOISigns.signStandingPopulus)
        {
            GlStateManager.translate((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
            GlStateManager.rotate(-f1, 0.0F, 1.0F, 0.0F);

            this.model.signStick.showModel = true;
        }

        else
        {
            if (wallSign)
            {
                if (flatSign)
                {
                    if (i2 == 1)
                    {
                        f2 = 90F;
                    }
                    if (i2 == 2)
                    {
                        f2 = 180F;
                    }
                    if (i2 == 3)
                    {
                        f2 = -90F;
                    }
                }

                else
                {
                    if (i2 == 0)
                    {
                        f2 = 180F;
                    }
                    if (i2 == 1)
                    {
                        f2 = -90F;
                    }
                    if (i2 == 2)
                    {
                        f2 = 0F;
                    }
                    if (i2 == 3)
                    {
                        f2 = 90F;
                    }
                }
            }

            else
            {
                if (i1 == 2)
                {
                    f2 = 180.0F;
                }
                if (i1 == 4)
                {
                    f2 = 90.0F;
                }
                if (i1 == 5)
                {
                    f2 = -90.0F;
                }
            }

            GlStateManager.translate((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
            GlStateManager.rotate(-f2, 0.0F, 1.0F, 0.0F);

            if (wallSign && !flatSign)
            {
                GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (wallSign && flatSign)
            {
                GlStateManager.rotate(270.0F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            }

            GlStateManager.translate(0.0F, -0.3125F, -0.4375F);

            this.model.signStick.showModel = false;
        }

        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);

            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 2.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }

        else
        {
            this.bindTexture(TEXTURE);
        }

        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.6666667F, -0.6666667F, -0.6666667F);

        this.model.renderSign();

        GlStateManager.popMatrix();

        FontRenderer fontrenderer = this.getFontRenderer();

        GlStateManager.translate(0.0F, 0.33333334F, 0.046666667F);
        GlStateManager.scale(0.010416667F, -0.010416667F, 0.010416667F);
        GlStateManager.glNormal3f(0.0F, 0.0F, -0.010416667F);
        GlStateManager.depthMask(false);

        if (destroyStage < 0)
        {
            for (int j = 0; j < tileEntity.signText.length; ++j)
            {
                if (tileEntity.signText[j] != null)
                {
                    ITextComponent itextcomponent = tileEntity.signText[j];
                    List<ITextComponent> list = GuiUtilRenderComponents.splitText(itextcomponent, 90, fontrenderer, false, true);
                    String s = list != null && !list.isEmpty() ? list.get(0).getFormattedText() : "";

                    if (j == tileEntity.lineBeingEdited)
                    {
                        s = "> " + s + " <";
                    }

                    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, j * 10 - tileEntity.signText.length * 5, 0);
                }
            }
        }

        GlStateManager.depthMask(true);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}