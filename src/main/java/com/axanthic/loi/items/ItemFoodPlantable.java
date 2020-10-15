package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemFoodPlantable extends ItemFood implements IPlantable {

	public String name;
	public Block crop;
	public EnumPlantType plantType;
	public int food;
	public float saturation;
	public float effectProb;
	public PotionEffect[] effects = null;

	public ItemFoodPlantable(String name, Block crop, EnumPlantType plantType, int food, float saturation) {
		super(0, false);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
		this.name = name;
		this.crop = crop;
		this.plantType = plantType;
		this.food = food;
		this.saturation = saturation;
	}

	public ItemFoodPlantable(String name, Block crop, EnumPlantType plantType, int food, float saturation, float effectProb, PotionEffect... effects) {
		this(name, crop, plantType, food, saturation);
		this.effectProb = effectProb;
		this.effects = effects;
	}

	@Override
	public int getHealAmount(ItemStack stack) {
		return this.food;
	}

	@Override
	public float getSaturationModifier(ItemStack stack) {
		return this.saturation;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote && this.effects != null && worldIn.rand.nextFloat() < this.effectProb) {
			for (PotionEffect effect : this.effects) {
				player.addPotionEffect(new PotionEffect(effect));
			}
		}
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = player.getHeldItem(hand);
		net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
		if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())) {
			worldIn.setBlockState(pos.up(), this.crop.getDefaultState());
			if (player instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
			}
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return this.plantType;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.crop.getDefaultState();
	}
}
