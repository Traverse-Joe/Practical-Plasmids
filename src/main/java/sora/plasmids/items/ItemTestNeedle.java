package sora.plasmids.items;

import sora.plasmids.PlasmidsCapabilities;
import sora.plasmids.api.IEveHolder;
import sora.plasmids.items.base.BaseItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemTestNeedle extends BaseItem {
    public ItemTestNeedle() {
        super("test_needle");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if(!worldIn.isRemote) {
            playerIn.attackEntityFrom(DamageSource.GENERIC, 1.0F);
            IEveHolder holder = playerIn.getCapability(PlasmidsCapabilities.EVE_HOLDER, null);
            if (holder != null) playerIn.sendStatusMessage(new TextComponentTranslation("message.plasmids.eve_reader", holder.getCapacity(), holder.getStoredPower()), true);
            else return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(hand));
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
    }
}
