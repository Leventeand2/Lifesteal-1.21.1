package net.levente.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.levente.Lifesteal;
import net.levente.block.ModBlocks;
import net.levente.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.EnterBlockCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancementsProvider extends FabricAdvancementProvider {
    public AdvancementsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.HEART, // The display icon
                        Text.translatable("advancements.heart.title"), // The title
                        Text.translatable("advancements.heart.desc"), // The description
                        Identifier.of("textures/advancements/advancement"), // Background image
                        AdvancementFrame.TASK,
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .criterion("has_heart", InventoryChangedCriterion.Conditions.items(ModItems.HEART))
                .build(consumer, Lifesteal.MOD_ID + "/root");
        AdvancementEntry heartStoneAdvancement = Advancement.Builder.create()
                .display(

                        ModBlocks.HEARTSTONE,
                        Text.translatable("advancements.heartstone.title"),
                        Text.translatable("advancements.heartstone.desc"),
                        Identifier.of("textures/advancements/advancement"),
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("healed_heartstone", EnterBlockCriterion.Conditions.block(ModBlocks.HEARTSTONE))
                .parent(rootAdvancement)
                .build(consumer, Lifesteal.MOD_ID + "/heartstone");
    }
}
