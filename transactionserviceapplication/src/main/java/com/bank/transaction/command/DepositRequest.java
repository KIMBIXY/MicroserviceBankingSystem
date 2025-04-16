package com.bank.transaction.command;

import java.math.BigDecimal;

public class DepositRequest {
    private Long accountId;
    private BigDecimal amount;

    // Getters et setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
