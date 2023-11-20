package com.jbdl58.learningspringbootdemo.Controllers;
import com.jbdl58.learningspringbootdemo.Employee;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    List<Employee> employeeList;
    HashMap<Integer, Employee> employeeHashMap = new HashMap<>();
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee)  throws Exception{
        /*
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getEmailId());
        */
        if(employee.getId() == 0){
            throw new Exception("Id not present");
        }
        if(employeeHashMap.containsKey(employee.getId())) {
            //employeeList.add(employee);
            throw new Exception("Key already exists");
        }
        employeeHashMap.put(employee.getId(), employee);
        return "Employee is created";

    }

    @GetMapping("/getEmployees")
    public List<Employee> fetchAllEmployees(){
       return employeeHashMap.values().stream().collect(Collectors.toList());

    }

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
    @GetMapping("/getEmployee/id/{id}")
    public Employee fetchAllEmployees(@PathVariable("id") int id) throws Exception{
        if(employeeHashMap.containsKey(id) == false){
            throw new Exception("Key doesn't exist");
        }

        return employeeHashMap.get(id);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public String deleteEmployee(@RequestParam("id") int id){
        if(employeeHashMap.containsKey(id)){
            employeeHashMap.remove(id);
            return "Employee Deleted";
        }
        return "ID Doesn't exist";
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        if(employeeHashMap.containsKey(employee.getId()) == false){
            return "ID doesn't Deleted";
        }
        employeeHashMap.put(employee.getId(), employee);
        return "Update success";
    }

    //Request param is
    @PatchMapping("/updateEmployee")
    public String updateEmployee2(@RequestBody Employee employee ){
        int id = employee.getId();
        if(employee.getEmailId() != null){
            employeeHashMap.get(id).setEmailId(employee.getEmailId());
        }
        if(employee.getDesignation() != null){
            employeeHashMap.get(id).setDesignation(employee.getDesignation());
        }
        return "patch the employee one";
    }

}
    /*
   public String addEmployee(@RequestParam("id") String id,
                           @RequestParam("name") String name){
                System.out.println("Employee " + id + " " + name + "created");
                // below one is for the o/p in the postman for post call
                return "hey";


    }
    */

