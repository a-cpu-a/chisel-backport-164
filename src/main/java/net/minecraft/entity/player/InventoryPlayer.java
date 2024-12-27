package net.minecraft.entity.player;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryPlayer implements IInventory {


    public ItemStack[] field_70462_a;


    /**
     * selected hotbar index
     */
    public int field_70461_c;
    public EntityPlayer field_70458_d;

    public ItemStack func_70445_o() {
        return null;
    }

    public void func_70437_b(ItemStack itemStack) {

    }

    @Override
    public void func_70299_a(int i, ItemStack stack) {

    }
    /**getHeldItem*/
    public ItemStack func_70448_g() {
        return null;
    }
}
