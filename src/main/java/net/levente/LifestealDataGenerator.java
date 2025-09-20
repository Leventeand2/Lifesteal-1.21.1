package net.levente;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.levente.data.generator.AdvancementsProvider;
import net.levente.data.generator.ModLangProvider;
import net.levente.data.generator.ModModelProvider;
import net.levente.data.generator.ModRecipeProvider;

public class LifestealDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(AdvancementsProvider::new);
		pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModLangProvider::new);
	}
}
