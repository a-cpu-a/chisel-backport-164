package com.cpu.chiselbp;


import com.cpu.chiselbp.bputils.BPTransformerUtils;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.6.4")
//@IFMLLoadingPlugin.SortingIndex(1)
//@IFMLLoadingPlugin.TransformerExclusions({"com.cpu.","java.","net."})
public class ChiselBPCoreMod implements IFMLLoadingPlugin {

    @Override
    public String[] getLibraryRequestClass() {
        return new String[0];
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                //utils
                BPTransformerUtils.class.getName(),BPTransformerUtils.BPReplaceGetStatic.class.getName(),
                BPTransformerUtils.BPReplaceNew.class.getName(),BPTransformerUtils.BPRenameMethod.class.getName(),
                BPTransformerUtils.BPAddDefaultConstructor.class.getName(),

                ChiselBPAccessTweaker.class.getName(),ChiselBPTransformer.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {

    }
}
