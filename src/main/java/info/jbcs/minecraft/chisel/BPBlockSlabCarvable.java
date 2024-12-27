//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package info.jbcs.minecraft.chisel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.src.Entity;
import net.minecraft.world.World;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BPBlockSlabCarvable extends BlockMarble {
    public Block master;
    public BPBlockSlabCarvable bottom;
    public BPBlockSlabCarvable top;
    public boolean isBottom;

    public BPBlockSlabCarvable( int bottomId, int topId, BlockMarble m) {
        super(bottomId,m.field_72018_cp);
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        field_71970_n[this.field_71990_ca] = true;
        this.master = m;
        this.bottom = this;
        this.top = new BPBlockSlabCarvable( this, topId);
        this.isBottom = true;

        this.carverHelper.variations = m.carverHelper.variations;
        this.carverHelper.map = m.carverHelper.map;

        this.field_71989_cb = m.field_71989_cb;
        this.field_72029_cc = m.field_72029_cc;
        this.func_71884_a(m.field_72020_cn);
    }

    public BPBlockSlabCarvable(BPBlockSlabCarvable bottomBlock, int topId) {
        super(topId,bottomBlock.field_72018_cp);
        this.func_71905_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
        field_71970_n[this.field_71990_ca] = true;
        this.master = bottomBlock.master;
        this.bottom = bottomBlock;
        this.top = this;
        this.carverHelper = bottomBlock.carverHelper;
        this.isBottom = false;


        this.field_71989_cb = master.field_71989_cb;
        this.field_72029_cc = master.field_72029_cc;
        this.func_71884_a(master.field_72020_cn);
    }

    public void register(String chiselRegisterName) {

        this.carverHelper.register(this,chiselRegisterName, BPItemSlabCarvable.class);
    }

    public void func_71902_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        if (this.isBottom) {
            this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        } else {
            this.func_71905_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

    }

    public void func_71919_f() {
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }

    public void func_71871_a(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
        this.func_71902_a(par1World, par2, par3, par4);
        super.func_71871_a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
    }

    public boolean func_71926_d() {
        return false;
    }

    public int func_71899_b(int meta) {
        return meta;
    }

    public int func_71885_a(int par1, Random par2Random, int par3) {
        return this.bottom.field_71990_ca;
    }

    public boolean func_71886_c() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int func_71922_a(World par1World, int par2, int par3, int par4) {
        return this.bottom.field_71990_ca;
    }

    public Icon func_71858_a(int side, int metadata) {
        return this.carverHelper.getIcon(side, metadata);
    }

    public void func_71879_a(int blockId, CreativeTabs tabs, List list) {
        if (this.isBottom) {
            super.func_71879_a(blockId, tabs, list);
        }

    }

    public CarvableHelper gCh() {
        return carverHelper;
    }
}
