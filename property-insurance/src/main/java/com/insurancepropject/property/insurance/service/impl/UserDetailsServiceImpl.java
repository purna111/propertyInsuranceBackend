package com.insurancepropject.property.insurance.service.impl;

import com.insurancepropject.property.insurance.dto.UserDetailsDto;
import com.insurancepropject.property.insurance.entity.UserDetails;
import com.insurancepropject.property.insurance.exception.ResourceNotFoundException;
import com.insurancepropject.property.insurance.mapper.UserDetailsMapper;
import com.insurancepropject.property.insurance.repository.UserDetailsRepository;
import com.insurancepropject.property.insurance.service.IUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements IUserDetailsService {

    private UserDetailsRepository userDetailsRepository;

    @Override
    public void createUserDetails(UserDetailsDto userDetailsDto) {
        UserDetails userDetails = UserDetailsMapper.mapToUserdetails(userDetailsDto, new UserDetails());
        UserDetails userDetails1 = userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetailsDto fetchUserDetailsByName(String name) {
        UserDetails userDetailsByName = userDetailsRepository.findByName(name).orElseThrow(
                ()-> new ResourceNotFoundException("UserDetails","Name",name)
        );
        UserDetailsDto userDetailsDto = UserDetailsMapper.mapToUserDetailsDto(userDetailsByName, new UserDetailsDto());
        return userDetailsDto ;

    }

    @Override
    public List<UserDetailsDto> fetchCustomerAllUserDetails(String mobileNumber, String paymentId) {
        List<UserDetails> userDetailsList = userDetailsRepository.findByMobileNumberAndPaymentId(mobileNumber, paymentId);
        List<UserDetailsDto> userDetailsDtoList = userDetailsList.stream().map(userDetails -> UserDetailsMapper.mapToUserDetailsDto(userDetails, new UserDetailsDto()))
                .collect(Collectors.toList());
        return userDetailsDtoList;
    }
}
