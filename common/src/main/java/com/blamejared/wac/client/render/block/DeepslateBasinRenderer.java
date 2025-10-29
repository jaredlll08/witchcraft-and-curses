package com.blamejared.wac.client.render.block;

import com.blamejared.wac.block.entity.DeepslateBasinBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;

import java.util.stream.IntStream;

public class DeepslateBasinRenderer implements BlockEntityRenderer<DeepslateBasinBlockEntity> {
    
    private final ItemRenderer itemRenderer;
    
    public DeepslateBasinRenderer(BlockEntityRendererProvider.Context context) {
        
        this.itemRenderer = context.getItemRenderer();
    }
    
    @Override
    public void render(DeepslateBasinBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        
        float yOffset = (blockEntity.getLevel().getGameTime() + partialTick) / 64f;
        poseStack.pushPose();
        poseStack.translate(0.5F, 0.5, 0.5F);
        poseStack.scale(0.5f, 0.5f, 0.5f);
        poseStack.translate(-0.5F, 0, -0.5F);
        BlockPos pos = blockEntity.getBlockPos();
        PerlinNoise perlinNoise = PerlinNoise.create(new LegacyRandomSource(2906), IntStream.range(0, 1));
        if(!blockEntity.isEmpty()) {
            for(int i = 0; i < blockEntity.items().size(); i++) {
                double value = perlinNoise.getValue(pos.getX() + i, yOffset, pos.getZ() + i) * 0.5;
                poseStack.translate(0.5f * (i % 3), value, 0.5f * Math.floor(i / 3f));
                float rotation = Math.round(value * 360) + blockEntity.getLevel().getGameTime() + partialTick;
                poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
                ItemStack item = blockEntity.getItem(i);
                this.itemRenderer.renderStatic(item, ItemDisplayContext.GROUND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, blockEntity.getLevel(), i);
                poseStack.mulPose(Axis.YP.rotationDegrees(-(rotation)));
                poseStack.translate(-0.5f * (i % 3), -value, -0.5f * Math.floor(i / 3f));
            }
        }
        poseStack.popPose();
    }
    
}