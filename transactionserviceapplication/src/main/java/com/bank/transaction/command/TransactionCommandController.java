package com.bank.transaction.command;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionCommandController {
    private final TransactionCommandService transactionCommandService;

    @PostMapping("/deposit")
    public void deposit(@RequestBody DepositRequest request) {
        transactionCommandService.deposit(request.getAccountId(), request.getAmount());
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody WithdrawRequest request) {
        transactionCommandService.withdraw(request.getAccountId(), request.getAmount());
    }
}
