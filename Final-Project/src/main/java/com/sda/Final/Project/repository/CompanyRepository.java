package com.sda.Final.Project.repository;

import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity , Integer> {

}
