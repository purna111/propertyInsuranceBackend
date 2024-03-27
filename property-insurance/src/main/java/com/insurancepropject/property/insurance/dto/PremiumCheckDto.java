package com.insurancepropject.property.insurance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PremiumCheckDto {

    private int premiumYears;

    private double totalPremiumAmount;
    @JsonProperty("premiumAmount")
    private double premiumAmountPerYear;

    private String mobileNumber;

    private String customerId;

    private String paymentId;

}
