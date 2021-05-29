package com.axanthic.loi.tileentity;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockForge;
import com.axanthic.loi.blocks.BlockForge.EnumCorner;
import com.axanthic.loi.gui.ContainerForge;
import com.axanthic.loi.proxy.CommonProxy;
import com.axanthic.loi.utils.ForgeRecipe;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityForge extends TileEntity implements ITickable, IInteractionObject {
	ItemStackHandler inventoryInput0 = new ItemStackHandler(1);
	ItemStackHandler inventoryInput1 = new ItemStackHandler(1);
	ItemStackHandler inventoryInput2 = new ItemStackHandler(1);
	ItemStackHandler inventoryOutputs = new ItemStackHandler(2) {
		@Override
		public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
			if (!this.isItemValid(slot, stack))
				return stack;
			return super.insertItem(slot, stack, simulate);
		}

		@Override
		public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
			return forgeInventory.isItemValidForSlot(slot + 4, stack);
		}
	};
	ItemStackHandler inventoryFuel = new ItemStackHandler(1) {
		@Override
		public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
			if (!this.isItemValid(slot, stack))
				return stack;
			return super.insertItem(slot, stack, simulate);
		}

		@Override
		public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
			return forgeInventory.isItemValidForSlot(3, stack);
		}
	};
	public IInventory forgeInventory = new IInventory() {
		@Override
		public String getName() {
			return TileEntityForge.this.getName();
		}

		@Override
		public boolean hasCustomName() {
			return TileEntityForge.this.hasCustomName();
		}

		@Override
		public ITextComponent getDisplayName() {
			return TileEntityForge.this.getDisplayName();
		}

		@Override
		public int getSizeInventory() {
			return inventoryInput0.getSlots() + inventoryInput1.getSlots() + inventoryInput2.getSlots() + inventoryOutputs.getSlots() + inventoryFuel.getSlots();
		}

		@Override
		public boolean isEmpty() {
			for (int i = 0; i < inventoryInput0.getSlots(); ++i) {
				if (!inventoryInput0.getStackInSlot(i).isEmpty())
					return false;
			}
			for (int i = 0; i < inventoryInput1.getSlots(); ++i) {
				if (!inventoryInput1.getStackInSlot(i).isEmpty())
					return false;
			}
			for (int i = 0; i < inventoryInput2.getSlots(); ++i) {
				if (!inventoryInput2.getStackInSlot(i).isEmpty())
					return false;
			}
			for (int i = 0; i < inventoryOutputs.getSlots(); ++i) {
				if (!inventoryOutputs.getStackInSlot(i).isEmpty())
					return false;
			}
			for (int i = 0; i < inventoryFuel.getSlots(); ++i) {
				if (!inventoryFuel.getStackInSlot(i).isEmpty())
					return false;
			}
			return true;
		}

		@Override
		public ItemStack getStackInSlot(int index) {
			if (index == 0)
				return inventoryInput0.getStackInSlot(0);
			if (index == 1)
				return inventoryInput1.getStackInSlot(0);
			if (index == 2)
				return inventoryInput2.getStackInSlot(0);
			if (index == 4 || index == 5)
				return inventoryOutputs.getStackInSlot(index - 4);
			if (index == 3)
				return inventoryFuel.getStackInSlot(0);
			return ItemStack.EMPTY;
		}

		@Override
		public ItemStack decrStackSize(int index, int count) {
			ItemStack stack = getStackInSlot(index);
			if (stack.isEmpty() || count < 0 || count >= getSizeInventory() || count < 1)
				return ItemStack.EMPTY;
			return getStackInSlot(index).splitStack(count);
		}

		@Override
		public ItemStack removeStackFromSlot(int index) {
			ItemStack stack = getStackInSlot(index).copy();
			this.setInventorySlotContents(index, ItemStack.EMPTY);
			return stack;
		}

		@Override
		public void setInventorySlotContents(int index, ItemStack stack) {
			ItemStack itemstack = this.getStackInSlot(index);
			boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);

			if (index == 0)
				inventoryInput0.setStackInSlot(0, stack);
			if (index == 1)
				inventoryInput1.setStackInSlot(0, stack);
			if (index == 2)
				inventoryInput2.setStackInSlot(0, stack);
			if (index == 4 || index == 5)
				inventoryOutputs.setStackInSlot(index - 4, stack);
			if (index == 3)
				inventoryFuel.setStackInSlot(0, stack);

			if (stack.getCount() > this.getInventoryStackLimit()) {
				stack.setCount(this.getInventoryStackLimit());
			}

			if ((index == 0 || index == 1 || index == 2) && !flag) {
				totalCookTime = getCookTime(stack);
				cookTime = 0;
				TileEntityForge.this.markDirty();
			}
		}

		@Override
		public int getInventoryStackLimit() {
			return 64;
		}

		@Override
		public void markDirty() {
			TileEntityForge.this.markDirty();
		}

		@Override
		public boolean isUsableByPlayer(EntityPlayer player) {
			if (world.getTileEntity(pos) != TileEntityForge.this) {
				return false;
			} else {
				return player.getDistanceSq((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D,
						(double) pos.getZ() + 0.5D) <= 64.0D;
			}
		}

		@Override
		public void openInventory(EntityPlayer player) {
		}

		@Override
		public void closeInventory(EntityPlayer player) {
		}

		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			if (index == 4 || index == 5) {
				return false;
			} else if (index != 3) {
				return true;
			} else {
				ItemStack itemstack = this.getStackInSlot(3);
				return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && itemstack.getItem() != Items.BUCKET;
			}
		}

		@Override
		public int getField(int id) {
			switch (id) {
			case 0:
				return burnTime;
			case 1:
				return currentItemBurnTime;
			case 2:
				return cookTime;
			case 3:
				return totalCookTime;
			default:
				return 0;
			}
		}

		@Override
		public void setField(int id, int value) {
			switch (id) {
			case 0:
				burnTime = value;
				break;
			case 1:
				currentItemBurnTime = value;
				break;
			case 2:
				cookTime = value;
				break;
			case 3:
				totalCookTime = value;
			}
		}

		@Override
		public int getFieldCount() {
			return 4;
		}

		@Override
		public void clear() {
			for (int i = 0; i < this.getSizeInventory(); ++i) {
				this.removeStackFromSlot(i);
			}
		}
	};
	protected int burnTime;
	protected int currentItemBurnTime;
	protected int cookTime;
	protected int totalCookTime;
	protected String customName;

	/*public void setNeighbours(BlockPos posIn) {
		if (posIn == null || this.world == null || !this.world.isValid(posIn) || !this.world.isBlockLoaded(posIn))
			return;

		try {
			IBlockState state = Resources.forge.getBlock().getActualState(this.world.getBlockState(posIn), this.world, posIn);
			if (state != null && state.getProperties().containsKey(BlockForge.CORNER) && state.getValue(BlockForge.CORNER).equals(EnumCorner.BOTTOM_FRONT_LEFT)) {
				EnumFacing facing = state.getValue(BlockHorizontal.FACING);
				this.world.setTileEntity(posIn.offset(facing), new TileEntityForgeRedirector(this));
				this.world.setTileEntity(posIn.offset(facing).offset(facing.rotateY()), new TileEntityForgeRedirector(this));
				this.world.setTileEntity(posIn.offset(facing.rotateY()), new TileEntityForgeRedirector(this));
				this.world.setTileEntity(posIn.offset(EnumFacing.UP), new TileEntityForgeRedirector(this));
				this.world.setTileEntity(posIn.offset(EnumFacing.UP).offset(facing), new TileEntityForgeRedirector(this));
				this.world.setTileEntity(posIn.offset(EnumFacing.UP).offset(facing).offset(facing.rotateY()), new TileEntityForgeRedirector(this));
				this.world.setTileEntity(posIn.offset(EnumFacing.UP).offset(facing.rotateY()), new TileEntityForgeRedirector(this));
			}
		} catch (Exception e) {
			System.out.println("blegh");
		}
	}

	public void setPos(BlockPos posIn) {
		super.setPos(posIn);
		setNeighbours(posIn);
	}

	public void onLoad() {
		super.onLoad();
		setNeighbours(this.pos);
	}*/

	/**
	 * Get the name of this object. For players this returns their username
	 */
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.forge";
	}

	/**
	 * Returns true if this thing is named
	 */
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomInventoryName(String name) {
		this.customName = name;
	}

	/**
	 * Get the formatted ChatComponent that will be used for the sender's username in chat
	 */
	public ITextComponent getDisplayName() {
		return (ITextComponent)(this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.inventoryInput0.deserializeNBT(compound.getCompoundTag("Input0"));
		this.inventoryInput1.deserializeNBT(compound.getCompoundTag("Input1"));
		this.inventoryInput2.deserializeNBT(compound.getCompoundTag("Input2"));
		this.inventoryOutputs.deserializeNBT(compound.getCompoundTag("Outputs"));
		this.inventoryFuel.deserializeNBT(compound.getCompoundTag("Fuel"));
		this.burnTime = compound.getInteger("BurnTime");
		this.cookTime = compound.getInteger("CookTime");
		this.totalCookTime = compound.getInteger("CookTimeTotal");
		this.currentItemBurnTime = getItemBurnTime(forgeInventory.getStackInSlot(3));

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", (short) this.burnTime);
		compound.setInteger("CookTime", (short) this.cookTime);
		compound.setInteger("CookTimeTotal", (short) this.totalCookTime);
		compound.setTag("Input0", this.inventoryInput0.serializeNBT());
		compound.setTag("Input1", this.inventoryInput1.serializeNBT());
		compound.setTag("Input1", this.inventoryInput2.serializeNBT());
		compound.setTag("Outputs", this.inventoryOutputs.serializeNBT());
		compound.setTag("Fuel", this.inventoryFuel.serializeNBT());

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}

		return compound;
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}

	@SideOnly(Side.CLIENT)
	public static boolean isBurning(IInventory inventory) {
		return inventory.getField(0) > 0;
	}

	/**
	 * Like the old updateEntity(), except more generic.
	 */
	public void update() {
		boolean flag = this.isBurning();
		boolean flag1 = false;

		if (this.isBurning()) {
			--this.burnTime;
		}

		if (!this.world.isRemote) {
			ItemStack itemstack = forgeInventory.getStackInSlot(3);

			if (this.isBurning() || !itemstack.isEmpty() && !(((ItemStack) forgeInventory.getStackInSlot(0)).isEmpty() && ((ItemStack) forgeInventory.getStackInSlot(1)).isEmpty() && ((ItemStack) forgeInventory.getStackInSlot(2)).isEmpty())) {
				if (!this.isBurning() && this.canSmelt()) {
					this.burnTime = getItemBurnTime(itemstack);
					this.currentItemBurnTime = this.burnTime;

					if (this.isBurning()) {
						flag1 = true;

						if (!itemstack.isEmpty()) {
							Item item = itemstack.getItem();
							itemstack.shrink(1);

							if (itemstack.isEmpty()) {
								ItemStack item1 = item.getContainerItem(itemstack);
								forgeInventory.setInventorySlotContents(3, item1);
							}
						}
					}
				}

				if (this.isBurning() && this.canSmelt()) {
					++this.cookTime;

					if (this.cookTime == this.totalCookTime) {
						this.cookTime = 0;
						if (!forgeInventory.getStackInSlot(2).isEmpty())
							this.totalCookTime = this.getCookTime(forgeInventory.getStackInSlot(2));
						if (!forgeInventory.getStackInSlot(1).isEmpty())
							this.totalCookTime = this.getCookTime(forgeInventory.getStackInSlot(1));
						if (!forgeInventory.getStackInSlot(0).isEmpty())
							this.totalCookTime = this.getCookTime(forgeInventory.getStackInSlot(0));
						this.smeltItem();
						flag1 = true;
					}
				} else {
					this.cookTime = 0;
				}
			} else if (!this.isBurning() && this.cookTime > 0) {
				this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
			}

			if (flag != this.isBurning()) {
				flag1 = true;
				((BlockForge) this.world.getBlockState(this.pos).getBlock()).setState(this.world.getBlockState(this.pos).withProperty(BlockForge.BURNING, this.isBurning()), this.world, pos);
			}
		}

		if (flag1) {
			this.markDirty();
		}
	}

	public int getCookTime(ItemStack stack) {
		return 200;
	}

	private boolean canSmelt() {
		ItemStack itemstack = ItemStack.EMPTY;
		if (!forgeInventory.getStackInSlot(2).isEmpty())
			itemstack = FurnaceRecipes.instance().getSmeltingResult(forgeInventory.getStackInSlot(2));
		if (!forgeInventory.getStackInSlot(1).isEmpty())
			itemstack = FurnaceRecipes.instance().getSmeltingResult(forgeInventory.getStackInSlot(1));
		if (!forgeInventory.getStackInSlot(0).isEmpty())
			itemstack = FurnaceRecipes.instance().getSmeltingResult(forgeInventory.getStackInSlot(0));
		if (!getAlloyResult(forgeInventory.getStackInSlot(0), forgeInventory.getStackInSlot(1), forgeInventory.getStackInSlot(2)).isEmpty())
			itemstack = getAlloyResult(forgeInventory.getStackInSlot(0), forgeInventory.getStackInSlot(1), forgeInventory.getStackInSlot(2));
		if (itemstack.isEmpty()) 
			return false;

		boolean canSmelt = false;
		ItemStack itemstack1 = forgeInventory.getStackInSlot(4);
		if (itemstack1.isEmpty()) {
			canSmelt = true;
		} else if (!itemstack1.isItemEqual(itemstack)) {
			canSmelt = false;
		} else if (itemstack1.getCount() + itemstack.getCount() <= forgeInventory.getInventoryStackLimit() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
			canSmelt = true;
		} else {
			canSmelt = itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
		}
		if (canSmelt)
			return true;

		ItemStack itemstack2 = forgeInventory.getStackInSlot(5);
		if (itemstack2.isEmpty()) {
			canSmelt = true;
		} else if (!itemstack2.isItemEqual(itemstack)) {
			canSmelt = false;
		} else if (itemstack2.getCount() + itemstack.getCount() <= forgeInventory.getInventoryStackLimit() && itemstack2.getCount() + itemstack.getCount() <= itemstack2.getMaxStackSize()) {
			canSmelt = true;
		} else {
			canSmelt = itemstack2.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
		}
		return canSmelt;
	}

	public static ItemStack getAlloyResult(ItemStack input1, ItemStack input2, ItemStack input3) {
		for (ForgeRecipe recipe : (Collection<ForgeRecipe>) CommonProxy.forgeRecipeRegistry.getValuesCollection()) {
			if (recipe.matches(input1, input2, input3)) {
				return recipe.getOutput(input1, input2, input3);
			}
		}
		return ItemStack.EMPTY;
	}

	public static boolean hasAlloyResult(ItemStack input) {
		for (Ingredient ingredient : ForgeRecipe.allInputs) {
			if (ingredient.apply(input))
				return true;
		}
		return false;
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack itemstack;
			ItemStack itemstack1;
			if (getAlloyResult(forgeInventory.getStackInSlot(0), forgeInventory.getStackInSlot(1), forgeInventory.getStackInSlot(2)).isEmpty()) {
				itemstack = ItemStack.EMPTY;
				if (!forgeInventory.getStackInSlot(2).isEmpty())
					itemstack = forgeInventory.getStackInSlot(2);
				if (!forgeInventory.getStackInSlot(1).isEmpty())
					itemstack = forgeInventory.getStackInSlot(1);
				if (!forgeInventory.getStackInSlot(0).isEmpty())
					itemstack = forgeInventory.getStackInSlot(0);
				itemstack1 = FurnaceRecipes.instance().getSmeltingResult(itemstack);

				if (itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemstack.getMetadata() == 1 && !((ItemStack) forgeInventory.getStackInSlot(3)).isEmpty() && ((ItemStack) forgeInventory.getStackInSlot(3)).getItem() == Items.BUCKET) {
					forgeInventory.setInventorySlotContents(3, new ItemStack(Items.WATER_BUCKET));
				}
				itemstack.shrink(1);
			} else {
				itemstack1 = getAlloyResult(forgeInventory.getStackInSlot(0), forgeInventory.getStackInSlot(1), forgeInventory.getStackInSlot(2));
				forgeInventory.getStackInSlot(0).shrink(1);
				forgeInventory.getStackInSlot(1).shrink(1);
				forgeInventory.getStackInSlot(2).shrink(1);
			}
			ItemStack itemstack2 = forgeInventory.getStackInSlot(4);
			ItemStack itemstack3 = forgeInventory.getStackInSlot(5);

			boolean done = false;
			if (itemstack2.isEmpty()) {
				forgeInventory.setInventorySlotContents(4, itemstack1.copy());
				done = true;
			} else if (ItemStack.areItemsEqual(itemstack2, itemstack1) && itemstack2.getCount() + itemstack1.getCount() <= itemstack1.getMaxStackSize()) {
				itemstack2.grow(itemstack1.getCount());
				done = true;
			}
			if (!done) {
				if (itemstack3.isEmpty()) {
					forgeInventory.setInventorySlotContents(5, itemstack1.copy());
					done = true;
				} else if (ItemStack.areItemsEqual(itemstack3, itemstack1) && itemstack3.getCount() + itemstack1.getCount() <= itemstack1.getMaxStackSize()) {
					itemstack3.grow(itemstack1.getCount());
					done = true;
				}
			}
		}
	}

	public static int getItemBurnTime(ItemStack stack) {
		if (stack.isEmpty()) {
			return 0;
		} else {
			int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack);
			if (burnTime >= 0)
				return burnTime;
			Item item = stack.getItem();

			if (item == Item.getItemFromBlock(Blocks.WOODEN_SLAB)) {
				return 150;
			} else if (item == Item.getItemFromBlock(Blocks.WOOL)) {
				return 100;
			} else if (item == Item.getItemFromBlock(Blocks.CARPET)) {
				return 67;
			} else if (item == Item.getItemFromBlock(Blocks.LADDER)) {
				return 300;
			} else if (item == Item.getItemFromBlock(Blocks.WOODEN_BUTTON)) {
				return 100;
			} else if (Block.getBlockFromItem(item).getDefaultState().getMaterial() == Material.WOOD) {
				return 300;
			} else if (item == Item.getItemFromBlock(Blocks.COAL_BLOCK)) {
				return 16000;
			} else if (item instanceof ItemTool && "WOOD".equals(((ItemTool) item).getToolMaterialName())) {
				return 200;
			} else if (item instanceof ItemSword && "WOOD".equals(((ItemSword) item).getToolMaterialName())) {
				return 200;
			} else if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe) item).getMaterialName())) {
				return 200;
			} else if (item == Items.STICK) {
				return 100;
			} else if (item != Items.BOW && item != Items.FISHING_ROD) {
				if (item == Items.SIGN) {
					return 200;
				} else if (item == Items.COAL) {
					return 1600;
				} else if (item == Items.LAVA_BUCKET) {
					return 20000;
				} else if (item != Item.getItemFromBlock(Blocks.SAPLING) && item != Items.BOWL) {
					if (item == Items.BLAZE_ROD) {
						return 2400;
					} else if (item instanceof ItemDoor && item != Items.IRON_DOOR) {
						return 200;
					} else {
						return item instanceof ItemBoat ? 400 : 0;
					}
				} else {
					return 100;
				}
			} else {
				return 300;
			}
		}
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemBurnTime(stack) > 0;
	}

	public String getGuiID() {
		return ModInformation.ID + ":forge";
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerForge(playerInventory, forgeInventory);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return this.hasCapabilityForPos(capability, facing, this.pos);
	}

	@Override
	@Nullable
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		return this.getCapabilityForPos(capability, facing, this.pos);
	}

	public boolean hasCapabilityForPos(Capability<?> capability, EnumFacing facing, BlockPos pos) {
		IBlockState state = Resources.forge.getBlock().getActualState(this.world.getBlockState(pos), this.world, pos);
		EnumFacing blockFacing = state.getValue(BlockForge.FACING);
		EnumCorner blockCorner = (EnumCorner) state.getValue(BlockForge.CORNER);
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN && blockCorner.isBottom())
				return true;
			else if (facing == EnumFacing.UP && !blockCorner.isBottom() && blockCorner != EnumCorner.TOP_FRONT_RIGHT)
				return true;
			else if (facing == blockFacing.rotateYCCW() && blockCorner == EnumCorner.BOTTOM_FRONT_LEFT)
				return true;
		return false;
	}

	@Nullable
	public <T> T getCapabilityForPos(Capability<T> capability, @Nullable EnumFacing facing, BlockPos pos) {
		IBlockState state = Resources.forge.getBlock().getActualState(this.world.getBlockState(pos), world, pos);
		EnumFacing blockFacing = state.getValue(BlockForge.FACING);
		EnumCorner blockCorner = (EnumCorner) state.getValue(BlockForge.CORNER);
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN && blockCorner.isBottom())
				return (T) inventoryOutputs;
			else if (facing == EnumFacing.UP && blockCorner == EnumCorner.TOP_BACK_LEFT)
				return (T) inventoryInput0;
			else if (facing == EnumFacing.UP && blockCorner == EnumCorner.TOP_BACK_RIGHT)
				return (T) inventoryInput1;
			else if (facing == EnumFacing.UP && blockCorner == EnumCorner.TOP_FRONT_LEFT)
				return (T) inventoryInput2;
			else if (facing == blockFacing.rotateYCCW() && blockCorner == EnumCorner.BOTTOM_FRONT_LEFT)
				return (T) inventoryFuel;
		return null;
	}
}