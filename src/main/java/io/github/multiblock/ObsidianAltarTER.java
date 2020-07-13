package io.github.multiblock;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

public class ObsidianAltarTER extends TileEntityRenderer<ObsidianAltarEntity> {
    public ObsidianAltarTER(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(ObsidianAltarEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.5, 0.8, 0.5);
        matrixStackIn.scale(0.5f, 0.5f, 0.5f);
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = tileEntityIn.getItemStack();
        IBakedModel ibakedmodel = itemRenderer.getItemModelWithOverrides(stack, tileEntityIn.getWorld(), null);
        itemRenderer.renderItem(stack, ItemCameraTransforms.TransformType.FIXED, true, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, ibakedmodel);
        matrixStackIn.pop();
    }
}
