package com.example.pontejavabackendtask.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressCreateDto {
    private int contactId;
    private String address;

    @JsonCreator
    public AddressCreateDto(@JsonProperty("contactId") String contactId, @JsonProperty("address") String address) {
        this.contactId = Integer.parseInt(contactId);
        this.address = address;
    }
}