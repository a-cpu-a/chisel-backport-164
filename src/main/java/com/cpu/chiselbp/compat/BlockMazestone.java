package com.cpu.chiselbp.compat;

import info.jbcs.minecraft.chisel.BlockMarble;
import info.jbcs.minecraft.chisel.ItemChisel;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class BlockMazestone extends BlockMarble {

    public BlockMazestone(int i, Material material) {
        super(i, material);
    }

    @Override
    public void func_71893_a(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
        ItemStack cei = entityplayer.func_71045_bC();

        Class itm = null;
        try {
            itm = Class.forName("twilightforest.item.ItemTFMazebreakerPick");
        } catch (ClassNotFoundException ignored) {
        }

        if (cei != null && cei.func_77973_b() instanceof ItemTool && !(itm!=null&& itm.isInstance(cei.func_77973_b()))) {
            cei.func_77972_a(16, entityplayer);
        }

        super.func_71893_a(world, entityplayer, x, y, z, meta);
    }

    @Override
    public float func_71908_a(EntityPlayer player, World world, int x, int y, int z){
        Class itm = null;
        try {
            itm = Class.forName("twilightforest.item.ItemTFMazebreakerPick");
        } catch (ClassNotFoundException ignored) {
        }
        ItemStack heldItem = player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c];

        boolean isHoldingMazebreaker = heldItem!=null && itm!=null && itm.isInstance(heldItem.func_77973_b());
        return super.func_71908_a(player, world, x, y, z) * ((isHoldingMazebreaker||(heldItem!=null && heldItem.func_77973_b() instanceof ItemChisel)) ? 16 : 1);
    }
}
