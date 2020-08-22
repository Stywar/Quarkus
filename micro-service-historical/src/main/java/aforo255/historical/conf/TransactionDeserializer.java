package aforo255.historical.conf;


import aforo255.historical.entity.Transaction;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class TransactionDeserializer extends JsonbDeserializer<Transaction> {
	
    public TransactionDeserializer() {
        super(Transaction.class);
    }
}