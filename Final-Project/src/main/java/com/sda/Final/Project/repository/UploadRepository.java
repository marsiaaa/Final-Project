package com.sda.Final.Project.repository;

import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.entity.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UploadRepository extends JpaRepository<UploadEntity , Integer> {
List<UploadEntity> findAllByIdUserUpload_Id(Integer id);
}
