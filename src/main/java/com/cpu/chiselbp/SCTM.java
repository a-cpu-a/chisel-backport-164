package com.cpu.chiselbp;

import net.minecraft.world.IBlockAccess;

public class SCTM {

    public static boolean isConnected(IBlockAccess world, int x, int y, int z,int id,int meta)
    {
        int blockId = world.func_72798_a(x, y, z);
        int blockMetadata = world.func_72805_g(x, y, z);

        return blockId == id && blockMetadata == meta;
    }

    public static int getTexture(IBlockAccess world, int x, int y, int z, int side) {

        int id = world.func_72798_a(x, y, z);
        int meta = world.func_72805_g(x, y, z);

        int ret = 0;

        boolean xConnected = isConnected(world,x-1,y,z,id,meta) && isConnected(world,x+1,y,z,id,meta);
        boolean yConnected = isConnected(world,x,y-1,z,id,meta) && isConnected(world,x,y+1,z,id,meta);
        boolean zConnected = isConnected(world,x,y,z-1,id,meta) && isConnected(world,x,y,z+1,id,meta);

        switch (side)
        {
            case 4://-x
            case 5://+x
                if(zConnected&&yConnected)
                {
                    if(isConnected(world,x,y-1,z-1,id,meta)&&isConnected(world,x,y+1,z-1,id,meta)
                            &&isConnected(world,x,y-1,z+1,id,meta)&&isConnected(world,x,y+1,z+1,id,meta))
                        ret = 3;
                }
                else if(yConnected)
                    ret = 2;
                else if(zConnected)
                    ret = 1;

                break;
            case 0://-y
            case 1://+y
                if(zConnected&&xConnected)
                {
                    if(isConnected(world,x-1,y,z-1,id,meta)&&isConnected(world,x+1,y,z-1,id,meta)
                            &&isConnected(world,x-1,y,z+1,id,meta)&&isConnected(world,x+1,y,z+1,id,meta))
                        ret = 3;
                }
                else if(xConnected)
                    ret = 1;
                else if(zConnected)
                    ret = 2;

                break;
            case 2://-z
            case 3://+z
                if(yConnected&&xConnected)
                {
                    if(isConnected(world,x-1,y-1,z,id,meta)&&isConnected(world,x+1,y-1,z,id,meta)
                            &&isConnected(world,x-1,y+1,z,id,meta)&&isConnected(world,x+1,y+1,z,id,meta))
                        ret = 3;
                }
                else if(yConnected)
                    ret = 2;
                else if(xConnected)
                    ret = 1;

                break;
        }

        return ret;
    }
}
