package main.java.com.bank.transaction.query;

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

