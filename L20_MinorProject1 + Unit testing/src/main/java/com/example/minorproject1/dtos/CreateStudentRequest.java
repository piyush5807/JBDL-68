package com.example.minorproject1.dtos;

import com.example.minorproject1.models.Student;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

    private String name;

    private String email;

    @NotBlank
    private String mobile;

    public Student mapToStudent(){
        return Student.builder()
                .name(this.name)
                .mobile(this.mobile)
                .email(this.email)
                .build();
    }

}
