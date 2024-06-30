package com.sda.Final.Project.exception.config;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorFormat {
    private String message;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}