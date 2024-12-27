package com.cpu.chiselbp.bputils;

public class Color3 {
    public static final Color3 WHITE = new Color3(1,1,1);
    public float r;
    public float g;
    public float b;
    public int cached;

    public Color3(double v, double v1, double v2) {
        r= (float) v;
        g= (float) v1;
        b= (float) v2;

        int re = 0;
        int gr = 0;
        int bl = 0;

        if(r>0.0)
        {
            if(r>1.0)
                re=255;
            else
                re = (int)(r*255.5);
        }
        if(g>0.0)
        {
            if(g>1.0)
                gr=255;
            else
                gr = (int)(g*255.5);
        }
        if(b>0.0)
        {
            if(b>1.0)
                bl=255;
            else
                bl = (int)(b*255.5);
        }

        cached |= re<<16;
        cached |= gr<<8;
        cached |= bl;
    }

    public int toInt() {

        return cached;

    }
}
