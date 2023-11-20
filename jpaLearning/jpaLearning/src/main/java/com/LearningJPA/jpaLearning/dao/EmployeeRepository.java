package com.LearningJPA.jpaLearning.dao;

import com.LearningJPA.jpaLearning.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // in interface we cant write the implementation
    //
    @Query(value = "select * from employee_table where name = ?1", nativeQuery = true)
    public Employee getEmployeebyName();
}
