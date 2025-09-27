package net.levente.item.custom;

import net.levente.util.PlayerMaxHealthUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class HeartWand extends Item {
    public HeartWand(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            double playerMaxHealth = player.getMaxHealth();
            double playerNewHealth = player.getMaxHealth() + 2.0;
            double targetMaxHealth = target.getMaxHealth();
            double targetNewHealth = target.getMaxHealth() - 2.0;

            if (targetMaxHealth > 2.0) {
                PlayerMaxHealthUtil.setPlayerMaxHealth(player, playerNewHealth);
                PlayerMaxHealthUtil.setPlayerMaxHealth(target, targetNewHealth);
                stack.damage(1, player);
                return true;
            } else {
                World world = player.getWorld();
                if (!world.isClient()) {
                    ServerWorld serverWorld = (ServerWorld) world;
                    target.kill(serverWorld);
                    return true;
                }
            }
            return false;
        }
        return super.postHit(stack, target, attacker);
    }
}
