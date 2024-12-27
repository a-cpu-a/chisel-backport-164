package com.cpu.chiselbp;

import com.cpu.chiselbp.bputils.Color3;
import net.minecraft.world.IBlockAccess;

public class Utils {


    public static final String[] dyeOres = { "dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple",
            "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta",
            "dyeOrange", "dyeWhite" };

    public static String[] colors = {
            "black",
            "red",
            "green",
            "brown",
            "blue",
            "purple",
            "cyan",
            "lightgray",
            "gray",
            "pink",
            "lime",
            "yellow",
            "lightblue",
            "magenta",
            "orange",
            "white"
    };
    public static String[] colorsAlt = {
            "Black",
            "Red",
            "Green",
            "Brown",
            "Blue",
            "Purple",
            "Cyan",
            "LightGray",
            "Gray",
            "Pink",
            "Lime",
            "Yellow",
            "LightBlue",
            "Magenta",
            "Orange",
            "White"
    };
    public static String[] colorsNew = {
            "black",
            "red",
            "green",
            "brown",
            "blue",
            "purple",
            "cyan",
            "silver",
            "gray",
            "pink",
            "lime",
            "yellow",
            "light_blue",
            "magenta",
            "orange",
            "white"
    };
    public static String[] textColors = {
            "Black",
            "Red",
            "Green",
            "Brown",
            "Blue",
            "Purple",
            "Cyan",
            "Light Gray",
            "Gray",
            "Pink",
            "Lime",
            "Yellow",
            "Light Blue",
            "Magenta",
            "Orange",
            "White"
    };
    public static String[] neoName = {
            "Atomic Tangerine",
            "Saffron Mango",
            "Golden Glow",
            "Oasis",
            "Pixie Green",
            "Fresh Green",
            "Jungle Green",
            "Mariner",
            "Congress Blue",
            "Deep Saphire",
            "Deep Cove",
            "Meteorite",
            "Eminence",
            "Warm Purple",
            "Raspberry Pink",
            "Watermelon Pink"
    };
    public static Color3[] colorValues = {
            new Color3(0.102, 0.11, 0.125),
            new Color3(0.58, 0.141, 0.106),
            new Color3(0.294, 0.384, 0.098),
            new Color3(0.412, 0.263, 0.153),
            new Color3(0.18, 0.192, 0.561),
            new Color3(0.435, 0.129, 0.608),
            new Color3(0.086, 0.498, 0.529),
            new Color3(0.514, 0.514, 0.478),
            new Color3(0.188, 0.216, 0.224),
            new Color3(0.914, 0.541, 0.651),
            new Color3(0.396, 0.698, 0.11),
            new Color3(0.957, 0.773, 0.176),
            new Color3(0.227, 0.659, 0.816),
            new Color3(0.663, 0.216, 0.62),
            new Color3(0.949, 0.482, 0.149),
            new Color3(0.918, 0.925, 0.929)
    };

    public static int getSideMeta(IBlockAccess access, int x, int y, int z, int side)
    {
        switch (side)
        {
            case 0:
                return access.func_72805_g(x, y+1, z);
            case 1:
                return access.func_72805_g(x, y-1, z);
            case 2:
                return access.func_72805_g(x, y, z+1);
            case 3:
                return access.func_72805_g(x, y, z-1);
            case 4:
                return access.func_72805_g(x+1, y, z);
            case 5:
                return access.func_72805_g(x-1, y, z);
        }
        return 0;
    }
    public static int mod(int v, int mod)
    {
        int m = v%mod;
        if(v<0)
            m+=mod-1;
        return m;
    }
    public static int xyzs2Idx(int x,int y,int z,int side, int w, int h)
    {
        int index = 0;

        switch (side)
        {
            case 4://-x
            case 5://+x
                int zz = Utils.mod((side==4?z:-z)+1,w);
                index = zz+Utils.mod(-y,h)*w;
                break;
            case 0://-y
            case 1://+y
                index =  Utils.mod(x,w)+ Utils.mod(z,h)*w;
                break;
            case 2://-z
            case 3://+z
                int xx = Utils.mod(x+1,w);
                if(side==2 && w==3)
                {
                    if(xx>0)
                        xx=w-xx;
                }
                index = xx+Utils.mod(-y,h)*3;
                break;
        }
        return index%(w*h);
    }
}
