import java.io.File;
import java.util.List;

public interface TransactionReader {
    List<Transaction> readTransactions(File file);
}
