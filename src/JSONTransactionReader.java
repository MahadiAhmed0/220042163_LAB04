import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTransactionReader implements TransactionReader {

    @Override
    public List<Transaction> readTransactions(File file) {
        ObjectMapper mapper = new ObjectMapper();
        List<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
}
/*import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class JSONTransactionReader implements TransactionReader {
    @Override
    public List<Transaction> readTransactions(File file) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return List.of(mapper.readValue(file, Transaction[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
 */
