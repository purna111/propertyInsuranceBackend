package com.insurancepropject.property.insurance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDetailsDto {
    private String name;
    private String email;
    private String dob;
    private String panCard;
    private String mobile;

    @JsonProperty("isPermanentAddress")
    private boolean isPermanentAddress;
    private AddressDto permanent;
    private AddressDto temporary;

    private String mobileNumber;

    private String customerId;

    private String paymentId;

}
