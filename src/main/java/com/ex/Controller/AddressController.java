package com.ex.Controller;


import com.ex.Payload.AddressDto;
import com.ex.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/address")
@RestController
public class AddressController {


    @Autowired
    private AddressService addressService;


    @PostMapping("/addAddress")
    public ResponseEntity<AddressDto> add(@RequestBody AddressDto addressDto,@RequestParam
    Long id)
    {
        AddressDto addressDto1 = addressService.saveAddress(addressDto, id);
        return new ResponseEntity<>(addressDto1, HttpStatus.CREATED);
    }

}
