package com.app.banking_app.mapper;

import com.app.banking_app.dto.AccountDto;
import com.app.banking_app.entity.AccountEntity;

public class AccountMapper {

    public static AccountEntity mapTAccountEntity(AccountDto accountDto){

        AccountEntity accountEntity=new AccountEntity();

        accountEntity.setId(accountDto.getId());
        accountEntity.setAccountHolderName(accountDto.getAccountHolderName());
        accountEntity.setBalance(accountDto.getBalance());
        return accountEntity;
    }
    

    public static AccountDto mapTAccountDto(AccountEntity accountEntity){

        AccountDto accountDto=new AccountDto();

        accountDto.setId(accountEntity.getId());
        accountDto.setAccountHolderName(accountEntity.getAccountHolderName());
        accountDto.setBalance(accountEntity.getBalance());
        return accountDto;
    }
}
