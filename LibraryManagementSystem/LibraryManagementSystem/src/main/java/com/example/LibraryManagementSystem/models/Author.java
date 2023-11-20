package com.example.LibraryManagementSystem.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    // if author needs book the author has
    // we need to query it as below
    // "select * from book where auth_id = x";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "my_author") // accessed the same my_author with help of the mapping
    // so above we have does select query behind the scenes
    private List<Book> books;

}
