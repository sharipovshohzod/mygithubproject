package com.example.demo.repository;

import com.example.demo.entitiy.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CompanyRepasitory extends JpaRepository<Company,Integer> {

}
