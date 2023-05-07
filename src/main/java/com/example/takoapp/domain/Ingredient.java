package com.example.takoapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.lang.reflect.Type;
@Data // можно не вписать геттер и сеттер, и прописать эту аннотацию и при компиляции спринг сам создаст их
@Entity
@AllArgsConstructor // создает конструктор для всех полей класса
@NoArgsConstructor
public class Ingredient {
    @Id
    private String id;
    private String name;
    private Type type;

    public enum Type{
        WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
    }
}
