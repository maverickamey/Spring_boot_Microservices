package com.LearningJPA.jpaLearning.dtos;

import com.LearningJPA.jpaLearning.models.Employee;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
// this is Getter and setter we get from lombok so we have added
// a dependency from the
@Getter
@Setter
public class CreateEmployeeDTO {


    @NotBlank
    private String name;

    @Max(70)
    @Min(18)
    private int age;

    private String country;
    /* rather than using below we can use Builder design patterns
    use a design pattern with @Builder in the Employee class
    public Employee toModel(){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setCountry(country);
        return employee;
    }
     */
    public Employee toModel(){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(22);
        employee.setCountry("India");

        // Hibernate: insert into employee (age,country,designation,name,salary,id) values (?,?,?,?,?,?)
        // after post call we see that go to see how save is used here..
        //
        // this is done by design pattern ie factory class
        // further here navigate to target->employee class you will see getter and setter are already set and
        // further there is object which is returned of employee which will take ca
//        Employee employee = Employee.builder().
//                age(age).
//                country(country).
//                name(name).
//                build();
        return employee;
    }

}


/*
Use this http://localhost:8080/addEmployee with POST
{
        "name": "",
        "id": 21,
        "designation": "SWE"
}
try sending it via name NULL it will return
{
    "timestamp": "2023-10-31T00:17:33.199+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/addEmployee"
}


similary set the age as 108 as min and max we have already set


 */