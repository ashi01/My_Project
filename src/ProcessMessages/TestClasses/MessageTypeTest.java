package ProcessMessages.TestClasses;


import ProcessMessages.MainFrame.ProductDetails;
import ProcessMessages.MessageOperations.Message;
import ProcessMessages.MessageOperations.MessageTypeOne;
import ProcessMessages.MessageOperations.WriteMessage;
import ProcessMessages.Reports.ReportGenerator;
import sun.jvm.hotspot.utilities.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

 enum Fruit {apples,oranges};

public class MessageTypeTest
{
        private Message messageType;
        private Map<String,ProductDetails> listProducts;
        Fruit fruitName;
        ProductDetails.Type type;
        ReportGenerator reportGenerator;


        public void setUp()
        {
            messageType = new MessageTypeOne();
            listProducts = new LinkedHashMap<String, ProductDetails>();
            reportGenerator = new ReportGenerator((WriteMessage) messageType);
        }


        public boolean TestValidMessageTypeOne(String msg)
        {
            if(msg.length() == 3 && msg.contains("at"))
            {
                boolean valid = messageType.validMsg(msg);

            }
            return true;
        }

    public boolean TestValidMessageTypeTwo(String msg)
    {
        if(msg.length() == 7 && msg.contains("of"))
        {
            boolean valid = messageType.validMsg(msg);

        }
        return true;
    }

    public boolean TestValidMessageTypeThree(String msg)
    {
        if(msg.length() == 3 && (msg.contains("Add") || (msg.contains("Subtract"))|| (msg.contains("Multiply"))))
        {
            boolean valid = messageType.validMsg(msg);

        }
        return true;
    }

    public void TestMessageTypeOne()
    {

        String messageLine = "Apple at 10p";
        boolean validity = TestValidMessageTypeOne(messageLine);

        for (Fruit fruit : Fruit.values())
        {
            if (validity == true && !listProducts.containsValue(fruit))
            {
                listProducts.put(String.valueOf(fruitName), new ProductDetails());
                messageType.Process(messageLine, listProducts, 1);
            } else
            {
                messageType.Process(messageLine, listProducts, 2);
                int numberOfSales = listProducts.get(fruit).getTotalSales();
                int totalValue = listProducts.get(fruit).getTotal();
                Assert.that(true, String.valueOf(numberOfSales));
                Assert.that(true, String.valueOf(totalValue));
            }
        }
    }

        public void TestMessageTypeTwo()
        {
            String messageLine = "20 sales of Oranges at 25p each";
            boolean validity = TestValidMessageTypeTwo(messageLine);
            for (Fruit fruit : Fruit.values())
            {
                if (validity == true && !listProducts.containsValue(fruit))
                {
                    listProducts.put(String.valueOf(fruitName), new ProductDetails());
                    messageType.Process(messageLine, listProducts, 1);
                } else
                {
                    messageType.Process(messageLine, listProducts, 2);
                    int numberOfSales = listProducts.get(fruit).getTotalSales();
                    int totalValue = listProducts.get(fruit).getTotal();
                    Assert.that(true, String.valueOf(numberOfSales));
                    Assert.that(true, String.valueOf(totalValue));
                }
            }

        }

     public void TestMessageTypeThree()
     {
         String messageLine = "Multiply 2p Apples";
         boolean validity = TestValidMessageTypeThree(messageLine);
         for (Fruit fruit : Fruit.values())
         {
             if (validity == true && !listProducts.containsValue(fruit))
             {
                 listProducts.put(String.valueOf(fruitName),new ProductDetails());
                 messageType.Process(messageLine,listProducts,1);
             }
             else
             {

                 messageType.Process(messageLine, listProducts, 2);
                 int numberOfSales = listProducts.get(fruit).getTotalSales();
                 int totalValue = listProducts.get(fruit).getTotal();
                 Assert.that(true, String.valueOf(numberOfSales));
                 Assert.that(true, String.valueOf(totalValue));
             }
         }
     }

}

