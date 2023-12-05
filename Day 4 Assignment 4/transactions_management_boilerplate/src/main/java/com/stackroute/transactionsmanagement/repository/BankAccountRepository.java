package com.stackroute.transactionsmanagement.repository;

import com.stackroute.transactionsmanagement.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
}
