package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.UploadDto;

import java.util.List;

public interface iUploadService {
    void save(UploadDto uploadDto);
    UploadDto findById(Integer id);
    void delete (Integer id);
    List<UploadDto> findAllByUserId(Integer userId);
}
