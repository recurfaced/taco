package com.example.takoapp.restclient;

import com.example.takoapp.domain.Ingredient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TacoCloudRestClient {
    private RestTemplate rest;


    public TacoCloudRestClient(RestTemplate rest) {
        this.rest = rest;

    }

    public Ingredient getIngredientById(String ingredientId){
        return rest.getForObject(
                "http://localhost:8080/ingredients/{id}",
                Ingredient.class,
                ingredientId
        );

    }

    public List<Ingredient> getAllIngredients(){
        return rest.exchange(
                "http://localhost:8080/ingredients/{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Ingredient>>() {
                }).getBody();
    }
}
