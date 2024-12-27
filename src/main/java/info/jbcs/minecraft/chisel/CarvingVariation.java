package info.jbcs.minecraft.chisel;

public class CarvingVariation {
    public int order;
    public int blockId;
    public int meta;
    public int damage;

    public CarvingVariation(int id, int metadata, int ord) {
        this.order = ord;
        this.blockId = id;
        this.meta = metadata;
        this.damage = metadata;
    }
}
