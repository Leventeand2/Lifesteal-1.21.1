package net.levente.item;

import net.levente.Lifesteal;
import net.levente.item.custom.HeartWand;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item HEART = registerItem("heart", new Item(new Item.Settings()));

    public static final Item HEART_WAND = registerItem("heart_wand", new HeartWand(new Item.Settings().maxDamage(0)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Lifesteal.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Lifesteal.LOGGER.info("Registering Mod Items for " + Lifesteal.MOD_ID);
    }
}
