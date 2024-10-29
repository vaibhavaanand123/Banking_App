package com.app.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.banking_app.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity,Long>{
    
}
