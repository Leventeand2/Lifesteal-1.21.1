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
        System.out.println("Registered Player Death class");
    }


    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {
        if (entity instanceof PlayerEntity) {
            World world = entity.getWorld();
            ItemStack stack = new ItemStack(ModItems.HEART);
            ItemEntity item = new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), stack);
            world.spawnEntity(item);

        }
    }
}
