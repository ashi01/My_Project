package ProcessMessages.TestClasses;

import ProcessMessages.MessageOperations.ReadMessage;

import java.util.List;


public class TestRead extends ReadMessage
{
    private List<String> msgLine;
    private int count =0;

    public TestRead(List<String> input)
    {
       this.msgLine = input;
    }

    public String getNextMessage()
    {
        return msgLine.get(count++);
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count=count;
    }

}
