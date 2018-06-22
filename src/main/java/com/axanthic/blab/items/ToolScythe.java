package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources.CompleteToolMaterial;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ToolScythe extends ItemTool {

	public ToolScythe(CompleteToolMaterial material) {
		super(material.material.getAttackDamage(), material.attackSpeed, material.material, null);
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("scythe");
		this.setRegistryName(ModInformation.ID, "scythe_" + material.material.name().substring(ModInformation.ID.length() + 1));
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + toolMaterial.name().substring(ModInformation.ID.length() + 1) + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}

	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		if (material.equals(Material.CACTUS) || material.equals(Material.CORAL) || material.equals(Material.GOURD) || material.equals(Material.LEAVES) || material.equals(Material.PLANTS) || material.equals(Material.VINE) || material.equals(Material.WEB))
			return efficiency;
		return 1.0F;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		stack.damageItem(1, entityLiving);
		return true;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		if (!(stack.getItem() instanceof ToolScythe))
			return false;
		
		World world = player.getEntityWorld();

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				for (int k = -1; k <= 1; k++) {
					if ((x + i) != x || (y + j) != y || (z + k) != z) {
						BlockPos newPos = new BlockPos(x + i, y + j, z + k);
						if (getDestroySpeed(stack, world.getBlockState(newPos)) == efficiency)
							world.destroyBlock(newPos, true);
					}
				}
			}
		}
		return false;
	}
}
