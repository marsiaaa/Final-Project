package com.sda.Final.Project.dto;

import lombok.Data;

@Data
public class UploadDto {
    private Integer id;
    private String filename;
    private byte[] image;
    private UserDTO idUserUpload;
}
