package com.store.restspringtest.services;

import com.store.restspringtest.entities.Author;
import com.store.restspringtest.entities.Book;
import com.store.restspringtest.exception.ResourceNotFoundException;
import com.store.restspringtest.repository.AuthorRepository;
import com.store.restspringtest.repository.BookRepository;
import com.store.restspringtest.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImp extends BookService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private Author checkIfIdIsPresentandReturnAuthor( int id){
        if (!authorRepository.findById( id ).isPresent())
            throw new ResourceNotFoundException( " Author id = " + " not found ");
        else
            return  authorRepository.findById( id ).get();
    }

    @Override
    public Page<Book> getAll(Pageable pageable) {
        return bookRepository.findAll( pageable );
    }

    @Override
    public Book add(Book o) {
        if ( o.getAuthor().getAuthorId() != 0){
            Author author = checkIfIdIsPresentandReturnAuthor(o.getPublisher().getId());
        }

        return null;
    }

    @Override
    public Book update(Book o, int id) {
        return null;
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public Book deleteById(int id) {
        return null;
    }
}
