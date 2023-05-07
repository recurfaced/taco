package com.example.takoapp.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Data
public class TacoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date pleacedAt;
    //@Column("customer_name")
    @NotBlank(message = "delivery name is required")
    private String deliveryName;
    @NotBlank(message = "delivery street is required")
    private String deliveryStreet;
    @NotBlank(message = "delivery city is required")
    private String deliveryCity;
    @NotBlank(message = "State is required")
    private String deliveryState;
    @NotBlank(message = "Zip is required")
    private String deliveryZip;
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2]) (\\/)([2-9][0-9])$",message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3,fraction = 0,message = "Invalid CVV")
    private String ccCVV;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public TacoOrder() {
    }

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
