package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Address;
import com.xyz.easymycart.request.AddressRequestDto;
import com.xyz.easymycart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PatchMapping("/api/update-address/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable("id")Long id, @RequestBody AddressRequestDto addressRequestDto){
         productService.updateUserAddress(id,addressRequestDto);
        return ResponseEntity.ok("address updated successfully");
    }

    @GetMapping("/")
    public List<Address> getUserAddress(@RequestHeader("userId") Long userId){
        List<Address> addressList = productService.getUserAddress(userId);
        return addressList;
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable("id") Long id){
        Address address =productService.getAddress(id);
        return address;
    }
}
