package com.uah.gestion_de_practicas.controller.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/** 
 * DTO to manage the authentication data.
 */
@Data
@EqualsAndHashCode
@ToString
public class AuthDTO {
    private String username;
    private String password;

    public AuthDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthDTO() {
    }
}
