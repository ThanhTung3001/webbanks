package com.example.webbank.Repository;

import com.example.webbank.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    public List<AccountEntity> findByAccountCode(String accountCode);
}
