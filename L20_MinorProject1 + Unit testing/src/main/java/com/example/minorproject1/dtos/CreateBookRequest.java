package com.example.minorproject1.dtos;

import com.example.minorproject1.models.Author;
import com.example.minorproject1.models.Book;
import com.example.minorproject1.models.Genre;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {


    private String bookName;

    private Genre genre;

    private String authorName;

    @NotBlank
    private String authorEmail;

    public Book mapToBookAndAuthor(){
        return Book.builder()
                .name(this.bookName)
                .genre(this.genre)
                .author(
                      Author.builder()
                              .email(this.authorEmail)
                              .name(this.authorName)
                              .build()
                )
                .build();
    }
}
