import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVTransactionReader implements TransactionReader{

    @Override
    public List<Transaction> readTransactions(File file) {
        List<Transaction> transactions = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] fields = line.split(",");
                transactions.add(new CSVTransaction(fields[0], Double.parseDouble(fields[1]), fields[2]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }
}
