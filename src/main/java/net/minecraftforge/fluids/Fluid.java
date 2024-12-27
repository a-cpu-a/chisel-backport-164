//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraftforge.fluids;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.src.EnumRarity;
import net.minecraft.world.World;
import net.minecraft.util.Icon;

public class Fluid {
    protected final String fluidName = "";
    protected String unlocalizedName;
    protected Icon stillIcon;
    protected Icon flowingIcon;
    protected int luminosity = 0;
    protected int density = 1000;
    protected int temperature = 295;
    protected int viscosity = 1000;
    protected boolean isGaseous;
    protected EnumRarity rarity;
    protected int blockID;
    private static Map<String, String> legacyNames;

    public Fluid(String fluidName) {}

    public Fluid setUnlocalizedName(String unlocalizedName){return null;}

    public Fluid setBlockID(int blockID) {return null;}

    public Fluid setBlockID(Block block) {return null;}

    public Fluid setLuminosity(int luminosity){return null;}

    public Fluid setDensity(int density) {return null;}

    public Fluid setTemperature(int temperature) {return null;}

    public Fluid setViscosity(int viscosity) {return null;}

    public Fluid setGaseous(boolean isGaseous)  {return null;}

    public Fluid setRarity(EnumRarity rarity) {return null;}

    public final String getName() {return "";}

    public final int getID()  {return 0;}

    public final int getBlockID()  {return 0;}

    public final boolean canBePlacedInWorld()  {return false;}

    public String getLocalizedName()  {return "";}

    public String getUnlocalizedName()  {return "";}

    public final int getSpriteNumber()  {return 0;}

    public final int getLuminosity() {return 0;}

    public final int getDensity()  {return 0;}

    public final int getTemperature()  {return 0;}

    public final int getViscosity()  {return 0;}

    public final boolean isGaseous() {return false;}

    public EnumRarity getRarity() {        return null;    }

    public int getColor() {return 0;}

    public final Fluid setStillIcon(Icon stillIcon) {  return null;  }

    public final Fluid setFlowingIcon(Icon flowingIcon) {   return null; }

    public final Fluid setIcons(Icon stillIcon, Icon flowingIcon) {  return null;  }

    public final Fluid setIcons(Icon commonIcon) {  return null;  }

    public Icon getIcon() {        return null;    }

    public Icon getStillIcon() {  return null;  }

    public Icon getFlowingIcon() { return null;   }

    public int getLuminosity(FluidStack stack) {return 0;    }

    public int getDensity(FluidStack stack) {return 0;    }

    public int getTemperature(FluidStack stack) {return 0;    }

    public int getViscosity(FluidStack stack){return 0;    }

    public boolean isGaseous(FluidStack stack) {return false;    }

    public EnumRarity getRarity(FluidStack stack) {return null;}

    public int getColor(FluidStack stack) {return 0;}

    public Icon getIcon(FluidStack stack){return null;}

    public int getLuminosity(World world, int x, int y, int z)  {return 0;}

    public int getDensity(World world, int x, int y, int z)  {return 0;}

    public int getTemperature(World world, int x, int y, int z)  {return 0;}

    public int getViscosity(World world, int x, int y, int z)  {return 0;}

    public boolean isGaseous(World world, int x, int y, int z)  {return false;}

    public EnumRarity getRarity(World world, int x, int y, int z)  {return null;}

    public int getColor(World world, int x, int y, int z)  {return 0;}

    public Icon getIcon(World world, int x, int y, int z) {return null;}

    static String convertLegacyName(String fluidName) {return null;}

    public static void registerLegacyName(String legacyName, String canonicalName) {}
}
