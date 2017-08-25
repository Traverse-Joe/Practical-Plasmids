package kiba.plasmids.items;

import kiba.plasmids.items.base.BaseWeapon;

public class ItemWrench extends BaseWeapon {
	public ItemWrench() {
		super(ToolMaterial.IRON, "wrench");
		this.setMaxDamage(1000);

	}
}
