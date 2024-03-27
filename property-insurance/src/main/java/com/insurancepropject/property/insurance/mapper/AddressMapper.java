package com.insurancepropject.property.insurance.mapper;

import com.insurancepropject.property.insurance.dto.AddressDto;
import com.insurancepropject.property.insurance.entity.Address;
import org.springframework.beans.BeanUtils;

public class AddressMapper {

    public static AddressDto toDTO(Address address) {
        AddressDto dto = new AddressDto();
        BeanUtils.copyProperties(address, dto);
        return dto;
    }

    public static Address toEntity(AddressDto dto) {
        Address address = new Address();
        BeanUtils.copyProperties(dto, address);
        return address;
    }
}
