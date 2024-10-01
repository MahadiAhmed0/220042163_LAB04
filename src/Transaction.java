public class Transaction{
    public double amount;
    public String date;
    public String description;
    public Transaction(String date, double amount, String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
