//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.chisel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class BPSlotChiselPlayer extends Slot {
    BPContainerChisel container;
    InventoryPlayer selInventory;

    public BPSlotChiselPlayer(BPContainerChisel container, InventoryPlayer inv, int i, int j, int k) {
        super(inv, i, j, k);
        this.container = container;
        this.selInventory = inv;
    }

    public boolean func_75214_a(ItemStack par1ItemStack) {
        return false;
    }

    public void func_82870_a(EntityPlayer player, ItemStack itemstack) {
        this.container.finished = true;
    }

    public boolean func_75216_d() {
        return false;
    }

    public ItemStack func_75209_a(int i) {
        return null;
    }
}
