package com.example.minorproject1.services;

import com.example.minorproject1.dtos.CreateStudentRequest;
import com.example.minorproject1.dtos.GetStudentDetailsResponse;
import com.example.minorproject1.dtos.UpdateStudentRequest;
import com.example.minorproject1.models.*;
import com.example.minorproject1.repositories.BookRepository;
import com.example.minorproject1.repositories.StudentCacheRepository;
import com.example.minorproject1.repositories.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentCacheRepository studentCacheRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserService userService;


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

    /**
     * 1. Fetch the student details in the cache for a given student id (1ms)
     * 2. if the student details exist, then return from here itself (10 ms)
     * 3. if the student details doesn't exist, then fetch the details from db (400 ms)
     *
     * 4. save in the cache for future scenarios, (100 ms)
     * 5. return the data retrieved from the cache to the client (10 ms)
     * @param studentId
     * @param requireBookList
     * @return
     */

    public GetStudentDetailsResponse getStudentDetails(Integer studentId, boolean requireBookList){

        Student student = this.studentCacheRepository.get(studentId);

        if(student != null){
            return GetStudentDetailsResponse.builder()
                    .student(student)
                    .bookList(student.getBookList())
                    .build();
        }

        // Cache Miss
        student = this.studentRepository.findById(studentId).orElse(null);
//        List<Book> bookList = null;
//        if(requireBookList){
//            bookList = this.bookRepository.findByStudentId(studentId);
//        }

        //TODO: Make this add in the cache call in a parallel thread
        this.studentCacheRepository.add(student);

        return GetStudentDetailsResponse.builder()
                .student(student)
                .bookList(student.getBookList())
                .build();
    }

    public Integer create(CreateStudentRequest request) {

        /**
         * 1. encode the pwd before storing
         * 2. we will have to attach the authorities
         * 3. we need to create a user
         *
         * 4. attach the user id with the student (foreign key association)
         */

        Student student = request.mapToStudent();
        User user = this.userService.create(student.getUser(), Authority.STUDENT);
        student.setUser(user);
        this.studentRepository.save(student);
        return student.getId();

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
