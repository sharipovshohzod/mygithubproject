package com.example.demo.service;

import com.example.demo.entitiy.Address;
import com.example.demo.payloadDTO.AddressDTO;
import com.example.demo.payloadDTO.ApiResponse;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {


//    private final AddressRepository addressRepository;

    @Autowired
    AddressRepository addressRepository;
//    public AddressService(AddressRepository addressRepository) {
//        this.addressRepository = addressRepository;
//    }

    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public Address getOneAddress(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent())
            return optionalAddress.get();
        return null;
    }

    public ApiResponse addAddress(AddressDTO addressDTO) {
        boolean existsByHomeNumberAndStreet
                = addressRepository.existsByHomeNumberAndStreet
                (addressDTO.getHomeNumber(),
                        addressDTO.getStreet());
        if (existsByHomeNumberAndStreet) {
            return new ApiResponse("bunday address mavjud", false);
        }
        Address newAddress = new Address();
        newAddress.setStreet(addressDTO.getStreet());
        newAddress.setHomeNumber(addressDTO.getHomeNumber());
        addressRepository.save(newAddress);
        return new ApiResponse("Address muvoffaqiyatli qo'shildi"+newAddress, true);
    }
    public ApiResponse editAddress(AddressDTO addressDTO,Integer id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (!optionalAddress.isPresent())
            return new ApiResponse("bunday address topilmadi", false);
        Address editedAddress=optionalAddress.get();
        editedAddress.setStreet(addressDTO.getStreet());
        editedAddress.setHomeNumber(addressDTO.getHomeNumber());
        addressRepository.save(editedAddress);
        return new ApiResponse("address tahrirlandi "+editedAddress,true);
    }

}
