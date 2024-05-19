package com.example.minorproject1.services;

import com.example.minorproject1.dtos.CreateStudentRequest;
import com.example.minorproject1.dtos.GetStudentDetailsResponse;
import com.example.minorproject1.dtos.UpdateStudentRequest;
import com.example.minorproject1.models.Book;
import com.example.minorproject1.models.Student;
import com.example.minorproject1.models.StudentStatus;
import com.example.minorproject1.repositories.BookRepository;
import com.example.minorproject1.repositories.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookRepository bookRepository;


    private ObjectMapper mapper = new ObjectMapper();

//    public GetStudentDetailsResponse getStudentDetails(Integer studentId, boolean requireBookList){
//        Student student = this.studentRepository.findById(studentId).orElse(null);
//        List<Book> bookList = null;
//        if(requireBookList){
//            bookList = this.bookService.getBooksByStudentId(studentId);
//        }
//        return GetStudentDetailsResponse.builder()
//                .student(student)
//                .bookList(bookList)
//                .build();
//    }

    public GetStudentDetailsResponse getStudentDetails(Integer studentId, boolean requireBookList){
        Student student = this.studentRepository.findById(studentId).orElse(null);
        List<Book> bookList = null;
        if(requireBookList){
            bookList = this.bookRepository.findByStudentId(studentId);
        }

        return GetStudentDetailsResponse.builder()
                .student(student)
                .bookList(bookList)
                .build();
    }

    public Integer create(CreateStudentRequest request) {

        Student student = request.mapToStudent();
        this.studentRepository.save(student);

        return student.getId();

//        Student student = request.mapToStudent();
//        this.studentRepository.save(student); // id is added in the same object
//
//        return student.getId(); // default value of integer datatype
    }

    public GetStudentDetailsResponse update(Integer studentId, UpdateStudentRequest request) {

        Student student = request.mapToStudent();
        student.setId(1);

        GetStudentDetailsResponse studentDetailsResponse = this.getStudentDetails(studentId, false);

        Student savedStudent = studentDetailsResponse.getStudent();


//   Another way to retrieve the student details: Student savedStudent = this.studentRepository.findById(studentId).orElse(null);

        Student target = this.merge(student, savedStudent);
        studentRepository.save(student);

        studentDetailsResponse.setStudent(target);
        return studentDetailsResponse;
    }


    private Student merge(Student incoming, Student saved) {
        JSONObject incomingStudent = mapper.convertValue(incoming, JSONObject.class);
        JSONObject savedStudent = mapper.convertValue(saved, JSONObject.class);

        Iterator it = incomingStudent.keySet().iterator();  // id, name, email, mobile .....
        while (it.hasNext()) {
            String key = (String)it.next();
            if(incomingStudent.get(key) != null) {
                savedStudent.put(key, incomingStudent.get(key));
            }
        }

        return mapper.convertValue(savedStudent, Student.class);
    }

    public GetStudentDetailsResponse deactivate(int studentId) {

        this.studentRepository.deactivate(studentId, StudentStatus.INACTIVE);
        return this.getStudentDetails(studentId, false);
    }
//
//    public static void main(String[] args) {
//
//        Person person = Person.builder()
//                .name("abc")
//                .build();
//
////        System.out.println("Inside func.... person = " + person);
//        Person returnedPerson = func2(person);
//        System.out.println("Inside func.... person = " + person + ", returnedPerson = " + returnedPerson);
//
//        /**
//         * Output : person = {?, ?} , returnedPerson = {?, ?}
//         */
//    }
//
//    public static Person func(Person person){          // In spring boot 3.X this type of implementation is present in spring data jpa
////        System.out.println("Inside func.... person = " + person);
//
//        person.setId(new Random().nextInt(10));
//
////        System.out.println("Inside func.... person = " + person);
//
//        return person;
//    }
//
//    public static Person func2(Person person){
////        System.out.println("Inside func.... person = " + person);
//
//        Person newPerson = Person.builder()
//                .name(person.getName())
//                .id(new Random().nextInt(10))
//                .build();
//
////        System.out.println("Inside func.... person = " + person);
//
//        return newPerson;
//    }
}
