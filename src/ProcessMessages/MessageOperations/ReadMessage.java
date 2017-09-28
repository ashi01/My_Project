package ProcessMessages.MessageOperations;


import java.util.Scanner;

public class ReadMessage
{
    public Scanner scan;

    public ReadMessage()
    {
        scan = new Scanner(System.in);
    }
    public String getNextLine()
    {
        return scan.nextLine();
    }

    public boolean hasNext()
    {
        return scan.hasNext();
    }

    public void endIt()
    {
        scan.close();
    }
}
