package com.example.demo.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(unique = true,nullable = false)
    private String compName;

    @Column(nullable = false)
    private String directorName;

    @OneToOne
    private Address address;
}


//        Company malumotlarini service, controller yordamida
//        ResposeEntity qaytaradigan to'liq REST full API yozing.
//        Bunda Address(street, homeNumber)
//        Company(corpName, directorName, Address)
//        Department(name, Company)
//        Worker(name, phoneNumber, Address, Department)
//        malumotlari bo'lsin. Proyektni git ga yuklab,
//        javob sifatida linkni yuboring.