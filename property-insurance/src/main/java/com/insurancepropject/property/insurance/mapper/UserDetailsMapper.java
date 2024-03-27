package com.insurancepropject.property.insurance.mapper;

import com.insurancepropject.property.insurance.dto.UserDetailsDto;
import com.insurancepropject.property.insurance.entity.UserDetails;

public class UserDetailsMapper {

    public static UserDetailsDto mapToUserDetailsDto(UserDetails userDetails, UserDetailsDto userDetailsDto){

        userDetailsDto.setName(userDetails.getName());
        userDetailsDto.setEmail(userDetails.getEmail());
        userDetailsDto.setDob(userDetails.getDob());
        userDetailsDto.setPanCard(userDetails.getPanCard());
        userDetailsDto.setMobile(userDetails.getMobile());
        userDetailsDto.setPermanentAddress(userDetails.isPermanentAddress());
        userDetailsDto.setPermanent(AddressMapper.toDTO(userDetails.getPermanent()));
        userDetailsDto.setTemporary(AddressMapper.toDTO(userDetails.getTemporary()));
        userDetailsDto.setMobileNumber(userDetails.getMobileNumber());
        userDetailsDto.setCustomerId(userDetails.getCustomerId());
        userDetailsDto.setPaymentId(userDetails.getPaymentId());


        return userDetailsDto ;
    }

    public static UserDetails mapToUserdetails(UserDetailsDto userDetailsDto, UserDetails userDetails){

        userDetails.setName(userDetailsDto.getName());
        userDetails.setEmail(userDetailsDto.getEmail());
        userDetails.setDob(userDetailsDto.getDob());
        userDetails.setPanCard(userDetailsDto.getPanCard());
        userDetails.setMobile(userDetailsDto.getMobile());
        userDetails.setPermanentAddress(userDetailsDto.isPermanentAddress());
        userDetails.setPermanent(AddressMapper.toEntity(userDetailsDto.getPermanent()));
        userDetails.setTemporary(AddressMapper.toEntity(userDetailsDto.getTemporary()));
        userDetails.setMobileNumber(userDetailsDto.getMobileNumber());
        userDetails.setCustomerId(userDetailsDto.getCustomerId());
        userDetails.setPaymentId(userDetailsDto.getPaymentId());

        return userDetails ;
    }

}
