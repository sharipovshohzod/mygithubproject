package com.example.demo.controller;

import com.example.demo.entitiy.Address;
import com.example.demo.payloadDTO.AddressDTO;
import com.example.demo.payloadDTO.ApiResponse;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;


    @GetMapping
    public ResponseEntity<?> getAddress() {
        List<Address> addresses = addressService.getAddress();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneAddress(@PathVariable Integer id){
        Address oneAddress = addressService.getOneAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(oneAddress);
    }

    @PostMapping
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO addressDTO){
        ApiResponse apiResponse = addressService.addAddress(addressDTO);
        return ResponseEntity.ok(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editAddress(@RequestBody AddressDTO addressDTO,@PathVariable Integer id){
        ApiResponse apiResponse = addressService.editAddress(addressDTO, id);
        return ResponseEntity.ok(apiResponse);
    }


    }

