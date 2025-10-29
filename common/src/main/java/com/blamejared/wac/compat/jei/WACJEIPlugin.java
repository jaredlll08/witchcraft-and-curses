package com.blamejared.wac.compat.jei;

import com.blamejared.wac.WAC;
import com.blamejared.wac.item.WACItems;
import com.blamejared.wac.recipe.WACRecipes;
import com.blamejared.wac.recipe.ritual.Ritual;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class WACJEIPlugin implements IModPlugin {
    
    public static final ResourceLocation ID = WAC.rl("default");
    public static final RecipeType<Ritual> RITUAL = RecipeType.create(WAC.MODID, "ritual", Ritual.class);
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        
        final IGuiHelper gui = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new RitualCategory(gui));
    }
    
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        
        registration.addRecipeCatalyst(WACItems.DEEPSLATE_BASIN.get(), RITUAL);
    }
    
    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        
        final Level level = Minecraft.getInstance().level;
        
        if(level != null) {
            List<Ritual> list = level.getRecipeManager()
                    .getAllRecipesFor(WACRecipes.RITUAL_TYPE.get())
                    .stream()
                    .map(RecipeHolder::value)
                    .toList();
            registration.addRecipes(RITUAL, list);
        }
    }
    
    @Override
    public ResourceLocation getPluginUid() {
        
        return ID;
    }
    
}
