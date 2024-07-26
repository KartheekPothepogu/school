package com.ex.Service;

import com.ex.Entity.Address;
import com.ex.Entity.School;
import com.ex.Payload.AddressDto;
import com.ex.Repository.AddressRepository;
import com.ex.Repository.SchoolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{


    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDto saveAddress(AddressDto addressDto, Long id) {

        School school = schoolRepository.findById(id).get();
        addressDto.setSchool(school);
        Address map = modelMapper.map(addressDto, Address.class);
        Address save = addressRepository.save(map);
        return modelMapper.map(save,AddressDto.class);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, Long id) {
        return null;
    }

    @Override
    public AddressDto deleteAddress(Long id) {
        return null;
    }

    @Override
    public List<AddressDto> getAll() {
        return List.of();
    }

    @Override
    public AddressDto findAddress(Long id) {
        return null;
    }
}
