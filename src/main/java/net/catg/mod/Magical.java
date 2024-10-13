package net.catg.mod;

import net.catg.mod.entity.ModEntities;
import net.catg.mod.item.ModItemGroups;
import net.catg.mod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.LoggerFactory;


import java.util.logging.Logger;


public class Magical implements ModInitializer {
	public static final String MOD_ID = "magical";
	public static final Logger LOGGER = Logger.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}

}
