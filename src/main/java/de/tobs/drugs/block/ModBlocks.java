package de.tobs.drugs.block;

import de.tobs.drugs.Drugs;
import de.tobs.drugs.block.custom.CannabisCropBlock;
import de.tobs.drugs.item.ModItems;
import de.tobs.drugs.item.ModTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Drugs.MOD_ID);

    public static final RegistryObject<Block> MIXED_CEMENT_BASE = registerBlock("mixed_cement_base", () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(6F).sound(SoundType.SAND)), ModTab.DRUGS_TAB);
    public static final RegistryObject<Block> CEMENT = registerBlock("cement", () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(6F).sound(SoundType.SAND)), ModTab.DRUGS_TAB);
    public static final RegistryObject<Block> CANNABIS_CROP = BLOCKS.register("cannabis_plant", () -> new CannabisCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
