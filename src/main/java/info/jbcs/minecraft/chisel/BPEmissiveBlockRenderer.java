package info.jbcs.minecraft.chisel;

import com.cpu.chiselbp.bputils.BPDrawing;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import info.jbcs.minecraft.utilities.Drawing;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

import static info.jbcs.minecraft.chisel.BPRenderingUtilsCTM.rendererBP;

public class BPEmissiveBlockRenderer implements ISimpleBlockRenderingHandler {
    public static int id;
    public BPEmissiveBlockRenderer(){
        id= RenderingRegistry.getNextAvailableRenderId();
    }
    static float bot=-0.001f,top=1.0f-bot;

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        BPRenderingUtilsCTM.renderInventoryBlockInit(block,metadata,renderer);

        GL11.glDisable(GL11.GL_LIGHTING);
        Drawing.drawBlock(block,metadata, renderer);
        GL11.glEnable(GL11.GL_LIGHTING);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        int action = BPRenderingUtilsCTM.renderWorldBlockInit(world,x,y,z,block,renderer);

        if(action==1)
            BPDrawing.drawWorldBlock(world,block,true,0,0,0, BPRenderingUtilsCTM.rendererBP);
        else if(action==2)
            BPDrawing.drawWorldBlock(world,block,true,x,y,z,renderer);
        else if(action==3)
            rendererBP.func_78578_a(block,x,y,z,1.0f,1.0f,1.0f);

        BPRenderingUtilsCTM.renderWorldBlockDone(action,world,x,y,z,block,renderer);


        return true;
        /*
        renderer.func_83020_a(bot, bot, bot, top, top, top);

        //boolean wasAOEnabled = renderer.field_78677_m;
        //renderer.field_78677_m = false;
        //renderer.func_78609_c(block, x, y, z,1.0f,1.0f,1.0f);
        //renderer.field_78677_m=wasAOEnabled;
        if(!(block instanceof Carvable))
        {
            BPDrawing.drawWorldBlock(world,block,true,x,y,z,renderer);
            return true;
        }

        Tessellator tes = Tessellator.field_78398_a;

        int metadata = world.func_72805_g(x,y,z);
        CarvableVariation var = ((Carvable)block).getVariation(metadata);
        try {

            switch(var == null ? 0 : var.kind) {
                case 4:
                    this.rendererColumn.field_78669_a = world;
                    this.rendererColumn.field_83026_h = 1.0D;
                    this.rendererColumn.field_83024_j = 1.0D;
                    this.rendererColumn.field_83022_l = 1.0D;
                    this.rendererColumn.submap = var.seamsCtmVert;
                    this.rendererColumn.iconTop = var.iconTop;
                    //return this.rendererColumn.func_78570_q(block, x, y, z);
                    BPDrawing.drawWorldBlock(world,block,true,x,y,z,rendererColumn);
                case 8:
                    this.rendererCTM.field_78669_a = world;
                    this.rendererCTM.field_83026_h = 1.0D;
                    this.rendererCTM.field_83024_j = 1.0D;
                    this.rendererCTM.field_83022_l = 1.0D;
                    this.rendererCTM.submap = var.submap;
                    this.rendererCTM.submapSmall = var.submapSmall;
                    this.rendererCTM.rendererOld = renderer;
                    this.rendererCTM.func_78570_q(block, x, y, z);
                    rendererCTM.bx = x;
                    rendererCTM.by = y;
                    rendererCTM.bz = z;
                    rendererCTM.tessellator = Tessellator.field_78398_a;
                    rendererCTM.tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
                    Tessellator var10000 = rendererCTM.tessellator;
                    var10000.field_78408_v += (double)x;
                    var10000 = rendererCTM.tessellator;
                    var10000.field_78407_w += (double)y;
                    var10000 = rendererCTM.tessellator;
                    var10000.field_78417_x += (double)z;*/
                    /*Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                    IMPL_LOOKUP.setAccessible(true);
                    MethodHandles.Lookup lkp = (MethodHandles.Lookup) IMPL_LOOKUP.get(null);
                    MethodHandle h1 = lkp.findSpecial(RenderBlocks.class, "func_78570_q", MethodType.methodType(boolean.class, Block.class, int.class, int.class, int.class), RenderBlocksCTM.class);
                    boolean res = (boolean) h1.invoke(this.rendererCTM,block,x,y,z);*/
                    //boolean res = rendererCTM.func_78609_c(block,x,y,z,1.0f,1.0f,1.0f);
                    /*BPDrawing.drawWorldBlock(world,block,true,0,0,0,rendererCTM);
                    //boolean res = super.func_78570_q(block, x, y, z);
                    var10000 = rendererCTM.tessellator;
                    var10000.field_78408_v -= (double)x;
                    var10000 = rendererCTM.tessellator;
                    var10000.field_78407_w -= (double)y;
                    var10000 = rendererCTM.tessellator;
                    var10000.field_78417_x -= (double)z;
                    //BPDrawing.drawWorldBlock(world,block,true,x,y,z,rendererCTM);
                    
                    break;
                default:
                    BPDrawing.drawWorldBlock(world,block,true,x,y,z,renderer);
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return true;*/
    }


    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }
    @Override
    public int getRenderId() {
        return id;
    }
}
