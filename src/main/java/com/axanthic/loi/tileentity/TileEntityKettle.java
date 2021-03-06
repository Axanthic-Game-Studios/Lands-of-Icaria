package com.axanthic.loi.tileentity;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

import javax.annotation.Nullable;

import com.axanthic.loi.LOIFluids;
import com.axanthic.loi.Resources;
import com.axanthic.loi.proxy.CommonProxy;
import com.axanthic.loi.utils.KettleRecipe;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.server.management.PlayerChunkMap;
import net.minecraft.server.management.PlayerChunkMapEntry;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.TileFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class TileEntityKettle extends TileFluidHandler {

	protected Deque<ItemStack> ingredientStack = new ArrayDeque<ItemStack>();
	protected KettleRecipe currentRecipe = null;
	protected boolean ingredientEmpty = true;
	protected int ingredientStrength = 1000;
	protected int randomColor = 0xFFFFFF;

	public TileEntityKettle() {
		super();
		this.tank = new FluidTank(new FluidStack(LOIFluids.waterFluid, 0), Fluid.BUCKET_VOLUME) {
			public boolean canFillFluidType(FluidStack fluid) {
				return canFill() && fluid.getFluid().equals(LOIFluids.waterFluid);
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
				TileEntityKettle.this.syncToClient();
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
		randomColor = compound.getInteger("Concoction_color");
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
		compound.setInteger("Concoction_color", randomColor);

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

	public boolean addIngredient(ItemStack itemstack) {
		if (itemstack.isEmpty())
			return false;
		boolean matched = false;
		for (Ingredient ingredient : KettleRecipe.allInputs) {
			if (ingredient.apply(itemstack)) {
				matched = true;
				break;
			}
		}
		if (!matched)
			return false;

		ItemStack copystack = itemstack.copy();
		copystack.setCount(1);

		if (ingredientStack.size() >= 5)
			ingredientStack.poll();
		ingredientStack.offer(copystack);

		itemstack.shrink(1);
		ingredientStrength = Math.min(1000, ingredientStrength + 300);
		ingredientEmpty = false;
		randomColor = this.world.rand.nextInt(0xFFFFFF + 1);
		updateRecipe();
		this.markDirty();
		this.syncToClient();
		return true;
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

	public boolean craft(EntityPlayer player, EnumHand hand) {
		if (currentRecipe == null || this.tank.getFluidAmount() < currentRecipe.fluidcost)
			return false;

		if (player.getHeldItem(hand).getItem() == Resources.emptyFlask && currentRecipe.getConcoctionOutput(ingredientStack.toArray(new ItemStack[5])) != null) {
			if (!player.isCreative())
				player.getHeldItem(hand).shrink(1);
			ItemHandlerHelper.giveItemToPlayer(player, currentRecipe.getConcoctionOutput(ingredientStack.toArray(new ItemStack[5])));
			currentRecipe.performRecipe(world, pos, player);
		} else {
			ItemHandlerHelper.giveItemToPlayer(player, currentRecipe.getOutput(ingredientStack.toArray(new ItemStack[5])));
			currentRecipe.performRecipe(world, pos, player);
		}

		this.tank.drainInternal(currentRecipe.fluidcost, true);

		if (this.tank.getFluidAmount() == 0) {
			ingredientStack.clear();
			for (int i = 0; i < 5; ++i)
				ingredientStack.offer(ItemStack.EMPTY);

			currentRecipe = null;
			ingredientStrength = 1000;
			ingredientEmpty = true;

			this.syncToClient();
		}

		this.markDirty();
		this.syncToClient();
		return true;
	}

	public int getColor() {
		if (currentRecipe == null) {
			if (ingredientEmpty)
				return 0x22473A;
			return randomColor;
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

				this.syncToClient();
			}
		}
	}

	public int getFluidLevel() {
		return this.tank.getFluidAmount();
	}

	protected void syncToClient() {
		if(world instanceof WorldServer) {
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

	private IItemHandler itemHandler = new KettleHandler();

	@Override
	@Nullable
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) itemHandler;
		return super.getCapability(capability, facing);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}

	public class KettleHandler implements IItemHandler {

		@Override
		public int getSlots() {
			return 2;
		}

		@Override
		public ItemStack getStackInSlot(int slot) {
			if (slot == 1 && currentRecipe != null) {
				return currentRecipe.getOutput(ingredientStack.toArray(new ItemStack[5]));
			}
			return ItemStack.EMPTY;
		}

		@Override
		public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
			if (slot != 0 || stack.isEmpty() || getFluidLevel() == 0)
				return stack;
			boolean matched = false;
			for (Ingredient ingredient : KettleRecipe.allInputs) {
				if (ingredient.apply(stack)) {
					matched = true;
					break;
				}
			}
			if (!matched)
				return stack;
			ItemStack stackCopy = stack.copy();
			stackCopy.shrink(1);
			if (simulate)
				return stackCopy;

			ItemStack inputStack = stack.copy();
			inputStack.setCount(1);

			if (ingredientStack.size() >= 5)
				ingredientStack.poll();
			ingredientStack.offer(inputStack);

			ingredientStrength = Math.min(1000, ingredientStrength + 300);
			ingredientEmpty = false;
			randomColor = world.rand.nextInt(0xFFFFFF + 1);
			updateRecipe();
			markDirty();
			syncToClient();
			return stackCopy;
		}

		@Override
		public ItemStack extractItem(int slot, int amount, boolean simulate) {
			if (slot != 1 || currentRecipe == null || tank.getFluidAmount() < currentRecipe.fluidcost)
				return ItemStack.EMPTY;

			ItemStack output = currentRecipe.getOutput(ingredientStack.toArray(new ItemStack[5]));
			if (simulate) {
				if (output == ItemStack.EMPTY)
					return currentRecipe.getFakeOutput();
				return output;
			}

			currentRecipe.performRecipe(world, pos, null);
			tank.drainInternal(currentRecipe.fluidcost, true);

			if (tank.getFluidAmount() == 0) {
				ingredientStack.clear();
				for (int i = 0; i < 5; ++i)
					ingredientStack.offer(ItemStack.EMPTY);

				currentRecipe = null;
				ingredientStrength = 1000;
				ingredientEmpty = true;

				syncToClient();
			}

			markDirty();
			syncToClient();
			return output;
		}

		@Override
		public int getSlotLimit(int slot) {
			return 1;
		}
	}
}