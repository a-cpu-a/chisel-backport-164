//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.chisel;

import info.jbcs.minecraft.utilities.General;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class BPSlotChiselSelection extends Slot {
    BPContainerChisel container;
    BPInventoryChiselSelection selInventory;

    public BPSlotChiselSelection(BPContainerChisel container, BPInventoryChiselSelection inv, IInventory iinventory, int id, int j, int k) {
        super(iinventory, id, j, k);
        this.container = container;
        this.selInventory = inv;
    }

    public boolean func_75214_a(ItemStack itemstack) {
        return false;
    }

    public boolean func_82869_a(EntityPlayer par1EntityPlayer) {
        if (this.container.finished) {
            return false;
        } else {
            return par1EntityPlayer.field_71071_by.func_70445_o() == null;
        }
    }

    public void func_82870_a(EntityPlayer player, ItemStack itemstack) {
        ItemStack stack = player.field_71071_by.func_70445_o();
        ItemStack crafted = this.selInventory.items[0];
        if (stack == null) {
            if (crafted != null && crafted.field_77994_a > 0) {
                --crafted.field_77994_a;
            }

            if (crafted.field_77994_a == 0) {
                crafted = null;
            }

            this.selInventory.func_70299_a(0, crafted);
        } else {
            this.func_75215_d(new ItemStack(itemstack.field_77993_c, itemstack.field_77994_a, itemstack.func_77960_j()));
            player.field_71071_by.func_70437_b((ItemStack)null);
            if (this.selInventory.items[0] == null) {
                return;
            }

            player.field_71071_by.func_70437_b(new ItemStack(itemstack.field_77993_c, this.selInventory.items[0].field_77994_a, itemstack.func_77960_j()));
            this.selInventory.func_70299_a(0, (ItemStack)null);
        }

        this.selInventory.updateItems();
        String sound = this.container.carving.getVariationSound(itemstack.field_77993_c, itemstack.func_77960_j());
        player.field_70170_p.func_72956_a(player, sound, 0.3F + 0.7F * General.rand.nextFloat(), 0.6F + 0.4F * General.rand.nextFloat());
    }
}
