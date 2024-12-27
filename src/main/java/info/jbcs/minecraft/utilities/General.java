//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.utilities;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.Entity;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Random;

public class General {
    public static Random rand = new Random();
    static HashMap<String, Block> blockMapping;

    public General() {
    }

    public static void propelTowards(Entity what, Entity whereTo, double force) {

    }

    public static boolean isInRange(double distance, double x1, double y1, double z1, double x2, double y2, double z2) {
        double x = x1 - x2;
        double y = y1 - y2;
        double z = z1 - z2;
        return x * x + y * y + z * z < distance * distance;
    }

    public static Item getItem(ItemStack stack) {
        return null;
    }

    public static Block getBlock(int blockId) {
        return null;
    }

    public static Item getItem(int itemId) {
        return null;
    }

    public static String getUnlocalizedName(Block block) {
        return "";
    }

    public static Block getBlock(String s, Block fallback) {
        return fallback;
    }

    public static Block getBlock(String s) {
        return null;
    }

    public static String getName(Block block) {
        return "";
    }

    public static MovingObjectPosition getMovingObjectPositionFromPlayer(World par1World, EntityPlayer par2EntityPlayer, boolean par3) {
        return null;
    }
}
