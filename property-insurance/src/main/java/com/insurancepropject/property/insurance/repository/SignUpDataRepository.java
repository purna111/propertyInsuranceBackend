package com.insurancepropject.property.insurance.repository;

import com.insurancepropject.property.insurance.entity.SignUpData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpDataRepository extends JpaRepository<SignUpData,String> {
}
