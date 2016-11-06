package kiba.plasmids.api;

import net.minecraft.nbt.NBTTagCompound;

public interface IEveHolder {

    long getStoredPower();

    long getCapacity();

    void deserializeNBT(NBTTagCompound nbt);

    long givePower(long power, boolean simulated);

    long takePower(long power, boolean simulated);

    NBTTagCompound serializeNBT();
}