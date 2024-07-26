package com.ex.Service;

import com.ex.Payload.AddressDto;
import com.ex.Payload.SchoolDto;

import java.util.List;

public interface AddressService {
    AddressDto saveAddress(AddressDto addressDto,Long id);

    AddressDto updateAddress(AddressDto addressDto,Long id);

    AddressDto deleteAddress(Long id);

    List<AddressDto> getAll();

    AddressDto findAddress(Long id);
}
