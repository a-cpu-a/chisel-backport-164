package net.minecraft.block;


import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import java.util.List;
import java.util.Random;

public class Block {


    public static boolean[] field_71970_n;

    /**
     * redstone block
     */
    public static Block field_94341_cq;
    /**
     * brick block
     */
    public static Block field_72081_al;
    /**
     * end stone block
     */
    public static Block field_72082_bJ;

    /**
     * stone
     */
    public static Block field_71981_t;
    /** stoneBricks */
    public static Block field_72007_bm;
    /** cobblestone */
    public static Block field_71978_w;
    /** gravel */
    public static Block field_71940_F;

    /**
     * sand
     */
    public static Block field_71939_E;

    /**
     * sandstone
     */
    public static Block field_71957_Q;

    /**
     * wool
     */
    public static Block field_72101_ab;
    /**
     * coal block
     */
    public static Block field_111034_cE;
    /** obsidian block */
    public static Block field_72089_ap;
    /**quartzBlock*/
    public static Block field_94339_ct;
    /**leavesBlock*/
    public static BlockLeaves field_71952_K;
    /**blockGrass*/
    public static BlockGrass field_71980_u;
    /**glass*/
    public static Block field_71946_M;
    /**waterMoving*/
    public static BlockFluid field_71942_A;

    public StepSound field_72020_cn;
    public Material field_72018_cp;

    /**is solid opaque cube*/
    public boolean func_71926_d(){return false;}

    /**
     * block-id
     */
    public int field_71990_ca;

    /**
     * soundGlassFootstep
     */
    public static StepSound field_71974_j;
    /**
     * soundStoneFootstep
     */
    public static StepSound field_71976_h;
    /** soundGrassFootstep */
    public static StepSound field_71965_g;
    /**
     * soundWoodFootstep
     */
    public static StepSound field_71967_e;
    /**
     * soundMetalFootstep
     */
    public static StepSound field_71977_i;

    /**
     * soundClothFootstep
     */
    public static StepSound field_71975_k;

    /**
     * soundSandFootstep
     */
    public static StepSound field_71972_l;
    /**
 * hardness
 */
    public float field_71989_cb;

    /**
     * set hardness
     */
    public Block func_71848_c(float v) {
        return this;
    }
    /**
     * setLightValue
     */
    public Block func_71900_a(float v) {
        return this;
    }
    /**
     * resistance
     */
    public float field_72029_cc;
    /**
     * setResistance
     */
    public Block func_71894_b(float v) {
        return this;
    }

    /**
     * setStepSound
     */
    public Block func_71884_a(StepSound v) {
        return this;
    }

    /**
     * setLightOpacity
     */
    public Block func_71868_h(int v) {
        return this;
    }

    /**
     * get unlocalized name (lang key)
     */
    public String func_71917_a() {return "";}

    /**
     * getPlayerRelativeBlockHardness
     */
    public float func_71908_a(EntityPlayer player, World world, int x, int y, int z){return 0.0f;}

    /**
     * block list
     */
    public static Block[] field_71973_m;


    /**
     * localized name?
     */
    public String func_71931_t() {return "";
    }
    /**
     * getRenderType
     */
    public int func_71857_b(){return 0;}
    /**
     * hasAlpha / getRenderBlockPass
     */
    public int func_71856_s_(){return 0;}


    //isSolid = ((Block aqz)var1).cU.k()&& func_71886_c()

    /**
     * renderAsNormalBlock
     */
    public boolean func_71886_c(){return true;}
    /**
     * registerIcons
     */
    public void func_94332_a(IconRegister register){}
    /**
     * get mixed brightness
     */
    public int func_71874_e(IBlockAccess access,int x,int y,int z){return 999;}
    /**colorMultiplier*/
    public int func_71920_b(IBlockAccess access,int x,int y,int z){return 999;}

    /**get world block icon*/
    public Icon func_71895_b(IBlockAccess access, int x, int y, int z, int side) {return null;
    }

    /**
     * setUnlocalizedName
     */
    public Block func_71864_b(String name) {return null;
    }
    /**
     * randomDisplayTick
     */
    public void func_71862_a(World world, int x, int y, int z, Random rng) {}

    /** getBlockBoundsMinX */
    public double func_83009_v() {return 0.0;}
    /** getBlockBoundsMinY */
    public double func_83008_x() {return 0.0;}
    /** getBlockBoundsMinZ */
    public double func_83005_z() {return 0.0;}

    /** getBlockBoundsMaxX */
    public double func_83007_w() {return 0.0;}
    /** getBlockBoundsMaxY */
    public double func_83010_y() {return 0.0;}
    /** getBlockBoundsMaxZ */
    public double func_83006_A() {return 0.0;}

    /**getIcon*/
    public Icon func_71858_a(int side, int metadata) {return null;}
    /**shouldSideBeRendered*/
    public boolean func_71877_c(IBlockAccess access, int x, int y, int z, int side) {return false;
    }
    /**harvestBlock*/
    public void func_71893_a(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
    }

    /**setTextureName*/
    public Block func_111022_d(String s) {return null;}
    /**getRenderColor*/
    public int func_71889_f_(int damage) {return 0;}
    /**getBlockColor*/
    public int func_71933_m() {return 0;}
    /**onEntityCollidedWithBlock*/
    public void func_71869_a(World world,int x, int y, int z,Entity ent) {}

    /**updateTick*/
    protected void func_71847_b(World world, int x, int y, int z, Random rand) {
    }


    public int getLightOpacity(World world, int x, int y, int z){return 1;}

    public boolean isBlockNormalCube(World world, int x, int y, int z){return false;}

    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side){return false;}

    public Icon func_71851_a(int i) {
        return null;
    }

    public void func_71879_a(int blockId, CreativeTabs tabs, List list) {
    }

    public void func_71871_a(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
    }

    protected void func_71905_a(float v, float v1, float v2, float v3, float v4, float v5) {

    }
}
