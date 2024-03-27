package com.insurancepropject.property.insurance.repository;

import com.insurancepropject.property.insurance.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

    Optional<UserDetails> findByName(String name);

    List<UserDetails> findByMobileNumberAndPaymentId(String mobileNumber, String paymentId);
}
