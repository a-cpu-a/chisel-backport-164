package net.minecraft.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.src.NBTTagCompound;

public class ItemStack {
    /**item id*/
    public int field_77993_c;
    /**damage*/
    public int field_77991_e;
    /**stackTagCompound*/
    public NBTTagCompound field_77990_d;
    /**count*/
    public int field_77994_a;

    public ItemStack(int id, int count, int damage) {
    }

    public ItemStack(Block block, int count) {
    }
    public ItemStack(Block block, int count, int metadata) {
    }

    public ItemStack(Item type, int count) {
    }
    /**loadItemStackFromNBT*/
    public static ItemStack func_77949_a(NBTTagCompound item) {
        return null;
    }

    /**
     * get item
     */
    public Item func_77973_b() {
        return null;
    }

    /**damageItem*/
    public void func_77972_a(int i, EntityLivingBase entityplayer) {
    }
    /**getTagCompound*/
    public NBTTagCompound func_77978_p() {
        return null;
    }
    /**setTagCompound*/
    public void func_77982_d(NBTTagCompound stackTag) {
    }

    /**save2Tag*/
    public NBTTagCompound func_77955_b(NBTTagCompound item) {
        return null;
    }

    /**getDamage*/
    public int func_77960_j() {
        return 0;
    }

    public boolean func_77969_a(ItemStack chisel) {
        return false;
    }
}
