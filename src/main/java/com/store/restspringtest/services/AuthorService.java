package com.store.restspringtest.services;

import com.store.restspringtest.entities.Author;
import com.store.restspringtest.entities.Book;

import java.util.List;

public abstract class AuthorService implements MainService<Author> {

    public abstract List<Book> getBooksById(int id);
}
