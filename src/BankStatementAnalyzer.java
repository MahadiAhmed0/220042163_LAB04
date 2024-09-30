import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankStatementAnalyzer {
    private List<Transaction> transactions;

    public void loadTransactions(File file) {
        TransactionReader reader = TransactionFactory.getReader(file);
        this.transactions = reader.readTransactions(file);
    }

    public double totalProfitLoss() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public int countTransactionsByMonth(String month, String year) {
        return (int) transactions.stream()
                .filter(t -> t.getDate().startsWith(month + "-" + year))
                .count();
    }

    public List<Transaction> topExpenses(int n) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .limit(n)
                .toList();
    }

    public String spendingCategory() {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getDescription, Collectors.summingDouble(Transaction::getAmount)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No expenses");
    }
}
