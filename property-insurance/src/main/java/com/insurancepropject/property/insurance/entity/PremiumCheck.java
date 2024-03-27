package com.insurancepropject.property.insurance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class PremiumCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int premiumYears;

    private double totalPremiumAmount;
    @JsonProperty("premiumAmount")
    private double premiumAmountPerYear;

    private String mobileNumber;

    private String customerId;

    private String paymentId;

}
