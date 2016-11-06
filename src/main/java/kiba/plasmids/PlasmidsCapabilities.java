package kiba.plasmids;

import kiba.plasmids.api.IEveHolder;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class PlasmidsCapabilities {

    @CapabilityInject(IEveHolder.class)
    public static Capability<IEveHolder> EVE_HOLDER = null;


    public static class CapabilityEveHolder<T extends IEveHolder> implements IStorage<IEveHolder> {
        @Override
        public NBTBase writeNBT(Capability<IEveHolder> capability, IEveHolder instance, EnumFacing side) {
            return instance.serializeNBT();
        }

        @Override
        public void readNBT(Capability<IEveHolder> capability, IEveHolder instance, EnumFacing side, NBTBase nbt) {
            instance.deserializeNBT((NBTTagCompound) nbt);
        }
    }
}