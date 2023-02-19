package de.tobs.drugs.block.custom;

import de.tobs.drugs.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class CannabisCropBlock extends CropBlock {

    public CannabisCropBlock(Properties p_52247_) {
        super(p_52247_);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CANNABIS_SEEDS.get();
    }

}
