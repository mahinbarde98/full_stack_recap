package com.stackroute.transactionsmanagement.test;

import com.stackroute.transactionsmanagement.model.BankAccount;
import com.stackroute.transactionsmanagement.repository.BankAccountRepository;
import com.stackroute.transactionsmanagement.service.BankAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTest {

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private BankAccountService bankAccountService;

    private BankAccount fromAccount;
    private BankAccount toAccount;

    @Before
    public void setUp() {
        fromAccount = new BankAccount(1L, "1234567890", 1000.0);
        toAccount = new BankAccount(2L, "0987654321", 2000.0);
    }

    @Test
    public void testTransferMoneySufficientBalance() {
        when(bankAccountRepository.findById(1L)).thenReturn(Optional.of(fromAccount));
        when(bankAccountRepository.findById(2L)).thenReturn(Optional.of(toAccount));

        bankAccountService.transferMoney(1L, 2L, 500.0);

        assertEquals(500.0, fromAccount.getBalance(), 0.001);
        assertEquals(2500.0, toAccount.getBalance(), 0.001);

        verify(bankAccountRepository, times(2)).save(any(BankAccount.class));
    }

    @Test
    public void testTransferMoneyInsufficientBalance() {
        fromAccount.setBalance(100.0);

        when(bankAccountRepository.findById(1L)).thenReturn(Optional.of(fromAccount));
        when(bankAccountRepository.findById(2L)).thenReturn(Optional.of(toAccount));

        assertThrows(RuntimeException.class, () -> bankAccountService.transferMoney(1L, 2L, 500.0));

        verify(bankAccountRepository, never()).save(any(BankAccount.class));
    }

    @Test
    public void testTransferMoneyFromAccountNotFound() {
        when(bankAccountRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> bankAccountService.transferMoney(1L, 2L, 500.0));

        verify(bankAccountRepository, never()).save(any(BankAccount.class));
    }

    @Test
    public void testTransferMoneyToAccountNotFound() {
        when(bankAccountRepository.findById(1L)).thenReturn(Optional.of(fromAccount));
        when(bankAccountRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> bankAccountService.transferMoney(1L, 2L, 500.0));

        verify(bankAccountRepository, never()).save(any(BankAccount.class));
    }
}

