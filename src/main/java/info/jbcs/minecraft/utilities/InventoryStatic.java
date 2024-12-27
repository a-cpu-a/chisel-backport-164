//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.utilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.world.World;

public abstract class InventoryStatic implements IInventory {
    public final ItemStack[] items;

    public InventoryStatic(int size) {
        this.items = new ItemStack[size];
    }

    public String b() {
        return null;
    }

    public boolean a(EntityPlayer entityplayer) {
        return false;
    }

    public void onInventoryChanged(int slot) {
    }

    public int j_() {
        return this.items.length;
    }

    public ItemStack a(int i) {
        return this.items[i];
    }

    public ItemStack a(int i, int j) {
            return null;
    }

    public void func_70299_a(int i, ItemStack itemstack) {
    }

    public int d() {
        return 64;
    }

    public void readFromNBT(NBTTagCompound nbttagcompound) {
    }

    public void writeToNBT(NBTTagCompound nbttagcompound) {
    }

    private int getFirstEmptyStack(int start, int end) {
        return -1;
    }

    private int storeItemStack(ItemStack itemstack, int start, int end) {
        return -1;
    }

    private int storePartialItemStack(ItemStack itemstack, int start, int end) {
        return 0;
    }

    public boolean addItemStackToInventory(ItemStack itemstack, int start, int end) {
        return false;
    }

    public boolean addItemStackToInventory(ItemStack itemstack) {
        return this.addItemStackToInventory(itemstack, 0, this.items.length - 1);
    }

    public ItemStack takeItems(int itemId, int damage, int count) {
        return null;
    }

    public ItemStack a_(int i) {
        return null;
    }

    public boolean c() {
        return true;
    }

    public void e() {
    }

    public void k_() {
    }

    public void g() {
    }

    public boolean b(int i, ItemStack itemstack) {
        return true;
    }

    public boolean isEmpty() {
        return true;
    }

    public void clear() {
    }

    public void throwItems(World world, int x, int y, int z) {    }
}
