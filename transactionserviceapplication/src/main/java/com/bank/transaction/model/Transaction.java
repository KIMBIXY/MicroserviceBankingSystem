package com.bank.transaction.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

@Data
@AllArgsConstructor
public class Transaction {
    private Long accountId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}
