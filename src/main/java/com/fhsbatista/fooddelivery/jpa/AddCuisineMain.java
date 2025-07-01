package com.fhsbatista.fooddelivery.jpa;

import com.fhsbatista.fooddelivery.FooddeliveryApplication;
import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class AddCuisineMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(
                FooddeliveryApplication.class
        ).web(WebApplicationType.NONE).run(args);

        final var registerCuisine = applicationContext.getBean(CuisineRepository.class);

        final var cuisine1 = new Cuisine();
        cuisine1.setName("brazilian");
        final var cuisine2 = new Cuisine();
        cuisine2.setName("peruvian");

        registerCuisine.save(cuisine1);
        registerCuisine.save(cuisine2);
    }
}
