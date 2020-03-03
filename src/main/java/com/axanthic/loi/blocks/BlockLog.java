package com.axanthic.loi.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.entity.EntityForestHag;
import com.axanthic.loi.items.ItemBlockMaterial;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLog extends BlockRotatedPillar implements IBlockMaterial {

	public BlockPlanks.WoodTypes type;
	public boolean stripped;
	public ItemBlockMaterial strippedLog;

	public BlockLog(BlockPlanks.WoodTypes type, MapColor color, ItemBlockMaterial stripped) {
		super(Material.WOOD, color);
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setHardness(2.0F);
		this.type = type;
		this.strippedLog = stripped;
		this.setSoundType(SoundType.WOOD);
		if (type.mapColor.equals(color)) {
			this.setUnlocalizedName("log_stripped");
			this.setRegistryName(ModInformation.ID, "stripped_" + type.unlocalizedName);
			this.stripped = true;
		} else {
			this.setUnlocalizedName("log");
			this.setRegistryName(ModInformation.ID, "log_" + type.unlocalizedName);
			this.stripped = false;
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5))) {
			for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4))) {
				IBlockState iblockstate = worldIn.getBlockState(blockpos);
				if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos)) {
					iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
				}
			}
		}
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, state, te, stack);
		if (stripped || player == null)
			return;
		for(EntityForestHag forestHag : worldIn.getEntitiesWithinAABB(EntityForestHag.class, new AxisAlignedBB(pos).grow(32))) {
			if (forestHag.type == this.type.meta)
				forestHag.setAttackTarget(player);
		}

		Random rand = new Random();
		if (rand.nextInt(100) != 0)
			return;

		EntityForestHag forestHag;
		try {
			forestHag = (EntityForestHag) Resources.getWoodSetFromType(this.type).hag.getConstructors()[0].newInstance(worldIn);
		} catch (Exception e) {
			return;
		}

		int i = MathHelper.floor(pos.getX());
		int j = MathHelper.floor(pos.getY());
		int k = MathHelper.floor(pos.getZ());
		for (int l = 0; l < 50; ++l) {
			int i1 = i + MathHelper.getInt(rand, 7, 40) * MathHelper.getInt(rand, -1, 1);
			int j1 = j + MathHelper.getInt(rand, 7, 40) * MathHelper.getInt(rand, -1, 1);
			int k1 = k + MathHelper.getInt(rand, 7, 40) * MathHelper.getInt(rand, -1, 1);
			if (worldIn.getBlockState(new BlockPos(i1, j1 - 1, k1)).isSideSolid(worldIn, new BlockPos(i1, j1 - 1, k1), net.minecraft.util.EnumFacing.UP)) {
				forestHag.setPosition((double)i1, (double)j1, (double)k1);
				if (!worldIn.isAnyPlayerWithinRangeAt((double)i1, (double)j1, (double)k1, 7.0D) && worldIn.checkNoEntityCollision(forestHag.getEntityBoundingBox(), forestHag) && worldIn.getCollisionBoxes(forestHag, forestHag.getEntityBoundingBox()).isEmpty() && !worldIn.containsAnyLiquid(forestHag.getEntityBoundingBox())) {
					worldIn.spawnEntity(forestHag);
					forestHag.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(forestHag)), (IEntityLivingData)null);
					//player.playSound(SoundEvents.ENTITY_WITHER_BREAK_BLOCK, 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
					break;
				}
			}
		}
	}

	@Override
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		if (!stripped && (itemstack.getItem() instanceof ItemAxe || itemstack.getItem().getToolClasses(itemstack).contains("axe")) && playerIn.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
			worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			if (!worldIn.isRemote) {
				worldIn.setBlockState(pos, strippedLog.getBlock().getStateFromMeta(this.getMetaFromState(worldIn.getBlockState(pos))));
				itemstack.damageItem(1, playerIn);
			}
			return true;
		}
		return false;
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		if (((EnumFacing.Axis)state.getValue(AXIS)).equals(EnumFacing.Axis.Y) || stripped)
			return type.mapColor;
		return type.logColor;
	}

	@Override
	public String getName() {
		return "material." + type.getName() + ".name";
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}
}
