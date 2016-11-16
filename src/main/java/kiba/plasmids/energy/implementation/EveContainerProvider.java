package kiba.plasmids.energy.implementation;

import kiba.plasmids.PlasmidsCapabilities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class EveContainerProvider implements ICapabilitySerializable<NBTTagCompound> {

	private final EveContainer container;

	public EveContainerProvider(EveContainer container) {

		this.container = container;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

		return capability == PlasmidsCapabilities.EVE_HOLDER;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

		if (capability == PlasmidsCapabilities.EVE_HOLDER) return (T) this.container;

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