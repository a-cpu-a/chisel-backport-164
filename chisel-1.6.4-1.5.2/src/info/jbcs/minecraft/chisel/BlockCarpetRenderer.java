package info.jbcs.minecraft.chisel;

import cpw.mods.fml.client.registry.RenderingRegistry;


public class BlockCarpetRenderer extends BlockAdvancedMarbleRenderer {
	
	BlockCarpetRenderer(){
		super();
		
		Chisel.RenderCarpetId = RenderingRegistry.getNextAvailableRenderId();

		rendererCTM=new RenderBlocksCTMCarpet();
	}

	@Override
	public int getRenderId() {
		return Chisel.RenderCarpetId;
	}
}
