package net.levente.item;

import net.levente.Lifesteal;
import net.levente.item.custom.Heart;
import net.levente.item.custom.HeartWand;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModItems {
    public static final Item HEART = registerItem(
            "heart",
            Heart::new,
            new Item.Settings().maxCount(16)
    );

    public static final Item HEART_WAND = registerItem(
            "heart_wand",
            HeartWand::new,
            new Item.Settings().maxCount(1).maxDamage(16)
    );



    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory,
                                     Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Lifesteal.id(name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        Lifesteal.LOGGER.info("Registering Mod Items for " + Lifesteal.MOD_ID);
    }
}
