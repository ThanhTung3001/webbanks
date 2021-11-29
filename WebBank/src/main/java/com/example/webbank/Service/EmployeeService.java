package com.example.webbank.Service;

import com.example.webbank.Dto.EmployeeDto;
import com.example.webbank.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService extends AbstractService<EmployeeEntity>{
    public  void Update(EmployeeEntity entity);

    public List<EmployeeDto> getAll();
}
