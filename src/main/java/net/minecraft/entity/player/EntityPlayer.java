package net.minecraft.entity.player;

import info.jbcs.minecraft.chisel.Chisel;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.src.FoodStats;
import net.minecraft.src.PlayerCapabilities;
import net.minecraft.world.World;

public class EntityPlayer extends EntityLivingBase {
    /**
     * inventory
     */
    public InventoryPlayer field_71071_by;
    public PlayerCapabilities field_71075_bZ;
    public String field_71092_bJ;

    /**getCurrentEquippedItem*/
    public ItemStack func_71045_bC() {return null;
    }

    /**getFoodStats*/
    public FoodStats func_71024_bL() {
        return null;
    }
    /**canPlayerEdit*/
    public boolean func_82247_a(int x, int y, int z, int side, ItemStack itemStack) {
        return false;
    }

    public void openGui(Object instance, int i, World world, int i1, int i2, int i3) {
    }
}
