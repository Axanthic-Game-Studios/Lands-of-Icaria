package com.axanthic.icaria.common.network.runnable;

import com.axanthic.icaria.common.network.packet.ChestLabelPacket;
import com.axanthic.icaria.common.registry.IcariaDataComponents;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.network.handling.IPayloadContext;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelRunnable implements Runnable {
    public IPayloadContext context;
    public ChestLabelPacket packet;

    public ChestLabelRunnable(ChestLabelPacket pPacket, IPayloadContext pContext) {
        this.context = pContext;
        this.packet = pPacket;
    }

    @Override
    public void run() {
        this.context.player().getMainHandItem().set(IcariaDataComponents.LABEL, this.packet.string);
    }
}
