package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Address;
import com.xyz.easymycart.request.AddressRequestDto;
import com.xyz.easymycart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    private ProductService productService;

    @Autowired
    public AddressController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public Address addAddress(@RequestHeader("userId") Long userId, @RequestBody AddressRequestDto addressRequestDto){
        Address address = productService.addAddress(addressRequestDto,userId);
        return address;
    }
}
