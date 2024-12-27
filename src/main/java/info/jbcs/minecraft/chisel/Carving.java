package info.jbcs.minecraft.chisel;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class Carving {
    HashMap<String, Carving.CarvingGroup> carvingGroupsByName;
    HashMap<String, Carving.CarvingGroup> carvingGroupsByOre;
    HashMap<String, Carving.CarvingGroup> carvingGroupsByVariation;

    public static Carving chisel;
    public CarvingVariation addVariation(String name, int blockId, int metadata, int order){return null;}
    public void registerOre(String name, String oreName){}

    public void setGroupClass(String name, String className) {
    }

    public String getVariationSound(int blockId, int metadata) {
        return null;
    }

    public boolean isVariationOfSameClass(int targetId, int index, int blockId, int blockMeta) {
        return false;
    }

    class CarvingGroup {
        String name;
        String className;
        String sound;
        String oreName;
        ArrayList<CarvingVariation> variations;

        public CarvingGroup(String n) {
            this.name = n;
        }
    }
    public CarvingVariation[] getVariations(int blockId,int metadata){return null;}

    public ArrayList<ItemStack> getItems(ItemStack chiseledItem) {return null;}
}
