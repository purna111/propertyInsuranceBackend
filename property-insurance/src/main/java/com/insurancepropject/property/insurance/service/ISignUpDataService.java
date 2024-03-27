package com.insurancepropject.property.insurance.service;

import com.insurancepropject.property.insurance.dto.SignUpDataDto;

import java.util.List;

public interface ISignUpDataService {

    /**
     *
     * @param signUpDataDto
     */
    void createSignUpData(SignUpDataDto signUpDataDto);

    /**
     *
     * @param mobileNumber
     * @return SignUpData
     */
     SignUpDataDto fetchSignupData(String mobileNumber);



    List<SignUpDataDto> fetchAllSignupData();
}
