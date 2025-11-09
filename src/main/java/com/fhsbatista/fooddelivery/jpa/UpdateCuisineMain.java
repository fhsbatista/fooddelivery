package com.fhsbatista.fooddelivery.jpa;

import com.fhsbatista.fooddelivery.FooddeliveryApplication;
import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class UpdateCuisineMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(
                FooddeliveryApplication.class
        ).web(WebApplicationType.NONE).run(args);

        final var registerCuisine = applicationContext.getBean(CuisineRepository.class);

        final var cuisine1 = new Cuisine();

        cuisine1.setId(1L);
        cuisine1.setName("american");

        registerCuisine.save(cuisine1);
    }
}
