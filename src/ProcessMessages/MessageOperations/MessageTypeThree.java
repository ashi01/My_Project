package ProcessMessages.MessageOperations;


import ProcessMessages.MainFrame.ProductDetails;

import java.util.List;
import java.util.Map;

public class MessageTypeThree implements Message
{
    private String Type3 = "(Add|Subtract|Multiply)\\s(\\d+)p?\\s(\\w+)s$";

    @Override
    public boolean Process(String msg, Map<String, ProductDetails> ListProducts, int msgCount)
    {
        List<String> token = RegExpression.getToken(Type3, msg);
        ProductDetails.Type type = ProductDetails.Type.valueOf(token.get(1));
        String name = token.get(3);

        if (!ListProducts.containsKey(name))
            ListProducts.put(name, new ProductDetails());

        ProductDetails prod = ListProducts.get(name);
        int val = Integer.parseInt(token.get(2));
        prod.updateAll(type, val);

        String printMessage = "Message: " + msgCount + " " + type.toString() + "to " + name + "with a value of: " + prod.getTotalSales();
        prod.addDetails(printMessage);

        return true;
    }

    @Override
    public boolean validMsg(String msg)
    {
        boolean validMsg = RegExpression.match(Type3,msg);
        return validMsg;
    }
}
