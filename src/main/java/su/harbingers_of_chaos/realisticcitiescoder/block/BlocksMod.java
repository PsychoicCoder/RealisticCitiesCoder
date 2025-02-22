package su.harbingers_of_chaos.realisticcitiescoder.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlazedTerracottaBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import org.intellij.lang.annotations.Identifier;
import su.harbingers_of_chaos.realisticcitiescoder.block.custom.ConnectingRoad;

import static su.harbingers_of_chaos.realisticcitiescoder.RealisticCitiesCoder.*;
public class BlocksMod {
    public static final Block ROAD_WITH_CROSSWALK   = registerBlock("road_with_crosswalk", new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD                  = registerBlock("road"               , new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block BIKE_LINE             = registerBlock("bike_line"          , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));

    public static final Block MEDIAN_BLUE           = registerBlock("median_blue"        , new ConnectingRoad(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block MEDIAN_WHITE          = registerBlock("median_white"       , new ConnectingRoad(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block MEDIAN_YELLOW         = registerBlock("median_yellow"      , new ConnectingRoad(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));


    public static final Block ROAD_WITH_CORNER_WHITE_LINE           = registerBlock("road_with_corner_white_line"           , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_MIDDLE_WHITE_LINE           = registerBlock("road_with_middle_corner_white_line"    , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_SMALL_WHITE_LINE            = registerBlock("road_with_small_corner_white_line"     , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_DOUBLE_STRAIGHT_WHITE_LINE  = registerBlock("road_with_double_straight_white_line"  , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_STRAIGHT_WHITE_LINE         = registerBlock("road_with_straight_white_line"         , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_STRAIGHT_WHITE_LINE_SIDE    = registerBlock("road_with_straight_white_line_side"    , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));

    public static final Block ROAD_WITH_CORNER_YELLOW_LINE           = registerBlock("road_with_corner_yellow_line"         , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_MIDDLE_YELLOW_LINE           = registerBlock("road_with_middle_corner_yellow_line"  , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_SMALL_YELLOW_LINE            = registerBlock("road_with_small_corner_yellow_line"   , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_DOUBLE_STRAIGHT_YELLOW_LINE  = registerBlock("road_with_double_straight_yellow_line", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_STRAIGHT_YELLOW_LINE         = registerBlock("road_with_straight_yellow_line"       , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block ROAD_WITH_STRAIGHT_YELLOW_LINE_SIDE    = registerBlock("road_with_straight_yellow_line_side"  , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));

    public static final Block BIKE_LINE_CORNER          = registerBlock("bike_line_corner"      , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block BIKE_LINE_INNER_CORNER    = registerBlock("bike_line_inner_corner", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block BIKE_LINE_SIDE            = registerBlock("bike_line_side"        , new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, id(name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, id(name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        LOGGER.info("Registering ModBlocks for " + MOD_ID);
    }
}
