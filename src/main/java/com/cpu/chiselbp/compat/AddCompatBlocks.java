package com.cpu.chiselbp.compat;

import Reika.GeoStrata.Registry.RockShapes;
import Reika.GeoStrata.Registry.RockTypes;
import info.jbcs.minecraft.chisel.Carving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.src.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.reflect.Field;
import java.util.*;

public class AddCompatBlocks {

    public static Field carvingGroupsByOreField;
    public static Field nameField;
    //public static Field variationsField;
    static {
        try {
            carvingGroupsByOreField = Carving.class.getDeclaredField("carvingGroupsByOre");
            carvingGroupsByOreField.setAccessible(true);
            Class groupC = Class.forName("info.jbcs.minecraft.chisel.Carving$CarvingGroup");
            nameField = groupC.getDeclaredField("name");
            nameField.setAccessible(true);
            //variationsField = Class.forName("info.jbcs.minecraft.chisel.Carving$CarvingGroup").getDeclaredField("variations");
            //variationsField.setAccessible(true);
        } catch (NoSuchFieldException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void addBlock(ItemStack block,String name)
    {
        Carving.chisel.addVariation(name, block.field_77993_c, block.field_77991_e, 99);
        MinecraftForge.setBlockHarvestLevel(Block.field_71973_m[block.field_77993_c], block.field_77991_e, "chisel", 0);
    }
    public static void addBlock(Block block,String name,int metadata)
    {
        Carving.chisel.addVariation(name, block.field_71990_ca, metadata, 99);
        MinecraftForge.setBlockHarvestLevel(block, metadata, "chisel", 0);
    }
    public static void addBlocks(Block block,String name,int min,int max)
    {
        for (int i = min; i <= max ; i++) {
            addBlock(block,name,i);
        }
    }

    public static void postInit()
    {
        try {
            Class x = Class.forName("thaumcraft.common.config.ConfigBlocks");
            Block block = (Block) x.getField("blockCosmeticSolid").get(null);
            addBlock(block,"obsidian",1);

            addBlock(block,"thaumium",4);

            addBlock(block,"tallow",5);

            addBlock(block,"arcane",6);
            addBlock(block,"arcane",7);

            block = (Block) x.getField("blockCosmeticOpaque").get(null);

            addBlock(block,"amber",0);
            addBlock(block,"amber",1);

            ApEngCompat.addAll();

        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException ignored) {
        }

        try {

            for (RockShapes s : RockShapes.values())
            {
                addBlock(Block.field_71973_m[RockTypes.SANDSTONE.getID(s)],"sandstone",RockTypes.SANDSTONE.ordinal()%16);
                addBlock(Block.field_71973_m[RockTypes.SANDSTONE.getID(s)],"limestone",RockTypes.LIMESTONE.ordinal()%16);
                addBlock(Block.field_71973_m[RockTypes.SANDSTONE.getID(s)],"granite",RockTypes.GRANITE.ordinal()%16);
                addBlock(Block.field_71973_m[RockTypes.SANDSTONE.getID(s)],"marble",RockTypes.MARBLE.ordinal()%16);

            }


        } catch (NoClassDefFoundError ignored) {
        }

        try {
            Class x = Class.forName("twilightforest.block.TFBlocks");
            Block block = (Block) x.getField("mazestone").get(null);
            addBlocks(block,"mazestone",0,7);
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException ignored) {
        }
        try {
            HashMap ores = (HashMap) carvingGroupsByOreField.get(Carving.chisel);
            for (Object x : ores.entrySet())
            {
                String dict = (String) ((Map.Entry)x).getKey();
                Object var = ((Map.Entry)x).getValue();
                ArrayList<ItemStack> blocks = OreDictionary.getOres(dict);
                for (ItemStack itm : blocks)
                {
                    Item itmType = itm.func_77973_b();
                    if(itmType instanceof ItemBlock)
                    {
                        Block bl = Block.field_71973_m[itm.field_77993_c];
                        MinecraftForge.setBlockHarvestLevel(bl, itm.field_77991_e, "chisel", 0);
                        Carving.chisel.addVariation((String) nameField.get(var),itm.field_77993_c, itm.field_77991_e, 99);
                        /*
                        CarvingVariation variation = new CarvingVariation(itm.field_77993_c, itm.field_77991_e, 99);
                        ((ArrayList)variationsField.get(var)).add(variation);
                        Collections.sort((ArrayList) variationsField.get(var));*/
                        System.out.println("(ChiselBP-DictFix) Added block '"+itm.field_77993_c+":"+itm.field_77991_e+"' using oreDict '"+dict+"'");
                    }
                    else
                        System.out.println("(ChiselBP-DictFix) Found non block '"+itm.field_77993_c+":"+itm.field_77991_e+"' using oreDict '"+dict+"'");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
