package com.bank.transaction.event;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bank.transaction.model.TransactionType;

@Entity
@Table(name = "transaction_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCreatedEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}

