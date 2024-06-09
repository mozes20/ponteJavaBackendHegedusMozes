package com.example.pontejavabackendtask.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmailDeleteDto {
    private int id;

    @JsonCreator
    public EmailDeleteDto(@JsonProperty("id") int id) {
        this.id = id;
    }
}