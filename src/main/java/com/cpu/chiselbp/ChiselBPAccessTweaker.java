package com.cpu.chiselbp;

import cpw.mods.fml.common.asm.transformers.AccessTransformer;

import java.io.IOException;

public class ChiselBPAccessTweaker extends AccessTransformer {
    public ChiselBPAccessTweaker() throws IOException {
        super("chiselbp_at.cfg");
    }
}
