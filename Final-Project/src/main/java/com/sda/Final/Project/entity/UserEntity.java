package com.sda.Final.Project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "date_Created")
    private LocalDate dateCreated;
    @Column(name = "date_Modified")
    private LocalDate dateModified;
    @Column(name = "location")
    private String location;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "rating")
    private float rating;

}









