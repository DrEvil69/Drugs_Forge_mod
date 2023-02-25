package de.tobs.drugs.block.entity;

import de.tobs.drugs.Drugs;
import de.tobs.drugs.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Drugs.MOD_ID);

    public static final RegistryObject<BlockEntityType<ChemistryToolsBlockEntity>> CHEMISTRY_TOOLS = BLOCK_ENTITIES.register("chemistry_tools", ()-> BlockEntityType.Builder.of(ChemistryToolsBlockEntity::new, ModBlocks.CHEMISTRY_TOOLS.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
