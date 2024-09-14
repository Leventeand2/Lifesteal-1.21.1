
package net.levente;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.levente.event.EntityDeathHandler;
import net.levente.event.EventRegistry;
import net.levente.event.PlayerRespawnHandler;
import net.levente.event.UseItemHandler;
import net.levente.item.ModItemGroups;
import net.levente.item.ModItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lifesteal implements ModInitializer {
	public static final String MOD_ID = "lifesteal";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		EventRegistry.registerEvents();
		ServerPlayerEvents.AFTER_RESPAWN.register(new PlayerRespawnHandler());

		// Register the UseItemHandler to handle item usage events
		UseItemCallback.EVENT.register(new UseItemHandler());
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		EntityDeathHandler.registerPlayerDeath();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
