package com.example.pontejavabackendtask.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressUpdateDto {
    private int id;


    private String address;

    @JsonCreator
    public AddressUpdateDto(@JsonProperty("id") int id, @JsonProperty("address") String address) {
        this.id = id;
        this.address = address;
    }
}