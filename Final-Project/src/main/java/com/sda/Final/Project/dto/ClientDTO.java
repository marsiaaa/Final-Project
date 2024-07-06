package com.sda.Final.Project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO{
    private Integer id;

    @NotNull(message = "Emri s'mund te jete null")
    @NotBlank(message = "Emri s´mund te jete bosh")
    @NotEmpty(message = "Emri s´mund te jete bosh")
    @Pattern(regexp = "^[A-Za-z]+ [A-Za-z]+$",
            message = "Please insert your name")
    private String name;

    @NotNull(message = "Mbiemri s'mund te jete null")
    @NotBlank(message = "Mbiemri s´mund te jete bosh")
    @NotEmpty(message = "Mbiemri s´mund te jete bosh")
    @Pattern(regexp = "^[A-Za-z]+ [A-Za-z]+$",
            message = "Please insert your surname")
    private String surname;

    private String phone;

    @NotNull(message = "Email s'mund te jete null")
    @NotBlank(message = "Email s´mund te jete bosh")
    @NotEmpty(message = "Email s´mund te jete bosh")
    @Pattern(regexp = "^[A-Za-z]+ [A-Za-z]+$",
            message = "Please insert your Email")
    private String email;

    public ClientDTO(Integer id) {
        this.id = id;
    }
}
