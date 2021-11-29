package com.example.webbank.Controller;

import com.example.webbank.Service.AccountService;
import com.example.webbank.Service.ServiceImp.AccountServiceImp;
import com.example.webbank.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"api/account"})
@CrossOrigin
public class AccountController {
    @Autowired
    public AccountServiceImp accountService;

    @GetMapping
    public ResponseEntity<?>getAll(){
        return  ResponseEntity.ok(accountService.findAll());
    }
    @PostMapping
    public ResponseEntity<?>add(@RequestBody AccountEntity account){
        accountService.save(account);
        return  ResponseEntity.ok("Create success!");
    }
    @DeleteMapping
    public ResponseEntity<?>delete(@RequestParam Long id){
       accountService.deleteById(id);
       return  ResponseEntity.ok("Delete Success");

    }
}
