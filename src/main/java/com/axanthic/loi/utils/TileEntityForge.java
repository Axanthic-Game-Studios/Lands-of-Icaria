package com.axanthic.loi.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Recipes;
import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockForge;
import com.axanthic.loi.blocks.BlockForge.EnumCorner;
import com.axanthic.loi.gui.ContainerForge;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityForge extends TileEntityLockable implements ITickable, ISidedInventory {
	private static final int[] SLOTS_TOP = new int[] { 0, 1, 2 };
	private static final int[] SLOTS_BOTTOM = new int[] { 4, 5 };
	private static final int[] SLOTS_SIDES = new int[] { 3 };
	private NonNullList<ItemStack> inventoryItems = NonNullList.<ItemStack>withSize(6, ItemStack.EMPTY);
	private int burnTime;
	private int currentItemBurnTime;
	private int cookTime;
	private int totalCookTime;
	private String customName;

	public void setNeighbours(BlockPos posIn) {
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
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return this.inventoryItems.size();
	}

	public boolean isEmpty() {
		for (ItemStack itemstack : this.inventoryItems) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the stack in the given slot.
	 */
	public ItemStack getStackInSlot(int index) {
		return this.inventoryItems.get(index);
	}

	/**
	 * Removes up to a specified number of items from an inventory slot and returns
	 * them in a new stack.
	 */
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.inventoryItems, index, count);
	}

	/**
	 * Removes a stack from the given slot and returns it.
	 */
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.inventoryItems, index);
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections).
	 */
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack itemstack = this.inventoryItems.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.inventoryItems.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		if ((index == 0 || index == 1 || index == 2) && !flag) {
			this.totalCookTime = this.getCookTime(stack);
			this.cookTime = 0;
			this.markDirty();
		}
	}

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

	public void setCustomInventoryName(String p_145951_1_) {
		this.customName = p_145951_1_;
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.inventoryItems = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.inventoryItems);
		this.burnTime = compound.getInteger("BurnTime");
		this.cookTime = compound.getInteger("CookTime");
		this.totalCookTime = compound.getInteger("CookTimeTotal");
		this.currentItemBurnTime = getItemBurnTime(this.inventoryItems.get(3));

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", (short) this.burnTime);
		compound.setInteger("CookTime", (short) this.cookTime);
		compound.setInteger("CookTimeTotal", (short) this.totalCookTime);
		ItemStackHelper.saveAllItems(compound, this.inventoryItems);

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}

		return compound;
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64,
	 * possibly will be extended.
	 */
	public int getInventoryStackLimit() {
		return 64;
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
			ItemStack itemstack = this.inventoryItems.get(3);

			if (this.isBurning() || !itemstack.isEmpty() && !(((ItemStack) this.inventoryItems.get(0)).isEmpty() && ((ItemStack) this.inventoryItems.get(1)).isEmpty() && ((ItemStack) this.inventoryItems.get(2)).isEmpty())) {
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
								this.inventoryItems.set(3, item1);
							}
						}
					}
				}

				if (this.isBurning() && this.canSmelt()) {
					++this.cookTime;

					if (this.cookTime == this.totalCookTime) {
						this.cookTime = 0;
						if (!((ItemStack) this.inventoryItems.get(2)).isEmpty())
							this.totalCookTime = this.getCookTime(this.inventoryItems.get(2));
						if (!((ItemStack) this.inventoryItems.get(1)).isEmpty())
							this.totalCookTime = this.getCookTime(this.inventoryItems.get(1));
						if (!((ItemStack) this.inventoryItems.get(0)).isEmpty())
							this.totalCookTime = this.getCookTime(this.inventoryItems.get(0));
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
		if (!((ItemStack) this.inventoryItems.get(2)).isEmpty())
			itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventoryItems.get(2));
		if (!((ItemStack) this.inventoryItems.get(1)).isEmpty())
			itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventoryItems.get(1));
		if (!((ItemStack) this.inventoryItems.get(0)).isEmpty())
			itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventoryItems.get(0));
		if (!getAlloyResult(this.inventoryItems.get(0), this.inventoryItems.get(1), this.inventoryItems.get(2)).isEmpty())
			itemstack = getAlloyResult(this.inventoryItems.get(0), this.inventoryItems.get(1), this.inventoryItems.get(2));
		if (itemstack.isEmpty()) 
			return false;

		boolean canSmelt = false;
		ItemStack itemstack1 = this.inventoryItems.get(4);
		if (itemstack1.isEmpty()) {
			canSmelt = true;
		} else if (!itemstack1.isItemEqual(itemstack)) {
			canSmelt = false;
		} else if (itemstack1.getCount() + itemstack.getCount() <= this.getInventoryStackLimit() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
			canSmelt = true;
		} else {
			canSmelt = itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
		}
		if (canSmelt)
			return true;

		ItemStack itemstack2 = this.inventoryItems.get(5);
		if (itemstack2.isEmpty()) {
			canSmelt = true;
		} else if (!itemstack2.isItemEqual(itemstack)) {
			canSmelt = false;
		} else if (itemstack2.getCount() + itemstack.getCount() <= this.getInventoryStackLimit() && itemstack2.getCount() + itemstack.getCount() <= itemstack2.getMaxStackSize()) {
			canSmelt = true;
		} else {
			canSmelt = itemstack2.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
		}
		return canSmelt;
	}

	public static ItemStack getAlloyResult(ItemStack input1, ItemStack input2, ItemStack input3) {
		Collection<String> ingredients = new ArrayList(Arrays.asList(input1.getItem().getRegistryName().toString() + ":" + input1.getMetadata(), input2.getItem().getRegistryName().toString() + ":" + input2.getMetadata(), input3.getItem().getRegistryName().toString() + ":" + input3.getMetadata()));

		if (Recipes.forgeRecipes.containsKey(ingredients))
			return Recipes.forgeRecipes.get(ingredients).copy();

		for (Collection<String> recipe : Recipes.forgeRecipes.keySet()) {
			if (ingredients.containsAll(recipe) && recipe.containsAll(ingredients) && ingredients.size() == recipe.size())
				return Recipes.forgeRecipes.get(recipe).copy();
		}
		return ItemStack.EMPTY;
	}

	public static boolean hasAlloyResult(ItemStack input) {
		return Recipes.forgeIngredients.contains(input.getItem().getRegistryName().toString() + ":" + input.getMetadata());
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack itemstack;
			ItemStack itemstack1;
			if (getAlloyResult(this.inventoryItems.get(0), this.inventoryItems.get(1), this.inventoryItems.get(2)).isEmpty()) {
				itemstack = ItemStack.EMPTY;
				if (!((ItemStack) this.inventoryItems.get(2)).isEmpty())
					itemstack = this.inventoryItems.get(2);
				if (!((ItemStack) this.inventoryItems.get(1)).isEmpty())
					itemstack = this.inventoryItems.get(1);
				if (!((ItemStack) this.inventoryItems.get(0)).isEmpty())
					itemstack = this.inventoryItems.get(0);
				itemstack1 = FurnaceRecipes.instance().getSmeltingResult(itemstack);

				if (itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemstack.getMetadata() == 1 && !((ItemStack) this.inventoryItems.get(3)).isEmpty() && ((ItemStack) this.inventoryItems.get(3)).getItem() == Items.BUCKET) {
					this.inventoryItems.set(3, new ItemStack(Items.WATER_BUCKET));
				}
				itemstack.shrink(1);
			} else {
				itemstack1 = getAlloyResult(this.inventoryItems.get(0), this.inventoryItems.get(1), this.inventoryItems.get(2));
				this.inventoryItems.get(0).shrink(1);
				this.inventoryItems.get(1).shrink(1);
				this.inventoryItems.get(2).shrink(1);
			}
			ItemStack itemstack2 = this.inventoryItems.get(4);
			ItemStack itemstack3 = this.inventoryItems.get(5);

			boolean done = false;
			if (itemstack2.isEmpty()) {
				this.inventoryItems.set(4, itemstack1.copy());
				done = true;
			} else if (ItemStack.areItemsEqual(itemstack2, itemstack1) && itemstack2.getCount() + itemstack1.getCount() <= itemstack1.getMaxStackSize()) {
				itemstack2.grow(itemstack1.getCount());
				done = true;
			}
			if (!done) {
				if (itemstack3.isEmpty()) {
					this.inventoryItems.set(5, itemstack1.copy());
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

	/**
	 * Don't rename this method to canInteractWith due to conflicts with Container
	 */
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
					(double) this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	public void openInventory(EntityPlayer player) {
	}

	public void closeInventory(EntityPlayer player) {
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot. For guis use Slot.isItemValid
	 */
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 4 || index == 5) {
			return false;
		} else if (index != 3) {
			return true;
		} else {
			ItemStack itemstack = this.inventoryItems.get(3);
			return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && itemstack.getItem() != Items.BUCKET;
		}
	}

	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.DOWN) {
			return SLOTS_BOTTOM;
		} else {
			return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
		}
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from
	 * the given side.
	 */
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot from
	 * the given side.
	 */
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (direction == EnumFacing.DOWN && index == 1) {
			Item item = stack.getItem();

			if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
				return false;
			}
		}

		return true;
	}

	public String getGuiID() {
		return ModInformation.ID + ":forge";
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerForge(playerInventory, this);
	}

	public int getField(int id) {
		switch (id) {
		case 0:
			return this.burnTime;
		case 1:
			return this.currentItemBurnTime;
		case 2:
			return this.cookTime;
		case 3:
			return this.totalCookTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.burnTime = value;
			break;
		case 1:
			this.currentItemBurnTime = value;
			break;
		case 2:
			this.cookTime = value;
			break;
		case 3:
			this.totalCookTime = value;
		}
	}

	public int getFieldCount() {
		return 4;
	}

	public void clear() {
		this.inventoryItems.clear();
	}

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

	@Override
	@javax.annotation.Nullable
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability,
			@javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}
}