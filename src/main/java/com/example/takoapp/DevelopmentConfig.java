package com.example.takoapp;


import com.example.takoapp.data.IngredientRepository;
import com.example.takoapp.data.TacoRepository;
import com.example.takoapp.data.UserRepository;
import com.example.takoapp.domain.Ingredient.*;
import com.example.takoapp.domain.Ingredient;
import com.example.takoapp.domain.Taco;
import com.example.takoapp.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {



}
