package com.cpu.chiselbp.compat;

import net.minecraft.item.ItemStack;

import static com.cpu.chiselbp.compat.AddCompatBlocks.addBlock;

public class ApEngCompat {
    public static void addAll() throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {

        Class c = Class.forName("appeng.api.Blocks");

        addBlock( (ItemStack) c.getDeclaredField("blkQuartz").get(null),"certusQuartz");
        addBlock( (ItemStack) c.getDeclaredField("blkQuartzPiller").get(null),"certusQuartz");
        addBlock((ItemStack) c.getDeclaredField("blkQuartzChiseled").get(null),"certusQuartz");

    }
}
