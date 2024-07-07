package com.sda.Final.Project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Upload")
@Data
public class UploadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "image")
    private byte[] image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_upload",referencedColumnName = "id")
    private UserEntity idUserUpload;
}
