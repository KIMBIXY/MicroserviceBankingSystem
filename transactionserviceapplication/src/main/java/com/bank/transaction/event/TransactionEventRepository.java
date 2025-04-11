package main.java.com.bank.transaction.event;

public interface TransactionEventRepository extends CrudRepository<TransactionCreatedEvent, Long> {
    List<TransactionCreatedEvent> findByAccountId(Long accountId);
}

