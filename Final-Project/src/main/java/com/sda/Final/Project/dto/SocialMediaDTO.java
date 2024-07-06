package com.sda.Final.Project.dto;

import com.sda.Final.Project.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SocialMediaDTO {

    private Integer id;

    @NotNull(message = "Adresa e linkedin  s'mund te jete null")
    @NotBlank(message = "Adresa e linkedin s´mund te jete bosh")
    @NotEmpty(message = "Adresa e linkedin s´mund te jete bosh")
    private String linkedin;


    @NotNull(message = "Adresa e instagramit  s'mund te jete null")
    @NotBlank(message = "Adresa e instagramit s´mund te jete bosh")
    @NotEmpty(message = "Adresa e instagramit s´mund te jete bosh")

    private String instagram;


    @NotNull(message = "Adresa e facebook  s'mund te jete null")
    @NotBlank(message = "Adresa e facebook s´mund te jete bosh")
    @NotEmpty(message = "Adresa e facebook s´mund te jete bosh")
    private String facebook;


    private UserDTO userDTO;

}


