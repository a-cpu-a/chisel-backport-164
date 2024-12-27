package net.minecraftforge.common;

import info.jbcs.minecraft.chisel.BPItemChisel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.EventBus;

public class MinecraftForge {
    public static  EventBus EVENT_BUS;
    public static  EventBus TERRAIN_GEN_BUS;
    public static  EventBus ORE_GEN_BUS;
    private static  ForgeInternalHandler INTERNAL_HANDLER;

    public static void setBlockHarvestLevel(Block block, int metadata, String toolClass, int harvestLevel){}
    public static void setBlockHarvestLevel(Block block, String toolClass, int harvestLevel) {}

    public static void setToolClass(Item bpItemChisel, String chisel, int i) {

    }
}
