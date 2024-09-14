package net.levente.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.levente.item.ModItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDeathHandler implements ServerLivingEntityEvents.AfterDeath {

    public static void registerPlayerDeath() {

    }

    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {
        if (entity instanceof PlayerEntity) {
            World world = entity.getWorld();

            ItemStack item = new ItemStack(ModItems.HEART);
            world.spawnEntity(new ItemEntity(world, entity.getX(), entity.getY() + 2, entity.getZ(), item));
        }


    }
}
