package com.sda.Final.Project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Company")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_Name")
    private String companyName;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user_company",referencedColumnName = "id")
    private UserEntity idUserCompany;
}
