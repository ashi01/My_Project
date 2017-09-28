package ProcessMessages.MessageOperations;


import ProcessMessages.MainFrame.ProductDetails;

import java.util.Map;

public interface Message
{
   public boolean Process(String msg, Map<String,ProductDetails> ListProducts, int msgCount);
   public boolean validMsg(String msg);
}
