package com.cpu.chiselbp;

import info.jbcs.minecraft.chisel.BlockMarble;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ItemShears;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;

public class WoolBlock extends BlockMarble implements IShearable {
    public WoolBlock(int i) {
        super(i, Material.field_76253_m);
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack ye, World abw, int i, int i1, int i2, int i3) {
        return new ArrayList<>();
    }

    @Override
    public boolean isShearable(ItemStack ye, World abw, int i, int i1, int i2) {
        return true;
    }

    @Override
    public float func_71908_a(EntityPlayer player, World world, int x, int y, int z){
        ItemStack heldItem = player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c];
        boolean isHoldingShears = heldItem!=null && heldItem.func_77973_b() instanceof ItemShears;
        return super.func_71908_a(player, world, x, y, z) * (isHoldingShears ? 3 : 1);
    }
}
