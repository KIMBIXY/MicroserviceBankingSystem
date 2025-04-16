package com.bank.transaction.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bank.transaction.event.TransactionCreatedEvent;
import com.bank.transaction.event.TransactionEventRepository;
import com.bank.transaction.model.Transaction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {
    private final TransactionEventRepository transactionEventRepository;

    @Override
    public List<Transaction> getTransactionsByAccount(Long accountId) {
        List<TransactionCreatedEvent> events = transactionEventRepository.findByAccountId(accountId);
        return events.stream()
            .map(e -> new Transaction(e.getAccountId(), e.getType(), e.getAmount(), e.getTimestamp()))
            .collect(Collectors.toList());
    }
}

