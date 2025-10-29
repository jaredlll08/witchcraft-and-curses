package com.blamejared.wac.client.render.block;

import com.blamejared.wac.WAC;
import com.blamejared.wac.block.entity.MossyPodiumBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LecternBlock;

public class MossyPodiumRenderer implements BlockEntityRenderer<MossyPodiumBlockEntity> {
    
    private final BookModel bookModel;
    private final ItemRenderer itemRenderer;
    private static final ResourceLocation TEXTURE = WAC.rl("textures/entity/mossy_podium_book.png");
    
    public MossyPodiumRenderer(BlockEntityRendererProvider.Context context) {
        
        this.itemRenderer = context.getItemRenderer();
        this.bookModel = new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }
    
    @Override
    public void render(MossyPodiumBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        
        poseStack.pushPose();
        poseStack.translate(0.5F, 0.9, 0.5F);
        float g = blockEntity.getBlockState().getValue(LecternBlock.FACING).getClockWise().toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(-g));
        poseStack.mulPose(Axis.ZP.rotationDegrees(45F));
        poseStack.translate(0.0F, -0.125F, 0.0F);
        poseStack.scale(0.75f, 0.75f, 0.75f);
        this.bookModel.setupAnim(blockEntity.getLevel().getGameTime() + partialTick, 0.1F, 0.9f, 1.2f);
        
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entitySolid(TEXTURE));
        this.bookModel.render(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
        poseStack.popPose();
    }
    
}