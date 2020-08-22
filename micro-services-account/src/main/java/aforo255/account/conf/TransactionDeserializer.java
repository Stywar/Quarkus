package aforo255.account.conf;
import aforo255.account.consumer.entity.Transaction;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class TransactionDeserializer extends JsonbDeserializer<Transaction> {
	
    public TransactionDeserializer() {
        super(Transaction.class);
    }
}