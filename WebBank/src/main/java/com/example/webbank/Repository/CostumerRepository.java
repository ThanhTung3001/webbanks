package com.example.webbank.Repository;

import com.example.webbank.entity.CostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostumerRepository extends JpaRepository<CostumerEntity,Long> {
    public List<CostumerEntity>findByFullName(String fullName);
}
