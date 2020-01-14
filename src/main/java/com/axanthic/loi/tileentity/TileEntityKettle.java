package com.axanthic.loi.tileentity;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

import com.axanthic.loi.Resources;
import com.axanthic.loi.proxy.CommonProxy;
import com.axanthic.loi.utils.KettleRecipe;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.server.management.PlayerChunkMap;
import net.minecraft.server.management.PlayerChunkMapEntry;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.TileFluidHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class TileEntityKettle extends TileFluidHandler implements ITickable {

	protected Deque<ItemStack> ingredientStack = new ArrayDeque<ItemStack>();
	protected KettleRecipe currentRecipe = null;
	protected boolean ingredientEmpty = true;
	protected int lastUpdate = 0;//only updated server side
	protected int ingredientStrength = 1000;

	public TileEntityKettle() {
		super();
		this.tank = new FluidTank(new FluidStack(Resources.waterFluid, 0), Fluid.BUCKET_VOLUME) {
			public boolean canFillFluidType(FluidStack fluid) {
				return canFill() && fluid.getFluid().equals(Resources.waterFluid);
			}

			public int fillInternal(FluidStack resource, boolean doFill) {
				if (resource == null || resource.amount <= 0) {
					return 0;
				}

				if (!doFill) {
					if (fluid == null) {
						return Math.min(capacity, resource.amount);
					}

					if (!fluid.isFluidEqual(resource)) {
						return 0;
					}

					return Math.min(capacity - fluid.amount, resource.amount);
				}

				if (fluid == null) {
					fluid = new FluidStack(resource, Math.min(capacity, resource.amount));

					onContentsChanged();

					TileEntityKettle.this.onFluidAdded(fluid.amount);

					if (tile != null) {
						FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(fluid, tile.getWorld(), tile.getPos(), this, fluid.amount));
					}
					return fluid.amount;
				}

				if (!fluid.isFluidEqual(resource)) {
					return 0;
				}
				int filled = capacity - fluid.amount;

				if (resource.amount < filled) {
					fluid.amount += resource.amount;
					filled = resource.amount;
				} else {
					fluid.amount = capacity;
				}

				onContentsChanged();

				TileEntityKettle.this.onFluidAdded(filled);

				if (tile != null) {
					FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(fluid, tile.getWorld(), tile.getPos(), this, filled));
				}
				return filled;
			}

			protected void onContentsChanged() {
				TileEntityKettle.this.syncToClient(false);
			}
		};
		this.tank.setTileEntity(this);
		this.tank.setCanDrain(false);
		for (int i = 0; i < 5; ++i)
			ingredientStack.offer(ItemStack.EMPTY);
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NonNullList inventoryItems = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, inventoryItems);
		ingredientStack.clear();
		ingredientStack.addAll(inventoryItems);
		ingredientStrength = compound.getInteger("Ingredient_strength");
		updateRecipe();
		ingredientEmpty = true;
		for (ItemStack stack : ingredientStack) {
			ingredientEmpty = ingredientEmpty && stack.isEmpty();
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		ItemStackHelper.saveAllItems(compound, NonNullList.<ItemStack>from(ItemStack.EMPTY, ingredientStack.toArray(new ItemStack[5])));
		compound.setInteger("Ingredient_strength", ingredientStrength);

		return compound;
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	public void handleUpdateTag(NBTTagCompound nbt) {
		this.readFromNBT(nbt);
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbtTag = this.getUpdateTag();
		return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.handleUpdateTag(pkt.getNbtCompound());
	}

	@Override
	public void update() {
		if (!this.world.isRemote) {
			lastUpdate++;
			for (EntityItem entityItem : getCaptureItems(this.getWorld(), this.getPos())) {
				ItemStack itemstack = entityItem.getItem().copy();

				ItemStack copystack = itemstack.copy();
				copystack.setCount(1);

				if (ingredientStack.size() >= 5)
					ingredientStack.poll();
				ingredientStack.offer(copystack);

				itemstack.shrink(1);

				if (itemstack.isEmpty()) {
					entityItem.setDead();
				} else {
					entityItem.setItem(itemstack);
				}

				ingredientStrength = Math.min(1000, ingredientStrength + 300);

				ingredientEmpty = false;

				updateRecipe();

				this.markDirty();

				this.syncToClient(false);

				break;
			}
		}
	}

	@Override
	@javax.annotation.Nullable
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
		return super.getCapability(capability, facing);
	}

	public static List<EntityItem> getCaptureItems(World worldIn, BlockPos pos) {
		return worldIn.<EntityItem>getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos.getX(), pos.getY() + 0.5D, pos.getZ(), pos.getX() + 1.0D, pos.getY() + 1.0D, pos.getZ() + 1.0D), EntitySelectors.IS_ALIVE);
	}

	public void updateRecipe() {
		currentRecipe = null;
		for (KettleRecipe recipe : (Collection<KettleRecipe>) CommonProxy.kettleRecipeRegistry.getValuesCollection()) {
			if (recipe.matches(ingredientStack.toArray(new ItemStack[5]))) {
				currentRecipe = recipe;
				break;
			}
		}
	}

	public boolean craft(EntityPlayer player) {
		if (currentRecipe == null || this.tank.getFluidAmount() < 200)
			return false;

		ItemHandlerHelper.giveItemToPlayer(player, currentRecipe.getOutput(ingredientStack.toArray(new ItemStack[5])));

		this.tank.drainInternal(200, true);

		if (this.tank.getFluidAmount() == 0) {
			ingredientStack.clear();
			for (int i = 0; i < 5; ++i)
				ingredientStack.offer(ItemStack.EMPTY);

			currentRecipe = null;
			ingredientStrength = 1000;
			ingredientEmpty = true;

			this.syncToClient(true);
		}

		this.markDirty();

		this.syncToClient(true);

		return true;
	}

	public int getColor() {
		if (currentRecipe == null) {
			if (ingredientEmpty)
				return 0x22473A;
			return 0x443630;
		}
		return currentRecipe.getColor();
	}

	public void onFluidAdded(int amount) {
		if (!ingredientEmpty) {
			ingredientStrength = Math.max(0, ingredientStrength - amount * 2);
			if (ingredientStrength == 0) {
				ingredientStack.clear();
				for (int i = 0; i < 5; ++i)
					ingredientStack.offer(ItemStack.EMPTY);

				currentRecipe = null;
				ingredientStrength = 1000;
				ingredientEmpty = true;

				this.syncToClient(true);
			}
		}
	}

	public int getFluidLevel() {
		return this.tank.getFluidAmount();
	}

	protected void syncToClient(boolean forceUpdate) {
		if(world instanceof WorldServer && (forceUpdate || lastUpdate > 10)) {
			lastUpdate = 0;
			SPacketUpdateTileEntity packet = this.getUpdatePacket();
			if (packet != null) {
				PlayerChunkMap chunkMap = ((WorldServer) world).getPlayerChunkMap();
				int i = this.getPos().getX() >> 4;
			int j = this.getPos().getZ() >> 4;
				PlayerChunkMapEntry entry = chunkMap.getEntry(i, j);
				if(entry != null) {
					entry.sendPacket(packet);
				}
			}
		}
	}
}