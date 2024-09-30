import java.io.File;

public class TransactionFactory {
    public static TransactionReader getReader(File file) {
        String fileName = file.getName().toLowerCase();
        if (fileName.endsWith(".csv")) {
            return new CSVTransactionReader();
        } else if (fileName.endsWith(".json")) {
            return new JSONTransactionReader();
        } else if (fileName.endsWith(".xml")) {
            return new XMLTransactionReader();
        }
        throw new IllegalArgumentException("Unsupported file type");
    }
}
