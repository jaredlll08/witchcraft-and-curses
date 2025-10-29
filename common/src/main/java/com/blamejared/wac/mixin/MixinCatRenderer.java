package com.blamejared.wac.mixin;

import com.blamejared.wac.WAC;
import net.minecraft.client.model.CatModel;
import net.minecraft.client.renderer.entity.CatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CatRenderer.class)
public abstract class MixinCatRenderer extends MobRenderer<Cat, CatModel<Cat>> {
    
    public MixinCatRenderer(EntityRendererProvider.Context context, CatModel<Cat> model, float shadowRadius) {
        
        super(context, model, shadowRadius);
    }
    
    @Inject(method = "getTextureLocation(Lnet/minecraft/world/entity/animal/Cat;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    public void overrideTexture(Cat entity, CallbackInfoReturnable<ResourceLocation> cir) {
        
        if(entity.getCustomName() != null && entity.getCustomName().getString().equals("Oreo")) {
            cir.setReturnValue(WAC.rl("textures/entity/oreo.png"));
        }
    }
    
}
