package de.tobs.drugs.block;

import de.tobs.drugs.Drugs;
import de.tobs.drugs.block.custom.CannabisCropBlock;
import de.tobs.drugs.block.custom.ChemistryToolsBlock;
import de.tobs.drugs.block.custom.CocaCropBlock;
import de.tobs.drugs.block.custom.CocaLeavesPileBlock;
import de.tobs.drugs.item.ModItems;
import de.tobs.drugs.item.ModTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Drugs.MOD_ID);

    public static final RegistryObject<Block> MIXED_CEMENT_BASE = registerBlock("mixed_cement_base", () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND).strength(4F).sound(SoundType.SAND)), ModTab.DRUGS_TAB);
    public static final RegistryObject<Block> CEMENT = registerBlock("cement", () -> new GlassBlock(BlockBehaviour.Properties.of(Material.SAND).strength(4F).sound(SoundType.SAND)), ModTab.DRUGS_TAB);
    public static final RegistryObject<Block> CHEMISTRY_TOOLS = registerBlock("chemistry_tools", () -> new ChemistryToolsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(6F).sound(SoundType.GLASS).noOcclusion()), ModTab.DRUGS_TAB);
    public static final RegistryObject<Block> COCA_LEAVES_PILE = registerBlock("coca_leaves_pile", () -> new CocaLeavesPileBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(6F).sound(SoundType.AZALEA_LEAVES).noOcclusion()), ModTab.DRUGS_TAB);



    public static final RegistryObject<Block> CANNABIS_CROP = BLOCKS.register("cannabis_plant", () -> new CannabisCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> COCA_CROP = BLOCKS.register("coca_plant", () -> new CocaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

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
