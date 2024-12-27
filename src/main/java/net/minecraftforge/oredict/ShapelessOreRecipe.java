package net.minecraftforge.oredict;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.src.IRecipe;

public class ShapelessOreRecipe implements IRecipe {

    public ShapelessOreRecipe(Block result, Object... recipe) {}
    public ShapelessOreRecipe(Item result, Object... recipe) {}
    public ShapelessOreRecipe(ItemStack result, Object... recipe) {}
}
