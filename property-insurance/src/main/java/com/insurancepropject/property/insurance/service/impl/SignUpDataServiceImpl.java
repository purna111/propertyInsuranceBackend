package com.insurancepropject.property.insurance.service.impl;

import com.insurancepropject.property.insurance.dto.SignUpDataDto;
import com.insurancepropject.property.insurance.entity.SignUpData;
import com.insurancepropject.property.insurance.exception.ResourceNotFoundException;
import com.insurancepropject.property.insurance.exception.UserAlreadyExistsException;
import com.insurancepropject.property.insurance.mapper.SignUpDataMapper;
import com.insurancepropject.property.insurance.repository.SignUpDataRepository;
import com.insurancepropject.property.insurance.service.ISignUpDataService;
//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SignUpDataServiceImpl implements ISignUpDataService {
    @Autowired
    private SignUpDataRepository signUpDataRepository;

    private Integer customerIdCounter = 1000; // Initial value for alphanumeric customer ID generation
    @Override
    public void createSignUpData(SignUpDataDto signUpDataDto) {
        SignUpData signUpData = SignUpDataMapper.mapToSignUpData(signUpDataDto,new SignUpData());
        Optional<SignUpData> optionalSignUpData = signUpDataRepository.findById(signUpData.getMobileNumber());
        if(optionalSignUpData.isPresent()){
            throw new UserAlreadyExistsException("user already existed" + " "+  signUpDataDto.getMobileNumber()) ;

        }

        // Generate alphanumeric customer ID
        String customerId = generateAlphaNumericCustomerId();

        // Set the generated customer ID
        signUpData.setCustomerId(customerId);


        SignUpData saved = signUpDataRepository.save(signUpData);

    }

    /**
     *
     * @param mobileNumber
     * @return SignUpDataDto
     */
    @Override
    public SignUpDataDto fetchSignupData(String mobileNumber) {
        SignUpData signUpData= signUpDataRepository.findById(mobileNumber).orElseThrow(
                 ()-> new ResourceNotFoundException("User","mobileNumber",mobileNumber)
        );
        SignUpDataDto signUpDataDto = SignUpDataMapper.mapToSignUpDataDto(signUpData, new SignUpDataDto());
        return signUpDataDto ;
    }

    @Override
    public List<SignUpDataDto> fetchAllSignupData() {
        List<SignUpData> signUpDataList = signUpDataRepository.findAll();
        List<SignUpDataDto> signUpDataDtoList = signUpDataList.stream()
                .map(signUpData -> SignUpDataMapper.mapToSignUpDataDto(signUpData, new SignUpDataDto()))
                .collect(Collectors.toList());
        return signUpDataDtoList;
    }



    private synchronized String generateAlphaNumericCustomerId() {

        // Get current date components
        LocalDateTime currentDateTime = LocalDateTime.now();
        int year = currentDateTime.getYear();
        int month = currentDateTime.getMonthValue();
        int day = currentDateTime.getDayOfMonth();
        int hour = currentDateTime.getHour();
        int minute = currentDateTime.getMinute();
        int second = currentDateTime.getSecond();
        int nanosecond = currentDateTime.getNano();



        // Increment the counter for generating customer IDs
        customerIdCounter++;

        // Generate alphanumeric customer ID by combining a prefix and the incremented counter
//        return "CUS" + customerIdCounter;

        // Generate alphanumeric customer ID by combining year, month, day, and the incremented counter
        return String.format("%04d%02d%02d-CUS-%d%d%d%d%d", year, month, day, customerIdCounter,hour,minute,second,nanosecond);
    }
}
