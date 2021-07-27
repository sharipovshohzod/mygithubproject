package com.example.demo.service;

import com.example.demo.entitiy.Address;
import com.example.demo.entitiy.Company;
import com.example.demo.payloadDTO.ApiResponse;
import com.example.demo.payloadDTO.CompanyDTO;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CompanyRepasitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServise {
    @Autowired
    CompanyRepasitory companyRepasitory;
    @Autowired
    AddressRepository addressRepository;

    public List<Company> getCompany() {
        List<Company> companyList = companyRepasitory.findAll();
        return companyList;
    }

    public ApiResponse addCompany(CompanyDTO companyDTO) {
        Company newCompany = new Company();
        newCompany.setCompName(companyDTO.getCompName());
        newCompany.setDirectorName(companyDTO.getDirectorName());

        Optional<Address> optionalAddress = addressRepository.findById(companyDTO.getAddressId());
        if (!optionalAddress.isPresent()) {
            return new ApiResponse("bunday adres mavjud emas", false);
        }
        Address address = optionalAddress.get();
        newCompany.setAddress(address);
        companyRepasitory.save(newCompany);
        return new ApiResponse("company qo'shildi " + newCompany, true);
    }

}
