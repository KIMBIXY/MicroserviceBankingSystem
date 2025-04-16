package com.bank.transaction.event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TransactionEventRepository extends CrudRepository<TransactionCreatedEvent, Long> {
    List<TransactionCreatedEvent> findByAccountId(Long accountId);
}

