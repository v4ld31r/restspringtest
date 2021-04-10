package com.store.restspringtest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "address")
    @NonNull
    private String address;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

    public void addBook( Book book ) { this.bookList.add(book); }
}
