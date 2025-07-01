package com.fhsbatista.fooddelivery.jpa;

import com.fhsbatista.fooddelivery.FooddeliveryApplication;
import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultByIdCuisineMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(
                FooddeliveryApplication.class
        ).web(WebApplicationType.NONE).run(args);

        final var registerCuisine = applicationContext.getBean(CuisineRepository.class);
        final var cuisine = registerCuisine.findById(1L);


        System.out.printf("Id: %d || Nome: %s\n", cuisine.getId(), cuisine.getName());
    }
}
