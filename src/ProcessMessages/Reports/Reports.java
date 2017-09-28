package ProcessMessages.Reports;

import ProcessMessages.MainFrame.ProductDetails;
import ProcessMessages.MessageOperations.WriteMessage;

import java.util.Map;

public interface Reports
{
    public void setOutput(WriteMessage msgWrite);
    public void Process(Map<String, ProductDetails> listProducts, int msgCount);
}
