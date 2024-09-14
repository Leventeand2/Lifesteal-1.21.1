package net.levente;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;

public class MaxHealth {
    public static double currentHealth = 0;
    public static double maxHealth = 0;

    public static void setPlayerMaxHealth(LivingEntity player, double health) {
        // Get the max health attribute instance
        EntityAttributeInstance healthAttribute = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        currentHealth = player.getMaxHealth();
        maxHealth = player.getMaxHealth();

        if (healthAttribute != null) {
            // Set the base value to the desired health
            healthAttribute.setBaseValue(health);

            // Heal the player to the new max health instantly
            player.setHealth((float) health);
        }
    }
}
