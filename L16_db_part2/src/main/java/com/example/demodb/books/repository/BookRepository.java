package com.example.demodb.books.repository;

import com.example.demodb.books.models.Book;
import com.example.demodb.books.models.Genre;
import com.example.demodb.commons.DatabaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {

    private static Logger logger = LoggerFactory.getLogger(BookRepository.class);

    /**
     * Database creation - Manual / code
     * Table creation - code orm (object relation mapping)
     * Migrations:
     */

    private final DatabaseRepository databaseRepository;

    BookRepository(DatabaseRepository databaseRepository) throws SQLException {
        this.databaseRepository = databaseRepository;
        createBookTable();
    }

    /**
     * private String authorName;
     *
     *     private Genre genre;
     *
     *     private String authorCountry;
     *
     *     private String authorEmail;
     *
     *     private Date createdOn;
     *
     *     private Date updatedOn;
     */


    private Connection getConnection(){
        return this.databaseRepository.getConnection();
    }

    private void createBookTable() throws SQLException {
        logger.info("Inside createBooktable....");
        Connection connection = getConnection();
        String sql = "CREATE TABLE if not exists book(id int primary key auto_increment, name varchar(50) not null, author_name varchar(50), " +
                "author_email varchar(50), author_country varchar(30), genre varchar(30), created_on date, updated_on date)";

        Statement statement = connection.createStatement();
        boolean result = statement.execute(sql);

        logger.info("inside createbookTable.. result = {}", result);
    }
    public void create(Book book) throws SQLException {
        String sql = "INSERT INTO book (name, author_name, author_country, author_email, genre, " +
                "created_on, updated_on) VALUES (?, ?, ?, ?, ?, ?, ?)";

        /**
         * INSERT INTO book (name, author_name, author_country, author_email, genre, " +
         *                 "created_on, updated_on) VALUES (book.getName(), book.getAuthorName(), ?, ?, ?, ?, ?)
         */

        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthorName());
        preparedStatement.setString(3, book.getAuthorCountry());
        preparedStatement.setString(4, book.getAuthorEmail());
        preparedStatement.setString(5, book.getGenre().name());
        preparedStatement.setDate(6, new Date(book.getCreatedOn().getTime()));
        preparedStatement.setDate(7, new Date(book.getUpdatedOn().getTime()));

        boolean result = preparedStatement.execute();
        logger.info("Inside create book: result = {}", result);

        // book.getCreatedOn().getTime() --> getting the epoch time in milliseconds from book's date (java.util)
        // creating a new instance of sql date by passing the epoch

    }

    public List<Book> getAll() throws SQLException {

        List<Book> bookList = new ArrayList<>();

        String sql = "select * from book";
        Statement statement = this.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){

            // object relation mapping
            // java <--> sql mapping

            String name = resultSet.getString("name");
            String authorName = resultSet.getString("author_name");
            String authorCountry = resultSet.getString("author_country");
            String authorEmail = resultSet.getString("author_email");
            Genre genre = Genre.valueOf(resultSet.getString("genre"));
            int id = resultSet.getInt("id");
            java.util.Date createdOn = resultSet.getDate("created_on");
            java.util.Date updatedOn = resultSet.getDate("updated_on");

            Book book = Book.builder()
                    .name(name)
                    .id(id)
                    .authorName(authorName)
                    .authorCountry(authorCountry)
                    .authorEmail(authorEmail)
                    .genre(genre)
                    .createdOn(createdOn)
                    .updatedOn(updatedOn)
                    .build();

            bookList.add(book);

        }

        return bookList;

    }

    public Book getById(int bookId) throws SQLException {

        String sql = "select * from book where id = ?";
        PreparedStatement statement = this.getConnection().prepareStatement(sql);
        statement.setInt(1, bookId);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){

            // object relation mapping
            // java <--> sql mapping

            String name = resultSet.getString("name");
            String authorName = resultSet.getString("author_name");
            String authorCountry = resultSet.getString("author_country");
            String authorEmail = resultSet.getString("author_email");
            Genre genre = Genre.valueOf(resultSet.getString("genre"));
            int id = resultSet.getInt("id");
            java.util.Date createdOn = resultSet.getDate("created_on");
            java.util.Date updatedOn = resultSet.getDate("updated_on");

            return Book.builder()
                    .name(name)
                    .id(id)
                    .authorName(authorName)
                    .authorCountry(authorCountry)
                    .authorEmail(authorEmail)
                    .genre(genre)
                    .createdOn(createdOn)
                    .updatedOn(updatedOn)
                    .build();


        }

        return null;
    }
}
