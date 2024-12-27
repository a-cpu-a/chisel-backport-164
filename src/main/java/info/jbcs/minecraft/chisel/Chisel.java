package info.jbcs.minecraft.chisel;

import net.minecraft.block.Block;
import net.minecraft.src.StepSound;

public class Chisel {
    public static BlockMarble blockLimestone;
    public static BlockMarble blockNetherBrick;
    public static BlockMarble blockEmerald;
    public static BlockCloud blockCloud;
    public static BlockConcrete blockConcrete;
    public static BlockMarble blockLapis;
    public static BlockHolystone blockHolystone;
    public static BlockLavastone blockLavastone;
    public static BlockGlassCarvable blockGlass;

    public static StepSound soundMetalFootstep;


    public static boolean 					configExists;
    public static boolean 					overrideVanillaBlocks;
    public static boolean 					disableOverriding;
    public static boolean 					dropIceShards;
    public static boolean					oldPillars;
    public static boolean					disableCTM;
    public static double 					concreteVelocity;
    public static int						particlesTickrate;
    public static boolean 					blockDescriptions;
    public static BlockMarble blockCobblestone;
    public static BlockMarble stoneBrick;
    public static Chisel instance;
}
