package de.tobs.drugs.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab {
    public static final CreativeModeTab DRUGS_TAB = new CreativeModeTab("drugs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CANNABIS_SEEDS.get());
        }
    };
}
