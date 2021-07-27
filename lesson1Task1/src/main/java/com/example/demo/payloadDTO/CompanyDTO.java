package com.example.demo.payloadDTO;

import com.example.demo.entitiy.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CompanyDTO {
    private String compName;
    private String directorName;
    private Integer addressId;


}
