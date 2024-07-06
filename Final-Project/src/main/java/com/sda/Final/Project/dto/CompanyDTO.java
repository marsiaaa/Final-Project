package com.sda.Final.Project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CompanyDTO {

    private Integer id;

    @NotNull(message = "Emri i kompanise s'mund te jete null")
    @NotBlank(message = "Emri  i kompanise s´mund te jete bosh")
    @NotEmpty(message = "Emri i kompanise s´mund te jete bosh")
    private String companyName;

    private UserDTO idUserCompany;
}
