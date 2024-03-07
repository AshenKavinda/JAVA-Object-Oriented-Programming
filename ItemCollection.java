import java.util.ArrayList;
import java.util.Scanner;

public class ItemCollection {
    private ArrayList<Item> items ;
    private SupplierCollection supplierCollection ;

    ItemCollection(SupplierCollection supplierCollection)
    {
        items = new ArrayList<Item>() ;
        this.supplierCollection = supplierCollection ;
    }
    //countable stock
    public void addItem(String itemGroupCode,String itemName,int quntity,float buyPrice,float sellPrice,String name, String nic, String phoneNo)
    {
        CountableItem qItem = new CountableItem(itemGroupCode,itemName, quntity, buyPrice, sellPrice);
        supplierCollection.addSuplier(name, nic, phoneNo, itemGroupCode);
        items.add(qItem);

    }
    //uncountable stock
    public void addItem(String itemGroupCode,String itemName,String unit,int stock,float buyPrice,float sellPrice,String name, String nic, String phoneNo)
    {
        UncountableItem oItem = new UncountableItem(itemGroupCode, itemName,unit, stock, buyPrice, sellPrice);
        supplierCollection.addSuplier(name, nic, phoneNo, itemGroupCode);
        items.add(oItem);
    }

    public void getUserInputAddItem(SupplierCollection suplier,int type,Scanner scanner)
    {
        String itemGroupCode,itemName,name,nic,phoneNo,unit=null;
        float buyPrice,sellPrice ;
        int quntity=0,stock=0 ;
        scanner.nextLine();
        System.out.println("Group Code : ");
        itemGroupCode= scanner.nextLine();
        System.out.println("item name : ");
        itemName = scanner.nextLine();
        if (type == 1) {
            System.out.println("quntity");
            quntity = scanner.nextInt();
        }
        else {
            System.out.println("Unit : ");
            unit = scanner.nextLine();
            System.out.println("Stock : ");
            stock = scanner.nextInt();
        }
        System.out.println("buy Price : ");
        buyPrice = scanner.nextFloat();
        System.out.println("Sell Price : ");
        sellPrice = scanner.nextFloat();
        System.out.println("SupplierCollection name : ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.println("SupplierCollection NIC : ");
        nic = scanner.nextLine();
        System.out.println("SupplierCollection Phone No : ");
        phoneNo = scanner.nextLine();

        if (type == 1) {
            addItem(itemGroupCode, itemName, quntity, buyPrice, sellPrice, name, nic, phoneNo);
        }
        else {
            addItem(itemGroupCode, itemName, unit, stock, buyPrice, sellPrice, name, nic, phoneNo);
        }
    }

    public void getUserInputUpdateQuntity(Scanner scanner)
    {
        String itemGroupCode ;
        int addQuntity ;
        scanner.nextLine();
        System.out.println("Item Code : ");
        itemGroupCode = scanner.nextLine();
        System.out.println("Quntity : ");
        addQuntity = scanner.nextInt();
        updateQuntity(itemGroupCode, addQuntity);
    }

    private Item searchItem(String itemGroupCode) {
        Item temItem = null ;
        for (Item item : items) {
            if (item.getItemGroupCode().equals(itemGroupCode)) {
                temItem = item ;
            }
        }
        return temItem ;
    }

    public void updateQuntity(String itemGroupCode,int addQuntity)
    {
        Item item = searchItem(itemGroupCode);
        float bQuntity = item.getQuntity() ;
        float nQuntity = bQuntity + addQuntity ;
        item.setQuntity(nQuntity);    
    }

    public float getItemPriceById(String itemGroupCode)
    {
        float sellPrice = -1 ;
        Item item = searchItem(itemGroupCode);
        sellPrice = item.getSellPrice();
        return sellPrice ;
    }

    public String getItemNameById(String itemGroupCode)
    {
        String name = null ;
        Item item = searchItem(itemGroupCode);
        name = item.getItemName();
        return name ;
    }

    public void reductItems(String itemGroupCode,int quntity)
    {
        Item item = searchItem(itemGroupCode);
        float bQuntity = item.getQuntity() ;
        float nQuntity = bQuntity - quntity ;
        item.setQuntity(nQuntity);
    }

    public String getItemUnit(String itemGroupCode)
    {
        Item item = searchItem(itemGroupCode); 
        String unit = item.getUnit();
        return unit ;
    }
}

