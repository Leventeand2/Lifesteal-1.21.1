package net.levente.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.Objects;

public class HeartStealEnchantmentHandler implements ServerLivingEntityEvents.AfterDeath {
    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {
        if (entity.isLiving()) {
            if (entity instanceof PlayerEntity) {
                if (Objects.requireNonNull(damageSource.getAttacker()).isAlive() && damageSource.getAttacker() instanceof PlayerEntity) {
                    LivingEntity attacker = (LivingEntity) damageSource.getAttacker();
                    ItemStack item = attacker.getActiveItem();
                    item.
                }
            }
        }
    }
}
