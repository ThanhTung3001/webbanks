package com.example.webbank.Service.ServiceImp;

import com.example.webbank.Repository.RoleRepository;
import com.example.webbank.Service.RoleService;
import com.example.webbank.entity.RoleAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    public RoleRepository roleRp;
    @Override
    public void save(RoleAccount roleAccount) {
        roleRp.save(roleAccount);
    }
    @Override
    public List<RoleAccount> findAll() {
        return roleRp.findAll();
    }

    @Override
    public RoleAccount findById(Long t) {
        return roleRp.findById(t).get();
    }

    @Override
    public List<RoleAccount> findByName(String name) {
        return roleRp.findByErole(name);
    }

    @Override
    public void deleteById(Long id) {
        RoleAccount role =roleRp.findById(id).get();
        if(role!=null){
            roleRp.deleteById(id);
        }
    }
}
