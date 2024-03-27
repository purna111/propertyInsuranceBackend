package com.insurancepropject.property.insurance.repository;

import com.insurancepropject.property.insurance.dto.PropertyDetailsDto;
import com.insurancepropject.property.insurance.entity.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails,Long> {

    List<PropertyDetails> findByMobileNumber(String mobileNumber);

    List<PropertyDetails> findByMobileNumberAndPaymentId(String mobileNumber, String paymentId);
}
