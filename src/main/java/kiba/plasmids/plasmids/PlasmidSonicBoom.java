package kiba.plasmids.plasmids;

import kiba.plasmids.PlasmidsCapabilities;
import kiba.plasmids.energy.IEveHolder;
import kiba.plasmids.items.ItemBasePlasmid;
import kiba.plasmids.registry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

public class PlasmidSonicBoom extends ItemBasePlasmid {
    public PlasmidSonicBoom() {

        super("plasmid_sonicBoom");
    }

    @SubscribeEvent
    public void onItemUse(PlayerInteractEvent.EntityInteractSpecific event) {

        if (event.getSide() == Side.SERVER && event.getHand() == EnumHand.MAIN_HAND) {
            ItemStack stack = event.getItemStack();
            if (stack != null) {
                Item item = stack.getItem();
                /*
                Basic setup:
                Moves the affected entity in the direction you're looking
                Doesn't move the entity very far though, so it's not very useful
                 */
                if (item.equals(ModItems.plasmidSonicBoom)) {
                    EntityPlayer player = event.getEntityPlayer();
                    //lookVec is the _normalised_ vector of where an entity is looking
                    Vec3d lookVec = player.getLookVec();
                    Entity target = event.getTarget();
                    target.motionX += lookVec.xCoord;
                    target.motionY += lookVec.yCoord;
                    target.motionZ += lookVec.zCoord;
                }
                /*
                More useful setup:
                Moves the entity with a bit more oomph
                Utilises the player's current movement speed (sprinting = more knockback)
                Inverts the Y motion change if negative, so affected entities will fly up into the air instead of
                    sliding along the ground most of the time
                 */

                    }
                }
            }
        }


