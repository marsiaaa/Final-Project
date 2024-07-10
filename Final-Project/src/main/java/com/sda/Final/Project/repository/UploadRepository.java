package com.sda.Final.Project.repository;


import com.sda.Final.Project.entity.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadRepository extends JpaRepository<UploadEntity , Integer> {
    List<UploadEntity> findAllByIdUserUpload_Id(Integer id);
}
