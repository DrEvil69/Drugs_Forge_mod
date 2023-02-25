package de.tobs.drugs;

import com.mojang.logging.LogUtils;
import de.tobs.drugs.block.ModBlocks;
import de.tobs.drugs.block.entity.ModBlockEntities;
import de.tobs.drugs.effect.ModEffects;
import de.tobs.drugs.event.ModEvents;
import de.tobs.drugs.item.ModItems;
import de.tobs.drugs.screen.ModMenuTypes;
import de.tobs.drugs.sound.ModSounds;
import de.tobs.drugs.villager.ModVillagers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(Drugs.MOD_ID)
public class Drugs
{
    public static final String MOD_ID = "drugs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Drugs()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();;

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEffects.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()-> {
            ModVillagers.registerPOIs();
        });
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANNABIS_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COCA_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHEMISTRY_TOOLS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRACK_TOOLS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COCA_LEAVES_PILE.get(), RenderType.translucent());
        }
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }
}
