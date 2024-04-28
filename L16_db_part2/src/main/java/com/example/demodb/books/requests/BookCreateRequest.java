package com.example.demodb.books.requests;

import com.example.demodb.books.models.Book;
import com.example.demodb.books.models.Genre;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
                .authorName(this.authorName)
                .authorCountry(this.authorCountry)
                .createdOn(new Date())
                .updatedOn(new Date())
                .build();
    }
}
