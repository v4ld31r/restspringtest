package com.store.restspringtest.services;

import com.store.restspringtest.entities.Author;
import com.store.restspringtest.entities.Book;
import com.store.restspringtest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BookService implements MainService<Book> {
}
