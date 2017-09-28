package ProcessMessages.MessageOperations;


import ProcessMessages.MainFrame.ProductDetails;
import ProcessMessages.Reports.ReportGenerator;
import ProcessMessages.TestClasses.ApplicationTestClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SalesMessageProcessor
{
    public ReadMessage readMsg;
    public WriteMessage writeMsg;
    public ReportGenerator reportGenerator;
    public List<Message> list;
    private Map<String, ProductDetails> listProducts;
    public ApplicationTestClass appTest;


    public SalesMessageProcessor(ReadMessage readMessage, WriteMessage writeMessage, ReportGenerator repGen)
    {
       list = new ArrayList<Message>();
        Message msg1 = new MessageTypeOne();
        Message msg2 = new MessageTypeTwo();
        Message msg3 = new MessageTypeThree();

        list.add(msg1);
        list.add(msg2);
        list.add(msg3);

        this.readMsg = readMessage;
        this.writeMsg = writeMessage;
        this.reportGenerator = repGen;
        listProducts = new LinkedHashMap<String, ProductDetails>();
        this.reportGenerator.setProducts(listProducts);
    }

    public void processSalesMessages() throws IOException
    {
       int msgCount = 0;
       while(msgCount < Adjustment.MaxNumber && readMsg.hasNext())
       {
           String line = readMsg.getNextLine();
           msgCount++;
           boolean msgValid = false;
           for (Message message : list)
           {
               if (message.validMsg(line))
                   if (message.Process(line,listProducts, msgCount))
                   {
                       reportGenerator = getReports();
                       setReports(reportGenerator);
                       msgValid = true;
                       break;
                   }
           }
            if(!msgValid)
                     throw new IllegalArgumentException("Invalid message ");

           reportGenerator.processReports(msgCount);

       }


           if (msgCount == Adjustment.MaxNumber)
           {
               this.writeMsg.printMessage(Adjustment.Pause_Message);
               reportGenerator.processLastReport(Adjustment.MaxNumber);
           }
       }


    public ReportGenerator getReports()
    {
        return reportGenerator;
    }

    public void setReports(ReportGenerator rep)
    {
       reportGenerator = rep;
    }

    public ReadMessage getReadMsg()
    {
        return readMsg;
    }
    public void setReadMsg(ReadMessage readMsg)
    {
        this.readMsg = readMsg;
    }

    public WriteMessage getWriteMsg()
    {
        return writeMsg;
    }

    public void setWriteMsg(WriteMessage writeMsg)
    {
        this.writeMsg = writeMsg;
    }

}
