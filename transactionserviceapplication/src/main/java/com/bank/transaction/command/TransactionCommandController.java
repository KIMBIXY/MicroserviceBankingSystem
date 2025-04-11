package main.java.com.bank.transaction.command;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionCommandController {
    private final TransactionCommandService transactionCommandService;

    @RequestMapping("/deposit/{accountId}/{amount}")
    public void deposit(@RequestParam("accountId") Long accountId, @RequestParam("amount") BigDecimal amount) {
        transactionCommandService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        transactionCommandService.withdraw(accountId, amount);
    }
}
