package de.tobs.drugs.effect;

import de.tobs.drugs.Drugs;
import de.tobs.drugs.effect.custom.CannabisHighEffect;
import de.tobs.drugs.effect.custom.CocainHighEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Drugs.MOD_ID);
    public static final RegistryObject<MobEffect> CANNABIS_HIGH = MOB_EFFECTS.register("cannabis_high", () -> new CannabisHighEffect(MobEffectCategory.HARMFUL, 3124687));
    public static final RegistryObject<MobEffect> COCAIN_HIGH = MOB_EFFECTS.register("cocain_high", () -> new CocainHighEffect(MobEffectCategory.HARMFUL, 3124687));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
