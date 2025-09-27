package net.levente.util;

import net.levente.Lifesteal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.Objects;

public class PlayerMaxHealthUtil {

    public static void setPlayerMaxHealth(LivingEntity entity, double newHealth) {
        if (newHealth < 2.0) {
            if (entity instanceof PlayerEntity player) {
                World world = player.getWorld();
                if (!world.isClient()) {
                    if (world.getServer() != null && !world.getServer().isSingleplayer()) {
                        ServerWorld serverWorld = (ServerWorld) world;
                        MinecraftServer server = serverWorld.getServer();
                        String command = "ban " + player.getName().getString() + " \"Your health ran out.\"";
                        String messageCommand = "tellraw @a {\"text\":\"" + Objects.requireNonNull(player.getDisplayName()).getString() + " ran out of lives!\"}";

                        ServerCommandSource commandSource = server.getCommandSource();
                        CommandManager manager = server.getCommandManager();
                        try {
                            manager.executeWithPrefix(commandSource, command);
                            manager.executeWithPrefix(commandSource, messageCommand);
                        } catch (Exception e) {
                            Lifesteal.LOGGER.error("Error trying to ban player: {}", e.getMessage());
                        }
                    } else {
                        updateHealth(entity, 1.0);
                    }
                }
            }
        } else {
            updateHealth(entity, newHealth);
        }
    }

    private static void updateHealth(LivingEntity entity, double newHealth) {

        newHealth = entity.getMaxHealth() % 2 == 0 ? newHealth : newHealth - 0.5;
        EntityAttributeInstance healthAttribute = entity.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        if (healthAttribute != null) { healthAttribute.setBaseValue(newHealth); }
        entity.setHealth((float) newHealth);
    }
}
