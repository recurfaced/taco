package com.example.takoapp;

import com.example.takoapp.data.IngredientRepository;
import com.example.takoapp.data.UserRepository;
import com.example.takoapp.domain.Ingredient;
import com.example.takoapp.domain.Ingredient.*;
import com.example.takoapp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.takoapp.data")
public class TakoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakoappApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo){

		return args -> {
			repo.deleteAll();
			repo.save(new Ingredient("FLTO","Flour Tortila",Type.WRAP));
			repo.save(new Ingredient("COTO","Corn Tortila", Type.WRAP));
			repo.save(new Ingredient("GRBF","Ground Beef", Type.PROTEIN));
			repo.save(new Ingredient("CARN","Carnitas", Type.PROTEIN));
			repo.save(new Ingredient("TMTO","Diced Tomatoes", Type.VEGGIES));
			repo.save(new Ingredient("LETC","Lettuce", Type.VEGGIES));
			repo.save(new Ingredient("CHED","Cheddar", Type.CHEESE));
			repo.save(new Ingredient("JACK","Monterrey Jack",Type.CHEESE));
			repo.save(new Ingredient("SRCR","Salsa", Type.SAUCE));
			repo.save(new Ingredient("SLSA","Sour Cream",Type.SAUCE));
			User user = new User("john", "password", "John Doe", "123 Main St", "Anytown", "USA", "12345", "555-555-5555");

			userRepository.save(user);

		};

	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
