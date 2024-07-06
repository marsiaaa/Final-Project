package com.sda.Final.Project.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "social_media")
public class SocialMediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Linkedin")
    private String linkedin;

    @Column(name = "Instagram")
    private String instagram;

    @Column(name = "Facebook")
    private String facebook;

    @OneToOne
    @JoinColumn(name = "id_user_social_media", referencedColumnName = "id")
    private UserEntity userEntity;

}
