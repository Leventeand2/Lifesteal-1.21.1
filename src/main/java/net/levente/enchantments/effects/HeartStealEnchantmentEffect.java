package net.levente.enchantments.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.levente.Lifesteal;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import org.slf4j.Logger;

public record HeartStealEnchantmentEffect(EnchantmentLevelBasedValue level) implements EnchantmentEntityEffect {
    public static final MapCodec<HeartStealEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    EnchantmentLevelBasedValue.CODEC.fieldOf("level").forGetter(HeartStealEnchantmentEffect::level)
            ).apply(instance, HeartStealEnchantmentEffect::new));


    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        Lifesteal.LOGGER.info("Registered enchantment: HeartStealEnchantment for: " + Lifesteal.MOD_ID);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
