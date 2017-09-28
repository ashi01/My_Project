package ProcessMessages.Reports;


import ProcessMessages.MainFrame.ProductDetails;
import ProcessMessages.MessageOperations.Adjustment;
import ProcessMessages.MessageOperations.WriteMessage;

import java.util.Map;

public class ReportGenerator
{

    private InitialReport initReport;
    private FinalReports finalReports;
    public WriteMessage msgWrite;
    public Map<String, ProductDetails> listProducts;

    public ReportGenerator(WriteMessage writeMessage)
    {
        msgWrite = writeMessage;
        initReport = new InitialReport();
        initReport.setOutput(msgWrite);
        finalReports = new FinalReports();
        finalReports.setOutput(msgWrite);
    }

    public void setProducts(Map<String, ProductDetails> listProducts)
    {
        this.listProducts = listProducts;
    }

    public void processLastReport(int maxNumber)
    {
        finalReports.Process(listProducts,maxNumber);
    }

    public void processReports(int msgCount)
    {
        if(msgCount % Adjustment.count == 0)
            initReport.Process(listProducts,msgCount);

    }


}
