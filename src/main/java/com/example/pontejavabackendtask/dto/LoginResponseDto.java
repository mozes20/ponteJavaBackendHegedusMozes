package com.example.pontejavabackendtask.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponseDto {
    private String token;
    private Long expiresIn;

    @JsonCreator
    public LoginResponseDto(@JsonProperty("token") String token, @JsonProperty("expiresIn") Long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
}
