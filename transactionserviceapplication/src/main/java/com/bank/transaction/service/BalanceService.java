package com.bank.transaction.service;

import com.bank.transaction.model.Transaction;
import com.bank.transaction.model.TransactionType;
import com.bank.transaction.event.TransactionCreatedEvent;
import com.bank.transaction.event.TransactionEventRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BalanceService {
    private final TransactionEventRepository transactionRepository;

    public BalanceService(TransactionEventRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

   public BigDecimal calculateBalance(Long accountId) {
    // Convertir Iterable en List
    List<TransactionCreatedEvent> transactions = new ArrayList<>();
    transactionRepository.findAll().forEach(transactions::add);

    BigDecimal balance = BigDecimal.ZERO;

    for (TransactionCreatedEvent transaction : transactions) {
        if (transaction.getAccountId().equals(accountId)) {
            // Vérification du type de transaction avec l'énumération TransactionType
            if (transaction.getType() == TransactionType.DEPOSIT) {
                balance = balance.add(transaction.getAmount()); // Augmente le solde
            } else if (transaction.getType() == TransactionType.WITHDRAWAL) {
                balance = balance.subtract(transaction.getAmount()); // Diminue le solde
            }
        }
    }

    return balance;
}

}
