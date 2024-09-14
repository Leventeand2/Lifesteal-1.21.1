package net.levente.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HeartWand extends Item {
    public HeartWand(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PlayerEntity) {
            double maxHealth = target.getMaxHealth();
            setPlayerMaxHealth((PlayerEntity) target, maxHealth - 2);
        }
        return super.postHit(stack, target, attacker);
    }

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
}
