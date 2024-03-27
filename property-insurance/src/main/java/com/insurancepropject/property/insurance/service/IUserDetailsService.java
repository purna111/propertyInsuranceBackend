package com.insurancepropject.property.insurance.service;

import com.insurancepropject.property.insurance.dto.UserDetailsDto;

import java.util.List;

public interface IUserDetailsService {
    void createUserDetails(UserDetailsDto userDetailsDto);


    UserDetailsDto fetchUserDetailsByName(String name);

    List<UserDetailsDto> fetchCustomerAllUserDetails(String mobileNumber, String paymentId);
}
