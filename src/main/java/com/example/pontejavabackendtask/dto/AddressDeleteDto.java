package com.example.pontejavabackendtask.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressDeleteDto {
    private int id;

    @JsonCreator
    public AddressDeleteDto(@JsonProperty("id") int id) {
        this.id = id;
    }
}