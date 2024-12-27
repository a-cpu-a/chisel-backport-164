//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.chisel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class BPSlotChiselInput extends Slot {
    BPContainerChisel container;
    BPInventoryChiselSelection selInventory;

    public BPSlotChiselInput(BPContainerChisel container, BPInventoryChiselSelection inv, int i, int j, int k) {
        super(inv, i, j, k);
        this.selInventory = inv;
        this.container = container;
    }

    public boolean func_75214_a(ItemStack itemstack) {
        return !this.container.finished && super.func_75214_a(itemstack);
    }

    public boolean func_82869_a(EntityPlayer par1EntityPlayer) {
        return !this.container.finished && super.func_82869_a(par1EntityPlayer);
    }

    public void func_75218_e() {
        if (!this.container.finished) {
            super.func_75218_e();
            this.selInventory.updateItems();
        }
    }
}
