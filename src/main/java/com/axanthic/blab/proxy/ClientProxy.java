package com.axanthic.blab.proxy;

import java.awt.Color;
import java.util.List;

import javax.annotation.Nullable;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockFlower;
import com.axanthic.blab.blocks.BlockHerb;
import com.axanthic.blab.blocks.BlockLeaf;
import com.axanthic.blab.blocks.BlockLog;
import com.axanthic.blab.blocks.BlockSapling;
import com.axanthic.blab.blocks.BlockTallGrass;
import com.axanthic.blab.blocks.IBlockMeta;
import com.axanthic.blab.entity.EntityAeternae;
import com.axanthic.blab.entity.EntityBident;
import com.axanthic.blab.entity.EntityFallingVase;
import com.axanthic.blab.entity.EntityForestHag;
import com.axanthic.blab.entity.EntityRevenant;
import com.axanthic.blab.entity.RenderAeternae;
import com.axanthic.blab.entity.RenderBident;
import com.axanthic.blab.entity.RenderForestHag;
import com.axanthic.blab.entity.RenderRevenant;
import com.axanthic.blab.items.IItemCustomReach;
import com.axanthic.blab.items.ItemBlockMeta;
import com.axanthic.blab.items.ItemCustomArmor;
import com.axanthic.blab.items.ItemMeta;
import com.axanthic.blab.utils.MessageCustomReachAttack;
import com.axanthic.blab.utils.TileEntityGrinder;
import com.axanthic.blab.utils.TileEntitySpecialRendererGrinder;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	public static final ResourceLocation SOUND_GRIND = new ResourceLocation(ModInformation.ID, "block.grinder.grind");
	public static final SoundEvent GRIND = new SoundEvent(SOUND_GRIND).setRegistryName(SOUND_GRIND);

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityBident.class, RenderBident::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFallingVase.class, RenderFallingBlock::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityAeternae.class, RenderAeternae::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityForestHag.class, RenderForestHag::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRevenant.class, RenderRevenant::new);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrinder.class, new TileEntitySpecialRendererGrinder());
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@Override
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		super.registerBlocks(event);
	}

	@Override
	public void registerItems(RegistryEvent.Register<Item> event) {
		super.registerItems(event);

		for (ItemBlock block : Resources.blocks) {
			if (block.getBlock() instanceof BlockFlower || block.getBlock() instanceof BlockTallGrass || block.getBlock() instanceof BlockHerb) {
				for (int i = 0; i < ((IBlockMeta) block.getBlock()).getNames().length; i++) {
					ModelLoader.setCustomModelResourceLocation(block, i, new ModelResourceLocation(block.getRegistryName() + "_inv", "type=" + ((IBlockMeta) block.getBlock()).getNames()[i]));
				}
			} else if (block instanceof ItemBlockMeta) {
				ModelLoader.setCustomMeshDefinition(block, new ItemMeshDefinition() {
					@Override
					public ModelResourceLocation getModelLocation(ItemStack stack) {
						return new ModelResourceLocation(block.getRegistryName(), "type=" + ((IBlockMeta) block.getBlock()).getNameForMeta(stack.getMetadata()));
					}});
			} else if (block.getBlock() instanceof BlockLeaf || block.getBlock() instanceof BlockSapling) {
				String[] path = block.getRegistryName().getResourcePath().split("_");
				if (block.getBlock() instanceof BlockSapling)
					ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]), "inv_" + path[0]));
				else
					ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]), path[0]));
				ModelLoader.setCustomStateMapper(block.getBlock(), new StateMapperBase() {
					@Override
					public ModelResourceLocation getModelResourceLocation(IBlockState state) {
						return new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]), path[0]);
					}});
			} else if (block.getBlock() instanceof BlockLog) {
				String[] path = block.getRegistryName().getResourcePath().split("_");
				ResourceLocation loc = new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]);
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(loc, path[0] + "_y"));
				ModelLoader.setCustomStateMapper(block.getBlock(), new StateMapperBase() {
					@Override
					public ModelResourceLocation getModelResourceLocation(IBlockState state) {
						String axis = "bark";
						int meta = ((BlockLog) block.getBlock()).getMetaFromState(state);
						if (meta == 0) {
							axis = "y";
						} else if (meta == 4) {
							axis = "x";
						} else if (meta == 8) {
							axis = "z";
						}
						return new ModelResourceLocation(loc, path[0] + "_" + axis);
					}});
			} else
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}

		for (Item item : Resources.items) {
			if (item instanceof ItemMeta) {
				for (int i = 0; i < ((ItemMeta) item).names.length; i++) {
					ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), "type=" + ((ItemMeta) item).names[i]));
				}
			} else if (item instanceof ItemTool || item instanceof ItemSword || item instanceof ItemCustomArmor) {
				String[] path = item.getRegistryName().getResourcePath().split("_");
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), "tool_" + path[1]), path[0]));
			} else
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}

	@Override
	public void registerBlockColors(ColorHandlerEvent.Block event) {
		event.getBlockColors().registerBlockColorHandler(new IBlockColor() {
			@Override
			public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) {
				return reduceGreen(worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : ColorizerGrass.getGrassColor(0.5D, 1.0D));
			}
		}, Resources.grass.getBlock(), Resources.tallGrass.getBlock());
	}

	@Override
	public void registerItemColors(ColorHandlerEvent.Item event) {
		event.getItemColors().registerItemColorHandler(new IItemColor() {
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				return reduceGreen(ColorizerGrass.getGrassColor(0.5D, 1.0D));
			}
		}, Resources.grass, Resources.tallGrass);
	}

	public int reduceGreen(int color) {
		Color col = new Color(color);
		return new Color(Math.min(col.getRed() + 30, 255), Math.max(col.getGreen() - 10, 0), col.getBlue()).getRGB();
	}

	@Override
	public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().register(GRIND);
	}

	@Override
	public void onMouseEvent(MouseEvent event) {
		if (event.getButton() == 0 && event.isButtonstate()) {
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer thePlayer = mc.player;
			if (thePlayer != null) {
				ItemStack itemstack = thePlayer.getHeldItemMainhand();
				IItemCustomReach ieri = null;
				if (itemstack != null) {
					if (itemstack.getItem() instanceof IItemCustomReach) {
						ieri = (IItemCustomReach) itemstack.getItem();
					}
					if (ieri != null) {
						float reach = ieri.getReach();
						RayTraceResult mov = getMouseOverExtended(reach);
						if (mov != null && mov.entityHit != null) {
							if (mov.entityHit.hurtResistantTime == 0) {
								if (mov.entityHit != thePlayer) {
									Blab.network.sendToServer(new MessageCustomReachAttack(mov.entityHit.getEntityId()));
								}
							}
						}
					}
				}
			}
		}
	}

	public static RayTraceResult getMouseOverExtended(float dist) {
		Minecraft mc = FMLClientHandler.instance().getClient();
		Entity theRenderViewEntity = mc.getRenderViewEntity();
		RayTraceResult returnRTR = null;
		if (mc.world != null) {
			returnRTR = theRenderViewEntity.rayTrace(dist, 0);
			Vec3d pos = theRenderViewEntity.getPositionEyes(0);
			Vec3d lookvec = theRenderViewEntity.getLook(0);
			Vec3d var8 = pos.addVector(lookvec.x * dist, lookvec.y * dist, lookvec.z * dist);
			Entity pointedEntity = null;
			float var9 = 1.0F;
			List<Entity> list = mc.world.getEntitiesInAABBexcluding(theRenderViewEntity, theRenderViewEntity.getEntityBoundingBox().expand(lookvec.x * dist, lookvec.y * dist, lookvec.z * dist).grow(var9, var9, var9), Predicates.and(EntitySelectors.NOT_SPECTATING, new Predicate<Entity>() {
				public boolean apply(@Nullable Entity entity) {
					return entity != null && entity.canBeCollidedWith();
				}
			}));
			double d = dist;

			for (Entity entity : list) {
				AxisAlignedBB aabb = entity.getEntityBoundingBox().grow((double)entity.getCollisionBorderSize());
				RayTraceResult mop0 = aabb.calculateIntercept(pos, var8);

				if (mop0 != null) {
					double d1 = pos.distanceTo(mop0.hitVec);
					if (d1 < d) {
						pointedEntity = entity;
						d = d1;
					}
				}
			}
			if (pointedEntity != null && (d < dist )) {
				returnRTR = new RayTraceResult(pointedEntity);
			}
		}
		return returnRTR;
	}
}
