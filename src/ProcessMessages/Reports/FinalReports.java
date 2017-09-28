package ProcessMessages.Reports;


import ProcessMessages.MainFrame.ProductDetails;
import ProcessMessages.MessageOperations.WriteMessage;

import java.util.Map;

public class FinalReports implements Reports
{
    public WriteMessage msgWrite;

    @Override
    public void setOutput(WriteMessage msgWrite)
    {
        this.msgWrite =msgWrite;
    }

    @Override
    public void Process(Map<String, ProductDetails> listProducts, int msgCount)
    {
       String printFinal = "Final Log Report Generated : " + msgCount;
        msgWrite.printMessage(printFinal);

        for(Map.Entry<String,ProductDetails> prod : listProducts.entrySet())
        {
           String prodDetails = " Details of products: " + prod.getKey();
            msgWrite.printMessage(prodDetails);
            for(String products : prod.getValue().getDetails())
                msgWrite.printMessage(products);
            prodDetails = "Total Quantity of product: " + prod.getKey() +" Price: " + prod.getValue().getTotal() +"Sales: "
                            + prod.getValue().getTotalSales();
            msgWrite.printMessage(prodDetails);
        }

    }
}
