package ProcessMessages.MainFrame;


public class SalesInformation
{
    public int value;

    public SalesInformation()
    {
    }

    public SalesInformation(int val)
    {
        this.setValue(val);
    }

    public SalesInformation(SalesInformation s)
    {
        this.value = s.getValue();
    }

    private void setValue(int val)
    {
        this.value=val;
    }

    public int getValue()
    {
     return value;
    }

    public void addPrice(int val)
    {
        this.value += val;
    }

    public void subPrice(int val)
    {

        this.value = (this.value - val) < 0 ? 0 : this.value - val;
    }

    public void multiplyPrice(int val)
    {
       this.value *= val;
    }
}
