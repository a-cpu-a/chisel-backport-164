package com.cpu.chiselbp;

import com.cpu.chiselbp.bputils.Color3;
import net.minecraft.util.Icon;

public interface ILayeredBlock {

    Icon getItemUnderlayIcon(int metadata);
    Icon getItemOverlayIcon(int metadata);
    Icon getBlockUnderlay(int metadata);
    Color3 getUnderlayColor(int metadata);
    Color3 getOverlayColor(int metadata);
    int getEmissiveProps(int metadata);
}
