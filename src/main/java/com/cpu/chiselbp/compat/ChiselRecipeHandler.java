package com.cpu.chiselbp.compat;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import info.jbcs.minecraft.chisel.Carving;
import info.jbcs.minecraft.chisel.CarvingVariation;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;

public class ChiselRecipeHandler extends TemplateRecipeHandler {
    @Override
    public String getGuiTexture() {
        return "chisel:textures/chiselNEI.png";
    }

    @Override
    public String getRecipeName() {
        return "Chiseling";
    }

    HashMap<String, Object> getList()
    {
        Field f= null;
        try {
            f = Carving.class.getDeclaredField("carvingGroupsByName");
            f.setAccessible(true);

            return (HashMap) f.get(Carving.chisel);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return new HashMap<>();
        }
    }


    @Override
    public int recipiesPerPage() {
        return 1;
    }

    @Override
    public void loadTransferRects() {
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(75, 22, 15, 13), "chisel.chisel"));
    }

    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("chisel.chisel")) {

            Field vars = null;
            try {
                vars = Class.forName("info.jbcs.minecraft.chisel.Carving$CarvingGroup").getDeclaredField("variations");
                vars.setAccessible(true);

                for (Object v : getList().values())
                {
                    try {
                        arecipes.add(new CachedChiselRecipe(((ArrayList<CarvingVariation>)vars.get(v)).get(0).blockId,0,((ArrayList<CarvingVariation>)((ArrayList<?>) vars.get(v))).toArray(new CarvingVariation[0])));
                    }
                    catch (NullPointerException ignored){}
                }
            } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            return;
        }
        super.loadCraftingRecipes(outputId,results);

    }

    public void loadCraftingRecipes(ItemStack output) {
        try {
        arecipes.add(new CachedChiselRecipe(output.field_77993_c,output.field_77991_e,Carving.chisel.getVariations(output.field_77993_c,output.field_77991_e)));
        }
        catch (NullPointerException ignored){}
    }
    public void loadUsageRecipes(ItemStack input) {
        try {
            arecipes.add(new CachedChiselRecipe(input.field_77993_c,input.field_77991_e,Carving.chisel.getVariations(input.field_77993_c,input.field_77991_e)));
        }
        catch (NullPointerException ignored){}
    }
    @Override
    public void drawBackground(int recipe) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        try {
            GuiDraw.class.getDeclaredMethod("changeTexture", String.class).invoke(null,this.getGuiTexture());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        GuiDraw.drawTexturedModalRect(0, 0, 0, 0, 166, 130);
    }

    public class CachedChiselRecipe extends TemplateRecipeHandler.CachedRecipe {

        PositionedStack res;
        List<PositionedStack> in;
        int cycleTicks = 0;

        public CachedChiselRecipe(int id,int meta,CarvingVariation[] variations)
        {
            ArrayList<ItemStack> inputs = new ArrayList<>();
            for (CarvingVariation var : variations)
            {
                inputs.add(new ItemStack(var.blockId,1,var.damage));
            }

            res = new PositionedStack(inputs,74,4,true);
            in = new ArrayList<>();
            int i = 0;
            for (ItemStack itm : inputs)
            {
                in.add(new PositionedStack(itm, 3+(i%9)*18,37+(i/9)*18));
                i++;
            }
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return in;
        }

        @Override
        public PositionedStack getResult() {
            int len = 0;
            try {
                len = ((Object[])PositionedStack.class.getField("items").get(res)).length;
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            if(len>0)
                res.setPermutationToRender((cycleTicks/20)%len);

            cycleTicks++;
            return res;
        }
    }
}
