package com.example.takoapp.web.api;


import com.example.takoapp.data.IngredientRepository;
import com.example.takoapp.domain.Ingredient;
import com.example.takoapp.domain.Taco;
import com.example.takoapp.data.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos",produces = "application/json") // рест юзается для того чтобы и на твои ебучие часики и планшетики и телефоны, программа могла тоже вернуть результат твоих мувиков,обычно он просто бэкает html странички на пк юзера
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoRestController {


   private TacoRepository tacoRepo;
    private IngredientRepository ingredientRepo;

    public TacoRestController(IngredientRepository ingredientRepo,TacoRepository tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }



    @GetMapping(params = "recent")//../api/tacos?recent
    public Iterable<Taco> recentTacos(){
        PageRequest page =PageRequest.of(
                0,
                12,
                Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }
    @GetMapping("/ingredients")
    public Iterable<Ingredient> allIngredients() {
        return ingredientRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(
            @PathVariable("id") Long id
    ) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if (!optTaco.isPresent()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optTaco.get(),HttpStatus.OK);
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){

        return tacoRepo.save(taco);
    }
}
