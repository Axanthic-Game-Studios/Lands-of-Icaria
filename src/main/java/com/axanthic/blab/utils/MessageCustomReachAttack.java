package com.axanthic.blab.utils;

import com.axanthic.blab.items.IItemCustomReach;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCustomReachAttack implements IMessage {
	private int entityId;

	public MessageCustomReachAttack() {
		// need this constructor
	}

	public MessageCustomReachAttack(int parEntityId) {
		entityId = parEntityId;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityId = ByteBufUtils.readVarInt(buf, 4);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, entityId, 4);
		// DEBUG
	}

	public static class Handler implements IMessageHandler<MessageCustomReachAttack,IMessage> {
		@Override
		public IMessage onMessage(final MessageCustomReachAttack message, MessageContext ctx) {
			final EntityPlayerMP thePlayer = ctx.getServerHandler().player;
			thePlayer.getServer().addScheduledTask(new Runnable() {
				@Override
				public void run() {
					Entity theEntity = thePlayer.world.getEntityByID(message.entityId);
					if (thePlayer.getHeldItemMainhand() == null) {
						return;
					}
					if (thePlayer.getHeldItemMainhand().getItem() instanceof IItemCustomReach) {
						IItemCustomReach theExtendedReachWeapon = (IItemCustomReach) thePlayer.getHeldItemMainhand().getItem();
						double distanceSq = thePlayer.getDistanceSq(theEntity);
						double reachSq = theExtendedReachWeapon.getReach() * theExtendedReachWeapon.getReach();
						if (reachSq >= distanceSq) {
							thePlayer.attackTargetEntityWithCurrentItem(theEntity);
						}
					}
					return; 
				}
			});
			return null;
		}
	}
}
