package com.example.webbank.Service.ServiceImp;

import com.example.webbank.Convert.ConvertDto;
import com.example.webbank.Dto.CostumerDto;
import com.example.webbank.EnumDefauld.EROLE;
import com.example.webbank.Repository.AccountRepository;
import com.example.webbank.Repository.CostumerRepository;
import com.example.webbank.Repository.RoleRepository;
import com.example.webbank.Service.CostumerService;
import com.example.webbank.entity.CostumerEntity;
import com.example.webbank.entity.RoleAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CostumerServiceImp implements CostumerService {
    @Autowired
    public CostumerRepository costumerRepository;
    @Autowired
    public AccountRepository accountRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void save(CostumerEntity costumerEntity) {
        RoleAccount role = roleRepository.findById(costumerEntity.getEntity().getRoleAccount().getId()).get();
        costumerEntity.getEntity().setRoleAccount(role);
        costumerRepository.save(costumerEntity);
    }

    @Override
    public List<CostumerEntity> findAll() {
        return costumerRepository.findAll();
    }

    @Override
    public CostumerEntity findById(Long t) {
        return costumerRepository.findById(t).get();
    }

    @Override
    public List<CostumerEntity> findByName(String name) {
        return costumerRepository.findByFullName(name);
    }

    @Override
    public void deleteById(Long id) {
         CostumerEntity costumer = costumerRepository.findById(id).get();
         if(costumer!=null){
             costumerRepository.deleteById(id);
         }
    }

    @Override
    public void AddRoleForCostumerById(Long id, EROLE erole) {
        CostumerEntity costumer = costumerRepository.findById(id).get();
        if(costumer!=null){
            RoleAccount roleAccount = new RoleAccount();
            roleAccount.setErole(erole);
            roleAccount.setId(costumer.getEntity().getRoleAccount().getId());
            costumer.getEntity().setRoleAccount(roleAccount);
            costumerRepository.save(costumer);
        }
    }

    @Override
    public boolean checkout(Long id, float price) {
        CostumerEntity costumer = costumerRepository.findById(id).get();
        float rest = costumer.getEntity().getAvailable()-price;
        if(rest<0){
            return false;
        }
        costumer.getEntity().setAvailable(rest);
        costumerRepository.save(costumer);
            return  true;
    }

    @Override
    public List<CostumerDto> FindAllCostumers() {
        return new ConvertDto().toListCostumerDto(costumerRepository.findAll());
    }

    @Override
    public CostumerDto findByID(Long id) {
        return new ConvertDto().toCostumerDto(costumerRepository.findById(id).get());
    }

    @Override
    public boolean update(CostumerEntity costumerEntity) {
        CostumerEntity costumer =costumerRepository.findById(costumerEntity.getId()).get();

            try {
                costumerRepository.save(costumerEntity);
                return true;
            } catch (Exception e) {
                return false;
            }

    }
}
