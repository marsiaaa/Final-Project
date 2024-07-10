package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.dto.CompanyDTO;

import java.util.List;

public interface iCompanyService {
    void save(CompanyDTO companyDTO);
    void update(CompanyDTO companyDTO);
    CompanyDTO findById(Integer id);
    List<CompanyDTO> findAll();
    void delete (Integer id);
    List<ClientDTO> findAllClientsOfCompany(Integer compnyId);
}
