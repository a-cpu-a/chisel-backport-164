package net.minecraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class Item {



    /**
    * clay
    * */
    public static Item field_77757_aI;
    /**
    * dye
    * */
    public static Item field_77756_aW;
    /** coal */
    public static Item field_77705_m;
    /** slimeball */
    public static Item field_77761_aM;
    /** quartz */
    public static Item field_94583_ca;
    /** redstone dust */
    public static Item field_77767_aC;
    /** iron */
    public static Item field_77703_o;
    /** gold nuggy */
    public static Item field_77733_bq;
    /** ender pearl */
    public static Item field_77730_bn;
    /** ender eye */
    public static Item field_77748_bA;
    /** emerald */
    public static Item field_77817_bH;
    /**
    * glowstone
    * */
    public static Item field_77751_aT;
    public static Item[] field_77698_e;
    /**bucketEmpty*/
    public static Item field_77788_aw;
    /**bucketWater*/
    public static Item field_77786_ax;
    /**
     * item id
     */
    public int field_77779_bT;
    /**maxStackSize*/
    protected int field_77777_bU;

    public Item() {
    }
    public Item(int id) {
    }

    /**setHasSubTypes*/
    public Item func_77627_a(boolean b) {
        return null;
    }
    /**setMaxStackSize*/
    public Item func_77625_d(int b) {
        return null;
    }
    /**setMaxDamage*/
    public Item func_77656_e(int b) {
        return null;
    }
    /**
     * getSubItems
     */
    public void func_77633_a(int x, CreativeTabs tab, List list) {
    }
    //get unlocalized name (lang key)
    public String func_77667_c(ItemStack itemstack) {
        return "";
    }


    /**getColorFromItemStack*/
    public int func_82790_a(ItemStack itm,int i){return 0;}

    /**addInformation*/
    public void func_77624_a(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
    }

    /**setUnlocalizedName*/
    public Item func_77655_b(String name) {return null;    }
    /**registerIcons*/
    public void func_94581_a(IconRegister ir){}

    /**onItemRightClick*/
    public ItemStack func_77659_a(ItemStack itemStack, World world, EntityPlayer player){return null;}
    /**onCreated*/
    public void func_77622_d(ItemStack itemStack, World world, EntityPlayer player){}

    /**setCreativeTab*/
    public Item func_77637_a(net.minecraft.creativetab.CreativeTabs creativeTab) {
        return null;
    }

    /**setContainerItem*/
    public Item func_77642_a(Item i){
        return i;
    }
    /**getMovingObjectPositionFromPlayer*/
    public MovingObjectPosition func_77621_a(World world, EntityPlayer player, boolean b) {
        return null;
    }


    /**getUnlocalizedNameInefficiently*/
    public String func_77657_g(ItemStack itemstack){
        return "";
    }


    protected boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hz, float hy, float hz1) {
        return false;
    }

    protected int func_77883_f() {
        return 0;
    }

    /**canPlaceItemBlockOnSide*/
    public boolean func_77884_a(World world, int x, int y, int z, int side, EntityPlayer player, ItemStack stack) {
return false;
    }
}
