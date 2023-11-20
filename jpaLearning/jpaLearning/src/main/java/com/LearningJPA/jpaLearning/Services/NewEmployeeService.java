package com.LearningJPA.jpaLearning.Services;

import com.LearningJPA.jpaLearning.dao.EmployeeRepository;
import com.LearningJPA.jpaLearning.dtos.CreateEmployeeDTO;
import com.LearningJPA.jpaLearning.dtos.EmployeeResponseDTO;
import com.LearningJPA.jpaLearning.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewEmployeeService {
    // we will need this service in controller

    @Autowired
    EmployeeRepository employeeRepository ;


    public EmployeeResponseDTO getEmployeefromname(String name){
        Employee employee = employeeRepository.getEmployeebyName();
        Integer id = employee.getId();
        String message = id.toString() + "id of fetched employee";
        return EmployeeResponseDTO.builder().message(message).salary(100).build();

    }
    public EmployeeResponseDTO createNewEmployee(CreateEmployeeDTO createEmployeeDTO){
        Employee employee = createEmployeeDTO.toModel();
        if(employee.getName().charAt(0) == 'K'){
            employee.setDesignation("STAFF SOFTWARE ENGINEER");
            employee.setSalary(100);
        }else{
            employee.setDesignation("CTO");
            employee.setSalary(100000);
        }
        // DAO object we created at top is instatianted from crudrepo class so we use it here based on objects and save it
        employeeRepository.save(employee);
        EmployeeResponseDTO responseDTO = EmployeeResponseDTO.builder().message("Employee is created").salary(employee.getSalary()).designation(employee.getDesignation()).build();
        return responseDTO;
    }
}


/*
This is the output
{
    "salary": 100000,
    "designation": "CTO",
    "message": "Employee is created"
}


Again after creating DAO ie Employee repo and autowiring it
further we tried putting data with 2 post calls , first one went through and created a table
mysql> select * from employee;
+----+-----+---------+-------------+-------+--------+
| id | age | country | designation | name  | salary |
+----+-----+---------+-------------+-------+--------+
|  0 |  22 | India   | CTO         | janji | 100000 |
+----+-----+---------+-------------+-------+--------+
1 row in set (0.00 sec)

Then further here we see is that
{
        "name": "yashavai",
        "age": 25,
        "country": "Dubai"

}

then it thre error as
{
    "timestamp": "2023-11-02T23:39:42.693+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/addEmployee"
}


So the error was
java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '0' for key 'PRIMARY'


How this issue is here , so the primary key our ID is everytime = 0 that is the issue here
    @GeneratedValue(strategy = GenerationType.AUTO) // as ID is primary key and then it is similar to autoincrement
this will take care of adding different IDs here
with auto new table is created  in logs we see
Hibernate: create table employee_seq (next_val bigint) engine=InnoDB
Hibernate: insert into employee_seq values ( 1 )

so we see 2 tables
mysql> show tables;
+-----------------------+
| Tables_in_employee_db |
+-----------------------+
| employee              |
| employee_seq          |
+-----------------------+
2 rows in set (0.00 sec)

mysql> show tables;^C
mysql> select * from employee_seq;
+----------+
| next_val |
+----------+
|        1 |
+----------+
1 row in set (0.00 sec)
so this next_val gets incremented after every addition of the new entry
 */