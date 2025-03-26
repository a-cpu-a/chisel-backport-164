package info.jbcs.minecraft.chisel;

import com.cpu.chiselbp.Utils;
import info.jbcs.minecraft.utilities.GeneralClient;
import net.minecraft.block.BlockPane;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import java.util.Iterator;

public class BPCarverHelper extends CarvableHelper {

    public static final int				R9  			= 9;
    public static final int				R4  			= 10;
    public static final int				V9_CTM  		= 11;
    public static final int				V4_CTM  		= 12;
    public static final int				R16  			= 13;
    public static final int				SCTM  			= 14;
    public static final int				ALT_R  			= 15; //-ar
    public static final int				V3_2  			= 16; //-v3x2

    public BPCarverHelper(){}

    public void addVariation(String description, int metadata, String texture, Block block, int blockMeta) {
        if (variations.size() > 15)
            return;

        if(blockName==null && block!=null) blockName=block.func_71931_t();
        else if(blockName==null && description!=null) blockName=description;

        CarvableVariation variation = new BPCarvableVariation();
        variation.description = description;
        variation.metadata = metadata;
        variation.blockName = blockName;

        if (texture != null) {
            variation.texture = texture;

            String path = "/assets/" + modName + "/textures/blocks/" + variation.texture;
            if(variation.texture.contains(":"))
            {
                int idx = variation.texture.indexOf(':');
                path = "/assets/" + variation.texture.substring(0,idx) + "/textures/blocks/" + variation.texture.substring(idx+1);
            }

            boolean any = Chisel.class.getResource(path + ".png") != null;
            boolean ctm3 = Chisel.class.getResource(path + "-ctm1.png") != null && Chisel.class.getResource(path + "-ctm2.png") != null && Chisel.class.getResource(path + "-ctm3.png") != null;
            boolean ctmv = Chisel.class.getResource(path + "-ctmv.png") != null;
            boolean ctmh = Chisel.class.getResource(path + "-ctmh.png") != null;
            boolean side = Chisel.class.getResource(path + "-side.png") != null;
            boolean top = Chisel.class.getResource(path + "-top.png") != null;
            boolean bot = Chisel.class.getResource(path + "-bottom.png") != null;
            boolean v9 = Chisel.class.getResource(path + "-v9.png") != null;
            boolean v9Ctm = Chisel.class.getResource(path + "-v9-ctm.png") != null;
            boolean v4 = Chisel.class.getResource(path + "-v4.png") != null;
            boolean v4Ctm = Chisel.class.getResource(path + "-v4-ctm.png") != null;
            boolean ctmx = Chisel.class.getResource(path + "-ctm.png") != null;
            boolean r16 = Chisel.class.getResource(path + "-r16.png") != null;
            boolean r9 = Chisel.class.getResource(path + "-r9.png") != null;
            boolean r4 = Chisel.class.getResource(path + "-r4.png") != null;
            boolean sctm = Chisel.class.getResource(path + "-ctms.png") != null;
            boolean ar = Chisel.class.getResource(path + "-ar.png") != null;
            boolean v3x2 = Chisel.class.getResource(path + "-v3x2.png") != null;

            if (ctm3) {
                variation.kind = 3;
            }else if (r16) {
                variation.kind = R16;
            } else if (v9) {
                if(any && v9Ctm && !Chisel.disableCTM)
                    variation.kind = V9_CTM;
                else
                    variation.kind = V9;
            }else if (r9) {
                variation.kind = R9;
            } else if (r4) {
                variation.kind = R4;
            } else if (v4) {
                if(any && v4Ctm && !Chisel.disableCTM)
                    variation.kind = V4_CTM;
                else
                    variation.kind = V4;
            }else if (sctm) {
                variation.kind = SCTM;
            }else if (ar) {
                variation.kind = ALT_R;
            } else if (ctmh && top) {
                variation.kind = CTMH;
            } else if (ctmv && top) {
                variation.kind = CTMV;
            }else if (v3x2) {
                variation.kind = V3_2;
            } else if (bot && top && side) {
                variation.kind = TOPBOTSIDE;
            } else if (top && side) {
                variation.kind = TOPSIDE;
            }  else if (any && ctmx && !Chisel.disableCTM) {
                variation.kind = CTMX;
            } else if (any) {
                variation.kind = NORMAL;
            } else {
                throw new RuntimeException("No valid textures found for chisel block variation '" + description + "' (" + variation.texture + ")");
            }
        } else {
            variation.block = block;
            variation.kind = 2;
            variation.blockMeta = blockMeta;
        }

        variations.add(variation);
        super.map[metadata] = variation;
    }

    public Icon getIcon(int side, int metadata) {
        Icon ret = super.getIcon(side,metadata);
        if(ret != GeneralClient.getMissingIcon())
            return ret;

        if (metadata < 0 || metadata > 15)
            metadata = 0;

        CarvableVariation variation = this.map[metadata];
        if (variation == null)
            return GeneralClient.getMissingIcon();

        switch(variation.kind) {
            case SCTM:
                return variation.submap.icons[0];
            case V9_CTM:
            case V4_CTM:
                return variation.icon;
            case V3_2:
                return variation.variations9.icons[1];
            case R9:
            case R16:
                return variation.variations9.icons[4];
            case R4:
                return variation.variations9.icons[0];
            case ALT_R:
                return variation.variations9.icons[0];
            default:
                return GeneralClient.getMissingIcon();
        }
    }

    public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side) {
        int metadata = world.func_72805_g(x, y, z);
        if (metadata < 0 || metadata > 15)
            metadata = 0;

        CarvableVariation variation = this.map[metadata];
        if (variation == null)
            return GeneralClient.getMissingIcon();


        switch(variation.kind) {
            case SCTM:
                return variation.submap.icons[com.cpu.chiselbp.SCTM.getTexture(world,x,y,z,side)];
            case V9:
            case V9_CTM:
                return variation.variations9.icons[Utils.xyzs2Idx(x,y,z,side,3,3)];
            case V3_2:
                return variation.variations9.icons[Utils.xyzs2Idx(x,y,z,side,3,2)];
            case V4:
            case V4_CTM:
                return variation.variations9.icons[Utils.xyzs2Idx(x,y,z,side,2,2)];
            case R9:
            case R16:
            case R4:
            case ALT_R:
                int index = x + y * 606731 + z * 571163 + side * 555491;

                index ^= index << 13;
                index ^= index >>> 17;
                index ^= index << 5;

                //todo: improve that rng (it does not work that well)

                //index >>>=3;//get higher bits

                if (index < 0) {
                    index = -index;
                }

                if(variation.kind==ALT_R)
                {
                    index%=2;
                    index<<=1;//mul 2

                    index += (x^y^z)&1;//first bit
                }

                return variation.variations9.icons[index % (variation.kind == R9 ? 9 : (variation.kind)==R16?16:4)];
        }

        return super.getBlockTexture(world, x, y, z, side);
    }

    public void registerIcons(String _modName, Block block, IconRegister register) {
        //super.registerIcons(_modName,block,register);
        Iterator i$ = this.variations.iterator();




/*
        Field[] arr = CarvableVariation.class.getDeclaredFields();
        System.out.print(arr.length+"\n");
        for (Field field : arr) {
            System.out.print(field.getName()+"\n");
        }*/


        String modName;

        while(i$.hasNext()) {
            BPCarvableVariation variation = (BPCarvableVariation) i$.next();




            if (variation.block != null) {
                variation.block.func_94332_a(register);

                if (variation.block instanceof BlockPane) {
                    variation.icon = variation.block.func_71851_a(2);
                    variation.iconTop = ((BlockPane) variation.block).func_72162_n();
                    variation.iconBot = ((BlockPane) variation.block).func_72162_n();
                } else {
                    switch (variation.kind) {
                        case 0:
                            variation.icon = variation.block.func_71858_a(2, variation.blockMeta);
                            break;
                        case 1:
                            variation.icon = variation.block.func_71858_a(2, variation.blockMeta);
                            variation.iconTop = variation.block.func_71858_a(0, variation.blockMeta);
                            break;
                        case 2:
                            variation.icon = variation.block.func_71858_a(2, variation.blockMeta);
                            variation.iconTop = variation.block.func_71858_a(1, variation.blockMeta);
                            variation.iconBot = variation.block.func_71858_a(0, variation.blockMeta);
                            break;
                    }
                }
            }
            else {

                if(variation.texture==null)return;

                if(variation.texture.contains(":"))
                    modName ="";
                else
                    modName = _modName+":";

                switch(variation.kind) {
                    case 0:
                        variation.icon = register.func_94245_a(modName + variation.texture);
                        break;
                    case 1:
                        variation.icon = register.func_94245_a(modName + variation.texture + "-side");
                        variation.iconTop = register.func_94245_a(modName + variation.texture + "-top");
                        break;
                    case 2:
                        variation.icon = register.func_94245_a(modName + variation.texture + "-side");
                        variation.iconTop = register.func_94245_a(modName + variation.texture + "-top");
                        variation.iconBot = register.func_94245_a(modName + variation.texture + "-bottom");
                        break;
                    case 3:
                        CarvableVariation.CarvableVariationCTM ctm=new CarvableVariation.CarvableVariationCTM();
                        ctm.seams[0]=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-ctm1"),4,4);
                        ctm.seams[1]=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-ctm2"),4,4);
                        ctm.seams[2]=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-ctm3"),4,4);
                        variation.ctm=ctm;
                        break;
                    case 4:
                        variation.seamsCtmVert=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-ctmv"),2,2);
                        variation.iconTop = register.func_94245_a(modName + variation.texture + "-top");
                        break;
                    case 5:
                        variation.seamsCtmVert=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-ctmh"),2,2);
                        variation.iconTop = register.func_94245_a(modName + variation.texture + "-top");
                        break;
                    case V9:
                        variation.variations9=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-v9"),3,3);
                        break;
                    case V4:
                        variation.variations9=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-v4"),2,2);
                        break;
                    case V3_2:
                        variation.variations9=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-v3x2"),3,3);
                        break;
                    case CTMX:
                        variation.icon=register.func_94245_a(modName + variation.texture);
                        variation.submap=new TextureSubmap(register.func_94245_a(modName + variation.texture+"-ctm"),4,4);
                        variation.submapSmall=new TextureSubmap(variation.icon,2,2);
                        break;

                    case SCTM:
                        variation.submap = new TextureSubmap(register.func_94245_a(modName + variation.texture + "-ctms"), 2, 2);
                        break;
                    case V4_CTM:
                        Icon v4Tex = register.func_94245_a(modName + variation.texture + "-v4");
                        variation.icon = register.func_94245_a(modName + variation.texture);
                        variation.variations9 = new TextureSubmap(v4Tex, 2, 2);
                        variation.submap = new TextureSubmap(register.func_94245_a(modName + variation.texture + "-v4-ctm"), 4*2, 4*2);
                        variation.submapSmall = new TextureSubmap(v4Tex, 2*2, 2*2);
                        variation.initV9Ctm(2,2);
                        break;
                    case V9_CTM:
                        Icon v9Tex = register.func_94245_a(modName + variation.texture + "-v9");
                        variation.icon = register.func_94245_a(modName + variation.texture);
                        variation.variations9 = new TextureSubmap(v9Tex, 3, 3);
                        variation.submap = new TextureSubmap(register.func_94245_a(modName + variation.texture + "-v9-ctm"), 4*3, 4*3);
                        variation.submapSmall = new TextureSubmap(v9Tex, 3*2, 3*2);
                        variation.initV9Ctm(3,3);
                        break;
                    case R16:
                        variation.variations9 = new TextureSubmap(register.func_94245_a(modName + variation.texture + "-r16"), 4, 4);
                        break;
                    case R9:
                        variation.variations9 = new TextureSubmap(register.func_94245_a(modName + variation.texture + "-r9"), 3, 3);
                        break;
                    case R4:
                        variation.variations9 = new TextureSubmap(register.func_94245_a(modName + variation.texture + "-r4"), 2, 2);
                        break;
                    case ALT_R:
                        variation.variations9 = new TextureSubmap(register.func_94245_a(modName + variation.texture + "-ar"), 2, 2);
                        break;
                }
            }
        }
    }
}
