package com.app.banking_app.service.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.banking_app.dto.AccountDto;
import com.app.banking_app.entity.AccountEntity;
import com.app.banking_app.mapper.AccountMapper;
import com.app.banking_app.repository.AccountRepository;
import com.app.banking_app.service.AccountService;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto creatAccount(AccountDto accountDto) {
        
        AccountEntity accountEntity=AccountMapper.mapTAccountEntity(accountDto);
       
        AccountEntity savedAccountEntity= accountRepository.save(accountEntity);
        
        return AccountMapper.mapTAccountDto(savedAccountEntity);

      
    }

    @Override
    public List<AccountDto> allAcountDetails() {

        List<AccountDto> accountDto= new ArrayList<>();
        List<AccountEntity> accountEntity=accountRepository.findAll();

        for(AccountEntity ae: accountEntity){
            accountDto.add(AccountMapper.mapTAccountDto(ae));
        }


        return accountDto;

    }

   

    
}
