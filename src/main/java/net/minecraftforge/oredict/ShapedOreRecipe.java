package net.minecraftforge.oredict;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.src.IRecipe;

public class ShapedOreRecipe implements IRecipe {
    public ShapedOreRecipe(Block result, Object... recipe) {}
    public ShapedOreRecipe(Item result, Object... recipe) {}
    public ShapedOreRecipe(ItemStack result, Object... recipe) {}
}
