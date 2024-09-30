import java.io.File;

public class Main {
    public static void main(String[] args) {
        BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        File file = new File("D:\\transactions.xml");
        analyzer.loadTransactions(file);

        System.out.println("Total Profit/Loss: " + analyzer.totalProfitLoss());
        System.out.println("Transactions in February 2017: " + analyzer.countTransactionsByMonth("02", "2017"));
        System.out.println("Top 10 Expenses: " + analyzer.topExpenses(10));
        System.out.println("Category with highest spending: " + analyzer.spendingCategory());
    }
}
