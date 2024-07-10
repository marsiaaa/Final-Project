package com.sda.Final.Project.repository;


import com.sda.Final.Project.entity.SocialMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaRepository  extends JpaRepository<SocialMediaEntity, Integer>{
    boolean existsByUserEntity_Id(Integer id);
}
