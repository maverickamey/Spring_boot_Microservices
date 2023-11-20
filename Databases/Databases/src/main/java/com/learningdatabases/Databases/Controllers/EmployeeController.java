package com.learningdatabases.Databases.Controllers;
import com.learningdatabases.Databases.Employee;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    // here we have created a DB connection query below .
    private static Connection employeeDBConnection;
//     public void EmployeeControllers() throws SQLException {
//         System.out.println("Reaching");
//         employeeDBConnection = DBConnection.getDBConnection();
//     }
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee)  throws Exception{
        /*
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getEmailId());
        */
        employeeDBConnection = DBConnection.getDBConnection();
        String sqlquery = "INSERT INTO employee_data(name, designation, email)" +  "values(" +
                        "\"" + employee.getName() + "\"" + "," +  "\"" +employee.getDesignation() + "\"" + "," +
                "\"" +employee.getEmailId() + "\"" +");";
        System.out.println(sqlquery);
        Statement statement = employeeDBConnection.createStatement();
        statement.execute(sqlquery);

        return "";
    }
/*
        As we know
        INSERT INTO employee_data values(66,"GANJI","PSWE","somi@gmail.com");
2023-10-22T21:39:12.192-07:00 ERROR 24548 --- [io-8080-exec-10] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '66' for key 'PRIMARY'] with root cause

java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '66' for key 'PRIMARY'

Here the id 66 is duplicated so we need to take care of it through some techniques we can take care of it
by using

Soln 1:AUTO INCTREMENT FEATURE where we dont need to pass id but it automatically sets it
//Soln 2: PLACE/SERVER + TIMESTAMP + RANDOM NUMBER (PACIFIC REGION/ 7838383MS + 3672) is there in mongo DB, nosql databases
 */



//    @GetMapping("/getEmployees")
//    public List<Employee> fetchAllEmployees(){
//        return employeeHashMap.values().stream().collect(Collectors.toList());
//
//    }

    //getEmployee?id=22 returns the first output

    /*
    [
    {
        "id": 2019,
        "name": "Gonea",
        "emailId": null,
        "designation": null
    },
    {
        "id": 22,
        "name": "ganji",
        "emailId": null,
        "designation": null
    }
]

    */
//    @GetMapping("getEmployee")
//    public Employee fetchAllEmployees(@RequestParam("id") int id) throws Exception{
//        if(employeeHashMap.containsKey(id) == false){
//            throw new Exception("Key doesn't exist");
//        }
//        return employeeHashMap.get(id);
//    }

    //use Pathvariable if you want to get selected output by passing path in URL
//    @GetMapping("/getEmployee/id/{id}")
//    public Employee fetchAllEmployees(@PathVariable("id") int id) throws Exception{
//
//    }
//
//    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
//    public String deleteEmployee(@RequestParam("id") int id){
//        if(employeeHashMap.containsKey(id)){
//            employeeHashMap.remove(id);
//            return "Employee Deleted";
//        }
//        return "ID Doesn't exist";
//    }
//
//    @PutMapping("/updateEmployee")
//    public String updateEmployee(@RequestBody Employee employee){
//        if(employeeHashMap.containsKey(employee.getId()) == false){
//            return "ID doesn't Deleted";
//        }
//        employeeHashMap.put(employee.getId(), employee);
//        return "Update success";
//    }
//
//    //Request param is
//    @PatchMapping("/updateEmployee")
//    public String updateEmployee2(@RequestBody Employee employee ){
//        int id = employee.getId();
//        if(employee.getEmailId() != null){
//            employeeHashMap.get(id).setEmailId(employee.getEmailId());
//        }
//        if(employee.getDesignation() != null){
//            employeeHashMap.get(id).setDesignation(employee.getDesignation());
//        }
//        return "patch the employee one";
//    }

}
    /*
   public String addEmployee(@RequestParam("id") String id,
                           @RequestParam("name") String name){
                System.out.println("Employee " + id + " " + name + "created");
                // below one is for the o/p in the postman for post call
                return "hey";


    }
    */

