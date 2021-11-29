package com.example.webbank.Repository;

import com.example.webbank.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
  public   List<EmployeeEntity>findByFullName(String name);
}
