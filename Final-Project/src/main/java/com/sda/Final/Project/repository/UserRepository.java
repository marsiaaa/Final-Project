package com.sda.Final.Project.repository;

import com.sda.Final.Project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <UserEntity, Integer> {
    List<UserEntity> findAllByName(String name);

    Optional<UserEntity> findUserEntityByEmail(String email);
}
