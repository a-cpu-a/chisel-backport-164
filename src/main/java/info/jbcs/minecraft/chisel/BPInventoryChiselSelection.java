//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.chisel;

import info.jbcs.minecraft.utilities.General;
import info.jbcs.minecraft.utilities.InventoryStatic;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BPInventoryChiselSelection extends InventoryStatic {
    ItemStack chisel = null;
    public static final int NORMAL_SLOTS = 69;
    int activeVariations = 0;
    BPContainerChisel container;

    public BPInventoryChiselSelection(ItemStack c) {
        super(NORMAL_SLOTS+1);
        this.chisel = c;
    }

    public String func_70303_b() {
        return "Carve blocks";
    }

    public boolean func_70300_a(EntityPlayer entityplayer) {
        return true;
    }

    public void func_70296_d() {
    }

    public void clearItems() {
        this.activeVariations = 0;

        for(int i = 0; i < NORMAL_SLOTS; ++i) {
            this.items[i+1] = null;
        }

    }

    public ItemStack getStackInSpecialSlot() {
        return this.items[0];
    }

    public void updateItems() {
        ItemStack chiseledItem = this.items[0];
        this.clearItems();
        if (chiseledItem != null && chiseledItem.field_77993_c >= 0 && chiseledItem.field_77993_c < Item.field_77698_e.length) {
            if (chiseledItem.field_77993_c < Block.field_71973_m.length) {
                Item item = General.getItem(chiseledItem);
                if (item != null) {
                    ArrayList<ItemStack> list = this.container.carving.getItems(chiseledItem);

                    for(this.activeVariations = 0; this.activeVariations < NORMAL_SLOTS && this.activeVariations < list.size(); ++this.activeVariations) {
                        this.items[this.activeVariations+1] = (ItemStack)list.get(this.activeVariations);
                    }

                    this.container.onChiselSlotChanged();
                }
            }
        } else {
            this.container.onChiselSlotChanged();
        }
    }

    public ItemStack func_70304_b(int i) {
        return null;
    }

    public boolean func_94042_c() {
        return true;
    }

    public void func_70295_k_() {
    }

    public void func_70305_f() {
    }

    public boolean func_94041_b(int i, ItemStack stack) {
        if (stack != null && Item.field_77698_e[stack.field_77993_c] instanceof ItemChisel) {
            return false;
        } else {
            return i == 0;
        }
    }
}
