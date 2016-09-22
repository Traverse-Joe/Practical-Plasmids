package kiba.plasmids.energy;

import net.minecraft.nbt.NBTTagCompound;

public interface IEveHolder {

    long getStoredPower();

    long getCapacity();

    void deserializeNBT(NBTTagCompound nbt);

    NBTTagCompound serializeNBT();
}