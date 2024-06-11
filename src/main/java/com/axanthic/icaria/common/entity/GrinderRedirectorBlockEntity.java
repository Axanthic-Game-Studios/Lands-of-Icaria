package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.GrinderBlock;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderRedirectorBlockEntity extends BlockEntity {
    public GrinderBlockEntity original;

    public GrinderRedirectorBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.GRINDER_REDIRECTOR.get(), pPos, pState);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (this.level instanceof ServerLevel serverLevel) {
            if (serverLevel.getBlockEntity(GrinderBlock.getBlockEntityPosition(serverLevel.getBlockState(this.getBlockPos()), this.getBlockPos())) instanceof GrinderBlockEntity blockEntity) {
                this.original = blockEntity;
            }
        }
    }

    //@Override
    //public <T> LazyOptional<T> getCapability(Capability<T> pCapability, @Nullable Direction pDirection) {
    //    return this.original != null ? this.original.getCapabilityForPos(pCapability, pDirection, this.getBlockPos()) : LazyOptional.empty();
    //}
}
