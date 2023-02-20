package de.tobs.drugs.item.custom;

import de.tobs.drugs.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BluntItem extends Item {
    public BluntItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        entity.playSound(ModSounds.SMOKING_SOUND.get(), 1.0F, 1.0F);
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public SoundEvent getEatingSound() {
        return ModSounds.NOTHING_SOUND.get();
    }
}
