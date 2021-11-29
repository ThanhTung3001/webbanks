package com.example.webbank.Service.ServiceImp;

import com.example.webbank.Convert.ConvertDto;
import com.example.webbank.Dto.EmployeeDto;
import com.example.webbank.Repository.EmployeeRepository;
import com.example.webbank.Service.EmployeeService;
import com.example.webbank.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public void save(EmployeeEntity entity) {
        employeeRepository.save(entity);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity findById(Long t) {
        return employeeRepository.findById(t).get();
    }

    @Override
    public List<EmployeeEntity> findByName(String name) {
        return employeeRepository.findByFullName(name);
    }

    @Override
    public void deleteById(Long id) {
        EmployeeEntity entity = employeeRepository.findById(id).get();
        if(entity!=null){
            employeeRepository.deleteById(id);
        }
    }

    @Override
    public void Update(EmployeeEntity entity) {
           EmployeeEntity e =employeeRepository.findById(entity.getId()).get();
           if(e!=null){
               e=entity;
               employeeRepository.save(e);
           }
    }

    @Override
    public List<EmployeeDto> getAll() {
        return new ConvertDto().toListEmployeeDto(employeeRepository.findAll());
    }
}
