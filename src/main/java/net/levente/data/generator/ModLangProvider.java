package net.levente.data.generator;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.levente.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.HEART, "Heart");
        translationBuilder.add(ModItems.HEART_WAND, "Heart Staff");
        translationBuilder.add("itemgroup.lifesteal.lifesteal", "Healthsteal");
        translationBuilder.add("advancements.heart.title", "Health Achivement");
        translationBuilder.add("advancements.heart.desc", "You're just getting started! Keep STEALING lives!!");
        translationBuilder.add("advancements.heartstone.title", "Healed by the Heartstone");
        translationBuilder.add("advancements.heartstone.desc", "You got healed by something... Who gave you these hearts? What are they?? Nevermind.");
    }
}
