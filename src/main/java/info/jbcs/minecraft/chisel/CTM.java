package info.jbcs.minecraft.chisel;

import net.minecraft.world.IBlockAccess;

public class CTM {
	static int submaps[][]={
		{16,17,18,19},
		{16, 9,18,13},
		{ 8, 9,12,13},
		{ 8,17,12,19},
		{16, 9, 6,15},
		{ 8,17,14, 7},
		{ 2,11, 6,15},
		{ 8, 9,14,15},
		{10, 1,14,15},
		{10,11,14, 5},
		{ 0,11, 4,15},
		{ 0, 1,14,15},
		{},
		{},
		{},
		{},
		{16,17, 6, 7},
		{16, 9, 6, 5},
		{ 8, 9, 4, 5},
		{ 8,17, 4, 7},
		{ 2,11,18,13},
		{10, 3,12,19},
		{10,11,12,13},
		{10, 3,14, 7},
		{ 0,11,14,15},
		{10,11, 4,15},
		{10,11, 4, 5},
		{10, 1,14, 5},
		{},
		{},
		{},
		{},
		{ 2, 3, 6, 7},
		{ 2, 1, 6, 5},
		{ 0, 1, 4, 5},
		{ 0, 3, 4, 7},
		{ 2,11, 6, 5},
		{ 8, 9, 4,15},
		{ 2, 1, 6,15},
		{ 8, 9,14, 5},
		{ 0, 1, 4,15},
		{ 0, 1,14, 5},
		{10, 1, 4,15},
		{ 0,11,14, 5},
		{},
		{},
		{},
		{},
		{ 2, 3,18,19},
		{ 2, 1,18,13},
		{ 0, 1,12,13},
		{ 0, 3,12,19},
		{10, 1,12,13},
		{ 0, 3,14, 7},
		{ 0,11,12,13},
		{10, 3, 4, 7},
		{ 0,11, 4, 5},
		{10, 1, 4, 5},
		{10,11,14,15},
		{ 0, 1, 4, 5},
		{},
		{},
		{},
		{},
	};

    public static int[] getSubmapIndices(IBlockAccess world, int x, int y, int z, int side){
    	int index=getTexture(world,x,y,z,side);
    	
    	return submaps[index];
    }

	public static int getTexture(IBlockAccess world, int x, int y, int z, int side) {
		return 0;
	}

	private static boolean isConnected(IBlockAccess world, int x, int y, int z, int side,int id, int meta) {
		int x2=x,y2=y,z2=z;
		
		switch(side){
		case 0: y2--; break;
		case 1: y2++; break;
		case 2: z2--; break;
		case 3: z2++; break;
		case 4: x2--; break;
		case 5: x2++; break;
		}
		
		return false;
	}
		

}
