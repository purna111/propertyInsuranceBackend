package com.insurancepropject.property.insurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.*;

@Entity
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class SignUpData {

    private String userName;

    private String email;
    @Id
    private String mobileNumber;

    private String newPassword;

    private String customerId;


}
