package com.insurancepropject.property.insurance.mapper;

import com.insurancepropject.property.insurance.dto.SignUpDataDto;
import com.insurancepropject.property.insurance.entity.SignUpData;

public class SignUpDataMapper {

    public static SignUpDataDto mapToSignUpDataDto(SignUpData signUpData,SignUpDataDto signUpDataDto){
        signUpDataDto.setEmail(signUpData.getEmail());
        signUpDataDto.setUserName(signUpData.getUserName());
        signUpDataDto.setMobileNumber(signUpData.getMobileNumber());
        signUpDataDto.setNewPassword(signUpData.getNewPassword());
        signUpDataDto.setCustomerId(signUpData.getCustomerId());

        return signUpDataDto ;

    }

    public static SignUpData mapToSignUpData(SignUpDataDto signUpDataDto,SignUpData signUpData){
        signUpData.setEmail(signUpDataDto.getEmail());
        signUpData.setUserName(signUpDataDto.getUserName());
        signUpData.setMobileNumber(signUpDataDto.getMobileNumber());
        signUpData.setNewPassword(signUpDataDto.getNewPassword());
        signUpData.setCustomerId(signUpDataDto.getCustomerId());

        return signUpData ;
    }
}
