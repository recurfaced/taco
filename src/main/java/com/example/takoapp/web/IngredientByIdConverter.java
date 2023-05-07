package com.example.takoapp.web;


import com.example.takoapp.domain.Ingredient;
import com.example.takoapp.data.IngredientRepository;
import org.springframework.core.convert.converter.Converter;

public class IngredientByIdConverter implements Converter<String, Ingredient> {


    private final IngredientRepository ingredientRepo;

    public IngredientByIdConverter(IngredientRepository ingredientRepo){
        this.ingredientRepo =ingredientRepo;
    }

    // public Optional <Ingredient> convert(String id) можно было это юзать тк он либо вернет true or false
    @Override
    public Ingredient convert(String id) {

        return ingredientRepo.findById(id).orElse(null);
    }
}
