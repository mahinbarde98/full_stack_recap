package com.stackroute.transactionsmanagement.service;

import com.stackroute.transactionsmanagement.model.BankAccount;
import com.stackroute.transactionsmanagement.repository.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, double amount) {
        //write business logic for transferring money from one account to another

        Optional<BankAccount> fromAccount = bankAccountRepository.findById(fromAccountId);
        Optional<BankAccount> toAccount = bankAccountRepository.findById(toAccountId);
        if(fromAccount.get().getBalance()>500){
            toAccount.get().setBalance(toAccount.get().getBalance()+amount);
            fromAccount.get().setBalance(fromAccount.get().getBalance()-amount);
            bankAccountRepository.save(fromAccount.get());
            bankAccountRepository.save(toAccount.get());

        }
        else throw new RuntimeException();

    }
}

