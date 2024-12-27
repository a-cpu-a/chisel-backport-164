package info.jbcs.minecraft.chisel;

import net.minecraft.block.Block;
import net.minecraft.util.Icon;

public class CarvableVariation {
    String blockName;
    String description;
    int metadata;
    int kind;
    Block block;
    int blockMeta;
    String texture;
    Icon icon;
    Icon iconTop;
    Icon iconBot;
    CarvableVariation.CarvableVariationCTM ctm;
    TextureSubmap seamsCtmVert;
    TextureSubmap variations9;
    TextureSubmap submap;
    TextureSubmap submapSmall;

    public CarvableVariation() {
    }

    static class CarvableVariationCTM {
        TextureSubmap[] seams = new TextureSubmap[3];

        CarvableVariationCTM() {
        }
    }
}
