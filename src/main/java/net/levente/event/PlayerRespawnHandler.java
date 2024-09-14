package net.levente.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.levente.item.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class PlayerRespawnHandler implements ServerPlayerEvents.AfterRespawn {

    public void setPlayerMaxHealth(PlayerEntity player, double health) {
        // Get the max health attribute instance
        EntityAttributeInstance healthAttribute = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

        if (healthAttribute != null) {
            // Set the base value to the new max health
            healthAttribute.setBaseValue(health);

            // Heal the player to their new max health
            player.setHealth((float) health);
        }
    }

    @Override
    public void afterRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        World world = newPlayer.getWorld();

        // Adjust health after respawn
        double maxHealth = newPlayer.getMaxHealth();

        // Reduce the player's max health by 1 (you can change this logic if needed)
        setPlayerMaxHealth(newPlayer, maxHealth - 2);

        if (maxHealth >= 100) {
            setPlayerMaxHealth(newPlayer, 30);
        }
        if (maxHealth < 2) {
            setPlayerMaxHealth(newPlayer, 10);
        }
    }
}
