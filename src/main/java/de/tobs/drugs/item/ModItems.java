package de.tobs.drugs.item;

import de.tobs.drugs.Drugs;
import de.tobs.drugs.block.ModBlocks;
import de.tobs.drugs.effect.ModEffects;
import de.tobs.drugs.item.custom.BluntItem;
import de.tobs.drugs.item.custom.CocainItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //for recipes visit https://crafting.thedestruc7i0n.ca/
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Drugs.MOD_ID);
    public static final RegistryObject<Item> CANNABIS_SEEDS = ITEMS.register("cannabis_seeds", () -> new ItemNameBlockItem(ModBlocks.CANNABIS_CROP.get(), new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> COCA_SEEDS = ITEMS.register("coca_seeds", () -> new ItemNameBlockItem(ModBlocks.COCA_CROP.get(), new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> CANNABIS_FLOWER = ITEMS.register("cannabis_flower", () -> new Item(new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> COCA_LEAVES = ITEMS.register("coca_leaves", () -> new Item(new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> CANNABIS_FLOWER_DRIED = ITEMS.register("cannabis_flower_dried", () -> new Item(new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> CANNABIS_ONE_GRAMM = ITEMS.register("cannabis_one_gramm", () -> new Item(new Item.Properties().tab(ModTab.DRUGS_TAB)));
    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt", () -> new BluntItem(new Item.Properties().tab(ModTab.DRUGS_TAB).food(new FoodProperties.Builder().saturationMod(0).effect(()-> new MobEffectInstance(ModEffects.CANNABIS_HIGH.get(), 6000, 0), 1.0F).build())));
    public static final RegistryObject<Item> COCAIN = ITEMS.register("cocain", () -> new CocainItem(new Item.Properties().tab(ModTab.DRUGS_TAB).food(new FoodProperties.Builder().saturationMod(0).effect(()-> new MobEffectInstance(ModEffects.COCAIN_HIGH.get(), 6000, 0), 1.0F).build())));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

