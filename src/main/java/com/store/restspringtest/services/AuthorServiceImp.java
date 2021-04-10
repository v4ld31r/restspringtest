package com.store.restspringtest.services;

import com.store.restspringtest.entities.Author;
import com.store.restspringtest.entities.Book;
import com.store.restspringtest.exception.ResourceNotFoundException;
import com.store.restspringtest.repository.AuthorRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class AuthorServiceImp extends AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Page<Author> getAll(Pageable pageable) { return authorRepository.findAll( pageable);}

    @Override
    public Author add( Author o ) { return authorRepository.save( o );}

    @Override
    public Author update( Author o, int id){

        Author author = checkIfIdIsPresentandReturnAuthor( id );
        author.setName( o.getName() );
        return authorRepository.save( author);

    }
    @Override
    public Author getById( int id ) { return checkIfIdIsPresentandReturnAuthor ( id ); }

    @Override
    public Author deleteById(int id) {
        Author author = checkIfIdIsPresentandReturnAuthor( id );
        authorRepository.deleteById( id );
        return author;
    }

    @Override
    public List<Book> getBooksById(int id) {
        return checkIfIdIsPresentandReturnAuthor( id ).getBookList();
    }

    private Author checkIfIdIsPresentandReturnAuthor( int id) {
        if (!authorRepository.findById(id).isPresent())
            throw new ResourceNotFoundException("Author id = " + id + " not found");
        else
            return authorRepository.findById(id).get();
    }
}
