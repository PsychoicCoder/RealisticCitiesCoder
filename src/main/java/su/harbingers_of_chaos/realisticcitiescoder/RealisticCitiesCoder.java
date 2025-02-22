package su.harbingers_of_chaos.realisticcitiescoder;

import net.fabricmc.api.ModInitializer;

import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import su.harbingers_of_chaos.realisticcitiescoder.block.BlocksMod;
import su.harbingers_of_chaos.realisticcitiescoder.block.GroupsMod;

public class RealisticCitiesCoder implements ModInitializer {
	public static final String MOD_ID = "realisticcitiescoder";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String name){
		return new Identifier(MOD_ID, name);
	};

	@Override
	public void onInitialize() {
		BlocksMod.registerModBlocks();
		GroupsMod.registerItemGroups();
		LOGGER.info("Hello Fabric world!");
	}
}