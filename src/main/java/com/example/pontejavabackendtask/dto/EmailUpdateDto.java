package com.example.pontejavabackendtask.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmailUpdateDto {
    private int id;
    private int contactId;
    private String email;

    @JsonCreator
    public EmailUpdateDto(@JsonProperty("id") int id, @JsonProperty("contactId") String contactId, @JsonProperty("email") String email) {
        this.contactId = Integer.parseInt(contactId);
        this.email = email;
        this.id = id;
    }
}