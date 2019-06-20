package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;

public class ItemReinforcer extends Item
{
	public ItemReinforcer()
	{
		super();
		this.setCreativeTab(Blab.modTabItems);
		this.setUnlocalizedName("Reinforcer");
		this.setRegistryName(ModInformation.ID, "Reinforcer");
	}

	/**
	 * Called when a Block is right-clicked with this Item
	 */
	public EnumActionResult onItemUse(final EntityPlayer playerIn, final World worldIn, final BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ)
	{
		if(!worldIn.isRemote && !playerIn.isDead) {
			if(playerIn.getHealth() >= 10) {
			/* Creating instances of wolf guards */
			double X = playerIn.posX;
			double Y = playerIn.posY;
			double Z = playerIn.posZ;
			EntityWolf guard = new EntityWolf(worldIn);
			EntityWolf guard1 = new EntityWolf(worldIn);
			EntityWolf guard2 = new EntityWolf(worldIn);
			EntityWolf guard3 = new EntityWolf(worldIn);
			playerIn.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 83, 0));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 60*20, 0));
			playerIn.setHealth(playerIn.getHealth()-10); // To prevent spamming and OP-ness. 
			playerIn.performHurtAnimation();
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 83, 1));

			/* Summoning them */
			guard.setPositionAndRotation(X+2.5, Y, Z, playerIn.getRotationYawHead(), 0);
			guard.setCustomNameTag("good boy");
			guard.setAlwaysRenderNameTag(true);
			guard.setGlowing(true);
			worldIn.spawnEntity(guard);

			guard1.setPositionAndRotation(X-2.5, Y, Z, playerIn.getRotationYawHead(), 0);
			guard1.setCustomNameTag("boy");
			guard1.setAlwaysRenderNameTag(true);
			guard1.setGlowing(true);
			worldIn.spawnEntity(guard1);

			guard2.setPositionAndRotation(X, Y, Z+2.5, playerIn.getRotationYawHead()*-1, 0);
			guard2.setCustomNameTag("boy");
			guard2.setAlwaysRenderNameTag(true);
			guard2.setGlowing(true);
			worldIn.spawnEntity(guard2);

			guard3.setPositionAndRotation(X, Y, Z-2.5, playerIn.getRotationYawHead()*-1, 0);
			guard3.setCustomNameTag("boy");
			guard3.setAlwaysRenderNameTag(true);
			guard3.setGlowing(true);
			worldIn.spawnEntity(guard3);

			/* Setting their attack targets */
			if(playerIn.getAttackingEntity() != null) {
				guard.setAttackTarget(playerIn.getAttackingEntity());	
				guard1.setAttackTarget(playerIn.getAttackingEntity());	
				guard2.setAttackTarget(playerIn.getAttackingEntity());	
				guard3.setAttackTarget(playerIn.getAttackingEntity());
			}else {
				guard.setAttackTarget(playerIn.getLastAttackedEntity());	
				guard1.setAttackTarget(playerIn.getLastAttackedEntity());	
				guard2.setAttackTarget(playerIn.getLastAttackedEntity());	
				guard3.setAttackTarget(playerIn.getLastAttackedEntity());
			}
			
			/* Making them worth some extra damage */
			PotionEffect[] powerful = {
					new PotionEffect(MobEffects.STRENGTH, 200000, 0), 
					new PotionEffect(MobEffects.SPEED, 200000, 3),  
					};
			
			for(int yeet = 0; yeet < powerful.length; ++yeet) {
				guard.addPotionEffect(powerful[yeet]);
				guard1.addPotionEffect(powerful[yeet]);
				guard2.addPotionEffect(powerful[yeet]);
				guard3.addPotionEffect(powerful[yeet]);
			}
			
			guard.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200000, 2)); 
			guard1.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200000, 2)); 
			guard2.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200000, 2)); 
			guard3.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200000, 2)); 
			
			playerIn.getAttackingEntity().setRevengeTarget(playerIn.getAttackingEntity().getAttackingEntity());
			playerIn.getAttackingEntity().attackEntityAsMob(playerIn.getAttackingEntity().getAttackingEntity());
			
			return EnumActionResult.SUCCESS;
			}else {
				return EnumActionResult.FAIL;
			}
		}else { 
			
			return EnumActionResult.FAIL;
		}
	}//ends onItemUse
}//ends class
