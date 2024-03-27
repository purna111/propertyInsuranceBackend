package com.insurancepropject.property.insurance.service;

import com.insurancepropject.property.insurance.dto.PropertyDetailsDto;
import com.insurancepropject.property.insurance.entity.PropertyDetails;
import com.insurancepropject.property.insurance.mapper.PropertyDetailsMapper;
import com.insurancepropject.property.insurance.repository.PropertyDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PropertyDetailsServiceImpl implements IPropertyDetailsService {
    private PropertyDetailsRepository propertyDetailsRepository;

    @Override
    public void createPropertyDetails(PropertyDetailsDto propertyDetailsDto) {
        PropertyDetails propertyDetails = PropertyDetailsMapper.mapToPropertyDetails(propertyDetailsDto, new PropertyDetails());
        PropertyDetails propertyDetails1 = propertyDetailsRepository.save(propertyDetails);
    }

    @Override
    public List<PropertyDetailsDto> fetchAllPropertyDetailsRelatedToCustomer(String mobileNumber) {
        List<PropertyDetails> propertyDetailsList = propertyDetailsRepository.findByMobileNumber(mobileNumber);
        List<PropertyDetailsDto> propertyDetailsDtoList = propertyDetailsList.stream()
                .map(propertyDetails -> PropertyDetailsMapper.mapToPropertyDetailsDto(propertyDetails, new PropertyDetailsDto()))
                .collect(Collectors.toList());
        return propertyDetailsDtoList ;

    }

    public List<PropertyDetailsDto> fetchCustomerAllPropertyDetails(String mobileNumber,String paymentId) {
        List<PropertyDetails> propertyDetailsList = propertyDetailsRepository.findByMobileNumberAndPaymentId(mobileNumber,paymentId);
        List<PropertyDetailsDto> propertyDetailsDtoList = propertyDetailsList.stream()
                .map(propertyDetails -> PropertyDetailsMapper.mapToPropertyDetailsDto(propertyDetails, new PropertyDetailsDto()))
                .collect(Collectors.toList());
        return propertyDetailsDtoList ;

    }


}
