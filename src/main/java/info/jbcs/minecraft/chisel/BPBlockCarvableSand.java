package info.jbcs.minecraft.chisel;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.src.BlockSand;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BPBlockCarvableSand extends BlockSand implements Carvable {

    public CarvableHelper ch;



    public BPBlockCarvableSand(int i) {
        this(null, i, Material.field_76246_e);
    }

    public BPBlockCarvableSand(String name, int i) {
        this(name, i, Material.field_76246_e);
    }

    public BPBlockCarvableSand(int i, Material m) {
        this(null, i, m);
    }


    public BPBlockCarvableSand(String name, int i, Material m) {
        super(i, m);

        ch = new CarvableHelper();

        this.func_71849_a(Chisel.tabChisel);
    }


    public Icon func_71858_a(int side, int metadata) {
        return this.ch.getIcon(side, metadata);
    }

    public Icon func_71895_b(IBlockAccess world, int x, int y, int z, int side) {
        return this.ch.getBlockTexture(world, x, y, z, side);
    }

    public int func_71899_b(int i) {
        return i;
    }

    public void func_94332_a(IconRegister register) {
        this.ch.registerIcons("Chisel", this, register);
    }

    public void func_71879_a(int blockId, CreativeTabs tabs, List list) {
        this.ch.registerSubBlocks(this, tabs, list);
    }

    public int func_71857_b() {
        return Chisel.RenderCTMId;
    }

    public CarvableVariation getVariation(int metadata) {
        return this.ch.getVariation(metadata);
    }


}
