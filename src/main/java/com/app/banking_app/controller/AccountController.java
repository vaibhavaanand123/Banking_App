package com.app.banking_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.banking_app.dto.AccountDto;
import com.app.banking_app.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccount(){

        List<AccountDto> accountDtos=accountService.allAcountDetails();
        return ResponseEntity.ok().body(accountDtos);
    }

    @PostMapping
    public ResponseEntity<AccountDto> creatAccount(@RequestBody AccountDto accountDto){

        AccountDto saveAccountDto=accountService.creatAccount(accountDto);
        return ResponseEntity.ok().body(saveAccountDto);
    }
    
}
