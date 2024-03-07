import java.util.ArrayList;
import java.util.Scanner;

public class SupplierCollection {
    public int indexCount ;
    public ArrayList<Supplier> supliers = new ArrayList<Supplier>();

    SupplierCollection()
    {
        indexCount = 0 ;
    }
    SupplierCollection(int indexStartNumber)
    {
        indexCount = indexStartNumber ;
    }

    public void addSuplier(String name, String nic, String phoneNo,String itemGroupCode)
    {
        //existing supplier
        boolean status = false ;
        for (Supplier suplierDetails : supliers) {
            if (suplierDetails.nic.equals(nic)) {
                suplierDetails.addItemToSuplier(itemGroupCode);
                status= true ;
            }
        }
        //new supplier 
        if (status==false) {
            Supplier suplier = new Supplier(indexCount, name, nic, phoneNo, itemGroupCode);
            supliers.add(suplier);
            indexCount++;
        }    
    }

    public void getUserInputAddSuplier(Scanner scanner)
    {
        String name,nic,phoneNo,itemGroupCode ;
        scanner.nextLine();
        System.out.println("Name : ");
        name = scanner.nextLine();
        System.out.println("NIC");
        nic = scanner.nextLine();
        System.out.println("Phone No : ");
        phoneNo = scanner.nextLine();
        System.out.println("Item code : ");
        itemGroupCode = scanner.nextLine();

        addSuplier(name, nic, phoneNo, itemGroupCode);

    }

    public void addMoreItemToSuplier(int sId,String itemGroupCode)
    {
        for (Supplier suplierDetails : supliers) {
            if (suplierDetails.sId==sId) {
                suplierDetails.addItemToSuplier(itemGroupCode);
            }
        }
    }

    public void getUserInputaddMoreItemToSuplier(Scanner scanner)
    {
        int sId ;
        String itemGroupCode ;
        scanner.nextLine();
        System.out.println("Suplier ID : ");
        sId=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Item Code : ");
        itemGroupCode = scanner.nextLine();

        addMoreItemToSuplier(sId, itemGroupCode);
    }

    public void addMoreItemToSuplier(String nic,String itemGroupCode)
    {
        for (Supplier suplierDetails : supliers) {
            if (suplierDetails.nic.equals(nic)) {
                suplierDetails.addItemToSuplier(itemGroupCode);
            }
        }
    }

    public void printSuplierListByItemGroupId(String itemGroupCode)
    {
        ArrayList<Supplier> list = new ArrayList<Supplier>() ;
        for (Supplier suplierDetails : supliers) {
            for (String item : suplierDetails.itemList) {
                if (item.equals(itemGroupCode)) {
                    list.add(suplierDetails);
                }
            }
        }
        
        for (Supplier suplierDetails : list) {

            System.out.println("Suplier ID    :"+ suplierDetails.sId);
            System.out.println("Suplier Name  :"+ suplierDetails.name);
            System.out.println("Suplier NIC   :"+ suplierDetails.nic);
            System.out.println("Suplier Phone :"+ suplierDetails.phoneNo);
        }  
       
    }

    
}
