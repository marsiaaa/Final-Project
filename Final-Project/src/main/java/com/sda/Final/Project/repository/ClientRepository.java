package com.sda.Final.Project.repository;

import com.sda.Final.Project.entity.ClientEntity;
import com.sda.Final.Project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    public List<ClientEntity> findAllByName(String name);
    Optional<ClientEntity> findClientEntitiesByEmail(String email);


}
