package com.insurancepropject.property.insurance.repository;

import com.insurancepropject.property.insurance.entity.PremiumCheck;
import com.insurancepropject.property.insurance.entity.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremiumCheckRepository extends JpaRepository<PremiumCheck,Long> {
    List<PremiumCheck> findByMobileNumberAndPaymentId(String mobileNumber, String paymentId);
}
