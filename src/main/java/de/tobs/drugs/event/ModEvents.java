package de.tobs.drugs.event;

import de.tobs.drugs.Drugs;
import de.tobs.drugs.block.ModBlocks;
import de.tobs.drugs.item.ModItems;
import de.tobs.drugs.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Drugs.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        //----------------------------------------Crackie----------------------------------------------------------------------------------
        if (event.getType() == ModVillagers.CRACKIE.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.EMERALD, 8);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(ModItems.CANNABIS_ONE_GRAMM.get(), 1), stack, 5, 4, 0.02F));
        }
        if (event.getType() == ModVillagers.CRACKIE.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.EMERALD, 40);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(ModItems.COCAIN.get(), 1), stack, 3, 8, 0.02F));
        }
        //----------------------------------------Chemist----------------------------------------------------------------------------------
        if (event.getType() == ModVillagers.CHEMIST.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.SULFUR_ACID.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(ModBlocks.SULFUR.get(), 1), new ItemStack(Items.WATER_BUCKET, 1), stack, 5, 4, 0.02F));
        }
        if (event.getType() == ModVillagers.CHEMIST.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.PETROL_BUCKET.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 15), stack, 3, 12, 0.02F));
        }
        if (event.getType() == ModVillagers.CHEMIST.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COCAIN.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(ModItems.COCA_PASTE_BUCKET.get(), 1), new ItemStack(Items.EMERALD, 1), stack, 3, 12, 0.02F));
        }

    }
}
