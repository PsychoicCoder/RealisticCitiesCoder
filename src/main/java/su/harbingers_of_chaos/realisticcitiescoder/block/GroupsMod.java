package su.harbingers_of_chaos.realisticcitiescoder.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static su.harbingers_of_chaos.realisticcitiescoder.RealisticCitiesCoder.*;

public class GroupsMod {
    public static final ItemGroup ROAD_GROUP = Registry.register(Registries.ITEM_GROUP,
            id("road"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.road"))
                    .icon(() -> new ItemStack(Items.AIR)).entries((displayContext, entries) -> {

                        entries.add(BlocksMod.ROAD_WITH_CROSSWALK);
                        entries.add(BlocksMod.ROAD);
                        entries.add(BlocksMod.BIKE_LINE);

                        entries.add(BlocksMod.ROAD_WITH_CORNER_WHITE_LINE         );
                        entries.add(BlocksMod.ROAD_WITH_MIDDLE_WHITE_LINE         );
                        entries.add(BlocksMod.ROAD_WITH_SMALL_WHITE_LINE          );
                        entries.add(BlocksMod.ROAD_WITH_DOUBLE_STRAIGHT_WHITE_LINE);
                        entries.add(BlocksMod.ROAD_WITH_STRAIGHT_WHITE_LINE       );
                        entries.add(BlocksMod.ROAD_WITH_STRAIGHT_WHITE_LINE_SIDE  );

                        entries.add(BlocksMod.ROAD_WITH_CORNER_YELLOW_LINE         );
                        entries.add(BlocksMod.ROAD_WITH_MIDDLE_YELLOW_LINE         );
                        entries.add(BlocksMod.ROAD_WITH_SMALL_YELLOW_LINE          );
                        entries.add(BlocksMod.ROAD_WITH_DOUBLE_STRAIGHT_YELLOW_LINE);
                        entries.add(BlocksMod.ROAD_WITH_STRAIGHT_YELLOW_LINE       );
                        entries.add(BlocksMod.ROAD_WITH_STRAIGHT_YELLOW_LINE_SIDE  );

                        entries.add(BlocksMod.MEDIAN_BLUE  );
                        entries.add(BlocksMod.MEDIAN_WHITE );
                        entries.add(BlocksMod.MEDIAN_YELLOW);

                        entries.add(BlocksMod.BIKE_LINE_CORNER      );
                        entries.add(BlocksMod.BIKE_LINE_INNER_CORNER);
                        entries.add(BlocksMod.BIKE_LINE_SIDE        );


                    }).build());

    public static void registerItemGroups() {
        LOGGER.info("Registering Item Groups for " + MOD_ID);
    }
}
