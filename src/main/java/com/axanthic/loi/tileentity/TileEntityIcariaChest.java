package com.axanthic.loi.tileentity;

import com.axanthic.loi.blocks.BlockIcariaChest;
import com.axanthic.loi.utils.IcariaDoubleChestItemHandler;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class TileEntityIcariaChest extends TileEntityLockableLoot implements ITickable
{
    public BlockIcariaChest.Type cachedChestType;

    public TileEntityIcariaChest adjacentChestZNeg;
    public TileEntityIcariaChest adjacentChestXPos;
    public TileEntityIcariaChest adjacentChestXNeg;
    public TileEntityIcariaChest adjacentChestZPos;

    public NonNullList<ItemStack> chestContents = NonNullList.withSize(18, ItemStack.EMPTY);

    public boolean adjacentChestChecked;

    public float lidAngle;
    public float prevLidAngle;

    public int numPlayersUsing;
    public int ticksSinceSync;

    public TileEntityIcariaChest()
    {
    }

    public int getSizeInventory()
    {
        return 18;
    }

    public boolean isEmpty()
    {
        for(ItemStack itemstack : this.chestContents)
        {
            if(!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    public String getName()
    {
        return this.hasCustomName() ? this.customName : "container.chest";
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

        if(!this.checkLootAndRead(compound))
        {
            ItemStackHelper.loadAllItems(compound, this.chestContents);
        }

        if(compound.hasKey("CustomName", 8))
        {
            this.customName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        if(!this.checkLootAndWrite(compound))
        {
            ItemStackHelper.saveAllItems(compound, this.chestContents);
        }

        if(this.hasCustomName())
        {
            compound.setString("CustomName", this.customName);
        }

        return compound;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public void updateContainingBlockInfo()
    {
        super.updateContainingBlockInfo();

        this.adjacentChestChecked = false;

        doubleChestHandler = null;
    }

    @SuppressWarnings("incomplete-switch")
    private void setNeighbor(TileEntityIcariaChest chestTe, EnumFacing side)
    {
        if(chestTe.isInvalid())
        {
            this.adjacentChestChecked = false;
        }

        else if(this.adjacentChestChecked)
        {
            switch(side)
            {
                case NORTH:

                    if(this.adjacentChestZNeg != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;

                case SOUTH:

                    if(this.adjacentChestZPos != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;

                case EAST:

                    if(this.adjacentChestXPos != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;

                case WEST:

                    if(this.adjacentChestXNeg != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }
            }
        }
    }

    public void checkForAdjacentChests()
    {
        if(!this.adjacentChestChecked)
        {
            if(this.world == null || !this.world.isAreaLoaded(this.pos, 1)) return;

            this.adjacentChestChecked = true;

            this.adjacentChestXNeg = this.getAdjacentChest(EnumFacing.WEST);
            this.adjacentChestXPos = this.getAdjacentChest(EnumFacing.EAST);
            this.adjacentChestZNeg = this.getAdjacentChest(EnumFacing.NORTH);
            this.adjacentChestZPos = this.getAdjacentChest(EnumFacing.SOUTH);
        }
    }

    @Nullable
    protected TileEntityIcariaChest getAdjacentChest(EnumFacing side)
    {
        BlockPos blockpos = this.pos.offset(side);

        if(this.isChestAt(blockpos))
        {
            TileEntity tileentity = this.world.getTileEntity(blockpos);

            if(tileentity instanceof TileEntityIcariaChest)
            {
                TileEntityIcariaChest tileentitychest = (TileEntityIcariaChest)tileentity;

                tileentitychest.setNeighbor(this, side.getOpposite());

                return tileentitychest;
            }
        }

        return null;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return new net.minecraft.util.math.AxisAlignedBB(pos.add(-1, 0, -1), pos.add(2, 2, 2));
    }

    private boolean isChestAt(BlockPos posIn)
    {
        if(this.world == null)
        {
            return false;
        }

        else
        {
            Block block = this.world.getBlockState(posIn).getBlock();

            return block instanceof BlockIcariaChest && ((BlockIcariaChest)block).chestType == this.getChestType();
        }
    }

    public void update()
    {
        this.checkForAdjacentChests();

        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();

        ++this.ticksSinceSync;

        if(!this.world.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + i + j + k) % 200 == 0)
        {
            this.numPlayersUsing = 0;

            for(EntityPlayer entityplayer : this.world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((float)i - 5.0F, (float)j - 5.0F, (float)k - 5.0F, (float)(i + 1) + 5.0F, (float)(j + 1) + 5.0F, (float)(k + 1) + 5.0F)))
            {
                if(entityplayer.openContainer instanceof ContainerChest)
                {
                    IInventory iinventory = ((ContainerChest)entityplayer.openContainer).getLowerChestInventory();

                    if(iinventory == this || iinventory instanceof InventoryLargeChest && ((InventoryLargeChest)iinventory).isPartOfLargeChest(this))
                    {
                        ++this.numPlayersUsing;
                    }
                }
            }
        }

        this.prevLidAngle = this.lidAngle;

        if(this.numPlayersUsing > 0 && this.lidAngle == 0.0F && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null)
        {
            double d1 = (double)i + 0.5D;
            double d2 = (double)k + 0.5D;

            if(this.adjacentChestZPos != null)
            {
                d2 += 0.5D;
            }

            if(this.adjacentChestXPos != null)
            {
                d1 += 0.5D;
            }

            this.world.playSound(null, d1, (double)j + 0.5D, d2, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
        }

        if(this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
        {
            float f2 = this.lidAngle;

            if(this.numPlayersUsing > 0)
            {
                this.lidAngle += 0.1F;
            }

            else
            {
                this.lidAngle -= 0.1F;
            }

            if(this.lidAngle > 1.0F)
            {
                this.lidAngle = 1.0F;
            }

            if(this.lidAngle < 0.5F && f2 >= 0.5F && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null)
            {
                double d3 = (double)i + 0.5D;
                double d0 = (double)k + 0.5D;

                if(this.adjacentChestZPos != null)
                {
                    d0 += 0.5D;
                }

                if(this.adjacentChestXPos != null)
                {
                    d3 += 0.5D;
                }

                this.world.playSound(null, d3, (double)j + 0.5D, d0, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }

            if(this.lidAngle < 0.0F)
            {
                this.lidAngle = 0.0F;
            }
        }
    }

    public boolean receiveClientEvent(int id, int type)
    {
        if(id == 1)
        {
            this.numPlayersUsing = type;
            return true;
        }

        else
        {
            return super.receiveClientEvent(id, type);
        }
    }

    public void openInventory(EntityPlayer player)
    {
        if(!player.isSpectator())
        {
            if(this.numPlayersUsing < 0)
            {
                this.numPlayersUsing = 0;
            }

            ++this.numPlayersUsing;

            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);

            if(this.getChestType() == BlockIcariaChest.Type.TRAP)
            {
                this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
            }
        }
    }

    public void closeInventory(EntityPlayer player)
    {
        if(!player.isSpectator() && this.getBlockType() instanceof BlockIcariaChest)
        {
            --this.numPlayersUsing;

            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);

            if(this.getChestType() == BlockIcariaChest.Type.TRAP)
            {
                this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
            }
        }
    }

    public IcariaDoubleChestItemHandler doubleChestHandler;

    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            if(doubleChestHandler == null || doubleChestHandler.needsRefresh())
            {
                doubleChestHandler = IcariaDoubleChestItemHandler.get(this);
            }

            if(doubleChestHandler != null && doubleChestHandler != IcariaDoubleChestItemHandler.NO_ADJACENT_CHESTS_INSTANCE)
            {
                return (T) doubleChestHandler;
            }
        }

        return super.getCapability(capability, facing);
    }

    public IItemHandler getSingleChestHandler()
    {
        return super.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
    }

    public void invalidate()
    {
        super.invalidate();

        this.updateContainingBlockInfo();
        this.checkForAdjacentChests();
    }

    public BlockIcariaChest.Type getChestType()
    {
        if(this.cachedChestType == null)
        {
            if(this.world == null || !(this.getBlockType() instanceof BlockIcariaChest))
            {
                return BlockIcariaChest.Type.BASIC;
            }

            this.cachedChestType = ((BlockIcariaChest)this.getBlockType()).chestType;
        }

        return this.cachedChestType;
    }

    public String getGuiID()
    {
        return "minecraft:chest";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        this.fillWithLoot(playerIn);

        return new ContainerChest(playerInventory, this, playerIn);
    }

    protected NonNullList<ItemStack> getItems()
    {
        return this.chestContents;
    }
}
