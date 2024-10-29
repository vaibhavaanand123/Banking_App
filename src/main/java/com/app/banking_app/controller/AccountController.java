package com.app.banking_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){

        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok().body(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id,@RequestBody Map<String,Double> request){

        Double amount=request.get("amount");
        AccountDto accountDto=accountService.depositAmount(id, amount);
        return ResponseEntity.ok().body(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id,@RequestBody Map<String,Double> request){

        Double amount=request.get("amount");
        AccountDto accountDto=accountService.withdrawAmount(id, amount);
        return ResponseEntity.ok().body(accountDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id){

        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is Deleted");
    }




    @PostMapping
    public ResponseEntity<AccountDto> creatAccount(@RequestBody AccountDto accountDto){

        AccountDto saveAccountDto=accountService.creatAccount(accountDto);
        return ResponseEntity.ok().body(saveAccountDto);
    }
    
}
