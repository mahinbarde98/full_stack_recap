package com.stackroute.transactionsmanagement.test;

import com.stackroute.transactionsmanagement.controller.TransactionController;
import com.stackroute.transactionsmanagement.service.BankAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {

    @Mock
    private BankAccountService bankAccountService;

    @InjectMocks
    private TransactionController transactionController;

    @Before
    public void setUp() {
        // Mock setup if needed
    }

    @Test
    public void testTransferMoneySuccess() {
        doNothing().when(bankAccountService).transferMoney(1L, 2L, 500.0);

        ResponseEntity<String> responseEntity = transactionController.transferMoney(1L, 2L, 500.0);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Money transferred successfully", responseEntity.getBody());
    }
    
}

