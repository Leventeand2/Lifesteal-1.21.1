package net.levente.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.levente.util.PlayerMaxHealthUtil;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerRespawnHandler implements ServerPlayerEvents.AfterRespawn {


    @Override
    public void afterRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        // Adjust health after respawn
        double maxHealth = newPlayer.getMaxHealth();

        // Reduce the player's max health by 1 (you can change this logic if needed)
        PlayerMaxHealthUtil.setPlayerMaxHealth(newPlayer, maxHealth - 1);

        if (maxHealth >= 100) {
            PlayerMaxHealthUtil.setPlayerMaxHealth(newPlayer, 30);
        }
    }

}
