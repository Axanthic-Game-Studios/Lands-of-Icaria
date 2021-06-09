package com.axanthic.loi.utils;

import com.axanthic.loi.tileentity.TileEntityIcariaChest;
import com.google.common.base.Objects;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.ref.WeakReference;

public class IcariaDoubleChestItemHandler extends WeakReference<TileEntityIcariaChest> implements IItemHandlerModifiable
{
    public static final IcariaDoubleChestItemHandler NO_ADJACENT_CHESTS_INSTANCE = new IcariaDoubleChestItemHandler(null, null, false);

    public final TileEntityIcariaChest mainChest;

    public final boolean mainChestIsUpper;

    public final int hashCode;

    public IcariaDoubleChestItemHandler(@Nullable TileEntityIcariaChest mainChest, @Nullable TileEntityIcariaChest other, boolean mainChestIsUpper)
    {
        super(other);
        this.mainChest = mainChest;
        this.mainChestIsUpper = mainChestIsUpper;
        hashCode = Objects.hashCode(mainChestIsUpper ? mainChest : other) * 31 + Objects.hashCode(!mainChestIsUpper ? mainChest : other);
    }

    @Nullable
    public static IcariaDoubleChestItemHandler get(TileEntityIcariaChest chest)
    {
        World world = chest.getWorld();
        BlockPos pos = chest.getPos();

        if(world == null || pos == null || !world.isBlockLoaded(pos))
        {
            return null;
        }

        Block blockType = chest.getBlockType();

        EnumFacing[] horizontals = EnumFacing.HORIZONTALS;

        for(int i = horizontals.length - 1; i >= 0; i--)
        {
            EnumFacing enumfacing = horizontals[i];
            BlockPos blockpos = pos.offset(enumfacing);
            Block block = world.getBlockState(blockpos).getBlock();

            if(block == blockType)
            {
                TileEntity otherTE = world.getTileEntity(blockpos);

                if(otherTE instanceof TileEntityIcariaChest)
                {
                    TileEntityIcariaChest otherChest = (TileEntityIcariaChest) otherTE;
                    return new IcariaDoubleChestItemHandler(chest, otherChest, enumfacing != net.minecraft.util.EnumFacing.WEST && enumfacing != net.minecraft.util.EnumFacing.NORTH);
                }
            }
        }

        return NO_ADJACENT_CHESTS_INSTANCE;
    }

    @Nullable
    public TileEntityIcariaChest getChest(boolean accessingUpper)
    {
        if(accessingUpper == mainChestIsUpper)
        {
            return mainChest;
        }

        else
        {
            return getOtherChest();
        }
    }

    @Nullable
    private TileEntityIcariaChest getOtherChest()
    {
        TileEntityIcariaChest tileEntityChest = get();

        return tileEntityChest != null && !tileEntityChest.isInvalid() ? tileEntityChest : null;
    }

    @Override
    public int getSlots()
    {
        return 18 * 2;
    }

    @Override
    @Nonnull
    public ItemStack getStackInSlot(int slot)
    {
        boolean accessingUpperChest = slot < 18;
        int targetSlot = accessingUpperChest ? slot : slot - 18;

        TileEntityIcariaChest chest = getChest(accessingUpperChest);

        return chest != null ? chest.getStackInSlot(targetSlot) : ItemStack.EMPTY;
    }

    @Override
    public void setStackInSlot(int slot, @Nonnull ItemStack stack)
    {
        boolean accessingUpperChest = slot < 18;
        int targetSlot = accessingUpperChest ? slot : slot - 18;

        TileEntityIcariaChest chest = getChest(accessingUpperChest);

        if(chest != null)
        {
            IItemHandler singleHandler = chest.getSingleChestHandler();

            if(singleHandler instanceof IItemHandlerModifiable)
            {
                ((IItemHandlerModifiable) singleHandler).setStackInSlot(targetSlot, stack);
            }
        }

        chest = getChest(!accessingUpperChest);

        if(chest != null)
        {
            chest.markDirty();
        }
    }

    @Override
    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
    {
        boolean accessingUpperChest = slot < 18;
        int targetSlot = accessingUpperChest ? slot : slot - 18;

        TileEntityIcariaChest chest = getChest(accessingUpperChest);

        if(chest == null)
        {
            return stack;
        }

        int starting = stack.getCount();

        ItemStack ret = chest.getSingleChestHandler().insertItem(targetSlot, stack, simulate);

        if(ret.getCount() != starting && !simulate)
        {
            chest = getChest(!accessingUpperChest);

            if (chest != null)
            {
                chest.markDirty();
            }
        }

        return ret;
    }

    @Override
    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate)
    {
        boolean accessingUpperChest = slot < 18;
        int targetSlot = accessingUpperChest ? slot : slot - 18;

        TileEntityIcariaChest chest = getChest(accessingUpperChest);

        if(chest == null)
        {
            return ItemStack.EMPTY;
        }

        ItemStack ret = chest.getSingleChestHandler().extractItem(targetSlot, amount, simulate);

        if(!ret.isEmpty() && !simulate)
        {
            chest = getChest(!accessingUpperChest);

            if(chest != null)
            {
                chest.markDirty();
            }
        }

        return ret;
    }

    @Override
    public int getSlotLimit(int slot)
    {
        boolean accessingUpperChest = slot < 18;
        return getChest(accessingUpperChest).getInventoryStackLimit();
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack)
    {
        boolean accessingUpperChest = slot < 18;
        int targetSlot = accessingUpperChest ? slot : slot - 18;

        TileEntityIcariaChest chest = getChest(accessingUpperChest);

        if(chest != null)
        {
            return chest.getSingleChestHandler().isItemValid(targetSlot, stack);
        }

        return true;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }

        if(o == null || getClass() != o.getClass())
        {
            return false;
        }

        IcariaDoubleChestItemHandler that = (IcariaDoubleChestItemHandler) o;

        if (hashCode != that.hashCode)
        {
            return false;
        }

        final TileEntityIcariaChest otherChest = getOtherChest();

        if(mainChestIsUpper == that.mainChestIsUpper)
        {
            return Objects.equal(mainChest, that.mainChest) && Objects.equal(otherChest, that.getOtherChest());
        }

        else
        {
            return Objects.equal(mainChest, that.getOtherChest()) && Objects.equal(otherChest, that.mainChest);
        }
    }

    @Override
    public int hashCode()
    {
        return hashCode;
    }

    public boolean needsRefresh()
    {
        if(this == NO_ADJACENT_CHESTS_INSTANCE)
        {
            return false;
        }

        TileEntityIcariaChest tileEntityChest = get();

        return tileEntityChest == null || tileEntityChest.isInvalid();
    }
}