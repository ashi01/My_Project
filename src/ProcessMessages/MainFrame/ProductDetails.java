package ProcessMessages.MainFrame;


import java.util.ArrayList;
import java.util.List;

public class ProductDetails
{
    private List<SalesInformation> salesInfo;
    private List<String> prodDetail;

    public void addMoreSalesSales(SalesInformation salesInformation, int number)
    {
        for(int i=0; i< number;i++)
        {
            salesInfo.add(new SalesInformation(salesInformation));
        }
    }

    public enum Type { Add,Subtract,Multiply};

    public ProductDetails()
    {
        this.salesInfo = new ArrayList<SalesInformation>();
        this.setDetails(new ArrayList<String>());
    }


    private void setDetails(ArrayList<String> prodDetail)
    {
        this.prodDetail = prodDetail;
    }

    public int getTotal()
    {
      int total = 0;
      for(SalesInformation sales: salesInfo)
       total += sales.getValue();
       return total;
    }

    public int getTotalSales()
    {
        return salesInfo.size();
    }

    public List<String> getDetails()
    {
        return prodDetail;
    }

    public void addDetails(String details)
    {
        this.prodDetail.add(details);
    }


    public void updateAll(Type type, int val)
    {
        switch (type)
        {
            case Add:
                for(int i=0; i<= salesInfo.size(); i++)
                    salesInfo.get(i).addPrice(val);
                break;
            case Subtract:
                for(int i=0; i<= salesInfo.size();i++)
                    salesInfo.get(i).subPrice(val);
                break;
            case Multiply:
                for (int i=0;i<= salesInfo.size();i++)
                    salesInfo.get(i).multiplyPrice(val);
                break;
            default:
                break;

        }
    }
    public void addSingleSale(SalesInformation sale)
    {
        salesInfo.add(sale);
    }
    public void addSales(List<SalesInformation> sales)
    {
        this.salesInfo.addAll(sales);
    }


}
