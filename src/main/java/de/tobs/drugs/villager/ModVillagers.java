package de.tobs.drugs.villager;

import com.google.common.collect.ImmutableSet;
import de.tobs.drugs.Drugs;
import de.tobs.drugs.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Drugs.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Drugs.MOD_ID);

    public static final RegistryObject<PoiType> CHEMIST_POI = POI_TYPES.register("chemist_poi", ()-> new PoiType(ImmutableSet.copyOf(ModBlocks.CHEMISTRY_TOOLS.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> CHEMIST = VILLAGER_PROFESSIONS.register("chemist", ()-> new VillagerProfession("chemist", x -> x.get() == CHEMIST_POI.get(), x -> x.get() == CHEMIST_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.BREWING_STAND_BREW));
    public static void registerPOIs(){
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, CHEMIST_POI.get());
        }catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }
    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
