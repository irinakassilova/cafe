package com.example.cafe.dto;

import com.example.cafe.model.User;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class UserDTO {
    private int id;
    private String email;
    private String role;
//    private Set<Role> roles;

    static public UserDTO from(User user){
        return builder()
                .id(user.getId())
                .email(user.getEmail())
                .role("USER")
                .build();
    }
}
