package info.jbcs.minecraft.chisel;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;

public class CarvableHelper {

    static final String				modName			= "chisel";
    static final ArrayList<Block> chiselBlocks = new ArrayList();

    static final int				NORMAL			= 0;
    static final int				TOPSIDE			= 1;
    static final int				TOPBOTSIDE		= 2;
    static final int				CTM3			= 3;
    static final int				CTMV			= 4;
    static final int				CTMH			= 5;
    static final int				V9				= 6;
    static final int				V4				= 7;
    static final int				CTMX			= 8;

    ArrayList<CarvableVariation>	variations		= new ArrayList<CarvableVariation>();
    CarvableVariation[]				map				= new CarvableVariation[16];
    public boolean					forbidChiseling	= false;
    String							blockName;

    public void addVariation(String description, int metadata, String texture, Block block, int blockMeta) {}
    public void addVariation(String description, int metadata, Block bb, int blockMeta){}
    public void addVariation(String description, int metadata, String texture) {}
    public void addVariation(String description, int metadata, Block baseBlock) {}
    void register(Block block, String name){}
    void register(Block block, String name, Class cl) {}
    public void registerVariation(String name, CarvableVariation variation, Block block, int blockMeta){}
    public Icon getIcon(int side, int metadata) {return null;}
    public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side) {return null;}

    public void registerIcons(String modName, Block block, IconRegister register){}

    public void setBlockName(String factory_block) {
    }




    public void setBlockHarvestLevel(Block block, String tool, int level) {}
}
