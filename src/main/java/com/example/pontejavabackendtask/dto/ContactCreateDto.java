package com.example.pontejavabackendtask.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactCreateDto {
    private String name;

    @JsonCreator
    public ContactCreateDto(@JsonProperty("name") String name) {
        this.name = name;
    }
}