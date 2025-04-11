package main.java.com.bank.transaction.command;

import java.math.BigDecimal;

public interface TransactionCommandService {
    void deposit(Long accountId, BigDecimal amount);
    void withdraw(Long accountId, BigDecimal amount);
}
