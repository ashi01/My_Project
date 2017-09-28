package ProcessMessages.MainFrame;


import ProcessMessages.TestClasses.ApplicationTestClass;

import java.io.IOException;

public class InitateApp
{

    public static void main(String[] args) throws IndexOutOfBoundsException, IOException {
        ItemManager.getItem().startApp();
        ApplicationTestClass appTest= new ApplicationTestClass();
        appTest.initiate();
        try
        {
            appTest.Test1();
            appTest.Test2();
            appTest.Test3();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
