package main.java.com.bank.transaction.query;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionQueryController {
    private final TransactionQueryService transactionQueryService;

    @GetMapping
    public List<Transaction> getTransactions(@RequestParam Long accountId) {
        return transactionQueryService.getTransactionsByAccount(accountId);
    }
}

