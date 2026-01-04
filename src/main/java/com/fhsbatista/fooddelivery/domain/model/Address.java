package com.fhsbatista.fooddelivery.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public record Address(
        @Column(name = "zip_code") String zipCode,
        String address,
        String neighborhood,
        String number,
        String complement,
        @ManyToOne @JoinColumn(name = "city_id", nullable = false) City city
) {
}
