package ProcessMessages.MessageOperations;


import ProcessMessages.MainFrame.ProductDetails;
import ProcessMessages.MainFrame.SalesInformation;

import java.util.List;
import java.util.Map;

public class MessageTypeTwo implements Message
{
    private final String TypeTwo = "(\\d+)\\sProductSales\\sOf\\s(\\w+)\\sat\\s(\\d+)p\\s$";

    @Override
    public boolean Process(String msg, Map<String, ProductDetails> ListProducts, int msgCount)
    {
        List<String> token = RegExpression.getToken(this.TypeTwo,msg);
        int number = Integer.parseInt(token.get(1));
        String prodName = token.get(2);

        if(!ListProducts.containsKey(prodName))
            ListProducts.put(prodName,new ProductDetails());
        ProductDetails prod = ListProducts.get(prodName);
        int newVal = Integer.parseInt(token.get(3));
        prod.addMoreSalesSales(new SalesInformation(newVal),number);

        String line = "Message: " + msgCount + "Added previous" + number +"sales to : " + prodName + "with value : " + newVal;
        prod.addDetails(line);

        return true;
    }

    @Override
    public boolean validMsg(String msg)
    {
        boolean valid = RegExpression.match(TypeTwo,msg);
        return valid;
    }

}

