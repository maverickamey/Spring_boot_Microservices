package com.example.LibraryManagementSystem.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // to specify JPA on the below values in tables
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // book can have multiple authors;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @ManyToOne // Book to author is many to 1 relationship to connect..
    @JoinColumn
    private Author my_author; // this is for joining b/w book table and author table..
    // so this will keep book id in author table
    // foreign key reference



}
