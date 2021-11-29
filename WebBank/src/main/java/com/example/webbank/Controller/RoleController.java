package com.example.webbank.Controller;

import com.example.webbank.Service.ServiceImp.RoleServiceImp;
import com.example.webbank.entity.RoleAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"api/role"})
@CrossOrigin
public class RoleController {
    @Autowired
   public RoleServiceImp roleService;
    @PostMapping
    public ResponseEntity<?>addRole(@RequestBody RoleAccount roleAccount){
        roleService.save(roleAccount);
        return ResponseEntity.ok("add success");
    }
    @GetMapping
    public ResponseEntity<?>getAll(){
      return ResponseEntity.ok( roleService.findAll());
    }
}
