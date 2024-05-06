package com.example.demojpa.dtos;

import com.example.demojpa.models.Book;
import com.example.demojpa.models.Genre;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateRequest {

    @NotBlank
    @Length(max = 50, min = 5)
    private String name;

    private String authorName;

    @NotNull
    private Genre genre;

    private String authorCountry;

    private String authorEmail;

    public Book to(){
        return Book.builder()
                .name(this.name)
                .genre(this.genre)
                .authorEmail(this.authorEmail)
                .author(this.authorName)
                .authorCountry(this.authorCountry)
                .createdOn(new Date())
                .updatedOn(new Date())
                .build();
    }
}
