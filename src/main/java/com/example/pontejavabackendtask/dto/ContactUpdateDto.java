package com.example.pontejavabackendtask.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactUpdateDto {
    private int id;
    private String name;

    @JsonCreator
    public ContactUpdateDto(@JsonProperty("name") String name, @JsonProperty("id") int id){
        this.id = id;
        this.name = name;
    }
}