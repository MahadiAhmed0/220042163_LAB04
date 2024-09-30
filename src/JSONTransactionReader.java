import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.lang.Throwable;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTransactionReader implements TransactionReader {

    @Override
    public List<Transaction> readTransactions(File file) {
        ObjectMapper mapper = new ObjectMapper();
        List<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
}
