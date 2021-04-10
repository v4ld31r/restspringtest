package com.store.restspringtest.services;

import com.store.restspringtest.entities.Book;
import com.store.restspringtest.entities.Publisher;

import java.util.List;

public abstract class PublisherService implements MainService<Publisher> {
    public abstract List<Book> getBooksById( int id);
}
