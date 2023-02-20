package de.tobs.drugs.item.custom;

import de.tobs.drugs.Drugs;
import de.tobs.drugs.effect.ModEffects;
import de.tobs.drugs.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CocainItem extends Item {
    public CocainItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        entity.playSound(ModSounds.SNIFFING_SOUND.get(), 1.0F, 1.0F);
        return super.finishUsingItem(stack, level, entity);
    }
    @Override
    public SoundEvent getEatingSound() {
        return ModSounds.NOTHING_SOUND.get();
    }

}
