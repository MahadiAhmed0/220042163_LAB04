public class JSONTransaction implements Transaction{
    public double amount;
    public String date;
    public String description;
    public JSONTransaction(String date, double amount, String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
