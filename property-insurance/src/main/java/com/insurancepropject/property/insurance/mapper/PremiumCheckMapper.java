package com.insurancepropject.property.insurance.mapper;

import com.insurancepropject.property.insurance.dto.PremiumCheckDto;
import com.insurancepropject.property.insurance.entity.PremiumCheck;

public class PremiumCheckMapper {
    public static PremiumCheckDto mapToPremiumCheckDto (PremiumCheck premiumCheck,PremiumCheckDto premiumCheckDto){

        premiumCheckDto.setPremiumYears(premiumCheck.getPremiumYears());
        premiumCheckDto.setTotalPremiumAmount(premiumCheck.getTotalPremiumAmount());
        premiumCheckDto.setPremiumAmountPerYear(premiumCheck.getPremiumAmountPerYear());
        premiumCheckDto.setCustomerId(premiumCheck.getCustomerId());
        premiumCheckDto.setPaymentId(premiumCheck.getPaymentId());
        premiumCheckDto.setMobileNumber(premiumCheck.getMobileNumber());

        return premiumCheckDto ;
    }

    public static PremiumCheck mapToPremiumCheck (PremiumCheckDto premiumCheckDto,PremiumCheck premiumCheck){

        premiumCheck.setPremiumYears(premiumCheck.getPremiumYears());
        premiumCheck.setTotalPremiumAmount(premiumCheckDto.getTotalPremiumAmount());
        premiumCheck.setPremiumAmountPerYear(premiumCheckDto.getPremiumAmountPerYear());
        premiumCheck.setCustomerId(premiumCheckDto.getCustomerId());
        premiumCheck.setPaymentId(premiumCheckDto.getPaymentId());
        premiumCheck.setMobileNumber(premiumCheckDto.getMobileNumber());

        return premiumCheck ;
    }
}
