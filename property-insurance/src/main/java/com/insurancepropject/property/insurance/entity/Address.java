package com.insurancepropject.property.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data@Embeddable
public class Address {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String flatNo;
    private String lane;
    private String area;
    private String city;
    private String zipcode;
    private String state;
    private String country;
}
