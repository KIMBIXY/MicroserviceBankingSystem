package com.bank.transaction.query;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.transaction.model.Transaction;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionQueryController {
    private final TransactionQueryService transactionQueryService;

    @GetMapping
    public List<Transaction> getTransactions(@RequestParam Long accountId) {
        return transactionQueryService.getTransactionsByAccount(accountId);
    }
}

