package com.insurancepropject.property.insurance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String dob;
    private String panCard;
    private String mobile;

    @JsonProperty("isPermanentAddress")
    private boolean isPermanentAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="flatNo", column = @Column(name = "permanent_flatNo")),
            @AttributeOverride(name = "lane", column = @Column(name = "permanent_lane")),
            @AttributeOverride(name = "area", column = @Column(name = "permanent_area")),
            @AttributeOverride(name = "city", column = @Column(name = "permanent_city")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "permanent_zipcode")),
            @AttributeOverride(name = "state", column = @Column(name = "permanent_state")),
            @AttributeOverride(name = "country", column = @Column(name = "permanent_country"))
    })
    private Address permanent;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "flatNo", column = @Column(name = "property_flatNo")),
            @AttributeOverride(name = "lane", column = @Column(name = "property_lane")),
            @AttributeOverride(name = "area", column = @Column(name = "property_area")),
            @AttributeOverride(name = "city", column = @Column(name = "property_city")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "property_zipcode")),
            @AttributeOverride(name = "state", column = @Column(name = "property_state")),
            @AttributeOverride(name = "country", column = @Column(name = "property_country"))
    })
    private Address temporary;

    private String mobileNumber;

    private String customerId;

    private String paymentId;

}
