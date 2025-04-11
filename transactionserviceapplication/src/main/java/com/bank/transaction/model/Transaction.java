package main.java.com.bank.transaction.model;

@Data
@AllArgsConstructor
public class Transaction {
    private Long accountId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}
