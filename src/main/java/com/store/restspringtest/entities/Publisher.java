package com.store.restspringtest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "publisher")
public class Publisher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "address")
    @NonNull
    private String address;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> bookList= new ArrayList<>();

    public void addBook(Book book){
        this.bookList.add( book );
    }
}
