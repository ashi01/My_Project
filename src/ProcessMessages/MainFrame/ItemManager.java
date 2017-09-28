package ProcessMessages.MainFrame;

import ProcessMessages.MessageOperations.ReadMessage;
import ProcessMessages.MessageOperations.SalesMessageProcessor;
import ProcessMessages.MessageOperations.WriteMessage;
import ProcessMessages.Reports.ReportGenerator;

import java.io.IOException;

public class ItemManager
{
   public SalesMessageProcessor msgProcess;
   public ReportGenerator repGen;
   public ReadMessage readMessage;
   public WriteMessage writeMessage;
   private static ItemManager item;

    public ItemManager()
    {
        readMessage = new ReadMessage();
        writeMessage = new WriteMessage();
        repGen = new ReportGenerator(writeMessage);
        msgProcess = new SalesMessageProcessor(readMessage,writeMessage,repGen);
    }

    public static ItemManager getItem()
    {
        if(item == null)
        {
            item = new ItemManager();
        }
        return item;
    }

    public void startApp()
    {
        try
        {
            msgProcess.processSalesMessages();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

 }


