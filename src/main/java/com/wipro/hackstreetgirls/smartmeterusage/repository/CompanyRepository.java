package com.wipro.hackstreetgirls.smartmeterusage.repository;

import java.util.Optional;

import com.wipro.hackstreetgirls.smartmeterusage.entity.CompanyEntity;
import com.wipro.hackstreetgirls.smartmeterusage.enums.CompanyEnum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CompanyRepository extends JpaRepository<CompanyEntity, CompanyEnum>{
    
    Optional<CompanyEntity> findByCompany(CompanyEnum company);
}
