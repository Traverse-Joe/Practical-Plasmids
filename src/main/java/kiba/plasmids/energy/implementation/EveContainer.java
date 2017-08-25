package kiba.plasmids.energy.implementation;

import kiba.plasmids.api.IEveHolder;
import net.minecraft.nbt.NBTTagCompound;

public class EveContainer implements IEveHolder {

	private long stored;

	private long capacity;

	private long inputRate;

	private long outputRate;

	public EveContainer() {
		this(5000, 50, 50);
	}

	private EveContainer(long capacity, long input, long output) {
		this.capacity = capacity;
		this.inputRate = input;
		this.outputRate = output;
	}

	public static EveContainer create(long capacity, long input, long output) {
		return new EveContainer(capacity, input, output);
	}

	public static EveContainer createFromNBT(NBTTagCompound tagCompound) {
		return new EveContainer(tagCompound);
	}

	private EveContainer(NBTTagCompound dataTag) {
		this();
		this.deserializeNBT(dataTag);
	}

	@Override
	public long getStoredPower() {

		return this.stored;
	}

	@Override
	public long givePower(long eve, boolean simulated) {

		final long acceptedEve = Math.min(this.getCapacity() - this.stored, Math.min(this.getInputRate(), eve));

		if (!simulated) this.stored += acceptedEve;

		return acceptedEve;
	}

	@Override
	public long takePower(long eve, boolean simulated) {

		final long removedPower = Math.min(this.stored, Math.min(this.getOutputRate(), eve));

		if (!simulated) this.stored -= removedPower;

		return removedPower;
	}

	@Override
	public long getCapacity() {

		return this.capacity;
	}

	@Override
	public NBTTagCompound serializeNBT() {

		final NBTTagCompound dataTag = new NBTTagCompound();
		dataTag.setLong("EvePower", this.stored);
		dataTag.setLong("EveInput", this.inputRate);
		dataTag.setLong("EveOutput", this.outputRate);

		return dataTag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {

		this.stored = nbt.getLong("EvePower");

		if (nbt.hasKey("EveInput")) this.inputRate = nbt.getLong("EveInput");

		if (nbt.hasKey("EveOutput")) this.outputRate = nbt.getLong("EveOutput");

		if (this.stored > this.getCapacity()) this.stored = this.getCapacity();
	}

	public EveContainer setCapacity(long capacity) {

		this.capacity = capacity;

		if (this.stored > capacity) this.stored = capacity;

		return this;
	}

	public long getInputRate() {

		return this.inputRate;
	}

	public EveContainer setInputRate(long rate) {

		this.inputRate = rate;
		return this;
	}

	public long getOutputRate() {

		return this.outputRate;
	}

	public EveContainer setOutputRate(long rate) {
		this.outputRate = rate;
		return this;
	}

	public EveContainer setTransferRate(long rate) {

		this.setInputRate(rate);
		this.setOutputRate(rate);
		return this;
	}
}
