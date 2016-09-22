package kiba.plasmids.energy.implementation;

import dank.planetary.core.common.PlanetaryCapabilities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public class EveContainerProvider implements INBTSerializable<NBTTagCompound>, ICapabilityProvider {

    private final EveContainer container;

    public EveContainerProvider(EveContainer container) {

        this.container = container;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

        return capability == PlanetaryCapabilities.EVE_CONSUMER || capability == PlanetaryCapabilities.EVE_PRODUCER || capability == PlanetaryCapabilities.EVE_HOLDER;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

        if (capability == PlanetaryCapabilities.EVE_CONSUMER || capability == PlanetaryCapabilities.EVE_PRODUCER || capability == PlanetaryCapabilities.EVE_HOLDER)
            return (T) this.container;

        return null;
    }

    @Override
    public NBTTagCompound serializeNBT() {

        return this.container.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {

        this.container.deserializeNBT(nbt);
    }
}