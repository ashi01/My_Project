package ProcessMessages.TestClasses;


import ProcessMessages.MessageOperations.ReadMessage;
import ProcessMessages.MessageOperations.SalesMessageProcessor;
import ProcessMessages.MessageOperations.WriteMessage;
import ProcessMessages.Reports.ReportGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationTestClass
{
    public SalesMessageProcessor salesMsg;
    public ReportGenerator repGen;
    public ReadMessage readMsg;
    public WriteMessage writeMsg;
    public List<String> input;
    public List<String> output;
    public MessageTypeTest msgTest;

    private static final String folder = "/Users/User/Assessment/My_Project/src/ProcessMessages/TestClasses";



  public static void readFileData(String fileName, List<String> input) throws IOException
  {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line;

      while((line = br.readLine()) != null)
         input.add(line);

      br.close();
  }

    public void initiate()
    {
        input = new ArrayList<String>();
        output = new ArrayList<String>();
        readMsg = new TestRead(input);
        writeMsg = new TestWrite();
        repGen = new ReportGenerator(writeMsg);
        salesMsg = new SalesMessageProcessor(readMsg,writeMsg,repGen);
        msgTest = new MessageTypeTest();
    }

    public void Test1() throws IOException
    {

        input.clear();
        readFileData(folder +"DataInputFile.txt", input);
        output.clear();
        readFileData(folder+"OutputData.txt",output);
        salesMsg.processSalesMessages();
        msgTest.TestMessageTypeOne();


    }

    public void Test2() throws IOException
    {
        input.clear();
        input.add("Apple for 10p");
        input.add("10 sales of apple for 20p each");
        input.add("Multiply 20p apple");
        input.add("Orange at 30p");
        input.add("20 sales of oranges at 30p each");
        input.add("Multiply 20p apple");
        input.add("Subtract 10p Oranges");
        input.add("Apples at 20p");
        input.add("Subtract apple at 30p");
        input.add("Multiply 30p oranges");
        output.clear();
        output.add("Sales Data After 10 more Messages: ");
        output.add("Product: Apple Price: 2034 Sales: 20");
        output.add("Product: Orange Price:2065 Sales:23");
        salesMsg.processSalesMessages();
        msgTest.TestMessageTypeTwo();

    }

    public void Test3() throws IOException
    {
        input.clear();
        readFileData(folder + "DataInputFile.txt",input);
        output.clear();
        readFileData(folder + "OutputData.txt",output);
        salesMsg.processSalesMessages();
        msgTest.TestMessageTypeThree();
    }


}
