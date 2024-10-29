package com.app.banking_app.service;


import java.util.List;

import com.app.banking_app.dto.AccountDto;
import com.app.banking_app.entity.AccountEntity;

public interface AccountService {

    AccountDto creatAccount(AccountDto account);

    List<AccountDto> allAcountDetails();
    
}
