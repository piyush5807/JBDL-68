package com.example.minorproject1.dtos;

import com.example.minorproject1.models.Student;
import com.example.minorproject1.models.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String name;

    private String email;

    @NotBlank
    private String mobile;

    public Student mapToStudent(){
        return Student.builder()
                .name(this.name)
                .mobile(this.mobile)
                .email(this.email)
                .user(
                        User.builder()
                                .username(this.username)
                                .password(this.password)
                                .build()
                )
                .build();
    }

}
