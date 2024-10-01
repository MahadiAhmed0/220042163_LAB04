import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLTransactionReader implements TransactionReader{
    @Override
    public List<Transaction> readTransactions(File file) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            NodeList nodeList = doc.getElementsByTagName("transaction");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String date = element.getElementsByTagName("date").item(0).getTextContent();
                double amount = Double.parseDouble(element.getElementsByTagName("amount").item(0).getTextContent());
                String description = element.getElementsByTagName("description").item(0).getTextContent();
                transactions.add(new Transaction(date, amount, description));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

}
