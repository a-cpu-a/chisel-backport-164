package info.jbcs.minecraft.chisel;

import net.minecraft.src.Block;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class ChiselModCompatibility {
	
	
	abstract class ClassCompat{
		Class cl;
		
		public ClassCompat(String name){
			try {
				if((cl = Class.forName(name))!=null)
					action();
			} catch (ClassNotFoundException e) {
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		abstract void action() throws Exception;
		
		abstract class BlockCompat{
			Block block;
			
			public BlockCompat(String variableName) throws Exception{
				block=(Block) ClassCompat.this.cl.getField(variableName).get(null);
				
				if(block!=null)
					action();
			}
			
			abstract void action() throws Exception;
		};
	};
	
	abstract class ClassBlockCompat{
		Block block;
		
		ClassBlockCompat(final String className,final String blockName){
			new ClassCompat(className){
				@Override void action() throws Exception {
					new BlockCompat(blockName){
						@Override void action() throws Exception {
							ClassBlockCompat.this.doAction(block);
						}
					};
				}
			};
		}

		void doAction(Block b){
			block=b;
			
			action();
		}
		
		abstract void action();
	}

	
	public void postInit(FMLPostInitializationEvent event) {
		new ClassBlockCompat("shukaro.artifice.ArtificeBlocks","blockMarble"){
			@Override void action(){
				Carving.chisel.addVariation("marble",block.blockID,0,99);
				MinecraftForge.setBlockHarvestLevel(block,0,"chisel",0);
			}
		};
		new ClassBlockCompat("num.numirp.block.ModBlocks","blockDecor"){
			@Override void action(){
				Carving.chisel.addVariation("marble",block.blockID,0,99);
				MinecraftForge.setBlockHarvestLevel(block,0,"chisel",0);
			}
		};				
		new ClassBlockCompat("mrtjp.projectred.ProjectRedExploration","blockStones"){
			@Override void action(){
				Carving.chisel.addVariation("marble",block.blockID,0,99);
				MinecraftForge.setBlockHarvestLevel(block,0,"chisel",0);
			}
		};
		
		new ClassBlockCompat("mariculture.core.Core","oreBlocks"){
			@Override void action(){
				Carving.chisel.addVariation("limestone",block.blockID,3,99);
				MinecraftForge.setBlockHarvestLevel(block,3,"chisel",0);
			}
		};
		new ClassBlockCompat("emasher.core.EmasherCore","limestone"){
			@Override void action(){
				Carving.chisel.addVariation("limestone",block.blockID,0,99);
				MinecraftForge.setBlockHarvestLevel(block,0,"chisel",0);
			}
		};

		new ClassCompat("Reika.GeoStrata.GeoStrata"){
			@Override void action() throws Exception {
				Block[] blocks=(Block[]) cl.getField("blocks").get(null);

				Carving.chisel.addVariation("marble",blocks[0].blockID,2,99);
				MinecraftForge.setBlockHarvestLevel(blocks[0],2,"chisel",0);
				
				Carving.chisel.addVariation("limestone",blocks[0].blockID,3,99);
				MinecraftForge.setBlockHarvestLevel(blocks[0],3,"chisel",0);
			}
		};
	}
	
}
