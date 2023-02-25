package de.tobs.drugs.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import de.tobs.drugs.Drugs;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ChemistryToolsScreen extends AbstractContainerScreen<ChemistryToolsMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Drugs.MOD_ID, "textures/gui/chemistry_tools.png");
    public ChemistryToolsScreen(ChemistryToolsMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float pPartialTick, int pMouseX, int pMouseY) {

    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
