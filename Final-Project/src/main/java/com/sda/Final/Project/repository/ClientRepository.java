package com.sda.Final.Project.repository;

import com.sda.Final.Project.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {


}
