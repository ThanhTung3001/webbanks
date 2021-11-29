package com.example.webbank.Service;

import com.example.webbank.Dto.CostumerDto;
import com.example.webbank.EnumDefauld.EROLE;
import com.example.webbank.entity.CostumerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostumerService extends AbstractService<CostumerEntity> {
    public void AddRoleForCostumerById(Long id, EROLE erole);
    public boolean checkout(Long id,float price);
    public List<CostumerDto> FindAllCostumers();
    public CostumerDto findByID(Long id);
    public boolean update(CostumerEntity costumerEntity);
}
