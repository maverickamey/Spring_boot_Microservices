package com.LearningJPA.jpaLearning.Controllers;

import com.LearningJPA.jpaLearning.Services.NewEmployeeService;
import com.LearningJPA.jpaLearning.dtos.CreateEmployeeDTO;
import com.LearningJPA.jpaLearning.dtos.EmployeeResponseDTO;
//import com.LearningJPA.jpaLearning.models.Employee;// Models should not be in controller class
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class EmployeeController {

    static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private NewEmployeeService employeeService;

    @PostMapping("/addEmployee")
    public EmployeeResponseDTO addEmployee(@RequestBody @Valid CreateEmployeeDTO createEmployeeDTO) {
        logger.info("I am in this code");
//        System.out.println("Hello and HI");


//        Employee employee = createEmployeeDTO.toModel();

        //here above we have received the parameters from the
        // user now fill it to service
        // this is done by creating spring IOC object as createNewEmployee is @Service
//        employeeService.createNewEmployee(employee);
        // in service is set here
//        EmployeeResponseDTO responseDTO = EmployeeResponseDTO.builder().message("Employee is created").salary(employee.getSalary()).designation(employee.getDesignation()).build();
        EmployeeResponseDTO responseDTO = employeeService.createNewEmployee(createEmployeeDTO);
        return responseDTO;

//        return new EmployeeResponseDTO();
        // here we return only string but still the response body
        // which consist of the json so we did in last project so
        //we will create DTO for the repsonse DT0

    }

    @GetMapping("/fetchEmployee")
    public EmployeeResponseDTO readEmployee(@RequestParam("name") String name){
        return employeeService.getEmployeefromname(name);
    }
}
