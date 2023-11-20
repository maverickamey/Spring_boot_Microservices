package com.LearningJPA.jpaLearning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Builder
@Entity // this annotation will help for the
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // as ID is primary key and then it is similar to autoincrement
    // inplace of AUTO if we use IDENTITY then thats autoincrement
    // but here we dont use DB created IDS so we use concept of UUID  which is used in the by help of AUTO
    private int id;
    @Setter
    private int age;
    @Setter
    private String name;
    @Setter
    private String country;

    // here we will can set the objects which is taken care by setter
    // but designation is not setter so we cant set it only get it
    @Setter
    private String designation;

    @Setter
    private long salary;
}
