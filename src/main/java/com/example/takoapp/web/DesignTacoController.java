package com.example.takoapp.web;


import com.example.takoapp.domain.Ingredient;
import com.example.takoapp.domain.Taco;
import com.example.takoapp.domain.TacoOrder;
import com.example.takoapp.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.takoapp.domain.Ingredient.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    // всю логику класса JdbcIngredientRepository импортируем в контроллер через конструктор.
    // если бы в классе JdbcIngredientRepository не была бы указана аннотация @Repository то спирнг бы нас нахуй послал
    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Iterable<Ingredient> ingredients =ingredientRepo.findAll();


        Type[] types = Type.values();

        for (Type type:types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients,type));

        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }
    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors,
                              @ModelAttribute TacoOrder tacoOrder){

        if (errors.hasErrors()){
            return "design";
        }
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Ingredient.Type type) {
        return StreamSupport.stream(ingredients.spliterator(),false)// превращает все гавно с ингредиентами в поток
                .filter(x->x.getType().equals(type)) // создает фильтр, в качестве предиката достает его тип и проеряет
                .collect(Collectors.toList()); // собираем в массивчик
    }
}
