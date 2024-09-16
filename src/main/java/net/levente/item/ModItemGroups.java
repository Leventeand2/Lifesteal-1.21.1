package net.levente.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.levente.Lifesteal;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup HEALTHSTEAL = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Lifesteal.MOD_ID, "lifesteal"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.HEART))
                    .displayName(Text.translatable("itemgroup.lifesteal.lifesteal"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.HEART_WAND);
                    })).build());

    public static void registerItemGroups() {
        System.out.println("Registering mod item groups");
    }
}


