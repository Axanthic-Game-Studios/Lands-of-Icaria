package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources.CompleteToolMaterial;
import com.axanthic.blab.entity.EntityFakePlayer;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ToolScythe extends ItemSword implements IItemCustomReach {

	public CompleteToolMaterial material;

	public ToolScythe(CompleteToolMaterial material) {
		super(material.material);
		this.material = material;
		this.setCreativeTab(Blab.modTabItems);
		this.setUnlocalizedName("generic.scythe");
		this.setRegistryName(ModInformation.ID, "scythe_" + material.material.name().substring(ModInformation.ID.length() + 1));
	}


	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + material.material.name().substring(ModInformation.ID.length() + 1) + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		if (enchantment.type.equals(EnumEnchantmentType.ALL) || enchantment.type.equals(EnumEnchantmentType.BREAKABLE) || enchantment.type.equals(EnumEnchantmentType.DIGGER) || enchantment.type.equals(EnumEnchantmentType.WEAPON)) {
			return true;
		}
		return enchantment.type.canEnchantItem(stack.getItem());
	}

	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		Material blockMaterial = state.getMaterial();
		if (blockMaterial.equals(Material.CACTUS) || blockMaterial.equals(Material.CORAL) || blockMaterial.equals(Material.GOURD) || blockMaterial.equals(Material.LEAVES) || blockMaterial.equals(Material.PLANTS) || blockMaterial.equals(Material.VINE) || blockMaterial.equals(Material.WEB))
			return material.material.getEfficiency();
		return 1.0F;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		stack.damageItem(1, entityLiving);
		return true;
	}

	@Override
	public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) {
		return true;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		World world = player.getEntityWorld();

		if (!(stack.getItem() instanceof ToolScythe) || getDestroySpeed(stack, world.getBlockState(pos)) != material.material.getEfficiency())
			return false;

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				for (int k = -1; k <= 1; k++) {
					if ((x + i) != x || (y + j) != y || (z + k) != z) {
						BlockPos newPos = new BlockPos(x + i, y + j, z + k);
						if (getDestroySpeed(stack, world.getBlockState(newPos)) == material.material.getEfficiency())
							world.destroyBlock(newPos, true);
					}
				}
			}
		}
		return false;
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.material.material.getAttackDamage() + 4.0D, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.material.attackSpeed - 2.0D, 0));
			multimap.put(Blab.ATTACK_RANGE.getName(), new AttributeModifier(Blab.ATTACK_RANGE_MODIFIER, "Weapon modifier", (double)this.getReach() - 5.0D, 0));
		}
		return multimap;
	}

	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = player.getHeldItem(hand);
		ItemStack itemstackHoe = new ItemStack(Items.IRON_HOE, itemstack.getCount(), itemstack.getItemDamage());
		if (itemstack.getItem().getNBTShareTag(itemstack) != null)
			itemstackHoe.writeToNBT(itemstack.getItem().getNBTShareTag(itemstack));

		if (!player.canPlayerEdit(pos.offset(facing), facing, itemstackHoe)) {
			return EnumActionResult.FAIL;
		} else {
			int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(itemstackHoe, player, worldIn, pos);
			if (hook != 0) {
				itemstack.setItemDamage(itemstackHoe.getItemDamage());
				return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
			}

			IBlockState iblockstate = worldIn.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up())) {
				if (block == Blocks.GRASS || block == Blocks.GRASS_PATH) {
					this.setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
					return EnumActionResult.SUCCESS;
				}
				if (block == Blocks.DIRT) {
					if (BlockDirt.DirtType.COARSE_DIRT.equals((BlockDirt.DirtType) iblockstate.getValue(BlockDirt.VARIANT))) {
						this.setBlock(itemstack, player, worldIn, pos, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
						return EnumActionResult.SUCCESS;
					}
					if (BlockDirt.DirtType.DIRT.equals((BlockDirt.DirtType) iblockstate.getValue(BlockDirt.VARIANT))) {
						this.setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
						return EnumActionResult.SUCCESS;
					}
				}
			}
			EntityPlayer fakeplayer = new EntityFakePlayer(player.getEntityWorld(), player.getGameProfile(), player.isCreative(), player.isSpectator());

			if (hand == EnumHand.MAIN_HAND)
				fakeplayer.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstackHoe);
	        else if (hand == EnumHand.OFF_HAND)
				fakeplayer.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, itemstackHoe);

			if (block.onBlockActivated(worldIn, pos, iblockstate, fakeplayer, hand, facing, hitX, hitY, hitZ)) {
				itemstack.setItemDamage(itemstackHoe.getItemDamage());
				return EnumActionResult.SUCCESS;
			}
			return EnumActionResult.PASS;
		}
	}

	protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state) {
		worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

		if (!worldIn.isRemote) {
			worldIn.setBlockState(pos, state, 11);
			stack.damageItem(1, player);
		}
	}

	@Override
	public float getReach() {
		return 6.0F;
	}
}
