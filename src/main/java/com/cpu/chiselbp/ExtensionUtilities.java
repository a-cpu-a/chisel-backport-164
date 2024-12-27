package com.cpu.chiselbp;

import cpw.mods.fml.common.registry.GameRegistry;
import info.jbcs.minecraft.chisel.*;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtensionUtilities {

    public static Field chBlockName;
    public static Field chVariations;
    public static Field chChiselBlocks;
    public static Field marbleSlabTopField;
    public static Field marbleSlabIsBottomField;
    public static Field varMetadata;

    static {
        try {
            chBlockName = CarvableHelper.class.getDeclaredField("blockName");
            chBlockName.setAccessible(true);
            chVariations = CarvableHelper.class.getDeclaredField("variations");
            chVariations.setAccessible(true);
            chChiselBlocks = CarvableHelper.class.getDeclaredField("chiselBlocks");
            chChiselBlocks.setAccessible(true);
            marbleSlabTopField = BlockMarbleSlab.class.getDeclaredField("top");
            marbleSlabTopField.setAccessible(true);
            marbleSlabIsBottomField = BlockMarbleSlab.class.getDeclaredField("isBottom");
            marbleSlabIsBottomField.setAccessible(true);
            varMetadata = CarvableVariation.class.getDeclaredField("metadata");
            varMetadata.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void addVariation2Block(String description, String texture, int metadata,CarvableHelper ch, Block block, String chiselId)
    {
        ch.addVariation(description, metadata, texture);
        Carving.chisel.addVariation(chiselId, block.field_71990_ca, metadata, metadata);
        MinecraftForge.setBlockHarvestLevel(block, metadata, "chisel", 0);
        /*try {
            LanguageRegistry.addName(new ItemStack(block.field_71990_ca, 1, metadata), Chisel.blockDescriptions? (String) chBlockName.get(ch) :description);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
    }

    public static void registerDupe(CarvableHelper ch, Block block, String name, String dupeName) {registerDupe(ch,block,name,dupeName, ItemCarvable.class);}
    public static void registerDupe(CarvableHelper ch, Block block, String name, String dupeName, Class cl) {
        try {
            block.func_71864_b(dupeName);
            Item.field_77698_e[block.field_71990_ca] = null;

            GameRegistry.registerBlock(block, cl, "chisel." + dupeName);
            if (block instanceof BlockMarbleSlab) {
                BlockMarbleSlab slab = (BlockMarbleSlab) block;
                GameRegistry.registerBlock((Block) marbleSlabTopField.get(slab), cl, "chisel." + dupeName + ".top");
            }
            else if (block instanceof BPBlockSlabCarvable) {
                BPBlockSlabCarvable slab = (BPBlockSlabCarvable) block;
                GameRegistry.registerBlock(slab.top, cl, "chiselbp." + dupeName + ".top");
            }

        Iterator i$ = ((Iterable)chVariations.get(ch)).iterator();

        while(i$.hasNext()) {
            CarvableVariation variation = (CarvableVariation)i$.next();
            int varMeta = varMetadata.getInt(variation);

            ch.registerVariation(name, variation, block, varMeta);
            if (block instanceof BlockMarbleSlab && marbleSlabIsBottomField.getBoolean(block)) {
                BlockMarbleSlab slab = (BlockMarbleSlab)block;
                Block slabTop = ((Block)marbleSlabTopField.get(slab));

                MinecraftForge.setBlockHarvestLevel(slabTop, varMeta, "chisel", 0);
                slabTop.func_71848_c(slab.field_71989_cb).func_71894_b(slab.field_72029_cc);
                if (!ch.forbidChiseling) {
                    Carving.chisel.addVariation(name + ".top", slabTop.field_71990_ca, varMeta, 0);
                    Carving.chisel.setGroupClass(name + ".top", name);
                }
            }
            if (block instanceof BPBlockSlabCarvable && ((BPBlockSlabCarvable) block).isBottom) {
                BPBlockSlabCarvable slab = (BPBlockSlabCarvable)block;
                Block slabTop = slab.top;

                MinecraftForge.setBlockHarvestLevel(slabTop, varMeta, "chisel", 0);
                slabTop.func_71848_c(slab.field_71989_cb).func_71894_b(slab.field_72029_cc);
                if (!ch.forbidChiseling) {
                    Carving.chisel.addVariation(name + ".top", slabTop.field_71990_ca, varMeta, 0);
                    Carving.chisel.setGroupClass(name + ".top", name);
                }
            }
        }

        ((ArrayList)chChiselBlocks.get(null)).add(block);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void addModBlock2Chisel(Block block,int metadata, String name) {
        Carving.chisel.addVariation(name, block.field_71990_ca, metadata, metadata);
        MinecraftForge.setBlockHarvestLevel(block, metadata, "chisel", 0);
    }
}
