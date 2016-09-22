package kiba.plasmids;

import kiba.plasmids.energy.IEveConsumer;
import kiba.plasmids.energy.IEveHolder;
import kiba.plasmids.energy.IEveProducer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class PlasmidsCapabilities {


    //Eve
    @CapabilityInject(IEveConsumer.class)
    public static Capability<IEveConsumer> EVE_CONSUMER = null;

    @CapabilityInject(IEveProducer.class)
    public static Capability<IEveProducer> EVE_PRODUCER = null;

    @CapabilityInject(IEveHolder.class)
    public static Capability<IEveHolder> EVE_HOLDER = null;

    public static class CapabilityEveConsumer<T extends IEveConsumer> implements IStorage<IEveConsumer> {
        @Override
        public NBTBase writeNBT(Capability<IEveConsumer> capability, IEveConsumer instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IEveConsumer> capability, IEveConsumer instance, EnumFacing side, NBTBase nbt) {
        }
    }

    public static class CapabilityEveProducer<T extends IEveProducer> implements IStorage<IEveProducer> {
        @Override
        public NBTBase writeNBT(Capability<IEveProducer> capability, IEveProducer instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IEveProducer> capability, IEveProducer instance, EnumFacing side, NBTBase nbt) {
        }
    }

    public static class CapabilityEveHolder<T extends IEveHolder> implements IStorage<IEveHolder> {
        @Override
        public NBTBase writeNBT(Capability<IEveHolder> capability, IEveHolder instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IEveHolder> capability, IEveHolder instance, EnumFacing side, NBTBase nbt) {
        }
    }
}