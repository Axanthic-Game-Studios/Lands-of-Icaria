package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaIdents;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PillarHeadItem extends BlockItem {
	public PillarHeadItem(Block pBlock, Properties pProperties) {
		super(pBlock, pProperties);
	}

	@Override
	public void appendHoverText(ItemStack pItemStack, TooltipContext pTooltipContext, TooltipDisplay pTooltipDisplay, Consumer<Component> pConsumer, TooltipFlag pTooltipFlag) {
		pConsumer.accept(Component.translatable("tooltip" + "." + IcariaIdents.ID + "." + "pillar_head" + "." + "title").withStyle(ChatFormatting.GRAY));
	}
}
