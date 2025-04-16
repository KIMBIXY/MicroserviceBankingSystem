package com.bank.transaction.query;

import java.util.List;

import com.bank.transaction.model.Transaction;

public interface TransactionQueryService {
    List<Transaction> getTransactionsByAccount(Long accountId);
}
