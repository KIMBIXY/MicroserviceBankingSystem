package main.java.com.bank.transaction.event;

@Entity
@Table(name = "transaction_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCreatedEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}

