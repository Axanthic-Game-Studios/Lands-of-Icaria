package com.axanthic.loi.items;

import com.axanthic.loi.ModInformation;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemSaltedFood extends ItemFood {

	public ItemSaltedFood() {
		super(0, false);
		this.setCreativeTab(null);
		this.setUnlocalizedName("salted_food");
		this.setRegistryName(ModInformation.ID, "salted_food");
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String locName = I18n.translateToLocal(this.getUnlocalizedName() + ".name");
		if (!stack.hasTagCompound())
			return locName;
		ItemStack foodStack = getContainedItem(stack.getTagCompound());
		if (foodStack.isEmpty())
			return locName;
		return String.format(locName, foodStack.getItem().getItemStackDisplayName(foodStack));
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		if (!stack.hasTagCompound())
			return this.maxStackSize;
		ItemStack foodStack = getContainedItem(stack.getTagCompound());
		if (foodStack.isEmpty())
			return this.maxStackSize;
		return foodStack.getItem().getItemStackLimit(foodStack);
	}

	/**
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
	 * the Item before the action is complete.
	 */
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (!stack.hasTagCompound())
			return stack;
		ItemStack foodStack = getContainedItem(stack.getTagCompound());
		foodStack.setCount(stack.getCount());
		if (foodStack.isEmpty())
			return stack;
		ItemStack returnStack = foodStack.getItem().onItemUseFinish(foodStack, worldIn, entityLiving);
		if (returnStack.isItemEqual(foodStack)) {
			stack.setCount(foodStack.getCount());
			return stack;
		}
		return returnStack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		if (!stack.hasTagCompound())
			return 0;
		ItemStack foodStack = getContainedItem(stack.getTagCompound());
		if (foodStack.isEmpty())
			return 0;
		return foodStack.getItem().getMaxItemUseDuration(foodStack) / 2;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		if (!stack.hasTagCompound())
			return EnumAction.NONE;
		ItemStack foodStack = getContainedItem(stack.getTagCompound());
		if (foodStack.isEmpty())
			return EnumAction.NONE;
		return foodStack.getItem().getItemUseAction(foodStack);
	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (!itemstack.hasTagCompound())
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		ItemStack foodStack = getContainedItem(itemstack.getTagCompound());
		if (foodStack.isEmpty())
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		return foodStack.getItem().onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public int getHealAmount(ItemStack stack) {
		if (!stack.hasTagCompound())
			return 0;
		ItemStack foodStack = getContainedItem(stack.getTagCompound());
		if (foodStack.isEmpty() || !(foodStack.getItem() instanceof ItemFood))
			return 0;
		return ((ItemFood) foodStack.getItem()).getHealAmount(foodStack);
	}

	@Override
	public float getSaturationModifier(ItemStack stack) {
		if (!stack.hasTagCompound())
			return 0;
		ItemStack foodStack = getContainedItem(stack.getTagCompound());
		if (foodStack.isEmpty() || !(foodStack.getItem() instanceof ItemFood))
			return 0;
		return ((ItemFood) foodStack.getItem()).getSaturationModifier(foodStack);
	}

	public static ItemStack getContainedItem(NBTTagCompound nbt) {
		if (nbt.hasKey("food"))
			return new ItemStack(nbt.getCompoundTag("food"));
		return ItemStack.EMPTY;
	}
}
