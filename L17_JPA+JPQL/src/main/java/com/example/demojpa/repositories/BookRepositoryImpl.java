//package com.example.demojpa.repositories;
//
//import com.example.demojpa.models.Book;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//public class BookRepositoryImpl implements BookRepository{
//
//
//    @Override
//    public List<Book> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Book> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Book> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public List<Book> findAllById(Iterable<Integer> integers) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(Book entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Book> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Book> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Book> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<Book> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Book> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Book> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<Book> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Book getOne(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public Book getById(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public Book getReferenceById(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public <S extends Book> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Book> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Book> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Book> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Book> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Book> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends Book, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//}
