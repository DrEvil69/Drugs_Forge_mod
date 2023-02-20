package de.tobs.drugs.sound;

import de.tobs.drugs.Drugs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Drugs.MOD_ID);
    public static final RegistryObject<SoundEvent> SMOKING_SOUND = registerSoundEvent("smoking_sound");
    public static final RegistryObject<SoundEvent> SNIFFING_SOUND = registerSoundEvent("sniffing_sound");
    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, ()-> new SoundEvent(new ResourceLocation(Drugs.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
