package com.bank.transaction.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bank.transaction.event.TransactionEventRepository;
import com.bank.transaction.model.TransactionType;

import lombok.RequiredArgsConstructor;
import com.bank.transaction.event.TransactionCreatedEvent;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {
    private final TransactionEventRepository transactionEventRepository;

    @Override
    public void deposit(Long accountId, BigDecimal amount) {
        TransactionCreatedEvent event = new TransactionCreatedEvent(
            null, accountId, TransactionType.DEPOSIT, amount, LocalDateTime.now()
        );
        transactionEventRepository.save(event);
    }

    @Override
    public void withdraw(Long accountId, BigDecimal amount) {
        TransactionCreatedEvent event = new TransactionCreatedEvent(
            null, accountId, TransactionType.WITHDRAWAL, amount, LocalDateTime.now()
        );
        transactionEventRepository.save(event);
    }
}

