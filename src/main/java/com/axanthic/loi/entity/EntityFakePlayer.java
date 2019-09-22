package com.axanthic.loi.entity;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityFakePlayer extends EntityPlayer {
	
	Boolean creative;
	Boolean spectator;

	public EntityFakePlayer(World worldIn, GameProfile gameProfileIn, boolean creative, boolean spectator) {
		super(worldIn, gameProfileIn);
		this.creative = creative;
		this.spectator = spectator;
	}
	@Override
	public boolean isCreative() {
		return creative;
	}

	@Override
	public boolean isSpectator() {
		return spectator;
	}

}