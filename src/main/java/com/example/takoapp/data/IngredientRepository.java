package com.example.takoapp.data;

import com.example.takoapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository
        extends CrudRepository<Ingredient,String> {
}
