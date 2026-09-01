package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaDataComponents;
import com.axanthic.icaria.common.registry.IcariaKeys;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelItem extends Item {
	public ChestLabelItem(Properties pProperties) {
		super(pProperties.component(IcariaDataComponents.COLOR, 0xFF000000).component(IcariaDataComponents.LABEL, "").component(IcariaDataComponents.STYLE, false));
	}

	public int getColorByColor(int pColor) {
		return pColor == 0xFF000000 ? 0xFFFFFFFF : pColor;
	}

	public int getColorByStyle(boolean pStyle) {
		return pStyle ? 0xFFFFFF55 : 0xFFFFFFFF;
	}

	@Override
	public void appendHoverText(ItemStack pItemStack, TooltipContext pTooltipContext, TooltipDisplay pTooltipDisplay, Consumer<Component> pConsumer, TooltipFlag pTooltipFlag) {
		var color = pItemStack.getOrDefault(IcariaDataComponents.COLOR, 0xFF000000);
		var label = pItemStack.getOrDefault(IcariaDataComponents.LABEL, "");
		var style = pItemStack.getOrDefault(IcariaDataComponents.STYLE, false);

		pConsumer.accept(Component.translatable("tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "label").withStyle(ChatFormatting.GRAY));
		pConsumer.accept(Component.translatable(this.getLabelByLabel(label)));
		pConsumer.accept(Component.translatable("tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "color").withStyle(ChatFormatting.GRAY));
		pConsumer.accept(Component.translatable(this.getNameByColor(color)).withColor(this.getColorByColor(color)));
		pConsumer.accept(Component.translatable("tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "style").withStyle(ChatFormatting.GRAY));
		pConsumer.accept(Component.translatable(this.getNameByStyle(style)).withColor(this.getColorByStyle(style)));
	}

	public String getLabelByLabel(String pLabel) {
		return pLabel.isEmpty() ? "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "title" : pLabel;
	}

	public String getNameByColor(int pColor) {
		return switch (pColor) {
			case 0xFFFFFFFF -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "white";
			case 0xFFD3D3D3 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "light_gray";
			case 0xFF808080 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "gray";
			case 0xFF000000 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "black";
			case 0xFF8B4513 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "brown";
			case 0xFFFF0000 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "red";
			case 0xFFFF681F -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "orange";
			case 0xFFFFFF00 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "yellow";
			case 0xFFBFFF00 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "lime";
			case 0xFF00FF00 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "green";
			case 0xFF00FFFF -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "cyan";
			case 0xFF9AC0CD -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "light_blue";
			case 0xFF0000FF -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "blue";
			case 0xFFA020F0 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "purple";
			case 0xFFFF00FF -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "magenta";
			case 0xFFFF69B4 -> "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "pink";
			default -> throw new IllegalStateException("Unexpected value: " + pColor);
		};
	}

	public String getNameByStyle(boolean pStyle) {
		return pStyle ? "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "glowing" : "tooltip" + "." + IcariaKeys.ID + "." + "chest_label" + "." + "classic";
	}
}
