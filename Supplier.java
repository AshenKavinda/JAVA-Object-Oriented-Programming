import java.util.ArrayList;

public class Supplier {
    public int sId  ;
    public String name,nic,phoneNo ;
    public ArrayList<String> itemList = new ArrayList<String>() ;

    Supplier(int sId,String name, String nic, String phoneNo,String itemGroupCode)
    {
        this.sId = sId ;
        this.name = name ;
        this.nic = nic ;
        this.phoneNo = phoneNo ;
        itemList.add(itemGroupCode);
    }
    public void addItemToSuplier(String itemGroupCode)
    {
        itemList.add(itemGroupCode) ;
    }
}
