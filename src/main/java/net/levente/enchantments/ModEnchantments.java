package net.levente.enchantments;

import com.mojang.serialization.MapCodec;
import net.levente.Lifesteal;
import net.levente.enchantments.effects.HeartStealEnchantmentEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> HEARTSTEAL_ENCHANTMENT_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Lifesteal.id("heartsteal"));

    public static final MapCodec<HeartStealEnchantmentEffect> HEARTSTEAL_EFFECT = register("heartstealeffect", HeartStealEnchantmentEffect.CODEC);

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Lifesteal.id(name), codec);
    }

    public static void load() {}
}
