package com.insurancepropject.property.insurance.service.impl;

import com.insurancepropject.property.insurance.dto.PremiumCheckDto;
import com.insurancepropject.property.insurance.dto.PropertyDetailsDto;
import com.insurancepropject.property.insurance.entity.PremiumCheck;
import com.insurancepropject.property.insurance.entity.PropertyDetails;
import com.insurancepropject.property.insurance.mapper.PremiumCheckMapper;
import com.insurancepropject.property.insurance.mapper.PropertyDetailsMapper;
import com.insurancepropject.property.insurance.repository.PremiumCheckRepository;
import com.insurancepropject.property.insurance.service.IPremiumCheckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PremiumCheckServiceImpl implements IPremiumCheckService {

    private PremiumCheckRepository premiumCheckRepository;
    @Override
    public void createPremiumCheck(PremiumCheck premiumCheck) {
        PremiumCheck save = premiumCheckRepository.save(premiumCheck);
    }

    @Override
    public List<PremiumCheckDto> fetchCustomerAllPremiumChecks(String mobileNumber, String paymentId) {
        List<PremiumCheck> premiumCheckList = premiumCheckRepository.findByMobileNumberAndPaymentId(mobileNumber,paymentId);
        List<PremiumCheckDto> premiumCheckDtoList = premiumCheckList.stream()
                .map(premiumCheck -> PremiumCheckMapper.mapToPremiumCheckDto(premiumCheck,new PremiumCheckDto()))
                .collect(Collectors.toList());

        return premiumCheckDtoList ;
    }


}
