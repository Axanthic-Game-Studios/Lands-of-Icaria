package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.worldgen.feature.WorldGenShips;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWingsDispenser extends BlockBasic {

	public static ItemStack IcarusWings;
	public static String ICARUS_WINGS_TAG = "is_icarus_wings";
	public static String HAS_FLOWN_TAG = "has_flown_icarus";

	public BlockWingsDispenser(Material material, float hardness, String name, MapColor color) {
		super(material, hardness, name, color);
		this.setResistance(6000000.0F);
		this.disableStats();
		MinecraftForge.EVENT_BUS.register(this);
		IcarusWings = new ItemStack(Items.ELYTRA);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean(ICARUS_WINGS_TAG, true);
		IcarusWings.setTagCompound(nbt);
		IcarusWings.addEnchantment(Enchantments.BINDING_CURSE, 1);
		IcarusWings.addEnchantment(Enchantments.VANISHING_CURSE, 1);
		IcarusWings.setItemDamage(IcarusWings.getMaxDamage() - 40);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!playerIn.hasItemInSlot(EntityEquipmentSlot.CHEST)) {
			playerIn.setItemStackToSlot(EntityEquipmentSlot.CHEST, IcarusWings.copy());
		}
		return false;
	}

	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
	}

	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
		return false;
	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntityLiving() instanceof EntityPlayer) {
			ItemStack chest = event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.CHEST);
			if (chest.getItem() == Items.ELYTRA && chest.hasTagCompound() && chest.getTagCompound().getBoolean(ICARUS_WINGS_TAG)) {
				if (chest.getTagCompound().getBoolean(HAS_FLOWN_TAG)) {
					if (event.getEntityLiving().onGround) {
						event.getEntityLiving().setItemStackToSlot(EntityEquipmentSlot.CHEST, ItemStack.EMPTY);
					} else {
						if (event.getEntityLiving().posY > WorldGenShips.spawnShipHeight + 10)
							chest.setItemDamage(432);
						if (!ItemElytra.isUsable(chest))
							event.getEntityLiving().setFire(3);
					}
				} else {
					if (event.getEntityLiving().isElytraFlying()) {
						chest.getTagCompound().setBoolean(HAS_FLOWN_TAG, true);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onItemTooltip(ItemTooltipEvent event) {
		if (event.getItemStack().getItem() == Items.ELYTRA && event.getItemStack().hasTagCompound() && event.getItemStack().getTagCompound().getBoolean(ICARUS_WINGS_TAG)) {
			event.getToolTip().set(0, I18n.translateToLocal("item.icarus_wings.name"));
		}
	}
}
