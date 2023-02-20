package de.tobs.drugs.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class CocainHighEffect extends MobEffect {

    public CocainHighEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide()){
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 10, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 10, 0));
        }
        super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }
}
