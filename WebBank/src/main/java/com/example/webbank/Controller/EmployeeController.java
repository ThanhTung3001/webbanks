package com.example.webbank.Controller;


import com.example.webbank.Dto.MessageResponse;
import com.example.webbank.Service.EmployeeService;

import com.example.webbank.entity.EmployeeEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@CrossOrigin
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<?>getAll(){
      return  ResponseEntity.ok(employeeService.getAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody EmployeeEntity entity){
         employeeService.save(entity);
        return ResponseEntity.ok(new MessageResponse("Add Success !"));
    }
    @PutMapping
    public  ResponseEntity<?>Update(@RequestBody EmployeeEntity entity){
        employeeService.Update(entity);
        return ResponseEntity.ok(new MessageResponse("Update Success!"));
    }
    @DeleteMapping
    public  ResponseEntity<?>Delete(@RequestParam(name = "id") Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("delete success"));
    }
    @GetMapping("/user")
    public ResponseEntity<EmployeeEntity>findById(@RequestParam(name = "id")Long id){
        return ResponseEntity.ok(employeeService.findById(id));
    }


}
