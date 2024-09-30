import java.io.File;
import java.util.List;
import java.lang.Throwable;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JSONTransactionReader implements TransactionReader{

    @Override
    public List<Transaction> readTransactions(File file) {
        ObjectMapper mapper = new ObjectMapper();
        try{
                return List.of(mapper.readValue(file, Transaction[].class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
