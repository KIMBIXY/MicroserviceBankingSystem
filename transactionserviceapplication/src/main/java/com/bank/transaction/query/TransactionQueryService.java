package main.java.com.bank.transaction.query;

public interface TransactionQueryService {
    List<Transaction> getTransactionsByAccount(Long accountId);
}
