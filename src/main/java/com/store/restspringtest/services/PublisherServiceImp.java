package com.store.restspringtest.services;

import com.store.restspringtest.entities.Book;
import com.store.restspringtest.entities.Publisher;
import com.store.restspringtest.exception.ResourceNotFoundException;
import com.store.restspringtest.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PublisherServiceImp extends PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Page<Publisher> getAll(Pageable pageable) {
        return publisherRepository.findAll( pageable );
    }

    @Override
    public Publisher add(Publisher o) {
        return publisherRepository.save ( o );
    }

    @Override
    public Publisher update(Publisher o, int id) {
        Publisher publisher = checkIfIdIsPresentandReturnPublisher( id );
        publisher.setName( o.getName());
        publisher.setAddress( o.getAddress());
        return publisherRepository.save( publisher );
    }

    @Override
    public Publisher getById(int id) throws ResourceNotFoundException {
        return checkIfIdIsPresentandReturnPublisher( id );
    }

    @Override
    public Publisher deleteById(int id) {
        Publisher publisher = checkIfIdIsPresentandReturnPublisher( id );
        return publisher;
    }

    @Override
    public List<Book> getBooksById(int id) {
        return null;
    }

    private Publisher checkIfIdIsPresentandReturnPublisher( int id){
        if ( !publisherRepository.findById( id ).isPresent())
            throw new ResourceNotFoundException( " Publisher id = " + " not found" );
        else
            return publisherRepository.findById( id ).get();
    }
}
