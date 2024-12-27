package info.jbcs.minecraft.chisel;

import info.jbcs.minecraft.chisel.CarvableVariation;
import info.jbcs.minecraft.chisel.TextureSubmap;
import net.minecraft.util.Icon;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class BPCarvableVariation extends CarvableVariation {
    public TextureSubmap[] v9CtmSubmaps;
    public TextureSubmap[] v9CtmSmallSubmaps;
    public int w = Integer.MIN_VALUE;
    public int h = Integer.MIN_VALUE;
    public boolean isV9Ctm;

    public void initV9Ctm(int w,int h)
    {
        this.w = w;
        this.h = h;
        this.isV9Ctm = true;

        v9CtmSubmaps = new TextureSubmap[w*h];
        v9CtmSmallSubmaps = new TextureSubmap[w*h];

        MinecraftForge.EVENT_BUS.register(this);
    }


    @ForgeSubscribe
    public void TexturesStitched(TextureStitchEvent.Post event) {

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                TextureSubmap map = v9CtmSmallSubmaps[x+y*w] = new TextureSubmap();
                map.width =2;
                map.height =2;
                map.icon = submapSmall.icon;
                map.icons = new Icon[2*2];
                for (int i = 0; i < map.icons.length; i++) {
                    map.icons[i] = submapSmall.icons[(x*2+(i%2)) + w*2*(y*2+(i/2))];
                }
                map = v9CtmSubmaps[x+y*w] = new TextureSubmap();
                map.width =4;
                map.height =4;
                map.icon = submap.icon;
                map.icons = new Icon[4*4];
                for (int i = 0; i < map.icons.length; i++) {
                    map.icons[i] = submap.icons[(x*4+(i%4)) + w*4*(y*4+(i/4))];
                }
            }
        }
    }
}
