package info.jbcs.minecraft.chisel;

import net.minecraft.src.Block;
import net.minecraft.util.Icon;

public class RenderBlocksCTMCarpet extends RenderBlocksCTM {
	RenderBlocksCTMCarpet(){
		super();		
	}
	
	@Override
	void resetVertices(){
		super.resetVertices();
		
		for(int i=0;i<Y.length;i++){
			Y[i]/=16;
		}
	}
	

	@Override
	public void renderFaceXNeg(Block block, double x, double y, double z, Icon icon){
		rendererOld.renderFaceXNeg(block,0,0,0,submapSmall.icon);
    }
	
	@Override
	public void renderFaceXPos(Block block, double x, double y, double z, Icon icon){
		rendererOld.renderFaceXPos(block,0,0,0,submapSmall.icon);
    }

	@Override
	public void renderFaceZNeg(Block block, double x, double y, double z, Icon icon){
		rendererOld.renderFaceZNeg(block,0,0,0,submapSmall.icon);
    }
	
	@Override
	public void renderFaceZPos(Block block, double x, double y, double z, Icon icon){
		rendererOld.renderFaceZPos(block,0,0,0,submapSmall.icon);
    }

}
