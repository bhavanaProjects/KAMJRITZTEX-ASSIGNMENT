import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkJob {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> transactionStream = env.addSource(new FlinkKafkaConsumer<>("transactions", new SimpleStringSchema(), new Properties()));

        transactionStream
            .map(transactionData -> {
                if (FraudDetection.isFraudulentTransaction(transactionData)) {
                    System.out.println("Fraudulent transaction detected: " + transactionData);
                }
                return transactionData;
            });

        env.execute("Transaction Monitoring Job");
    }
}
