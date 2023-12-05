package com.stackroute.transactionsmanagement.controller;

import com.stackroute.transactionsmanagement.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount) {
        //return status code 200 and "Money transferred successfully" message if success
        try
        {
            bankAccountService.transferMoney(fromAccountId,toAccountId,amount);
            return new ResponseEntity<String>("Money transferred successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
