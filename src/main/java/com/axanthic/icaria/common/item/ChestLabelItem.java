package com.axanthic.icaria.common.item;

import com.axanthic.icaria.client.screen.ChestLabelScreen;
import com.axanthic.icaria.common.registry.IcariaDataComponents;
import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelItem extends Item {
	public ChestLabelItem(Properties pProperties) {
		super(pProperties.component(IcariaDataComponents.COLOR, 0).component(IcariaDataComponents.LABEL, "").component(IcariaDataComponents.STYLE, false));
	}

	public int getColorByColor(int pColor) {
		return pColor == 0 ? 16777215 : pColor;
	}

	public int getColorByStyle(boolean pStyle) {
		return pStyle ? 16777045 : 5592575;
	}

	@Override
	public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pList, TooltipFlag pFlag) {
		var color = pStack.getOrDefault(IcariaDataComponents.COLOR, 0);
		var label = pStack.getOrDefault(IcariaDataComponents.LABEL, "");
		var style = pStack.getOrDefault(IcariaDataComponents.STYLE, false);

		pList.add(Component.translatable(this.getLabelByLabel(label)).withStyle(ChatFormatting.GRAY));
		pList.add(CommonComponents.EMPTY);
		pList.add(Component.translatable("tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "color").withStyle(ChatFormatting.GRAY));
		pList.add(Component.translatable(this.getNameByColor(color)).withColor(this.getColorByColor(color)));
		pList.add(Component.translatable("tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "style").withStyle(ChatFormatting.GRAY));
		pList.add(Component.translatable(this.getNameByStyle(style)).withColor(this.getColorByStyle(style)));
	}

	public String getLabelByLabel(String pLabel) {
		return pLabel.isEmpty() ? "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "title" : pLabel;
	}

	public String getNameByColor(int pColor) {
		return switch (pColor) {
			case 16777215 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "white";
			case 13882323 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "light_gray";
			case 8421504 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "gray";
			case 0 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "black";
			case 9127187 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "brown";
			case 16711680 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "red";
			case 16738335 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "orange";
			case 16776960 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "yellow";
			case 12582656 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "lime";
			case 65280 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "green";
			case 65535 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "cyan";
			case 10141901 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "light_blue";
			case 255 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "blue";
			case 10494192 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "purple";
			case 16711935 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "magenta";
			case 16738740 -> "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "pink";
			default -> throw new IllegalStateException("Unexpected value: " + pColor);
		};
	}

	public String getNameByStyle(boolean pStyle) {
		return pStyle ? "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "glowing" : "tooltip" + "." + IcariaIdents.ID + "." + "chest_label" + "." + "classic";
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		var stack = pPlayer.getItemInHand(pUsedHand);
		Minecraft.getInstance().setScreen(new ChestLabelScreen(stack));
		return InteractionResultHolder.sidedSuccess(stack, pLevel.isClientSide());
	}
}
