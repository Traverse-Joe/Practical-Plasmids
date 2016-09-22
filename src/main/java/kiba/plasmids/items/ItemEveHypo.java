package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEveHypo extends BaseItem {
    public ItemEveHypo() {
        super("eve_Hypo");
        this.setMaxStackSize(8);
        this.setMaxDamage(1);

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
        holder.givePower(100, false);
        //Need to Make Item Get Used Up on Use
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
