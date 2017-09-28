package ProcessMessages.MessageOperations;


import ProcessMessages.MainFrame.ProductDetails;
import ProcessMessages.MainFrame.SalesInformation;

import java.util.List;
import java.util.Map;

public class MessageTypeOne implements Message
{
    private final String TypeOne = "(\\w+)\\sat\\s(\\d+)p$";

    @Override
    public boolean Process(String msg, Map<String,ProductDetails> ListProducts, int msgCount)
    {

            List<String> token = RegExpression.getToken(TypeOne, msg);
            String prodName = token.get(1);

            if (!ListProducts.containsKey(prodName))
                ListProducts.put(prodName, new ProductDetails());
            ProductDetails prod = ListProducts.get(prodName);

            int newVal = Integer.parseInt(token.get(2));
            prod.addSingleSale(new SalesInformation(newVal));

            String line = "Message:" + msgCount + "Added single sale to: " + prodName + "with value: " + newVal;
            prod.addDetails(line);


        return true;
    }

    @Override
    public boolean validMsg(String msg)
    {
        boolean valid = RegExpression.match(TypeOne,msg);
        return valid;
    }
}
