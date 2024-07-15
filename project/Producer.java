import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerExample {
    private static final String TOPIC = "transactions";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        String transactionData = "{\"transactionId\":\"12345\", \"amount\":100.0, \"timestamp\":1621234567890}";
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, transactionData);

        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.printf("Sent record(key=%s value=%s) meta(partition=%d, offset=%d)\n",
                        record.key(), record.value(), metadata.partition(), metadata.offset());
            } else {
                exception.printStackTrace();
            }
        });

        producer.close();
    }
}
