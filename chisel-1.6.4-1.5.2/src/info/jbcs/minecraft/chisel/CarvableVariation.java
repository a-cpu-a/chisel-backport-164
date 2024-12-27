package info.jbcs.minecraft.chisel;

import net.minecraft.src.Block;
import net.minecraft.util.Icon;

public class CarvableVariation {
	String					blockName;
	String					description;
	int						metadata;
	int						kind;

	Block					block;
	int						blockMeta;

	String					texture;

	Icon					icon;
	Icon					iconTop;
	Icon					iconBot;

	CarvableVariationCTM	ctm;
	TextureSubmap			seamsCtmVert;
	TextureSubmap			variations9;

	TextureSubmap			submap;
	TextureSubmap			submapSmall;

	static class CarvableVariationCTM {
		TextureSubmap	seams[]	= new TextureSubmap[3];
	}

}
