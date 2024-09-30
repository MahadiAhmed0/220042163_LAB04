import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path to your CSV file: "); //Get CSV file
        String csvFile = scanner.nextLine();

        String line;
        String csvSplitBy = ",";

        //**List, Map creation**

        List<Expense> expenses = new ArrayList<>();
        Map<String, Integer> transactionsPerMonth = new HashMap<>();
        Map<String, Double> categoryTotals = new HashMap<>();

        double totalProfit = 0;
        double totalLoss = 0;

        //**File read**

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);

                if (values.length < 3) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }

                try {
                    String date = values[0].trim();
                    double expense = Double.parseDouble(values[1].trim());
                    String category = values[2].trim();

                    expenses.add(new Expense(date, expense, category));

                    if (expense < 0) {
                        totalLoss += expense;
                    } else {
                        totalProfit += expense;
                    }

                    String monthYear = date.substring(3, 7); //DD-MM-YYYY format
                    transactionsPerMonth.put(monthYear, transactionsPerMonth.getOrDefault(monthYear, 0) + 1);


                    categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + expense);

                } catch (NumberFormatException e) {
                    System.err.println("Error parsing number: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //**Getting Expense list**

        List<Expense> topNegativeExpenses = expenses.stream()
                .filter(e -> e.expense < 0)
                .sorted(Comparator.comparingDouble(e -> e.expense))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Top 10 Negative Expenses:");
        for (Expense e : topNegativeExpenses) {
            System.out.printf("Expense: %.2f - %s%n", e.expense, e.category);
        }

        //**Getting Transaction Number**

        System.out.println("\nNumber of Transactions Per Month:");
        for (Map.Entry<String, Integer> entry : transactionsPerMonth.entrySet()) {
            System.out.printf("Month %s: %d transactions%n", entry.getKey(), entry.getValue());
        }

        //**Getting profit or loss and positive or negative value of the whole statement**

        System.out.printf("\nTotal Profit: %.2f%n", totalProfit);
        System.out.printf("Total Loss: %.2f%n", totalLoss);
        if(totalProfit>totalLoss){
            System.out.println("Value: Positive");
        }
        else{
            System.out.println("Value: Negative");
        }

        //**Getting most spent value**

        String mostSpentCategory = categoryTotals.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
        double mostSpentAmount = categoryTotals.values().stream()
                .max(Double::compare)
                .orElse(0.0);

        System.out.printf("\nMost Spent Money On: %s (%.2f)%n", mostSpentCategory, mostSpentAmount);

        scanner.close();
    }

}
