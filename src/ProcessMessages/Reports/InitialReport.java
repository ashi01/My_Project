package ProcessMessages.Reports;

import ProcessMessages.MainFrame.ProductDetails;
import ProcessMessages.MessageOperations.WriteMessage;

import java.util.Map;

public class InitialReport implements Reports
{
    public WriteMessage msgWrite;

    @Override
    public void setOutput(WriteMessage msgWrite)
    {
        this.msgWrite = msgWrite;
    }

    @Override
    public void Process(Map<String, ProductDetails> listProducts, int msgCount)
    {
        String id = " After Sales of : " +msgCount;
        msgWrite.printMessage(id);

        for(Map.Entry<String,ProductDetails> prod :listProducts.entrySet())
        {
            String print = "The Product : " +prod.getKey() + "Product Price is: " +prod.getValue().getTotal() +
                    " Sales : " + prod.getValue().getTotalSales();

            msgWrite.printMessage(print);

        }

    }
}
