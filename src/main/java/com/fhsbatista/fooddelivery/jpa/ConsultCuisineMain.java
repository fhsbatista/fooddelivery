package com.fhsbatista.fooddelivery.jpa;

import com.fhsbatista.fooddelivery.FooddeliveryApplication;
import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultCuisineMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(
                FooddeliveryApplication.class
        ).web(WebApplicationType.NONE).run(args);
        final var registerCuisine = applicationContext.getBean(RegisterCuisine.class);
        List<Cuisine> cuisines = registerCuisine.list();
        cuisines.forEach(cuisine -> System.out.println(cuisine.getName()));
    }
}
