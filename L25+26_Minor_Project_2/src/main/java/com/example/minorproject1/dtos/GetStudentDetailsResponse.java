package com.example.minorproject1.dtos;

import com.example.minorproject1.models.Book;
import com.example.minorproject1.models.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetStudentDetailsResponse {

    private Student student;

    private List<Book> bookList;
}
