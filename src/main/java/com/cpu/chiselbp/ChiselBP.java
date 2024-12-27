package com.cpu.chiselbp;

import com.cpu.chiselbp.compat.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import info.jbcs.minecraft.chisel.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


//https://gist.github.com/Xyene/4615933
/*


TODO list

rest of blocks

separate glass chiseling?


ice pillar extensions (replacements?)
warning


redstone lamp (chrono lamps?)
pumpkin
eye stuff (thaumium, gold)

manasteel block recipe (maybe port botania texture? )
-v3x2
metal eyes
gold eye
certus quartz (dont forget existing chisel stuffs)

fix snakestone : MinecraftForge.setBlockHarvestLevel(Block.planks, i, "chisel", 0);
fix braced planks

* */

@Mod(modid = "chiselbp", name = "ChiselBP", version = "1.0.0", dependencies = "required-after:Chisel")
@NetworkMod(clientSideRequired = true,serverSideRequired = true)
public class ChiselBP {

    public static BlockMarble				blockWoolenClay;
    public static BlockMarble				blockNetherBrick;
    public static BlockMarble				blockFactory;
    public static BlockMarble				blockColoredSand;
    public static BlockMarble				blockCalcareousSandstone;
    public static BlockDyeableGlowingOverlay blockHexPlating;
    public static BlockPoweredMarble    	blockRedstone;
    public static BlockConcrete				blockReinforcedConcrete;
    public static BlockEmissive				blockAntiBlock;
    public static BlockGlassCarvable		blockGlass;
    public static BlockMarble blockBrick;
    public static BlockMarble blockEndStone;
    public static BlockMarble blockEndStone2;
    public static BlockMarble blockValentines;
    public static BlockMarble blockFantasy;
    public static BlockMarble blockMilitary;
    public static BlockMarble blockVoidStone;
    public static BlockMarble blockVoidStone2;
    public static BlockEnergizedVoidstone blockEnergizedVoidStone;
    public static BlockGrimstone blockGrimstone;
    public static BlockGrimstone blockGrimstone2;
    public static BlockMarble blockQuartz;
    public static BlockMarble blockStoneBricks;
    public static BlockMarble blockLab;
    public static BlockLeaves blockLeaves;
    public static BlockMarble blockTerraSteel;
    public static BlockMarble blockManasteel;
    public static BlockMarble blockElementium;
    public static BlockMarble blockLivingstone;
    public static BlockMarble blockArcane;
    public static BlockGlowingArcaneRune blockArcaneRune;
    public static BlockMarble blockFutura;
    public static BlockDyeableGlowingOverlay blockFuturaCircuit;
    public static BlockMarble blockTechnical;
    public static BlockMarble blockTechnical2;
    public static BlockMarble blockTechnical3;
    public static BlockGlassCarvable blockDyedGlass;
    public static BlockGlassCarvable blockDyedBubbleGlass;
    public static BlockGlassCarvable blockDyedForestryGlass;
    public static BlockGlassCarvable blockDyedPanelGlass;
    public static BlockGlassCarvable blockDyedFancyPanelGlass;
    public static BlockGlassCarvable blockDyedTransparentGlass;
    public static BlockMarble blockTallow;
    public static BlockMazestone blockMazestone;
    public static BlockAmber blockAmber;
    public static BlockMarble blockPurpur;
    public static BlockMarble blockDiorite;
    public static BlockMarble blockAndesite;
    public static BlockMarble blockGranite;
    public static BlockMarble blockPrismarine;
    public static BlockMarble blockDarkstone;
    public static BlockOverlay blockWaterstone;
    public static BPBlockSlabCarvable blockDarkstoneSlab;

    public static BlockMarble blockBloodstone;
    public static BPBlockSlabCarvable blockBloodstoneSlab;

    public static BlockMarble blockYellowstone;
    public static BPBlockSlabCarvable blockYellowstoneSlab;

    public static BlockMarble blockCubit;
    public static BlockEmissive blockNeonite;
    public static BlockMarble blockNuCrete;
    public static BlockMarble blockFrogLight;
    public static BlockMarble blockSveltstone;

    public static BlockMarble blockBrickM;
    public static BlockMarble blockBrickM2;

    public static BlockEmissive blockGlotek;


    public static BlockMarble blockOak;
    public static BlockMarble blockBirch;
    public static BlockMarble blockSpruce;
    public static BlockMarble blockJungle;
    public static BlockMarble blockDarkOak;
    public static BlockMarble blockAcacia;
    public static BlockMarble blockCrimson;

    public static BlockMarble blockOak2;
    public static BlockMarble blockBirch2;
    public static BlockMarble blockSpruce2;
    public static BlockMarble blockJungle2;
    public static BlockMarble blockDarkOak2;
    public static BlockMarble blockAcacia2;
    public static BlockMarble blockCrimson2;

    public static boolean 					configExists;

    static Configuration config;

    public static int DFLT_ID_WOOLEN_CLAY = 2846;
    public static int DFLT_ID_CONCRETE = 2847;
    public static int DFLT_ID_COLORED_SAND = 2848;
    public static int DFLT_ID_REDSTONE = 2849;
    public static int DFLT_ID_CALCAREOUS_SANDSTONE = 2850;
    public static int DFLT_ID_HEX_PLATING = 2851;
    public static int DFLT_ID_ANTI_BLOCK = 2852;
    public static int DFLT_ID_FACTORY = 2853;
    public static int DFLT_ID_GLASS = 2854;
    public static int DFLT_ID_NETHER_BRICK = 2855;
    public static int DFLT_ID_BRICK = 2856;
    public static int DFLT_ID_END_STONE = 2857;
    public static int DFLT_ID_END_STONE2 = 2858;
    public static int DFLT_ID_VALENTINES = 2859;
    public static int DFLT_ID_FANTASY = 2860;
    public static int DFLT_ID_GRIMSTONE = 2861;
    public static int DFLT_ID_GRIMSTONE2 = 2862;
    public static int DFLT_ID_VOIDSTONE = 2863;
    public static int DFLT_ID_VOIDSTONE2 = 2864;
    public static int DFLT_ID_ENERGIZED_VOIDSTONE = 2865;
    public static int DFLT_ID_MILITARY = 2866;
    public static int DFLT_ID_QUARTZ = 2867;
    public static int DFLT_ID_STONE_BRICKS = 2868;
    public static int DFLT_ID_LAB = 2869;
    public static int DFLT_ID_LEAVES = 2870;
    public static int DFLT_ID_TERRA_STEEL = 2871;
    public static int DFLT_ID_MANASTEEL = 2872;
    public static int DFLT_ID_ELEMENTIUM = 2873;
    public static int DFLT_ID_LIVINGSTONE = 2874;
    public static int DFLT_ID_METALS_START = 2875;
    public static int DFLT_ID_GOLD = 2875+14;
    public static int DFLT_ID_ARCANE = 2890;
    public static int DFLT_ID_ARCANE_RUNE = 2891;
    public static int DFLT_ID_FUTURA = 2892;
    public static int DFLT_ID_FUTURA_CIRCUIT = 2893;
    public static int DFLT_ID_TECHNICAL = 2894;
    public static int DFLT_ID_TECHNICAL2 = 2895;
    public static int DFLT_ID_TECHNICAL3 = 2896;
    public static int DFLT_ID_DYED_GLASS = 2897;
    public static int DFLT_ID_DYED_BUBBLE_GLASS = 2898;
    public static int DFLT_ID_DYED_FORESTRY_GLASS = 2899;
    public static int DFLT_ID_DYED_PANEL_GLASS = 2900;
    public static int DFLT_ID_DYED_FANCY_PANEL_GLASS = 2901;
    public static int DFLT_ID_DYED_TRANSPARENT_GLASS = 2902;
    public static int DFLT_ID_TALLOW = 2903;
    public static int DFLT_ID_MAZE_STONE= 2904;
    public static int DFLT_ID_AMBER = 2905;
    public static int DFLT_ID_PURPUR = 2906;
    public static int DFLT_ID_DIORITE = 2907;
    public static int DFLT_ID_ANDESITE = 2908;
    public static int DFLT_ID_GRANITE = 2909;
    public static int DFLT_ID_PRISMARINE = 2910;
    public static int DFLT_ID_DARKSTONE = 2911;
    public static int DFLT_ID_WATERSTONE = 2912;
    public static int DFLT_ID_DARKSTONE_SLAB = 2913;
    public static int DFLT_ID_DARKSTONE_SLAB_TOP = 2914;

    public static int DFLT_ID_BLOODSTONE = 2915;
    public static int DFLT_ID_BLOODSTONE_SLAB = 2916;
    public static int DFLT_ID_BLOODSTONE_SLAB_TOP = 2917;

    public static int DFLT_ID_YELLOWSTONE = 2918;
    public static int DFLT_ID_YELLOWSTONE_SLAB = 2919;
    public static int DFLT_ID_YELLOWSTONE_SLAB_TOP = 2920;

    public static int DFLT_ID_CUBIT = 2921;
    public static int DFLT_ID_NEONITE = 2922;
    public static int DFLT_ID_NUCRETE = 2923;
    public static int DFLT_ID_FROGLIGHT = 2924;
    public static int DFLT_ID_SVELTSTONE = 2925;

    public static int DFLT_ID_BRICK_M = 2926;
    public static int DFLT_ID_BRICK_M2 = 2927;

    public static int DFLT_ID_GLOTEK = 2928;


    public static int DFLT_ID_OAK_M = 2929;
    public static int DFLT_ID_BIRCH_M = 2930;
    public static int DFLT_ID_SPRUCE_M = 2931;
    public static int DFLT_ID_JUNGLE_M = 2932;
    public static int DFLT_ID_DARK_OAK_M = 2933;
    public static int DFLT_ID_ACACIA_M = 2934;
    public static int DFLT_ID_CRIMSON_M = 2935;

    public static int DFLT_ID_OAK_M2 = 2936;
    public static int DFLT_ID_BIRCH_M2 = 2937;
    public static int DFLT_ID_SPRUCE_M2 = 2938;
    public static int DFLT_ID_JUNGLE_M2 = 2939;
    public static int DFLT_ID_DARK_OAK_M2 = 2940;
    public static int DFLT_ID_ACACIA_M2 = 2941;
    public static int DFLT_ID_CRIMSON_M2 = 2942;


    public static boolean neiPlugin = true;

    @SidedProxy(clientSide="com.cpu.chiselbp.ChiselBPClient", serverSide ="com.cpu.chiselbp.ChiselBPServer" )
    public static Proxy proxy;


    @Mod.Instance("chiselbp")
    public static ChiselBP instance;

    public static int getBlock(String name, int id){
        return config.getBlock(name, id).getInt(id);
    }

    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent event) {
        File configFile=event.getSuggestedConfigurationFile();
        configExists=configFile.exists();
        config = new Configuration(configFile);
        config.load();
        proxy.preInit();
    }

    @Mod.Init
    public void init(FMLInitializationEvent event) throws IllegalAccessException, InvocationTargetException {

        proxy.init();

        neiPlugin = config.get("misc","neiPlugin",true).getBoolean(true);

        Field f = null;
        Field fOre = null;
        Field fGlass = null;
        Field crvMeta = null;
        Method register = null;
        try {
            f = BlockMarble.class.getDeclaredField("carverHelper");
            fOre = BlockMarbleTexturedOre.class.getDeclaredField("carverHelper");
            fGlass = BlockGlassCarvable.class.getDeclaredField("carverHelper");
            register = CarvableHelper.class.getDeclaredMethod("register", Block.class, String.class);
            register.setAccessible(true);
            crvMeta = CarvableVariation.class.getDeclaredField("blockMeta");
            crvMeta.setAccessible(true);
            fGlass.setAccessible(true);


            f.setAccessible(true);
            fOre.setAccessible(true);
            //((CarvableHelper)f.get(Chisel.blockConcrete)).addVariation("Concrete Test", 11, "concrete/default");

        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
            return;
        }

        Carving.chisel.registerOre("limestone", "limestone");

        {
            CarvableHelper ch = ((CarvableHelper)f.get(Chisel.blockConcrete));
            String name = "concrete";

            ExtensionUtilities.addVariation2Block("Asphalt V2","concrete/asphaltV2",11,ch,Chisel.blockConcrete,name);
            ExtensionUtilities.addVariation2Block("Cracked asphalt","concrete/asphaltCracks",12,ch,Chisel.blockConcrete,name);
            ExtensionUtilities.addVariation2Block("Weathered asphalt with cracks","concrete/asphaltCracksWeathered",13,ch,Chisel.blockConcrete,name);
            ExtensionUtilities.addVariation2Block("Weathered asphalt","concrete/asphaltWeathered",14,ch,Chisel.blockConcrete,name);
        }
        {
            blockReinforcedConcrete = new BlockConcrete(null,getBlock("smoothConcrete",DFLT_ID_CONCRETE));
            blockReinforcedConcrete.func_71884_a(Block.field_71976_h).func_71848_c(0.5F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockReinforcedConcrete));
            ch.addVariation("Concrete", 0, "concrete/concrete");
            ch.addVariation("Cracked concrete", 1, "concrete/concreteCracked");
            ch.addVariation("Weathered concrete", 2, "concrete/concreteWeathered");
            ch.addVariation("Damaged concrete", 3, "concrete/concreteDmg");
            ch.addVariation("Moldy concrete", 4, "concrete/concreteMoldy");
            ch.addVariation("Moldy cracked concrete", 5, "concrete/concreteMoldyCracked");
            ch.addVariation("Concrete with vines", 6, "concrete/concreteVines");
            ch.addVariation("Rough beveled concrete", 7, "technical/new/concrete/concreteBlocks");
            register.invoke(ch,blockReinforcedConcrete,"concrete");

            OreDictionary.registerOre("blockConcrete", blockReinforcedConcrete);
        }

        //blockWoolenClay.setHardness(3F).setResistance(5F);//.setStepSound(Block.soundClothFootstep);

        {
            blockWoolenClay = new WoolBlock(getBlock("woolenClay",DFLT_ID_WOOLEN_CLAY ));
            blockWoolenClay.func_71848_c(0.4f).func_71894_b(4.0f).func_71884_a(Block.field_71975_k);

            CarvableHelper ch = ((CarvableHelper)f.get(blockWoolenClay));
            for (int i = 0; i < Utils.colors.length; i++) {
                ch.setBlockName(Utils.textColors[i]+" Woolen Clay");
                ch.addVariation(Utils.textColors[i] + " woolen clay", i, "woolenClay/"+ Utils.colors[i]);
            }
            register.invoke(ch, blockWoolenClay, "blockWoolenClay");
            for (int i = 0; i < Utils.colors.length; i++) {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockWoolenClay, 8, i), "***", "*X*", "***", '*', new ItemStack(Block.field_72101_ab.field_71990_ca, 1,15-i), 'X', "itemClay"));
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockWoolenClay, 8, i), "***", "*X*", "***", '*', new ItemStack(Block.field_72101_ab.field_71990_ca, 1,15-i), 'X', new ItemStack(Item.field_77757_aI, 1)));
            }

        }
        {
            blockColoredSand = new BlockMarble(getBlock("coloredSand",DFLT_ID_COLORED_SAND),Material.field_76251_o);
            blockColoredSand.func_71848_c(0.5f).func_71894_b(4.0f).func_71884_a(Block.field_71972_l);

            CarvableHelper ch = ((CarvableHelper)f.get(blockColoredSand));
            for (int i = 0; i < Utils.colors.length; i++) {
                ch.setBlockName(Utils.textColors[i]+" Sand");
                ch.addVariation(  Utils.textColors[i] + " colored sand", i, "coloredSand/"+ Utils.colors[i]);
            }
            register.invoke(ch, blockColoredSand, "blockColoredSand");
            for (int i = 0; i < Utils.colors.length; i++) {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockColoredSand, 8, i), "***", "*X*", "***", '*', "sand", 'X', Utils.dyeOres[i]));
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockColoredSand, 8, i), "***", "*X*", "***", '*', new ItemStack(Block.field_71939_E, 1), 'X', Utils.dyeOres[i]));

                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockColoredSand, 8, i), "***", "*X*", "***", '*', "sand", 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,i)));
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockColoredSand, 8, i), "***", "*X*", "***", '*', new ItemStack(Block.field_71939_E, 1), 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,i)));
            }

        }
        {
            CarvableHelper ch = ((CarvableHelper)f.get(Chisel.blockEmerald));
            String name = "emerald";

            ExtensionUtilities.addVariation2Block("Emerald circles","emerald/emeraldCircle",12,ch,Chisel.blockEmerald,name);
            ExtensionUtilities.addVariation2Block("Prismatic emeralds","emerald/emeraldPrismatic",13,ch,Chisel.blockEmerald,name);
            ExtensionUtilities.addVariation2Block("Emerald masonry","emerald/masonryEmerald",14,ch,Chisel.blockEmerald,name);
        }
        {
            blockRedstone = new BlockPoweredMarble(getBlock("redstoneBlock",DFLT_ID_REDSTONE),Material.field_76246_e);
            blockRedstone.func_71848_c(5.0F).func_71894_b(10.0F).func_71884_a(Block.field_71977_i);


            CarvableHelper ch = ((CarvableHelper)f.get(blockRedstone));
            ch.addVariation("Redstone masonry", 0, "redstone/masonryRedstone");
            register.invoke(ch,blockRedstone,"blockRedstone");

            LanguageRegistry.addName(new ItemStack(blockRedstone.field_71990_ca, 1, 0), Block.field_94341_cq.func_71931_t());
            OreDictionary.registerOre("blockRedstone", blockRedstone);
        }
        {
            CarvableHelper ch = ((CarvableHelper)f.get(Chisel.blockCloud));
            String name = "blockCloud";

            ExtensionUtilities.addVariation2Block("Grid of clouds","cloud/grid",1,ch,Chisel.blockCloud,name);
            ExtensionUtilities.addVariation2Block("Large cloud bricks","cloud/large",2,ch,Chisel.blockCloud,name);
            ExtensionUtilities.addVariation2Block("Cloud bricks","cloud/small",3,ch,Chisel.blockCloud,name);
            ExtensionUtilities.addVariation2Block("Vertical cloud bricks","cloud/vertical",4,ch,Chisel.blockCloud,name);
        }
        {
            CarvableHelper ch = ((CarvableHelper)f.get(Chisel.blockLapis));
            String name = "lapis";

            ExtensionUtilities.addVariation2Block("Lapis masonry","lapis/masonryLapis",9,ch,Chisel.blockLapis,name);
        }
        {
            CarvableHelper ch = ((CarvableHelper)fOre.get(Chisel.blockLavastone));
            String name = "blockLavastone";

            ExtensionUtilities.addVariation2Block("Cracked dark lavastone","lavastone/dark",7,ch,Chisel.blockLavastone,name);
        }
        {
            blockCalcareousSandstone = new BlockMarble(getBlock("calcareousSandstoneBlock",DFLT_ID_CALCAREOUS_SANDSTONE));
            blockCalcareousSandstone.func_71884_a(Block.field_71976_h).func_71848_c(0.8F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockCalcareousSandstone));
            ch.setBlockName("Calcareous Sandstone");
            ch.addVariation("Smooth flat sandstone", 0, "sandstone/a0-sandstonepreview-smoothflat");
            ch.addVariation("Flat sandstone bricks", 1, "sandstone/terrain-sandstone-brickflat");
            ch.addVariation("Sandy cobblestone", 2, "sandstone/terrain-sandstone-cobble");
            ch.addVariation("Sandstone column", 3, "sandstone/terrain-sandstone-column");
            ch.addVariation("Faded sandstone", 4, "sandstone/terrain-sandstone-faded");
            ch.addVariation("Sandstone glyph", 5, "sandstone/terrain-sandstone-glyph");
            ch.addVariation("Smooth natural sandstone", 6, "sandstone/terrain-sandstone-naturalsmooth");
            register.invoke(ch,blockCalcareousSandstone,"sandstoneCalcareous");

            Carving.chisel.registerOre("sandstoneCalcareous", "blockSandstoneCalcareous");
            OreDictionary.registerOre("blockSandstoneCalcareous", blockCalcareousSandstone);
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockCalcareousSandstone, 9, 0), "***", "*X*", "***", '*', "blockSandstone", 'X', "blockLimestone"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockCalcareousSandstone, 9, 0), "***", "*X*", "***", '*', new ItemStack(Block.field_71957_Q, 1), 'X', "blockLimestone"));
        }
        {
            blockHexPlating = new BlockDyeableGlowingOverlay(getBlock("blockHexPlatingBlock",DFLT_ID_HEX_PLATING),
                    "chisel:animations/shroud", "chisel:hexPlating/hexBase",
                    "chisel:hexPlating/hexOverlay");
            blockHexPlating.func_71884_a(Block.field_71976_h).func_71848_c(2.0F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockHexPlating));
            ch.setBlockName("Hex Plating");
            for (int i = 0; i < 16; i++) {
                ch.setBlockName(Utils.textColors[i]+" Hex Plating");
                ch.addVariation("Hex plating with "+ Utils.textColors[i]+" filler", i, "hexPlating/hexNew");
            }
            register.invoke(ch,blockHexPlating,"hexPlating");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockHexPlating, 9, 0), "***", "*X*", "***", '*', "stone", 'X', "blockCoal"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockHexPlating, 9, 0), "***", "*X*", "***", '*', "stone", 'X', new ItemStack(Block.field_111034_cE, 1)));
        }
        {
            blockAntiBlock = new BlockEmissive(getBlock("blockAntiBlock",DFLT_ID_ANTI_BLOCK),Material.field_76248_c);
            blockAntiBlock.func_71884_a(Block.field_71976_h).func_71848_c(0.5F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockAntiBlock));
            for (int i = 0; i < 16; i++) {
                ch.setBlockName(Utils.textColors[i]+" Anti Block");
                ch.addVariation(Utils.textColors[i]+" anti block", i, "antiblock/"+ Utils.colorsNew[i]+"-antiBlock");
            }
            register.invoke(ch,blockAntiBlock,"antiBlock");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockAntiBlock, 8, 15), "***", "*X*", "***", '*', "stone", 'X', "dustGlowstone"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockAntiBlock, 8, 15), "***", "*X*", "***", '*', "stone", 'X', new ItemStack(Item.field_77751_aT, 1)));
        }
        {
            // blockFactory = (BlockMarble)(new BlockMarble("factory", 2843)).func_71848_c(2.0F).func_71894_b(10.0F).func_71884_a(soundMetalFootstep);

            blockFactory = new BlockMarble(getBlock("factoryBlock",DFLT_ID_FACTORY));
            blockFactory.func_71848_c(2.0F).func_71894_b(10.0F).func_71884_a(Chisel.soundMetalFootstep);

            CarvableHelper ch = ((CarvableHelper)f.get(blockFactory));
            ch.setBlockName("Factory Block");
            ch.addVariation("Blue frame", 0, "factory/frameblue");
            ch.addVariation("Ice ice ice", 1, "factory/iceiceice");
            ch.addVariation("Mosaic tiles", 2, "factory/tilemosaic");
            ch.addVariation("Blue wireframe", 3, "factory/wireframeblue");
            register.invoke(ch,blockFactory,"blockFactory");
        }
        {
            // blockFactory = (BlockMarble)(new BlockMarble("factory", 2843)).func_71848_c(2.0F).func_71894_b(10.0F).func_71884_a(soundMetalFootstep);

            blockGlass = new BlockGlassCarvable(getBlock("glassBlock",DFLT_ID_GLASS));
            blockGlass.func_71848_c(0.3F).func_71884_a(Block.field_71974_j);

            CarvableHelper ch = ((CarvableHelper)fGlass.get(blockGlass));
            ch.setBlockName("Glass");
            ch.addVariation("Chrono", 0, "glass/chrono");
            register.invoke(ch,blockGlass,"glass");
        }
        {
            // blockFactory = (BlockMarble)(new BlockMarble("factory", 2843)).func_71848_c(2.0F).func_71894_b(10.0F).func_71884_a(soundMetalFootstep);

            blockNetherBrick = new BlockMarble(getBlock("blockNetherBrick",DFLT_ID_NETHER_BRICK));
            blockNetherBrick.func_71848_c(2.0F).func_71894_b(10.0F).func_71884_a(Block.field_71976_h);

            CarvableHelper ch = ((CarvableHelper)f.get(blockNetherBrick));
            ch.setBlockName("Nether Brick");
            ch.addVariation("Fancy nether bricks", 0, "netherbrick/netherFancyBricks");
            register.invoke(ch,blockNetherBrick,"netherBrick");
        }
        {
            CarvableHelper ch = ((CarvableHelper)f.get(Chisel.blockHolystone));
            String name = "blockHolystone";

            ExtensionUtilities.addVariation2Block("Chunks of holystone","holystone/chunks",14,ch,Chisel.blockHolystone,name);
            ExtensionUtilities.addVariation2Block("Holystone tiles","holystone/tiles",15,ch,Chisel.blockHolystone,name);
        }
        {
            blockBrick = new BlockMarble(this.getBlock("blockBrick",DFLT_ID_BRICK));
            blockBrick.func_71848_c(2.0F).func_71894_b(6.0F).func_71884_a(Block.field_71976_h);
            CarvableHelper ch = ((CarvableHelper)f.get(blockBrick));
            ch.addVariation("Bricks", 0, Block.field_72081_al);
            ch.addVariation("Aged bricks", 1, "brickCustom/aged");
            ch.addVariation("Large bricks", 2, "brickCustom/large");
            ch.addVariation("Mortarless bricks", 3, "brickCustom/mortarless");
            ch.addVariation("Varied bricks", 4, "brickCustom/varied");
            ch.addVariation("Yellow bricks", 5, "brickCustom/yellow");

            ch.addVariation("Zagged bricks", 6, "bricks/zag");

            register.invoke(ch,blockBrick, "brick");
            Carving.chisel.registerOre("brick", "blockBrick");
        }
        {
            blockEndStone = new BlockMarble(this.getBlock("blockEndStone",DFLT_ID_END_STONE));
            blockEndStone.func_71848_c(3.0F).func_71894_b(9.0F).func_71884_a(Block.field_71976_h);
            CarvableHelper ch = ((CarvableHelper)f.get(blockEndStone));
            ch.addVariation("End Stone", 0, Block.field_72082_bJ);
            ch.addVariation("Arcane end stone", 1, "endstone/arcaneEndStone");
            ch.addVariation("Chaotic end stone bricks", 2, "endstone/chaoticBricks");
            ch.addVariation("Checkered end stone tiles", 3, "endstone/CheckeredTile");
            ch.addVariation("End stone bricks", 4, "endstone/end_bricks");
            ch.addVariation("Ender circuit", 5, "endstone/enderCircuit");
            ch.addVariation("End stone masonry", 6, "endstone/masonryEnder");
            ch.addVariation("Prismic end stone", 7, "endstone/prismaticEndStone");
            ch.addVariation("French end stone bricks", 8, "endstone/endFrenchBricks");
            ch.addVariation("End stone pillar", 9, "endstone/endPillar");
            ch.addVariation("Prismatic end stone", 10, "endstone/endPrismatic");
            ch.addVariation("End stone chunks", 11, "endstone/endStoneChunk");
            ch.addVariation("Etched end stone", 12, "endstone/endStoneEtched");
            ch.addVariation("Large end stone tile", 13, "endstone/endStoneLargeTile");
            ch.addVariation("Ornate end stone", 14, "endstone/endStoneOrnate");
            ch.addVariation("Framed end stone", 15, "endstone/framedEndStone");
            register.invoke(ch,blockEndStone, "endStone");
            Carving.chisel.registerOre("endStone", "blockStoneWhite");
            Carving.chisel.registerOre("endStone", "stoneWhite");
            Carving.chisel.registerOre("endStone", "blockStoneEnd");
            Carving.chisel.registerOre("endStone", "stoneEnd");

            ch.addVariation("End stone masonry", 0, "endstone/masonryEnder");
            ch.addVariation("Prismic end stone", 1, "endstone/prismaticEndStone");
        }
        {
            blockEndStone2 = new BlockMarble(this.getBlock("blockEndStone2",DFLT_ID_END_STONE2));
            blockEndStone2.func_71848_c(3.0F).func_71894_b(9.0F).func_71884_a(Block.field_71976_h);
            CarvableHelper ch = ((CarvableHelper)f.get(blockEndStone2));
            ch.setBlockName("End Stone");
            ch.addVariation("Diagonal end stone bricks", 0, "endstone/enderDiagonalBrick");
            ch.addVariation("Ender frame", 1, "endstone/EnderFrame");
            ExtensionUtilities.registerDupe(ch,blockEndStone2, "endStone","endStone2");
        }
        {
            blockValentines = new BlockMarble(getBlock("blockValentines",DFLT_ID_VALENTINES));
            blockValentines.func_71884_a(Block.field_71976_h).func_71848_c(1.5F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockValentines));
            ch.setBlockName("Valentines Block");
            ch.addVariation("Pink square", 0, "valentines/1");
            ch.addVariation("Cobblestone with a heart", 1, "valentines/2");
            ch.addVariation("Pink cobblestone with a heart", 2, "valentines/3");
            ch.addVariation("Cobblestone with a pink heart", 3, "valentines/4");
            ch.addVariation("Large tile", 4, "valentines/5");
            ch.addVariation("Pink cobblestone", 5, "valentines/6");
            ch.addVariation("Grid", 6, "valentines/7");
            ch.addVariation("Flame", 7, "valentines/8");
            ch.addVariation("Large bumpy tile", 8, "valentines/9");
            ch.addVariation("Companion cube", 9, "valentines/companion");
            register.invoke(ch,blockValentines,"blockValentines");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockValentines, 8, 0), "***", "*X*", "***", '*', "stone", 'X', "dyeMagenta"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockValentines, 8, 0), "***", "*X*", "***", '*', "stone", 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,9)));
        }
        {
            blockFantasy = new BlockMarble(getBlock("blockFantasy",DFLT_ID_FANTASY),Material.field_76246_e);
            blockFantasy.func_71848_c(2.0F).func_71894_b(10.0F);

            CarvableHelper ch = ((CarvableHelper)f.get(blockFantasy));
            ch.setBlockName("Fantasy Block");
            ch.addVariation("Fantasy gold border", 0, "fft/pillar+");
            register.invoke(ch,blockFantasy,"blockFft");
        }
        {
            blockGrimstone = new BlockGrimstone(getBlock("blockGrimstone",DFLT_ID_GRIMSTONE),Material.field_76246_e);
            blockGrimstone.func_71884_a(Block.field_71976_h).func_71848_c(1.5F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockGrimstone));
            ch.setBlockName("Grimstone");
            ch.addVariation("Grimstone", 0, "grimstone/grimstone");
            ch.addVariation("Grimstone blocks", 1, "grimstone/blocks");
            ch.addVariation("Rough grimstone blocks", 2, "grimstone/blocks-rough");
            ch.addVariation("Grimstone bricks", 3, "grimstone/brick");
            ch.addVariation("Chiseled grimstone", 4, "grimstone/chiseled");
            ch.addVariation("Grimstone chunks", 5, "grimstone/chunks");
            ch.addVariation("Fancy grimstone construction", 6, "grimstone/construction");
            ch.addVariation("Fancy grimstone tiles", 7, "grimstone/fancy-tiles");
            ch.addVariation("Flaky grimstone", 8, "grimstone/flaky");
            ch.addVariation("Mysterious grimstone symbol", 9, "grimstone/hate");
            ch.addVariation("Large grimstone bricks", 10, "grimstone/largebricks");
            ch.addVariation("Smooth grimstone plate", 11, "grimstone/plate");
            ch.addVariation("Rough grimstone plate", 12, "grimstone/plate-rough");
            ch.addVariation("Grimstone platform", 13, "grimstone/platform");
            ch.addVariation("Grimstone platform tiles", 14, "grimstone/platform-tiles");
            ch.addVariation("Smooth grimstone", 15, "grimstone/smooth");
            register.invoke(ch,blockGrimstone,"grimstone");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockGrimstone, 8, 0), "***", "*X*", "***", '*', "stone", 'X', "itemCoal"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockGrimstone, 8, 0), "***", "*X*", "***", '*', "stone", 'X', new ItemStack(Item.field_77705_m, 1)));
        }
        {
            blockGrimstone2 = new BlockGrimstone(getBlock("blockGrimstone2",DFLT_ID_GRIMSTONE2),Material.field_76246_e);
            blockGrimstone2.func_71884_a(Block.field_71976_h).func_71848_c(1.5F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockGrimstone2));
            ch.setBlockName("Grimstone");
            ch.addVariation("Grimstone tiles", 0, "grimstone/tiles");
            //register.invoke(ch,blockGrimstone,"blockGrimstone");
            ExtensionUtilities.registerDupe(ch,blockGrimstone2,"grimstone","grimstone2");
        }
        {
            blockVoidStone = new BlockMarble(getBlock("blockVoidStone",DFLT_ID_VOIDSTONE));
            blockVoidStone.func_71884_a(Block.field_71976_h).func_71848_c(1.5F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockVoidStone));
            ch.setBlockName("Voidstone");
            ch.addVariation("Raw voidstone", 0, "voidstone/raw");
            ch.addVariation("Beveled voidstone", 1, "voidstone/bevel");
            ch.addVariation("Mysterious eye", 2, "voidstone/eye");
            ch.addVariation("Voidstone with a metal border", 3, "voidstone/metalborder");
            ch.addVariation("Voidstone pillar", 4, "voidstone/pillar");
            ch.addVariation("Voidstone quarters", 5, "voidstone/quarters");
            ch.addVariation("Voidstone skulls", 6, "voidstone/skulls");
            ch.addVariation("Smooth voidstone", 7, "voidstone/smooth");
            ch.setBlockName("White Voidstone Rune");
            ch.addVariation("White voidstone rune", 8, "voidstone/rune");
            register.invoke(ch,blockVoidStone,"voidStone");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockVoidStone, 8, 0), "Z*Z", "*X*", "Z*Z", '*', "stone", 'X', "itemEnderPearl",'Z',"blockObsidian"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockVoidStone, 8, 0), "Z*Z", "*X*", "Z*Z", '*', "stone", 'X', new ItemStack(Item.field_77730_bn, 1),'Z',new ItemStack(Block.field_72089_ap, 1)));
        }
        {
            blockVoidStone2 = new BlockMarble(getBlock("blockVoidStone2",DFLT_ID_VOIDSTONE2));
            blockVoidStone2.func_71884_a(Block.field_71976_h).func_71848_c(1.5F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockVoidStone2));
            for (int i = 0; i < 15; i++) {
                ch.setBlockName(Utils.textColors[i] +" Voidstone Rune");
                ch.addVariation(Utils.textColors[i] +" voidstone rune", i, "voidstone/runes/rune"+ Utils.colorsAlt[i]);
            }
            ExtensionUtilities.registerDupe(ch,blockVoidStone2,"voidStone","voidStone2");
        }
        {
            blockEnergizedVoidStone = new BlockEnergizedVoidstone(getBlock("blockEnergizedVoidStone",DFLT_ID_ENERGIZED_VOIDSTONE));
            blockEnergizedVoidStone.func_71884_a(Block.field_71976_h).func_71848_c(1.5F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockEnergizedVoidStone));
            ch.setBlockName("Energized Voidstone");
            ch.addVariation("Raw energized voidstone", 0, "voidstone/animated/raw");
            ch.addVariation("Beveled energized voidstone", 1, "voidstone/animated/bevel");
            ch.addVariation("Mysterious eye", 2, "voidstone/animated/eye");
            ch.addVariation("Energized voidstone with a metal border", 3, "voidstone/animated/metalborder");
            ch.addVariation("Energized voidstone pillar", 4, "voidstone/animated/pillar");
            ch.addVariation("Energized voidstone quarters", 5, "voidstone/animated/quarters");
            ch.addVariation("Energized voidstone skulls", 6, "voidstone/animated/skulls");
            ch.addVariation("Smooth energized voidstone", 7, "voidstone/animated/smooth");
            ch.addVariation("White energized voidstone rune", 8, "voidstone/animated/rune");
            register.invoke(ch,blockEnergizedVoidStone,"voidStoneEnergized");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockEnergizedVoidStone, 8, 0), "Z*Z", "*X*", "Z*Z", '*', "stone", 'X', "itemEyeEnder",'Z',"blockObsidian"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockEnergizedVoidStone, 8, 0), "Z*Z", "*X*", "Z*Z", '*', "stone", 'X', new ItemStack(Item.field_77748_bA, 1),'Z',new ItemStack(Block.field_72089_ap, 1)));

        }
        {
            blockMilitary = new BlockMarble(getBlock("blockMilitary",DFLT_ID_MILITARY));
            blockMilitary.func_71884_a(Block.field_71977_i).func_71848_c(2.0F).func_71894_b(15.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockMilitary));
            ch.setBlockName("Military Block");
            ch.addVariation("Military camo", 0, "military/imperialCamoSecluded");
            ch.addVariation("Orange military caution block", 1, "military/imperialCautionOrange");
            ch.addVariation("White military caution block", 2, "military/imperialCautionWhite");
            ch.addVariation("Military plates", 3, "military/imperialPlate");
            ch.addVariation("Rebel camo", 4, "military/rebelCamoSecluded");
            ch.addVariation("Red rebel caution block", 5, "military/rebelCautionRed");
            ch.addVariation("White rebel caution block", 6, "military/rebelCautionWhite");
            ch.addVariation("Rebel plates", 7, "military/rebelPlate");
            register.invoke(ch,blockMilitary,"militaryBlock");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockMilitary, 32, 0), "xyx", "yzy", "xyx", 'x', "stone",'y',"ingotIron",'z',"nuggetGold"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockMilitary, 32, 0), "xyx", "yzy", "xyx", 'x', "stone",'y',new ItemStack(Item.field_77703_o, 1),'z',new ItemStack(Item.field_77733_bq, 1)));

        }
        {
            blockQuartz = new BlockMarble(this.getBlock("blockQuartz",DFLT_ID_QUARTZ));
            blockQuartz.func_71848_c(0.8F).func_71894_b(0.8F).func_71884_a(Block.field_71976_h);
            CarvableHelper ch = ((CarvableHelper)f.get(blockQuartz));
            ch.setBlockName("Block of Quartz");
            ch.addVariation("Block of Quartz", 0, Block.field_94339_ct,0);
            ch.addVariation("Chiseled Quartz Block", 1, Block.field_94339_ct,1);
            ch.addVariation("Pillar Quartz Block", 2, Block.field_94339_ct,2);
            ch.addVariation("Quartz masonry", 0, "quartz/masonryQuartz");
            ch.addVariation("Quartz circles", 1, "quartz/quartzChiseled");
            ch.addVariation("Prismatic quartz", 2, "quartz/quartzPrismatic");
            ch.addVariation("Prismatic quartz pattern", 3, "quartz/quartzPrismaticPattern");
            register.invoke(ch,blockQuartz, "quartz");
            Carving.chisel.registerOre("quartz", "blockQuartz");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,0,"quartz");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,1,"quartz");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,2,"quartz");
        }
        {
            blockStoneBricks = new BlockMarble(this.getBlock("blockStoneBricks",DFLT_ID_STONE_BRICKS));
            blockStoneBricks.func_71848_c(1.5F).func_71894_b(10.0F).func_71884_a(Block.field_71976_h);
            CarvableHelper ch = ((CarvableHelper)f.get(blockStoneBricks));
            ch.setBlockName("Stone Bricks");
            ch.addVariation("Felsic brick masonry", 0, "stonebrick2/masonBricksFelsic");
            ch.addVariation("Mafic brick masonry", 1, "stonebrick2/masonBricksMafic");
            ch.addVariation("Mixed brick masonry", 2, "stonebrick2/masonBricksMixed");
            ch.addVariation("Plain brick masonry", 3, "stonebrick2/masonBricksPlain");
            ch.addVariation("Cold brick masonry", 4, "stonebrick2/masonry2Blue");
            ch.addVariation("Mixed masonry", 5, "stonebrick2/masonry2Both");
            ch.addVariation("Brick masonry", 6, "stonebrick2/masonry2Neutral");
            ch.addVariation("Warm brick masonry", 7, "stonebrick2/masonry2Red");
            ch.addVariation("Felsic masonry", 8, "stonebrick2/masonryFelsic");
            ch.addVariation("Mafic masonry", 9, "stonebrick2/masonryMafic");
            ch.addVariation("Mixed masonry", 10, "stonebrick2/masonryMixed");
            ch.addVariation("Plain masonry", 11, "stonebrick2/masonryPlain");
            register.invoke(ch,blockStoneBricks, "stoneBrick");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,0,"quartz");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,1,"quartz");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,2,"quartz");
        }
        {
            blockLab = new BlockMarble(getBlock("blockLab",DFLT_ID_LAB));
            blockLab.func_71884_a(Chisel.soundMetalFootstep).func_71848_c(2.0F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockLab));
            ch.setBlockName("Laboratory Block");
            ch.addVariation("Clear laboratory screen", 0, "laboratory/clearscreen");
            ch.addVariation("Checkered laboratory tiles", 1, "laboratory/checkertile");
            ch.addVariation("Blue arrow facing left", 2, "laboratory/directionleft");
            ch.addVariation("Blue arrow facing right", 3, "laboratory/directionright");
            ch.addVariation("Dotted laboratory panel", 4, "laboratory/dottedpanel");
            ch.addVariation("Laboratory wall vent", 5, "laboratory/wallvents");
            ch.addVariation("Laboratory floor tile", 6, "laboratory/floortile");
            ch.addVariation("Fuzzy laboratory screen", 7, "laboratory/fuzzscreen");
            ch.addVariation("Laboratory info console", 8, "laboratory/infocon");
            ch.addVariation("Large steel vent", 9, "laboratory/largesteel");
            ch.addVariation("Large laboratory tile", 10, "laboratory/largetile");
            ch.addVariation("Smooth laboratory wall", 11, "laboratory/largewall");
            ch.addVariation("Roundel laboratory wall", 12, "laboratory/roundel");
            ch.addVariation("Small steel vent", 13, "laboratory/smallsteel");
            ch.addVariation("Small laboratory tiles", 14, "laboratory/smalltile");
            ch.addVariation("Smooth laboratory panel", 15, "laboratory/wallpanel");
            register.invoke(ch,blockLab,"labBlock");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockLab, 32, 0), "***", "*X*", "***", '*', "stone", 'X', "itemQuartz"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockLab, 32, 0), "***", "*X*", "***", '*', "stone", 'X', new ItemStack(Item.field_94583_ca, 1)));
        }
        {
            blockLeaves = new BlockLeaves(this.getBlock("blockLeaves",DFLT_ID_LEAVES));
            blockLeaves.func_71848_c(0.2F).func_71894_b(0.2F).func_71884_a(Block.field_71965_g);
            CarvableHelper ch = ((CarvableHelper)f.get(blockLeaves));
            ch.setBlockName("Leaves");
            ch.addVariation("Oak leaves", 0, Block.field_71952_K,0);
            ch.addVariation("Oak leaves", 0, Block.field_71952_K,4);
            ch.addVariation("Oak leaves", 0, Block.field_71952_K,8);
            ch.addVariation("Oak leaves", 0, Block.field_71952_K,12);
            ch.addVariation("Christmas tree with bells", 0, "leaves/christmasBalls");
            ch.addVariation("Christmas tree with lights", 1, "leaves/christmasLights");
            ch.addVariation("Dead leaves", 2, "leaves/dead");
            ch.addVariation("Pink cherry tree leaves", 3, "leaves/pinkpetal");
            ch.addVariation("Rose bush leaves", 4, "leaves/red_roses");
            ch.addVariation("White bush leaves", 5, "leaves/roses");
            register.invoke(ch,blockLeaves, "leaves");
            Carving.chisel.registerOre("leaves", "treeLeaves");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,0,"quartz");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,1,"quartz");
            //ExtensionUtilities.addModBlock2Chisel(Block.field_94339_ct,2,"quartz");
        }
        blockTerraSteel = MetalUtils.createModMetal("blockTerraSteel",DFLT_ID_TERRA_STEEL,"terrasteel","Terrasteel","blockTerrasteel","elementiumEye");
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockTerraSteel, 32, 6), "*Z*", "ZXZ", "*Z*", '*', "stone", 'X', new ItemStack(Block.field_71980_u, 1),'Z',new ItemStack(Item.field_77703_o, 1)));

        blockManasteel = MetalUtils.createModMetal("blockManasteel",DFLT_ID_MANASTEEL,"manasteel","Manasteel","blockManasteel","elementiumEye");
        blockElementium = MetalUtils.createModMetal("blockElementium",DFLT_ID_ELEMENTIUM,"elementium","Elementium","blockElementium","elementiumEye");
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockElementium, 32, 6), "*Z*", "Z Z", "*Z*", '*', "dyeMagenta", 'Z',"ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockElementium, 32, 6), "*Z*", "Z Z", "*Z*", '*', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,13),'Z',new ItemStack(Item.field_77703_o, 1)));

        {
            blockLivingstone = new BlockMarble(ChiselBP.getBlock("blockLivingstone",DFLT_ID_LIVINGSTONE));
            blockLivingstone.func_71884_a(Block.field_71976_h).func_71848_c(1.5F).func_71894_b(6.0f);

            CarvableHelper ch = ((CarvableHelper)f.get(blockLivingstone));
            ch.setBlockName("Livingstone");
            ch.addVariation("Livingstone masonry", 0, "botania/livingrock/masonryLivingstone");

            register.invoke(ch,blockLivingstone,"livingstone");
            Carving.chisel.registerOre("livingstone", "blockLivingstone");
        }

        int nextMetalId = DFLT_ID_METALS_START;

        Metals.registerMetal("aluminum","Aluminum",nextMetalId++,"blockAluminum");
        Metals.registerMetal("bronze","Bronze",nextMetalId++,"blockBronze");
        Metals.registerMetal("cobalt","Cobalt",nextMetalId++,"blockCobalt");
        Metals.registerMetal("copper","Copper",nextMetalId++,"blockCopper");
        Metals.registerMetal("electrum","Electrum",nextMetalId++,"blockElectrum");
        Metals.registerMetal("invar","Invar",nextMetalId++,"blockInvar");
        Metals.registerMetal("nickel","Nickel",nextMetalId++,"blockNickel");
        Metals.registerMetal("platinum","Platinum",nextMetalId++,"blockPlatinum");
        Metals.registerMetal("silver","Silver",nextMetalId++,"blockSilver");
        Metals.registerMetal("steel","Steel",nextMetalId++,"blockSteel");
        Metals.registerMetal("tin","Tin",nextMetalId++,"blockTin");
        Metals.registerMetal("uranium","Uranium",nextMetalId++,"blockUranium");
        Metals.registerMetal("iron","Iron",nextMetalId++,"blockIron");
        System.out.println("BlockId after all chisel metals: "+nextMetalId+" aka gold block id");
        {
            BlockMarble block = new BlockMarble(ChiselBP.getBlock("blockGold",DFLT_ID_GOLD));
            block.func_71884_a(Block.field_71977_i).func_71848_c(2.0F).func_71894_b(15.0f);

            String folder = "metals/gold/";

            CarvableHelper ch = ((CarvableHelper)MetalUtils.f.get(block));
            ch.setBlockName("Gold Block");
            ch.addVariation("Bolted gold plates", 0, folder+"badGreggy");
            ch.addVariation("Bolted gold", 1, folder+"bolted");
            ch.addVariation("Gold caution block", 2, folder+"caution");
            ch.addVariation("Gold crate", 3, folder+"crate");
            ch.addVariation("Gold machine", 4, folder+"machine");
            ch.addVariation("Gold scaffolding", 5, folder+"scaffold");
            ch.addVariation("Thermal style block of gold", 6, folder+"thermal");
            //TODO: gold eye
            MetalUtils.register.invoke(ch,block,"gold");
        }
        {
            blockArcane = new BlockMarble(ChiselBP.getBlock("blockArcane",DFLT_ID_ARCANE));
            blockArcane.func_71884_a(Block.field_71976_h).func_71848_c(1.5F).func_71894_b(6.0f);

            CarvableHelper ch = ((CarvableHelper)f.get(blockArcane));
            ch.setBlockName("Arcane Stone");
            ch.addVariation("Arcane border", 0, "arcane/ArcaneBorder");
            ch.addVariation("Arcane crack", 1, "arcane/arcaneCrackAnim");
            ch.addVariation("Arcane brain matrix", 2, "arcane/arcaneMatrix");
            ch.addVariation("Large arcane tile", 3, "arcane/arcaneTile");
            ch.addVariation("Big arcane bricks", 4, "arcane/bigBrick");
            ch.addVariation("Arcane bordered brain", 5, "arcane/BorderBrain");
            ch.addVariation("Glowing arcane conduit", 6, "arcane/conduitGlowAnim");
            ch.addVariation("Arcane moon engravement", 7, "arcane/moonEngrave");
            ch.addVariation("Glowing arcane moon engravement", 8, "arcane/moonGlowAnim");
            ch.addVariation("Glowing arcane rune", 9, "arcane/runesGlow");
            ch.addVariation("Arcane rune", 10, "arcane/runes");
            ch.addVariation("Arcane engravement", 11, "arcane/thaumcraftLogo");

            register.invoke(ch,blockArcane,"arcane");
            Carving.chisel.registerOre("arcane", "blockStoneArcane");
        }
        {
            blockArcaneRune = new BlockGlowingArcaneRune(ChiselBP.getBlock("blockArcaneRune",DFLT_ID_ARCANE_RUNE));
            blockArcaneRune.func_71884_a(Block.field_71976_h).func_71848_c(1.5F).func_71894_b(6.0f);

            CarvableHelper ch = ((CarvableHelper)f.get(blockArcaneRune));
            for (int i = 0; i < 16; i++) {
                ch.setBlockName(Utils.textColors[i]+" Arcane Rune");
                ch.addVariation(Utils.textColors[i]+" arcane rune", i, "arcane/runesGlowOverlay");
                blockArcaneRune.underlayCH.addVariation("",i,"arcane/runesGlowBase");
            }

            ExtensionUtilities.registerDupe(ch,blockArcaneRune,"arcane","arcaneRune");
        }
        {
            blockFutura = new BlockMarble(getBlock("blockFutura",DFLT_ID_FUTURA));
            blockFutura.func_71884_a(Chisel.soundMetalFootstep).func_71848_c(2.0F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockFutura));
            ch.setBlockName("Futura Block");
            ch.addVariation("Futura controller", 0, "futura/controller");
            ch.addVariation("Futura unity controller", 1, "futura/controllerPurple");
            ch.addVariation("Cyan futura screen", 2, "futura/screenCyanWIP");
            ch.addVariation("Metallic futura screen", 3, "futura/screenMetallicWIP");
            ch.addVariation("Uber wavy futura block", 4, "futura/uberWavy");
            ch.addVariation("Wavy futura block", 5, "futura/wavyLine");
            register.invoke(ch,blockFutura,"futura");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockFutura, 16, 0), "*Z*", "ZXZ", "*Z*", 'Z',"bricksStone", '*', "stone", 'X', "dustRedstone"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockFutura, 16, 0), "*Z*", "ZXZ", "*Z*", '*', "stone",'Z',new ItemStack(Block.field_72007_bm,1), 'X', new ItemStack(Item.field_77767_aC, 1)));
        }
        {
            blockFuturaCircuit = new BlockDyeableGlowingOverlay(getBlock("blockFuturaCircuit",DFLT_ID_FUTURA_CIRCUIT),"chisel:animations/strobe");
            blockFuturaCircuit.func_71884_a(Chisel.soundMetalFootstep).func_71848_c(2.0F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockFuturaCircuit));
            ch.setBlockName("Futura Circuit");
            for (int i = 0; i < 16; i++) {
                ch.setBlockName(Utils.textColors[i]+" Futura Ciruit");
                ch.addVariation(Utils.textColors[i]+" futura circuit", i, "futura/circuitPlate");
            }
            ExtensionUtilities.registerDupe(ch,blockFuturaCircuit,"futura","futuraCircuit");
        }
        {
            blockTechnical = new BlockMarble(getBlock("blockTechnical", DFLT_ID_TECHNICAL));
            blockTechnical.func_71884_a(Block.field_71977_i).func_71848_c(2.0F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockTechnical));
            ch.setBlockName("Technical Block");
            ch.addVariation("Cables", 0, "technical/cables");
            ch.addVariation("Caution tape", 1, "technical/cautiontape");
            ch.addVariation("Fast fan", 2, "technical/fanFast");
            ch.addVariation("Malfunctioning fan with sparks", 3, "technical/fanMalfunction");
            ch.addVariation("Still fan", 4, "technical/fanStill");
            ch.addVariation("Iron grate", 5, "technical/grate");
            ch.addVariation("Rusty iron grate", 6, "technical/grateRusty");
            ch.addVariation("Hex armor plating", 7, "technical/hexArmorPlating");
            ch.addVariation("Industrial relic", 8, "technical/industrialrelic");
            ch.addVariation("Insulation", 9, "technical/insulationv2");
            ch.addVariation("Malfunctioning fan", 10, "technical/malfunctionFan");
            ch.addVariation("Massive fan", 11, "technical/massiveFan");
            ch.addVariation("Large pipes", 12, "technical/pipesLarge");
            ch.addVariation("Small pipes", 13, "technical/pipesSmall");
            ch.addVariation("Rusty bolted plates", 14, "technical/rustyBoltedPlates");
            ch.addVariation("Rusty cover", 15, "technical/rustyCover");
            register.invoke(ch, blockTechnical,"technical");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockTechnical, 32, 0), "*X*", "X*X", "*X*", '*', "stone", 'X', "ingotIron"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockTechnical, 32, 0), "*X*", "X*X", "*X*", '*', "stone", 'X', new ItemStack(Item.field_77703_o, 1)));
        }
        {
            blockTechnical2 = new BlockMarble(getBlock("blockTechnical2", DFLT_ID_TECHNICAL2));
            blockTechnical2.func_71884_a(Block.field_71977_i).func_71848_c(2.0F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockTechnical2));
            ch.setBlockName("Technical Block");
            ch.addVariation("Spinning gears", 0, "technical/spinningStuffAnim");
            ch.addVariation("Vent", 1, "technical/vent");
            ch.addVariation("Glowing vent", 2, "technical/ventGlowing");
            ch.addVariation("Wall pads", 3, "technical/wallPads");
            ch.addVariation("Wires", 4, "technical/wires");
            ch.addVariation("Steel engineering", 5, "technical/new/engineering");
            ch.addVariation("Steel exhaust plating", 6, "technical/new/ExhaustPlating");
            ch.addVariation("Makeshift panels", 7, "technical/new/MakeshiftPanels");
            ch.addVariation("MegaCell battery", 8, "technical/new/MegaCell");
            ch.addVariation("Spinning cassette", 9, "technical/new/OldeTimeyServerAnim");
            ch.addVariation("Piping", 10, "technical/new/Piping");
            ch.addVariation("Sturdy wall", 11, "technical/new/Sturdy");
            ch.addVariation("Tape drive", 12, "technical/new/TapeDrive");
            ch.addVariation("Weathered green panels", 13, "technical/new/weatheredGreenPanels");
            ch.addVariation("Weathered orange panels", 14, "technical/new/weatheredOrangePanels");
            ch.addVariation("Old mechanism", 15, "technical/old");
            ExtensionUtilities.registerDupe(ch,blockTechnical2,"technical","technical2");
       }
       {
            blockTechnical3 = new TransparentTechnicalBlock(getBlock("blockTechnical3", DFLT_ID_TECHNICAL3),Material.field_76248_c);
            blockTechnical3.func_71884_a(Block.field_71977_i).func_71848_c(0.3F).func_71894_b(5.0f).func_71868_h(1);


            CarvableHelper ch = ((CarvableHelper)f.get(blockTechnical3));
            ch.setBlockName("Technical Block");
            ch.addVariation("Fast transparent fan", 0, "technical/fanFastTransparent");
            ch.addVariation("Transparent fan", 1, "technical/fanStillTransparent");
            ch.addVariation("Scaffolding", 2, "technical/scaffold");
            ch.addVariation("Transparent scaffolding", 3, "technical/scaffoldTransparent");
            ch.addVariation("Large scaffolding", 4, "technical/new/scaffoldLarge");
            ExtensionUtilities.registerDupe(ch,blockTechnical3,"technical","technical3");
       }
        blockDyedBubbleGlass = GlassUtils.addGlassType("blockDyedBubbleGlass",DFLT_ID_DYED_BUBBLE_GLASS,"bubble","Bubble");
        blockDyedForestryGlass =  GlassUtils.addGlassType("blockDyedForestryGlass",DFLT_ID_DYED_FORESTRY_GLASS,"forestry","Forestry");
        blockDyedPanelGlass = GlassUtils.addGlassType("blockDyedPanelGlass",DFLT_ID_DYED_PANEL_GLASS,"panel","Panel");
        blockDyedFancyPanelGlass = GlassUtils.addGlassType("blockDyedFancyPanelGlass",DFLT_ID_DYED_FANCY_PANEL_GLASS,"panel-fancy","Fancy Panel");
        blockDyedTransparentGlass = GlassUtils.addGlassType("blockDyedTransparentGlass",DFLT_ID_DYED_TRANSPARENT_GLASS,"transparent","Transparent");
        blockDyedGlass = GlassUtils.addGlassType("blockDyedPlainGlass",DFLT_ID_DYED_GLASS,"plain","Plain");

        for (int i = 0; i < 16; i++) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDyedGlass, 8, i), "***", "*X*", "***", '*', new ItemStack(Block.field_71946_M, 1), 'X', Utils.dyeOres[i]));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDyedGlass, 8, i), "***", "*X*", "***", '*', "glass", 'X', Utils.dyeOres[i]));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDyedGlass, 8, i), "***", "*X*", "***", '*', new ItemStack(Block.field_71946_M, 1), 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,i)));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDyedGlass, 8, i), "***", "*X*", "***", '*', "glass", 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,i)));
        }

        {
            blockTallow = new BlockMarble(getBlock("blockTallow", DFLT_ID_TALLOW),Material.field_76248_c);
            blockTallow.func_71884_a(Block.field_71976_h).func_71848_c(0.3F).func_71894_b(5.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockTallow));
            ch.setBlockName("Tallow Block");
            ch.addVariation("Molded faces", 0, "tallow/faces");
            ch.addVariation("Smooth tallow", 1, "tallow/smooth");
            ch.addVariation("Block of tallow", 2, "tallow/tallowblock");
            register.invoke(ch, blockTallow,"tallow");
            Carving.chisel.registerOre("tallow", "blockTallow");
        }

        {
            blockMazestone = new BlockMazestone(getBlock("blockMazeStone", DFLT_ID_MAZE_STONE),Material.field_76246_e);
            blockMazestone.func_71848_c(100.0F).func_71894_b(5.0f).func_71884_a(Block.field_71976_h);


            CarvableHelper ch = ((CarvableHelper)f.get(blockMazestone));
            ch.setBlockName("Mazestone Block");
            ch.addVariation("Mazestone circles", 0, "mazestone/circular");
            ch.addVariation("Cobbled mazestone", 1, "mazestone/cobbled");
            ch.addVariation("Intricate mazestone engravings", 2, "mazestone/intricate");
            ch.addVariation("Mazestone masonry", 3, "mazestone/masonryMazestone");
            ch.addVariation("Diagonal mazestone bricks", 4, "mazestone/mazestoneDiagonals");
            ch.addVariation("Prismatic mazestone", 5, "mazestone/prismatic");
            ch.addVariation("Mazestone prims", 6, "mazestone/prismaticMazestone");
            register.invoke(ch, blockMazestone,"mazestone");
            Carving.chisel.registerOre("mazestone", "blockStoneMaze");
            Carving.chisel.registerOre("mazestone", "blockMazestone");
        }
        {
            blockAmber = new BlockAmber(getBlock("blockAmber", DFLT_ID_AMBER),Material.field_76246_e);
            blockAmber.func_71884_a(Block.field_71976_h).func_71848_c(1.5F).func_71894_b(5.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockAmber));
            ch.setBlockName("Amber Block");
            ch.addVariation("Amber block", 0, "amber/amberblock");
            register.invoke(ch, blockAmber,"amber");
            Carving.chisel.registerOre("amber", "blockAmber");
        }
        {
            blockPurpur = new BlockMarble(getBlock("blockPurpur",DFLT_ID_PURPUR));
            blockPurpur.func_71884_a(Block.field_71976_h).func_71848_c(6.0F).func_71894_b(1.5f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockPurpur));
            ch.setBlockName("Purpur Block");
            ch.addVariation("Arcane purpur", 0, "end_purpur/arcanePurpur");
            ch.addVariation("Bordered purpur bricks", 1, "end_purpur/borderPurpur");
            ch.addVariation("Purpur masonry", 2, "end_purpur/masonryPurpur");
            ch.addVariation("Prismatic purpur", 3, "end_purpur/prismaticPurpur");
            ch.addVariation("Purpur tiles", 4, "end_purpur/purpur_block");
            ch.addVariation("Purpur pillar", 5, "end_purpur/purpur_pillar");
            ch.addVariation("Purpur bricks", 6, "end_purpur/purpurBricks");
            ch.addVariation("Cobbled purpur", 7, "end_purpur/purpurCobble");
            ch.addVariation("Large purpur tiles", 8, "end_purpur/purpurLargeTile");
            ch.addVariation("Ornate purpur", 9, "end_purpur/purpurOrnate");
            ch.addVariation("Purpur prismarine", 10, "end_purpur/purpurPrismarine");
            ch.addVariation("Purpur shulker box", 11, "end_purpur/shulker");
            ch.addVariation("Small broken purpur tiles", 12, "end_purpur/tileBrokenPurpur");
            ch.addVariation("Small purpur tiles", 13, "end_purpur/tilePurpur");
            register.invoke(ch,blockPurpur,"purpur");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockPurpur, 8, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',"endStone", 'X', "dyeMagenta"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockPurpur, 8, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',"whiteStone", 'X', "dyeMagenta"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockPurpur, 8, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',new ItemStack(Block.field_72082_bJ,1), 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,13)));
        }
        {
            blockDiorite =RockUtils.registerRock("diorite","Diorite",DFLT_ID_DIORITE);

            OreDictionary.registerOre("diorite", blockDiorite);
            OreDictionary.registerOre("stoneDiorite", blockDiorite);
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDiorite, 2, 0),"XZ","ZX",'X',"cobblestone",'Z', "quartz"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDiorite, 2, 0), "XZ","ZX",'X',Block.field_71978_w,'Z',  Item.field_94583_ca));
        }
        {
            blockAndesite =RockUtils.registerRock("andesite","Andesite",DFLT_ID_ANDESITE);

            OreDictionary.registerOre("andesite", blockAndesite);
            OreDictionary.registerOre("stoneAndesite", blockAndesite);
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockAndesite, 2, 0),"cobblestone", "diorite"));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockAndesite, 2, 0),"cobblestone", "stoneDiorite"));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockAndesite, 2, 0), Block.field_71978_w,  blockDiorite));
        }
        {
            blockGranite =RockUtils.registerRock("granite","Granite",DFLT_ID_GRANITE);

            OreDictionary.registerOre("granite", blockGranite);
            OreDictionary.registerOre("stoneGranite", blockGranite);
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockGranite, 2, 0),"quartz", "diorite"));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockGranite, 2, 0),"quartz", "stoneDiorite"));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockGranite, 2, 0), Item.field_94583_ca,  blockDiorite));
        }
        {
            blockPrismarine = new BlockMarble(getBlock("blockPrismarine",DFLT_ID_PRISMARINE));
            blockPrismarine.func_71884_a(Block.field_71976_h).func_71848_c(6.0F).func_71894_b(1.5f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockPrismarine));
            ch.setBlockName("Prismarine Block");
            ch.addVariation("Raw diagonal prismarine bricks", 0, "prismarine/diagonal/prismarineDiagonalAnim");
            ch.addVariation("Raw prismarine masonry", 1, "prismarine/masonryPrismarineAnim");
            ch.addVariation("Prismarine masonry", 2, "prismarine/masonryPrismarine");
            ch.addVariation("Prismarine prism bricks", 3, "prismarine/prismarine_bricks");
            ch.addVariation("Dark prismarine", 4, "prismarine/prismarine_dark");
            ch.addVariation("Raw prismarine", 5, "prismarine/prismarine_rough");
            ch.addVariation("Prismarine bricks", 6, "prismarine/prismarineBrick");
            ch.addVariation("Prismarine circles", 7, "prismarine/prismarineCircular");
            register.invoke(ch,blockPrismarine,"prismarine");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockPrismarine, 8, 5), "ZZZ", "ZXZ", "ZZZ", 'Z',"cobblestone", 'X', "dyeCyan"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockPrismarine, 8, 5), "ZZZ", "ZXZ", "ZZZ", 'Z',new ItemStack(Block.field_71978_w,1), 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,6)));
        }
        {
            blockDarkstone = new BlockMarble(getBlock("blockDarkstone",DFLT_ID_DARKSTONE));
            blockDarkstone.func_71884_a(Block.field_71976_h).func_71848_c(6.0F).func_71894_b(1.5f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockDarkstone));
            ch.setBlockName("Darkstone Block");
            ch.addVariation("Raw darkstone", 0, "chiselbp:darkstone/stone");
            ch.addVariation("Arcane darkstone", 1, "chiselbp:darkstone/arcane");
            ch.addVariation("Darkstone bricks", 2, "chiselbp:darkstone/bricks");
            ch.addVariation("Darkstone circles", 3, "chiselbp:darkstone/circles");
            ch.addVariation("Darkstone pillar", 4, "chiselbp:darkstone/pillar");
            ch.addVariation("Darkstone tile", 5, "chiselbp:darkstone/tile");
            ch.addVariation("Small darkstone tiles", 6, "chiselbp:darkstone/tiles");
            ch.addVariation("Darkstone grass", 7, "chiselbp:darkstone/grass");
            ch.addVariation("Arcane darkstone bricks", 8, "chiselbp:darkstone/arcaneBrick");
            ch.addVariation("Outlined darkstone bricks", 9, "chiselbp:darkstone/bricksOutlined");
            register.invoke(ch,blockDarkstone,"darkstone");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDarkstone, 32, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',"cobblestone", 'X', "dyeBlue"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDarkstone, 32, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',new ItemStack(Block.field_71978_w,1), 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,4)));

            blockDarkstoneSlab = new BPBlockSlabCarvable(
                    getBlock("blockDarkstoneSlab",DFLT_ID_DARKSTONE_SLAB),
                    getBlock("blockDarkstoneSlabTop",DFLT_ID_DARKSTONE_SLAB_TOP),
                    blockDarkstone);

            blockDarkstoneSlab.gCh().setBlockName("Darkstone Slab");
            blockDarkstoneSlab.register("darkstoneSlab");

            for (int i = 0; i < 10; i++) {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDarkstoneSlab, 6, i), "ZZZ",  'Z',new ItemStack(blockDarkstone,1,i)));
            }

        }
        {
            blockWaterstone = new BlockOverlay(getBlock("blockWaterstone",DFLT_ID_WATERSTONE),"water_still",true);
            blockWaterstone.func_71848_c(2.0F).func_71894_b(10.0F);
            //blockWaterstone = (BlockLavastone)(new BlockMarbleTexturedOre("lavastone", 2834, Material.field_76246_e, "lava_flow")).func_71848_c(2.0F).func_71894_b(10.0F);

            CarvableHelper ch = ((CarvableHelper)f.get(blockWaterstone));
            ch.setBlockName("Waterstone");
            ch.addVariation("Waterstone", 0, "waterstone/cobble");
            ch.addVariation("Black waterstone", 1, "waterstone/black");
            ch.addVariation("Waterstone tiles", 2, "waterstone/tiles");
            ch.addVariation("Chaotic waterstone bricks", 3, "waterstone/chaotic");
            ch.addVariation("Water creeper in tiles", 4, "waterstone/creeper");
            ch.addVariation("Water panel", 5, "waterstone/panel");
            ch.addVariation("Ornate water panel", 6, "waterstone/panel-ornate");
            register.invoke(ch,blockWaterstone,"blockWaterstone");
            OreDictionary.registerOre("blockWaterstone", blockWaterstone);
            Carving.chisel.registerOre("blockWaterstone", "blockWaterstone");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockWaterstone, 32, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',"cobblestone", 'X', "bucketWater"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockWaterstone, 32, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',new ItemStack(Block.field_71978_w,1), 'X', new ItemStack(Item.field_77786_ax.field_77779_bT, 1,0)));

        }
        {
            blockBloodstone = new BlockMarble(getBlock("blockBloodstone",DFLT_ID_BLOODSTONE));
            blockBloodstone.func_71884_a(Block.field_71976_h).func_71848_c(6.0F).func_71894_b(1.5f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockBloodstone));
            ch.setBlockName("Bloodstone Block");
            ch.addVariation("Raw bloodstone", 0, "chiselbp:bloodstone/stone");
            ch.addVariation("Arcane bloodstone", 1, "chiselbp:bloodstone/arcane");
            ch.addVariation("Bloodstone bricks", 2, "chiselbp:bloodstone/bricks");
            ch.addVariation("Bloodstone circles", 3, "chiselbp:bloodstone/circles");
            ch.addVariation("Bloodstone pillar", 4, "chiselbp:bloodstone/pillar");
            ch.addVariation("Bloodstone tile", 5, "chiselbp:bloodstone/tile");
            ch.addVariation("Small bloodstone tiles", 6, "chiselbp:bloodstone/tiles");
            ch.addVariation("Bloodstone grass", 7, "chiselbp:bloodstone/grass");
            ch.addVariation("Arcane bloodstone bricks", 8, "chiselbp:bloodstone/arcaneBrick");
            ch.addVariation("Outlined bloodstone bricks", 9, "chiselbp:bloodstone/bricksOutlined");
            register.invoke(ch,blockBloodstone,"bloodstone");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockBloodstone, 32, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',"cobblestone", 'X', "dyeRed"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockBloodstone, 32, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',new ItemStack(Block.field_71978_w,1), 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,1)));

            blockBloodstoneSlab = new BPBlockSlabCarvable(
                    getBlock("blockBloodstoneSlab",DFLT_ID_BLOODSTONE_SLAB),
                    getBlock("blockBloodstoneSlabTop",DFLT_ID_BLOODSTONE_SLAB_TOP),
                    blockBloodstone);

            blockBloodstoneSlab.gCh().setBlockName("Bloodstone Slab");
            blockBloodstoneSlab.register("bloodstoneSlab");

            for (int i = 0; i < 10; i++) {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockBloodstoneSlab, 6, i), "ZZZ",  'Z',new ItemStack(blockBloodstone,1,i)));
            }

        }
        {
            blockYellowstone = new BlockMarble(getBlock("blockYellowstone",DFLT_ID_YELLOWSTONE));
            blockYellowstone.func_71884_a(Block.field_71976_h).func_71848_c(6.0F).func_71894_b(1.5f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockYellowstone));
            ch.setBlockName("Yellowstone Block");
            ch.addVariation("Raw yellowstone", 0, "chiselbp:yellowstone/stone");
            ch.addVariation("Arcane yellowstone", 1, "chiselbp:yellowstone/arcane");
            ch.addVariation("Yellowstone bricks", 2, "chiselbp:yellowstone/bricks");
            ch.addVariation("Yellowstone circles", 3, "chiselbp:yellowstone/circles");
            ch.addVariation("Yellowstone pillar", 4, "chiselbp:yellowstone/pillar");
            ch.addVariation("Yellowstone tile", 5, "chiselbp:yellowstone/tile");
            ch.addVariation("Small yellowstone tiles", 6, "chiselbp:yellowstone/tiles");
            ch.addVariation("Yellowstone grass", 7, "chiselbp:yellowstone/grass");
            ch.addVariation("Arcane yellowstone bricks", 8, "chiselbp:yellowstone/arcaneBrick");
            ch.addVariation("Outlined yellowstone bricks", 9, "chiselbp:yellowstone/bricksOutlined");
            register.invoke(ch,blockYellowstone,"yellowstone");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockYellowstone, 32, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',"cobblestone", 'X', "dyeYellow"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockYellowstone, 32, 0), "ZZZ", "ZXZ", "ZZZ", 'Z',new ItemStack(Block.field_71978_w,1), 'X', new ItemStack(Item.field_77756_aW.field_77779_bT, 1,11)));

            blockYellowstoneSlab = new BPBlockSlabCarvable(
                    getBlock("blockYellowstoneSlab",DFLT_ID_YELLOWSTONE_SLAB),
                    getBlock("blockYellowstoneSlabTop",DFLT_ID_YELLOWSTONE_SLAB_TOP),
                    blockYellowstone);

            blockYellowstoneSlab.gCh().setBlockName("Yellowstone Slab");
            blockYellowstoneSlab.register("yellowstoneSlab");

            for (int i = 0; i < 10; i++) {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockYellowstoneSlab, 6, i), "ZZZ",  'Z',new ItemStack(blockYellowstone,1,i)));
            }

        }
        {

            blockCubit = new BlockMarble(getBlock("blockCubit",DFLT_ID_CUBIT));
            blockCubit.func_71884_a(Block.field_71976_h).func_71848_c(0.8F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockCubit));
            ch.setBlockName("Cubit");

            for (int i = 0; i < 16; i++) {
                ch.addVariation("Cubit("+i+")", i, "cubit/" + i);
            }
            register.invoke(ch,blockCubit,"cubit");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockCubit,8,0), "***","*X*","***",  '*',"stone",'X',new ItemStack(Block.field_72101_ab,1,15)));
        }
        {

            blockNeonite = new BlockEmissive(getBlock("blockNeonite",DFLT_ID_NEONITE));
            blockNeonite.func_71848_c(1.0F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockNeonite));
            ch.setBlockName("Neonite");

            for (int i = 0; i < 16; i++) {
                ch.addVariation(Utils.neoName[i]+" Neonite", i, "neonite/" + i);
            }
            register.invoke(ch,blockNeonite,"neonite");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockNeonite,8,0), "***","*X*","***", '*',"gemEmerald",'X',"dustGlowstone"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockNeonite,8,0), "***","*X*","***", '*',new ItemStack(Item.field_77817_bH,1),'X',new ItemStack(Item.field_77751_aT,1)));
        }
        {

            blockNuCrete = new BlockMarble(getBlock("blockNuCrete",DFLT_ID_NUCRETE));
            blockNuCrete.func_71884_a(Block.field_71976_h).func_71848_c(5.0F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockNuCrete));
            ch.setBlockName("Structural Concrete");

            ch.addVariation("Dark Concrete Breezeblocks", 0, "nucrete/darkbreezeblock");
            ch.addVariation("Dark Concrete Panel", 1, "nucrete/darkpanel");
            ch.addVariation("Dark Concrete Panel 2", 2, "nucrete/darkpanel2");
            ch.addVariation("Smooth Dark Concrete", 3, "nucrete/darksmooth");
            ch.addVariation("Dark Concrete Tiles", 4, "nucrete/darkstamped");
            ch.addVariation("Dark Concrete Strip", 5, "nucrete/darkstrip");
            ch.addVariation("Dark Concrete Caution Tape", 6, "nucrete/darkstripes");
            ch.addVariation("Dark Concrete Tiles", 7, "nucrete/darktiles");
            ch.addVariation("Light Concrete Breezeblocks", 8, "nucrete/lightbreezeblocks");
            ch.addVariation("Light Concrete Panel", 9, "nucrete/lightpanel");
            ch.addVariation("Light Concrete Panel 2", 10, "nucrete/lightpanel2");
            ch.addVariation("Smooth Light Concrete", 11, "nucrete/lightsmooth");
            ch.addVariation("Light Concrete Tiles", 12, "nucrete/lightstamped");
            ch.addVariation("Light Concrete Strip", 13, "nucrete/lightstrip");
            ch.addVariation("Light Concrete Caution Tape", 14, "nucrete/lightstripe");
            ch.addVariation("Light Concrete Tiles", 15, "nucrete/lighttiles");

            register.invoke(ch,blockNuCrete,"nucrete");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockNuCrete,8,0), "xyx","*x*","xyx", '*',"sand",'x',"gravel",'y',"itemClay"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockNuCrete,8,0), "xyx","*x*","xyx", '*',new ItemStack(Block.field_71939_E, 1),'x',new ItemStack(Block.field_71940_F, 1),'y',new ItemStack(Item.field_77757_aI, 1)));
        }
        {

            blockFrogLight = new BlockMarble(getBlock("blockFrogLight",DFLT_ID_FROGLIGHT));
            blockFrogLight.func_71884_a(Block.field_71976_h).func_71848_c(1.0F).func_71900_a(1.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockFrogLight));
            ch.setBlockName("Froglight");

            String[] prefixes = {
                    "Aluminium",
                    "Titanium",
                    "Tungstensteel",
                    "Osmium",
                    "Fluxed",
                    "Uranium",
                    "Girisium",
                    "Orundum",
                    "Blood-Stained",
                    "Ichor"
            };

            for (int i = 0; i < 10; i++) {
                ch.addVariation(prefixes[i]+" Froglight", i, "froglight/" + i);
            }

            register.invoke(ch,blockFrogLight,"froglight");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockFrogLight,8,0), "SGS","BSB","SGS", 'S',"stone",'G',"dustGlowstone",'B',"slimeball"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockFrogLight,8,0), "SGS","BSB","SGS", 'S',"stone",'G',new ItemStack(Item.field_77751_aT, 1),'B',new ItemStack(Item.field_77761_aM, 1)));
        }
        {

            blockSveltstone = new BlockMarble(getBlock("blockSveltstone",DFLT_ID_SVELTSTONE));
            blockSveltstone.func_71884_a(Block.field_71976_h).func_71848_c(5.0F).func_71894_b(10.0f);


            CarvableHelper ch = ((CarvableHelper)f.get(blockSveltstone));
            ch.setBlockName("Sveltstone");

            String[] prefix = {

                    "Silver Sand",
                    "Sand Dune",
                    "Fuscous Grey",
                    "Flint",
                    "Taupe",
                    "Tobacco Brown",
                    "Boulder",
                    "Olive Haze",
                    "Pale Oister",
                    "Hemlock",
                    "Rifle Green",
                    "Everglade",
                    "Baltic Sea",
                    "Outer Space",
                    "Gunmetal",
                    "Matterhorn"

            };

            for (int i = 0; i < 16; i++) {
                ch.addVariation(prefix[i]+" Sveltstone Block", i, "sveltstone/" + i);
            }

            register.invoke(ch,blockSveltstone,"sveltstone");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSveltstone,8,0), "***","*X*","***",  '*',"stone",'X',"andesite"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSveltstone,8,0), "***","*X*","***",  '*',"stone",'X',"stoneAndesite"));
        }
        {
            blockBrickM = new BlockMarble(this.getBlock("blockBrickM",DFLT_ID_BRICK_M));
            blockBrickM.func_71848_c(2.0F).func_71894_b(6.0F).func_71884_a(Block.field_71976_h);
            CarvableHelper ch = ((CarvableHelper)f.get(blockBrickM));
            ch.setBlockName("Bricks");

            ch.addVariation("Array of bricks", 0, "bricks/array");
            ch.addVariation("Braided bricks", 1, "bricks/braid");
            ch.addVariation("Chaotic bricks", 2, "bricks/chaotic_bricks");
            ch.addVariation("Medium Chaotic bricks", 3, "bricks/chaotic_medium");
            ch.addVariation("Small Chaotic bricks", 4, "bricks/chaotic_small");
            ch.addVariation("Circular bricks", 5, "bricks/circular");
            ch.addVariation("Cracked bricks", 6, "bricks/cracked");
            ch.addVariation("Cracked Large bricks", 7, "bricks/cracked_bricks");
            ch.addVariation("Brick cuts", 8, "bricks/cuts");
            ch.addVariation("Brick dent", 9, "bricks/dent");
            ch.addVariation("Encased bricks", 10, "bricks/encased_bricks");
            ch.addVariation("French bricks 1", 11, "bricks/french_1");
            ch.addVariation("French bricks 2", 12, "bricks/french_2");
            ch.addVariation("Jellybean bricks", 13, "bricks/jellybean");
            ch.addVariation("Layered bricks", 14, "bricks/layers");
            ch.addVariation("Brick mosaic", 15, "bricks/mosaic");

            ExtensionUtilities.registerDupe(ch,blockBrickM,"brick","brickM");
        }
        {
            blockBrickM2 = new BlockMarble(this.getBlock("blockBrickM2",DFLT_ID_BRICK_M2));
            blockBrickM2.func_71848_c(2.0F).func_71894_b(6.0F).func_71884_a(Block.field_71976_h);
            CarvableHelper ch = ((CarvableHelper)f.get(blockBrickM2));
            ch.setBlockName("Bricks");

            ch.addVariation("Weaved bricks", 0, "bricks/weaver");
            ch.addVariation("Twisted bricks", 1, "bricks/twisted");
            ch.addVariation("Triple bricks", 2, "bricks/triple_bricks");
            ch.addVariation("Small brick tiles", 3, "bricks/tiles_small");
            ch.addVariation("Medium brick tiles", 4, "bricks/tiles_medium");
            ch.addVariation("Large brick tiles", 5, "bricks/tiles_large");
            ch.addVariation("Ornate bricks", 6, "bricks/ornate");
            ch.addVariation("Brick panel", 7, "bricks/panel");
            ch.addVariation("Brick pillar", 8, "bricks/pillar");
            ch.addVariation("Brick prism", 9, "bricks/prism");
            ch.addVariation("Raw brick", 10, "bricks/raw");
            ch.addVariation("Brick road", 11, "bricks/road");
            ch.addVariation("Slanted bricks", 12, "bricks/slanted");
            ch.addVariation("Small bricks", 13, "bricks/small_bricks");
            ch.addVariation("Soft bricks", 14, "bricks/soft_bricks");
            ch.addVariation("Solid bricks", 15, "bricks/solid_bricks");

            ExtensionUtilities.registerDupe(ch,blockBrickM2,"brick","brickM2");
        }
        {

            blockGlotek = new BlockEmissive(getBlock("blockGlotek",DFLT_ID_GLOTEK));
            blockGlotek.func_71848_c(1.0F);


            CarvableHelper ch = ((CarvableHelper)f.get(blockGlotek));
            ch.setBlockName("Glotek");

            String[] prefix = {

                    "Ceramic",
                    "Sandwisp",
                    "Easter Green",
                    "Dragon Green",
                    "Tealish Green",
                    "Green Haze",
                    "Petrol",
                    "Catalina Blue",
                    "Blue Gem",
                    "Royal Purple",
                    "Dark Magenta",
                    "Dogwood Rose",
                    "Cranberry",
                    "Brink Pink",
                    "Dark Salmon",
                    "Harvest Gold"

            };

            for (int i = 0; i < 16; i++) {
                ch.addVariation(prefix[i]+" Glotek", i, "glotek/" + i);
            }

            register.invoke(ch,blockGlotek,"glotek");

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockGlotek,8,0), "***","*X*","***",  '*',new ItemStack(blockNeonite, 1),'X',"dustGlowstone"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockGlotek,8,0), "***","*X*","***",  '*',new ItemStack(blockNeonite, 1),'X',new ItemStack(Item.field_77751_aT, 1)));
        }

        blockOak = ModernWoodUtils.makePlanks("oak","Oak",DFLT_ID_OAK_M);
        blockBirch = ModernWoodUtils.makePlanks("birch","Birch",DFLT_ID_BIRCH_M);
        blockSpruce = ModernWoodUtils.makePlanks("spruce","Spruce",DFLT_ID_SPRUCE_M);
        blockJungle = ModernWoodUtils.makePlanks("jungle","Jungle",DFLT_ID_JUNGLE_M);
        blockDarkOak = ModernWoodUtils.makePlanks("dark_oak","Dark Oak",DFLT_ID_DARK_OAK_M);
        blockAcacia = ModernWoodUtils.makePlanks("acacia","Acacia",DFLT_ID_ACACIA_M);
        blockCrimson = ModernWoodUtils.makePlanks("crimson","Crimson",DFLT_ID_CRIMSON_M);

        blockOak2 = ModernWoodUtils.makePlanks2("oak","Oak",DFLT_ID_OAK_M2,true);
        blockBirch2 = ModernWoodUtils.makePlanks2("birch","Birch",DFLT_ID_BIRCH_M2,false);
        blockSpruce2 = ModernWoodUtils.makePlanks2("spruce","Spruce",DFLT_ID_SPRUCE_M2,false);
        blockJungle2 = ModernWoodUtils.makePlanks2("jungle","Jungle",DFLT_ID_JUNGLE_M2,false);
        blockDarkOak2 = ModernWoodUtils.makePlanks2("dark_oak","Dark Oak",DFLT_ID_DARK_OAK_M2,false);
        blockAcacia2 = ModernWoodUtils.makePlanks2("acacia","Acacia",DFLT_ID_ACACIA_M2,false);
        blockCrimson2 = ModernWoodUtils.makePlanks2("crimson","Crimson",DFLT_ID_CRIMSON_M2,false);


        NetworkRegistry.instance().registerGuiHandler(this, new IGuiHandler(){
            @Override
            public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
                return new BPContainerChisel(player.field_71071_by, new BPInventoryChiselSelection(null));
            }

            @Override
            public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
                return new BPGuiChisel(player.field_71071_by, new BPInventoryChiselSelection(null));
            }
        });

        MinecraftForge.EVENT_BUS.register(new ChiselController());

        config.save();
    }

    @Mod.PostInit
    public void postInit(FMLPostInitializationEvent event)
    {
        AddCompatBlocks.postInit();
        if(neiPlugin)
            ChiselNEI.load();
    }

}
