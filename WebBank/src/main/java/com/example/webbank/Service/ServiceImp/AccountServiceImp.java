package com.example.webbank.Service.ServiceImp;

import com.example.webbank.Repository.AccountRepository;
import com.example.webbank.Service.AccountService;
import com.example.webbank.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    public AccountRepository accountRepository;
    @Override
    public void save(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }
    @Override
    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity findById(Long t) {
        return accountRepository.findById(t).get();
    }

    @Override
    public List<AccountEntity> findByName(String name) {
        return accountRepository.findByAccountCode(name);
    }

    @Override
    public void deleteById(Long id) {
          AccountEntity account = accountRepository.findById(id).get();
          if(account!=null){
              accountRepository.deleteById(id);
          }
    }
}
