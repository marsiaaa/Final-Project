package com.sda.Final.Project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationDTO {

    private Integer id;

    @NotNull(message = "The receiver cannot be null!")
    @NotBlank(message = "The receiver cannot be blank!")
    @NotEmpty(message = "The receiver cannot be empty!")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "Please insert a valid email address for sender!")

    private String sender;

    @NotNull(message = "The sender cannot be null!")
    @NotBlank(message = "The sender cannot be blank!")
    @NotEmpty(message = "The sender cannot be empty!")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "Please insert a valid email address for receiver!")
    private String receiver;

    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "Please insert a valid email address!")
    private String carbon_copy;

    //@Pattern(regexp = "^[A-Za-z][A-Za-z0-9!@#$%^&*]*$",
    //message = "Subject length must be between 2 and 100 characters ")
    private String subject;

    private String body;
    private MeetingDTO meeting;



}
