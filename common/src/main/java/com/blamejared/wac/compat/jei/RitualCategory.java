package com.blamejared.wac.compat.jei;

import com.blamejared.wac.item.WACItems;
import com.blamejared.wac.recipe.ritual.Ritual;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.ICraftingGridHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.MobEffectTextureManager;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class RitualCategory implements IRecipeCategory<Ritual> {
    
    private static final ResourceLocation EFFECT_BACKGROUND_SMALL_SPRITE = ResourceLocation.withDefaultNamespace("container/inventory/effect_background_small");
    
    private final Component title;
    private final IDrawable icon;
    private final IDrawableStatic background;
    private final IDrawableStatic blankSlot;
    
    private final ICraftingGridHelper craftingGridHelper;
    private final IGuiHelper guiHelper;
    private final Minecraft mc;
    
    public RitualCategory(IGuiHelper guiHelper) {
        
        this.title = Component.translatable("gui.jei.category.wac.ritual");
        this.icon = guiHelper.createDrawableItemStack(WACItems.DEEPSLATE_BASIN.get().getDefaultInstance());
        this.background = guiHelper.createBlankDrawable(116, 80);
        this.blankSlot = guiHelper.getSlotDrawable();
        this.craftingGridHelper = guiHelper.createCraftingGridHelper();
        this.guiHelper = guiHelper;
        this.mc = Minecraft.getInstance();
    }
    
    @NotNull
    @Override
    public RecipeType<Ritual> getRecipeType() {
        
        return WACJEIPlugin.RITUAL;
    }
    
    @NotNull
    @Override
    public Component getTitle() {
        
        return this.title;
    }
    
    @NotNull
    @Override
    public IDrawable getBackground() {
        
        return this.background;
    }
    
    @Nullable
    @Override
    public IDrawable getIcon() {
        
        return this.icon;
    }
    
    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull Ritual recipe, @NotNull IFocusGroup focuses) {
        
        craftingGridHelper.createAndSetIngredients(builder, recipe.ingredients(), 3, 3);
        builder.setShapeless();
    }
    
    @Override
    public void draw(@NotNull Ritual recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics graphics, double mouseX, double mouseY) {
        
        graphics.drawCenteredString(mc.font, Component.translatable("gui.jei.category.wac.enchantment_power", recipe.requiredEnchantingPower()), 58, 80 - 10, 0xFFFFFFFF);
        IDrawableStatic recipeArrow = guiHelper.getRecipeArrow();
        recipeArrow.draw(graphics, 58, (54 - recipeArrow.getHeight()) / 2);
        graphics.blitSprite(EFFECT_BACKGROUND_SMALL_SPRITE, 83, 45 - 32, 32, 32);
        
        MobEffectTextureManager mobeffecttexturemanager = mc.getMobEffectTextures();
        Holder<MobEffect> holder = recipe.output().getEffect();
        TextureAtlasSprite textureatlassprite = mobeffecttexturemanager.get(holder);
        graphics.blit(89, 45 - 32 + 7, 0, 18, 18, textureatlassprite);
        
        if(mouseX > 83 && mouseX < 83 + 18 && mouseY > 45 - 32 && mouseY < 45 - 32 + 18) {
            List<Component> list = List.of(
                    this.getEffectName(recipe.output()),
                    MobEffectUtil.formatDuration(recipe.output(), 1.0F, mc.level.tickRateManager().tickrate())
            );
            graphics.renderTooltip(mc.font, list, Optional.empty(), (int) mouseX, (int) mouseY);
        }
    }
    
    private Component getEffectName(MobEffectInstance effect) {
        
        MutableComponent mutablecomponent = effect.getEffect().value().getDisplayName().copy();
        if(effect.getAmplifier() >= 1 && effect.getAmplifier() <= 9) {
            mutablecomponent.append(CommonComponents.SPACE)
                    .append(Component.translatable("enchantment.level." + (effect.getAmplifier() + 1)));
        }
        
        return mutablecomponent;
    }
    
}