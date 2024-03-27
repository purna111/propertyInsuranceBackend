package com.insurancepropject.property.insurance.service;

import com.insurancepropject.property.insurance.dto.PremiumCheckDto;
import com.insurancepropject.property.insurance.dto.PropertyDetailsDto;
import com.insurancepropject.property.insurance.entity.PremiumCheck;

import java.util.List;

public interface IPremiumCheckService {
    void createPremiumCheck(PremiumCheck premiumCheck);

    List<PremiumCheckDto> fetchCustomerAllPremiumChecks(String mobileNumber, String paymentId);
}
