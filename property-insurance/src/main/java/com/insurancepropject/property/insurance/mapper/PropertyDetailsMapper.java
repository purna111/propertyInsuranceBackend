package com.insurancepropject.property.insurance.mapper;

import com.insurancepropject.property.insurance.dto.PropertyDetailsDto;
import com.insurancepropject.property.insurance.entity.PropertyDetails;

public class PropertyDetailsMapper {

    public static PropertyDetailsDto mapToPropertyDetailsDto(PropertyDetails propertyDetails,PropertyDetailsDto propertyDetailsDto){
        propertyDetailsDto.setCarpetArea(propertyDetails.getCarpetArea());
        propertyDetailsDto.setCurrentMarketValue(propertyDetails.getCurrentMarketValue());
        propertyDetailsDto.setAgeOfBuilding(propertyDetails.getAgeOfBuilding());
        propertyDetailsDto.setZipcode(propertyDetails.getZipcode());
        propertyDetailsDto.setSecurity(propertyDetails.isSecurity());
        propertyDetailsDto.setEmployed(propertyDetails.isEmployed());
        propertyDetailsDto.setMobileNumber(propertyDetails.getMobileNumber());
        propertyDetailsDto.setCustomerId(propertyDetails.getCustomerId());
        propertyDetailsDto.setPaymentId(propertyDetails.getPaymentId());


        return propertyDetailsDto ;
    }

    public static PropertyDetails mapToPropertyDetails(PropertyDetailsDto propertyDetailsDto,PropertyDetails propertyDetails){

        propertyDetails.setCurrentMarketValue(propertyDetailsDto.getCurrentMarketValue());
        propertyDetails.setCarpetArea(propertyDetailsDto.getCarpetArea());
        propertyDetails.setAgeOfBuilding(propertyDetailsDto.getAgeOfBuilding());
        propertyDetails.setZipcode(propertyDetailsDto.getZipcode());
        propertyDetails.setSecurity(propertyDetailsDto.isSecurity());
        propertyDetails.setEmployed(propertyDetailsDto.isEmployed());
        propertyDetails.setMobileNumber(propertyDetailsDto.getMobileNumber());
        propertyDetails.setCustomerId(propertyDetailsDto.getCustomerId());
        propertyDetails.setPaymentId(propertyDetailsDto.getPaymentId());

        return propertyDetails ;
    }
}
