import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @PostMapping("/monitor")
    public String monitorTransaction(@RequestBody String transactionData) {
        // Send transaction data to Kafka
        KafkaProducerExample.sendTransaction(transactionData);
        return "Transaction monitored";
    }
}
