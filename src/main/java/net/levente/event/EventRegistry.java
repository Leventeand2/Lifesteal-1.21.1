package net.levente.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.levente.item.ModItemGroups;
import net.levente.item.ModItems;

public class EventRegistry {

    public static void registerEvents() {
        // Register the PlayerRespawnHandler to handle player respawn events
        ServerPlayerEvents.AFTER_RESPAWN.register(new PlayerRespawnHandler());

        // Register the UseItemHandler to handle item usage events
        UseItemCallback.EVENT.register(new UseItemHandler());
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        EntityDeathHandler.registerPlayerDeath();
    }
}
