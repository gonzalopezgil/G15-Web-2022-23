package com.uah.gestion_de_practicas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.uah.gestion_de_practicas.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class UserDTO {
    
    private Long id;
    private String username;
    private String first_name;
    private String last_name;
    private String nif;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.first_name = user.getFirstName();
        this.last_name = user.getLastName();
        this.nif = user.getNif();
        this.email = user.getEmail();
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user);
    }

    public static List<UserDTO> fromUsers(List<User> users) {
        return users.stream().map(UserDTO::fromUser).collect(Collectors.toList());
    }
}