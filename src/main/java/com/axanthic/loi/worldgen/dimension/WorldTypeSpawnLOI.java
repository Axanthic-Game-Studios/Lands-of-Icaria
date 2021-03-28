package com.axanthic.loi.worldgen.dimension;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.blocks.BlockIcariaPortal;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class WorldTypeSpawnLOI extends WorldType {

	public static final String TAG_PLAYER_HAS_SPAWNED = ModInformation.ID + ".has_spawned";

	public WorldTypeSpawnLOI() {
		super("loi_spawn");
		MinecraftForge.EVENT_BUS.register(this);
	}

	public WorldType getWorldTypeForGeneratorVersion(int version) {
		return version == 0 ? DEFAULT_1_1 : this;
	}

	public boolean hasInfoNotice() {
		return true;
	}

	@SubscribeEvent
	public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.player.world.getWorldType().equals(LandsOfIcaria.LOI_SPAWN_WORLD_TYPE)) {
			NBTTagCompound tag = event.player.getEntityData();
			NBTTagCompound persistedTag = tag.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);

			if (!persistedTag.hasKey(TAG_PLAYER_HAS_SPAWNED) || !persistedTag.getBoolean(TAG_PLAYER_HAS_SPAWNED)) {
				persistedTag.setBoolean(TAG_PLAYER_HAS_SPAWNED, true);
				tag.setTag(EntityPlayer.PERSISTED_NBT_TAG, persistedTag);
				BlockIcariaPortal.changeDimension(event.player.world, event.player, LandsOfIcaria.dimensionId, new TeleporterLOINoPortal());
			}
		}
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (event.player.world.getWorldType().equals(LandsOfIcaria.LOI_SPAWN_WORLD_TYPE) && event.player.dimension != LandsOfIcaria.dimensionId) {
			BlockIcariaPortal.changeDimension(event.player.world, event.player, LandsOfIcaria.dimensionId, new TeleporterLOINoPortal());
		}
	}
}