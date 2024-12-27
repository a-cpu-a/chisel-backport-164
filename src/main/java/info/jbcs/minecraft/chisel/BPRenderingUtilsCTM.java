package info.jbcs.minecraft.chisel;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.src.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class BPRenderingUtilsCTM {
    static public BPRenderBlocksCTM rendererBP = new BPRenderBlocksCTM();
    static public RenderBlocksColumn rendererColumn = new RenderBlocksColumn();
    public static double bot=0.0f,top=1.0f;


    static public void renderInventoryBlockInit(Block block, int metadata, RenderBlocks renderer) {
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        if(block instanceof BPBlockSlabCarvable || block instanceof BlockMarbleSlab)
            renderer.func_83020_a(bot, bot, bot, top, top-0.5, top);
        else
            renderer.func_83020_a(bot, bot, bot, top, top, top);

        //call something after this like VVV
        //Drawing.drawBlock(block,metadata, renderer);
    }

    static public void renderWorldBlockDone(int wasBlockDrawn,IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer) {
        if(wasBlockDrawn==1 || wasBlockDrawn==3)
        {
            Tessellator var10000 = rendererBP.tessellator;
            var10000.field_78408_v -= (double) x;
            var10000 = rendererBP.tessellator;
            var10000.field_78407_w -= (double) y;
            var10000 = rendererBP.tessellator;
            var10000.field_78417_x -= (double) z;
        }
    }

    static public void initCTMRenderer(IBlockAccess world,int x,int y,int z, RenderBlocks renderer,BPRenderBlocksCTM rendererCTM)
    {
        rendererCTM.field_78669_a = world;
        Block block = Block.field_71973_m[world.func_72798_a(x,y,z)];
        rendererCTM.notSlab = true;
        if(block instanceof BPBlockSlabCarvable || block instanceof BlockMarbleSlab) {
            rendererCTM.notSlab = false;
            if (block instanceof BPBlockSlabCarvable){
                rendererCTM.topSlab = !((BPBlockSlabCarvable) block).isBottom;
                rendererCTM.func_83020_a(bot, bot + (((BPBlockSlabCarvable) block).isBottom ? 0 : 0.5), bot, top, top - (((BPBlockSlabCarvable) block).isBottom ? 0.5 : 0), top);
            }else {
                rendererCTM.topSlab = !((BlockMarbleSlab) block).isBottom;
                rendererCTM.func_83020_a(bot, bot + (((BlockMarbleSlab) block).isBottom?0:0.5), bot, top, top - (((BlockMarbleSlab) block).isBottom?0.5:0), top);
            }
        }
        else
            rendererCTM.func_83020_a(bot, bot, bot, top, top, top);

        rendererCTM.initPoses();

        //rendererCTM.submap = var.submap;
        //rendererCTM.submapSmall = var.submapSmall;
        rendererCTM.rendererOld = renderer;
        //rendererCTM.func_78570_q(block, x, y, z);
        rendererCTM.bx = x;
        rendererCTM.by = y;
        rendererCTM.bz = z;
        rendererCTM.tessellator = Tessellator.field_78398_a;
        rendererCTM.tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
    }

    //returns non 0 if you should draw a cube, pass into renderWorldBlockDone
    static public int renderWorldBlockInit(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer) {

        //renderer.func_83020_a(bot, bot, bot, top, top, top);

        //boolean wasAOEnabled = renderer.field_78677_m;
        //renderer.field_78677_m = false;
        //renderer.func_78609_c(block, x, y, z,1.0f,1.0f,1.0f);
        //renderer.field_78677_m=wasAOEnabled;
        if(!(block instanceof Carvable))
        {
            //BPDrawing.drawWorldBlock(world,block,true,x,y,z,renderer);
            return 2;
        }

        Tessellator tes = Tessellator.field_78398_a;

        int metadata = world.func_72805_g(x,y,z);
        CarvableVariation var = ((Carvable)block).getVariation(metadata);
        try {

            switch(var == null ? 0 : var.kind) {
                case 4:
                    rendererColumn.field_78669_a = world;
                    if(block instanceof BPBlockSlabCarvable || block instanceof BlockMarbleSlab) {
                        if(block instanceof BPBlockSlabCarvable)
                            rendererColumn.func_83020_a(bot, bot + (((BPBlockSlabCarvable) block).isBottom?0:0.5), bot, top, top - (((BPBlockSlabCarvable) block).isBottom?0.5:0), top);
                        else
                            rendererColumn.func_83020_a(bot, bot + (((BlockMarbleSlab) block).isBottom?0:0.5), bot, top, top - (((BlockMarbleSlab) block).isBottom?0.5:0), top);
                    }
                    else
                        rendererColumn.func_83020_a(bot,bot,bot,top,top,top);
                    rendererColumn.submap = var.seamsCtmVert;
                    rendererColumn.iconTop = var.iconTop;
                    rendererColumn.func_78570_q(block, x, y, z);
                    return 0;
                    //BPDrawing.drawWorldBlock(world,block,true,x,y,z,rendererColumn);
                case 8:
                    initCTMRenderer(world,x,y,z,renderer,rendererBP);
                    rendererBP.var = (BPCarvableVariation) var;
                    rendererBP.submap = var.submap;
                    rendererBP.submapSmall = var.submapSmall;
                    tes.field_78408_v += (double)x;
                    tes.field_78407_w += (double)y;
                    tes.field_78417_x += (double)z;

                    //call something like this if the function returns 1
                    //BPDrawing.drawWorldBlock(world,block,true,0,0,0,rendererCTM);

                    return 1;
                case BPCarverHelper.V9_CTM:
                case BPCarverHelper.V4_CTM:
                    initCTMRenderer(world,x,y,z,renderer,rendererBP);
                    rendererBP.var = (BPCarvableVariation) var;
                    tes.field_78408_v += (double)x;
                    tes.field_78407_w += (double)y;
                    tes.field_78417_x += (double)z;
                    rendererBP.w = var.kind== BPCarverHelper.V9_CTM?3:2;
                    rendererBP.h = rendererBP.w;
                    //call something like this if the function returns 3
                    //rendererBP.func_78578_a(block,x,y,z,1.0f,1.0f,1.0f);
                    return 3;
                default:
                    return 2;
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return 0;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return 0;
    }
}
