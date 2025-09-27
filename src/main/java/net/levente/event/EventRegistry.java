package net.levente.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.levente.item.ModItems;

public class EventRegistry {

    public static void registerEvents() {
        // Register the PlayerRespawnHandler to handle player respawn events
        ServerPlayerEvents.AFTER_RESPAWN.register(new PlayerRespawnHandler());
        EntityDeathHandler.registerPlayerDeath();
        ServerLivingEntityEvents.AFTER_DEATH.register(new EntityDeathHandler());
    }
}
