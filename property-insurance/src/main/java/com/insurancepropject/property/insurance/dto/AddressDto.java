package com.insurancepropject.property.insurance.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String flatNo;
    private String lane;
    private String area;
    private String city;
    private String zipcode;
    private String state;
    private String country;
}
