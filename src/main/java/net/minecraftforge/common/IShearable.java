package net.minecraftforge.common;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public interface IShearable {

    boolean isShearable(ItemStack ye, World abw, int i, int i1, int i2);
    ArrayList<ItemStack> onSheared(ItemStack ye, World abw, int i, int i1, int i2, int i3);
}
