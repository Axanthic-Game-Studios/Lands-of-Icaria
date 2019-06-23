package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBasicVine extends BlockVine {

	public boolean damaging = false;

	public BlockBasicVine(String name, boolean damage) {
		this(name);
		this.damaging = damage;
	}

	public BlockBasicVine(String name) {
		super();
		this.setCreativeTab(Blab.modTabFlora);
		this.setHardness(0.3F);
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if (damaging)
			entity.attackEntityFrom(net.minecraft.util.DamageSource.CACTUS, 1.0F);
	}
}
