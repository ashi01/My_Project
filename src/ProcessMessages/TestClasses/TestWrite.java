package ProcessMessages.TestClasses;

import ProcessMessages.MessageOperations.WriteMessage;

import java.util.ArrayList;
import java.util.List;

public class TestWrite extends ProcessMessages.MessageOperations.WriteMessage
{
    private List<String> lines;
    public WriteMessage msg;

     public TestWrite()
     {
         this.lines = new ArrayList<String>();
     }


    public List<String> getLines()
    {
      return lines;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }

    public void writeMessage(String msg)
    {
        lines.add(msg);
    }
}
