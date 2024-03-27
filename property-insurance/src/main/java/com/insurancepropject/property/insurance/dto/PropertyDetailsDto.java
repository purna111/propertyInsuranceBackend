package com.insurancepropject.property.insurance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
public class PropertyDetailsDto {

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
