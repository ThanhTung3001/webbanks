package com.example.webbank.Controller;

import com.example.webbank.Dto.MessageResponse;
import com.example.webbank.Repository.AccountRepository;
import com.example.webbank.Repository.RoleRepository;
import com.example.webbank.Service.CostumerService;
import com.example.webbank.entity.CostumerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"api/costumer"})
@CrossOrigin
public class CostumerController {

    @Autowired
    public CostumerService costumerService;
    @GetMapping
    public ResponseEntity<?>getAll(){
          return ResponseEntity.ok(costumerService.FindAllCostumers());
    }
    @GetMapping("/user")
    public ResponseEntity<?>findById(@RequestParam Long id){
       return  ResponseEntity.ok(costumerService.findByID(id));
    }
    @PostMapping
    public  ResponseEntity<?>add(@RequestBody CostumerEntity costumerEntity){
        costumerService.save(costumerEntity);
        return ResponseEntity.ok(new MessageResponse("Add success!"));
    }
    @PutMapping
    public  ResponseEntity<?>Update(@RequestBody CostumerEntity costumer){
      boolean result= costumerService.update(costumer);
      if(result){
          return  ResponseEntity.ok(new MessageResponse("Update success!"));
      }else {
          return  ResponseEntity.ok(new MessageResponse("Update fail!"));
      }

    }
    @GetMapping("/user-info")
    public ResponseEntity<?>findByName(@RequestParam("name") String name){
        return  ResponseEntity.ok(costumerService.findByName(name));
    }
    @DeleteMapping
    public  ResponseEntity<?>delete(@RequestParam("id")Long id){
        costumerService.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Delete Success!"));
    }
    @PostMapping("/user-checkout")
    public ResponseEntity<?>CheckOut(@RequestParam(name = "id")Long id, @RequestParam(name = "price") float price){
     boolean result= costumerService.checkout(id,price);
       if(result){
           return ResponseEntity.ok(new MessageResponse("Check Out Success"));
       }
       return  ResponseEntity.ok(new MessageResponse("insufficient"));
    }

}
