package com.insurancepropject.property.insurance.service;

import com.insurancepropject.property.insurance.dto.PropertyDetailsDto;

import java.util.List;

public interface IPropertyDetailsService {
    void createPropertyDetails(PropertyDetailsDto propertyDetailsDto);

    List<PropertyDetailsDto> fetchAllPropertyDetailsRelatedToCustomer(String mobileNumber);

    List<PropertyDetailsDto> fetchCustomerAllPropertyDetails(String mobileNumber,String paymentId);
}
