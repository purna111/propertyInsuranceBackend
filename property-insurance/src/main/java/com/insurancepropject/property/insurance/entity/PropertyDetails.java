package com.insurancepropject.property.insurance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long currentMarketValue;

    private  long carpetArea;

    private String ageOfBuilding;
    @JsonProperty("pincode")
    private long zipcode;

    private boolean security;

    @JsonProperty("salaried")
    private boolean isEmployed;

    private String mobileNumber;

    private String customerId;

    private String paymentId;


}



