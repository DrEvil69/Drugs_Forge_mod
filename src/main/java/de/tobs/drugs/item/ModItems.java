package de.tobs.drugs.item;

import de.tobs.drugs.Drugs;
import de.tobs.drugs.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Drugs.MOD_ID);
    public static final RegistryObject<Item> CANNABIS_SEEDS = ITEMS.register("cannabis_seeds", () -> new ItemNameBlockItem(ModBlocks.CANNABIS_CROP.get(), new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> CANNABIS_FLOWER = ITEMS.register("cannabis_flower", () -> new Item(new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> CANNABIS_FLOWER_DRIED = ITEMS.register("cannabis_flower_dried", () -> new Item(new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> CANNABIS_ONE_GRAMM = ITEMS.register("cannabis_one_gramm", () -> new Item(new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt", () -> new Item(new Item.Properties().tab(ModTab.DRUGS_TAB).food(new FoodProperties.Builder().saturationMod(0).build())));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}