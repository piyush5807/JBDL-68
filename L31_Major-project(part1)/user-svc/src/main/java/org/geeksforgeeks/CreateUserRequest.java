package org.geeksforgeeks;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NotBlank
    private String name;

    @Min(18)
    private Integer age;

    @Email
    @NotBlank
    private String email;

    private String mobile;


    public User toUser(){
        return User.builder()
                .name(this.name)
                .email(this.email)
                .mobile(this.mobile)
                .age(this.age)
                .build();
    }
}
