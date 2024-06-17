package com.example.minorproject1.dtos;

import com.example.minorproject1.models.Admin;
import com.example.minorproject1.models.Student;
import com.example.minorproject1.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAdminRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String name;

    public Admin mapToAdmin(){
        return Admin.builder()
                .name(this.name)
                .user(
                        User.builder()
                                .username(this.username)
                                .password(this.password)
                                .build()
                )
                .build();
    }
}
