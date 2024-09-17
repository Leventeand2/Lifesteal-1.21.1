package net.levente.advancements.criterions;

import com.mojang.serialization.Codec;
import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModCriterions {
    public static final Codec<Criterion<?>> CODEC = Registries.CRITERION.getCodec();

    public static <T extends Criterion<?>> T register(String id, T criterion) {
        return Registry.register(Registries.CRITERION, id, criterion);
    }
}
