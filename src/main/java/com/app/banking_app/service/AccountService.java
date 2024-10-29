package com.app.banking_app.service;


import java.util.List;

import com.app.banking_app.dto.AccountDto;


public interface AccountService {

    AccountDto creatAccount(AccountDto account);

    List<AccountDto> allAcountDetails();

    AccountDto getAccountById(Long id);

    AccountDto depositAmount(Long id, Double amount);

    AccountDto withdrawAmount(Long id, Double amount);

    void deleteAccount(long id);
    
}
