package com.blamejared.wac.recipe;

import com.blamejared.wac.WAC;
import com.blamejared.wac.platform.IRegister;
import com.blamejared.wac.recipe.ritual.Ritual;
import com.blamejared.wac.registry.RegistrationProvider;
import com.blamejared.wac.registry.RegistryObject;
import com.google.auto.service.AutoService;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

@AutoService(IRegister.class)
public class WACRecipes implements IRegister {
    
    public static final RegistrationProvider<RecipeSerializer<?>> SERIALIZER = RegistrationProvider.get(Registries.RECIPE_SERIALIZER, WAC.MODID);
    public static final RegistrationProvider<RecipeType<?>> TYPE = RegistrationProvider.get(Registries.RECIPE_TYPE, WAC.MODID);
    
    public static final RegistryObject<RecipeSerializer<Ritual>> RITUAL_SERIALIZER = SERIALIZER.register("ritual", Ritual.Serializer::new);
    public static final RegistryObject<RecipeType<Ritual>> RITUAL_TYPE = TYPE.register("ritual", () -> new RecipeType<>() {
        @Override
        public String toString() {
            
            return WAC.rl("ritual").toString();
        }
    });
    
}
