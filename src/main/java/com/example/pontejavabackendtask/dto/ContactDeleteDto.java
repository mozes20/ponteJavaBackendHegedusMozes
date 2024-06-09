package com.example.pontejavabackendtask.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactDeleteDto {
    private int id;

    @JsonCreator
    public ContactDeleteDto( @JsonProperty("id") int id){
        this.id = id;

    }
}