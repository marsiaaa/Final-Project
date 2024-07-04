package com.sda.Final.Project.exception.config;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorFormat {
    private String message;
    private LocalDate date;
}
