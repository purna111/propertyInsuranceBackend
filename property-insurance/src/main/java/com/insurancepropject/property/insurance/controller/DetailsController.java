package com.insurancepropject.property.insurance.controller;

import com.insurancepropject.property.insurance.constants.DetailsConstants;
import com.insurancepropject.property.insurance.dto.PropertyDetailsDto;
import com.insurancepropject.property.insurance.dto.ResponseDto;
import com.insurancepropject.property.insurance.dto.SignUpDataDto;
import com.insurancepropject.property.insurance.dto.UserDetailsDto;
import com.insurancepropject.property.insurance.entity.PremiumCheck;
import com.insurancepropject.property.insurance.entity.PropertyDetails;
import com.insurancepropject.property.insurance.service.IPremiumCheckService;
import com.insurancepropject.property.insurance.service.IPropertyDetailsService;
import com.insurancepropject.property.insurance.service.ISignUpDataService;
import com.insurancepropject.property.insurance.service.IUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@CrossOrigin(value = "*")
public class DetailsController {

    private IPropertyDetailsService iPropertyDetailsService;
    private IPremiumCheckService iPremiumCheckService;
    private ISignUpDataService iSignUpDataService;
    private IUserDetailsService iUserDetailsService;

    @GetMapping("testing")
    public String sayHello(){
        return " ohh hello there ";
    }

    @PostMapping("savePropertyDetails")
    public ResponseEntity<PropertyDetailsDto> CreatePropertyDetails(@RequestBody PropertyDetailsDto propertyDetailsDto){
        // Convert string values to appropriate data types
        propertyDetailsDto.setCurrentMarketValue(Long.parseLong(String.valueOf(propertyDetailsDto.getCurrentMarketValue())));
        propertyDetailsDto.setCarpetArea(Long.parseLong(String.valueOf(propertyDetailsDto.getCarpetArea())));
        propertyDetailsDto.setZipcode(Long.parseLong(String.valueOf(propertyDetailsDto.getZipcode())));


        iPropertyDetailsService.createPropertyDetails(propertyDetailsDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(propertyDetailsDto);

    }

    @PostMapping("savePremiumCheck")
    public ResponseEntity<PremiumCheck> CreatePremiumCheck(@RequestBody PremiumCheck premiumCheck){
        iPremiumCheckService.createPremiumCheck(premiumCheck);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(premiumCheck);

    }
    @PostMapping("signUpData")
    public ResponseEntity<ResponseDto> createSignUpData (@RequestBody SignUpDataDto signUpDataDto){
        iSignUpDataService.createSignUpData(signUpDataDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(DetailsConstants.STATUS_200,DetailsConstants.MESSAGE_201));

    }
    @GetMapping("fetchSignUpData")
    public ResponseEntity<SignUpDataDto> fetchSignUpData (@RequestParam String mobileNumber){
    SignUpDataDto signUpDataDto = iSignUpDataService.fetchSignupData(mobileNumber);

    return ResponseEntity.status(HttpStatus.OK)
            .body(signUpDataDto);

    }

    @GetMapping("fetchAllSignUpData")
    public List<SignUpDataDto> fetchAllSignUpData (){
        List<SignUpDataDto> signUpDataDtoList = iSignUpDataService.fetchAllSignupData();
        return signUpDataDtoList;


    }


    @PostMapping("createUser")
    public ResponseEntity<UserDetailsDto> createUserDetails (@RequestBody UserDetailsDto userDetailsDto){
        iUserDetailsService.createUserDetails(userDetailsDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userDetailsDto) ;
    }
    @GetMapping("fetchUserDetails")
    public ResponseEntity<UserDetailsDto> fetchUserDetails (@RequestParam String name){
        UserDetailsDto userDetailsDto = iUserDetailsService.fetchUserDetailsByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .body(userDetailsDto) ;
    }


}
