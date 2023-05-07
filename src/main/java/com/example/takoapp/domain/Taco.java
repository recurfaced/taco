package com.example.takoapp.domain;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5,message = "Name must be at least 5 characters long")
    private String name;


    @NotNull
    @Size(min = 1,message = "You must choose at least 1 ingredient")
    @ManyToMany
    List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
}
