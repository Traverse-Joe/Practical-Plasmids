package kiba.plasmids.items;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CreativeItemEve extends BaseItem {
    public CreativeItemEve() {
        super("creative_eveHypo");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
        holder.givePower(10000, false);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }

}

