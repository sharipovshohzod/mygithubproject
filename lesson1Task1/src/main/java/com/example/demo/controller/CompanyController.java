package com.example.demo.controller;

import com.example.demo.entitiy.Company;
import com.example.demo.payloadDTO.ApiResponse;
import com.example.demo.payloadDTO.CompanyDTO;
import com.example.demo.service.CompanyServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyServise companyServise;

@GetMapping
    public ResponseEntity<?> getAddress(){
    List<Company> companyList = companyServise.getCompany();
    return ResponseEntity.ok(companyList);
}
@PostMapping
    public ResponseEntity<?> addCompany(@RequestBody CompanyDTO companyDTO){
    ApiResponse apiResponse = companyServise.addCompany(companyDTO);
    return ResponseEntity.ok(apiResponse);
}

}
