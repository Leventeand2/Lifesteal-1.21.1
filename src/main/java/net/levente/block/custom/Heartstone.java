package net.levente.block.custom;

import net.levente.MaxHealth;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Heartstone extends Block {
    public Heartstone(Settings settings) {
        super(settings);
        settings.strength(12f).requiresTool();
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient) {
            if (entity.isAlive()) {
                if (entity instanceof PlayerEntity player) {
                    double currentHealth = MaxHealth.currentHealth;
                    MaxHealth.setPlayerMaxHealth(player, currentHealth + 1.0f);
                }
            }
        }
    }
}
