package com.app.ecom.mapper;

import com.app.ecom.dto.AddressDto;
import com.app.ecom.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto mapToAddressDto(Address address){
        return AddressDto.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .country(address.getCountry())
                .state(address.getState())
                .build();
    }

    public Address mapToAddressFromDto(AddressDto addressDto){
        return Address.builder()
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .zipcode(addressDto.getZipcode())
                .state(addressDto.getState())
                .country(addressDto.getCountry())
                .build();
    }

}
