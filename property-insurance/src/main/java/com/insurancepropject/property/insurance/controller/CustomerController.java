package com.insurancepropject.property.insurance.controller;

import com.insurancepropject.property.insurance.dto.PremiumCheckDto;
import com.insurancepropject.property.insurance.dto.PropertyDetailsDto;
import com.insurancepropject.property.insurance.dto.SignUpDataDto;
import com.insurancepropject.property.insurance.dto.UserDetailsDto;
import com.insurancepropject.property.insurance.service.IPremiumCheckService;
import com.insurancepropject.property.insurance.service.IPropertyDetailsService;
import com.insurancepropject.property.insurance.service.ISignUpDataService;
import com.insurancepropject.property.insurance.service.IUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@CrossOrigin(value = "*")
public class CustomerController {

    private IPropertyDetailsService iPropertyDetailsService;
    private IPremiumCheckService iPremiumCheckService;
    private ISignUpDataService iSignUpDataService;
    private IUserDetailsService iUserDetailsService;

    @GetMapping("fetchAllPropertyDetails")
    public List<PropertyDetailsDto> fetchAllPropertyDetails (@RequestParam String mobileNumber){
        List<PropertyDetailsDto> propertyDetailsDtoList = iPropertyDetailsService.fetchAllPropertyDetailsRelatedToCustomer(mobileNumber);
        return propertyDetailsDtoList;


    }

    @GetMapping("fetchCustomerAllPropertyDetails")
    public List<PropertyDetailsDto> getPropertyDetailsByMobileNumberAndPaymentId (@RequestParam("mobileNumber") String mobileNumber,
                                                              @RequestParam("paymentId") String paymentId){
        List<PropertyDetailsDto> propertyDetailsDtoList = iPropertyDetailsService.fetchCustomerAllPropertyDetails(mobileNumber,paymentId);
        return propertyDetailsDtoList;

    }


    @GetMapping("fetchCustomersAllPremiumChecks")
    public List<PremiumCheckDto> getPremiumChecksByMobileNumberAndPaymentId (@RequestParam("mobileNumber") String mobileNumber,
                                                                             @RequestParam("paymentId") String paymentId){
        List<PremiumCheckDto> propertyDetailsDtoList = iPremiumCheckService.fetchCustomerAllPremiumChecks(mobileNumber,paymentId);
        return propertyDetailsDtoList;

    }

    @GetMapping("fetchCustomersAllUserDetails")
    public List<UserDetailsDto> getUserDetailsByMobileNumberAndPaymentId(@RequestParam("mobileNumber") String mobileNumber,
                                                                         @RequestParam("paymentId") String paymentId){
        List<UserDetailsDto> userDetailsDtoList = iUserDetailsService.fetchCustomerAllUserDetails(mobileNumber, paymentId);
        return userDetailsDtoList;
    }









}
